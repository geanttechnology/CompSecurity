// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import org.altbeacon.beacon.logging.LogManager;

public class Callback
{

    private static final String TAG = "Callback";
    private Intent intent;

    public Callback(String s)
    {
        if (s != null)
        {
            intent = new Intent();
            intent.setComponent(new ComponentName(s, "org.altbeacon.beacon.BeaconIntentProcessor"));
        }
    }

    public boolean call(Context context, String s, Parcelable parcelable)
    {
        if (intent != null)
        {
            LogManager.d("Callback", "attempting callback via intent: %s", new Object[] {
                intent.getComponent()
            });
            intent.putExtra(s, parcelable);
            context.startService(intent);
            return true;
        } else
        {
            return false;
        }
    }

    public Intent getIntent()
    {
        return intent;
    }

    public void setIntent(Intent intent1)
    {
        intent = intent1;
    }
}
