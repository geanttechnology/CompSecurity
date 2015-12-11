// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayNowUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBaseActivity;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.activities:
//            SignInModalActivity

public class EbnOrderDetailsActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String PARAM_FORCE_RELOAD = "param_force_reload";
    private static final String PARAM_FROM_ACTIVITY = "param_from_activity";
    public static final String PARAM_VIEW_DATA = "param_view_data";
    private static final String TWO_LINE_TEXT_FORMAT = "%s%n%s";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private String galleryImageHost;
    private ImageCache imageCache;
    private boolean isForceReload;
    private boolean isFromActivity;
    private boolean showingMoreOrderStatusUpdates;
    private SourceIdentification sid;
    private ViewItemViewData viewData;

    public EbnOrderDetailsActivity()
    {
        showingMoreOrderStatusUpdates = false;
        isFromActivity = false;
        isForceReload = false;
    }

    public static final void StartActivity(Context context, ViewItemViewData viewitemviewdata, SourceIdentification sourceidentification)
    {
        Intent intent = new Intent(context, com/ebay/mobile/activities/EbnOrderDetailsActivity);
        intent.putExtra("param_view_data", viewitemviewdata);
        intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        intent.putExtra("param_from_activity", true);
        context.startActivity(intent);
    }

    private void addOrderStatusRow(LayoutInflater layoutinflater, ViewGroup viewgroup, ShipmentTrackingScanDetail shipmenttrackingscandetail)
    {
        TextView textview;
        layoutinflater = layoutinflater.inflate(0x7f03008e, viewgroup, false);
        if (viewgroup.getChildCount() > 0)
        {
            ((android.view.ViewGroup.MarginLayoutParams)layoutinflater.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(0x7f090073);
        }
        ((TextView)layoutinflater.findViewById(0x7f100188)).setText(shipmenttrackingscandetail.eventDesc);
        textview = (TextView)layoutinflater.findViewById(0x7f100189);
        if (TextUtils.isEmpty(shipmenttrackingscandetail.eventCity) || TextUtils.isEmpty(shipmenttrackingscandetail.eventStateOrProvince)) goto _L2; else goto _L1
_L1:
        textview.setText((new StringBuilder()).append(shipmenttrackingscandetail.eventCity).append(", ").append(shipmenttrackingscandetail.eventStateOrProvince).toString());
_L4:
        shipmenttrackingscandetail = shipmenttrackingscandetail.eventTime;
        ((TextView)layoutinflater.findViewById(0x7f10018a)).setText(Util.formattedTimeAndDate("%s%n%s", shipmenttrackingscandetail));
        viewgroup.addView(layoutinflater);
        return;
_L2:
        if (!TextUtils.isEmpty(shipmenttrackingscandetail.eventCity))
        {
            textview.setText(shipmenttrackingscandetail.eventCity);
        } else
        if (!TextUtils.isEmpty(shipmenttrackingscandetail.eventStateOrProvince))
        {
            textview.setText(shipmenttrackingscandetail.eventStateOrProvince);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void createUI()
    {
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        com.ebay.mobile.util.EbayNowUtil.EbnOrderState ebnorderstate;
        obj3 = getResources();
        ebnorderstate = EbayNowUtil.getOrderState(item.iTransaction, item.tracking);
        obj4 = findViewById(0x7f100178);
        obj5 = findViewById(0x7f10017d);
        Object obj = null;
        obj2 = obj;
        if (item.tracking != null)
        {
            obj2 = obj;
            if (item.tracking.details != null)
            {
                obj2 = obj;
                if (item.tracking.details.size() > 0)
                {
                    obj2 = (ShipmentTrackingDetail)item.tracking.details.get(item.tracking.details.size() - 1);
                }
            }
        }
        findViewById(0x7f100177).setVisibility(0);
        if (ebnorderstate != com.ebay.mobile.util.EbayNowUtil.EbnOrderState.CANCELLED) goto _L2; else goto _L1
_L1:
        ((View) (obj4)).setVisibility(8);
        ((View) (obj5)).setVisibility(0);
        ((TextView)findViewById(0x7f10017e)).setText(EbayNowUtil.getCancelledReason(this, item.iTransaction));
_L4:
        Object obj1 = (LayoutInflater)getSystemService("layout_inflater");
        if (obj2 != null)
        {
            int i = ((ShipmentTrackingDetail) (obj2)).scanDetails.size();
            if (i > 0)
            {
                findViewById(0x7f10017f).setVisibility(0);
                findViewById(0x7f100180).setVisibility(0);
                obj2 = (ShipmentTrackingScanDetail)((ShipmentTrackingDetail) (obj2)).scanDetails.get(0);
                obj3 = (ViewGroup)findViewById(0x7f100182);
                ((ViewGroup) (obj3)).removeAllViews();
                addOrderStatusRow(((LayoutInflater) (obj1)), ((ViewGroup) (obj3)), ((ShipmentTrackingScanDetail) (obj2)));
                if (i > 1)
                {
                    obj2 = findViewById(0x7f100183);
                    ((View) (obj2)).setVisibility(0);
                    ((View) (obj2)).setOnClickListener(this);
                }
            }
        }
        obj4 = DeviceConfiguration.getAsync();
        if (item.id > 0L && item.transactionId != null && item.title != null && !TextUtils.isEmpty(item.title.getContent(((DeviceConfiguration) (obj4)).get(DcsBoolean.itemTitleTranslationEnabled))))
        {
            findViewById(0x7f100186).setVisibility(0);
            obj2 = (ViewGroup)findViewById(0x7f100187);
            ((ViewGroup) (obj2)).setVisibility(0);
            obj3 = ((LayoutInflater) (obj1)).inflate(0x7f03012b, ((ViewGroup) (obj2)), false);
            obj1 = (TextView)((View) (obj3)).findViewById(0x7f100108);
            ((TextView) (obj1)).setBackgroundColor(getResources().getColor(0x106000d));
            ((TextView) (obj1)).setText(item.title.getContent(((DeviceConfiguration) (obj4)).get(DcsBoolean.itemTitleTranslationEnabled)));
            obj1 = null;
            if (galleryImageHost != null)
            {
                obj1 = (new StringBuilder()).append("http://").append(galleryImageHost).append("/d/l200/pict/").append(item.id).append(".JPG").toString();
            }
            obj4 = (ImageView)((View) (obj3)).findViewById(0x7f1002ed);
            imageCache.setImage(((ImageView) (obj4)), ((String) (obj1)));
            ((ViewGroup) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

                final EbnOrderDetailsActivity this$0;

                public void onClick(View view)
                {
                    if (Util.hasNetwork())
                    {
                        if ((view = ((View) (view.getTag()))) instanceof Pair)
                        {
                            view = (Pair)view;
                            ItemViewActivity.StartActivity(EbnOrderDetailsActivity.this, ((Long)((Pair) (view)).first).longValue(), (String)((Pair) (view)).second, com.ebay.common.ConstantsCommon.ItemKind.Won);
                            finish();
                            return;
                        }
                    }
                }

            
            {
                this$0 = EbnOrderDetailsActivity.this;
                super();
            }
            });
            ((ViewGroup) (obj2)).setTag(new Pair(Long.valueOf(item.id), Long.toString(item.transactionId.longValue())));
            ((ViewGroup) (obj2)).addView(((View) (obj3)));
        }
        showLayout(com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
        return;
_L2:
        int j;
        ((View) (obj4)).setVisibility(0);
        ((View) (obj5)).setVisibility(8);
        int k = 0x7f07038e;
        obj5 = ((Resources) (obj3)).getString(0x7f07038d);
        obj3 = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
        java.util.Date date = ((java.util.Date) (obj3));
        if (item.tracking != null)
        {
            date = ((java.util.Date) (obj3));
            if (item.tracking.estimatedDeliveryDate != null)
            {
                date = item.tracking.estimatedDeliveryDate;
            }
        }
        obj3 = date;
        obj4 = obj5;
        j = k;
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[];
            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState = new int[com.ebay.mobile.util.EbayNowUtil.EbnOrderState.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.EbayNowUtil.EbnOrderState.PENDING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.EbayNowUtil.EbnOrderState.IN_TRANSIT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.EbayNowUtil.EbnOrderState.DELIVERED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$util$EbayNowUtil$EbnOrderState[com.ebay.mobile.util.EbayNowUtil.EbnOrderState.CANCELLED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.ebay.mobile.util.EbayNowUtil.EbnOrderState[ebnorderstate.ordinal()])
        {
        default:
            j = k;
            obj4 = obj5;
            obj3 = date;
            break;

        case 1: // '\001'
        case 2: // '\002'
            break;

        case 3: // '\003'
            break; /* Loop/switch isn't completed */
        }
_L5:
        ((TextView)findViewById(0x7f100179)).setText(j);
        if (obj3 != null)
        {
            ((TextView)findViewById(0x7f10017a)).setText(Util.formattedTimeAndDate(((String) (obj4)), ((java.util.Date) (obj3))));
        }
        if (obj2 != null)
        {
            ((TextView)findViewById(0x7f10017b)).setText(((ShipmentTrackingDetail) (obj2)).trackingNumber);
        }
        String s = String.format("%s%n%s", new Object[] {
            EbayCurrencyUtil.formatDisplay(item.iTransaction.selectedShippingOption.shippingServiceCost, 0), ""
        });
        ((TextView)findViewById(0x7f10017c)).setText(s);
        if (true) goto _L4; else goto _L3
_L3:
        j = 0x7f07038a;
        obj4 = "%s%n%s";
        obj3 = item.iTransaction.orderShippingInfo.actualDeliveryDate;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    private void showLayout(com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState layoutstate)
    {
        View view = findViewById(0x7f100016);
        if (layoutstate != com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL) goto _L2; else goto _L1
_L1:
        view.setVisibility(0);
_L4:
        ItemViewCommonProgressAndError.showLayouts(this, layoutstate);
        return;
_L2:
        if (layoutstate == com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.PROGRESS)
        {
            view.setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void showOrHideExpandedOrderStatus(boolean flag)
    {
        Object obj = null;
        ShipmentTrackingDetail shipmenttrackingdetail = obj;
        if (item.tracking != null)
        {
            shipmenttrackingdetail = obj;
            if (item.tracking.details != null)
            {
                shipmenttrackingdetail = obj;
                if (item.tracking.details.size() > 0)
                {
                    shipmenttrackingdetail = (ShipmentTrackingDetail)item.tracking.details.get(item.tracking.details.size() - 1);
                }
            }
        }
        if (shipmenttrackingdetail != null && shipmenttrackingdetail.scanDetails != null && shipmenttrackingdetail.scanDetails.size() > 0)
        {
            ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100182);
            if (flag)
            {
                LayoutInflater layoutinflater = (LayoutInflater)getSystemService("layout_inflater");
                for (int i = 1; i < shipmenttrackingdetail.scanDetails.size(); i++)
                {
                    addOrderStatusRow(layoutinflater, viewgroup, (ShipmentTrackingScanDetail)shipmenttrackingdetail.scanDetails.get(i));
                }

            } else
            {
                viewgroup.removeViews(1, shipmenttrackingdetail.scanDetails.size() - 1);
            }
        }
    }

    public String getTrackingEventName()
    {
        return "EbnOrderDetails";
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755395: 
            int i;
            boolean flag;
            if (!showingMoreOrderStatusUpdates)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showingMoreOrderStatusUpdates = flag;
            view = (ImageView)findViewById(0x7f100185);
            if (showingMoreOrderStatusUpdates)
            {
                i = 0x7f020256;
            } else
            {
                i = 0x7f020252;
            }
            view.setImageResource(i);
            view = (TextView)findViewById(0x7f100184);
            if (showingMoreOrderStatusUpdates)
            {
                i = 0x7f07039e;
            } else
            {
                i = 0x7f07039f;
            }
            view.setText(i);
            showOrHideExpandedOrderStatus(showingMoreOrderStatusUpdates);
            return;

        case 2131755328: 
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Intent intent;
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                bundle
            });
        }
        super.onCreate(bundle);
        setContentView(0x7f03008d);
        intent = getIntent();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        viewData = (ViewItemViewData)bundle.getParcelable("param_view_data");
        sid = (SourceIdentification)bundle.getParcelable("com.ebay.mobile.analytics.sid");
        isFromActivity = bundle.getBoolean("param_from_activity");
        isForceReload = bundle.getBoolean("param_force_reload");
_L4:
        if (verboseLogger.isLoggable)
        {
            verboseLogger.log((new StringBuilder()).append("Created with ViewData: ").append(viewData).toString());
        }
        if (intent.getIntExtra("noti_type_id", -1) != -1)
        {
            ServiceStarter.startUpdateNotificationCacheService(this, intent.getStringExtra("event_type"), intent.getStringExtra("order_id"));
        }
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
        }
        imageCache = new ImageCache(this, MyApp.getDeviceConfiguration().getGalleryImageHost());
        galleryImageHost = MyApp.getDeviceConfiguration().getGalleryImageHost();
        initDataManagers();
        return;
_L2:
        viewData = (ViewItemViewData)intent.getParcelableExtra("param_view_data");
        sid = (SourceIdentification)intent.getParcelableExtra("com.ebay.mobile.analytics.sid");
        isFromActivity = intent.getBooleanExtra("param_from_activity", false);
        if (!isFromActivity)
        {
            isForceReload = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        isForceReload = false;
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
        if (!content.getStatus().hasError())
        {
            switch (_cls2..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
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
        datamanagercontainer = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        if (isForceReload)
        {
            datamanagercontainer.forceReloadData(viewData);
            return;
        } else
        {
            datamanagercontainer.loadData(this, viewData);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (0x102002c == menuitem.getItemId())
        {
            if (!isFromActivity)
            {
                ItemViewActivity.StartActivity(this, item.id, Long.toString(item.transactionId.longValue()), com.ebay.common.ConstantsCommon.ItemKind.Won);
            }
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        super.onResume();
        Intent intent = getIntent();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        NotificationTrackingUtil.addNotificationTracking(this, trackingdata, intent, intent.getStringExtra("event_type"));
        trackingdata.addSourceIdentification(intent);
        trackingdata.send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                bundle
            });
        }
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("com.ebay.mobile.analytics.sid", sid);
        bundle.putParcelable("param_view_data", viewData);
        bundle.putBoolean("param_from_activity", isFromActivity);
        bundle.putBoolean("param_force_reload", isForceReload);
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EbnOrderDetails", 3, "Log eBay Now Order Details events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended eBay Now Order Details events");
    }
}
