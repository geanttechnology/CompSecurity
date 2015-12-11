// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import android.text.TextUtils;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.api.ecas.EcasErrorHandler;
import com.ebay.nautilus.kernel.util.NumberUtil;
import java.util.ArrayList;
import java.util.Arrays;
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

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCartResponse, EcasShoppingCart

public class EcasShoppingCartMapper
{

    private static final Collection INVALID_OFFER_TYPES;
    public static final long ITEM_ENDING_WARNING_TIME = 0x5265c00L;
    private final com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action;
    private final Map ebayItems;
    private final EcasShoppingCartResponse ecasCartResponse;
    private final EcasErrorHandler errorHandler;

    public EcasShoppingCartMapper(EcasShoppingCartResponse ecasshoppingcartresponse, Map map, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action1, String s)
    {
        ecasCartResponse = ecasshoppingcartresponse;
        if (map == null)
        {
            map = Collections.emptyMap();
        }
        ebayItems = map;
        errorHandler = new EcasErrorHandler(action1, s);
        action = action1;
    }

    private static EcasShoppingCart.Promotion getCurrentPromotionFor(EcasShoppingCart.NonAuctionItem nonauctionitem)
    {
label0:
        {
            if (nonauctionitem == null || nonauctionitem.promotions == null)
            {
                break label0;
            }
            nonauctionitem = nonauctionitem.promotions.iterator();
            EcasShoppingCart.Promotion promotion;
            do
            {
                if (!nonauctionitem.hasNext())
                {
                    break label0;
                }
                promotion = (EcasShoppingCart.Promotion)nonauctionitem.next();
            } while (promotion == null || promotion.type == null || !promotion.type.isSellerPromotion || !isOfferTypeVisible(promotion));
            return promotion;
        }
        return null;
    }

