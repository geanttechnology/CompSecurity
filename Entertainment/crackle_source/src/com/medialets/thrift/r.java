// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;

// Referenced classes of package com.medialets.thrift:
//            MMSlotZeroResponse, MMAdDownload

final class r extends HashMap
{

    r()
    {
        put(Integer.valueOf(1), new FieldMetaData("adDownloads", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdDownload))));
    }
}
