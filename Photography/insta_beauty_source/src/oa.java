// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

class oa
    implements Runnable
{

    final nz a;

    oa(nz nz1)
    {
        a = nz1;
        super();
    }

    public void run()
    {
        ActivityCameraNoRealtime.d(a.a.a).setVisibility(4);
    }
}
