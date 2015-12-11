// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class dr extends ImageView
{

    private Uri oU;
    private int oV;
    private int oW;

    public void H(int i)
    {
        oV = i;
    }

    public int bE()
    {
        return oV;
    }

    public void d(Uri uri)
    {
        oU = uri;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (oW != 0)
        {
            canvas.drawColor(oW);
        }
    }
}
