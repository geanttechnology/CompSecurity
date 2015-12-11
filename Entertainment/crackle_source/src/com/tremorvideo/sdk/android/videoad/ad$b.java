// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad

class a
{

    final Activity a;

    public boolean a()
    {
        boolean flag = false;
        int i;
        try
        {
            i = a.getPackageManager().getActivityInfo(a.getComponentName(), 0).flags;
        }
        catch (Exception exception)
        {
            ad.a(exception);
            return false;
        }
        if ((i & 0x200) == 512)
        {
            flag = true;
        }
        return flag;
    }

    (Activity activity)
    {
        a = activity;
        super();
    }
}
