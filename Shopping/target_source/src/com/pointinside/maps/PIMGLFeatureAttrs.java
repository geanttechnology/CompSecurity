// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.g.a.a.a.d;
import com.pointinside.maps.model.FeatureStyle;
import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            PIMGLColor

public class PIMGLFeatureAttrs extends d
{
    public static class ByReference extends PIMGLFeatureAttrs
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

    public static class ByValue extends PIMGLFeatureAttrs
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
    public PIMGLColor mFillColor;
    public PIMGLColor mStrokeColor;
    public boolean mVisible;
    public float mZScale;

    public PIMGLFeatureAttrs()
    {
    }

    PIMGLFeatureAttrs(FeatureStyle featurestyle)
    {
        mVisible = featurestyle.getVisibilty();
        mColor = PIMGLColor.fromColor(featurestyle.getTintColor());
        mFillColor = PIMGLColor.fromColor(featurestyle.getFillColor());
        mStrokeColor = PIMGLColor.fromColor(featurestyle.getStrokeColor());
        mZScale = featurestyle.getZScale();
    }

    public PIMGLFeatureAttrs(Pointer pointer)
    {
        super(pointer);
    }

    public PIMGLFeatureAttrs(boolean flag, PIMGLColor pimglcolor, PIMGLColor pimglcolor1, PIMGLColor pimglcolor2, float f)
    {
        mVisible = flag;
        mColor = pimglcolor;
        mFillColor = pimglcolor1;
        mStrokeColor = pimglcolor2;
        mZScale = f;
    }

    public static PIMGLFeatureAttrs[] newArray(int i)
    {
        return (PIMGLFeatureAttrs[])d.newArray(com/pointinside/maps/PIMGLFeatureAttrs, i);
    }

    protected List getFieldOrder()
    {
        return Arrays.asList(new String[] {
            "mVisible", "mColor", "mFillColor", "mStrokeColor", "mZScale"
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

    protected PIMGLFeatureAttrs newInstance()
    {
        return new PIMGLFeatureAttrs();
    }
}
