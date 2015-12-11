// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingOverviewModel

public class SellingOverviewHolder extends ViewHolder
{

    private static int PROGRESS_SCALE = 100;
    private static boolean animateSellingOverview = true;
    public final TextView numberSold;
    public final TextView numberUnsold;
    public final ProgressBar progressBar;
    public final Button seeAll;
    public final View sold;
    public final TextView soldText;
    public final TextView timeRange;
    public final TextView totalSold;
    public final View unsold;
    public final TextView unsoldText;

    public SellingOverviewHolder(View view)
    {
        super(view);
        progressBar = (ProgressBar)view.findViewById(0x7f1002ac);
        totalSold = (TextView)view.findViewById(0x7f1002ad);
        timeRange = (TextView)view.findViewById(0x7f1002ae);
        numberUnsold = (TextView)view.findViewById(0x7f1002aa);
        numberSold = (TextView)view.findViewById(0x7f1002a7);
        sold = view.findViewById(0x7f1002a6);
        soldText = (TextView)view.findViewById(0x7f1002a8);
        unsoldText = (TextView)view.findViewById(0x7f1002ab);
        unsold = view.findViewById(0x7f1002a9);
        seeAll = (Button)view.findViewById(0x7f1002a5);
        seeAll.setOnClickListener(this);
        sold.setOnClickListener(this);
        unsold.setOnClickListener(this);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof SellingOverviewModel))
        {
            throw new IllegalArgumentException("Model is not instance of SellingOverviewModel");
        }
        Resources resources = itemView.getResources();
        String s = itemView.getResources().getString(0x7f0701ef);
        SellingOverviewModel sellingoverviewmodel = (SellingOverviewModel)viewmodel;
        final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingOverview overview = sellingoverviewmodel.record.sellingOverview;
        s = String.format(s, new Object[] {
            Integer.valueOf(overview.periodInDays)
        });
        viewmodel = String.valueOf(overview.numberOfSoldItems);
        Button button = seeAll;
        int i;
        boolean flag;
        if (sellingoverviewmodel.sellContentEnabled)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        button.setVisibility(i);
        if (overview.hasMoreSold)
        {
            viewmodel = (new StringBuilder()).append(viewmodel).append("+").toString();
            timeRange.setVisibility(4);
            totalSold.setVisibility(4);
        } else
        {
            timeRange.setVisibility(0);
            totalSold.setVisibility(0);
        }
        timeRange.setText(s);
        numberSold.setText(viewmodel);
        numberUnsold.setText(String.valueOf(overview.numberOfUnsoldItems));
        if (overview.grossMerchandiseVolume != null)
        {
            totalSold.setText(EbayCurrencyUtil.formatDisplay(overview.grossMerchandiseVolume.currency, overview.grossMerchandiseVolume.value, 2));
        } else
        {
            totalSold.setText("0");
        }
        if (overview.grossMerchandiseVolume != null && overview.grossMerchandiseVolume.value > 0.0D || overview.hasMoreSold)
        {
            totalSold.setTextColor(resources.getColor(0x7f0d00a5));
            numberSold.setTextColor(resources.getColor(0x7f0d00a5));
        } else
        {
            totalSold.setTextColor(resources.getColor(0x7f0d00e7));
            numberSold.setTextColor(resources.getColor(0x7f0d00e7));
        }
        progressBar.setMax((overview.numberOfSoldItems + overview.numberOfUnsoldItems) * PROGRESS_SCALE);
        soldText.setText(resources.getQuantityString(0x7f08000f, overview.numberOfSoldItems));
        unsoldText.setText(resources.getQuantityString(0x7f080010, overview.numberOfUnsoldItems));
        viewmodel = sold;
        if (overview.grossMerchandiseVolume != null && overview.grossMerchandiseVolume.value > 0.0D || overview.hasMoreSold)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewmodel.setEnabled(flag);
        viewmodel = unsold;
        if ((long)overview.numberOfUnsoldItems > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewmodel.setEnabled(flag);
        if (animateSellingOverview && !overview.hasMoreSold && overview.grossMerchandiseVolume != null)
        {
            animateSellingOverview = false;
            progressBar.setProgress(0);
            viewmodel = ObjectAnimator.ofInt(progressBar, "progress", new int[] {
                overview.numberOfSoldItems * PROGRESS_SCALE
            });
            viewmodel.setDuration(2000L);
            viewmodel.setInterpolator(new DecelerateInterpolator());
            viewmodel.start();
            viewmodel.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                final SellingOverviewHolder this$0;
                final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingOverview val$overview;

                public void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    if (overview.grossMerchandiseVolume != null)
                    {
                        double d = valueanimator.getAnimatedFraction();
                        double d1 = overview.grossMerchandiseVolume.value;
                        double d2 = SellingOverviewHolder.PROGRESS_SCALE;
                        totalSold.setText(EbayCurrencyUtil.formatDisplay(overview.grossMerchandiseVolume.currency, (d * d1 * d2) / (double)SellingOverviewHolder.PROGRESS_SCALE, 2));
                    }
                }

            
            {
                this$0 = SellingOverviewHolder.this;
                overview = sellingoverview;
                super();
            }
            });
            viewmodel.addListener(new android.animation.Animator.AnimatorListener() {

                final SellingOverviewHolder this$0;
                final com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingOverview val$overview;

                public void onAnimationCancel(Animator animator)
                {
                    animator.removeAllListeners();
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (overview.grossMerchandiseVolume != null)
                    {
                        totalSold.setText(EbayCurrencyUtil.formatDisplay(overview.grossMerchandiseVolume.currency, overview.grossMerchandiseVolume.value, 2));
                    }
                    animator.removeAllListeners();
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = SellingOverviewHolder.this;
                overview = sellingoverview;
                super();
            }
            });
            return;
        }
        viewmodel = progressBar;
        if (overview.hasMoreSold)
        {
            i = 0;
        } else
        {
            i = overview.numberOfSoldItems * PROGRESS_SCALE;
        }
        viewmodel.setProgress(i);
    }


}
