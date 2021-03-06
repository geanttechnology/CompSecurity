// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

// Referenced classes of package com.parse.signpost.signature:
//            SigningStrategy

public class AuthorizationHeaderSigningStrategy
    implements SigningStrategy
{

    private static final long serialVersionUID = 1L;

    public AuthorizationHeaderSigningStrategy()
    {
    }

    public String writeSignature(String s, HttpRequest httprequest, HttpParameters httpparameters)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("OAuth ");
        if (httpparameters.containsKey("realm"))
        {
            stringbuilder.append(httpparameters.getAsHeaderElement("realm"));
            stringbuilder.append(", ");
        }
        if (httpparameters.containsKey("oauth_token"))
        {
            stringbuilder.append(httpparameters.getAsHeaderElement("oauth_token"));
            stringbuilder.append(", ");
        }
        if (httpparameters.containsKey("oauth_callback"))
        {
            stringbuilder.append(httpparameters.getAsHeaderElement("oauth_callback"));
            stringbuilder.append(", ");
        }
        if (httpparameters.containsKey("oauth_verifier"))
        {
            stringbuilder.append(httpparameters.getAsHeaderElement("oauth_verifier"));
            stringbuilder.append(", ");
        }
        stringbuilder.append(httpparameters.getAsHeaderElement("oauth_consumer_key"));
        stringbuilder.append(", ");
        stringbuilder.append(httpparameters.getAsHeaderElement("oauth_version"));
        stringbuilder.append(", ");
        stringbuilder.append(httpparameters.getAsHeaderElement("oauth_signature_method"));
        stringbuilder.append(", ");
        stringbuilder.append(httpparameters.getAsHeaderElement("oauth_timestamp"));
        stringbuilder.append(", ");
        stringbuilder.append(httpparameters.getAsHeaderElement("oauth_nonce"));
        stringbuilder.append(", ");
        stringbuilder.append(OAuth.toHeaderElement("oauth_signature", s));
        s = stringbuilder.toString();
        httprequest.setHeader("Authorization", s);
        return s;
    }
}
