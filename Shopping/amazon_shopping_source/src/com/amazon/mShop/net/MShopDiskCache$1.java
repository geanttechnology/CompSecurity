// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCache, MShopHttpHeaderHelper, MShopDiskCachePolicy

static final class val.contentType
    implements Runnable
{

    final String val$contentType;
    final Map val$header;
    final String val$key;
    final long val$receiveTimeMillis;
    final icy.ResidencePriority val$residencePriority;
    final long val$sendTimeMillis;
    final byte val$value[];

    public void run()
    {
        if (MShopHttpHeaderHelper.writeHeaderInf(val$key, val$header, val$residencePriority, val$sendTimeMillis, val$receiveTimeMillis))
        {
            java.io.File file = MShopDiskCache.writeFileContent(val$key, val$value, val$contentType, val$residencePriority);
            if (file != null)
            {
                MShopDiskCachePolicy.addFileJournal(val$key, file, val$residencePriority);
            }
        }
        System.gc();
    }

    icy.ResidencePriority(String s, Map map, icy.ResidencePriority residencepriority, long l, long l1, 
            byte abyte0[], String s1)
    {
        val$key = s;
        val$header = map;
        val$residencePriority = residencepriority;
        val$sendTimeMillis = l;
        val$receiveTimeMillis = l1;
        val$value = abyte0;
        val$contentType = s1;
        super();
    }
}
