// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            PIMGLColor

public class PIMGLAnnotationAttrs extends d
{
    public static class ByReference extends PIMGLAnnotationAttrs
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

    public static class ByValue extends PIMGLAnnotationAttrs
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


    public PIMGLColor mColor;
    public float mScale;
    public float mShadowAlpha;
    public float mShadowScale;
    public IntByReference mStyle;
    public float mX;
    public float mXOffset;
    public float mY;
    public float mYOffset;
    public float mZ;
    public IntByReference mZone;

    public PIMGLAnnotationAttrs()
    {
    }

    public PIMGLAnnotationAttrs(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLAnnotationAttrs[] newArray(int i)
    {
        return (PIMGLAnnotationAttrs[])d.newArray(com/pointinside/maps/PIMGLAnnotationAttrs, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mZone", "mStyle", "mX", "mY", "mZ", "mXOffset", "mYOffset", "mScale", "mColor", "mShadowScale", 
            "mShadowAlpha"
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

    protected PIMGLAnnotationAttrs newInstance()
    {
        return new PIMGLAnnotationAttrs();
    }
}
