// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

public interface RemoveFavoritesResult
{

    public abstract boolean getCustomerRequired();

    public abstract List getErrors();

    public abstract boolean getSucceeded();

    public abstract void setCustomerRequired(boolean flag);

    public abstract void setErrors(List list);

    public abstract void setSucceeded(boolean flag);
}
