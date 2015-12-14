// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements android.view.inActivity._cls17
{

    private CameraMainActivity a;

    public final void onClick(View view)
    {
        CameraMainActivity.d(a, view.getId());
        if (view.getId() == 0x7f100224)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tionEvent(CameraMainActivity.n(a), "mask"));
            return;
        } else
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tionEvent(CameraMainActivity.n(a), "fx"));
            return;
        }
    }

    ameraActionEvent(CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
