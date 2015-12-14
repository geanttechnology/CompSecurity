// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a
    implements Runnable
{

    final String a;
    final AutoPostActivity b;

    public void run()
    {
        AutoPostActivity.p(b).setText(a);
    }

    (AutoPostActivity autopostactivity, String s)
    {
        b = autopostactivity;
        a = s;
        super();
    }
}
