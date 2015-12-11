// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Observer
{

    final MagicActivity a;

    public void update(Observable observable, Object obj)
    {
        if (!MagicActivity.c(a))
        {
            MagicActivity.d(a);
            return;
        } else
        {
            MagicActivity.e(a);
            return;
        }
    }

    (MagicActivity magicactivity)
    {
        a = magicactivity;
        super();
    }
}
