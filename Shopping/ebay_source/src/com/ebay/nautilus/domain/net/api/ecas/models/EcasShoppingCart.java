// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class EcasShoppingCart
{
    public static class Address
    {

        public String addressId;
        public String city;
        public String country;
        public String county;
        public String name;
        public String phone;
        public String postalCode;
        public String stateOrProvince;
        public String street1;
        public String street2;

        public Address()
        {
        }
    }

    public static class AddressIdentifier
    {

        public String type;
        public String value;

        public AddressIdentifier()
        {
        }
    }

    public static class Adjustment
    {

        public ItemCurrency amount;
        public String description;

        public Adjustment()
        {
        }
    }

    public static class CartCounts
    {

        public int buyableCount;
        public int buyableLimit;
        public int transactionCount;
        public int unbuyableCount;

        public CartCounts()
        {
        }
    }

    public static abstract class CartItem
    {

        public List attributes;
        public String condition;
        public Date createdOn;
        public Long ebayItemId;
        public String galleryUrl;
        public List imageUrls;
        public boolean isItemEnded;
        public boolean isUnbuyable;
        public String itemTitle;
        public Date lastModifedOn;
        public List messages;
        public List promotions;
        public int quantityAvailable;
        public int quantityRequested;
        public ItemCurrency rewards;
        public VariationDetails variationDetails;
        public String viewItemUrl;

        public Map getItemSpecifics()
        {
            HashMap hashmap;
            DeviceConfiguration deviceconfiguration;
            Object obj1;
            obj1 = NamedAttribute.listToMap(attributes);
            if (!((Map) (obj1)).containsKey("ItemSpecifics"))
            {
                return Collections.emptyMap();
            }
            hashmap = new HashMap();
            deviceconfiguration = DeviceConfiguration.getAsync();
            Object obj = (JsonObject)(new Gson()).fromJson((String)((Map) (obj1)).get("ItemSpecifics"), com/google/gson/JsonObject);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            if (!((JsonObject) (obj)).isJsonNull())
            {
                break MISSING_BLOCK_LABEL_83;
            }
            return Collections.emptyMap();
            String s = null;
            obj1 = EbaySite.getInstanceFromId((String)((Map) (obj1)).get("ListingSiteId"));
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            s = EnergyEfficiencyRating.getItemSpecificsValueKey(((EbaySite) (obj1)));
            obj = ((JsonObject) (obj)).entrySet().iterator();
_L7:
            if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
            Object obj2;
            obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
            obj1 = (String)((java.util.Map.Entry) (obj2)).getKey();
            obj2 = ((JsonPrimitive)((java.util.Map.Entry) (obj2)).getValue()).getAsString();
            if (s == null) goto _L4; else goto _L3
_L3:
            if (!s.equals(obj1)) goto _L4; else goto _L5
_L5:
            if (!deviceconfiguration.get(DcsNautilusBoolean.payments_showEekRatings) || obj2 == null) goto _L7; else goto _L6
_L6:
            if (((String) (obj2)).length() <= 0) goto _L7; else goto _L8
_L8:
            hashmap.put(EnergyEfficiencyRating.getInstanceForLangauge(Locale.getDefault().getLanguage()).getName(true), obj2);
              goto _L7
            JsonSyntaxException jsonsyntaxexception;
            jsonsyntaxexception;
            Collections.emptyMap();
_L2:
            return Collections.unmodifiableMap(hashmap);
_L4:
            if (!deviceconfiguration.get(DcsNautilusBoolean.payments_showItemSpecifics)) goto _L7; else goto _L9
_L9:
            hashmap.put(obj1, obj2);
              goto _L7
        }

        public CartItem()
        {
        }
    }

    public static class CurrentBidDetails
    {

        public ItemCurrency bidAmount;
        public String bidder;

        public CurrentBidDetails()
        {
        }
    }

    public static class DateWithTimeZone extends Date
    {

        public DateWithTimeZone(Date date)
        {
            if (date != null)
            {
                setTime(date.getTime());
            }
        }
    }

    public static class Fee
    {

        public ItemCurrency amount;
        public String description;

        public Fee()
        {
        }
    }

    public static class Incentive
    {

        public String code;
        public String message;
        public ItemCurrency redeemedAmount;
        public String type;

        public Incentive()
        {
        }
    }

    public static class ItemCurrencyWithConversion
    {

        public String basisAmount;
        public String basisCurrencyId;
        public String code;
        public String value;

        public ItemCurrencyWithConversion()
        {
        }
    }

    public static class ItemGroup
    {

        public List items;
        public String paymentStatus;
        public List problemStatus;
        public List promotions;
        public TotalSummary totalSummary;

        public ItemGroup()
        {
        }
    }

    public static class Message
    {

        public int code;
        public String level;
        public List parameters;

        public Message()
        {
        }
    }

    public static class NameValueList
    {

        protected List innerList;

        public List asList()
        {
            if (innerList != null)
            {
                return innerList;
            } else
            {
                return Collections.emptyList();
            }
        }

        public Map asMap()
        {
            HashMap hashmap = new HashMap();
            if (innerList != null)
            {
                NameValue namevalue;
                for (Iterator iterator = innerList.iterator(); iterator.hasNext(); hashmap.put(namevalue.getName(), namevalue.getValues()))
                {
                    namevalue = (NameValue)iterator.next();
                }

            }
            return Collections.unmodifiableMap(hashmap);
        }

        public NameValueList()
        {
        }
    }

    public static class NamedAttribute
    {

        public String name;
        public String value;

        public static final NamedAttribute getAttribute(List list, String s)
        {
            if (list == null)
            {
                return null;
            }
            for (list = list.iterator(); list.hasNext();)
            {
                NamedAttribute namedattribute = (NamedAttribute)list.next();
                if (namedattribute != null && namedattribute.name.equalsIgnoreCase(s))
                {
                    return namedattribute;
                }
            }

            return null;
        }

        public static final Map listToMap(List list)
        {
            if (list == null || list.isEmpty())
            {
                return Collections.emptyMap();
            }
            HashMap hashmap = new HashMap();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                NamedAttribute namedattribute = (NamedAttribute)list.next();
                if (namedattribute != null)
                {
                    hashmap.put(namedattribute.name, namedattribute.value);
                }
            } while (true);
            return Collections.unmodifiableMap(hashmap);
        }

        public NamedAttribute()
        {
        }
    }

    public static class NonAuctionItem extends CartItem
    {

        public Date addedAt;
        public List adjustments;
        public List availablePaymentMethods;
        public List availablePickupMethods;
        public List availableShippingServices;
        public Date endedAt;
        public List fees;
        public ItemCurrency fullPrice;
        public List incentives;
        public boolean isImmediatePay;
        public Long lineItemId;
        public Date orderCreatedAt;
        public String orderId;
        public List orderTransactions;
        public ItemCurrencyWithConversion price;
        public List problems;
        public PickupMethod selectedPickupMethod;
        public ShippingService selectedShippingService;
        public SalesTax tax;
        public Date transactionCreatedAt;
        public String transactionId;

        public boolean isBopisSelected()
        {
            NamedAttribute namedattribute;
            if (selectedPickupMethod != null)
            {
                if ((namedattribute = NamedAttribute.getAttribute(selectedPickupMethod.attributes, "storeId")) != null && !TextUtils.isEmpty(namedattribute.value))
                {
                    return true;
                }
            }
            return false;
        }

        public boolean isEnded()
        {
label0:
            {
                boolean flag = false;
                if (endedAt != null)
                {
                    if (!isItemEnded)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            return EbayResponse.currentHostTime() > endedAt.getTime();
        }

        public NonAuctionItem()
        {
        }
    }

    public static class NonAuctions
    {

        public String cartId;
        public CartCounts counts;
        public Date createdOn;
        public Date lastAccessedAt;
        public Date lastModifiedBySystemOn;
        public Date lastModifiedByUserOn;
        public List messages;
        public List promotions;
        public List sellerGroups;
        public Address shippingAddress;
        public TotalSummary totalSummary;

        public int getBuyableCount()
        {
            Iterator iterator;
            int i;
            int j;
            j = 0;
            i = 0;
            if (sellerGroups == null)
            {
                break MISSING_BLOCK_LABEL_251;
            }
            iterator = sellerGroups.iterator();
_L2:
            Object obj;
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_251;
                }
                obj = (SellerGroup)iterator.next();
            } while (obj == null || ((SellerGroup) (obj)).itemGroups == null);
            obj = ((SellerGroup) (obj)).itemGroups.iterator();
            j = i;
_L4:
            i = j;
            if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
            Object obj1 = (ItemGroup)((Iterator) (obj)).next();
            if (((ItemGroup) (obj1)).items == null) goto _L4; else goto _L3
_L3:
            obj1 = ((ItemGroup) (obj1)).items.iterator();
            i = j;
_L7:
            j = i;
            if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L5
_L5:
            Object obj2;
            obj2 = (NonAuctionItem)((Iterator) (obj1)).next();
            if (((NonAuctionItem) (obj2)).orderTransactions == null || ((NonAuctionItem) (obj2)).orderTransactions.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_211;
            }
            obj2 = ((NonAuctionItem) (obj2)).orderTransactions.iterator();
            j = i;
_L8:
            i = j;
            if (!((Iterator) (obj2)).hasNext()) goto _L7; else goto _L6
_L6:
            j += ((OrderTransaction)((Iterator) (obj2)).next()).quantityRequested;
              goto _L8
            if (!TextUtils.isEmpty(((NonAuctionItem) (obj2)).transactionId) || !((NonAuctionItem) (obj2)).isItemEnded && !((NonAuctionItem) (obj2)).isUnbuyable)
            {
                i += ((NonAuctionItem) (obj2)).quantityRequested;
            }
              goto _L7
            return j;
        }

        public boolean hasBopisSelectedItem()
        {
            if (sellerGroups != null)
            {
                Iterator iterator = sellerGroups.iterator();
                while (iterator.hasNext()) 
                {
                    Object obj = (SellerGroup)iterator.next();
                    if (((SellerGroup) (obj)).itemGroups != null)
                    {
                        obj = ((SellerGroup) (obj)).itemGroups.iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            Object obj1 = (ItemGroup)((Iterator) (obj)).next();
                            if (((ItemGroup) (obj1)).items != null)
                            {
                                obj1 = ((ItemGroup) (obj1)).items.iterator();
                                while (((Iterator) (obj1)).hasNext()) 
                                {
                                    if (((NonAuctionItem)((Iterator) (obj1)).next()).isBopisSelected())
                                    {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        public NonAuctions()
        {
        }
    }

    public static class OrderTransaction extends CartItem
    {

        public Date createdAt;
        public ItemCurrency fullPrice;
        public ItemCurrencyWithConversion price;
        public String transactionId;

        public OrderTransaction()
        {
        }
    }

    public static class PaymentMethod
    {

        public boolean isApplicable;
        public String name;

        public PaymentMethod()
        {
        }
    }

    public static class PickupMethod
    {

        public List attributes;
        public boolean isApplicable;
        public String name;
        public String token;

        public PickupMethod()
        {
        }
    }

    public static class ProblemStatus
    {

        public String details;
        public String status;
        public String summary;
        public String systemId;

        public ProblemStatus()
        {
        }
    }

    public static class Promotion
    {

        public List attributes;
        public String code;
        public String message;
        public ItemCurrency promotionSavingsAmount;
        public String status;
        public PromotionType type;

        public Promotion()
        {
        }
    }

    public static final class PromotionType extends Enum
    {

        private static final PromotionType $VALUES[];
        public static final PromotionType BILL_ME_LATER_PROMOTIONAL_OFFER;
        public static final PromotionType SELLER_DISCOUNTED_PROMOTIONAL_OFFER;
        public static final PromotionType SHIPPING_PROMOTIONAL_OFFER;
        public static final PromotionType UNKNOWN;
        public final boolean isSellerPromotion;
        public final String token;

        public static PromotionType valueOf(String s)
        {
            return (PromotionType)Enum.valueOf(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionType, s);
        }

        public static PromotionType[] values()
        {
            return (PromotionType[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new PromotionType("UNKNOWN", 0, "Unknown", false);
            BILL_ME_LATER_PROMOTIONAL_OFFER = new PromotionType("BILL_ME_LATER_PROMOTIONAL_OFFER", 1, "BillMeLaterPromotionalOffer", false);
            SHIPPING_PROMOTIONAL_OFFER = new PromotionType("SHIPPING_PROMOTIONAL_OFFER", 2, "ShippingPromotionalOffer", false);
            SELLER_DISCOUNTED_PROMOTIONAL_OFFER = new PromotionType("SELLER_DISCOUNTED_PROMOTIONAL_OFFER", 3, "SellerDiscountedPromotionalOffer", true);
            $VALUES = (new PromotionType[] {
                UNKNOWN, BILL_ME_LATER_PROMOTIONAL_OFFER, SHIPPING_PROMOTIONAL_OFFER, SELLER_DISCOUNTED_PROMOTIONAL_OFFER
            });
        }

        private PromotionType(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            isSellerPromotion = flag;
            token = s1;
        }
    }

    public static final class PromotionType.Deserializer
        implements JsonDeserializer
    {

        public PromotionType deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            type = PromotionType.values();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (TextUtils.equals(jsonelement, ((PromotionType) (jsondeserializationcontext)).token))
                {
                    return jsondeserializationcontext;
                }
            }

            return PromotionType.UNKNOWN;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public PromotionType.Deserializer()
        {
        }
    }

    public static final class PromotionalOfferType extends Enum
    {

        private static final PromotionalOfferType $VALUES[];
        public static final PromotionalOfferType GENERIC;
        public static final PromotionalOfferType MARK_DOWN_SALE;
        public static final PromotionalOfferType PROMOTIONAL_SHIPPING;
        public static final PromotionalOfferType REBATE_OFFER;
        public static final PromotionalOfferType RELATIONAL;
        public static final PromotionalOfferType SALE_CLEARENCE;
        public static final PromotionalOfferType SALE_EVENT;
        public static final PromotionalOfferType TARGETED_OFFER;
        public static final PromotionalOfferType UNKNOWN;
        public static final PromotionalOfferType VERTICAL_OFFER;
        public final int designator;
        public final String token;

        public static PromotionalOfferType valueOf(String s)
        {
            return (PromotionalOfferType)Enum.valueOf(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionalOfferType, s);
        }

        public static PromotionalOfferType[] values()
        {
            return (PromotionalOfferType[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new PromotionalOfferType("UNKNOWN", 0, -1, "Unknown");
            RELATIONAL = new PromotionalOfferType("RELATIONAL", 1, 2, "BundleOffer");
            GENERIC = new PromotionalOfferType("GENERIC", 2, 3, "OrderSubTotalOffer");
            SALE_EVENT = new PromotionalOfferType("SALE_EVENT", 3, 4, "SaleEvent");
            PROMOTIONAL_SHIPPING = new PromotionalOfferType("PROMOTIONAL_SHIPPING", 4, 5, "PromotionalShipping");
            SALE_CLEARENCE = new PromotionalOfferType("SALE_CLEARENCE", 5, 6, "SaleAndClearence");
            VERTICAL_OFFER = new PromotionalOfferType("VERTICAL_OFFER", 6, 7, "VerticalOffer");
            REBATE_OFFER = new PromotionalOfferType("REBATE_OFFER", 7, 8, "RebateOffer");
            MARK_DOWN_SALE = new PromotionalOfferType("MARK_DOWN_SALE", 8, 11, "MarkDownSale");
            TARGETED_OFFER = new PromotionalOfferType("TARGETED_OFFER", 9, 9, "TargetedOffer");
            $VALUES = (new PromotionalOfferType[] {
                UNKNOWN, RELATIONAL, GENERIC, SALE_EVENT, PROMOTIONAL_SHIPPING, SALE_CLEARENCE, VERTICAL_OFFER, REBATE_OFFER, MARK_DOWN_SALE, TARGETED_OFFER
            });
        }

        private PromotionalOfferType(String s, int i, int j, String s1)
        {
            super(s, i);
            designator = j;
            token = s1;
        }
    }

    public static final class PromotionalOfferType.Deserializer
        implements JsonDeserializer
    {

        public PromotionalOfferType deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            type = PromotionalOfferType.values();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (TextUtils.equals(jsonelement, ((PromotionalOfferType) (jsondeserializationcontext)).token))
                {
                    return jsondeserializationcontext;
                }
            }

            return PromotionalOfferType.UNKNOWN;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public PromotionalOfferType.Deserializer()
        {
        }
    }

    public static final class PromotionalRuleTemplate extends Enum
    {

        private static final PromotionalRuleTemplate $VALUES[];
        public static final PromotionalRuleTemplate AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT;
        public static final PromotionalRuleTemplate AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT_RANGE;
        public static final PromotionalRuleTemplate BUNDLE_EPID_WITH_DISCOUNTS;
        public static final PromotionalRuleTemplate BUNDLE_EPID_WITH_DISCOUNTS_PERCENT;
        public static final PromotionalRuleTemplate BUNDLE_WITHOUT_DISCOUNTS;
        public static final PromotionalRuleTemplate BUNDLE_WITHOUT_DISCOUNTS_NO_FREE_SHIPPING;
        public static final PromotionalRuleTemplate BUNDLE_WITH_DISCOUNTS;
        public static final PromotionalRuleTemplate BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate BUY_1_ITEMS_GET_Y_PCT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate BUY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF;
        public static final PromotionalRuleTemplate BUY_N_ITEMS_GET_M_ITEMS_FREE;
        public static final PromotionalRuleTemplate BUY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate BUY_N_ITEMS_GET_Y_PCT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate FOR_EVERY_BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate FOR_EVERY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF;
        public static final PromotionalRuleTemplate FOR_EVERY_N_ITEMS_GET_M_ITEMS_FREE;
        public static final PromotionalRuleTemplate FOR_EVERY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate FOR_EVERY_X_AMT_SPENT_GET_Y_AMT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate MARK_DOWN_SALE;
        public static final PromotionalRuleTemplate PROMOTIONAL_SHIPPING;
        public static final PromotionalRuleTemplate PROMO_FREE_SHIPPING_ON_ITEM_X;
        public static final PromotionalRuleTemplate PROMO_FREE_SHIPPING_SPEND_X;
        public static final PromotionalRuleTemplate PROMO_FREE_SHIPPING_SPEND_X_ON_ITEM_Y;
        public static final PromotionalRuleTemplate PROMO_SHIPPING_COST_ON_ITEM_X;
        public static final PromotionalRuleTemplate PROMO_SHIPPING_COST_SPEND_X;
        public static final PromotionalRuleTemplate PROMO_SHIPPING_COST_SPEND_X_ON_ITEMS_Y;
        public static final PromotionalRuleTemplate REBATE_OFFER;
        public static final PromotionalRuleTemplate SALE_AND_CLEARANCE;
        public static final PromotionalRuleTemplate SALE_EVENT;
        public static final PromotionalRuleTemplate SPEND_X_AMT_GET_Y_AMT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate SPEND_X_AMT_GET_Y_PCT_OFF_SUBTOTAL;
        public static final PromotionalRuleTemplate VERTICAL_OFFER;

        public static PromotionalRuleTemplate valueOf(String s)
        {
            return (PromotionalRuleTemplate)Enum.valueOf(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionalRuleTemplate, s);
        }

        public static PromotionalRuleTemplate[] values()
        {
            return (PromotionalRuleTemplate[])$VALUES.clone();
        }

        static 
        {
            SPEND_X_AMT_GET_Y_AMT_OFF_SUBTOTAL = new PromotionalRuleTemplate("SPEND_X_AMT_GET_Y_AMT_OFF_SUBTOTAL", 0);
            SPEND_X_AMT_GET_Y_PCT_OFF_SUBTOTAL = new PromotionalRuleTemplate("SPEND_X_AMT_GET_Y_PCT_OFF_SUBTOTAL", 1);
            BUY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL = new PromotionalRuleTemplate("BUY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL", 2);
            BUY_N_ITEMS_GET_Y_PCT_OFF_SUBTOTAL = new PromotionalRuleTemplate("BUY_N_ITEMS_GET_Y_PCT_OFF_SUBTOTAL", 3);
            BUY_N_ITEMS_GET_M_ITEMS_FREE = new PromotionalRuleTemplate("BUY_N_ITEMS_GET_M_ITEMS_FREE", 4);
            BUY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF = new PromotionalRuleTemplate("BUY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF", 5);
            BUNDLE_WITH_DISCOUNTS = new PromotionalRuleTemplate("BUNDLE_WITH_DISCOUNTS", 6);
            BUNDLE_WITHOUT_DISCOUNTS = new PromotionalRuleTemplate("BUNDLE_WITHOUT_DISCOUNTS", 7);
            SALE_EVENT = new PromotionalRuleTemplate("SALE_EVENT", 8);
            SALE_AND_CLEARANCE = new PromotionalRuleTemplate("SALE_AND_CLEARANCE", 9);
            PROMOTIONAL_SHIPPING = new PromotionalRuleTemplate("PROMOTIONAL_SHIPPING", 10);
            PROMO_FREE_SHIPPING_SPEND_X = new PromotionalRuleTemplate("PROMO_FREE_SHIPPING_SPEND_X", 11);
            PROMO_SHIPPING_COST_SPEND_X = new PromotionalRuleTemplate("PROMO_SHIPPING_COST_SPEND_X", 12);
            PROMO_FREE_SHIPPING_SPEND_X_ON_ITEM_Y = new PromotionalRuleTemplate("PROMO_FREE_SHIPPING_SPEND_X_ON_ITEM_Y", 13);
            PROMO_SHIPPING_COST_SPEND_X_ON_ITEMS_Y = new PromotionalRuleTemplate("PROMO_SHIPPING_COST_SPEND_X_ON_ITEMS_Y", 14);
            PROMO_FREE_SHIPPING_ON_ITEM_X = new PromotionalRuleTemplate("PROMO_FREE_SHIPPING_ON_ITEM_X", 15);
            PROMO_SHIPPING_COST_ON_ITEM_X = new PromotionalRuleTemplate("PROMO_SHIPPING_COST_ON_ITEM_X", 16);
            BUNDLE_WITHOUT_DISCOUNTS_NO_FREE_SHIPPING = new PromotionalRuleTemplate("BUNDLE_WITHOUT_DISCOUNTS_NO_FREE_SHIPPING", 17);
            VERTICAL_OFFER = new PromotionalRuleTemplate("VERTICAL_OFFER", 18);
            REBATE_OFFER = new PromotionalRuleTemplate("REBATE_OFFER", 19);
            FOR_EVERY_X_AMT_SPENT_GET_Y_AMT_OFF_SUBTOTAL = new PromotionalRuleTemplate("FOR_EVERY_X_AMT_SPENT_GET_Y_AMT_OFF_SUBTOTAL", 20);
            FOR_EVERY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL = new PromotionalRuleTemplate("FOR_EVERY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL", 21);
            FOR_EVERY_N_ITEMS_GET_M_ITEMS_FREE = new PromotionalRuleTemplate("FOR_EVERY_N_ITEMS_GET_M_ITEMS_FREE", 22);
            FOR_EVERY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF = new PromotionalRuleTemplate("FOR_EVERY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF", 23);
            BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL = new PromotionalRuleTemplate("BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL", 24);
            BUY_1_ITEMS_GET_Y_PCT_OFF_SUBTOTAL = new PromotionalRuleTemplate("BUY_1_ITEMS_GET_Y_PCT_OFF_SUBTOTAL", 25);
            FOR_EVERY_BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL = new PromotionalRuleTemplate("FOR_EVERY_BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL", 26);
            AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT = new PromotionalRuleTemplate("AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT", 27);
            AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT_RANGE = new PromotionalRuleTemplate("AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT_RANGE", 28);
            MARK_DOWN_SALE = new PromotionalRuleTemplate("MARK_DOWN_SALE", 29);
            BUNDLE_EPID_WITH_DISCOUNTS = new PromotionalRuleTemplate("BUNDLE_EPID_WITH_DISCOUNTS", 30);
            BUNDLE_EPID_WITH_DISCOUNTS_PERCENT = new PromotionalRuleTemplate("BUNDLE_EPID_WITH_DISCOUNTS_PERCENT", 31);
            $VALUES = (new PromotionalRuleTemplate[] {
                SPEND_X_AMT_GET_Y_AMT_OFF_SUBTOTAL, SPEND_X_AMT_GET_Y_PCT_OFF_SUBTOTAL, BUY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL, BUY_N_ITEMS_GET_Y_PCT_OFF_SUBTOTAL, BUY_N_ITEMS_GET_M_ITEMS_FREE, BUY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF, BUNDLE_WITH_DISCOUNTS, BUNDLE_WITHOUT_DISCOUNTS, SALE_EVENT, SALE_AND_CLEARANCE, 
                PROMOTIONAL_SHIPPING, PROMO_FREE_SHIPPING_SPEND_X, PROMO_SHIPPING_COST_SPEND_X, PROMO_FREE_SHIPPING_SPEND_X_ON_ITEM_Y, PROMO_SHIPPING_COST_SPEND_X_ON_ITEMS_Y, PROMO_FREE_SHIPPING_ON_ITEM_X, PROMO_SHIPPING_COST_ON_ITEM_X, BUNDLE_WITHOUT_DISCOUNTS_NO_FREE_SHIPPING, VERTICAL_OFFER, REBATE_OFFER, 
                FOR_EVERY_X_AMT_SPENT_GET_Y_AMT_OFF_SUBTOTAL, FOR_EVERY_N_ITEMS_GET_Y_AMT_OFF_SUBTOTAL, FOR_EVERY_N_ITEMS_GET_M_ITEMS_FREE, FOR_EVERY_N_ITEMS_GET_M_ITEMS_AT_Y_PCT_OFF, BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL, BUY_1_ITEMS_GET_Y_PCT_OFF_SUBTOTAL, FOR_EVERY_BUY_1_ITEMS_GET_Y_AMT_OFF_SUBTOTAL, AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT, AUTO_SALE_CLEARANCE_WITH_DISCOUNT_PERCENT_RANGE, MARK_DOWN_SALE, 
                BUNDLE_EPID_WITH_DISCOUNTS, BUNDLE_EPID_WITH_DISCOUNTS_PERCENT
            });
        }

        private PromotionalRuleTemplate(String s, int i)
        {
            super(s, i);
        }
    }

    public static class SalesTax
    {

        public ItemCurrency amount;
        public boolean isShippingTaxed;
        public Double percent;
        public String state;

        public SalesTax()
        {
        }
    }

    public static class SaveForLaterNonAuctionItem extends NonAuctionItem
    {

        public User seller;

        public SaveForLaterNonAuctionItem()
        {
        }
    }

    public static class SavedForLater
    {

        public List items;
        public List messages;

        public SavedForLater()
        {
        }
    }

    public static class Seller extends User
    {

        public int feedbackScore;
        public boolean isOnVacation;
        public boolean isTopRatedSeller;
        public DateWithTimeZone vacationEndDate;

        public Seller()
        {
        }
    }

    public static final class SellerGroup
    {

        public List addressIds;
        public List itemGroups;
        public List messages;
        public Seller seller;
        public TotalSummary totalSummary;

        public SellerGroup()
        {
        }
    }

    public static class ShippingCostBreakdown
    {

        public ItemCurrency domesticLegCost;
        public ItemCurrency internationalLegCost;

        public ShippingCostBreakdown()
        {
        }
    }

    public static class ShippingService
    {

        public List attributes;
        public String carrier;
        public String category;
        public Date deliveryDateMax;
        public Date deliveryDateMin;
        public Integer deliveryDaysMax;
        public Integer deliveryDaysMin;
        public ItemCurrency handlingCost;
        public String id;
        public ItemCurrency importCharges;
        public boolean isApplicable;
        public String name;
        public ItemCurrencyWithConversion shippingCost;
        public ShippingCostBreakdown shippingCostBreakdown;
        public ItemCurrency shippingInsuranceCost;
        public String superscript;
        public String token;

        public ShippingService()
        {
        }
    }

    public static class TotalSummary
    {

        public ItemCurrency adjustmentsSubtotal;
        public ItemCurrency handlingSubtotal;
        public ItemCurrency importChargesSubtotal;
        public ItemCurrency incentiveTotal;
        public ItemCurrency insuranceSubtotal;
        public ItemCurrency otherFeesSubtotal;
        public ItemCurrency priceSubtotal;
        public ItemCurrency promotionSavingsTotal;
        public ItemCurrency savingsAmount;
        public ItemCurrency shippingSubtotal;
        public ShippingCostBreakdown shippingSubtotalBreakdown;
        public ItemCurrency taxSubtotal;
        public ItemCurrency total;

        public TotalSummary()
        {
        }
    }

    public static class User
    {

        public String username;

        public User()
        {
        }
    }

    public static class VariationDetails
    {

        public String variationId;
        public NameValueList variationSpecifics;

        public VariationDetails()
        {
        }
    }


    public User buyer;
    public boolean isGuestCart;
    public boolean isSynchronousCart;
    public boolean isUserInitiatedCart;
    public NonAuctions nonAuctionItems;
    public SavedForLater savedForLater;

    public EcasShoppingCart()
    {
    }

    public final Set getItemIds()
    {
        HashSet hashset;
        Iterator iterator;
        hashset = new HashSet();
        if (nonAuctionItems == null || nonAuctionItems.sellerGroups == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        iterator = nonAuctionItems.sellerGroups.iterator();
_L6:
        Iterator iterator2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        iterator2 = ((SellerGroup)iterator.next()).itemGroups.iterator();
_L2:
        Iterator iterator3;
        if (!iterator2.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator3 = ((ItemGroup)iterator2.next()).items.iterator();
_L4:
        Object obj;
        while (iterator3.hasNext()) 
        {
            obj = (NonAuctionItem)iterator3.next();
            if (((NonAuctionItem) (obj)).ebayItemId == null || ((NonAuctionItem) (obj)).isItemEnded)
            {
                continue; /* Loop/switch isn't completed */
            }
            hashset.add(((NonAuctionItem) (obj)).ebayItemId);
        }
        if (true) goto _L2; else goto _L1
_L1:
        continue; /* Loop/switch isn't completed */
        if (!(obj instanceof NonAuctionItem) || ((NonAuctionItem) (obj)).orderTransactions == null) goto _L4; else goto _L3
_L3:
        obj = ((NonAuctionItem) (obj)).orderTransactions.iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            hashset.add(((OrderTransaction)((Iterator) (obj)).next()).ebayItemId);
        }
          goto _L4
        if (savedForLater != null && savedForLater.items != null)
        {
            Iterator iterator1 = savedForLater.items.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                NonAuctionItem nonauctionitem = (NonAuctionItem)iterator1.next();
                if (nonauctionitem.ebayItemId != null)
                {
                    hashset.add(nonauctionitem.ebayItemId);
                }
            } while (true);
        }
        return hashset;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
