// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.TextView;
import com.groupon.mvc.model.Directions;
import com.groupon.view.NonLeakingNonFlickerWebView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class DirectionsViewHolder extends RecyclerItemViewHolder
{

    TextView howToGetThereTitleView;
    NonLeakingNonFlickerWebView howToGetThereView;
    TextView travelerTipsTitleView;
    NonLeakingNonFlickerWebView travelerTipsView;

    public DirectionsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        String s = ((Directions)model).howToGetThereHtml;
        String s1 = ((Directions)model).travelerTipsHtml;
        String s2 = ((Directions)model).webViewCSSStyling;
        if (Strings.notEmpty(s))
        {
            howToGetThereView.loadDataWithBaseURL(null, (new StringBuilder()).append(s2).append(s).toString(), "text/html", "UTF-8", null);
            howToGetThereView.setVisibility(0);
            howToGetThereTitleView.setVisibility(0);
        } else
        {
            howToGetThereView.setVisibility(8);
            howToGetThereTitleView.setVisibility(8);
        }
        if (Strings.notEmpty(s1))
        {
            travelerTipsView.loadDataWithBaseURL(null, (new StringBuilder()).append(s2).append(s1).toString(), "text/html", "UTF-8", null);
            travelerTipsView.setVisibility(0);
            travelerTipsTitleView.setVisibility(0);
            return;
        } else
        {
            travelerTipsView.setVisibility(8);
            travelerTipsTitleView.setVisibility(8);
            return;
        }
    }
}
