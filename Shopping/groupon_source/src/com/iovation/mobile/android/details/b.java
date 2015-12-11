// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class b
    implements i
{

    public b()
    {
    }

    String a(Context context)
    {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public void a(Context context, j j1)
    {
        boolean flag = false;
        ApplicationInfo applicationinfo = context.getApplicationInfo();
        j1.a("APPN", a(context));
        j1.a("PROCN", applicationinfo.processName);
        j1.a("APPID", applicationinfo.packageName);
        j1.a("AASN", b(context));
        j1.a("EXEN", applicationinfo.sourceDir);
        if ((context.getApplicationInfo().flags & 2) != 0)
        {
            flag = true;
        }
        if (flag)
        {
            j1.a("DEBUG", "1");
        } else
        {
            j1.a("DEBUG", "0");
        }
        context = context.getPackageManager();
        try
        {
            j1.a("APPV", Integer.toString(context.getPackageInfo(applicationinfo.packageName, 0).versionCode));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    String b(Context context)
    {
        Signature asignature[] = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        Object obj;
        int l = asignature.length;
        context = "";
        String s = "";
        int k = 0;
        do
        {
            obj = context;
            if (k >= l)
            {
                break;
            }
            obj = asignature[k];
            context = (new StringBuilder()).append(context).append(s).append(((Signature) (obj)).hashCode()).toString();
            s = ", ";
            k++;
        } while (true);
        break MISSING_BLOCK_LABEL_88;
        context;
        obj = null;
        return ((String) (obj));
    }
}
