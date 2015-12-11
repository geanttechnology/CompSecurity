// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
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
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.ft;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.fw;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gb;
import com.google.android.gms.internal.gg;

// Referenced classes of package com.google.android.gms.games:
//            GamesMetadata, Notifications, Players

public final class Games
{
    public static final class GamesOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
    {

        final boolean ta;
        final boolean tb;
        final int tc;
        final int td;

        public static Builder builder()
        {
            return new Builder();
        }

        private GamesOptions()
        {
            ta = false;
            tb = true;
            tc = 17;
            td = 4368;
        }


        private GamesOptions(Builder builder1)
        {
            ta = builder1.ta;
            tb = builder1.tb;
            tc = builder1.tc;
            td = builder1.td;
        }

    }

    public static final class GamesOptions.Builder
    {

        boolean ta;
        boolean tb;
        int tc;
        int td;

        public GamesOptions build()
        {
            return new GamesOptions(this);
        }

        public GamesOptions.Builder setSdkVariant(int i)
        {
            td = i;
            return this;
        }

        public GamesOptions.Builder setShowConnectingPopup(boolean flag)
        {
            tb = flag;
            tc = 17;
            return this;
        }

        public GamesOptions.Builder setShowConnectingPopup(boolean flag, int i)
        {
            tb = flag;
            tc = i;
            return this;
        }

        private GamesOptions.Builder()
        {
            ta = false;
            tb = true;
            tc = 17;
            td = 4368;
        }

    }

    public static abstract class a extends com.google.android.gms.common.api.a.a
        implements PendingResult
    {

        public a()
        {
            super(Games.jO);
        }
    }

    private static abstract class b extends a
    {

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        private b()
        {
        }

    }


    public static final Api API;
    public static final Achievements Achievements = new fs();
    public static final GamesMetadata GamesMetadata = new fu();
    public static final Invitations Invitations = new fv();
    public static final Leaderboards Leaderboards = new fw();
    public static final Notifications Notifications = new fy();
    public static final Players Players = new fz();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new ga();
    public static final Scope SCOPE_GAMES;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new gb();
    static final com.google.android.gms.common.api.Api.b jO;
    public static final Scope sW;
    public static final Api sX;
    public static final Multiplayer sY = new fx();
    public static final gg sZ = new ft();

    private Games()
    {
    }

    public static String getAppId(GoogleApiClient googleapiclient)
    {
        return j(googleapiclient).getAppId();
    }

    public static String getCurrentAccountName(GoogleApiClient googleapiclient)
    {
        return j(googleapiclient).getCurrentAccountName();
    }

    public static int getSdkVariant(GoogleApiClient googleapiclient)
    {
        return j(googleapiclient).dd();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleapiclient)
    {
        return j(googleapiclient).getSettingsIntent();
    }

    public static fl j(GoogleApiClient googleapiclient)
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
        eg.b(flag, "GoogleApiClient parameter is required.");
        eg.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (fl)googleapiclient.a(jO);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.a(flag, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    public static void setGravityForPopups(GoogleApiClient googleapiclient, int i)
    {
        j(googleapiclient).setGravityForPopups(i);
    }

    public static void setViewForPopups(GoogleApiClient googleapiclient, View view)
    {
        eg.f(view);
        j(googleapiclient).setViewForPopups(view);
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new b() {

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((fl)a1);
            }

            protected void a(fl fl1)
            {
                fl1.b(this);
            }

        });
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return e(context, dt1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public fl e(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                GamesOptions gamesoptions = new GamesOptions();
                if (apioptions != null)
                {
                    eg.b(apioptions instanceof GamesOptions, "Must provide valid GamesOptions!");
                    apioptions = (GamesOptions)apioptions;
                } else
                {
                    apioptions = gamesoptions;
                }
                return new fl(context, dt1.bJ(), dt1.bF(), connectioncallbacks, onconnectionfailedlistener, dt1.bI(), dt1.bG(), dt1.bK(), ((GamesOptions) (apioptions)).ta, ((GamesOptions) (apioptions)).tb, ((GamesOptions) (apioptions)).tc, ((GamesOptions) (apioptions)).td);
            }

            public int getPriority()
            {
                return 1;
            }

        };
        SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
        API = new Api(jO, new Scope[] {
            SCOPE_GAMES
        });
        sW = new Scope("https://www.googleapis.com/auth/games.firstparty");
        sX = new Api(jO, new Scope[] {
            sW
        });
    }
}
