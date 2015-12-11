// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;

import android.graphics.Point;

public class ResolutionPoints extends Point
    implements Comparable
{

    public ResolutionPoints(int i, int j)
    {
        set(i, j);
    }

    public int compareTo(Point point)
    {
        int i = point.x;
        int j = point.y;
        return x * y - i * j;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Point)obj);
    }
}
