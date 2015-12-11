// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;

// Referenced classes of package com.medialets.thrift:
//            MMClientRequest, BroadcastData

final class o extends HashMap
{

    o()
    {
        put(Integer.valueOf(1), new FieldMetaData("tok", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("deviceID", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(3), new FieldMetaData("b", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(4), new FieldMetaData("dev", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(5), new FieldMetaData("v", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(6), new FieldMetaData("sysv", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(7), new FieldMetaData("model", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(8), new FieldMetaData("appv", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(9), new FieldMetaData("app", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(10), new FieldMetaData("sys", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(11), new FieldMetaData("broadcastData", (byte)2, new StructMetaData((byte)12, com/medialets/thrift/BroadcastData)));
        put(Integer.valueOf(12), new FieldMetaData("ipAddress", (byte)2, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(13), new FieldMetaData("requestTime", (byte)2, new FieldValueMetaData((byte)11)));
    }
}
