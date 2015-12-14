// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.b;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            e

class a
    implements android.view..OnClickListener
{

    final e a;

    public void onClick(View view)
    {
        b.a(com.cyberlink.youcammakeup.clflurry.Event.EventName.a);
        e.a(a).setVisibility(8);
        com.cyberlink.youcammakeup.b.e.b(a).setVisibility(8);
        e.a(a, e.a(a));
    }

    ry.b(e e1)
    {
        a = e1;
        super();
    }
}
