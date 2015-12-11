// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas.models;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas.models:
//            EcasShoppingCart

public static final class token extends Enum
{
    public static final class Deserializer
        implements JsonDeserializer
    {

        public EcasShoppingCart.PromotionalOfferType deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            type = EcasShoppingCart.PromotionalOfferType.values();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (TextUtils.equals(jsonelement, ((EcasShoppingCart.PromotionalOfferType) (jsondeserializationcontext)).token))
                {
                    return jsondeserializationcontext;
                }
            }

            return EcasShoppingCart.PromotionalOfferType.UNKNOWN;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public Deserializer()
        {
        }
    }


    private static final TARGETED_OFFER $VALUES[];
    public static final TARGETED_OFFER GENERIC;
    public static final TARGETED_OFFER MARK_DOWN_SALE;
    public static final TARGETED_OFFER PROMOTIONAL_SHIPPING;
    public static final TARGETED_OFFER REBATE_OFFER;
    public static final TARGETED_OFFER RELATIONAL;
    public static final TARGETED_OFFER SALE_CLEARENCE;
    public static final TARGETED_OFFER SALE_EVENT;
    public static final TARGETED_OFFER TARGETED_OFFER;
    public static final TARGETED_OFFER UNKNOWN;
    public static final TARGETED_OFFER VERTICAL_OFFER;
    public final int designator;
    public final String token;

    public static Deserializer.deserialize valueOf(String s)
    {
        return (Deserializer.deserialize)Enum.valueOf(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionalOfferType, s);
    }

    public static Deserializer.deserialize[] values()
    {
        return (Deserializer.deserialize[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, -1, "Unknown");
        RELATIONAL = new <init>("RELATIONAL", 1, 2, "BundleOffer");
        GENERIC = new <init>("GENERIC", 2, 3, "OrderSubTotalOffer");
        SALE_EVENT = new <init>("SALE_EVENT", 3, 4, "SaleEvent");
        PROMOTIONAL_SHIPPING = new <init>("PROMOTIONAL_SHIPPING", 4, 5, "PromotionalShipping");
        SALE_CLEARENCE = new <init>("SALE_CLEARENCE", 5, 6, "SaleAndClearence");
        VERTICAL_OFFER = new <init>("VERTICAL_OFFER", 6, 7, "VerticalOffer");
        REBATE_OFFER = new <init>("REBATE_OFFER", 7, 8, "RebateOffer");
        MARK_DOWN_SALE = new <init>("MARK_DOWN_SALE", 8, 11, "MarkDownSale");
        TARGETED_OFFER = new <init>("TARGETED_OFFER", 9, 9, "TargetedOffer");
        $VALUES = (new .VALUES[] {
            UNKNOWN, RELATIONAL, GENERIC, SALE_EVENT, PROMOTIONAL_SHIPPING, SALE_CLEARENCE, VERTICAL_OFFER, REBATE_OFFER, MARK_DOWN_SALE, TARGETED_OFFER
        });
    }

    private Deserializer(String s, int i, int j, String s1)
    {
        super(s, i);
        designator = j;
        token = s1;
    }
}
