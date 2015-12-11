// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioManager;

final class vt
    implements Runnable
{

    private vs a;

    vt(vs vs1)
    {
        a = vs1;
        super();
    }

    public final void run()
    {
        a.a.abandonAudioFocus(null);
    }
}
