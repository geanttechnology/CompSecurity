// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

// Referenced classes of package com.amazon.device.ads:
//            WebViewFactory

static class cookieSyncManagerCreated
{

    private boolean cookieSyncManagerCreated;

    public void createCookieSyncManager(Context context)
    {
        if (!cookieSyncManagerCreated)
        {
            CookieSyncManager.createInstance(context);
            cookieSyncManagerCreated = true;
        }
    }

    public boolean isCookieSyncManagerCreated()
    {
        return cookieSyncManagerCreated;
    }

    public void setCookie(String s, String s1)
    {
        CookieManager.getInstance().setCookie(s, s1);
    }

    public void startSync()
    {
        CookieSyncManager.getInstance().startSync();
    }

    public void stopSync()
    {
        CookieSyncManager.getInstance().stopSync();
    }

    A()
    {
        cookieSyncManagerCreated = false;
    }
}
