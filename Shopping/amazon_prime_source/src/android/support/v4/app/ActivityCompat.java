// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;

// Referenced classes of package android.support.v4.app:
//            ActivityCompat21, ActivityCompatApi23

public class ActivityCompat extends ContextCompat
{
    public static interface OnRequestPermissionsResultCallback
    {

        public abstract void onRequestPermissionsResult(int i, String as[], int ai[]);
    }


    public ActivityCompat()
    {
    }

    public static void finishAfterTransition(Activity activity)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            ActivityCompat21.finishAfterTransition(activity);
            return;
        } else
        {
            activity.finish();
            return;
        }
    }

    public static void requestPermissions(Activity activity, String as[], int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            ActivityCompatApi23.requestPermissions(activity, as, i);
        } else
        if (activity instanceof OnRequestPermissionsResultCallback)
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(as, activity, i) {

                final Activity val$activity;
                final String val$permissions[];
                final int val$requestCode;

                public void run()
                {
                    int ai[] = new int[permissions.length];
                    PackageManager packagemanager = activity.getPackageManager();
                    String s = activity.getPackageName();
                    int k = permissions.length;
                    for (int j = 0; j < k; j++)
                    {
                        ai[j] = packagemanager.checkPermission(permissions[j], s);
                    }

                    ((OnRequestPermissionsResultCallback)activity).onRequestPermissionsResult(requestCode, permissions, ai);
                }

            
            {
                permissions = as;
                activity = activity1;
                requestCode = i;
                super();
            }
            });
            return;
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            return ActivityCompatApi23.shouldShowRequestPermissionRationale(activity, s);
        } else
        {
            return false;
        }
    }
}
