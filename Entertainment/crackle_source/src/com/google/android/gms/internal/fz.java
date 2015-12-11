// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
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
//            fl

public final class fz
    implements Players
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public com.google.android.gms.games.Players.LoadPlayersResult B(Status status)
        {
            return new com.google.android.gms.games.Players.LoadPlayersResult(this, status) {

                final Status jP;
                final a vo;

                public PlayerBuffer getPlayers()
                {
                    return new PlayerBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                vo = a1;
                jP = status;
                super();
            }
            };
        }

        public Result e(Status status)
        {
            return B(status);
        }

        private a()
        {
        }

    }


    public fz()
    {
    }

    public Player getCurrentPlayer(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getCurrentPlayer();
    }

    public String getCurrentPlayerId(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getCurrentPlayerId();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getPlayerSearchIntent();
    }

    public PendingResult loadInvitablePlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.a(new a(i, flag) {

            final boolean uN;
            final fz vm;
            final int vn;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vn, false, uN);
            }

            
            {
                vm = fz.this;
                vn = i;
                uN = flag;
                super();
            }
        });
    }

    public PendingResult loadMoreInvitablePlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new a(i) {

            final fz vm;
            final int vn;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vn, true, false);
            }

            
            {
                vm = fz.this;
                vn = i;
                super();
            }
        });
    }

    public PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new a(i) {

            final fz vm;
            final int vn;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, "playedWith", vn, true, false);
            }

            
            {
                vm = fz.this;
                vn = i;
                super();
            }
        });
    }

    public PendingResult loadPlayer(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new a(s) {

            final String vl;
            final fz vm;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, vl);
            }

            
            {
                vm = fz.this;
                vl = s;
                super();
            }
        });
    }

    public PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleapiclient, int i, boolean flag)
    {
        return googleapiclient.a(new a(i, flag) {

            final boolean uN;
            final fz vm;
            final int vn;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.a(this, "playedWith", vn, false, uN);
            }

            
            {
                vm = fz.this;
                vn = i;
                uN = flag;
                super();
            }
        });
    }
}
