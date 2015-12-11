// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.widget;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.actions.ActionRunRequestFactory;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.Situation;
import com.urbanairship.js.NativeBridge;
import com.urbanairship.js.Whitelist;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushMessage;
import com.urbanairship.richpush.RichPushUser;
import com.urbanairship.util.UriUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.widget:
//            UAWebView

public class UAWebViewClient extends WebViewClient
{

    public static final String CLOSE_COMMAND = "close";
    public static final String RUN_ACTIONS_COMMAND = "run-actions";
    private static final String RUN_ACTIONS_COMMAND_CALLBACK = "android-run-action-cb";
    public static final String RUN_BASIC_ACTIONS_COMMAND = "run-basic-actions";
    public static final String UA_ACTION_SCHEME = "uairship";
    private static SimpleDateFormat dateFormatter;
    private ActionCompletionCallback actionCompletionCallback;
    private final ActionRunRequestFactory actionRunRequestFactory;
    private final Map authRequestCredentials;

    public UAWebViewClient()
    {
        this(new ActionRunRequestFactory());
    }

    UAWebViewClient(ActionRunRequestFactory actionrunrequestfactory)
    {
        authRequestCredentials = new HashMap();
        actionRunRequestFactory = actionrunrequestfactory;
    }

    private String createGetter(String s, long l)
    {
        return String.format(Locale.US, "_UAirship.%s = function(){return %d;};", new Object[] {
            s, Long.valueOf(l)
        });
    }

