// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import com.smule.android.console.n;
import com.smule.android.network.managers.ak;

public class j
    implements n
{

    public j()
    {
    }

    public String a()
    {
        return "snapshot";
    }

    public String a(String as[])
    {
        if (as != null && as.length > 2 && as[1].compareToIgnoreCase("throttle") == 0)
        {
            if (as[2].compareToIgnoreCase("on") == 0)
            {
                ak.a().a = 0x36ee80L;
                return "snapshot throttling is on!  stay always in the light!";
            }
            if (as[2].compareToIgnoreCase("off") == 0)
            {
                ak.a().a = 0L;
                return "snapshot throttling is off!  good luck out there!";
            }
        }
        return "Error.  Please enter 'snapshot throttle on' or 'snapshot throttle off'";
    }
}
