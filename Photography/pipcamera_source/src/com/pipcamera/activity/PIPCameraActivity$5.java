// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import eo;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements eo
{

    final PIPCameraActivity a;

    public void a(String s)
    {
        if (s.startsWith("http://") || s.startsWith("https://"))
        {
            PIPCameraActivity.a(a, s);
        }
    }

    public void b(String s)
    {
    }

    (PIPCameraActivity pipcameraactivity)
    {
        a = pipcameraactivity;
        super();
    }
}
