// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            RFC2617Scheme, MalformedChallengeException, AuthenticationException, InvalidCredentialsException

public class BasicScheme extends RFC2617Scheme
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$auth$BasicScheme;
    private boolean complete;

    public BasicScheme()
    {
        complete = false;
    }

    public BasicScheme(String s)
        throws MalformedChallengeException
    {
        super(s);
        complete = true;
    }

    public static String authenticate(UsernamePasswordCredentials usernamepasswordcredentials)
    {
        return authenticate(usernamepasswordcredentials, "ISO-8859-1");
    }

    public static String authenticate(UsernamePasswordCredentials usernamepasswordcredentials, String s)
    {
        LOG.trace("enter BasicScheme.authenticate(UsernamePasswordCredentials, String)");
        if (usernamepasswordcredentials == null)
        {
            throw new IllegalArgumentException("Credentials may not be null");
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("charset may not be null or empty");
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append(usernamepasswordcredentials.getUserName());
            stringbuffer.append(":");
            stringbuffer.append(usernamepasswordcredentials.getPassword());
            return "Basic " + EncodingUtil.getAsciiString(Base64.encodeBase64(EncodingUtil.getBytes(stringbuffer.toString(), s)));
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public String authenticate(Credentials credentials, String s, String s1)
        throws AuthenticationException
    {
        LOG.trace("enter BasicScheme.authenticate(Credentials, String, String)");
        try
        {
            s = (UsernamePasswordCredentials)credentials;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidCredentialsException("Credentials cannot be used for basic authentication: " + credentials.getClass().getName());
        }
        return authenticate(((UsernamePasswordCredentials) (s)));
    }

    public String authenticate(Credentials credentials, HttpMethod httpmethod)
        throws AuthenticationException
    {
        LOG.trace("enter BasicScheme.authenticate(Credentials, HttpMethod)");
        if (httpmethod == null)
        {
            throw new IllegalArgumentException("Method may not be null");
        }
        UsernamePasswordCredentials usernamepasswordcredentials;
        try
        {
            usernamepasswordcredentials = (UsernamePasswordCredentials)credentials;
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod)
        {
            throw new InvalidCredentialsException("Credentials cannot be used for basic authentication: " + credentials.getClass().getName());
        }
        return authenticate(usernamepasswordcredentials, httpmethod.getParams().getCredentialCharset());
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

    public void processChallenge(String s)
        throws MalformedChallengeException
    {
        super.processChallenge(s);
        complete = true;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$auth$BasicScheme == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.BasicScheme");
            class$org$apache$commons$httpclient$auth$BasicScheme = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$BasicScheme;
        }
        LOG = LogFactory.getLog(class1);
    }
}
