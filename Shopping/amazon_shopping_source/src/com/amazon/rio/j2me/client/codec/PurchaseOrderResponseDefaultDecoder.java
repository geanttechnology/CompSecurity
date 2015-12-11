// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PurchaseOrderResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, RichMessageDefaultDecoder, PurchaseStatusDefaultDecoder, 
//            AddressDefaultDecoder, OrderDefaultDecoder, OrderSummaryDefaultDecoder, PaymentPlanDefaultDecoder, 
//            GiftOptionSummaryDefaultDecoder, InvoiceCategoryDefaultDecoder, CreditCardTypeDefaultDecoder, PaymentTypeDefaultDecoder, 
//            PaymentMethodDefaultDecoder, PaymentMethodInfoDefaultDecoder, StreamedResponseListener

public class PurchaseOrderResponseDefaultDecoder
    implements Decoder
{

    public PurchaseOrderResponseDefaultDecoder()
    {
    }

    public PurchaseOrderResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new PurchaseOrderResponse();
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setError((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getStringInstance()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setInfo((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getStringInstance()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPurchaseMessages((List)DefaultDecoder.getArrayInstance(new RichMessageDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPurchaseStatus((new PurchaseStatusDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBillingAddress((new AddressDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setShippingAddress((new AddressDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setOrder((List)DefaultDecoder.getArrayInstance(new OrderDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setOrderSummary((new OrderSummaryDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAcknowledgement((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPaymentPlan((new PaymentPlanDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setGiftOptionSummary((List)DefaultDecoder.getArrayInstance(new GiftOptionSummaryDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setBuyNowSessionId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setInvoiceCategories((List)DefaultDecoder.getArrayInstance(new InvoiceCategoryDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setCreditCardType((List)DefaultDecoder.getArrayInstance(new CreditCardTypeDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPaymentType((List)DefaultDecoder.getArrayInstance(new PaymentTypeDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPaymentMethod((List)DefaultDecoder.getArrayInstance(new PaymentMethodDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setPaymentMethodInfo((List)DefaultDecoder.getArrayInstance(new PaymentMethodInfoDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setAddress((List)DefaultDecoder.getArrayInstance(new AddressDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setConfirmedOrderId((List)DefaultDecoder.getArrayInstance(DefaultDecoder.getStringInstance()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setRecipientName((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMsToCheckout((Integer)DefaultDecoder.getIntegerInstance(0xffffffff80000000L, 0x7fffffffL).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
