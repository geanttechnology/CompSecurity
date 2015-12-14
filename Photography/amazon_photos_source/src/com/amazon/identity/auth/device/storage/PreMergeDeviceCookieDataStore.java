// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.CookieUtils;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            CookieDataStore, GenericCookieDataStore, LocalKeyValueStore

public class PreMergeDeviceCookieDataStore extends CookieDataStore
{

    private static final String TAG = com/amazon/identity/auth/device/storage/GenericCookieDataStore.getName();
    private final Context mContext;

    public PreMergeDeviceCookieDataStore(Context context)
    {
        mContext = context;
    }

    private static String getLocalStoreCookieNamespace(String s)
    {
        return String.format("%s#%s", new Object[] {
            "com.amazon.identity.auth.device.cookiekeys.namespace", s
        });
    }

    public boolean clearCookies(Context context, String s)
    {
        return (new LocalKeyValueStore(context, getLocalStoreCookieNamespace(s))).clearStore();
    }

    public Map getCookieTokenMapOrWriteToDataStoreFromRegistrationData(String s, List list, String s1)
    {
        if (list.isEmpty())
        {
            s = TAG;
            return Collections.emptyMap();
        } else
        {
            setCookies(s, s1, list);
            return Collections.emptyMap();
        }
    }

    protected List getCookies(final String directedId, final String domain)
    {
        Object obj;
        List list;
        if (TextUtils.isEmpty(directedId))
        {
            obj = new LocalKeyValueStore(mContext, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth");
        } else
        {
            obj = new LocalKeyValueStore(mContext, getLocalStoreCookieNamespace(directedId));
        }
        obj = ((LocalKeyValueStore) (obj)).getStringValue(domain);
        list = CookieUtils.fromJsonOrSerializedBundle(((String) (obj)), directedId);
        if (!TextUtils.isEmpty(((CharSequence) (obj))) && !((String) (obj)).startsWith("["))
        {
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final PreMergeDeviceCookieDataStore this$0;
                final List val$copyOfCookies;
                final String val$directedId;
                final String val$domain;

                public void run()
                {
                    setCookies(directedId, domain, copyOfCookies);
                }

            
            {
                this$0 = PreMergeDeviceCookieDataStore.this;
                directedId = s;
                domain = s1;
                copyOfCookies = list;
                super();
            }
            });
        }
        return list;
    }

    protected void setCookies(String s, String s1, List list)
    {
        boolean flag = TextUtils.isEmpty(s);
        list = CookieUtils.toJson(list);
        if (flag)
        {
            (new LocalKeyValueStore(mContext, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth")).setValue(s1, list);
            return;
        } else
        {
            (new LocalKeyValueStore(mContext, getLocalStoreCookieNamespace(s))).setValue(s1, list);
            return;
        }
    }

}
