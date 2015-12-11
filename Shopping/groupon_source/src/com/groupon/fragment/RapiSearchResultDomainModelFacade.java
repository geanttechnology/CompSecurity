// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import java.util.Date;

public interface RapiSearchResultDomainModelFacade
{

    public abstract int getPartySize();

    public abstract Date getReservationDate();

    public abstract String getReservationDateFormatted();

    public abstract Date getReservationTime();

    public abstract String getReservationTimeFormatted();

    public abstract String getServiceType();

    public abstract boolean isMakeAReservationToggled();

    public abstract boolean isReservationHeaderVisible();
}
