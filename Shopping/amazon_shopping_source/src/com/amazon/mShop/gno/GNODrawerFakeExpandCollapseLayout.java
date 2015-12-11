// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.amazon.mShop.anim.ExpandCollapseAnimation;
import com.amazon.mShop.util.LayoutUtils;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItem, GNODebugSettingsActivity

public class GNODrawerFakeExpandCollapseLayout extends FrameLayout
{

    private Context mContext;
    private int mGNOChildrenCount;
    private int mHeight;
    private LinearLayout mLayoutDelegate;

    public GNODrawerFakeExpandCollapseLayout(Context context)
    {
        super(context);
        mContext = context;
        mLayoutDelegate = new LinearLayout(context);
        mLayoutDelegate.setOrientation(1);
        mLayoutDelegate.setBackgroundColor(context.getResources().getColor(com.amazon.mShop.android.lib.R.color.gno_menu_sub_item_background));
        mLayoutDelegate.setLayoutParams(new android.widget.LinearLayout.LayoutParams(LayoutUtils.fillWidthWrapHeight()));
        addView(mLayoutDelegate);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final GNODrawerFakeExpandCollapseLayout this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = GNODrawerFakeExpandCollapseLayout.this;
                super();
            }
        });
    }

    public void setItems(Collection collection)
    {
        mLayoutDelegate.getLayoutParams().height = -2;
        mLayoutDelegate.removeAllViews();
        boolean flag = true;
        boolean flag1 = true;
        for (Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            GNODrawerItem gnodraweritem = (GNODrawerItem)iterator.next();
            if (!flag && flag1 && gnodraweritem.allowDividers())
            {
                View view = View.inflate(mContext, com.amazon.mShop.android.lib.R.layout.gno_drawer_sub_item_divider, null);
                mLayoutDelegate.addView(view);
            }
            View view1 = gnodraweritem.getView(null, this);
            mLayoutDelegate.addView(view1);
            flag = false;
            flag1 = gnodraweritem.allowDividers();
        }

        measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        mHeight = getMeasuredHeight();
        mGNOChildrenCount = collection.size();
    }

    public void startExpandCollapseAnimation(boolean flag, boolean flag1, final Runnable endAction)
    {
        Object obj = mLayoutDelegate;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj = new ExpandCollapseAnimation(((View) (obj)), i, mHeight, flag1, (long)mGNOChildrenCount * GNODebugSettingsActivity.getAnimationDurationMillis(mContext, flag));
        if (flag)
        {
            mLayoutDelegate.getLayoutParams().height = 1;
            ((ExpandCollapseAnimation) (obj)).setMinHeight(1);
        }
        ((ExpandCollapseAnimation) (obj)).setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final GNODrawerFakeExpandCollapseLayout this$0;
            final Runnable val$endAction;

            public void onAnimationEnd(Animation animation)
            {
                if (endAction != null)
                {
                    endAction.run();
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = GNODrawerFakeExpandCollapseLayout.this;
                endAction = runnable;
                super();
            }
        });
        mLayoutDelegate.startAnimation(((Animation) (obj)));
    }
}
