// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.CustomRefinementFilter;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;
import com.amazon.searchapp.retailsearch.model.RefinementFilter;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Sort;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            DDSAdapter, FilterItemAdapter, FilterAdapter, DDSLocationAdapter, 
//            DepartmentAdapter, SortAdapter, SeeMoreAdapter, GroupAdapter, 
//            RefinementGroupType, RefinementItemViewType, RefinementGroupViewType, RefinementType

public class RefinementsAdapter extends com.amazon.retailsearch.android.ui.AnimatedExpandableListView.AnimatedExpandableListAdapter
{

    private static String AMAZON_PRIME_FILTER_ID = "p_85";
    private static String DDS_FILTER_ID = "dds_widget";
    private final Context context;
    private DDSAdapter ddsAdapter;
    private List ddsCityAdapters;
    private List ddsDistrictAdapters;
    private List ddsProvinceAdapters;
    private List defaultAdapters;
    FeatureConfiguration featureConfig;
    private List groupAdapters;
    private final Department mDepartment;
    private final boolean mHasKeywords;
    UserPreferenceManager preferencesManager;
    private RefinementType refinementType;
    private final ResultLayoutType resultLayoutType;

    public RefinementsAdapter(Department department, List list, List list1, Sort sort, List list2, Context context1, boolean flag, 
            String s)
    {
        defaultAdapters = new ArrayList();
        RetailSearchDaggerGraphController.inject(this);
        context = context1;
        mDepartment = department;
        resultLayoutType = preferencesManager.getResultLayoutType();
        mHasKeywords = flag;
        initDefaultGroupAdapters(context1, department, list, list1, sort, list2, s);
        groupAdapters = defaultAdapters;
    }

