// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.app.LoaderManager;
import android.location.Location;
import com.groupon.abtest.EditOrderAbTestHelper;
import com.groupon.adapter.VpsAdapter;
import com.groupon.adapter.mygroupons.MyGrouponsCardEndlessAdapter;
import com.groupon.adapter.mygroupons.MyNearbyGrouponsJavaAdapter;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.manager.mygroupons.BaseMyGrouponsPaginatedSyncManager;
import com.groupon.manager.mygroupons.MyNearbyGrouponsSyncManager;
import com.groupon.models.EndlessList;
import com.groupon.models.country.Country;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import commonlib.adapter.JavaListAdapter;
import commonlib.manager.PaginatedSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

public class MyNearbyGrouponsFragment extends BaseMyGrouponsFragment
{

    private GeoUtils geoUtils;
    private LocationService locationService;
    private MyNearbyGrouponsSyncManager myNearbyGrouponsSyncManager;

    public MyNearbyGrouponsFragment()
    {
    }

    private List createNearbyListElements(List list, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (!list.isEmpty())
        {
            if (flag)
            {
                arraylist.add(0, getString(0x7f080276));
            }
            Object obj = locationService.getLocation();
            if (obj == null || ((Location) (obj)).getLatitude() == 0.0D && ((Location) (obj)).getLongitude() == 0.0D)
            {
                arraylist.add(getString(0x7f08013a));
                arraylist.addAll(list);
                return arraylist;
            }
            ArrayList arraylist1;
            ArrayList arraylist2;
            ArrayList arraylist3;
            ArrayList arraylist4;
            ArrayList arraylist5;
            int i;
            if (currentCountryManager.getCurrentCountry().usesMetricSystem())
            {
                i = 0x7f080246;
            } else
            {
                i = 0x7f080269;
            }
            obj = getString(i);
            arraylist1 = new ArrayList();
            arraylist2 = new ArrayList();
            arraylist3 = new ArrayList();
            arraylist4 = new ArrayList();
            arraylist5 = new ArrayList();
            for (list = list.iterator(); list.hasNext();)
            {
                MyGrouponItemSummary mygrouponitemsummary = (MyGrouponItemSummary)list.next();
                ArrayList arraylist6 = mygrouponitemsummary.derivedRedemptionLocations;
                if (arraylist6 != null && !arraylist6.isEmpty())
                {
                    double d = geoUtils.getClosestDistance(new GeoPoint(locationService.getLocation()), arraylist6);
                    if (d == 1.7976931348623157E+308D)
                    {
                        arraylist5.add(mygrouponitemsummary);
                    } else
                    if (d < 5D)
                    {
                        arraylist1.add(mygrouponitemsummary);
                    } else
                    if (d < 10D)
                    {
                        arraylist2.add(mygrouponitemsummary);
                    } else
                    if (d < 20D)
                    {
                        arraylist3.add(mygrouponitemsummary);
                    } else
                    {
                        arraylist4.add(mygrouponitemsummary);
                    }
                } else
                {
                    arraylist5.add(mygrouponitemsummary);
                }
            }

            if (!arraylist1.isEmpty())
            {
                arraylist.add(getString(0x7f080288));
                arraylist.addAll(arraylist1);
            }
            if (!arraylist2.isEmpty())
            {
                arraylist.add(String.format(">%1$s %2$s", new Object[] {
                    Integer.valueOf(5), obj
                }));
                arraylist.addAll(arraylist2);
            }
            if (!arraylist3.isEmpty())
            {
                arraylist.add(String.format(">%1$s %2$s", new Object[] {
                    Integer.valueOf(10), obj
                }));
                arraylist.addAll(arraylist3);
            }
            if (!arraylist4.isEmpty())
            {
                arraylist.add(String.format(">%1$s %2$s", new Object[] {
                    Integer.valueOf(20), obj
                }));
                arraylist.addAll(arraylist4);
            }
            if (!arraylist5.isEmpty())
            {
                arraylist.add(getString(0x7f0802ac));
                arraylist.addAll(arraylist5);
                return arraylist;
            }
        }
        return arraylist;
    }

    public volatile BaseMyGrouponsPaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public MyNearbyGrouponsSyncManager getSyncManager()
    {
        return myNearbyGrouponsSyncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void initLoader()
    {
        getLoaderManager().initLoader(0, null, new BaseMyGrouponsFragment.GrouponsListLoaderCallbacks(this, myGrouponsJavaAdapter, "nearby_groupons", ((EditOrderAbTestHelper)editOrderAbTestHelper.get()).isEditOrderEnabled()));
    }

    protected void installAdapters()
    {
        myGrouponsJavaAdapter = new MyNearbyGrouponsJavaAdapter(getActivity(), getTrackPackageClickListener());
        myGrouponsCardEndlessAdapter = new MyGrouponsCardEndlessAdapter(this, this, myGrouponsJavaAdapter);
        setListAdapter(new VpsAdapter(myGrouponsCardEndlessAdapter));
    }

    protected void onFinishedLoading(List list)
    {
        toggleEmptyViewVisibility(list.isEmpty());
        List list1;
        boolean flag;
        if (((EndlessList)list).getTotalSize() > 30)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        list1 = createNearbyListElements(list, flag);
        myGrouponsCardEndlessAdapter.setTotalSize(list.size());
        myGrouponsJavaAdapter.setList(list1);
    }
}
