// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.text.TextUtils;
import android.text.format.Time;
import com.amazon.identity.auth.device.utils.ArrayUtil;
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
    private static class CookieAttribute
    {

        private CookieAttribute()
        {
        }
    }


    public static final String KEY_COMMENT = "Comment";
    public static final String KEY_COMMENT_URL = "CommentUrl";
    public static final String KEY_DIRECTED_ID = "DirectedId";
    public static final String KEY_DOMAIN = "Domain";
    public static final String KEY_EXPIRES = "Expires";
    public static final String KEY_HTTP_ONLY = "HttpOnly";
    public static final String KEY_NAME = "Name";
    public static final String KEY_PATH = "Path";
    public static final String KEY_PERSISTANT = "Persistant";
    public static final String KEY_SECURE = "Secure";
    public static final String KEY_VALUE = "Value";
    public static final String KEY_VERSION = "Version";
    private static final String LOG_TAG = com/amazon/identity/auth/device/token/MAPCookie.getName();
    public static final int NO_VERSION = -1;
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

    public MAPCookie(Map map)
    {
        mLocalCreationTimestamp = new Time();
        mCookieData = map;
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

    public Map getData()
    {
        return mCookieData;
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

    public Time getLocalTimestamp()
    {
        return mLocalCreationTimestamp;
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
        if (mPorts == null)
        {
            return null;
        } else
        {
            return ArrayUtil.copyOf(mPorts, mPorts.length);
        }
    }

    public String getSetCookieHeader()
    {
        StringBuilder stringbuilder = new StringBuilder(getName().trim());
        stringbuilder.append("=");
        stringbuilder.append(getValue().trim());
        stringbuilder.append("; path=/");
        stringbuilder.append((new StringBuilder("; domain=")).append(getDomain().trim()).toString());
        if (isSecure())
        {
            stringbuilder.append("; secure");
        }
        Date date = getExpiryDate();
        if (date != null)
        {
            stringbuilder.append("; expires=");
            if (date.before(Calendar.getInstance().getTime()))
            {
                String s = LOG_TAG;
                getName();
                date.toGMTString();
            }
            stringbuilder.append(CookieUtils.getCookieExpireDateFormatter().format(date));
        }
        return stringbuilder.toString();
    }

    public String getType()
    {
        return getName();
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

    public boolean hasExpired()
    {
        return isExpired(Calendar.getInstance().getTime());
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

    public void setPorts(int ai[])
    {
        mPorts = new int[ai.length];
        System.arraycopy(ai, 0, mPorts, 0, ai.length);
    }

    protected void setSecure(boolean flag)
    {
        setAttribute("Secure", Boolean.toString(flag));
    }

}
