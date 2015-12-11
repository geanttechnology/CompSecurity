// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface Availability
{

    public abstract List getFastTrack();

    public abstract String getGeneralAvailability();

    public abstract String getLowStockMessage();

    public abstract String getSecondaryAvailability();

    public abstract void setFastTrack(List list);

    public abstract void setGeneralAvailability(String s);

    public abstract void setLowStockMessage(String s);

    public abstract void setSecondaryAvailability(String s);
}
