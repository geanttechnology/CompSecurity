// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import org.altbeacon.beacon.c.c;

public class a
{

    private Intent a;

    public a(String s)
    {
        if (s != null)
        {
            a = new Intent();
            a.setComponent(new ComponentName(s, "org.altbeacon.beacon.BeaconIntentProcessor"));
        }
    }

    public boolean a(Context context, String s, Parcelable parcelable)
    {
        if (a != null)
        {
            c.a("Callback", "attempting callback via intent: %s", new Object[] {
                a.getComponent()
            });
            a.putExtra(s, parcelable);
            context.startService(a);
            return true;
        } else
        {
            return false;
        }
    }
}
