// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class a
{

    public final float a;
    public final float b;
    public final boolean c;
    public final boolean d;

    protected a(float f, float f1, boolean flag, boolean flag1)
    {
        a = f;
        b = f1;
        c = flag;
        d = flag1;
    }

    public abstract float a();

    public abstract void a(Canvas canvas, Paint paint);

    public abstract float b();

    static 
    {
        com/socialin/android/photo/lensflare/a.getSimpleName();
    }
}
