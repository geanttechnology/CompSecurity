// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v4.view.ab;
import android.support.v4.view.ai;
import android.support.v4.view.bh;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

class a
    implements ab
{

    final AppCompatDelegateImplV7 a;

    public bh a(View view, bh bh1)
    {
        int i = bh1.b();
        int j = AppCompatDelegateImplV7.c(a, i);
        bh bh2 = bh1;
        if (i != j)
        {
            bh2 = bh1.a(bh1.a(), j, bh1.c(), bh1.d());
        }
        return ai.a(view, bh2);
    }

    (AppCompatDelegateImplV7 appcompatdelegateimplv7)
    {
        a = appcompatdelegateimplv7;
        super();
    }
}
