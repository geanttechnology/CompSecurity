// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.text.TextUtils;
import android.text.format.Time;
import com.amazon.identity.auth.device.utils.CookieUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            Token

public class MAPCookie
    implements Token, Serializable, Cookie
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/token/MAPCookie.getName();
    private static final long serialVersionUID = 0x8056234039L;
    private final Map mCookieData;
    private final transient Time mLocalCreationTimestamp;
    private int mPorts[];

    public MAPCookie(String s, String s1, String s2, String s3, String s4, String s5, boolean flag, 
            boolean flag1)
    {
        mLocalCreationTimestamp = new Time();
        mCookieData = new HashMap();
        mCookieData.put("Name", s);
        mCookieData.put("Value", s1);
        mCookieData.put("Domain", s2);
        mCookieData.put("Expires", s3);
        mCookieData.put("Path", s4);
        mCookieData.put("DirectedId", s5);
        setSecure(flag);
        setHttpOnly(flag1);
        mLocalCreationTimestamp.setToNow();
        logCookie();
    }

    public MAPCookie(String s, String s1, String s2, String s3, boolean flag)
    {
        mLocalCreationTimestamp = new Time();
        mCookieData = new HashMap();
        mCookieData.put("Name", s);
        mCookieData.put("Value", s1);
        mCookieData.put("DirectedId", s3);
        mCookieData.put("Domain", s2);
        setSecure(flag);
        mLocalCreationTimestamp.setToNow();
        logCookie();
    }

    private void logCookie()
    {
        String s = getValue();
        if (isSecure())
        {
            s = "<secure>";
        }
        s = LOG_TAG;
        getName();
        getDomain();
        getDirectedId();
    }

    public String getAttribute(String s)
    {
        return (String)mCookieData.get(s);
    }

    public String getComment()
    {
        return getAttribute("Comment");
    }

    public String getCommentURL()
    {
        return getAttribute("CommentUrl");
    }

    public String getDirectedId()
    {
        return getAttribute("DirectedId");
    }

    public String getDomain()
    {
        return getAttribute("Domain");
    }

    public Date getExpiryDate()
    {
        Date date = null;
        String s1 = getAttribute("Expires");
        if (s1 != null)
        {
            try
            {
                date = CookieUtils.getCookieExpireDateFormatter().parse(s1);
            }
            catch (ParseException parseexception)
            {
                String s = LOG_TAG;
                return null;
            }
        }
        return date;
    }

    public String getName()
    {
        return getAttribute("Name");
    }

    public String getPath()
    {
        return getAttribute("Path");
    }

    public int[] getPorts()
    {
        if (mPorts != null) goto _L2; else goto _L1
_L1:
        int ai[] = null;
_L4:
        return ai;
_L2:
        int ai2[] = mPorts;
        int i = mPorts.length;
        int ai1[] = new int[i];
        int j = Math.min(i, ai2.length);
        i = 0;
        do
        {
            ai = ai1;
            if (i >= j)
            {
                continue;
            }
            ai1[i] = ai2[i];
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getSetCookieHeader()
    {
        StringBuilder stringbuilder = new StringBuilder(getName().trim());
        stringbuilder.append("=");
        stringbuilder.append(getValue().trim());
        stringbuilder.append("; path=");
        Object obj = getPath();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            stringbuilder.append("/");
        } else
        {
            stringbuilder.append(((String) (obj)));
        }
        stringbuilder.append((new StringBuilder("; domain=")).append(getDomain().trim()).toString());
        if (isSecure())
        {
            stringbuilder.append("; secure");
        }
        if (isHttpOnly())
        {
            stringbuilder.append("; httponly");
        }
        obj = getExpiryDate();
        if (obj != null)
        {
            stringbuilder.append("; expires=");
            if (((Date) (obj)).before(Calendar.getInstance().getTime()))
            {
                String s = LOG_TAG;
                getName();
                ((Date) (obj)).toGMTString();
            }
            stringbuilder.append(CookieUtils.getCookieExpireDateFormatter().format(((Date) (obj))));
        }
        return stringbuilder.toString();
    }

    public String getValue()
    {
        return getAttribute("Value");
    }

    public int getVersion()
    {
        if (TextUtils.isEmpty(getAttribute("Version")))
        {
            return -1;
        } else
        {
            return Integer.parseInt(getAttribute("Version"));
        }
    }

    public boolean isExpired(Date date)
    {
        if (getExpiryDate() == null)
        {
            return false;
        }
        Date date1 = date;
        if (date == null)
        {
            date1 = Calendar.getInstance().getTime();
        }
        return getExpiryDate().before(date1);
    }

    public boolean isHttpOnly()
    {
        String s = getAttribute("HttpOnly");
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return Boolean.parseBoolean(s);
        }
    }

    public boolean isPersistent()
    {
        return Boolean.parseBoolean(getAttribute("Persistant"));
    }

    public boolean isSecure()
    {
        return Boolean.parseBoolean(getAttribute("Secure"));
    }

    public String setAttribute(String s, String s1)
    {
        return (String)mCookieData.put(s, s1);
    }

    public void setDomain(String s)
    {
        mCookieData.put("Domain", s);
    }

    public void setExpiryDate(String s)
    {
        setAttribute("Expires", s);
    }

    public void setHttpOnly(boolean flag)
    {
        mCookieData.put("HttpOnly", Boolean.toString(flag));
    }

    public void setPath(String s)
    {
        setAttribute("Path", s);
    }

    protected void setSecure(boolean flag)
    {
        setAttribute("Secure", Boolean.toString(flag));
    }

}
