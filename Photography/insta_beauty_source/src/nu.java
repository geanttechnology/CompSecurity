// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

class nu
    implements Runnable
{

    final ns a;

    nu(ns ns1)
    {
        a = ns1;
        super();
    }

    public void run()
    {
        ActivityCameraNoRealtime.n(a.b);
    }
}
