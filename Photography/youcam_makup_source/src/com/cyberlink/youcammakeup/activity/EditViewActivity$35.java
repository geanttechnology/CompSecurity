// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.c.a;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class b
    implements Runnable
{

    final View a;
    final int b;
    final EditViewActivity c;

    public void run()
    {
        int i = a.getHeight();
        int j = b;
        if (c.d == com.cyberlink.youcammakeup.activity.eID.a)
        {
            ((a)c.e).a(j - i);
        }
    }

    eID(EditViewActivity editviewactivity, View view, int i)
    {
        c = editviewactivity;
        a = view;
        b = i;
        super();
    }
}
