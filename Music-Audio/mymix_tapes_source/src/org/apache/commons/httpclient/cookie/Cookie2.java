// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.Date;
import org.apache.commons.httpclient.Cookie;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookiePolicy, CookieSpec

public class Cookie2 extends Cookie
{

    public static final String COMMENT = "comment";
    public static final String COMMENTURL = "commenturl";
    public static final String DISCARD = "discard";
    public static final String DOMAIN = "domain";
    public static final String MAXAGE = "max-age";
    public static final String PATH = "path";
    public static final String PORT = "port";
    public static final String SECURE = "secure";
    public static final String VERSION = "version";
    private String cookieCommentURL;
    private int cookiePorts[];
    private boolean discard;
    private boolean hasPortAttribute;
    private boolean hasVersionAttribute;
    private boolean isPortAttributeBlank;

    public Cookie2()
    {
        super(null, "noname", null, null, null, false);
        discard = false;
        hasPortAttribute = false;
        isPortAttributeBlank = false;
        hasVersionAttribute = false;
    }

    public Cookie2(String s, String s1, String s2)
    {
        super(s, s1, s2);
        discard = false;
        hasPortAttribute = false;
        isPortAttributeBlank = false;
        hasVersionAttribute = false;
    }

    public Cookie2(String s, String s1, String s2, String s3, Date date, boolean flag)
    {
        super(s, s1, s2, s3, date, flag);
        discard = false;
        hasPortAttribute = false;
        isPortAttributeBlank = false;
        hasVersionAttribute = false;
    }

    public Cookie2(String s, String s1, String s2, String s3, Date date, boolean flag, int ai[])
    {
        super(s, s1, s2, s3, date, flag);
        discard = false;
        hasPortAttribute = false;
        isPortAttributeBlank = false;
        hasVersionAttribute = false;
        setPorts(ai);
    }

    public String getCommentURL()
    {
        return cookieCommentURL;
    }

    public int[] getPorts()
    {
        return cookiePorts;
    }

    public boolean isPersistent()
    {
        return getExpiryDate() != null && !discard;
    }

    public boolean isPortAttributeBlank()
    {
        return isPortAttributeBlank;
    }

    public boolean isPortAttributeSpecified()
    {
        return hasPortAttribute;
    }

    public boolean isVersionAttributeSpecified()
    {
        return hasVersionAttribute;
    }

    public void setCommentURL(String s)
    {
        cookieCommentURL = s;
    }

    public void setDiscard(boolean flag)
    {
        discard = flag;
    }

    public void setPortAttributeBlank(boolean flag)
    {
        isPortAttributeBlank = flag;
    }

    public void setPortAttributeSpecified(boolean flag)
    {
        hasPortAttribute = flag;
    }

    public void setPorts(int ai[])
    {
        cookiePorts = ai;
    }

    public void setVersionAttributeSpecified(boolean flag)
    {
        hasVersionAttribute = flag;
    }

    public String toExternalForm()
    {
        return CookiePolicy.getCookieSpec("rfc2965").formatCookie(this);
    }
}
