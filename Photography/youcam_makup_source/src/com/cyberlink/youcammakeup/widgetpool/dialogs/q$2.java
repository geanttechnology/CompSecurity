// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.PointF;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            q, s, t, r

class a
    implements android.view..OnClickListener
{

    final q a;

    public void onClick(View view)
    {
        view = new PointF[3];
        for (int i = 0; i < 3; i++)
        {
            view[i] = new PointF(q.b(a).d[i].a, q.b(a).d[i].b);
        }

        q.a(a).a(view);
    }

    (q q1)
    {
        a = q1;
        super();
    }
}
