// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc;

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc:
//            LimitedDiscCache

class this._cls0
    implements Runnable
{

    final LimitedDiscCache this$0;

    public void run()
    {
        File afile[];
        int j;
        j = 0;
        afile = cacheDir.listFiles();
        if (afile == null) goto _L2; else goto _L1
_L1:
        int i;
        int k;
        k = afile.length;
        i = 0;
_L6:
        if (i < k) goto _L4; else goto _L3
_L3:
        LimitedDiscCache.access$1(LimitedDiscCache.this).set(j);
_L2:
        return;
_L4:
        File file = afile[i];
        j += getSize(file);
        LimitedDiscCache.access$0(LimitedDiscCache.this).put(file, Long.valueOf(file.lastModified()));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        this$0 = LimitedDiscCache.this;
        super();
    }
}
