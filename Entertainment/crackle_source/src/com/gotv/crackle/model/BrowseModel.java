// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;


public abstract class BrowseModel
{

    public BrowseModel()
    {
    }

    public abstract String getDuration();

    public abstract String getExpires();

    public abstract Integer getExpiresInDays();

    public abstract boolean getExpiresInLessThan5days();

    public abstract String getID();

    public abstract String getImageUrl();

    public abstract String getItemType();

    public abstract String getRating();

    public abstract String getRootChannel();

    public abstract String getRootChannelID();

    public abstract String getTitle();
}
