// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import android.app.DialogFragment;
import android.app.FragmentManager;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager

public class r
{

    public DialogFragment a;
    public String b;
    final StatusManager c;
    private final FragmentManager d;

    public r(StatusManager statusmanager, FragmentManager fragmentmanager, DialogFragment dialogfragment, String s)
    {
        c = statusmanager;
        super();
        a = null;
        d = fragmentmanager;
        a = dialogfragment;
        b = s;
    }

    static FragmentManager a(r r1)
    {
        return r1.d;
    }
}
