// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model;


public interface TimelineEntry
{

    public abstract int getCount();

    public abstract int getId();

    public abstract int getMonth();

    public abstract int getYear();

    public abstract boolean isNoDate();
}
