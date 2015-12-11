// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.c.aa;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            a

class a
    implements Observer
{

    final a a;

    public void update(Observable observable, Object obj)
    {
        aa.a(a.a, "Got level up notification!");
        com.smule.pianoandroid.magicpiano.a.a.d(a);
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
