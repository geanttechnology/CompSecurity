// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.graphics.drawable.GradientDrawable;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            be

static final class b
    implements android.view.OnFocusChangeListener
{

    final int a[];
    final int b[];

    public void onFocusChange(View view, boolean flag)
    {
        Object obj;
        if (flag)
        {
            obj = a;
        } else
        {
            obj = b;
        }
        obj = new GradientDrawable(android.graphics.drawable.entDrawable.Orientation.TOP_BOTTOM, ((int []) (obj)));
        ((GradientDrawable) (obj)).setCornerRadius(5F);
        ((GradientDrawable) (obj)).setGradientType(0);
        view.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
    }

    e.Orientation(int ai[], int ai1[])
    {
        a = ai;
        b = ai1;
        super();
    }
}
