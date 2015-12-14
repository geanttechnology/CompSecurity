// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.c;

// Referenced classes of package com.socialin.android.photo.collage:
//            SelectCollageBgActivity

final class a
    implements c
{

    private SelectCollageBgActivity a;

    public final void a(int i)
    {
        SelectCollageBgActivity.a(a, i);
        AnalyticUtils.getInstance(a).trackLocalAction("collageBg:color");
    }

    (SelectCollageBgActivity selectcollagebgactivity)
    {
        a = selectcollagebgactivity;
        super();
    }
}
