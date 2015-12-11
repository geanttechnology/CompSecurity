// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.NavigateToLinkInteraction;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class NavigateToLinkInteractionView extends InteractionView
{

    public NavigateToLinkInteractionView(NavigateToLinkInteraction navigatetolinkinteraction)
    {
        super(navigatetolinkinteraction);
    }

    public void doOnCreate(Activity activity, Bundle bundle)
    {
        bundle = new Intent("android.intent.action.VIEW", Uri.parse(((NavigateToLinkInteraction)interaction).getUrl()));
        _cls1..SwitchMap.com.apptentive.android.sdk.module.engagement.interaction.model.NavigateToLinkInteraction.Target[((NavigateToLinkInteraction)interaction).getTarget().ordinal()];
        JVM INSTR tableswitch 1 1: default 351
    //                   1 138;
           goto _L1 _L2
_L1:
        activity.startActivity(bundle);
        bundle = new JSONObject();
        try
        {
            bundle.put("url", ((NavigateToLinkInteraction)interaction).getUrl());
            bundle.put("target", ((NavigateToLinkInteraction)interaction).getTarget().lowercaseName());
            bundle.put("success", true);
        }
        catch (JSONException jsonexception)
        {
            Log.e("Error creating Event data object.", jsonexception, new Object[0]);
        }
        EngagementModule.engageInternal(activity, interaction, "navigate", bundle.toString());
        activity.finish();
        return;
_L2:
        bundle.setFlags(0x10000000);
          goto _L1
        bundle;
        Log.w("NavigateToLink Error: ", bundle, new Object[0]);
        bundle = new JSONObject();
        try
        {
            bundle.put("url", ((NavigateToLinkInteraction)interaction).getUrl());
            bundle.put("target", ((NavigateToLinkInteraction)interaction).getTarget().lowercaseName());
            bundle.put("success", false);
        }
        catch (JSONException jsonexception1)
        {
            Log.e("Error creating Event data object.", jsonexception1, new Object[0]);
        }
        EngagementModule.engageInternal(activity, interaction, "navigate", bundle.toString());
        activity.finish();
        return;
        bundle;
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("url", ((NavigateToLinkInteraction)interaction).getUrl());
            jsonobject.put("target", ((NavigateToLinkInteraction)interaction).getTarget().lowercaseName());
            jsonobject.put("success", false);
        }
        catch (JSONException jsonexception2)
        {
            Log.e("Error creating Event data object.", jsonexception2, new Object[0]);
        }
        EngagementModule.engageInternal(activity, interaction, "navigate", jsonobject.toString());
        activity.finish();
        throw bundle;
    }

    public boolean onBackPressed(Activity activity)
    {
        return true;
    }

    private class _cls1
    {

        static final int $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$NavigateToLinkInteraction$Target[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$NavigateToLinkInteraction$Target = new int[com.apptentive.android.sdk.module.engagement.interaction.model.NavigateToLinkInteraction.Target.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$NavigateToLinkInteraction$Target[com.apptentive.android.sdk.module.engagement.interaction.model.NavigateToLinkInteraction.Target.New.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$module$engagement$interaction$model$NavigateToLinkInteraction$Target[com.apptentive.android.sdk.module.engagement.interaction.model.NavigateToLinkInteraction.Target.Self.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
