// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieSpecBase, MalformedCookieException

public class NetscapeDraftSpec extends CookieSpecBase
{

    public NetscapeDraftSpec()
    {
    }

    private static boolean isSpecialDomain(String s)
    {
        s = s.toUpperCase();
        return s.endsWith(".COM") || s.endsWith(".EDU") || s.endsWith(".NET") || s.endsWith(".GOV") || s.endsWith(".MIL") || s.endsWith(".ORG") || s.endsWith(".INT");
    }

    public boolean domainMatch(String s, String s1)
    {
        return s.endsWith(s1);
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, String s2)
        throws MalformedCookieException
    {
        LOG.trace("enter NetscapeDraftSpec.parse(String, port, path, boolean, Header)");
        if (s == null)
        {
            throw new IllegalArgumentException("Host of origin may not be null");
        }
        if (s.trim().equals(""))
        {
            throw new IllegalArgumentException("Host of origin may not be blank");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("Invalid port: " + i);
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Path of origin may not be null.");
        }
        if (s2 == null)
        {
            throw new IllegalArgumentException("Header may not be null.");
        }
        String s3 = s1;
        if (s1.trim().equals(""))
        {
            s3 = "/";
        }
        s1 = s.toLowerCase();
        int j = s3.lastIndexOf("/");
        s = s3;
        if (j >= 0)
        {
            i = j;
            if (j == 0)
            {
                i = 1;
            }
            s = s3.substring(0, i);
        }
        s2 = new HeaderElement(s2.toCharArray());
        s = new Cookie(s1, s2.getName(), s2.getValue(), s, null, false);
        s1 = s2.getParameters();
        if (s1 != null)
        {
            for (i = 0; i < s1.length; i++)
            {
                parseAttribute(s1[i], s);
            }

        }
        return (new Cookie[] {
            s
        });
    }

    public void parseAttribute(NameValuePair namevaluepair, Cookie cookie)
        throws MalformedCookieException
    {
        if (namevaluepair == null)
        {
            throw new IllegalArgumentException("Attribute may not be null.");
        }
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
        String s = namevaluepair.getName().toLowerCase();
        String s1 = namevaluepair.getValue();
        if (s.equals("expires"))
        {
            if (s1 == null)
            {
                throw new MalformedCookieException("Missing value for expires attribute");
            }
            try
            {
                cookie.setExpiryDate((new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z", Locale.US)).parse(s1));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NameValuePair namevaluepair)
            {
                throw new MalformedCookieException("Invalid expires attribute: " + namevaluepair.getMessage());
            }
        } else
        {
            super.parseAttribute(namevaluepair, cookie);
            return;
        }
    }

    public void validate(String s, int i, String s1, boolean flag, Cookie cookie)
        throws MalformedCookieException
    {
        LOG.trace("enterNetscapeDraftCookieProcessor RCF2109CookieProcessor.validate(Cookie)");
        super.validate(s, i, s1, flag, cookie);
        if (s.indexOf(".") >= 0)
        {
            i = (new StringTokenizer(cookie.getDomain(), ".")).countTokens();
            if (isSpecialDomain(cookie.getDomain()))
            {
                if (i < 2)
                {
                    throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates the Netscape cookie specification for " + "special domains");
                }
            } else
            if (i < 3)
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates the Netscape cookie specification");
            }
        }
    }
}
