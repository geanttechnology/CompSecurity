// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.view.View;
import com.socialin.android.brushlib.brush.BrushHistory;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            d, SelectBrushDialog

final class a
    implements android.view..OnClickListener
{

    private int a;
    private d b;

    public final void onClick(View view)
    {
        int i = SelectBrushDialog.b(b.a).getSelectedBrushId(SelectBrushDialog.a(b.a));
        boolean flag;
        if (a == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            SelectBrushDialog.a(b.a, a);
            if (d.a(b) != null)
            {
                d.a(b).setSelected(false);
                d.a(b).invalidate();
            }
            d.a(b, view);
            d.a(b).setSelected(true);
            d.a(b).invalidate();
        }
        switch (a)
        {
        default:
            return;

        case 21: // '\025'
            SelectBrushDialog.s(b.a);
            return;

        case 22: // '\026'
            SelectBrushDialog.t(b.a);
            break;
        }
    }

    story(d d1, int i)
    {
        b = d1;
        a = i;
        super();
    }
}
