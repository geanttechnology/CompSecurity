// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experience.checkout;

import com.ebay.nautilus.domain.data.experience.checkout.XoCallToActionModule;
import com.ebay.nautilus.domain.data.experience.checkout.address.ShippingAddressesModule;
import com.ebay.nautilus.domain.data.experience.checkout.details.CartDetailsModule;
import com.ebay.nautilus.domain.data.experience.checkout.error.ErrorsModule;
import com.ebay.nautilus.domain.data.experience.checkout.incentive.IncentivesModule;
import com.ebay.nautilus.domain.data.experience.checkout.payment.PaymentMethodsModule;
import com.ebay.nautilus.domain.data.experience.checkout.protection.BuyerProtectionModule;
import com.ebay.nautilus.domain.data.experience.checkout.summary.SummaryModule;
import com.ebay.nautilus.domain.data.experience.checkout.survey.SurveyModule;
import com.ebay.nautilus.domain.data.experience.type.base.IModule;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experience.checkout:
//            CheckoutApiResponse

protected static class 
    implements JsonDeserializer
{

    public IModule deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        type = jsonelement.getAsJsonObject().get("_type");
        if (type != null)
        {
            if ("ErrorsModule".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/error/ErrorsModule);
            }
            if ("Summary".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/summary/SummaryModule);
            }
            if ("ShippingAddresses".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/address/ShippingAddressesModule);
            }
            if ("PaymentMethods".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/payment/PaymentMethodsModule);
            }
            if ("SessionBuyerProtection".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/protection/BuyerProtectionModule);
            }
            if ("Incentives".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/incentive/IncentivesModule);
            }
            if ("CartDetails".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/details/CartDetailsModule);
            }
            if ("SessionCallToAction".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/XoCallToActionModule);
            }
            if ("Survey".equals(type.getAsString()))
            {
                return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/checkout/survey/SurveyModule);
            }
        }
        return null;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    protected ()
    {
    }
}
