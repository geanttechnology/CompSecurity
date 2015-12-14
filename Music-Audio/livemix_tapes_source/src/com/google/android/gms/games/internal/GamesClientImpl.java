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
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.api.zzl;
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

        private final ArrayList zzasT = new ArrayList();

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            zza(roomstatusupdatelistener, room, zzasT);
        }

        protected abstract void zza(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist);

        AbstractPeerStatusNotifier(DataHolder dataholder, String as[])
        {
            super(dataholder);
            int i = 0;
            for (int j = as.length; i < j; i++)
            {
                zzasT.add(as[i]);
            }

        }
    }

    private static abstract class AbstractRoomNotifier extends zzd
    {

        protected void zza(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            zza(roomupdatelistener, GamesClientImpl.zzW(dataholder), dataholder.getStatusCode());
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

    private static abstract class AbstractRoomStatusNotifier extends zzd
    {

        protected void zza(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            zza(roomstatusupdatelistener, GamesClientImpl.zzW(dataholder));
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

        private final Quest zzasU = null;

        public Quest getQuest()
        {
            return zzasU;
        }

        AcceptQuestResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new QuestBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzasU = new QuestEntity((Quest)dataholder.get(0));
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

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzg(int i, String s)
        {
            zzQz.zzn(new UpdateAchievementResultImpl(i, s));
        }

        AchievementUpdatedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzf(DataHolder dataholder)
        {
            zzQz.zzn(new LoadAchievementsResultImpl(dataholder));
        }

        AchievementsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzasV;

        public void zza(DataHolder adataholder[])
        {
            zzasV.zzn(new LoadAppContentsResultImpl(adataholder));
        }

        public AppContentLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzasV = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class CancelMatchResultImpl
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    {

        private final Status zzQA;
        private final String zzasW;

        public String getMatchId()
        {
            return zzasW;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        CancelMatchResultImpl(Status status, String s)
        {
            zzQA = status;
            zzasW = s;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
    {

        private final Quest zzasU;
        private final Milestone zzasX = null;

        public Milestone getMilestone()
        {
            return zzasX;
        }

        public Quest getQuest()
        {
            return zzasU;
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
            zzasU = new QuestEntity((Quest)dataholder.get(0));
            list = zzasU.zzuZ();
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
            zzasX = (Milestone)list.get(i);
            dataholder.release();
            return;
            i++;
            if (true) goto _L4; else goto _L3
_L3:
_L6:
            dataholder.release();
            return;
_L2:
            zzasX = null;
            zzasU = null;
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

        private final SnapshotMetadata zzasY = null;

        public SnapshotMetadata getSnapshotMetadata()
        {
            return zzasY;
        }

        CommitSnapshotResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new SnapshotMetadataBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzasY = new SnapshotMetadataEntity(dataholder.get(0));
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

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzG(DataHolder dataholder)
        {
            zzQz.zzn(new ContactSettingLoadResultImpl(dataholder));
        }

        ContactSettingsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzfJ(int i)
        {
            zzQz.zzn(GamesStatusCodes.zzfx(i));
        }

        ContactSettingsUpdatedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class DeleteSnapshotResultImpl
        implements com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
    {

        private final Status zzQA;
        private final String zzasZ;

        public String getSnapshotId()
        {
            return zzasZ;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        DeleteSnapshotResultImpl(int i, String s)
        {
            zzQA = GamesStatusCodes.zzfx(i);
            zzasZ = s;
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

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzg(DataHolder dataholder)
        {
            zzQz.zzn(new LoadEventResultImpl(dataholder));
        }

        EventsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache
    {

        final GamesClientImpl zzasS;

        protected void zzt(String s, int i)
        {
            if (zzasS.isConnected())
            {
                ((IGamesService)zzasS.zzoA()).zzq(s, i);
                return;
            }
            try
            {
                com.google.android.gms.games.internal.GamesLog.zzx("GamesClientImpl", (new StringBuilder()).append("Unable to increment event ").append(s).append(" by ").append(i).append(" because the games client is no longer connected").toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                GamesClientImpl.zza(zzasS, s);
            }
            return;
        }

        public GameClientEventIncrementCache()
        {
            zzasS = GamesClientImpl.this;
            super(getContext().getMainLooper(), 1000);
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzn(DataHolder dataholder)
        {
            zzQz.zzn(new LoadGameInstancesResultImpl(dataholder));
        }

        GameInstancesLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class GameMuteStatusChangeResultImpl
        implements com.google.android.gms.games.Notifications.GameMuteStatusChangeResult
    {

        private final Status zzQA;
        private final String zzata;
        private final boolean zzatb;

        public Status getStatus()
        {
            return zzQA;
        }

        public GameMuteStatusChangeResultImpl(int i, String s, boolean flag)
        {
            zzQA = GamesStatusCodes.zzfx(i);
            zzata = s;
            zzatb = flag;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(int i, String s, boolean flag)
        {
            zzQz.zzn(new GameMuteStatusChangeResultImpl(i, s, flag));
        }

        GameMuteStatusChangedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class GameMuteStatusLoadResultImpl
        implements com.google.android.gms.games.Notifications.GameMuteStatusLoadResult
    {

        private final Status zzQA;
        private final String zzata;
        private final boolean zzatb;

        public Status getStatus()
        {
            return zzQA;
        }

        public GameMuteStatusLoadResultImpl(DataHolder dataholder)
        {
            zzQA = GamesStatusCodes.zzfx(dataholder.getStatusCode());
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzata = dataholder.zzd("external_game_id", 0, 0);
            zzatb = dataholder.zze("muted", 0, 0);
_L4:
            dataholder.close();
            return;
_L2:
            zzata = null;
            zzatb = false;
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

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzE(DataHolder dataholder)
        {
            zzQz.zzn(new GameMuteStatusLoadResultImpl(dataholder));
        }

        GameMuteStatusLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzo(DataHolder dataholder)
        {
            zzQz.zzn(new LoadGameSearchSuggestionsResultImpl(dataholder));
        }

        GameSearchSuggestionsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static abstract class GamesDataHolderResult extends zze
    {

        protected GamesDataHolderResult(DataHolder dataholder)
        {
            super(dataholder, GamesStatusCodes.zzfx(dataholder.getStatusCode()));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzl(DataHolder dataholder)
        {
            zzQz.zzn(new LoadGamesResultImpl(dataholder));
        }

        GamesLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class InboxCountResultImpl
        implements com.google.android.gms.games.Notifications.InboxCountResult
    {

        private final Status zzQA;
        private final Bundle zzatc;

        public Status getStatus()
        {
            return zzQA;
        }

        InboxCountResultImpl(Status status, Bundle bundle)
        {
            zzQA = status;
            zzatc = bundle;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzg(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfx(i);
            zzQz.zzn(new InboxCountResultImpl(status, bundle));
        }

        InboxCountsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
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

        private final zzl zzaiL;

        public void onInvitationRemoved(String s)
        {
            zzaiL.zza(new InvitationRemovedNotifier(s));
        }

        public void zzq(DataHolder dataholder)
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
                zzaiL.zza(new InvitationReceivedNotifier(dataholder));
            }
            return;
            dataholder;
            invitationbuffer.release();
            throw dataholder;
        }

        InvitationReceivedBinderCallback(zzl zzl1)
        {
            zzaiL = zzl1;
        }
    }

    private static final class InvitationReceivedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final Invitation zzatd;

        public void zza(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationReceived(zzatd);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnInvitationReceivedListener)obj);
        }

        InvitationReceivedNotifier(Invitation invitation)
        {
            zzatd = invitation;
        }
    }

    private static final class InvitationRemovedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final String zzate;

        public void zza(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationRemoved(zzate);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnInvitationReceivedListener)obj);
        }

        InvitationRemovedNotifier(String s)
        {
            zzate = s;
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzp(DataHolder dataholder)
        {
            zzQz.zzn(new LoadInvitationsResultImpl(dataholder));
        }

        InvitationsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
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

        private final LeaderboardBuffer zzatf;

        public LeaderboardBuffer getLeaderboards()
        {
            return zzatf;
        }

        LeaderboardMetadataResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatf = new LeaderboardBuffer(dataholder);
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(DataHolder dataholder, DataHolder dataholder1)
        {
            zzQz.zzn(new LoadScoresResultImpl(dataholder, dataholder1));
        }

        LeaderboardScoresLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzh(DataHolder dataholder)
        {
            zzQz.zzn(new LeaderboardMetadataResultImpl(dataholder));
        }

        LeaderboardsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
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
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final int zzWu;
        private final String zzatg;

        public void zza(RoomUpdateListener roomupdatelistener)
        {
            roomupdatelistener.onLeftRoom(zzWu, zzatg);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((RoomUpdateListener)obj);
        }

        LeftRoomNotifier(int i, String s)
        {
            zzWu = i;
            zzatg = s;
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
    {

        private final AchievementBuffer zzath;

        public AchievementBuffer getAchievements()
        {
            return zzath;
        }

        LoadAchievementsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzath = new AchievementBuffer(dataholder);
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

        private final ArrayList zzati;

        LoadAppContentsResultImpl(DataHolder adataholder[])
        {
            super(adataholder[0]);
            zzati = new ArrayList(Arrays.asList(adataholder));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.event.Events.LoadEventsResult
    {

        private final EventBuffer zzatj;

        public EventBuffer getEvents()
        {
            return zzatj;
        }

        LoadEventResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatj = new EventBuffer(dataholder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult
    {

        private final GameInstanceBuffer zzatk;

        LoadGameInstancesResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatk = new GameInstanceBuffer(dataholder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult
    {

        private final GameSearchSuggestionBuffer zzatl;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatl = new GameSearchSuggestionBuffer(dataholder);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.GamesMetadata.LoadGamesResult
    {

        private final GameBuffer zzatm;

        public GameBuffer getGames()
        {
            return zzatm;
        }

        LoadGamesResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatm = new GameBuffer(dataholder);
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
    {

        private final InvitationBuffer zzatn;

        public InvitationBuffer getInvitations()
        {
            return zzatn;
        }

        LoadInvitationsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatn = new InvitationBuffer(dataholder);
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

        private final Status zzQA;
        private final LoadMatchesResponse zzato;

        public LoadMatchesResponse getMatches()
        {
            return zzato;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public void release()
        {
            zzato.release();
        }

        LoadMatchesResultImpl(Status status, Bundle bundle)
        {
            zzQA = status;
            zzato = new LoadMatchesResponse(bundle);
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
    {

        private final LeaderboardScoreEntity zzatp = null;

        public LeaderboardScore getScore()
        {
            return zzatp;
        }

        LoadPlayerScoreResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new LeaderboardScoreBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzatp = (LeaderboardScoreEntity)dataholder.get(0).freeze();
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

        private final PlayerStats zzatq = null;

        LoadPlayerStatsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new PlayerStatsBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzatq = new PlayerStatsEntity(dataholder.zzgp(0));
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

        private final PlayerBuffer zzatr;

        public PlayerBuffer getPlayers()
        {
            return zzatr;
        }

        LoadPlayersResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzatr = new PlayerBuffer(dataholder);
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.Players.LoadProfileSettingsResult
    {

        private final boolean zzasG;
        private final boolean zzats;

        public Status getStatus()
        {
            return zzQA;
        }

        public boolean isProfileVisible()
        {
            return zzasG;
        }

        public boolean isVisibilityExplicitlySet()
        {
            return zzats;
        }

        LoadProfileSettingsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            int i = dataholder.zzbo(0);
            zzasG = dataholder.zze("profile_visible", 0, i);
            zzats = dataholder.zze("profile_visibility_explicitly_set", 0, i);
_L4:
            dataholder.close();
            return;
_L2:
            zzasG = true;
            zzats = false;
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

        private final DataHolder zzYX;

        public QuestBuffer getQuests()
        {
            return new QuestBuffer(zzYX);
        }

        LoadQuestsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzYX = dataholder;
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

        private final Status zzQA;
        private final Bundle zzatt;

        public GameRequestBuffer getRequests(int i)
        {
            String s = RequestType.zzfQ(i);
            if (!zzatt.containsKey(s))
            {
                return null;
            } else
            {
                return new GameRequestBuffer((DataHolder)zzatt.get(s));
            }
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public void release()
        {
            Iterator iterator = zzatt.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (String)iterator.next();
                obj = (DataHolder)zzatt.getParcelable(((String) (obj)));
                if (obj != null)
                {
                    ((DataHolder) (obj)).close();
                }
            } while (true);
        }

        LoadRequestsResultImpl(Status status, Bundle bundle)
        {
            zzQA = status;
            zzatt = bundle;
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
    {

        private final LeaderboardEntity zzatu = null;
        private final LeaderboardScoreBuffer zzatv;

        public Leaderboard getLeaderboard()
        {
            return zzatu;
        }

        public LeaderboardScoreBuffer getScores()
        {
            return zzatv;
        }

        LoadScoresResultImpl(DataHolder dataholder, DataHolder dataholder1)
        {
            super(dataholder1);
            dataholder = new LeaderboardBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzatu = (LeaderboardEntity)((Leaderboard)dataholder.get(0)).freeze();
_L4:
            dataholder.release();
            zzatv = new LeaderboardScoreBuffer(dataholder1);
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
            return new SnapshotMetadataBuffer(zzYX);
        }

        LoadSnapshotsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl
        implements com.google.android.gms.games.Players.LoadXpForGameCategoriesResult
    {

        private final Status zzQA;
        private final List zzatw;
        private final Bundle zzatx;

        public Status getStatus()
        {
            return zzQA;
        }

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle)
        {
            zzQA = status;
            zzatw = bundle.getStringArrayList("game_category_list");
            zzatx = bundle;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.Players.LoadXpStreamResult
    {

        private final ExperienceEventBuffer zzaty;

        LoadXpStreamResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzaty = new ExperienceEventBuffer(dataholder);
        }
    }

    private static final class MatchRemovedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final String zzatz;

        public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchRemoved(zzatz);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        MatchRemovedNotifier(String s)
        {
            zzatz = s;
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks
    {

        private final zzl zzaiL;

        public void onTurnBasedMatchRemoved(String s)
        {
            zzaiL.zza(new MatchRemovedNotifier(s));
        }

        public void zzw(DataHolder dataholder)
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
                zzaiL.zza(new MatchUpdateReceivedNotifier(dataholder));
            }
            return;
            dataholder;
            turnbasedmatchbuffer.release();
            throw dataholder;
        }

        MatchUpdateReceivedBinderCallback(zzl zzl1)
        {
            zzaiL = zzl1;
        }
    }

    private static final class MatchUpdateReceivedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final TurnBasedMatch zzatA;

        public void zza(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchReceived(zzatA);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        MatchUpdateReceivedNotifier(TurnBasedMatch turnbasedmatch)
        {
            zzatA = turnbasedmatch;
        }
    }

    private static final class MessageReceivedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final RealTimeMessage zzatB;

        public void zza(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            realtimemessagereceivedlistener.onRealTimeMessageReceived(zzatB);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((RealTimeMessageReceivedListener)obj);
        }

        MessageReceivedNotifier(RealTimeMessage realtimemessage)
        {
            zzatB = realtimemessage;
        }
    }

    private static final class NearbyPlayerDetectedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final Player zzatC;

        public void zza(OnNearbyPlayerDetectedListener onnearbyplayerdetectedlistener)
        {
            onnearbyplayerdetectedlistener.zza(zzatC);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnNearbyPlayerDetectedListener)obj);
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzF(DataHolder dataholder)
        {
            zzQz.zzn(new LoadAclResultImpl(dataholder));
        }

        NotifyAclLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzfI(int i)
        {
            zzQz.zzn(GamesStatusCodes.zzfx(i));
        }

        NotifyAclUpdatedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
    {

        private final Snapshot zzatD;
        private final String zzatE;
        private final Snapshot zzatF;
        private final Contents zzatG;
        private final SnapshotContents zzatH;

        public String getConflictId()
        {
            return zzatE;
        }

        public Snapshot getConflictingSnapshot()
        {
            return zzatF;
        }

        public SnapshotContents getResolutionSnapshotContents()
        {
            return zzatH;
        }

        public Snapshot getSnapshot()
        {
            return zzatD;
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
            zzatD = null;
            zzatF = null;
_L3:
            snapshotmetadatabuffer.release();
            zzatE = s;
            zzatG = contents2;
            zzatH = new SnapshotContentsEntity(contents2);
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
            com.google.android.gms.common.internal.zzb.zzY(flag);
            zzatD = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
            zzatF = null;
              goto _L3
            dataholder;
            snapshotmetadatabuffer.release();
            throw dataholder;
            zzatD = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
            zzatF = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(1)), new SnapshotContentsEntity(contents1));
              goto _L3
        }
    }

    private static final class P2PConnectedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final String zzatI;

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            roomstatusupdatelistener.onP2PConnected(zzatI);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((RoomStatusUpdateListener)obj);
        }

        P2PConnectedNotifier(String s)
        {
            zzatI = s;
        }
    }

    private static final class P2PDisconnectedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final String zzatI;

        public void zza(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            roomstatusupdatelistener.onP2PDisconnected(zzatI);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((RoomStatusUpdateListener)obj);
        }

        P2PDisconnectedNotifier(String s)
        {
            zzatI = s;
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

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzH(DataHolder dataholder)
        {
            zzQz.zzn(new LoadPlayerScoreResultImpl(dataholder));
        }

        PlayerLeaderboardScoreLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzU(DataHolder dataholder)
        {
            zzQz.zzn(new LoadPlayerStatsResultImpl(dataholder));
        }

        public PlayerStatsLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzf(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfx(i);
            zzQz.zzn(new LoadXpForGameCategoriesResultImpl(status, bundle));
        }

        PlayerXpForGameCategoriesLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzS(DataHolder dataholder)
        {
            zzQz.zzn(new LoadXpStreamResultImpl(dataholder));
        }

        PlayerXpStreamLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzj(DataHolder dataholder)
        {
            zzQz.zzn(new LoadPlayersResultImpl(dataholder));
        }

        public void zzk(DataHolder dataholder)
        {
            zzQz.zzn(new LoadPlayersResultImpl(dataholder));
        }

        PlayersLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient
    {

        private final PopupManager zzasN;

        public PopupLocationInfoParcelable zztC()
        {
            return new PopupLocationInfoParcelable(zzasN.zzus());
        }

        public PopupLocationInfoBinderCallbacks(PopupManager popupmanager)
        {
            zzasN = popupmanager;
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzT(DataHolder dataholder)
        {
            zzQz.zzn(new LoadProfileSettingsResultImpl(dataholder));
        }

        ProfileSettingsLoadedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzfK(int i)
        {
            zzQz.zzn(GamesStatusCodes.zzfx(i));
        }

        ProfileSettingsUpdatedBinderCallback(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatJ;

        public void zzO(DataHolder dataholder)
        {
            zzatJ.zzn(new AcceptQuestResultImpl(dataholder));
        }

        public QuestAcceptedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatJ = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class QuestCompletedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final Quest zzasU;

        public void zza(QuestUpdateListener questupdatelistener)
        {
            questupdatelistener.onQuestCompleted(zzasU);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((QuestUpdateListener)obj);
        }

        QuestCompletedNotifier(Quest quest)
        {
            zzasU = quest;
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatK;
        private final String zzatL;

        public void zzN(DataHolder dataholder)
        {
            zzatK.zzn(new ClaimMilestoneResultImpl(dataholder, zzatL));
        }

        public QuestMilestoneClaimBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        {
            zzatK = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
            zzatL = (String)zzx.zzb(s, "MilestoneId must not be null");
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks
    {

        private final zzl zzaiL;

        private Quest zzX(DataHolder dataholder)
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

        public void zzP(DataHolder dataholder)
        {
            dataholder = zzX(dataholder);
            if (dataholder != null)
            {
                zzaiL.zza(new QuestCompletedNotifier(dataholder));
            }
        }

        QuestUpdateBinderCallback(zzl zzl1)
        {
            zzaiL = zzl1;
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatM;

        public void zzR(DataHolder dataholder)
        {
            zzatM.zzn(new LoadQuestsResultImpl(dataholder));
        }

        public QuestsLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatM = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RealTimeMessageSentNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final int zzWu;
        private final String zzatN;
        private final int zzatO;

        public void zza(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            if (reliablemessagesentcallback != null)
            {
                reliablemessagesentcallback.onRealTimeMessageSent(zzWu, zzatO, zzatN);
            }
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback)obj);
        }

        RealTimeMessageSentNotifier(int i, int j, String s)
        {
            zzWu = i;
            zzatO = j;
            zzatN = s;
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks
    {

        final zzl zzatP;

        public void zzb(int i, int j, String s)
        {
            if (zzatP != null)
            {
                zzatP.zza(new RealTimeMessageSentNotifier(i, j, s));
            }
        }

        public RealTimeReliableMessageBinderCallbacks(zzl zzl1)
        {
            zzatP = zzl1;
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks
    {

        private final zzl zzaiL;

        public void onRequestRemoved(String s)
        {
            zzaiL.zza(new RequestRemovedNotifier(s));
        }

        public void zzr(DataHolder dataholder)
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
                zzaiL.zza(new RequestReceivedNotifier(dataholder));
            }
            return;
            dataholder;
            gamerequestbuffer.release();
            throw dataholder;
        }

        RequestReceivedBinderCallback(zzl zzl1)
        {
            zzaiL = zzl1;
        }
    }

    private static final class RequestReceivedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final GameRequest zzatQ;

        public void zza(OnRequestReceivedListener onrequestreceivedlistener)
        {
            onrequestreceivedlistener.onRequestReceived(zzatQ);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnRequestReceivedListener)obj);
        }

        RequestReceivedNotifier(GameRequest gamerequest)
        {
            zzatQ = gamerequest;
        }
    }

    private static final class RequestRemovedNotifier
        implements com.google.android.gms.common.api.zzl.zzb
    {

        private final String zzBm;

        public void zza(OnRequestReceivedListener onrequestreceivedlistener)
        {
            onrequestreceivedlistener.onRequestRemoved(zzBm);
        }

        public void zznh()
        {
        }

        public void zzo(Object obj)
        {
            zza((OnRequestReceivedListener)obj);
        }

        RequestRemovedNotifier(String s)
        {
            zzBm = s;
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatR;

        public void zzJ(DataHolder dataholder)
        {
            zzatR.zzn(new SendRequestResultImpl(dataholder));
        }

        public RequestSentBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatR = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatS;

        public void zzK(DataHolder dataholder)
        {
            zzatS.zzn(new LoadRequestSummariesResultImpl(dataholder));
        }

        public RequestSummariesLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatS = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatT;

        public void zzd(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfx(i);
            zzatT.zzn(new LoadRequestsResultImpl(status, bundle));
        }

        public RequestsLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatT = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatU;

        public void zzI(DataHolder dataholder)
        {
            zzatU.zzn(new UpdateRequestsResultImpl(dataholder));
        }

        public RequestsUpdatedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatU = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
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

        private final zzl zzatV;
        private final zzl zzatW;
        private final zzl zzatX;

        public void onLeftRoom(int i, String s)
        {
            zzatV.zza(new LeftRoomNotifier(i, s));
        }

        public void onP2PConnected(String s)
        {
            if (zzatW != null)
            {
                zzatW.zza(new P2PConnectedNotifier(s));
            }
        }

        public void onP2PDisconnected(String s)
        {
            if (zzatW != null)
            {
                zzatW.zza(new P2PDisconnectedNotifier(s));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage realtimemessage)
        {
            if (zzatX != null)
            {
                zzatX.zza(new MessageReceivedNotifier(realtimemessage));
            }
        }

        public void zzA(DataHolder dataholder)
        {
            if (zzatW != null)
            {
                zzatW.zza(new RoomAutoMatchingNotifier(dataholder));
            }
        }

        public void zzB(DataHolder dataholder)
        {
            zzatV.zza(new RoomConnectedNotifier(dataholder));
        }

        public void zzC(DataHolder dataholder)
        {
            if (zzatW != null)
            {
                zzatW.zza(new ConnectedToRoomNotifier(dataholder));
            }
        }

        public void zzD(DataHolder dataholder)
        {
            if (zzatW != null)
            {
                zzatW.zza(new DisconnectedFromRoomNotifier(dataholder));
            }
        }

        public void zza(DataHolder dataholder, String as[])
        {
            if (zzatW != null)
            {
                zzatW.zza(new PeerInvitedToRoomNotifier(dataholder, as));
            }
        }

        public void zzb(DataHolder dataholder, String as[])
        {
            if (zzatW != null)
            {
                zzatW.zza(new PeerJoinedRoomNotifier(dataholder, as));
            }
        }

        public void zzc(DataHolder dataholder, String as[])
        {
            if (zzatW != null)
            {
                zzatW.zza(new PeerLeftRoomNotifier(dataholder, as));
            }
        }

        public void zzd(DataHolder dataholder, String as[])
        {
            if (zzatW != null)
            {
                zzatW.zza(new PeerDeclinedNotifier(dataholder, as));
            }
        }

        public void zze(DataHolder dataholder, String as[])
        {
            if (zzatW != null)
            {
                zzatW.zza(new PeerConnectedNotifier(dataholder, as));
            }
        }

        public void zzf(DataHolder dataholder, String as[])
        {
            if (zzatW != null)
            {
                zzatW.zza(new PeerDisconnectedNotifier(dataholder, as));
            }
        }

        public void zzx(DataHolder dataholder)
        {
            zzatV.zza(new RoomCreatedNotifier(dataholder));
        }

        public void zzy(DataHolder dataholder)
        {
            zzatV.zza(new JoinedRoomNotifier(dataholder));
        }

        public void zzz(DataHolder dataholder)
        {
            if (zzatW != null)
            {
                zzatW.zza(new RoomConnectingNotifier(dataholder));
            }
        }

        public RoomBinderCallbacks(zzl zzl1)
        {
            zzatV = (zzl)com.google.android.gms.common.internal.zzx.zzb(zzl1, "Callbacks must not be null");
            zzatW = null;
            zzatX = null;
        }

        public RoomBinderCallbacks(zzl zzl1, zzl zzl2, zzl zzl3)
        {
            zzatV = (zzl)com.google.android.gms.common.internal.zzx.zzb(zzl1, "Callbacks must not be null");
            zzatW = zzl2;
            zzatX = zzl3;
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

        private final GameRequest zzatQ = null;

        SendRequestResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new GameRequestBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzatQ = (GameRequest)((GameRequest)dataholder.get(0)).freeze();
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

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzll()
        {
            Status status = GamesStatusCodes.zzfx(0);
            zzQz.zzn(status);
        }

        public SignOutCompleteBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatY;

        public void zzM(DataHolder dataholder)
        {
            zzatY.zzn(new CommitSnapshotResultImpl(dataholder));
        }

        public SnapshotCommittedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatY = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzi(int i, String s)
        {
            zzQz.zzn(new DeleteSnapshotResultImpl(i, s));
        }

        public SnapshotDeletedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzatZ;

        public void zza(DataHolder dataholder, Contents contents)
        {
            zzatZ.zzn(new OpenSnapshotResultImpl(dataholder, contents));
        }

        public void zza(DataHolder dataholder, String s, Contents contents, Contents contents1, Contents contents2)
        {
            zzatZ.zzn(new OpenSnapshotResultImpl(dataholder, s, contents, contents1, contents2));
        }

        public SnapshotOpenedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzatZ = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaua;

        public void zzL(DataHolder dataholder)
        {
            zzaua.zzn(new LoadSnapshotsResultImpl(dataholder));
        }

        public SnapshotsLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaua = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zzi(DataHolder dataholder)
        {
            zzQz.zzn(new SubmitScoreResultImpl(dataholder));
        }

        public SubmitScoreBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult
        implements com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
    {

        private final ScoreSubmissionData zzaub;

        public ScoreSubmissionData getScoreData()
        {
            return zzaub;
        }

        public SubmitScoreResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzaub = new ScoreSubmissionData(dataholder);
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

        private final com.google.android.gms.common.api.zzc.zzb zzauc;

        public void zzh(int i, String s)
        {
            Status status = GamesStatusCodes.zzfx(i);
            zzauc.zzn(new CancelMatchResultImpl(status, s));
        }

        public TurnBasedMatchCanceledBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzauc = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaud;

        public void zzt(DataHolder dataholder)
        {
            zzaud.zzn(new InitiateMatchResultImpl(dataholder));
        }

        public TurnBasedMatchInitiatedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaud = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzaue;

        public void zzv(DataHolder dataholder)
        {
            zzaue.zzn(new LeaveMatchResultImpl(dataholder));
        }

        public TurnBasedMatchLeftBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaue = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzauf;

        public void zzs(DataHolder dataholder)
        {
            zzauf.zzn(new LoadMatchResultImpl(dataholder));
        }

        public TurnBasedMatchLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzauf = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult
    {

        final TurnBasedMatch zzatA = null;

        public TurnBasedMatch getMatch()
        {
            return zzatA;
        }

        TurnBasedMatchResult(DataHolder dataholder)
        {
            super(dataholder);
            dataholder = new TurnBasedMatchBuffer(dataholder);
            if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
            zzatA = (TurnBasedMatch)((TurnBasedMatch)dataholder.get(0)).freeze();
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

        private final com.google.android.gms.common.api.zzc.zzb zzaug;

        public void zzu(DataHolder dataholder)
        {
            zzaug.zzn(new UpdateMatchResultImpl(dataholder));
        }

        public TurnBasedMatchUpdatedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaug = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks
    {

        private final com.google.android.gms.common.api.zzc.zzb zzauh;

        public void zzc(int i, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = GamesStatusCodes.zzfx(i);
            zzauh.zzn(new LoadMatchesResultImpl(status, bundle));
        }

        public TurnBasedMatchesLoadedBinderCallbacks(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzauh = (com.google.android.gms.common.api.zzc.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }

    private static final class UpdateAchievementResultImpl
        implements com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    {

        private final Status zzQA;
        private final String zzarS;

        public String getAchievementId()
        {
            return zzarS;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        UpdateAchievementResultImpl(int i, String s)
        {
            zzQA = GamesStatusCodes.zzfx(i);
            zzarS = s;
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

        private final RequestUpdateOutcomes zzaui;

        public Set getRequestIds()
        {
            return zzaui.getRequestIds();
        }

        public int getRequestOutcome(String s)
        {
            return zzaui.getRequestOutcome(s);
        }

        UpdateRequestsResultImpl(DataHolder dataholder)
        {
            super(dataholder);
            zzaui = RequestUpdateOutcomes.zzY(dataholder);
        }
    }


    EventIncrementManager zzasJ;
    private final String zzasK;
    private PlayerEntity zzasL;
    private GameEntity zzasM;
    private final PopupManager zzasN;
    private boolean zzasO;
    private final Binder zzasP = new Binder();
    private final long zzasQ = (long)hashCode();
    private final com.google.android.gms.games.Games.GamesOptions zzasR;

    public GamesClientImpl(Context context, Looper looper, zzf zzf1, com.google.android.gms.games.Games.GamesOptions gamesoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 1, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzasJ = new EventIncrementManager() {

            final GamesClientImpl zzasS;

            public EventIncrementCache zzue()
            {
                return zzasS. new GameClientEventIncrementCache();
            }

            
            {
                zzasS = GamesClientImpl.this;
                super();
            }
        };
        zzasO = false;
        zzasK = zzf1.zzol();
        zzasN = PopupManager.zza(this, zzf1.zzoh());
        zzm(zzf1.zzon());
        zzasR = gamesoptions;
    }

    private static Room zzV(DataHolder dataholder)
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

    static Room zzW(DataHolder dataholder)
    {
        return zzV(dataholder);
    }

    static void zza(GamesClientImpl gamesclientimpl, RemoteException remoteexception)
    {
        gamesclientimpl.zzb(remoteexception);
    }

    private void zzb(RemoteException remoteexception)
    {
        com.google.android.gms.games.internal.GamesLog.zzb("GamesClientImpl", "service died", remoteexception);
    }

    private void zztF()
    {
        zzasL = null;
        zzasM = null;
    }

    public void disconnect()
    {
        zzasO = false;
        if (isConnected())
        {
            try
            {
                IGamesService igamesservice = (IGamesService)zzoA();
                igamesservice.zzud();
                zzasJ.flush();
                igamesservice.zzE(zzasQ);
            }
            catch (RemoteException remoteexception)
            {
                GamesLog.zzw("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        super.onConnectionFailed(connectionresult);
        zzasO = false;
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzbN(ibinder);
    }

    public int zza(zzl zzl1, byte abyte0[], String s, String s1)
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zza(new RealTimeReliableMessageBinderCallbacks(zzl1), abyte0, s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(zzl1);
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
            i = ((IGamesService)zzoA()).zzb(abyte0, s, as);
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
            abyte0 = ((IGamesService)zzoA()).zza(i, abyte0, j, s);
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
            playerentity = ((IGamesService)zzoA()).zza(playerentity);
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
            room = ((IGamesService)zzoA()).zza((RoomEntity)room.freeze(), i);
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
            s = ((IGamesService)zzoA()).zza(s, flag, flag1, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
            return null;
        }
        return s;
    }

    protected Set zza(Set set)
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

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (i == 0 && bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/games/internal/GamesClientImpl.getClassLoader());
            zzasO = bundle.getBoolean("show_welcome_popup");
            zzasL = (PlayerEntity)bundle.getParcelable("com.google.android.gms.games.current_player");
            zzasM = (GameEntity)bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, ibinder, bundle, j);
    }

    public void zza(IBinder ibinder, Bundle bundle)
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        ((IGamesService)zzoA()).zza(ibinder, bundle);
        return;
        ibinder;
        zzb(ibinder);
        return;
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza1)
    {
        zztF();
        super.zza(zza1);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, int j, int k)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new RequestsLoadedBinderCallbacks(zzb1), i, j, k);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, String s, String as[], boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new AppContentLoadedBinderCallbacks(zzb1), i, s, as, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int i, int ai[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzb1), i, ai);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, LeaderboardScoreBuffer leaderboardscorebuffer, int i, int j)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new LeaderboardScoresLoadedBinderCallback(zzb1), leaderboardscorebuffer.zzuR().asBundle(), i, j);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, TurnBasedMatchConfig turnbasedmatchconfig)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), turnbasedmatchconfig.getVariant(), turnbasedmatchconfig.zzuX(), turnbasedmatchconfig.getInvitedPlayerIds(), turnbasedmatchconfig.getAutoMatchCriteria());
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, Snapshot snapshot, SnapshotMetadataChange snapshotmetadatachange)
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
        obj = snapshotmetadatachange.zzvc();
        if (obj != null)
        {
            ((BitmapTeleporter) (obj)).zzc(getContext().getCacheDir());
        }
        obj = snapshotcontents.zzqh();
        snapshotcontents.close();
        ((IGamesService)zzoA()).zza(new SnapshotCommittedBinderCallbacks(zzb1), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)snapshotmetadatachange, ((Contents) (obj)));
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzoA()).zza(zzb1, s, zzasN.zzur(), zzasN.zzuq());
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzoA()).zza(zzb1, s, i, zzasN.zzur(), zzasN.zzuq());
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new LeaderboardScoresLoadedBinderCallback(zzb1), s, i, j, k, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i, boolean flag, boolean flag1)
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
            ((IGamesService)zzoA()).zzd(new PlayersLoadedBinderCallback(zzb1), s, i, flag, flag1);
            break;
        }
        return;
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i, int ai[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzb1), s, i, ai);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, long l, String s1)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new SubmitScoreBinderCallbacks(zzb1);
        }
        ((IGamesService)zzoA()).zza(zzb1, s, l, s1);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new TurnBasedMatchLeftBinderCallbacks(zzb1), s, s1);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int i, int j)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(zzb1), s, s1, i, j);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int i, int j, int k)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new RequestsLoadedBinderCallbacks(zzb1), s, s1, i, j, k);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new LeaderboardScoresLoadedBinderCallback(zzb1), s, s1, i, j, k, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int i, boolean flag, boolean flag1)
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
            ((IGamesService)zzoA()).zza(new PlayersLoadedBinderCallback(zzb1), s, s1, i, flag, flag1);
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

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, SnapshotMetadataChange snapshotmetadatachange, SnapshotContents snapshotcontents)
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
        obj = snapshotmetadatachange.zzvc();
        if (obj != null)
        {
            ((BitmapTeleporter) (obj)).zzc(getContext().getCacheDir());
        }
        obj = snapshotcontents.zzqh();
        snapshotcontents.close();
        ((IGamesService)zzoA()).zza(new SnapshotOpenedBinderCallbacks(zzb1), s, s1, (SnapshotMetadataChangeEntity)snapshotmetadatachange, ((Contents) (obj)));
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new LeaderboardsLoadedBinderCallback(zzb1), s, s1, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, boolean flag, String as[])
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zza(new QuestsLoadedBinderCallbacks(zzb1), s, s1, as, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int ai[], int i, boolean flag)
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zza(new QuestsLoadedBinderCallbacks(zzb1), s, s1, ai, i, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new RequestsUpdatedBinderCallbacks(zzb1), s, s1, as);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzf(new PlayersLoadedBinderCallback(zzb1), s, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, boolean flag, int i)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new SnapshotOpenedBinderCallbacks(zzb1), s, flag, i);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzb1), s, abyte0, s1, aparticipantresult);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, byte abyte0[], ParticipantResult aparticipantresult[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzb1), s, abyte0, aparticipantresult);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String as[], int i, byte abyte0[], int j)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new RequestSentBinderCallbacks(zzb1), s, as, i, abyte0, j);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new PlayersLoadedBinderCallback(zzb1), flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag, Bundle bundle)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new ContactSettingsUpdatedBinderCallback(zzb1), flag, bundle);
    }

    public transient void zza(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag, String as[])
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zza(new EventsLoadedBinderCallback(zzb1), flag, as);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, int ai[], int i, boolean flag)
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zza(new QuestsLoadedBinderCallbacks(zzb1), ai, i, flag);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb zzb1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new PlayersLoadedBinderCallback(zzb1), as);
    }

    public void zza(zzl zzl1)
    {
        try
        {
            zzl1 = new InvitationReceivedBinderCallback(zzl1);
            ((IGamesService)zzoA()).zza(zzl1, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(zzl1);
        }
    }

    public void zza(zzl zzl1, zzl zzl2, zzl zzl3, RoomConfig roomconfig)
    {
        try
        {
            zzl1 = new RoomBinderCallbacks(zzl1, zzl2, zzl3);
            ((IGamesService)zzoA()).zza(zzl1, zzasP, roomconfig.getVariant(), roomconfig.getInvitedPlayerIds(), roomconfig.getAutoMatchCriteria(), false, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(zzl1);
        }
    }

    public void zza(zzl zzl1, String s)
    {
        try
        {
            ((IGamesService)zzoA()).zzc(new RoomBinderCallbacks(zzl1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(zzl1);
        }
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
        contents = snapshot.zzqh();
        snapshot.close();
        try
        {
            ((IGamesService)zzoA()).zza(contents);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Snapshot snapshot)
        {
            zzb(snapshot);
        }
    }

    public Intent zzb(int i, int j, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zzb(i, j, flag);
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
            ai = ((IGamesService)zzoA()).zzb(ai);
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            zzb(((RemoteException) (ai)));
            return null;
        }
        return ai;
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zza(new SignOutCompleteBinderCallbacks(zzb1));
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzoA()).zzb(zzb1, s, zzasN.zzur(), zzasN.zzuq());
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i)
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new AchievementUpdatedBinderCallback(zzb1);
        }
        ((IGamesService)zzoA()).zzb(zzb1, s, i, zzasN.zzur(), zzasN.zzuq());
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb1), s, i, j, k, flag);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new PlayersLoadedBinderCallback(zzb1), s, i, flag, flag1);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zzf(new QuestMilestoneClaimBinderCallbacks(zzb1, s1), s, s1);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int i, int j, int k, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb1), s, s1, i, j, k, flag);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new PlayersLoadedBinderCallback(zzb1), s, s1, i, flag, flag1);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new AchievementsLoadedBinderCallback(zzb1), s, s1, flag);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new LeaderboardsLoadedBinderCallback(zzb1), s, flag);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new LeaderboardsLoadedBinderCallback(zzb1), flag);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag, String as[])
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zza(new QuestsLoadedBinderCallbacks(zzb1), as, flag);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb zzb1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new RequestsUpdatedBinderCallbacks(zzb1), as);
    }

    public void zzb(zzl zzl1)
    {
        try
        {
            zzl1 = new MatchUpdateReceivedBinderCallback(zzl1);
            ((IGamesService)zzoA()).zzb(zzl1, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(((RemoteException) (zzl1)));
        }
    }

    public void zzb(zzl zzl1, zzl zzl2, zzl zzl3, RoomConfig roomconfig)
    {
        try
        {
            zzl1 = new RoomBinderCallbacks(zzl1, zzl2, zzl3);
            ((IGamesService)zzoA()).zza(zzl1, zzasP, roomconfig.getInvitationId(), false, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(((RemoteException) (zzl1)));
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
            intent = ((IGamesService)zzoA()).zzc(i, j, flag);
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, int i)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new InvitationsLoadedBinderCallback(zzb1), i);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new PlayerXpStreamLoadedBinderCallback(zzb1), s, i);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s, s1);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new SnapshotsLoadedBinderCallbacks(zzb1), s, s1, flag);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzd(new LeaderboardsLoadedBinderCallback(zzb1), s, flag);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new AchievementsLoadedBinderCallback(zzb1), flag);
    }

    public void zzc(com.google.android.gms.common.api.zzc.zzb zzb1, String as[])
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new RequestsUpdatedBinderCallbacks(zzb1), as);
    }

    public void zzc(zzl zzl1)
    {
        try
        {
            zzl1 = new QuestUpdateBinderCallback(zzl1);
            ((IGamesService)zzoA()).zzd(zzl1, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(zzl1);
        }
    }

    public void zzcX(String s)
    {
        try
        {
            ((IGamesService)zzoA()).zzdf(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public Intent zzcY(String s)
    {
        try
        {
            s = ((IGamesService)zzoA()).zzcY(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
            return null;
        }
        return s;
    }

    public void zzcZ(String s)
    {
        try
        {
            ((IGamesService)zzoA()).zza(s, zzasN.zzur(), zzasN.zzuq());
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
            i = ((IGamesService)zzoA()).zzb(abyte0, s, null);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzb(abyte0);
            return -1;
        }
        return i;
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, int i, boolean flag, boolean flag1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zze(new PlayersLoadedBinderCallback(zzb1), i, flag, flag1);
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s);
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzc(new PlayerXpStreamLoadedBinderCallback(zzb1), s, i);
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, String s, String s1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zze(new TurnBasedMatchInitiatedBinderCallbacks(zzb1), s, s1);
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, String s, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new GameMuteStatusChangedBinderCallback(zzb1), s, flag);
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zzf(new EventsLoadedBinderCallback(zzb1), flag);
    }

    public void zzd(zzl zzl1)
    {
        try
        {
            zzl1 = new RequestReceivedBinderCallback(zzl1);
            ((IGamesService)zzoA()).zzc(zzl1, zzasQ);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzl zzl1)
        {
            zzb(zzl1);
        }
    }

    public void zze(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzo(new TurnBasedMatchLeftBinderCallbacks(zzb1), s);
    }

    public void zze(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzb(new InvitationsLoadedBinderCallback(zzb1), s, i, false);
    }

    public void zze(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzi(new PlayerStatsLoadedBinderCallbacks(zzb1), flag);
    }

    public void zzf(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzd(new GamesLoadedBinderCallback(zzb1));
    }

    public void zzf(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzn(new TurnBasedMatchCanceledBinderCallbacks(zzb1), s);
    }

    public void zzf(com.google.android.gms.common.api.zzc.zzb zzb1, String s, int i)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zza(new RequestSummariesLoadedBinderCallbacks(zzb1), s, i);
    }

    public void zzf(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzd(new SnapshotsLoadedBinderCallbacks(zzb1), flag);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzfM(int i)
    {
        zzasN.setGravity(i);
    }

    public void zzfN(int i)
    {
        try
        {
            ((IGamesService)zzoA()).zzfN(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zzg(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzh(new NotifyAclLoadedBinderCallback(zzb1));
    }

    public void zzg(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzp(new TurnBasedMatchLoadedBinderCallbacks(zzb1), s);
    }

    public void zzg(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzg(new ProfileSettingsLoadedBinderCallback(zzb1), flag);
    }

    public void zzh(com.google.android.gms.common.api.zzc.zzb zzb1)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzt(new InboxCountsLoadedBinderCallback(zzb1), null);
    }

    public void zzh(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        zzasJ.flush();
        ((IGamesService)zzoA()).zzu(new QuestAcceptedBinderCallbacks(zzb1), s);
    }

    public void zzh(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzh(new ProfileSettingsUpdatedBinderCallback(zzb1), flag);
    }

    public void zzi(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzr(new SnapshotDeletedBinderCallbacks(zzb1), s);
    }

    public void zzi(com.google.android.gms.common.api.zzc.zzb zzb1, boolean flag)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zze(new ContactSettingsLoadedBinderCallback(zzb1), flag);
    }

    public void zzj(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzf(new GameInstancesLoadedBinderCallback(zzb1), s);
    }

    public void zzk(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzq(new GameSearchSuggestionsLoadedBinderCallback(zzb1), s);
    }

    public void zzl(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzb1), s);
    }

    protected Bundle zzli()
    {
        Object obj = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = zzasR.zzsQ();
        bundle.putString("com.google.android.gms.games.key.gamePackageName", zzasK);
        bundle.putString("com.google.android.gms.games.key.desiredLocale", ((String) (obj)));
        bundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(zzasN.zzur()));
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 0);
        obj = zzoy();
        if (((zzf) (obj)).zzoo() != null)
        {
            bundle.putBundle("com.google.android.gms.games.key.signInOptions", com.google.android.gms.signin.internal.zzi.zza(((zzf) (obj)).zzoo(), ((zzf) (obj)).zzop(), Executors.newSingleThreadExecutor()));
        }
        return bundle;
    }

    public boolean zzlm()
    {
        return true;
    }

    public void zzm(View view)
    {
        zzasN.zzn(view);
    }

    public void zzm(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzk(new InvitationsLoadedBinderCallback(zzb1), s);
    }

    public Bundle zzmw()
    {
        Bundle bundle;
        try
        {
            bundle = ((IGamesService)zzoA()).zzmw();
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

    public void zzn(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzj(new NotifyAclUpdatedBinderCallback(zzb1), s);
    }

    public void zzo(com.google.android.gms.common.api.zzc.zzb zzb1, String s)
        throws RemoteException
    {
        ((IGamesService)zzoA()).zzi(new GameMuteStatusLoadedBinderCallback(zzb1), s);
    }

    public void zzou()
    {
        super.zzou();
        if (zzasO)
        {
            zzasN.zzup();
            zzasO = false;
        }
        if (!zzasR.zzarv)
        {
            zztG();
        }
    }

    public Intent zzp(String s, int i)
    {
        try
        {
            s = ((IGamesService)zzoA()).zzw(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
            return null;
        }
        return s;
    }

    public void zzq(String s, int i)
    {
        zzasJ.zzq(s, i);
    }

    public void zzr(String s, int i)
    {
        try
        {
            ((IGamesService)zzoA()).zzr(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public void zzs(String s, int i)
    {
        try
        {
            ((IGamesService)zzoA()).zzs(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb(s);
        }
    }

    public void zztG()
    {
        try
        {
            PopupLocationInfoBinderCallbacks popuplocationinfobindercallbacks = new PopupLocationInfoBinderCallbacks(zzasN);
            ((IGamesService)zzoA()).zza(popuplocationinfobindercallbacks, zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public String zztH()
    {
        String s;
        try
        {
            s = ((IGamesService)zzoA()).zztH();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return s;
    }

    public String zztI()
    {
        if (zzasL != null)
        {
            return zzasL.getPlayerId();
        }
        String s;
        try
        {
            s = ((IGamesService)zzoA()).zztI();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return s;
    }

    public Player zztJ()
    {
        zzoz();
        this;
        JVM INSTR monitorenter ;
        Object obj = zzasL;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new PlayerBuffer(((IGamesService)zzoA()).zzuf());
        if (((PlayerBuffer) (obj)).getCount() > 0)
        {
            zzasL = (PlayerEntity)((PlayerBuffer) (obj)).get(0).freeze();
        }
        ((PlayerBuffer) (obj)).release();
_L1:
        this;
        JVM INSTR monitorexit ;
        return zzasL;
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

    public Game zztK()
    {
        zzoz();
        this;
        JVM INSTR monitorenter ;
        Object obj = zzasM;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new GameBuffer(((IGamesService)zzoA()).zzuh());
        if (((GameBuffer) (obj)).getCount() > 0)
        {
            zzasM = (GameEntity)((GameBuffer) (obj)).get(0).freeze();
        }
        ((GameBuffer) (obj)).release();
_L1:
        this;
        JVM INSTR monitorexit ;
        return zzasM;
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

    public Intent zztL()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztL();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zztM()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztM();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zztN()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztN();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zztO()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztO();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public void zztP()
    {
        try
        {
            ((IGamesService)zzoA()).zzF(zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zztQ()
    {
        try
        {
            ((IGamesService)zzoA()).zzG(zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zztR()
    {
        try
        {
            ((IGamesService)zzoA()).zzI(zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public void zztS()
    {
        try
        {
            ((IGamesService)zzoA()).zzH(zzasQ);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
        }
    }

    public Intent zztT()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztT();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public Intent zztU()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztU();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public int zztV()
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zztV();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return 4368;
        }
        return i;
    }

    public String zztW()
    {
        String s;
        try
        {
            s = ((IGamesService)zzoA()).zztW();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return s;
    }

    public int zztX()
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zztX();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public Intent zztY()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)zzoA()).zztY();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return null;
        }
        return intent;
    }

    public int zztZ()
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zztZ();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public int zzua()
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zzua();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public int zzub()
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zzub();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public int zzuc()
    {
        int i;
        try
        {
            i = ((IGamesService)zzoA()).zzuc();
        }
        catch (RemoteException remoteexception)
        {
            zzb(remoteexception);
            return -1;
        }
        return i;
    }

    public void zzud()
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ((IGamesService)zzoA()).zzud();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb(remoteexception);
        return;
    }
}
