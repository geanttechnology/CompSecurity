// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ParameterFormatter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            RFC2617Scheme, MalformedChallengeException, AuthenticationException, InvalidCredentialsException

public class DigestScheme extends RFC2617Scheme
{

    private static final char HEXADECIMAL[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static final Log LOG;
    private static final String NC = "00000001";
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    static Class class$org$apache$commons$httpclient$auth$DigestScheme;
    private String cnonce;
    private boolean complete;
    private final ParameterFormatter formatter;
    private int qopVariant;

    public DigestScheme()
    {
        qopVariant = 0;
        complete = false;
        formatter = new ParameterFormatter();
    }

    public DigestScheme(String s)
        throws MalformedChallengeException
    {
        this();
        processChallenge(s);
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

    public static String createCnonce()
    {
        LOG.trace("enter DigestScheme.createCnonce()");
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new HttpClientError("Unsupported algorithm in HTTP Digest authentication: MD5");
        }
        return encode(messagedigest.digest(EncodingUtil.getAsciiBytes(Long.toString(System.currentTimeMillis()))));
    }

    private String createDigest(String s, String s1)
        throws AuthenticationException
    {
        LOG.trace("enter DigestScheme.createDigest(String, String, Map)");
        String s7 = getParameter("uri");
        String s9 = getParameter("realm");
        String s5 = getParameter("nonce");
        String s6 = getParameter("qop");
        String s8 = getParameter("methodname");
        String s2 = getParameter("algorithm");
        String s4 = s2;
        if (s2 == null)
        {
            s4 = "MD5";
        }
        Object obj = getParameter("charset");
        s2 = ((String) (obj));
        if (obj == null)
        {
            s2 = "ISO-8859-1";
        }
        if (qopVariant == 1)
        {
            LOG.warn("qop=auth-int is not supported");
            throw new AuthenticationException("Unsupported qop in HTTP Digest authentication");
        }
        StringBuffer stringbuffer2;
        try
        {
            obj = MessageDigest.getInstance("MD5");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AuthenticationException("Unsupported algorithm in HTTP Digest authentication: MD5");
        }
        stringbuffer2 = new StringBuffer(s.length() + s9.length() + s1.length() + 2);
        stringbuffer2.append(s);
        stringbuffer2.append(':');
        stringbuffer2.append(s9);
        stringbuffer2.append(':');
        stringbuffer2.append(s1);
        s1 = stringbuffer2.toString();
        if (s4.equals("MD5-sess"))
        {
            s = encode(((MessageDigest) (obj)).digest(EncodingUtil.getBytes(s1, s2)));
            s1 = new StringBuffer(s.length() + s5.length() + cnonce.length() + 2);
            s1.append(s);
            s1.append(':');
            s1.append(s5);
            s1.append(':');
            s1.append(cnonce);
            s = s1.toString();
        } else
        {
            s = s1;
            if (!s4.equals("MD5"))
            {
                LOG.warn("Unhandled algorithm " + s4 + " requested");
                s = s1;
            }
        }
        s1 = encode(((MessageDigest) (obj)).digest(EncodingUtil.getBytes(s, s2)));
        s = null;
        if (qopVariant == 1)
        {
            LOG.error("Unhandled qop auth-int");
        } else
        {
            s = s8 + ":" + s7;
        }
        s = encode(((MessageDigest) (obj)).digest(EncodingUtil.getAsciiBytes(s)));
        if (qopVariant == 0)
        {
            LOG.debug("Using null qop method");
            StringBuffer stringbuffer = new StringBuffer(s1.length() + s5.length() + s.length());
            stringbuffer.append(s1);
            stringbuffer.append(':');
            stringbuffer.append(s5);
            stringbuffer.append(':');
            stringbuffer.append(s);
            s = stringbuffer.toString();
        } else
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Using qop method " + s6);
            }
            String s3 = getQopVariantString();
            StringBuffer stringbuffer1 = new StringBuffer(s1.length() + s5.length() + "00000001".length() + cnonce.length() + s3.length() + s.length() + 5);
            stringbuffer1.append(s1);
            stringbuffer1.append(':');
            stringbuffer1.append(s5);
            stringbuffer1.append(':');
            stringbuffer1.append("00000001");
            stringbuffer1.append(':');
            stringbuffer1.append(cnonce);
            stringbuffer1.append(':');
            stringbuffer1.append(s3);
            stringbuffer1.append(':');
            stringbuffer1.append(s);
            s = stringbuffer1.toString();
        }
        return encode(((MessageDigest) (obj)).digest(EncodingUtil.getAsciiBytes(s)));
    }

    private String createDigestHeader(String s, String s1)
        throws AuthenticationException
    {
        LOG.trace("enter DigestScheme.createDigestHeader(String, Map, String)");
        String s2 = getParameter("uri");
        String s3 = getParameter("realm");
        String s4 = getParameter("nonce");
        String s5 = getParameter("opaque");
        String s6 = getParameter("algorithm");
        ArrayList arraylist = new ArrayList(20);
        arraylist.add(new NameValuePair("username", s));
        arraylist.add(new NameValuePair("realm", s3));
        arraylist.add(new NameValuePair("nonce", s4));
        arraylist.add(new NameValuePair("uri", s2));
        arraylist.add(new NameValuePair("response", s1));
        if (qopVariant != 0)
        {
            arraylist.add(new NameValuePair("qop", getQopVariantString()));
            arraylist.add(new NameValuePair("nc", "00000001"));
            arraylist.add(new NameValuePair("cnonce", cnonce));
        }
        if (s6 != null)
        {
            arraylist.add(new NameValuePair("algorithm", s6));
        }
        if (s5 != null)
        {
            arraylist.add(new NameValuePair("opaque", s5));
        }
        s = new StringBuffer();
        int i = 0;
        while (i < arraylist.size()) 
        {
            s1 = (NameValuePair)arraylist.get(i);
            if (i > 0)
            {
                s.append(", ");
            }
            ParameterFormatter parameterformatter;
            boolean flag;
            boolean flag1;
            if ("nc".equals(s1.getName()) || "qop".equals(s1.getName()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            parameterformatter = formatter;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            parameterformatter.setAlwaysUseQuotes(flag1);
            formatter.format(s, s1);
            i++;
        }
        return s.toString();
    }

    private static String encode(byte abyte0[])
    {
        LOG.trace("enter DigestScheme.encode(byte[])");
        if (abyte0.length != 16)
        {
            return null;
        }
        char ac[] = new char[32];
        for (int i = 0; i < 16; i++)
        {
            byte byte0 = abyte0[i];
            byte byte1 = abyte0[i];
            ac[i * 2] = HEXADECIMAL[(byte1 & 0xf0) >> 4];
            ac[i * 2 + 1] = HEXADECIMAL[byte0 & 0xf];
        }

        return new String(ac);
    }

    private String getQopVariantString()
    {
        if (qopVariant == 1)
        {
            return "auth-int";
        } else
        {
            return "auth";
        }
    }

    public String authenticate(Credentials credentials, String s, String s1)
        throws AuthenticationException
    {
        LOG.trace("enter DigestScheme.authenticate(Credentials, String, String)");
        UsernamePasswordCredentials usernamepasswordcredentials;
        try
        {
            usernamepasswordcredentials = (UsernamePasswordCredentials)credentials;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidCredentialsException("Credentials cannot be used for digest authentication: " + credentials.getClass().getName());
        }
        getParameters().put("methodname", s);
        getParameters().put("uri", s1);
        credentials = createDigest(usernamepasswordcredentials.getUserName(), usernamepasswordcredentials.getPassword());
        return "Digest " + createDigestHeader(usernamepasswordcredentials.getUserName(), credentials);
    }

    public String authenticate(Credentials credentials, HttpMethod httpmethod)
        throws AuthenticationException
    {
        LOG.trace("enter DigestScheme.authenticate(Credentials, HttpMethod)");
        UsernamePasswordCredentials usernamepasswordcredentials;
        String s;
        try
        {
            usernamepasswordcredentials = (UsernamePasswordCredentials)credentials;
        }
        // Misplaced declaration of an exception variable
        catch (HttpMethod httpmethod)
        {
            throw new InvalidCredentialsException("Credentials cannot be used for digest authentication: " + credentials.getClass().getName());
        }
        getParameters().put("methodname", httpmethod.getName());
        credentials = new StringBuffer(httpmethod.getPath());
        s = httpmethod.getQueryString();
        if (s != null)
        {
            if (s.indexOf("?") != 0)
            {
                credentials.append("?");
            }
            credentials.append(httpmethod.getQueryString());
        }
        getParameters().put("uri", credentials.toString());
        if (getParameter("charset") == null)
        {
            getParameters().put("charset", httpmethod.getParams().getCredentialCharset());
        }
        credentials = createDigest(usernamepasswordcredentials.getUserName(), usernamepasswordcredentials.getPassword());
        return "Digest " + createDigestHeader(usernamepasswordcredentials.getUserName(), credentials);
    }

    public String getID()
    {
        String s1 = getRealm();
        String s2 = getParameter("nonce");
        String s = s1;
        if (s2 != null)
        {
            s = s1 + "-" + s2;
        }
        return s;
    }

    public String getSchemeName()
    {
        return "digest";
    }

    public boolean isComplete()
    {
        if ("true".equalsIgnoreCase(getParameter("stale")))
        {
            return false;
        } else
        {
            return complete;
        }
    }

    public boolean isConnectionBased()
    {
        return false;
    }

    public void processChallenge(String s)
        throws MalformedChallengeException
    {
        boolean flag;
        boolean flag1;
        super.processChallenge(s);
        if (getParameter("realm") == null)
        {
            throw new MalformedChallengeException("missing realm in challange");
        }
        if (getParameter("nonce") == null)
        {
            throw new MalformedChallengeException("missing nonce in challange");
        }
        flag1 = false;
        flag = false;
        s = getParameter("qop");
        if (s == null) goto _L2; else goto _L1
_L1:
        s = new StringTokenizer(s, ",");
_L7:
        flag1 = flag;
        if (!s.hasMoreTokens()) goto _L2; else goto _L3
_L3:
        String s1 = s.nextToken().trim();
        if (!s1.equals("auth")) goto _L5; else goto _L4
_L4:
        qopVariant = 2;
        flag1 = flag;
_L2:
        if (flag1 && qopVariant == 0)
        {
            throw new MalformedChallengeException("None of the qop methods is supported");
        } else
        {
            cnonce = createCnonce();
            complete = true;
            return;
        }
_L5:
        if (s1.equals("auth-int"))
        {
            qopVariant = 1;
        } else
        {
            flag = true;
            LOG.warn("Unsupported qop detected: " + s1);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$auth$DigestScheme == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.DigestScheme");
            class$org$apache$commons$httpclient$auth$DigestScheme = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$DigestScheme;
        }
        LOG = LogFactory.getLog(class1);
    }
}
