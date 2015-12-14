// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity

class a
    implements Runnable
{

    final FreeSampleActivity a;

    public void run()
    {
        c.b(a, 5);
    }

    I(FreeSampleActivity freesampleactivity)
    {
        a = freesampleactivity;
        super();
    }
}
