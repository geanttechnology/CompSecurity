// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.android.webkit.AmazonCookieManager;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.api.AmazonWebViewUtils;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.token.MAPCookie;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            CookieUtils, ParcelUtils

public class AmazonWebviewSharedPrefCookieUtils
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils.getName();
    private final AmazonAccountManager mAmazonAccountManager;
    private final Context mContext;
    private final MAPAccountManager mMAPAccountManager;
    private final SharedPreferences mSharedPrefs;

    public AmazonWebviewSharedPrefCookieUtils(Context context)
    {
        mContext = context;
        mMAPAccountManager = new MAPAccountManager(mContext);
        mAmazonAccountManager = new AmazonAccountManager(mContext);
        mSharedPrefs = mContext.getSharedPreferences("com.amazon.identity.auth.device.utils.CookieAuthorityInfo", 0);
    }

    private String getCurrentRegistrationUUID()
    {
        String s = mMAPAccountManager.getAccount();
        return mAmazonAccountManager.getAccountValidator(s);
    }

    private String getUpdatedCookieString(String s, String as[])
    {
        int j;
        if (mSharedPrefs.contains(s))
        {
            s = CookieUtils.fromJsonOrSerializedBundle(mSharedPrefs.getString(s, null), null);
        } else
        {
            s = new ArrayList();
        }
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            s.add(CookieUtils.parseMapCookieFromSetCookieString(as[i], null));
        }

        return CookieUtils.toSerializedBundleString(new ArrayList(new HashSet(s)));
    }

    public void addCookiesToSharedPrefs(String s, String as[])
    {
        Object obj;
        String s1;
        String s2;
        android.content.SharedPreferences.Editor editor;
        String s3;
        String s5;
        if (mSharedPrefs.contains("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"))
        {
            obj = ParcelUtils.toStringSet(mSharedPrefs.getString("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL", null));
        } else
        {
            obj = new HashSet();
        }
        ((Set) (obj)).add(s);
        obj = ParcelUtils.toSerializedBundleString(((Set) (obj)));
        as = getUpdatedCookieString(s, as);
        s5 = mSharedPrefs.getString("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL", null);
        s3 = mSharedPrefs.getString(s, null);
        s1 = getCurrentRegistrationUUID();
        s2 = mSharedPrefs.getString("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID", null);
        editor = mSharedPrefs.edit();
        if (s5 == null || !s5.equals(obj))
        {
            String s6 = LOG_TAG;
            String.format("Setting SharedPreferences Url value to %s", new Object[] {
                obj
            });
            editor.putString("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL", ((String) (obj)));
        }
        if (s3 == null || !s3.equals(obj))
        {
            String s4 = LOG_TAG;
            String.format("Setting SharedPreferences Cookie value for domain %s to %s", new Object[] {
                obj, as
            });
            editor.putString(s, as);
        }
        if (!TextUtils.equals(s1, s2))
        {
            editor.putString("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID", s1);
        }
        editor.commit();
    }

    public boolean checkIfProcessKnowsSameRegistration()
    {
        String s = mSharedPrefs.getString("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID", null);
        if (s != null)
        {
            String s1 = getCurrentRegistrationUUID();
            if (s1 == null)
            {
                return false;
            }
            if (!s1.equalsIgnoreCase(s))
            {
                return false;
            }
        }
        return true;
    }

    public void cleanUpKnownCookies()
    {
        Object obj = mSharedPrefs.getAll();
        if (!((Map) (obj)).containsKey("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"))
        {
            return;
        }
        AmazonCookieManager amazoncookiemanager = AmazonWebViewUtils.getAmazonCookieManager(mContext);
        amazoncookiemanager.setAcceptCookie(true);
        AmazonWebViewUtils.syncAmazonCookieSyncManager(mContext);
        Iterator iterator = ParcelUtils.toStringSet((String)((Map) (obj)).get("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL")).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (((Map) (obj)).containsKey(s))
            {
                Iterator iterator1 = CookieUtils.fromJsonOrSerializedBundle((String)((Map) (obj)).get(s), null).iterator();
                while (iterator1.hasNext()) 
                {
                    Object obj1 = (Cookie)iterator1.next();
                    obj1 = new MAPCookie(((Cookie) (obj1)).getName(), "", ((Cookie) (obj1)).getDomain(), ((Cookie) (obj1)).getExpiryDate().toGMTString(), ((Cookie) (obj1)).getPath(), null, ((Cookie) (obj1)).isSecure(), ((MAPCookie)obj1).isHttpOnly());
                    String s1 = LOG_TAG;
                    ((MAPCookie) (obj1)).getName();
                    amazoncookiemanager.setCookie(s, ((MAPCookie) (obj1)).getSetCookieHeader());
                }
            }
        } while (true);
        obj = mSharedPrefs.edit();
        ((android.content.SharedPreferences.Editor) (obj)).clear();
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        AmazonWebViewUtils.syncAmazonCookieSyncManager(mContext);
    }

}
