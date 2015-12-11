// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.scribe.builder.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

// Referenced classes of package org.scribe.builder.api:
//            DefaultApi20

public class ConstantContactApi2 extends DefaultApi20
{

    private static final String AUTHORIZE_URL = "https://oauth2.constantcontact.com/oauth2/oauth/siteowner/authorize?client_id=%s&response_type=code&redirect_uri=%s";

    public ConstantContactApi2()
    {
    }

    public String getAccessTokenEndpoint()
    {
        return "https://oauth2.constantcontact.com/oauth2/oauth/token?grant_type=authorization_code";
    }

    public AccessTokenExtractor getAccessTokenExtractor()
    {
        return new AccessTokenExtractor() {

            final ConstantContactApi2 this$0;

            public Token extract(String s)
            {
                Preconditions.checkEmptyString(s, "Response body is incorrect. Can't extract a token from an empty string");
                Matcher matcher = Pattern.compile("\"access_token\"\\s*:\\s*\"([^&\"]+)\"").matcher(s);
                if (matcher.find())
                {
                    return new Token(OAuthEncoder.decode(matcher.group(1)), "", s);
                } else
                {
                    throw new OAuthException((new StringBuilder()).append("Response body is incorrect. Can't extract a token from this: '").append(s).append("'").toString(), null);
                }
            }

            
            {
                this$0 = ConstantContactApi2.this;
                super();
            }
        };
    }

    public Verb getAccessTokenVerb()
    {
        return Verb.POST;
    }

    public String getAuthorizationUrl(OAuthConfig oauthconfig)
    {
        return String.format("https://oauth2.constantcontact.com/oauth2/oauth/siteowner/authorize?client_id=%s&response_type=code&redirect_uri=%s", new Object[] {
            oauthconfig.getApiKey(), OAuthEncoder.encode(oauthconfig.getCallback())
        });
    }
}
