// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.socialin.android.photo.select.SelectionDrawController;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view.
{

    private SelectionFragment a;

    public final void onClick(View view)
    {
        if (SelectionFragment.p(a) != null)
        {
            SelectionFragment.p(a).a(SelectionFragment.G(a));
            SelectionFragment.a(a, agmentUIMode.SELECTION);
        }
    }

    agmentUIMode(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
