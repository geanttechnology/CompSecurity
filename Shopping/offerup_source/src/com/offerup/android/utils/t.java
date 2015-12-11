// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.offerup.android.activities.UserDetailActivity;

final class t
    implements android.content.DialogInterface.OnClickListener
{

    private Activity a;
    private long b;

    t(Activity activity, long l)
    {
        a = activity;
        b = l;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(a, com/offerup/android/activities/UserDetailActivity);
        dialoginterface.putExtra("userId", b);
        a.startActivity(dialoginterface);
    }
}
