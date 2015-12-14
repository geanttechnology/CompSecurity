// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            o

class b
    implements w
{

    final Context a;
    final w b;
    final o c;

    public void a(boolean flag)
    {
        c.i(a);
        if (b != null)
        {
            b.a(flag);
        }
    }

    public void b(boolean flag)
    {
        c.i(a);
        if (b != null)
        {
            b.b(flag);
        }
    }

    ialogs.w(o o1, Context context, w w1)
    {
        c = o1;
        a = context;
        b = w1;
        super();
    }
}
