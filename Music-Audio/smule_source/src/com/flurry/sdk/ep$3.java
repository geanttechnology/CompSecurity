// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.widget.TextView;

// Referenced classes of package com.flurry.sdk:
//            ep

class it>
    implements Runnable
{

    final int a;
    final ep b;

    public void run()
    {
        ep.a(b).setText(Integer.toString(a));
    }

    iew(ep ep1, int i)
    {
        b = ep1;
        a = i;
        super();
    }
}
