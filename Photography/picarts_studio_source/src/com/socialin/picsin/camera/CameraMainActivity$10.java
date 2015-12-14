// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;


// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        a.finish();
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
