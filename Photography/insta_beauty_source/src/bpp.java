// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.model.res.TPhotoFreeComposeStyleInfo;
import com.wantu.view.TBackgroudFreeStyleScrollView;

public class bpp
    implements android.view.View.OnClickListener
{

    final TBackgroudFreeStyleScrollView a;

    public bpp(TBackgroudFreeStyleScrollView tbackgroudfreestylescrollview)
    {
        a = tbackgroudfreestylescrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TBackgroudFreeStyleScrollView.access$000(a) != view)
        {
            if (TBackgroudFreeStyleScrollView.access$000(a) != null)
            {
                TBackgroudFreeStyleScrollView.access$000(a).setSelected(false);
            }
            TBackgroudFreeStyleScrollView.access$002(a, view);
            view.setSelected(true);
            if (TBackgroudFreeStyleScrollView.access$100(a) != null)
            {
                view = (TPhotoFreeComposeStyleInfo)view.getTag();
                TBackgroudFreeStyleScrollView.access$100(a).a(view);
                return;
            }
        }
    }
}
