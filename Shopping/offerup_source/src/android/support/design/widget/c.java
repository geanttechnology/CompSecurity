// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ba;
import android.support.v4.view.dn;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            AppBarLayout

class c
    implements ba
{

    private AppBarLayout a;

    c(AppBarLayout appbarlayout)
    {
        a = appbarlayout;
        super();
    }

    public final dn onApplyWindowInsets(View view, dn dn1)
    {
        AppBarLayout.a(a, dn1);
        return dn1.f();
    }
}
