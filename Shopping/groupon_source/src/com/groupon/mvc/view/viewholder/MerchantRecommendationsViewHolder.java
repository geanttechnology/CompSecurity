// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.groupon.callbacks.OnMerchantRecommendationsClickEventListener;
import com.groupon.mvc.model.MerchantRecommendation;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class MerchantRecommendationsViewHolder extends RecyclerItemViewHolder
{
    private class RecommendationsSectionClickListener
        implements android.view.View.OnClickListener
    {

        final MerchantRecommendationsViewHolder this$0;

        public void onClick(View view)
        {
            if (callback != null)
            {
                ((OnMerchantRecommendationsClickEventListener)callback).onClick(view, recommendationsLabelView.getText().toString());
            }
        }

        private RecommendationsSectionClickListener()
        {
            this$0 = MerchantRecommendationsViewHolder.this;
            super();
        }

    }


    View recommendationsArrow;
    TextView recommendationsLabelView;
    View recommendationsSection;

    public MerchantRecommendationsViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        Object obj = ((MerchantRecommendation)model).merchantRecommendationLabelHtml;
        boolean flag = ((MerchantRecommendation)model).hasMerchantTips;
        if (Strings.notEmpty(obj))
        {
            recommendationsLabelView.setText(Html.fromHtml(((String) (obj))));
        }
        View view = recommendationsSection;
        int i;
        if (flag)
        {
            obj = new RecommendationsSectionClickListener();
        } else
        {
            obj = null;
        }
        view.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        obj = recommendationsArrow;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }
}
