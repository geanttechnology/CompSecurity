// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.internal.view.menu.f;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final AppCompatDelegateImplV7 a;

    public void a(f f1, boolean flag)
    {
label0:
        {
            f f2 = f1.p();
            AppCompatDelegateImplV7 appcompatdelegateimplv7;
            boolean flag1;
            if (f2 != f1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            appcompatdelegateimplv7 = a;
            if (flag1)
            {
                f1 = f2;
            }
            f1 = AppCompatDelegateImplV7.a(appcompatdelegateimplv7, f1);
            if (f1 != null)
            {
                if (!flag1)
                {
                    break label0;
                }
                AppCompatDelegateImplV7.a(a, ((nelFeatureState) (f1)).a, f1, f2);
                AppCompatDelegateImplV7.a(a, f1, true);
            }
            return;
        }
        AppCompatDelegateImplV7.a(a, f1, flag);
    }

    public boolean a_(f f1)
    {
        if (f1 == null && a.e)
        {
            android.view.  = a.m();
            if ( != null && !a.l())
            {
                .ed(8, f1);
            }
        }
        return true;
    }

    private nelFeatureState(AppCompatDelegateImplV7 appcompatdelegateimplv7)
    {
        a = appcompatdelegateimplv7;
        super();
    }

    a(AppCompatDelegateImplV7 appcompatdelegateimplv7, a a1)
    {
        this(appcompatdelegateimplv7);
    }
}
