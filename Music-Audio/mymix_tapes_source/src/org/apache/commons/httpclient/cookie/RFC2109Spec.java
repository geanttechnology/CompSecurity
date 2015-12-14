// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterFormatter;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieSpecBase, MalformedCookieException

public class RFC2109Spec extends CookieSpecBase
{

    public static final String SET_COOKIE_KEY = "set-cookie";
    private final ParameterFormatter formatter = new ParameterFormatter();

    public RFC2109Spec()
    {
        formatter.setAlwaysUseQuotes(true);
    }

    private void formatCookieAsVer(StringBuffer stringbuffer, Cookie cookie, int i)
    {
        String s1 = cookie.getValue();
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        formatParam(stringbuffer, new NameValuePair(cookie.getName(), s), i);
        if (cookie.getPath() != null && cookie.isPathAttributeSpecified())
        {
            stringbuffer.append("; ");
            formatParam(stringbuffer, new NameValuePair("$Path", cookie.getPath()), i);
        }
        if (cookie.getDomain() != null && cookie.isDomainAttributeSpecified())
        {
            stringbuffer.append("; ");
            formatParam(stringbuffer, new NameValuePair("$Domain", cookie.getDomain()), i);
        }
    }

    private void formatParam(StringBuffer stringbuffer, NameValuePair namevaluepair, int i)
    {
        if (i < 1)
        {
            stringbuffer.append(namevaluepair.getName());
            stringbuffer.append("=");
            if (namevaluepair.getValue() != null)
            {
                stringbuffer.append(namevaluepair.getValue());
            }
            return;
        } else
        {
            formatter.format(stringbuffer, namevaluepair);
            return;
        }
    }

    public boolean domainMatch(String s, String s1)
    {
        return s.equals(s1) || s1.startsWith(".") && s.endsWith(s1);
    }

    public String formatCookie(Cookie cookie)
    {
        LOG.trace("enter RFC2109Spec.formatCookie(Cookie)");
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        } else
        {
            int i = cookie.getVersion();
            StringBuffer stringbuffer = new StringBuffer();
            formatParam(stringbuffer, new NameValuePair("$Version", Integer.toString(i)), i);
            stringbuffer.append("; ");
            formatCookieAsVer(stringbuffer, cookie, i);
            return stringbuffer.toString();
        }
    }

    public String formatCookies(Cookie acookie[])
    {
        LOG.trace("enter RFC2109Spec.formatCookieHeader(Cookie[])");
        int i = 0x7fffffff;
        for (int j = 0; j < acookie.length;)
        {
            Cookie cookie = acookie[j];
            int l = i;
            if (cookie.getVersion() < i)
            {
                l = cookie.getVersion();
            }
            j++;
            i = l;
        }

        StringBuffer stringbuffer = new StringBuffer();
        formatParam(stringbuffer, new NameValuePair("$Version", Integer.toString(i)), i);
        for (int k = 0; k < acookie.length; k++)
        {
            stringbuffer.append("; ");
            formatCookieAsVer(stringbuffer, acookie[k], i);
        }

        return stringbuffer.toString();
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
        if (s.equals("path"))
        {
            if (s1 == null)
            {
                throw new MalformedCookieException("Missing value for path attribute");
            }
            if (s1.trim().equals(""))
            {
                throw new MalformedCookieException("Blank value for path attribute");
            } else
            {
                cookie.setPath(s1);
                cookie.setPathAttributeSpecified(true);
                return;
            }
        }
        if (s.equals("version"))
        {
            if (s1 == null)
            {
                throw new MalformedCookieException("Missing value for version attribute");
            }
            try
            {
                cookie.setVersion(Integer.parseInt(s1));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NameValuePair namevaluepair)
            {
                throw new MalformedCookieException("Invalid version: " + namevaluepair.getMessage());
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
        LOG.trace("enter RFC2109Spec.validate(String, int, String, boolean, Cookie)");
        super.validate(s, i, s1, flag, cookie);
        if (cookie.getName().indexOf(' ') != -1)
        {
            throw new MalformedCookieException("Cookie name may not contain blanks");
        }
        if (cookie.getName().startsWith("$"))
        {
            throw new MalformedCookieException("Cookie name may not start with $");
        }
        if (cookie.isDomainAttributeSpecified() && !cookie.getDomain().equals(s))
        {
            if (!cookie.getDomain().startsWith("."))
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
            }
            i = cookie.getDomain().indexOf('.', 1);
            if (i < 0 || i == cookie.getDomain().length() - 1)
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must contain an embedded dot");
            }
            s = s.toLowerCase();
            if (!s.endsWith(cookie.getDomain()))
            {
                throw new MalformedCookieException("Illegal domain attribute \"" + cookie.getDomain() + "\". Domain of origin: \"" + s + "\"");
            }
            if (s.substring(0, s.length() - cookie.getDomain().length()).indexOf('.') != -1)
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: host minus domain may not contain any dots");
            }
        }
    }
}
