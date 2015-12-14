// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.view.TLightingScrollView;

public class bqk
    implements android.view.View.OnClickListener
{

    final TLightingScrollView a;

    public bqk(TLightingScrollView tlightingscrollview)
    {
        a = tlightingscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (TLightingScrollView.access$100(a) != view)
        {
            if (TLightingScrollView.access$100(a) != null)
            {
                TLightingScrollView.access$100(a).setSelected(false);
            }
            TLightingScrollView.access$102(a, view);
            view.setSelected(true);
            if (TLightingScrollView.access$200(a) != null)
            {
                view = (TImageFilterInfo)view.getTag();
                TLightingScrollView.access$200(a).a(view);
                return;
            }
        }
    }
}
