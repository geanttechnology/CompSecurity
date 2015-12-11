// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.res.ColorStateList;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            br, do, bu, dn, 
//            ba

final class bs extends br
{

    bs()
    {
    }

    public final boolean A(View view)
    {
        return view.isNestedScrollingEnabled();
    }

    public final void B(View view)
    {
        view.stopNestedScroll();
    }

    public final float D(View view)
    {
        return view.getZ();
    }

    public final dn a(View view, dn dn)
    {
        Object obj = dn;
        if (dn instanceof do)
        {
            android.view.WindowInsets windowinsets = ((do)dn).g();
            view = view.onApplyWindowInsets(windowinsets);
            obj = dn;
            if (view != windowinsets)
            {
                obj = new do(view);
            }
        }
        return ((dn) (obj));
    }

    public final void a(View view, ColorStateList colorstatelist)
    {
        view.setBackgroundTintList(colorstatelist);
    }

    public final void a(View view, android.graphics.PorterDuff.Mode mode)
    {
        view.setBackgroundTintMode(mode);
    }

    public final void a(View view, ba ba)
    {
        view.setOnApplyWindowInsetsListener(new bu(ba));
    }

    public final dn b(View view, dn dn)
    {
        Object obj = dn;
        if (dn instanceof do)
        {
            android.view.WindowInsets windowinsets = ((do)dn).g();
            view = view.dispatchApplyWindowInsets(windowinsets);
            obj = dn;
            if (view != windowinsets)
            {
                obj = new do(view);
            }
        }
        return ((dn) (obj));
    }

    public final void f(View view, float f1)
    {
        view.setElevation(f1);
    }

    public final void u(View view)
    {
        view.requestApplyInsets();
    }

    public final float v(View view)
    {
        return view.getElevation();
    }

    public final float w(View view)
    {
        return view.getTranslationZ();
    }
}
