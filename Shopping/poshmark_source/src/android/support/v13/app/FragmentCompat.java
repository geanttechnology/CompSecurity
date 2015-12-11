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
//            FragmentCompatICS, FragmentCompatICSMR1, FragmentCompat23

public class FragmentCompat
{
    static class BaseFragmentCompatImpl
        implements FragmentCompatImpl
    {

        public void requestPermissions(final Fragment fragment, final String permissions[], int i)
        {
            (new Handler(Looper.getMainLooper())).post(i. new Runnable() {

                final BaseFragmentCompatImpl this$0;
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
                    ((OnRequestPermissionsResultCallback)fragment).onRequestPermissionsResult(requestCode, permissions, ai);
                }

            
            {
                this$0 = final_basefragmentcompatimpl;
                permissions = as;
                fragment = fragment1;
                requestCode = I.this;
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

        BaseFragmentCompatImpl()
        {
        }
    }

    static interface FragmentCompatImpl
    {

        public abstract void requestPermissions(Fragment fragment, String as[], int i);

        public abstract void setMenuVisibility(Fragment fragment, boolean flag);

        public abstract void setUserVisibleHint(Fragment fragment, boolean flag);

        public abstract boolean shouldShowRequestPermissionRationale(Fragment fragment, String s);
    }

    static class ICSFragmentCompatImpl extends BaseFragmentCompatImpl
    {

        public void setMenuVisibility(Fragment fragment, boolean flag)
        {
            FragmentCompatICS.setMenuVisibility(fragment, flag);
        }

        ICSFragmentCompatImpl()
        {
        }
    }

    static class ICSMR1FragmentCompatImpl extends ICSFragmentCompatImpl
    {

        public void setUserVisibleHint(Fragment fragment, boolean flag)
        {
            FragmentCompatICSMR1.setUserVisibleHint(fragment, flag);
        }

        ICSMR1FragmentCompatImpl()
        {
        }
    }

    static class MncFragmentCompatImpl extends ICSMR1FragmentCompatImpl
    {

        public void requestPermissions(Fragment fragment, String as[], int i)
        {
            FragmentCompat23.requestPermissions(fragment, as, i);
        }

        public boolean shouldShowRequestPermissionRationale(Fragment fragment, String s)
        {
            return FragmentCompat23.shouldShowRequestPermissionRationale(fragment, s);
        }

        MncFragmentCompatImpl()
        {
        }
    }

    public static interface OnRequestPermissionsResultCallback
    {

        public abstract void onRequestPermissionsResult(int i, String as[], int ai[]);
    }


    static final FragmentCompatImpl IMPL;

    public FragmentCompat()
    {
    }

    public static void requestPermissions(Fragment fragment, String as[], int i)
    {
        IMPL.requestPermissions(fragment, as, i);
    }

    public static void setMenuVisibility(Fragment fragment, boolean flag)
    {
        IMPL.setMenuVisibility(fragment, flag);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean flag)
    {
        IMPL.setUserVisibleHint(fragment, flag);
    }

    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String s)
    {
        return IMPL.shouldShowRequestPermissionRationale(fragment, s);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            IMPL = new MncFragmentCompatImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            IMPL = new ICSMR1FragmentCompatImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new ICSFragmentCompatImpl();
        } else
        {
            IMPL = new BaseFragmentCompatImpl();
        }
    }
}