    private String createGetter(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = "null";
        } else
        {
            s1 = JSONObject.quote(s1);
        }
        return String.format(Locale.US, "_UAirship.%s = function(){return %s;};", new Object[] {
            s, s1
        });
    }

    private Map decodeActionArguments(Uri uri, boolean flag)
    {
        Map map;
        HashMap hashmap;
        Iterator iterator;
        map = UriUtils.getQueryParameters(uri);
        if (map == null)
        {
            return null;
        }
        hashmap = new HashMap();
        iterator = map.keySet().iterator();
_L6:
        String s;
        ArrayList arraylist;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        arraylist = new ArrayList();
        if (map.get(s) == null)
        {
            Logger.warn((new StringBuilder("No arguments to decode for actionName: ")).append(s).toString());
            return null;
        }
        iterator1 = ((List)map.get(s)).iterator();
_L2:
        String s1;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        s1 = (String)iterator1.next();
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = JsonValue.wrap(s1);
_L3:
        arraylist.add(new ActionValue(uri));
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            uri = JsonValue.parseString(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            Logger.warn((new StringBuilder("Invalid json. Unable to create action argument ")).append(s).append(" with args: ").append(s1).toString(), uri);
            return null;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        hashmap.put(s, arraylist);
        if (true) goto _L6; else goto _L5
_L5:
        if (hashmap.isEmpty())
        {
            Logger.warn("Error no action names are present in the actions key set");
            return null;
        } else
        {
            return hashmap;
        }
    }

    private RichPushMessage getMessage(WebView webview)
    {
        if (webview instanceof UAWebView)
        {
            return ((UAWebView)webview).getCurrentMessage();
        } else
        {
            return null;
        }
    }

    private void injectJavascriptInterface(WebView webview)
    {
        RichPushMessage richpushmessage = getMessage(webview);
        if (dateFormatter == null)
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
            dateFormatter = simpledateformat;
            simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        StringBuilder stringbuilder = new StringBuilder("var _UAirship = {};");
        StringBuilder stringbuilder1 = stringbuilder.append(createGetter("getDeviceModel", Build.MODEL));
        Object obj;
        long l;
        if (richpushmessage != null)
        {
            obj = richpushmessage.getMessageId();
        } else
        {
            obj = null;
        }
        stringbuilder1 = stringbuilder1.append(createGetter("getMessageId", ((String) (obj))));
        if (richpushmessage != null)
        {
            obj = richpushmessage.getTitle();
        } else
        {
            obj = null;
        }
        stringbuilder1 = stringbuilder1.append(createGetter("getMessageTitle", ((String) (obj))));
        if (richpushmessage != null)
        {
            obj = dateFormatter.format(richpushmessage.getSentDate());
        } else
        {
            obj = null;
        }
        obj = stringbuilder1.append(createGetter("getMessageSentDate", ((String) (obj))));
        if (richpushmessage != null)
        {
            l = richpushmessage.getSentDateMS();
        } else
        {
            l = -1L;
        }
        ((StringBuilder) (obj)).append(createGetter("getMessageSentDateMS", l)).append(createGetter("getUserId", UAirship.shared().getRichPushManager().getRichPushUser().getId()));
        stringbuilder.append(NativeBridge.getJavaScriptSource());
        obj = stringbuilder.toString();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            webview.evaluateJavascript(((String) (obj)), null);
            return;
        } else
        {
            webview.loadUrl((new StringBuilder("javascript:")).append(((String) (obj))).toString());
            return;
        }
    }

    private boolean interceptUrl(WebView webview, String s)
    {
        Uri uri;
        String s1;
        byte byte0;
        if (webview == null || s == null)
        {
            return false;
        }
        uri = Uri.parse(s);
        if (uri.getHost() == null || !uri.getScheme().equals("uairship") || !isWhiteListed(webview.getUrl()))
        {
            return false;
        }
        Logger.verbose((new StringBuilder("Intercepting: ")).append(s).toString());
        s1 = uri.getHost();
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 124
    //                   -1507513413: 207
    //                   -189575524: 191
    //                   94756344: 239
    //                   716793782: 223;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_239;
_L6:
        switch (byte0)
        {
        default:
            Logger.warn((new StringBuilder("Unrecognized command: ")).append(uri.getHost()).append(" for URL: ").append(s).toString());
            return false;

        case 0: // '\0'
            Logger.info((new StringBuilder("Running run basic actions command for URL: ")).append(s).toString());
            runActions(webview, decodeActionArguments(uri, true));
            return true;

        case 1: // '\001'
            Logger.info((new StringBuilder("Running run actions command for URL: ")).append(s).toString());
            runActions(webview, decodeActionArguments(uri, false));
            return true;

        case 2: // '\002'
            Logger.info((new StringBuilder("Running run actions command with callback for URL: ")).append(s).toString());
            s = uri.getPathSegments();
            if (s.size() == 3)
            {
                Logger.info((new StringBuilder("Action: ")).append((String)s.get(0)).append(", Args: ").append((String)s.get(1)).append(", Callback: ").append((String)s.get(2)).toString());
                runAction(webview, (String)s.get(0), (String)s.get(1), (String)s.get(2));
            } else
            {
                Logger.error("Unable to run action, invalid number of arguments.");
            }
            return true;

        case 3: // '\003'
            Logger.info((new StringBuilder("Running close command for URL: ")).append(s).toString());
            onClose(webview);
            return true;
        }
_L3:
        if (s1.equals("run-basic-actions"))
        {
            byte0 = 0;
        }
          goto _L6
_L2:
        if (s1.equals("run-actions"))
        {
            byte0 = 1;
        }
          goto _L6
_L5:
        if (s1.equals("android-run-action-cb"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s1.equals("close"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    private boolean isWhiteListed(String s)
    {
        return UAirship.shared().getWhitelist().isWhitelisted(s);
    }

    private void runAction(final WebView webView, final String name, String s, final String callbackKey)
    {
        ActionValue actionvalue;
        RichPushMessage richpushmessage;
        try
        {
            actionvalue = new ActionValue(JsonValue.parseString(s));
        }
        // Misplaced declaration of an exception variable
        catch (final String name)
        {
            Logger.warn((new StringBuilder("Unable to parse action argument value: ")).append(s).toString(), name);
            triggerCallback(webView, "Unable to decode arguments payload", new ActionValue(), callbackKey);
            return;
        }
        s = new Bundle();
        richpushmessage = getMessage(webView);
        if (richpushmessage != null)
        {
            s.putString("com.urbanairship.RICH_PUSH_ID_METADATA", richpushmessage.getMessageId());
        }
        actionRunRequestFactory.createActionRequest(name).setMetadata(s).setValue(actionvalue).setSituation(Situation.WEB_VIEW_INVOCATION).run(new _cls2());
    }

    private void runActions(WebView webview, Map map)
    {
        if (map != null)
        {
            Bundle bundle = new Bundle();
            webview = getMessage(webview);
            if (webview != null)
            {
                bundle.putString("com.urbanairship.RICH_PUSH_ID_METADATA", webview.getMessageId());
            }
            webview = map.keySet().iterator();
            while (webview.hasNext()) 
            {
                String s = (String)webview.next();
                Iterator iterator = ((List)map.get(s)).iterator();
                while (iterator.hasNext()) 
                {
                    ActionValue actionvalue = (ActionValue)iterator.next();
                    actionRunRequestFactory.createActionRequest(s).setValue(actionvalue).setMetadata(bundle).setSituation(Situation.WEB_VIEW_INVOCATION).run(new _cls1());
                }
            }
        }
    }

    private void triggerCallback(WebView webview, String s, ActionValue actionvalue, String s1)
    {
        s1 = String.format("'%s'", new Object[] {
            s1
        });
        if (s == null)
        {
            s = "null";
        } else
        {
            s = String.format(Locale.US, "new Error(%s)", new Object[] {
                JSONObject.quote(s)
            });
        }
        actionvalue = actionvalue.toString();
        s = String.format(Locale.US, "UAirship.finishAction(%s, %s, %s);", new Object[] {
            s, actionvalue, s1
        });
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            webview.evaluateJavascript(s, null);
            return;
        } else
        {
            webview.loadUrl((new StringBuilder("javascript:")).append(s).toString());
            return;
        }
    }

    void addAuthRequestCredentials(String s, String s1, String s2)
    {
        authRequestCredentials.put(s, new Credentials(s1, s2));
    }

    public void onClose(WebView webview)
    {
        webview.getRootView().dispatchKeyEvent(new KeyEvent(0, 4));
        webview.getRootView().dispatchKeyEvent(new KeyEvent(1, 4));
    }

    public void onLoadResource(WebView webview, String s)
    {
        interceptUrl(webview, s);
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (webview == null)
        {
            return;
        }
        if (!isWhiteListed(s))
        {
            Logger.debug((new StringBuilder("UAWebViewClient - ")).append(s).append(" is not a white listed URL. Urban Airship Javascript interface will not be accessible.").toString());
            return;
        } else
        {
            Logger.info("Loading UrbanAirship Javascript interface.");
            injectJavascriptInterface(webview);
            return;
        }
    }

    public void onReceivedHttpAuthRequest(WebView webview, HttpAuthHandler httpauthhandler, String s, String s1)
    {
        webview = (Credentials)authRequestCredentials.get(s);
        if (webview != null)
        {
            httpauthhandler.proceed(((Credentials) (webview)).username, ((Credentials) (webview)).password);
        }
    }

    void removeAuthRequestCredentials(String s)
    {
        authRequestCredentials.remove(s);
    }

    public void setActionCompletionCallback(ActionCompletionCallback actioncompletioncallback)
    {
        this;
        JVM INSTR monitorenter ;
        actionCompletionCallback = actioncompletioncallback;
        this;
        JVM INSTR monitorexit ;
        return;
        actioncompletioncallback;
        this;
        JVM INSTR monitorexit ;
        throw actioncompletioncallback;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return interceptUrl(webview, s);
    }



    private class _cls2
        implements ActionCompletionCallback
    {

        final UAWebViewClient this$0;
        final String val$callbackKey;
        final String val$name;
        final WebView val$webView;

        public void onFinish(ActionArguments actionarguments, ActionResult actionresult)
        {
            String s = null;
            _cls3..SwitchMap.com.urbanairship.actions.ActionResult.Status[actionresult.getStatus().ordinal()];
            JVM INSTR tableswitch 1 3: default 40
        //                       1 89
        //                       2 109
        //                       3 129;
               goto _L1 _L2 _L3 _L4
_L1:
            triggerCallback(webView, s, actionresult.getValue(), callbackKey);
            this;
            JVM INSTR monitorenter ;
            if (actionCompletionCallback != null)
            {
                actionCompletionCallback.onFinish(actionarguments, actionresult);
            }
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            s = String.format("Action %s not found", new Object[] {
                name
            });
            continue; /* Loop/switch isn't completed */
_L3:
            s = String.format("Action %s rejected its arguments", new Object[] {
                name
            });
            continue; /* Loop/switch isn't completed */
_L4:
            if (actionresult.getException() != null)
            {
                s = actionresult.getException().getMessage();
            } else
            {
                s = String.format("Action %s failed with unspecified error", new Object[] {
                    name
                });
            }
            if (true) goto _L1; else goto _L5
_L5:
            actionarguments;
            this;
            JVM INSTR monitorexit ;
            throw actionarguments;
        }

        _cls2()
        {
            this$0 = UAWebViewClient.this;
            name = s;
            webView = webview;
            callbackKey = s1;
            super();
        }

        private class _cls3
        {

            static final int $SwitchMap$com$urbanairship$actions$ActionResult$Status[];

            static 
            {
                $SwitchMap$com$urbanairship$actions$ActionResult$Status = new int[com.urbanairship.actions.ActionResult.Status.values().length];
                try
                {
                    $SwitchMap$com$urbanairship$actions$ActionResult$Status[com.urbanairship.actions.ActionResult.Status.ACTION_NOT_FOUND.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$urbanairship$actions$ActionResult$Status[com.urbanairship.actions.ActionResult.Status.REJECTED_ARGUMENTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$urbanairship$actions$ActionResult$Status[com.urbanairship.actions.ActionResult.Status.EXECUTION_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

    }


    private class _cls1
        implements ActionCompletionCallback
    {

        final UAWebViewClient this$0;

        public void onFinish(ActionArguments actionarguments, ActionResult actionresult)
        {
            this;
            JVM INSTR monitorenter ;
            if (actionCompletionCallback != null)
            {
                actionCompletionCallback.onFinish(actionarguments, actionresult);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            actionarguments;
            this;
            JVM INSTR monitorexit ;
            throw actionarguments;
        }

        _cls1()
        {
            this$0 = UAWebViewClient.this;
            super();
        }
    }


    private class Credentials
    {

        final String password;
        final String username;

        Credentials(String s, String s1)
        {
            username = s;
            password = s1;
        }
    }

}
