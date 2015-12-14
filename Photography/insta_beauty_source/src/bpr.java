// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.view.TBackgroudScrollView;

public class bpr
    implements android.view.View.OnClickListener
{

    final TBackgroudScrollView a;

    public bpr(TBackgroudScrollView tbackgroudscrollview)
    {
        a = tbackgroudscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TBackgroudScrollView.access$100(a) != view)
        {
            if (TBackgroudScrollView.access$100(a) != null)
            {
                TBackgroudScrollView.access$100(a).setSelected(false);
            }
            TBackgroudScrollView.access$102(a, view);
            view.setSelected(true);
            if (TBackgroudScrollView.access$200(a) != null)
            {
                view = (TFrameItemInfo)view.getTag();
                TBackgroudScrollView.access$200(a).a(view);
                return;
            }
        }
    }
}
