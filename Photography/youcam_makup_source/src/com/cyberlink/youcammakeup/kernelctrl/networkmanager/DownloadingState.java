// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            a

public class DownloadingState
{

    private static String a = "DownloadingState";
    private static final a b = new a(0L, 1L);
    private final State c;
    private final a d;

    DownloadingState(State state)
    {
        this(state, null);
    }

    DownloadingState(State state, a a1)
    {
        c = state;
        d = a1;
    }

    public State a()
    {
        return c;
    }

    public a b()
    {
        if (d == null)
        {
            return b;
        } else
        {
            return d;
        }
    }

}
