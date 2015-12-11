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

        public EcasShoppingCart.PromotionType deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            type = EcasShoppingCart.PromotionType.values();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (TextUtils.equals(jsonelement, ((EcasShoppingCart.PromotionType) (jsondeserializationcontext)).token))
                {
                    return jsondeserializationcontext;
                }
            }

            return EcasShoppingCart.PromotionType.UNKNOWN;
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


    private static final SELLER_DISCOUNTED_PROMOTIONAL_OFFER $VALUES[];
    public static final SELLER_DISCOUNTED_PROMOTIONAL_OFFER BILL_ME_LATER_PROMOTIONAL_OFFER;
    public static final SELLER_DISCOUNTED_PROMOTIONAL_OFFER SELLER_DISCOUNTED_PROMOTIONAL_OFFER;
    public static final SELLER_DISCOUNTED_PROMOTIONAL_OFFER SHIPPING_PROMOTIONAL_OFFER;
    public static final SELLER_DISCOUNTED_PROMOTIONAL_OFFER UNKNOWN;
    public final boolean isSellerPromotion;
    public final String token;

    public static Deserializer.deserialize valueOf(String s)
    {
        return (Deserializer.deserialize)Enum.valueOf(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionType, s);
    }

    public static Deserializer.deserialize[] values()
    {
        return (Deserializer.deserialize[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, "Unknown", false);
        BILL_ME_LATER_PROMOTIONAL_OFFER = new <init>("BILL_ME_LATER_PROMOTIONAL_OFFER", 1, "BillMeLaterPromotionalOffer", false);
        SHIPPING_PROMOTIONAL_OFFER = new <init>("SHIPPING_PROMOTIONAL_OFFER", 2, "ShippingPromotionalOffer", false);
        SELLER_DISCOUNTED_PROMOTIONAL_OFFER = new <init>("SELLER_DISCOUNTED_PROMOTIONAL_OFFER", 3, "SellerDiscountedPromotionalOffer", true);
        $VALUES = (new .VALUES[] {
            UNKNOWN, BILL_ME_LATER_PROMOTIONAL_OFFER, SHIPPING_PROMOTIONAL_OFFER, SELLER_DISCOUNTED_PROMOTIONAL_OFFER
        });
    }

    private Deserializer(String s, int i, String s1, boolean flag)
    {
        super(s, i);
        isSellerPromotion = flag;
        token = s1;
    }
}
