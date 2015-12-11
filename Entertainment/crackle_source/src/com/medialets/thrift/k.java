// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;

// Referenced classes of package com.medialets.thrift:
//            MMAdFrequencyCap

final class k extends HashMap
{

    k()
    {
        put(Integer.valueOf(1), new FieldMetaData("startTime", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("endTime", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(3), new FieldMetaData("maxImpressions", (byte)3, new FieldValueMetaData((byte)8)));
        put(Integer.valueOf(4), new FieldMetaData("dayModifier", (byte)2, new FieldValueMetaData((byte)8)));
    }
}
