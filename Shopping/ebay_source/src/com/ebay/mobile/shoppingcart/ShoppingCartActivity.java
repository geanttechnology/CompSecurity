// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.SlidingTabLayout;
import com.ebay.common.Preferences;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.CheckoutItem;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.ChangeCartItemQuantityActivity;
import com.ebay.mobile.checkout.CheckoutActivity;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.notifications.PollService;
import com.ebay.mobile.search.SellerOfferResultFragmentActivity;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.ui_stuff.MenuHandler;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartTabFragment, ShoppingCartTabFragmentAdapter, LocalizedCartMessage

public class ShoppingCartActivity extends ModalActivity
    implements android.support.v4.view.ViewPager.OnPageChangeListener, android.view.View.OnClickListener, android.widget.AdapterView.OnItemSelectedListener, ChangeItemQuantityFragment.ChangeItemQuantityDialogListener, ShoppingCartTabFragment.CheckoutListener, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{
    private final class ShoppingCartDataHandler extends com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver
    {

        final ShoppingCartActivity this$0;

        public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
        {
            handleShoppingCartChanged(shoppingcartdatamanagerbase, action, content);
        }

        public void onShoppingCartLoading(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action)
        {
            showProgress(true);
            showBottomActionBar(false, true);
        }

        private ShoppingCartDataHandler()
        {
            this$0 = ShoppingCartActivity.this;
            super();
        }

    }


    static final String EXTRA_CART_ITEM = "shopping_cart_item";
    public static final String EXTRA_LINE_ITEM_ID = "com.ebay.mobile.shoppingcart.ShoppingCartActivity.lineItemId";
    public static final String EXTRA_QUANTITY = "com.ebay.mobile.shoppingcart.ShoppingCartActivity.quantity";
    private static final String EXTRA_SHOPPING_CART = "shopping_cart_response";
    private static final String EXTRA_SHOULD_SEND_PAGE_IMPRESSION = "should_send_page_impression";
    public static final int MAX_GET_MULTIPLE_ITEM_CHUNK_COUNT = 20;
    static final int MAX_SELECTABLE_QUANTITY = 5;
    private static final int REQUEST_CHANGE_QUANTITY = 0;
    private static final int REQUEST_CHECKOUT = 1;
    public static final boolean SHOW_OPTIONS_LABEL;
    public static final int TAB_IN_CART = 0;
    public static final int TAB_SAVED = 1;
    private static final int XO_ITEM_LIMIT = 20;
    private static final int XO_SELLER_LIMIT = 10;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ShoppingCart", 3, "Log ShoppingCartActivity events");
    private Button proceedToCheckout;
    private View selectedMenuItem;
    private ShoppingCart shoppingCart;
    private ShoppingCartDataHandler shoppingCartDataHandler;
    private ShoppingCartDataManagerBase shoppingCartDataManager;
    private boolean shouldSendPageImpression;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager tabFragmentPager;

    public ShoppingCartActivity()
    {
        shouldSendPageImpression = true;
    }

    private void attemptCheckout(ShoppingCart shoppingcart)
    {
        Integer integer;
        int i;
        integer = null;
        i = shoppingcart.summary.totalBuyableItems;
        if (i <= 10) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        int l;
        j = shoppingcart.itemsBySeller.size();
        k = shoppingcart.summary.totalTransactedItems;
        l = shoppingcart.summary.totalUnbuyableItems;
        if (j <= 10) goto _L4; else goto _L3
_L3:
        if (k > 10)
        {
            integer = Integer.valueOf(0x7f070a92);
        } else
        {
            integer = Integer.valueOf(0x7f070a94);
        }
_L5:
        if (integer != null)
        {
            showDialog(integer.intValue());
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (i + l > 20)
        {
            integer = Integer.valueOf(0x7f070a93);
        }
        if (true) goto _L5; else goto _L2
_L2:
        HashMap hashmap = new HashMap();
        Object obj;
        if (MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.UseShoppingCartMultipleCurrency))
        {
            obj = getPurchasableCartItems(MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode());
        } else
        {
            obj = shoppingcart.getAllItems();
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            com.ebay.nautilus.domain.data.ShoppingCart.Item item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)((Iterator) (obj)).next();
            Object obj1 = ShoppingCart.createItemKey(item.ebayItemId.longValue(), item.variationId, item.transactionId.toString());
            if (hashmap.containsKey(obj1))
            {
                obj1 = (CheckoutItem)hashmap.get(obj1);
                obj1.quantity = ((CheckoutItem) (obj1)).quantity + item.requestedQuantity;
            } else
            {
                hashmap.put(obj1, new CheckoutItem(item));
            }
        }

        obj = new Intent(this, com/ebay/mobile/checkout/CheckoutActivity);
        ((Intent) (obj)).putExtra("remember_me", MyApp.getDeviceConfiguration().isMec2Enabled(null));
        ((Intent) (obj)).putExtra("shopping_cart_id", shoppingcart.cartId);
        ((Intent) (obj)).putExtra("shopping_cart_items", (Serializable)hashmap);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.BidSource", "shopping_cart");
        boolean flag;
        if (ShoppingCartTabFragment.getPurchasableCurrenciesCount(shoppingcart) > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Intent) (obj)).putExtra("checkoutable_items_in_cart", flag);
        startActivityForResult(((Intent) (obj)), 1);
        (new TrackingData("ProceedToCheckout", TrackingType.EVENT)).send(this);
        return;
    }

    private void cancelReceivedNotifications()
    {
        ServiceStarter.startUpdateNotificationCacheService(this, com.ebay.common.model.mdns.NotificationPreference.EventType.SHOPCARTITM.name(), null);
        Intent intent = getIntent();
        int i = intent.getIntExtra("noti_sys_id", -1);
        if (i != -1)
        {
            ((NotificationManager)getSystemService("notification")).cancel(i);
            ServiceStarter.startUpdateNotificationCacheService(this, intent.getStringExtra("event_type"), null);
            intent.removeExtra("noti_sys_id");
        }
    }

    private void initializeInterface()
    {
        setContentView(0x7f030242);
        setTitle(0x7f070ab2);
        hideBackButton();
        proceedToCheckout = (Button)findViewById(0x7f1007b9);
        proceedToCheckout.setOnClickListener(this);
        showBottomActionBar(false, false);
        tabFragmentPager = (ViewPager)findViewById(0x7f10055a);
        tabFragmentPager.setAdapter(new ShoppingCartTabFragmentAdapter(getFragmentManager(), this));
        slidingTabLayout = (SlidingTabLayout)findViewById(0x7f1007b7);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(tabFragmentPager);
        slidingTabLayout.setOnPageChangeListener(this);
        slidingTabLayout.setCustomTabColorizer(new com.ebay.android.widget.SlidingTabLayout.TabColorizer() {

            final ShoppingCartActivity this$0;

            public int getDividerColor(int i)
            {
                return getResources().getColor(0x7f0d00e6);
            }

            public int getIndicatorColor(int i)
            {
                return getResources().getColor(0x7f0d00df);
            }

            
            {
                this$0 = ShoppingCartActivity.this;
                super();
            }
        });
    }

    private ResultStatus localizeResultStatus(ResultStatus resultstatus)
    {
        LinkedList linkedlist = new LinkedList();
        for (resultstatus = resultstatus.initializeMessages().iterator(); resultstatus.hasNext(); linkedlist.add(new LocalizedCartMessage((com.ebay.nautilus.kernel.content.ResultStatus.Message)resultstatus.next()))) { }
        return ResultStatus.create(linkedlist);
    }

    private static final List mapItemsToIds(Collection collection)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(((com.ebay.nautilus.domain.data.ShoppingCart.Item)collection.next()).ebayItemId.toString())) { }
        return arraylist;
    }

    private static final List mapItemsToSiteListedCurrencyCode(Collection collection)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.data.ShoppingCart.Item item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)collection.next();
            if (!item.itemPrice.isZero() && item.itemPrice.listedPrice != CurrencyAmount.ZERO)
            {
                arraylist.add(item.itemPrice.listedPrice.getCurrencyCode());
            }
        } while (true);
        return arraylist;
    }

    private void sendPageImpression(ShoppingCart shoppingcart)
    {
        if (shouldSendPageImpression)
        {
            shouldSendPageImpression = false;
            TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
            Intent intent = getIntent();
            NotificationTrackingUtil.addNotificationTracking(this, trackingdata, intent, intent.getStringExtra("event_type"));
            if (shoppingcart != null)
            {
                trackingdata.addKeyValuePair("ebc", Long.toString(shoppingcart.cartId));
                trackingdata.addKeyValuePair("crtsz", Integer.toString(shoppingcart.summary.totalBuyableItems));
                trackingdata.addKeyValuePair("cart_itm", AnalyticsUtil.getCommaSeparatedStringFromCollection(mapItemsToIds(shoppingcart.getAllItems())));
                trackingdata.addKeyValuePair("chtpc", AnalyticsUtil.getCommaSeparatedStringFromCollection(mapItemsToSiteListedCurrencyCode(shoppingcart.getAllItems())));
                trackingdata.addKeyValuePair("itm_unavbl", AnalyticsUtil.getCommaSeparatedStringFromCollection(mapItemsToIds(shoppingcart.getUnavailableItems())));
                trackingdata.addKeyValuePair("itm_sfl", AnalyticsUtil.getCommaSeparatedStringFromCollection(mapItemsToIds(shoppingcart.savedForLater)));
                if (DeviceConfiguration.getAsync().get(DcsBoolean.smeSupport))
                {
                    LinkedList linkedlist = new LinkedList();
                    LinkedList linkedlist1 = new LinkedList();
                    for (Iterator iterator = shoppingcart.itemsBySeller.values().iterator(); iterator.hasNext();)
                    {
                        Iterator iterator1 = ((com.ebay.nautilus.domain.data.ShoppingCart.Orders)iterator.next()).itemsByOffer.entrySet().iterator();
                        while (iterator1.hasNext()) 
                        {
                            shoppingcart = (java.util.Map.Entry)iterator1.next();
                            com.ebay.nautilus.domain.data.ShoppingCart.Promotion promotion = (com.ebay.nautilus.domain.data.ShoppingCart.Promotion)shoppingcart.getKey();
                            if (promotion != com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN)
                            {
                                Iterator iterator2 = ((List)shoppingcart.getValue()).iterator();
                                while (iterator2.hasNext()) 
                                {
                                    com.ebay.nautilus.domain.data.ShoppingCart.Item item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)iterator2.next();
                                    if (promotion.status == com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.APPLIED)
                                    {
                                        shoppingcart = linkedlist;
                                    } else
                                    {
                                        shoppingcart = linkedlist1;
                                    }
                                    shoppingcart.add(new com.ebay.mobile.analytics.Tracking.Formatters.SellerOfferItem(item.ebayItemId.longValue(), promotion.offerCode, promotion.offerType.name()));
                                }
                            }
                        }
                    }

                    trackingdata.addKeyValuePair("mo", com.ebay.mobile.analytics.Tracking.Formatters.SellerOfferItem.format(linkedlist));
                    trackingdata.addKeyValuePair("umo", com.ebay.mobile.analytics.Tracking.Formatters.SellerOfferItem.format(linkedlist1));
                }
            }
            if (DeviceInfoUtil.isPortrait(this))
            {
                shoppingcart = "p";
            } else
            {
                shoppingcart = "l";
            }
            trackingdata.addKeyValuePair("ort", shoppingcart);
            trackingdata.addSourceIdentification(intent);
            trackingdata.send(this);
        }
    }

    private void sendShoppingCartActionTracking(String s, String s1, com.ebay.nautilus.domain.data.ShoppingCart.Item item)
    {
        s1 = new TrackingData("ShoppingCartAction", TrackingType.EVENT);
        s1.addKeyValuePair(s, "1");
        if (item != null)
        {
            s1.addKeyValuePair("itm", item.ebayItemId.toString());
        }
        if (shoppingCart != null)
        {
            s1.addKeyValuePair("ebc", Long.toString(shoppingCart.cartId));
        }
        s1.send(this);
    }

    private void showBottomActionBar(boolean flag, boolean flag1)
    {
        float f2 = 1.0F;
        float f3 = 0.0F;
        View view = findViewById(0x7f1007b8);
        if (view != null && view.getTag() != Boolean.valueOf(flag))
        {
            if (flag1)
            {
                ViewPropertyAnimator viewpropertyanimator = view.animate();
                float f;
                if (flag)
                {
                    f = 0.0F;
                } else
                {
                    f = view.getHeight();
                }
                viewpropertyanimator = viewpropertyanimator.translationY(f);
                f = f3;
                if (flag)
                {
                    f = 1.0F;
                }
                viewpropertyanimator.alpha(f).start();
            } else
            {
                float f1;
                if (flag)
                {
                    f1 = 0.0F;
                } else
                {
                    f1 = view.getHeight();
                }
                view.setTranslationY(f1);
                if (flag)
                {
                    f1 = f2;
                } else
                {
                    f1 = 0.0F;
                }
                view.setAlpha(f1);
            }
            view.setTag(Boolean.valueOf(flag));
        }
    }

    private void showProgress(boolean flag)
    {
        View view = findViewById(0x7f100148);
        if (view != null)
        {
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public static final void updateActionBarCount(Activity activity)
    {
        View view = null;
        NautilusKernel.verifyMain();
        int i = ShoppingCartDataManagerBase.getBuyableItemCount();
        View view1 = MenuHandler.getActionView(activity, 0x7f1009e6);
        if (view1 == null)
        {
            activity = null;
        } else
        {
            activity = (TextView)view1.findViewById(0x7f10008c);
        }
        if (view1 != null)
        {
            view = view1.findViewById(0x7f10008b);
        }
        if (activity != null && view != null)
        {
            boolean flag1 = MyApp.getDeviceConfiguration().isShoppingCartEnabled();
            activity.setText(String.valueOf(i));
            boolean flag;
            if (flag1 && i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            activity.setVisibility(visibleOrGone(flag));
            view.setVisibility(visibleOrGone(flag1));
        }
    }

    public static final void updateLocalNotificationsForCart(Context context, ShoppingCart shoppingcart)
    {
        if (shoppingcart != null)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = shoppingcart.itemsBySeller.entrySet().iterator(); iterator.hasNext();)
            {
                Iterator iterator1 = ((com.ebay.nautilus.domain.data.ShoppingCart.Orders)((java.util.Map.Entry)iterator.next()).getValue()).itemsByOffer.entrySet().iterator();
                while (iterator1.hasNext()) 
                {
                    Iterator iterator2 = ((List)((java.util.Map.Entry)iterator1.next()).getValue()).iterator();
                    while (iterator2.hasNext()) 
                    {
                        com.ebay.nautilus.domain.data.ShoppingCart.Item item1 = (com.ebay.nautilus.domain.data.ShoppingCart.Item)iterator2.next();
                        if (!item1.isEnded && !item1.isTransacted)
                        {
                            arraylist.add(new com.ebay.common.model.mdns.PlatformNotificationsEvent.CartItemEndingEvent(item1));
                        }
                    }
                }
            }

            shoppingcart = shoppingcart.savedForLater.iterator();
            do
            {
                if (!shoppingcart.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.data.ShoppingCart.Item item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)shoppingcart.next();
                if (!item.isEnded && !item.isTransacted)
                {
                    arraylist.add(new com.ebay.common.model.mdns.PlatformNotificationsEvent.CartItemEndingEvent(item));
                }
            } while (true);
            shoppingcart = new Intent(context, com/ebay/mobile/notifications/PollService);
            shoppingcart.setAction("com.ebay.mobile.service.UPDATE_LOCAL_NOTIFICATIONS_CART");
            shoppingcart.putParcelableArrayListExtra("cart_item_ending_events", arraylist);
            context.startService(shoppingcart);
        }
    }

    private static final int visibleOrGone(boolean flag)
    {
        return !flag ? 8 : 0;
    }

    public static final void wiggleActionBar(Activity activity)
    {
        View view = MenuHandler.getActionView(activity, 0x7f1009e6);
        if (view == null)
        {
            view = null;
        } else
        {
            view = view.findViewById(0x7f10008b);
        }
        if (view != null)
        {
            view.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f040011));
        }
    }

    public List getPurchasableCartItems(String s)
    {
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        obj = shoppingCart.getItemsByCurrency();
        if (!((Map) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        s = Collections.emptyList();
_L4:
        return s;
_L2:
        if (((Map) (obj)).containsKey(s))
        {
            s = (List)((Map) (obj)).get(s);
        } else
        {
            s = (List)((java.util.Map.Entry)((Map) (obj)).entrySet().iterator().next()).getValue();
        }
        obj = s.iterator();
        s = arraylist;
        if (((Iterator) (obj)).hasNext())
        {
            s = (com.ebay.nautilus.domain.data.ShoppingCart.Item)((Iterator) (obj)).next();
            if (s.hasPaymentMethod("PayPal"))
            {
                arraylist.add(s);
            }
            break MISSING_BLOCK_LABEL_59;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getTrackingEventName()
    {
        if (tabFragmentPager != null && tabFragmentPager.getCurrentItem() == 1)
        {
            return "ShoppingCartSaved";
        } else
        {
            return "ShoppingCart";
        }
    }

    public void handleShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
    {
        if (!isFinishing())
        {
            SiteSpeedActivityUtil.primaryAndAllLoaded(this);
            showProgress(false);
            if (content.getStatus().hasError() || content.getStatus().hasWarning())
            {
                SiteSpeedActivityUtil.invalidate(this);
                if (networkAvailable())
                {
                    if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
                    {
                        EbayErrorHandler.handleResultStatus(this, action.ordinal(), content.getStatus());
                    } else
                    {
                        showMessage(action.ordinal(), localizeResultStatus(content.getStatus()));
                    }
                }
            }
            if (content.getData() != null && action.needsAdditionalData)
            {
                shoppingCart = (ShoppingCart)content.getData();
                if (shoppingCart != null)
                {
                    sendPageImpression(shoppingCart);
                    boolean flag;
                    if (tabFragmentPager.getCurrentItem() == 0 && shoppingCart.summary.totalBuyableItems > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    showBottomActionBar(flag, true);
                    updateLocalNotificationsForCart(this, shoppingCart);
                    updateActionBarCount(this);
                    return;
                }
            }
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 44
    //                   1 25;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (j == -1)
        {
            finish();
            return;
        } else
        {
            shoppingCartDataManager.getCartAsync(true);
            return;
        }
_L2:
        if (j == -1)
        {
            if (intent != null && intent.hasExtra("quantity_selected") && intent.hasExtra("ebay_item_id"))
            {
                i = intent.getIntExtra("quantity_selected", 0);
                intent = intent.getStringExtra("ebay_item_id");
                if (!TextUtils.isEmpty(intent) && i > 0)
                {
                    onItemQuantityChanged(Long.parseLong(intent), i);
                    return;
                }
            }
        } else
        {
            shoppingCartDataManager.getCartAsync(true);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onClick(final View cartItem)
    {
        Object obj;
        obj = null;
        break MISSING_BLOCK_LABEL_2;
        Object obj1;
label0:
        while (!(obj1 instanceof com.ebay.nautilus.domain.data.ShoppingCart.Item)) 
        {
            do
            {
label1:
                do
                {
                    do
                    {
                        return;
                    } while (!networkAvailable() || isFinishing());
                    obj1 = cartItem.getTag(0x7f100010);
                    switch (cartItem.getId())
                    {
                    default:
                        return;

                    case 2131756990: 
                        continue label0;

                    case 2131756985: 
                        if (shoppingCart != null)
                        {
                            attemptCheckout(shoppingCart);
                            return;
                        }
                        break;

                    case 2131756999: 
                        if (obj1 instanceof com.ebay.nautilus.domain.data.ShoppingCart.Item)
                        {
                            cartItem = (com.ebay.nautilus.domain.data.ShoppingCart.Item)obj1;
                            showProgress(true);
                            shoppingCartDataManager.saveForLater(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (cartItem)).lineItemId.longValue(), null);
                            sendShoppingCartActionTracking("svfl", "1", cartItem);
                            return;
                        }
                        break;

                    case 2131757000: 
                        if (obj1 instanceof com.ebay.nautilus.domain.data.ShoppingCart.Item)
                        {
                            cartItem = (com.ebay.nautilus.domain.data.ShoppingCart.Item)obj1;
                            showProgress(true);
                            shoppingCartDataManager.moveToCart(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (cartItem)).lineItemId.longValue(), null);
                            sendShoppingCartActionTracking("move2cart", "1", cartItem);
                            return;
                        }
                        break;

                    case 2131756998: 
                        if (obj1 instanceof com.ebay.nautilus.domain.data.ShoppingCart.Item)
                        {
                            cartItem = (com.ebay.nautilus.domain.data.ShoppingCart.Item)obj1;
                            (new android.support.v7.app.AlertDialog.Builder(this, 0)).setPositiveButton(0x7f070aa1, new android.content.DialogInterface.OnClickListener() {

                                final ShoppingCartActivity this$0;
                                final com.ebay.nautilus.domain.data.ShoppingCart.Item val$cartItem;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    showProgress(true);
                                    shoppingCartDataManager.removeItemFromCart(cartItem.lineItemId.longValue(), null);
                                    sendShoppingCartActionTracking("rmvcart", "1", cartItem);
                                }

            
            {
                this$0 = ShoppingCartActivity.this;
                cartItem = item;
                super();
            }
                            }).setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

                                final ShoppingCartActivity this$0;
                                final com.ebay.nautilus.domain.data.ShoppingCart.Item val$cartItem;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    sendShoppingCartActionTracking("rmvcart", "0", cartItem);
                                    dialoginterface.dismiss();
                                }

            
            {
                this$0 = ShoppingCartActivity.this;
                cartItem = item;
                super();
            }
                            }).setMessage(0x7f070a7e).setTitle(0x7f070a7f).create().show();
                            return;
                        }
                        break;

                    case 2131756997: 
                        if (obj1 instanceof com.ebay.nautilus.domain.data.ShoppingCart.Item)
                        {
                            cartItem = (com.ebay.nautilus.domain.data.ShoppingCart.Item)obj1;
                            showProgress(true);
                            shoppingCartDataManager.removeItemFromSaveForLater(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (cartItem)).lineItemId.longValue(), null);
                            sendShoppingCartActionTracking("rmvsfl", "1", cartItem);
                            return;
                        }
                        break;

                    case 2131757001: 
                        cartItem.showContextMenu();
                        return;

                    case 2131757006: 
                        if (obj1 instanceof com.ebay.nautilus.domain.data.ShoppingCart.Promotion)
                        {
                            break label1;
                        }
                        break;
                    }
                } while (true);
                cartItem = (com.ebay.nautilus.domain.data.ShoppingCart.Promotion)obj1;
            } while (((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (cartItem)).offerType == com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.None || ((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (cartItem)).promotionType == com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType.None);
            showProgress(true);
            SellerOfferResultFragmentActivity.startActivity(this, ((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (cartItem)).sellerUserId, ((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (cartItem)).offerType.name(), ((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (cartItem)).offerCode, ((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (cartItem)).seedCategoryId, new SourceIdentification(getTrackingEventName(), "sop"));
            return;
        }
        obj1 = (com.ebay.nautilus.domain.data.ShoppingCart.Item)obj1;
        showProgress(true);
        Long long1 = ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj1)).ebayItemId;
        cartItem = obj;
        if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj1)).isTransacted)
        {
            cartItem = ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj1)).transactionId;
        }
        ItemViewActivity.StartActivity(this, long1, cartItem, ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj1)).variationSpecifics);
        return;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        shouldSendPageImpression = true;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (selectedMenuItem == null)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        if (selectedMenuItem.getId() != 0x7f1007c9) goto _L2; else goto _L1
