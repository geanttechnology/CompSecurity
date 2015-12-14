// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            c

final class a
    implements android.view..OnClickListener
{

    final Activity a;

    public void onClick(View view)
    {
        c.a(a, null, Boolean.valueOf(false));
    }

    (Activity activity)
    {
        a = activity;
        super();
    }
}
