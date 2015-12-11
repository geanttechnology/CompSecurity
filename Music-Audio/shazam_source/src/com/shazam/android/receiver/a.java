// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

// Referenced classes of package com.shazam.android.receiver:
//            b, ConnectivityReceiver

public final class a
    implements b
{

    private final Context a;

    public a(Context context)
    {
        a = context;
    }

    public final void a(boolean flag)
    {
        ComponentName componentname;
        PackageManager packagemanager;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        componentname = new ComponentName(a, com/shazam/android/receiver/ConnectivityReceiver);
        packagemanager = a.getPackageManager();
        if (packagemanager != null)
        {
            packagemanager.setComponentEnabledSetting(componentname, i, 1);
        }
    }
}
