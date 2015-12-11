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
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupAdapter, RefinementGroupType

public class DepartmentAdapter extends RefinementGroupAdapter
{

    public static String ID = com/amazon/retailsearch/android/ui/refinements/DepartmentAdapter.getName();
    private int ancestryDepartmentSize;
    private Department department;

    public DepartmentAdapter(Context context, Department department1)
    {
        super(context);
        department = department1;
        int i;
        if (department1 == null || department1.getAncestry() == null)
        {
            i = 0;
        } else
        {
            i = department1.getAncestry().size();
        }
        ancestryDepartmentSize = i;
    }

    public boolean containsChild(String s)
    {
        return getChildPosition(s) != -1;
    }

    public RefinementLink getChild(int i)
    {
        if (department != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (i >= ancestryDepartmentSize)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (department.getAncestry() == null) goto _L1; else goto _L3
_L3:
        return (RefinementLink)department.getAncestry().get(i);
        if (department.getCategories() == null) goto _L1; else goto _L4
_L4:
        return (RefinementLink)department.getCategories().get(i - ancestryDepartmentSize);
    }

    public volatile Object getChild(int i)
    {
        return getChild(i);
    }

    public int getChildPosition(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int k = -1;
_L4:
        return k;
_L2:
        k = 0;
        int i = 0;
        if (!Utils.isEmpty(department.getAncestry()))
        {
            Iterator iterator = department.getAncestry().iterator();
            do
            {
                k = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                k = i;
                if (s.equals(((RefinementLink)iterator.next()).getId()))
                {
                    continue; /* Loop/switch isn't completed */
                }
                i++;
            } while (true);
        }
label0:
        {
            if (Utils.isEmpty(department.getCategories()))
            {
                break label0;
            }
            Iterator iterator1 = department.getCategories().iterator();
            int j = k;
            do
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                k = j;
                if (s.equals(((RefinementLink)iterator1.next()).getId()))
                {
                    break;
                }
                j++;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public String getChildUrl(int i)
    {
        RefinementLink refinementlink = getChild(i);
        if (refinementlink == null)
        {
            return null;
        } else
        {
            return refinementlink.getUrl();
        }
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getChildView(i, flag, view, viewgroup);
        viewgroup = getChild(i);
        flag = false;
        if (viewgroup != null)
        {
            if (i >= ancestryDepartmentSize)
            {
                childTitle.setPadding(resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_27px), 0, 0, 0);
            }
            childTitle.setText(viewgroup.getText());
            flag = viewgroup.getSelected();
        }
        setDefaultChildViewsStyle(flag, isChildEnabled(i), false);
        return view;
    }

    public int getChildrenCount()
    {
        int i = 0;
        if (department.getCategories() != null)
        {
            i = 0 + department.getCategories().size();
        }
        int j = i;
        if (department.getAncestry() != null)
        {
            j = i + department.getAncestry().size();
        }
        return j;
    }

    public Object getData()
    {
        return department;
    }

    public String getId()
    {
        return ID;
    }

    public RefinementGroupType getType()
    {
        return RefinementGroupType.DEPARTMENT;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getView(flag, view, viewgroup);
        viewgroup = new StyledSpannableString(context);
        viewgroup.append(resources.getString(com.amazon.retailsearch.R.string.select_department));
        groupTitle.setText(viewgroup);
        setDefaultGroupViewsStyle();
        groupTitle.setVisibility(0);
        viewgroup = department.getAncestry();
        if (viewgroup != null && viewgroup.size() > 0)
        {
            viewgroup = ((RefinementLink)viewgroup.get(viewgroup.size() - 1)).getText();
            if (!TextUtils.isEmpty(viewgroup))
            {
                groupSubTitle.setText(viewgroup);
                groupSubTitle.setTextSize(0, resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
                groupSubTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
                groupSubTitle.setVisibility(0);
            }
        }
        setDefaultGroupIndicatorStyle(flag);
        groupContent.setVisibility(0);
        return view;
    }

    public boolean isChildEnabled(int i)
    {
        for (RefinementLink refinementlink = getChild(i); refinementlink == null || TextUtils.isEmpty(refinementlink.getUrl()) || refinementlink.getSelected();)
        {
            return false;
        }

        return true;
    }

    public boolean isChildSelected(String s)
    {
        Object obj = department.getAncestry();
        if (!Utils.isEmpty(((java.util.Collection) (obj))) && !TextUtils.isEmpty(s))
        {
            if ((obj = (RefinementLink)((List) (obj)).get(((List) (obj)).size() - 1)) != null && ((RefinementLink) (obj)).getSelected() && s.equals(((RefinementLink) (obj)).getId()))
            {
                return true;
            }
        }
        return false;
    }

}
