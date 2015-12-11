// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

public class PIMGLEdgeInsets extends d
{
    public static class ByReference extends PIMGLEdgeInsets
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

    public static class ByValue extends PIMGLEdgeInsets
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


    public float mBottom;
    public float mLeft;
    public float mRight;
    public float mTop;

    public PIMGLEdgeInsets()
    {
    }

    public PIMGLEdgeInsets(float f, float f1, float f2, float f3)
    {
        mTop = f;
        mLeft = f1;
        mBottom = f2;
        mRight = f3;
    }

    public PIMGLEdgeInsets(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLEdgeInsets[] newArray(int i)
    {
        return (PIMGLEdgeInsets[])d.newArray(com/pointinside/maps/PIMGLEdgeInsets, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mTop", "mLeft", "mBottom", "mRight"
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

    protected PIMGLEdgeInsets newInstance()
    {
        return new PIMGLEdgeInsets();
    }
}
