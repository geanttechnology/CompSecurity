// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.TextView;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final String a;
    final MagicActivity b;

    public void run()
    {
        MagicActivity.y(b).setVisibility(0);
        MagicActivity.y(b).setText(a);
        MagicActivity.a(b, MagicActivity.y(b), 0x7f040018);
    }

    (MagicActivity magicactivity, String s)
    {
        b = magicactivity;
        a = s;
        super();
    }
}
