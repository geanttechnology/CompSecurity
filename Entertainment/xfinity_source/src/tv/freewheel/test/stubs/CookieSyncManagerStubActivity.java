// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.test.stubs;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;

public class CookieSyncManagerStubActivity extends Activity
{

    private WebView mWebView;

    public CookieSyncManagerStubActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        CookieSyncManager.createInstance(this);
        mWebView = new WebView(this);
        setContentView(mWebView);
    }

    protected void onResume()
    {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    protected void onStop()
    {
        super.onStop();
        CookieSyncManager.getInstance().stopSync();
    }
}
