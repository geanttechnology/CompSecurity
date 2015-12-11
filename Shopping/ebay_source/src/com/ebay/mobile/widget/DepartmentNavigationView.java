// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.cos.base.Text;
import java.util.Iterator;
import java.util.List;

public class DepartmentNavigationView extends HorizontalScrollView
{

    private static final String TAG_CHILD_GROUP = "departmentCarouselList";
    private final android.widget.LinearLayout.LayoutParams childSizeParams;

    public DepartmentNavigationView(Context context)
    {
        super(context);
        childSizeParams = new android.widget.LinearLayout.LayoutParams(0, -1, 48F);
        initContainer(context);
    }

    public DepartmentNavigationView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        childSizeParams = new android.widget.LinearLayout.LayoutParams(0, -1, 48F);
        initContainer(context);
    }

    public DepartmentNavigationView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        childSizeParams = new android.widget.LinearLayout.LayoutParams(0, -1, 48F);
        initContainer(context);
    }

    private void initContainer(Context context)
    {
        context = new LinearLayout(context);
        context.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1));
        context.setOrientation(0);
        context.setTag("departmentCarouselList");
        addView(context);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag)
        {
            childSizeParams.width = (k - i) / 2;
            ViewGroup viewgroup = (ViewGroup)findViewWithTag("departmentCarouselList");
            if (viewgroup != null && viewgroup.getChildCount() > 0)
            {
                viewgroup.setPaddingRelative((k - i) / 4, 0, (k - i) / 4, 0);
                for (i = 0; i < viewgroup.getChildCount(); i++)
                {
                    viewgroup.getChildAt(i).setLayoutParams(childSizeParams);
                }

                if (!isLayoutRequested())
                {
                    viewgroup.postInvalidate();
                }
            }
        }
    }

    public void setTitles(List list)
    {
        ViewGroup viewgroup;
        if (list != null)
        {
            if ((viewgroup = (ViewGroup)findViewWithTag("departmentCarouselList")) != null)
            {
                viewgroup.removeAllViews();
                TextView textview;
                for (list = list.iterator(); list.hasNext(); viewgroup.addView(textview))
                {
                    Channel channel = (Channel)list.next();
                    textview = new TextView(getContext());
                    textview.setLayoutParams(childSizeParams);
                    textview.setText(channel.displayName.content);
                    textview.setGravity(17);
                    textview.setTextAppearance(getContext(), 0x7f0a014b);
                }

                if (!isLayoutRequested())
                {
                    viewgroup.postInvalidate();
                    return;
                }
            }
        }
    }
}
