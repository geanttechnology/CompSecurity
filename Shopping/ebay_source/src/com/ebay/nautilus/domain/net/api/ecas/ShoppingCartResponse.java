// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.domain.datamapping.gson.DateWithTimeZoneDeserializer;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCartResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.ebay.nautilus.domain.net.dataobject.ErrorMessageContainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiResponse, EcasErrorHandler

public class ShoppingCartResponse extends EcasApiResponse
{
    public static class AddItemToShoppingCart extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public AddItemToShoppingCart()
        {
        }
    }

    static abstract class EcasResponseWrapper
        implements ResponseWrapper
    {

        public ErrorMessageContainer errorContainer;

        EcasResponseWrapper()
        {
        }
    }

    public static final class GetAndValidateShoppingCartByUserId extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public GetAndValidateShoppingCartByUserId()
        {
        }
    }

    public static class GetShoppingCartByUserId extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public GetShoppingCartByUserId()
        {
        }
    }

    public static class GetVersion extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public GetVersion()
        {
        }
    }

    public static class MoveItemFromCartToSaveForLater extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public MoveItemFromCartToSaveForLater()
        {
        }
    }

    public static class MoveItemFromSaveForLaterToCart extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public MoveItemFromSaveForLaterToCart()
        {
        }
    }

    public static class RemoveItemFromSaveForLater extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public RemoveItemFromSaveForLater()
        {
        }
    }

    public static class RemoveItemFromShoppingCart extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public RemoveItemFromShoppingCart()
        {
        }
    }

    public static class UpdateShoppingCart extends EcasResponseWrapper
    {

        protected EcasShoppingCartResponse casResponse;

        public EcasShoppingCartResponse getResponse()
        {
            return casResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public UpdateShoppingCart()
        {
        }
    }


    private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).registerTypeAdapter(java/util/Date, new EbayDateAdapter()).registerTypeAdapter(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$DateWithTimeZone, new DateWithTimeZoneDeserializer()).registerTypeAdapter(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionType, new com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.PromotionType.Deserializer()).registerTypeAdapter(com/ebay/nautilus/domain/net/api/ecas/models/EcasShoppingCart$PromotionalOfferType, new com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.PromotionalOfferType.Deserializer()).create();
    protected final Class callWrapperClass;

    public ShoppingCartResponse(Class class1)
    {
        callWrapperClass = class1;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (EcasResponseWrapper)readStream(MAPPER, inputstream, callWrapperClass);
        if (inputstream != null)
        {
            setCasResponse(inputstream.getResponse());
        }
        if (inputstream != null && ((EcasResponseWrapper) (inputstream)).errorContainer != null)
        {
            inputstream = EcasErrorHandler.getIafTokenError(((EcasResponseWrapper) (inputstream)).errorContainer);
            if (inputstream != null)
            {
                addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    inputstream
                });
            }
        }
    }

}
