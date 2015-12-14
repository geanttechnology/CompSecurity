// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.graphics.Bitmap;
import kz;

// Referenced classes of package com.pipcamera.activity:
//            ExternReceiverActivity

class c
    implements kz
{

    final String a;
    final String b;
    final String c;
    final ExternReceiverActivity d;

    public void a(Bitmap bitmap)
    {
        ExternReceiverActivity.a(d, a, b, c, bitmap, false);
        d.finish();
    }

    public void a(Exception exception)
    {
        ExternReceiverActivity.a(d, a, b, c, null, false);
        d.finish();
    }

    (ExternReceiverActivity externreceiveractivity, String s, String s1, String s2)
    {
        d = externreceiveractivity;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
