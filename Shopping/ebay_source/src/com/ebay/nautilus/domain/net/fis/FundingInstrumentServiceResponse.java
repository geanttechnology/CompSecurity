// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.fis;

import com.ebay.nautilus.domain.data.CreditCard;
import com.ebay.nautilus.domain.data.DirectDebit;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;

public final class FundingInstrumentServiceResponse extends EbayCosResponse
{
    public static class FundingResponseData extends BaseApiResponse
    {

        public AccountOwner accountOwner;
        public DirectDebit bankAccount;
        public CreditCard creditCard;
        public String instrumentId;

        public FundingResponseData()
        {
        }
    }

    public static class FundingResponseData.AccountOwner
    {

        public String accountId;
        public String domainType;

        public FundingResponseData.AccountOwner()
        {
        }
    }


    private FundingResponseData responseData;

    public FundingInstrumentServiceResponse()
    {
        super(true);
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        gsonbuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter((new TypeToken() {

            final FundingInstrumentServiceResponse this$0;

            
            {
                this$0 = FundingInstrumentServiceResponse.this;
                super();
            }
        }).getType(), new com.ebay.nautilus.domain.data.CreditCard.Type.Deserializer());
    }

    public FundingResponseData getResponseData()
    {
        return responseData;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        responseData = (FundingResponseData)readJsonStream(inputstream, com/ebay/nautilus/domain/net/fis/FundingInstrumentServiceResponse$FundingResponseData);
    }
}
