// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.graphics.Point;

public interface PMGestureDetectorListener
{

    public abstract void onActionEnd();

    public abstract void onDrag(Point point, Point point1);

    public abstract void onDragEnd();

    public abstract void onDragStart(Point point);

    public abstract void onPinchZoom(Point point, Point point1, Point point2, Point point3);

    public abstract void onPinchZoomEnd();

    public abstract void onPinchZoomStart(Point point, Point point1);

    public abstract void onSingleTap(Point point);
}
