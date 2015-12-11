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
//            MMAdDownload, MMAdUpdate, MMAdControl

final class n extends HashMap
{

    n()
    {
        put(Integer.valueOf(1), new FieldMetaData("adID", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(2), new FieldMetaData("adVersion", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(3), new FieldMetaData("bundleURL", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(4), new FieldMetaData("updates", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdUpdate))));
        put(Integer.valueOf(5), new FieldMetaData("adControlPlist", (byte)3, new FieldValueMetaData((byte)11)));
        put(Integer.valueOf(6), new FieldMetaData("adControl", (byte)2, new StructMetaData((byte)12, com/medialets/thrift/MMAdControl)));
    }
}
