// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Point;
import android.view.View;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class b
    implements android.view.obalLayoutListener
{

    private View a;
    private View b;
    private SelectionFragment c;

    public final void onGlobalLayout()
    {
        if (SelectionFragment.v(c).x == 0)
        {
            SelectionFragment.v(c).x = a.getWidth();
        }
        if (SelectionFragment.v(c).y == 0)
        {
            SelectionFragment.v(c).y = a.getHeight();
        }
        if (SelectionFragment.v(c).x > 0 && SelectionFragment.v(c).y > 0)
        {
            SelectionFragment.a(a, this);
        }
        SelectionFragment.a(c, b);
    }

    (SelectionFragment selectionfragment, View view, View view1)
    {
        c = selectionfragment;
        a = view;
        b = view1;
        super();
    }
}
