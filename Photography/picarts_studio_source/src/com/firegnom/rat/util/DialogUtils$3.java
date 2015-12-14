// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat.util;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.firegnom.rat.util:
//            DialogUtils

final class val.activity
    implements android.view.stener
{

    final Activity val$activity;

    public final void onClick(View view)
    {
        val$activity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    ()
    {
        val$activity = activity1;
        super();
    }
}
