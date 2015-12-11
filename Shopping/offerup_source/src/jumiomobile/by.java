// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.view.animation.AlphaAnimation;

// Referenced classes of package jumiomobile:
//            bz, ca

public class by
{

    private static int a = 10;
    private int b;
    private View c;
    private AlphaAnimation d;
    private AlphaAnimation e;

    public by(View view)
    {
        b = 0;
        c = view;
        d = new AlphaAnimation(0.4F, 1.0F);
        e = new AlphaAnimation(1.0F, 0.4F);
        d.setDuration(350L);
        e.setDuration(350L);
        d.setAnimationListener(new bz(this));
        e.setAnimationListener(new ca(this));
    }

    static int a(by by1)
    {
        int i = by1.b;
        by1.b = i + 1;
        return i;
    }

    static int b(by by1)
    {
        return by1.b;
    }

    static int c()
    {
        return a;
    }

    static AlphaAnimation c(by by1)
    {
        return by1.e;
    }

    static View d(by by1)
    {
        return by1.c;
    }

    static AlphaAnimation e(by by1)
    {
        return by1.d;
    }

    public void a()
    {
        b = a;
    }

    public void b()
    {
        b = 0;
        c.startAnimation(d);
    }

}
