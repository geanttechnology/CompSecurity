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

public class PIMGLRouteLegAttrs extends d
{
    public static class ByReference extends PIMGLRouteLegAttrs
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

    public static class ByValue extends PIMGLRouteLegAttrs
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
    public int mLineStyle;
    public float mLineWidth;

    public PIMGLRouteLegAttrs()
    {
    }

    public PIMGLRouteLegAttrs(PIMGLColor pimglcolor, float f, int i, float f1)
    {
        mColor = pimglcolor;
        mLineWidth = f;
        mLineStyle = i;
        mCrawlSpeed = f1;
    }

    public PIMGLRouteLegAttrs(Pointer pointer)
    {
        super(pointer);
    }

    static PIMGLRouteLegAttrs fromRouteStyle(MapRouteStyle maproutestyle)
    {
        return new PIMGLRouteLegAttrs(PIMGLColor.fromColor(maproutestyle.getColor()), maproutestyle.getLineWidth(), maproutestyle.getLineStyle().getId(), maproutestyle.getCrawlSpeed());
    }

    public static PIMGLRouteLegAttrs[] newArray(int i)
    {
        return (PIMGLRouteLegAttrs[])d.newArray(com/pointinside/maps/PIMGLRouteLegAttrs, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mColor", "mLineWidth", "mLineStyle", "mCrawlSpeed"
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

    protected PIMGLRouteLegAttrs newInstance()
    {
        return new PIMGLRouteLegAttrs();
    }
}
