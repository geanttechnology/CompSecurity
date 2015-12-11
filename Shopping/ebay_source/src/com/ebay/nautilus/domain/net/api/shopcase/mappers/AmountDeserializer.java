// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.mappers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

public final class AmountDeserializer
    implements JsonDeserializer
{

    private static final String FIELD_CONVERTED_FROM_CURRENCY = "convertedFromCurrency";
    private static final String FIELD_CONVERTED_FROM_CURRENCY_ALT = "basisCurrencyId";
    private static final String FIELD_CONVERTED_FROM_VALUE = "convertedFromValue";
    private static final String FIELD_CONVERTED_FROM_VALUE_ALT = "basisAmount";
    private static final String FIELD_CURRENCY = "currency";
    private static final String FIELD_CURRENCY_ALT = "currencyId";
    private static final String FIELD_VALUE = "value";

    public AmountDeserializer()
    {
    }

    public com.ebay.nautilus.domain.data.BaseCommonType.Amount deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        if (jsonelement == null) goto _L2; else goto _L1
_L1:
        if (!jsonelement.isJsonObject()) goto _L2; else goto _L3
_L3:
        jsondeserializationcontext = new com.ebay.nautilus.domain.data.BaseCommonType.Amount();
        type = jsonelement.getAsJsonObject();
        jsonelement = type.getAsJsonPrimitive("value");
        if (jsonelement == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        jsondeserializationcontext.value = jsonelement.getAsDouble();
        if (!type.has("currency")) goto _L5; else goto _L4
_L4:
        jsonelement = type.getAsJsonPrimitive("currency");
_L14:
        if (jsonelement == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        jsondeserializationcontext.currency = jsonelement.getAsString();
        if (!type.has("convertedFromValue")) goto _L7; else goto _L6
_L6:
        jsonelement = type.getAsJsonPrimitive("convertedFromValue");
_L11:
        if (jsonelement == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        jsondeserializationcontext.convertedFromValue = Double.valueOf(jsonelement.getAsDouble());
        if (!type.has("convertedFromCurrency")) goto _L9; else goto _L8
_L8:
        jsonelement = type.getAsJsonPrimitive("convertedFromCurrency");
_L12:
        type = jsondeserializationcontext;
        if (jsonelement != null)
        {
            try
            {
                jsondeserializationcontext.convertedFromCurrency = jsonelement.getAsString();
            }
            // Misplaced declaration of an exception variable
            catch (JsonElement jsonelement)
            {
                throw new JsonParseException("Failed to map JSON to currency amount", jsonelement);
            }
            return jsondeserializationcontext;
        }
          goto _L10
_L5:
        jsonelement = type.getAsJsonPrimitive("currencyId");
        continue; /* Loop/switch isn't completed */
_L7:
        jsonelement = type.getAsJsonPrimitive("basisAmount");
          goto _L11
_L9:
        jsonelement = type.getAsJsonPrimitive("basisCurrencyId");
          goto _L12
_L2:
        type = null;
_L10:
        return type;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }
}
