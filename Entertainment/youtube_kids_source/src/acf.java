// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaPlayer;

final class acf
    implements android.media.AudioManager.OnAudioFocusChangeListener
{

    private acd a;

    acf(acd acd1)
    {
        a = acd1;
        super();
    }

    public final void onAudioFocusChange(int i)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   -3: 50
    //                   1: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        float f = a.a();
        a.a.setVolume(f, f);
        return;
_L2:
        if (a.a.isPlaying())
        {
            float f1 = (float)((double)a.a() * 0.10000000000000001D);
            a.a.setVolume(f1, f1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
