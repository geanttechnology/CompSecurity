// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.f;

// Referenced classes of package android.support.v7.internal.a:
//            b

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final b a;

    public void a(f f, boolean flag)
    {
        if (b.a(a) != null)
        {
            b.a(a).onPanelClosed(0, f);
        }
    }

    public boolean a_(f f)
    {
        if (f == null && b.a(a) != null)
        {
            b.a(a).onMenuOpened(0, f);
        }
        return true;
    }

    private enu.f(b b1)
    {
        a = b1;
        super();
    }

    a(b b1, a a1)
    {
        this(b1);
    }
}
