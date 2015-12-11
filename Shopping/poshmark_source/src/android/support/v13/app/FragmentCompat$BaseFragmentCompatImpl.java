// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

// Referenced classes of package android.support.v13.app:
//            FragmentCompat

static class _cls1.val.requestCode
    implements _cls1.val.requestCode
{

    public void requestPermissions(final Fragment fragment, final String permissions[], final int requestCode)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final FragmentCompat.BaseFragmentCompatImpl this$0;
            final Fragment val$fragment;
            final String val$permissions[];
            final int val$requestCode;

            public void run()
            {
                int ai[] = new int[permissions.length];
                Object obj = fragment.getActivity();
                if (obj != null)
                {
                    PackageManager packagemanager = ((Context) (obj)).getPackageManager();
                    obj = ((Context) (obj)).getPackageName();
                    int j = permissions.length;
                    for (int i = 0; i < j; i++)
                    {
                        ai[i] = packagemanager.checkPermission(permissions[i], ((String) (obj)));
                    }

                } else
                {
                    Arrays.fill(ai, -1);
                }
                ((FragmentCompat.OnRequestPermissionsResultCallback)fragment).onRequestPermissionsResult(requestCode, permissions, ai);
            }

            
            {
                this$0 = FragmentCompat.BaseFragmentCompatImpl.this;
                permissions = as;
                fragment = fragment1;
                requestCode = i;
                super();
            }
        });
    }

    public void setMenuVisibility(Fragment fragment, boolean flag)
    {
    }

    public void setUserVisibleHint(Fragment fragment, boolean flag)
    {
    }

    public boolean shouldShowRequestPermissionRationale(Fragment fragment, String s)
    {
        return false;
    }

    _cls1.val.requestCode()
    {
    }
}
