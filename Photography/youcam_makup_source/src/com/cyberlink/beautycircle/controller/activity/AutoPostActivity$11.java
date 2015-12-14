// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a
    implements android.view.
{

    final AutoPostActivity a;

    public void onClick(View view)
    {
        view = a;
        boolean flag;
        if (!AutoPostActivity.r(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AutoPostActivity.a(view, flag, true);
    }

    (AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
