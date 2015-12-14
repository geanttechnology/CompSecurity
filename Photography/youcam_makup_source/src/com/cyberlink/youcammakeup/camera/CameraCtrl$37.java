// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a extends m
{

    final CameraCtrl a;

    protected void a(Bitmap bitmap)
    {
        if (CameraCtrl.X(a) != null)
        {
            CameraCtrl.X(a).setImageBitmap(bitmap);
        }
    }

    protected void b(Object obj)
    {
        a((Bitmap)obj);
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
