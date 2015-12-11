// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.os.Bundle;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.module.ActivityContent;
import com.apptentive.android.sdk.module.engagement.interaction.model.Interaction;

public abstract class InteractionView extends ActivityContent
{

    private static final String HAS_LAUNCHED = "has_launched";
    protected boolean hasLaunched;
    protected Interaction interaction;

    public InteractionView(Interaction interaction1)
    {
        interaction = interaction1;
    }

    protected abstract void doOnCreate(Activity activity, Bundle bundle);

    public void onCreate(Activity activity, Bundle bundle)
    {
        Log.d("Showing interaction.", new Object[0]);
        if (bundle != null)
        {
            hasLaunched = bundle.getBoolean("has_launched");
        }
        if (!hasLaunched)
        {
            hasLaunched = true;
            interaction.sendLaunchEvent(activity);
        }
        doOnCreate(activity, bundle);
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        hasLaunched = bundle.getBoolean("has_launched", false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("has_launched", hasLaunched);
    }
}
