// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;

public class FragmentCompat
{

    static final FragmentCompatImpl IMPL;

    public FragmentCompat()
    {
    }

    public static void requestPermissions(Fragment fragment, String as[], int i)
    {
    /* block-local class not found */
    class FragmentCompatImpl {}

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
    /* block-local class not found */
    class BaseFragmentCompatImpl {}

    /* block-local class not found */
    class ICSFragmentCompatImpl {}

    /* block-local class not found */
    class ICSMR1FragmentCompatImpl {}

    /* block-local class not found */
    class MncFragmentCompatImpl {}

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

    // Unreferenced inner class android/support/v13/app/FragmentCompat$OnRequestPermissionsResultCallback
    /* block-local class not found */
    class OnRequestPermissionsResultCallback {}

}
