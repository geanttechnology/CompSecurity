// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gw;

// Referenced classes of package com.google.android.gms.games:
//            GamesMetadata, Notifications, Players

public final class Games
{
    public static final class GamesOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
    {

        final boolean Gc;
        final boolean Gd;
        final int Ge;
        final boolean Gf;
        final int Gg;

        public static Builder builder()
        {
            return new Builder();
        }

        private GamesOptions()
        {
            Gc = false;
            Gd = true;
            Ge = 17;
            Gf = false;
            Gg = 4368;
        }


        private GamesOptions(Builder builder1)
        {
            Gc = builder1.Gc;
            Gd = builder1.Gd;
            Ge = builder1.Ge;
            Gf = builder1.Gf;
            Gg = builder1.Gg;
        }

    }

    public static final class GamesOptions.Builder
    {

        boolean Gc;
        boolean Gd;
        int Ge;
        boolean Gf;
        int Gg;

        public GamesOptions build()
        {
            return new GamesOptions(this);
        }

        public GamesOptions.Builder setSdkVariant(int i)
        {
            Gg = i;
            return this;
        }

        public GamesOptions.Builder setShowConnectingPopup(boolean flag)
        {
            Gd = flag;
            Ge = 17;
            return this;
        }

        public GamesOptions.Builder setShowConnectingPopup(boolean flag, int i)
        {
            Gd = flag;
            Ge = i;
            return this;
        }

        private GamesOptions.Builder()
        {
            Gc = false;
            Gd = true;
            Ge = 17;
            Gf = false;
            Gg = 4368;
        }

    }

    public static abstract class a extends com.google.android.gms.common.api.a.a
        implements PendingResult
    {

        public a()
        {
            super(Games.va);
        }
    }

    private static abstract class b extends a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        private b()
        {
        }

    }


    public static final Api API;
    public static final Achievements Achievements = new gf();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Scope FY;
    public static final Api FZ;
    public static final Multiplayer Ga = new gk();
    public static final GamesMetadata GamesMetadata = new gh();
    public static final gw Gb = new gg();
    public static final Invitations Invitations = new gi();
    public static final Leaderboards Leaderboards = new gj();
    public static final Notifications Notifications = new gl();
    public static final Players Players = new gm();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new gn();
    public static final Requests Requests = new go();
    public static final Scope SCOPE_GAMES;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new gp();
    static final com.google.android.gms.common.api.Api.b va;

    private Games()
    {
    }

    public static fx c(GoogleApiClient googleapiclient)
    {
        boolean flag1 = true;
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.b(flag, "GoogleApiClient parameter is required.");
        er.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (fx)googleapiclient.a(va);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        er.a(flag, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    public static String getAppId(GoogleApiClient googleapiclient)
    {
        return c(googleapiclient).fB();
    }

    public static String getCurrentAccountName(GoogleApiClient googleapiclient)
    {
        return c(googleapiclient).fn();
    }

    public static int getSdkVariant(GoogleApiClient googleapiclient)
    {
        return c(googleapiclient).fA();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleapiclient)
    {
        return c(googleapiclient).fz();
    }

    public static void setGravityForPopups(GoogleApiClient googleapiclient, int i)
    {
        c(googleapiclient).aT(i);
    }

    public static void setViewForPopups(GoogleApiClient googleapiclient, View view)
    {
        er.f(view);
        c(googleapiclient).e(view);
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new b() {

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((fx)a1);
            }

            protected void a(fx fx1)
            {
                fx1.b(this);
            }

        });
    }

    static 
    {
        va = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return e(context, looper, ee1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public fx e(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                GamesOptions gamesoptions = new GamesOptions();
                if (apioptions != null)
                {
                    er.b(apioptions instanceof GamesOptions, "Must provide valid GamesOptions!");
                    apioptions = (GamesOptions)apioptions;
                } else
                {
                    apioptions = gamesoptions;
                }
                return new fx(context, looper, ee1.dV(), ee1.dR(), connectioncallbacks, onconnectionfailedlistener, ee1.dU(), ee1.dS(), ee1.dW(), ((GamesOptions) (apioptions)).Gc, ((GamesOptions) (apioptions)).Gd, ((GamesOptions) (apioptions)).Ge, ((GamesOptions) (apioptions)).Gf, ((GamesOptions) (apioptions)).Gg);
            }

            public int getPriority()
            {
                return 1;
            }

        };
        SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
        API = new Api(va, new Scope[] {
            SCOPE_GAMES
        });
        FY = new Scope("https://www.googleapis.com/auth/games.firstparty");
        FZ = new Api(va, new Scope[] {
            FY
        });
    }
}