    private SortedMap initializePromotionsMap(EcasShoppingCart.SellerGroup sellergroup)
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        if (sellergroup != null)
        {
            for (Iterator iterator = sellergroup.itemGroups.iterator(); iterator.hasNext();)
            {
                Object obj1 = (EcasShoppingCart.ItemGroup)iterator.next();
                if (obj1 != null)
                {
                    obj1 = ((EcasShoppingCart.ItemGroup) (obj1)).items.iterator();
                    while (((Iterator) (obj1)).hasNext()) 
                    {
                        Object obj2 = (EcasShoppingCart.NonAuctionItem)((Iterator) (obj1)).next();
                        if (obj2 != null && ((EcasShoppingCart.NonAuctionItem) (obj2)).promotions != null)
                        {
                            obj2 = ((EcasShoppingCart.NonAuctionItem) (obj2)).promotions.iterator();
                            while (((Iterator) (obj2)).hasNext()) 
                            {
                                EcasShoppingCart.Promotion promotion = (EcasShoppingCart.Promotion)((Iterator) (obj2)).next();
                                if (promotion != null && isOfferTypeVisible(promotion))
                                {
                                    if (!hashmap.containsKey(promotion.code))
                                    {
                                        hashmap.put(promotion.code, promotion);
                                    }
                                    com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = promotion.promotionSavingsAmount;
                                    if (itemcurrency != null)
                                    {
                                        if (!hashmap1.containsKey(promotion.code))
                                        {
                                            hashmap1.put(promotion.code, new CurrencyAmount(itemcurrency));
                                        } else
                                        {
                                            hashmap1.put(promotion.code, ((CurrencyAmount)hashmap1.get(promotion.code)).add(itemcurrency));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        TreeMap treemap = new TreeMap();
        Iterator iterator1 = hashmap.entrySet().iterator();
        while (iterator1.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
            Object obj = (String)entry.getKey();
            if (hashmap1.containsKey(obj))
            {
                obj = (CurrencyAmount)hashmap1.get(obj);
            } else
            {
                obj = CurrencyAmount.ZERO;
            }
            treemap.put(translatePromotion((EcasShoppingCart.Promotion)entry.getValue(), sellergroup.seller, ((CurrencyAmount) (obj))), new LinkedList());
        }
        return treemap;
    }

    private static boolean isOfferTypeVisible(EcasShoppingCart.Promotion promotion)
    {
        if (promotion == null)
        {
            return false;
        }
        promotion = EcasShoppingCart.NamedAttribute.listToMap(promotion.attributes);
        boolean flag;
        if (promotion.containsKey("OfferType"))
        {
            promotion = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.from((String)promotion.get("OfferType"));
        } else
        {
            promotion = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.None;
        }
        if (!INVALID_OFFER_TYPES.contains(promotion))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private static final boolean isReallyEnded(EcasShoppingCart.NonAuctionItem nonauctionitem, EbayItem ebayitem)
    {
        if (nonauctionitem != null)
        {
            if (ebayitem != null)
            {
                if ((!nonauctionitem.isEnded() || ebayitem.isActive()) && (ebayitem.timeLeft == null || ebayitem.timeLeft.timeInSeconds != 0L))
                {
                    return false;
                }
            } else
            {
                return nonauctionitem.isEnded();
            }
        }
        return true;
    }

    public ShoppingCart toAppModel()
    {
        if (ecasCartResponse != null)
        {
            errorHandler.addMessage(ecasCartResponse.errorMessage);
            Object obj = ecasCartResponse.shoppingCart;
            if (obj != null && ((EcasShoppingCart) (obj)).nonAuctionItems != null)
            {
                Long long1 = NumberUtil.safeParseLong(((EcasShoppingCart) (obj)).nonAuctionItems.cartId);
                if (long1 != null)
                {
                    TreeMap treemap = new TreeMap();
                    if (((EcasShoppingCart) (obj)).nonAuctionItems.sellerGroups != null)
                    {
                        EcasShoppingCart.SellerGroup sellergroup;
                        for (Iterator iterator = ((EcasShoppingCart) (obj)).nonAuctionItems.sellerGroups.iterator(); iterator.hasNext(); treemap.put(translateSellerProfile(sellergroup.seller), translateSellerItems(sellergroup)))
                        {
                            sellergroup = (EcasShoppingCart.SellerGroup)iterator.next();
                        }

                    }
                    errorHandler.addMessages(((EcasShoppingCart) (obj)).nonAuctionItems.messages, null);
                    LinkedList linkedlist = new LinkedList();
                    if (((EcasShoppingCart) (obj)).savedForLater != null && ((EcasShoppingCart) (obj)).savedForLater.items != null)
                    {
                        for (Iterator iterator1 = ((EcasShoppingCart) (obj)).savedForLater.items.iterator(); iterator1.hasNext(); linkedlist.add(translateItem((EcasShoppingCart.NonAuctionItem)iterator1.next()))) { }
                        errorHandler.addMessages(((EcasShoppingCart) (obj)).savedForLater.messages, null);
                        Collections.sort(linkedlist, new com.ebay.nautilus.domain.data.ShoppingCart.ItemComparator());
                    }
                    com.ebay.nautilus.domain.data.ShoppingCart.Address address = translateAddress(((EcasShoppingCart) (obj)).nonAuctionItems.shippingAddress);
                    obj = translateTotalsSummary(((EcasShoppingCart) (obj)).nonAuctionItems);
                    return new ShoppingCart(long1.longValue(), treemap, linkedlist, ((com.ebay.nautilus.domain.data.ShoppingCart.Summary) (obj)), address);
                }
            }
        }
        return null;
    }

    public Content toContentModel()
    {
        return new Content(toAppModel(), errorHandler.getResultStatus());
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Address translateAddress(EcasShoppingCart.Address address)
    {
        if (address == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Address.UNKNOWN;
        } else
        {
            return new com.ebay.nautilus.domain.data.ShoppingCart.Address(address.addressId, address.name, address.street1, address.street2, address.city, address.county, address.stateOrProvince, address.country, address.postalCode, address.phone);
        }
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Item translateItem(EcasShoppingCart.NonAuctionItem nonauctionitem)
    {
        return translateItem(nonauctionitem, null);
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Item translateItem(EcasShoppingCart.NonAuctionItem nonauctionitem, EcasShoppingCart.Seller seller)
    {
        return translateItem(nonauctionitem, seller, null, 0);
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Item translateItem(EcasShoppingCart.NonAuctionItem nonauctionitem, EcasShoppingCart.Seller seller, EcasShoppingCart.OrderTransaction ordertransaction, int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Long long1;
        int j;
        int i1;
        int j1;
        boolean flag;
        boolean flag5;
        if (nonauctionitem == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.UNKNOWN;
        }
        HashSet hashset;
        long l1;
        boolean flag1;
        boolean flag2;
        boolean flag4;
        boolean flag9;
        boolean flag11;
        if (nonauctionitem.ebayItemId != null)
        {
            l1 = nonauctionitem.ebayItemId.longValue();
        } else
        {
            l1 = -1L;
        }
        obj4 = Long.valueOf(l1);
        obj7 = nonauctionitem.itemTitle;
        i1 = nonauctionitem.quantityRequested;
        j1 = nonauctionitem.quantityAvailable;
        if (nonauctionitem.variationDetails != null && nonauctionitem.variationDetails.variationId != null)
        {
            obj = nonauctionitem.variationDetails.variationId;
        } else
        {
            obj = "";
        }
        if (nonauctionitem.transactionId != null)
        {
            l1 = Long.parseLong(nonauctionitem.transactionId);
        } else
        {
            l1 = -1L;
        }
        obj5 = Long.valueOf(l1);
        long1 = nonauctionitem.lineItemId;
        if (seller != null)
        {
            flag2 = seller.isOnVacation;
        } else
        {
            flag2 = false;
        }
        if (seller != null)
        {
            obj2 = seller.username;
        } else
        {
            obj2 = "";
        }
        if (seller != null)
        {
            l1 = seller.feedbackScore;
        } else
        {
            l1 = 0L;
        }
        obj15 = nonauctionitem.galleryUrl;
        flag5 = nonauctionitem.isItemEnded;
        if (!TextUtils.isEmpty(nonauctionitem.transactionId))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag11 = EcasErrorHandler.hasAnyMessageCode(nonauctionitem.messages, new Integer[] {
            Integer.valueOf(125)
        });
        if (nonauctionitem.isUnbuyable || EcasErrorHandler.hasAnyMessageCode(nonauctionitem.messages, new Integer[] {
    Integer.valueOf(128), Integer.valueOf(103)
}))
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        flag9 = nonauctionitem.isImmediatePay;
        hashset = new HashSet();
        if (nonauctionitem.availablePaymentMethods != null)
        {
            for (Iterator iterator = nonauctionitem.availablePaymentMethods.iterator(); iterator.hasNext(); hashset.add(((EcasShoppingCart.PaymentMethod)iterator.next()).name)) { }
        }
        String s;
        List list;
        com.ebay.nautilus.domain.data.ShoppingCart.Item.Status status;
        Object obj16;
        Object obj17;
        com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType listingtype;
        List list1;
        com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion itemcurrencywithconversion;
        Map map;
        int k;
        long l2;
        long l3;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag10;
        if (nonauctionitem.variationDetails != null && nonauctionitem.variationDetails.variationSpecifics != null)
        {
            list = nonauctionitem.variationDetails.variationSpecifics.asList();
        } else
        {
            list = Collections.emptyList();
        }
        map = nonauctionitem.getItemSpecifics();
        obj3 = null;
        obj1 = EcasShoppingCart.NamedAttribute.getAttribute(nonauctionitem.attributes, "TranslatedItemTitle");
        if (obj1 != null)
        {
            obj3 = ((EcasShoppingCart.NamedAttribute) (obj1)).value;
        }
        flag10 = false;
        flag6 = false;
        flag7 = true;
        flag8 = false;
        status = com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.NOT_AVAILABLE;
        listingtype = com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.UNKNOWN;
        obj17 = null;
        obj16 = null;
        l2 = 0L;
        l3 = 0L;
        obj1 = null;
        if (nonauctionitem.selectedShippingService != null)
        {
            obj1 = translateItemCurrency(nonauctionitem.selectedShippingService.shippingCost);
        }
        obj6 = translateItemCurrency(nonauctionitem.price);
        s = ((String) (obj2));
        if (nonauctionitem instanceof EcasShoppingCart.SaveForLaterNonAuctionItem)
        {
            EcasShoppingCart.SaveForLaterNonAuctionItem saveforlaternonauctionitem = (EcasShoppingCart.SaveForLaterNonAuctionItem)nonauctionitem;
            s = ((String) (obj2));
            if (saveforlaternonauctionitem.seller != null)
            {
                s = saveforlaternonauctionitem.seller.username;
            }
        }
        if (ordertransaction == null) goto _L2; else goto _L1
_L1:
        list1 = Collections.emptyList();
        if (ordertransaction.ebayItemId != null)
        {
            obj4 = Long.valueOf(ordertransaction.ebayItemId.longValue());
        }
        itemcurrencywithconversion = translateItemCurrency(ordertransaction.price);
        if (i > 0)
        {
            obj1 = null;
        }
        obj2 = NumberUtil.safeParseLong(ordertransaction.transactionId);
        if (obj2 != null)
        {
            obj5 = obj2;
        }
        obj6 = obj;
        if (ordertransaction.variationDetails != null)
        {
            obj6 = obj;
            if (ordertransaction.variationDetails.variationId != null)
            {
                obj6 = ordertransaction.variationDetails.variationId;
            }
        }
        obj = obj7;
        if (ordertransaction.itemTitle != null)
        {
            obj = ordertransaction.itemTitle;
        }
        k = ordertransaction.quantityRequested;
        i1 = ordertransaction.quantityAvailable;
        obj2 = EcasShoppingCart.NamedAttribute.getAttribute(ordertransaction.imageUrls, "Thumbnail96");
        obj7 = obj15;
        if (obj2 != null)
        {
            obj7 = ((EcasShoppingCart.NamedAttribute) (obj2)).value;
        }
        flag5 = ordertransaction.isItemEnded;
        obj15 = EcasShoppingCart.NamedAttribute.getAttribute(ordertransaction.attributes, "TranslatedItemTitle");
        flag = flag5;
        i = i1;
        obj8 = obj4;
        obj9 = obj6;
        obj10 = obj5;
        ordertransaction = ((EcasShoppingCart.OrderTransaction) (obj7));
        obj11 = obj;
        obj12 = itemcurrencywithconversion;
        obj13 = obj1;
        j = k;
        obj2 = list1;
        obj14 = obj3;
        if (obj15 != null)
        {
            obj14 = ((EcasShoppingCart.NamedAttribute) (obj15)).value;
            obj2 = list1;
            j = k;
            obj13 = obj1;
            obj12 = itemcurrencywithconversion;
            obj11 = obj;
            ordertransaction = ((EcasShoppingCart.OrderTransaction) (obj7));
            obj10 = obj5;
            obj9 = obj6;
            obj8 = obj4;
            i = i1;
            flag = flag5;
        }
_L4:
        boolean flag3;
        if (!TextUtils.isEmpty(((CharSequence) (obj9))))
        {
            obj = TextUtils.concat(new CharSequence[] {
                Long.toString(((Long) (obj8)).longValue()), "-", obj9
            }).toString();
        } else
        {
            obj = Long.toString(long1.longValue());
        }
        if (com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action.ADD_TO_CART.equals(action))
        {
            errorHandler.addMessages(nonauctionitem.messages, ((String) (obj)));
        }
        obj3 = listingtype;
        obj4 = obj17;
        obj5 = obj16;
        obj = ordertransaction;
        obj1 = status;
        flag5 = flag10;
        if (ebayItems.containsKey(obj8))
        {
            obj1 = (EbayItem)ebayItems.get(obj8);
            flag = isReallyEnded(nonauctionitem, ((EbayItem) (obj1)));
            obj = ordertransaction;
            if (ordertransaction == null)
            {
                obj = ordertransaction;
                if (((EbayItem) (obj1)).pictureUrls != null)
                {
                    obj = ordertransaction;
                    if (((EbayItem) (obj1)).pictureUrls.size() > 0)
                    {
                        obj = (String)((EbayItem) (obj1)).pictureUrls.get(0);
                    }
                }
            }
            ArrayList arraylist;
            int l;
            if (((EbayItem) (obj1)).isBidWithBinAvailable())
            {
                if (((EbayItem) (obj1)).bidCount > 0)
                {
                    ordertransaction = com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_ONLY;
                } else
                {
                    ordertransaction = com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_AND_BIN;
                }
            } else
            if (((EbayItem) (obj1)).isListingTypeBid())
            {
                ordertransaction = com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_ONLY;
            } else
            {
                ordertransaction = com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BIN_ONLY;
            }
            flag9 = ((EbayItem) (obj1)).autoPay;
            s = ((EbayItem) (obj1)).sellerUserId;
            l1 = ((EbayItem) (obj1)).sellerFeedbackScore;
            obj4 = EbaySite.getInstanceFromId(((EbayItem) (obj1)).site);
            obj5 = ((EbayItem) (obj1)).location;
            l2 = ((EbayItem) (obj1)).primaryCategoryId;
            l3 = ((EbayItem) (obj1)).secondaryCategoryId;
            flag5 = ((EbayItem) (obj1)).reserveMet;
            flag6 = ((EbayItem) (obj1)).hasReservePrice;
            flag7 = ((EbayItem) (obj1)).buyItNowAvailable;
            flag8 = ((EbayItem) (obj1)).ebayPaymentProcessEnabled;
            obj1 = translateItemStatus(ordertransaction, nonauctionitem.endedAt, flag2, flag1, flag, flag4, flag11, i);
            obj3 = ordertransaction;
        }
        ordertransaction = nonauctionitem.orderId;
        obj6 = nonauctionitem.endedAt;
        nonauctionitem = nonauctionitem.addedAt;
        if (seller == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Item(((EbaySite) (obj4)), ((String) (obj5)), ((Long) (obj8)), ((String) (obj9)), ((Long) (obj10)), long1, ((String) (obj)), ((String) (obj11)), s, Long.valueOf(l1), ((com.ebay.nautilus.domain.data.ShoppingCart.Item.Status) (obj1)), Long.valueOf(l2), Long.valueOf(l3), ((com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion) (obj12)), ((com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion) (obj13)), j, i, list, ordertransaction, flag, flag1, flag5, flag6, flag7, flag8, ((Date) (obj6)), nonauctionitem, flag4, flag11, flag9, ((com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType) (obj3)), ((List) (obj2)), flag3, hashset, map, com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.LineItemTypes.UNKNOWN_LINE_ITEM_TYPE, ((String) (obj14)));
_L2:
        if (nonauctionitem.orderTransactions == null)
        {
            break MISSING_BLOCK_LABEL_1341;
        }
        arraylist = new ArrayList(nonauctionitem.orderTransactions.size());
        l = 0;
_L5:
        flag = flag5;
        i = j1;
        obj8 = obj4;
        obj9 = obj;
        obj10 = obj5;
        ordertransaction = ((EcasShoppingCart.OrderTransaction) (obj15));
        obj11 = obj7;
        obj12 = obj6;
        obj13 = obj1;
        j = i1;
        obj2 = arraylist;
        obj14 = obj3;
        if (l >= nonauctionitem.orderTransactions.size()) goto _L4; else goto _L3
_L3:
        arraylist.add(translateItem(nonauctionitem, seller, (EcasShoppingCart.OrderTransaction)nonauctionitem.orderTransactions.get(l), l));
        l++;
          goto _L5
        obj2 = Collections.emptyList();
        flag = flag5;
        i = j1;
        obj8 = obj4;
        obj9 = obj;
        obj10 = obj5;
        ordertransaction = ((EcasShoppingCart.OrderTransaction) (obj15));
        obj11 = obj7;
        obj12 = obj6;
        obj13 = obj1;
        j = i1;
        obj14 = obj3;
          goto _L4
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion translateItemCurrency(EcasShoppingCart.ItemCurrencyWithConversion itemcurrencywithconversion)
    {
        if (itemcurrencywithconversion == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion.ZERO;
        }
        CurrencyAmount currencyamount;
        if (!TextUtils.isEmpty(itemcurrencywithconversion.value))
        {
            currencyamount = new CurrencyAmount(itemcurrencywithconversion.value, itemcurrencywithconversion.code);
        } else
        {
            currencyamount = CurrencyAmount.ZERO;
        }
        if (!TextUtils.isEmpty(itemcurrencywithconversion.basisAmount))
        {
            itemcurrencywithconversion = new CurrencyAmount(itemcurrencywithconversion.basisAmount, itemcurrencywithconversion.basisCurrencyId);
        } else
        {
            itemcurrencywithconversion = CurrencyAmount.ZERO;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.ItemCurrencyWithConversion(currencyamount, itemcurrencywithconversion);
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Item.Status translateItemStatus(com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType listingtype, Date date, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, 
            int i)
    {
        long l1 = EbayResponse.currentHostTime();
        boolean flag5;
        boolean flag6;
        boolean flag7;
        long l;
        if (date != null)
        {
            l = date.getTime();
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        if (listingtype == com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_AND_BIN)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (listingtype == com.ebay.nautilus.domain.data.ShoppingCart.Item.ListingType.BID_ONLY)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        if (flag5 || flag6)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (flag)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.SELLER_ON_VACATION;
        }
        if (flag1)
        {
            if (flag7)
            {
                return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.WON;
            } else
            {
                return com.ebay.nautilus.domain.data.ShoppingCart.Item.Status.PAY_NOW;
            }
        }
        if (flag3)
        {
            if (!flag5 && flag6)
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
        if (i == 1 && !flag5)
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

    protected com.ebay.nautilus.domain.data.ShoppingCart.Promotion translatePromotion(EcasShoppingCart.Promotion promotion, EcasShoppingCart.Seller seller, CurrencyAmount currencyamount)
    {
        String s1 = null;
        if (promotion == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN;
        }
        Object obj = EcasShoppingCart.NamedAttribute.listToMap(promotion.attributes);
        String s;
        com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status status;
        if (((Map) (obj)).containsKey("SeedCategoryId"))
        {
            s = (String)((Map) (obj)).get("SeedCategoryId");
        } else
        {
            s = null;
        }
        if (seller != null)
        {
            s1 = seller.username;
        }
        if (((Map) (obj)).containsKey("OfferType"))
        {
            seller = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.from((String)((Map) (obj)).get("OfferType"));
        } else
        {
            seller = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.None;
        }
        if (promotion.type != null)
        {
            obj = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType.from(promotion.type.token);
        } else
        {
            obj = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType.None;
        }
        if (promotion.status != null)
        {
            status = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.from(promotion.status);
        } else
        {
            status = com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.NOT_APPLIED;
        }
        if (currencyamount == null)
        {
            currencyamount = CurrencyAmount.ZERO;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Promotion(promotion.code, seller, ((com.ebay.nautilus.domain.data.ShoppingCart.Promotion.PromotionType) (obj)), status, currencyamount, promotion.message, s1, s);
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Orders translateSellerItems(EcasShoppingCart.SellerGroup sellergroup)
    {
        SortedMap sortedmap = initializePromotionsMap(sellergroup);
        if (sellergroup != null)
        {
            Iterator iterator = sellergroup.itemGroups.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (EcasShoppingCart.ItemGroup)iterator.next();
                if (obj != null)
                {
                    obj = ((EcasShoppingCart.ItemGroup) (obj)).items.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        Object obj1 = (EcasShoppingCart.NonAuctionItem)((Iterator) (obj)).next();
                        com.ebay.nautilus.domain.data.ShoppingCart.Promotion promotion = translatePromotion(getCurrentPromotionFor(((EcasShoppingCart.NonAuctionItem) (obj1))), sellergroup.seller, CurrencyAmount.ZERO);
                        obj1 = translateItem(((EcasShoppingCart.NonAuctionItem) (obj1)), sellergroup.seller);
                        if (sortedmap.containsKey(promotion))
                        {
                            ((List)sortedmap.get(promotion)).add(obj1);
                        } else
                        {
                            LinkedList linkedlist = new LinkedList();
                            linkedlist.add(obj1);
                            sortedmap.put(promotion, linkedlist);
                        }
                    }
                }
            } while (true);
            errorHandler.addMessages(sellergroup.messages, null);
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Orders(sortedmap);
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Seller translateSellerProfile(EcasShoppingCart.Seller seller)
    {
        if (seller == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Seller.UNKNOWN;
        } else
        {
            return new com.ebay.nautilus.domain.data.ShoppingCart.Seller(seller.username, seller.feedbackScore, seller.isOnVacation, seller.vacationEndDate);
        }
    }

    protected com.ebay.nautilus.domain.data.ShoppingCart.Summary translateTotalsSummary(EcasShoppingCart.NonAuctions nonauctions)
    {
        if (nonauctions == null)
        {
            return com.ebay.nautilus.domain.data.ShoppingCart.Summary.UNKNOWN;
        }
        boolean flag = nonauctions.hasBopisSelectedItem();
        CurrencyAmount currencyamount1 = CurrencyAmount.ZERO;
        CurrencyAmount currencyamount2 = CurrencyAmount.ZERO;
        CurrencyAmount currencyamount3 = CurrencyAmount.ZERO;
        CurrencyAmount currencyamount5 = CurrencyAmount.ZERO;
        CurrencyAmount currencyamount4 = CurrencyAmount.ZERO;
        Object obj = CurrencyAmount.ZERO;
        CurrencyAmount currencyamount = CurrencyAmount.ZERO;
        if (nonauctions.totalSummary != null)
        {
            obj = nonauctions.totalSummary;
            int i;
            int j;
            int k;
            if (((EcasShoppingCart.TotalSummary) (obj)).adjustmentsSubtotal != null)
            {
                currencyamount = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).adjustmentsSubtotal);
            } else
            {
                currencyamount = CurrencyAmount.ZERO;
            }
            if (((EcasShoppingCart.TotalSummary) (obj)).priceSubtotal != null)
            {
                currencyamount1 = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).priceSubtotal);
            } else
            {
                currencyamount1 = CurrencyAmount.ZERO;
            }
            if (((EcasShoppingCart.TotalSummary) (obj)).shippingSubtotal != null)
            {
                currencyamount2 = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).shippingSubtotal);
            } else
            {
                currencyamount2 = CurrencyAmount.ZERO;
            }
            if (((EcasShoppingCart.TotalSummary) (obj)).importChargesSubtotal != null)
            {
                currencyamount3 = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).importChargesSubtotal);
            } else
            {
                currencyamount3 = CurrencyAmount.ZERO;
            }
            if (((EcasShoppingCart.TotalSummary) (obj)).promotionSavingsTotal != null)
            {
                currencyamount4 = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).promotionSavingsTotal);
            } else
            {
                currencyamount4 = CurrencyAmount.ZERO;
            }
            if (((EcasShoppingCart.TotalSummary) (obj)).taxSubtotal != null)
            {
                currencyamount5 = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).taxSubtotal);
            } else
            {
                currencyamount5 = CurrencyAmount.ZERO;
            }
            if (((EcasShoppingCart.TotalSummary) (obj)).total != null)
            {
                obj = new CurrencyAmount(((EcasShoppingCart.TotalSummary) (obj)).total);
            } else
            {
                obj = CurrencyAmount.ZERO;
            }
        }
        i = 0;
        j = 0;
        k = nonauctions.getBuyableCount();
        if (nonauctions.counts != null)
        {
            nonauctions = nonauctions.counts;
            i = ((EcasShoppingCart.CartCounts) (nonauctions)).unbuyableCount;
            j = ((EcasShoppingCart.CartCounts) (nonauctions)).transactionCount;
        }
        return new com.ebay.nautilus.domain.data.ShoppingCart.Summary(currencyamount1, currencyamount2, currencyamount3, currencyamount4, currencyamount, currencyamount5, ((CurrencyAmount) (obj)), i, k, j, flag);
    }

    static 
    {
        INVALID_OFFER_TYPES = Arrays.asList(new com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType[] {
            com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.SaleAndClearence, com.ebay.nautilus.domain.data.ShoppingCart.Promotion.OfferType.SaleEvent
        });
    }
}
