// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


public interface CategoryIntentProperties
{

    public abstract com.groupon.db.models.Features.SearchIntentCategory getCategoryIntent();

    public abstract boolean isBeautyAndSpaIntent();

    public abstract boolean isFoodAndDrinkIntent();

    public abstract boolean isIntentUnknown();
}
