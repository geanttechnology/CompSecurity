// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.amazon.retailsearch.android.ui.AnimatedExpandableListView;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SelectedOption;
import com.amazon.searchapp.retailsearch.model.Sort;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsAdapter, IRefinementsViewListener

public class RefinementsListView extends AnimatedExpandableListView
{

    private String lastExpandedGroupItemId;
    private IRefinementsViewListener listener;
    private RefinementsAdapter mAdapter;
    private int mItemHeight;
    private Refinements mRefinements;
    private Sort mSort;
    private int selectedChildPosition;
    private String selectedGroupItemId;

    public RefinementsListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectedChildPosition = -1;
        lastExpandedGroupItemId = null;
        context = getResources().getDrawable(com.amazon.retailsearch.R.drawable.horizontal_divider_dark_rs);
        setDivider(context);
        setChildDivider(context);
        setOverScrollMode(2);
        mItemHeight = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_height) + context.getIntrinsicHeight();
        createListeners();
    }

    private void buildView()
    {
        if (mRefinements != null)
        {
            mAdapter = new RefinementsAdapter(mRefinements.getDepartments(), mRefinements.getFilters(), mSort, mRefinements.getPrioritizedFilterIds(), getContext());
            setAdapter(mAdapter);
            if (!TextUtils.isEmpty(selectedGroupItemId))
            {
                openGroup(selectedGroupItemId, selectedChildPosition);
            }
            if (listener != null)
            {
                listener.onUpdate(mRefinements);
                listener.onViewSizeChanged();
                return;
            }
        }
    }

    private void createListeners()
    {
        setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            final RefinementsListView this$0;

            public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
            {
                if (getVisibility() != 8) goto _L2; else goto _L1
_L1:
                return true;
_L2:
                selectedGroupItemId = getRefinementID(mAdapter.getGroupItem(i));
                selectedChildPosition = j;
                l = mAdapter.getChildId(i, j);
                if (l != 3L)
                {
                    break; /* Loop/switch isn't completed */
                }
                expandablelistview = (RefinementLink)mAdapter.getChild(i, j);
                if (listener != null)
                {
                    listener.onRefinementClick(expandablelistview.getUrl());
                }
_L4:
                if (listener != null)
                {
                    listener.onHide();
                    return true;
                }
                if (true) goto _L1; else goto _L3
_L3:
                if (l == 4L)
                {
                    expandablelistview = (SelectedOption)mAdapter.getChild(i, j);
                    if (listener != null)
                    {
                        listener.onRefinementClick(expandablelistview.getLink().getUrl());
                    }
                } else
                {
                    return false;
                }
                  goto _L4
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        });
        setOnGroupExpandListener(new android.widget.ExpandableListView.OnGroupExpandListener() {

            final RefinementsListView this$0;

            public void onGroupExpand(int i)
            {
                notifyItemCountChanged();
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        });
        setOnGroupCollapseListener(new android.widget.ExpandableListView.OnGroupCollapseListener() {

            final RefinementsListView this$0;

            public void onGroupCollapse(int i)
            {
                notifyItemCountChanged();
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        });
        setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            final RefinementsListView this$0;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
            {
                int j = i;
                if (mAdapter.isGroupSeeMoreLink(i))
                {
                    j = mAdapter.getGroupPosition("dept");
                } else
                if (mAdapter.isAddressInfo(i))
                {
                    return true;
                }
                if (isGroupExpanded(j))
                {
                    if (j != i)
                    {
                        setSelectedGroup(j);
                        return true;
                    } else
                    {
                        collapseGroupWithAnimation(j);
                        lastExpandedGroupItemId = null;
                        return true;
                    }
                }
                expandablelistview = getRefinementID(mAdapter.getGroupItem(j));
                if (lastExpandedGroupItemId != null && expandablelistview != null && !expandablelistview.equals(lastExpandedGroupItemId))
                {
                    collapseGroupWithAnimation(mAdapter.getGroupPosition(lastExpandedGroupItemId));
                }
                lastExpandedGroupItemId = expandablelistview;
                smoothScrollToPosition(j);
                expandGroupWithAnimation(j);
                return true;
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        });
    }

    private String getRefinementID(RefinementsAdapter.RefinementItem refinementitem)
    {
        if (refinementitem == null)
        {
            return null;
        }
        if (refinementitem.getId() == null)
        {
            return refinementitem.getLabel();
        } else
        {
            return refinementitem.getId();
        }
    }

    private void notifyItemCountChanged()
    {
        if (listener != null)
        {
            listener.onViewSizeChanged();
        }
    }

    private void openGroup(String s, int i)
    {
        int j = mAdapter.getGroupPosition(s);
        if (j > -1)
        {
            expandGroup(j);
            if (i > -1 && mAdapter.isFilterGroup(s) && mItemHeight * (i + 2) > getHeight())
            {
                int k = mAdapter.getRealChildrenCount(j);
                if (i > k - 1)
                {
                    i = k - 1;
                }
                setSelectedChild(j, i, true);
            } else
            {
                setSelectedGroup(j);
            }
        }
        clearAll();
    }

    public void clearAll()
    {
        selectedGroupItemId = null;
        selectedChildPosition = -1;
    }

    public int getItemsHeight(int i)
    {
        int j;
        int k;
        if (TextUtils.isEmpty(lastExpandedGroupItemId))
        {
            j = -1;
        } else
        {
            j = mAdapter.getGroupPosition(lastExpandedGroupItemId);
        }
        k = mAdapter.getGroupCount();
        if (j > -1)
        {
            j = mAdapter.getRealChildrenCount(j);
        } else
        {
            j = 0;
        }
        k = (k + j) * mItemHeight;
        j = k;
        if (k > i)
        {
            j = i;
        }
        return j;
    }

    public void refresh()
    {
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setListener(IRefinementsViewListener irefinementsviewlistener)
    {
        listener = irefinementsviewlistener;
    }

    public void setRefinements(Refinements refinements)
    {
        mRefinements = refinements;
        buildView();
    }

    public void setSort(Sort sort)
    {
        mSort = sort;
    }


/*
    static String access$002(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.selectedGroupItemId = s;
        return s;
    }

*/




/*
    static int access$302(RefinementsListView refinementslistview, int i)
    {
        refinementslistview.selectedChildPosition = i;
        return i;
    }

*/





/*
    static String access$602(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.lastExpandedGroupItemId = s;
        return s;
    }

*/
}
