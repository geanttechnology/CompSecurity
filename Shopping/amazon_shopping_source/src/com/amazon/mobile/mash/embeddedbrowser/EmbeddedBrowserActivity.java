// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.embeddedbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;

// Referenced classes of package com.amazon.mobile.mash.embeddedbrowser:
//            EmbeddedBrowserContainer

public class EmbeddedBrowserActivity extends Activity
    implements CordovaInterface
{

    private EmbeddedBrowserContainer mEmbeddedBrowserContainer;

    public EmbeddedBrowserActivity()
    {
    }

    public Activity getActivity()
    {
        return this;
    }

    public ExecutorService getThreadPool()
    {
        return null;
    }

    public void onBackPressed()
    {
        if (!mEmbeddedBrowserContainer.goBack())
        {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mEmbeddedBrowserContainer = new EmbeddedBrowserContainer(this);
        setContentView(mEmbeddedBrowserContainer);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 1, 0, com.amazon.mobile.mash.R.string.open_in_browser);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        mEmbeddedBrowserContainer.destroy();
        super.onDestroy();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (menuitem.getItemId() == 1)
        {
            mEmbeddedBrowserContainer.openInExternalBrowser();
        }
        return super.onMenuItemSelected(i, menuitem);
    }

    public Object onMessage(String s, Object obj)
    {
        return null;
    }

    public void onPause()
    {
        super.onPause();
        mEmbeddedBrowserContainer.handleOnPause();
    }

    public void onResume()
    {
        super.onResume();
        mEmbeddedBrowserContainer.handleOnResume();
    }

    public void setActivityResultCallback(CordovaPlugin cordovaplugin)
    {
    }

    public void startActivityForResult(CordovaPlugin cordovaplugin, Intent intent, int i)
    {
    }
}
