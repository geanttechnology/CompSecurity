// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.net.Uri;
import android.util.Log;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.common.net.api.local:
//            BaseEbayNowRequest, EbayNowTimeSlotResponse

public final class EbayNowTimeSlotRequest extends BaseEbayNowRequest
{
    public static class AddressWrapper
    {

        public final String city;
        public final String country;
        public final String line1;
        public final String line2;
        public final String notes = null;
        public final String postalCode;
        public final String state;

        public AddressWrapper(Address address)
        {
            line1 = address.addressFields.getStreet1();
            line2 = address.addressFields.getStreet2();
            city = address.addressFields.getCity();
            state = address.addressFields.getStateOrProvince();
            postalCode = address.addressFields.getPostalCode();
            country = address.addressFields.getCountry();
        }
    }

    public static class Contact
    {

        public final String name;
        public final String phoneNumber;

        public Contact(String s, String s1)
        {
            name = s;
            if (s1 != null)
            {
                s = s1.replaceAll("\\s+", "");
            } else
            {
                s = null;
            }
            phoneNumber = s;
        }
    }

    public static class OrderDetails
    {

        public final com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper discount;
        public final ArrayList products = new ArrayList();
        public final com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper tax;
        public final com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper total;

        public OrderDetails(Cart cart, List list)
        {
            CurrencyAmount currencyamount = CurrencyAmount.ZERO;
            cart = CurrencyAmount.ZERO;
            Iterator iterator = list.iterator();
            list = currencyamount;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (com.ebay.common.model.cart.Cart.LineItem)iterator.next();
                if (((com.ebay.common.model.cart.Cart.LineItem) (obj)).isEbayNowAvailable())
                {
                    list = list.add(((com.ebay.common.model.cart.Cart.LineItem) (obj)).salesTax.amount);
                    cart = cart.add(((com.ebay.common.model.cart.Cart.LineItem) (obj)).price.multiplyBy(((com.ebay.common.model.cart.Cart.LineItem) (obj)).quantity));
                    obj = new Product(((com.ebay.common.model.cart.Cart.LineItem) (obj)));
                    products.add(obj);
                }
            } while (true);
            tax = new com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper(list);
            total = new com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper(cart);
            discount = new com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper(CurrencyAmount.ZERO);
        }
    }

    public static class OrderDetails.Product
    {

        public final long id = 0L;
        public final String name;
        public final com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper price;
        public final int quantity;
        public final String sku;

        public OrderDetails.Product(com.ebay.common.model.cart.Cart.LineItem lineitem)
        {
            name = lineitem.itemTitle;
            sku = lineitem.getSellerProductId();
            price = new com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper(lineitem.price);
            quantity = lineitem.quantity;
        }
    }


    public final AddressWrapper deliveryAddress;
    public final Contact deliveryContact;
    public final OrderDetails orderDetails;
    public final String referenceDate = EbayDateUtils.formatIso8601DateTime(Calendar.getInstance(Locale.getDefault()).getTime());
    public final String requestId;
    public String sellerId;
    public final ArrayList serviceIds;
    public final String source = "CORE";
    public String storeId;
    public final String zoneId;

    public EbayNowTimeSlotRequest(String s, Cart cart, List list, String s1, String s2, String s3, ArrayList arraylist)
    {
        super(s, true);
        s = cart.getBuyerShippingAddress();
        deliveryAddress = new AddressWrapper(s);
        deliveryContact = new Contact(((Address) (s)).addressFields.getName(), ((Address) (s)).addressFields.getPhone());
        orderDetails = new OrderDetails(cart, list);
        requestId = (new StringBuilder()).append(cart.cartId).append("_").append(s2).toString();
        serviceIds = arraylist;
        zoneId = s1;
        sellerId = s2;
        storeId = s3;
    }

    protected URL formatUrl()
    {
        Object obj = Uri.parse(EbaySettings.get(EbaySettings.ebncdsvcUrl)).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("delivery-slots").appendPath("available");
        obj = ((android.net.Uri.Builder) (obj)).build().toString();
        URL url;
        try
        {
            url = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(((String) (obj))).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public EbayNowTimeSlotResponse getResponse()
    {
        return new EbayNowTimeSlotResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
