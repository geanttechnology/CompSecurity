// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.socialin.android.photo.freecrop.d;

public interface h
{

    public abstract void a(Bitmap bitmap);

    public abstract void a(Bitmap bitmap, boolean flag, Bitmap bitmap1, boolean flag1, RectF rectf);

    public abstract void a(d d);

    public abstract boolean a(Bitmap bitmap, boolean flag);

    public abstract boolean a(Bitmap bitmap, boolean flag, RectF rectf);
}
