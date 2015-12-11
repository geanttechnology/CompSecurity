// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

// Referenced classes of package com.ebay.mobile:
//            MyApp

public static class FoundException extends FoundException
{

    protected void preOnCreate(Bundle bundle)
    {
        Activity activity = getActivity();
        activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0).theme;
        JVM INSTR lookupswitch 3: default 83
    //                   0: 70
    //                   2131361835: 70
    //                   2131362432: 70;
           goto _L1 _L2 _L2 _L2
_L1:
        super.OnCreate(bundle);
        return;
_L2:
        try
        {
            activity.setTheme(0x7f0a028a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        return;
    }

    public FoundException()
    {
    }
}
