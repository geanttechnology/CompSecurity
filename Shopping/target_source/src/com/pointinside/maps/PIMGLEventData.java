// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

public class PIMGLEventData extends d
{
    public static class ByReference extends PIMGLEventData
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

    public static class ByValue extends PIMGLEventData
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


    public PIMGLContext.ByReference mContext;
    public int mError;
    public int mTapCount;
    public float mTapX;
    public float mTapY;
    public int mType;
    public Pointer mUserdata;
    public IntByReference mZone;

    public PIMGLEventData()
    {
    }

    public PIMGLEventData(PIMGLContext.ByReference byreference, int i, int j, Pointer pointer, int k, float f, float f1, 
            IntByReference intbyreference)
    {
        mContext = byreference;
        mType = i;
        mError = j;
        mUserdata = pointer;
        mTapCount = k;
        mTapX = f;
        mTapY = f1;
        mZone = intbyreference;
    }

    public PIMGLEventData(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLEventData[] newArray(int i)
    {
        return (PIMGLEventData[])d.newArray(com/pointinside/maps/PIMGLEventData, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mContext", "mType", "mError", "mUserdata", "mTapCount", "mTapX", "mTapY", "mZone"
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

    protected PIMGLEventData newInstance()
    {
        return new PIMGLEventData();
    }
}
