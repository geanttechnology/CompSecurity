// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import io.presage.Presage;

// Referenced classes of package io.presage.utils:
//            f

public final class c
{

    public static NetworkInfo a(Context context)
    {
        if (Presage.getInstance().getPackageHelper().a(2))
        {
            return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        } else
        {
            return null;
        }
    }
}
