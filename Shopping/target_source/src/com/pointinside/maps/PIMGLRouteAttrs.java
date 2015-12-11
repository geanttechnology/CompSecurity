// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.pointinside.maps.model.MapRouteStyle;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            PIMGLColor

public class PIMGLRouteAttrs extends d
{
    public static class ByReference extends PIMGLRouteAttrs
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

    public static class ByValue extends PIMGLRouteAttrs
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
    public float mCrawlSpeed;
    public float mLineSpacing;
    public int mLineStyle;
    public float mLineWidth;
    public float mPercentVisible;

    public PIMGLRouteAttrs()
    {
    }

    public PIMGLRouteAttrs(PIMGLColor pimglcolor, float f, int i, float f1, float f2, float f3)
    {
        mColor = pimglcolor;
        mLineWidth = f;
        mLineStyle = i;
        mLineSpacing = f1;
        mCrawlSpeed = f2;
        mPercentVisible = f3;
    }

    public PIMGLRouteAttrs(Pointer pointer)
    {
        super(pointer);
    }

    static PIMGLRouteAttrs fromRouteStyle(MapRouteStyle maproutestyle, float f)
    {
        return new PIMGLRouteAttrs(PIMGLColor.fromColor(maproutestyle.getColor()), maproutestyle.getLineWidth(), maproutestyle.getLineStyle().getId(), maproutestyle.getLineSpacing(), maproutestyle.getCrawlSpeed(), f);
    }

    public static PIMGLRouteAttrs[] newArray(int i)
    {
        return (PIMGLRouteAttrs[])d.newArray(com/pointinside/maps/PIMGLRouteAttrs, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mColor", "mLineWidth", "mLineStyle", "mLineSpacing", "mCrawlSpeed", "mPercentVisible"
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

    protected PIMGLRouteAttrs newInstance()
    {
        return new PIMGLRouteAttrs();
    }
}
