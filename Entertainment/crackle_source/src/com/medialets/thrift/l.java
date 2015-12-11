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
//            Run, AdEvent, Event

final class l extends HashMap
{

    l()
    {
        put(Integer.valueOf(1), new FieldMetaData("id", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("appVersion", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(3), new FieldMetaData("interval", (byte)3, new FieldValueMetaData((byte)10)));
        put(Integer.valueOf(4), new FieldMetaData("start", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(5), new FieldMetaData("dur", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(6), new FieldMetaData("abEnd", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(7), new FieldMetaData("first", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(8), new FieldMetaData("firstHr", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(9), new FieldMetaData("firstDay", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(10), new FieldMetaData("firstMon", (byte)2, new FieldValueMetaData((byte)2)));
        put(Integer.valueOf(11), new FieldMetaData("countHr", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(12), new FieldMetaData("countDay", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(13), new FieldMetaData("countMon", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(14), new FieldMetaData("adEvents", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/AdEvent))));
        put(Integer.valueOf(15), new FieldMetaData("events", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/Event))));
        put(Integer.valueOf(16), new FieldMetaData("systemVersion", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(17), new FieldMetaData("rev", (byte)3, new FieldValueMetaData((byte)11)));
    }
}
