// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.ItemListsResponse;
import java.util.Map;
import retrofit.Callback;

public interface SearchService
{

    public abstract void doDefaultSearchWithCallBack(int i, int j, double d, double d1, Callback callback);

    public abstract void doSearchWithCallBack(int i, int j, Map map, Callback callback);

    public abstract ItemListsResponse getItemLists();
}
