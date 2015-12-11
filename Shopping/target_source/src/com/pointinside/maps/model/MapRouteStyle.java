// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;


public class MapRouteStyle
{
    public static final class RouteLineStyle extends Enum
    {

        private static final RouteLineStyle $VALUES[];
        public static final RouteLineStyle DOTTED;
        public static final RouteLineStyle SOLID;
        private final int id;

        public static RouteLineStyle valueOf(String s)
        {
            return (RouteLineStyle)Enum.valueOf(com/pointinside/maps/model/MapRouteStyle$RouteLineStyle, s);
        }

        public static RouteLineStyle[] values()
        {
            return (RouteLineStyle[])$VALUES.clone();
        }

        public int getId()
        {
            return id;
        }

        static 
        {
            SOLID = new RouteLineStyle("SOLID", 0, 0);
            DOTTED = new RouteLineStyle("DOTTED", 1, 1);
            $VALUES = (new RouteLineStyle[] {
                SOLID, DOTTED
            });
        }

        private RouteLineStyle(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }


    public static final int DEFAULT_COLOR = 0xffff0000;
    public static final int DEFAULT_CRAWL_SPEED = 5;
    public static final float DEFAULT_LINE_SPACING = 1F;
    public static final RouteLineStyle DEFAULT_LINE_STYLE;
    public static final float DEFAULT_WIDTH = 6F;
    private int mColor;
    private int mCrawlSpeed;
    private float mLineSpacing;
    private RouteLineStyle mLineStyle;
    private float mLineWidth;

    public MapRouteStyle()
    {
        mColor = 0xffff0000;
        mLineWidth = 6F;
        mLineStyle = DEFAULT_LINE_STYLE;
        mLineSpacing = 1.0F;
        mCrawlSpeed = 5;
    }

    public static MapRouteStyle copy(MapRouteStyle maproutestyle)
    {
        if (maproutestyle == null)
        {
            return null;
        } else
        {
            return (new MapRouteStyle()).color(maproutestyle.mColor).crawlSpeed(maproutestyle.mCrawlSpeed).lineStyle(maproutestyle.mLineStyle).lineWidth(maproutestyle.mLineWidth).lineSpacing(maproutestyle.mLineSpacing);
        }
    }

    public MapRouteStyle color(int i)
    {
        mColor = i;
        return this;
    }

    public MapRouteStyle crawlSpeed(int i)
    {
        mCrawlSpeed = i;
        return this;
    }

    public int getColor()
    {
        return mColor;
    }

    public int getCrawlSpeed()
    {
        return mCrawlSpeed;
    }

    public float getLineSpacing()
    {
        return mLineSpacing;
    }

    public RouteLineStyle getLineStyle()
    {
        return mLineStyle;
    }

    public float getLineWidth()
    {
        return mLineWidth;
    }

    public MapRouteStyle lineSpacing(float f)
    {
        mLineSpacing = f;
        return this;
    }

    public MapRouteStyle lineStyle(RouteLineStyle routelinestyle)
    {
        mLineStyle = routelinestyle;
        return this;
    }

    public MapRouteStyle lineWidth(float f)
    {
        mLineWidth = f;
        return this;
    }

    static 
    {
        DEFAULT_LINE_STYLE = RouteLineStyle.DOTTED;
    }
}
