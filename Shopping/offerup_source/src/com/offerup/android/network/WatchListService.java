// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.response.UserWatchlistResponse;
import com.offerup.android.dto.response.WatchlistUpdateResponse;
import retrofit.Callback;

public interface WatchListService
{

    public abstract WatchlistUpdateResponse addToWatchlist(long l);

    public abstract void addToWatchlist(long l, Callback callback);

    public abstract UserWatchlistResponse getItemsWatched();

    public abstract WatchlistUpdateResponse removeFromWatchlist(long l);

    public abstract void removeFromWatchlist(long l, Callback callback);
}
