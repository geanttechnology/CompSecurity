// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowFileWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.viewitem.fragments.ViewItemShippingPaymentsReturnsFragment;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ItemViewCommonProgressAndError, ItemViewActivity, ViewItemViewData, 
//            ViewItemDataManager

public class ViewItemShippingPaymentsReturnsActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener
{

    private int currentSiteId;
    private ViewItemShippingPaymentsReturnsFragment sprFragment;

    public ViewItemShippingPaymentsReturnsActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, int i)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ViewItemShippingPaymentsReturnsActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        activity.startActivityForResult(intent, i);
    }

    private void createProofPointsLayout()
    {
        LinearLayout linearlayout;
        Object obj;
        View view;
        int i;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.TopRatedSeller3))
        {
            view = findViewById(0x7f1008c6);
            view.setOnClickListener(this);
            linearlayout = (LinearLayout)findViewById(0x7f1008c9);
            obj = (TextView)findViewById(0x7f1008c8);
            Object obj1 = (TextView)findViewById(0x7f1008ca);
            String s = getFooterString();
            int j;
            if (s == null)
            {
                ((TextView) (obj1)).setVisibility(8);
            } else
            {
                ((TextView) (obj1)).setText(s);
            }
        } else
        {
            view = findViewById(0x7f1008c3);
            linearlayout = (LinearLayout)findViewById(0x7f1008c5);
            obj = (TextView)findViewById(0x7f1008c4);
        }
        obj1 = getResources().getStringArray(getETRSProofPointsArray());
        ((TextView) (obj)).setText(getHeaderString());
        view.setVisibility(0);
        ((ImageView)findViewById(0x7f100842)).setImageResource(getBadgeResourceId());
        obj = findViewById(0x7f1008c7);
        if (shouldDisplayLandingPageChevron())
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ((View) (obj)).setVisibility(i);
        linearlayout.removeAllViews();
        j = obj1.length;
        for (i = 0; i < j; i++)
        {
            obj = obj1[i];
            view = View.inflate(this, 0x7f030297, null);
            ((TextView)view.findViewById(0x7f1008da)).setText(((CharSequence) (obj)));
            linearlayout.addView(view);
        }

    }

    private void createUI()
    {
        setupImageViewPager();
        updateGalleryPhotos(viewData);
        headerStart(0x7f03012c);
        if (item.isShowTopRatedListing && MyApp.getDeviceConfiguration().isTopRatedSellerEnabled())
        {
            createProofPointsLayout();
        }
        sprFragment.render(item, viewData);
    }

    private int getBadgeResourceId()
    {
        switch (currentSiteId)
        {
        default:
            return 0x7f0201d2;

        case 77: // 'M'
            return 0x7f0201d0;
        }
    }

    private int getETRSProofPointsArray()
    {
        switch (currentSiteId)
        {
        default:
            return 0x7f0e000e;

        case 77: // 'M'
            return 0x7f0e0011;

        case 15: // '\017'
            return 0x7f0e000f;

        case 3: // '\003'
        case 205: 
            return 0x7f0e0012;

        case 16: // '\020'
        case 193: 
            return 0x7f0e0010;

        case 0: // '\0'
            return 0x7f0e0013;
        }
    }

    private String getFooterString()
    {
        switch (currentSiteId)
        {
        default:
            return null;

        case 77: // 'M'
            return getString(0x7f0700cf);
        }
    }

    private String getHeaderString()
    {
        switch (currentSiteId)
        {
        default:
            return getString(0x7f070b20);

        case 77: // 'M'
            return getString(0x7f0700cb);

        case 3: // '\003'
        case 15: // '\017'
        case 16: // '\020'
        case 193: 
        case 205: 
            return getString(0x7f070afc);
        }
    }

    private boolean shouldDisplayLandingPageChevron()
    {
        switch (currentSiteId)
        {
        default:
            return false;

        case 77: // 'M'
            return true;
        }
    }

    public String getTrackingEventName()
    {
        return "ViewItemShipping";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 11 11: default 20
    //                   11 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (-1 == j && MyApp.getPrefs().isSignedIn())
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            if (sprFragment != null)
            {
                sprFragment.setForceReRender();
            }
            viewData.shippingCostsPostalCode = ItemViewActivity.getShippingCostsPostalCode(viewData);
            viewItemDataManager.forceReloadData(viewData);
            intent = new Intent();
            intent.putExtra("refresh_item", true);
            intent.putExtra("view_item_view_data", viewData);
            setResult(-1, intent);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131757254: 
            switch (currentSiteId)
            {
            default:
                return;

            case 77: // 'M'
                ShowFileWebViewActivity.startActivity(this, MyApp.getDeviceConfiguration().topRatedSeller3Url(), Integer.valueOf(EbayCountryManager.getBuyerProtectionPageTitle()), "EBayBuyerProtection");
                break;
            }
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(getResources().getString(0x7f070a75));
        setContentView(0x7f030292);
        currentSiteId = EbaySite.getInstanceFromId(MyApp.getCurrentSite()).idInt;
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        if (sprFragment == null)
        {
            bundle = getFragmentManager();
            FragmentTransaction fragmenttransaction = bundle.beginTransaction();
            sprFragment = new ViewItemShippingPaymentsReturnsFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("full_expansion", true);
            sprFragment.setArguments(bundle1);
            fragmenttransaction.add(0x7f1008cb, sprFragment);
            fragmenttransaction.commit();
            bundle.executePendingTransactions();
        }
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        if (!content.getStatus().hasError())
        {
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                createUI();
                break;
            }
            return;
        } else
        {
            showMessage(0, content.getStatus());
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        ((ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this)).loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }
}
