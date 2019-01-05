package com.university.shenyang.air.testing.collector.procotol.device.receiver;

import com.university.shenyang.air.testing.collector.cache.DevicesManager;
import com.university.shenyang.air.testing.collector.common.kit.Packet;
import com.university.shenyang.air.testing.collector.procotol.Protocols;
import com.university.shenyang.air.testing.collector.procotol.device.DeviceCommand;
import com.university.shenyang.air.testing.collector.util.Constants;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/**
 * 终端校时
 * Created by chenjc on 2017/05/03.
 */
@Protocols(id = "08", type = Constants.PROTOCOL_GB)
@ChannelHandler.Sharable
public class GB_08_Timing extends DeviceCommand {

    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(GB_08_Timing.class);

    @Override
    public void processor(ChannelHandlerContext ctx, Packet packet) {
        try {
            // 获取登入链路上下文
            ChannelHandlerContext loginCtx = DevicesManager.getInstance().getCtxByDeviceCode(packet.getUniqueMark());

            // 判断设备是否合法并登入
            if (loginCtx == ctx) {
                // 设备消息通用应答
                packet = super.terminalMessageCommonAnswer(packet);
                // 发送应答
                ctx.writeAndFlush(packet);
            } else {
                LOGGER.info("该设备信息不存在或未进行登入，设备标识码为：{}" + packet.getUniqueMark());
                ctx.close();
            }
        } catch (Exception ex) {
            LOGGER.error("解析设备校时信息出错:" + ex);
        }
    }
}