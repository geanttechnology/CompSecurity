// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            f, SelectShapeDialog

final class c
    implements android.view..OnClickListener
{

    private ViewGroup a;
    private int b;
    private int c;
    private f d;

    public final void onClick(View view)
    {
        View view1 = a.findViewWithTag(SelectShapeDialog.g(d.a));
        if (view1 != null)
        {
            view1.setBackgroundResource(0x7f0200be);
        }
        view.setBackgroundResource(0x7f0200aa);
        SelectShapeDialog.a(d.a, b * SelectShapeDialog.n(d.a) * SelectShapeDialog.i(d.a) + c);
    }

    ctShapeDialog(f f1, ViewGroup viewgroup, int i, int j)
    {
        d = f1;
        a = viewgroup;
        b = i;
        c = j;
        super();
    }
}
