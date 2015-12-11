// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            gj, gl, cy

final class ax
    implements gj
{

    private static final String p = com/flurry/android/ax.getSimpleName();

    ax()
    {
    }

    public final boolean a(Context context, gl gl1)
    {
        String s;
        Object obj;
        if (gl1 != null)
        {
            if (!TextUtils.isEmpty(s = gl1.O()) && (obj = gl1.bI()) != null)
            {
                gl1 = context.getPackageManager();
                context = context.getPackageName();
                obj = ((List) (obj)).iterator();
                boolean flag1 = true;
                do
                {
                    if (((Iterator) (obj)).hasNext())
                    {
                        String s1 = (String)((Iterator) (obj)).next();
                        boolean flag;
                        if (TextUtils.isEmpty(s) || gl1 == null || TextUtils.isEmpty(context) || TextUtils.isEmpty(s1))
                        {
                            flag = false;
                        } else
                        if (-1 == gl1.checkPermission(s1, context))
                        {
                            cy.d(p, (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml should include uses-permission node with ").append("android:name=\"").append(s1).append("\"").toString());
                            flag = false;
                        } else
                        {
                            (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml has uses-permission node with ").append("android:name=\"").append(s1).append("\"").toString();
                            flag = true;
                        }
                        if (!flag)
                        {
                            flag1 = false;
                        }
                    } else
                    {
                        return flag1;
                    }
                } while (true);
            }
        }
        return false;
    }

}
