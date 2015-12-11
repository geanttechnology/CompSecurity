// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.poshmark.http.api.PMApi;
import io.branch.referral.BranchError;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.poshmark.utils:
//            DeferredDeepLinkManager

class this._cls0
    implements io.branch.referral.istener
{

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
            deferreddeeplinkmanager.status = (anchDeepLinkStatus)brancherror;
            if (currentState == _STATE.INIT)
            {
                if (status.clicked_branch_link)
                {
                    currentState = _STATE.DL_RECEIVED;
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
                    currentState = _STATE.DL_RECEIVED;
                    jsonobject = new per();
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

    per()
    {
        this$0 = DeferredDeepLinkManager.this;
        super();
    }
}
