// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.external.tracking;

import android.content.Context;
import com.aviary.android.feather.common.tracking.AbstractTracker;
import com.aviary.android.feather.common.utils.SDKUtils;
import com.localytics.android.LocalyticsSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalyticsTracker extends AbstractTracker
{

    public static final String EXTRAS_API_KEY = "apiKey";
    public static final String EXTRAS_APP_NAME = "appId";
    public static final String EXTRAS_SDK_VERSION = "sdkVersion";
    private static final String LOG_TAG = "LocalyticsTracker";
    private LocalyticsSession localyticsSession;
    private final List mCustomDimensions = new ArrayList(3);
    private final HashMap mDefaultAttributes = new HashMap();

    public LocalyticsTracker(Context context, String s, String s1, String s2)
    {
        super(context, s, s1, s2);
        mDefaultAttributes.put("apiKey", mApiKey);
        mDefaultAttributes.put("appId", mCallingAppName);
        mDefaultAttributes.put("sdkVersion", mSdkVersion);
        localyticsSession = new LocalyticsSession(context, SDKUtils.getTrackerApiKey(context));
        mCustomDimensions.add(s);
    }

    public boolean close()
    {
        localyticsSession.close(mCustomDimensions);
        return true;
    }

    public void open()
    {
        localyticsSession.open(mCustomDimensions);
    }

    public void putCustomAttribute(String s, String s1)
    {
        mDefaultAttributes.put(s, s1);
    }

    public boolean recordTag(String s, HashMap hashmap)
    {
        if (hashmap == null)
        {
            hashmap = mDefaultAttributes;
        } else
        {
            hashmap.putAll(mDefaultAttributes);
        }
        localyticsSession.tagEvent(s, hashmap, mCustomDimensions);
        return true;
    }

    public void upload()
    {
        localyticsSession.upload();
    }
}
