// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.CollectionUtils;
import com.amazon.identity.auth.device.utils.CookieUtils;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            CookieDataStore, DataStorage

public class GenericCookieDataStore extends CookieDataStore
{

    private static final String TAG = com/amazon/identity/auth/device/storage/GenericCookieDataStore.getName();
    private final DataStorage mDataStorage;

    public GenericCookieDataStore(Context context)
    {
        this(ServiceWrappingContext.create(context).getDataStorage());
    }

    public GenericCookieDataStore(DataStorage datastorage)
    {
        mDataStorage = datastorage;
    }

    private void backfillOldCookieFormat(final String directedId, final String domain, List list)
    {
        if (!CollectionUtils.isEmpty(list))
        {
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final GenericCookieDataStore this$0;
                final List val$copyOfCookies;
                final String val$directedId;
                final String val$domain;

                public void run()
                {
                    setCookies(directedId, domain, copyOfCookies);
                }

            
            {
                this$0 = GenericCookieDataStore.this;
                directedId = s;
                domain = s1;
                copyOfCookies = list;
                super();
            }
            });
        }
    }

    private static Map cookiesToTokenMap(String s, List list)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(getCookieTokenKey(s), CookieUtils.toSerializedBundleString(list));
        hashmap.put(getJsonCookieTokenKey(s), CookieUtils.toJson(list));
        return hashmap;
    }

    static String getCookieTokenKey(String s)
    {
        return String.format("%s.%s", new Object[] {
            "com.amazon.dcp.sso.token.amazon.cookies", s
        });
    }

    static String getJsonCookieTokenKey(String s)
    {
        return String.format("%s.json.%s", new Object[] {
            "com.amazon.dcp.sso.token.amazon.cookies", s
        });
    }

    static String getJsonDeviceDataKeyForDomain(String s)
    {
        return (new StringBuilder("json.")).append(s).toString();
    }

    public boolean clearCookies(Context context, String s)
    {
        throw new IllegalStateException("Clear cookies is not supported");
    }

    public Map getCookieTokenMapOrWriteToDataStoreFromRegistrationData(String s, List list, String s1)
    {
        if (list.isEmpty())
        {
            s = TAG;
            return Collections.emptyMap();
        } else
        {
            return cookiesToTokenMap(s1, list);
        }
    }

    protected List getCookies(String s, String s1)
    {
        List list;
        if (TextUtils.isEmpty(s))
        {
            List list2 = CookieUtils.fromSerializedBundle(mDataStorage.getDeviceData("com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth", s1), null);
            list = list2;
            if (CollectionUtils.isEmpty(list2))
            {
                list = CookieUtils.fromJson(mDataStorage.getDeviceData("com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth", getJsonDeviceDataKeyForDomain(s1)), null);
                backfillOldCookieFormat(s, s1, list);
            }
        } else
        {
            List list3 = CookieUtils.fromSerializedBundle(mDataStorage.getToken(s, getCookieTokenKey(s1)), s);
            list = list3;
            if (CollectionUtils.isEmpty(list3))
            {
                List list1 = CookieUtils.fromJson(mDataStorage.getToken(s, getJsonCookieTokenKey(s1)), s);
                backfillOldCookieFormat(s, s1, list1);
                return list1;
            }
        }
        return list;
    }

    protected void setCookies(String s, String s1, List list)
    {
        if (TextUtils.isEmpty(s))
        {
            s = new HashMap();
            s.put(s1, CookieUtils.toSerializedBundleString(list));
            s.put(getJsonDeviceDataKeyForDomain(s1), CookieUtils.toJson(list));
            mDataStorage.setDeviceData("com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth", s);
            return;
        } else
        {
            mDataStorage.setTokens(s, cookiesToTokenMap(s1, list));
            return;
        }
    }

}
