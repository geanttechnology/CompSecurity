// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMNotificationManager;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            DeepLinkUtils

public class FbDeferredDeepLinkManager
{
    public static final class DL_STATE extends Enum
    {

        private static final DL_STATE $VALUES[];
        public static final DL_STATE DL_CONSUMED;
        public static final DL_STATE DL_EXPIRED;
        public static final DL_STATE DL_RECEIVED;
        public static final DL_STATE DL_REQUESTED;
        public static final DL_STATE INIT;

        public static DL_STATE valueOf(String s)
        {
            return (DL_STATE)Enum.valueOf(com/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE, s);
        }

        public static DL_STATE[] values()
        {
            return (DL_STATE[])$VALUES.clone();
        }

        static 
        {
            INIT = new DL_STATE("INIT", 0);
            DL_REQUESTED = new DL_STATE("DL_REQUESTED", 1);
            DL_RECEIVED = new DL_STATE("DL_RECEIVED", 2);
            DL_CONSUMED = new DL_STATE("DL_CONSUMED", 3);
            DL_EXPIRED = new DL_STATE("DL_EXPIRED", 4);
            $VALUES = (new DL_STATE[] {
                INIT, DL_REQUESTED, DL_RECEIVED, DL_CONSUMED, DL_EXPIRED
            });
        }

        private DL_STATE(String s, int i)
        {
            super(s, i);
        }
    }

    public static class DeferredDeepLinkInfo
    {

        List images;

        public DeferredDeepLinkInfo()
        {
        }
    }


    public static final FbDeferredDeepLinkManager INSTANCE = new FbDeferredDeepLinkManager();
    DL_STATE currentState;
    DeferredDeepLinkInfo deepLinkInfo;
    Object mutex;
    String originalDeepLinkUrl;

    private FbDeferredDeepLinkManager()
    {
        mutex = new Object();
        currentState = DL_STATE.INIT;
    }

    private void extractDeepLinkInfo(String s)
    {
        if (s != null)
        {
            s = Uri.parse(s);
            if (DeepLinkUtils.isValidDeepLink(s))
            {
                s = s.getQueryParameter("reg_screen_info");
                if (s != null)
                {
                    deepLinkInfo = DeepLinkUtils.handleFbDeferredDeepLinkJSON(s);
                }
            }
        }
    }

    public void fetchFbDeferredDeepLink()
    {
        synchronized (mutex)
        {
            if (currentState == DL_STATE.INIT)
            {
                currentState = DL_STATE.DL_REQUESTED;
                AppLinkData.fetchDeferredAppLinkData(PMApplication.getContext(), new com.facebook.applinks.AppLinkData.CompletionHandler() {

                    final FbDeferredDeepLinkManager this$0;

                    public void onDeferredAppLinkDataFetched(AppLinkData applinkdata)
                    {
                        if (applinkdata != null)
                        {
                            currentState = DL_STATE.DL_RECEIVED;
                            HashMap hashmap = new HashMap();
                            hashmap.put("ev", "fbdl");
                            hashmap.put("s", "dlf");
                            hashmap.put("lrf", FbDeferredDeepLinkManager.INSTANCE.getDeepLinkUrl());
                            PMApi.trackDeepLink(hashmap);
                            originalDeepLinkUrl = applinkdata.getArgumentBundle().getString("com.facebook.platform.APPLINK_NATIVE_URL");
                            extractDeepLinkInfo(originalDeepLinkUrl);
                            PMNotificationManager.fireNotification("com.poshmark.intents.PROFILE_UPDATED");
                        }
                    }

            
            {
                this$0 = FbDeferredDeepLinkManager.this;
                super();
            }
                });
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public DL_STATE getCurrentDeepLinkProcessingState()
    {
        return currentState;
    }

    public String getDeepLinkUrl()
    {
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        Object obj = null;
        DeepLinkUtils.DeepLinkWrapper deeplinkwrapper;
        if (originalDeepLinkUrl != null)
        {
            obj = (new GsonBuilder()).create();
            deeplinkwrapper = new DeepLinkUtils.DeepLinkWrapper();
            deeplinkwrapper.url = originalDeepLinkUrl;
            if (obj instanceof Gson)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            obj = ((Gson) (obj)).toJson(deeplinkwrapper, com/poshmark/utils/DeepLinkUtils$DeepLinkWrapper);
        }
_L1:
        obj1;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        obj = GsonInstrumentation.toJson((Gson)obj, deeplinkwrapper, com/poshmark/utils/DeepLinkUtils$DeepLinkWrapper);
          goto _L1
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getImageUrl()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        if (deepLinkInfo == null || deepLinkInfo.images.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        s = (String)deepLinkInfo.images.get(0);
        return s;
        obj;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void markAsExpired()
    {
        currentState = DL_STATE.DL_EXPIRED;
    }


}
