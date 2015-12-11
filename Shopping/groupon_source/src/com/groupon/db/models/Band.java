// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.util.SortableCard;
import java.util.Date;

public class Band
    implements SortableCard
{

    public String channel;
    public int derivedActualPosition;
    public int derivedTrackingPosition;
    public String message;
    public Date modificationDate;
    public Long primaryKey;

    public Band()
    {
    }

    public int cardPosition()
    {
        return derivedActualPosition;
    }
}
