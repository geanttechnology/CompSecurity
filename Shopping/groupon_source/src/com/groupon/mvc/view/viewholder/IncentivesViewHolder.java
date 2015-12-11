// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.TextView;
import com.groupon.mvc.model.Incentive;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class IncentivesViewHolder extends RecyclerItemViewHolder
{

    TextView incentiveEnterCodeView;
    TextView incentiveTitleView;
    View incentiveTopSeparator;

    public IncentivesViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        View view = incentiveTopSeparator;
        int i;
        if (((Incentive)model).displayTopSeparator)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        incentiveTitleView.setText(((Incentive)model).incentiveTitle);
        if (((Incentive)model).shouldDisplayEnterCode)
        {
            incentiveEnterCodeView.setOnClickListener((android.view.View.OnClickListener)callback);
            incentiveEnterCodeView.setVisibility(0);
            return;
        } else
        {
            incentiveEnterCodeView.setVisibility(8);
            return;
        }
    }
}
