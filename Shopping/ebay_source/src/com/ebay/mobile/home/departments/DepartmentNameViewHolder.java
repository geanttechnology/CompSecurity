// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.cos.base.Text;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentNameViewModel

public class DepartmentNameViewHolder extends ViewHolder
{

    public final ImageView arrowView;
    private Channel currentChannel;
    private final int defaultSeparatorSize;
    private boolean isArrowEnabled;
    private boolean isArrowVisible;
    public final TextView nameView;
    private final int screenWidth;
    private final int selectedColor;
    private final int unselectedColor;

    public DepartmentNameViewHolder(View view)
    {
        super(view);
        currentChannel = null;
        isArrowEnabled = false;
        isArrowVisible = false;
        Resources resources = view.getResources();
        defaultSeparatorSize = resources.getDimensionPixelSize(0x7f09006b);
        Display display = ((WindowManager)view.getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        screenWidth = point.x;
        selectedColor = resources.getColor(0x7f0d00dd);
        unselectedColor = resources.getColor(0x7f0d00e7);
        nameView = (TextView)view.findViewById(0x7f100248);
        arrowView = (ImageView)view.findViewById(0x7f100249);
        if (nameView != null)
        {
            nameView.setOnClickListener(this);
        }
        if (arrowView != null)
        {
            arrowView.setOnClickListener(this);
        }
    }

    private void updateOpenCloseToggle(boolean flag)
    {
        if (!isArrowEnabled) goto _L2; else goto _L1
_L1:
        arrowView.animate().cancel();
        if (!isArrowVisible) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        arrowView.animate().withStartAction(new Runnable() {

            final DepartmentNameViewHolder this$0;

            public void run()
            {
                arrowView.setTranslationX(-arrowView.getWidth());
                arrowView.setAlpha(0.0F);
                arrowView.setVisibility(0);
            }

            
            {
                this$0 = DepartmentNameViewHolder.this;
                super();
            }
        }).withEndAction(new Runnable() {

            final DepartmentNameViewHolder this$0;

            public void run()
            {
                arrowView.setTranslationX(0.0F);
                arrowView.setAlpha(1.0F);
            }

            
            {
                this$0 = DepartmentNameViewHolder.this;
                super();
            }
        }).translationX(0.0F).alpha(1.0F).start();
_L8:
        return;
_L6:
        arrowView.setTranslationX(0.0F);
        arrowView.setAlpha(1.0F);
        arrowView.setVisibility(0);
        return;
_L4:
        if (flag)
        {
            arrowView.animate().withStartAction(new Runnable() {

                final DepartmentNameViewHolder this$0;

                public void run()
                {
                    arrowView.setTranslationX(0.0F);
                }

            
            {
                this$0 = DepartmentNameViewHolder.this;
                super();
            }
            }).withEndAction(new Runnable() {

                final DepartmentNameViewHolder this$0;

                public void run()
                {
                    arrowView.setVisibility(4);
                    arrowView.setAlpha(1.0F);
                    arrowView.setTranslationX(0.0F);
                }

            
            {
                this$0 = DepartmentNameViewHolder.this;
                super();
            }
            }).translationX(-arrowView.getResources().getDimensionPixelSize(0x7f090207)).alpha(0.0F).start();
            return;
        } else
        {
            arrowView.setTranslationX(0.0F);
            arrowView.setAlpha(1.0F);
            arrowView.setVisibility(4);
            return;
        }
_L2:
        if (arrowView.getVisibility() == 0)
        {
            arrowView.setVisibility(4);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof DepartmentNameViewModel)
        {
            viewmodel = (DepartmentNameViewModel)viewmodel;
            Channel channel = ((DepartmentNameViewModel) (viewmodel)).channel;
            currentChannel = channel;
            isArrowEnabled = ((DepartmentNameViewModel) (viewmodel)).hasDisclosureArrow;
            isArrowVisible = false;
            nameView.setText(channel.displayName.content);
            if (((DepartmentNameViewModel) (viewmodel)).position == 0)
            {
                itemView.measure(0, 0);
                itemView.setPaddingRelative((screenWidth - nameView.getMeasuredWidth()) / 2, nameView.getPaddingTop(), nameView.getPaddingEnd(), nameView.getPaddingBottom());
            } else
            if (((DepartmentNameViewModel) (viewmodel)).position + 1 == ((DepartmentNameViewModel) (viewmodel)).size)
            {
                itemView.measure(0, 0);
                itemView.setPaddingRelative(defaultSeparatorSize, nameView.getPaddingTop(), screenWidth / 2 - (arrowView.getMeasuredWidth() + nameView.getMeasuredWidth() / 2), nameView.getPaddingBottom());
            } else
            {
                itemView.setPadding(defaultSeparatorSize, nameView.getPaddingTop(), nameView.getPaddingEnd(), nameView.getPaddingBottom());
            }
            setSelected(((DepartmentNameViewModel) (viewmodel)).isSelected);
        }
    }

    public Channel getChannel()
    {
        return currentChannel;
    }

    public boolean isValid()
    {
        return itemView != null && nameView != null && arrowView != null;
    }

    public void setArrowVisible(boolean flag, boolean flag1)
    {
        isArrowVisible = flag;
        updateOpenCloseToggle(flag1);
    }

    public void setSelected(boolean flag)
    {
        TextView textview = nameView;
        int i;
        if (flag)
        {
            i = selectedColor;
        } else
        {
            i = unselectedColor;
        }
        textview.setTextColor(i);
        setArrowVisible(flag, true);
    }
}
