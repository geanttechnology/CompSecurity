// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.widget.TextView;
import com.socialin.picsin.camera.CameraMainActivity;
import java.util.List;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewCupcake, c, CustomVerticalSeekBar

final class a
    implements Runnable
{

    private CameraViewCupcake a;

    public final void run()
    {
        if (!a.D() || a.c == null || a.a == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = (int)CameraViewCupcake.a(a);
        j = a.U();
        if (i >= 0) goto _L4; else goto _L3
_L3:
        i = 0;
_L6:
        a.setZoom(i);
        a.d();
        if (a.p != null)
        {
            CameraMainActivity cameramainactivity = (CameraMainActivity)a.p;
            List list = cameramainactivity.a.V();
            if (list != null && i >= 0 && i < list.size())
            {
                ((CustomVerticalSeekBar)cameramainactivity.findViewById(0x7f1001ff)).setProgressAndThumb(i);
                ((TextView)cameramainactivity.findViewById(0x7f1001fe)).setText((new StringBuilder()).append((float)(((Integer)list.get(i)).intValue() / 10) / 10F).append("X").toString());
            }
        }
_L2:
        return;
_L4:
        if (i > j)
        {
            i = j;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    r(CameraViewCupcake cameraviewcupcake)
    {
        a = cameraviewcupcake;
        super();
    }
}
