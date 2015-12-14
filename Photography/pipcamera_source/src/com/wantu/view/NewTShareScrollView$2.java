// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.view.View;
import ta;

// Referenced classes of package com.wantu.view:
//            NewTShareScrollView

class a
    implements android.view._cls2
{

    final NewTShareScrollView a;

    public void onClick(View view)
    {
        if (NewTShareScrollView.access$000(a) != view)
        {
            if (NewTShareScrollView.access$000(a) != null)
            {
                NewTShareScrollView.access$000(a).setSelected(false);
            }
            NewTShareScrollView.access$002(a, view);
        }
        view.setSelected(true);
        if (NewTShareScrollView.access$100(a) != null)
        {
            NewTShareScrollView.access$100(a).a((String)view.getTag(), a);
        }
    }

    (NewTShareScrollView newtsharescrollview)
    {
        a = newtsharescrollview;
        super();
    }
}
