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
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.searchapp.retailsearch.model.Domain;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupAdapter, SpinnerHiderRelativeLayout, RefinementType, RefinementGroupType

public class DDSLocationAdapter extends RefinementGroupAdapter
{

    public static final String ID = com/amazon/retailsearch/android/ui/refinements/DDSLocationAdapter.getName();
    private String currentValue;
    private List domains;
    private RefinementType refinementType;
    private String title;

    public DDSLocationAdapter(Context context, RefinementType refinementtype, List list, String s, String s1)
    {
        super(context);
        refinementType = refinementtype;
        domains = list;
        title = s;
        currentValue = s1;
    }

    public Domain getChild(int i)
    {
        if (i == 0)
        {
            return null;
        } else
        {
            return (Domain)domains.get(i - 1);
        }
    }

    public volatile Object getChild(int i)
    {
        return getChild(i);
    }

    public String getChildUrl(int i)
    {
        return null;
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        view = ((View) (obj));
        if (obj == null)
        {
            view = UIUtils.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_child_dds, viewgroup, false);
        }
        obj = (LinearLayout)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title);
        TextView textview = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title_text);
        View view1 = ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title_divider_left);
        View view2 = ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title_divider_right);
        viewgroup = (LinearLayout)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_address);
        TextView textview1 = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_address_text);
        ImageView imageview = (ImageView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_dds_address_check_box);
        SpinnerHiderRelativeLayout spinnerhiderrelativelayout = (SpinnerHiderRelativeLayout)ViewHolder.get(view, com.amazon.retailsearch.R.id.refinements_child_spinner);
        divider = ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_divider);
        ((LinearLayout) (obj)).setVisibility(8);
        view1.setVisibility(8);
        view2.setVisibility(8);
        viewgroup.setVisibility(8);
        spinnerhiderrelativelayout.setVisibility(8);
        divider.setVisibility(8);
        int k = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_padding_left);
        int l = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_padding_right);
        int i1 = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_address_padding_next);
        int j1 = getChildrenCount() - 1;
        if (i == 0)
        {
            if (title == null)
            {
                viewgroup = "";
            } else
            {
                viewgroup = title;
            }
            textview.setText(viewgroup);
            ((LinearLayout) (obj)).setVisibility(0);
            return view;
        }
        obj = ((Domain)domains.get(i - 1)).getLabel();
        textview1.setText(((CharSequence) (obj)));
        viewgroup.setVisibility(0);
        flag = ((String) (obj)).equals(currentValue);
        obj = context.getResources();
        int j;
        if (flag)
        {
            j = com.amazon.retailsearch.R.drawable.rs_radiobox_filled;
        } else
        {
            j = com.amazon.retailsearch.R.drawable.rs_radiobox;
        }
        imageview.setImageDrawable(((Resources) (obj)).getDrawable(j));
        obj = new android.widget.LinearLayout.LayoutParams(-1, -1);
        if (j1 == 1)
        {
            ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(k, i1, l, i1);
            UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_refinement_address_box));
        } else
        if (i == 1)
        {
            ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(k, i1, l, 0);
            UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_top));
        } else
        if (i == j1)
        {
            ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(k, 0, l, i1);
            UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_bottom));
        } else
        {
            ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(k, 0, l, 0);
            UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_middle));
        }
        textview1.setBackgroundColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_dds_address_background));
        viewgroup.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        return view;
    }

    public int getChildrenCount()
    {
        if (domains == null)
        {
            return 0;
        } else
        {
            return domains.size() + 1;
        }
    }

    public volatile Object getData()
    {
        return getData();
    }

    public List getData()
    {
        return domains;
    }

    public List getDomains(int i)
    {
        if (i == 0 || domains == null && domains.size() < i - 1)
        {
            return null;
        } else
        {
            return ((Domain)domains.get(i - 1)).getDomains();
        }
    }

    public String getId()
    {
        return ID;
    }

    public RefinementGroupType getType()
    {
        return refinementType.getRefinementGroupType();
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getView(flag, view, viewgroup);
        viewgroup = new StyledSpannableString(context);
        viewgroup.append(resources.getText(com.amazon.retailsearch.R.string.rs_refinement_menu_dds_back));
        groupTitle.setText(viewgroup);
        setDefaultGroupViewsStyle();
        groupTitle.setVisibility(0);
        groupIndicator.setVisibility(8);
        groupContent.setVisibility(0);
        groupIcon.setVisibility(0);
        return view;
    }

    public boolean isChildEnabled(int i)
    {
        return i != 0;
    }

    public void setRefinementType(RefinementType refinementtype, List list, String s, String s1)
    {
        refinementType = refinementtype;
        domains = list;
        title = s;
        currentValue = s1;
    }

}
