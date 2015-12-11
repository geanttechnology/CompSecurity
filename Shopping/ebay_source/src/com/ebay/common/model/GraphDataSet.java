// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.ArrayList;

public interface GraphDataSet
{
    public static interface GraphPoint
    {

        public abstract float getX();

        public abstract float getY();
    }


    public abstract int getDataColor();

    public abstract int getLegendId();

    public abstract ArrayList getList();
}
