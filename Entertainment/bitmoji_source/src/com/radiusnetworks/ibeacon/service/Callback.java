// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;

public class Callback
{

    private String TAG;
    private Intent intent;
    private Messenger messenger;

    public Callback(String s)
    {
        TAG = "Callback";
        if (s != null)
        {
            intent = new Intent();
            intent.setComponent(new ComponentName(s, "com.radiusnetworks.ibeacon.IBeaconIntentProcessor"));
        }
    }

    public boolean call(Context context, String s, Parcelable parcelable)
    {
        if (intent != null)
        {
            Log.d(TAG, (new StringBuilder()).append("attempting callback via intent: ").append(intent.getComponent()).toString());
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