_L1:
        com.ebay.nautilus.domain.data.ShoppingCart.Item item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)selectedMenuItem.getTag(0x7f100010);
        if (item == null) goto _L2; else goto _L3
_L3:
        int i = menuitem.getOrder();
        if (i <= 5) goto _L5; else goto _L4
_L4:
        menuitem = new Intent(this, com/ebay/mobile/checkout/ChangeCartItemQuantityActivity);
        menuitem.putExtra("quantity_available", item.availableQuantity);
        menuitem.putExtra("ebay_item_id", item.lineItemId.toString());
        startActivityForResult(menuitem, 0);
_L2:
        return true;
_L5:
        if (item.requestedQuantity != i)
        {
            onItemQuantityChanged(item.lineItemId.longValue(), i);
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setShowWarnings(true);
        if (MyApp.getPrefs().getAuthentication() == null || !MyApp.getDeviceConfiguration().isShoppingCartEnabled())
        {
            finish();
            return;
        }
        cancelReceivedNotifications();
        initializeInterface();
        if (bundle != null)
        {
            shouldSendPageImpression = bundle.getBoolean("should_send_page_impression");
            shoppingCart = (ShoppingCart)bundle.getParcelable("shopping_cart_response");
        } else
        {
            shouldSendPageImpression = true;
        }
        initDataManagers();
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        if (view.getId() == 0x7f1007c9)
        {
            contextmenu.setHeaderTitle(getString(0x7f07058e));
            selectedMenuItem = view;
            int j = ((com.ebay.nautilus.domain.data.ShoppingCart.Item)view.getTag(0x7f100010)).availableQuantity;
            for (int i = 1; i <= Math.min(5, j); i++)
            {
                contextmenu.add(0, 0, i, String.valueOf(i));
            }

            if (j > 5)
            {
                contextmenu.add(0, 0, 6, String.format(getString(0x7f070a96), new Object[] {
                    Integer.valueOf(5)
                }));
            }
            return;
        } else
        {
            selectedMenuItem = null;
            return;
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        Object obj = new android.support.v7.app.AlertDialog.Builder(this);
        switch (i)
        {
        default:
            return DialogManager.createAlertDialog(this, i);

        case 2131165520: 
            ((android.support.v7.app.AlertDialog.Builder) (obj)).setMessage(i).setCancelable(false).setTitle(0x7f070130).setPositiveButton(0x7f070920, new android.content.DialogInterface.OnClickListener() {

                final ShoppingCartActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    shoppingCartDataManager.getCartAsync(true);
                    dialoginterface.cancel();
                }

            
            {
                this$0 = ShoppingCartActivity.this;
                super();
            }
            }).setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

                final ShoppingCartActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    finish();
                }

            
            {
                this$0 = ShoppingCartActivity.this;
                super();
            }
            });
            return ((android.support.v7.app.AlertDialog.Builder) (obj)).create();

        case 2131165507: 
            ((android.support.v7.app.AlertDialog.Builder) (obj)).setMessage(i).setCancelable(false).setTitle(0x7f070130).setNegativeButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

                final ShoppingCartActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    finish();
                }

            
            {
                this$0 = ShoppingCartActivity.this;
                super();
            }
            });
            return ((android.support.v7.app.AlertDialog.Builder) (obj)).create();

        case 2131167890: 
        case 2131167891: 
        case 2131167892: 
            obj = DialogManager.createAlertDialog(this, i);
            break;
        }
        ((Dialog) (obj)).setTitle(0x7f070a91);
        return ((Dialog) (obj));
    }

    public void onEnableCheckout(boolean flag)
    {
        proceedToCheckout.setEnabled(flag);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        shoppingCartDataHandler = new ShoppingCartDataHandler();
        com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi;
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.SHOPCASE;
        } else
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.ECAS;
        }
        shoppingCartDataManager = (ShoppingCartDataManagerBase)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi), shoppingCartDataHandler);
        shoppingCartDataManager.loadData(true, null);
        datamanagercontainer.initialize(ImageDataManager.KEY, this);
    }

    public void onItemQuantityChanged(long l, int i)
    {
        showProgress(true);
        shoppingCartDataManager.setItemQuantity(Long.valueOf(l), i, null);
        (new TrackingData("ShoppingCartItemCount", TrackingType.EVENT)).send(this);
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (debugLogger.isLoggable)
        {
            debugLogger.log(String.format("ShoppingCartActivity#onItemSelected(%1$s,%2$s,%3$s,%4$s)", new Object[] {
                adapterview, view, Integer.valueOf(i), Long.valueOf(l)
            }));
        }
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        if (debugLogger.isLoggable)
        {
            debugLogger.log(String.format("ShoppingCartActivity#onNothingSelected(%1$s)", new Object[] {
                adapterview
            }));
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (debugLogger.isLoggable)
        {
            debugLogger.log(String.format("ShoppingCartActivity#onPageScrollStateChanged(%1$s)", new Object[] {
                Integer.valueOf(i)
            }));
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (debugLogger.isLoggable)
        {
            debugLogger.log(String.format("ShoppingCartActivity#onPageScrolled(%1$s,%2$s,%3$s)", new Object[] {
                Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(j)
            }));
        }
        if (shoppingCart == null) goto _L2; else goto _L1
_L1:
        View view = findViewById(0x7f1007b8);
        i;
        JVM INSTR tableswitch 0 1: default 84
    //                   0 85
    //                   1 120;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        if (shoppingCart.summary.totalBuyableItems > 0)
        {
            view.setTranslationY((float)view.getHeight() * f);
            view.setAlpha(1.0F - f);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        view.setTranslationY((1.0F - f) * (float)view.getHeight());
        view.setAlpha(f);
        return;
    }

    public void onPageSelected(int i)
    {
        if (debugLogger.isLoggable)
        {
            debugLogger.log(String.format("ShoppingCartActivity#onPageSelected(%1$s)", new Object[] {
                Integer.valueOf(i)
            }));
        }
        shouldSendPageImpression = true;
        sendPageImpression(shoppingCart);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("should_send_page_impression", shouldSendPageImpression);
        bundle.putParcelable("shopping_cart_response", shoppingCart);
    }

    public void refresh()
    {
        showProgress(true);
        shoppingCartDataManager.getCartAsync(true);
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SHOW_OPTIONS_LABEL = flag;
    }




}
