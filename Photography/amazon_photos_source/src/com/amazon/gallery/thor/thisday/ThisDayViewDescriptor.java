// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;


public class ThisDayViewDescriptor
{

    public final long focusedMediaItemCreationDate;
    public final int focusedYear;
    public final boolean isShuffleData;
    public final boolean isWeekData;

    public ThisDayViewDescriptor(int i, boolean flag, boolean flag1, long l)
    {
        focusedYear = i;
        isWeekData = flag;
        isShuffleData = flag1;
        focusedMediaItemCreationDate = l;
    }
}
