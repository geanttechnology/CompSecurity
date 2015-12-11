// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v4.view.ba;
import android.support.v4.view.bi;
import android.support.v4.view.dn;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplV7

class this._cls0
    implements ba
{

    final AppCompatDelegateImplV7 this$0;

    public dn onApplyWindowInsets(View view, dn dn1)
    {
        int i = dn1.b();
        int j = AppCompatDelegateImplV7.access$300(AppCompatDelegateImplV7.this, i);
        dn dn2 = dn1;
        if (i != j)
        {
            dn2 = dn1.a(dn1.a(), j, dn1.c(), dn1.d());
        }
        return bi.a(view, dn2);
    }

    ()
    {
        this$0 = AppCompatDelegateImplV7.this;
        super();
    }
}
