/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.broker.amqp.codec.frames;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.broker.common.data.types.ShortString;

public class BasicCancelTest {

    @Test
    public void testEncodeDecode() throws Exception {
        BasicCancel testFrame = new BasicCancel(1,
                                                ShortString.parseString("1"),
                                                true);
        ByteBuf buf = Unpooled.buffer((int) testFrame.getMethodBodySize());
        testFrame.writeMethod(buf);
        BasicCancel decodedFrame = (BasicCancel) BasicCancel.getFactory()
                                                            .newInstance(buf, 1, testFrame.getMethodBodySize());

        Assert.assertEquals(decodedFrame.getChannel(), testFrame.getChannel(), "Decoded frame's channel should match"
                + " the original frame's channel");
        Assert.assertEquals(decodedFrame.getConsumerTag(), testFrame.getConsumerTag(), "Decoded frame's consumer-tag "
                + "should match the original frame's consumer-tag");
        Assert.assertEquals(decodedFrame.isNoWait(), testFrame.isNoWait(), "Decoded frame's no-wait bit "
                + "should match the original frame's no-wait bit");

    }

    @Test
    public void testEncodeDecodeWithFalseFlags() throws Exception {
        BasicCancel testFrame = new BasicCancel(1,
                                                ShortString.parseString("1"),
                                                false);
        ByteBuf buf = Unpooled.buffer((int) testFrame.getMethodBodySize());
        testFrame.writeMethod(buf);
        BasicCancel decodedFrame = (BasicCancel) BasicCancel.getFactory()
                                                            .newInstance(buf, 1, testFrame.getMethodBodySize());

        Assert.assertEquals(decodedFrame.getChannel(), testFrame.getChannel(), "Decoded frame's channel should match"
                + " the original frame's channel");
        Assert.assertEquals(decodedFrame.getConsumerTag(), testFrame.getConsumerTag(), "Decoded frame's consumer-tag "
                + "should match the original frame's consumer-tag");
        Assert.assertEquals(decodedFrame.isNoWait(), testFrame.isNoWait(), "Decoded frame's no-wait bit "
                + "should match the original frame's no-wait bit");

    }
}
