// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Address, OrderSummary, PaymentPlan, PurchaseStatus

public class PurchaseOrderResponse
{

    private String acknowledgement;
    private List address;
    private Address billingAddress;
    private String buyNowSessionId;
    private List confirmedOrderId;
    private List creditCardType;
    private List error;
    private List giftOptionSummary;
    private List info;
    private List invoiceCategories;
    private Integer msToCheckout;
    private List order;
    private OrderSummary orderSummary;
    private List paymentMethod;
    private List paymentMethodInfo;
    private PaymentPlan paymentPlan;
    private List paymentType;
    private List purchaseMessages;
    private PurchaseStatus purchaseStatus;
    private String recipientName;
    private Address shippingAddress;

    public PurchaseOrderResponse()
    {
    }

    public List getConfirmedOrderId()
    {
        return confirmedOrderId;
    }

    public PurchaseStatus getPurchaseStatus()
    {
        return purchaseStatus;
    }

    public void setAcknowledgement(String s)
    {
        acknowledgement = s;
    }

    public void setAddress(List list)
    {
        address = list;
    }

    public void setBillingAddress(Address address1)
    {
        billingAddress = address1;
    }

    public void setBuyNowSessionId(String s)
    {
        buyNowSessionId = s;
    }

    public void setConfirmedOrderId(List list)
    {
        confirmedOrderId = list;
    }

    public void setCreditCardType(List list)
    {
        creditCardType = list;
    }

    public void setError(List list)
    {
        error = list;
    }

    public void setGiftOptionSummary(List list)
    {
        giftOptionSummary = list;
    }

    public void setInfo(List list)
    {
        info = list;
    }

    public void setInvoiceCategories(List list)
    {
        invoiceCategories = list;
    }

    public void setMsToCheckout(Integer integer)
    {
        msToCheckout = integer;
    }

    public void setOrder(List list)
    {
        order = list;
    }

    public void setOrderSummary(OrderSummary ordersummary)
    {
        orderSummary = ordersummary;
    }

    public void setPaymentMethod(List list)
    {
        paymentMethod = list;
    }

    public void setPaymentMethodInfo(List list)
    {
        paymentMethodInfo = list;
    }

    public void setPaymentPlan(PaymentPlan paymentplan)
    {
        paymentPlan = paymentplan;
    }

    public void setPaymentType(List list)
    {
        paymentType = list;
    }

    public void setPurchaseMessages(List list)
    {
        purchaseMessages = list;
    }

    public void setPurchaseStatus(PurchaseStatus purchasestatus)
    {
        purchaseStatus = purchasestatus;
    }

    public void setRecipientName(String s)
    {
        recipientName = s;
    }

    public void setShippingAddress(Address address1)
    {
        shippingAddress = address1;
    }
}
