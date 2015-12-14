// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NTCredentials;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthScheme, MalformedChallengeException, AuthenticationException, NTLM, 
//            InvalidCredentialsException, AuthChallengeParser

public class NTLMScheme
    implements AuthScheme
{

    private static final int FAILED = 0x7fffffff;
    private static final int INITIATED = 1;
    private static final Log LOG;
    private static final int TYPE1_MSG_GENERATED = 2;
    private static final int TYPE2_MSG_RECEIVED = 3;
    private static final int TYPE3_MSG_GENERATED = 4;
    private static final int UNINITIATED = 0;
    static Class class$org$apache$commons$httpclient$auth$NTLMScheme;
    private String ntlmchallenge;
    private int state;

    public NTLMScheme()
    {
        ntlmchallenge = null;
        state = 0;
    }

    public NTLMScheme(String s)
        throws MalformedChallengeException
    {
        ntlmchallenge = null;
        processChallenge(s);
    }

    public static String authenticate(NTCredentials ntcredentials, String s)
        throws AuthenticationException
    {
        LOG.trace("enter NTLMScheme.authenticate(NTCredentials, String)");
        if (ntcredentials == null)
        {
            throw new IllegalArgumentException("Credentials may not be null");
        } else
        {
            ntcredentials = (new NTLM()).getResponseFor(s, ntcredentials.getUserName(), ntcredentials.getPassword(), ntcredentials.getHost(), ntcredentials.getDomain());
            return "NTLM " + ntcredentials;
        }
    }

    public static String authenticate(NTCredentials ntcredentials, String s, String s1)
        throws AuthenticationException
    {
        LOG.trace("enter NTLMScheme.authenticate(NTCredentials, String)");
        if (ntcredentials == null)
        {
            throw new IllegalArgumentException("Credentials may not be null");
        } else
        {
            NTLM ntlm = new NTLM();
            ntlm.setCredentialCharset(s1);
            ntcredentials = ntlm.getResponseFor(s, ntcredentials.getUserName(), ntcredentials.getPassword(), ntcredentials.getHost(), ntcredentials.getDomain());
            return "NTLM " + ntcredentials;
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
        LOG.trace("enter NTLMScheme.authenticate(Credentials, String, String)");
        try
        {
            s = (NTCredentials)credentials;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + credentials.getClass().getName());
        }
        return authenticate(((NTCredentials) (s)), ntlmchallenge);
    }

    public String authenticate(Credentials credentials, HttpMethod httpmethod)
        throws AuthenticationException
    {
        LOG.trace("enter NTLMScheme.authenticate(Credentials, HttpMethod)");
        if (state == 0)
        {
            throw new IllegalStateException("NTLM authentication process has not been initiated");
        }
        NTCredentials ntcredentials;
        try
        {
            ntcredentials = (NTCredentials)credentials;
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod)
        {
            throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + credentials.getClass().getName());
        }
        credentials = new NTLM();
        credentials.setCredentialCharset(httpmethod.getParams().getCredentialCharset());
        if (state == 1 || state == 0x7fffffff)
        {
            credentials = credentials.getType1Message(ntcredentials.getHost(), ntcredentials.getDomain());
            state = 2;
        } else
        {
            credentials = credentials.getType3Message(ntcredentials.getUserName(), ntcredentials.getPassword(), ntcredentials.getHost(), ntcredentials.getDomain(), credentials.parseType2Message(ntlmchallenge));
            state = 4;
        }
        return "NTLM " + credentials;
    }

    public String getID()
    {
        return ntlmchallenge;
    }

    public String getParameter(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter name may not be null");
        } else
        {
            return null;
        }
    }

    public String getRealm()
    {
        return null;
    }

    public String getSchemeName()
    {
        return "ntlm";
    }

    public boolean isComplete()
    {
        return state == 4 || state == 0x7fffffff;
    }

    public boolean isConnectionBased()
    {
        return true;
    }

    public void processChallenge(String s)
        throws MalformedChallengeException
    {
        if (!AuthChallengeParser.extractScheme(s).equalsIgnoreCase(getSchemeName()))
        {
            throw new MalformedChallengeException("Invalid NTLM challenge: " + s);
        }
        int i = s.indexOf(' ');
        if (i != -1)
        {
            ntlmchallenge = s.substring(i, s.length()).trim();
            state = 3;
            return;
        }
        ntlmchallenge = "";
        if (state == 0)
        {
            state = 1;
            return;
        } else
        {
            state = 0x7fffffff;
            return;
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$auth$NTLMScheme == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.NTLMScheme");
            class$org$apache$commons$httpclient$auth$NTLMScheme = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$NTLMScheme;
        }
        LOG = LogFactory.getLog(class1);
    }
}
