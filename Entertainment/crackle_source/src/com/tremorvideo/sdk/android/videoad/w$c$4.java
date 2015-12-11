// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            w, ad

class a extends TimerTask
{

    final cancel a;

    public void run()
    {
        long l = GregorianCalendar.getInstance().getTimeInMillis();
        long l1 = a.a;
        a.a = l;
        a.a = Math.max(0.0F, a.a - ((float)(l - l1) / 1000F) * 1.5F);
        try
        {
            a.stInvalidate();
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        if (a.a == 0.0F)
        {
            cancel();
        }
    }

    ( )
    {
        a = ;
        super();
    }
}
