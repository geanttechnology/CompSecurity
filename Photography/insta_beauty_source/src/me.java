// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

class me
    implements Runnable
{

    final md a;

    me(md md1)
    {
        a = md1;
        super();
    }

    public void run()
    {
        ActivityCameraNew.R(a.a);
        ActivityCameraNew.S(a.a);
    }
}
