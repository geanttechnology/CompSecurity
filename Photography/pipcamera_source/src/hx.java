// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;

public class hx
{

    private static double a(Point point, Point point1, Point point2)
    {
        return Math.abs((double)((point.x * point1.y + point1.x * point2.y + point2.x * point.y) - point1.x * point.y - point2.x * point1.y - point.x * point2.y) / 2D);
    }

    public static boolean a(PointF pointf, PointF pointf1, PointF pointf2, PointF pointf3, PointF pointf4)
    {
        pointf = new Point((int)pointf.x, (int)pointf.y);
        pointf1 = new Point((int)pointf1.x, (int)pointf1.y);
        pointf2 = new Point((int)pointf2.x, (int)pointf2.y);
        pointf3 = new Point((int)pointf3.x, (int)pointf3.y);
        pointf4 = new Point((int)pointf4.x, (int)pointf4.y);
        Log.d("Walk Game", (new StringBuilder()).append("Quadrangle:new Point(").append(((Point) (pointf)).x).append(",").append(((Point) (pointf)).y).append("),").append("new Point(").append(((Point) (pointf1)).x).append(",").append(((Point) (pointf1)).y).append("),").append("new Point(").append(((Point) (pointf2)).x).append(",").append(((Point) (pointf2)).y).append("),").append("new Point(").append(((Point) (pointf3)).x).append(",").append(((Point) (pointf3)).y).append("),").append("new Point(").append(((Point) (pointf4)).x).append(",").append(((Point) (pointf4)).y).append("),").toString());
        double d = a(((Point) (pointf)), ((Point) (pointf1)), ((Point) (pointf4)));
        double d1 = a(((Point) (pointf1)), ((Point) (pointf2)), ((Point) (pointf4)));
        double d2 = a(((Point) (pointf2)), ((Point) (pointf3)), ((Point) (pointf4)));
        double d3 = a(((Point) (pointf3)), ((Point) (pointf)), ((Point) (pointf4)));
        double d4 = a(((Point) (pointf)), ((Point) (pointf1)), ((Point) (pointf2)));
        return d3 + (d + d1 + d2) == a(((Point) (pointf2)), ((Point) (pointf3)), ((Point) (pointf))) + d4;
    }
}