    private void addFilters(Context context1, List list, List list1, List list2, boolean flag, String s)
    {
label0:
        {
            int i;
label1:
            {
                if (list == null || list.size() <= 0)
                {
                    break label0;
                }
                byte byte0 = -1;
                i = byte0;
                if (flag)
                {
                    break label1;
                }
                i = byte0;
                if (list1 == null)
                {
                    break label1;
                }
                list1 = list1.iterator();
                CustomRefinementFilter customrefinementfilter;
                do
                {
                    i = byte0;
                    if (!list1.hasNext())
                    {
                        break label1;
                    }
                    customrefinementfilter = (CustomRefinementFilter)list1.next();
                } while (!DDS_FILTER_ID.equals(customrefinementfilter.getId()));
                ddsAdapter = new DDSAdapter(context1, customrefinementfilter);
                i = customrefinementfilter.getPriority();
            }
            int j = -1;
            list = list.iterator();
label2:
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                list1 = (RefinementFilter)list.next();
                if ((!flag || !list2.contains(list1.getId())) && (flag || list2.contains(list1.getId())))
                {
                    continue;
                }
                int k = j + 1;
                if (k == i && ddsAdapter != null && "T1".equals(FeatureStateUtil.getDDSWeblab(featureConfig)))
                {
                    defaultAdapters.add(ddsAdapter);
                }
                if (flag && list2.contains(list1.getId()) && AMAZON_PRIME_FILTER_ID.equals(list1.getId()))
                {
                    Iterator iterator = list1.getValues().iterator();
                    do
                    {
                        j = k;
                        if (!iterator.hasNext())
                        {
                            continue label2;
                        }
                        RefinementLink refinementlink = (RefinementLink)iterator.next();
                        boolean flag1;
                        if (s != null && refinementlink != null && s.equals(refinementlink.getId()))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        defaultAdapters.add(new FilterItemAdapter(context1, resultLayoutType, refinementlink, list1.getClearLink(), flag1));
                    } while (true);
                }
                defaultAdapters.add(new FilterAdapter(context1, list1, resultLayoutType));
                j = k;
            } while (true);
        }
    }

    private List initDDSLocationAdapters(Context context1, RefinementType refinementtype, List list, List list1, String s, String s1)
    {
        if (list == null)
        {
            list = new ArrayList();
            list.add(new DDSLocationAdapter(context1, refinementtype, list1, s, s1));
            return list;
        } else
        {
            ((DDSLocationAdapter)list.get(0)).setRefinementType(refinementtype, list1, s, s1);
            return list;
        }
    }

    private void initDefaultGroupAdapters(Context context1, Department department, List list, List list1, Sort sort, List list2, String s)
    {
        department = new DepartmentAdapter(context1, department);
        SortAdapter sortadapter = new SortAdapter(context1, sort);
        if (list2 != null && list2.size() > 0)
        {
            addFilters(context1, list, list1, list2, true, s);
        }
        defaultAdapters.add(department);
        if (sort != null)
        {
            defaultAdapters.add(sortadapter);
        }
        addFilters(context1, list, list1, list2, false, null);
        if (!isDepartmentSelected())
        {
            defaultAdapters.add(new SeeMoreAdapter(context1));
        }
    }

    private boolean isDepartmentSelected()
    {
        List list = mDepartment.getAncestry();
        return list != null && (list.size() > 1 || list.size() == 1 && !mHasKeywords);
    }

    public Object getChild(int i, int j)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getChild(j);
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public String getChildUrl(int i, int j)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getChildUrl(j);
    }

    public Object getGroup(int i)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getData();
    }

    public GroupAdapter getGroupAdapter(int i)
    {
        return (GroupAdapter)groupAdapters.get(i);
    }

    public GroupAdapter getGroupAdapter(String s)
    {
        int i = getGroupPosition(s);
        if (i > -1)
        {
            return getGroupAdapter(i);
        } else
        {
            return null;
        }
    }

    public int getGroupCount()
    {
        return groupAdapters.size();
    }

    public long getGroupId(int i)
    {
        return 0L;
    }

    public int getGroupPosition(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
        Iterator iterator = groupAdapters.iterator();
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
                if (s.equals(((GroupAdapter)iterator.next()).getId()))
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

    public int getGroupPositionByChildId(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        int i = 0;
        Iterator iterator = groupAdapters.iterator();
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
                if (((GroupAdapter)iterator.next()).containsChild(s))
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

    public String getGroupUrl(int i)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getUrl();
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getView(flag, view, viewgroup);
    }

    public int getRealChildType(int i, int j)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getType().getChildViewType().getValue();
    }

    public int getRealChildTypeCount()
    {
        return RefinementItemViewType.getCount();
    }

    public View getRealChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getChildView(j, flag, view, viewgroup);
    }

    public int getRealChildrenCount(int i)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getChildrenCount();
    }

    public int getRealGroupType(int i)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getType().getGroupViewType().getValue();
    }

    public int getRealGroupTypeCount()
    {
        return RefinementGroupViewType.getCount();
    }

    public RefinementGroupType getRefinementGroupType(int i)
    {
        return ((GroupAdapter)groupAdapters.get(i)).getType();
    }

    public RefinementType getRefinementType()
    {
        return refinementType;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public void setCurrentAddress(Current current)
    {
        if (ddsAdapter != null)
        {
            ddsAdapter.setCurrentAddress(current);
        }
    }

    public void setLocationSuggestions(LocationSuggestions locationsuggestions)
    {
        if (ddsAdapter != null)
        {
            ddsAdapter.setLocationSuggestions(locationsuggestions);
        }
    }

    public void setLocations(Locations locations)
    {
        if (ddsAdapter != null)
        {
            ddsAdapter.setLocations(locations);
        }
    }

    public void setRefinementType(RefinementType refinementtype, List list, Locations locations, String s)
    {
        refinementType = refinementtype;
        if (refinementtype != RefinementType.DEFAULT) goto _L2; else goto _L1
_L1:
        groupAdapters = defaultAdapters;
_L4:
        return;
_L2:
        if (list == null || locations == null) goto _L4; else goto _L3
_L3:
        List list1;
        String s1;
        s1 = null;
        list1 = null;
        if (refinementtype != RefinementType.DDS_PROVINCE) goto _L6; else goto _L5
_L5:
        s1 = (String)locations.getLocationSelectionLabels().get(0);
        list1 = ddsProvinceAdapters;
_L8:
        groupAdapters = initDDSLocationAdapters(context, refinementtype, list1, list, s1, s);
        return;
_L6:
        if (refinementtype == RefinementType.DDS_CITY)
        {
            s1 = (String)locations.getLocationSelectionLabels().get(1);
            list1 = ddsCityAdapters;
        } else
        if (refinementtype == RefinementType.DDS_DISTRICT)
        {
            s1 = (String)locations.getLocationSelectionLabels().get(2);
            list1 = ddsDistrictAdapters;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void updateDoamins(List list, List list1, List list2)
    {
        if (ddsAdapter != null)
        {
            ddsAdapter.setProvinceDomains(list);
            ddsAdapter.setCityDomains(list1);
            ddsAdapter.setDistrictDomains(list2);
        }
    }

}
