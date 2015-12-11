// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.animation.TypeEvaluator;
import android.graphics.Point;

// Referenced classes of package com.poshmark.utils:
//            GestureViewUtils

class this._cls0
    implements TypeEvaluator
{

    final GestureViewUtils this$0;

    public Point evaluate(float f, Point point, Point point1)
    {
        return point1;
    }

    public volatile Object evaluate(float f, Object obj, Object obj1)
    {
        return evaluate(f, (Point)obj, (Point)obj1);
    }

    ()
    {
        this$0 = GestureViewUtils.this;
        super();
    }
}
