// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            af, ao, aj

final class b
    implements Runnable
{

    final ao a;
    final aj b;
    final af c;

    public final void run()
    {
        if (af.a(c).equals("expandWithProperties"))
        {
            a.b = true;
        }
        String s = String.format("javascript:%s(%s);", new Object[] {
            af.b(c), b.a()
        });
        a.loadUrl(s);
    }

    (af af1, ao ao1, aj aj1)
    {
        c = af1;
        a = ao1;
        b = aj1;
        super();
    }
}
