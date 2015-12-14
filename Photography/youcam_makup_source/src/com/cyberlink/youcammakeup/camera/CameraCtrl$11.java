// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;


// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            n, CameraCtrl, e

class a
    implements n
{

    final CameraCtrl a;

    public void a()
    {
        CameraCtrl.a(false);
        CameraCtrl.y(a).c();
    }

    public void b()
    {
        CameraCtrl.y(a).a(false);
        CameraCtrl.y(a).b();
    }

    public void c()
    {
        CameraCtrl.y(a).a(true);
        CameraCtrl.y(a).b();
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
