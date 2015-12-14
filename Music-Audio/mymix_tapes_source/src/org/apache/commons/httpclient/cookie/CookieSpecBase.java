// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieSpec, MalformedCookieException

public class CookieSpecBase
    implements CookieSpec
{

    protected static final Log LOG;
    static Class class$org$apache$commons$httpclient$cookie$CookieSpec;
    private Collection datepatterns;

    public CookieSpecBase()
    {
        datepatterns = null;
    }

    private static void addInPathOrder(List list, Cookie cookie)
    {
        int i = 0;
        do
        {
            if (i >= list.size() || cookie.compare(cookie, (Cookie)list.get(i)) > 0)
            {
                list.add(i, cookie);
                return;
            }
            i++;
        } while (true);
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

    public boolean domainMatch(String s, String s1)
    {
        if (!s.equals(s1))
        {
            String s2 = s1;
            if (!s1.startsWith("."))
            {
                s2 = "." + s1;
            }
            if (!s.endsWith(s2) && !s.equals(s2.substring(1)))
            {
                return false;
            }
        }
        return true;
    }

    public String formatCookie(Cookie cookie)
    {
        LOG.trace("enter CookieSpecBase.formatCookie(Cookie)");
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(cookie.getName());
        stringbuffer.append("=");
        cookie = cookie.getValue();
        if (cookie != null)
        {
            stringbuffer.append(cookie);
        }
        return stringbuffer.toString();
    }

    public Header formatCookieHeader(Cookie cookie)
    {
        LOG.trace("enter CookieSpecBase.formatCookieHeader(Cookie)");
        return new Header("Cookie", formatCookie(cookie));
    }

    public Header formatCookieHeader(Cookie acookie[])
    {
        LOG.trace("enter CookieSpecBase.formatCookieHeader(Cookie[])");
        return new Header("Cookie", formatCookies(acookie));
    }

    public String formatCookies(Cookie acookie[])
        throws IllegalArgumentException
    {
        LOG.trace("enter CookieSpecBase.formatCookies(Cookie[])");
        if (acookie == null)
        {
            throw new IllegalArgumentException("Cookie array may not be null");
        }
        if (acookie.length == 0)
        {
            throw new IllegalArgumentException("Cookie array may not be empty");
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < acookie.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append("; ");
            }
            stringbuffer.append(formatCookie(acookie[i]));
        }

        return stringbuffer.toString();
    }

    public Collection getValidDateFormats()
    {
        return datepatterns;
    }

    public boolean match(String s, int i, String s1, boolean flag, Cookie cookie)
    {
        LOG.trace("enter CookieSpecBase.match(String, int, String, boolean, Cookie");
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
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        String s2 = s1;
        if (s1.trim().equals(""))
        {
            s2 = "/";
        }
        s = s.toLowerCase();
        if (cookie.getDomain() == null)
        {
            LOG.warn("Invalid cookie state: domain not specified");
        } else
        {
            if (cookie.getPath() == null)
            {
                LOG.warn("Invalid cookie state: path not specified");
                return false;
            }
            if ((cookie.getExpiryDate() == null || cookie.getExpiryDate().after(new Date())) && domainMatch(s, cookie.getDomain()) && pathMatch(s2, cookie.getPath()) && (!cookie.getSecure() || flag))
            {
                return true;
            }
        }
        return false;
    }

    public Cookie[] match(String s, int i, String s1, boolean flag, Cookie acookie[])
    {
        LOG.trace("enter CookieSpecBase.match(String, int, String, boolean, Cookie[])");
        if (acookie == null)
        {
            return null;
        }
        LinkedList linkedlist = new LinkedList();
        for (int j = 0; j < acookie.length; j++)
        {
            if (match(s, i, s1, flag, acookie[j]))
            {
                addInPathOrder(linkedlist, acookie[j]);
            }
        }

        return (Cookie[])(Cookie[])linkedlist.toArray(new Cookie[linkedlist.size()]);
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, String s2)
        throws MalformedCookieException
    {
        String s4;
        int j;
        int l;
        LOG.trace("enter CookieSpecBase.parse(String, port, path, boolean, Header)");
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
        s4 = s.toLowerCase();
        j = s3.lastIndexOf("/");
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
        j = 0;
        int k = s2.toLowerCase().indexOf("expires=");
        i = j;
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        l = k + "expires=".length();
        k = s2.indexOf(";", l);
        i = k;
        if (k == -1)
        {
            i = s2.length();
        }
        DateUtil.parseDate(s2.substring(l, i), datepatterns);
        i = 1;
_L2:
        if (i != 0)
        {
            s1 = new HeaderElement[1];
            s1[0] = new HeaderElement(s2.toCharArray());
        } else
        {
            s1 = HeaderElement.parseElements(s2.toCharArray());
        }
        s2 = new Cookie[s1.length];
        for (i = 0; i < s1.length; i++)
        {
            HeaderElement headerelement = s1[i];
            Cookie cookie;
            NameValuePair anamevaluepair[];
            try
            {
                cookie = new Cookie(s4, headerelement.getName(), headerelement.getValue(), s, null, false);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new MalformedCookieException(s.getMessage());
            }
            anamevaluepair = headerelement.getParameters();
            if (anamevaluepair != null)
            {
                for (j = 0; j < anamevaluepair.length; j++)
                {
                    parseAttribute(anamevaluepair[j], cookie);
                }

            }
            s2[i] = cookie;
        }

        return s2;
        s1;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, Header header)
        throws MalformedCookieException
    {
        LOG.trace("enter CookieSpecBase.parse(String, port, path, boolean, String)");
        if (header == null)
        {
            throw new IllegalArgumentException("Header may not be null.");
        } else
        {
            return parse(s, i, s1, flag, header.getValue());
        }
    }

    public void parseAttribute(NameValuePair namevaluepair, Cookie cookie)
        throws MalformedCookieException
    {
        String s;
        String s1;
        if (namevaluepair == null)
        {
            throw new IllegalArgumentException("Attribute may not be null.");
        }
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
        s1 = namevaluepair.getName().toLowerCase();
        s = namevaluepair.getValue();
        if (!s1.equals("path")) goto _L2; else goto _L1
_L1:
label0:
        {
            if (s != null)
            {
                namevaluepair = s;
                if (!s.trim().equals(""))
                {
                    break label0;
                }
            }
            namevaluepair = "/";
        }
        cookie.setPath(namevaluepair);
        cookie.setPathAttributeSpecified(true);
_L4:
        return;
_L2:
        if (s1.equals("domain"))
        {
            if (s == null)
            {
                throw new MalformedCookieException("Missing value for domain attribute");
            }
            if (s.trim().equals(""))
            {
                throw new MalformedCookieException("Blank value for domain attribute");
            } else
            {
                cookie.setDomain(s);
                cookie.setDomainAttributeSpecified(true);
                return;
            }
        }
        if (s1.equals("max-age"))
        {
            if (s == null)
            {
                throw new MalformedCookieException("Missing value for max-age attribute");
            }
            int i;
            try
            {
                i = Integer.parseInt(s);
            }
            // Misplaced declaration of an exception variable
            catch (NameValuePair namevaluepair)
            {
                throw new MalformedCookieException("Invalid max-age attribute: " + namevaluepair.getMessage());
            }
            cookie.setExpiryDate(new Date(System.currentTimeMillis() + (long)i * 1000L));
            return;
        }
        if (s1.equals("secure"))
        {
            cookie.setSecure(true);
            return;
        }
        if (s1.equals("comment"))
        {
            cookie.setComment(s);
            return;
        }
        if (s1.equals("expires"))
        {
            if (s == null)
            {
                throw new MalformedCookieException("Missing value for expires attribute");
            }
            try
            {
                cookie.setExpiryDate(DateUtil.parseDate(s, datepatterns));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NameValuePair namevaluepair)
            {
                LOG.debug("Error parsing cookie date", namevaluepair);
            }
            throw new MalformedCookieException("Unable to parse expiration date parameter: " + s);
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Unrecognized cookie attribute: " + namevaluepair.toString());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean pathMatch(String s, String s1)
    {
label0:
        {
            boolean flag1 = s.startsWith(s1);
            boolean flag = flag1;
            if (flag1)
            {
                flag = flag1;
                if (s.length() != s1.length())
                {
                    flag = flag1;
                    if (!s1.endsWith("/"))
                    {
                        if (s.charAt(s1.length()) != CookieSpec.PATH_DELIM_CHAR)
                        {
                            break label0;
                        }
                        flag = true;
                    }
                }
            }
            return flag;
        }
        return false;
    }

    public void setValidDateFormats(Collection collection)
    {
        datepatterns = collection;
    }

    public void validate(String s, int i, String s1, boolean flag, Cookie cookie)
        throws MalformedCookieException
    {
        LOG.trace("enter CookieSpecBase.validate(String, port, path, boolean, Cookie)");
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
        String s2 = s1;
        if (s1.trim().equals(""))
        {
            s2 = "/";
        }
        String s3 = s.toLowerCase();
        if (cookie.getVersion() < 0)
        {
            throw new MalformedCookieException("Illegal version number " + cookie.getValue());
        }
        if (s3.indexOf(".") >= 0)
        {
            if (!s3.endsWith(cookie.getDomain()))
            {
                s1 = cookie.getDomain();
                s = s1;
                if (s1.startsWith("."))
                {
                    s = s1.substring(1, s1.length());
                }
                if (!s3.equals(s))
                {
                    throw new MalformedCookieException("Illegal domain attribute \"" + cookie.getDomain() + "\". Domain of origin: \"" + s3 + "\"");
                }
            }
        } else
        if (!s3.equals(cookie.getDomain()))
        {
            throw new MalformedCookieException("Illegal domain attribute \"" + cookie.getDomain() + "\". Domain of origin: \"" + s3 + "\"");
        }
        if (!s2.startsWith(cookie.getPath()))
        {
            throw new MalformedCookieException("Illegal path attribute \"" + cookie.getPath() + "\". Path of origin: \"" + s2 + "\"");
        } else
        {
            return;
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$cookie$CookieSpec == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.CookieSpec");
            class$org$apache$commons$httpclient$cookie$CookieSpec = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$CookieSpec;
        }
        LOG = LogFactory.getLog(class1);
    }
}
