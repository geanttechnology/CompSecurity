// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            TipsViewHolder

public class 
    implements butterknife.wHolder..ViewBinder
{

    public void bind(butterknife.wHolder..ViewBinder viewbinder, TipsViewHolder tipsviewholder, Object obj)
    {
        tipsviewholder.recommendationsLabelView = (TextView)viewbinder.((View)viewbinder.iredView(obj, 0x7f1004d6, "field 'recommendationsLabelView'"), 0x7f1004d6, "field 'recommendationsLabelView'");
        tipsviewholder.merchantRecommendationsContainer = (LinearLayout)viewbinder.((View)viewbinder.iredView(obj, 0x7f1004e2, "field 'merchantRecommendationsContainer'"), 0x7f1004e2, "field 'merchantRecommendationsContainer'");
        tipsviewholder.tipsListContainer = (LinearLayout)viewbinder.((View)viewbinder.iredView(obj, 0x7f1004e3, "field 'tipsListContainer'"), 0x7f1004e3, "field 'tipsListContainer'");
    }

    public volatile void bind(butterknife.wHolder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (TipsViewHolder)obj, obj1);
    }

    public void unbind(TipsViewHolder tipsviewholder)
    {
        tipsviewholder.recommendationsLabelView = null;
        tipsviewholder.merchantRecommendationsContainer = null;
        tipsviewholder.tipsListContainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((TipsViewHolder)obj);
    }

    public ()
    {
    }
}
