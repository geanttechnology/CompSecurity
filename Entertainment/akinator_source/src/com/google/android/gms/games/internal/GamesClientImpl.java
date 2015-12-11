// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.signin.internal.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.games.internal:
//            PopupManager, GamesLog, IGamesService, AbstractGamesCallbacks, 
//            AbstractGamesClient, PopupLocationInfoParcelable

public final class GamesClientImpl extends zzj
{
    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier
    {

        private final ArrayList zzavr = new ArrayList();

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            zza(roomstatusupdatelistener, room, zzavr);
        }

        protected abstract void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist);

        AbstractPeerStatusNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder);
            int i = 0;
            for (int j = as.length; i < j; i++)
            {
                zzavr.add(as[i]);
            }

        }
    }

    private static abstract class AbstractRoomNotifier extends zzld
    {

        protected void zza(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            zza(roomupdatelistener, GamesClientImpl.zzY(dataholder), dataholder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomupdatelistener, Room room, int i);

        protected volatile void zza(Object obj, DataHolder dataholder)
        {
            zza((RoomUpdateListener)obj, dataholder);
        }

        AbstractRoomNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static abstract class AbstractRoomStatusNotifier extends zzld
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            zza(roomstatusupdatelistener, GamesClientImpl.zzY(dataholder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room);

        protected volatile void zza(Object obj, DataHolder dataholder)
        {
            zza((RoomStatusUpdateListener)obj, dataholder);
        }

        AbstractRoomStatusNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.quest.Quests.AcceptQuestResult
    {

        private final Quest zzavs = null;

        public Quest getQuest()
        {
            return zzavs;
        }

        AcceptQuestResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new QuestBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavs = new QuestEntity((Quest)dataholder.get(0));
_L4:
            dataholder.release();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.release();
            throw exception;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzh(int i, String s)
        {
            zzagy.zzp(new UpdateAchievementResultImpl(i, s));
        }

        AchievementUpdatedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzh(DataHolder dataholder)
        {
            zzagy.zzp(new LoadAchievementsResultImpl(dataholder));
        }

        AchievementsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzavt;

        public void zza(DataHolder adataholder[])
        {
            zzavt.zzp(new LoadAppContentsResultImpl(adataholder));
        }

        public AppContentLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzavt = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class CancelMatchResultImpl
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    {

        private final Status zzSC;
        private final String zzavu;

        public String getMatchId()
        {
            return zzavu;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        CancelMatchResultImpl(Status status, String s)
        {
            zzSC = status;
            zzavu = s;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
    {

        private final Quest zzavs;
        private final Milestone zzavv = null;

        public Milestone getMilestone()
        {
            return zzavv;
        }

        public Quest getQuest()
        {
            return zzavs;
        }

        ClaimMilestoneResultImpl(DataHolder dataholder, String s)
        {
            int i;
            i = 0;
            super(dataholder);
            dataholder = new QuestBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            List list;
            int j;
            zzavs = new QuestEntity((Quest)dataholder.get(0));
            list = zzavs.zzvP();
            j = list.size();
_L4:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            if (!((Milestone)list.get(i)).getMilestoneId().equals(s))
            {
                break MISSING_BLOCK_LABEL_111;
            }
            zzavv = (Milestone)list.get(i);
            dataholder.release();
            return;
            i++;
            if (true) goto _L4; else goto _L3
_L3:
_L6:
            dataholder.release();
            return;
_L2:
            zzavv = null;
            zzavs = null;
            if (true) goto _L6; else goto _L5
_L5:
            s;
            dataholder.release();
            throw s;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
    {

        private final SnapshotMetadata zzavw = null;

        public SnapshotMetadata getSnapshotMetadata()
        {
            return zzavw;
        }

        CommitSnapshotResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new SnapshotMetadataBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavw = new SnapshotMetadataEntity(dataholder.get(0));
_L4:
            dataholder.release();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.release();
            throw exception;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier
    {

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onConnectedToRoom(room);
        }

        ConnectedToRoomNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.Notifications.ContactSettingLoadResult
    {

        ContactSettingLoadResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzI(DataHolder dataholder)
        {
            zzagy.zzp(new ContactSettingLoadResultImpl(dataholder));
        }

        ContactSettingsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzfS(int i)
        {
            zzagy.zzp(GamesStatusCodes.zzfG(i));
        }

        ContactSettingsUpdatedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class DeleteSnapshotResultImpl
        implements com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
    {

        private final Status zzSC;
        private final String zzavx;

        public String getSnapshotId()
        {
            return zzavx;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        DeleteSnapshotResultImpl(int i, String s)
        {
            zzSC = GamesStatusCodes.zzfG(i);
            zzavx = s;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier
    {

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onDisconnectedFromRoom(room);
        }

        DisconnectedFromRoomNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzi(DataHolder dataholder)
        {
            zzagy.zzp(new LoadEventResultImpl(dataholder));
        }

        EventsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache
    {

        final GamesClientImpl zzavq;

        protected void zzs(String s, int i)
        {
            if (zzavq.isConnected())
            {
                ((IGamesService)zzavq.zzpc()).zzp(s, i);
                return;
            }
            try
            {
                GamesLog.zzz("GamesClientImpl", (new StringBuilder()).append("Unable to increment event ").append(s).append(" by ").append(i).append(" because the games client is no longer connected").toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                GamesClientImpl.zza(zzavq, s);
            }
            return;
        }

        public GameClientEventIncrementCache()
        {
            zzavq = GamesClientImpl.this;
            super(getContext().getMainLooper(), 1000);
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzp(DataHolder dataholder)
        {
            zzagy.zzp(new LoadGameInstancesResultImpl(dataholder));
        }

        GameInstancesLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class GameMuteStatusChangeResultImpl
        implements com.google.android.gms.games.Notifications.GameMuteStatusChangeResult
    {

        private final Status zzSC;
        private final String zzavy;
        private final boolean zzavz;

        public Status getStatus()
        {
            return zzSC;
        }

        public GameMuteStatusChangeResultImpl(int i, String s, boolean flag)
        {
            zzSC = GamesStatusCodes.zzfG(i);
            zzavy = s;
            zzavz = flag;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(int i, String s, boolean flag)
        {
            zzagy.zzp(new GameMuteStatusChangeResultImpl(i, s, flag));
        }

        GameMuteStatusChangedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class GameMuteStatusLoadResultImpl
        implements com.google.android.gms.games.Notifications.GameMuteStatusLoadResult
    {

        private final Status zzSC;
        private final String zzavy;
        private final boolean zzavz;

        public Status getStatus()
        {
            return zzSC;
        }

        public GameMuteStatusLoadResultImpl(DataHolder dataholder)
        {
            zzSC = GamesStatusCodes.zzfG(dataholder.getStatusCode());
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavy = dataholder.zzd("external_game_id", 0, 0);
            zzavz = dataholder.zze("muted", 0, 0);
_L4:
            dataholder.close();
            return;
_L2:
            zzavy = null;
            zzavz = false;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.close();
            throw exception;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzG(DataHolder dataholder)
        {
            zzagy.zzp(new GameMuteStatusLoadResultImpl(dataholder));
        }

        GameMuteStatusLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzq(DataHolder dataholder)
        {
            zzagy.zzp(new LoadGameSearchSuggestionsResultImpl(dataholder));
        }

        GameSearchSuggestionsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static abstract class GamesDataHolderResult extends zzle
    {

        protected GamesDataHolderResult(DataHolder dataholder)
        {
            super(dataholder, GamesStatusCodes.zzfG(dataholder.getStatusCode()));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzn(DataHolder dataholder)
        {
            zzagy.zzp(new LoadGamesResultImpl(dataholder));
        }

        GamesLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class InboxCountResultImpl
        implements com.google.android.gms.games.Notifications.InboxCountResult
    {

        private final Status zzSC;
        private final Bundle zzavA;

        public Status getStatus()
        {
            return zzSC;
        }

        InboxCountResultImpl(Status status, Bundle bundle)
        {
            zzSC = status;
            zzavA = bundle;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzg(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfG(i);
            zzagy.zzp(new InboxCountResultImpl(status, bundle));
        }

        InboxCountsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult
    {

        InitiateMatchResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks
    {

        private final zzlm zzakZ;

        public void onInvitationRemoved(String s)
        {
            zzakZ.zza(new InvitationRemovedNotifier(s));
        }

        public void zzs(DataHolder dataholder)
        {
            InvitationBuffer invitationbuffer;
            invitationbuffer = new InvitationBuffer(dataholder);
            dataholder = null;
            if (invitationbuffer.getCount() > 0)
            {
                dataholder = (Invitation)((Invitation)invitationbuffer.get(0)).freeze();
            }
            invitationbuffer.release();
            if (dataholder != null)
            {
                zzakZ.zza(new InvitationReceivedNotifier(dataholder));
            }
            return;
            dataholder;
            invitationbuffer.release();
            throw dataholder;
        }

        InvitationReceivedBinderCallback(zzlm zzlm1)
        {
            zzakZ = zzlm1;
        }
    }

    private static final class InvitationReceivedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final Invitation zzavB;

        public void zza(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationReceived(zzavB);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnInvitationReceivedListener)obj);
        }

        InvitationReceivedNotifier(Invitation invitation)
        {
            zzavB = invitation;
        }
    }

    private static final class InvitationRemovedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final String zzavC;

        public void zza(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationRemoved(zzavC);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnInvitationReceivedListener)obj);
        }

        InvitationRemovedNotifier(String s)
        {
            zzavC = s;
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzr(DataHolder dataholder)
        {
            zzagy.zzp(new LoadInvitationsResultImpl(dataholder));
        }

        InvitationsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier
    {

        public void zza(RoomUpdateListener roomupdatelistener, Room room, int i)
        {
            roomupdatelistener.onJoinedRoom(i, room);
        }

        public JoinedRoomNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
    {

        private final LeaderboardBuffer zzavD;

        public LeaderboardBuffer getLeaderboards()
        {
            return zzavD;
        }

        LeaderboardMetadataResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavD = new LeaderboardBuffer(dataholder);
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zza(DataHolder dataholder, DataHolder dataholder1)
        {
            zzagy.zzp(new LoadScoresResultImpl(dataholder, dataholder1));
        }

        LeaderboardScoresLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzj(DataHolder dataholder)
        {
            zzagy.zzp(new LeaderboardMetadataResultImpl(dataholder));
        }

        LeaderboardsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult
    {

        LeaveMatchResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LeftRoomNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final int zzYm;
        private final String zzavE;

        public void zza(RoomUpdateListener roomupdatelistener)
        {
            roomupdatelistener.onLeftRoom(zzYm, zzavE);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((RoomUpdateListener)obj);
        }

        LeftRoomNotifier(int i, String s)
        {
            zzYm = i;
            zzavE = s;
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
    {

        private final AchievementBuffer zzavF;

        public AchievementBuffer getAchievements()
        {
            return zzavF;
        }

        LoadAchievementsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavF = new AchievementBuffer(dataholder);
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.internal.game.Acls.LoadAclResult
    {

        LoadAclResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult
    {

        private final ArrayList zzavG;

        LoadAppContentsResultImpl(DataHolder adataholder[])
        {
            super(adataholder[0]);
            zzavG = new ArrayList(Arrays.asList(adataholder));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.event.Events.LoadEventsResult
    {

        private final EventBuffer zzavH;

        public EventBuffer getEvents()
        {
            return zzavH;
        }

        LoadEventResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavH = new EventBuffer(dataholder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult
    {

        private final GameInstanceBuffer zzavI;

        LoadGameInstancesResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavI = new GameInstanceBuffer(dataholder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult
    {

        private final GameSearchSuggestionBuffer zzavJ;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavJ = new GameSearchSuggestionBuffer(dataholder);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.GamesMetadata.LoadGamesResult
    {

        private final GameBuffer zzavK;

        public GameBuffer getGames()
        {
            return zzavK;
        }

        LoadGamesResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavK = new GameBuffer(dataholder);
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
    {

        private final InvitationBuffer zzavL;

        public InvitationBuffer getInvitations()
        {
            return zzavL;
        }

        LoadInvitationsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavL = new InvitationBuffer(dataholder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult
    {

        LoadMatchResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LoadMatchesResultImpl
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
    {

        private final Status zzSC;
        private final LoadMatchesResponse zzavM;

        public LoadMatchesResponse getMatches()
        {
            return zzavM;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public void release()
        {
            zzavM.release();
        }

        LoadMatchesResultImpl(Status status, Bundle bundle)
        {
            zzSC = status;
            zzavM = new LoadMatchesResponse(bundle);
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
    {

        private final LeaderboardScoreEntity zzavN = null;

        public LeaderboardScore getScore()
        {
            return zzavN;
        }

        LoadPlayerScoreResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new LeaderboardScoreBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavN = (LeaderboardScoreEntity)dataholder.get(0).freeze();
_L4:
            dataholder.release();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.release();
            throw exception;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
    {

        private final PlayerStats zzavO = null;

        public PlayerStats getPlayerStats()
        {
            return zzavO;
        }

        LoadPlayerStatsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new PlayerStatsBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavO = new PlayerStatsEntity(dataholder.zzgy(0));
_L4:
            dataholder.release();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.release();
            throw exception;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.Players.LoadPlayersResult
    {

        private final PlayerBuffer zzavP;

        public PlayerBuffer getPlayers()
        {
            return zzavP;
        }

        LoadPlayersResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavP = new PlayerBuffer(dataholder);
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.Players.LoadProfileSettingsResult
    {

        private final boolean zzavQ;
        private final boolean zzave;

        public Status getStatus()
        {
            return zzSC;
        }

        LoadProfileSettingsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            int i = dataholder.zzbt(0);
            zzave = dataholder.zze("profile_visible", 0, i);
            zzavQ = dataholder.zze("profile_visibility_explicitly_set", 0, i);
_L4:
            dataholder.close();
            return;
_L2:
            zzave = true;
            zzavQ = false;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.close();
            throw exception;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.quest.Quests.LoadQuestsResult
    {

        private final DataHolder zzabq;

        public QuestBuffer getQuests()
        {
            return new QuestBuffer(zzabq);
        }

        LoadQuestsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzabq = dataholder;
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.request.Requests.LoadRequestSummariesResult
    {

        LoadRequestSummariesResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LoadRequestsResultImpl
        implements com.google.android.gms.games.request.Requests.LoadRequestsResult
    {

        private final Status zzSC;
        private final Bundle zzavR;

        public GameRequestBuffer getRequests(int i)
        {
            String s = RequestType.zzfZ(i);
            if (!zzavR.containsKey(s))
            {
                return null;
            } else
            {
                return new GameRequestBuffer((DataHolder)zzavR.get(s));
            }
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public void release()
        {
            Iterator iterator = zzavR.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (String)iterator.next();
                obj = (DataHolder)zzavR.getParcelable(((String) (obj)));
                if (obj != null)
                {
                    ((DataHolder) (obj)).close();
                }
            } while (true);
        }

        LoadRequestsResultImpl(Status status, Bundle bundle)
        {
            zzSC = status;
            zzavR = bundle;
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
    {

        private final LeaderboardEntity zzavS = null;
        private final LeaderboardScoreBuffer zzavT;

        public Leaderboard getLeaderboard()
        {
            return zzavS;
        }

        public LeaderboardScoreBuffer getScores()
        {
            return zzavT;
        }

        LoadScoresResultImpl(DataHolder dataholder, DataHolder dataholder1)
        {
            super(dataholder1);
            dataholder = new LeaderboardBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavS = (LeaderboardEntity)((Leaderboard)dataholder.get(0)).freeze();
_L4:
            dataholder.release();
            zzavT = new LeaderboardScoreBuffer(dataholder1);
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            dataholder1;
            dataholder.release();
            throw dataholder1;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
    {

        public SnapshotMetadataBuffer getSnapshots()
        {
            return new SnapshotMetadataBuffer(zzabq);
        }

        LoadSnapshotsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl
        implements com.google.android.gms.games.Players.LoadXpForGameCategoriesResult
    {

        private final Status zzSC;
        private final List zzavU;
        private final Bundle zzavV;

        public Status getStatus()
        {
            return zzSC;
        }

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle)
        {
            zzSC = status;
            zzavU = bundle.getStringArrayList("game_category_list");
            zzavV = bundle;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.Players.LoadXpStreamResult
    {

        private final ExperienceEventBuffer zzavW;

        LoadXpStreamResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzavW = new ExperienceEventBuffer(dataholder);
        }
    }

    private static final class MatchRemovedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final String zzavX;

        public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchRemoved(zzavX);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        MatchRemovedNotifier(String s)
        {
            zzavX = s;
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks
    {

        private final zzlm zzakZ;

        public void onTurnBasedMatchRemoved(String s)
        {
            zzakZ.zza(new MatchRemovedNotifier(s));
        }

        public void zzy(DataHolder dataholder)
        {
            TurnBasedMatchBuffer turnbasedmatchbuffer;
            turnbasedmatchbuffer = new TurnBasedMatchBuffer(dataholder);
            dataholder = null;
            if (turnbasedmatchbuffer.getCount() > 0)
            {
                dataholder = (TurnBasedMatch)((TurnBasedMatch)turnbasedmatchbuffer.get(0)).freeze();
            }
            turnbasedmatchbuffer.release();
            if (dataholder != null)
            {
                zzakZ.zza(new MatchUpdateReceivedNotifier(dataholder));
            }
            return;
            dataholder;
            turnbasedmatchbuffer.release();
            throw dataholder;
        }

        MatchUpdateReceivedBinderCallback(zzlm zzlm1)
        {
            zzakZ = zzlm1;
        }
    }

    private static final class MatchUpdateReceivedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final TurnBasedMatch zzavY;

        public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchReceived(zzavY);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        MatchUpdateReceivedNotifier(TurnBasedMatch turnbasedmatch)
        {
            zzavY = turnbasedmatch;
        }
    }

    private static final class MessageReceivedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final RealTimeMessage zzavZ;

        public void zza(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            realtimemessagereceivedlistener.onRealTimeMessageReceived(zzavZ);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((RealTimeMessageReceivedListener)obj);
        }

        MessageReceivedNotifier(RealTimeMessage realtimemessage)
        {
            zzavZ = realtimemessage;
        }
    }

    private static final class NearbyPlayerDetectedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final Player zzawa;

        public void zza(OnNearbyPlayerDetectedListener onnearbyplayerdetectedlistener)
        {
            onnearbyplayerdetectedlistener.zza(zzawa);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnNearbyPlayerDetectedListener)obj);
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzH(DataHolder dataholder)
        {
            zzagy.zzp(new LoadAclResultImpl(dataholder));
        }

        NotifyAclLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzfR(int i)
        {
            zzagy.zzp(GamesStatusCodes.zzfG(i));
        }

        NotifyAclUpdatedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
    {

        private final Snapshot zzawb;
        private final String zzawc;
        private final Snapshot zzawd;
        private final Contents zzawe;
        private final SnapshotContents zzawf;

        public String getConflictId()
        {
            return zzawc;
        }

        public Snapshot getConflictingSnapshot()
        {
            return zzawd;
        }

        public SnapshotContents getResolutionSnapshotContents()
        {
            return zzawf;
        }

        public Snapshot getSnapshot()
        {
            return zzawb;
        }

        OpenSnapshotResultImpl(DataHolder dataholder, Contents contents)
        {
            this(dataholder, null, contents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder dataholder, String s, Contents contents, Contents contents1, Contents contents2)
        {
            SnapshotMetadataBuffer snapshotmetadatabuffer;
            boolean flag;
            flag = true;
            super(dataholder);
            snapshotmetadatabuffer = new SnapshotMetadataBuffer(dataholder);
            if (snapshotmetadatabuffer.getCount() != 0) goto _L2; else goto _L1
_L1:
            zzawb = null;
            zzawd = null;
_L3:
            snapshotmetadatabuffer.release();
            zzawc = s;
            zzawe = contents2;
            zzawf = new SnapshotContentsEntity(contents2);
            return;
_L2:
            if (snapshotmetadatabuffer.getCount() != 1)
            {
                break MISSING_BLOCK_LABEL_144;
            }
            if (dataholder.getStatusCode() == 4004)
            {
                flag = false;
            }
            com.google.android.gms.common.internal.zzb.zzZ(flag);
            zzawb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
            zzawd = null;
              goto _L3
            dataholder;
            snapshotmetadatabuffer.release();
            throw dataholder;
            zzawb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
            zzawd = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(1)), new SnapshotContentsEntity(contents1));
              goto _L3
        }
    }

    private static final class P2PConnectedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final String zzawg;

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            roomstatusupdatelistener.onP2PConnected(zzawg);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((RoomStatusUpdateListener)obj);
        }

        P2PConnectedNotifier(String s)
        {
            zzawg = s;
        }
    }

    private static final class P2PDisconnectedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final String zzawg;

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            roomstatusupdatelistener.onP2PDisconnected(zzawg);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((RoomStatusUpdateListener)obj);
        }

        P2PDisconnectedNotifier(String s)
        {
            zzawg = s;
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeersConnected(room, arraylist);
        }

        PeerConnectedNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder, as);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerDeclined(room, arraylist);
        }

        PeerDeclinedNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder, as);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeersDisconnected(room, arraylist);
        }

        PeerDisconnectedNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder, as);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerInvitedToRoom(room, arraylist);
        }

        PeerInvitedToRoomNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder, as);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerJoined(room, arraylist);
        }

        PeerJoinedRoomNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder, as);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerLeft(room, arraylist);
        }

        PeerLeftRoomNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder, as);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzJ(DataHolder dataholder)
        {
            zzagy.zzp(new LoadPlayerScoreResultImpl(dataholder));
        }

        PlayerLeaderboardScoreLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzW(DataHolder dataholder)
        {
            zzagy.zzp(new LoadPlayerStatsResultImpl(dataholder));
        }

        public PlayerStatsLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzf(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfG(i);
            zzagy.zzp(new LoadXpForGameCategoriesResultImpl(status, bundle));
        }

        PlayerXpForGameCategoriesLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzU(DataHolder dataholder)
        {
            zzagy.zzp(new LoadXpStreamResultImpl(dataholder));
        }

        PlayerXpStreamLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzl(DataHolder dataholder)
        {
            zzagy.zzp(new LoadPlayersResultImpl(dataholder));
        }

        public void zzm(DataHolder dataholder)
        {
            zzagy.zzp(new LoadPlayersResultImpl(dataholder));
        }

        PlayersLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient
    {

        private final PopupManager zzavl;

        public PopupLocationInfoParcelable zzus()
        {
            return new PopupLocationInfoParcelable(zzavl.zzvi());
        }

        public PopupLocationInfoBinderCallbacks(PopupManager popupmanager)
        {
            zzavl = popupmanager;
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzV(DataHolder dataholder)
        {
            zzagy.zzp(new LoadProfileSettingsResultImpl(dataholder));
        }

        ProfileSettingsLoadedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzfT(int i)
        {
            zzagy.zzp(GamesStatusCodes.zzfG(i));
        }

        ProfileSettingsUpdatedBinderCallback(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawh;

        public void zzQ(DataHolder dataholder)
        {
            zzawh.zzp(new AcceptQuestResultImpl(dataholder));
        }

        public QuestAcceptedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawh = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class QuestCompletedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final Quest zzavs;

        public void zza(QuestUpdateListener questupdatelistener)
        {
            questupdatelistener.onQuestCompleted(zzavs);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((QuestUpdateListener)obj);
        }

        QuestCompletedNotifier(Quest quest)
        {
            zzavs = quest;
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawi;
        private final String zzawj;

        public void zzP(DataHolder dataholder)
        {
            zzawi.zzp(new ClaimMilestoneResultImpl(dataholder, zzawj));
        }

        public QuestMilestoneClaimBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        {
            zzawi = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
            zzawj = (String)zzx.zzb(s, "MilestoneId must not be null");
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks
    {

        private final zzlm zzakZ;

        private Quest zzZ(DataHolder dataholder)
        {
            QuestBuffer questbuffer;
            questbuffer = new QuestBuffer(dataholder);
            dataholder = null;
            if (questbuffer.getCount() > 0)
            {
                dataholder = (Quest)((Quest)questbuffer.get(0)).freeze();
            }
            questbuffer.release();
            return dataholder;
            dataholder;
            questbuffer.release();
            throw dataholder;
        }

        public void zzR(DataHolder dataholder)
        {
            dataholder = zzZ(dataholder);
            if (dataholder != null)
            {
                zzakZ.zza(new QuestCompletedNotifier(dataholder));
            }
        }

        QuestUpdateBinderCallback(zzlm zzlm1)
        {
            zzakZ = zzlm1;
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawk;

        public void zzT(DataHolder dataholder)
        {
            zzawk.zzp(new LoadQuestsResultImpl(dataholder));
        }

        public QuestsLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawk = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RealTimeMessageSentNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final int zzYm;
        private final String zzawl;
        private final int zzawm;

        public void zza(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            if (reliablemessagesentcallback != null)
            {
                reliablemessagesentcallback.onRealTimeMessageSent(zzYm, zzawm, zzawl);
            }
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback)obj);
        }

        RealTimeMessageSentNotifier(int i, int j, String s)
        {
            zzYm = i;
            zzawm = j;
            zzawl = s;
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks
    {

        final zzlm zzawn;

        public void zzb(int i, int j, String s)
        {
            if (zzawn != null)
            {
                zzawn.zza(new RealTimeMessageSentNotifier(i, j, s));
            }
        }

        public RealTimeReliableMessageBinderCallbacks(zzlm zzlm1)
        {
            zzawn = zzlm1;
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks
    {

        private final zzlm zzakZ;

        public void onRequestRemoved(String s)
        {
            zzakZ.zza(new RequestRemovedNotifier(s));
        }

        public void zzt(DataHolder dataholder)
        {
            GameRequestBuffer gamerequestbuffer;
            gamerequestbuffer = new GameRequestBuffer(dataholder);
            dataholder = null;
            if (gamerequestbuffer.getCount() > 0)
            {
                dataholder = (GameRequest)((GameRequest)gamerequestbuffer.get(0)).freeze();
            }
            gamerequestbuffer.release();
            if (dataholder != null)
            {
                zzakZ.zza(new RequestReceivedNotifier(dataholder));
            }
            return;
            dataholder;
            gamerequestbuffer.release();
            throw dataholder;
        }

        RequestReceivedBinderCallback(zzlm zzlm1)
        {
            zzakZ = zzlm1;
        }
    }

    private static final class RequestReceivedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final GameRequest zzawo;

        public void zza(OnRequestReceivedListener onrequestreceivedlistener)
        {
            onrequestreceivedlistener.onRequestReceived(zzawo);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnRequestReceivedListener)obj);
        }

        RequestReceivedNotifier(GameRequest gamerequest)
        {
            zzawo = gamerequest;
        }
    }

    private static final class RequestRemovedNotifier
        implements com.google.android.gms.internal.zzlm.zzb
    {

        private final String zzBY;

        public void zza(OnRequestReceivedListener onrequestreceivedlistener)
        {
            onrequestreceivedlistener.onRequestRemoved(zzBY);
        }

        public void zznN()
        {
        }

        public void zzq(Object obj)
        {
            zza((OnRequestReceivedListener)obj);
        }

        RequestRemovedNotifier(String s)
        {
            zzBY = s;
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawp;

        public void zzL(DataHolder dataholder)
        {
            zzawp.zzp(new SendRequestResultImpl(dataholder));
        }

        public RequestSentBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawp = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawq;

        public void zzM(DataHolder dataholder)
        {
            zzawq.zzp(new LoadRequestSummariesResultImpl(dataholder));
        }

        public RequestSummariesLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawq = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawr;

        public void zzd(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfG(i);
            zzawr.zzp(new LoadRequestsResultImpl(status, bundle));
        }

        public RequestsLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawr = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzaws;

        public void zzK(DataHolder dataholder)
        {
            zzaws.zzp(new UpdateRequestsResultImpl(dataholder));
        }

        public RequestsUpdatedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzaws = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier
    {

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onRoomAutoMatching(room);
        }

        RoomAutoMatchingNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks
    {

        private final zzlm zzawt;
        private final zzlm zzawu;
        private final zzlm zzawv;

        public void onLeftRoom(int i, String s)
        {
            zzawt.zza(new LeftRoomNotifier(i, s));
        }

        public void onP2PConnected(String s)
        {
            if (zzawu != null)
            {
                zzawu.zza(new P2PConnectedNotifier(s));
            }
        }

        public void onP2PDisconnected(String s)
        {
            if (zzawu != null)
            {
                zzawu.zza(new P2PDisconnectedNotifier(s));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage realtimemessage)
        {
            if (zzawv != null)
            {
                zzawv.zza(new MessageReceivedNotifier(realtimemessage));
            }
        }

        public void zzA(DataHolder dataholder)
        {
            zzawt.zza(new JoinedRoomNotifier(dataholder));
        }

        public void zzB(DataHolder dataholder)
        {
            if (zzawu != null)
            {
                zzawu.zza(new RoomConnectingNotifier(dataholder));
            }
        }

        public void zzC(DataHolder dataholder)
        {
            if (zzawu != null)
            {
                zzawu.zza(new RoomAutoMatchingNotifier(dataholder));
            }
        }

        public void zzD(DataHolder dataholder)
        {
            zzawt.zza(new RoomConnectedNotifier(dataholder));
        }

        public void zzE(DataHolder dataholder)
        {
            if (zzawu != null)
            {
                zzawu.zza(new ConnectedToRoomNotifier(dataholder));
            }
        }

        public void zzF(DataHolder dataholder)
        {
            if (zzawu != null)
            {
                zzawu.zza(new DisconnectedFromRoomNotifier(dataholder));
            }
        }

        public void zza(DataHolder dataholder, String as[])
        {
            if (zzawu != null)
            {
                zzawu.zza(new PeerInvitedToRoomNotifier(dataholder, as));
            }
        }

        public void zzb(DataHolder dataholder, String as[])
        {
            if (zzawu != null)
            {
                zzawu.zza(new PeerJoinedRoomNotifier(dataholder, as));
            }
        }

        public void zzc(DataHolder dataholder, String as[])
        {
            if (zzawu != null)
            {
                zzawu.zza(new PeerLeftRoomNotifier(dataholder, as));
            }
        }

        public void zzd(DataHolder dataholder, String as[])
        {
            if (zzawu != null)
            {
                zzawu.zza(new PeerDeclinedNotifier(dataholder, as));
            }
        }

        public void zze(DataHolder dataholder, String as[])
        {
            if (zzawu != null)
            {
                zzawu.zza(new PeerConnectedNotifier(dataholder, as));
            }
        }

        public void zzf(DataHolder dataholder, String as[])
        {
            if (zzawu != null)
            {
                zzawu.zza(new PeerDisconnectedNotifier(dataholder, as));
            }
        }

        public void zzz(DataHolder dataholder)
        {
            zzawt.zza(new RoomCreatedNotifier(dataholder));
        }

        public RoomBinderCallbacks(zzlm zzlm1)
        {
            zzawt = (zzlm)zzx.zzb(zzlm1, "Callbacks must not be null");
            zzawu = null;
            zzawv = null;
        }

        public RoomBinderCallbacks(zzlm zzlm1, zzlm zzlm2, zzlm zzlm3)
        {
            zzawt = (zzlm)zzx.zzb(zzlm1, "Callbacks must not be null");
            zzawu = zzlm2;
            zzawv = zzlm3;
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier
    {

        public void zza(RoomUpdateListener roomupdatelistener, Room room, int i)
        {
            roomupdatelistener.onRoomConnected(i, room);
        }

        RoomConnectedNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier
    {

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onRoomConnecting(room);
        }

        RoomConnectingNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier
    {

        public void zza(RoomUpdateListener roomupdatelistener, Room room, int i)
        {
            roomupdatelistener.onRoomCreated(i, room);
        }

        public RoomCreatedNotifier(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.request.Requests.SendRequestResult
    {

        private final GameRequest zzawo = null;

        SendRequestResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new GameRequestBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzawo = (GameRequest)((GameRequest)dataholder.get(0)).freeze();
_L4:
            dataholder.release();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.release();
            throw exception;
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzur()
        {
            Status status = GamesStatusCodes.zzfG(0);
            zzagy.zzp(status);
        }

        public SignOutCompleteBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzaww;

        public void zzO(DataHolder dataholder)
        {
            zzaww.zzp(new CommitSnapshotResultImpl(dataholder));
        }

        public SnapshotCommittedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzaww = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzj(int i, String s)
        {
            zzagy.zzp(new DeleteSnapshotResultImpl(i, s));
        }

        public SnapshotDeletedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawx;

        public void zza(DataHolder dataholder, Contents contents)
        {
            zzawx.zzp(new OpenSnapshotResultImpl(dataholder, contents));
        }

        public void zza(DataHolder dataholder, String s, Contents contents, Contents contents1, Contents contents2)
        {
            zzawx.zzp(new OpenSnapshotResultImpl(dataholder, s, contents, contents1, contents2));
        }

        public SnapshotOpenedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawx = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawy;

        public void zzN(DataHolder dataholder)
        {
            zzawy.zzp(new LoadSnapshotsResultImpl(dataholder));
        }

        public SnapshotsLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;

        public void zzk(DataHolder dataholder)
        {
            zzagy.zzp(new SubmitScoreResultImpl(dataholder));
        }

        public SubmitScoreBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzagy = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
    {

        private final ScoreSubmissionData zzawz;

        public ScoreSubmissionData getScoreData()
        {
            return zzawz;
        }

        public SubmitScoreResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzawz = new ScoreSubmissionData(dataholder);
            dataholder.close();
            return;
            Exception exception;
            exception;
            dataholder.close();
            throw exception;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawA;

        public void zzi(int i, String s)
        {
            Status status = GamesStatusCodes.zzfG(i);
            zzawA.zzp(new CancelMatchResultImpl(status, s));
        }

        public TurnBasedMatchCanceledBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawA = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawB;

        public void zzv(DataHolder dataholder)
        {
            zzawB.zzp(new InitiateMatchResultImpl(dataholder));
        }

        public TurnBasedMatchInitiatedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawB = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawC;

        public void zzx(DataHolder dataholder)
        {
            zzawC.zzp(new LeaveMatchResultImpl(dataholder));
        }

        public TurnBasedMatchLeftBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawC = (com.google.android.gms.internal.zzlb.zzb)com.google.android.gms.common.internal.zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawD;

        public void zzu(DataHolder dataholder)
        {
            zzawD.zzp(new LoadMatchResultImpl(dataholder));
        }

        public TurnBasedMatchLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawD = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult
    {

        final TurnBasedMatch zzavY = null;

        public TurnBasedMatch getMatch()
        {
            return zzavY;
        }

        TurnBasedMatchResult(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new TurnBasedMatchBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzavY = (TurnBasedMatch)((TurnBasedMatch)dataholder.get(0)).freeze();
_L4:
            dataholder.release();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            dataholder.release();
            throw exception;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawE;

        public void zzw(DataHolder dataholder)
        {
            zzawE.zzp(new UpdateMatchResultImpl(dataholder));
        }

        public TurnBasedMatchUpdatedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawE = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.internal.zzlb.zzb zzawF;

        public void zzc(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfG(i);
            zzawF.zzp(new LoadMatchesResultImpl(status, bundle));
        }

        public TurnBasedMatchesLoadedBinderCallbacks(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzawF = (com.google.android.gms.internal.zzlb.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class UpdateAchievementResultImpl
        implements com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    {

        private final Status zzSC;
        private final String zzauq;

        public String getAchievementId()
        {
            return zzauq;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        UpdateAchievementResultImpl(int i, String s)
        {
            zzSC = GamesStatusCodes.zzfG(i);
            zzauq = s;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
    {

        UpdateMatchResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.request.Requests.UpdateRequestsResult
    {

        private final RequestUpdateOutcomes zzawG;

        public Set getRequestIds()
        {
            return zzawG.getRequestIds();
        }

        public int getRequestOutcome(String s)
        {
            return zzawG.getRequestOutcome(s);
        }

        UpdateRequestsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzawG = RequestUpdateOutcomes.zzaa(dataholder);
        }
    }


    EventIncrementManager zzavh;
    private final String zzavi;
    private PlayerEntity zzavj;
    private GameEntity zzavk;
    private final PopupManager zzavl;
    private boolean zzavm;
    private final Binder zzavn = new Binder();
    private final long zzavo = (long)hashCode();
    private final com.google.android.gms.games.Games.GamesOptions zzavp;

    public GamesClientImpl(Context context, Looper looper, zzf zzf1, com.google.android.gms.games.Games.GamesOptions gamesoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 1, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzavh = new EventIncrementManager() {

            final GamesClientImpl zzavq;

            public EventIncrementCache zzuU()
            {
                return zzavq. new GameClientEventIncrementCache();
            }

            
            {
                zzavq = GamesClientImpl.this;
                super();
            }
        };
        zzavm = false;
        zzavi = zzf1.zzoN();
        zzavl = PopupManager.zza(this, zzf1.zzoJ());
        zzn(zzf1.zzoP());
        zzavp = gamesoptions;
    }

    private static Room zzX(DataHolder dataholder)
    {
        RoomBuffer roombuffer;
        roombuffer = new RoomBuffer(dataholder);
        dataholder = null;
        if (roombuffer.getCount() > 0)
        {
            dataholder = (Room)((Room)roombuffer.get(0)).freeze();
        }
        roombuffer.release();
        return dataholder;
        dataholder;
        roombuffer.release();
        throw dataholder;
    }

    static Room zzY(DataHolder dataholder)
    {
        return zzX(dataholder);
    }

    static void zza(GamesClientImpl gamesclientimpl, RemoteException remoteexception)
    {
        gamesclientimpl.zzb(remoteexception);
    }

    private void zzb(RemoteException remoteexception)
    {
        com.google.android.gms.games.internal.GamesLog.zzb("GamesClientImpl", "service died", remoteexception);
    }

    private void zzuv()
    {
        zzavj = null;
        zzavk = null;
    }

    public void disconnect()
    {
        zzavm = false;
        if (isConnected())
        {
            try
            {
                IGamesService igamesservice = (IGamesService)zzpc();
                igamesservice.zzuT();
                zzavh.flush();
                igamesservice.zzE(zzavo);
            }
            catch (RemoteException remoteexception)
            {
                GamesLog.zzy("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        super.onConnectionFailed(connectionresult);
        zzavm = false;
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzbN(ibinder);
    }

    public int zza(zzlm zzlm, byte abyte0[], String s, String s1)
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zza(new RealTimeReliableMessageBinderCallbacks(zzlm), abyte0, s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(zzlm);
            return -1;
        }
        return i;
    }

    public int zza(byte abyte0[], String s, String as[])
    {
        zzx.zzb(as, "Participant IDs must not be null");
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzb(abyte0, s, as);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzb(abyte0);
            return -1;
        }
        return i;
    }

    public Intent zza(int i, byte abyte0[], int j, Bitmap bitmap, String s)
    {
        try
        {
            abyte0 = ((IGamesService)zzpc()).zza(i, abyte0, j, s);
            zzx.zzb(bitmap, "Must provide a non null icon");
            abyte0.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzb(abyte0);
            return null;
        }
        return abyte0;
    }

    public Intent zza(PlayerEntity playerentity)
    {
        try
        {
            playerentity = ((IGamesService)zzpc()).zza(playerentity);
        }
        // Misplaced declaration of an exception variable
        catch (PlayerEntity playerentity)
        {
            zzb(playerentity);
            return null;
        }
        return playerentity;
    }

    public Intent zza(Room room, int i)
    {
        try
        {
            room = ((IGamesService)zzpc()).zza((RoomEntity)room.freeze(), i);
        }
        // Misplaced declaration of an exception variable
        catch (Room room)
        {
            zzb(room);
            return null;
        }
        return room;
    }

    public Intent zza(String s, boolean flag, boolean flag1, int i)
    {
        try
        {
            s = ((IGamesService)zzpc()).zza(s, flag, flag1, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
            return null;
        }
        return s;
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (i == 0 && bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/games/internal/GamesClientImpl.getClassLoader());
            zzavm = bundle.getBoolean("show_welcome_popup");
            zzavj = (PlayerEntity)bundle.getParcelable("com.google.android.gms.games.current_player");
            zzavk = (GameEntity)bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, ibinder, bundle, j);
    }

    public void zza(IBinder ibinder, Bundle bundle)
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        ((IGamesService)zzpc()).zza(ibinder, bundle);
        return;
        ibinder;
        zzb(ibinder);
        return;
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza1)
    {
        zzuv();
        super.zza(zza1);
    }

    public void zza(Snapshot snapshot)
    {
        snapshot = snapshot.getSnapshotContents();
        Contents contents;
        boolean flag;
        if (!snapshot.isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Snapshot already closed");
        contents = snapshot.zzqO();
        snapshot.close();
        try
        {
            ((IGamesService)zzpc()).zza(contents);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Snapshot snapshot)
        {
            zzb(snapshot);
        }
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, int i)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new InvitationsLoadedBinderCallback(zzb1), i);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, int i, int j, int k)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new RequestsLoadedBinderCallbacks(zzb1), i, j, k);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, int i, String s, String as[], boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new AppContentLoadedBinderCallbacks(zzb1), i, s, as, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, int i, int ai[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzb1), i, ai);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(zzb1), leaderboardscorebuffer.zzvH().asBundle(), i, j);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, TurnBasedMatchConfig turnbasedmatchconfig)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), turnbasedmatchconfig.getVariant(), turnbasedmatchconfig.zzvN(), turnbasedmatchconfig.getInvitedPlayerIds(), turnbasedmatchconfig.getAutoMatchCriteria());
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, Snapshot snapshot, SnapshotMetadataChange snapshotmetadatachange)
        throws RemoteException
    {
        SnapshotContents snapshotcontents = snapshot.getSnapshotContents();
        Object obj;
        boolean flag;
        if (!snapshotcontents.isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Snapshot already closed");
        obj = snapshotmetadatachange.zzvS();
        if (obj != null)
        {
            ((BitmapTeleporter) (obj)).zzc(getContext().getCacheDir());
        }
        obj = snapshotcontents.zzqO();
        snapshotcontents.close();
        ((IGamesService)zzpc()).zza(new SnapshotCommittedBinderCallbacks(zzb1), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)snapshotmetadatachange, ((Contents) (obj)));
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzpc()).zza(zzb1, s, zzavl.zzvh(), zzavl.zzvg());
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzpc()).zza(zzb1, s, i, zzavl.zzvh(), zzavl.zzvg());
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(zzb1), s, i, j, k, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch 156408498 156408498: default 24
    //                   156408498 72;
           goto _L1 _L2
_L2:
        if (s.equals("played_with"))
        {
            byte0 = 0;
        }
_L1:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid player collection: ").append(s).toString());

        case 0: // '\0'
            ((IGamesService)zzpc()).zzd(new PlayersLoadedBinderCallback(zzb1), s, i, flag, flag1);
            break;
        }
        return;
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i, int ai[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzb1), s, i, ai);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, long l, String s1)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new SubmitScoreBinderCallbacks(zzb1);
        }
        ((IGamesService)zzpc()).zza(zzb1, s, l, s1);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new TurnBasedMatchLeftBinderCallbacks(zzb1), s, s1);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int i, int j)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(zzb1), s, s1, i, j);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int i, int j, int k)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new RequestsLoadedBinderCallbacks(zzb1), s, s1, i, j, k);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(zzb1), s, s1, i, j, k, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   -1049482625: 128
    //                   156408498: 112
    //                   782949780: 96;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_128;
_L5:
        switch (byte0)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid player collection: ").append(s).toString());

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            ((IGamesService)zzpc()).zza(new PlayersLoadedBinderCallback(zzb1), s, s1, i, flag, flag1);
            break;
        }
        break MISSING_BLOCK_LABEL_172;
_L4:
        if (s.equals("circled"))
        {
            byte0 = 0;
        }
          goto _L5
_L3:
        if (s.equals("played_with"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("nearby"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, SnapshotMetadataChange snapshotmetadatachange, SnapshotContents snapshotcontents)
        throws RemoteException
    {
        Object obj;
        boolean flag;
        if (!snapshotcontents.isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "SnapshotContents already closed");
        obj = snapshotmetadatachange.zzvS();
        if (obj != null)
        {
            ((BitmapTeleporter) (obj)).zzc(getContext().getCacheDir());
        }
        obj = snapshotcontents.zzqO();
        snapshotcontents.close();
        ((IGamesService)zzpc()).zza(new SnapshotOpenedBinderCallbacks(zzb1), s, s1, (SnapshotMetadataChangeEntity)snapshotmetadatachange, ((Contents) (obj)));
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new LeaderboardsLoadedBinderCallback(zzb1), s, s1, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, boolean flag, String as[])
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(zzb1), s, s1, as, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int ai[], int i, boolean flag)
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(zzb1), s, s1, ai, i, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new RequestsUpdatedBinderCallbacks(zzb1), s, s1, as);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzf(new PlayersLoadedBinderCallback(zzb1), s, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, boolean flag, int i)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new SnapshotOpenedBinderCallbacks(zzb1), s, flag, i);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzb1), s, abyte0, s1, aparticipantresult);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, byte abyte0[], ParticipantResult aparticipantresult[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzb1), s, abyte0, aparticipantresult);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String as[], int i, byte abyte0[], int j)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new RequestSentBinderCallbacks(zzb1), s, as, i, abyte0, j);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new PlayersLoadedBinderCallback(zzb1), flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag, Bundle bundle)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new ContactSettingsUpdatedBinderCallback(zzb1), flag, bundle);
    }

    public transient void zza(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag, String as[])
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zza(new EventsLoadedBinderCallback(zzb1), flag, as);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, int ai[], int i, boolean flag)
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(zzb1), ai, i, flag);
    }

    public void zza(com.google.android.gms.internal.zzlb.zzb zzb1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new PlayersLoadedBinderCallback(zzb1), as);
    }

    public void zza(zzlm zzlm)
    {
        try
        {
            zzlm = new InvitationReceivedBinderCallback(zzlm);
            ((IGamesService)zzpc()).zza(zzlm, zzavo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(zzlm);
        }
    }

    public void zza(zzlm zzlm, zzlm zzlm1, zzlm zzlm2, RoomConfig roomconfig)
    {
        try
        {
            zzlm = new RoomBinderCallbacks(zzlm, zzlm1, zzlm2);
            ((IGamesService)zzpc()).zza(zzlm, zzavn, roomconfig.getVariant(), roomconfig.getInvitedPlayerIds(), roomconfig.getAutoMatchCriteria(), false, zzavo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(zzlm);
        }
    }

    public void zza(zzlm zzlm, String s)
    {
        try
        {
            ((IGamesService)zzpc()).zzc(new RoomBinderCallbacks(zzlm), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(zzlm);
        }
    }

    public Intent zzb(int i, int j, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzb(i, j, flag);
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zzb(int ai[])
    {
        try
        {
            ai = ((IGamesService)zzpc()).zzb(ai);
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            zzb(((RemoteException) (ai)));
            return null;
        }
        return ai;
    }

    protected Set zzb(Set set)
    {
        Scope scope = new Scope("https://www.googleapis.com/auth/games");
        Scope scope1 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        Iterator iterator = set.iterator();
        boolean flag = false;
        boolean flag1 = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Scope scope2 = (Scope)iterator.next();
            if (scope2.equals(scope))
            {
                flag1 = true;
            } else
            if (scope2.equals(scope1))
            {
                flag = true;
            }
        } while (true);
        if (flag)
        {
            if (!flag1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            zzx.zza(flag1, "Cannot have both %s and %s!", new Object[] {
                "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"
            });
            return set;
        } else
        {
            zzx.zza(flag1, "Games APIs requires %s to function.", new Object[] {
                "https://www.googleapis.com/auth/games"
            });
            return set;
        }
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzpc()).zzb(zzb1, s, zzavl.zzvh(), zzavl.zzvg());
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzpc()).zzb(zzb1, s, i, zzavl.zzvh(), zzavl.zzvg());
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb1), s, i, j, k, flag);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new PlayersLoadedBinderCallback(zzb1), s, i, flag, flag1);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zzf(new QuestMilestoneClaimBinderCallbacks(zzb1, s1), s, s1);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb1), s, s1, i, j, k, flag);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new PlayersLoadedBinderCallback(zzb1), s, s1, i, flag, flag1);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new AchievementsLoadedBinderCallback(zzb1), s, s1, flag);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new LeaderboardsLoadedBinderCallback(zzb1), s, flag);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new LeaderboardsLoadedBinderCallback(zzb1), flag);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag, String as[])
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(zzb1), as, flag);
    }

    public void zzb(com.google.android.gms.internal.zzlb.zzb zzb1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new RequestsUpdatedBinderCallbacks(zzb1), as);
    }

    public void zzb(zzlm zzlm)
    {
        try
        {
            zzlm = new MatchUpdateReceivedBinderCallback(zzlm);
            ((IGamesService)zzpc()).zzb(zzlm, zzavo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(((RemoteException) (zzlm)));
        }
    }

    public void zzb(zzlm zzlm, zzlm zzlm1, zzlm zzlm2, RoomConfig roomconfig)
    {
        try
        {
            zzlm = new RoomBinderCallbacks(zzlm, zzlm1, zzlm2);
            ((IGamesService)zzpc()).zza(zzlm, zzavn, roomconfig.getInvitationId(), false, zzavo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(((RemoteException) (zzlm)));
        }
    }

    protected IGamesService zzbN(IBinder ibinder)
    {
        return IGamesService.Stub.zzbQ(ibinder);
    }

    public Intent zzc(int i, int j, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzc(i, j, flag);
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new PlayerXpStreamLoadedBinderCallback(zzb1), s, i);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s, s1);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new SnapshotsLoadedBinderCallbacks(zzb1), s, s1, flag);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzd(new LeaderboardsLoadedBinderCallback(zzb1), s, flag);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new AchievementsLoadedBinderCallback(zzb1), flag);
    }

    public void zzc(com.google.android.gms.internal.zzlb.zzb zzb1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new RequestsUpdatedBinderCallbacks(zzb1), as);
    }

    public void zzc(zzlm zzlm)
    {
        try
        {
            zzlm = new QuestUpdateBinderCallback(zzlm);
            ((IGamesService)zzpc()).zzd(zzlm, zzavo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(zzlm);
        }
    }

    public void zzcW(String s)
    {
        try
        {
            ((IGamesService)zzpc()).zzde(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public Intent zzcX(String s)
    {
        try
        {
            s = ((IGamesService)zzpc()).zzcX(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
            return null;
        }
        return s;
    }

    public void zzcY(String s)
    {
        try
        {
            ((IGamesService)zzpc()).zza(s, zzavl.zzvh(), zzavl.zzvg());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public int zzd(byte abyte0[], String s)
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzb(abyte0, s, null);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzb(abyte0);
            return -1;
        }
        return i;
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzd(new GamesLoadedBinderCallback(zzb1));
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zze(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s);
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzc(new PlayerXpStreamLoadedBinderCallback(zzb1), s, i);
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zze(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s, s1);
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new GameMuteStatusChangedBinderCallback(zzb1), s, flag);
    }

    public void zzd(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zzf(new EventsLoadedBinderCallback(zzb1), flag);
    }

    public void zzd(zzlm zzlm)
    {
        try
        {
            zzlm = new RequestReceivedBinderCallback(zzlm);
            ((IGamesService)zzpc()).zzc(zzlm, zzavo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzlm zzlm)
        {
            zzb(zzlm);
        }
    }

    public void zze(com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zza(new SignOutCompleteBinderCallbacks(zzb1));
    }

    public void zze(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzo(new TurnBasedMatchLeftBinderCallbacks(zzb1), s);
    }

    public void zze(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzb(new InvitationsLoadedBinderCallback(zzb1), s, i, false);
    }

    public void zze(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzi(new PlayerStatsLoadedBinderCallbacks(zzb1), flag);
    }

    public void zzf(com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzh(new NotifyAclLoadedBinderCallback(zzb1));
    }

    public void zzf(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzn(new TurnBasedMatchCanceledBinderCallbacks(zzb1), s);
    }

    public void zzf(com.google.android.gms.internal.zzlb.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zza(new RequestSummariesLoadedBinderCallbacks(zzb1), s, i);
    }

    public void zzf(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzd(new SnapshotsLoadedBinderCallbacks(zzb1), flag);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzfV(int i)
    {
        zzavl.setGravity(i);
    }

    public void zzfW(int i)
    {
        try
        {
            ((IGamesService)zzpc()).zzfW(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zzg(com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzt(new InboxCountsLoadedBinderCallback(zzb1), null);
    }

    public void zzg(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzp(new TurnBasedMatchLoadedBinderCallbacks(zzb1), s);
    }

    public void zzg(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzg(new ProfileSettingsLoadedBinderCallback(zzb1), flag);
    }

    public void zzh(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        zzavh.flush();
        ((IGamesService)zzpc()).zzu(new QuestAcceptedBinderCallbacks(zzb1), s);
    }

    public void zzh(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzh(new ProfileSettingsUpdatedBinderCallback(zzb1), flag);
    }

    public void zzi(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzr(new SnapshotDeletedBinderCallbacks(zzb1), s);
    }

    public void zzi(com.google.android.gms.internal.zzlb.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zze(new ContactSettingsLoadedBinderCallback(zzb1), flag);
    }

    public void zzj(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzf(new GameInstancesLoadedBinderCallback(zzb1), s);
    }

    public void zzk(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzq(new GameSearchSuggestionsLoadedBinderCallback(zzb1), s);
    }

    public Intent zzl(String s, int i, int j)
    {
        try
        {
            s = ((IGamesService)zzpc()).zzm(s, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
            return null;
        }
        return s;
    }

    public void zzl(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzb1), s);
    }

    public boolean zzlN()
    {
        return true;
    }

    protected Bundle zzly()
    {
        Object obj = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = zzavp.zztD();
        bundle.putString("com.google.android.gms.games.key.gamePackageName", zzavi);
        bundle.putString("com.google.android.gms.games.key.desiredLocale", ((String) (obj)));
        bundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(zzavl.zzvh()));
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 1);
        obj = zzpa();
        if (((zzf) (obj)).zzoQ() != null)
        {
            bundle.putBundle("com.google.android.gms.games.key.signInOptions", com.google.android.gms.signin.internal.zzi.zza(((zzf) (obj)).zzoQ(), ((zzf) (obj)).zzoR(), Executors.newSingleThreadExecutor()));
        }
        return bundle;
    }

    public void zzm(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzk(new InvitationsLoadedBinderCallback(zzb1), s);
    }

    public Bundle zzmS()
    {
        Bundle bundle;
        try
        {
            bundle = ((IGamesService)zzpc()).zzmS();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        bundle.setClassLoader(com/google/android/gms/games/internal/GamesClientImpl.getClassLoader());
        return bundle;
    }

    public void zzn(View view)
    {
        zzavl.zzo(view);
    }

    public void zzn(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzj(new NotifyAclUpdatedBinderCallback(zzb1), s);
    }

    public void zzo(com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzpc()).zzi(new GameMuteStatusLoadedBinderCallback(zzb1), s);
    }

    public void zzoW()
    {
        super.zzoW();
        if (zzavm)
        {
            zzavl.zzvf();
            zzavm = false;
        }
        if (!zzavp.zzatS)
        {
            zzuw();
        }
    }

    public void zzp(String s, int i)
    {
        zzavh.zzp(s, i);
    }

    public void zzq(String s, int i)
    {
        try
        {
            ((IGamesService)zzpc()).zzq(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public void zzr(String s, int i)
    {
        try
        {
            ((IGamesService)zzpc()).zzr(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public Game zzuA()
    {
        zzpb();
        this;
        JVM INSTR monitorenter ;
        Object obj = zzavk;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new GameBuffer(((IGamesService)zzpc()).zzuX());
        if (((GameBuffer) (obj)).getCount() > 0)
        {
            zzavk = (GameEntity)((GameBuffer) (obj)).get(0).freeze();
        }
        ((GameBuffer) (obj)).release();
_L1:
        this;
        JVM INSTR monitorexit ;
        return zzavk;
        Exception exception;
        exception;
        ((GameBuffer) (obj)).release();
        throw exception;
        Object obj1;
        obj1;
        zzb(((RemoteException) (obj1)));
          goto _L1
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public Intent zzuB()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuB();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zzuC()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuC();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zzuD()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuD();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zzuE()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuE();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public void zzuF()
    {
        try
        {
            ((IGamesService)zzpc()).zzF(zzavo);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zzuG()
    {
        try
        {
            ((IGamesService)zzpc()).zzG(zzavo);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zzuH()
    {
        try
        {
            ((IGamesService)zzpc()).zzI(zzavo);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zzuI()
    {
        try
        {
            ((IGamesService)zzpc()).zzH(zzavo);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public Intent zzuJ()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuJ();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zzuK()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuK();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public int zzuL()
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzuL();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return 4368;
        }
        return i;
    }

    public String zzuM()
    {
        String s;
        try
        {
            s = ((IGamesService)zzpc()).zzuM();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return s;
    }

    public int zzuN()
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzuN();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public Intent zzuO()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzpc()).zzuO();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public int zzuP()
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzuP();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public int zzuQ()
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzuQ();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public int zzuR()
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzuR();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public int zzuS()
    {
        int i;
        try
        {
            i = ((IGamesService)zzpc()).zzuS();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public void zzuT()
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ((IGamesService)zzpc()).zzuT();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb(remoteexception);
        return;
    }

    public void zzuw()
    {
        try
        {
            PopupLocationInfoBinderCallbacks popuplocationinfobindercallbacks = new PopupLocationInfoBinderCallbacks(zzavl);
            ((IGamesService)zzpc()).zza(popuplocationinfobindercallbacks, zzavo);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public String zzux()
    {
        String s;
        try
        {
            s = ((IGamesService)zzpc()).zzux();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return s;
    }

    public String zzuy()
    {
        if (zzavj != null)
        {
            return zzavj.getPlayerId();
        }
        String s;
        try
        {
            s = ((IGamesService)zzpc()).zzuy();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return s;
    }

    public Player zzuz()
    {
        zzpb();
        this;
        JVM INSTR monitorenter ;
        Object obj = zzavj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new PlayerBuffer(((IGamesService)zzpc()).zzuV());
        if (((PlayerBuffer) (obj)).getCount() > 0)
        {
            zzavj = (PlayerEntity)((PlayerBuffer) (obj)).get(0).freeze();
        }
        ((PlayerBuffer) (obj)).release();
_L1:
        this;
        JVM INSTR monitorexit ;
        return zzavj;
        Exception exception;
        exception;
        ((PlayerBuffer) (obj)).release();
        throw exception;
        Object obj1;
        obj1;
        zzb(((RemoteException) (obj1)));
          goto _L1
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }
}
