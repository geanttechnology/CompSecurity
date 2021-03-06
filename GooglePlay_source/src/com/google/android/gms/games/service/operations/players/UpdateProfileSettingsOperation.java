// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.service.operations.players;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.games.broker.DataBroker;
import com.google.android.gms.games.broker.GamesClientContext;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.service.WrappedGamesCallbacks;
import com.google.android.gms.games.service.operations.AbstractStatusReportingOperation;

public final class UpdateProfileSettingsOperation extends AbstractStatusReportingOperation
{

    private final WrappedGamesCallbacks mCallbacks;
    private final GamesClientContext mGamesContext;
    private final boolean mProfileVisible;

    public UpdateProfileSettingsOperation(GamesClientContext gamesclientcontext, WrappedGamesCallbacks wrappedgamescallbacks, boolean flag)
    {
        super(gamesclientcontext.mClientContext);
        mCallbacks = wrappedgamescallbacks;
        mGamesContext = gamesclientcontext;
        mProfileVisible = flag;
    }

    protected final int performOperation(Context context, DataBroker databroker)
        throws GoogleAuthException
    {
        return databroker.updateProfileSettings(mGamesContext, mProfileVisible);
    }

    protected final void provideResult(int i)
        throws RemoteException
    {
        mCallbacks.mCallbacks.onProfileSettingsUpdated(i);
    }
}
