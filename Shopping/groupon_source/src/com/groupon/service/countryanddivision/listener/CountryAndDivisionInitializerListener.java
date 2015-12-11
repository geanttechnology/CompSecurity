// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision.listener;


public interface CountryAndDivisionInitializerListener
{

    public abstract void onCountryAndDivisionSet();

    public abstract void onException(Exception exception);

    public abstract void onManualCountrySelectionNeeded();

    public abstract void onManualDivisionSelectionNeeded();
}
