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
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.DealsBadgeView;
import com.target.ui.view.QuantitySpinnerView;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            BaseListItemView

public class ListItemMapView extends BaseListItemView
{
    public static interface a
    {

        public abstract void b(ListDetailItem listdetailitem);
    }


    private boolean mClicked;
    private a mListener;

    public ListItemMapView(Context context)
    {
        super(context);
        e();
    }

    public ListItemMapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e();
    }

    public ListItemMapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        e();
    }

    static a a(ListItemMapView listitemmapview)
    {
        return listitemmapview.mListener;
    }

    private void e()
    {
        mViews.quantitySpinner.setVisibility(8);
        mViews.editTitleText.setVisibility(8);
        mViews.dealsBadge.setVisibility(8);
        mViews.gripper.setVisibility(8);
        mViews.aisleLocationView.setVisibility(8);
    }

    public void a(ListDetailItem listdetailitem, a a1)
    {
        super.a(listdetailitem);
        mClicked = false;
        mListener = a1;
        setupSelectedCheckboxView(false);
        mViews.layout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListItemMapView this$0;

            public void onClick(View view)
            {
                d();
            }

            
            {
                this$0 = ListItemMapView.this;
                super();
            }
        });
    }

    protected void c()
    {
        if (mClicked)
        {
            return;
        } else
        {
            mClicked = true;
            Object obj = mViews.titleTextView;
            mViews.titleTextView.setPaintFlags(((TextView) (obj)).getPaintFlags() | 0x10);
            mViews.selectedCheckBox.setChecked(true);
            obj = ObjectAnimator.ofFloat(mViews.layout, View.ALPHA, new float[] {
                1.0F, 0.0F
            });
            ((ObjectAnimator) (obj)).setStartDelay(300L);
            ((ObjectAnimator) (obj)).setDuration(300L);
            ((ObjectAnimator) (obj)).start();
            ((ObjectAnimator) (obj)).addListener(new AnimatorListenerAdapter() {

                final ListItemMapView this$0;
                final ListDetailItem val$detailListItem;

                public void onAnimationEnd(Animator animator)
                {
                    if (ListItemMapView.a(ListItemMapView.this) != null)
                    {
                        ListItemMapView.a(ListItemMapView.this).b(detailListItem);
                    }
                }

            
            {
                this$0 = ListItemMapView.this;
                detailListItem = listdetailitem;
                super();
            }
            });
            return;
        }
    }

    protected void d()
    {
    }
}
