// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import java.util.TimerTask;

// Referenced classes of package com.wishabi.flipp.b:
//            a

public final class m extends TimerTask
{

    final com.wishabi.flipp.content.Flyer.Model a;
    final a b;

    public m(a a1, com.wishabi.flipp.content.Flyer.Model model)
    {
        b = a1;
        a = model;
        super();
    }

    public final void run()
    {
        b.b(a);
    }
}
