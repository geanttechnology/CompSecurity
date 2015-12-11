// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import com.smule.android.console.n;
import com.smule.android.network.managers.ap;

public class k
    implements n
{

    public k()
    {
    }

    public String a()
    {
        return "subscribe";
    }

    public String a(String as[])
    {
        if (as != null && as.length > 1)
        {
            if (as[1].compareToIgnoreCase("true") == 0)
            {
                ap.a().a(0x61cfede0L);
                return "Congratulations, you are subscribed until the year 2022.";
            }
            if (as[1].compareToIgnoreCase("false") == 0)
            {
                ap.a().a(1L);
                return "You are unsubscribed.  May god have mercy on your soul.";
            }
        }
        return "Syntax Error.  Please enter either 'subscribe true' or 'subscribe false'";
    }
}
