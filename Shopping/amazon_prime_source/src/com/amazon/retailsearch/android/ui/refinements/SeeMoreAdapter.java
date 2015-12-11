// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupAdapter, RefinementGroupType

public class SeeMoreAdapter extends RefinementGroupAdapter
{

    public static String ID = com/amazon/retailsearch/android/ui/refinements/SeeMoreAdapter.getName();

    public SeeMoreAdapter(Context context)
    {
        super(context);
    }

    public Object getChild(int i)
    {
        return null;
    }

    public String getChildUrl(int i)
    {
        return null;
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        return null;
    }

    public int getChildrenCount()
    {
        return 0;
    }

    public Object getData()
    {
        return null;
    }

    public String getId()
    {
        return ID;
    }

    public RefinementGroupType getType()
    {
        return RefinementGroupType.SEEMORE;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getView(flag, view, viewgroup);
        viewgroup = new StyledSpannableString(context);
        viewgroup.append(resources.getString(com.amazon.retailsearch.R.string.rs_refinement_menu_see_more_filters));
        groupTitle.setText(viewgroup);
        groupTitle.setTextSize(0, context.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
        groupTitle.setTextColor(context.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_blue));
        groupTitle.setTypeface(groupTitle.getTypeface(), 0);
        groupTitle.setVisibility(0);
        setDefaultGroupIndicatorStyle(flag);
        groupContent.setVisibility(0);
        return view;
    }

    public boolean isChildEnabled(int i)
    {
        return false;
    }

    public boolean isEnabled()
    {
        return true;
    }

}
