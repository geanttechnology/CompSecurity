// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class zzlu extends ImageView
{

    private int zzaeA;
    private zza zzaeB;
    private int zzaeC;
    private float zzaeD;
    private Uri zzaey;
    private int zzaez;

    protected final void onDraw(Canvas canvas)
    {
        if (zzaeB != null)
        {
            canvas.clipPath(zzaeB.zzk(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (zzaeA != 0)
        {
            canvas.drawColor(zzaeA);
        }
    }

    protected final void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        zzaeC;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        i = getMeasuredHeight();
        j = (int)((float)i * zzaeD);
_L5:
        setMeasuredDimension(j, i);
        return;
_L3:
        j = getMeasuredWidth();
        i = (int)((float)j / zzaeD);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void zzbA(int i)
    {
        zzaez = i;
    }

    public final void zzj(Uri uri)
    {
        zzaey = uri;
    }

    public final int zzoH()
    {
        return zzaez;
    }

    private class zza
    {

        public abstract Path zzk(int i, int j);
    }

}
