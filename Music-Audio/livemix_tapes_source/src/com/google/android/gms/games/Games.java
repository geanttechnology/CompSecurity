// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.games:
//            GamesMetadata, Notifications, Players

public final class Games
{
    public static abstract class BaseGamesApiMethodImpl extends com.google.android.gms.common.api.zzc.zza
    {

        public BaseGamesApiMethodImpl(GoogleApiClient googleapiclient)
        {
            super(Games.zzQf, googleapiclient);
        }
    }

    private static abstract class GamesClientBuilder extends com.google.android.gms.common.api.Api.zza
    {

        public int getPriority()
        {
            return 1;
        }

        public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zza(context, looper, zzf, (GamesOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf zzf, GamesOptions gamesoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            if (gamesoptions == null)
            {
                gamesoptions = new GamesOptions();
            }
            return new GamesClientImpl(context, looper, zzf, gamesoptions, connectioncallbacks, onconnectionfailedlistener);
        }

        private GamesClientBuilder()
        {
        }

    }

    public static final class GamesOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.Optional
    {

        public final String zzarA;
        public final ArrayList zzarB;
        public final boolean zzarv;
        public final boolean zzarw;
        public final int zzarx;
        public final boolean zzary;
        public final int zzarz;

        public static Builder builder()
        {
            return new Builder();
        }

        public Bundle zzsQ()
        {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", zzarv);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", zzarw);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", zzarx);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", zzary);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", zzarz);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", zzarA);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", zzarB);
            return bundle;
        }

        private GamesOptions()
        {
            zzarv = false;
            zzarw = true;
            zzarx = 17;
            zzary = false;
            zzarz = 4368;
            zzarA = null;
            zzarB = new ArrayList();
        }


        private GamesOptions(Builder builder1)
        {
            zzarv = builder1.zzarv;
            zzarw = builder1.zzarw;
            zzarx = builder1.zzarx;
            zzary = builder1.zzary;
            zzarz = builder1.zzarz;
            zzarA = builder1.zzarA;
            zzarB = builder1.zzarB;
        }

    }

    public static final class GamesOptions.Builder
    {

        String zzarA;
        ArrayList zzarB;
        boolean zzarv;
        boolean zzarw;
        int zzarx;
        boolean zzary;
        int zzarz;

        public GamesOptions build()
        {
            return new GamesOptions(this);
        }

        public GamesOptions.Builder setSdkVariant(int i)
        {
            zzarz = i;
            return this;
        }

        public GamesOptions.Builder setShowConnectingPopup(boolean flag)
        {
            zzarw = flag;
            zzarx = 17;
            return this;
        }

        public GamesOptions.Builder setShowConnectingPopup(boolean flag, int i)
        {
            zzarw = flag;
            zzarx = i;
            return this;
        }

        private GamesOptions.Builder()
        {
            zzarv = false;
            zzarw = true;
            zzarx = 17;
            zzary = false;
            zzarz = 4368;
            zzarA = null;
            zzarB = new ArrayList();
        }

    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        private SignOutImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public static final Api API;
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final com.google.android.gms.common.api.Api.zzc zzQf;
    private static final com.google.android.gms.common.api.Api.zza zzQg;
    private static final com.google.android.gms.common.api.Api.zza zzaro;
    public static final Scope zzarp = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api zzarq;
    public static final AppContents zzarr = new AppContentsImpl();
    public static final Multiplayer zzars = new MultiplayerImpl();
    public static final Stats zzart = new StatsImpl();
    public static final Acls zzaru = new AclsImpl();

    private Games()
    {
    }

    public static String getAppId(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient).zztW();
    }

    public static String getCurrentAccountName(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient).zztH();
    }

    public static int getSdkVariant(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient).zztV();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient).zztU();
    }

    public static void setGravityForPopups(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient = zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzfM(i);
        }
    }

    public static void setViewForPopups(GoogleApiClient googleapiclient, View view)
    {
        zzx.zzv(view);
        googleapiclient = zzb(googleapiclient, false);
        if (googleapiclient != null)
        {
            googleapiclient.zzm(view);
        }
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new SignOutImpl(googleapiclient) {

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((GamesClientImpl)zzb1);
            }

            protected void zza(GamesClientImpl gamesclientimpl)
                throws RemoteException
            {
                gamesclientimpl.zzb(this);
            }

        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleapiclient, boolean flag)
    {
        boolean flag1;
        if (googleapiclient != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zzb(flag1, "GoogleApiClient parameter is required.");
        zzx.zza(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        return zzc(googleapiclient, flag);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleapiclient, boolean flag)
    {
        zzx.zza(googleapiclient.zza(API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean flag1 = googleapiclient.hasConnectedApi(API);
        if (flag && !flag1)
        {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
        if (flag1)
        {
            return (GamesClientImpl)googleapiclient.zza(zzQf);
        } else
        {
            return null;
        }
    }

    public static GamesClientImpl zzd(GoogleApiClient googleapiclient)
    {
        return zzb(googleapiclient, true);
    }

    static 
    {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new GamesClientBuilder() {

            public List zza(GamesOptions gamesoptions)
            {
                return Collections.singletonList(Games.SCOPE_GAMES);
            }

            public List zzl(Object obj)
            {
                return zza((GamesOptions)obj);
            }

        };
        zzaro = new GamesClientBuilder() {

            public List zza(GamesOptions gamesoptions)
            {
                return Collections.singletonList(Games.zzarp);
            }

            public List zzl(Object obj)
            {
                return zza((GamesOptions)obj);
            }

        };
        API = new Api("Games.API", zzQg, zzQf);
        zzarq = new Api("Games.API_1P", zzaro, zzQf);
    }
}
