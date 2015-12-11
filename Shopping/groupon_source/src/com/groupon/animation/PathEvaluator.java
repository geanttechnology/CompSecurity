// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import android.animation.TypeEvaluator;

// Referenced classes of package com.groupon.animation:
//            PathPoint

public class PathEvaluator
    implements TypeEvaluator
{

    public PathEvaluator()
    {
    }

    public PathPoint evaluate(float f, PathPoint pathpoint, PathPoint pathpoint1)
    {
        float f1;
        if (pathpoint1.mOperation == 2)
        {
            f1 = 1.0F - f;
            float f2 = f1 * f1 * f1 * pathpoint.mX + 3F * f1 * f1 * f * pathpoint1.mControl0X + 3F * f1 * f * f * pathpoint1.mControl1X + f * f * f * pathpoint1.mX;
            f1 = f1 * f1 * f1 * pathpoint.mY + 3F * f1 * f1 * f * pathpoint1.mControl0Y + 3F * f1 * f * f * pathpoint1.mControl1Y + f * f * f * pathpoint1.mY;
            f = f2;
        } else
        if (pathpoint1.mOperation == 1)
        {
            f1 = pathpoint.mX + (pathpoint1.mX - pathpoint.mX) * f;
            float f3 = pathpoint.mY + (pathpoint1.mY - pathpoint.mY) * f;
            f = f1;
            f1 = f3;
        } else
        {
            f = pathpoint1.mX;
            f1 = pathpoint1.mY;
        }
        return PathPoint.moveTo(f, f1);
    }

    public volatile Object evaluate(float f, Object obj, Object obj1)
    {
        return evaluate(f, (PathPoint)obj, (PathPoint)obj1);
    }
}
