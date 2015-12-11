// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;

// Referenced classes of package com.medialets.thrift:
//            ECActionResponse, MMAdControl

final class b extends HashMap
{

    b()
    {
        put(Integer.valueOf(1), new FieldMetaData("receivedEvents", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(2), new FieldMetaData("receivedAdEvents", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(3), new FieldMetaData("minBroadcastInterval", (byte)3, new FieldValueMetaData((byte)8)));
        put(Integer.valueOf(4), new FieldMetaData("broadcastURL", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(5), new FieldMetaData("clientToken", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(6), new FieldMetaData("appTok", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(7), new FieldMetaData("devTok", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(8), new FieldMetaData("debugMessage", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(9), new FieldMetaData("userMessage", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(10), new FieldMetaData("userMessageURL", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(11), new FieldMetaData("shutdown", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(12), new FieldMetaData("kill", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(13), new FieldMetaData("dcEnabled", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(14), new FieldMetaData("receivedRuns", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(15), new FieldMetaData("adInstructions", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(16), new FieldMetaData("adControls", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdControl))));
    }
}
