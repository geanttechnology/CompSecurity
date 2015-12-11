// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.adapter.list.a;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.DealsBadgeView;
import com.target.ui.view.QuantitySpinnerView;
import com.target.ui.view.TargetImeEditText;

public abstract class BaseListItemView extends RelativeLayout
    implements com.target.ui.adapter.list.a
{
    protected static class a
    {

        AisleBadgeView aisleLocationView;
        View blockerView;
        DealsBadgeView dealsBadge;
        TargetImeEditText editTitleText;
        ImageView gripper;
        RelativeLayout layout;
        QuantitySpinnerView quantitySpinner;
        CheckBox selectedCheckBox;
        TextView titleTextView;

        public a(View view)
        {
            layout = (RelativeLayout)view.findViewById(0x7f1002a8);
            quantitySpinner = (QuantitySpinnerView)view.findViewById(0x7f1002ac);
            editTitleText = (TargetImeEditText)view.findViewById(0x7f1002ad);
            selectedCheckBox = (CheckBox)view.findViewById(0x7f1002ae);
            titleTextView = (TextView)view.findViewById(0x7f1002aa);
            dealsBadge = (DealsBadgeView)view.findViewById(0x7f1002af);
            aisleLocationView = (AisleBadgeView)view.findViewById(0x7f1002b0);
            blockerView = view.findViewById(0x7f1002b1);
            gripper = (ImageView)view.findViewById(0x7f1002a9);
        }
    }


    protected static final long LONG_INTERVAL = 600L;
    protected static final long REALLY_SHORT_INTERVAL = 100L;
    protected static final long SHORT_INTERVAL = 300L;
    public static final String TAG = "ListItemView";
    protected ListDetailItem mItem;
    protected a mViews;

    public BaseListItemView(Context context)
    {
        super(context);
        e();
    }

    public BaseListItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e();
    }

    public BaseListItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e();
    }

    private void e()
    {
        mViews = new a(inflate(getContext(), 0x7f0300d7, this));
    }

    public void a()
    {
        mViews.blockerView.setVisibility(8);
    }

    protected void a(ListDetailItem listdetailitem)
    {
        mItem = listdetailitem;
        mViews.blockerView.setVisibility(8);
        mViews.layout.setAlpha(1.0F);
        b();
    }

    protected void b()
    {
        TextView textview = mViews.titleTextView;
        int i = mItem.h();
        StringBuffer stringbuffer = new StringBuffer();
        if (i > 1)
        {
            stringbuffer.append(Integer.valueOf(i)).append(" x ");
        }
        stringbuffer.append(mItem.b());
        mViews.titleTextView.setText(stringbuffer);
        if (mItem.c() || mItem.d())
        {
            textview.setPaintFlags(textview.getPaintFlags() | 0x10);
            mViews.selectedCheckBox.setChecked(true);
            mViews.selectedCheckBox.jumpDrawablesToCurrentState();
            return;
        } else
        {
            textview.setPaintFlags(textview.getPaintFlags() & 0xffffffef);
            mViews.selectedCheckBox.setChecked(false);
            mViews.selectedCheckBox.jumpDrawablesToCurrentState();
            return;
        }
    }

    protected abstract void c();

    protected abstract void d();

    protected void setupSelectedCheckboxView(boolean flag)
    {
        mViews.selectedCheckBox.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseListItemView this$0;

            public void onClick(View view)
            {
                if (mItem.k())
                {
                    return;
                } else
                {
                    mItem.d(true);
                    c();
                    return;
                }
            }

            
            {
                this$0 = BaseListItemView.this;
                super();
            }
        });
        if (flag)
        {
            mViews.selectedCheckBox.setVisibility(4);
            return;
        } else
        {
            mViews.selectedCheckBox.setVisibility(0);
            return;
        }
    }
}
