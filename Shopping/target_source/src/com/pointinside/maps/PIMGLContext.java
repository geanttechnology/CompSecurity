// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

public class PIMGLContext extends d
{
    public static class ByReference extends PIMGLContext
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

    public static class ByValue extends PIMGLContext
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


    public int mMoaiContext;
    public PIMGLInterface.PIMGLEventHandlerFunc mOnEvent;
    public Pointer mUserdata;

    public PIMGLContext()
    {
    }

    public PIMGLContext(int i, PIMGLInterface.PIMGLEventHandlerFunc pimgleventhandlerfunc, Pointer pointer)
    {
        mMoaiContext = i;
        mOnEvent = pimgleventhandlerfunc;
        mUserdata = pointer;
    }

    public PIMGLContext(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLContext[] newArray(int i)
    {
        return (PIMGLContext[])d.newArray(com/pointinside/maps/PIMGLContext, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mMoaiContext", "mOnEvent", "mUserdata"
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

    protected PIMGLContext newInstance()
    {
        return new PIMGLContext();
    }
}
