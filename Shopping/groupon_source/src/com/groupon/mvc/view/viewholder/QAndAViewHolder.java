// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.TextView;
import com.groupon.mvc.model.QandA;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class QAndAViewHolder extends RecyclerItemViewHolder
{

    View qaArrowRightView;
    TextView qaPostsCountView;
    View qaSectionView;
    TextView qaTitleView;

    public QAndAViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        boolean flag = ((QandA)model).shouldShowCount;
        if (flag)
        {
            qaSectionView.setOnClickListener((android.view.View.OnClickListener)callback);
        }
        if (qaArrowRightView != null)
        {
            View view = qaArrowRightView;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            if (!flag)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutparams.addRule(11);
                layoutparams.addRule(13);
                qaPostsCountView.setLayoutParams(layoutparams);
            }
        }
        qaTitleView.setText(((QandA)model).title);
        qaPostsCountView.setText(((QandA)model).postsCountText);
        qaSectionView.setVisibility(0);
    }
}
