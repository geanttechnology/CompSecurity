// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseFragment, SellListAdapter

public final class ActiveListFragment extends SellListBaseFragment
{

    private static long lastRefreshTime;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ActiveItemList", 3, "Log Dest Active");

    public ActiveListFragment()
    {
    }

    protected SellListAdapter getAdapter()
    {
        return new SellListAdapter(getActivity(), getLayoutResource(), 0x1020014, this, SellingListActivity.ListType.ACTIVE);
    }

    protected int getEmptyStateTextResource()
    {
        if (sellingListRefinement == null) goto _L2; else goto _L1
_L1:
        String s;
        byte byte0;
        s = sellingListRefinement.filter;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 56
    //                   -607502763: 115
    //                   1002796579: 101
    //                   1280454455: 87;
           goto _L3 _L4 _L5 _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 2: default 84
    //                   0 129
    //                   1 132
    //                   2 135;
           goto _L2 _L7 _L8 _L9
_L2:
        return 0x7f0703a9;
_L6:
        if (s.equals("NewOffers"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (s.equals("Auction"))
        {
            byte0 = 1;
        }
          goto _L3
_L4:
        if (s.equals("FixedPrice"))
        {
            byte0 = 2;
        }
          goto _L3
_L7:
        return 0x7f0703ac;
_L8:
        return 0x7f0703aa;
_L9:
        return 0x7f0703ab;
    }

    public List getFilterByRefinements()
    {
        refinements = new ArrayList();
        if (SellingListRefinement.SupportedMyEbayActiveFilters != null && SellingListRefinement.SupportedMyEbayActiveFilters.length > 0)
        {
            String as[] = SellingListRefinement.SupportedMyEbayActiveFilters;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                refinements.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(s) {

                    final ActiveListFragment this$0;
                    final String val$filterId;

                    public String getStringIdentifier()
                    {
                        return filterId;
                    }

                    public boolean isDefaultRefinement()
                    {
                        return "activeAll".equals(filterId);
                    }

            
            {
                this$0 = ActiveListFragment.this;
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
        return com.ebay.common.ConstantsCommon.ItemKind.Selling;
    }

    protected String getRefinementTitle(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 56
    //                   -1101455772: 109
    //                   -607502763: 151
    //                   204463291: 95
    //                   1002796579: 137
    //                   1280454455: 123;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_151;
_L7:
        switch (byte0)
        {
        default:
            return "";

        case 0: // '\0'
            return getString(0x7f070519);

        case 1: // '\001'
            return getString(0x7f0708e9);

        case 2: // '\002'
            return getString(0x7f0708e9);

        case 3: // '\003'
            return getString(0x7f0708e5);

        case 4: // '\004'
            return getString(0x7f0708e8);
        }
_L4:
        if (s.equals("activeAll"))
        {
            byte0 = 0;
        }
          goto _L7
_L2:
        if (s.equals("WillSell"))
        {
            byte0 = 1;
        }
          goto _L7
_L6:
        if (s.equals("NewOffers"))
        {
            byte0 = 2;
        }
          goto _L7
_L5:
        if (s.equals("Auction"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("FixedPrice"))
        {
            byte0 = 4;
        }
          goto _L7
    }

    public SourceIdentification getSourceIdentification()
    {
        String s1 = "All";
        String s = s1;
        if (sellingListRefinement != null)
        {
            s = s1;
            if ("NewOffers".equals(sellingListRefinement.filter))
            {
                s = "NewOffers";
            }
        }
        return new SourceIdentification(getTrackingEventName(), "me", s);
    }

    protected String getTitleText(Resources resources)
    {
        return resources.getString(0x7f070124);
    }

    public String getTrackingEventName()
    {
        return "MyEbaySellingList";
    }

    public void invalidate()
    {
        super.invalidate();
        if (dm != null)
        {
            dm.forceReloadActiveList(sellingListRefinement);
        }
    }

    protected boolean isRefineEnabled()
    {
        return true;
    }

    public void onActiveListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        super.onActiveListChanged(myebaysellingdatamanager, listcontent);
        if (sellingListRefinement != null && "activeAll".equals(sellingListRefinement.filter))
        {
            setList(listcontent, null);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        sellingListRefinement = SellingListRefinement.buildDefaultActive();
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
            dm.loadActiveList(restorePage, sellingListRefinement);
        }
        if (pendingRefresh)
        {
            invalidate();
        }
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        dm.loadActiveList(j, sellingListRefinement);
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
