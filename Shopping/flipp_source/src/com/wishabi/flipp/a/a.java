// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.a;

import android.animation.TypeEvaluator;
import android.graphics.RectF;

public final class a
    implements TypeEvaluator
{

    public a()
    {
    }

    public final Object evaluate(float f, Object obj, Object obj1)
    {
        obj = (RectF)obj;
        obj1 = (RectF)obj1;
        return new RectF(((RectF) (obj)).left + (((RectF) (obj1)).left - ((RectF) (obj)).left) * f, ((RectF) (obj)).top + (((RectF) (obj1)).top - ((RectF) (obj)).top) * f, ((RectF) (obj)).right + (((RectF) (obj1)).right - ((RectF) (obj)).right) * f, ((RectF) (obj)).bottom + (((RectF) (obj1)).bottom - ((RectF) (obj)).bottom) * f);
    }
}
