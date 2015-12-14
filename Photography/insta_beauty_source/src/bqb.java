// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.view.TFrameListScrollView;

public class bqb
    implements android.view.View.OnClickListener
{

    final TFrameListScrollView a;

    public bqb(TFrameListScrollView tframelistscrollview)
    {
        a = tframelistscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TFrameListScrollView.access$100(a) != view)
        {
            if (TFrameListScrollView.access$100(a) != null)
            {
                TFrameListScrollView.access$100(a).setSelected(false);
            }
            TFrameListScrollView.access$102(a, view);
            view.setSelected(true);
            if (TFrameListScrollView.access$200(a) != null)
            {
                view = (TFrameItemInfo)view.getTag();
                TFrameListScrollView.access$200(a).a(view);
                return;
            }
        }
    }
}
