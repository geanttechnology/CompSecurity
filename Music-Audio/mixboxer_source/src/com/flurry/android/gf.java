// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.TimerTask;

// Referenced classes of package com.flurry.android:
//            bv

final class gf extends TimerTask
{

    private bv di;
    private String ge;

    public gf(bv bv1, String s)
    {
        di = bv1;
        super();
        ge = "";
        ge = s;
    }

    public final void run()
    {
        di.k(ge);
    }
}
