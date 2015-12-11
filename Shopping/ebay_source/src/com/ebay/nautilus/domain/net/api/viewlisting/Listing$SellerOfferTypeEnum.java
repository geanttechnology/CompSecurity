// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class Deserializer extends Enum
{
    public static class Deserializer
        implements JsonDeserializer
    {

        public Listing.SellerOfferTypeEnum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            if (!TextUtils.isEmpty(jsonelement))
            {
                type = Listing.SellerOfferTypeEnum.values();
                int j = type.length;
                for (int i = 0; i < j; i++)
                {
                    jsondeserializationcontext = type[i];
                    if (jsondeserializationcontext.name().equals(jsonelement))
                    {
                        return jsondeserializationcontext;
                    }
                }

            }
            return Listing.SellerOfferTypeEnum.Unknown;
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


    private static final TargetedOffer $VALUES[];
    public static final TargetedOffer BundleOffer;
    public static final TargetedOffer OrderSubTotalOffer;
    public static final TargetedOffer PromotionalShipping;
    public static final TargetedOffer SaleAndClearence;
    public static final TargetedOffer SaleEvent;
    public static final TargetedOffer TargetedOffer;
    public static final TargetedOffer Unknown;

    public static Deserializer.deserialize valueOf(String s)
    {
        return (Deserializer.deserialize)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$SellerOfferTypeEnum, s);
    }

    public static Deserializer.deserialize[] values()
    {
        return (Deserializer.deserialize[])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        BundleOffer = new <init>("BundleOffer", 1);
        OrderSubTotalOffer = new <init>("OrderSubTotalOffer", 2);
        SaleEvent = new <init>("SaleEvent", 3);
        PromotionalShipping = new <init>("PromotionalShipping", 4);
        SaleAndClearence = new <init>("SaleAndClearence", 5);
        TargetedOffer = new <init>("TargetedOffer", 6);
        $VALUES = (new .VALUES[] {
            Unknown, BundleOffer, OrderSubTotalOffer, SaleEvent, PromotionalShipping, SaleAndClearence, TargetedOffer
        });
    }

    private Deserializer(String s, int i)
    {
        super(s, i);
    }
}
