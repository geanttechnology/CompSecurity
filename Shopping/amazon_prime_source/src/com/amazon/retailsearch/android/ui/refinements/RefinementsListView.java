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
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.AnimatedExpandableListView;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.Domain;
import com.amazon.searchapp.retailsearch.model.Label;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.Sort;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsAdapter, DDSAdapter, IRefinementsViewListener, RefinementType, 
//            DDSLocationAdapter, GroupAdapter, RefinementGroupType, DepartmentAdapter

public class RefinementsListView extends AnimatedExpandableListView
{

    private static String SEPARATOR = "|";
    private String animatedRefinementId;
    private List cityDomains;
    private Current currentAddress;
    private String currentCity;
    private String currentDistrict;
    private String currentProvince;
    IRetailSearchDataProvider dataProvider;
    SearchDataSource dataSource;
    private List districtDomains;
    private String lastExpandedGroupId;
    private IRefinementsViewListener listener;
    private com.amazon.retailsearch.data.location.LocationLoader.LocationResultListener locationResultLister;
    private LocationSuggestions locationSuggestions;
    private Locations locations;
    private RefinementsAdapter mAdapter;
    private boolean mHasKeywords;
    private int mItemHeight;
    private Refinements mRefinements;
    private Sort mSort;
    RetailSearchAndroidPlatform platform;
    private List provinceDomains;
    private int selectedChildPosition;
    private String selectedGroupId;

