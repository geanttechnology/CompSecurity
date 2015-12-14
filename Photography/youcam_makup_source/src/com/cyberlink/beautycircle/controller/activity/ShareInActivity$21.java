// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements android.view.r
{

    final ShareInActivity a;

    public void onClick(View view)
    {
        if (ShareInActivity.l(a) <= 0)
        {
            return;
        } else
        {
            ShareInActivity.m(a);
            ShareInActivity.n(a);
            return;
        }
    }

    (ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
