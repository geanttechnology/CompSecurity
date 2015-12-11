// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.AddEditTrackingInfoActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemDataManager, ItemViewCommonProgressAndError, ViewItemViewData

public class ItemViewShipmentTrackingDetails extends ItemViewBaseActivity
{

    private static final int ACTIVITY_RESULT_ADD_OR_EDIT_TRACKING_NUMBER = 0;
    public static final String EXTRA_EDITABLE = "editable";
    private static final String kAPITrackingStatusDelivered = "DELIVERED";
    private static final String kAPITrackingStatusUnconfirmed = "UNCONFIRMED";
    private boolean editable;
    private LayoutInflater inflater;
    private long itemId;
    private Long transactionId;
    private final UserCache userCache = new UserCache(this);
    private ViewItemDataManager viewItemDataManager;

    public ItemViewShipmentTrackingDetails()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, Intent intent, int i)
    {
        Intent intent1 = new Intent(activity, com/ebay/mobile/viewitem/ItemViewShipmentTrackingDetails);
        intent1.putExtra("view_item_view_data", viewitemviewdata);
        if (intent != null)
        {
            intent1.putExtras(intent);
        }
        activity.startActivityForResult(intent1, i);
    }

    private void appendAllDetails(ViewGroup viewgroup, ShipmentTrackingDetail shipmenttrackingdetail, int i)
    {
        appendHeader(viewgroup, shipmenttrackingdetail);
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f030145, viewgroup, false);
        viewgroup.addView(viewgroup1);
        appendDetail(viewgroup1, shipmenttrackingdetail, i);
        for (viewgroup = shipmenttrackingdetail.scanDetails.iterator(); viewgroup.hasNext(); appendScanDetail(viewgroup1, (ShipmentTrackingScanDetail)viewgroup.next())) { }
        if (shipmenttrackingdetail.scanDetails.isEmpty() && !TextUtils.isEmpty(shipmenttrackingdetail.trackingNumber))
        {
            viewgroup = new Intent("android.intent.action.WEB_SEARCH");
            viewgroup.putExtra("query", shipmenttrackingdetail.trackingNumber);
            if (Util.isIntentHandlerAvailable(this, viewgroup))
            {
                appendGetTrackingInfo(viewgroup1, viewgroup);
            }
        }
    }

    private void appendDetail(ViewGroup viewgroup, ShipmentTrackingDetail shipmenttrackingdetail, final int index)
    {
        ViewGroup viewgroup1;
        byte byte1 = 8;
        viewgroup1 = (ViewGroup)inflater.inflate(0x7f030144, viewgroup, false);
        ViewGroup viewgroup2 = (ViewGroup)viewgroup1.findViewById(0x7f100332);
        byte byte0;
        if (TextUtils.isEmpty(shipmenttrackingdetail.carrier))
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        viewgroup2.setVisibility(byte0);
        if (!TextUtils.isEmpty(shipmenttrackingdetail.carrier))
        {
            setField(viewgroup1, 0x7f100333, shipmenttrackingdetail.carrier);
        }
        viewgroup2 = (ViewGroup)viewgroup1.findViewById(0x7f100334);
        if (TextUtils.isEmpty(shipmenttrackingdetail.trackingNumber))
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        viewgroup2.setVisibility(byte0);
        if (!TextUtils.isEmpty(shipmenttrackingdetail.trackingNumber))
        {
            setField(viewgroup1, 0x7f100335, shipmenttrackingdetail.trackingNumber);
        }
        viewgroup2 = (ViewGroup)viewgroup1.findViewById(0x7f100336);
        if ("DELIVERED".equals(shipmenttrackingdetail.trackingStatus))
        {
            setField(viewgroup1, 0x7f100337, getString(0x7f070288));
        } else
        if ("UNCONFIRMED".equals(shipmenttrackingdetail.trackingStatus))
        {
            setField(viewgroup1, 0x7f100337, getString(0x7f070a6d));
        } else
        if (item.tracking.estimatedDeliveryDate != null)
        {
            setField(viewgroup1, 0x7f100337, DateFormat.format(Util.getDeliveryDateFormat(this, false), item.tracking.estimatedDeliveryDate).toString());
        } else
        {
            viewgroup2.setVisibility(8);
        }
        shipmenttrackingdetail = viewgroup1.findViewById(0x7f1002eb);
        byte0 = byte1;
        if (item.isSeller)
        {
            byte0 = byte1;
            if (editable)
            {
                byte0 = 0;
            }
        }
        shipmenttrackingdetail.setVisibility(byte0);
        if (item.isSeller) goto _L2; else goto _L1
_L1:
        viewgroup1.setFocusable(false);
        viewgroup1.setBackgroundColor(getResources().getColor(0x106000d));
_L4:
        viewgroup.addView(viewgroup1);
        return;
_L2:
        if (editable)
        {
            viewgroup1.setOnClickListener(new android.view.View.OnClickListener() {

                final ItemViewShipmentTrackingDetails this$0;
                final int val$index;

                public void onClick(View view)
                {
                    boolean flag = true;
                    view = (ShipmentTrackingDetail)item.tracking.details.get(index);
                    Intent intent = new Intent(ItemViewShipmentTrackingDetails.this, com/ebay/mobile/activities/AddEditTrackingInfoActivity);
                    intent.putExtra("number", ((ShipmentTrackingDetail) (view)).trackingNumber);
                    intent.putExtra("carrier", ((ShipmentTrackingDetail) (view)).carrier);
                    intent.putExtra("index", index);
                    intent.putExtra("enter_vs_edit", false);
                    if (1 < item.tracking.details.size())
                    {
                        flag = false;
                    }
                    intent.putExtra("showRemoveWarning", flag);
                    startActivityForResult(intent, 0);
                }

            
            {
                this$0 = ItemViewShipmentTrackingDetails.this;
                index = i;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void appendGetTrackingInfo(ViewGroup viewgroup, final Intent search)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f03013d, viewgroup, false);
        viewgroup1.setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewShipmentTrackingDetails this$0;
            final Intent val$search;

            public void onClick(View view)
            {
                startActivity(search);
            }

            
            {
                this$0 = ItemViewShipmentTrackingDetails.this;
                search = intent;
                super();
            }
        });
        viewgroup.addView(viewgroup1);
    }

    private void appendHeader(ViewGroup viewgroup, ShipmentTrackingDetail shipmenttrackingdetail)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f030146, viewgroup, false);
        TextView textview = (TextView)viewgroup1.findViewById(0x7f1000ec);
        if (!shipmenttrackingdetail.hops.isEmpty())
        {
            if (!item.isSeller)
            {
                textview.setText(getString(0x7f070a62));
            } else
            {
                shipmenttrackingdetail = (com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop)shipmenttrackingdetail.hops.get(0);
                textview.setText(getString(0x7f070a61, new Object[] {
                    getHumanReadableHopString(((com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop) (shipmenttrackingdetail)).from), getHumanReadableHopString(((com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop) (shipmenttrackingdetail)).to)
                }));
            }
        } else
        {
            textview.setText(getString(0x7f070a60));
        }
        viewgroup.addView(viewgroup1);
    }

    private void appendScanDetail(ViewGroup viewgroup, ShipmentTrackingScanDetail shipmenttrackingscandetail)
    {
        ViewGroup viewgroup1;
        viewgroup1 = (ViewGroup)inflater.inflate(0x7f03022d, viewgroup, false);
        if (!TextUtils.isEmpty(shipmenttrackingscandetail.eventDesc))
        {
            setField(viewgroup1, 0x7f10072e, shipmenttrackingscandetail.eventDesc);
        }
        if (TextUtils.isEmpty(shipmenttrackingscandetail.eventCity) || TextUtils.isEmpty(shipmenttrackingscandetail.eventStateOrProvince)) goto _L2; else goto _L1
_L1:
        setField(viewgroup1, 0x7f10072f, (new StringBuilder()).append(shipmenttrackingscandetail.eventCity).append(", ").append(shipmenttrackingscandetail.eventStateOrProvince).toString());
_L4:
        if (shipmenttrackingscandetail.eventTime != null)
        {
            setField(viewgroup1, 0x7f100730, DateFormat.format(Util.getDeliveryDateFormat(this, true), shipmenttrackingscandetail.eventTime).toString());
        }
        viewgroup.addView(viewgroup1);
        return;
_L2:
        if (!TextUtils.isEmpty(shipmenttrackingscandetail.eventCity))
        {
            setField(viewgroup1, 0x7f10072f, shipmenttrackingscandetail.eventCity);
        } else
        if (!TextUtils.isEmpty(shipmenttrackingscandetail.eventStateOrProvince))
        {
            setField(viewgroup1, 0x7f10072f, shipmenttrackingscandetail.eventStateOrProvince);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void callApi()
    {
        if (viewItemDataManager != null)
        {
            Preferences preferences = MyApp.getPrefs();
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            viewItemDataManager.getShipmentTracking(preferences.getAuthentication().iafToken, preferences.getCurrentSite(), itemId, transactionId, deviceconfiguration.get(DcsBoolean.useRealtimeShipTracking), viewData);
        }
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
    }

    private String getHumanReadableHopString(String s)
    {
        String s1 = "";
        if ("seller".equalsIgnoreCase(s))
        {
            s1 = getString(0x7f070a67);
        } else
        {
            if ("buyer".equalsIgnoreCase(s))
            {
                return getString(0x7f070a66);
            }
            if ("warehouse".equalsIgnoreCase(s))
            {
                return getString(0x7f070a68);
            }
        }
        return s1;
    }

    private boolean isSellerLeg(ShipmentTrackingDetail shipmenttrackingdetail)
    {
        return !shipmenttrackingdetail.hops.isEmpty() && "seller".equals(((com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop)shipmenttrackingdetail.hops.get(0)).from);
    }

    private void setField(View view, int i, String s)
    {
        if (view != null)
        {
            view = (TextView)view.findViewById(i);
        } else
        {
            view = (TextView)findViewById(i);
        }
        view.setText(s);
    }

    private void setUI()
    {
        ViewGroup viewgroup;
        viewgroup = (ViewGroup)findViewById(0x7f1001dc);
        viewgroup.removeAllViews();
        if (!item.isSeller) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= item.tracking.details.size()) goto _L2; else goto _L3
_L3:
        ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)item.tracking.details.get(i);
        if (!isSellerLeg(shipmenttrackingdetail)) goto _L5; else goto _L4
_L4:
        appendAllDetails(viewgroup, shipmenttrackingdetail, i);
_L2:
        for (i = 0; i < item.tracking.details.size(); i++)
        {
            ShipmentTrackingDetail shipmenttrackingdetail1 = (ShipmentTrackingDetail)item.tracking.details.get(i);
            if (!isSellerLeg(shipmenttrackingdetail1))
            {
                appendAllDetails(viewgroup, shipmenttrackingdetail1, i);
            }
        }

        break; /* Loop/switch isn't completed */
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        View view = findViewById(0x7f100093);
        int j;
        if (item.isShowEnterTrackingNumber)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        ((Button)findViewById(0x7f10072d)).setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewShipmentTrackingDetails this$0;

            public void onClick(View view1)
            {
                view1 = new Intent(ItemViewShipmentTrackingDetails.this, com/ebay/mobile/activities/AddEditTrackingInfoActivity);
                view1.putExtra("index", item.tracking.details.size());
                view1.putExtra("enter_vs_edit", true);
                startActivityForResult(view1, 0);
            }

            
            {
                this$0 = ItemViewShipmentTrackingDetails.this;
                super();
            }
        });
        return;
    }

    public String getTrackingEventName()
    {
        return "TrackPackage";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i != 0 || -1 != j) goto _L2; else goto _L1
