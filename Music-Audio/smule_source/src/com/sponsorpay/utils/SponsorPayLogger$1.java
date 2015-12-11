// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.sponsorpay.utils:
//            SponsorPayLogger, SPLoggerListener

class val.exception
    implements Runnable
{

    final SponsorPayLogger this$0;
    private final Exception val$exception;
    private final vel val$level;
    private final String val$message;
    private final String val$tag;

    public void run()
    {
        Iterator iterator = SponsorPayLogger.access$0(SponsorPayLogger.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((SPLoggerListener)iterator.next()).log(val$level, val$tag, val$message, val$exception);
        } while (true);
    }

    vel()
    {
        this$0 = final_sponsorpaylogger;
        val$level = vel;
        val$tag = s;
        val$message = s1;
        val$exception = Exception.this;
        super();
    }
}
