// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import com.groupon.callbacks.OnExposedOptionsEventListener;
import com.groupon.mvc.model.ExposedMultiOptions;
import com.groupon.mvc.model.OptionCardData;
import com.groupon.view.optioncards.CheckableOptionCardView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class ExposedMultiOptionsViewHolder extends RecyclerItemViewHolder
{
    private class AllOptionsButtonClickListener
        implements android.view.View.OnClickListener
    {

        final ExposedMultiOptionsViewHolder this$0;

        public void onClick(View view)
        {
            if (callback != null)
            {
                ((OnExposedOptionsEventListener)callback).onAllOptionsButtonClick(view);
            }
        }

        private AllOptionsButtonClickListener()
        {
            this$0 = ExposedMultiOptionsViewHolder.this;
            super();
        }

    }

    private class SecondOptionCardClickListener
        implements android.view.View.OnClickListener
    {

        final ExposedMultiOptionsViewHolder this$0;

        public void onClick(View view)
        {
            refreshOptionViewHeights();
            updateOptionsCheckmark();
            swapViews();
        }

        private SecondOptionCardClickListener()
        {
            this$0 = ExposedMultiOptionsViewHolder.this;
            super();
        }

    }

    private class SwapAnimationListener extends AnimatorListenerAdapter
    {

        final ExposedMultiOptionsViewHolder this$0;

        public void onAnimationEnd(Animator animator)
        {
            selectedOptionId = secondOptionView.getOptionId();
            animator = secondOptionView;
            secondOptionView = firstOptionView;
            firstOptionView = animator;
            if (callback != null)
            {
                ((OnExposedOptionsEventListener)callback).onOptionSelectionChange(selectedOptionId);
            }
            refreshOptionViewHeights();
            initSecondOptionOnClickListener();
        }

        public void onAnimationStart(Animator animator)
        {
            secondOptionView.setOnClickListener(null);
            secondOptionView.bringToFront();
        }

        private SwapAnimationListener()
        {
            this$0 = ExposedMultiOptionsViewHolder.this;
            super();
        }

    }


    private static final float HEIGHT_RESIZE_FACTOR = 1.04F;
    private static final String PROPERTY_SCALE_X = "scaleX";
    private static final String PROPERTY_SCALE_Y = "scaleY";
    private static final String PROPERTY_Y = "y";
    private static final int SCALE_OPTION_ANIMATION_DELAY = 400;
    private static final int SCALE_OPTION_ANIMATION_DURATION = 200;
    private static final float SWAP_OPTION_ANIMATION_DECELERATE_FACTOR = 2F;
    private static final int SWAP_OPTION_ANIMATION_DELAY = 200;
    private static final int SWAP_OPTION_ANIMATION_DURATION = 600;
    private static final float WIDTH_RESIZE_FACTOR = 1.02F;
    private int belowViewHeight;
    CheckableOptionCardView firstOptionView;
    View firstSecondSeparator;
    CheckableOptionCardView secondOptionView;
    private String selectedOptionId;
    private int topViewHeight;
    Button viewAllOptionsButton;
    View viewAllOptionsButtonContainer;

    public ExposedMultiOptionsViewHolder(View view)
    {
        super(view);
    }

    private void initSecondOptionOnClickListener()
    {
        SecondOptionCardClickListener secondoptioncardclicklistener;
        CheckableOptionCardView checkableoptioncardview;
        boolean flag;
        if (!((OptionCardData)secondOptionView.getTag()).soldOutOrExpired)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        firstOptionView.setOnClickListener(null);
        checkableoptioncardview = secondOptionView;
        if (flag)
        {
            secondoptioncardclicklistener = new SecondOptionCardClickListener();
        } else
        {
            secondoptioncardclicklistener = null;
        }
        checkableoptioncardview.setOnClickListener(secondoptioncardclicklistener);
    }

    private void populateOptionCard(CheckableOptionCardView checkableoptioncardview, OptionCardData optioncarddata)
    {
        checkableoptioncardview.setOptionId(optioncarddata.optionId);
        checkableoptioncardview.setTitleText(optioncarddata.title);
        checkableoptioncardview.setPriceText(optioncarddata.price);
        checkableoptioncardview.setPriceColor(optioncarddata.priceColor);
        checkableoptioncardview.setSoldOutOrExpiredOverlayVisibility(optioncarddata.soldOutOrExpired);
        boolean flag;
        if (!optioncarddata.soldOutOrExpired)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        checkableoptioncardview.setPriceEnabled(flag);
        checkableoptioncardview.setChecked(optioncarddata.checked);
        checkableoptioncardview.setDisplayLimitedAvailability(optioncarddata.displayLimitedAvailability);
        if (optioncarddata.displayDiscount)
        {
            checkableoptioncardview.setDiscount(optioncarddata.discount);
        }
        checkableoptioncardview.setDiscountVisibility(optioncarddata.displayDiscount);
        if (optioncarddata.displayBought)
        {
            checkableoptioncardview.setBought(optioncarddata.bought);
        }
        checkableoptioncardview.setBoughtVisibility(optioncarddata.displayBought);
        if (optioncarddata.displayUrgencyPricing)
        {
            checkableoptioncardview.setUrgencyPricingLabel(optioncarddata.urgencyPricingLabel);
        }
        checkableoptioncardview.setUrgencyPricingLabelVisibility(optioncarddata.displayUrgencyPricing);
        if (optioncarddata.displayOldPrice)
        {
            checkableoptioncardview.setOldPrice(optioncarddata.oldPrice);
        }
        checkableoptioncardview.setOldPriceVisibility(optioncarddata.displayOldPrice);
        checkableoptioncardview.setTag(optioncarddata);
    }

    private void refreshOptionViewHeights()
    {
        belowViewHeight = secondOptionView.getHeight() + firstSecondSeparator.getHeight();
        topViewHeight = firstOptionView.getHeight() + firstSecondSeparator.getHeight();
    }

    private void swapViews()
    {
        AnimatorSet animatorset = new AnimatorSet();
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(secondOptionView, "scaleX", new float[] {
            1.0F
        }).setDuration(200L);
        objectanimator.setStartDelay(400L);
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(secondOptionView, "scaleY", new float[] {
            1.0F
        }).setDuration(200L);
        objectanimator.setStartDelay(400L);
        animatorset.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(secondOptionView, "scaleX", new float[] {
                1.02F
            }).setDuration(200L), ObjectAnimator.ofFloat(secondOptionView, "scaleY", new float[] {
                1.04F
            }).setDuration(200L), ObjectAnimator.ofFloat(firstOptionView, "y", new float[] {
                firstOptionView.getY() + (float)belowViewHeight
            }).setDuration(600L), ObjectAnimator.ofFloat(secondOptionView, "y", new float[] {
                secondOptionView.getY() - (float)topViewHeight
            }).setDuration(600L), objectanimator, objectanimator1
        });
        animatorset.addListener(new SwapAnimationListener());
        animatorset.setStartDelay(200L);
        animatorset.setInterpolator(new DecelerateInterpolator(2.0F));
        animatorset.start();
    }

    private void updateOptionsCheckmark()
    {
        firstOptionView.setChecked(false);
        secondOptionView.setChecked(true);
    }

    public void populateViews()
    {
        populateOptionCard(firstOptionView, ((ExposedMultiOptions)model).firstOptionCardData);
        populateOptionCard(secondOptionView, ((ExposedMultiOptions)model).secondOptionCardData);
        firstOptionView.setChecked(true);
        secondOptionView.setChecked(false);
        View view = viewAllOptionsButtonContainer;
        int i;
        if (((ExposedMultiOptions)model).displayAllOptionsButton)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (((ExposedMultiOptions)model).displayAllOptionsButton)
        {
            viewAllOptionsButton.setText(itemView.getContext().getResources().getQuantityString(0x7f0c001b, ((ExposedMultiOptions)model).optionsCount, new Object[] {
                Integer.valueOf(((ExposedMultiOptions)model).optionsCount)
            }).toUpperCase());
            viewAllOptionsButton.setOnClickListener(new AllOptionsButtonClickListener());
        }
        initSecondOptionOnClickListener();
    }






/*
    static String access$602(ExposedMultiOptionsViewHolder exposedmultioptionsviewholder, String s)
    {
        exposedmultioptionsviewholder.selectedOptionId = s;
        return s;
    }

*/

}
