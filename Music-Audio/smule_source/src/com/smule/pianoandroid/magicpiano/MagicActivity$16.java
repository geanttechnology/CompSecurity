// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.ProgressBar;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final int a;
    final MagicActivity b;

    public void run()
    {
        MagicActivity.f(b).setProgress(a);
    }

    (MagicActivity magicactivity, int i)
    {
        b = magicactivity;
        a = i;
        super();
    }
}
