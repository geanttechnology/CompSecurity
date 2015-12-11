// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartActivity

public class CartAdapter extends ArrayAdapter
{
    private static final class ItemViewHolder
        implements ViewHolder
    {

        private static final String SPECIFIC_KEY_VALUE_SEPARATOR = ": ";
        private static final String VARIATION_MULTI_VALUE_SEPARATOR = "/";
        private static final String VARIATION_VALUE_SEPARATOR = ", ";
        public Button addToCartButton;
        private CountDownTimer countdownTimer;
        private final boolean invertedCurrencyConversionDisplay;
        public TextView itemSpecifics;
        public View multipleItemDivider;
        public TextView price;
        public TextView priceInItemSite;
        public RemoteImageView productImage;
        public LinearLayout quantityButton;
        public Button removeFromCartButton;
        public Button removeFromSavedButton;
        public Button saveForLaterButton;
        public TextView shippingCost;
        public TextView shippingCostInItemSite;
        public RelativeLayout statusBanner;
        public TextView statusBannerPrimary;
        public TextView statusBannerSecondary;
        public TextView title;
        public TextView variations;

        private static String mapMapValueToString(Map map)
        {
            LinkedList linkedlist = new LinkedList();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); linkedlist.add((new StringBuilder()).append(s).append(": ").append((String)map.get(s)).toString()))
            {
                s = (String)iterator.next();
            }

