// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.CountDownTimer;
import android.widget.TextView;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class u extends CountDownTimer
{

    final MagicActivity a;

    public u(MagicActivity magicactivity, long l, long l1)
    {
        a = magicactivity;
        super(l, l1);
    }

    public void onFinish()
    {
        MagicActivity.p(a).setVisibility(4);
    }

    public void onTick(long l)
    {
        if (l > 3000L)
        {
            return;
        } else
        {
            MagicActivity.x(a);
            MagicActivity.p(a).setText(Integer.toString(MagicActivity.o(a)));
            return;
        }
    }
}
