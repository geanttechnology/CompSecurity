// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experience.checkout;

import com.ebay.nautilus.domain.data.experience.checkout.XoActionType;
import com.ebay.nautilus.domain.data.experience.checkout.XoCallToActionModule;
import com.ebay.nautilus.domain.data.experience.checkout.address.ShippingAddressesModule;
import com.ebay.nautilus.domain.data.experience.checkout.details.CartDetailsModule;
import com.ebay.nautilus.domain.data.experience.checkout.details.LineItemType;
import com.ebay.nautilus.domain.data.experience.checkout.details.PromotionType;
import com.ebay.nautilus.domain.data.experience.checkout.error.ErrorsModule;
import com.ebay.nautilus.domain.data.experience.checkout.incentive.IncentiveBrandNameType;
import com.ebay.nautilus.domain.data.experience.checkout.incentive.IncentiveType;
import com.ebay.nautilus.domain.data.experience.checkout.incentive.IncentivesModule;
import com.ebay.nautilus.domain.data.experience.checkout.payment.PaymentMethodsModule;
import com.ebay.nautilus.domain.data.experience.checkout.protection.BuyerProtectionModule;
import com.ebay.nautilus.domain.data.experience.checkout.protection.BuyerProtectionType;
import com.ebay.nautilus.domain.data.experience.checkout.session.CheckoutSession;
import com.ebay.nautilus.domain.data.experience.checkout.summary.SummaryModule;
import com.ebay.nautilus.domain.data.experience.checkout.survey.SurveyModule;
import com.ebay.nautilus.domain.data.experience.type.base.IModule;
import com.ebay.nautilus.domain.datamapping.gson.EnumDeserializer;
import com.ebay.nautilus.domain.net.EbayCosExpResponse;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class CheckoutApiResponse extends EbayCosExpResponse
{
    protected static class Deserializer
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

        protected Deserializer()
        {
        }
    }


    public CheckoutSession session;

    public CheckoutApiResponse()
    {
    }

    public static void addGsonBuilderPropertiesHelper(GsonBuilder gsonbuilder)
    {
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/checkout/XoActionType, new EnumDeserializer(XoActionType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/checkout/details/PromotionType, new EnumDeserializer(PromotionType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/checkout/details/LineItemType, new EnumDeserializer(LineItemType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/checkout/incentive/IncentiveType, new EnumDeserializer(IncentiveType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/checkout/incentive/IncentiveBrandNameType, new EnumDeserializer(IncentiveBrandNameType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/checkout/protection/BuyerProtectionType, new EnumDeserializer(BuyerProtectionType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/type/base/IModule, new Deserializer());
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        super.addGsonBuilderProperties(gsonbuilder);
        addGsonBuilderPropertiesHelper(gsonbuilder);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        session = (CheckoutSession)readJsonStream(inputstream, com/ebay/nautilus/domain/data/experience/checkout/session/CheckoutSession);
    }
}
