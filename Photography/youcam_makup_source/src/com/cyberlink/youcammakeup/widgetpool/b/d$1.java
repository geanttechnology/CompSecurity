// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.b;

import com.cyberlink.youcammakeup.activity.EditViewActivity;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.b:
//            d, a

class a
    implements Runnable
{

    final d a;

    public void run()
    {
        android.app.Activity activity = a.a.getActivity();
        if (activity != null && !com.cyberlink.youcammakeup.widgetpool.b.a.d(a.a))
        {
            ((EditViewActivity)activity).a(true, true);
        }
    }

    Activity(d d1)
    {
        a = d1;
        super();
    }
}
