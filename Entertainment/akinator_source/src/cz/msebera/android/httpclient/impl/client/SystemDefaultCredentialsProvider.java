// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            BasicCredentialsProvider

public class SystemDefaultCredentialsProvider
    implements CredentialsProvider
{

    private static final Map SCHEME_MAP;
    private final BasicCredentialsProvider internal = new BasicCredentialsProvider();

    public SystemDefaultCredentialsProvider()
    {
    }

    private static PasswordAuthentication getSystemCreds(AuthScope authscope, java.net.Authenticator.RequestorType requestortype)
    {
        String s1 = authscope.getHost();
        int i = authscope.getPort();
        String s;
        if (i == 443)
        {
            s = "https";
        } else
        {
            s = "http";
        }
        return Authenticator.requestPasswordAuthentication(s1, null, i, s, null, translateScheme(authscope.getScheme()), null, requestortype);
    }

    private static String translateScheme(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            String s2 = (String)SCHEME_MAP.get(s);
            s1 = s2;
            if (s2 == null)
            {
                return s;
            }
        }
        return s1;
    }

    public void clear()
    {
        internal.clear();
    }

    public Credentials getCredentials(AuthScope authscope)
    {
        Args.notNull(authscope, "Auth scope");
        Credentials credentials = internal.getCredentials(authscope);
        if (credentials != null)
        {
            return credentials;
        }
        if (authscope.getHost() != null)
        {
            PasswordAuthentication passwordauthentication1 = getSystemCreds(authscope, java.net.Authenticator.RequestorType.SERVER);
            PasswordAuthentication passwordauthentication = passwordauthentication1;
            if (passwordauthentication1 == null)
            {
                passwordauthentication = getSystemCreds(authscope, java.net.Authenticator.RequestorType.PROXY);
            }
            if (passwordauthentication != null)
            {
                String s = System.getProperty("http.auth.ntlm.domain");
                if (s != null)
                {
                    return new NTCredentials(passwordauthentication.getUserName(), new String(passwordauthentication.getPassword()), null, s);
                }
                if ("NTLM".equalsIgnoreCase(authscope.getScheme()))
                {
                    return new NTCredentials(passwordauthentication.getUserName(), new String(passwordauthentication.getPassword()), null, null);
                } else
                {
                    return new UsernamePasswordCredentials(passwordauthentication.getUserName(), new String(passwordauthentication.getPassword()));
                }
            }
        }
        return null;
    }

    public void setCredentials(AuthScope authscope, Credentials credentials)
    {
        internal.setCredentials(authscope, credentials);
    }

    static 
    {
        SCHEME_MAP = new ConcurrentHashMap();
        SCHEME_MAP.put("Basic".toUpperCase(Locale.ENGLISH), "Basic");
        SCHEME_MAP.put("Digest".toUpperCase(Locale.ENGLISH), "Digest");
        SCHEME_MAP.put("NTLM".toUpperCase(Locale.ENGLISH), "NTLM");
        SCHEME_MAP.put("negotiate".toUpperCase(Locale.ENGLISH), "SPNEGO");
        SCHEME_MAP.put("Kerberos".toUpperCase(Locale.ENGLISH), "Kerberos");
    }
}
