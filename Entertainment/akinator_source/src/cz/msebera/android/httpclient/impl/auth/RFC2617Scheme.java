// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import cz.msebera.android.httpclient.message.HeaderValueParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            AuthSchemeBase

public abstract class RFC2617Scheme extends AuthSchemeBase
{

    private final Charset credentialsCharset;
    private final Map params;

    public RFC2617Scheme()
    {
        this(Consts.ASCII);
    }

    public RFC2617Scheme(ChallengeState challengestate)
    {
        super(challengestate);
        params = new HashMap();
        credentialsCharset = Consts.ASCII;
    }

    public RFC2617Scheme(Charset charset)
    {
        params = new HashMap();
        if (charset == null)
        {
            charset = Consts.ASCII;
        }
        credentialsCharset = charset;
    }

    String getCredentialsCharset(HttpRequest httprequest)
    {
        String s = (String)httprequest.getParams().getParameter("http.auth.credential-charset");
        httprequest = s;
        if (s == null)
        {
            httprequest = getCredentialsCharset().name();
        }
        return httprequest;
    }

    public Charset getCredentialsCharset()
    {
        return credentialsCharset;
    }

    public String getParameter(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (String)params.get(s.toLowerCase(Locale.ENGLISH));
        }
    }

    protected Map getParameters()
    {
        return params;
    }

    public String getRealm()
    {
        return getParameter("realm");
    }

    protected void parseChallenge(CharArrayBuffer chararraybuffer, int i, int j)
        throws MalformedChallengeException
    {
        chararraybuffer = BasicHeaderValueParser.INSTANCE.parseElements(chararraybuffer, new ParserCursor(i, chararraybuffer.length()));
        if (chararraybuffer.length == 0)
        {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        params.clear();
        j = chararraybuffer.length;
        for (i = 0; i < j; i++)
        {
            HeaderElement headerelement = chararraybuffer[i];
            params.put(headerelement.getName().toLowerCase(Locale.ENGLISH), headerelement.getValue());
        }

    }
}
