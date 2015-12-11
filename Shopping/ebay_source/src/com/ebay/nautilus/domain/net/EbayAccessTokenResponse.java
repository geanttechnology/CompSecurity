// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.io.InputStream;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponse, EbayResponseError

public final class EbayAccessTokenResponse extends EbayResponse
{
    static class ParseHandler extends BaseDataMapped
    {

        public String accessToken;
        public String error;
        public int expiresIn;
        public String refreshToken;
        public String tokenType;

        ParseHandler()
        {
        }
    }


    public long expirationDate;
    public String token;

    public EbayAccessTokenResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (ParseHandler)readJsonStream(inputstream, com/ebay/nautilus/domain/net/EbayAccessTokenResponse$ParseHandler);
        if (((ParseHandler) (inputstream)).error != null)
        {
            EbayResponseError ebayresponseerror = new EbayResponseError();
            ebayresponseerror.category = 1;
            ebayresponseerror.code = "1";
            ebayresponseerror.severity = 1;
            ebayresponseerror.shortMessage = ((ParseHandler) (inputstream)).error;
            setResultStatus(ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                ebayresponseerror
            }));
            return;
        } else
        {
            setAckCode(1);
            token = ((ParseHandler) (inputstream)).accessToken;
            expirationDate = 1000L * (long)((ParseHandler) (inputstream)).expiresIn + System.currentTimeMillis();
            return;
        }
    }
}
