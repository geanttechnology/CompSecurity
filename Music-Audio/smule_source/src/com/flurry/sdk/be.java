// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            bi, cn, gd, bm

public final class be
    implements bi
{

    private static final String a = com/flurry/sdk/be.getSimpleName();
    private static final SparseArray b = a();

    public be()
    {
    }

    private static SparseArray a()
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.append(1, "mcc");
        sparsearray.append(2, "mnc");
        sparsearray.append(4, "locale");
        sparsearray.append(8, "touchscreen");
        sparsearray.append(16, "keyboard");
        sparsearray.append(32, "keyboardHidden");
        sparsearray.append(64, "navigation");
        sparsearray.append(128, "orientation");
        sparsearray.append(256, "screenLayout");
        sparsearray.append(512, "uiMode");
        sparsearray.append(1024, "screenSize");
        sparsearray.append(2048, "smallestScreenSize");
        return sparsearray;
    }

    private boolean a(String s, PackageManager packagemanager, String s1, ActivityInfo activityinfo)
    {
        if (TextUtils.isEmpty(s) || packagemanager == null || TextUtils.isEmpty(s1) || activityinfo == null || TextUtils.isEmpty(activityinfo.name))
        {
            return false;
        }
        packagemanager = cn.a(packagemanager, new ComponentName(s1, activityinfo.name));
        if (packagemanager == null)
        {
            gd.b(a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml should include activity node with android:name=\"").append(activityinfo.name).append("\"").toString());
            return false;
        }
        gd.a(3, a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml has activity node with android:name=\"").append(activityinfo.name).append("\"").toString());
        int j = activityinfo.configChanges;
        boolean flag1;
        if (j != 0)
        {
            int k = cn.a(packagemanager);
            packagemanager = b();
            int i = 0;
            boolean flag = true;
            do
            {
                flag1 = flag;
                if (i >= packagemanager.size())
                {
                    break;
                }
                int l = packagemanager.keyAt(i);
                flag1 = flag;
                if ((l & j) != 0)
                {
                    if ((l & k) == 0)
                    {
                        gd.b(a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml activity node with android:name=\"").append(activityinfo.name).append("\" should include android:configChanges value=\"").append((String)packagemanager.valueAt(i)).append("\"").toString());
                        flag1 = false;
                    } else
                    {
                        gd.a(3, a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml activity node with ").append("android:name=\"").append(activityinfo.name).append("\" has android:configChanges value=\"").append((String)packagemanager.valueAt(i)).append("\"").toString());
                        flag1 = flag;
                    }
                }
                i++;
                flag = flag1;
            } while (true);
        } else
        {
            flag1 = true;
        }
        return flag1;
    }

    private static SparseArray b()
    {
        return b;
    }

    public boolean a(Context context, bm bm1)
    {
        String s;
        Object obj;
        if (bm1 != null)
        {
            if (!TextUtils.isEmpty(s = bm1.a()) && (obj = bm1.e()) != null)
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
                    if (!a(s, ((PackageManager) (bm1)), ((String) (context)), (ActivityInfo)((Iterator) (obj)).next()))
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
