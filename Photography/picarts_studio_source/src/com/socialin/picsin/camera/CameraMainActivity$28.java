// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import myobfuscated.da.b;
import myobfuscated.db.a;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public final class c
    implements Runnable
{

    private int a;
    private int b;
    private int c;
    private CameraMainActivity d;

    public final void run()
    {
        if (a != 0) goto _L2; else goto _L1
_L1:
        CameraMainActivity.g(d).a(b, false);
_L4:
        CameraMainActivity.G(d);
        if (CameraMainActivity.c(d) != null)
        {
            CameraMainActivity.c(d);
        }
        return;
_L2:
        a a1 = CameraMainActivity.g(d);
        int i = c;
        if (a1.f != null && i >= 0 && i < a1.f.getCount())
        {
            a1.f.b(i, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public (CameraMainActivity cameramainactivity, int i, int j, int k)
    {
        d = cameramainactivity;
        a = i;
        b = j;
        c = k;
        super();
    }
}
