// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.inc247.bridge.ChatSDKJSToNativeBridge;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.constants.ChatSDKConstants;
import com.inc247.errors.ChatSDKError;
import com.inc247.errors.ChatSDKErrorCodes;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inc247:
//            ChatSDK, ChatSDKUtil, ChatSDKResources, ChatSDKWebChromeClient, 
//            ChatSDKEventsCallback

public class ChatSDKWebView extends WebView
{

    private static final int RESULT_OK = -1;
    public static final String TAG = com/inc247/ChatSDKWebView.getSimpleName();
    private static ChatSDKWebView self;
    public static WebSettings settings;
    private Uri mCapturedImageURI;
    protected ValueCallback mFileUploadCallbackFirst;
    protected ValueCallback mFileUploadCallbackSecond;
    private RelativeLayout spinnerLayout;

    private ChatSDKWebView(Context context)
    {
        super(context);
        spinnerLayout = null;
        mCapturedImageURI = null;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            enableWebViewDebugging();
        }
        spinnerLayout = new RelativeLayout(context);
        loadChatSDKWebView(context);
    }

    private void enableWebViewDebugging()
    {
        WebView.setWebContentsDebuggingEnabled(true);
    }

    public static ChatSDKWebView getInstance(Context context)
    {
        if (self == null)
        {
            self = new ChatSDKWebView(context);
        }
        return self;
    }

    private void loadChatSDKWebView(Context context)
    {
        setScrollContainer(true);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        spinnerLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        (new android.widget.RelativeLayout.LayoutParams(-2, -2)).addRule(13);
        spinnerLayout.setBackgroundColor(0);
        if (spinnerLayout.getParent() != null)
        {
            ((ViewManager)spinnerLayout.getParent()).removeView(spinnerLayout);
        }
        ((ViewGroup)ChatSDK.getSDKInstance().activity.getWindow().getDecorView().getRootView()).addView(spinnerLayout);
        settings = getSettings();
        settings.setJavaScriptEnabled(true);
        obj = settings.getUserAgentString();
        if (ChatSDKUtil.isTablet(ChatSDK.getSDKInstance().activity))
        {
            settings.setUserAgentString((new StringBuilder(String.valueOf(obj))).append(" ").append(ChatSDKConstants.USER_AGENT_STRING_TABLET).toString());
        } else
        {
            settings.setUserAgentString((new StringBuilder(String.valueOf(obj))).append(" ").append(ChatSDKConstants.USER_AGENT_STRING_MOBILE).toString());
        }
        settings.setCacheMode(2);
        addJavascriptInterface(new ChatSDKJSToNativeBridge(), "bridge");
        setBackgroundColor(0);
        setWebChromeClient(new ChatSDKWebChromeClient() {

            final ChatSDKWebView this$0;

            public boolean onShowFileChooser(WebView webview, ValueCallback valuecallback, android.webkit.WebChromeClient.FileChooserParams filechooserparams)
            {
                openFileInput(null, valuecallback);
                return true;
            }

            public void openFileChooser(ValueCallback valuecallback)
            {
                openFileChooser(valuecallback, null);
            }

            public void openFileChooser(ValueCallback valuecallback, String s)
            {
                openFileChooser(valuecallback, s, null);
            }

            public void openFileChooser(ValueCallback valuecallback, String s, String s1)
            {
                openFileInput(valuecallback, null);
            }

            
            {
                this$0 = ChatSDKWebView.this;
                super();
            }
        });
        setWebViewClient(new WebViewClient() {

            final ChatSDKWebView this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                spinnerLayout.setVisibility(8);
                ChatSDK.getSDKInstance().maximizeChat();
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
                showProgessDialog(300, "Loading...");
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

            
            {
                this$0 = ChatSDKWebView.this;
                super();
            }
        });
        try
        {
            settings.setDomStorageEnabled(true);
            settings.setAppCacheMaxSize(0x800000L);
            context = context.getCacheDir().getAbsolutePath();
            settings.setAppCachePath(context);
            settings.setAllowFileAccess(true);
            settings.setAppCacheEnabled(true);
            settings.setCacheMode(-1);
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            requestFocus();
            requestFocusFromTouch();
            loadUrl(ChatSDKResources.URL);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(context).append("'}").toString()));
    }

    private void showProgessDialog(int i, String s)
    {
    }

    public void destroyWebView()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKWebView this$0;

            public void run()
            {
                try
                {
                    ChatSDKWebView.self.setVisibility(8);
                    ChatSDKWebView.self.destroy();
                    ChatSDKWebView.self = null;
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
                    return;
                }
            }

            
            {
                this$0 = ChatSDKWebView.this;
                super();
            }
        });
    }

    protected String getFileUploadPromptLabel()
    {
        return "Choose a file";
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 51426 && mFileUploadCallbackSecond != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        if (j == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        intent = null;
        obj = null;
_L6:
        if (mFileUploadCallbackFirst != null)
        {
            mFileUploadCallbackFirst.onReceiveValue(intent);
            mFileUploadCallbackFirst = null;
        }
        if (mFileUploadCallbackSecond != null)
        {
            mFileUploadCallbackSecond.onReceiveValue(obj);
            mFileUploadCallbackSecond = null;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (intent != null) goto _L5; else goto _L4
_L4:
        intent = mCapturedImageURI;
_L7:
        obj = new Uri[1];
        obj[0] = intent;
          goto _L6
        obj;
_L8:
        Exception exception;
        Toast.makeText(ChatSDK.getSDKInstance().activity.getApplicationContext(), (new StringBuilder("activity :")).append(exception).toString(), 1).show();
        exception = null;
          goto _L6
_L5:
        intent = intent.getData();
          goto _L7
        exception;
        intent = null;
          goto _L8
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            ChatSDK.getSDKInstance().minimizeChat();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void openFileInput(ValueCallback valuecallback, ValueCallback valuecallback1)
    {
        if (mFileUploadCallbackFirst != null)
        {
            mFileUploadCallbackFirst.onReceiveValue(null);
        }
        mFileUploadCallbackFirst = valuecallback;
        if (mFileUploadCallbackSecond != null)
        {
            mFileUploadCallbackSecond.onReceiveValue(null);
        }
        mFileUploadCallbackSecond = valuecallback1;
        try
        {
            valuecallback = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "AndroidExampleFolder");
            if (!valuecallback.exists())
            {
                valuecallback.mkdirs();
            }
            mCapturedImageURI = Uri.fromFile(new File((new StringBuilder()).append(valuecallback).append(File.separator).append("IMG_").append(String.valueOf(System.currentTimeMillis())).append(".jpg").toString()));
            valuecallback = new Intent("android.media.action.IMAGE_CAPTURE");
            valuecallback.putExtra("output", mCapturedImageURI);
            valuecallback1 = new Intent("android.intent.action.GET_CONTENT");
            valuecallback1.addCategory("android.intent.category.OPENABLE");
            valuecallback1.setType("image/*");
            valuecallback1 = Intent.createChooser(valuecallback1, "Image Chooser");
            valuecallback1.putExtra("android.intent.extra.INITIAL_INTENTS", new Parcelable[] {
                valuecallback
            });
            ChatSDK.getSDKInstance().activity.startActivityForResult(valuecallback1, 51426);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ValueCallback valuecallback)
        {
            Log.e("Error while choosing file", "An error occured while choosing file");
        }
    }





}
