// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.c;
import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

public class PIMGLFeatureSet extends d
{
    public static class ByReference extends PIMGLFeatureSet
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

    public static class ByValue extends PIMGLFeatureSet
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


    public FloatByReference mDistances;
    public PointerByReference mNames;
    public c mSize;

    public PIMGLFeatureSet()
    {
    }

    public PIMGLFeatureSet(Pointer pointer)
    {
        super(pointer);
    }

    public PIMGLFeatureSet(PointerByReference pointerbyreference, FloatByReference floatbyreference, c c)
    {
        mNames = pointerbyreference;
        mDistances = floatbyreference;
        mSize = c;
    }

    public static PIMGLFeatureSet[] newArray(int i)
    {
        return (PIMGLFeatureSet[])d.newArray(com/pointinside/maps/PIMGLFeatureSet, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mNames", "mDistances", "mSize"
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

    protected PIMGLFeatureSet newInstance()
    {
        return new PIMGLFeatureSet();
    }
}
