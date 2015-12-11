// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.LocalKeyValueStore;
import com.amazon.identity.auth.device.token.MAPCookie;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            JSONHelpers, CookieUtils, WebViewUtils

public class MAPAndroidWebviewSharedPrefCookieUtils
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/utils/MAPAndroidWebviewSharedPrefCookieUtils.getName();
    private final AmazonAccountManager mAmazonAccountManager;
    private final ServiceWrappingContext mContext;
    private final LocalKeyValueStore mLocalKeyValueStore;

    public MAPAndroidWebviewSharedPrefCookieUtils(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAmazonAccountManager = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mLocalKeyValueStore = new LocalKeyValueStore(mContext, "com.amazon.identity.auth.device.utils.CookieAuthorityInfo");
    }

    private String getUUIDForDirectedId(String s)
    {
        return mAmazonAccountManager.getAccountValidator(s);
    }

    public void addCookieNamesToSharedPrefs(String s, String s1, String as[])
    {
        String s2 = JSONHelpers.addNewItemToJsonArray(mLocalKeyValueStore.getStringValue("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"), s1);
        as = JSONHelpers.getJsonOfList(CookieUtils.getCookieNamesFromCookies(as));
        String s3 = mLocalKeyValueStore.getStringValue("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL");
        String s4 = mLocalKeyValueStore.getStringValue(s1);
        s = getUUIDForDirectedId(s);
        String s5 = mLocalKeyValueStore.getStringValue("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID");
        HashMap hashmap = new HashMap();
        if (!TextUtils.equals(s3, s2))
        {
            String.format("Setting SharedPreferences Url value to %s", new Object[] {
                s2
            });
            hashmap.put("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL", s2);
        }
        if (!TextUtils.equals(s4, as))
        {
            String.format("Setting SharedPreferences Cookie names for url %s to %s", new Object[] {
                s1, as
            });
            hashmap.put(s1, as);
        }
        if (!TextUtils.equals(s, s5))
        {
            hashmap.put("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID", s);
        }
        mLocalKeyValueStore.setValues(hashmap);
    }

    public void cleanUpKnownCookies()
    {
        Map map = mLocalKeyValueStore.getAll();
        if (!map.containsKey("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"))
        {
            return;
        }
        Object obj = JSONHelpers.getSetFromJSONArray((String)map.get("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.URL"));
        WebViewUtils.syncCookieSyncManager(mContext);
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            if (map.containsKey(s))
            {
                Iterator iterator = JSONHelpers.getSetFromJSONArray((String)map.get(s)).iterator();
                while (iterator.hasNext()) 
                {
                    Object obj1 = new MAPCookie((String)iterator.next(), "", s, null, false);
                    (new StringBuilder("Clearing cookie from WebView: ")).append(s).append(", ").append(((MAPCookie) (obj1)).getName());
                    obj1 = ((MAPCookie) (obj1)).getSetCookieHeader();
                    WebViewUtils.setCookie(mContext, s, ((String) (obj1)));
                }
            }
        } while (true);
        WebViewUtils.syncCookieSyncManager(mContext);
        mLocalKeyValueStore.clearStore();
    }

    public boolean needsToCleanupCookiesInSharedPrefsAndCookieJar(String s)
    {
        String s1 = mLocalKeyValueStore.getStringValue("com.amazon.identity.auth.device.utils.CookieAuthorityInfo.REGISTRATION_UUID");
        s = getUUIDForDirectedId(s);
        return !TextUtils.isEmpty(s1) && !s1.equalsIgnoreCase(s);
    }

}
