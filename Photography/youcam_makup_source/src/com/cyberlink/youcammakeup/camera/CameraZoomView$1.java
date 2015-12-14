// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.cyberlink.youcammakeup.activity.CameraActivity;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraZoomView

class a
    implements Runnable
{

    final CameraZoomView a;

    public void run()
    {
        CameraActivity.b(false);
        CameraZoomView.a(a, false);
        CameraZoomView.b(a, false);
        a.invalidate();
    }

    (CameraZoomView camerazoomview)
    {
        a = camerazoomview;
        super();
    }
}
