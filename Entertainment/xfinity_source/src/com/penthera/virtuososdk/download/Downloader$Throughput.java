// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import java.util.Date;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

class interFrom
{

    private double byteCount;
    private long interFrom;
    private long interval;
    final Downloader this$0;

    public double mbs()
    {
        if (interval > 0L)
        {
            return byteCount / 131072D / (double)interval;
        } else
        {
            return 0.0D;
        }
    }

    public void reset()
    {
        interval = 0L;
        byteCount = 0.0D;
    }

    public void signalStart()
    {
        interFrom = (new Date()).getTime() / 1000L;
    }

    public void update(long l)
    {
        long l1 = (new Date()).getTime() / 1000L;
        interval = interval + (l1 - interFrom);
        byteCount = byteCount + (double)l;
        interFrom = l1;
    }

    ()
    {
        this$0 = Downloader.this;
        super();
        byteCount = 0.0D;
        interval = 0L;
        interFrom = 0L;
    }
}
