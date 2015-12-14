// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

class lk
    implements Runnable
{

    final lj a;

    lk(lj lj1)
    {
        a = lj1;
        super();
    }

    public void run()
    {
        ActivityCameraNew.a(a.a);
    }
}
