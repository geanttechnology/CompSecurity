// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.graphics.Bitmap;
import android.graphics.Point;

public final class d
{

    public Bitmap a;

    public d()
    {
    }

    public d(int i, int j)
    {
        new Point(i, j);
        GPUImage.ReadPixelsResultType readpixelsresulttype = GPUImage.ReadPixelsResultType.ReadPixelsResultTypeBuffer;
    }

    public d(Bitmap bitmap)
    {
        a = bitmap;
        bitmap = GPUImage.ReadPixelsResultType.ReadPixelsResultTypeBitmap;
    }
}
