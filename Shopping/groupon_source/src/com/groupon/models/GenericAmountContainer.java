// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


public interface GenericAmountContainer
{

    public abstract int getAmount();

    public abstract String getCurrencyCode();

    public abstract String getFormattedAmount();

    public abstract void setAmount(int i);

    public abstract void setCurrencyCode(String s);

    public abstract void setFormattedAmount(String s);
}
