// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            bo

class bp extends bo
{

    bp()
    {
    }

    public final void a(View view, int i, int j, int i1, int j1)
    {
        view.setPaddingRelative(i, j, i1, j1);
    }

    public final int h(View view)
    {
        return view.getLayoutDirection();
    }

    public final int k(View view)
    {
        return view.getPaddingStart();
    }

    public final int l(View view)
    {
        return view.getPaddingEnd();
    }

    public final int t(View view)
    {
        return view.getWindowSystemUiVisibility();
    }

    public final boolean z(View view)
    {
        return view.isPaddingRelative();
    }
}
