// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements android.view.ener
{

    final MagicActivity a;

    public void onClick(View view)
    {
        if (MagicActivity.a(a) == 1 || MagicActivity.a(a) == 2)
        {
            PianoCoreBridge.setPaused(true);
            a.g();
        }
    }

    (MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