_L1:
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj = EbayApiUtil.getTradingApi(this, ((Authentication) (obj)));
        i = intent.getIntExtra("state", -1);
        j = intent.getIntExtra("index", 0);
        if (j >= item.tracking.details.size())
        {
            item.tracking.addDetail();
        }
        i;
        JVM INSTR tableswitch 0 2: default 104
    //                   0 228
    //                   1 109
    //                   2 109;
           goto _L4 _L5 _L6 _L6
_L4:
        setUI();
_L2:
        return;
_L6:
        ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)item.tracking.details.get(j);
        String s = intent.getStringExtra("number");
        intent = intent.getStringExtra("carrier");
        if (!TextUtils.equals(s, shipmenttrackingdetail.trackingNumber) || !TextUtils.equals(intent, shipmenttrackingdetail.carrier))
        {
            shipmenttrackingdetail.trackingNumber = s;
            shipmenttrackingdetail.carrier = intent;
            if (viewItemDataManager != null)
            {
                viewItemDataManager.addShipmentTracking(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), Long.valueOf(itemId), transactionId.longValue(), item.tracking, Boolean.valueOf(true), null);
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        item.tracking.details.remove(j);
        if (viewItemDataManager != null)
        {
            intent = viewItemDataManager;
            long l = itemId;
            long l1 = transactionId.longValue();
            ShipmentTracking shipmenttracking = item.tracking;
            boolean flag;
            if (!item.tracking.details.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            intent.addShipmentTracking(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), Long.valueOf(l), l1, shipmenttracking, Boolean.valueOf(flag), null);
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03022c);
        setTitle(getString(0x7f070a6a));
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        bundle = getIntent();
        viewData = (ViewItemViewData)bundle.getParcelableExtra("view_item_view_data");
        editable = bundle.getBooleanExtra("editable", true);
        itemId = viewData.keyParams.itemId;
        transactionId = viewData.keyParams.transactionId;
        initDataManagers();
        ((Button)findViewById(0x7f10013f)).setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewShipmentTrackingDetails this$0;

            public void onClick(View view)
            {
                callApi();
            }

            
            {
                this$0 = ItemViewShipmentTrackingDetails.this;
                super();
            }
        });
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (!isFinishing())
        {
            super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
            static class _cls5
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.GET_SHIPMENT_TRACKING.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.SHIPMENT_TRACKING.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            if (!content.getStatus().hasError())
            {
                switch (_cls5..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    if (item.tracking == null)
                    {
                        callApi();
                    } else
                    {
                        setUI();
                    }
                    headerStart(0x7f03012f);
                    ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
                    return;

                case 2: // '\002'
                    ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
                    setUI();
                    return;

                case 3: // '\003'
                    ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
                    break;
                }
                if (item.tracking.details.isEmpty())
                {
                    userCache.setShipped(item.getIdString(), String.valueOf(transactionId), false);
                    viewitemdatamanager = new Intent();
                    viewitemdatamanager.putExtra("refresh_item", true);
                    setResult(-1, viewitemdatamanager);
                    finish();
                    return;
                }
            } else
            {
                if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
                {
                    EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
                }
                switch (_cls5..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
                {
                default:
                    showMessage(0, content.getStatus());
                    return;

                case 2: // '\002'
                    ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
                    break;
                }
                ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.updateLayoutForLoaderError(this, content.getStatus()));
                return;
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

}
