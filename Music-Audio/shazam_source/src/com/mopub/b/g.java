// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.d.d;

final class g
{

    final Rect a = new Rect();
    final Rect b = new Rect();
    final Rect c = new Rect();
    final Rect d = new Rect();
    final Rect e = new Rect();
    final Rect f = new Rect();
    final Rect g = new Rect();
    final Rect h = new Rect();
    private final Context i;
    private final float j;

    g(Context context, float f1)
    {
        i = context.getApplicationContext();
        j = f1;
    }

    final void a(Rect rect, Rect rect1)
    {
        rect1.set(com.mopub.common.d.d.a(rect.left, i), com.mopub.common.d.d.a(rect.top, i), com.mopub.common.d.d.a(rect.right, i), com.mopub.common.d.d.a(rect.bottom, i));
    }
}
