// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

// Referenced classes of package com.parse.signpost.signature:
//            OAuthMessageSigner

public class PlainTextMessageSigner extends OAuthMessageSigner
{

    public PlainTextMessageSigner()
    {
    }

    public String getSignatureMethod()
    {
        return "PLAINTEXT";
    }

    public String sign(HttpRequest httprequest, HttpParameters httpparameters)
        throws OAuthMessageSignerException
    {
        return (new StringBuilder()).append(OAuth.percentEncode(getConsumerSecret())).append('&').append(OAuth.percentEncode(getTokenSecret())).toString();
    }
}
