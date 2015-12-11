// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.widget.ImageView;

public final class ez extends ImageView
{

    private int CQ;

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (CQ != 0)
        {
            canvas.drawColor(CQ);
        }
    }
}
