// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.Color;
import com.g.a.a.a.d;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

public class PIMGLColor extends d
{
    public static class ByReference extends PIMGLColor
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

    public static class ByValue extends PIMGLColor
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


    public float mA;
    public float mB;
    public float mG;
    public float mR;

    public PIMGLColor()
    {
    }

    public PIMGLColor(float f, float f1, float f2, float f3)
    {
        mR = f;
        mG = f1;
        mB = f2;
        mA = f3;
    }

    public PIMGLColor(Pointer pointer)
    {
        super(pointer);
    }

    public static PIMGLColor fromColor(int i)
    {
        return new PIMGLColor((float)Color.red(i) / 255F, (float)Color.green(i) / 255F, (float)Color.blue(i) / 255F, (float)Color.alpha(i) / 255F);
    }

    public static PIMGLColor[] newArray(int i)
    {
        return (PIMGLColor[])d.newArray(com/pointinside/maps/PIMGLColor, i);
    }

    public int getColor()
    {
        return Color.argb(Math.round(mA * 255F), Math.round(mR * 255F), Math.round(mG * 255F), Math.round(mB * 255F));
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mR", "mG", "mB", "mA"
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

    protected PIMGLColor newInstance()
    {
        return new PIMGLColor();
    }
}
