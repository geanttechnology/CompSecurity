// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.photo.morph:
//            StretchActivity, MorphGLSurfaceView

final class a
    implements android.view.er
{

    private StretchActivity a;

    public final void onClick(View view)
    {
        if (StretchActivity.e(a) != null)
        {
            StretchActivity.e(a).b();
        }
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.StretchCloseEvent(StretchActivity.f(a).a, "cancel", (int)StretchActivity.g(a).d()));
        a.finish();
    }

    lator(StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
