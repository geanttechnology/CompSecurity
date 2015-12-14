// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

class nr
    implements Runnable
{

    final nq a;

    nr(nq nq1)
    {
        a = nq1;
        super();
    }

    public void run()
    {
        ActivityCameraNoRealtime.o(a.a);
        ActivityCameraNoRealtime.p(a.a);
    }
}
