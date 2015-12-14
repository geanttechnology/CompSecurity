// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.view.View;
import yu;

// Referenced classes of package com.wantu.view:
//            TIconListScrollView

class a
    implements android.view._cls1
{

    final TIconListScrollView a;

    public void onClick(View view)
    {
        if (TIconListScrollView.access$000(a) != view)
        {
            if (TIconListScrollView.access$000(a) != null)
            {
                TIconListScrollView.access$000(a).setSelected(false);
            }
            TIconListScrollView.access$002(a, view);
            view.setSelected(true);
            if (TIconListScrollView.access$100(a) != null)
            {
                TIconListScrollView.access$100(a).a(view.getTag());
                return;
            }
        }
    }

    (TIconListScrollView ticonlistscrollview)
    {
        a = ticonlistscrollview;
        super();
    }
}
