// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.stroke;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class SerializableStroke
    implements Serializable
{

    private static final long serialVersionUID = 0xf615abeac3b6b768L;
    private List points;

    public SerializableStroke()
    {
        points = new LinkedList();
    }

    public void addPoint(float f, float f1)
    {
        points.add(new StrokePoint(f, f1));
    }

    public void clear()
    {
        points.clear();
    }

    public List getPoints()
    {
        return points;
    }

    private class StrokePoint
        implements Serializable
    {

        private static final long serialVersionUID = 0xe58c04ba5ca9ebd6L;
        private float x;
        private float y;

        public float getX()
        {
            return x;
        }

        public float getY()
        {
            return y;
        }

        public void setX(float f)
        {
            x = f;
        }

        public void setY(float f)
        {
            y = f;
        }

        public PointF toPointF()
        {
            return new PointF(x, y);
        }

        public StrokePoint(float f, float f1)
        {
            x = f;
            y = f1;
        }
    }

}
