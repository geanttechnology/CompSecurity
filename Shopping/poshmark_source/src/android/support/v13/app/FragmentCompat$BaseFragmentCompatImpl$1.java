// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Arrays;

// Referenced classes of package android.support.v13.app:
//            FragmentCompat

class val.requestCode
    implements Runnable
{

    final val.permissions this$0;
    final Fragment val$fragment;
    final String val$permissions[];
    final int val$requestCode;

    public void run()
    {
        int ai[] = new int[val$permissions.length];
        Object obj = val$fragment.getActivity();
        if (obj != null)
        {
            PackageManager packagemanager = ((Context) (obj)).getPackageManager();
            obj = ((Context) (obj)).getPackageName();
            int j = val$permissions.length;
            for (int i = 0; i < j; i++)
            {
                ai[i] = packagemanager.checkPermission(val$permissions[i], ((String) (obj)));
            }

        } else
        {
            Arrays.fill(ai, -1);
        }
        ((tCallback)val$fragment).onRequestPermissionsResult(val$requestCode, val$permissions, ai);
    }

    tCallback()
    {
        this$0 = final_tcallback;
        val$permissions = as;
        val$fragment = fragment1;
        val$requestCode = I.this;
        super();
    }
}
