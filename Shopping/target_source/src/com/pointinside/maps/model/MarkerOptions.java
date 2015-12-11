// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;

import android.graphics.drawable.Drawable;
import com.pointinside.maps.Location;

public final class MarkerOptions
{
    public static final class AnchorPoint extends Enum
    {

        private static final AnchorPoint $VALUES[];
        public static final AnchorPoint CENTER;
        public static final AnchorPoint CENTER_BOTTOM;

        public static AnchorPoint valueOf(String s)
        {
            return (AnchorPoint)Enum.valueOf(com/pointinside/maps/model/MarkerOptions$AnchorPoint, s);
        }

        public static AnchorPoint[] values()
        {
            return (AnchorPoint[])$VALUES.clone();
        }

        static 
        {
            CENTER = new AnchorPoint("CENTER", 0);
            CENTER_BOTTOM = new AnchorPoint("CENTER_BOTTOM", 1);
            $VALUES = (new AnchorPoint[] {
                CENTER, CENTER_BOTTOM
            });
        }

        private AnchorPoint(String s, int i)
        {
            super(s, i);
        }
    }


    private Location mLocation;
    private AnchorPoint mMarkerAnchorPoint;
    private Drawable mMarkerDrawable;
    private int mMarkerResourceId;
    private AnchorPoint mShadowAnchorPoint;
    private Drawable mShadowDrawable;
    private int mShadowResourceId;
    private int mTintColor;
    private String mTitle;

    public MarkerOptions()
    {
        mMarkerResourceId = 0x7fffffff;
        mShadowResourceId = 0x7fffffff;
        mMarkerAnchorPoint = AnchorPoint.CENTER_BOTTOM;
        mShadowAnchorPoint = AnchorPoint.CENTER;
        mTintColor = -1;
    }

    public static MarkerOptions copy(MarkerOptions markeroptions)
    {
        return (new MarkerOptions()).location(Location.copy(markeroptions.mLocation)).title(markeroptions.mTitle).tintColor(markeroptions.mTintColor).markerDrawable(markeroptions.mMarkerDrawable, markeroptions.mMarkerAnchorPoint).shadowDrawable(markeroptions.mShadowDrawable, markeroptions.mShadowAnchorPoint).markerDrawable(markeroptions.mMarkerResourceId, markeroptions.mMarkerAnchorPoint).shadowDrawable(markeroptions.mShadowResourceId, markeroptions.mShadowAnchorPoint);
    }

    public Location getLocation()
    {
        return mLocation;
    }

    public AnchorPoint getMarkerAnchorPoint()
    {
        return mMarkerAnchorPoint;
    }

    public Drawable getMarkerDrawable()
    {
        return mMarkerDrawable;
    }

    public int getMarkerResourceId()
    {
        return mMarkerResourceId;
    }

    public AnchorPoint getShadowAnchorPoint()
    {
        return mShadowAnchorPoint;
    }

    public Drawable getShadowDrawable()
    {
        return mShadowDrawable;
    }

    public int getShadowResourceId()
    {
        return mShadowResourceId;
    }

    public int getTintColor()
    {
        return mTintColor;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public MarkerOptions location(Location location1)
    {
        mLocation = location1;
        return this;
    }

    public MarkerOptions markerDrawable(int i)
    {
        mMarkerResourceId = i;
        return this;
    }

    public MarkerOptions markerDrawable(int i, AnchorPoint anchorpoint)
    {
        mMarkerResourceId = i;
        mMarkerAnchorPoint = anchorpoint;
        return this;
    }

    public MarkerOptions markerDrawable(Drawable drawable)
    {
        mMarkerDrawable = drawable;
        return this;
    }

    public MarkerOptions markerDrawable(Drawable drawable, AnchorPoint anchorpoint)
    {
        mMarkerDrawable = drawable;
        mMarkerAnchorPoint = anchorpoint;
        return this;
    }

    public MarkerOptions shadowDrawable(int i)
    {
        mShadowResourceId = i;
        return this;
    }

    public MarkerOptions shadowDrawable(int i, AnchorPoint anchorpoint)
    {
        mShadowResourceId = i;
        mShadowAnchorPoint = anchorpoint;
        return this;
    }

    public MarkerOptions shadowDrawable(Drawable drawable)
    {
        mShadowDrawable = drawable;
        return this;
    }

    public MarkerOptions shadowDrawable(Drawable drawable, AnchorPoint anchorpoint)
    {
        mShadowDrawable = drawable;
        mShadowAnchorPoint = anchorpoint;
        return this;
    }

    public MarkerOptions tintColor(int i)
    {
        mTintColor = i;
        return this;
    }

    public MarkerOptions title(String s)
    {
        mTitle = s;
        return this;
    }
}
