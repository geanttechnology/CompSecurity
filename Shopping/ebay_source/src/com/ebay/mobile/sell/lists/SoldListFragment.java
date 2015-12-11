// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseFragment, SellListAdapter

public final class SoldListFragment extends SellListBaseFragment
{

    private static long lastRefreshTime;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("SoldItemList", 3, "Log Dest Sold");

    public SoldListFragment()
    {
    }

    protected void deleteItems(List list)
    {
        if (list != null && list.size() > 0)
        {
            list = (MyEbayListItem[])list.toArray(new MyEbayListItem[list.size()]);
            dm.removeFromSoldList(this, sellingListRefinement, list);
            setListShown(false);
        }
    }

    protected SellListAdapter getAdapter()
    {
        return new SellListAdapter(getActivity(), getLayoutResource(), 0x1020014, this, SellingListActivity.ListType.SOLD);
    }

    protected int getEmptyStateTextResource()
    {
        if (sellingListRefinement != null)
        {
            if ("AwaitingPayment".equals(sellingListRefinement.filter))
            {
                return !EbaySite.DE.equals(MyApp.getPrefs().getCurrentSite()) ? 0x7f0703b0 : 0x7f0703b2;
            }
            if ("AwaitingShipment".equals(sellingListRefinement.filter))
            {
                return 0x7f0703b1;
            }
        }
        return 0x7f0703af;
    }

    public List getFilterByRefinements()
    {
        refinements = new ArrayList();
        if (SellingListRefinement.SupportedMyEbaySoldFilters != null && SellingListRefinement.SupportedMyEbaySoldFilters.length > 0)
        {
            String as[] = SellingListRefinement.SupportedMyEbaySoldFilters;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                refinements.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(s) {

                    final SoldListFragment this$0;
                    final String val$filterId;

                    public String getStringIdentifier()
                    {
                        return filterId;
                    }

                    public boolean isDefaultRefinement()
                    {
                        return "soldAll".equals(filterId);
                    }

            
            {
                this$0 = SoldListFragment.this;
                filterId = s1;
                super(final_s);
            }
                });
            }

        }
        return refinements;
    }

    protected com.ebay.common.ConstantsCommon.ItemKind getItemKind()
    {
        return com.ebay.common.ConstantsCommon.ItemKind.Sold;
    }

    protected String getRefinementTitle(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   -2042223450: 98
    //                   -2030638035: 70
    //                   -1251545734: 84;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_98;
_L5:
        switch (byte0)
        {
        default:
            return null;

        case 0: // '\0'
            return getString(0x7f070519);

        case 1: // '\001'
            if (EbaySite.DE.equals(MyApp.getPrefs().getCurrentSite()))
            {
                return getString(0x7f0708ea);
            } else
            {
                return getString(0x7f0708e6);
            }

        case 2: // '\002'
            return getString(0x7f0708e7);
        }
_L3:
        if (s.equals("soldAll"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("AwaitingPayment"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("AwaitingShipment"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    protected SourceIdentification getSourceIdentification()
    {
        String s;
        String s1;
        s1 = "All";
        s = s1;
        if (sellingListRefinement == null) goto _L2; else goto _L1
_L1:
        if (!"AwaitingPayment".equals(sellingListRefinement.filter)) goto _L4; else goto _L3
_L3:
        s = "AwaitingPayment";
_L2:
        return new SourceIdentification(getTrackingEventName(), "me", s);
_L4:
        s = s1;
        if ("AwaitingShipment".equals(sellingListRefinement.filter))
        {
            s = "AwaitingShipment";
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected String getTitleText(Resources resources)
    {
        return resources.getString(0x7f070ad4);
    }

    public String getTrackingEventName()
    {
        return "MyEbaySoldList";
    }

    public void invalidate()
    {
        super.invalidate();
        if (dm != null)
        {
            dm.forceReloadSoldList(sellingListRefinement);
        }
    }

    protected boolean isEditEnabled()
    {
        return true;
    }

    protected boolean isRefineEnabled()
    {
        return true;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        sellingListRefinement = SellingListRefinement.buildDefaultSold();
        bundle = getArguments();
        if (bundle != null && bundle.containsKey("filter"))
        {
            sellingListRefinement.filter = bundle.getString("filter");
            bundle.remove("filter");
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (MyEbaySellingDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager.KeyParams(userDm.getCurrentUser().user), this);
        datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
        dm.setObserving(this, false, sellingListRefinement);
        if (restorePage != -1)
        {
            dm.loadSoldList(restorePage, sellingListRefinement);
        }
        if (pendingRefresh)
        {
            invalidate();
        }
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        dm.loadSoldList(j, sellingListRefinement);
    }

    public void onSoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        super.onSoldListChanged(myebaysellingdatamanager, listcontent);
        if (sellingListRefinement != null && "soldAll".equals(sellingListRefinement.filter))
        {
            setList(listcontent, null);
        }
    }

    public void onStart()
    {
        if (lastRefreshTime != 0L) goto _L2; else goto _L1
_L1:
        lastRefreshTime = SystemClock.elapsedRealtime();
_L4:
        super.onStart();
        return;
_L2:
        if (SystemClock.elapsedRealtime() - 0x493e0L > lastRefreshTime)
        {
            lastRefreshTime = SystemClock.elapsedRealtime();
            invalidate();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
