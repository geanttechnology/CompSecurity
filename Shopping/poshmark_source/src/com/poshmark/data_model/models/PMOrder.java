// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.data_model.models.inner_models.LineItem;
import com.poshmark.data_model.models.inner_models.Offer;
import com.poshmark.data_model.models.inner_models.PaymentInfo;
import com.poshmark.data_model.models.inner_models.Price;
import com.poshmark.data_model.models.inner_models.ShippingAmount;
import com.poshmark.utils.CurrencyUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PMOrder
{

    public static String PMORDER_CHECKOUT_TYPE_BUY_BUNDLE = "bbdl";
    public static String PMORDER_CHECKOUT_TYPE_BUY_NOW = "bnow";
    BigDecimal balance_to_apply;
    public Address billing_address;
    String checkout_type;
    BigDecimal credits_to_apply;
    List discounts;
    String id;
    List inventory_units;
    public PaymentInfo last_payment_info;
    List line_items;
    BigDecimal net_balance;
    Offer offer;
    String picture_url;
    BigDecimal pm_fee;
    BigDecimal redeemable_to_apply;
    BigDecimal seller_earning;
    String seller_id;
    String seller_name;
    String seller_username;
    public Address shipping_address;
    List shipping_amounts;
    String shipping_discount_title;
    String state;
    String status;
    String title;
    BigDecimal total;
    Price total_amount;
    BigDecimal total_discount;
    String total_discount_title;
    BigDecimal total_original_price;
    BigDecimal total_price;
    BigDecimal total_price_discount;
    BigDecimal total_shipping;
    BigDecimal total_shipping_discount;
    BigDecimal total_tax;
    String user_id;

    public PMOrder()
    {
        inventory_units = new ArrayList();
        line_items = new ArrayList();
        shipping_amounts = new ArrayList();
    }

    private void copyLineItems(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        if (line_items != null)
        {
            line_items.clear();
        }
_L4:
        return;
_L2:
        int j = list.size();
        if (j > 0)
        {
            if (line_items == null)
            {
                line_items = new ArrayList();
            }
            int i = 0;
            while (i < j) 
            {
                LineItem lineitem = (LineItem)list.get(i);
                LineItem lineitem1 = new LineItem();
                lineitem1.copy(lineitem);
                line_items.set(i, lineitem1);
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void copyShippingAmounts(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        if (shipping_amounts != null)
        {
            shipping_amounts.clear();
        }
_L4:
        return;
_L2:
        int j = list.size();
        if (j > 0)
        {
            if (shipping_amounts == null)
            {
                shipping_amounts = new ArrayList();
            }
            int i = 0;
            while (i < j) 
            {
                ShippingAmount shippingamount = (ShippingAmount)list.get(i);
                ShippingAmount shippingamount1 = new ShippingAmount();
                shippingamount1.copy(shippingamount);
                shipping_amounts.set(i, shippingamount1);
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void copy(PMOrder pmorder)
    {
        id = pmorder.id;
        user_id = pmorder.user_id;
        status = pmorder.status;
        inventory_units = pmorder.inventory_units;
        copyLineItems(pmorder.line_items);
        if (shipping_address == null)
        {
            shipping_address = new Address();
        }
        shipping_address.copy(pmorder.shipping_address);
        if (billing_address == null)
        {
            billing_address = new Address();
        }
        billing_address.copy(pmorder.billing_address);
        if (last_payment_info == null)
        {
            last_payment_info = new PaymentInfo();
        }
        last_payment_info.copy(pmorder.last_payment_info);
        copyShippingAmounts(pmorder.shipping_amounts);
        if (offer == null)
        {
            offer = new Offer();
        }
        offer.copy(pmorder.offer);
        total_tax = pmorder.total_tax;
        total = pmorder.total;
        balance_to_apply = pmorder.balance_to_apply;
        credits_to_apply = pmorder.credits_to_apply;
        redeemable_to_apply = pmorder.redeemable_to_apply;
        net_balance = pmorder.net_balance;
        total_amount.copy(pmorder.total_amount);
    }

    public BigDecimal getBalanceToApply()
    {
        return balance_to_apply;
    }

    public String getBalanceToApplyString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(balance_to_apply)).toString();
    }

    public BigDecimal getBasePrice()
    {
        return ((LineItem)getLineItems().get(0)).getPrice();
    }

    public Address getBillingAddress()
    {
        return billing_address;
    }

    public String getBrainTreeToken()
    {
        String s = null;
        if (last_payment_info != null)
        {
            s = last_payment_info.getBrainTreeToken();
        }
        return s;
    }

    public String getCheckoutType()
    {
        return checkout_type;
    }

    public BigDecimal getCreditsToApply()
    {
        return credits_to_apply;
    }

    public String getCreditsToApplyString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(credits_to_apply)).toString();
    }

    public List getDiscounts()
    {
        return discounts;
    }

    public String getInventoryUnitIds()
    {
        Object obj = new String();
        Object obj1 = obj;
        if (line_items != null)
        {
            Iterator iterator = line_items.iterator();
            do
            {
                obj1 = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj1 = (LineItem)iterator.next();
                obj1 = (new StringBuilder()).append(((String) (obj))).append(((LineItem) (obj1)).getInventoryUnitId()).toString();
                obj = obj1;
                if (iterator.hasNext())
                {
                    obj = (new StringBuilder()).append(((String) (obj1))).append(",").toString();
                }
            } while (true);
        }
        return ((String) (obj1));
    }

    public PaymentInfo getLastPaymentInfo()
    {
        return last_payment_info;
    }

    public List getLineItems()
    {
        return line_items;
    }

    public BigDecimal getNetBalance()
    {
        return net_balance;
    }

    public String getNetBalanceString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(net_balance)).toString();
    }

    public String getOrderId()
    {
        return id;
    }

    public String getOrderListingId()
    {
        Object obj = null;
        String s = obj;
        if (line_items != null)
        {
            LineItem lineitem = (LineItem)line_items.get(0);
            s = obj;
            if (lineitem != null)
            {
                s = lineitem.getProductId();
            }
        }
        return s;
    }

    public String getPictureUrl()
    {
        if (picture_url != null)
        {
            return picture_url;
        }
        if (line_items.size() > 0)
        {
            return ((LineItem)line_items.get(0)).getPictureURL();
        } else
        {
            return null;
        }
    }

    public BigDecimal getRedeemableToApply()
    {
        return redeemable_to_apply;
    }

    public String getRedeemableToApplyString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(redeemable_to_apply)).toString();
    }

    public String getSellerName()
    {
        return seller_name;
    }

    public Address getShippingAddress()
    {
        return shipping_address;
    }

    public List getShippingAmount()
    {
        return shipping_amounts;
    }

    public String getShippingDiscountTitle()
    {
        return shipping_discount_title;
    }

    public String getStatus()
    {
        return state;
    }

    public String getTitle()
    {
        return title;
    }

    public BigDecimal getTotal()
    {
        return total;
    }

    public String getTotalDiscountTitle()
    {
        return total_discount_title;
    }

    public BigDecimal getTotalOriginalPrice()
    {
        return total_original_price;
    }

    public String getTotalOriginalPriceString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total_original_price)).toString();
    }

    public String getTotalPriceString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total_price)).toString();
    }

    public BigDecimal getTotalShipping()
    {
        return total_shipping;
    }

    public BigDecimal getTotalShippingAmount()
    {
        BigDecimal bigdecimal = new BigDecimal("0");
        for (int i = 0; i < shipping_amounts.size(); i++)
        {
            bigdecimal.add(((ShippingAmount)shipping_amounts.get(i)).getAmount());
        }

        return bigdecimal;
    }

    public String getTotalShippingString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total_shipping)).toString();
    }

    public String getTotalString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total)).toString();
    }

    public BigDecimal getTotalTax()
    {
        return total_tax;
    }

    public String getTotalTaxString()
    {
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsFormattedString(total_tax)).toString();
    }

    public boolean isCreditCardInfoValid()
    {
        boolean flag;
        boolean flag1;
        if (last_payment_info != null && last_payment_info.isDataAvailable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (shipping_address != null && shipping_address.isDataAvailable())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag && flag1;
    }

    public boolean isOrderCheckoutTypeBundle()
    {
        if (checkout_type != null)
        {
            return checkout_type.equalsIgnoreCase(PMORDER_CHECKOUT_TYPE_BUY_BUNDLE);
        } else
        {
            return false;
        }
    }

}
