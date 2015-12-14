// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import ms;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            TProEditMainScrollView, ItemView

class a
    implements android.view.EditMainScrollView._cls2
{

    final TProEditMainScrollView a;

    public void onClick(View view)
    {
        if (TProEditMainScrollView.access$000(a) != (ItemView)view)
        {
            if (TProEditMainScrollView.access$000(a) != null)
            {
                TProEditMainScrollView.access$000(a).setSelected(false);
            }
            TProEditMainScrollView.access$002(a, (ItemView)view);
        }
        view.setSelected(true);
        if (TProEditMainScrollView.access$100(a) != null)
        {
            TProEditMainScrollView.access$100(a).a((String)view.getTag(), a);
        }
    }

    (TProEditMainScrollView tproeditmainscrollview)
    {
        a = tproeditmainscrollview;
        super();
    }
}
