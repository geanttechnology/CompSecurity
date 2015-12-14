// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Vector2D
    implements Serializable
{

    private static final long serialVersionUID = 0xe666e5a0cf311132L;
    protected double x;
    protected double y;

    public Vector2D()
    {
        this(0.0D, 0.0D);
    }

    public Vector2D(double d)
    {
        this(d, d);
    }

    public Vector2D(double d, double d1)
    {
        x = d;
        y = d1;
    }

    public Vector2D(Vector2D vector2d)
    {
        x = vector2d.x;
        y = vector2d.y;
    }

    public static double cross(Vector2D vector2d, Vector2D vector2d1)
    {
        return vector2d.cross(vector2d1);
    }

    public static Vector2D difference(Vector2D vector2d, Vector2D vector2d1)
    {
        return (new Vector2D(vector2d)).sub(vector2d1);
    }

    public static double dot(Vector2D vector2d, Vector2D vector2d1)
    {
        return vector2d.dot(vector2d1);
    }

    public static Vector2D mean(List list)
    {
        int i = list.size();
        if (i == 0)
        {
            return new Vector2D(0.0D, 0.0D);
        } else
        {
            return sum(list).scale(1.0D / (double)i);
        }
    }

    public static Vector2D mult(Vector2D vector2d, double d)
    {
        return (new Vector2D(vector2d)).scale(d);
    }

    public static Vector2D rotate90(Vector2D vector2d)
    {
        return new Vector2D(-vector2d.y, vector2d.x);
    }

    public static Vector2D rotate90R(Vector2D vector2d)
    {
        return new Vector2D(vector2d.y, -vector2d.x);
    }

    public static Vector2D sum(Vector2D vector2d, Vector2D vector2d1)
    {
        return (new Vector2D(vector2d)).addThis(vector2d1);
    }

    public static Vector2D sum(List list)
    {
        Vector2D vector2d = new Vector2D(0.0D, 0.0D);
        for (list = list.iterator(); list.hasNext(); vector2d.addThis((Vector2D)list.next())) { }
        return vector2d;
    }

    public Vector2D add(Vector2D vector2d)
    {
        return new Vector2D(x + vector2d.x, y + vector2d.y);
    }

    public Vector2D addThis(Vector2D vector2d)
    {
        x = x + vector2d.x;
        y = y + vector2d.y;
        return this;
    }

    public double angle(Vector2D vector2d)
    {
        return Math.atan2(y, x) - Math.atan2(vector2d.y, vector2d.x);
    }

    public Object clone()
    {
        return new Vector2D(x, y);
    }

    public double cross(Vector2D vector2d)
    {
        return x * vector2d.y - y * vector2d.x;
    }

    public double distance(Vector2D vector2d)
    {
        return Math.sqrt(distanceSquared(vector2d));
    }

    public double distanceSquared(Vector2D vector2d)
    {
        double d = vector2d.getX() - getX();
        double d1 = vector2d.getY() - getY();
        return d * d + d1 * d1;
    }

    public double dot(Vector2D vector2d)
    {
        return x * vector2d.x + y * vector2d.y;
    }

    public double dotProduct(Vector2D vector2d)
    {
        return vector2d.x * x + vector2d.y * y;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Vector2D)
        {
            obj = (Vector2D)obj;
            flag = flag1;
            if (((Vector2D) (obj)).x == x)
            {
                flag = flag1;
                if (((Vector2D) (obj)).y == y)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean equalsDelta(Vector2D vector2d, double d)
    {
        return vector2d.getX() - d < x && vector2d.getX() + d > x && vector2d.getY() - d < y && vector2d.getY() + d > y;
    }

    public double[] getCoords()
    {
        return (new double[] {
            x, y
        });
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public int hashCode()
    {
        return (int)(x + y);
    }

    public float length()
    {
        return (float)Math.sqrt(x * x + y * y);
    }

    public double lengthSquared()
    {
        return x * x + y * y;
    }

    public double level()
    {
        return Math.sqrt(dotProduct(this));
    }

    public Vector2D modulate(Vector2D vector2d)
    {
        return new Vector2D(x * vector2d.x, y * vector2d.y);
    }

    public void move(double d, double d1)
    {
        x = x + d;
        y = y + d1;
    }

    public void move(Vector2D vector2d)
    {
        x = x + vector2d.x;
        y = y + vector2d.y;
    }

    public Vector2D multiply(double d)
    {
        return new Vector2D(x * d, y * d);
    }

    public Vector2D normalize()
    {
        double d = Math.sqrt(dotProduct(this));
        return new Vector2D(x / d, y / d);
    }

    public Vector2D reverse()
    {
        x = -x;
        y = -y;
        return this;
    }

    public void rotate90()
    {
        setLocation(y, -x);
    }

    public Vector2D scale(double d)
    {
        x = x * d;
        y = y * d;
        return this;
    }

    public void set(double d, double d1)
    {
        x = d;
        y = d1;
    }

    public void set(float f, float f1)
    {
        x = f;
        y = f1;
    }

    public void set(Vector2D vector2d)
    {
        set(vector2d.getX(), vector2d.getY());
    }

    public void setLocation(double d, double d1)
    {
        x = d;
        y = d1;
    }

    public void setX(double d)
    {
        x = d;
    }

    public void setY(double d)
    {
        y = d;
    }

    public Vector2D sub(Vector2D vector2d)
    {
        x = x - vector2d.getX();
        y = y - vector2d.getY();
        return this;
    }

    public Vector2D subtract(Vector2D vector2d)
    {
        return new Vector2D(x - vector2d.x, y - vector2d.y);
    }

    public String toString()
    {
        return "[Vector2D x:" + x + " y:" + y + "]";
    }

    public int x()
    {
        return (int)x;
    }

    public int y()
    {
        return (int)y;
    }
}
