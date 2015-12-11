// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;


public final class FeatureStyle
{

    private int mFillColor;
    private int mStrokeColor;
    private int mTintColor;
    private boolean mVisible;
    private float mZScale;

    public FeatureStyle()
    {
    }

    public static FeatureStyle copy(FeatureStyle featurestyle)
    {
        if (featurestyle == null)
        {
            return null;
        } else
        {
            return (new FeatureStyle()).fillColor(featurestyle.mFillColor).strokeColor(featurestyle.mStrokeColor).tintColor(featurestyle.mTintColor).visibilty(featurestyle.mVisible).zScale(featurestyle.mZScale);
        }
    }

    private FeatureStyle zScale(float f)
    {
        mZScale = f;
        return this;
    }

    public FeatureStyle fillColor(int i)
    {
        mFillColor = i;
        return this;
    }

    public int getFillColor()
    {
        return mFillColor;
    }

    public int getStrokeColor()
    {
        return mStrokeColor;
    }

    public int getTintColor()
    {
        return mTintColor;
    }

    public boolean getVisibilty()
    {
        return mVisible;
    }

    public float getZScale()
    {
        return mZScale;
    }

    public FeatureStyle strokeColor(int i)
    {
        mStrokeColor = i;
        return this;
    }

    public FeatureStyle tintColor(int i)
    {
        mTintColor = i;
        return this;
    }

    public FeatureStyle visibilty(boolean flag)
    {
        mVisible = flag;
        return this;
    }
}
