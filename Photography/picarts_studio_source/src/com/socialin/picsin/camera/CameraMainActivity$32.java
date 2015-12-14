// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements android.view.inActivity._cls32
{

    private CameraMainActivity a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && CameraMainActivity.c(a) != null)
        {
            CameraMainActivity.d(a);
        }
        return false;
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
