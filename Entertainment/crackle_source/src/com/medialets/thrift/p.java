// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;

// Referenced classes of package com.medialets.thrift:
//            MMAdEventBreadcrumb

final class p extends HashMap
{

    p()
    {
        put(Integer.valueOf(1), new FieldMetaData("urlID", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(2), new FieldMetaData("duration", (byte)3, new FieldValueMetaData((byte)4)));
        put(Integer.valueOf(3), new FieldMetaData("viewStart", (byte)3, new FieldValueMetaData((byte)11)));
    }
}
