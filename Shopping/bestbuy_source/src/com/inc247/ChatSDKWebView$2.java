// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.constants.ChatSDKConstants;
import com.inc247.errors.ChatSDKError;
import com.inc247.errors.ChatSDKErrorCodes;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inc247:
//            ChatSDKWebView, ChatSDK, ChatSDKEventsCallback, ChatSDKResources, 
//            ChatSDKUtil

class  extends WebViewClient
{

    final ChatSDKWebView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        ChatSDKWebView.access$1(ChatSDKWebView.this).setVisibility(8);
        ChatSDK.getSDKInstance().maximizeChat();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        ChatSDKWebView.access$0(ChatSDKWebView.this, 300, "Loading...");
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        webview.loadDataWithBaseURL(null, ChatSDKConstants.CHATSDK_OFFLINEPAGE, null, "UTF-8", null);
        webview = new ChatSDKError(ChatSDKErrorCodes.ChatSDKStartError);
        ChatSDK.getSDKInstance().callback.sendonChatErrorEvent(webview);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.toLowerCase(Locale.US).contains("chatsdk_closedialog"))
        {
            ChatSDK.getSDKInstance().endChat();
        } else
        if (ChatSDKResources.CUSTOM_URL_SCHEME != null && !ChatSDKResources.CUSTOM_URL_SCHEME.equalsIgnoreCase("") && s.toLowerCase(Locale.US).startsWith((new StringBuilder("http://")).append(ChatSDKResources.CUSTOM_URL_SCHEME).toString()))
        {
            webview = ChatSDKEventsCallback.getInstance();
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("url", s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
            }
            webview.sendonNavigationRequest(jsonobject);
        } else
        {
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
            ChatSDK.getSDKInstance().activity.startActivity(webview);
        }
        return true;
    }

    iveToJSBridge()
    {
        this$0 = ChatSDKWebView.this;
        super();
    }
}
