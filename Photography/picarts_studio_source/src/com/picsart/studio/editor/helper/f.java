// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.animation.TypeEvaluator;
import android.graphics.RectF;
import com.socialin.android.util.Geom;

public final class f
    implements TypeEvaluator
{

    private RectF a;

    public f()
    {
        a = new RectF();
    }

    public final Object evaluate(float f1, Object obj, Object obj1)
    {
        obj = (RectF)obj;
        obj1 = (RectF)obj1;
        Geom.a(a, ((RectF) (obj)), ((RectF) (obj1)), f1);
        return a;
    }
}
