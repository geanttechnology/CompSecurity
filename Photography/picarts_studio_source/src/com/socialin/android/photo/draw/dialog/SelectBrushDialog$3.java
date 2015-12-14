// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectBrushDialog

final class a
    implements android.view.
{

    private View a;
    private SelectBrushDialog b;

    public final void onClick(View view)
    {
        if (SelectBrushDialog.i(b).getChildAt(0).getVisibility() == 0)
        {
            a.setSelected(true);
            SelectBrushDialog.j(b);
            return;
        } else
        {
            a.setSelected(false);
            SelectBrushDialog.k(b);
            return;
        }
    }

    (SelectBrushDialog selectbrushdialog, View view)
    {
        b = selectbrushdialog;
        a = view;
        super();
    }
}
