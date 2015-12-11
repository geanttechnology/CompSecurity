// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.poshmark.http.api.PMApi;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import java.util.HashMap;
import org.json.JSONObject;

public class DeferredDeepLinkManager
{
    public static class BranchDeepLinkStatus
    {

        boolean clicked_branch_link;
        boolean is_first_session;

        public BranchDeepLinkStatus()
        {
        }
    }

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
            return (DL_STATE)Enum.valueOf(com/poshmark/utils/DeferredDeepLinkManager$DL_STATE, s);
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


    public static final DeferredDeepLinkManager INSTANCE = new DeferredDeepLinkManager();
    String branchDeepLinkJSON;
    GsonBuilder builder;
    DL_STATE currentState;
    Object mutex;
    String originalDeepLinkUrl;
    Uri savedUri;
    BranchDeepLinkStatus status;

    private DeferredDeepLinkManager()
    {
        mutex = new Object();
        currentState = DL_STATE.INIT;
        builder = new GsonBuilder();
    }

    private void extractDeepLinkInfo(String s)
    {
    }

    public String getBranchDeepLinkJson()
    {
        return branchDeepLinkJSON;
    }

    public DL_STATE getCurrentDeepLinkProcessingState()
    {
        return currentState;
    }

    public String getDirectDeepLinkJson()
    {
        Object obj;
        DeepLinkUtils.DeepLinkWrapper deeplinkwrapper;
label0:
        {
            obj = null;
            if (originalDeepLinkUrl != null)
            {
                obj = builder.create();
                deeplinkwrapper = new DeepLinkUtils.DeepLinkWrapper();
                deeplinkwrapper.url = originalDeepLinkUrl;
                if (obj instanceof Gson)
                {
                    break label0;
                }
                obj = ((Gson) (obj)).toJson(deeplinkwrapper, com/poshmark/utils/DeepLinkUtils$DeepLinkWrapper);
            }
            return ((String) (obj));
        }
        return GsonInstrumentation.toJson((Gson)obj, deeplinkwrapper, com/poshmark/utils/DeepLinkUtils$DeepLinkWrapper);
    }

    public void init(Uri uri, Activity activity)
    {
        if (uri != null)
        {
            savedUri = uri;
        }
        Branch.getInstance().initSession(new io.branch.referral.Branch.BranchReferralInitListener() {

            final DeferredDeepLinkManager this$0;

            public void onInitFinished(JSONObject jsonobject, BranchError brancherror)
            {
                if (brancherror == null)
                {
                    Gson gson = builder.create();
                    DeferredDeepLinkManager deferreddeeplinkmanager;
                    if (!(jsonobject instanceof JSONObject))
                    {
                        jsonobject = jsonobject.toString();
                    } else
                    {
                        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
                    }
                    deferreddeeplinkmanager = DeferredDeepLinkManager.this;
                    if (!(gson instanceof Gson))
                    {
                        brancherror = ((BranchError) (gson.fromJson(jsonobject, com/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus)));
                    } else
                    {
                        brancherror = ((BranchError) (GsonInstrumentation.fromJson((Gson)gson, jsonobject, com/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus)));
                    }
                    deferreddeeplinkmanager.status = (BranchDeepLinkStatus)brancherror;
                    if (currentState == DL_STATE.INIT)
                    {
                        if (status.clicked_branch_link)
                        {
                            currentState = DL_STATE.DL_RECEIVED;
                            branchDeepLinkJSON = jsonobject;
                            jsonobject = new HashMap();
                            jsonobject.put("ev", "brhdl");
                            jsonobject.put("s", "dlf");
                            jsonobject.put("brparams", branchDeepLinkJSON);
                            PMApi.trackDeepLink(jsonobject);
                        } else
                        if (savedUri != null)
                        {
                            originalDeepLinkUrl = savedUri.toString();
                            currentState = DL_STATE.DL_RECEIVED;
                            jsonobject = new DeepLinkUtils.DeepLinkWrapper();
                            jsonobject.url = originalDeepLinkUrl;
                            if (!(gson instanceof Gson))
                            {
                                jsonobject = gson.toJson(jsonobject, com/poshmark/utils/DeepLinkUtils$DeepLinkWrapper);
                            } else
                            {
                                jsonobject = GsonInstrumentation.toJson((Gson)gson, jsonobject, com/poshmark/utils/DeepLinkUtils$DeepLinkWrapper);
                            }
                            brancherror = new HashMap();
                            brancherror.put("drct", jsonobject);
                            PMApi.trackDeepLink(brancherror);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = DeferredDeepLinkManager.this;
                super();
            }
        }, uri, activity);
    }

    public void markAsExpired()
    {
        currentState = DL_STATE.DL_EXPIRED;
    }

}
