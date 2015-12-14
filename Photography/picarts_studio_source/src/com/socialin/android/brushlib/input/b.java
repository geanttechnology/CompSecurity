// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input;

import android.graphics.PointF;

public interface b
{

    public abstract void onLongPress(PointF pointf);

    public abstract void onPan(PointF pointf);

    public abstract void onPanEnd(PointF pointf);

    public abstract void onPanStart(PointF pointf);

    public abstract void onPinch(PointF pointf, PointF pointf1);

    public abstract void onPinchEnd(PointF pointf, PointF pointf1);

    public abstract void onPinchStart(PointF pointf, PointF pointf1);

    public abstract void onTap(PointF pointf);
}
