// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;

import com.pointinside.maps.Location;
import java.util.LinkedList;
import java.util.List;

public final class PolylineOptions
{

    private int mColor;
    private List mLinePoint;
    private boolean mVisible;

    public PolylineOptions()
    {
        mLinePoint = new LinkedList();
    }

    public static PolylineOptions copy(PolylineOptions polylineoptions)
    {
        return (new PolylineOptions()).addAll(new LinkedList(polylineoptions.mLinePoint)).color(polylineoptions.mColor).visible(polylineoptions.mVisible);
    }

    public PolylineOptions add(Location location)
    {
        mLinePoint.add(location);
        return this;
    }

    public PolylineOptions addAll(List list)
    {
        mLinePoint.addAll(list);
        return this;
    }

    public PolylineOptions color(int i)
    {
        mColor = i;
        return this;
    }

    public int getColor()
    {
        return mColor;
    }

    public List getPoints()
    {
        return mLinePoint;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public PolylineOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }
}
