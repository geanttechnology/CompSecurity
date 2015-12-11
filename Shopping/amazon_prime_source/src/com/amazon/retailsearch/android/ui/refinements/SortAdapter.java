// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.SelectedOption;
import com.amazon.searchapp.retailsearch.model.Sort;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupAdapter, RefinementGroupType

public class SortAdapter extends RefinementGroupAdapter
{

    public static String ID = com/amazon/retailsearch/android/ui/refinements/SortAdapter.getName();
    private Sort sort;

    public SortAdapter(Context context, Sort sort1)
    {
        super(context);
        sort = sort1;
    }

    public boolean containsChild(String s)
    {
        return getChildPosition(s) != -1;
    }

    public SelectedOption getChild(int i)
    {
        if (sort != null && sort.getOptions() != null && sort.getOptions().size() != 0)
        {
            return (SelectedOption)sort.getOptions().get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getChild(int i)
    {
        return getChild(i);
    }

    public int getChildPosition(String s)
    {
        if (sort != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
        Iterator iterator = sort.getOptions().iterator();
label0:
        do
        {
label1:
            {
                if (!iterator.hasNext())
                {
                    break label1;
                }
                j = i;
                if (s.equals(((SelectedOption)iterator.next()).getId()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public String getChildUrl(int i)
    {
        SelectedOption selectedoption = getChild(i);
        if (selectedoption == null || selectedoption.getLink() == null)
        {
            return null;
        } else
        {
            return selectedoption.getLink().getUrl();
        }
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getChildView(i, flag, view, viewgroup);
        viewgroup = getChild(i);
        if (viewgroup != null)
        {
            flag = viewgroup.getSelected();
            childTitle.setText(viewgroup.getLink().getText());
            setDefaultChildViewsStyle(flag, isChildEnabled(i), false);
        }
        return view;
    }

    public int getChildrenCount()
    {
        if (sort != null && sort.getOptions() != null && sort.getOptions().size() != 0)
        {
            return sort.getOptions().size();
        } else
        {
            return 0;
        }
    }

    public Object getData()
    {
        return sort;
    }

    public String getId()
    {
        return ID;
    }

    public RefinementGroupType getType()
    {
        return RefinementGroupType.SORT;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = super.getView(flag, view, viewgroup);
        view = new StyledSpannableString(context);
        view.append(resources.getString(com.amazon.retailsearch.R.string.refine_sort));
        groupTitle.setText(view);
        setDefaultGroupViewsStyle();
        groupTitle.setVisibility(0);
        view = null;
        Iterator iterator = sort.getOptions().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SelectedOption selectedoption = (SelectedOption)iterator.next();
            if (selectedoption != null && selectedoption.getSelected() && selectedoption.getLink() != null && selectedoption.getLink().getText() != null)
            {
                view = selectedoption.getLink().getText();
            }
        } while (true);
        if (!TextUtils.isEmpty(view))
        {
            groupSubTitle.setText(view);
            groupSubTitle.setTextSize(0, resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
            groupSubTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
            groupSubTitle.setVisibility(0);
        }
        setDefaultGroupIndicatorStyle(flag);
        groupContent.setVisibility(0);
        return viewgroup;
    }

    public boolean isChildEnabled(int i)
    {
        SelectedOption selectedoption = getChild(i);
        return selectedoption != null && !selectedoption.getSelected();
    }

    public boolean isChildSelected(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        SelectedOption selectedoption;
        Iterator iterator = sort.getOptions().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            selectedoption = (SelectedOption)iterator.next();
        } while (!s.equals(selectedoption.getId()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return selectedoption.getSelected();
    }

}
