// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.groupon.callbacks.OnMarketplaceEventListener;
import com.groupon.mvc.model.Marketplace;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class MarketplaceViewHolder extends RecyclerItemViewHolder
{
    public class ExpandTextButtonClickListener
        implements android.view.View.OnClickListener
    {

        final MarketplaceViewHolder this$0;

        public void onClick(View view)
        {
            boolean flag = expandableTextView.isShown();
            view = expandableTextView;
            byte byte0;
            if (flag)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
            ((OnMarketplaceEventListener)callback).onExpandTextClick(flag);
        }

        public ExpandTextButtonClickListener()
        {
            this$0 = MarketplaceViewHolder.this;
            super();
        }
    }


    Button expandCollapseButton;
    TextView expandableTextView;

    public MarketplaceViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        expandCollapseButton.setText(((Marketplace)model).connectedMarketPlaceDisplayText);
        expandCollapseButton.setOnClickListener(new ExpandTextButtonClickListener());
    }
}
