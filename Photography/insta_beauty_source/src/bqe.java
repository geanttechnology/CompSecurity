// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.view.TGridsStyleScrollView;

public class bqe
    implements android.view.View.OnClickListener
{

    final TGridsStyleScrollView a;

    public bqe(TGridsStyleScrollView tgridsstylescrollview)
    {
        a = tgridsstylescrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TGridsStyleScrollView.access$100(a) != view)
        {
            if (TGridsStyleScrollView.access$100(a) != null)
            {
                TGridsStyleScrollView.access$100(a).setSelected(false);
            }
            TGridsStyleScrollView.access$102(a, view);
            view.setSelected(true);
            if (TGridsStyleScrollView.access$200(a) != null)
            {
                view = (TPhotoComposeInfo)view.getTag();
                TGridsStyleScrollView.access$200(a).a(view);
                return;
            }
        }
    }
}
