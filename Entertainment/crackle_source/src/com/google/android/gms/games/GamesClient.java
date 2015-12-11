// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnPlayerLeaderboardScoreLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.leaderboard.SubmitScoreResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchCanceledListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchInitiatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLeftListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLoadedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchesLoadedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fl;
import java.util.List;

// Referenced classes of package com.google.android.gms.games:
//            Game, Player, OnGamesLoadedListener, OnPlayersLoadedListener, 
//            OnSignOutCompleteListener

public final class GamesClient
    implements GooglePlayServicesClient
{
    public static final class Builder
    {

        private final com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks jD;
        private final com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener jE;
        private String jF[] = {
            "https://www.googleapis.com/auth/games"
        };
        private String jG;
        private final Context mContext;
        private boolean tA;
        private int tB;
        private String tx;
        private int ty;
        private View tz;

        public GamesClient create()
        {
            return new GamesClient(mContext, tx, jG, jD, jE, jF, ty, tz, tA, tB);
        }

        public Builder setAccountName(String s)
        {
            jG = (String)eg.f(s);
            return this;
        }

        public Builder setGravityForPopups(int i)
        {
            ty = i;
            return this;
        }

        public transient Builder setScopes(String as[])
        {
            jF = as;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag)
        {
            tA = flag;
            tB = 17;
            return this;
        }

        public Builder setShowConnectingPopup(boolean flag, int i)
        {
            tA = flag;
            tB = i;
            return this;
        }

        public Builder setViewForPopups(View view)
        {
            tz = (View)eg.f(view);
            return this;
        }

        public Builder(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            jG = "<<default account>>";
            ty = 49;
            tA = true;
            tB = 17;
            mContext = context;
            tx = context.getPackageName();
            jD = connectioncallbacks;
            jE = onconnectionfailedlistener;
        }
    }


    public static final String EXTRA_EXCLUSIVE_BIT_MASK = "exclusive_bit_mask";
    public static final String EXTRA_INVITATION = "invitation";
    public static final String EXTRA_MAX_AUTOMATCH_PLAYERS = "max_automatch_players";
    public static final String EXTRA_MIN_AUTOMATCH_PLAYERS = "min_automatch_players";
    public static final String EXTRA_PLAYERS = "players";
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
    public static final String EXTRA_ROOM = "room";
    public static final String EXTRA_TURN_BASED_MATCH = "turn_based_match";
    public static final int MAX_RELIABLE_MESSAGE_LEN = 1400;
    public static final int MAX_UNRELIABLE_MESSAGE_LEN = 1168;
    public static final int NOTIFICATION_TYPES_ALL = -1;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;
    public static final int STATUS_ACHIEVEMENT_NOT_INCREMENTAL = 3002;
    public static final int STATUS_ACHIEVEMENT_UNKNOWN = 3001;
    public static final int STATUS_ACHIEVEMENT_UNLOCKED = 3003;
    public static final int STATUS_ACHIEVEMENT_UNLOCK_FAILURE = 3000;
    public static final int STATUS_APP_MISCONFIGURED = 8;
    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_GAME_NOT_FOUND = 9;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_INVALID_REAL_TIME_ROOM_ID = 7002;
    public static final int STATUS_LICENSE_CHECK_FAILED = 7;
    public static final int STATUS_MATCH_ERROR_ALREADY_REMATCHED = 6505;
    public static final int STATUS_MATCH_ERROR_INACTIVE_MATCH = 6501;
    public static final int STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS = 6504;
    public static final int STATUS_MATCH_ERROR_INVALID_MATCH_STATE = 6502;
    public static final int STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE = 6500;
    public static final int STATUS_MATCH_ERROR_LOCALLY_MODIFIED = 6507;
    public static final int STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION = 6503;
    public static final int STATUS_MATCH_NOT_FOUND = 6506;
    public static final int STATUS_MULTIPLAYER_DISABLED = 6003;
    public static final int STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 6000;
    public static final int STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE = 6002;
    public static final int STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION = 6004;
    public static final int STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 6001;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPERATION_IN_FLIGHT = 7007;
    public static final int STATUS_PARTICIPANT_NOT_CONNECTED = 7003;
    public static final int STATUS_REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int STATUS_REAL_TIME_INACTIVE_ROOM = 7005;
    public static final int STATUS_REAL_TIME_MESSAGE_FAILED = -1;
    public static final int STATUS_REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int STATUS_REAL_TIME_ROOM_NOT_JOINED = 7004;
    private final fl te;

    private GamesClient(Context context, String s, String s1, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String as[], int i, 
            View view, boolean flag, int j)
    {
        te = new fl(context, s, s1, connectioncallbacks, onconnectionfailedlistener, as, i, view, false, flag, j);
    }


    public void acceptTurnBasedInvitation(OnTurnBasedMatchInitiatedListener onturnbasedmatchinitiatedlistener, String s)
    {
        te.e(new com.google.android.gms.common.api.a.c(onturnbasedmatchinitiatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchInitiatedListener tn;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult initiatematchresult)
            {
                int i = initiatematchresult.getStatus().getStatusCode();
                tn.onTurnBasedMatchInitiated(i, initiatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tn = onturnbasedmatchinitiatedlistener;
                super();
            }
        }, s);
    }

    public void cancelTurnBasedMatch(OnTurnBasedMatchCanceledListener onturnbasedmatchcanceledlistener, String s)
    {
        te.g(new com.google.android.gms.common.api.a.c(onturnbasedmatchcanceledlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchCanceledListener tq;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult cancelmatchresult)
            {
                int i = cancelmatchresult.getStatus().getStatusCode();
                tq.onTurnBasedMatchCanceled(i, cancelmatchresult.getMatchId());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tq = onturnbasedmatchcanceledlistener;
                super();
            }
        }, s);
    }

    public void cancelTurnBasedMatch(String s)
    {
        te.g(new com.google.android.gms.common.api.a.c() {

            final GamesClient tg;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult cancelmatchresult)
            {
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                super();
            }
        }, s);
    }

    public void clearAllNotifications()
    {
        te.clearNotifications(-1);
    }

    public void clearNotifications(int i)
    {
        te.clearNotifications(i);
    }

    public void connect()
    {
        te.connect();
    }

    public void createRoom(RoomConfig roomconfig)
    {
        te.createRoom(roomconfig);
    }

    public void createTurnBasedMatch(OnTurnBasedMatchInitiatedListener onturnbasedmatchinitiatedlistener, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchinitiatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchInitiatedListener tn;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult initiatematchresult)
            {
                int i = initiatematchresult.getStatus().getStatusCode();
                tn.onTurnBasedMatchInitiated(i, initiatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tn = onturnbasedmatchinitiatedlistener;
                super();
            }
        }, turnbasedmatchconfig);
    }

    public void declineRoomInvitation(String s)
    {
        te.j(s, 0);
    }

    public void declineTurnBasedInvitation(String s)
    {
        te.j(s, 1);
    }

    public void disconnect()
    {
        te.disconnect();
    }

    public void dismissRoomInvitation(String s)
    {
        te.i(s, 0);
    }

    public void dismissTurnBasedInvitation(String s)
    {
        te.i(s, 1);
    }

    public void dismissTurnBasedMatch(String s)
    {
        te.dismissTurnBasedMatch(s);
    }

    public void finishTurnBasedMatch(OnTurnBasedMatchUpdatedListener onturnbasedmatchupdatedlistener, String s)
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchupdatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchUpdatedListener to;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult updatematchresult)
            {
                int i = updatematchresult.getStatus().getStatusCode();
                to.onTurnBasedMatchUpdated(i, updatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                to = onturnbasedmatchupdatedlistener;
                super();
            }
        }, s, null, null);
    }

    public void finishTurnBasedMatch(OnTurnBasedMatchUpdatedListener onturnbasedmatchupdatedlistener, String s, byte abyte0[], List list)
    {
        if (list == null)
        {
            list = null;
        } else
        {
            list = (ParticipantResult[])list.toArray(new ParticipantResult[list.size()]);
        }
        finishTurnBasedMatch(onturnbasedmatchupdatedlistener, s, abyte0, ((ParticipantResult []) (list)));
    }

    public transient void finishTurnBasedMatch(OnTurnBasedMatchUpdatedListener onturnbasedmatchupdatedlistener, String s, byte abyte0[], ParticipantResult aparticipantresult[])
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchupdatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchUpdatedListener to;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult updatematchresult)
            {
                int i = updatematchresult.getStatus().getStatusCode();
                to.onTurnBasedMatchUpdated(i, updatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                to = onturnbasedmatchupdatedlistener;
                super();
            }
        }, s, abyte0, aparticipantresult);
    }

    public Intent getAchievementsIntent()
    {
        return te.getAchievementsIntent();
    }

    public Intent getAllLeaderboardsIntent()
    {
        return te.getAllLeaderboardsIntent();
    }

    public String getAppId()
    {
        return te.getAppId();
    }

    public String getCurrentAccountName()
    {
        return te.getCurrentAccountName();
    }

    public Game getCurrentGame()
    {
        return te.getCurrentGame();
    }

    public Player getCurrentPlayer()
    {
        return te.getCurrentPlayer();
    }

    public String getCurrentPlayerId()
    {
        return te.getCurrentPlayerId();
    }

    public Intent getInvitationInboxIntent()
    {
        return te.getInvitationInboxIntent();
    }

    public Intent getLeaderboardIntent(String s)
    {
        return te.getLeaderboardIntent(s);
    }

    public Intent getMatchInboxIntent()
    {
        return te.getMatchInboxIntent();
    }

    public int getMaxTurnBasedMatchDataSize()
    {
        return te.getMaxTurnBasedMatchDataSize();
    }

    public Intent getPlayerSearchIntent()
    {
        return te.getPlayerSearchIntent();
    }

    public Intent getRealTimeSelectOpponentsIntent(int i, int j)
    {
        return te.getRealTimeSelectOpponentsIntent(i, j, true);
    }

    public Intent getRealTimeSelectOpponentsIntent(int i, int j, boolean flag)
    {
        return te.getRealTimeSelectOpponentsIntent(i, j, flag);
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String s, String s1)
    {
        return te.getRealTimeSocketForParticipant(s, s1);
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int i)
    {
        return te.getRealTimeWaitingRoomIntent(room, i);
    }

    public Intent getSettingsIntent()
    {
        return te.getSettingsIntent();
    }

    public void getTurnBasedMatch(OnTurnBasedMatchLoadedListener onturnbasedmatchloadedlistener, String s)
    {
        te.h(new com.google.android.gms.common.api.a.c(onturnbasedmatchloadedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchLoadedListener tu;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult loadmatchresult)
            {
                int i = loadmatchresult.getStatus().getStatusCode();
                tu.onTurnBasedMatchLoaded(i, loadmatchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tu = onturnbasedmatchloadedlistener;
                super();
            }
        }, s);
    }

    public Intent getTurnBasedSelectOpponentsIntent(int i, int j)
    {
        return te.getTurnBasedSelectOpponentsIntent(i, j, true);
    }

    public Intent getTurnBasedSelectOpponentsIntent(int i, int j, boolean flag)
    {
        return te.getTurnBasedSelectOpponentsIntent(i, j, flag);
    }

    public void incrementAchievement(String s, int i)
    {
        te.a(null, s, i);
    }

    public void incrementAchievementImmediate(OnAchievementUpdatedListener onachievementupdatedlistener, String s, int i)
    {
        te.a(new com.google.android.gms.common.api.a.c(onachievementupdatedlistener) {

            final GamesClient tg;
            final OnAchievementUpdatedListener tk;

            public void a(com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult updateachievementresult)
            {
                int j = updateachievementresult.getStatus().getStatusCode();
                tk.onAchievementUpdated(j, updateachievementresult.getAchievementId());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tk = onachievementupdatedlistener;
                super();
            }
        }, s, i);
    }

    public boolean isConnected()
    {
        return te.isConnected();
    }

    public boolean isConnecting()
    {
        return te.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return te.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return te.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void joinRoom(RoomConfig roomconfig)
    {
        te.joinRoom(roomconfig);
    }

    public void leaveRoom(RoomUpdateListener roomupdatelistener, String s)
    {
        te.leaveRoom(roomupdatelistener, s);
    }

    public void leaveTurnBasedMatch(OnTurnBasedMatchLeftListener onturnbasedmatchleftlistener, String s)
    {
        te.f(new com.google.android.gms.common.api.a.c(onturnbasedmatchleftlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchLeftListener tp;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult leavematchresult)
            {
                int i = leavematchresult.getStatus().getStatusCode();
                tp.onTurnBasedMatchLeft(i, leavematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tp = onturnbasedmatchleftlistener;
                super();
            }
        }, s);
    }

    public void leaveTurnBasedMatchDuringTurn(OnTurnBasedMatchLeftListener onturnbasedmatchleftlistener, String s, String s1)
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchleftlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchLeftListener tp;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult leavematchresult)
            {
                int i = leavematchresult.getStatus().getStatusCode();
                tp.onTurnBasedMatchLeft(i, leavematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tp = onturnbasedmatchleftlistener;
                super();
            }
        }, s, s1);
    }

    public void loadAchievements(OnAchievementsLoadedListener onachievementsloadedlistener, boolean flag)
    {
        te.b(new com.google.android.gms.common.api.a.c(onachievementsloadedlistener) {

            final GamesClient tg;
            final OnAchievementsLoadedListener tj;

            public void a(com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult loadachievementsresult)
            {
                int i = loadachievementsresult.getStatus().getStatusCode();
                tj.onAchievementsLoaded(i, loadachievementsresult.getAchievements());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tj = onachievementsloadedlistener;
                super();
            }
        }, flag);
    }

    public void loadCurrentPlayerLeaderboardScore(OnPlayerLeaderboardScoreLoadedListener onplayerleaderboardscoreloadedlistener, String s, int i, int j)
    {
        te.a(new com.google.android.gms.common.api.a.c(onplayerleaderboardscoreloadedlistener) {

            final GamesClient tg;
            final OnPlayerLeaderboardScoreLoadedListener tw;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult loadplayerscoreresult)
            {
                int k = loadplayerscoreresult.getStatus().getStatusCode();
                tw.onPlayerLeaderboardScoreLoaded(k, loadplayerscoreresult.getScore());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tw = onplayerleaderboardscoreloadedlistener;
                super();
            }
        }, null, s, i, j);
    }

    public void loadGame(OnGamesLoadedListener ongamesloadedlistener)
    {
        te.g(new com.google.android.gms.common.api.a.c(ongamesloadedlistener) {

            final GamesClient tg;
            final OnGamesLoadedListener tl;

            public void a(GamesMetadata.LoadGamesResult loadgamesresult)
            {
                tl.onGamesLoaded(loadgamesresult.getStatus().getStatusCode(), loadgamesresult.getGames());
            }

            public volatile void a(Object obj)
            {
                a((GamesMetadata.LoadGamesResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tl = ongamesloadedlistener;
                super();
            }
        });
    }

    public void loadInvitablePlayers(OnPlayersLoadedListener onplayersloadedlistener, int i, boolean flag)
    {
        te.a(new com.google.android.gms.common.api.a.c(onplayersloadedlistener) {

            final OnPlayersLoadedListener tf;
            final GamesClient tg;

            public void a(Players.LoadPlayersResult loadplayersresult)
            {
                tf.onPlayersLoaded(loadplayersresult.getStatus().getStatusCode(), loadplayersresult.getPlayers());
            }

            public volatile void a(Object obj)
            {
                a((Players.LoadPlayersResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tf = onplayersloadedlistener;
                super();
            }
        }, i, false, flag);
    }

    public void loadInvitations(OnInvitationsLoadedListener oninvitationsloadedlistener)
    {
        te.h(new com.google.android.gms.common.api.a.c(oninvitationsloadedlistener) {

            final GamesClient tg;
            final OnInvitationsLoadedListener ts;

            public void a(com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult loadinvitationsresult)
            {
                int i = loadinvitationsresult.getStatus().getStatusCode();
                ts.onInvitationsLoaded(i, loadinvitationsresult.getInvitations());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult)obj);
            }

            
            {
                tg = GamesClient.this;
                ts = oninvitationsloadedlistener;
                super();
            }
        });
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener onleaderboardmetadataloadedlistener, String s, boolean flag)
    {
        te.a(new com.google.android.gms.common.api.a.c(onleaderboardmetadataloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardMetadataLoadedListener tv;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult leaderboardmetadataresult)
            {
                int i = leaderboardmetadataresult.getStatus().getStatusCode();
                tv.onLeaderboardMetadataLoaded(i, leaderboardmetadataresult.getLeaderboards());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tv = onleaderboardmetadataloadedlistener;
                super();
            }
        }, s, flag);
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener onleaderboardmetadataloadedlistener, boolean flag)
    {
        te.a(new com.google.android.gms.common.api.a.c(onleaderboardmetadataloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardMetadataLoadedListener tv;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult leaderboardmetadataresult)
            {
                int i = leaderboardmetadataresult.getStatus().getStatusCode();
                tv.onLeaderboardMetadataLoaded(i, leaderboardmetadataresult.getLeaderboards());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tv = onleaderboardmetadataloadedlistener;
                super();
            }
        }, flag);
    }

    public void loadMoreInvitablePlayers(OnPlayersLoadedListener onplayersloadedlistener, int i)
    {
        te.a(new com.google.android.gms.common.api.a.c(onplayersloadedlistener) {

            final OnPlayersLoadedListener tf;
            final GamesClient tg;

            public void a(Players.LoadPlayersResult loadplayersresult)
            {
                tf.onPlayersLoaded(loadplayersresult.getStatus().getStatusCode(), loadplayersresult.getPlayers());
            }

            public volatile void a(Object obj)
            {
                a((Players.LoadPlayersResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tf = onplayersloadedlistener;
                super();
            }
        }, i, true, false);
    }

    public void loadMoreScores(OnLeaderboardScoresLoadedListener onleaderboardscoresloadedlistener, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
    {
        te.a(new com.google.android.gms.common.api.a.c(onleaderboardscoresloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardScoresLoadedListener th;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult loadscoresresult)
            {
                int k = loadscoresresult.getStatus().getStatusCode();
                th.onLeaderboardScoresLoaded(k, loadscoresresult.getLeaderboard(), loadscoresresult.getScores());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult)obj);
            }

            
            {
                tg = GamesClient.this;
                th = onleaderboardscoresloadedlistener;
                super();
            }
        }, leaderboardscorebuffer, i, j);
    }

    public void loadPlayer(OnPlayersLoadedListener onplayersloadedlistener, String s)
    {
        te.a(new com.google.android.gms.common.api.a.c(onplayersloadedlistener) {

            final OnPlayersLoadedListener tf;
            final GamesClient tg;

            public void a(Players.LoadPlayersResult loadplayersresult)
            {
                tf.onPlayersLoaded(loadplayersresult.getStatus().getStatusCode(), loadplayersresult.getPlayers());
            }

            public volatile void a(Object obj)
            {
                a((Players.LoadPlayersResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tf = onplayersloadedlistener;
                super();
            }
        }, s);
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener onleaderboardscoresloadedlistener, String s, int i, int j, int k)
    {
        te.b(new com.google.android.gms.common.api.a.c(onleaderboardscoresloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardScoresLoadedListener th;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult loadscoresresult)
            {
                int l = loadscoresresult.getStatus().getStatusCode();
                th.onLeaderboardScoresLoaded(l, loadscoresresult.getLeaderboard(), loadscoresresult.getScores());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult)obj);
            }

            
            {
                tg = GamesClient.this;
                th = onleaderboardscoresloadedlistener;
                super();
            }
        }, s, i, j, k, false);
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener onleaderboardscoresloadedlistener, String s, int i, int j, int k, boolean flag)
    {
        te.b(new com.google.android.gms.common.api.a.c(onleaderboardscoresloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardScoresLoadedListener th;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult loadscoresresult)
            {
                int l = loadscoresresult.getStatus().getStatusCode();
                th.onLeaderboardScoresLoaded(l, loadscoresresult.getLeaderboard(), loadscoresresult.getScores());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult)obj);
            }

            
            {
                tg = GamesClient.this;
                th = onleaderboardscoresloadedlistener;
                super();
            }
        }, s, i, j, k, flag);
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener onleaderboardscoresloadedlistener, String s, int i, int j, int k)
    {
        te.a(new com.google.android.gms.common.api.a.c(onleaderboardscoresloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardScoresLoadedListener th;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult loadscoresresult)
            {
                int l = loadscoresresult.getStatus().getStatusCode();
                th.onLeaderboardScoresLoaded(l, loadscoresresult.getLeaderboard(), loadscoresresult.getScores());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult)obj);
            }

            
            {
                tg = GamesClient.this;
                th = onleaderboardscoresloadedlistener;
                super();
            }
        }, s, i, j, k, false);
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener onleaderboardscoresloadedlistener, String s, int i, int j, int k, boolean flag)
    {
        te.a(new com.google.android.gms.common.api.a.c(onleaderboardscoresloadedlistener) {

            final GamesClient tg;
            final OnLeaderboardScoresLoadedListener th;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult loadscoresresult)
            {
                int l = loadscoresresult.getStatus().getStatusCode();
                th.onLeaderboardScoresLoaded(l, loadscoresresult.getLeaderboard(), loadscoresresult.getScores());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult)obj);
            }

            
            {
                tg = GamesClient.this;
                th = onleaderboardscoresloadedlistener;
                super();
            }
        }, s, i, j, k, flag);
    }

    public transient void loadTurnBasedMatches(OnTurnBasedMatchesLoadedListener onturnbasedmatchesloadedlistener, int ai[])
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchesloadedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchesLoadedListener tt;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult loadmatchesresult)
            {
                int i = loadmatchesresult.getStatus().getStatusCode();
                tt.onTurnBasedMatchesLoaded(i, loadmatchesresult.getMatches());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tt = onturnbasedmatchesloadedlistener;
                super();
            }
        }, ai);
    }

    public void reconnect()
    {
        te.disconnect();
        te.connect();
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        te.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        te.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void registerInvitationListener(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        te.registerInvitationListener(oninvitationreceivedlistener);
    }

    public void registerMatchUpdateListener(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        te.registerMatchUpdateListener(onturnbasedmatchupdatereceivedlistener);
    }

    public void rematchTurnBasedMatch(OnTurnBasedMatchInitiatedListener onturnbasedmatchinitiatedlistener, String s)
    {
        te.d(new com.google.android.gms.common.api.a.c(onturnbasedmatchinitiatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchInitiatedListener tn;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult initiatematchresult)
            {
                int i = initiatematchresult.getStatus().getStatusCode();
                tn.onTurnBasedMatchInitiated(i, initiatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tn = onturnbasedmatchinitiatedlistener;
                super();
            }
        }, s);
    }

    public void revealAchievement(String s)
    {
        te.b(null, s);
    }

    public void revealAchievementImmediate(OnAchievementUpdatedListener onachievementupdatedlistener, String s)
    {
        te.b(new com.google.android.gms.common.api.a.c(onachievementupdatedlistener) {

            final GamesClient tg;
            final OnAchievementUpdatedListener tk;

            public void a(com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult updateachievementresult)
            {
                int i = updateachievementresult.getStatus().getStatusCode();
                tk.onAchievementUpdated(i, updateachievementresult.getAchievementId());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tk = onachievementupdatedlistener;
                super();
            }
        }, s);
    }

    public int sendReliableRealTimeMessage(RealTimeReliableMessageSentListener realtimereliablemessagesentlistener, byte abyte0[], String s, String s1)
    {
        return te.a(new com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback(realtimereliablemessagesentlistener) {

            final GamesClient tg;
            final RealTimeReliableMessageSentListener tr;

            public void onRealTimeMessageSent(int i, int j, String s2)
            {
                tr.onRealTimeMessageSent(i, j, s2);
            }

            
            {
                tg = GamesClient.this;
                tr = realtimereliablemessagesentlistener;
                super();
            }
        }, abyte0, s, s1);
    }

    public int sendUnreliableRealTimeMessage(byte abyte0[], String s, String s1)
    {
        return te.a(abyte0, s, new String[] {
            s1
        });
    }

    public int sendUnreliableRealTimeMessage(byte abyte0[], String s, List list)
    {
        list = (String[])list.toArray(new String[list.size()]);
        return te.a(abyte0, s, list);
    }

    public int sendUnreliableRealTimeMessageToAll(byte abyte0[], String s)
    {
        return te.sendUnreliableRealTimeMessageToAll(abyte0, s);
    }

    public void setAchievementSteps(String s, int i)
    {
        te.b(null, s, i);
    }

    public void setAchievementStepsImmediate(OnAchievementUpdatedListener onachievementupdatedlistener, String s, int i)
    {
        te.b(new com.google.android.gms.common.api.a.c(onachievementupdatedlistener) {

            final GamesClient tg;
            final OnAchievementUpdatedListener tk;

            public void a(com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult updateachievementresult)
            {
                int j = updateachievementresult.getStatus().getStatusCode();
                tk.onAchievementUpdated(j, updateachievementresult.getAchievementId());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tk = onachievementupdatedlistener;
                super();
            }
        }, s, i);
    }

    public void setGravityForPopups(int i)
    {
        te.setGravityForPopups(i);
    }

    public void setViewForPopups(View view)
    {
        eg.f(view);
        te.setViewForPopups(view);
    }

    public void signOut()
    {
        te.b(new com.google.android.gms.common.api.a.c() {

            final GamesClient tg;

            public void a(Status status)
            {
            }

            public volatile void a(Object obj)
            {
                a((Status)obj);
            }

            
            {
                tg = GamesClient.this;
                super();
            }
        });
    }

    public void signOut(OnSignOutCompleteListener onsignoutcompletelistener)
    {
        te.b(new com.google.android.gms.common.api.a.c(onsignoutcompletelistener) {

            final GamesClient tg;
            final OnSignOutCompleteListener tm;

            public void a(Status status)
            {
                tm.onSignOutComplete();
            }

            public volatile void a(Object obj)
            {
                a((Status)obj);
            }

            
            {
                tg = GamesClient.this;
                tm = onsignoutcompletelistener;
                super();
            }
        });
    }

    public void submitScore(String s, long l)
    {
        te.a(null, s, l, null);
    }

    public void submitScore(String s, long l, String s1)
    {
        te.a(null, s, l, s1);
    }

    public void submitScoreImmediate(OnScoreSubmittedListener onscoresubmittedlistener, String s, long l)
    {
        te.a(new com.google.android.gms.common.api.a.c(onscoresubmittedlistener) {

            final GamesClient tg;
            final OnScoreSubmittedListener ti;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult submitscoreresult)
            {
                int i = submitscoreresult.getStatus().getStatusCode();
                submitscoreresult = new SubmitScoreResult(submitscoreresult.getScoreData().dx());
                ti.onScoreSubmitted(i, submitscoreresult);
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult)obj);
            }

            
            {
                tg = GamesClient.this;
                ti = onscoresubmittedlistener;
                super();
            }
        }, s, l, null);
    }

    public void submitScoreImmediate(OnScoreSubmittedListener onscoresubmittedlistener, String s, long l, String s1)
    {
        te.a(new com.google.android.gms.common.api.a.c(onscoresubmittedlistener) {

            final GamesClient tg;
            final OnScoreSubmittedListener ti;

            public void a(com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult submitscoreresult)
            {
                int i = submitscoreresult.getStatus().getStatusCode();
                submitscoreresult = new SubmitScoreResult(submitscoreresult.getScoreData().dx());
                ti.onScoreSubmitted(i, submitscoreresult);
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult)obj);
            }

            
            {
                tg = GamesClient.this;
                ti = onscoresubmittedlistener;
                super();
            }
        }, s, l, s1);
    }

    public void takeTurn(OnTurnBasedMatchUpdatedListener onturnbasedmatchupdatedlistener, String s, byte abyte0[], String s1)
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchupdatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchUpdatedListener to;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult updatematchresult)
            {
                int i = updatematchresult.getStatus().getStatusCode();
                to.onTurnBasedMatchUpdated(i, updatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                to = onturnbasedmatchupdatedlistener;
                super();
            }
        }, s, abyte0, s1, null);
    }

    public void takeTurn(OnTurnBasedMatchUpdatedListener onturnbasedmatchupdatedlistener, String s, byte abyte0[], String s1, List list)
    {
        if (list == null)
        {
            list = null;
        } else
        {
            list = (ParticipantResult[])list.toArray(new ParticipantResult[list.size()]);
        }
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchupdatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchUpdatedListener to;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult updatematchresult)
            {
                int i = updatematchresult.getStatus().getStatusCode();
                to.onTurnBasedMatchUpdated(i, updatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                to = onturnbasedmatchupdatedlistener;
                super();
            }
        }, s, abyte0, s1, list);
    }

    public transient void takeTurn(OnTurnBasedMatchUpdatedListener onturnbasedmatchupdatedlistener, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
    {
        te.a(new com.google.android.gms.common.api.a.c(onturnbasedmatchupdatedlistener) {

            final GamesClient tg;
            final OnTurnBasedMatchUpdatedListener to;

            public void a(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult updatematchresult)
            {
                int i = updatematchresult.getStatus().getStatusCode();
                to.onTurnBasedMatchUpdated(i, updatematchresult.getMatch());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult)obj);
            }

            
            {
                tg = GamesClient.this;
                to = onturnbasedmatchupdatedlistener;
                super();
            }
        }, s, abyte0, s1, aparticipantresult);
    }

    public void unlockAchievement(String s)
    {
        te.c(null, s);
    }

    public void unlockAchievementImmediate(OnAchievementUpdatedListener onachievementupdatedlistener, String s)
    {
        te.c(new com.google.android.gms.common.api.a.c(onachievementupdatedlistener) {

            final GamesClient tg;
            final OnAchievementUpdatedListener tk;

            public void a(com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult updateachievementresult)
            {
                int i = updateachievementresult.getStatus().getStatusCode();
                tk.onAchievementUpdated(i, updateachievementresult.getAchievementId());
            }

            public volatile void a(Object obj)
            {
                a((com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult)obj);
            }

            
            {
                tg = GamesClient.this;
                tk = onachievementupdatedlistener;
                super();
            }
        }, s);
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        te.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        te.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    public void unregisterInvitationListener()
    {
        te.unregisterInvitationListener();
    }

    public void unregisterMatchUpdateListener()
    {
        te.unregisterMatchUpdateListener();
    }
}
