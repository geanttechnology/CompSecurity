// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.models.tips.MerchantTip;
import com.groupon.mvc.model.Tips;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class TipsViewHolder extends RecyclerItemViewHolder
{

    LinearLayout merchantRecommendationsContainer;
    TextView recommendationsLabelView;
    LinearLayout tipsListContainer;

    public TipsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        String s = ((Tips)model).merchantRecommendationLabelHtml;
        List list = ((Tips)model).merchantTips;
        if (Strings.notEmpty(s))
        {
            merchantRecommendationsContainer.setVisibility(0);
            recommendationsLabelView.setText(Html.fromHtml(s));
        } else
        {
            merchantRecommendationsContainer.setVisibility(8);
        }
        tipsListContainer.removeAllViews();
        if (list != null)
        {
            View view;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); tipsListContainer.addView(view))
            {
                MerchantTip merchanttip = (MerchantTip)iterator.next();
                view = View.inflate(itemView.getContext(), 0x7f030216, null);
                TextView textview = (TextView)view.findViewById(0x7f10055f);
                TextView textview1 = (TextView)view.findViewById(0x7f100560);
                TextView textview2 = (TextView)view.findViewById(0x7f100561);
                textview.setText(merchanttip.text);
                textview1.setText(merchanttip.maskedName);
                textview2.setText(merchanttip.updatedAtString);
            }

        }
    }
}
