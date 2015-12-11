// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.content.Context;
import com.smule.pianoandroid.magicpiano.MagicApplication;

// Referenced classes of package com.smule.pianoandroid.ads:
//            g, j

public class a extends g
{

    private static final String a = com/smule/pianoandroid/ads/j.getName();
    private static final String b = MagicApplication.getContext().getString(0x7f0c00cb);

    public a()
    {
        b("PIANDROID_AtLaunch_FullScreen");
        c(b);
        a("at_launch_source");
    }

    protected boolean a()
    {
        return com.smule.pianoandroid.magicpiano.c.a.a().f() < 3;
    }

}
