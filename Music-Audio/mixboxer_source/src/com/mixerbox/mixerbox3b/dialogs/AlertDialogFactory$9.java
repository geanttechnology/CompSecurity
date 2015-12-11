// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import java.util.HashMap;
import java.util.Map;

final class val.activity
    implements android.content.ckListener
{

    final Activity val$activity;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        ((MainPage)val$activity).handleAnnounce();
        dialoginterface = new HashMap();
        dialoginterface.put("allow", "1");
        FlurryAgent.logEvent("action:allow_publish_permission", dialoginterface);
    }

    ()
    {
        val$activity = activity1;
        super();
    }
}
