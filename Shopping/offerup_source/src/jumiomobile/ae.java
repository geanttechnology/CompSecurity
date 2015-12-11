// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Point;

public class ae
{

    public static double a(Point point, Point point1)
    {
        int i = point.x - point1.x;
        int j = point.y - point1.y;
        return Math.sqrt(i * i + j * j);
    }
}
