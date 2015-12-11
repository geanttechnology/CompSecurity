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
//            PIMGLRect

public class PIMGLAccessibilityElement extends d
{
    public static class ByReference extends PIMGLAccessibilityElement
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

    public static class ByValue extends PIMGLAccessibilityElement
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


    public boolean mIsAnnotation;
    public PIMGLRect mRect;
    public IntByReference mRef;
    public Pointer mText;

    public PIMGLAccessibilityElement()
    {
    }

    public PIMGLAccessibilityElement(Pointer pointer)
    {
        super(pointer);
    }

    public PIMGLAccessibilityElement(IntByReference intbyreference, Pointer pointer, PIMGLRect pimglrect, boolean flag)
    {
        mRef = intbyreference;
        mText = pointer;
        mRect = pimglrect;
        mIsAnnotation = flag;
    }

    public static PIMGLAccessibilityElement[] newArray(int i)
    {
        return (PIMGLAccessibilityElement[])d.newArray(com/pointinside/maps/PIMGLAccessibilityElement, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mRef", "mText", "mRect", "mIsAnnotation"
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

    protected PIMGLAccessibilityElement newInstance()
    {
        return new PIMGLAccessibilityElement();
    }
}
