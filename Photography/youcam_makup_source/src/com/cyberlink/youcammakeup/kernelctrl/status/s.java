// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import android.app.Activity;
import android.app.Fragment;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager

public class s
{

    public Fragment a;
    public Boolean b;
    final StatusManager c;
    private final Activity d;

    public s(StatusManager statusmanager, Fragment fragment, Activity activity, Boolean boolean1)
    {
        c = statusmanager;
        super();
        a = null;
        b = Boolean.valueOf(false);
        a = fragment;
        d = activity;
        b = boolean1;
    }

    static Activity a(s s1)
    {
        return s1.d;
    }
}
