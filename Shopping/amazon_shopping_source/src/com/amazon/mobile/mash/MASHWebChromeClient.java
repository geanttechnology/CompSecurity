// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash:
//            MASHWebView

public class MASHWebChromeClient extends CordovaChromeClient
{

    public MASHWebChromeClient(CordovaInterface cordovainterface, MASHWebView mashwebview)
    {
        super(cordovainterface, mashwebview);
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        if (!MASHDebug.isEnabled() && consolemessage.messageLevel() != android.webkit.ConsoleMessage.MessageLevel.ERROR)
        {
            return true;
        } else
        {
            return super.onConsoleMessage(consolemessage);
        }
    }

    public void onProgressChanged(WebView webview, int i)
    {
        if (MASHDebug.isEnabled())
        {
            Log.v("MASHWebChromeClient", (new StringBuilder()).append("onProgressChanged, newProgress = ").append(i).append(" %").toString());
        }
        super.onProgressChanged(webview, i);
    }
}
