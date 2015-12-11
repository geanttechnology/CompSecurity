// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SoloActivity

class a
    implements Observer
{

    final SoloActivity a;

    public void update(Observable observable, Object obj)
    {
        if (!SoloActivity.a(a))
        {
            SoloActivity.b(a);
            return;
        } else
        {
            SoloActivity.c(a);
            return;
        }
    }

    (SoloActivity soloactivity)
    {
        a = soloactivity;
        super();
    }
}
