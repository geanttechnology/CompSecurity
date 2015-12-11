// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

public class PIMGLPoint extends d
{
    public static class ByReference extends PIMGLPoint
        implements com.g.a.a.a.d.a
    {

        protected volatile d newByReference()
        {
            return newByReference();
        }

        protected volatile d newByValue()
        {
            return newByValue();
        }

        protected volatile d newInstance()
        {
            return newInstance();
        }

        public ByReference()
        {
        }
    }

    public static class ByValue extends PIMGLPoint
        implements com.g.a.a.a.d.b
    {

        protected volatile d newByReference()
        {
            return newByReference();
        }

        protected volatile d newByValue()
        {
            return newByValue();
        }

        protected volatile d newInstance()
        {
            return newInstance();
        }

        public ByValue()
        {
        }
    }


    public float mX;
    public float mY;
    public float mZ;

    public PIMGLPoint()
    {
    }

    public PIMGLPoint(float f, float f1, float f2)
    {
        mX = f;
        mY = f1;
        mZ = f2;
    }

    public PIMGLPoint(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLPoint[] newArray(int i)
    {
        return (PIMGLPoint[])d.newArray(com/pointinside/maps/PIMGLPoint, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mX", "mY", "mZ"
        });
    }

    protected volatile d newByReference()
    {
        return newByReference();
    }

    protected ByReference newByReference()
    {
        return new ByReference();
    }

    protected volatile d newByValue()
    {
        return newByValue();
    }

    protected ByValue newByValue()
    {
        return new ByValue();
    }

    protected volatile d newInstance()
    {
        return newInstance();
    }

    protected PIMGLPoint newInstance()
    {
        return new PIMGLPoint();
    }
}
