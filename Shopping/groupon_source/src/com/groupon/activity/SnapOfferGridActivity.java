// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.groupon.Channel;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.fragment.SnapIntroDialog;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.SnapGrocerySyncManagerProcess;
import com.groupon.models.country.Country;
import com.groupon.models.nst.PageViewExtraInfo;
import com.groupon.models.nst.SnapGroceryGenericMetadata;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BaseRecyclerViewDelegate;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.adapter.mapping.GenericHeaderCardMapping;
import com.groupon.v3.adapter.mapping.SnapGroceryMapping;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.SnapGroceryLoader;
import com.groupon.v3.view.list_view.SnapGroceryDetailsWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            BaseRecyclerViewActivity, IntentFactory

public class SnapOfferGridActivity extends BaseRecyclerViewActivity
    implements CustomPageViewEvent
{

    private static final String CASH_BACK_FORMATTED = "0";
    private static final String DEFAULT_DECIMAL = ".00";
    private static final String GROCERIES = "Groceries";
    private static final int MIN_OFFER_COLUMN_SIZE = 200;
    private static final String OFFER_GRID = "offer_grid";
    private static final String SNAP_IMPRESSION = "snap_impression";
    private static final String SNAP_INTRO_DIALOG = "snapIntroDialog";
    CurrentCountryManager currentCountryManager;
    protected IntentFactory intentFactory;
    protected LoggingUtils loggingUtils;
    protected SharedPreferences prefs;
    private SnapIntroDialog snapIntroDialog;

    public SnapOfferGridActivity()
    {
    }

    private void onGroceryImageClick(SnapGroceryDetail snapgrocerydetail)
    {
        SnapGroceryGenericMetadata snapgrocerygenericmetadata = new SnapGroceryGenericMetadata();
        snapgrocerygenericmetadata.offerId = snapgrocerydetail.remoteId;
        snapgrocerygenericmetadata.pageId = "offer_grid";
        snapgrocerygenericmetadata.position = (new StringBuilder()).append(snapgrocerydetail.row).append(",").append(snapgrocerydetail.column).toString();
        loggingUtils.logClick(null, "snap_impression", "snap", null, snapgrocerygenericmetadata);
        startActivity(intentFactory.newGroceryDetailIntent(snapgrocerydetail.remoteId, snapgrocerydetail.productName, Channel.safeValueOf(dbChannel)));
    }

    public static void reformatPrice(SnapGroceryDetail snapgrocerydetail)
    {
        if (snapgrocerydetail.cashBackInteger.equals("0"))
        {
            if (snapgrocerydetail.cashBack.indexOf(".") == -1)
            {
                snapgrocerydetail.cashBack = (new StringBuilder()).append(snapgrocerydetail.cashBack).append(".00").toString();
            }
            return;
        } else
        {
            snapgrocerydetail.cashBack = snapgrocerydetail.cashBack.split("\\.")[0];
            return;
        }
    }

    protected void configureEmptyView(View view)
    {
        ((Button)view.findViewById(0x7f1001ba)).setOnClickListener(new android.view.View.OnClickListener() {

            final SnapOfferGridActivity this$0;

            public void onClick(View view1)
            {
                universalSyncManager.requestSync(SnapOfferGridActivity.this, null);
            }

            
            {
                this$0 = SnapOfferGridActivity.this;
                super();
            }
        });
    }

    protected void configureLoaderAndAdapter(UniversalListAdapter universallistadapter, UniversalLoaderCallbacks universalloadercallbacks)
    {
        universalloadercallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            new SnapGroceryLoader(this, dbChannel, Channel.encodePath(new String[] {
                dbChannel, "TOP"
            }), currentCountryManager.getCurrentCountry().isUnitedStates())
        });
        universallistadapter.registerOverrideMapping((new SnapGroceryMapping()).registerCallback(com/groupon/v3/adapter/callback/IViewCallback, this));
        universallistadapter.registerOverrideMapping(new GenericHeaderCardMapping());
    }

    protected void configureSyncManager(UniversalSyncManager universalsyncmanager)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new SnapGrocerySyncManagerProcess(this, dbChannel));
        universalsyncmanager.configurePaginatedSyncManager(null, arraylist, new UniversalUpdateEvent(dbChannel));
    }

    public int getEmptyViewLayoutId()
    {
        return 0x7f030121;
    }

    public int getNumberOfItemsPerRow()
    {
        boolean flag = getResources().getBoolean(0x7f090007);
        int j = getResources().getInteger(0x7f0d0000);
        int k = getResources().getDisplayMetrics().widthPixels;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        k /= i * Math.round(200F * getResources().getDisplayMetrics().density);
        if (flag)
        {
            i = j;
        } else
        {
            i = 2;
        }
        return Math.max(k, i);
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        baseRecyclerViewDelegate.handleSyncError(runnable, exception, this);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle("Groceries");
    }

    public void logPageViewEvent()
    {
        logger.logPageView("", "offer_grid", new PageViewExtraInfo(null));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        snapIntroDialog = new SnapIntroDialog();
        if (!prefs.getBoolean("snap_intro_done", false) && bundle == null)
        {
            snapIntroDialog.show(getFragmentManager(), "snapIntroDialog");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f100020, 0, 0x7f0803b1).setIcon(0x7f0201f1).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        int k = 0;
        int l = getNumberOfItemsPerRow();
        SnapGroceryDetailsWrapper snapgrocerydetailswrapper = null;
        int i = 0;
        for (Iterator iterator = universallistloadresultdata.getListData().iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            if (obj instanceof SnapGroceryDetail)
            {
                obj = (SnapGroceryDetail)obj;
                reformatPrice(((SnapGroceryDetail) (obj)));
                if (k % l == 0)
                {
                    i = 0;
                    snapgrocerydetailswrapper = new SnapGroceryDetailsWrapper();
                    arraylist.add(snapgrocerydetailswrapper);
                }
                obj.row = k / l;
                obj.column = i;
                i++;
                k++;
                snapgrocerydetailswrapper.snapGroceryDetailList.add(obj);
            } else
            {
                arraylist.add(obj);
            }
        }

        if (snapgrocerydetailswrapper != null && k % l != 0)
        {
            for (int j = 0; j < l - k % l; j++)
            {
                SnapGroceryDetail snapgrocerydetail = new SnapGroceryDetail();
                snapgrocerydetail.isPlaceHolder = true;
                snapgrocerydetailswrapper.snapGroceryDetailList.add(snapgrocerydetail);
            }

        }
        super.onLoaderDataChanged(new UniversalListLoadResultData(arraylist, universallistloadresultdata.getDealSubsetAttribute(), universallistloadresultdata.getPagination()), flag);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755040 2131755040: default 24
    //                   2131755040 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        snapIntroDialog.show(getFragmentManager(), "snapIntroDialog");
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onViewBound(int i, Object obj)
    {
        SnapGroceryDetail snapgrocerydetail;
        SnapGroceryGenericMetadata snapgrocerygenericmetadata;
        for (obj = ((SnapGroceryDetailsWrapper)obj).snapGroceryDetailList.iterator(); ((Iterator) (obj)).hasNext(); loggingUtils.logImpression(null, "snap_impression", "snap", (new StringBuilder()).append(snapgrocerydetail.row).append(",").append(snapgrocerydetail.column).toString(), snapgrocerygenericmetadata))
        {
            snapgrocerydetail = (SnapGroceryDetail)((Iterator) (obj)).next();
            snapgrocerygenericmetadata = new SnapGroceryGenericMetadata();
            snapgrocerygenericmetadata.offerId = snapgrocerydetail.remoteId;
            snapgrocerygenericmetadata.pageId = "offer_grid";
        }

    }

    public void onViewClick(View view)
    {
        view = ((View) (view.getTag(0x7f100001)));
        if (view != null && view.getClass() == com/groupon/db/models/SnapGroceryDetail)
        {
            onGroceryImageClick((SnapGroceryDetail)view);
        }
    }
}
