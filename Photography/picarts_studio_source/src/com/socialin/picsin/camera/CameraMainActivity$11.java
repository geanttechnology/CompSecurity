// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a extends OrientationEventListener
{

    private CameraMainActivity a;

    public final void onOrientationChanged(int i)
    {
        int j = CameraMainActivity.a(a);
        i = ((CameraMainActivity.b(a) + i + 45) / 90) * 90;
        CameraMainActivity.a(a, (i + 90) % 360);
        if (CameraMainActivity.a(a) != j)
        {
            (new StringBuilder("rotation: ")).append(CameraMainActivity.a(a)).append(" orientation:").append(i);
            CameraMainActivity.a(a);
            CameraMainActivity.a(a, a.findViewById(0x7f100203));
            CameraMainActivity.a(a, a.findViewById(0x7f100205));
            CameraMainActivity.a(a, a.findViewById(0x7f100204));
            CameraMainActivity.a(a, a.findViewById(0x7f100207));
            CameraMainActivity.a(a, a.findViewById(0x7f100208));
            CameraMainActivity.a(a, a.findViewById(0x7f100223));
            CameraMainActivity.a(a, a.findViewById(0x7f100224));
            CameraMainActivity.a(a, a.findViewById(0x7f100226));
            CameraMainActivity.a(a, a.findViewById(0x7f10022a));
            CameraMainActivity.a(a, CameraMainActivity.a(a));
        }
    }

    (CameraMainActivity cameramainactivity, Context context)
    {
        a = cameramainactivity;
        super(context, 1);
    }
}
