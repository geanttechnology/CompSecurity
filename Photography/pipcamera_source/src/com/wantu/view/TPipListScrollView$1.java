// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.view.View;
import com.wantu.model.res.pip.TDFSceneInfo;
import yv;

// Referenced classes of package com.wantu.view:
//            TPipListScrollView

class a
    implements android.view._cls1
{

    final TPipListScrollView a;

    public void onClick(View view)
    {
        if (TPipListScrollView.access$000(a) != view)
        {
            if (TPipListScrollView.access$000(a) != null)
            {
                TPipListScrollView.access$000(a).setSelected(false);
            }
            TPipListScrollView.access$002(a, view);
            view.setSelected(true);
            if (TPipListScrollView.access$100(a) != null)
            {
                view = (TDFSceneInfo)view.getTag();
                TPipListScrollView.access$100(a).a(view);
                return;
            }
        }
    }

    (TPipListScrollView tpiplistscrollview)
    {
        a = tpiplistscrollview;
        super();
    }
}
