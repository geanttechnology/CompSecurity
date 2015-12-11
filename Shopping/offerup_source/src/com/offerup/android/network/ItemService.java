// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.ItemResponse;
import retrofit.Callback;

public interface ItemService
{

    public abstract void createItem(String s, Integer integer, Integer integer1, String s1, Double double1, Integer integer2, String s2, 
            Integer integer3, String s3, Double double2, Double double3, int i, String s4, Callback callback);

    public abstract void deleteItem(long l, Callback callback);

    public abstract ItemResponse getItem(long l);

    public abstract void getItem(long l, Callback callback);

    public abstract void getItemWithUserEngagement(long l, Callback callback);

    public abstract void markItemAsSold(long l, boolean flag, Callback callback);

    public abstract void updateItem(long l, int i, Callback callback);

    public abstract void updateItem(long l, String s, Integer integer, Integer integer1, String s1, Double double1, 
            Integer integer2, String s2, Integer integer3, String s3, Double double2, Double double3, Callback callback);
}
