// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.nio.charset.Charset;
import java.security.Principal;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            RFC2617Scheme

public class BasicScheme extends RFC2617Scheme
{

    private boolean complete;

    public BasicScheme()
    {
        this(Consts.ASCII);
    }

    public BasicScheme(ChallengeState challengestate)
    {
        super(challengestate);
    }

    public BasicScheme(Charset charset)
    {
        super(charset);
        complete = false;
    }

    public static Header authenticate(Credentials credentials, String s, boolean flag)
    {
        Args.notNull(credentials, "Credentials");
        Args.notNull(s, "charset");
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
        credentials = Base64.encode(EncodingUtils.getBytes(stringbuilder.toString(), s), 2);
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
        return authenticate(credentials, httprequest, ((HttpContext) (new BasicHttpContext())));
    }

    public Header authenticate(Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException
    {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httprequest, "HTTP request");
        httpcontext = new StringBuilder();
        httpcontext.append(credentials.getUserPrincipal().getName());
        httpcontext.append(":");
        if (credentials.getPassword() == null)
        {
            credentials = "null";
        } else
        {
            credentials = credentials.getPassword();
        }
        httpcontext.append(credentials);
        credentials = Base64.encode(EncodingUtils.getBytes(httpcontext.toString(), getCredentialsCharset(httprequest)), 2);
        httprequest = new CharArrayBuffer(32);
        if (isProxy())
        {
            httprequest.append("Proxy-Authorization");
        } else
        {
            httprequest.append("Authorization");
        }
        httprequest.append(": Basic ");
        httprequest.append(credentials, 0, credentials.length);
        return new BufferedHeader(httprequest);
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
