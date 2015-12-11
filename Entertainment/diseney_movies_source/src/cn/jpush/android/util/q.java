// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

// Referenced classes of package cn.jpush.android.util:
//            x

public final class q
{

    public static String[] a(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.j();
            return null;
        }
        return context;
    }
}
