// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api;

import java.util.Date;

public interface AchievementData
{

    public abstract String getAchievementIconURL();

    public abstract String getAction();

    public abstract int getDistance();

    public abstract String getMessage();

    public abstract int getMpointValue();

    public abstract String getName();

    public abstract boolean isCustom();

    public abstract Date lastEarnedDate();
}
