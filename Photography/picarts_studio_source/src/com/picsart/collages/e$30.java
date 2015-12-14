// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.view.View;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView

final class a
    implements android.view.OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        boolean flag = true;
        if (view.isSelected())
        {
            view.setSelected(false);
        } else
        {
            view.setSelected(true);
        }
        view = e.b(a);
        if (e.b(a).p)
        {
            flag = false;
        }
        view.setControlsVisible(flag);
        e.b(a).invalidate();
    }

    geCreatorView(e e1)
    {
        a = e1;
        super();
    }
}