            return TextUtils.join(", ", linkedlist);
        }

        private static String mapNameValuesToString(List list)
        {
            LinkedList linkedlist = new LinkedList();
            for (list = list.iterator(); list.hasNext(); linkedlist.add(TextUtils.join("/", ((NameValue)list.next()).getValues()))) { }
            return TextUtils.join(", ", linkedlist);
        }

        private void setStatusBanner(int i, int j, String s)
        {
            byte byte0 = 8;
            if (i > 0)
            {
                statusBanner.setVisibility(0);
                statusBanner.setBackgroundColor(statusBanner.getContext().getResources().getColor(j));
                statusBannerPrimary.setText(i);
                TextView textview = statusBannerSecondary;
                if (TextUtils.isEmpty(s))
                {
                    i = byte0;
                } else
                {
                    i = 0;
                }
                textview.setVisibility(i);
                statusBannerSecondary.setText(s);
                return;
            } else
            {
                statusBanner.setVisibility(8);
                return;
            }
        }

        private void updateCountdownTimer(com.ebay.nautilus.domain.data.ShoppingCart.Item item)
        {
            if (countdownTimer != null)
            {
                countdownTimer.cancel();
            }
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[];
                static final int $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status = new int[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.ENDING_SOON.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.SELLER_ON_VACATION.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.PAY_NOW.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.WON.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.ENDED.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.UP_FOR_AUCTION.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.NOT_AVAILABLE.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.LAST_ONE.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.HAS_REVISIONS.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$ShoppingCart$Item$Status[com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.UNKNOWN.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType = new int[ViewType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ViewType.VIEW_TYPE_ITEM.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ViewType.VIEW_TYPE_SELLER.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ViewType.VIEW_TYPE_PROMOTION.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ViewType.VIEW_TYPE_TOTALS.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$shoppingcart$CartAdapter$ViewType[ViewType.VIEW_TYPE_UNKNOWN.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            long l;
            switch (_cls1..SwitchMap.com.ebay.nautilus.domain.data.ShoppingCart.Item.Status[item.status.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                l = EbayResponse.currentHostTime();
                break;
            }
            countdownTimer = new CountDownTimer(item.itemEndTime.getTime() - l, 1000L) {

                final ItemViewHolder this$0;

                public void onFinish()
                {
                    setStatusBanner(0x7f070a82, 0x7f0d00e3, null);
                }

                public void onTick(long l)
                {
                    String s = Util.formatDayHourMinSec(title.getContext(), l);
                    setStatusBanner(0x7f070a83, 0x7f0d00ee, s);
                }

            
            {
                this$0 = ItemViewHolder.this;
                super(l, l1);
            }
            };
            countdownTimer.start();
        }

        private boolean updateStatusBannerFor(com.ebay.nautilus.domain.data.ShoppingCart.Item item)
        {
            int i;
            int j;
            byte byte0;
            byte byte1;
            byte0 = -1;
            byte1 = -1;
            i = byte0;
            j = byte1;
            if (item == null) goto _L2; else goto _L1
_L1:
            _cls1..SwitchMap.com.ebay.nautilus.domain.data.ShoppingCart.Item.Status[item.status.ordinal()];
            JVM INSTR tableswitch 1 9: default 76
        //                       1 163
        //                       2 97
        //                       3 108
        //                       4 119
        //                       5 130
        //                       6 141
        //                       7 152
        //                       8 174
        //                       9 185;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L12:
            break MISSING_BLOCK_LABEL_185;
_L3:
            j = byte1;
            i = byte0;
_L2:
            setStatusBanner(j, i, "");
            return j > 0;
_L5:
            i = 0x7f0d00e3;
            j = 0x7f070aa4;
              goto _L2
_L6:
            i = 0x7f0d00ee;
            j = 0x7f070a9c;
              goto _L2
_L7:
            i = 0x7f0d00ee;
            j = 0x7f070ab4;
              goto _L2
_L8:
            i = 0x7f0d00e3;
            j = 0x7f070a82;
              goto _L2
_L9:
            i = 0x7f0d00f0;
            j = 0x7f070a9a;
              goto _L2
_L10:
            i = 0x7f0d00e3;
            j = 0x7f070a99;
              goto _L2
_L4:
            i = 0x7f0d00ee;
            j = 0x7f070a83;
              goto _L2
_L11:
            i = 0x7f0d00ee;
            j = 0x7f070a90;
              goto _L2
            i = 0x7f0d00ee;
            j = 0x7f070aa2;
              goto _L2
        }

        public void update(Object obj, boolean flag)
        {
            obj = (com.ebay.nautilus.domain.data.ShoppingCart.Item)obj;
            if (obj != null)
            {
                DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
                title.setText(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).getTitle(deviceconfiguration.get(DcsBoolean.itemTitleTranslationEnabled)));
                ImageView imageview;
                if (invertedCurrencyConversionDisplay && CartAdapter.isConverted(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj))))
                {
                    price.setTypeface(null, 2);
                    priceInItemSite.setVisibility(0);
                    priceInItemSite.setText(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).itemPrice.listedPrice.toItemCurrency(), ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).site.getLocale(), 2));
                    Object obj1;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).shippingCost.isZero())
                    {
                        shippingCostInItemSite.setVisibility(8);
                    } else
                    {
                        shippingCostInItemSite.setVisibility(0);
                        shippingCost.setTypeface(null, 2);
                        shippingCostInItemSite.setText(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).shippingCost.listedPrice.toItemCurrency(), ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).site.getLocale(), 2));
                    }
                } else
                {
                    priceInItemSite.setVisibility(8);
                    shippingCostInItemSite.setVisibility(8);
                    price.setTypeface(null, 0);
                    shippingCost.setTypeface(null, 0);
                }
                price.setText(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).itemPrice.sitePrice.multiplyBy(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).requestedQuantity), 2));
                if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).shippingCost.isZero())
                {
                    shippingCost.setText(0x7f070421);
                } else
                {
                    shippingCost.setText(shippingCost.getContext().getString(0x7f070a8d, new Object[] {
                        EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).shippingCost.sitePrice, 2)
                    }));
                }
                productImage.setRemoteImageUrl(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).imageUrl);
                productImage.setTag(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).imageUrl);
                if (!((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).variationSpecifics.isEmpty())
                {
                    variations.setText(mapNameValuesToString(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).variationSpecifics));
                    variations.setVisibility(0);
                } else
                {
                    variations.setVisibility(8);
                }
                if (!((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).itemSpecifics.isEmpty())
                {
                    itemSpecifics.setText(mapMapValueToString(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).itemSpecifics));
                    itemSpecifics.setVisibility(0);
                } else
                {
                    itemSpecifics.setVisibility(8);
                }
                obj1 = (TextView)quantityButton.findViewById(0x7f1007cb);
                imageview = (ImageView)quantityButton.findViewById(0x7f1007cc);
                if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).availableQuantity <= 1 || ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).isEnded || ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).isTransacted)
                {
                    quantityButton.setEnabled(false);
                    imageview.setVisibility(8);
                } else
                {
                    quantityButton.setEnabled(true);
                    imageview.setVisibility(0);
                }
                ((TextView) (obj1)).setText(Integer.toString(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).requestedQuantity));
                if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).savedForLater)
                {
                    obj1 = removeFromSavedButton;
                    int i;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).status.isRemoveable)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((Button) (obj1)).setVisibility(i);
                    obj1 = addToCartButton;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).status.isCartable)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((Button) (obj1)).setVisibility(i);
                    removeFromCartButton.setVisibility(8);
                    saveForLaterButton.setVisibility(8);
                    quantityButton.setVisibility(8);
                } else
                if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).transactionId.longValue() > -1L)
                {
                    removeFromCartButton.setVisibility(8);
                    Button button = saveForLaterButton;
                    int j;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).status.isSaveable && ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).lineItemType != com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LineItemTypes.SELLER_CREATED_ORDER)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    button.setVisibility(j);
                    quantityButton.setVisibility(0);
                    removeFromSavedButton.setVisibility(8);
                    addToCartButton.setVisibility(8);
                } else
                {
                    Button button1 = removeFromCartButton;
                    int k;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).status.isRemoveable)
                    {
                        k = 0;
                    } else
                    {
                        k = 8;
                    }
                    button1.setVisibility(k);
                    button1 = saveForLaterButton;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).status.isSaveable && ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)).lineItemType != com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LineItemTypes.SELLER_CREATED_ORDER)
                    {
                        k = 0;
                    } else
                    {
                        k = 8;
                    }
                    button1.setVisibility(k);
                    quantityButton.setVisibility(0);
                    removeFromSavedButton.setVisibility(8);
                    addToCartButton.setVisibility(8);
                }
                removeFromSavedButton.setTag(0x7f100010, obj);
                removeFromCartButton.setTag(0x7f100010, obj);
                saveForLaterButton.setTag(0x7f100010, obj);
                addToCartButton.setTag(0x7f100010, obj);
                quantityButton.setTag(0x7f100010, obj);
                if (flag)
                {
                    multipleItemDivider.setVisibility(8);
                } else
                {
                    multipleItemDivider.setVisibility(0);
                }
                if (updateStatusBannerFor(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj))))
                {
                    title.setLines(2);
                } else
                {
                    title.setLines(3);
                }
                title.setEllipsize(android.text.TextUtils.TruncateAt.END);
                updateCountdownTimer(((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj)));
            }
        }


        public ItemViewHolder(ShoppingCartActivity shoppingcartactivity, View view)
        {
            title = (TextView)view.findViewById(0x7f10005f);
            price = (TextView)view.findViewById(0x7f100109);
            shippingCost = (TextView)view.findViewById(0x7f1007c0);
            productImage = (RemoteImageView)view.findViewById(0x7f1002ed);
            variations = (TextView)view.findViewById(0x7f1007c2);
            quantityButton = (LinearLayout)view.findViewById(0x7f1007c9);
            quantityButton.setOnClickListener(shoppingcartactivity);
            shoppingcartactivity.registerForContextMenu(quantityButton);
            removeFromCartButton = (Button)view.findViewById(0x7f1007c6);
            removeFromCartButton.setOnClickListener(shoppingcartactivity);
            removeFromSavedButton = (Button)view.findViewById(0x7f1007c5);
            removeFromSavedButton.setOnClickListener(shoppingcartactivity);
            addToCartButton = (Button)view.findViewById(0x7f1007c8);
            addToCartButton.setOnClickListener(shoppingcartactivity);
            saveForLaterButton = (Button)view.findViewById(0x7f1007c7);
            saveForLaterButton.setOnClickListener(shoppingcartactivity);
            statusBanner = (RelativeLayout)view.findViewById(0x7f1007c4);
            statusBannerPrimary = (TextView)statusBanner.findViewById(0x7f1007bb);
            statusBannerSecondary = (TextView)statusBanner.findViewById(0x7f1007ba);
            priceInItemSite = (TextView)view.findViewById(0x7f1007bf);
            shippingCostInItemSite = (TextView)view.findViewById(0x7f1007c1);
            multipleItemDivider = view.findViewById(0x7f1007cd);
            view.setOnClickListener(shoppingcartactivity);
            invertedCurrencyConversionDisplay = MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.ShoppingCartInvertCurrencyConversionDisplay);
            itemSpecifics = (TextView)view.findViewById(0x7f1007c3);
        }
    }

    private static final class PromotionViewHolder
        implements ViewHolder
    {

        private final View boundView;
        private final String discountFormat;
        public View multipleItemDivider;
        public TextView promotionDiscount;
        public TextView promotionText;

        public void update(Object obj, boolean flag)
        {
label0:
            {
                obj = (com.ebay.nautilus.domain.data.ShoppingCart.Promotion)obj;
                if (obj != null)
                {
                    DeviceConfiguration deviceconfiguration;
                    boolean flag1;
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (obj)).status == com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.APPLIED)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    promotionText.setText(((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (obj)).message);
                    deviceconfiguration = DeviceConfiguration.getAsync();
                    boundView.setClickable(deviceconfiguration.get(DcsBoolean.smeSupport));
                    if (flag1)
                    {
                        if (!((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (obj)).discount.isZero())
                        {
                            promotionDiscount.setText(String.format(discountFormat, new Object[] {
                                EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShoppingCart.Promotion) (obj)).discount, 2)
                            }));
                            promotionDiscount.setVisibility(0);
                        } else
                        {
                            promotionDiscount.setVisibility(8);
                        }
                    } else
                    {
                        promotionDiscount.setVisibility(8);
                    }
                    if (!flag)
                    {
                        break label0;
                    }
                    multipleItemDivider.setVisibility(8);
                }
                return;
            }
            multipleItemDivider.setVisibility(0);
        }

        public PromotionViewHolder(ShoppingCartActivity shoppingcartactivity, View view)
        {
            boundView = view;
            promotionText = (TextView)view.findViewById(0x7f1007cf);
            promotionDiscount = (TextView)view.findViewById(0x7f1007d0);
            multipleItemDivider = view.findViewById(0x7f1007cd);
            view.setOnClickListener(shoppingcartactivity);
            discountFormat = shoppingcartactivity.getResources().getString(0x7f070a80);
        }
    }

    private static final class SellerViewHolder
        implements ViewHolder
    {

        private final String sellerNameLabel;
        public TextView statusBanner;
        public TextView title;

        public void update(Object obj, boolean flag)
        {
label0:
            {
                obj = (com.ebay.nautilus.domain.data.ShoppingCart.Seller)obj;
                if (obj != null)
                {
                    SpannableString spannablestring = new SpannableString(((com.ebay.nautilus.domain.data.ShoppingCart.Seller) (obj)).username);
                    spannablestring.setSpan(new StyleSpan(1), 0, spannablestring.length(), 0);
                    title.setText(TextUtils.concat(new CharSequence[] {
                        sellerNameLabel, spannablestring
                    }));
                    if (!((com.ebay.nautilus.domain.data.ShoppingCart.Seller) (obj)).isOnVacation)
                    {
                        break label0;
                    }
                    if (((com.ebay.nautilus.domain.data.ShoppingCart.Seller) (obj)).vacationEndsOn.before(Calendar.getInstance().getTime()))
                    {
                        statusBanner.setText(0x7f070aa6);
                    } else
                    {
                        obj = DateFormat.getMediumDateFormat(statusBanner.getContext()).format(((com.ebay.nautilus.domain.data.ShoppingCart.Seller) (obj)).vacationEndsOn);
                        statusBanner.setText(statusBanner.getContext().getString(0x7f070aa5, new Object[] {
                            obj
                        }));
                    }
                    statusBanner.setVisibility(0);
                }
                return;
            }
            statusBanner.setVisibility(8);
        }

        public SellerViewHolder(View view)
        {
            title = (TextView)view.findViewById(0x7f10005f);
            statusBanner = (TextView)view.findViewById(0x7f1007c4);
            sellerNameLabel = view.getContext().getString(0x7f070aa8);
        }
    }

    private static final class TotalsViewHolder
        implements ViewHolder
    {

        public TextView bopisSubtotal;
        public TextView bopisSubtotalLabel;
        public TextView cartSubtotal;
        private final String discountFormat;
        public TextView discountSubtotal;
        public TextView discountSubtotalLabel;
        private final boolean invertedCurrencyConversionDisplay;
        public TextView itemSubtotal;
        public TextView itemSubtotalLabel;
        private final String localCurrencyCode = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
        public TextView sellerDiscountSubtotalAmount;
        public TextView sellerDiscountSubtotalLabel;
        public TextView shippingImportSubtotalAmount;
        public TextView shippingImportSubtotalLabel;
        public TextView shippingSubtotal;
        public TextView shippingSubtotalLabel;
        public TextView taxAmount;
        public TextView taxLabel;

        public void update(Object obj, boolean flag)
        {
label0:
            {
                com.ebay.nautilus.domain.data.ShoppingCart.Summary summary = (com.ebay.nautilus.domain.data.ShoppingCart.Summary)obj;
                if (summary != null)
                {
                    cartSubtotal.setText(EbayCurrencyUtil.formatDisplay(summary.total, 2));
                    itemSubtotal.setText(EbayCurrencyUtil.formatDisplay(summary.itemSubTotal, 2));
                    itemSubtotalLabel.setText(itemSubtotalLabel.getContext().getString(0x7f070a8f, new Object[] {
                        Integer.valueOf(summary.totalBuyableItems)
                    }));
                    PostalCodeSpecification postalcodespecification;
                    if (summary.shippingSubTotal.isZero())
                    {
                        shippingSubtotal.setText(0x7f070421);
                    } else
                    {
                        shippingSubtotal.setText(EbayCurrencyUtil.formatDisplay(summary.shippingSubTotal, 2));
                    }
                    postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
                    obj = "";
                    if (postalcodespecification != null)
                    {
                        obj = postalcodespecification.postalCode;
                    }
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        shippingSubtotalLabel.setText(0x7f070aab);
                    } else
                    {
                        shippingSubtotalLabel.setText(shippingSubtotalLabel.getContext().getString(0x7f070aac, new Object[] {
                            obj
                        }));
                    }
                    if (summary.hasBopisItem)
                    {
                        bopisSubtotal.setText(0x7f070421);
                        bopisSubtotal.setVisibility(0);
                        bopisSubtotalLabel.setVisibility(0);
                        bopisSubtotalLabel.setText(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
                    } else
                    {
                        bopisSubtotal.setVisibility(8);
                        bopisSubtotalLabel.setVisibility(8);
                    }
                    if (!summary.importCharges.isZero())
                    {
                        shippingImportSubtotalAmount.setText(EbayCurrencyUtil.formatDisplay(summary.importCharges, 2));
                        shippingImportSubtotalAmount.setVisibility(0);
                        shippingImportSubtotalLabel.setVisibility(0);
                    } else
                    {
                        shippingImportSubtotalAmount.setVisibility(8);
                        shippingImportSubtotalLabel.setVisibility(8);
                    }
                    if (!summary.taxSubTotal.isZero())
                    {
                        taxAmount.setText(EbayCurrencyUtil.formatDisplay(summary.taxSubTotal, 2));
                        taxAmount.setVisibility(0);
                        taxLabel.setVisibility(0);
                    } else
                    {
                        taxLabel.setVisibility(8);
                        taxAmount.setVisibility(8);
                    }
                    if (!summary.discount.isZero())
                    {
                        discountSubtotal.setText(String.format(discountFormat, new Object[] {
                            EbayCurrencyUtil.formatDisplay(summary.discount, 2)
                        }));
                        discountSubtotal.setVisibility(0);
                        discountSubtotalLabel.setVisibility(0);
                    } else
                    {
                        discountSubtotal.setVisibility(8);
                        discountSubtotalLabel.setVisibility(8);
                    }
                    if (!summary.adjustmentsSubTotal.isZero())
                    {
                        flag = summary.adjustmentsSubTotal.isGreaterThanZero();
                        obj = MyApp.getApp();
                        CurrencyAmount currencyamount;
                        StringBuilder stringbuilder;
                        int i;
                        if (flag)
                        {
                            i = 0x7f070c66;
                        } else
                        {
                            i = 0x7f070c67;
                        }
                        obj = ((MyApp) (obj)).getString(i);
                        currencyamount = new CurrencyAmount(summary.adjustmentsSubTotal.getValueAsBigDecimal().abs(), summary.adjustmentsSubTotal.getCurrencyCode());
                        stringbuilder = new StringBuilder();
                        if (!flag)
                        {
                            stringbuilder.append("- ");
                        }
                        stringbuilder.append(EbayCurrencyUtil.formatDisplay(currencyamount, 2));
                        sellerDiscountSubtotalAmount.setText(stringbuilder);
                        sellerDiscountSubtotalLabel.setText(((CharSequence) (obj)));
                        sellerDiscountSubtotalAmount.setVisibility(0);
                        sellerDiscountSubtotalLabel.setVisibility(0);
                    } else
                    {
                        sellerDiscountSubtotalAmount.setVisibility(8);
                        sellerDiscountSubtotalLabel.setVisibility(8);
                    }
                    if (invertedCurrencyConversionDisplay)
                    {
                        if (!summary.isLocalCurrencyCart(localCurrencyCode))
                        {
                            break label0;
                        }
                        cartSubtotal.setTypeface(null, 0);
                        itemSubtotal.setTypeface(null, 0);
                        shippingImportSubtotalAmount.setTypeface(null, 0);
                        shippingSubtotal.setTypeface(null, 0);
                        bopisSubtotal.setTypeface(null, 0);
                        taxAmount.setTypeface(null, 0);
                        discountSubtotal.setTypeface(null, 0);
                    }
                }
                return;
            }
            cartSubtotal.setTypeface(null, 2);
            itemSubtotal.setTypeface(null, 2);
            shippingImportSubtotalAmount.setTypeface(null, 2);
            shippingSubtotal.setTypeface(null, 2);
            bopisSubtotal.setTypeface(null, 2);
            taxAmount.setTypeface(null, 2);
            discountSubtotal.setTypeface(null, 2);
        }

        public TotalsViewHolder(View view)
        {
            cartSubtotal = (TextView)view.findViewById(0x7f1007e6);
            itemSubtotalLabel = (TextView)view.findViewById(0x7f1007d7);
            itemSubtotal = (TextView)view.findViewById(0x7f1007d8);
            shippingSubtotalLabel = (TextView)view.findViewById(0x7f1007d9);
            shippingImportSubtotalAmount = (TextView)view.findViewById(0x7f1007dc);
            shippingImportSubtotalLabel = (TextView)view.findViewById(0x7f1007db);
            shippingSubtotal = (TextView)view.findViewById(0x7f1007da);
            bopisSubtotal = (TextView)view.findViewById(0x7f1007de);
            bopisSubtotalLabel = (TextView)view.findViewById(0x7f1007dd);
            discountSubtotal = (TextView)view.findViewById(0x7f1007e2);
            discountSubtotalLabel = (TextView)view.findViewById(0x7f1007e1);
            sellerDiscountSubtotalAmount = (TextView)view.findViewById(0x7f1007e4);
            sellerDiscountSubtotalLabel = (TextView)view.findViewById(0x7f1007e3);
            taxAmount = (TextView)view.findViewById(0x7f1007e0);
            taxLabel = (TextView)view.findViewById(0x7f1007df);
            discountFormat = view.getResources().getString(0x7f070a80);
            invertedCurrencyConversionDisplay = MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.ShoppingCartInvertCurrencyConversionDisplay);
        }
    }

    private static final class UnknownViewHolder
        implements ViewHolder
    {

        public TextView primary;

        public void update(Object obj, boolean flag)
        {
            primary.setText(obj.toString());
        }

        public UnknownViewHolder(View view)
        {
            primary = (TextView)view.findViewById(0x1020014);
        }
    }

    private static interface ViewHolder
    {

        public abstract void update(Object obj, boolean flag);
    }

    private static final class ViewType extends Enum
    {

        private static final ViewType $VALUES[];
        public static final ViewType VIEW_TYPE_ITEM;
        public static final ViewType VIEW_TYPE_PROMOTION;
        public static final ViewType VIEW_TYPE_SELLER;
        public static final ViewType VIEW_TYPE_TOTALS;
        public static final ViewType VIEW_TYPE_UNKNOWN;
        final boolean isSelectable;
        final int layoutResourceId;

        public static ViewType valueOf(String s)
        {
            return (ViewType)Enum.valueOf(com/ebay/mobile/shoppingcart/CartAdapter$ViewType, s);
        }

        public static ViewType[] values()
        {
            return (ViewType[])$VALUES.clone();
        }

        static 
        {
            VIEW_TYPE_UNKNOWN = new ViewType("VIEW_TYPE_UNKNOWN", 0, 0x1090003, false);
            VIEW_TYPE_ITEM = new ViewType("VIEW_TYPE_ITEM", 1, 0x7f030246, true);
            VIEW_TYPE_SELLER = new ViewType("VIEW_TYPE_SELLER", 2, 0x7f030248, false);
            VIEW_TYPE_PROMOTION = new ViewType("VIEW_TYPE_PROMOTION", 3, 0x7f030247, true);
            VIEW_TYPE_TOTALS = new ViewType("VIEW_TYPE_TOTALS", 4, 0x7f03024a, false);
            $VALUES = (new ViewType[] {
                VIEW_TYPE_UNKNOWN, VIEW_TYPE_ITEM, VIEW_TYPE_SELLER, VIEW_TYPE_PROMOTION, VIEW_TYPE_TOTALS
            });
        }

        private ViewType(String s, int i, int j, boolean flag)
        {
            super(s, i);
            isSelectable = flag;
            layoutResourceId = j;
        }
    }


    private final LayoutInflater layoutInflater;

    public CartAdapter(ShoppingCartActivity shoppingcartactivity, List list)
    {
        super(shoppingcartactivity, -1, list);
        layoutInflater = LayoutInflater.from(shoppingcartactivity);
    }

    private static final ViewHolder createViewHolder(ViewType viewtype, ShoppingCartActivity shoppingcartactivity, View view)
    {
        if (viewtype == null)
        {
            return new UnknownViewHolder(view);
        }
        switch (_cls1..SwitchMap.com.ebay.mobile.shoppingcart.CartAdapter.ViewType[viewtype.ordinal()])
        {
        default:
            return new UnknownViewHolder(view);

        case 1: // '\001'
            return new ItemViewHolder(shoppingcartactivity, view);

        case 2: // '\002'
            return new SellerViewHolder(view);

        case 3: // '\003'
            return new PromotionViewHolder(shoppingcartactivity, view);

        case 4: // '\004'
            return new TotalsViewHolder(view);
        }
    }

    private static ViewType getItemViewTypeEnum(Object obj)
    {
        if (obj == null)
        {
            return ViewType.VIEW_TYPE_UNKNOWN;
        }
        if (obj instanceof com.ebay.nautilus.domain.data.ShoppingCart.Item)
        {
            return ViewType.VIEW_TYPE_ITEM;
        }
        if (obj instanceof com.ebay.nautilus.domain.data.ShoppingCart.Seller)
        {
            return ViewType.VIEW_TYPE_SELLER;
        }
        if (obj instanceof com.ebay.nautilus.domain.data.ShoppingCart.Promotion)
        {
            return ViewType.VIEW_TYPE_PROMOTION;
        }
        if (obj instanceof com.ebay.nautilus.domain.data.ShoppingCart.Summary)
        {
            return ViewType.VIEW_TYPE_TOTALS;
        } else
        {
            return ViewType.VIEW_TYPE_UNKNOWN;
        }
    }

    private static boolean isConverted(com.ebay.nautilus.domain.data.ShoppingCart.Item item)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item != null)
        {
            flag = flag1;
            if (item.itemPrice != com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion.ZERO)
            {
                flag = flag1;
                if (item.itemPrice.listedPrice != CurrencyAmount.ZERO)
                {
                    flag = flag1;
                    if (!item.itemPrice.listedPrice.getCurrencyCode().equals(item.itemPrice.sitePrice.getCurrencyCode()))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public int getItemViewType(int i)
    {
        return getItemViewTypeEnum(getItem(i)).ordinal();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = getItem(i);
        ViewType viewtype = getItemViewTypeEnum(obj);
        ShoppingCartActivity shoppingcartactivity = (ShoppingCartActivity)getContext();
        boolean flag;
        if (view == null)
        {
            view = layoutInflater.inflate(viewtype.layoutResourceId, viewgroup, false);
            viewgroup = createViewHolder(viewtype, shoppingcartactivity, view);
            view.setTag(0x7f100011, viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag(0x7f100011);
        }
        if (i + 1 < getCount())
        {
            if (!getItemViewTypeEnum(getItem(i + 1)).isSelectable)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = true;
        }
        viewgroup.update(obj, flag);
        view.setTag(0x7f100010, obj);
        return view;
    }

    public int getViewTypeCount()
    {
        return ViewType.values().length;
    }

    public boolean isEnabled(int i)
    {
        return getItemViewTypeEnum(getItem(i)).isSelectable;
    }

}
