// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.ViewHolder;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            GroupAdapter

public abstract class RefinementGroupAdapter
    implements GroupAdapter
{

    protected ImageView childIndicator;
    protected TextView childTitle;
    protected Context context;
    protected LinearLayout ddsLayout;
    protected View divider;
    protected LinearLayout groupContent;
    protected View groupDivider;
    protected ImageView groupIcon;
    protected ImageView groupIndicator;
    protected TextView groupSubTitle;
    protected TextView groupTitle;
    protected LinearLayout regularLayout;
    protected Resources resources;

    public RefinementGroupAdapter(Context context1)
    {
        context = context1;
        resources = context1.getResources();
    }

    public boolean containsChild(String s)
    {
        return false;
    }

    public int getChildPosition(String s)
    {
        return 0;
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = UIUtils.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_child_regular, viewgroup, false);
        }
        divider = ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_divider);
        childTitle = (TextView)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_label);
        childTitle.setPadding(resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_18px), 0, 0, 0);
        childIndicator = (ImageView)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_indicator);
        childIndicator.setVisibility(8);
        return view1;
    }

    public String getUrl()
    {
        return null;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
label0:
        {
            View view1 = view;
            if (view1 != null)
            {
                view = view1;
                if (view1.getId() == com.amazon.retailsearch.R.id.rs_refinement_group_layout)
                {
                    break label0;
                }
            }
            view = View.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_group, null);
        }
        groupDivider = ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_group_divider);
        groupContent = (LinearLayout)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinement_group_content);
        groupTitle = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinement_label);
        groupSubTitle = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinement_selected_label);
        groupIndicator = (ImageView)view.findViewById(com.amazon.retailsearch.R.id.rs_refinements_group_indicator);
        groupIcon = (ImageView)view.findViewById(com.amazon.retailsearch.R.id.rs_refinement_group_icon);
        groupTitle.setVisibility(8);
        groupSubTitle.setVisibility(8);
        groupContent.setVisibility(8);
        groupIndicator.setVisibility(8);
        groupIcon.setVisibility(8);
        viewgroup = groupDivider.getLayoutParams();
        viewgroup.height = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_1px);
        groupDivider.setLayoutParams(viewgroup);
        return view;
    }

    public boolean isChildSelected(String s)
    {
        return false;
    }

    public boolean isEnabled()
    {
        return true;
    }

    protected void setDefaultChildViewsStyle(boolean flag, boolean flag1, boolean flag2)
    {
        if (flag)
        {
            childTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_child_text_selected));
            childTitle.setContentDescription((new StringBuilder()).append(childTitle.getText()).append(". ").append(resources.getString(com.amazon.retailsearch.R.string.refine_selected)).toString());
            return;
        }
        if (!flag1)
        {
            childTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_gray));
            childIndicator.setVisibility(8);
            childTitle.setContentDescription((new StringBuilder()).append(childTitle.getText()).append(". ").append(resources.getString(com.amazon.retailsearch.R.string.refine_disabled)).toString());
            return;
        }
        if (flag2)
        {
            childTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_link_text));
        } else
        {
            childTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
        }
        childTitle.setContentDescription(childTitle.getText());
    }

    protected void setDefaultGroupIndicatorStyle(boolean flag)
    {
        if (getChildrenCount() <= 0)
        {
            groupIndicator.setVisibility(8);
            return;
        }
        if (flag)
        {
            groupIndicator.setImageDrawable(resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_arrow_up));
        } else
        {
            groupIndicator.setImageDrawable(resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_arrow_down));
        }
        groupIndicator.setVisibility(0);
    }

    protected void setDefaultGroupViewsStyle()
    {
        groupTitle.setTextSize(0, resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_header));
        groupTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_group_header));
        groupTitle.setTypeface(groupTitle.getTypeface(), 1);
    }
}
