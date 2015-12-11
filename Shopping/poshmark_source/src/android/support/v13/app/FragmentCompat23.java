// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;

class FragmentCompat23
{

    FragmentCompat23()
    {
    }

    public static void requestPermissions(Fragment fragment, String as[], int i)
    {
        fragment.requestPermissions(as, i);
    }

    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String s)
    {
        return fragment.shouldShowRequestPermissionRationale(s);
    }
}
