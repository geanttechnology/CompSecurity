// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

public interface IGeom
    extends Parcelable
{

    public abstract void draw(Canvas canvas, Paint paint);

    public abstract RectF getBounds();

    public abstract void getBounds(RectF rectf);

    public abstract void readFromParcel(Parcel parcel);
}
