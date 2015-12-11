// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.clouddrive;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.web.MShopWebActivity;
import java.lang.reflect.Method;

public class CloudDriveManageStorageActivity extends MShopWebActivity
{

    public CloudDriveManageStorageActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        String s;
        super.onCreate(bundle);
        s = "";
        bundle = Class.forName("com.amazon.clouddrive.library.CloudDriveLibrary", true, SecondDexEntry.getInstance().getClassLoader());
        Object obj = bundle.getDeclaredMethod("getInstance", (Class[])null).invoke(null, (Object[])null);
        bundle = (String)bundle.getDeclaredMethod("getManageStorageUrl", (Class[])null).invoke(obj, (Class[])null);
_L2:
        getWebView().loadUrl(bundle);
        return;
        Exception exception;
        exception;
        bundle = s;
        if (DebugSettings.isDebugEnabled())
        {
            Log.e("CloudDriveManageStorageActivity", "Exception occurred using reflection to fetch manage storage url for Cloud Drive account", exception);
            bundle = s;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
