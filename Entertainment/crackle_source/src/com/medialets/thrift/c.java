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
//            MMV1Request, Event

final class c extends HashMap
{

    c()
    {
        put(Integer.valueOf(1), new FieldMetaData("requestTime", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("deviceID", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(3), new FieldMetaData("deviceModel", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(4), new FieldMetaData("deviceSystemName", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(5), new FieldMetaData("deviceSystemVersion", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(6), new FieldMetaData("appID", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(7), new FieldMetaData("appVersion", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(8), new FieldMetaData("events", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/Event))));
        put(Integer.valueOf(9), new FieldMetaData("ipAddress", (byte)2, new FieldValueMetaData((byte)11)));
    }
}
