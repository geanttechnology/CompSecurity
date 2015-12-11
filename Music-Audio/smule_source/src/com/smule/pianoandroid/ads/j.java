// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.content.Context;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.c.a;

// Referenced classes of package com.smule.pianoandroid.ads:
//            g

public class j extends g
{

    private static final String a = com/smule/pianoandroid/ads/j.getName();
    private static final String b = MagicApplication.getContext().getString(0x7f0c00cf);

    public j()
    {
        b("PIANDROID_AfterSongPlay_FullScreen");
        c(b);
        a("after_song_source");
    }

    protected boolean a()
    {
        return com.smule.pianoandroid.magicpiano.c.a.a().f() % 2 == 1 || com.smule.pianoandroid.magicpiano.c.a.a().f() < 3;
    }

}
