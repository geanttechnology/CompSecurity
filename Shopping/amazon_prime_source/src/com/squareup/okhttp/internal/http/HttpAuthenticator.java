// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.OkAuthenticator;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Headers, HeaderParser, Response, Request

public final class HttpAuthenticator
{

    public static final OkAuthenticator SYSTEM_DEFAULT = new OkAuthenticator() {

        private InetAddress getConnectToInetAddress(Proxy proxy, URL url)
            throws IOException
        {
            if (proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT)
            {
                return ((InetSocketAddress)proxy.address()).getAddress();
            } else
            {
                return InetAddress.getByName(url.getHost());
            }
        }

        public com.squareup.okhttp.OkAuthenticator.Credential authenticate(Proxy proxy, URL url, List list)
            throws IOException
        {
            int i;
            int j;
            i = 0;
            j = list.size();
_L2:
            Object obj;
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_116;
            }
            obj = (com.squareup.okhttp.OkAuthenticator.Challenge)list.get(i);
            if ("Basic".equalsIgnoreCase(((com.squareup.okhttp.OkAuthenticator.Challenge) (obj)).getScheme()))
            {
                break; /* Loop/switch isn't completed */
            }
_L4:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if ((obj = Authenticator.requestPasswordAuthentication(url.getHost(), getConnectToInetAddress(proxy, url), url.getPort(), url.getProtocol(), ((com.squareup.okhttp.OkAuthenticator.Challenge) (obj)).getRealm(), ((com.squareup.okhttp.OkAuthenticator.Challenge) (obj)).getScheme(), url, java.net.Authenticator.RequestorType.SERVER)) == null) goto _L4; else goto _L3
_L3:
            return com.squareup.okhttp.OkAuthenticator.Credential.basic(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
            return null;
        }

        public com.squareup.okhttp.OkAuthenticator.Credential authenticateProxy(Proxy proxy, URL url, List list)
            throws IOException
        {
            int i;
            int j;
            i = 0;
            j = list.size();
_L2:
            Object obj;
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_127;
            }
            obj = (com.squareup.okhttp.OkAuthenticator.Challenge)list.get(i);
            if ("Basic".equalsIgnoreCase(((com.squareup.okhttp.OkAuthenticator.Challenge) (obj)).getScheme()))
            {
                break; /* Loop/switch isn't completed */
            }
_L4:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy.address();
            obj = Authenticator.requestPasswordAuthentication(inetsocketaddress.getHostName(), getConnectToInetAddress(proxy, url), inetsocketaddress.getPort(), url.getProtocol(), ((com.squareup.okhttp.OkAuthenticator.Challenge) (obj)).getRealm(), ((com.squareup.okhttp.OkAuthenticator.Challenge) (obj)).getScheme(), url, java.net.Authenticator.RequestorType.PROXY);
            if (obj == null) goto _L4; else goto _L3
_L3:
            return com.squareup.okhttp.OkAuthenticator.Credential.basic(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
            return null;
        }

    };

    private HttpAuthenticator()
    {
    }

    private static List parseChallenges(Headers headers, String s)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L2:
        if (i >= headers.size())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (s.equalsIgnoreCase(headers.name(i)))
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s1;
        int j;
        s1 = headers.value(i);
        j = 0;
_L6:
        if (j >= s1.length()) goto _L4; else goto _L3
_L3:
        String s2;
        int k = HeaderParser.skipUntil(s1, j, " ");
        s2 = s1.substring(j, k).trim();
        j = HeaderParser.skipWhitespace(s1, k);
        if (!s1.regionMatches(true, j, "realm=\"", 0, "realm=\"".length())) goto _L4; else goto _L5
_L5:
        j += "realm=\"".length();
        int l = HeaderParser.skipUntil(s1, j, "\"");
        String s3 = s1.substring(j, l);
        j = HeaderParser.skipWhitespace(s1, HeaderParser.skipUntil(s1, l + 1, ",") + 1);
        arraylist.add(new com.squareup.okhttp.OkAuthenticator.Challenge(s2, s3));
          goto _L6
        return arraylist;
    }

    public static Request processAuthHeader(OkAuthenticator okauthenticator, Response response, Proxy proxy)
        throws IOException
    {
        String s;
        String s1;
        List list;
        if (response.code() == 401)
        {
            s1 = "WWW-Authenticate";
            s = "Authorization";
        } else
        if (response.code() == 407)
        {
            s1 = "Proxy-Authenticate";
            s = "Proxy-Authorization";
        } else
        {
            throw new IllegalArgumentException();
        }
        list = parseChallenges(response.headers(), s1);
        if (!list.isEmpty())
        {
            Request request = response.request();
            if (response.code() == 407)
            {
                okauthenticator = okauthenticator.authenticateProxy(proxy, request.url(), list);
            } else
            {
                okauthenticator = okauthenticator.authenticate(proxy, request.url(), list);
            }
            if (okauthenticator != null)
            {
                return request.newBuilder().header(s, okauthenticator.getHeaderValue()).build();
            }
        }
        return null;
    }

}
