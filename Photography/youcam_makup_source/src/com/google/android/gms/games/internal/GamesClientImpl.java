// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.android.gms.games.internal:
//            PopupManager, IGamesService, GamesLog, LibjingleNativeSocket, 
//            RealTimeSocketImpl

public final class GamesClientImpl extends hb
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private final boolean NA;
    private final int NB;
    private final boolean NC;
    private final String ND;
    EventIncrementManager Np;
    private final String Nq;
    private final Map Nr = new HashMap();
    private PlayerEntity Ns;
    private GameEntity Nt;
    private final PopupManager Nu;
    private boolean Nv;
    private boolean Nw;
    private int Nx;
    private final Binder Ny = new Binder();
    private final long Nz = (long)hashCode();
    private final String yQ;

    public GamesClientImpl(Context context, Looper looper, String s, String s1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as[], 
            int i1, View view, boolean flag, boolean flag1, int j1, boolean flag2, int k1, 
            String s2)
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, as);
        Np = new _cls1();
        Nv = false;
        Nw = false;
        Nq = s;
        yQ = (String)com.google.android.gms.internal.hm.f(s1);
        Nu = com.google.android.gms.games.internal.PopupManager.a(this, i1);
        f(view);
        Nw = flag1;
        Nx = j1;
        NA = flag;
        NC = flag2;
        NB = k1;
        ND = s2;
        registerConnectionCallbacks(this);
        registerConnectionFailedListener(this);
    }

    private Room Q(DataHolder dataholder)
    {
        RoomBuffer roombuffer;
        roombuffer = new RoomBuffer(dataholder);
        dataholder = null;
        if (roombuffer.getCount() > 0)
        {
            dataholder = (Room)((Room)roombuffer.get(0)).freeze();
        }
        roombuffer.close();
        return dataholder;
        dataholder;
        roombuffer.close();
        throw dataholder;
    }

    static Room a(GamesClientImpl gamesclientimpl, DataHolder dataholder)
    {
        return gamesclientimpl.Q(dataholder);
    }

    private RealTimeSocket aT(String s)
    {
        Object obj;
        LocalSocket localsocket;
        try
        {
            obj = ((IGamesService)ft()).bb(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.k("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        GamesLog.i("GamesClientImpl", "Created native libjingle socket.");
        obj = new LibjingleNativeSocket(((android.os.ParcelFileDescriptor) (obj)));
        Nr.put(s, obj);
        return ((RealTimeSocket) (obj));
        GamesLog.i("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
        obj = ((IGamesService)ft()).aW(s);
        if (obj == null)
        {
            return null;
        }
        localsocket = new LocalSocket();
        localsocket.connect(new LocalSocketAddress(((String) (obj))));
        obj = new RealTimeSocketImpl(localsocket, s);
        Nr.put(s, obj);
        return ((RealTimeSocket) (obj));
        s;
        GamesLog.k("GamesClientImpl", (new StringBuilder()).append("connect() call failed on socket: ").append(s.getMessage()).toString());
        return null;
    }

    private void gY()
    {
        Ns = null;
    }

    private void hv()
    {
        for (Iterator iterator = Nr.values().iterator(); iterator.hasNext();)
        {
            RealTimeSocket realtimesocket = (RealTimeSocket)iterator.next();
            try
            {
                realtimesocket.close();
            }
            catch (IOException ioexception)
            {
                GamesLog.b("GamesClientImpl", "IOException:", ioexception);
            }
        }

        Nr.clear();
    }

    public int a(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback, byte abyte0[], String s, String s1)
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).a(new RealTimeReliableMessageBinderCallbacks(reliablemessagesentcallback), abyte0, s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public int a(byte abyte0[], String s, String as[])
    {
        com.google.android.gms.internal.hm.b(as, "Participant IDs must not be null");
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).b(abyte0, s, as);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public Intent a(int i1, int j1, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).a(i1, j1, flag);
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent a(int i1, byte abyte0[], int j1, Bitmap bitmap, String s)
    {
        try
        {
            abyte0 = ((IGamesService)ft()).a(i1, abyte0, j1, s);
            com.google.android.gms.internal.hm.b(bitmap, "Must provide a non null icon");
            abyte0.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return abyte0;
    }

    public Intent a(Room room, int i1)
    {
        try
        {
            room = ((IGamesService)ft()).a((RoomEntity)room.freeze(), i1);
        }
        // Misplaced declaration of an exception variable
        catch (Room room)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return room;
    }

    public Intent a(String s, boolean flag, boolean flag1, int i1)
    {
        try
        {
            s = ((IGamesService)ft()).a(s, flag, flag1, i1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return s;
    }

    public Intent a(int ai[])
    {
        try
        {
            ai = ((IGamesService)ft()).a(ai);
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return ai;
    }

    protected void a(int i1, IBinder ibinder, Bundle bundle)
    {
        if (i1 == 0 && bundle != null)
        {
            Nv = bundle.getBoolean("show_welcome_popup");
        }
        super.a(i1, ibinder, bundle);
    }

    public void a(IBinder ibinder, Bundle bundle)
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        ((IGamesService)ft()).a(ibinder, bundle);
        return;
        ibinder;
        GamesLog.j("GamesClientImpl", "service died");
        return;
    }

    public void a(com.google.android.gms.common.api.a.d d1, int i1, int j1, int k1)
    {
        try
        {
            ((IGamesService)ft()).a(new RequestsLoadedBinderCallbacks(d1), i1, j1, k1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, int i1, int j1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).a(new ExtendedGamesLoadedBinderCallback(d1), i1, j1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).a(new PlayersLoadedBinderCallback(d1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, int i1, int ai[])
    {
        try
        {
            ((IGamesService)ft()).a(new TurnBasedMatchesLoadedBinderCallbacks(d1), i1, ai);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, LeaderboardScoreBuffer leaderboardscorebuffer, int i1, int j1)
    {
        try
        {
            ((IGamesService)ft()).a(new LeaderboardScoresLoadedBinderCallback(d1), leaderboardscorebuffer.iA().iB(), i1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        try
        {
            ((IGamesService)ft()).a(new TurnBasedMatchInitiatedBinderCallbacks(d1), turnbasedmatchconfig.getVariant(), turnbasedmatchconfig.iH(), turnbasedmatchconfig.getInvitedPlayerIds(), turnbasedmatchconfig.getAutoMatchCriteria());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, Snapshot snapshot, SnapshotMetadataChange snapshotmetadatachange)
    {
        Contents contents = snapshot.getContents();
        com.google.android.gms.internal.hm.b(contents, "Must provide a previously opened Snapshot");
        a a1 = snapshotmetadatachange.iN();
        if (a1 != null)
        {
            a1.a(getContext().getCacheDir());
        }
        snapshot.iM();
        try
        {
            ((IGamesService)ft()).a(new SnapshotCommittedBinderCallbacks(d1), snapshot.getMetadata().getSnapshotId(), snapshotmetadatachange, contents);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).a(new PlayersLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, int i1)
    {
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        d1 = null;
_L1:
        try
        {
            ((IGamesService)ft()).a(d1, s, i1, Nu.hN(), Nu.hM());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_58;
        d1 = new AchievementUpdatedBinderCallback(d1);
          goto _L1
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new LeaderboardScoresLoadedBinderCallback(d1), s, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new PlayersLoadedBinderCallback(d1), s, i1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        if (!s.equals("played_with"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid player collection: ").append(s).toString());
        }
        try
        {
            ((IGamesService)ft()).d(new PlayersLoadedBinderCallback(d1), s, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        try
        {
            ((IGamesService)ft()).a(new ExtendedGamesLoadedBinderCallback(d1), s, i1, flag, flag1, flag2, flag3);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, int i1, int ai[])
    {
        try
        {
            ((IGamesService)ft()).a(new TurnBasedMatchesLoadedBinderCallbacks(d1), s, i1, ai);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, long l1, String s1)
    {
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        d1 = null;
_L1:
        try
        {
            ((IGamesService)ft()).a(d1, s, l1, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_46;
        d1 = new SubmitScoreBinderCallbacks(d1);
          goto _L1
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1)
    {
        try
        {
            ((IGamesService)ft()).c(new TurnBasedMatchLeftBinderCallbacks(d1), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, int i1, int j1)
    {
        try
        {
            ((IGamesService)ft()).a(new PlayerLeaderboardScoreLoadedBinderCallback(d1), s, s1, i1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, int i1, int j1, int k1)
    {
        try
        {
            ((IGamesService)ft()).a(new RequestsLoadedBinderCallbacks(d1), s, s1, i1, j1, k1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new LeaderboardScoresLoadedBinderCallback(d1), s, s1, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, int i1, boolean flag, boolean flag1)
    {
        if (!s.equals("played_with") && !s.equals("circled"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid player collection: ").append(s).toString());
        }
        try
        {
            ((IGamesService)ft()).a(new PlayersLoadedBinderCallback(d1), s, s1, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, SnapshotMetadataChange snapshotmetadatachange, Contents contents)
    {
        a a1 = snapshotmetadatachange.iN();
        if (a1 != null)
        {
            a1.a(getContext().getCacheDir());
        }
        try
        {
            ((IGamesService)ft()).a(new SnapshotOpenedBinderCallbacks(d1), s, s1, snapshotmetadatachange, contents);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).b(new LeaderboardsLoadedBinderCallback(d1), s, s1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, boolean flag, String as[])
    {
        try
        {
            ((IGamesService)ft()).a(new QuestsLoadedBinderCallbacks(d1), s, s1, as, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, int ai[], int i1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new QuestsLoadedBinderCallbacks(d1), s, s1, ai, i1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String s1, String as[])
    {
        try
        {
            ((IGamesService)ft()).a(new RequestsUpdatedBinderCallbacks(d1), s, s1, as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).c(new LeaderboardsLoadedBinderCallback(d1), s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
    {
        try
        {
            ((IGamesService)ft()).a(new TurnBasedMatchUpdatedBinderCallbacks(d1), s, abyte0, s1, aparticipantresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, byte abyte0[], ParticipantResult aparticipantresult[])
    {
        try
        {
            ((IGamesService)ft()).a(new TurnBasedMatchUpdatedBinderCallbacks(d1), s, abyte0, aparticipantresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String s, String as[], int i1, byte abyte0[], int j1)
    {
        try
        {
            ((IGamesService)ft()).a(new RequestSentBinderCallbacks(d1), s, as, i1, abyte0, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).c(new PlayersLoadedBinderCallback(d1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, boolean flag, Bundle bundle)
    {
        try
        {
            ((IGamesService)ft()).a(new ContactSettingsUpdatedBinderCallback(d1), flag, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public transient void a(com.google.android.gms.common.api.a.d d1, boolean flag, String as[])
    {
        try
        {
            Np.flush();
            ((IGamesService)ft()).a(new EventsLoadedBinderCallback(d1), flag, as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, int ai[], int i1, boolean flag)
    {
        try
        {
            Np.flush();
            ((IGamesService)ft()).a(new QuestsLoadedBinderCallbacks(d1), ai, i1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.d d1, String as[])
    {
        try
        {
            ((IGamesService)ft()).c(new PlayersLoadedBinderCallback(d1), as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        try
        {
            oninvitationreceivedlistener = new InvitationReceivedBinderCallback(oninvitationreceivedlistener);
            ((IGamesService)ft()).a(oninvitationreceivedlistener, Nz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(RoomConfig roomconfig)
    {
        try
        {
            RoomBinderCallbacks roombindercallbacks = new RoomBinderCallbacks(roomconfig.getRoomUpdateListener(), roomconfig.getRoomStatusUpdateListener(), roomconfig.getMessageReceivedListener());
            ((IGamesService)ft()).a(roombindercallbacks, Ny, roomconfig.getVariant(), roomconfig.getInvitedPlayerIds(), roomconfig.getAutoMatchCriteria(), roomconfig.isSocketEnabled(), Nz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomConfig roomconfig)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(RoomUpdateListener roomupdatelistener, String s)
    {
        try
        {
            ((IGamesService)ft()).c(new RoomBinderCallbacks(roomupdatelistener), s);
            hv();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomUpdateListener roomupdatelistener)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        try
        {
            onturnbasedmatchupdatereceivedlistener = new MatchUpdateReceivedBinderCallback(onturnbasedmatchupdatereceivedlistener);
            ((IGamesService)ft()).b(onturnbasedmatchupdatereceivedlistener, Nz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(QuestUpdateListener questupdatelistener)
    {
        try
        {
            questupdatelistener = new QuestUpdateBinderCallback(questupdatelistener);
            ((IGamesService)ft()).d(questupdatelistener, Nz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (QuestUpdateListener questupdatelistener)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(OnRequestReceivedListener onrequestreceivedlistener)
    {
        try
        {
            onrequestreceivedlistener = new RequestReceivedBinderCallback(onrequestreceivedlistener);
            ((IGamesService)ft()).c(onrequestreceivedlistener, Nz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnRequestReceivedListener onrequestreceivedlistener)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void a(Snapshot snapshot)
    {
        Contents contents = snapshot.getContents();
        com.google.android.gms.internal.hm.b(contents, "Must provide a previously opened Snapshot");
        snapshot.iM();
        try
        {
            ((IGamesService)ft()).a(contents);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Snapshot snapshot)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    protected void a(hi hi1, com.google.android.gms.internal.hb.e e1)
    {
        String s = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", NA);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", Nw);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", Nx);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", NC);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", NB);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", ND);
        hi1.a(e1, 0x4da6e8, getContext().getPackageName(), yQ, fs(), Nq, Nu.hN(), s, bundle);
    }

    public Intent aR(String s)
    {
        try
        {
            s = ((IGamesService)ft()).aR(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return s;
    }

    public void aS(String s)
    {
        try
        {
            ((IGamesService)ft()).ba(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public Intent aU(String s)
    {
        try
        {
            s = ((IGamesService)ft()).aU(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return s;
    }

    protected IGamesService ah(IBinder ibinder)
    {
        return IGamesService.Stub.aj(ibinder);
    }

    public Intent b(int i1, int j1, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).b(i1, j1, flag);
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public void b(com.google.android.gms.common.api.a.d d1)
    {
        try
        {
            Np.flush();
            ((IGamesService)ft()).a(new SignOutCompleteBinderCallbacks(d1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).b(new PlayersLoadedBinderCallback(d1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s)
    {
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        d1 = null;
_L1:
        try
        {
            ((IGamesService)ft()).a(d1, s, Nu.hN(), Nu.hM());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_57;
        d1 = new AchievementUpdatedBinderCallback(d1);
          goto _L1
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, int i1)
    {
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        d1 = null;
_L1:
        try
        {
            ((IGamesService)ft()).b(d1, s, i1, Nu.hN(), Nu.hM());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_58;
        d1 = new AchievementUpdatedBinderCallback(d1);
          goto _L1
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).b(new LeaderboardScoresLoadedBinderCallback(d1), s, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).a(new ExtendedGamesLoadedBinderCallback(d1), s, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, String s1)
    {
        try
        {
            Np.flush();
            ((IGamesService)ft()).f(new QuestMilestoneClaimBinderCallbacks(d1, s1), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, String s1, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).b(new LeaderboardScoresLoadedBinderCallback(d1), s, s1, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, String s1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new AchievementsLoadedBinderCallback(d1), s, s1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String s, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).e(new SnapshotOpenedBinderCallbacks(d1), s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).b(new LeaderboardsLoadedBinderCallback(d1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, boolean flag, String as[])
    {
        try
        {
            ((IGamesService)ft()).a(new QuestsLoadedBinderCallbacks(d1), as, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.d d1, String as[])
    {
        try
        {
            ((IGamesService)ft()).a(new RequestsUpdatedBinderCallbacks(d1), as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void b(RoomConfig roomconfig)
    {
        try
        {
            RoomBinderCallbacks roombindercallbacks = new RoomBinderCallbacks(roomconfig.getRoomUpdateListener(), roomconfig.getRoomStatusUpdateListener(), roomconfig.getMessageReceivedListener());
            ((IGamesService)ft()).a(roombindercallbacks, Ny, roomconfig.getInvitationId(), roomconfig.isSocketEnabled(), Nz);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomConfig roomconfig)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    protected transient void b(String as[])
    {
        int i1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        while (i1 < as.length) 
        {
            String s = as[i1];
            boolean flag2;
            if (s.equals("https://www.googleapis.com/auth/games"))
            {
                flag2 = true;
            } else
            {
                flag2 = flag1;
                if (s.equals("https://www.googleapis.com/auth/games.firstparty"))
                {
                    flag = true;
                    flag2 = flag1;
                }
            }
            i1++;
            flag1 = flag2;
        }
        if (flag)
        {
            if (!flag1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            com.google.android.gms.internal.hm.a(flag1, "Cannot have both %s and %s!", new Object[] {
                "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"
            });
            return;
        } else
        {
            com.google.android.gms.internal.hm.a(flag1, "Games APIs requires %s to function.", new Object[] {
                "https://www.googleapis.com/auth/games"
            });
            return;
        }
    }

    protected String bu()
    {
        return "com.google.android.gms.games.service.START";
    }

    protected String bv()
    {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void c(com.google.android.gms.common.api.a.d d1, int i1)
    {
        try
        {
            ((IGamesService)ft()).a(new InvitationsLoadedBinderCallback(d1), i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).c(new PlayersLoadedBinderCallback(d1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, String s)
    {
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        d1 = null;
_L1:
        try
        {
            ((IGamesService)ft()).b(d1, s, Nu.hN(), Nu.hM());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_57;
        d1 = new AchievementUpdatedBinderCallback(d1);
          goto _L1
    }

    public void c(com.google.android.gms.common.api.a.d d1, String s, int i1)
    {
        try
        {
            ((IGamesService)ft()).b(new PlayerXpStreamLoadedBinderCallback(d1), s, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).e(new ExtendedGamesLoadedBinderCallback(d1), s, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, String s, String s1)
    {
        try
        {
            ((IGamesService)ft()).d(new TurnBasedMatchInitiatedBinderCallbacks(d1), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, String s, String s1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).c(new SnapshotsLoadedBinderCallbacks(d1), s, s1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, String s, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).d(new LeaderboardsLoadedBinderCallback(d1), s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new AchievementsLoadedBinderCallback(d1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.d d1, String as[])
    {
        try
        {
            ((IGamesService)ft()).b(new RequestsUpdatedBinderCallbacks(d1), as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void cg(int i1)
    {
        Nu.setGravity(i1);
    }

    public void ch(int i1)
    {
        try
        {
            ((IGamesService)ft()).ch(i1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void connect()
    {
        gY();
        super.connect();
    }

    public int d(byte abyte0[], String s)
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).b(abyte0, s, null);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public void d(com.google.android.gms.common.api.a.d d1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).e(new PlayersLoadedBinderCallback(d1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).l(new TurnBasedMatchInitiatedBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.d d1, String s, int i1)
    {
        try
        {
            ((IGamesService)ft()).c(new PlayerXpStreamLoadedBinderCallback(d1), s, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).f(new ExtendedGamesLoadedBinderCallback(d1), s, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.d d1, String s, String s1)
    {
        try
        {
            ((IGamesService)ft()).e(new TurnBasedMatchInitiatedBinderCallbacks(d1), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.d d1, String s, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).a(new GameMuteStatusChangedBinderCallback(d1), s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.d d1, boolean flag)
    {
        try
        {
            Np.flush();
            ((IGamesService)ft()).f(new EventsLoadedBinderCallback(d1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void disconnect()
    {
        Nv = false;
        if (isConnected())
        {
            try
            {
                IGamesService igamesservice = (IGamesService)ft();
                igamesservice.hw();
                Np.flush();
                igamesservice.q(Nz);
            }
            catch (RemoteException remoteexception)
            {
                GamesLog.j("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        hv();
        super.disconnect();
    }

    public void e(com.google.android.gms.common.api.a.d d1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).d(new PlayersLoadedBinderCallback(d1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void e(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).m(new TurnBasedMatchInitiatedBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void e(com.google.android.gms.common.api.a.d d1, String s, int i1)
    {
        try
        {
            ((IGamesService)ft()).b(new InvitationsLoadedBinderCallback(d1), s, i1, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void e(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).c(new ExtendedGamesLoadedBinderCallback(d1), s, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void e(com.google.android.gms.common.api.a.d d1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).d(new SnapshotsLoadedBinderCallbacks(d1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public Bundle ef()
    {
        Bundle bundle;
        try
        {
            bundle = ((IGamesService)ft()).ef();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        bundle.setClassLoader(com/google/android/gms/games/internal/GamesClientImpl.getClassLoader());
        return bundle;
    }

    public void f(View view)
    {
        Nu.g(view);
    }

    public void f(com.google.android.gms.common.api.a.d d1)
    {
        try
        {
            ((IGamesService)ft()).d(new GamesLoadedBinderCallback(d1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void f(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).o(new TurnBasedMatchLeftBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void f(com.google.android.gms.common.api.a.d d1, String s, int i1)
    {
        try
        {
            ((IGamesService)ft()).a(new RequestSummariesLoadedBinderCallbacks(d1), s, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void f(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).b(new PlayersLoadedBinderCallback(d1), s, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void f(com.google.android.gms.common.api.a.d d1, boolean flag)
    {
        try
        {
            ((IGamesService)ft()).e(new ContactSettingsLoadedBinderCallback(d1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void g(com.google.android.gms.common.api.a.d d1)
    {
        try
        {
            ((IGamesService)ft()).j(new OwnerCoverPhotoUrisLoadedBinderCallback(d1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void g(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).n(new TurnBasedMatchCanceledBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void g(com.google.android.gms.common.api.a.d d1, String s, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((IGamesService)ft()).b(new PlayersLoadedBinderCallback(d1), s, null, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public String gZ()
    {
        String s;
        try
        {
            s = ((IGamesService)ft()).gZ();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return s;
    }

    public void h(com.google.android.gms.common.api.a.d d1)
    {
        try
        {
            ((IGamesService)ft()).h(new NotifyAclLoadedBinderCallback(d1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void h(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).p(new TurnBasedMatchLoadedBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public String ha()
    {
        String s;
        try
        {
            s = ((IGamesService)ft()).ha();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return s;
    }

    public Player hb()
    {
        cn();
        this;
        JVM INSTR monitorenter ;
        Object obj = Ns;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new PlayerBuffer(((IGamesService)ft()).hy());
        if (((PlayerBuffer) (obj)).getCount() > 0)
        {
            Ns = (PlayerEntity)((PlayerBuffer) (obj)).get(0).freeze();
        }
        ((PlayerBuffer) (obj)).close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return Ns;
        Exception exception1;
        exception1;
        Exception exception;
        try
        {
            ((PlayerBuffer) (obj)).close();
            throw exception1;
        }
        catch (RemoteException remoteexception) { }
        finally { }
        GamesLog.j("GamesClientImpl", "service died");
          goto _L1
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Game hc()
    {
        cn();
        this;
        JVM INSTR monitorenter ;
        Object obj = Nt;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new GameBuffer(((IGamesService)ft()).hA());
        if (((GameBuffer) (obj)).getCount() > 0)
        {
            Nt = (GameEntity)((GameBuffer) (obj)).get(0).freeze();
        }
        ((GameBuffer) (obj)).close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return Nt;
        Exception exception1;
        exception1;
        Exception exception;
        try
        {
            ((GameBuffer) (obj)).close();
            throw exception1;
        }
        catch (RemoteException remoteexception) { }
        finally { }
        GamesLog.j("GamesClientImpl", "service died");
          goto _L1
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Intent hd()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).hd();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent he()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).he();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent hf()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).hf();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent hg()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).hg();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public void hh()
    {
        try
        {
            ((IGamesService)ft()).r(Nz);
            return;
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void hi()
    {
        try
        {
            ((IGamesService)ft()).s(Nz);
            return;
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void hj()
    {
        try
        {
            ((IGamesService)ft()).u(Nz);
            return;
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void hk()
    {
        try
        {
            ((IGamesService)ft()).t(Nz);
            return;
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public Intent hl()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).hl();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent hm()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).hm();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public int hn()
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).hn();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return 4368;
        }
        return i1;
    }

    public String ho()
    {
        String s;
        try
        {
            s = ((IGamesService)ft()).ho();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return s;
    }

    public int hp()
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).hp();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public Intent hq()
    {
        Intent intent;
        try
        {
            intent = ((IGamesService)ft()).hq();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public int hr()
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).hr();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public int hs()
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).hs();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public int ht()
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).ht();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public int hu()
    {
        int i1;
        try
        {
            i1 = ((IGamesService)ft()).hu();
        }
        catch (RemoteException remoteexception)
        {
            GamesLog.j("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public void hw()
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ((IGamesService)ft()).hw();
        return;
        RemoteException remoteexception;
        remoteexception;
        GamesLog.j("GamesClientImpl", "service died");
        return;
    }

    public void i(com.google.android.gms.common.api.a.d d1)
    {
        try
        {
            ((IGamesService)ft()).e(new ContactSettingsLoadedBinderCallback(d1), false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void i(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            Np.flush();
            ((IGamesService)ft()).u(new QuestAcceptedBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void j(com.google.android.gms.common.api.a.d d1)
    {
        try
        {
            ((IGamesService)ft()).t(new InboxCountsLoadedBinderCallback(d1), null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void j(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).r(new SnapshotDeletedBinderCallbacks(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void k(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).e(new ExtendedGamesLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket l(String s, String s1)
    {
label0:
        {
            if (s1 == null || !ParticipantUtils.bn(s1))
            {
                throw new IllegalArgumentException("Bad participant ID");
            }
            RealTimeSocket realtimesocket = (RealTimeSocket)Nr.get(s1);
            if (realtimesocket != null)
            {
                s = realtimesocket;
                if (!realtimesocket.isClosed())
                {
                    break label0;
                }
            }
            s = aT(s1);
        }
        return s;
    }

    public void l(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).f(new GameInstancesLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void l(String s, int i1)
    {
        Np.l(s, i1);
    }

    public void m(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).q(new GameSearchSuggestionsLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void m(String s, int i1)
    {
        try
        {
            ((IGamesService)ft()).m(s, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void n(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).s(new PlayerXpForGameCategoriesLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void n(String s, int i1)
    {
        try
        {
            ((IGamesService)ft()).n(s, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void o(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).k(new InvitationsLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle bundle)
    {
        if (Nv)
        {
            Nu.hL();
            Nv = false;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        Nv = false;
    }

    public void onConnectionSuspended(int i1)
    {
    }

    public void p(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).j(new NotifyAclUpdatedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    public void q(com.google.android.gms.common.api.a.d d1, String s)
    {
        try
        {
            ((IGamesService)ft()).i(new GameMuteStatusLoadedBinderCallback(d1), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.d d1)
        {
            GamesLog.j("GamesClientImpl", "service died");
        }
    }

    protected IInterface x(IBinder ibinder)
    {
        return ah(ibinder);
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class RealTimeReliableMessageBinderCallbacks {}


    /* member class not found */
    class RequestsLoadedBinderCallbacks {}


    /* member class not found */
    class ExtendedGamesLoadedBinderCallback {}


    /* member class not found */
    class PlayersLoadedBinderCallback {}


    /* member class not found */
    class TurnBasedMatchesLoadedBinderCallbacks {}


    /* member class not found */
    class LeaderboardScoresLoadedBinderCallback {}


    /* member class not found */
    class TurnBasedMatchInitiatedBinderCallbacks {}


    /* member class not found */
    class SnapshotCommittedBinderCallbacks {}


    /* member class not found */
    class AchievementUpdatedBinderCallback {}


    /* member class not found */
    class SubmitScoreBinderCallbacks {}


    /* member class not found */
    class TurnBasedMatchLeftBinderCallbacks {}


    /* member class not found */
    class PlayerLeaderboardScoreLoadedBinderCallback {}


    /* member class not found */
    class SnapshotOpenedBinderCallbacks {}


    /* member class not found */
    class LeaderboardsLoadedBinderCallback {}


    /* member class not found */
    class QuestsLoadedBinderCallbacks {}


    /* member class not found */
    class RequestsUpdatedBinderCallbacks {}


    /* member class not found */
    class TurnBasedMatchUpdatedBinderCallbacks {}


    /* member class not found */
    class RequestSentBinderCallbacks {}


    /* member class not found */
    class ContactSettingsUpdatedBinderCallback {}


    /* member class not found */
    class EventsLoadedBinderCallback {}


    /* member class not found */
    class InvitationReceivedBinderCallback {}


    /* member class not found */
    class RoomBinderCallbacks {}


    /* member class not found */
    class MatchUpdateReceivedBinderCallback {}


    /* member class not found */
    class QuestUpdateBinderCallback {}


    /* member class not found */
    class RequestReceivedBinderCallback {}


    /* member class not found */
    class SignOutCompleteBinderCallbacks {}


    /* member class not found */
    class QuestMilestoneClaimBinderCallbacks {}


    /* member class not found */
    class AchievementsLoadedBinderCallback {}


    /* member class not found */
    class InvitationsLoadedBinderCallback {}


    /* member class not found */
    class PlayerXpStreamLoadedBinderCallback {}


    /* member class not found */
    class SnapshotsLoadedBinderCallbacks {}


    /* member class not found */
    class GameMuteStatusChangedBinderCallback {}


    /* member class not found */
    class GamesLoadedBinderCallback {}


    /* member class not found */
    class RequestSummariesLoadedBinderCallbacks {}


    /* member class not found */
    class ContactSettingsLoadedBinderCallback {}


    /* member class not found */
    class OwnerCoverPhotoUrisLoadedBinderCallback {}


    /* member class not found */
    class TurnBasedMatchCanceledBinderCallbacks {}


    /* member class not found */
    class NotifyAclLoadedBinderCallback {}


    /* member class not found */
    class TurnBasedMatchLoadedBinderCallbacks {}


    /* member class not found */
    class QuestAcceptedBinderCallbacks {}


    /* member class not found */
    class InboxCountsLoadedBinderCallback {}


    /* member class not found */
    class SnapshotDeletedBinderCallbacks {}


    /* member class not found */
    class GameInstancesLoadedBinderCallback {}


    /* member class not found */
    class GameSearchSuggestionsLoadedBinderCallback {}


    /* member class not found */
    class PlayerXpForGameCategoriesLoadedBinderCallback {}


    /* member class not found */
    class NotifyAclUpdatedBinderCallback {}


    /* member class not found */
    class GameMuteStatusLoadedBinderCallback {}

}
