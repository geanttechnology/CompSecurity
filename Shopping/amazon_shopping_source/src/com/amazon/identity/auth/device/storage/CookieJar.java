// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.Cookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class CookieJar
{

    private static final String TAG = com/amazon/identity/auth/device/storage/CookieJar.getName();
    private final List mCookies;
    private final AtomicBoolean mInit = new AtomicBoolean(false);
    private JSONObject mInternationalXmainCookies;
    private String mXmain;

    public CookieJar(List list)
    {
        if (list != null)
        {
            mCookies = list;
        } else
        {
            mCookies = new ArrayList();
        }
        mInternationalXmainCookies = new JSONObject();
    }

    private void ensureInitialized()
    {
        if (!mInit.getAndSet(true)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator = mCookies.iterator();
_L4:
        Cookie cookie;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        cookie = (Cookie)iterator.next();
        String s = cookie.getValue();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s.startsWith("x-main"))
        {
            mXmain = parseXmain(s);
        }
        boolean flag;
        if (!s.startsWith("x-main") && !s.startsWith("x-acb"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            try
            {
                mInternationalXmainCookies.put((new StringBuilder("https://www")).append(cookie.getUrl()).toString(), cookie.getValue());
            }
            catch (JSONException jsonexception)
            {
                MAPLog.e(TAG, "Adding JSON value failed", jsonexception);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    private String parseXmain(String s)
    {
        s = s.split(";");
        if (s.length > 0) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Cookie does not seem to be in a valid format");
        s = null;
          goto _L3
_L2:
        s = s[0].split("=");
        if (s.length == 2) goto _L5; else goto _L4
_L4:
        MAPLog.e(TAG, "Cookie name/value pair does not seem to be in a valid format");
        s = null;
_L3:
        while (s == null) 
        {
            try
            {
                MAPLog.e(TAG, "Found no x-main cookie in RegisterDeviceResponse");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPLog.e(TAG, (new StringBuilder("Caught exception parsing the cookie value out of RegisterDeviceResponse")).append(s.getMessage()).toString());
            }
            return null;
        }
        return s;
_L5:
        s = s[1];
        if (true) goto _L3; else goto _L6
_L6:
    }

    public String getInternationalXMainAndXAcbCookies()
    {
        ensureInitialized();
        return mInternationalXmainCookies.toString();
    }

    public String getXmain()
    {
        ensureInitialized();
        return mXmain;
    }

}
