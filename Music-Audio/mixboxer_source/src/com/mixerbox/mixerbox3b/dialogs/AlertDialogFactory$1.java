// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

final class val.activity
    implements android.content.ckListener
{

    final Activity val$activity;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        val$activity.startActivity(new Intent("android.settings.SETTINGS"));
    }

    ()
    {
        val$activity = activity1;
        super();
    }
}
