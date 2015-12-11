// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;

// Referenced classes of package com.medialets.thrift:
//            MMAdUpdate

final class m extends HashMap
{

    m()
    {
        put(Integer.valueOf(1), new FieldMetaData("adVersion", (byte)3, new FieldValueMetaData((byte)6)));
        put(Integer.valueOf(2), new FieldMetaData("updateBundleURL", (byte)3, new FieldValueMetaData((byte)11)));
    }
}
