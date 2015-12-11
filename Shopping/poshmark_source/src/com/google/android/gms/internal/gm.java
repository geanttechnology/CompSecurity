// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;

// Referenced classes of package com.google.android.gms.internal:
//            fx

public final class gm
    implements Players
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.Players.LoadPlayersResult A(Status status)
        {
            return new com.google.android.gms.games.Players.LoadPlayersResult(this, status) {

                final a Ii;
                final Status vb;

                public PlayerBuffer getPlayers()
                {
                    return new PlayerBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return vb;
                }

                public void release()
                {
                }

            
            {
                Ii = a1;
                vb = status;
                super();
            }
            };
        }

        public Result d(Status status)
        {
            return A(status);
        }

        private a()
        {
        }

    }


    public gm()
    {
    }

    public Player getCurrentPlayer(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).fp();
    }

    public String getCurrentPlayerId(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).fo();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).fy();
    }

    public PendingResult loadConnectedPlayers(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.a(new a(flag) {

            final boolean HH;
            final gm Ig;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, HH);
            }

            
            {
                Ig = gm.this;
                HH = flag;
                super();
            }
        });
    }

    public PendingResult loadInvitablePlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.a(new a(i, flag) {

            final boolean HH;
            final gm Ig;
            final int Ih;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, Ih, false, HH);
            }

            
            {
                Ig = gm.this;
                Ih = i;
                HH = flag;
                super();
            }
        });
    }

    public PendingResult loadMoreInvitablePlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new a(i) {

            final gm Ig;
            final int Ih;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, Ih, true, false);
            }

            
            {
                Ig = gm.this;
                Ih = i;
                super();
            }
        });
    }

    public PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new a(i) {

            final gm Ig;
            final int Ih;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, "playedWith", Ih, true, false);
            }

            
            {
                Ig = gm.this;
                Ih = i;
                super();
            }
        });
    }

    public PendingResult loadPlayer(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new a(s) {

            final String If;
            final gm Ig;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, If);
            }

            
            {
                Ig = gm.this;
                If = s;
                super();
            }
        });
    }

    public PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.a(new a(i, flag) {

            final boolean HH;
            final gm Ig;
            final int Ih;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.a(this, "playedWith", Ih, false, HH);
            }

            
            {
                Ig = gm.this;
                Ih = i;
                HH = flag;
                super();
            }
        });
    }
}
