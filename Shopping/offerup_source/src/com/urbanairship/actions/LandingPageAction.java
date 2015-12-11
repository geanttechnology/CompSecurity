// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import com.urbanairship.util.UriUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.urbanairship.actions:
//            Action, ActionArguments, Situation, ActionValue, 
//            ActionResult

public class LandingPageAction extends Action
{

    public static final String CACHE_ON_RECEIVE_KEY = "cache_on_receive";
    public static final String DEFAULT_REGISTRY_NAME = "landing_page_action";
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^p";
    public static final String SHOW_LANDING_PAGE_INTENT_ACTION = "com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION";
    public static final String URL_KEY = "url";

    public LandingPageAction()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        _cls3..SwitchMap.com.urbanairship.actions.Situation[actionarguments.getSituation().ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 46
    //                   2 46
    //                   3 46
    //                   4 46
    //                   5 46;
           goto _L1 _L2 _L2 _L2 _L2 _L2
_L1:
        return false;
_L2:
        if (parseUri(actionarguments) != null)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected Uri parseUri(ActionArguments actionarguments)
    {
        Object obj;
        if (actionarguments.getValue().getMap() != null)
        {
            actionarguments = actionarguments.getValue().getMap().opt("url").getString();
        } else
        {
            actionarguments = actionarguments.getValue().getString();
        }
        if (actionarguments == null)
        {
            obj = null;
        } else
        {
            obj = UriUtils.parse(actionarguments);
            if (UAStringUtil.isEmpty(((Uri) (obj)).toString()))
            {
                return null;
            }
            actionarguments = ((ActionArguments) (obj));
            if ("u".equals(((Uri) (obj)).getScheme()))
            {
                try
                {
                    actionarguments = URLEncoder.encode(((Uri) (obj)).getSchemeSpecificPart(), "UTF-8");
                }
                // Misplaced declaration of an exception variable
                catch (ActionArguments actionarguments)
                {
                    Logger.warn((new StringBuilder("LandingPageAction - Unable to decode ")).append(((Uri) (obj)).getSchemeSpecificPart()).toString());
                    return null;
                }
                obj = UAirship.shared().getAirshipConfigOptions();
                actionarguments = Uri.parse((new StringBuilder()).append(((AirshipConfigOptions) (obj)).landingPageContentURL).append(((AirshipConfigOptions) (obj)).getAppKey()).append("/").append(actionarguments).toString());
            }
            obj = actionarguments;
            if (UAStringUtil.isEmpty(actionarguments.getScheme()))
            {
                return Uri.parse((new StringBuilder("https://")).append(actionarguments).toString());
            }
        }
        return ((Uri) (obj));
    }

    public ActionResult perform(final ActionArguments actionIntent)
    {
        final Uri uri = parseUri(actionIntent);
        _cls3..SwitchMap.com.urbanairship.actions.Situation[actionIntent.getSituation().ordinal()];
        JVM INSTR tableswitch 1 1: default 36
    //                   1 86;
           goto _L1 _L2
_L1:
        actionIntent = (new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", uri)).addFlags(0x30000000).setPackage(UAirship.getPackageName());
        (new Handler(Looper.getMainLooper())).post(new _cls2());
_L4:
        return ActionResult.newEmptyResult();
_L2:
        if (shouldCacheOnReceive(actionIntent))
        {
            (new Handler(Looper.getMainLooper())).postAtFrontOfQueue(new _cls1());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean shouldCacheOnReceive(ActionArguments actionarguments)
    {
        boolean flag = false;
        if (actionarguments.getValue().getMap() != null)
        {
            flag = actionarguments.getValue().getMap().opt("cache_on_receive").getBoolean(false);
        }
        return flag;
    }

    private class _cls3
    {

        static final int $SwitchMap$com$urbanairship$actions$Situation[];

        static 
        {
            $SwitchMap$com$urbanairship$actions$Situation = new int[Situation.values().length];
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.PUSH_RECEIVED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.PUSH_OPENED.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.WEB_VIEW_INVOCATION.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.MANUAL_INVOCATION.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$urbanairship$actions$Situation[Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls2
        implements Runnable
    {

        final LandingPageAction this$0;
        final Intent val$actionIntent;
        final Uri val$uri;

        public void run()
        {
            try
            {
                UAirship.getApplicationContext().startActivity(actionIntent);
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Logger.error((new StringBuilder("Unable to view a landing page for uri ")).append(uri).append(". The landing page'sintent filter is missing the scheme: ").append(uri.getScheme()).toString());
            }
        }

        _cls2()
        {
            this$0 = LandingPageAction.this;
            actionIntent = intent;
            uri = uri1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final LandingPageAction this$0;
        final Uri val$uri;

        public void run()
        {
            UAWebView uawebview = new UAWebView(UAirship.getApplicationContext());
            if (uri.getScheme().equalsIgnoreCase("message"))
            {
                String s = uri.getSchemeSpecificPart();
                com.urbanairship.richpush.RichPushMessage richpushmessage = UAirship.shared().getRichPushManager().getRichPushInbox().getMessage(s);
                if (richpushmessage != null)
                {
                    uawebview.loadRichPushMessage(richpushmessage);
                    return;
                } else
                {
                    Logger.debug((new StringBuilder("LandingPageAction - Message ")).append(s).append(" not found.").toString());
                    return;
                }
            } else
            {
                uawebview.loadUrl(uri.toString());
                return;
            }
        }

        _cls1()
        {
            this$0 = LandingPageAction.this;
            uri = uri1;
            super();
        }
    }

}
