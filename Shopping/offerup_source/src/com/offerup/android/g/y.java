// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.ViewTreeObserver;
import android.widget.SeekBar;

// Referenced classes of package com.offerup.android.g:
//            x

final class y
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private x a;

    y(x x1)
    {
        a = x1;
        super();
    }

    public final boolean onPreDraw()
    {
        x.a(a, x.a(a).getMeasuredHeight());
        x.b(a, x.a(a).getMeasuredWidth());
        x.b(a);
        x.a(a).getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
