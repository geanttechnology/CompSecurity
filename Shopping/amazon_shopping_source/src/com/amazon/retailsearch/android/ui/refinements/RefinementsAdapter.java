// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.RefinementFilter;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.SelectedOption;
import com.amazon.searchapp.retailsearch.model.Sort;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RefinementsAdapter extends com.amazon.retailsearch.android.ui.AnimatedExpandableListView.AnimatedExpandableListAdapter
{
    private static final class GroupSection extends Enum
    {

        private static final GroupSection $VALUES[];
        public static final GroupSection Department;
        public static final GroupSection Filter;
        public static final GroupSection PrioritizedFilter;
        public static final GroupSection SeeMore;
        public static final GroupSection Sort;
        public static final GroupSection Unknown;

        public static GroupSection valueOf(String s)
        {
            return (GroupSection)Enum.valueOf(com/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection, s);
        }

        public static GroupSection[] values()
        {
            return (GroupSection[])$VALUES.clone();
        }

        static 
        {
            PrioritizedFilter = new GroupSection("PrioritizedFilter", 0);
            Department = new GroupSection("Department", 1);
            Sort = new GroupSection("Sort", 2);
            Filter = new GroupSection("Filter", 3);
            SeeMore = new GroupSection("SeeMore", 4);
            Unknown = new GroupSection("Unknown", 5);
            $VALUES = (new GroupSection[] {
                PrioritizedFilter, Department, Sort, Filter, SeeMore, Unknown
            });
        }

        private GroupSection(String s, int i)
        {
            super(s, i);
        }
    }

    protected class RefinementItem
    {

        private String detail;
        private String id;
        private String label;
        final RefinementsAdapter this$0;
        private String type;

        public String getDetail()
        {
            return detail;
        }

        public String getId()
        {
            return id;
        }

        public String getLabel()
        {
            return label;
        }

        public String getType()
        {
            return type;
        }

        public void setDetail(String s)
        {
            detail = s;
        }

        public void setId(String s)
        {
            id = s;
        }

        public void setLabel(String s)
        {
            label = s;
        }

        public void setType(String s)
        {
            type = s;
        }

        protected RefinementItem()
        {
            this$0 = RefinementsAdapter.this;
            super();
        }
    }


    private static final String FILTER_TYPE_ADDRESS = "Address";
    private static final String FILTER_TYPE_MULTI = "MultiSelectOR";
    public static final String ID_DEPARTMENT = "dept";
    public static final String ID_SEEMORE_FILTERS = "seeMoreFilters";
    public static final String ID_SORT = "sort";
    public static final long REFINEMENT_LINK_CHILD_ID = 3L;
    public static final long SELECTED_OPTION_CHILD_ID = 4L;
    private final int ancestryDepartmentSize;
    private final Context mContext;
    private final Department mDepartment;
    private final List mFilters = new ArrayList();
    private final List mPrioritizedFilters = new ArrayList();
    private final Resources mResources;
    private final Sort mSort;
    UserPreferenceManager preferencesManager;
    Lazy retailSearchDataProvider;
    private final ViewType viewType;

    public RefinementsAdapter(Department department, List list, Sort sort, List list1, Context context)
    {
        RetailSearchDaggerGraphController.inject(this);
        mDepartment = department;
        int i;
        if (mDepartment.getAncestry() == null)
        {
            i = 0;
        } else
        {
            i = mDepartment.getAncestry().size();
        }
        ancestryDepartmentSize = i;
        splitFilters(list, list1, mFilters, mPrioritizedFilters);
        mSort = sort;
        mContext = context;
        mResources = context.getResources();
        viewType = preferencesManager.getViewType();
    }

    private int filterOffset()
    {
        int i;
        int j;
        if (mDepartment == null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (mSort == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        return i + j + mPrioritizedFilters.size();
    }

    private String getFilterLabelText(RefinementFilter refinementfilter)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag1 = false;
        boolean flag = false;
        if (refinementfilter.getValues() != null)
        {
            refinementfilter = refinementfilter.getValues().iterator();
            do
            {
                flag1 = flag;
                if (!refinementfilter.hasNext())
                {
                    break;
                }
                RefinementLink refinementlink = (RefinementLink)refinementfilter.next();
                if (refinementlink != null && refinementlink.getSelected())
                {
                    flag1 = true;
                    flag = flag1;
                    if (!TextUtils.isEmpty(refinementlink.getText()))
                    {
                        if (stringbuilder.length() > 0)
                        {
                            stringbuilder.append(", ");
                        }
                        stringbuilder.append(refinementlink.getText());
                        flag = flag1;
                    }
                }
            } while (true);
        }
        if (flag1 && stringbuilder.length() < 1)
        {
            return mResources.getString(com.amazon.retailsearch.R.string.refine_selected);
        } else
        {
            return stringbuilder.toString().trim();
        }
    }

    private SpannableStringBuilder getFilterMessage(TextView textview, RefinementLink refinementlink)
    {
        textview = new StyledSpannableString(viewType, mContext);
        if (refinementlink != null)
        {
            List list = refinementlink.getStyleText();
            if (list != null && list.size() > 0)
            {
                int i;
                if (list.size() > 1)
                {
                    i = com.amazon.retailsearch.R.style.Rs_Refinement_ChildPanel_Header_MultiText;
                } else
                {
                    i = com.amazon.retailsearch.R.style.Rs_Refinement_ChildPanel_Header;
                }
                textview.append(list, i);
                return textview;
            }
            if (!TextUtils.isEmpty(refinementlink.getText()))
            {
                textview.append(refinementlink.getText());
                return textview;
            }
        }
        return textview;
    }

    private int getFilterSize(RefinementFilter refinementfilter)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (refinementfilter != null)
        {
            i = ((flag) ? 1 : 0);
            if (refinementfilter.getValues() != null)
            {
                int j = refinementfilter.getValues().size();
                i = j;
                if (refinementfilter.getClearLink() != null)
                {
                    i = j + 1;
                }
            }
        }
        return i;
    }

    private GroupSection getGroupSection(int i)
    {
        boolean flag = false;
        int k = mPrioritizedFilters.size() - 1;
        if (i <= k)
        {
            return GroupSection.PrioritizedFilter;
        }
        int j;
        if (mDepartment == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        k += j;
        if (i == k)
        {
            return com.amazon.retailsearch.android.ui.refinements.GroupSection.Department;
        }
        if (mSort == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 1;
        }
        j = k + j;
        if (i == j)
        {
            return com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort;
        }
        j += mFilters.size();
        if (i <= j)
        {
            return GroupSection.Filter;
        }
        if (i == j + 1)
        {
            return GroupSection.SeeMore;
        } else
        {
            return GroupSection.Unknown;
        }
    }

    private String getRefinementID(RefinementFilter refinementfilter)
    {
        if (refinementfilter == null)
        {
            return null;
        }
        if (refinementfilter.getId() == null)
        {
            return refinementfilter.getLabel();
        } else
        {
            return refinementfilter.getId();
        }
    }

    private RefinementLink getRefinementLink(RefinementFilter refinementfilter, int i)
    {
        int j = i;
        if (refinementfilter.getClearLink() != null)
        {
            j = i - 1;
        }
        if (j == -1)
        {
            return refinementfilter.getClearLink();
        } else
        {
            return (RefinementLink)refinementfilter.getValues().get(j);
        }
    }

    private String getSelectedLabelText(int i)
    {
label0:
        {
            Object obj = getGroupSection(i);
            if (obj == com.amazon.retailsearch.android.ui.refinements.GroupSection.Department)
            {
                if (mDepartment != null)
                {
                    obj = mDepartment.getAncestry();
                    if (obj != null && ((List) (obj)).size() > 0)
                    {
                        return ((RefinementLink)((List) (obj)).get(((List) (obj)).size() - 1)).getText();
                    }
                }
                break label0;
            }
            if (obj == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
            {
                if (mSort == null || mSort.getOptions() == null)
                {
                    break label0;
                }
                obj = mSort.getOptions().iterator();
                SelectedOption selectedoption;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    selectedoption = (SelectedOption)((Iterator) (obj)).next();
                } while (selectedoption == null || !selectedoption.getSelected() || selectedoption.getLink() == null || selectedoption.getLink().getText() == null);
                return selectedoption.getLink().getText();
            }
            if (obj == GroupSection.PrioritizedFilter)
            {
                return getFilterLabelText((RefinementFilter)mPrioritizedFilters.get(i));
            }
            if (obj == GroupSection.Filter)
            {
                return getFilterLabelText((RefinementFilter)mFilters.get(i - filterOffset()));
            }
        }
        return "";
    }

    private boolean isDepartmentSelected()
    {
        List list = mDepartment.getAncestry();
        return list != null && list.size() > 1;
    }

    private void setDepartmentChildView(RefinementLink refinementlink, int i, TextView textview)
    {
        if (i >= ancestryDepartmentSize)
        {
            textview.setPadding(mResources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_27px), 0, 0, 0);
        }
        textview.setText(refinementlink.getText());
    }

    private void splitFilters(List list, List list1, List list2, List list3)
    {
        if (!Utils.isEmpty(list1) && list != null && list.size() != 0)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                RefinementFilter refinementfilter = (RefinementFilter)list.next();
                if (list1.contains(refinementfilter.getId()))
                {
                    list3.add(refinementfilter);
                } else
                {
                    list2.add(refinementfilter);
                }
            }
        }
    }

    public Object getChild(int i, int j)
    {
        GroupSection groupsection = getGroupSection(i);
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Department)
        {
            if (j < ancestryDepartmentSize)
            {
                return mDepartment.getAncestry().get(j);
            } else
            {
                return mDepartment.getCategories().get(j - ancestryDepartmentSize);
            }
        }
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
        {
            return mSort.getOptions().get(j);
        }
        if (groupsection == GroupSection.PrioritizedFilter)
        {
            return getRefinementLink((RefinementFilter)mPrioritizedFilters.get(i), j);
        }
        if (groupsection == GroupSection.Filter)
        {
            return getRefinementLink((RefinementFilter)mFilters.get(i - filterOffset()), j);
        } else
        {
            return null;
        }
    }

    public long getChildId(int i, int j)
    {
        GroupSection groupsection = getGroupSection(i);
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
        {
            return 4L;
        }
        return groupsection != com.amazon.retailsearch.android.ui.refinements.GroupSection.Department && groupsection != GroupSection.Filter && groupsection != GroupSection.PrioritizedFilter ? -1L : 3L;
    }

    public Object getGroup(int i)
    {
        GroupSection groupsection = getGroupSection(i);
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Department)
        {
            return mDepartment;
        }
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
        {
            return mSort;
        }
        if (groupsection == GroupSection.PrioritizedFilter)
        {
            return mPrioritizedFilters.get(i);
        }
        if (groupsection == GroupSection.Filter)
        {
            return mFilters.get(i - filterOffset());
        } else
        {
            return null;
        }
    }

    public int getGroupCount()
    {
        int k = 0;
        int i;
        int j;
        int l;
        int i1;
        if (mDepartment == null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        if (mSort == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        l = mFilters.size();
        i1 = mPrioritizedFilters.size();
        if (!isDepartmentSelected())
        {
            k = 1;
        }
        return i + j + (l + i1) + k;
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public RefinementItem getGroupItem(int i)
    {
        RefinementItem refinementitem = new RefinementItem();
        Object obj = getGroupSection(i);
        if (obj == com.amazon.retailsearch.android.ui.refinements.GroupSection.Department)
        {
            refinementitem.setLabel(mResources.getString(com.amazon.retailsearch.R.string.select_department));
            refinementitem.setId("dept");
        } else
        {
            if (obj == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
            {
                refinementitem.setLabel(mResources.getString(com.amazon.retailsearch.R.string.refine_sort));
                refinementitem.setId("sort");
                return refinementitem;
            }
            if (obj == GroupSection.PrioritizedFilter)
            {
                obj = (RefinementFilter)mPrioritizedFilters.get(i);
                refinementitem.setLabel(((RefinementFilter) (obj)).getLabel());
                refinementitem.setId(((RefinementFilter) (obj)).getId());
                refinementitem.setType(((RefinementFilter) (obj)).getType());
                refinementitem.setDetail(((RefinementFilter) (obj)).getDetail());
                return refinementitem;
            }
            if (obj == GroupSection.Filter)
            {
                int j = filterOffset();
                obj = (RefinementFilter)mFilters.get(i - j);
                refinementitem.setLabel(((RefinementFilter) (obj)).getLabel());
                refinementitem.setId(((RefinementFilter) (obj)).getId());
                refinementitem.setType(((RefinementFilter) (obj)).getType());
                refinementitem.setDetail(((RefinementFilter) (obj)).getDetail());
                return refinementitem;
            }
            if (obj == GroupSection.SeeMore)
            {
                refinementitem.setLabel(mResources.getString(com.amazon.retailsearch.R.string.rs_refinement_menu_see_more_filters));
                refinementitem.setId("seeMoreFilters");
                return refinementitem;
            }
        }
        return refinementitem;
    }

    public int getGroupPosition(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        if ("dept".equals(s))
        {
            return mPrioritizedFilters.size() + 0;
        }
        if ("sort".equals(s))
        {
            return mPrioritizedFilters.size() + 1;
        }
        if ("seeMoreFilters".equals(s))
        {
            return getGroupCount() - 1;
        }
        int j = 0;
        for (Iterator iterator = mPrioritizedFilters.iterator(); iterator.hasNext();)
        {
            i = j;
            if (s.equals(getRefinementID((RefinementFilter)iterator.next())))
            {
                continue; /* Loop/switch isn't completed */
            }
            j++;
        }

        j = filterOffset();
        Iterator iterator1 = mFilters.iterator();
label0:
        do
        {
label1:
            {
                if (!iterator1.hasNext())
                {
                    break label1;
                }
                i = j;
                if (s.equals(getRefinementID((RefinementFilter)iterator1.next())))
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        view = ((View) (obj));
        if (obj == null)
        {
            view = View.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_group, null);
        }
        viewgroup = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinement_label);
        obj = getGroupItem(i);
        Object obj1 = new StyledSpannableString(mContext);
        ((StyledSpannableString) (obj1)).append(((RefinementItem) (obj)).getLabel());
        viewgroup.setText(((CharSequence) (obj1)));
        obj1 = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinement_selected_label);
        String s = getSelectedLabelText(i);
        if (!TextUtils.isEmpty(s))
        {
            ((TextView) (obj1)).setText(s);
            ((TextView) (obj1)).setTextSize(0, mContext.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
            ((TextView) (obj1)).setTextColor(mContext.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
            ((TextView) (obj1)).setVisibility(0);
        } else
        {
            ((TextView) (obj1)).setVisibility(8);
        }
        if (GroupSection.SeeMore == getGroupSection(i))
        {
            viewgroup.setTextSize(0, mContext.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
            viewgroup.setTextColor(mContext.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_blue));
            viewgroup.setTypeface(viewgroup.getTypeface(), 0);
        } else
        if ("Address".equals(((RefinementItem) (obj)).getType()))
        {
            viewgroup.setTextSize(0, mContext.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_address));
            viewgroup.setTextColor(mContext.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
            viewgroup.setTypeface(viewgroup.getTypeface(), 1);
            ((TextView) (obj1)).setText(((RefinementItem) (obj)).getDetail());
            ((TextView) (obj1)).setTextSize(0, mContext.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_address));
            ((TextView) (obj1)).setTextColor(mContext.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_blue));
            ((TextView) (obj1)).setVisibility(0);
        } else
        {
            viewgroup.setTextSize(0, mContext.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_header));
            viewgroup.setTextColor(mContext.getResources().getColor(com.amazon.retailsearch.R.color.rs_refinement_group_header));
            viewgroup.setTypeface(viewgroup.getTypeface(), 1);
        }
        viewgroup = (ImageView)view.findViewById(com.amazon.retailsearch.R.id.rs_refinements_group_indicator);
        if (getChildrenCount(i) <= 0)
        {
            viewgroup.setVisibility(8);
            return view;
        }
        viewgroup.setVisibility(0);
        if (flag)
        {
            viewgroup.setImageDrawable(mContext.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_arrow_up));
            return view;
        } else
        {
            viewgroup.setImageDrawable(mContext.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_arrow_down));
            return view;
        }
    }

    public View getRealChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj;
        Object obj1;
        obj = view;
        view = ((View) (obj));
        if (obj == null)
        {
            view = View.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_child, null);
        }
        viewgroup = (TextView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_label);
        viewgroup.setPadding(mResources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.pc_18px), 0, 0, 0);
        obj = (ImageView)ViewHolder.get(view, com.amazon.retailsearch.R.id.rs_refinements_child_indicator);
        ((ImageView) (obj)).setVisibility(8);
        flag = false;
        obj1 = getGroupSection(i);
        if (obj1 != com.amazon.retailsearch.android.ui.refinements.GroupSection.Department) goto _L2; else goto _L1
