// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.gimbal.a.b;

// Referenced classes of package com.gimbal.internal.c:
//            c

public final class a
{

    private static final b b = com.gimbal.internal.c.c.f("SIGHTINGS");
    public boolean a;
    private Context c;

    public a(Context context)
    {
        c = context;
        a = a();
        if (a)
        {
            b.b("SIGHTINGS Debug mode available - Enable with: GimbalDebugger.enableBeaconSightingsLogging();", new Object[0]);
        }
    }

    private boolean a()
    {
        boolean flag1 = false;
        PackageInfo packageinfo;
        boolean flag;
        try
        {
            packageinfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 64);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        flag = flag1;
        if (packageinfo.signatures == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        flag = flag1;
        if (packageinfo.signatures.length > 0)
        {
            flag = (new String(packageinfo.signatures[0].toByteArray())).contains("Android Debug");
        }
        return flag;
    }

}
