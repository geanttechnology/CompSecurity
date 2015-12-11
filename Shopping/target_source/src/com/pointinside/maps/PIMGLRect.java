// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

public class PIMGLRect extends d
{
    public static class ByReference extends PIMGLRect
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

    public static class ByValue extends PIMGLRect
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


    public float mXMax;
    public float mXMin;
    public float mYMax;
    public float mYMin;

    public PIMGLRect()
    {
    }

    public PIMGLRect(float f, float f1, float f2, float f3)
    {
        mXMin = f;
        mYMin = f1;
        mXMax = f2;
        mYMax = f3;
    }

    public PIMGLRect(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLRect[] newArray(int i)
    {
        return (PIMGLRect[])d.newArray(com/pointinside/maps/PIMGLRect, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mXMin", "mYMin", "mXMax", "mYMax"
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

    protected PIMGLRect newInstance()
    {
        return new PIMGLRect();
    }
}
