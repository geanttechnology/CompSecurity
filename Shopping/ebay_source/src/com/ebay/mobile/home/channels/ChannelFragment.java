// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.channels;


public interface ChannelFragment
{

    public abstract String getDepartmentId();

    public abstract int getPositionInParent();

    public abstract boolean hasCarousel();

    public abstract boolean hasScrollOffset();

    public abstract boolean hasSubChannels();

    public abstract void setTitleVisibility(boolean flag);
}
