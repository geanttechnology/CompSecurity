// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            BreadcrumbAdapter

public class BreadcrumbContainer extends LinearLayout
    implements FilterChangeListener
{

    private BreadcrumbAdapter adapter;
    private boolean addCommas;
    private LayoutInflater layoutInflater;
    private CharSequence leadText;

    public BreadcrumbContainer(Context context)
    {
        super(context);
    }

    public BreadcrumbContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer);
        addCommas = context.getBoolean(com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_addCommas, false);
        leadText = context.getText(com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_leadText);
        context.recycle();
    }

    public void onFilterChange(Object obj)
    {
        update(obj);
    }

    public void setAdapter(BreadcrumbAdapter breadcrumbadapter)
    {
        adapter = breadcrumbadapter;
        breadcrumbadapter.setLeadText(leadText);
        breadcrumbadapter.setAddCommas(addCommas);
    }

    public void update(Object obj)
    {
        removeAllViews();
        if (layoutInflater == null)
        {
            layoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        }
        adapter.addViews(layoutInflater, this, obj);
    }
}
