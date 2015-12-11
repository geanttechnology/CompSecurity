// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;


// Referenced classes of package com.smule.pianoandroid.e:
//            c

class a
    implements Runnable
{

    final Runnable a;
    final c b;

    public void run()
    {
        b.d();
        if (a != null)
        {
            a.run();
        }
    }

    (c c1, Runnable runnable)
    {
        b = c1;
        a = runnable;
        super();
    }
}
