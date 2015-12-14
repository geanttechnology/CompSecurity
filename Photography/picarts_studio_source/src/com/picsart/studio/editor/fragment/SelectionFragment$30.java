// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Point;
import android.view.View;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view.obalLayoutListener
{

    private View a;
    private SelectionFragment b;

    public final void onGlobalLayout()
    {
        if (SelectionFragment.u(b).x == 0)
        {
            SelectionFragment.u(b).x = a.getWidth();
        }
        if (SelectionFragment.u(b).y == 0)
        {
            SelectionFragment.u(b).y = a.getHeight();
        }
        if (SelectionFragment.u(b).x > 0 && SelectionFragment.u(b).y > 0)
        {
            SelectionFragment.a(a, this);
        }
        SelectionFragment.a(b, a);
    }

    (SelectionFragment selectionfragment, View view)
    {
        b = selectionfragment;
        a = view;
        super();
    }
}
