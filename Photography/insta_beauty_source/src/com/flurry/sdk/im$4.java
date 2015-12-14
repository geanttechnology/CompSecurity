// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.widget.Toast;

// Referenced classes of package com.flurry.sdk:
//            js, ik, im

class it>
    implements Runnable
{

    final ik a;
    final im b;

    public void run()
    {
        Toast.makeText(js.a().c(), (new StringBuilder()).append("PulseCallbackReportInfo HTTP Response Code: ").append(a.e).append(" for url: ").append(a.f()).toString(), 1).show();
    }

    (im im, ik ik1)
    {
        b = im;
        a = ik1;
        super();
    }
}
