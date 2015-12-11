// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface Savings
{

    public abstract String getAmountSaved();

    public abstract int getPercentageSaved();

    public abstract List getSavedMessage();

    public abstract void setAmountSaved(String s);

    public abstract void setPercentageSaved(int i);

    public abstract void setSavedMessage(List list);
}
