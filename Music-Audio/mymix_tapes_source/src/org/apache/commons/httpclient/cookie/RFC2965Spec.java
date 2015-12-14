// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterFormatter;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieSpecBase, CookieVersionSupport, CookiePathComparator, RFC2109Spec, 
//            MalformedCookieException, Cookie2, CookieAttributeHandler, CookieSpec, 
//            CookieOrigin

public class RFC2965Spec extends CookieSpecBase
    implements CookieVersionSupport
{
    private class Cookie2DomainAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            cookieorigin = cookieorigin.getHost().toLowerCase();
            for (cookie = cookie.getDomain(); !domainMatch(cookieorigin, cookie) || cookieorigin.substring(0, cookieorigin.length() - cookie.length()).indexOf('.') != -1;)
            {
                return false;
            }

            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (s == null)
            {
                throw new MalformedCookieException("Missing value for domain attribute");
            }
            if (s.trim().equals(""))
            {
                throw new MalformedCookieException("Blank value for domain attribute");
            }
            String s1 = s.toLowerCase();
            s = s1;
            if (!s1.startsWith("."))
            {
                s = "." + s1;
            }
            cookie.setDomain(s);
            cookie.setDomainAttributeSpecified(true);
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            cookieorigin = cookieorigin.getHost().toLowerCase();
            if (cookie.getDomain() == null)
            {
                throw new MalformedCookieException("Invalid cookie state: domain not specified");
            }
            String s = cookie.getDomain().toLowerCase();
            if (cookie.isDomainAttributeSpecified())
            {
                if (!s.startsWith("."))
                {
                    throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
                }
                int i = s.indexOf('.', 1);
                if ((i < 0 || i == s.length() - 1) && !s.equals(".local"))
                {
                    throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
                }
                if (!domainMatch(cookieorigin, s))
                {
                    throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
                }
                if (cookieorigin.substring(0, cookieorigin.length() - s.length()).indexOf('.') != -1)
                {
                    throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
                }
            } else
            if (!cookie.getDomain().equals(cookieorigin))
            {
                throw new MalformedCookieException("Illegal domain attribute: \"" + cookie.getDomain() + "\"." + "Domain of origin: \"" + cookieorigin + "\"");
            }
        }

        private Cookie2DomainAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class Cookie2MaxageAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
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
            catch (String s)
            {
                i = -1;
            }
            if (i < 0)
            {
                throw new MalformedCookieException("Invalid max-age attribute.");
            } else
            {
                cookie.setExpiryDate(new Date(System.currentTimeMillis() + (long)i * 1000L));
                return;
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
        {
        }

        private Cookie2MaxageAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class Cookie2PathAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            String s = cookieorigin.getPath();
            if (cookie.getPath() == null)
            {
                CookieSpecBase.LOG.warn("Invalid cookie state: path attribute is null.");
            } else
            {
                cookieorigin = s;
                if (s.trim().equals(""))
                {
                    cookieorigin = "/";
                }
                if (pathMatch(cookieorigin, cookie.getPath()))
                {
                    return true;
                }
            }
            return false;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (s == null)
            {
                throw new MalformedCookieException("Missing value for path attribute");
            }
            if (s.trim().equals(""))
            {
                throw new MalformedCookieException("Blank value for path attribute");
            } else
            {
                cookie.setPath(s);
                cookie.setPathAttributeSpecified(true);
                return;
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            String s = cookieorigin.getPath();
            if (s == null)
            {
                throw new IllegalArgumentException("Path of origin host may not be null.");
            }
            if (cookie.getPath() == null)
            {
                throw new MalformedCookieException("Invalid cookie state: path attribute is null.");
            }
            cookieorigin = s;
            if (s.trim().equals(""))
            {
                cookieorigin = "/";
            }
            if (!pathMatch(cookieorigin, cookie.getPath()))
            {
                throw new MalformedCookieException("Illegal path attribute \"" + cookie.getPath() + "\". Path of origin: \"" + cookieorigin + "\"");
            } else
            {
                return;
            }
        }

        private Cookie2PathAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class Cookie2PortAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            if (!(cookie instanceof Cookie2)) goto _L2; else goto _L1
_L1:
            int i;
            cookie = (Cookie2)cookie;
            i = cookieorigin.getPort();
            if (!cookie.isPortAttributeSpecified()) goto _L4; else goto _L3
_L3:
            if (cookie.getPorts() != null) goto _L6; else goto _L5
_L5:
            CookieSpecBase.LOG.warn("Invalid cookie state: port not specified");
_L2:
            return false;
_L6:
            if (!portMatch(i, cookie.getPorts())) goto _L2; else goto _L4
_L4:
            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookie instanceof Cookie2)
            {
                cookie = (Cookie2)cookie;
                if (s == null || s.trim().equals(""))
                {
                    cookie.setPortAttributeBlank(true);
                } else
                {
                    cookie.setPorts(parsePortAttribute(s));
                }
                cookie.setPortAttributeSpecified(true);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            if (cookie instanceof Cookie2)
            {
                cookie = (Cookie2)cookie;
                int i = cookieorigin.getPort();
                if (cookie.isPortAttributeSpecified() && !portMatch(i, cookie.getPorts()))
                {
                    throw new MalformedCookieException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
                }
            }
        }

        private Cookie2PortAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class Cookie2VersionAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookie instanceof Cookie2)
            {
                cookie = (Cookie2)cookie;
                if (s == null)
                {
                    throw new MalformedCookieException("Missing value for version attribute");
                }
                int i;
                try
                {
                    i = Integer.parseInt(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    i = -1;
                }
                if (i < 0)
                {
                    throw new MalformedCookieException("Invalid cookie version.");
                }
                cookie.setVersion(i);
                cookie.setVersionAttributeSpecified(true);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if ((cookie instanceof Cookie2) && !((Cookie2)cookie).isVersionAttributeSpecified())
            {
                throw new MalformedCookieException("Violates RFC 2965. Version attribute is required.");
            } else
            {
                return;
            }
        }

        private Cookie2VersionAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class CookieCommentAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            cookie.setComment(s);
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
        }

        private CookieCommentAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class CookieCommentUrlAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie instanceof Cookie2)
            {
                ((Cookie2)cookie).setCommentURL(s);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
        }

        private CookieCommentUrlAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class CookieDiscardAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            return true;
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            if (cookie instanceof Cookie2)
            {
                ((Cookie2)cookie).setDiscard(true);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
        }

        private CookieDiscardAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }

    private class CookieSecureAttributeHandler
        implements CookieAttributeHandler
    {

        private final RFC2965Spec this$0;

        public boolean match(Cookie cookie, CookieOrigin cookieorigin)
        {
            if (cookie == null)
            {
                throw new IllegalArgumentException("Cookie may not be null");
            }
            if (cookieorigin == null)
            {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
            return cookie.getSecure() == cookieorigin.isSecure();
        }

        public void parse(Cookie cookie, String s)
            throws MalformedCookieException
        {
            cookie.setSecure(true);
        }

        public void validate(Cookie cookie, CookieOrigin cookieorigin)
            throws MalformedCookieException
        {
        }

        private CookieSecureAttributeHandler()
        {
            this$0 = RFC2965Spec.this;
        }

    }


    private static final Comparator PATH_COMPOARATOR = new CookiePathComparator();
    public static final String SET_COOKIE2_KEY = "set-cookie2";
    private final List attribHandlerList = new ArrayList(10);
    private final Map attribHandlerMap = new HashMap(10);
    private final ParameterFormatter formatter = new ParameterFormatter();
    private final CookieSpec rfc2109 = new RFC2109Spec();

    public RFC2965Spec()
    {
        formatter.setAlwaysUseQuotes(true);
        registerAttribHandler("path", new Cookie2PathAttributeHandler());
        registerAttribHandler("domain", new Cookie2DomainAttributeHandler());
        registerAttribHandler("port", new Cookie2PortAttributeHandler());
        registerAttribHandler("max-age", new Cookie2MaxageAttributeHandler());
        registerAttribHandler("secure", new CookieSecureAttributeHandler());
        registerAttribHandler("comment", new CookieCommentAttributeHandler());
        registerAttribHandler("commenturl", new CookieCommentUrlAttributeHandler());
        registerAttribHandler("discard", new CookieDiscardAttributeHandler());
        registerAttribHandler("version", new Cookie2VersionAttributeHandler());
    }

    private String createPortAttribute(int ai[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        for (int j = ai.length; i < j; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(",");
            }
            stringbuffer.append(ai[i]);
        }

        return stringbuffer.toString();
    }

    private void doFormatCookie2(Cookie2 cookie2, StringBuffer stringbuffer)
    {
        String s3 = cookie2.getName();
        String s2 = cookie2.getValue();
        String s = s2;
        if (s2 == null)
        {
            s = "";
        }
        formatter.format(stringbuffer, new NameValuePair(s3, s));
        if (cookie2.getDomain() != null && cookie2.isDomainAttributeSpecified())
        {
            stringbuffer.append("; ");
            formatter.format(stringbuffer, new NameValuePair("$Domain", cookie2.getDomain()));
        }
        if (cookie2.getPath() != null && cookie2.isPathAttributeSpecified())
        {
            stringbuffer.append("; ");
            formatter.format(stringbuffer, new NameValuePair("$Path", cookie2.getPath()));
        }
        if (cookie2.isPortAttributeSpecified())
        {
            String s1 = "";
            if (!cookie2.isPortAttributeBlank())
            {
                s1 = createPortAttribute(cookie2.getPorts());
            }
            stringbuffer.append("; ");
            formatter.format(stringbuffer, new NameValuePair("$Port", s1));
        }
    }

    private static String getEffectiveHost(String s)
    {
        String s2 = s.toLowerCase();
        String s1 = s2;
        if (s.indexOf('.') < 0)
        {
            s1 = s2 + ".local";
        }
        return s1;
    }

    private int[] parsePortAttribute(String s)
        throws MalformedCookieException
    {
        int ai[];
        int i;
        s = new StringTokenizer(s, ",");
        ai = new int[s.countTokens()];
        i = 0;
_L2:
        if (!s.hasMoreTokens())
        {
            break; /* Loop/switch isn't completed */
        }
        ai[i] = Integer.parseInt(s.nextToken().trim());
        if (ai[i] < 0)
        {
            try
            {
                throw new MalformedCookieException("Invalid Port attribute.");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new MalformedCookieException("Invalid Port attribute: " + s.getMessage());
            }
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return ai;
    }

    private boolean portMatch(int i, int ai[])
    {
        boolean flag1 = false;
        int j = 0;
        int k = ai.length;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < k)
                {
                    if (i != ai[j])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    public boolean domainMatch(String s, String s1)
    {
        return s.equals(s1) || s1.startsWith(".") && s.endsWith(s1);
    }

    protected CookieAttributeHandler findAttribHandler(String s)
    {
        return (CookieAttributeHandler)attribHandlerMap.get(s);
    }

    public String formatCookie(Cookie cookie)
    {
        LOG.trace("enter RFC2965Spec.formatCookie(Cookie)");
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie instanceof Cookie2)
        {
            cookie = (Cookie2)cookie;
            int i = cookie.getVersion();
            StringBuffer stringbuffer = new StringBuffer();
            formatter.format(stringbuffer, new NameValuePair("$Version", Integer.toString(i)));
            stringbuffer.append("; ");
            doFormatCookie2(cookie, stringbuffer);
            return stringbuffer.toString();
        } else
        {
            return rfc2109.formatCookie(cookie);
        }
    }

    public String formatCookies(Cookie acookie[])
    {
        LOG.trace("enter RFC2965Spec.formatCookieHeader(Cookie[])");
        if (acookie == null)
        {
            throw new IllegalArgumentException("Cookies may not be null");
        }
        boolean flag1 = false;
        int i = -1;
        int k = 0;
label0:
        do
        {
            Cookie cookie;
label1:
            {
                boolean flag = flag1;
                if (k < acookie.length)
                {
                    cookie = acookie[k];
                    if (cookie instanceof Cookie2)
                    {
                        break label1;
                    }
                    flag = true;
                }
                k = i;
                if (i < 0)
                {
                    k = 0;
                }
                if (flag || k < 1)
                {
                    return rfc2109.formatCookies(acookie);
                }
                break label0;
            }
            int l = i;
            if (cookie.getVersion() > i)
            {
                l = cookie.getVersion();
            }
            k++;
            i = l;
        } while (true);
        Arrays.sort(acookie, PATH_COMPOARATOR);
        StringBuffer stringbuffer = new StringBuffer();
        formatter.format(stringbuffer, new NameValuePair("$Version", Integer.toString(k)));
        for (int j = 0; j < acookie.length; j++)
        {
            stringbuffer.append("; ");
            doFormatCookie2((Cookie2)acookie[j], stringbuffer);
        }

        return stringbuffer.toString();
    }

    protected CookieAttributeHandler getAttribHandler(String s)
    {
        CookieAttributeHandler cookieattributehandler = findAttribHandler(s);
        if (cookieattributehandler == null)
        {
            throw new IllegalStateException("Handler not registered for " + s + " attribute.");
        } else
        {
            return cookieattributehandler;
        }
    }

    protected Iterator getAttribHandlerIterator()
    {
        return attribHandlerList.iterator();
    }

    public int getVersion()
    {
        return 1;
    }

    public Header getVersionHeader()
    {
        ParameterFormatter parameterformatter = new ParameterFormatter();
        StringBuffer stringbuffer = new StringBuffer();
        parameterformatter.format(stringbuffer, new NameValuePair("$Version", Integer.toString(getVersion())));
        return new Header("Cookie2", stringbuffer.toString(), true);
    }

    public boolean match(String s, int i, String s1, boolean flag, Cookie cookie)
    {
        LOG.trace("enter RFC2965.match(String, int, String, boolean, Cookie");
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie instanceof Cookie2)
        {
            if (cookie.isPersistent() && cookie.isExpired())
            {
                return false;
            }
            s = new CookieOrigin(getEffectiveHost(s), i, s1, flag);
            for (s1 = getAttribHandlerIterator(); s1.hasNext();)
            {
                if (!((CookieAttributeHandler)s1.next()).match(cookie, s))
                {
                    return false;
                }
            }

            return true;
        } else
        {
            return rfc2109.match(s, i, s1, flag, cookie);
        }
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, String s2)
        throws MalformedCookieException
    {
        LOG.trace("enter RFC2965Spec.parse(String, int, String, boolean, String)");
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
        s = getEffectiveHost(s);
        s1 = HeaderElement.parseElements(s2.toCharArray());
        s2 = new LinkedList();
        for (int j = 0; j < s1.length; j++)
        {
            HeaderElement headerelement = s1[j];
            Cookie2 cookie2;
            NameValuePair anamevaluepair[];
            try
            {
                cookie2 = new Cookie2(s, headerelement.getName(), headerelement.getValue(), s3, null, false, new int[] {
                    i
                });
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new MalformedCookieException(s.getMessage());
            }
            anamevaluepair = headerelement.getParameters();
            if (anamevaluepair != null)
            {
                HashMap hashmap = new HashMap(anamevaluepair.length);
                for (int k = anamevaluepair.length - 1; k >= 0; k--)
                {
                    NameValuePair namevaluepair = anamevaluepair[k];
                    hashmap.put(namevaluepair.getName().toLowerCase(), namevaluepair);
                }

                for (Iterator iterator = hashmap.entrySet().iterator(); iterator.hasNext(); parseAttribute((NameValuePair)((java.util.Map.Entry)iterator.next()).getValue(), cookie2)) { }
            }
            s2.add(cookie2);
        }

        return (Cookie[])(Cookie[])s2.toArray(new Cookie[s2.size()]);
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, Header header)
        throws MalformedCookieException
    {
        LOG.trace("enter RFC2965.parse(String, int, String, boolean, Header)");
        if (header == null)
        {
            throw new IllegalArgumentException("Header may not be null.");
        }
        if (header.getName() == null)
        {
            throw new IllegalArgumentException("Header name may not be null.");
        }
        if (header.getName().equalsIgnoreCase("set-cookie2"))
        {
            return parse(s, i, s1, flag, header.getValue());
        }
        if (header.getName().equalsIgnoreCase("set-cookie"))
        {
            return rfc2109.parse(s, i, s1, flag, header.getValue());
        } else
        {
            throw new MalformedCookieException("Header name is not valid. RFC 2965 supports \"set-cookie\" and \"set-cookie2\" headers.");
        }
    }

    public void parseAttribute(NameValuePair namevaluepair, Cookie cookie)
        throws MalformedCookieException
    {
        if (namevaluepair == null)
        {
            throw new IllegalArgumentException("Attribute may not be null.");
        }
        if (namevaluepair.getName() == null)
        {
            throw new IllegalArgumentException("Attribute Name may not be null.");
        }
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
        Object obj = namevaluepair.getName().toLowerCase();
        String s = namevaluepair.getValue();
        obj = findAttribHandler(((String) (obj)));
        if (obj == null)
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Unrecognized cookie attribute: " + namevaluepair.toString());
            }
            return;
        } else
        {
            ((CookieAttributeHandler) (obj)).parse(cookie, s);
            return;
        }
    }

    protected void registerAttribHandler(String s, CookieAttributeHandler cookieattributehandler)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Attribute name may not be null");
        }
        if (cookieattributehandler == null)
        {
            throw new IllegalArgumentException("Attribute handler may not be null");
        }
        if (!attribHandlerList.contains(cookieattributehandler))
        {
            attribHandlerList.add(cookieattributehandler);
        }
        attribHandlerMap.put(s, cookieattributehandler);
    }

    public void validate(String s, int i, String s1, boolean flag, Cookie cookie)
        throws MalformedCookieException
    {
        LOG.trace("enter RFC2965Spec.validate(String, int, String, boolean, Cookie)");
        if (cookie instanceof Cookie2)
        {
            if (cookie.getName().indexOf(' ') != -1)
            {
                throw new MalformedCookieException("Cookie name may not contain blanks");
            }
            if (cookie.getName().startsWith("$"))
            {
                throw new MalformedCookieException("Cookie name may not start with $");
            }
            s = new CookieOrigin(getEffectiveHost(s), i, s1, flag);
            for (s1 = getAttribHandlerIterator(); s1.hasNext(); ((CookieAttributeHandler)s1.next()).validate(cookie, s)) { }
        } else
        {
            rfc2109.validate(s, i, s1, flag, cookie);
        }
    }



}
