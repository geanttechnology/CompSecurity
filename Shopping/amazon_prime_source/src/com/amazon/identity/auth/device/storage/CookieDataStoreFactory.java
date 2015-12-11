// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import com.amazon.identity.auth.device.framework.PlatformWrapper;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            PreMergeDeviceCookieDataStore, GenericCookieDataStore, CookieDataStore

public class CookieDataStoreFactory
{

    private final Context mContext;
    private final PlatformWrapper mPlatform;

    public CookieDataStoreFactory(Context context)
    {
        mContext = context;
        mPlatform = (PlatformWrapper)context.getSystemService("sso_platform");
    }

    public CookieDataStore getDataStore()
    {
        if (mPlatform.isPreMergeDevice())
        {
            return new PreMergeDeviceCookieDataStore(mContext);
        } else
        {
            return new GenericCookieDataStore(mContext);
        }
    }
}
