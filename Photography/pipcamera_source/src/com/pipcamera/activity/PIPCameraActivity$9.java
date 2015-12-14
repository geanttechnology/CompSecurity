// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import com.wantu.piprender.ESceneMode;
import kc;

// Referenced classes of package com.pipcamera.activity:
//            PIPCameraActivity

class a
    implements kc
{

    final PIPCameraActivity a;

    public void a(int i)
    {
        a.a(false);
        if (i == 1)
        {
            a.b = ESceneMode.SCENE_MODE1;
            a.f();
        } else
        if (i == 2)
        {
            a.b = ESceneMode.SCENE_MODE1;
            a.d();
            return;
        }
    }

    (PIPCameraActivity pipcameraactivity)
    {
        a = pipcameraactivity;
        super();
    }
}
