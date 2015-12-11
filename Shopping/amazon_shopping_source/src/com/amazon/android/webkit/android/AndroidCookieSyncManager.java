// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.amazon.android.webkit.AmazonCookieSyncManager;

public class AndroidCookieSyncManager extends AmazonCookieSyncManager
{

    public AndroidCookieSyncManager()
    {
    }

    public void createInstance(Context context)
    {
        CookieSyncManager.createInstance(context);
    }

    public void sync()
    {
        CookieSyncManager.getInstance().sync();
    }
}
