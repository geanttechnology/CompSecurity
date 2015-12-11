// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;

// Referenced classes of package android.support.v13.app:
//            FragmentCompat, FragmentCompat23

static class pl extends pl
{

    public void requestPermissions(Fragment fragment, String as[], int i)
    {
        FragmentCompat23.requestPermissions(fragment, as, i);
    }

    public boolean shouldShowRequestPermissionRationale(Fragment fragment, String s)
    {
        return FragmentCompat23.shouldShowRequestPermissionRationale(fragment, s);
    }

    pl()
    {
    }
}
