// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.widget.TextView;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final MagicActivity a;

    public void run()
    {
        ((TextView)a.findViewById(0x7f0a0161)).setText(MagicActivity.j(a));
        ((TextView)a.findViewById(0x7f0a0162)).setText(MagicActivity.k(a));
        if (PianoCoreBridge.isJoin())
        {
            a.findViewById(0x7f0a0163).setVisibility(0);
            MagicActivity.l(a);
        }
    }

    (MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
