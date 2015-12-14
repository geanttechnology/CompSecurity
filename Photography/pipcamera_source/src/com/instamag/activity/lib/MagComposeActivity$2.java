// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;


// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

class d
    implements Runnable
{

    final int a;
    final int b;
    final float c;
    final float d;
    final MagComposeActivity e;

    public void run()
    {
        MagComposeActivity.a(e, a);
        MagComposeActivity.a(e, b, c, d);
    }

    (MagComposeActivity magcomposeactivity, int i, int j, float f, float f1)
    {
        e = magcomposeactivity;
        a = i;
        b = j;
        c = f;
        d = f1;
        super();
    }
}
