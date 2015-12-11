// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.EbayOrder;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderItemTransaction;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.common.net.api.inventory.GetLocationDetailsResponse;
import com.ebay.common.net.api.inventory.GetStoreLocationNetLoader;
import com.ebay.common.net.api.trading.GetItemTransactionsNetLoader;
import com.ebay.common.net.api.trading.GetItemTransactionsResponse;
import com.ebay.common.net.api.trading.GetOrdersNetLoader;
import com.ebay.common.net.api.trading.GetOrdersResponse;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, OrderSummaryInstructionsActivity, SignInModalActivity

public class OrderSummaryActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    public static final String BUNDLE_EST_DELIVERY_DATE = "est_delivery_date";
    public static final String BUNDLE_HOURS_OFFSET = "hours_offset";
    public static final String BUNDLE_ORDER = "order";
    public static final String BUNDLE_ORDER_ID = "order_id";
    public static final String BUNDLE_STORE_DETAILS = "store_details";
    public static final String BUNDLE_TRANSACTION = "transaction";
    public static final int LOADER_GET_ITEM_TRANSACTION = 2;
    public static final int LOADER_GET_LOCATION_DETAILS = 3;
    public static final int LOADER_GET_ORDERS = 1;
    private Date estDeliveryDate;
    private String galleryImageHost;
    private int hoursOffset;
    private ImageCache imageCache;
    private EbayOrder order;
    private String orderId;
    private View pickupInstructions;
    private LocationDetails storeDetails;
    private ItemTransaction transaction;

    public OrderSummaryActivity()
    {
    }

    public static final void StartActivity(Context context, String s, SourceIdentification sourceidentification)
    {
        Intent intent = new Intent(context, com/ebay/mobile/activities/OrderSummaryActivity);
        intent.putExtra("order_id", s);
        intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        context.startActivity(intent);
    }

    public static int getBannerColor(Activity activity, ItemTransaction itemtransaction)
    {
        if (itemtransaction != null) goto _L2; else goto _L1
_L1:
        OrderPickupStatus orderpickupstatus;
        return 0x7f0d00ee;
_L2:
        if ((orderpickupstatus = itemtransaction.pickupStatus) == null) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (itemtransaction.isInStoreCredit() || itemtransaction.isPaymentRefund())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return !(activity instanceof ItemViewActivity) ? 0x7f0d00f0 : 0x7f0d00e7;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus = new int[OrderPickupStatus.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.Pickedup.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PendingMerchantConfirmation.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.ReadyToPickup.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledBuyerNoShow.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledBuyerRejected.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledOutOfStock.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.ebay.nautilus.domain.data.OrderPickupStatus[orderpickupstatus.ordinal()])
        {
        default:
            return 0x7f0d00ee;

        case 1: // '\001'
            return 0x7f0d00e3;

        case 2: // '\002'
            if (itemtransaction.isInStoreCredit() || itemtransaction.isPaymentRefund())
            {
                return 0x7f0d00e7;
            }
            break;

        case 3: // '\003'
            return 0x7f0d00e9;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return 0x7f0d00f0;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static DateFormat getDateFormatter(Context context)
    {
        if (Locale.getDefault().equals(Locale.GERMANY) || Locale.getDefault().equals(Locale.GERMAN))
        {
            return DateFormat.getDateInstance(3, Locale.getDefault());
        } else
        {
            return android.text.format.DateFormat.getDateFormat(context);
        }
    }

    public static Intent getGoogleMapsIntent(LocationAddress locationaddress)
    {
        if (!TextUtils.isEmpty(locationaddress.address1) && !TextUtils.isEmpty(locationaddress.postalCode))
        {
            return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("geo:0,0?q=").append(locationaddress.address1).append(" ").append(locationaddress.postalCode).toString()));
        } else
        {
            StringBuffer stringbuffer = new StringBuffer("saddr=");
            locationaddress = (new StringBuffer("&daddr=")).append(locationaddress.latitude).append(",").append(locationaddress.longitude);
            return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://maps.google.com/maps?").append(stringbuffer.toString()).append(locationaddress.toString()).toString()));
        }
    }

    private void getItemTransactions(EbayOrder ebayorder)
    {
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj != null && ebayorder != null && ebayorder.transactions != null && ebayorder.transactions.size() > 0)
        {
            ebayorder = (OrderItemTransaction)ebayorder.transactions.get(0);
            obj = EbayApiUtil.getTradingApi(this, ((Authentication) (obj)));
            ebayorder = new GetItemTransactionsNetLoader(getEbayContext(), ((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), Long.parseLong(((OrderItemTransaction) (ebayorder)).itemId), Long.parseLong(((OrderItemTransaction) (ebayorder)).transactionId));
            getFwLoaderManager().start(2, ebayorder, true);
        }
    }

    private void getLocationDetails()
    {
        if (MyApp.getPrefs().getAuthentication() != null && order != null && transaction != null)
        {
            GetStoreLocationNetLoader getstorelocationnetloader = new GetStoreLocationNetLoader(getEbayContext(), transaction.sellerUserId, order.storeId);
            getFwLoaderManager().start(3, getstorelocationnetloader, true);
        }
    }

    private void getOrders(String s)
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null && s != null)
        {
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            s = new GetOrdersNetLoader(getEbayContext(), EbayApiUtil.getTradingApi(this, authentication), authentication.iafToken, Locale.getDefault(), s);
            getFwLoaderManager().start(1, s, true);
        }
    }

    private void onGetItemTransactionsComplete(GetItemTransactionsNetLoader getitemtransactionsnetloader)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!getitemtransactionsnetloader.isError())
        {
            flag = flag1;
            if (getitemtransactionsnetloader.getResponse() != null)
            {
                flag = flag1;
                if (((GetItemTransactionsResponse)getitemtransactionsnetloader.getResponse()).getItemTransaction() != null)
                {
                    transaction = ((GetItemTransactionsResponse)getitemtransactionsnetloader.getResponse()).getItemTransaction();
                    flag = flag1;
                    if (!TextUtils.isEmpty(transaction.sellerUserId))
                    {
                        if (storeDetails == null)
                        {
                            getLocationDetails();
                        } else
                        {
                            render();
                        }
                        flag = true;
                    }
                }
            }
        }
        if (!flag)
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.updateLayoutForLoaderError(this, getitemtransactionsnetloader));
        }
    }

    private void onGetLocationDetailsComplete(GetStoreLocationNetLoader getstorelocationnetloader)
    {
        boolean flag1 = false;
        GetLocationDetailsResponse getlocationdetailsresponse = getstorelocationnetloader.getResponse();
        boolean flag = flag1;
        if (!getstorelocationnetloader.isError())
        {
            flag = flag1;
            if (getlocationdetailsresponse != null)
            {
                flag = flag1;
                if (getlocationdetailsresponse.isLocationFound())
                {
                    storeDetails = getlocationdetailsresponse.locationDetails;
                    render();
                    flag = true;
                }
            }
        }
        if (!flag)
        {
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR);
        }
    }

    private void onGetOrders(GetOrdersNetLoader getordersnetloader)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!getordersnetloader.isError())
        {
            flag = flag1;
            if (getordersnetloader.getResponse() != null)
            {
                List list = ((GetOrdersResponse)getordersnetloader.getResponse()).orders;
                if (list != null && list.size() > 0)
                {
                    flag = true;
                    order = (EbayOrder)list.get(0);
                    getItemTransactions(order);
                } else
                {
                    flag = flag1;
                }
            }
        }
        if (!flag)
        {
            if (!getordersnetloader.isConnectionError())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                getordersnetloader = com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR;
            } else
            {
                getordersnetloader = com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.CONNECTION_ERROR;
            }
            ItemViewCommonProgressAndError.showLayouts(this, getordersnetloader);
        }
    }

    private void render()
    {
        if (order != null)
        {
            findViewById(0x7f100016).setVisibility(0);
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
            if (!transaction.isInStoreCredit() && !transaction.isPaymentRefund());
            OrderPickupStatus.PickupCancelledOutOfStock.equals(transaction.pickupStatus);
            setupBanner(true, getBannerColor(this, transaction));
            Object obj = PickupUtil.getOrderStatusText(this, transaction, order);
            ((TextView)findViewById(0x7f1004a1)).setText(((CharSequence) (obj)));
            obj = PickupUtil.getOrderStatusSubText(this, transaction);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                TextView textview = (TextView)findViewById(0x7f1004a2);
                textview.setText(((CharSequence) (obj)));
                textview.setVisibility(0);
            }
            LayoutInflater layoutinflater = LayoutInflater.from(this);
            Resources resources = getResources();
            Object obj1 = new ArrayList();
            obj = (ViewGroup)findViewById(0x7f1004a3);
            ((ViewGroup) (obj)).removeAllViews();
            if (transaction.createdDate != null)
            {
                ((List) (obj1)).add(Util.createViewItemStatFormattedDate(this, layoutinflater, ((ViewGroup) (obj)), resources.getString(0x7f07093b), transaction.createdDate));
            }
            if (transaction.pickupStatus == OrderPickupStatus.PendingMerchantConfirmation && estDeliveryDate != null)
            {
                ((List) (obj1)).add(Util.createViewItemStat(layoutinflater, ((ViewGroup) (obj)), resources.getString(0x7f07079a), Util.getEstimatedPickupDateString(this, estDeliveryDate, false)));
            }
            if (storeDetails != null && !TextUtils.isEmpty(storeDetails.pickupInstructions))
            {
                pickupInstructions = Util.createViewItemStatTruncated(layoutinflater, ((ViewGroup) (obj)), resources.getString(0x7f070795), storeDetails.pickupInstructions);
                ((List) (obj1)).add(pickupInstructions);
            }
            if (transaction.shipmentTrackingDetails != null && transaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)transaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
            {
                ((List) (obj1)).add(Util.createViewItemStat(layoutinflater, ((ViewGroup) (obj)), resources.getString(0x7f070b7e), ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)transaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
            }
            if (((List) (obj1)).size() > 0)
            {
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    View view = (View)((Iterator) (obj1)).next();
                    ((ViewGroup) (obj)).addView(view);
                    if (pickupInstructions.equals(view))
                    {
                        view.setOnClickListener(this);
                    }
                } while (true);
                ((ViewGroup) (obj)).setVisibility(0);
            }
            ArrayList arraylist = new ArrayList();
            obj1 = (ViewGroup)findViewById(0x7f1004a5);
            ((ViewGroup) (obj1)).removeAllViews();
            if (storeDetails != null)
            {
                if (storeDetails.address != null)
                {
                    arraylist.add(Util.createViewItemStatTertiary(this, layoutinflater, ((ViewGroup) (obj1)), resources.getString(0x7f070191), PickupUtil.formatStoreAddress(storeDetails.address)));
                }
                if (!TextUtils.isEmpty(storeDetails.phone))
                {
                    arraylist.add(Util.createViewItemStatPhone(this, layoutinflater, ((ViewGroup) (obj1)), resources.getString(0x7f070773), storeDetails.phone));
                }
                String s = null;
                if (storeDetails.hours != null)
                {
                    s = PickupUtil.formatStoreHours(this, storeDetails.hours, hoursOffset);
                }
                if (!TextUtils.isEmpty(s))
                {
                    arraylist.add(Util.createViewItemStat(layoutinflater, ((ViewGroup) (obj1)), resources.getString(0x7f070193), s));
                }
            }
            if (arraylist.size() > 0)
            {
                for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((ViewGroup) (obj1)).addView((View)iterator.next())) { }
                ((ViewGroup) (obj1)).setVisibility(0);
                findViewById(0x7f1004a4).setVisibility(0);
            }
            arraylist = new ArrayList();
            obj1 = (ViewGroup)findViewById(0x7f1004a7);
            ((ViewGroup) (obj1)).removeAllViews();
            if (order.transactions != null && order.transactions.size() > 0)
            {
                final View row;
                for (Iterator iterator2 = order.transactions.iterator(); iterator2.hasNext(); arraylist.add(row))
                {
                    OrderItemTransaction orderitemtransaction = (OrderItemTransaction)iterator2.next();
                    row = layoutinflater.inflate(0x7f030194, null, false);
                    row.setBackgroundResource(0x7f020274);
                    ((TextView)row.findViewById(0x7f10005f)).setText(orderitemtransaction.title);
                    ImageView imageview = null;
                    String s1 = imageview;
                    if (galleryImageHost != null)
                    {
                        s1 = imageview;
                        if (!TextUtils.isEmpty(orderitemtransaction.itemId))
                        {
                            s1 = (new StringBuilder()).append("http://").append(galleryImageHost).append("/d/l200/pict/").append(orderitemtransaction.itemId).append(".JPG").toString();
                        }
                    }
                    imageview = (ImageView)row.findViewById(0x7f10005b);
                    imageCache.setImage(imageview, s1);
                    row.setOnClickListener(new android.view.View.OnClickListener() {

                        final OrderSummaryActivity this$0;
                        final View val$row;

                        public void onClick(View view1)
                        {
                            if (Util.hasNetwork())
                            {
                                if ((view1 = ((View) (row.getTag()))) instanceof OrderItemTransaction)
                                {
                                    view1 = (OrderItemTransaction)view1;
                                    InventoryInfo inventoryinfo = new InventoryInfo();
                                    inventoryinfo.setSelectedStore(new StoreAvailability(storeDetails));
                                    inventoryinfo.setSellerUserId(transaction.sellerUserId);
                                    inventoryinfo.setItemSku(((OrderItemTransaction) (view1)).sku);
                                    ItemViewActivity.StartActivity(OrderSummaryActivity.this, Long.parseLong(((OrderItemTransaction) (view1)).itemId), ((OrderItemTransaction) (view1)).transactionId, com.ebay.common.ConstantsCommon.ItemKind.Won, inventoryinfo);
                                    return;
                                }
                            }
                        }

            
            {
                this$0 = OrderSummaryActivity.this;
                row = view;
                super();
            }
                    });
                    row.setTag(orderitemtransaction);
                }

            }
            if (arraylist.size() > 0)
            {
                for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); ((ViewGroup) (obj1)).addView((View)iterator1.next())) { }
                ((ViewGroup) (obj1)).setVisibility(0);
                findViewById(0x7f1004a6).setVisibility(0);
            }
            return;
        } else
        {
            ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR);
            return;
        }
    }

    private void setupBanner(boolean flag, int i)
    {
        View view = findViewById(0x7f1004a0);
        if (flag)
        {
            view.setVisibility(0);
            view.setBackgroundColor(getResources().getColor(i));
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    public String getTrackingEventName()
    {
        return "OrderSummary";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 65 65: default 28
    //                   65 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            if (!TextUtils.isEmpty(orderId))
            {
                getOrders(orderId);
                return;
            }
        } else
        {
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        if (!Util.hasNetwork())
        {
            return;
        }
        if (view.equals(pickupInstructions))
        {
            view = new Intent(this, com/ebay/mobile/activities/OrderSummaryInstructionsActivity);
            view.putExtra("order_instructions", storeDetails.pickupInstructions);
            startActivity(view);
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131755327: 
            getOrders(orderId);
            return;

        case 2131756197: 
            startActivity(getGoogleMapsIntent(storeDetails.address));
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030192);
        imageCache = new ImageCache(this, MyApp.getDeviceConfiguration().getGalleryImageHost());
        galleryImageHost = MyApp.getDeviceConfiguration().getGalleryImageHost();
        findViewById(0x7f10013f).setOnClickListener(this);
        findViewById(0x7f1004a5).setOnClickListener(this);
        if (bundle != null)
        {
            orderId = bundle.getString("order_id");
            order = (EbayOrder)bundle.getParcelable("order");
            storeDetails = (LocationDetails)bundle.getParcelable("store_details");
            transaction = (ItemTransaction)bundle.getParcelable("transaction");
            long l = bundle.getLong("est_delivery_date");
            if (l != 0L)
            {
                estDeliveryDate = new Date(l);
            }
            hoursOffset = bundle.getInt("hours_offset");
        } else
        {
            bundle = getIntent();
            orderId = bundle.getStringExtra("order_id");
            storeDetails = (LocationDetails)bundle.getParcelableExtra("store_details");
            long l1 = bundle.getLongExtra("est_delivery_date", 0L);
            if (l1 != 0L)
            {
                estDeliveryDate = new Date(l1);
            }
            if (bundle.getIntExtra("noti_type_id", -1) != -1)
            {
                ServiceStarter.startUpdateNotificationCacheService(this, bundle.getStringExtra("event_type"), orderId);
            }
            hoursOffset = bundle.getIntExtra("hours_offset", 0);
        }
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            return;
        }
        if (order != null && storeDetails != null && transaction != null && transaction.sellerUserId != null)
        {
            render();
            return;
        }
        if (!TextUtils.isEmpty(orderId))
        {
            getOrders(orderId);
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        Intent intent = getIntent();
        NotificationTrackingUtil.addNotificationTracking(this, trackingdata, intent, intent.getStringExtra("event_type"));
        trackingdata.addSourceIdentification(intent);
        trackingdata.send(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("order", order);
        bundle.putParcelable("store_details", storeDetails);
        bundle.putParcelable("transaction", transaction);
        bundle.putString("order_id", orderId);
        if (estDeliveryDate != null)
        {
            bundle.putLong("est_delivery_date", estDeliveryDate.getTime());
        } else
        {
            bundle.putLong("est_delivery_date", 0L);
        }
        bundle.putInt("hours_offset", hoursOffset);
        super.onSaveInstanceState(bundle);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (fwloader.isCanceled()) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 46
    //                   3 55;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        onGetOrders((GetOrdersNetLoader)fwloader);
        return;
_L4:
        onGetItemTransactionsComplete((GetItemTransactionsNetLoader)fwloader);
        return;
_L5:
        onGetLocationDetailsComplete((GetStoreLocationNetLoader)fwloader);
        return;
    }


}
