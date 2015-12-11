// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.kernel.net.Response;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartRequest, UpdateCartResponse, EbayCartApi

public class SetPaymentMethod
{
    public static final class SetPaymentMethodRequest extends EbayCartRequest
    {

        final String addressId;
        final String cartId;
        final Date dateOfBirth;
        final String instrumentRefId;
        final Boolean paymentAgreementAccepted;
        final String paymentMethodName;
        final boolean shouldRemember;
        final String strategyChoiceId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            JSONObject jsonobject;
            JSONObject jsonobject1;
            jsonobject = new JSONObject();
            buildClientContext(jsonobject);
            jsonobject.put("cartIdentifier", cartId);
            jsonobject1 = new JSONObject();
            jsonobject1.put("paymentMethodName", paymentMethodName);
            jsonobject1.put("shouldRememberPaymentInstrument", shouldRemember);
            if (paymentAgreementAccepted == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            Object obj;
            JSONObject jsonobject2;
            if (paymentAgreementAccepted.booleanValue())
            {
                obj = "ACCEPTED";
            } else
            {
                obj = "NOT_ACCEPTED";
            }
            jsonobject1.put("paymentAgreementAcceptanceStatus", obj);
            if (strategyChoiceId != null)
            {
                jsonobject1.put("fundingStrategyChoiceId", strategyChoiceId);
            }
            if (instrumentRefId == null)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            jsonobject2 = new JSONObject();
            if ("PayPal".equals(paymentMethodName))
            {
                obj = "IdentityService";
            } else
            {
                obj = "FundingInstrumentService";
            }
            jsonobject2.put("owner", obj);
            jsonobject2.put("key", instrumentRefId);
            jsonobject1.put("paymentInstrumentRefId", jsonobject2);
            if ("PayUponInvoice".equals(paymentMethodName))
            {
                obj = new JSONArray();
                JSONObject jsonobject3 = new JSONObject();
                jsonobject3.put("@name", "DateOfBirth");
                jsonobject3.put("__value__", EbayDateUtils.formatIso8601DateTime(dateOfBirth));
                ((JSONArray) (obj)).put(jsonobject3);
                jsonobject3 = new JSONObject();
                jsonobject3.put("@name", "BillingAddressId");
                jsonobject3.put("__value__", (new StringBuilder()).append("eBay:").append(addressId).toString());
                ((JSONArray) (obj)).put(jsonobject3);
                jsonobject1.put("attribute", obj);
            }
            jsonobject.put("PaymentMethod", jsonobject1);
            obj = new JSONObject();
            ((JSONObject) (obj)).put("updateCartRequest", jsonobject);
            return ((JSONObject) (obj)).toString().getBytes();
            obj;
            throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(((Throwable) (obj)));
        }

        public UpdateCartResponse getResponse()
        {
            return new UpdateCartResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected SetPaymentMethodRequest(EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, boolean flag, Boolean boolean1, 
                Date date, String s4)
        {
            super(ebaycartapi, "updateCart");
            cartId = s;
            paymentMethodName = s1;
            instrumentRefId = s2;
            strategyChoiceId = s3;
            shouldRemember = flag;
            paymentAgreementAccepted = boolean1;
            dateOfBirth = date;
            addressId = s4;
        }
    }


    public SetPaymentMethod()
    {
    }
}
