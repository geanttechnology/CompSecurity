// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.Purchase;
import com.groupon.goods.shoppingcart.event.ShoppingCartItemQuantitySelectedEvent;
import com.groupon.goods.shoppingcart.mapping.ShoppingCartCustomFieldViewHolder;
import com.groupon.goods.shoppingcart.mapping.ShoppingCartItemMapping;
import com.groupon.goods.shoppingcart.mapping.ShoppingCartItemViewHolder;
import com.groupon.goods.shoppingcart.model.CartPurchaseExtraInfo;
import com.groupon.goods.shoppingcart.model.CartQuantityClickExtraInfo;
import com.groupon.goods.shoppingcart.model.ContinueShoppingClickExtraInfo;
import com.groupon.goods.shoppingcart.view.ShoppingCartFlyout;
import com.groupon.models.GenericAmount;
import com.groupon.models.dealbreakdown.DealBreakdownAddresses;
import com.groupon.models.dealbreakdown.DealBreakdownGenericAmount;
import com.groupon.models.dealbreakdown.DealBreakdownItem;
import com.groupon.models.dealbreakdown.DealMultiItemBreakdown;
import com.groupon.models.dealbreakdown.DealMultiItemBreakdownContainer;
import com.groupon.models.dealbreakdown.PurchaseBreakdown;
import com.groupon.models.error.BreakdownException;
import com.groupon.models.error.GrouponException;
import com.groupon.models.order.Order;
import com.groupon.models.order.OrderContainer;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.shoppingCart.ShoppingCart;
import com.groupon.models.shoppingCart.ShoppingCartCustomField;
import com.groupon.models.shoppingCart.ShoppingCartDeal;
import com.groupon.models.shoppingCart.ShoppingCartDealOption;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.models.shoppingCart.ShoppingCartSubtotal;
import com.groupon.network.HttpResponseException;
import com.groupon.provider.KochavaProvider;
import com.groupon.service.AttributionService;
import com.groupon.service.DealBreakdownService;
import com.groupon.service.DealBreakdownServiceMultiDealListener;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;
import com.groupon.service.GoogleWalletService;
import com.groupon.service.OrdersService;
import com.groupon.service.OrdersServiceMultiItemListener;
import com.groupon.service.ShoppingCartService;
import com.groupon.tracking.mobile.events.CartStatus;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.DefaultGrouponDialogListenerImpl;
import com.groupon.util.Function0;
import com.groupon.util.GrouponDialogFragment;
import com.kochava.android.tracker.Feature;
import com.squareup.otto.Bus;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryActivity

public class NewPurchaseCart extends Purchase
{
    private class CartServiceListener extends DefaultShoppingCartServiceListenerImpl
    {

        final NewPurchaseCart this$0;

        public void onCancel()
        {
            onCartCancel();
        }

        public boolean onException(Exception exception)
        {
            return onCartException(exception);
        }

        public void onSuccess(ShoppingCartResponse shoppingcartresponse)
        {
            onCartResponse(shoppingcartresponse.cart);
        }

        private CartServiceListener()
        {
            this$0 = NewPurchaseCart.this;
            super();
        }

    }

