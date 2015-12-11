// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            RFC2617Scheme, UnsupportedDigestAlgorithmException, HttpEntityDigester

public class DigestScheme extends RFC2617Scheme
{

    private static final char HEXADECIMAL[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme()
    {
        this(Consts.ASCII);
    }

    public DigestScheme(ChallengeState challengestate)
    {
        super(challengestate);
    }

    public DigestScheme(Charset charset)
    {
        super(charset);
        complete = false;
    }

    public static String createCnonce()
    {
        SecureRandom securerandom = new SecureRandom();
        byte abyte0[] = new byte[8];
        securerandom.nextBytes(abyte0);
        return encode(abyte0);
    }

    private Header createDigestHeader(Credentials credentials, HttpRequest httprequest)
        throws AuthenticationException
    {
        Object obj;
        String s;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        HashSet hashset;
        int i;
        s3 = getParameter("uri");
        s4 = getParameter("realm");
        s5 = getParameter("nonce");
        s2 = getParameter("opaque");
        s6 = getParameter("methodname");
        s = getParameter("algorithm");
        obj = s;
        if (s == null)
        {
            obj = "MD5";
        }
        hashset = new HashSet(8);
        i = -1;
        s = getParameter("qop");
        if (s == null) goto _L2; else goto _L1
_L1:
        for (StringTokenizer stringtokenizer = new StringTokenizer(s, ","); stringtokenizer.hasMoreTokens(); hashset.add(stringtokenizer.nextToken().trim().toLowerCase(Locale.ENGLISH))) { }
        if (!(httprequest instanceof HttpEntityEnclosingRequest) || !hashset.contains("auth-int")) goto _L4; else goto _L3
_L3:
        i = 1;
_L6:
        if (i == -1)
        {
            throw new AuthenticationException((new StringBuilder()).append("None of the qop methods is supported: ").append(s).toString());
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (hashset.contains("auth"))
        {
            i = 2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L6; else goto _L5
_L5:
        Object obj2;
        StringBuilder stringbuilder1;
        String s7;
        obj2 = getParameter("charset");
        Object obj1 = obj2;
        if (obj2 == null)
        {
            obj1 = "ISO-8859-1";
        }
        String s1 = ((String) (obj));
        obj2 = s1;
        if (s1.equalsIgnoreCase("MD5-sess"))
        {
            obj2 = "MD5";
        }
        MessageDigest messagedigest;
        try
        {
            messagedigest = createMessageDigest(((String) (obj2)));
        }
        // Misplaced declaration of an exception variable
        catch (Credentials credentials)
        {
            throw new AuthenticationException((new StringBuilder()).append("Unsuppported digest algorithm: ").append(((String) (obj2))).toString());
        }
        s1 = credentials.getUserPrincipal().getName();
        credentials = credentials.getPassword();
        if (s5.equals(lastNonce))
        {
            nounceCount = nounceCount + 1L;
        } else
        {
            nounceCount = 1L;
            cnonce = null;
            lastNonce = s5;
        }
        stringbuilder1 = new StringBuilder(256);
        obj2 = new Formatter(stringbuilder1, Locale.US);
        ((Formatter) (obj2)).format("%08x", new Object[] {
            Long.valueOf(nounceCount)
        });
        ((Formatter) (obj2)).close();
        obj2 = stringbuilder1.toString();
        if (cnonce == null)
        {
            cnonce = createCnonce();
        }
        a1 = null;
        a2 = null;
        if (((String) (obj)).equalsIgnoreCase("MD5-sess"))
        {
            stringbuilder1.setLength(0);
            stringbuilder1.append(s1).append(':').append(s4).append(':').append(credentials);
            credentials = encode(messagedigest.digest(EncodingUtils.getBytes(stringbuilder1.toString(), ((String) (obj1)))));
            stringbuilder1.setLength(0);
            stringbuilder1.append(credentials).append(':').append(s5).append(':').append(cnonce);
            a1 = stringbuilder1.toString();
        } else
        {
            stringbuilder1.setLength(0);
            stringbuilder1.append(s1).append(':').append(s4).append(':').append(credentials);
            a1 = stringbuilder1.toString();
        }
        s7 = encode(messagedigest.digest(EncodingUtils.getBytes(a1, ((String) (obj1)))));
        if (i == 2)
        {
            a2 = (new StringBuilder()).append(s6).append(':').append(s3).toString();
            break MISSING_BLOCK_LABEL_546;
        }
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_1257;
        }
        credentials = null;
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            credentials = ((HttpEntityEnclosingRequest)httprequest).getEntity();
        }
        if (credentials != null && !credentials.isRepeatable())
        {
            if (hashset.contains("auth"))
            {
                i = 2;
                a2 = (new StringBuilder()).append(s6).append(':').append(s3).toString();
            } else
            {
                throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
            }
            continue;
        }
        httprequest = new HttpEntityDigester(messagedigest);
        if (credentials == null)
        {
            break MISSING_BLOCK_LABEL_1193;
        }
        credentials.writeTo(httprequest);
        httprequest.close();
        a2 = (new StringBuilder()).append(s6).append(':').append(s3).append(':').append(encode(httprequest.getDigest())).toString();
        continue;
        credentials;
        throw new AuthenticationException("I/O error reading entity content", credentials);
        a2 = (new StringBuilder()).append(s6).append(':').append(s3).toString();
        continue;
        do
        {
            httprequest = encode(messagedigest.digest(EncodingUtils.getBytes(a2, ((String) (obj1)))));
            if (i == 0)
            {
                stringbuilder1.setLength(0);
                stringbuilder1.append(s7).append(':').append(s5).append(':').append(httprequest);
                credentials = stringbuilder1.toString();
            } else
            {
                stringbuilder1.setLength(0);
                StringBuilder stringbuilder = stringbuilder1.append(s7).append(':').append(s5).append(':').append(((String) (obj2))).append(':').append(cnonce).append(':');
                if (i == 1)
                {
                    credentials = "auth-int";
                } else
                {
                    credentials = "auth";
                }
                stringbuilder.append(credentials).append(':').append(httprequest);
                credentials = stringbuilder1.toString();
            }
            credentials = encode(messagedigest.digest(EncodingUtils.getAsciiBytes(credentials)));
            httprequest = new CharArrayBuffer(128);
            if (isProxy())
            {
                httprequest.append("Proxy-Authorization");
            } else
            {
                httprequest.append("Authorization");
            }
            httprequest.append(": Digest ");
            obj1 = new ArrayList(20);
            ((List) (obj1)).add(new BasicNameValuePair("username", s1));
            ((List) (obj1)).add(new BasicNameValuePair("realm", s4));
            ((List) (obj1)).add(new BasicNameValuePair("nonce", s5));
            ((List) (obj1)).add(new BasicNameValuePair("uri", s3));
            ((List) (obj1)).add(new BasicNameValuePair("response", credentials));
            if (i != 0)
            {
                if (i == 1)
                {
                    credentials = "auth-int";
                } else
                {
                    credentials = "auth";
                }
                ((List) (obj1)).add(new BasicNameValuePair("qop", credentials));
                ((List) (obj1)).add(new BasicNameValuePair("nc", ((String) (obj2))));
                ((List) (obj1)).add(new BasicNameValuePair("cnonce", cnonce));
            }
            ((List) (obj1)).add(new BasicNameValuePair("algorithm", ((String) (obj))));
            if (s2 != null)
            {
                ((List) (obj1)).add(new BasicNameValuePair("opaque", s2));
            }
            i = 0;
            while (i < ((List) (obj1)).size()) 
            {
                credentials = (BasicNameValuePair)((List) (obj1)).get(i);
                if (i > 0)
                {
                    httprequest.append(", ");
                }
                obj = credentials.getName();
                boolean flag;
                boolean flag1;
                if ("nc".equals(obj) || "qop".equals(obj) || "algorithm".equals(obj))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj = BasicHeaderValueFormatter.INSTANCE;
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ((BasicHeaderValueFormatter) (obj)).formatNameValuePair(httprequest, credentials, flag1);
                i++;
            }
            return new BufferedHeader(httprequest);
        } while (true);
    }

    private static MessageDigest createMessageDigest(String s)
        throws UnsupportedDigestAlgorithmException
    {
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance(s);
        }
        catch (Exception exception)
        {
            throw new UnsupportedDigestAlgorithmException((new StringBuilder()).append("Unsupported algorithm in HTTP Digest authentication: ").append(s).toString());
        }
        return messagedigest;
    }

