// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.errors.ChatSDKError;
import com.inc247.errors.ChatSDKErrorCodes;

// Referenced classes of package com.inc247:
//            ChatSDK, ChatSDKUtil, ChatSDKEventsCallback

public class ChatSDKWebChromeClient extends WebChromeClient
{

    public ChatSDKWebChromeClient()
    {
    }

    public boolean onJsAlert(WebView webview, String s, String s1, final JsResult result)
    {
        try
        {
            webview = new android.app.AlertDialog.Builder(ChatSDK.getSDKInstance().activity);
            webview.setMessage(s1);
            webview.setTitle("Alert");
            webview.setCancelable(true);
            webview.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final ChatSDKWebChromeClient this$0;
                private final JsResult val$result;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    result.confirm();
                }

            
            {
                this$0 = ChatSDKWebChromeClient.this;
                result = jsresult;
                super();
            }
            });
            webview.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

                final ChatSDKWebChromeClient this$0;
                private final JsResult val$result;

                public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
                {
                    if (i == 4)
                    {
                        result.confirm();
                        return false;
                    } else
                    {
                        return true;
                    }
                }

            
            {
                this$0 = ChatSDKWebChromeClient.this;
                result = jsresult;
                super();
            }
            });
            webview.create();
            webview.show();
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(webview).append("'}").toString()));
            ChatSDKEventsCallback.getInstance().sendonChatErrorEvent(new ChatSDKError(ChatSDKErrorCodes.ChatSDKUnknownError));
            return false;
        }
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, final JsResult result)
    {
        webview = new android.app.AlertDialog.Builder(ChatSDK.getSDKInstance().activity);
        webview.setMessage(s1);
        webview.setTitle("Confirm");
        webview.setCancelable(true);
        webview.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final ChatSDKWebChromeClient this$0;
            private final JsResult val$result;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                result.confirm();
            }

            
            {
                this$0 = ChatSDKWebChromeClient.this;
                result = jsresult;
                super();
            }
        });
        webview.setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final ChatSDKWebChromeClient this$0;
            private final JsResult val$result;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                result.cancel();
            }

            
            {
                this$0 = ChatSDKWebChromeClient.this;
                result = jsresult;
                super();
            }
        });
        webview.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ChatSDKWebChromeClient this$0;
            private final JsResult val$result;

            public void onCancel(DialogInterface dialoginterface)
            {
                result.cancel();
            }

            
            {
                this$0 = ChatSDKWebChromeClient.this;
                result = jsresult;
                super();
            }
        });
        webview.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final ChatSDKWebChromeClient this$0;
            private final JsResult val$result;

            public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
            {
                if (i == 4)
                {
                    result.cancel();
                    return false;
                } else
                {
                    return true;
                }
            }

            
            {
                this$0 = ChatSDKWebChromeClient.this;
                result = jsresult;
                super();
            }
        });
        webview.create();
        webview.show();
        return true;
    }

    public void onReachedMaxAppCacheSize(long l, long l1, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        quotaupdater.updateQuota(2L * l);
    }
}