    private class MultiItemBreakdownListener
        implements DealBreakdownServiceMultiDealListener
    {

        final NewPurchaseCart this$0;

        public void onComplete()
        {
        }

        public boolean onException(Exception exception)
        {
            return onMultiDealBreakdownException(exception).booleanValue();
        }

        public void onSuccess(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
        {
            onMultiDealBreakdownSuccess(dealmultiitembreakdowncontainer);
        }

        private MultiItemBreakdownListener()
        {
            this$0 = NewPurchaseCart.this;
            super();
        }

    }

    private class MultiItemOrderListener
        implements OrdersServiceMultiItemListener
    {

        final NewPurchaseCart this$0;

        public void onComplete()
        {
        }

        public boolean onException(Exception exception)
        {
            return onOrderException(exception);
        }

        public void onSuccess(OrderContainer ordercontainer)
        {
            onOrderSuccess(ordercontainer);
        }

        private MultiItemOrderListener()
        {
            this$0 = NewPurchaseCart.this;
            super();
        }

    }


    private static final String CART_CUSTOM_FIELD_DIALOG = "cart_custom_field_dialog";
    private static final String CART_CUSTOM_MAP = "cart_custom_map";
    public static final String CART_QUANTITY_CLICK = "cart_quantity";
    public static final String COMING_FROM_DEAL_DETAILS = "coming_from_deal_details";
    private static final String PROMO_CODE_NULL_STRING = "";
    Bus bus;
    private ShoppingCart cart;
    NewCartAbTestHelper cartAbTestHelper;
    private final Map cartCustomFieldMap = new LinkedHashMap();
    private ShoppingCartItemViewHolder cartItemViewHolders[];
    ViewGroup cartItemsContainer;
    private final CartServiceListener cartServiceListener = new CartServiceListener();
    boolean comingFromDealDetails;
    private DealMultiItemBreakdown currentMultiItemBreakdown;
    private final View disableViews[];
    KochavaProvider kochavaProvider;
    private ShoppingCartItemMapping mapping;
    private final MultiItemBreakdownListener multiItemBreakdownListener = new MultiItemBreakdownListener();
    private final MultiItemOrderListener multiItemOrderListener = new MultiItemOrderListener();
    OrdersService ordersService;
    ShoppingCartFlyout shoppingCartFlyout;
    ShoppingCartService shoppingCartService;

    public NewPurchaseCart()
    {
        disableViews = (new View[] {
            cartItemsContainer
        });
    }

    private void addCartCustomFields(ViewGroup viewgroup, LayoutInflater layoutinflater, final ShoppingCartItem item)
    {
        final ShoppingCartCustomField field = item.dealOption.customFields;
        if (field == null || field.isEmpty())
        {
            return;
        } else
        {
            field = (ShoppingCartCustomField)field.get(0);
            layoutinflater = layoutinflater.inflate(0x7f030148, viewgroup, false);
            String s = (String)cartCustomFieldMap.get(item.dealOption.id);
            final ShoppingCartCustomFieldViewHolder holder = new ShoppingCartCustomFieldViewHolder(layoutinflater);
            layoutinflater.setTag(holder);
            holder.bind(field, s);
            layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

                final NewPurchaseCart this$0;
                final ShoppingCartCustomField val$field;
                final ShoppingCartCustomFieldViewHolder val$holder;
                final ShoppingCartItem val$item;

                public void onClick(View view)
                {
                    onCustomFieldClick(item.dealOption.id, field, holder);
                }

            
            {
                this$0 = NewPurchaseCart.this;
                item = shoppingcartitem;
                field = shoppingcartcustomfield;
                holder = shoppingcartcustomfieldviewholder;
                super();
            }
            });
            viewgroup.addView(layoutinflater);
            return;
        }
    }

    private void addDivider(ViewGroup viewgroup, LayoutInflater layoutinflater)
    {
        viewgroup.addView(layoutinflater.inflate(0x7f0301fc, viewgroup, false));
    }

    private void confirmDeleteItem(final String optionUuid, final int position)
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final NewPurchaseCart this$0;
            final String val$optionUuid;
            final int val$position;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                onConfirmDialogResponse(true, optionUuid, position);
            }

            
            {
                this$0 = NewPurchaseCart.this;
                optionUuid = s;
                position = i;
                super();
            }
        };
        optionUuid = new android.content.DialogInterface.OnClickListener() {

            final NewPurchaseCart this$0;
            final String val$optionUuid;
            final int val$position;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                onConfirmDialogResponse(false, optionUuid, position);
            }

            
            {
                this$0 = NewPurchaseCart.this;
                optionUuid = s;
                position = i;
                super();
            }
        };
        (new android.app.AlertDialog.Builder(this)).setTitle(0x7f080097).setMessage(0x7f080096).setPositiveButton(0x7f0804fe, onclicklistener).setNegativeButton(0x7f080084, optionUuid).show();
    }

    private void continueShopping()
    {
        logger.logClick("", "continue_shopping", getClass().getSimpleName(), Logger.NULL_NST_FIELD, new ContinueShoppingClickExtraInfo(cart.numberOfItems));
        startActivity(intentFactory.newGoodsIntent());
        finish();
    }

    private String generateUuid()
    {
        return UUID.randomUUID().toString();
    }

    private CartPurchaseExtraInfo getPurchaseNSTField()
    {
        CartPurchaseExtraInfo cartpurchaseextrainfo = new CartPurchaseExtraInfo();
        cartpurchaseextrainfo.cartSize = cart.numberOfItems;
        cartpurchaseextrainfo.cartTotal = cart.subtotal;
        return cartpurchaseextrainfo;
    }

    private String getSelectedAddressKey()
    {
        List list = currentMultiItemBreakdown.items;
        if (list != null && !list.isEmpty())
        {
            return ((DealBreakdownItem)list.get(0)).destinationAddress;
        } else
        {
            return null;
        }
    }

    private boolean isShippingAddressRequired(ShoppingCart shoppingcart)
    {
        boolean flag1 = false;
        shoppingcart = shoppingcart.items.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!shoppingcart.hasNext())
            {
                break;
            }
            if (!((ShoppingCartItem)shoppingcart.next()).deal.shippingAddressRequired.booleanValue())
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    private void onCartCancel()
    {
        finish();
    }

    private boolean onCartException(Exception exception)
    {
        handleSyncError(null, exception);
        return true;
    }

    private void onCartResponse(ShoppingCart shoppingcart)
    {
        if (shoppingcart == null || shoppingcart.items.isEmpty())
        {
            startActivity(CartSummaryActivity.openShoppingCartIntent(this));
            finish();
            return;
        }
        setIsRefreshing(false);
        cart = shoppingcart;
        Object obj = (ShoppingCartItem)shoppingcart.items.get(0);
        String s = ((ShoppingCartItem) (obj)).deal.id;
        obj = ((ShoppingCartItem) (obj)).dealOption.id;
        if (!s.equals(dealId) || ((String) (obj)).equals(dealOptionId))
        {
            getLoaderManager().destroyLoader(0);
            dealId = s;
            dealOptionId = ((String) (obj));
        }
        initDealLoader(true);
        cartItemsContainer.removeAllViews();
        addDivider(cartItemsContainer, inflater);
        cartItemsContainer.addView(inflater.inflate(0x7f0301fa, cartItemsContainer, false));
        addDivider(cartItemsContainer, inflater);
        cartItemViewHolders = new ShoppingCartItemViewHolder[shoppingcart.items.size()];
        for (int i = 0; i < shoppingcart.items.size(); i++)
        {
            ShoppingCartItem shoppingcartitem = (ShoppingCartItem)shoppingcart.items.get(i);
            ShoppingCartItemViewHolder shoppingcartitemviewholder = (ShoppingCartItemViewHolder)mapping.createViewHolder(this, cartItemsContainer);
            cartItemViewHolders[i] = shoppingcartitemviewholder;
            cartItemsContainer.addView(shoppingcartitemviewholder.itemView);
            mapping.bindView(i, shoppingcartitemviewholder, shoppingcartitem);
            addCartCustomFields(cartItemsContainer, inflater, shoppingcartitem);
            addDivider(cartItemsContainer, inflater);
        }

        if (cartAbTestHelper.isCartCheckoutContinueShoppingEnabled())
        {
            View view = inflater.inflate(0x7f0301f9, cartItemsContainer, false);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final NewPurchaseCart this$0;

                public void onClick(View view1)
                {
                    continueShopping();
                }

            
            {
                this$0 = NewPurchaseCart.this;
                super();
            }
            });
            cartItemsContainer.addView(view);
            addDivider(cartItemsContainer, inflater);
        }
        priceAmountInCents = shoppingcart.subtotal.price.getAmount();
        currency = shoppingcart.subtotal.price.getCurrencyCode();
        showShoppingCartInAppMessages();
    }

    private void onConfirmDialogResponse(boolean flag, String s, int i)
    {
        if (flag)
        {
            setIsRefreshing(true);
            shoppingCartService.removeItem(0x7f1000a7, s, disableViews, cartServiceListener);
            return;
        } else
        {
            s = (ShoppingCartItem)cart.items.get(i);
            ShoppingCartItemViewHolder shoppingcartitemviewholder = cartItemViewHolders[i];
            mapping.setEditMode(s, false);
            mapping.bindView(i, shoppingcartitemviewholder, s);
            return;
        }
    }

    private void onCustomFieldClick(final String optionId, final ShoppingCartCustomField field, final ShoppingCartCustomFieldViewHolder holder)
    {
        String s = (String)cartCustomFieldMap.get(optionId);
        final View customFieldView = inflater.inflate(0x7f0300b6, null);
        ((TextView)customFieldView.findViewById(0x7f100205)).setText(field.label);
        final EditText customFieldEditText = (EditText)customFieldView.findViewById(0x7f100206);
        customFieldEditText.setText(s);
        field = new GrouponDialogFragment(new DefaultGrouponDialogListenerImpl() {

            final NewPurchaseCart this$0;
            final EditText val$customFieldEditText;
            final View val$customFieldView;
            final ShoppingCartCustomField val$field;
            final ShoppingCartCustomFieldViewHolder val$holder;
            final String val$optionId;

            public View getDialogCustomView(String s1)
            {
                return customFieldView;
            }

            public void onDialogPositiveButtonClick(String s1, DialogInterface dialoginterface)
            {
                onCustomFieldDialogSuccess(optionId, customFieldEditText.getText().toString(), field, holder);
            }

            
            {
                this$0 = NewPurchaseCart.this;
                optionId = s;
                customFieldEditText = edittext;
                field = shoppingcartcustomfield;
                holder = shoppingcartcustomfieldviewholder;
                customFieldView = view;
                super();
            }
        });
        holder = new Bundle();
        holder.putInt("dialog_title_res_id", 0x7f080150);
        holder.putInt("dialog_positive_button_text_res_id", 0x104000a);
        holder.putInt("dialog_negative_button_text_res_id", 0x1040000);
        holder.putString("custom_field_key", optionId);
        field.setArguments(holder);
        field.setCustomView(customFieldView);
        showDialog(field, "cart_custom_field_dialog");
    }

    private void onCustomFieldDialogSuccess(String s, String s1, ShoppingCartCustomField shoppingcartcustomfield, ShoppingCartCustomFieldViewHolder shoppingcartcustomfieldviewholder)
    {
        cartCustomFieldMap.put(s, s1);
        shoppingcartcustomfieldviewholder.bind(shoppingcartcustomfield, s1);
    }

    private Boolean onMultiDealBreakdownException(Exception exception)
    {
        currentMultiItemBreakdown = null;
        displayBreakdownError(exception);
        onMultiDealBreakdownFinally();
        return Boolean.valueOf(true);
    }

    private void onMultiDealBreakdownFinally()
    {
        setIsRefreshingBreakdowns(false);
        setIsRefreshing(false);
        fromGiftCodesScreen = false;
    }

    private void onMultiDealBreakdownSuccess(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
    {
        currentMultiItemBreakdown = dealmultiitembreakdowncontainer.breakdowns;
        dealmultiitembreakdowncontainer = currentMultiItemBreakdown.addresses;
        if (dealmultiitembreakdowncontainer != null)
        {
            dealmultiitembreakdowncontainer = (DealBreakdownAddresses)dealmultiitembreakdowncontainer.get(getSelectedAddressKey());
        } else
        {
            dealmultiitembreakdowncontainer = null;
        }
        if (Strings.notEmpty(currentMultiItemBreakdown.getPromoCode()) && shouldShowMultiUsePromoCodeSuccessMessage)
        {
            Toast.makeText(getApplicationContext(), getString(0x7f08004d), 1).show();
            shouldShowMultiUsePromoCodeSuccessMessage = false;
        }
        invalidateOptionsMenu();
        handleAddressAdjustments(dealmultiitembreakdowncontainer);
        recreateOrderBreakdowns();
        onMultiDealBreakdownFinally();
    }

    private boolean onOrderException(Exception exception)
    {
        handleOrderResultSaveException(exception);
        logDealPurchaseConfirmation(exception);
        hideProcessingFeedback();
        setIsOrdersCallInProgress(false);
        return false;
    }

    private void onOrderSuccess(OrderContainer ordercontainer)
    {
        hideProcessingFeedback();
        setIsOrdersCallInProgress(false);
        orderId = ordercontainer.order.id;
        showMultiItemThanks(orderId, cart.numberOfItems, isShippingAddressRequired(cart));
        logDealPurchaseConfirmation(null);
        kochavaProvider.get().event("purchase", orderId);
    }

    public static Intent openPurchaseCartIntent(Context context)
    {
        Intent intent = new Intent(context, com/groupon/goods/shoppingcart/NewPurchaseCart);
        return ((IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory)).newLoginIntent(context, intent, null, null, Channel.GOODS);
    }

    public static Intent openPurchaseCartIntent(Context context, int i, String s, String s1)
    {
        Intent intent = new Intent(context, com/groupon/goods/shoppingcart/NewPurchaseCart);
        return ((IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory)).newLoginIntent(context, intent, null, null, Channel.GOODS).putExtra("comingFromCheckout", true).putExtra("num_items_in_cart", i).putExtra("max_cart_discount", s).putExtra("cart_deal_image_url", s1);
    }

    private void restoreCustomMap(Bundle bundle)
    {
        if (bundle != null)
        {
            if ((bundle = (Map)bundle.getSerializable("cart_custom_map")) != null)
            {
                cartCustomFieldMap.clear();
                cartCustomFieldMap.putAll(bundle);
                return;
            }
        }
    }

    private void showMultiItemThanks(String s, int i, boolean flag)
    {
        startActivity(intentFactory.newThanksIntent().putExtra("multiItemOrderId", s).putExtra("num_items_in_cart", i).putExtra("giftingRecord", giftingRecord).putExtra("hide_purchased_deal_info", true).putExtra("show_shipping_address", flag).putExtra("channel", Channel.SHOPPING_CART));
        finish();
    }

    private void showShoppingCartInAppMessages()
    {
        if (!shoppingCartService.getCartInAppMessageViewed())
        {
            shoppingCartFlyout.showShoppingCartInAppMessagesDrawer();
            shoppingCartService.setCartInAppMessageViewed(true);
        }
    }

    protected void addCustomFieldItems()
    {
    }

    protected void addQuantityItem()
    {
        if (userInputActionContainer != null)
        {
            View view = inflater.inflate(0x7f0301fd, userInputActionContainer, false);
            userInputActionContainer.addView(view);
            addUserInputActionSeparator();
        }
    }

    protected void addStockControlItem()
    {
    }

    protected boolean areCustomFieldsValid()
    {
        Iterator iterator = cart.items.iterator();
        ShoppingCartCustomField shoppingcartcustomfield;
label0:
        do
        {
            if (iterator.hasNext())
            {
                ShoppingCartItem shoppingcartitem = (ShoppingCartItem)iterator.next();
                if (shoppingcartitem.dealOption.customFields == null || shoppingcartitem.dealOption.customFields.isEmpty())
                {
                    continue;
                }
                Iterator iterator1 = shoppingcartitem.dealOption.customFields.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    shoppingcartcustomfield = (ShoppingCartCustomField)iterator1.next();
                } while (!shoppingcartcustomfield.required || cartCustomFieldMap.containsKey(shoppingcartitem.dealOption.id));
                break;
            } else
            {
                return true;
            }
        } while (true);
        showCustomFieldError(shoppingcartcustomfield.label);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        shoppingCartFlyout.hideShoppingCartInAppMessagesDrawer();
        return super.dispatchTouchEvent(motionevent);
    }

    protected void displayBreakdownError(Exception exception)
    {
        if (exception instanceof GrouponException)
        {
            if (exception instanceof BreakdownException)
            {
                displayGenericBreakdownsError(exception);
                return;
            }
            if (fromGiftCodesScreen && Strings.notEmpty(multiUsePromoCode))
            {
                multiUsePromoCode = "";
                setIsRefreshingBreakdowns(false);
                refreshDealBreakdowns();
                return;
            }
        }
        displayInvalidBreakdownsPaymentMethodsDialog("breakdowns_payments_action_finish");
    }

    protected GenericAmount getBreakdownSubtotal()
    {
        if (currentMultiItemBreakdown == null)
        {
            return cart.subtotal.price;
        } else
        {
            return currentMultiItemBreakdown.subtotal.amount;
        }
    }

    protected PurchaseBreakdown getCurrentBreakdown()
    {
        return currentMultiItemBreakdown;
    }

    protected int getLayout()
    {
        return 0x7f030198;
    }

    protected Intent getNewGiftCodesIntent()
    {
        return intentFactory.newGiftCodesIntent(dealId, dealOptionId, channel, cart.numberOfItems, shoppingCartService.getFormattedMaxDiscount(cart.items), shoppingCartService.getFirstDealImageUrl(cart.items));
    }

    protected Intent getNewMyCreditCardIntent()
    {
        return intentFactory.newMyCreditCardIntent(dealId, dealOptionId, channel, false, true, true, cart.numberOfItems, shoppingCartService.getFormattedMaxDiscount(cart.items), shoppingCartService.getFirstDealImageUrl(cart.items), shoppingCartService.getLastCachedCartUuid(), dealPaymentMethodsNameTypePairs, storageConsentRequirements);
    }

    protected Boolean handleOrderResultSaveException(Exception exception)
    {
        if (super.handleOrderResultSaveException(exception).booleanValue())
        {
            displayOrderErrorDialog(exception);
        }
        return Boolean.valueOf(false);
    }

    protected void handleTitle()
    {
    }

    protected boolean hasDealData()
    {
        return cartItemsContainer.getChildCount() > 0;
    }

    protected boolean isCurrentBreakdownValid()
    {
        return currentMultiItemBreakdown != null;
    }

    protected boolean isShippingAddressRequired()
    {
        return true;
    }

    protected void logDealConfirmationView()
    {
        logger.logDealConfirmationView("", "", "", cart.uuid, "", cart.generateTrackingString(CartStatus.STATUS_LENGTH), getPurchaseNSTField());
    }

    protected void logDealPurchaseConfirmation(Exception exception)
    {
        String s;
        Logger logger;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        int i;
        long l;
        if (exception == null)
        {
            i = 0;
        } else
        if (exception instanceof HttpResponseException)
        {
            i = ((HttpResponseException)exception).getStatusCode();
        } else
        {
            i = 900;
        }
        if (exception == null)
        {
            exception = "";
        } else
        {
            exception = exception.getMessage();
        }
        logger = this.logger;
        s1 = attributionService.getAttributionCid();
        s2 = attributionService.getAttributionId();
        s3 = attributionService.getAttributionType();
        l = attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue();
        s4 = attributionService.getAttributionDownloadId();
        s5 = attributionService.getAttributionDownloadCid();
        if (orderId == null)
        {
            s = "";
        } else
        {
            s = orderId;
        }
        logger.logDealPurchaseConfirmation("", "", "", i, exception, "", s1, s2, s3, l, s4, s5, s, cart.uuid, "", cart.generateTrackingString(CartStatus.STATUS_LENGTH), getPurchaseNSTField());
    }

    protected void logDealPurchaseInitiation()
    {
        logger.logDealPurchaseInitiation("", "", "", 0, 0.0F, "", cart.subtotal.price.getCurrencyCode(), attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), cart.uuid, "", cart.generateTrackingString(CartStatus.STATUS_LENGTH), getPurchaseNSTField());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (comingFromDealDetails)
        {
            overridePendingTransition(0x7f040007, 0x7f040006);
        }
        mapping = new ShoppingCartItemMapping(bus);
        mapping.onRestoreInstanceState(bundle);
        restoreCustomMap(bundle);
        requestSync(null);
    }

    protected void onDestroy()
    {
        shoppingCartFlyout.stopPositionAnimation();
        super.onDestroy();
    }

    public void onItemQuantitySelected(ShoppingCartItemQuantitySelectedEvent shoppingcartitemquantityselectedevent)
    {
        CartQuantityClickExtraInfo cartquantityclickextrainfo = new CartQuantityClickExtraInfo();
        cartquantityclickextrainfo.quantity = shoppingcartitemquantityselectedevent.quantity;
        logger.logClick("", "cart_quantity", getClass().getSimpleName(), Logger.NULL_NST_FIELD, cartquantityclickextrainfo);
        if (shoppingcartitemquantityselectedevent.quantity < 1)
        {
            confirmDeleteItem(shoppingcartitemquantityselectedevent.optionUuid, shoppingcartitemquantityselectedevent.position);
            return;
        } else
        {
            setIsRefreshing(true);
            shoppingCartService.updateItem(0x7f1000a7, shoppingcartitemquantityselectedevent.optionUuid, shoppingcartitemquantityselectedevent.dealUuid, shoppingcartitemquantityselectedevent.quantity, disableViews, cartServiceListener);
            return;
        }
    }

    protected boolean onNavigationUpPressed()
    {
        if (isDeepLinked)
        {
            Intent intent = intentFactory.newCarouselIntent();
            intent.setFlags(0x10008000);
            return ActionBarUtil.navigateUpTo(this, channel, intent, null);
        } else
        {
            return false;
        }
    }

    protected void onPause()
    {
        super.onPause();
        bus.unregister(this);
        mapping.unregister();
    }

    protected void onResume()
    {
        super.onResume();
        bus.register(this);
        mapping.register();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mapping.onSaveInstanceState(bundle);
        bundle.putSerializable("cart_custom_map", (Serializable)cartCustomFieldMap);
    }

    protected void overrideAbValues()
    {
        isNewCheckout1408 = true;
    }

    protected void refreshDealBreakdowns()
    {
        if (cart == null)
        {
            return;
        }
        if (setIsRefreshingBreakdowns(true))
        {
            Ln.d("BREAKDOWNS: refreshDealBreakdowns, bail because we have an outstanding refresh", new Object[0]);
            return;
        } else
        {
            handlePaymentSection();
            dealBreakdownService.getMultiDealBreakdown(generateUuid(), cart.items, multiUsePromoCode, false, multiItemBreakdownListener);
            return;
        }
    }

    protected void requestSync(Function0 function0)
    {
        shoppingCartService.getCart(0x7f1000a7, cartServiceListener);
    }

    protected void saveOrderResult(List list)
    {
        OrdersService ordersservice = ordersService;
        String s = generateUuid();
        String s1 = currentPaymentMethod.getId();
        if (currentMultiItemBreakdown != null)
        {
            list = currentMultiItemBreakdown.getPromoCode();
        } else
        {
            list = "";
        }
        ordersservice.getMultiItemOrders(s, s1, list, true, isGiftWrappable, giftingRecord, cart.items, cartCustomFieldMap, multiItemOrderListener);
    }

    protected boolean shouldDisplayGoogleWallet()
    {
        return googleWalletService.shouldDisplayGoogleWallet(isGdtOption(option), false, true, isUSDCurrency(option));
    }

    protected boolean shouldShowSendAsGift()
    {
        return false;
    }

    protected void updateOptionAndPrice()
    {
    }











}
