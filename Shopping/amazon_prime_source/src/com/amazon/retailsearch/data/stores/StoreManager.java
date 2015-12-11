// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.stores;

import java.util.Map;

public interface StoreManager
{

    public abstract String getStoreBadgeUrl(String s);

    public abstract String getStoreColor(String s);

    public abstract int getStoreCount();

    public abstract String getStoreName(String s);

    public abstract boolean isMultiStoreOffersEnabled();

    public abstract void updateStoreMap(Map map);
}
