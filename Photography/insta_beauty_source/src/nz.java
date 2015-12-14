// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;
import java.util.ArrayList;

class nz
    implements Runnable
{

    final ny a;

    nz(ny ny1)
    {
        a = ny1;
        super();
    }

    public void run()
    {
        if (!ActivityCameraNoRealtime.c(a.a))
        {
            ActivityCameraNoRealtime.a(a.a, 0);
            ActivityCameraNoRealtime.b(a.a).clear();
            a.a.runOnUiThread(new oa(this));
        }
    }
}
