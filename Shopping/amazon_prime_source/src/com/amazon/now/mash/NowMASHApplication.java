// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash;

import android.content.Context;
import com.amazon.mobile.mash.MASHApplication;
import com.amazon.now.platform.AndroidPlatform;

public class NowMASHApplication
    implements MASHApplication
{

    public NowMASHApplication()
    {
    }

    public String getAppCustomUserAgent()
    {
        return AndroidPlatform.getInstance().getUserAgent();
    }

    public Context getApplicationContext()
    {
        return AndroidPlatform.getInstance().getApplicationContext();
    }

    public boolean isDebugEnabled()
    {
        return true;
    }

    public boolean shouldInterceptUrls()
    {
        return true;
    }
}
