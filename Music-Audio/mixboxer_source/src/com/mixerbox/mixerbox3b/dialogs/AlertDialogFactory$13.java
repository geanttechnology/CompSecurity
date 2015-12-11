// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;

final class val.activity
    implements android.content.kListener
{

    final Activity val$activity;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        MixerBoxSharedPreferences.putTipFirstSearch(val$activity, true);
        dialoginterface.cancel();
    }

    s()
    {
        val$activity = activity1;
        super();
    }
}
