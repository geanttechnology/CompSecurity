// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.api.shopcase.mappers.AmountDeserializer;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart;
import com.ebay.nautilus.domain.net.api.shopcase.models.ShopCartRequestResult;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseErrorHandler

public final class ShopcaseCartResponse extends EbayCosResponse
{
    public static final class ShoppingCartResponseWrapper extends BaseApiResponse
        implements ResponseWrapper
    {

        private String errorCode;
        private String errorDescription;
        private List extensions;
        private ShopCartRequestResult requestResult;
        private ShopCart shopCart;

        public int getAck()
        {
            if (requestResult != null)
            {
                return requestResult.getAck();
            } else
            {
                return -1;
            }
        }

        public ShoppingCartResponseWrapper getResponse()
        {
            return this;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }




        public ShoppingCartResponseWrapper()
        {
        }
    }


    private static final String IAF_TOKEN_ERROR_CODE = "invalid_token";
    public ShopCart shopCart;

    public ShopcaseCartResponse()
    {
        super(true);
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/BaseCommonType$Amount, new AmountDeserializer());
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (ShoppingCartResponseWrapper)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/shopcase/ShopcaseCartResponse$ShoppingCartResponseWrapper);
        if (inputstream != null)
        {
            shopCart = ((ShoppingCartResponseWrapper) (inputstream)).shopCart;
            if (((ShoppingCartResponseWrapper) (inputstream)).errorCode != null && !((ShoppingCartResponseWrapper) (inputstream)).errorCode.isEmpty() && ((ShoppingCartResponseWrapper) (inputstream)).errorCode.equals("invalid_token"))
            {
                addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    ShopcaseErrorHandler.createIafTokenError(((ShoppingCartResponseWrapper) (inputstream)).errorDescription)
                });
            }
        }
    }
}
