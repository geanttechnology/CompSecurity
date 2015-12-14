// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.view.View;
import com.photo.morph.brushes.a;

// Referenced classes of package com.photo.morph:
//            StretchActivity, MorphGLSurfaceView

final class a
    implements android.view.r
{

    private StretchActivity a;

    public final void onClick(View view)
    {
        view = a;
        float f = StretchActivity.u(a);
        if (((StretchActivity) (view)).a != null)
        {
            ((StretchActivity) (view)).a.c.a(f);
        }
        view = a;
        f = StretchActivity.v(a);
        if (((StretchActivity) (view)).a != null)
        {
            ((StretchActivity) (view)).a.c.b(f);
        }
    }

    (StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
