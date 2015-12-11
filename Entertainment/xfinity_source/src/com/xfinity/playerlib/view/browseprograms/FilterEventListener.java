// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;


public interface FilterEventListener
{

    public abstract void onCategoryChanged(DibicProgramFilter.FilterCategory filtercategory);

    public abstract void onDownloadOnlyChanged(boolean flag);

    public abstract void onFilterItemDeselected(String s, DibicProgramFilter.FilterCategory filtercategory);

    public abstract void onFilterItemSelected(String s, String s1, DibicProgramFilter.FilterCategory filtercategory);

    public abstract void onSubscriptionOnlyChanged(boolean flag);
}
