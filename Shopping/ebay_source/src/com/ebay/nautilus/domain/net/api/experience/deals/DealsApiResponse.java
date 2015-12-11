// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experience.deals;

import com.ebay.nautilus.domain.data.experience.deals.DealsData;
import com.ebay.nautilus.domain.data.experience.deals.ListingsModule;
import com.ebay.nautilus.domain.data.experience.deals.TitleVmModule;
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

public class DealsApiResponse extends EbayCosExpResponse
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
                if ("Listings".equals(type.getAsString()))
                {
                    return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/deals/ListingsModule);
                }
                if ("TitleViewModel".equals(type.getAsString()))
                {
                    return (IModule)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/data/experience/deals/TitleVmModule);
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


    public DealsData experienceData;

    public DealsApiResponse()
    {
    }

    public static void addGsonBuilderPropertiesHelper(GsonBuilder gsonbuilder)
    {
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/deals/DealsListingSummary$DeliveryOption, new EnumDeserializer(com.ebay.nautilus.domain.data.experience.deals.DealsListingSummary.DeliveryOption.UNKNOWN));
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
        experienceData = (DealsData)readJsonStream(inputstream, com/ebay/nautilus/domain/data/experience/deals/DealsData);
    }
}
