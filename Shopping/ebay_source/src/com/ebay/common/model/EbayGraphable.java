// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.ArrayList;

public interface EbayGraphable
{

    public abstract ArrayList getData();

    public abstract float getGraphXAxisSize();

    public abstract float getGraphYAxisSize();

    public abstract float getLargestXValue();

    public abstract float getLargestYValue();

    public abstract int getRecordCount();

    public abstract float getSmallestXValue();

    public abstract float getSmallestYValue();

    public abstract ArrayList getXAxisLabels(int i);

    public abstract ArrayList getYAxisLabels(int i);
}
