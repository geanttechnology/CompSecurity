// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.internal.view.menu.f;

// Referenced classes of package android.support.v7.app:
//            k

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final k a;

    public void onCloseMenu(f f1, boolean flag)
    {
label0:
        {
            f f2 = f1.p();
            k k1;
            boolean flag1;
            if (f2 != f1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            k1 = a;
            if (flag1)
            {
                f1 = f2;
            }
            f1 = k.a(k1, f1);
            if (f1 != null)
            {
                if (!flag1)
                {
                    break label0;
                }
                k.a(a, ((a) (f1)).a, f1, f2);
                k.a(a, f1, true);
            }
            return;
        }
        k.a(a, f1, flag);
    }

    public boolean onOpenSubMenu(f f1)
    {
        if (f1 == null && a.e)
        {
            android.view.ow.Callback callback = a.m();
            if (callback != null && !a.l())
            {
                callback.onMenuOpened(8, f1);
            }
        }
        return true;
    }

    private .view.menu.f(k k1)
    {
        a = k1;
        super();
    }

    a(k k1, a a1)
    {
        this(k1);
    }
}
