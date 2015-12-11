// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.groupon.animation:
//            PathPoint

public class AnimatorPath
{

    ArrayList mPoints;

    public AnimatorPath()
    {
        mPoints = new ArrayList();
    }

    public void curveTo(float f, float f1, float f2, float f3, float f4, float f5)
    {
        mPoints.add(PathPoint.curveTo(f, f1, f2, f3, f4, f5));
    }

    public Collection getPoints()
    {
        return mPoints;
    }

    public void lineTo(float f, float f1)
    {
        mPoints.add(PathPoint.lineTo(f, f1));
    }

    public void moveTo(float f, float f1)
    {
        mPoints.add(PathPoint.moveTo(f, f1));
    }
}
