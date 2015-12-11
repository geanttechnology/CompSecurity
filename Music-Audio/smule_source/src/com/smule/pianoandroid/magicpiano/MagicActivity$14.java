// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final MagicActivity a;

    public void run()
    {
        MagicActivity.z(a);
        PianoCoreBridge.startAudioSync(a);
    }

    (MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
