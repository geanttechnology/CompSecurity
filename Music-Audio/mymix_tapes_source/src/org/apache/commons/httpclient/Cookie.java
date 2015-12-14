// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.util.LangUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            NameValuePair

public class Cookie extends NameValuePair
    implements Serializable, Comparator
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$Cookie;
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private boolean hasDomainAttribute;
    private boolean hasPathAttribute;
    private boolean isSecure;

    public Cookie()
    {
        this(null, "noname", null, null, ((Date) (null)), false);
    }

    public Cookie(String s, String s1, String s2)
    {
        this(s, s1, s2, null, ((Date) (null)), false);
    }

    public Cookie(String s, String s1, String s2, String s3, int i, boolean flag)
    {
        this(s, s1, s2, s3, ((Date) (null)), flag);
        if (i < -1)
        {
            throw new IllegalArgumentException("Invalid max age:  " + Integer.toString(i));
        }
        if (i >= 0)
        {
            setExpiryDate(new Date(System.currentTimeMillis() + (long)i * 1000L));
        }
    }

    public Cookie(String s, String s1, String s2, String s3, Date date, boolean flag)
    {
        super(s1, s2);
        hasPathAttribute = false;
        hasDomainAttribute = false;
        cookieVersion = 0;
        LOG.trace("enter Cookie(String, String, String, String, Date, boolean)");
        if (s1 == null)
        {
            throw new IllegalArgumentException("Cookie name may not be null");
        }
        if (s1.trim().equals(""))
        {
            throw new IllegalArgumentException("Cookie name may not be blank");
        } else
        {
            setPath(s3);
            setDomain(s);
            setExpiryDate(date);
            setSecure(flag);
            return;
        }
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

    public int compare(Object obj, Object obj1)
    {
        LOG.trace("enter Cookie.compare(Object, Object)");
        if (!(obj instanceof Cookie))
        {
            throw new ClassCastException(obj.getClass().getName());
        }
        if (!(obj1 instanceof Cookie))
        {
            throw new ClassCastException(obj1.getClass().getName());
        }
        obj = (Cookie)obj;
        obj1 = (Cookie)obj1;
        if (((Cookie) (obj)).getPath() != null || ((Cookie) (obj1)).getPath() != null) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        if (((Cookie) (obj)).getPath() != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((Cookie) (obj1)).getPath().equals("/"))
        {
            return -1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (((Cookie) (obj1)).getPath() == null)
        {
            if (!((Cookie) (obj)).getPath().equals("/"))
            {
                return 1;
            }
        } else
        {
            return ((Cookie) (obj)).getPath().compareTo(((Cookie) (obj1)).getPath());
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof Cookie)
            {
                obj = (Cookie)obj;
                if (!LangUtils.equals(getName(), ((Cookie) (obj)).getName()) || !LangUtils.equals(cookieDomain, ((Cookie) (obj)).cookieDomain) || !LangUtils.equals(cookiePath, ((Cookie) (obj)).cookiePath))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public String getComment()
    {
        return cookieComment;
    }

    public String getDomain()
    {
        return cookieDomain;
    }

    public Date getExpiryDate()
    {
        return cookieExpiryDate;
    }

    public String getPath()
    {
        return cookiePath;
    }

    public boolean getSecure()
    {
        return isSecure;
    }

    public int getVersion()
    {
        return cookieVersion;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, getName()), cookieDomain), cookiePath);
    }

    public boolean isDomainAttributeSpecified()
    {
        return hasDomainAttribute;
    }

    public boolean isExpired()
    {
        return cookieExpiryDate != null && cookieExpiryDate.getTime() <= System.currentTimeMillis();
    }

    public boolean isExpired(Date date)
    {
        return cookieExpiryDate != null && cookieExpiryDate.getTime() <= date.getTime();
    }

    public boolean isPathAttributeSpecified()
    {
        return hasPathAttribute;
    }

    public boolean isPersistent()
    {
        return cookieExpiryDate != null;
    }

    public void setComment(String s)
    {
        cookieComment = s;
    }

    public void setDomain(String s)
    {
        if (s != null)
        {
            int i = s.indexOf(":");
            String s1 = s;
            if (i != -1)
            {
                s1 = s.substring(0, i);
            }
            cookieDomain = s1.toLowerCase();
        }
    }

    public void setDomainAttributeSpecified(boolean flag)
    {
        hasDomainAttribute = flag;
    }

    public void setExpiryDate(Date date)
    {
        cookieExpiryDate = date;
    }

    public void setPath(String s)
    {
        cookiePath = s;
    }

    public void setPathAttributeSpecified(boolean flag)
    {
        hasPathAttribute = flag;
    }

    public void setSecure(boolean flag)
    {
        isSecure = flag;
    }

    public void setVersion(int i)
    {
        cookieVersion = i;
    }

    public String toExternalForm()
    {
        CookieSpec cookiespec;
        if (getVersion() > 0)
        {
            cookiespec = CookiePolicy.getDefaultSpec();
        } else
        {
            cookiespec = CookiePolicy.getCookieSpec("netscape");
        }
        return cookiespec.formatCookie(this);
    }

    public String toString()
    {
        return toExternalForm();
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$Cookie == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.Cookie");
            class$org$apache$commons$httpclient$Cookie = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$Cookie;
        }
        LOG = LogFactory.getLog(class1);
    }
}
