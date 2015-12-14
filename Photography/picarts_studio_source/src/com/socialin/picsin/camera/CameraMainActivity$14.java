// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.picsin.camera.view.c;
import java.util.List;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class b
    implements android.widget.eListener
{

    private TextView a;
    private List b;
    private CameraMainActivity c;

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (flag)
        {
            com.socialin.picsin.camera.CameraMainActivity.c(c).setZoom(i);
            a.setText((new StringBuilder()).append((float)(((Integer)b.get(i)).intValue() / 10) / 10F).append("X").toString());
            com.socialin.picsin.camera.CameraMainActivity.c(c).d();
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    (CameraMainActivity cameramainactivity, TextView textview, List list)
    {
        c = cameramainactivity;
        a = textview;
        b = list;
        super();
    }
}
