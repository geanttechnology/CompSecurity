// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;

// Referenced classes of package com.medialets.thrift:
//            Event, MMStringData, MMNumberData

final class g extends HashMap
{

    g()
    {
        put(Integer.valueOf(1), new FieldMetaData("eventID", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("key", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(3), new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(4), new FieldMetaData("conn", (byte)3, new FieldValueMetaData((byte)8)));
        put(Integer.valueOf(5), new FieldMetaData("countHr", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(6), new FieldMetaData("countDay", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(7), new FieldMetaData("countMon", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(8), new FieldMetaData("lat", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(9), new FieldMetaData("lon", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(10), new FieldMetaData("alt", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(11), new FieldMetaData("uCount", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(12), new FieldMetaData("uDur", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(13), new FieldMetaData("uDict", (byte)3, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
        put(Integer.valueOf(14), new FieldMetaData("horizontalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(15), new FieldMetaData("verticalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(16), new FieldMetaData("stringValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMStringData))));
        put(Integer.valueOf(17), new FieldMetaData("numericValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMNumberData))));
        put(Integer.valueOf(18), new FieldMetaData("durationValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMNumberData))));
        put(Integer.valueOf(19), new FieldMetaData("direction", (byte)2, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(20), new FieldMetaData("directionAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
    }
}
