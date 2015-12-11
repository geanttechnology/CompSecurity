// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.c;
import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

class PIMGLAccessibilityElementSet extends d
{
    public static class ByReference extends PIMGLAccessibilityElementSet
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

    public static class ByValue extends PIMGLAccessibilityElementSet
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


    public PIMGLAccessibilityElement.ByReference mElements;
    public c mSize;

    public PIMGLAccessibilityElementSet()
    {
    }

    public PIMGLAccessibilityElementSet(PIMGLAccessibilityElement.ByReference byreference, c c)
    {
        mElements = byreference;
        mSize = c;
    }

    public PIMGLAccessibilityElementSet(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLAccessibilityElementSet[] newArray(int i)
    {
        return (PIMGLAccessibilityElementSet[])d.newArray(com/pointinside/maps/PIMGLAccessibilityElementSet, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mElements", "mSize"
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

    protected PIMGLAccessibilityElementSet newInstance()
    {
        return new PIMGLAccessibilityElementSet();
    }
}
