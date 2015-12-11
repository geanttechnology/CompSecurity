// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.commonscodecandroid.binary.Base64;
import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.auth.params.AuthParams;
import com.comcast.cim.httpcomponentsandroid.message.BufferedHeader;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.EncodingUtils;
import java.security.Principal;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.auth:
//            RFC2617Scheme

public class BasicScheme extends RFC2617Scheme
{

    private boolean complete;

    public BasicScheme()
    {
        complete = false;
    }

    public static Header authenticate(Credentials credentials, String s, boolean flag)
    {
        if (credentials == null)
        {
            throw new IllegalArgumentException("Credentials may not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("charset may not be null");
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(credentials.getUserPrincipal().getName());
        stringbuilder.append(":");
        if (credentials.getPassword() == null)
        {
            credentials = "null";
        } else
        {
            credentials = credentials.getPassword();
        }
        stringbuilder.append(credentials);
        credentials = Base64.encodeBase64(EncodingUtils.getBytes(stringbuilder.toString(), s));
        s = new CharArrayBuffer(32);
        if (flag)
        {
            s.append("Proxy-Authorization");
        } else
        {
            s.append("Authorization");
        }
        s.append(": Basic ");
        s.append(credentials, 0, credentials.length);
        return new BufferedHeader(s);
    }

    public Header authenticate(Credentials credentials, HttpRequest httprequest)
        throws AuthenticationException
    {
        if (credentials == null)
        {
            throw new IllegalArgumentException("Credentials may not be null");
        }
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else
        {
            return authenticate(credentials, AuthParams.getCredentialCharset(httprequest.getParams()), isProxy());
        }
    }

    public String getSchemeName()
    {
        return "basic";
    }

    public boolean isComplete()
    {
        return complete;
    }

    public boolean isConnectionBased()
    {
        return false;
    }

    public void processChallenge(Header header)
        throws MalformedChallengeException
    {
        super.processChallenge(header);
        complete = true;
    }
}
