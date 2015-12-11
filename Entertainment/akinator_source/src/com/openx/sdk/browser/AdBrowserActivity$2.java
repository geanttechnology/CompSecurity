// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.browser;

import android.webkit.WebView;
import com.openx.sdk.event.OXMEvent;
import com.openx.sdk.event.OXMEventsListener;

// Referenced classes of package com.openx.sdk.browser:
//            BrowserControlsEventsListener, AdBrowserActivity

class this._cls0
    implements BrowserControlsEventsListener
{

    final AdBrowserActivity this$0;

    public boolean canGoBack()
    {
        return AdBrowserActivity.access$100(AdBrowserActivity.this).canGoBack();
    }

    public boolean canGoForward()
    {
        return AdBrowserActivity.access$100(AdBrowserActivity.this).canGoForward();
    }

    public void closeBrowser()
    {
        AdBrowserActivity.access$200(AdBrowserActivity.this).fireEvent(new OXMEvent(com.openx.sdk.event.e.CLOSE_ACTIVE_INTERNAL_WINDOW, this, null));
        finish();
    }

    public String getCurrentURL()
    {
        if (AdBrowserActivity.access$100(AdBrowserActivity.this) != null)
        {
            return AdBrowserActivity.access$100(AdBrowserActivity.this).getUrl();
        } else
        {
            return null;
        }
    }

    public void onGoBack()
    {
        if (AdBrowserActivity.access$100(AdBrowserActivity.this) != null)
        {
            AdBrowserActivity.access$100(AdBrowserActivity.this).goBack();
        }
    }

    public void onGoForward()
    {
        if (AdBrowserActivity.access$100(AdBrowserActivity.this) != null)
        {
            AdBrowserActivity.access$100(AdBrowserActivity.this).goForward();
        }
    }

    public void onRelaod()
    {
        if (AdBrowserActivity.access$100(AdBrowserActivity.this) != null)
        {
            AdBrowserActivity.access$100(AdBrowserActivity.this).reload();
        }
    }

    public void setCreatorOfView(Object obj)
    {
    }

    sListener()
    {
        this$0 = AdBrowserActivity.this;
        super();
    }
}
