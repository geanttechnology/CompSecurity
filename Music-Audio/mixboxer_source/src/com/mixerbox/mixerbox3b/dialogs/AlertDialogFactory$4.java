// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

final class val.activity
    implements android.content.ckListener
{

    final Activity val$activity;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        dialoginterface = MixerBoxSharedPreferences.getPackageName(val$activity);
        try
        {
            val$activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            val$activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(dialoginterface).toString())));
        }
        val$activity.finish();
    }

    es()
    {
        val$activity = activity1;
        super();
    }
}
