// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;

final class as
{

    static as a;
    boolean b;
    private ArrayList c;

    as(Context context)
    {
        c = new ArrayList();
        boolean flag;
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
