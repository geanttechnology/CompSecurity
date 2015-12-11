// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class w extends TimerTask
{

    final MagicActivity a;

    private w(MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }

    w(MagicActivity magicactivity, MagicActivity._cls1 _pcls1)
    {
        this(magicactivity);
    }

    public void run()
    {
        a.e();
    }
}