_L1:
        obj1 = (RefinementLink)getChild(i, j);
        if (obj1 != null)
        {
            setDepartmentChildView(((RefinementLink) (obj1)), j, viewgroup);
            flag = ((RefinementLink) (obj1)).getSelected();
        }
_L4:
        if (flag)
        {
            viewgroup.setTextColor(mResources.getColor(com.amazon.retailsearch.R.color.rs_refinement_child_text_selected));
            viewgroup.setContentDescription((new StringBuilder()).append(viewgroup.getText()).append(". ").append(mResources.getString(com.amazon.retailsearch.R.string.refine_selected)).toString());
            return view;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (obj1 == GroupSection.Filter || obj1 == GroupSection.PrioritizedFilter)
        {
            obj1 = (RefinementFilter)getGroup(i);
            RefinementLink refinementlink = (RefinementLink)getChild(i, j);
            if (refinementlink != null)
            {
                flag = refinementlink.getSelected();
                viewgroup.setText(getFilterMessage(viewgroup, refinementlink));
                if ("MultiSelectOR".equals(((RefinementFilter) (obj1)).getType()))
                {
                    ((ImageView) (obj)).setVisibility(0);
                    obj1 = mContext.getResources();
                    int k;
                    if (flag)
                    {
                        k = com.amazon.retailsearch.R.drawable.rs_checkbox_filled;
                    } else
                    {
                        k = com.amazon.retailsearch.R.drawable.rs_checkbox;
                    }
                    ((ImageView) (obj)).setImageDrawable(((Resources) (obj1)).getDrawable(k));
                } else
                {
                    ((ImageView) (obj)).setVisibility(0);
                    obj1 = mContext.getResources();
                    int l;
                    if (flag)
                    {
                        l = com.amazon.retailsearch.R.drawable.rs_radiobox_filled;
                    } else
                    {
                        l = com.amazon.retailsearch.R.drawable.rs_radiobox;
                    }
                    ((ImageView) (obj)).setImageDrawable(((Resources) (obj1)).getDrawable(l));
                }
            }
        } else
        if (obj1 == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
        {
            SelectedOption selectedoption = (SelectedOption)getChild(i, j);
            flag = selectedoption.getSelected();
            viewgroup.setText(selectedoption.getLink().getText());
        } else
        {
            viewgroup.setText("");
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!isChildSelectable(i, j))
        {
            viewgroup.setTextColor(mResources.getColor(com.amazon.retailsearch.R.color.rs_refinement_gray));
            ((ImageView) (obj)).setVisibility(8);
            viewgroup.setContentDescription((new StringBuilder()).append(viewgroup.getText()).append(". ").append(mResources.getString(com.amazon.retailsearch.R.string.refine_disabled)).toString());
            return view;
        } else
        {
            viewgroup.setTextColor(mResources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
            viewgroup.setContentDescription(viewgroup.getText());
            return view;
        }
    }

    public int getRealChildrenCount(int i)
    {
        GroupSection groupsection = getGroupSection(i);
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Department)
        {
            i = 0;
            if (mDepartment.getCategories() != null)
            {
                i = 0 + mDepartment.getCategories().size();
            }
            int j = i;
            if (mDepartment.getAncestry() != null)
            {
                j = i + mDepartment.getAncestry().size();
            }
            return j;
        }
        if (groupsection == com.amazon.retailsearch.android.ui.refinements.GroupSection.Sort)
        {
            if (mSort.getOptions() != null && mSort.getOptions().size() != 0)
            {
                return mSort.getOptions().size();
            }
        } else
        {
            if (groupsection == GroupSection.PrioritizedFilter)
            {
                return getFilterSize((RefinementFilter)mPrioritizedFilters.get(i));
            }
            if (groupsection == GroupSection.Filter)
            {
                return getFilterSize((RefinementFilter)mFilters.get(i - filterOffset()));
            }
        }
        return 0;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isAddressInfo(int i)
    {
        RefinementItem refinementitem = getGroupItem(i);
        return refinementitem != null && "Address".equals(refinementitem.getType());
    }

    public boolean isChildSelectable(int i, int j)
    {
        boolean flag2 = true;
        boolean flag = true;
        long l = getChildId(i, j);
        if (l == 3L)
        {
            RefinementLink refinementlink = (RefinementLink)getChild(i, j);
            if (refinementlink != null && !TextUtils.isEmpty(refinementlink.getUrl()))
            {
                GroupSection groupsection = getGroupSection(i);
                if (groupsection == GroupSection.Filter || groupsection == GroupSection.PrioritizedFilter)
                {
                    RefinementFilter refinementfilter = (RefinementFilter)getGroup(i);
                    if (!refinementlink.getSelected() || "MultiSelectOR".equals(refinementfilter.getType()))
                    {
                        return true;
                    }
                } else
                {
                    if (refinementlink.getSelected())
                    {
                        flag = false;
                    }
                    return flag;
                }
            }
        } else
        if (l == 4L)
        {
            boolean flag1;
            if (!((SelectedOption)getChild(i, j)).getSelected())
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            return flag1;
        }
        return false;
    }

    public boolean isFilterGroup(String s)
    {
        return s != null && !"dept".equals(s) && !"sort".equals(s) && !"seeMoreFilters".equals(s);
    }

    public boolean isGroupSeeMoreLink(int i)
    {
        return GroupSection.SeeMore == getGroupSection(i);
    }
}
