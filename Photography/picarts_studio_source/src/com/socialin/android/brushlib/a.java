// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib;

import android.graphics.Canvas;
import com.socialin.android.brushlib.input.d;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.overlay.Overlay;

public abstract class a
    implements d
{

    public Overlay a;

    public a()
    {
    }

    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, b b);

    public void a(Overlay overlay)
    {
        a = overlay;
    }
}
