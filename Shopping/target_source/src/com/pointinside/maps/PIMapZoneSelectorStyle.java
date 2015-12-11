// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.PointF;

public class PIMapZoneSelectorStyle
{
    public static class Builder
    {

        private String mLabelsFontPath;
        private float mLabelsFontSize;
        private boolean mLabelsHidden;
        private PointF mLabelsOffset;
        private int mLabelsOutlineColor;
        private float mLabelsOutlineWidth;
        private int mLabelsTextColor;

        private Builder getThis()
        {
            return this;
        }

        public PIMapZoneSelectorStyle build()
        {
            return new PIMapZoneSelectorStyle(this);
        }

        public Builder setLabelsFontPath(String s)
        {
            mLabelsFontPath = s;
            return getThis();
        }

        public Builder setLabelsFontSize(float f)
        {
            mLabelsFontSize = f;
            return getThis();
        }

        public Builder setLabelsHidden(boolean flag)
        {
            mLabelsHidden = flag;
            return getThis();
        }

        public Builder setLabelsOffset(PointF pointf)
        {
            mLabelsOffset = pointf;
            return getThis();
        }

        public Builder setLabelsOutlineColor(int i)
        {
            mLabelsOutlineColor = i;
            return getThis();
        }

        public Builder setLabelsOutlineWidth(float f)
        {
            mLabelsOutlineWidth = f;
            return getThis();
        }

        public Builder setLabelsTextColor(int i)
        {
            mLabelsTextColor = i;
            return getThis();
        }








        public Builder()
        {
        }
    }


    private String mLabelsFontPath;
    private float mLabelsFontSize;
    private boolean mLabelsHidden;
    private PointF mLabelsOffset;
    private int mLabelsOutlineColor;
    private float mLabelsOutlineWidth;
    private int mLabelsTextColor;

    private PIMapZoneSelectorStyle(Builder builder)
    {
        mLabelsHidden = builder.mLabelsHidden;
        mLabelsFontPath = builder.mLabelsFontPath;
        mLabelsFontSize = builder.mLabelsFontSize;
        mLabelsOutlineWidth = builder.mLabelsOutlineWidth;
        mLabelsOffset = builder.mLabelsOffset;
        mLabelsTextColor = builder.mLabelsTextColor;
        mLabelsOutlineColor = builder.mLabelsOutlineColor;
    }


    public String getLabelsFontPath()
    {
        return mLabelsFontPath;
    }

    public float getLabelsFontSize()
    {
        return mLabelsFontSize;
    }

    public PointF getLabelsOffset()
    {
        return mLabelsOffset;
    }

    public int getLabelsOutlineColor()
    {
        return mLabelsOutlineColor;
    }

    public float getLabelsOutlineWidth()
    {
        return mLabelsOutlineWidth;
    }

    public int getLabelsTextColor()
    {
        return mLabelsTextColor;
    }

    public boolean isLabelsHidden()
    {
        return mLabelsHidden;
    }
}
