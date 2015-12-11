// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.s;

// Referenced classes of package android.support.v7.app:
//            i, a

private class <init>
    implements <init>
{

    final i a;

    public Drawable a()
    {
        s s1 = s.a(b(), null, new int[] {
            android.support.v7.a.homeAsUpIndicator
        });
        Drawable drawable = s1.a(0);
        s1.b();
        return drawable;
    }

    public void a(int j)
    {
        a a1 = a.a();
        if (a1 != null)
        {
            a1.a(j);
        }
    }

    public void a(Drawable drawable, int j)
    {
        a a1 = a.a();
        if (a1 != null)
        {
            a1.a(drawable);
            a1.a(j);
        }
    }

    public Context b()
    {
        return a.k();
    }

    public boolean c()
    {
        a a1 = a.a();
        return a1 != null && (a1.a() & 4) != 0;
    }

    private rawable(i j)
    {
        a = j;
        super();
    }

    a(i j, a a1)
    {
        this(j);
    }
}