    public RefinementsListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectedChildPosition = -1;
        lastExpandedGroupId = null;
        mHasKeywords = true;
        locationResultLister = new com.amazon.retailsearch.data.location.LocationLoader.LocationResultListener() {

            final RefinementsListView this$0;

            public void currentLocation(Current current)
            {
                currentAddress = current;
                mAdapter.setCurrentAddress(current);
            }

            public void endParse(LocationResults locationresults)
            {
                notifyAdapterDataSetChanged();
                updateCurrentDomains();
            }

            public void locationSuggestions(LocationSuggestions locationsuggestions)
            {
                RefinementsListView.this.locationSuggestions = locationsuggestions;
                mAdapter.setLocationSuggestions(locationsuggestions);
            }

            public void locations(Locations locations1)
            {
                RefinementsListView.this.locations = locations1;
                provinceDomains = locations1.getDomains();
                mAdapter.setLocations(locations1);
            }

            public void onError(Exception exception)
            {
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        };
        context = getResources().getDrawable(com.amazon.retailsearch.R.drawable.horizontal_divider_dark_rs);
        setDivider(context);
        setChildDivider(context);
        setDividerHeight(0);
        setOverScrollMode(2);
        mItemHeight = getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_height) + context.getIntrinsicHeight();
        createListeners();
        RetailSearchDaggerGraphController.inject(this);
    }

    private void buildView()
    {
        if (mRefinements != null)
        {
            clearLocationData();
            mAdapter = new RefinementsAdapter(mRefinements.getDepartments(), mRefinements.getFilters(), mRefinements.getCustomFilters(), mSort, mRefinements.getPrioritizedFilterIds(), getContext(), mHasKeywords, animatedRefinementId);
            animatedRefinementId = null;
            mAdapter.setLocations(locations);
            mAdapter.setLocationSuggestions(locationSuggestions);
            setAdapter(mAdapter);
            if (!TextUtils.isEmpty(selectedGroupId))
            {
                if (selectedGroupId == DDSAdapter.ID)
                {
                    updateLocationData();
                }
                openGroup(selectedGroupId, selectedChildPosition);
            }
            if (listener != null)
            {
                listener.onUpdate(mRefinements);
                listener.onViewSizeChanged();
                return;
            }
        }
    }

    private boolean changeRefinementType(RefinementType refinementtype, List list)
    {
        return changeRefinementType(refinementtype, list, null);
    }

    private boolean changeRefinementType(RefinementType refinementtype, List list, String s)
    {
        if (refinementtype == RefinementType.DEFAULT)
        {
            selectedGroupId = DDSAdapter.ID;
        } else
        {
            selectedGroupId = DDSLocationAdapter.ID;
        }
        selectedChildPosition = 0;
        lastExpandedGroupId = selectedGroupId;
        mAdapter.setRefinementType(refinementtype, list, locations, s);
        setAdapter(mAdapter);
        if (!TextUtils.isEmpty(selectedGroupId))
        {
            openGroup(selectedGroupId, selectedChildPosition);
        }
        notifyItemCountChanged();
        return true;
    }

    private void clearLocationData()
    {
        locations = null;
    }

    private void clearSelectedItems()
    {
        selectedGroupId = null;
        selectedChildPosition = -1;
    }

    private void createListeners()
    {
        setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            final RefinementsListView this$0;

            public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
            {
                expandablelistview = mAdapter.getGroupAdapter(i);
                if (expandablelistview == null || !expandablelistview.isChildEnabled(j))
                {
                    return true;
                }
                if (getVisibility() == 8)
                {
                    return true;
                }
                view = mAdapter.getRefinementGroupType(i);
                if (view == RefinementGroupType.DDS)
                {
                    expandablelistview = (DDSAdapter)expandablelistview;
                    clearAll();
                    if (expandablelistview.isProvinceSelector(j))
                    {
                        return changeRefinementType(RefinementType.DDS_PROVINCE, provinceDomains, expandablelistview.getCurrentValue(0));
                    }
                    if (expandablelistview.isCitySelector(j))
                    {
                        return changeRefinementType(RefinementType.DDS_CITY, cityDomains, expandablelistview.getCurrentValue(1));
                    }
                    if (expandablelistview.isDistrictSelector(j))
                    {
                        return changeRefinementType(RefinementType.DDS_DISTRICT, districtDomains, expandablelistview.getCurrentValue(2));
                    }
                    expandablelistview = expandablelistview.getChildUrl(j);
                    if (updateAddress(expandablelistview))
                    {
                        selectedGroupId = DDSAdapter.ID;
                        selectedChildPosition = j;
                        lastExpandedGroupId = selectedGroupId;
                    }
                    return true;
                }
                if (view == RefinementGroupType.DDS_PROVINCE)
                {
                    expandablelistview = (DDSLocationAdapter)expandablelistview;
                    cityDomains = expandablelistview.getDomains(j);
                    currentProvince = expandablelistview.getChild(j).getId();
                    if (cityDomains.size() == 1)
                    {
                        districtDomains = ((Domain)cityDomains.get(0)).getDomains();
                        currentCity = ((Domain)cityDomains.get(0)).getId();
                        return changeRefinementType(RefinementType.DDS_DISTRICT, districtDomains);
                    } else
                    {
                        return changeRefinementType(RefinementType.DDS_CITY, cityDomains);
                    }
                }
                if (view == RefinementGroupType.DDS_CITY)
                {
                    expandablelistview = (DDSLocationAdapter)expandablelistview;
                    districtDomains = expandablelistview.getDomains(j);
                    currentCity = expandablelistview.getChild(j).getId();
                    return changeRefinementType(RefinementType.DDS_DISTRICT, districtDomains);
                }
                if (view == RefinementGroupType.DDS_DISTRICT)
                {
                    expandablelistview = (DDSLocationAdapter)expandablelistview;
                    currentDistrict = expandablelistview.getChild(j).getId();
                    expandablelistview = getCurrentAddress();
                    if (updateAddress(expandablelistview))
                    {
                        selectedGroupId = DDSAdapter.ID;
                        selectedChildPosition = 0;
                        lastExpandedGroupId = selectedGroupId;
                    }
                    return true;
                }
                selectedGroupId = expandablelistview.getId();
                selectedChildPosition = j;
                expandablelistview = mAdapter.getChildUrl(i, j);
                if (!TextUtils.isEmpty(expandablelistview) && listener != null)
                {
                    listener.onRefinementClick(expandablelistview);
                    if (listener != null)
                    {
                        listener.onHide();
                    }
                    return true;
                } else
                {
                    return false;
                }
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
                post(i. new Runnable() {

                    final _cls3 this$1;
                    final int val$groupPosition;

                    public void run()
                    {
                        setSelectedGroup(groupPosition);
                    }

            
            {
                this$1 = final__pcls3;
                groupPosition = I.this;
                super();
            }
                });
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        });
        final android.widget.ExpandableListView.OnGroupCollapseListener onGroupCollapseListener = new android.widget.ExpandableListView.OnGroupCollapseListener() {

            final RefinementsListView this$0;

            public void onGroupCollapse(int i)
            {
                notifyItemCountChanged();
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        };
        setOnGroupCollapseListener(onGroupCollapseListener);
        setOnGroupClickListener(new android.widget.ExpandableListView.OnGroupClickListener() {

            final RefinementsListView this$0;
            final android.widget.ExpandableListView.OnGroupCollapseListener val$onGroupCollapseListener;

            public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
            {
                view = mAdapter.getGroupAdapter(i);
                if (view == null || !view.isEnabled())
                {
                    return true;
                }
                RefinementGroupType refinementgrouptype = mAdapter.getRefinementGroupType(i);
                final int p = i;
                if (refinementgrouptype == RefinementGroupType.SEEMORE)
                {
                    p = mAdapter.getGroupPosition(DepartmentAdapter.ID);
                    expandablelistview = mAdapter.getGroupAdapter(p);
                } else
                {
                    if (refinementgrouptype == RefinementGroupType.DDS_PROVINCE)
                    {
                        return changeRefinementType(RefinementType.DEFAULT, null);
                    }
                    if (refinementgrouptype == RefinementGroupType.DDS_CITY)
                    {
                        return changeRefinementType(RefinementType.DDS_PROVINCE, provinceDomains);
                    }
                    if (refinementgrouptype == RefinementGroupType.DDS_DISTRICT)
                    {
                        if (cityDomains.size() == 1)
                        {
                            return changeRefinementType(RefinementType.DDS_PROVINCE, provinceDomains);
                        } else
                        {
                            return changeRefinementType(RefinementType.DDS_CITY, cityDomains);
                        }
                    }
                    if (refinementgrouptype == RefinementGroupType.DDS)
                    {
                        updateLocationData();
                        expandablelistview = view;
                    } else
                    {
                        expandablelistview = view;
                        if (refinementgrouptype == RefinementGroupType.FILTER_ITEM)
                        {
                            expandablelistview = view.getUrl();
                            if (!TextUtils.isEmpty(expandablelistview) && listener != null)
                            {
                                listener.onRefinementClick(expandablelistview);
                            }
                            return true;
                        }
                    }
                }
                if (isGroupExpanded(p))
                {
                    if (p != i)
                    {
                        setSelectedGroup(p);
                    } else
                    {
                        collapseGroupWithAnimation(p);
                        lastExpandedGroupId = null;
                    }
                } else
                {
                    expandablelistview = expandablelistview.getId();
                    boolean flag = false;
                    i = ((flag) ? 1 : 0);
                    if (lastExpandedGroupId != null)
                    {
                        i = ((flag) ? 1 : 0);
                        if (expandablelistview != null)
                        {
                            i = ((flag) ? 1 : 0);
                            if (!expandablelistview.equals(lastExpandedGroupId))
                            {
                                int j = mAdapter.getGroupPosition(lastExpandedGroupId);
                                i = ((flag) ? 1 : 0);
                                if (isGroupExpanded(j))
                                {
                                    setOnGroupCollapseListener(expandablelistview. new android.widget.ExpandableListView.OnGroupCollapseListener() {

                                        final _cls5 this$1;
                                        final String val$currGroupId;
                                        final int val$p;

                                        public void onGroupCollapse(int i)
                                        {
                                            expandGroup(p, currGroupId);
                                            setOnGroupCollapseListener(onGroupCollapseListener);
                                        }

            
            {
                this$1 = final__pcls5;
                p = i;
                currGroupId = String.this;
                super();
            }
                                    });
                                    collapseGroupWithAnimation(j);
                                    i = 1;
                                }
                            }
                        }
                    }
                    if (i == 0)
                    {
                        expandGroup(p, expandablelistview);
                    }
                }
                return true;
            }

            
            {
                this$0 = RefinementsListView.this;
                onGroupCollapseListener = ongroupcollapselistener;
                super();
            }
        });
    }

    private void expandGroup(int i, String s)
    {
        lastExpandedGroupId = s;
        smoothScrollToPosition(i);
        if (mAdapter.getGroupCount() == i + 1)
        {
            expandGroup(i);
            return;
        } else
        {
            expandGroupWithAnimation(i);
            return;
        }
    }

    private List findSubDomains(List list, String s)
    {
        if (list != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Domain domain;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            domain = (Domain)list.next();
        } while (!s.equals(domain.getId()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return domain.getDomains();
    }

    private String getCurrentAddress()
    {
        if (TextUtils.isEmpty(currentProvince) || TextUtils.isEmpty(currentCity) || TextUtils.isEmpty(currentDistrict))
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(currentProvince).append(SEPARATOR).append(currentCity).append(SEPARATOR).append(currentDistrict).toString();
        }
    }

    private void notifyAdapterDataSetChanged()
    {
        platform.invokeLater(new Runnable() {

            final RefinementsListView this$0;

            public void run()
            {
                mAdapter.notifyDataSetChanged();
            }

            
            {
                this$0 = RefinementsListView.this;
                super();
            }
        });
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
        if (j <= -1) goto _L2; else goto _L1
_L1:
        s = mAdapter.getGroupAdapter(s);
        if (s != null && s.getChildrenCount() > 0)
        {
            expandGroup(j);
        }
        if (i <= -1 || s == null || s.getType() != RefinementGroupType.FILTER || mItemHeight * (i + 2) <= getHeight()) goto _L4; else goto _L3
_L3:
        int k = mAdapter.getRealChildrenCount(j);
        if (i > k - 1)
        {
            i = k - 1;
        }
        setSelectedChild(j, i, true);
_L2:
        clearSelectedItems();
        return;
_L4:
        if (mItemHeight * j > getHeight())
        {
            setSelectedGroup(j);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private boolean updateAddress(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            RetailSearchQuery retailsearchquery = dataSource.cloneLastQuery();
            retailsearchquery.setAddress(s);
            dataSource.submitQuery(retailsearchquery);
            return true;
        } else
        {
            return false;
        }
    }

    private void updateCurrentDomains()
    {
        if (locations != null && currentAddress != null && currentAddress.getLabels() != null && currentAddress.getLabels().size() > 2)
        {
            currentProvince = ((Label)currentAddress.getLabels().get(0)).getId();
            currentCity = ((Label)currentAddress.getLabels().get(1)).getId();
            currentDistrict = ((Label)currentAddress.getLabels().get(2)).getId();
            provinceDomains = locations.getDomains();
            cityDomains = findSubDomains(provinceDomains, currentProvince);
            districtDomains = findSubDomains(cityDomains, currentCity);
            mAdapter.updateDoamins(provinceDomains, cityDomains, districtDomains);
        }
    }

    private void updateLocationData()
    {
        if (locations == null)
        {
            dataProvider.getLocation(locationResultLister);
        }
    }

    public void clearAll()
    {
        clearSelectedItems();
        lastExpandedGroupId = null;
    }

    public int getItemsHeight(int i)
    {
        int j;
        int k;
        if (TextUtils.isEmpty(lastExpandedGroupId))
        {
            j = -1;
        } else
        {
            j = mAdapter.getGroupPosition(lastExpandedGroupId);
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

    public void openFilter(String s, boolean flag)
    {
        int i = mAdapter.getGroupPositionByChildId(s);
        Object obj;
        int j;
        if (i >= 0)
        {
            if ((obj = mAdapter.getGroupAdapter(i)) != null && (j = ((GroupAdapter) (obj)).getChildPosition(s)) >= 0)
            {
                selectedGroupId = ((GroupAdapter) (obj)).getId();
                selectedChildPosition = j;
                if (((GroupAdapter) (obj)).isChildSelected(s))
                {
                    openGroup(selectedGroupId, selectedChildPosition);
                    return;
                }
                obj = mAdapter.getChildUrl(i, j);
                if (!TextUtils.isEmpty(((CharSequence) (obj))) && listener != null)
                {
                    listener.onRefinementClick(((String) (obj)));
                    if (flag)
                    {
                        animatedRefinementId = s;
                        return;
                    }
                }
            }
        }
    }

    public void refresh()
    {
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setHasKeywords(boolean flag)
    {
        mHasKeywords = flag;
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
    static Locations access$002(RefinementsListView refinementslistview, Locations locations1)
    {
        refinementslistview.locations = locations1;
        return locations1;
    }

*/




/*
    static List access$102(RefinementsListView refinementslistview, List list)
    {
        refinementslistview.provinceDomains = list;
        return list;
    }

*/



/*
    static String access$1102(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.selectedGroupId = s;
        return s;
    }

*/


/*
    static int access$1202(RefinementsListView refinementslistview, int i)
    {
        refinementslistview.selectedChildPosition = i;
        return i;
    }

*/



/*
    static String access$1302(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.lastExpandedGroupId = s;
        return s;
    }

*/


/*
    static String access$1402(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.currentProvince = s;
        return s;
    }

*/


/*
    static String access$1502(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.currentCity = s;
        return s;
    }

*/



/*
    static String access$1702(RefinementsListView refinementslistview, String s)
    {
        refinementslistview.currentDistrict = s;
        return s;
    }

*/








/*
    static LocationSuggestions access$302(RefinementsListView refinementslistview, LocationSuggestions locationsuggestions)
    {
        refinementslistview.locationSuggestions = locationsuggestions;
        return locationsuggestions;
    }

*/


/*
    static Current access$402(RefinementsListView refinementslistview, Current current)
    {
        refinementslistview.currentAddress = current;
        return current;
    }

*/






/*
    static List access$802(RefinementsListView refinementslistview, List list)
    {
        refinementslistview.cityDomains = list;
        return list;
    }

*/



/*
    static List access$902(RefinementsListView refinementslistview, List list)
    {
        refinementslistview.districtDomains = list;
        return list;
    }

*/
}
