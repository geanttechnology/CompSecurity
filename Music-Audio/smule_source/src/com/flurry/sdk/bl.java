// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            bi, gd, bm

public final class bl
    implements bi
{

    private static final String a = com/flurry/sdk/bl.getSimpleName();

    public bl()
    {
    }

    private boolean a(String s, PackageManager packagemanager, String s1, String s2)
    {
        if (TextUtils.isEmpty(s) || packagemanager == null || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            return false;
        }
        if (-1 == packagemanager.checkPermission(s2, s1))
        {
            gd.b(a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml should include uses-permission node with ").append("android:name=\"").append(s2).append("\"").toString());
            return false;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml has uses-permission node with ").append("android:name=\"").append(s2).append("\"").toString());
            return true;
        }
    }

    public boolean a(Context context, bm bm1)
    {
        String s;
        Object obj;
        if (bm1 != null)
        {
            if (!TextUtils.isEmpty(s = bm1.a()) && (obj = bm1.d()) != null)
            {
                bm1 = context.getPackageManager();
                context = context.getPackageName();
                obj = ((List) (obj)).iterator();
                boolean flag = true;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    if (!a(s, ((PackageManager) (bm1)), ((String) (context)), (String)((Iterator) (obj)).next()))
                    {
                        flag = false;
                    }
                } while (true);
                return flag;
            }
        }
        return false;
    }

}
