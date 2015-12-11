// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import android.webkit.WebViewDatabase;
import com.amazon.android.webkit.AmazonWebViewDatabase;

public class AndroidWebViewDatabase extends AmazonWebViewDatabase
{

    private Context context;

    public AndroidWebViewDatabase(Context context1)
    {
        context = context1;
    }

    public void clearFormData()
    {
        WebViewDatabase.getInstance(context).clearFormData();
    }

    public void clearHttpAuthUsernamePassword()
    {
        WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
    }

    public void clearUsernamePassword()
    {
        WebViewDatabase.getInstance(context).clearUsernamePassword();
    }

    public boolean hasFormData()
    {
        return WebViewDatabase.getInstance(context).hasFormData();
    }

    public boolean hasHttpAuthUsernamePassword()
    {
        return WebViewDatabase.getInstance(context).hasHttpAuthUsernamePassword();
    }

    public boolean hasUsernamePassword()
    {
        return WebViewDatabase.getInstance(context).hasUsernamePassword();
    }
}
