// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.auth.params.AuthParams;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeaderValueFormatter;
import com.comcast.cim.httpcomponentsandroid.message.BasicNameValuePair;
import com.comcast.cim.httpcomponentsandroid.message.BufferedHeader;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.EncodingUtils;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.auth:
//            RFC2617Scheme, UnsupportedDigestAlgorithmException

public class DigestScheme extends RFC2617Scheme
{

    private static final char HEXADECIMAL[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme()
    {
        complete = false;
    }

    public static String createCnonce()
    {
        SecureRandom securerandom = new SecureRandom();
        byte abyte0[] = new byte[8];
        securerandom.nextBytes(abyte0);
        return encode(abyte0);
    }

    private Header createDigestHeader(Credentials credentials)
        throws AuthenticationException
    {
        String s;
        Object obj1;
        String s3;
        String s4;
        String s5;
        String s6;
        Object obj2;
        byte byte0;
        s4 = getParameter("uri");
        s5 = getParameter("realm");
        s6 = getParameter("nonce");
        s3 = getParameter("opaque");
        obj2 = getParameter("methodname");
        obj1 = getParameter("algorithm");
        if (s4 == null)
        {
            throw new IllegalStateException("URI may not be null");
        }
        if (s5 == null)
        {
            throw new IllegalStateException("Realm may not be null");
        }
        if (s6 == null)
        {
            throw new IllegalStateException("Nonce may not be null");
        }
        byte0 = -1;
        s = getParameter("qop");
        if (s == null) goto _L2; else goto _L1
_L1:
        int i;
label0:
        {
            StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
            do
            {
                i = byte0;
                if (!stringtokenizer.hasMoreTokens())
                {
                    break label0;
                }
            } while (!stringtokenizer.nextToken().trim().equals("auth"));
            i = 2;
        }
_L4:
        if (i == -1)
        {
            throw new AuthenticationException((new StringBuilder()).append("None of the qop methods is supported: ").append(s).toString());
        }
        break; /* Loop/switch isn't completed */
_L2:
        i = 0;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = "MD5";
        }
        String s1 = getParameter("charset");
        obj1 = s1;
        if (s1 == null)
        {
            obj1 = "ISO-8859-1";
        }
        String s2 = ((String) (obj));
        s1 = s2;
        if (s2.equalsIgnoreCase("MD5-sess"))
        {
            s1 = "MD5";
        }
        MessageDigest messagedigest;
        StringBuilder stringbuilder1;
        try
        {
            messagedigest = createMessageDigest(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Credentials credentials)
        {
            throw new AuthenticationException((new StringBuilder()).append("Unsuppported digest algorithm: ").append(s1).toString());
        }
        s2 = credentials.getUserPrincipal().getName();
        credentials = credentials.getPassword();
        if (s6.equals(lastNonce))
        {
            nounceCount = nounceCount + 1L;
        } else
        {
            nounceCount = 1L;
            cnonce = null;
            lastNonce = s6;
        }
        stringbuilder1 = new StringBuilder(256);
        (new Formatter(stringbuilder1, Locale.US)).format("%08x", new Object[] {
            Long.valueOf(nounceCount)
        });
        s1 = stringbuilder1.toString();
        if (cnonce == null)
        {
            cnonce = createCnonce();
        }
        a1 = null;
        a2 = null;
        if (((String) (obj)).equalsIgnoreCase("MD5-sess"))
        {
            stringbuilder1.setLength(0);
            stringbuilder1.append(s2).append(':').append(s5).append(':').append(credentials);
            credentials = encode(messagedigest.digest(EncodingUtils.getBytes(stringbuilder1.toString(), ((String) (obj1)))));
            stringbuilder1.setLength(0);
            stringbuilder1.append(credentials).append(':').append(s6).append(':').append(cnonce);
            a1 = stringbuilder1.toString();
        } else
        {
            stringbuilder1.setLength(0);
            stringbuilder1.append(s2).append(':').append(s5).append(':').append(credentials);
            a1 = stringbuilder1.toString();
        }
        credentials = encode(messagedigest.digest(EncodingUtils.getBytes(a1, ((String) (obj1)))));
        if (i == 2)
        {
            a2 = (new StringBuilder()).append(((String) (obj2))).append(':').append(s4).toString();
        } else
        {
            if (i == 1)
            {
                throw new AuthenticationException("qop-int method is not suppported");
            }
            a2 = (new StringBuilder()).append(((String) (obj2))).append(':').append(s4).toString();
        }
        obj1 = encode(messagedigest.digest(EncodingUtils.getBytes(a2, ((String) (obj1)))));
        if (i == 0)
        {
            stringbuilder1.setLength(0);
            stringbuilder1.append(credentials).append(':').append(s6).append(':').append(((String) (obj1)));
            credentials = stringbuilder1.toString();
        } else
        {
            stringbuilder1.setLength(0);
            StringBuilder stringbuilder = stringbuilder1.append(credentials).append(':').append(s6).append(':').append(s1).append(':').append(cnonce).append(':');
            if (i == 1)
            {
                credentials = "auth-int";
            } else
            {
                credentials = "auth";
            }
            stringbuilder.append(credentials).append(':').append(((String) (obj1)));
            credentials = stringbuilder1.toString();
        }
        credentials = encode(messagedigest.digest(EncodingUtils.getAsciiBytes(credentials)));
        obj1 = new CharArrayBuffer(128);
        if (isProxy())
        {
            ((CharArrayBuffer) (obj1)).append("Proxy-Authorization");
        } else
        {
            ((CharArrayBuffer) (obj1)).append("Authorization");
        }
        ((CharArrayBuffer) (obj1)).append(": Digest ");
        obj2 = new ArrayList(20);
        ((List) (obj2)).add(new BasicNameValuePair("username", s2));
        ((List) (obj2)).add(new BasicNameValuePair("realm", s5));
        ((List) (obj2)).add(new BasicNameValuePair("nonce", s6));
        ((List) (obj2)).add(new BasicNameValuePair("uri", s4));
        ((List) (obj2)).add(new BasicNameValuePair("response", credentials));
        if (i != 0)
        {
            if (i == 1)
            {
                credentials = "auth-int";
            } else
            {
                credentials = "auth";
            }
            ((List) (obj2)).add(new BasicNameValuePair("qop", credentials));
            ((List) (obj2)).add(new BasicNameValuePair("nc", s1));
            ((List) (obj2)).add(new BasicNameValuePair("cnonce", cnonce));
        }
        if (obj != null)
        {
            ((List) (obj2)).add(new BasicNameValuePair("algorithm", ((String) (obj))));
        }
        if (s3 != null)
        {
            ((List) (obj2)).add(new BasicNameValuePair("opaque", s3));
        }
        i = 0;
        while (i < ((List) (obj2)).size()) 
        {
            credentials = (BasicNameValuePair)((List) (obj2)).get(i);
            if (i > 0)
            {
                ((CharArrayBuffer) (obj1)).append(", ");
            }
            boolean flag;
            boolean flag1;
            if ("nc".equals(credentials.getName()) || "qop".equals(credentials.getName()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = BasicHeaderValueFormatter.DEFAULT;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((BasicHeaderValueFormatter) (obj)).formatNameValuePair(((CharArrayBuffer) (obj1)), credentials, flag1);
            i++;
        }
        return new BufferedHeader(((CharArrayBuffer) (obj1)));
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

    private static String encode(byte abyte0[])
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
        if (credentials == null)
        {
            throw new IllegalArgumentException("Credentials may not be null");
        }
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        getParameters().put("methodname", httprequest.getRequestLine().getMethod());
        getParameters().put("uri", httprequest.getRequestLine().getUri());
        if (getParameter("charset") == null)
        {
            httprequest = AuthParams.getCredentialCharset(httprequest.getParams());
            getParameters().put("charset", httprequest);
        }
        return createDigestHeader(credentials);
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

    public void processChallenge(Header header)
        throws MalformedChallengeException
    {
        super.processChallenge(header);
        if (getParameter("realm") == null)
        {
            throw new MalformedChallengeException("missing realm in challenge");
        }
        if (getParameter("nonce") == null)
        {
            throw new MalformedChallengeException("missing nonce in challenge");
        } else
        {
            complete = true;
            return;
        }
    }

}
