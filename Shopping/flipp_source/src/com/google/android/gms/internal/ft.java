// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class ft extends ImageView
{

    public Uri a;
    public int b;
    private int c;

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (c != 0)
        {
            canvas.drawColor(c);
        }
    }
}
