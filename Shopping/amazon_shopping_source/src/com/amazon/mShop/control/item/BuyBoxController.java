// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.ui.resources.BadgeType;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.OfferListing;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickShippingOffers;
import com.amazon.rio.j2me.client.services.mShop.ShippingOffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController, BuyButtonController, BuyButtonType

public class BuyBoxController
{

    private final boolean isAddToCartOnly = false;
    private final boolean isAddToWishListEnabled = true;
    private final OfferListing offerListing;
    private final ProductController productController;

    public BuyBoxController(ProductController productcontroller, OfferListing offerlisting)
    {
        productController = productcontroller;
        offerListing = offerlisting;
    }

    private ShippingOffer[] getPrimeShippingOffers()
    {
        Object obj = getPrimeOneClickShippingOffers();
        if (obj != null)
        {
            if ((obj = ((PrimeOneClickShippingOffers) (obj)).getShippingOffers()) != null && ((List) (obj)).size() != 0)
            {
                return (ShippingOffer[])((List) (obj)).toArray(new ShippingOffer[((List) (obj)).size()]);
            }
        }
        return null;
    }

    private boolean isAddToWishListEnabled()
    {
        if (isAddToWishListEnabled && !isAddToCartOnly && getAsin() != null && productController != null)
        {
            BasicProductInfo basicproductinfo = productController.getBasicProduct();
            if (basicproductinfo != null)
            {
                if (basicproductinfo.getAvailabilityCondition() == 3)
                {
                    return true;
                }
                if (!productController.mustSelectVariationChild())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public BuyButtonController[] getAddButtons()
    {
        ArrayList arraylist = new ArrayList();
        String s = getOfferId();
        String s1 = getDealId();
        if (isBuyable())
        {
            arraylist.add(new BuyButtonController(BuyButtonType.ADD_TO_CART, productController, s, s1));
        }
        if (isAddToWishListEnabled())
        {
            arraylist.add(new BuyButtonController(BuyButtonType.ADD_TO_WISH_LIST, productController));
        }
        return (BuyButtonController[])arraylist.toArray(new BuyButtonController[arraylist.size()]);
    }

    public String getAsin()
    {
        return productController.getAsin();
    }

    public BasicOfferListing getBasicOfferListing()
    {
        if (offerListing != null)
        {
            return offerListing.getBasicOffer();
        } else
        {
            return productController.getBasicOffer();
        }
    }

    public BuyButtonController[] getBuyButtons()
    {
        ArrayList arraylist;
        String s;
        String s1;
        arraylist = new ArrayList();
        s = getOfferId();
        s1 = getDealId();
        if (!isBuyable()) goto _L2; else goto _L1
_L1:
        populateBuyButtons(s, s1, arraylist);
_L4:
        return (BuyButtonController[])arraylist.toArray(new BuyButtonController[arraylist.size()]);
_L2:
        if (productController.isAvailableFromThirdPartiesOnly())
        {
            arraylist.add(new BuyButtonController(BuyButtonType.SEE_MORE_BUYING_OPTIONS, productController));
        } else
        if (productController.shouldBuyFromFriendApp())
        {
            arraylist.add(new BuyButtonController(BuyButtonType.FRIEND_APP_BUTTON, productController));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getDealId()
    {
        if (offerListing != null)
        {
            return null;
        } else
        {
            return productController.getDealId();
        }
    }

    public String getOfferId()
    {
        BasicOfferListing basicofferlisting = getBasicOfferListing();
        if (basicofferlisting != null)
        {
            return basicofferlisting.getOfferId();
        } else
        {
            return null;
        }
    }

    public PrimeOneClickShippingOffers getPrimeOneClickShippingOffers()
    {
        if (offerListing != null)
        {
            return offerListing.getPrimeOneClickShippingOffers();
        } else
        {
            return productController.getPrimeOneClickShippingOffers();
        }
    }

    public String getPrimeOneClickShippingOffersNote()
    {
        PrimeOneClickShippingOffers primeoneclickshippingoffers = getPrimeOneClickShippingOffers();
        if (primeoneclickshippingoffers != null)
        {
            return primeoneclickshippingoffers.getNote();
        } else
        {
            return null;
        }
    }

    public Integer getPrimeShippingOffersRemainingMinutes()
    {
        Object obj = getPrimeOneClickShippingOffers();
        if (obj != null)
        {
            obj = ((PrimeOneClickShippingOffers) (obj)).getShippingOffers();
            int i = 0x7fffffff;
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ShippingOffer shippingoffer = (ShippingOffer)((Iterator) (obj)).next();
                if (shippingoffer.getRemainingMinutes() != null)
                {
                    i = Math.min(i, shippingoffer.getRemainingMinutes().intValue());
                }
            } while (true);
            if (i != 0x7fffffff)
            {
                return new Integer(i);
            }
        }
        return null;
    }

    public ProductController getProductController()
    {
        return productController;
    }

    public boolean isBuyable()
    {
        boolean flag1 = true;
        if (offerListing != null || !productController.isAvailableFromThirdPartiesOnly()) goto _L2; else goto _L1
_L1:
        BasicOfferListing basicofferlisting;
        return false;
_L2:
        BasicProductInfo basicproductinfo;
        if ((basicofferlisting = getBasicOfferListing()) == null || ((basicproductinfo = productController.getBasicProduct()) == null || Util.isEmpty(getAsin()) || Util.isEmpty(getOfferId()) || !isAddToCartOnly && productController.mustSelectVariationChild())) goto _L1; else goto _L3
_L3:
        int i;
        int j;
        i = basicproductinfo.getAvailabilityCondition();
        j = basicofferlisting.getAvailabilityCondition();
        if (i != 0) goto _L5; else goto _L4
_L4:
        boolean flag = flag1;
        if (j == 0) goto _L7; else goto _L6
_L6:
        if (j != 1) goto _L5; else goto _L8
_L8:
        flag = flag1;
_L7:
        return flag;
_L5:
        flag = false;
        if (true) goto _L7; else goto _L9
_L9:
    }

    public boolean isPreOrder()
    {
        boolean flag = true;
        BasicOfferListing basicofferlisting = getBasicOfferListing();
        if (basicofferlisting == null)
        {
            return false;
        }
        if (basicofferlisting.getAvailabilityCondition() != 1)
        {
            flag = false;
        }
        return flag;
    }

    public boolean isWaitingForPrime1ClickShippingOffers()
    {
        if (!isAddToCartOnly && offerListing == null && !productController.getPrimeOneClickShippingOffersReceived())
        {
            User user = User.getUser();
            boolean flag;
            if (user != null && user.isOneClick() && user.isPrime())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Object obj = getBasicOfferListing();
                if (obj != null)
                {
                    obj = ((BasicOfferListing) (obj)).getBadgeInfo();
                    if (obj != null && ((BadgeInfo) (obj)).getBadge() != null && (BadgeType.PRIME.name().equals(((BadgeInfo) (obj)).getBadge().getType()) || BadgeType.PRIME_PLUS.name().equals(((BadgeInfo) (obj)).getBadge().getType())))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected void populateBuyButtons(String s, String s1, List list)
    {
        if (s1 == null && !isAddToCartOnly)
        {
            boolean flag1 = isPreOrder();
            ShippingOffer ashippingoffer[] = getPrimeShippingOffers();
            if (ashippingoffer != null && ashippingoffer.length != 0)
            {
                BuyButtonType buybuttontype;
                if (flag1)
                {
                    buybuttontype = BuyButtonType.PRE_ORDER_1_CLICK_PRIME;
                } else
                {
                    buybuttontype = BuyButtonType.BUY_NOW_1_CLICK_PRIME;
                }
                populatePrimeShippingOptions(s, s1, buybuttontype, ashippingoffer, list);
                return;
            }
            if (!isWaitingForPrime1ClickShippingOffers())
            {
                Object obj = User.getUser();
                boolean flag;
                if (obj != null && ((User) (obj)).isOneClick())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    if (flag1)
                    {
                        obj = BuyButtonType.PRE_ORDER_1_CLICK;
                    } else
                    {
                        obj = BuyButtonType.BUY_NOW_1_CLICK;
                    }
                    list.add(new BuyButtonController(((BuyButtonType) (obj)), productController, s, s1, "default"));
                    return;
                }
                if (flag1)
                {
                    obj = BuyButtonType.PRE_ORDER_NOW;
                } else
                {
                    obj = BuyButtonType.BUY_NOW;
                }
                list.add(new BuyButtonController(((BuyButtonType) (obj)), productController, s, s1));
                return;
            }
        }
    }

    protected void populatePrimeShippingOptions(String s, String s1, BuyButtonType buybuttontype, ShippingOffer ashippingoffer[], List list)
    {
        int j = ashippingoffer.length;
        for (int i = 0; i < j; i++)
        {
            ShippingOffer shippingoffer = ashippingoffer[i];
            list.add(new BuyButtonController(buybuttontype, productController, s, s1, shippingoffer));
        }

    }
}
