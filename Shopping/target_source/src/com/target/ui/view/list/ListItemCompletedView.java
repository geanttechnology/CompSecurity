// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.DealsBadgeView;
import com.target.ui.view.QuantitySpinnerView;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            BaseListItemView

public class ListItemCompletedView extends BaseListItemView
{
    public static interface a
    {

        public abstract void a(ListDetailCompletedItem listdetailcompleteditem);
    }


    private boolean mClicked;
    private a mListener;

    public ListItemCompletedView(Context context)
    {
        super(context);
        e();
    }

    public ListItemCompletedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e();
    }

    public ListItemCompletedView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e();
    }

    static a a(ListItemCompletedView listitemcompletedview)
    {
        return listitemcompletedview.mListener;
    }

    private void e()
    {
        mViews.quantitySpinner.setVisibility(8);
        mViews.editTitleText.setVisibility(8);
        mViews.dealsBadge.setVisibility(8);
        mViews.gripper.setVisibility(8);
        mViews.aisleLocationView.setVisibility(8);
    }

    public void a(ListDetailCompletedItem listdetailcompleteditem, a a1)
    {
        super.a(listdetailcompleteditem);
        mClicked = false;
        mListener = a1;
        setupSelectedCheckboxView(false);
        mViews.layout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListItemCompletedView this$0;

            public void onClick(View view)
            {
                d();
            }

            
            {
                this$0 = ListItemCompletedView.this;
                super();
            }
        });
        listdetailcompleteditem = mViews.titleTextView;
        mViews.titleTextView.setPaintFlags(listdetailcompleteditem.getPaintFlags() | 0x10);
        mViews.selectedCheckBox.setChecked(true);
    }

    protected void c()
    {
        d();
    }

    protected void d()
    {
        if (mClicked)
        {
            return;
        } else
        {
            mClicked = true;
            Object obj = mViews.titleTextView;
            mViews.titleTextView.setPaintFlags(((TextView) (obj)).getPaintFlags() & 0xffffffef);
            mViews.selectedCheckBox.setChecked(false);
            obj = ObjectAnimator.ofFloat(mViews.layout, View.ALPHA, new float[] {
                1.0F, 0.0F
            });
            ((ObjectAnimator) (obj)).setStartDelay(300L);
            ((ObjectAnimator) (obj)).setDuration(300L);
            ((ObjectAnimator) (obj)).start();
            ((ObjectAnimator) (obj)).addListener(new AnimatorListenerAdapter() {

                final ListItemCompletedView this$0;
                final ListDetailCompletedItem val$detailListItem;

                public void onAnimationEnd(Animator animator)
                {
                    if (ListItemCompletedView.a(ListItemCompletedView.this) != null)
                    {
                        ListItemCompletedView.a(ListItemCompletedView.this).a(detailListItem);
                    }
                }

            
            {
                this$0 = ListItemCompletedView.this;
                detailListItem = listdetailcompleteditem;
                super();
            }
            });
            return;
        }
    }
}
