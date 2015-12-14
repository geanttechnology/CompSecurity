// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.model.res.TPhotoFreeFrameLayoutInfo;
import com.wantu.view.TCollageStyleScrollView;

public class bpt
    implements android.view.View.OnClickListener
{

    final TCollageStyleScrollView a;

    public bpt(TCollageStyleScrollView tcollagestylescrollview)
    {
        a = tcollagestylescrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TCollageStyleScrollView.access$000(a) != view)
        {
            if (TCollageStyleScrollView.access$000(a) != null)
            {
                TCollageStyleScrollView.access$000(a).setSelected(false);
            }
            TCollageStyleScrollView.access$002(a, view);
            view.setSelected(true);
            if (TCollageStyleScrollView.access$100(a) != null)
            {
                view = (TPhotoFreeFrameLayoutInfo)view.getTag();
                TCollageStyleScrollView.access$100(a).a(view);
                return;
            }
        }
    }
}
