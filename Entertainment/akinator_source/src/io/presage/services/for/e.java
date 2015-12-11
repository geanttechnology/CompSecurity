// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import io.presage.services.do.d;
import io.presage.services.if.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package io.presage.services.for:
//            a, j

public final class e extends a
    implements j
{

    private ActivityManager b;
    private List c;

    public e(String s)
    {
        super(new d(), s);
    }

    public final void h()
    {
        boolean flag = false;
        if (c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (b == null)
        {
            b = (ActivityManager)d().getSystemService("activity");
        }
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        Object obj = new Intent("android.intent.action.MAIN");
        ((Intent) (obj)).addCategory("android.intent.category.HOME");
        c = new ArrayList();
        Object obj1;
        List list;
        PackageInfo packageinfo;
        ApplicationInfo applicationinfo;
        Object obj2;
        ResolveInfo resolveinfo;
        int i;
        boolean flag1;
        try
        {
            obj = d().getPackageManager().resolveActivity(((Intent) (obj)), 0);
            obj1 = new Intent("android.intent.action.MAIN", null);
            ((Intent) (obj1)).addCategory("android.intent.category.LAUNCHER");
            obj1 = d().getPackageManager().queryIntentActivities(((Intent) (obj1)), 0);
            list = d().getPackageManager().getInstalledPackages(0);
        }
        catch (Exception exception)
        {
            return;
        }
        i = 0;
        if (i >= list.size())
        {
            break MISSING_BLOCK_LABEL_512;
        }
        packageinfo = (PackageInfo)list.get(i);
        applicationinfo = packageinfo.applicationInfo;
        if (((ResolveInfo) (obj)).activityInfo != null && ((ResolveInfo) (obj)).activityInfo.packageName.equals(packageinfo.packageName) || "com.android.browser".equals(packageinfo.packageName) || "com.android.chrome".equals(packageinfo.packageName) || "com.sec.android.app.sbrowser".equals(packageinfo.packageName))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        obj2 = ((List) (obj1)).iterator();
        flag1 = false;
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            resolveinfo = (ResolveInfo)((Iterator) (obj2)).next();
            if (resolveinfo.activityInfo != null)
            {
                flag1 = resolveinfo.activityInfo.packageName.equals(packageinfo.packageName);
            }
        } while (!flag1);
        if (!flag1) goto _L4; else goto _L3
_L3:
        obj2 = new b();
        ((b) (obj2)).b(packageinfo.packageName);
        ((b) (obj2)).c(packageinfo.versionName);
        ((b) (obj2)).d(String.valueOf(packageinfo.versionCode));
        if ((applicationinfo.flags & 1) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((b) (obj2)).a(flag1);
        ((b) (obj2)).b(((ResolveInfo) (obj)).activityInfo.packageName.equals(packageinfo.packageName));
        c.add(obj2);
_L4:
        i++;
        break MISSING_BLOCK_LABEL_128;
        obj2 = new StringBuilder();
        ((StringBuilder) (obj2)).append(packageinfo.packageName);
        ((StringBuilder) (obj2)).append(":");
        ((StringBuilder) (obj2)).append(packageinfo.versionName);
        ((StringBuilder) (obj2)).append(":");
        ((StringBuilder) (obj2)).append(packageinfo.versionCode);
        ((StringBuilder) (obj2)).append(":");
        ((StringBuilder) (obj2)).append(((ResolveInfo) (obj)).activityInfo.packageName.equals(packageinfo.packageName));
        io.presage.utils.e.b(new String[] {
            "DEBUG", ((StringBuilder) (obj2)).toString()
        });
          goto _L3
        ((d)a()).a();
        i = ((flag) ? 1 : 0);
        while (i < c.size()) 
        {
            obj = ((b)c.get(i)).c();
            ((d)a()).a(((io.presage.services.if.f) (obj)));
            ((b) (obj)).e();
            i++;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
