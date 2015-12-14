// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.LinearLayout;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view.obalLayoutListener
{

    private LinearLayout a;
    private SelectionFragment b;

    public final void onGlobalLayout()
    {
        if (SelectionFragment.t(b))
        {
            SelectionFragment.a(a, this);
        }
    }

    (SelectionFragment selectionfragment, LinearLayout linearlayout)
    {
        b = selectionfragment;
        a = linearlayout;
        super();
    }
}
