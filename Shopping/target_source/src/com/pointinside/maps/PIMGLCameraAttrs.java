// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            CameraAnimation

public class PIMGLCameraAttrs extends d
{
    public static class ByReference extends PIMGLCameraAttrs
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

    public static class ByValue extends PIMGLCameraAttrs
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


    public int animation;
    public float animationDuration;
    public boolean force;
    public float orbit;
    public float scope;
    public float tilt;
    public float x;
    public float y;

    public PIMGLCameraAttrs()
    {
    }

    public PIMGLCameraAttrs(float f, float f1, float f2, float f3, float f4, CameraAnimation cameraanimation, float f5, 
            boolean flag)
    {
        x = f;
        y = -f1;
        orbit = f2;
        scope = f3;
        tilt = f4;
        animation = cameraanimation.ordinal();
        animationDuration = f5;
        force = flag;
    }

    public PIMGLCameraAttrs(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLCameraAttrs[] newArray(int i)
    {
        return (PIMGLCameraAttrs[])d.newArray(com/pointinside/maps/PIMGLCameraAttrs, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "x", "y", "orbit", "scope", "tilt", "animation", "animationDuration", "force"
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

    protected PIMGLCameraAttrs newInstance()
    {
        return new PIMGLCameraAttrs();
    }
}
