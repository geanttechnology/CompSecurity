// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;

// Referenced classes of package com.google.android.gms.internal:
//            fl

public final class fu
    implements GamesMetadata
{
    private static abstract class a extends com.google.android.gms.games.Games.a
    {

        public Result e(Status status)
        {
            return v(status);
        }

        public com.google.android.gms.games.GamesMetadata.LoadGamesResult v(Status status)
        {
            return new com.google.android.gms.games.GamesMetadata.LoadGamesResult(this, status) {

                final Status jP;
                final a uV;

                public GameBuffer getGames()
                {
                    return new GameBuffer(DataHolder.empty(14));
                }

                public Status getStatus()
                {
                    return jP;
                }

                public void release()
                {
                }

            
            {
                uV = a1;
                jP = status;
                super();
            }
            };
        }

        private a()
        {
        }

    }


    public fu()
    {
    }

    public Game getCurrentGame(GoogleApiClient googleapiclient)
    {
        return Games.j(googleapiclient).getCurrentGame();
    }

    public PendingResult loadGame(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new a() {

            final fu uU;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.g(this);
            }

            
            {
                uU = fu.this;
                super();
            }
        });
    }
}
