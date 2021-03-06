// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.service.operations.requests;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.broker.DataBroker;
import com.google.android.gms.games.broker.GamesClientContext;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.service.WrappedGamesCallbacks;
import com.google.android.gms.games.service.operations.AbstractDataHolderOperation;

public final class LoadRequestSummariesOperation extends AbstractDataHolderOperation
{

    private final WrappedGamesCallbacks mCallbacks;
    private final GamesClientContext mGamesContext;
    private final int mRequestTypes;

    public LoadRequestSummariesOperation(GamesClientContext gamesclientcontext, WrappedGamesCallbacks wrappedgamescallbacks, int i)
    {
        super(gamesclientcontext.mClientContext);
        mCallbacks = wrappedgamescallbacks;
        mGamesContext = gamesclientcontext;
        mRequestTypes = i;
    }

    protected final DataHolder fetchData(Context context, DataBroker databroker)
        throws GoogleAuthException
    {
        int i = databroker.syncRequests(mGamesContext, new com.google.android.gms.games.service.GamesSyncAdapter.GamesSyncResult());
        return databroker.getLocalRequestSummaries(mGamesContext, mRequestTypes, i);
    }

    protected final void provideResult(DataHolder dataholder)
        throws RemoteException
    {
        WrappedGamesCallbacks wrappedgamescallbacks = mCallbacks;
        wrappedgamescallbacks.audit(new DataHolder[] {
            dataholder
        });
        wrappedgamescallbacks.mCallbacks.onRequestSummariesLoaded(dataholder);
    }
}
