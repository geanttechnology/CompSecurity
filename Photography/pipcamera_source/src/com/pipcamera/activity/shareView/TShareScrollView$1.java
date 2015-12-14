// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.shareView;

import android.view.View;
import ta;

// Referenced classes of package com.pipcamera.activity.shareView:
//            TShareScrollView

class a
    implements android.view.r
{

    final TShareScrollView a;

    public void onClick(View view)
    {
        if (TShareScrollView.access$000(a) != view)
        {
            if (TShareScrollView.access$000(a) != null)
            {
                TShareScrollView.access$000(a).setSelected(false);
            }
            TShareScrollView.access$002(a, view);
        }
        view.setSelected(true);
        if (TShareScrollView.access$100(a) != null)
        {
            TShareScrollView.access$100(a).a((String)view.getTag(), a);
        }
    }

    _cls9(TShareScrollView tsharescrollview)
    {
        a = tsharescrollview;
        super();
    }
}