    static String encode(byte abyte0[])
    {
        int j = abyte0.length;
        char ac[] = new char[j * 2];
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            byte byte1 = abyte0[i];
            ac[i * 2] = HEXADECIMAL[(byte1 & 0xf0) >> 4];
            ac[i * 2 + 1] = HEXADECIMAL[byte0 & 0xf];
        }

        return new String(ac);
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
        if (getParameter("realm") == null)
        {
            throw new AuthenticationException("missing realm in challenge");
        }
        if (getParameter("nonce") == null)
        {
            throw new AuthenticationException("missing nonce in challenge");
        }
        getParameters().put("methodname", httprequest.getRequestLine().getMethod());
        getParameters().put("uri", httprequest.getRequestLine().getUri());
        if (getParameter("charset") == null)
        {
            getParameters().put("charset", getCredentialsCharset(httprequest));
        }
        return createDigestHeader(credentials, httprequest);
    }

    String getA1()
    {
        return a1;
    }

    String getA2()
    {
        return a2;
    }

    String getCnonce()
    {
        return cnonce;
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

    public void overrideParamter(String s, String s1)
    {
        getParameters().put(s, s1);
    }

    public void processChallenge(Header header)
        throws MalformedChallengeException
    {
        super.processChallenge(header);
        complete = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("DIGEST [complete=").append(complete).append(", nonce=").append(lastNonce).append(", nc=").append(nounceCount).append("]");
        return stringbuilder.toString();
    }

}
