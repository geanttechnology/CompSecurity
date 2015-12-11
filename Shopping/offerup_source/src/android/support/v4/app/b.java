// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;

// Referenced classes of package android.support.v4.app:
//            c

final class b
    implements Runnable
{

    private String a[];
    private Activity b;
    private int c;

    b(String as[], Activity activity, int i)
    {
        a = as;
        b = activity;
        c = i;
        super();
    }

    public final void run()
    {
        int ai[] = new int[a.length];
        PackageManager packagemanager = b.getPackageManager();
        String s = b.getPackageName();
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
            ai[i] = packagemanager.checkPermission(a[i], s);
        }

        ((c)b).onRequestPermissionsResult(c, a, ai);
    }
}
