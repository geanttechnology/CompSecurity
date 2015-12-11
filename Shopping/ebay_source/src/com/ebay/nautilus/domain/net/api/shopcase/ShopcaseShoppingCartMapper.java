// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseErrorHandler

public final class ShopcaseShoppingCartMapper
{

    public static final Gson ATTRIBUTE_MAPPER = new Gson();
    private static final long ITEM_ENDING_WARNING_TIME = 0x5265c00L;
    private final ShopcaseErrorHandler errorHandler;
    private boolean hasItemsWithInStorePickup;
    private final ShopCart shopCart;

    public ShopcaseShoppingCartMapper(ShopCart shopcart, ShopcaseErrorHandler shopcaseerrorhandler)
    {
        shopCart = shopcart;
        errorHandler = shopcaseerrorhandler;
        hasItemsWithInStorePickup = false;
    }

    private static List flattenAttributeMap(List list)
    {
        ArrayList arraylist = new ArrayList();
        if (list != null && list.size() > 0)
        {
            list = ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.AttributeContainer)list.get(0)).attributes.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute attribute = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute)list.next();
                if (attribute != null && attribute.name != null)
                {
                    arraylist.add(attribute);
                }
            } while (true);
        }
        return arraylist;
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Address translateAddress(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Address address)
    {
        if (address == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Address.UNKNOWN;
        } else
        {
            return new com.ebay.nautilus.domain.data.ShoppingCart.Address(address.addressId, address.name, address.street1, address.street2, address.city, address.county, address.stateOrProvince, address.country, address.postalCode, address.phone);
        }
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Item translateCartItem(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItem cartlineitem, com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Seller seller, com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.BaseCartItem basecartitem)
    {
        if (basecartitem == null || basecartitem.itemDetails == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.UNKNOWN;
        }
        boolean flag3 = basecartitem instanceof com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.UnbuyableItem;
        boolean flag4 = cartlineitem instanceof com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaveForLaterItem;
        if (basecartitem instanceof com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem)
        {
            errorHandler.addNotifications(((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem)basecartitem).notifications);
        }
        Object obj3 = new ArrayList();
        if (!flag3 && cartlineitem.attributeContainers != null && cartlineitem.attributeContainers.size() > 0)
        {
            Object obj = null;
            Iterator iterator = cartlineitem.attributeContainers.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Map map = (Map)iterator.next();
                if (map.get("attribute") != null)
                {
                    obj = (List)map.get("attribute");
                }
            } while (true);
            if (obj != null)
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute attribute = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute)((Iterator) (obj)).next();
                    if (attribute != null && attribute.name != null)
                    {
                        ((List) (obj3)).add(attribute);
                    }
                } while (true);
            }
        }
        EbaySite ebaysite = null;
        Object obj2 = new com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.ItemLocationAttribute();
        com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType saletype = com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.UNKNOWN;
        long l1 = 0L;
        long l = 0L;
        long l6 = -1L;
        com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion itemcurrencywithconversion1 = com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion.ZERO;
        Object obj7 = com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion.ZERO;
        Object obj6 = Collections.emptyList();
        String s3 = null;
        Long long1 = null;
        HashMap hashmap = new HashMap();
        String s = null;
        Object obj5 = null;
        Object obj1 = null;
        Iterator iterator1 = ((List) (obj3)).iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute attribute1 = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute)iterator1.next();
            if (!TextUtils.isEmpty(attribute1.name))
            {
                EbaySite ebaysite1 = ebaysite;
                obj3 = obj5;
                if (TextUtils.equals(attribute1.name, "ListingSiteId"))
                {
                    obj3 = attribute1.value.replace('_', '-');
                    ebaysite1 = EbaySite.getInstanceFromId(((String) (obj3)));
                }
                Object obj4 = obj1;
                if (TextUtils.equals(attribute1.name, "EnergyEfficiencyRating"))
                {
                    obj4 = attribute1.value;
                }
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.ItemLocationAttribute itemlocationattribute = ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.ItemLocationAttribute) (obj2));
                if (TextUtils.equals(attribute1.name, "ItemLocation"))
                {
                    itemlocationattribute = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.ItemLocationAttribute)ATTRIBUTE_MAPPER.fromJson(attribute1.value, com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$ItemLocationAttribute);
                }
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType saletype1 = saletype;
                if (TextUtils.equals(attribute1.name, "SaleType"))
                {
                    saletype1 = com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.from(attribute1.value);
                }
                if (TextUtils.equals(attribute1.name, "StoreId") && !TextUtils.isEmpty(attribute1.value))
                {
                    hasItemsWithInStorePickup = true;
                }
                long l2 = l1;
                if (TextUtils.equals(attribute1.name, "Category1"))
                {
                    l2 = l1;
                    if (!TextUtils.isEmpty(attribute1.value))
                    {
                        obj1 = (Long[])ATTRIBUTE_MAPPER.fromJson(attribute1.value, [Ljava/lang/Long;);
                        l2 = l1;
                        if (obj1 != null)
                        {
                            l2 = l1;
                            if (obj1.length > 0)
                            {
                                l2 = obj1[obj1.length - 1].longValue();
                            }
                        }
                    }
                }
                long l4 = l;
                if (TextUtils.equals(attribute1.name, "Category2"))
                {
                    l4 = l;
                    if (!TextUtils.isEmpty(attribute1.value))
                    {
                        obj1 = (Long[])ATTRIBUTE_MAPPER.fromJson(attribute1.value, [Ljava/lang/Long;);
                        l4 = l;
                        if (obj1 != null)
                        {
                            l4 = l;
                            if (obj1.length > 0)
                            {
                                l4 = obj1[obj1.length - 1].longValue();
                            }
                        }
                    }
                }
                saletype = saletype1;
                ebaysite = ebaysite1;
                obj5 = obj3;
                obj1 = obj4;
                obj2 = itemlocationattribute;
                l1 = l2;
                l = l4;
                if (TextUtils.equals(attribute1.name, "TranslatedItemTitle"))
                {
                    s = attribute1.value;
                    saletype = saletype1;
                    ebaysite = ebaysite1;
                    obj5 = obj3;
                    obj1 = obj4;
                    obj2 = itemlocationattribute;
                    l1 = l2;
                    l = l4;
                }
            }
        } while (true);
        if (!TextUtils.isEmpty(((CharSequence) (obj5))) && !TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj3 = DeviceConfiguration.getAsync();
            if (ebaysite != null)
            {
                String s1 = EnergyEfficiencyRating.getItemSpecificsValueKey(ebaysite);
                if (s1 != null && ((DeviceConfiguration) (obj3)).get(DcsNautilusBoolean.payments_showEekRatings))
                {
                    hashmap.put(s1, obj1);
                }
            }
        }
        long l3 = l6;
        if (basecartitem.transactionDetails != null)
        {
            l3 = l6;
            if (basecartitem.transactionDetails.transactionId != null)
            {
                l3 = basecartitem.transactionDetails.transactionId.longValue();
            }
        }
        com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion itemcurrencywithconversion;
        String s2;
        HashSet hashset;
        com.ebay.nautilus.domain.data.ShoppingCart.Item.Status status;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag5;
        if (!flag3 && ShopcaseErrorHandler.hasErrorCode(((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem)basecartitem).notifications, 125))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag3 && ShopcaseErrorHandler.hasErrorCode(((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.UnbuyableItem)basecartitem).notifications, 106))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj1 = basecartitem.itemDetails.itemEndTime;
        flag5 = seller.sellerOnVacation;
        if (l3 > -1L)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        status = translateItemStatus(saletype, ((Date) (obj1)), flag5, flag2, basecartitem.itemDetails.ended, flag3, flag, basecartitem.itemDetails.availableQuantity.intValue(), flag1);
        obj3 = itemcurrencywithconversion1;
        if (basecartitem.itemDetails.price != null)
        {
            obj3 = translateItemCurrency(basecartitem.itemDetails.price.amount);
        }
        obj1 = null;
        if (cartlineitem instanceof com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaveForLaterItem)
        {
            obj1 = ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaveForLaterItem)cartlineitem).selectedLogisticPlanOption;
        } else
        if (basecartitem.selectedLogisticsPlanOption != null)
        {
            obj1 = basecartitem.selectedLogisticsPlanOption;
        }
        itemcurrencywithconversion = ((com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion) (obj7));
        if (obj1 != null)
        {
            itemcurrencywithconversion = ((com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion) (obj7));
            if (((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LogisticPlanOption) (obj1)).totalCostWithSavings != null)
            {
                itemcurrencywithconversion = translateItemCurrency(((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LogisticPlanOption) (obj1)).totalCostWithSavings.subTotal);
            }
        }
        obj1 = obj6;
        if (basecartitem.variationDetails != null)
        {
            obj1 = obj6;
            if (basecartitem.variationDetails.variationSpecifics != null)
            {
                obj1 = obj6;
                if (basecartitem.variationDetails.variationSpecifics.nameValueList != null)
                {
                    obj1 = basecartitem.variationDetails.variationSpecifics.nameValueList;
                }
            }
        }
        s2 = s3;
        if (cartlineitem != null)
        {
            s2 = s3;
            if (cartlineitem.orderDetails != null)
            {
                s2 = cartlineitem.orderDetails.orderId;
            }
        }
        if (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.FIXED_PRICE.equals(saletype) || com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.BID_AND_BIN.equals(saletype))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        hashset = long1;
        if (basecartitem.itemDetails.availablePaymentMethods != null)
        {
            hashset = new HashSet(basecartitem.itemDetails.availablePaymentMethods.size());
        }
        if (hashset != null)
        {
            for (obj5 = basecartitem.itemDetails.availablePaymentMethods.iterator(); ((Iterator) (obj5)).hasNext(); hashset.add(((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.PaymentMethod)((Iterator) (obj5)).next()).name)) { }
        }
        int i;
        int j;
        long l5;
        if (cartlineitem == null || flag3)
        {
            obj5 = ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.UnbuyableItem)basecartitem).itemReferenceId;
        } else
        {
            obj5 = cartlineitem.itemReferenceId;
        }
        obj5 = NumberUtil.safeParseLong(((String) (obj5)));
        if (obj5 != null)
        {
            l5 = ((Long) (obj5)).longValue();
        } else
        {
            l5 = 0x7fffffffffffffffL;
        }
        l6 = Integer.valueOf(seller.sellerFeedBackScore).longValue();
        if (cartlineitem != null)
        {
            obj5 = cartlineitem.addedTime;
        } else
        {
            obj5 = null;
        }
        if (cartlineitem != null)
        {
            cartlineitem = cartlineitem.lineItemType;
        } else
        {
            cartlineitem = null;
        }
        obj2 = ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.ItemLocationAttribute) (obj2)).location;
        long1 = basecartitem.itemDetails.itemId;
        s3 = basecartitem.variationId;
        obj6 = basecartitem.itemDetails.galleryUrl;
        obj7 = basecartitem.itemDetails.title;
        seller = seller.loginName;
        i = basecartitem.requestedQuantity.intValue();
        j = basecartitem.itemDetails.availableQuantity.intValue();
        flag5 = basecartitem.itemDetails.ended;
        if (l3 > -1L)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Item(ebaysite, ((String) (obj2)), long1, s3, Long.valueOf(l3), Long.valueOf(l5), ((String) (obj6)), ((String) (obj7)), seller, Long.valueOf(l6), status, Long.valueOf(l1), Long.valueOf(l), ((com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion) (obj3)), itemcurrencywithconversion, i, j, ((List) (obj1)), s2, flag5, flag2, false, false, flag1, false, basecartitem.itemDetails.itemEndTime, ((Date) (obj5)), flag3, flag, basecartitem.itemDetails.immediatePay.booleanValue(), translateListingType(saletype), null, flag4, hashset, hashmap, cartlineitem, s);
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion translateItemCurrency(com.ebay.nautilus.domain.data.BaseCommonType.Amount amount)
    {
        if (amount == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion.ZERO;
        }
        CurrencyAmount currencyamount;
        if (amount.convertedFromValue != null)
        {
            currencyamount = new CurrencyAmount(amount.convertedFromValue.doubleValue(), amount.convertedFromCurrency);
        } else
        {
            currencyamount = CurrencyAmount.ZERO;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion(new CurrencyAmount(amount.value, amount.currency), currencyamount);
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Item.Status translateItemStatus(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType saletype, Date date, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, 
            int i, boolean flag5)
    {
        long l1 = EbayResponse.currentHostTime();
        boolean flag6;
        boolean flag7;
        boolean flag8;
        long l;
        if (date != null)
        {
            l = date.getTime();
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        if (saletype == com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.BID_AND_BIN)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        if (saletype == com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.BID_ONLY)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (flag6 || flag7)
        {
            flag8 = true;
        } else
        {
            flag8 = false;
        }
        if (flag)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.SELLER_ON_VACATION;
        }
        if (flag1)
        {
            if (flag8)
            {
                return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.WON;
            } else
            {
                return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.PAY_NOW;
            }
        }
        if (flag3)
        {
            if (!flag6 && flag7 || flag5)
            {
                return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.UP_FOR_AUCTION;
            } else
            {
                return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.NOT_AVAILABLE;
            }
        }
        if (flag2)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.ENDED;
        }
        if (0x5265c00L + l1 >= l)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.ENDING_SOON;
        }
        if (i == 1 && !flag6)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.LAST_ONE;
        }
        if (flag4)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.HAS_REVISIONS;
        } else
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.UNKNOWN;
        }
    }

    private Collection translateLineItem(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItem cartlineitem, com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Seller seller)
    {
        if (cartlineitem != null && cartlineitem.items != null) goto _L2; else goto _L1
_L1:
        seller = Collections.emptyList();
_L4:
        return seller;
_L2:
        ArrayList arraylist = new ArrayList(cartlineitem.items.size());
        com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Seller seller1 = seller;
        if (seller == null)
        {
            seller1 = seller;
            if (cartlineitem instanceof com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaveForLaterItem)
            {
                seller1 = seller;
                if (!cartlineitem.items.isEmpty())
                {
                    com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem cartitem = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem)cartlineitem.items.get(0);
                    seller1 = seller;
                    if (cartitem != null)
                    {
                        seller1 = seller;
                        if (cartitem.itemDetails != null)
                        {
                            seller1 = new com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Seller();
                            seller1.loginName = ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem)cartlineitem.items.get(0)).itemDetails.sellerLoginName;
                            seller1.sellerOnVacation = false;
                            seller1.sellerFeedBackScore = 0;
                        }
                    }
                }
            }
        }
        Iterator iterator = cartlineitem.items.iterator();
        do
        {
            seller = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(translateCartItem(cartlineitem, seller1, (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartItem)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Orders translateLineItems(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItemSellerGroup cartlineitemsellergroup, String s)
    {
        if (cartlineitemsellergroup == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Orders.UNKNOWN;
        }
        TreeMap treemap = new TreeMap();
        treemap.put(com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN, new LinkedList());
        if (cartlineitemsellergroup.lineItems != null)
        {
            Object obj3 = new HashMap();
            HashMap hashmap = new HashMap();
            Iterator iterator1 = cartlineitemsellergroup.lineItems.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItem cartlineitem = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItem)iterator1.next();
                if (cartlineitem != null)
                {
                    String s1 = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN.offerCode;
                    Object obj2 = null;
                    com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Promotion promotion = obj2;
                    if (cartlineitem.itemPricingDetail != null)
                    {
                        promotion = obj2;
                        if (cartlineitem.itemPricingDetail.promotions != null)
                        {
                            promotion = obj2;
                            if (!cartlineitem.itemPricingDetail.promotions.isEmpty())
                            {
                                Iterator iterator2 = cartlineitem.itemPricingDetail.promotions.iterator();
                                do
                                {
                                    promotion = obj2;
                                    if (!iterator2.hasNext())
                                    {
                                        break;
                                    }
                                    promotion = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Promotion)iterator2.next();
                                } while (!com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType.from(promotion.promotionType).isSellerPromotion);
                            }
                        }
                    }
                    if (promotion != null)
                    {
                        s1 = promotion.promotionCode;
                        if (!hashmap.containsKey(s1))
                        {
                            hashmap.put(s1, new LinkedList());
                        }
                        ((List)hashmap.get(s1)).add(promotion);
                    }
                    if (!((Map) (obj3)).containsKey(s1))
                    {
                        ((Map) (obj3)).put(s1, new LinkedList());
                    }
                    ((List)((Map) (obj3)).get(s1)).addAll(translateLineItem(cartlineitem, cartlineitemsellergroup.seller));
                }
            } while (true);
            Object obj;
            for (Iterator iterator = ((Map) (obj3)).entrySet().iterator(); iterator.hasNext(); treemap.put(obj, ((java.util.Map.Entry) (obj3)).getValue()))
            {
                obj3 = (java.util.Map.Entry)iterator.next();
                List list = (List)hashmap.get(((java.util.Map.Entry) (obj3)).getKey());
                Object obj1 = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN;
                obj = obj1;
                if (list == null)
                {
                    continue;
                }
                obj = obj1;
                if (list.isEmpty())
                {
                    continue;
                }
                obj = CurrencyAmount.ZERO;
                obj1 = list.iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Promotion promotion1 = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Promotion)((Iterator) (obj1)).next();
                    if (promotion1.promotionSavingsAmount != null)
                    {
                        obj = ((CurrencyAmount) (obj)).add(promotion1.promotionSavingsAmount.getAmount());
                    }
                } while (true);
                obj = translatePromotion((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Promotion)list.get(0), s, ((CurrencyAmount) (obj)));
            }

        }
        if (cartlineitemsellergroup.unbuyableItems != null)
        {
            com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.UnbuyableItem unbuyableitem;
            for (s = cartlineitemsellergroup.unbuyableItems.iterator(); s.hasNext(); ((List)treemap.get(com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN)).add(translateCartItem(null, cartlineitemsellergroup.seller, unbuyableitem)))
            {
                unbuyableitem = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.UnbuyableItem)s.next();
            }

        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Orders(treemap);
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType translateListingType(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType saletype)
    {
        if (saletype == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.UNKNOWN;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$net$api$shopcase$models$ShopCart$SaleType[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$net$api$shopcase$models$ShopCart$SaleType = new int[com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$shopcase$models$ShopCart$SaleType[com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.BID_AND_BIN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$shopcase$models$ShopCart$SaleType[com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.BID_ONLY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$net$api$shopcase$models$ShopCart$SaleType[com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType.FIXED_PRICE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaleType[saletype.ordinal()])
        {
        default:
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.UNKNOWN;

        case 1: // '\001'
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_AND_BIN;

        case 2: // '\002'
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_ONLY;

        case 3: // '\003'
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BIN_ONLY;
        }
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Promotion translatePromotion(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Promotion promotion, String s, CurrencyAmount currencyamount)
    {
        if (promotion == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN;
        }
        List list = flattenAttributeMap(promotion.attributeContainers);
        com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType offertype1 = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.None;
        com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType promotiontype = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType.None;
        com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status status = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.NOT_APPLIED;
        String s1 = null;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute attribute = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Attribute)iterator.next();
            com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType offertype = offertype1;
            if (TextUtils.equals(attribute.name, "OfferType"))
            {
                offertype = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.from(attribute.value);
            }
            com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType promotiontype1 = promotiontype;
            if (!TextUtils.isEmpty(promotion.promotionType))
            {
                promotiontype1 = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType.from(promotion.promotionType);
            }
            com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status status1 = status;
            if (!TextUtils.isEmpty(promotion.promotionAppliedStatus))
            {
                status1 = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.from(promotion.promotionAppliedStatus);
            }
            offertype1 = offertype;
            promotiontype = promotiontype1;
            status = status1;
            if (TextUtils.equals(attribute.name, "SeedCategoryId"))
            {
                s1 = attribute.value;
                offertype1 = offertype;
                promotiontype = promotiontype1;
                status = status1;
            }
        } while (true);
        return new com.ebay.nautilus.domain.data.ShoppingCart.Promotion(promotion.promotionCode, offertype1, promotiontype, status, currencyamount, promotion.promotionMessage, s, s1);
    }

    private ShoppingCart translateShopCart(ShopCart shopcart)
    {
        if (shopcart == null)
        {
            return ShoppingCart.EMPTY;
        }
        errorHandler.addNotifications(shopcart.cartNotifications);
        TreeMap treemap = new TreeMap();
        if (shopcart.cartLineItemSellerGroups != null && !shopcart.cartLineItemSellerGroups.isEmpty())
        {
            Iterator iterator = shopcart.cartLineItemSellerGroups.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItemSellerGroup cartlineitemsellergroup = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartLineItemSellerGroup)iterator.next();
                if (cartlineitemsellergroup != null)
                {
                    com.ebay.nautilus.domain.data.ShoppingCart.Seller seller;
                    if (cartlineitemsellergroup.seller == null)
                    {
                        seller = com.ebay.nautilus.domain.data.ShoppingCart.Seller.UNKNOWN;
                    } else
                    {
                        seller = new com.ebay.nautilus.domain.data.ShoppingCart.Seller(cartlineitemsellergroup.seller.loginName, cartlineitemsellergroup.seller.sellerFeedBackScore, cartlineitemsellergroup.seller.sellerOnVacation, cartlineitemsellergroup.seller.sellerVacationEndDate);
                    }
                    treemap.put(seller, translateLineItems(cartlineitemsellergroup, seller.username));
                }
            } while (true);
        }
        LinkedList linkedlist = new LinkedList();
        if (shopcart.saveForLaterItems != null && !shopcart.saveForLaterItems.isEmpty())
        {
            for (Iterator iterator1 = shopcart.saveForLaterItems.iterator(); iterator1.hasNext(); linkedlist.addAll(translateLineItem((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.SaveForLaterItem)iterator1.next(), null))) { }
        }
        com.ebay.nautilus.domain.data.ShoppingCart.Summary summary = translateSummary(shopcart.costSummary, shopcart.cartCounts, hasItemsWithInStorePickup);
        com.ebay.nautilus.domain.data.ShoppingCart.Address address = translateAddress(shopcart.selectedShippingAddress);
        return new ShoppingCart(shopcart.shopCartId, treemap, linkedlist, summary, address);
    }

    private com.ebay.nautilus.domain.data.ShoppingCart.Summary translateSummary(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CostSummary costsummary, com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.CartCounts cartcounts, boolean flag)
    {
        if (costsummary == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Summary.UNKNOWN;
        }
        CurrencyAmount currencyamount;
        CurrencyAmount currencyamount1;
        CurrencyAmount currencyamount2;
        CurrencyAmount currencyamount3;
        CurrencyAmount currencyamount4;
        CurrencyAmount currencyamount5;
        if (costsummary.taxTotal != null && costsummary.taxTotal.getConvertedAmount() != null)
        {
            currencyamount = new CurrencyAmount(costsummary.taxTotal.getConvertedAmount());
        } else
        {
            currencyamount = CurrencyAmount.ZERO;
        }
        if (costsummary.itemTotal != null && costsummary.itemTotal.getConvertedAmount() != null)
        {
            currencyamount1 = new CurrencyAmount(costsummary.itemTotal.getConvertedAmount());
        } else
        {
            currencyamount1 = CurrencyAmount.ZERO;
        }
        if (costsummary.logisticCharges != null && costsummary.logisticCharges.getConvertedAmount() != null)
        {
            currencyamount2 = new CurrencyAmount(costsummary.logisticCharges.getConvertedAmount());
        } else
        {
            currencyamount2 = CurrencyAmount.ZERO;
        }
        if (costsummary.totalAdjustments != null && costsummary.totalAdjustments.getConvertedAmount() != null)
        {
            currencyamount3 = new CurrencyAmount(costsummary.totalAdjustments.getConvertedAmount());
        } else
        {
            currencyamount3 = CurrencyAmount.ZERO;
        }
        if (costsummary.totalAppliedPromotions != null && costsummary.totalAppliedPromotions.getConvertedAmount() != null)
        {
            currencyamount4 = new CurrencyAmount(costsummary.totalAppliedPromotions.getConvertedAmount());
        } else
        {
            currencyamount4 = CurrencyAmount.ZERO;
        }
        if (costsummary.totalAmount != null && costsummary.totalAmount.getConvertedAmount() != null)
        {
            currencyamount5 = new CurrencyAmount(costsummary.totalAmount.getConvertedAmount());
        } else
        {
            currencyamount5 = CurrencyAmount.ZERO;
        }
        if (costsummary.importCharges != null && costsummary.importCharges.getConvertedAmount() != null)
        {
            costsummary = new CurrencyAmount(costsummary.importCharges.getConvertedAmount());
        } else
        {
            costsummary = CurrencyAmount.ZERO;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Summary(currencyamount1, currencyamount2, costsummary, currencyamount4, currencyamount3, currencyamount, currencyamount5, cartcounts.unbuyableCount, shopCart.cartLineItemCount.intValue(), cartcounts.transactionCount, flag);
    }

    public Content toContentModel()
    {
        return new Content(translateShopCart(shopCart), errorHandler.getResultStatus());
    }

}
