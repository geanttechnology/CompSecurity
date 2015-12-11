// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            Message, StaticMethods, Messages, RemoteDownload, 
//            MessageFullScreenActivity

final class MessageFullScreen extends Message
{

    private static final String JSON_CONFIG_HTML = "html";
    private static final String MESSAGE_SCHEME = "adbinapp";
    private static final String MESSAGE_SCHEME_PATH_CANCEL = "cancel";
    private static final String MESSAGE_SCHEME_PATH_CONFIRM = "confirm";
    protected String html;
    protected Activity messageFullScreenActivity;
    protected String replacedHtml;
    protected ViewGroup rootViewGroup;
    private WebView webView;

    MessageFullScreen()
    {
    }

    private static void killMessageActivity(MessageFullScreen messagefullscreen)
    {
        messagefullscreen.messageFullScreenActivity.finish();
        messagefullscreen.messageFullScreenActivity.overridePendingTransition(0, 0);
        messagefullscreen.isVisible = false;
    }

    protected boolean initWithPayloadObject(JSONObject jsonobject)
    {
label0:
        {
            while (jsonobject == null || jsonobject.length() <= 0 || !super.initWithPayloadObject(jsonobject)) 
            {
                return false;
            }
            try
            {
                jsonobject = jsonobject.getJSONObject("payload");
                if (jsonobject.length() > 0)
                {
                    break label0;
                }
                StaticMethods.logDebugFormat("Messages - Unable to create fullscreen message \"%s\", payload is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logDebugFormat("Messages - Unable to create fullscreen message \"%s\", payload is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
label1:
        {
            try
            {
                html = jsonobject.getString("html");
                if (html.length() > 0)
                {
                    break label1;
                }
                StaticMethods.logDebugFormat("Messages - Unable to create fullscreen message \"%s\", html is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logDebugFormat("Messages - Unable to create fullscreen message \"%s\", html is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
        jsonobject = jsonobject.getJSONArray("assets");
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        if (jsonobject.length() <= 0) goto _L2; else goto _L3
_L3:
        int k;
        assets = new ArrayList();
        k = jsonobject.length();
        int i = 0;
_L6:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONArray jsonarray = jsonobject.getJSONArray(i);
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        ArrayList arraylist;
        int l;
        if (jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        arraylist = new ArrayList();
        l = jsonarray.length();
        int j = 0;
_L5:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(jsonarray.getString(j));
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        assets.add(arraylist);
        i++;
        if (true) goto _L6; else goto _L2
        jsonobject;
        StaticMethods.logDebugFormat("Messages - No assets found for fullscreen message \"%s\"", new Object[] {
            messageId
        });
_L2:
        return true;
    }

    protected void show()
    {
        Object obj;
        Activity activity;
        HashMap hashmap;
        Object obj1;
        Iterator iterator;
        String s;
        File file;
        int i;
        try
        {
            activity = StaticMethods.getCurrentActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            StaticMethods.logErrorFormat(((StaticMethods.NullActivityException) (obj)).getMessage(), new Object[0]);
            return;
        }
        super.show();
        Messages.setCurrentMessageFullscreen(this);
        hashmap = new HashMap();
        if (assets == null || assets.size() <= 0) goto _L2; else goto _L1
_L1:
        iterator = assets.iterator();
_L3:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (ArrayList)iterator.next();
        i = ((ArrayList) (obj1)).size();
        if (i <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = (String)((ArrayList) (obj1)).get(0);
        obj = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_268;
            }
            file = RemoteDownload.getFileForCachedURL((String)((Iterator) (obj)).next(), "messageImages");
        } while (file == null);
        obj = file.toURI().toString();
_L4:
        if (obj == null)
        {
            obj1 = (String)((ArrayList) (obj1)).get(i - 1);
            boolean flag;
            if (!RemoteDownload.stringIsUrl(((String) (obj1))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = obj1;
            }
        }
        if (obj != null)
        {
            hashmap.put(s, obj);
        }
        if (true) goto _L3; else goto _L2
_L2:
        replacedHtml = StaticMethods.expandTokens(html, hashmap);
        try
        {
            obj = new Intent(activity.getApplicationContext(), com/adobe/mobile/MessageFullScreenActivity);
            ((Intent) (obj)).addFlags(0x10000);
            activity.startActivity(((Intent) (obj)));
            activity.overridePendingTransition(0, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            StaticMethods.logWarningFormat("Messages - Must declare MessageFullScreenActivity in AndroidManifest.xml in order to show full screen messages (%s)", new Object[] {
                ((ActivityNotFoundException) (obj)).getMessage()
            });
        }
        return;
        obj = null;
          goto _L4
    }

    protected void showInRootViewGroup()
    {
        int i = StaticMethods.getCurrentOrientation();
        if (isVisible && orientationWhenShown == i)
        {
            return;
        } else
        {
            orientationWhenShown = i;
            (new Handler(Looper.getMainLooper())).post(new MessageFullScreenRunner());
            return;
        }
    }



/*
    static WebView access$002(MessageFullScreen messagefullscreen, WebView webview)
    {
        messagefullscreen.webView = webview;
        return webview;
    }

*/


    private class MessageFullScreenRunner
        implements Runnable
    {

        private MessageFullScreen message;

        public void run()
        {
            message.webView = new WebView(message.messageFullScreenActivity);
            message.webView.setVerticalScrollBarEnabled(false);
            message.webView.setHorizontalScrollBarEnabled(false);
            message.webView.setBackgroundColor(0);
            message.webView.setWebViewClient(message. new MessageFullScreenWebViewClient());
            WebSettings websettings = message.webView.getSettings();
            websettings.setJavaScriptEnabled(true);
            websettings.setAllowFileAccess(true);
            websettings.setDefaultTextEncodingName("UTF-8");
            message.webView.loadDataWithBaseURL("file:///android_asset/", message.replacedHtml, "text/html", "UTF-8", null);
            if (message.rootViewGroup == null)
            {
                StaticMethods.logErrorFormat("Messages - unable to get root view group from os", new Object[0]);
                MessageFullScreen.killMessageActivity(message);
                return;
            }
            int i;
            int j;
            i = message.rootViewGroup.getMeasuredWidth();
            j = message.rootViewGroup.getMeasuredHeight();
            if (i == 0 || j == 0)
            {
                try
                {
                    StaticMethods.logErrorFormat("Messages - root view hasn't been measured, cannot show message", new Object[0]);
                    MessageFullScreen.killMessageActivity(message);
                    return;
                }
                catch (Exception exception)
                {
                    StaticMethods.logDebugFormat("Messages - Failed to show full screen message (%s)", new Object[] {
                        exception.getMessage()
                    });
                }
                return;
            }
            if (!message.isVisible)
            {
                break MISSING_BLOCK_LABEL_257;
            }
            message.rootViewGroup.addView(message.webView, i, j);
_L2:
            message.isVisible = true;
            return;
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, j, 0.0F);
            translateanimation.setDuration(300L);
            message.webView.setAnimation(translateanimation);
            message.rootViewGroup.addView(message.webView, i, j);
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected MessageFullScreenRunner()
        {
            message = MessageFullScreen.this;
        }

        private class MessageFullScreenWebViewClient extends WebViewClient
        {

            private MessageFullScreen message;

            private void dismissMessage(WebView webview)
            {
                if (message.rootViewGroup == null)
                {
                    StaticMethods.logErrorFormat("Messages - unable to get root view group from os", new Object[0]);
                    return;
                } else
                {
                    TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, message.rootViewGroup.getMeasuredHeight());
                    translateanimation.setDuration(300L);
                    translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                        final MessageFullScreenWebViewClient this$0;

                        public void onAnimationEnd(Animation animation)
                        {
                            MessageFullScreen.killMessageActivity(message);
                        }

                        public void onAnimationRepeat(Animation animation)
                        {
                        }

                        public void onAnimationStart(Animation animation)
                        {
                        }

                    
                    {
                        this$0 = MessageFullScreenWebViewClient.this;
                        super();
                    }
                    });
                    webview.setAnimation(translateanimation);
                    message.rootViewGroup.removeView(webview);
                    return;
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s.startsWith("adbinapp"))
                {
                    if (s.contains("cancel"))
                    {
                        message.viewed();
                        dismissMessage(webview);
                        return true;
                    }
                    if (s.contains("confirm"))
                    {
                        message.clickedThrough();
                        dismissMessage(webview);
                        int i = s.indexOf("url=");
                        if (i >= 0)
                        {
                            s = s.substring(i + 4);
                            HashMap hashmap = new HashMap();
                            if (StaticMethods.getVisitorID() == null)
                            {
                                webview = "";
                            } else
                            {
                                webview = StaticMethods.getVisitorID();
                            }
                            hashmap.put("{userId}", webview);
                            if (StaticMethods.getAID() == null)
                            {
                                webview = "";
                            } else
                            {
                                webview = StaticMethods.getAID();
                            }
                            hashmap.put("{trackingId}", webview);
                            hashmap.put("{messageId}", message.messageId);
                            hashmap.put("{lifetimeValue}", AnalyticsTrackLifetimeValueIncrease.getLifetimeValue().toString());
                            webview = StaticMethods.expandTokens(s, hashmap);
                            try
                            {
                                s = new Intent("android.intent.action.VIEW");
                                s.setData(Uri.parse(webview));
                                message.messageFullScreenActivity.startActivity(s);
                            }
                            // Misplaced declaration of an exception variable
                            catch (WebView webview)
                            {
                                StaticMethods.logDebugFormat("Messages - unable to launch intent from full screen message (%s)", new Object[] {
                                    webview.getMessage()
                                });
                                return true;
                            }
                            return true;
                        }
                    }
                }
                return true;
            }


            protected MessageFullScreenWebViewClient()
            {
                message = MessageFullScreen.this;
            }
        }

    }

}
