// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.leaderboard.c;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.a;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            dw, eg, fq, fp, 
//            fr, fn, ec, fk

public final class fl extends dw
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{
    abstract class a extends c
    {

        private final ArrayList tY = new ArrayList();
        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            a(roomstatusupdatelistener, room, tY);
        }

        protected abstract void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist);

        a(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder);
            int i1 = 0;
            for (int j1 = as1.length; i1 < j1; i1++)
            {
                tY.add(as1[i1]);
            }

        }
    }

    final class aa extends dw.b
    {

        final fl tZ;
        private final String up;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            if (roomstatusupdatelistener != null)
            {
                roomstatusupdatelistener.onP2PConnected(up);
            }
        }

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            a((RoomStatusUpdateListener)obj);
        }

        aa(RoomStatusUpdateListener roomstatusupdatelistener, String s1)
        {
            tZ = fl.this;
            super(fl.this, roomstatusupdatelistener);
            up = s1;
        }
    }

    final class ab extends dw.b
    {

        final fl tZ;
        private final String up;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            if (roomstatusupdatelistener != null)
            {
                roomstatusupdatelistener.onP2PDisconnected(up);
            }
        }

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            a((RoomStatusUpdateListener)obj);
        }

        ab(RoomStatusUpdateListener roomstatusupdatelistener, String s1)
        {
            tZ = fl.this;
            super(fl.this, roomstatusupdatelistener);
            up = s1;
        }
    }

    final class ac extends a
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeersConnected(room, arraylist);
        }

        ac(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ad extends a
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerDeclined(room, arraylist);
        }

        ad(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ae extends a
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeersDisconnected(room, arraylist);
        }

        ae(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class af extends a
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerInvitedToRoom(room, arraylist);
        }

        af(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ag extends a
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerJoined(room, arraylist);
        }

        ag(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ah extends a
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerLeft(room, arraylist);
        }

        ah(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ai extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void D(DataHolder dataholder)
        {
            tZ.a(tZ. new aj(jW, dataholder));
        }

        ai(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class aj extends dw.d
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
    {

        private final Status jY;
        final fl tZ;
        private final com.google.android.gms.games.leaderboard.d uq = null;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public LeaderboardScore getScore()
        {
            return uq;
        }

        public Status getStatus()
        {
            return jY;
        }

        aj(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(fl.this, c1, dataholder);
            jY = new Status(dataholder.getStatusCode());
            fl1 = new LeaderboardScoreBuffer(dataholder);
            if (getCount() <= 0) goto _L2; else goto _L1
_L1:
            uq = (com.google.android.gms.games.leaderboard.d)get(0).freeze();
_L4:
            close();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            c1;
            close();
            throw c1;
        }
    }

    final class ak extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void e(DataHolder dataholder)
        {
            tZ.a(tZ. new al(jW, dataholder));
        }

        ak(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class al extends ao
        implements com.google.android.gms.games.Players.LoadPlayersResult
    {

        final fl tZ;
        private final PlayerBuffer ur;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public PlayerBuffer getPlayers()
        {
            return ur;
        }

        al(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            ur = new PlayerBuffer(dataholder);
        }
    }

    final class am extends dw.b
    {

        private final int mC;
        final fl tZ;
        private final String us;
        private final int ut;

        public void a(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            if (reliablemessagesentcallback != null)
            {
                reliablemessagesentcallback.onRealTimeMessageSent(mC, ut, us);
            }
        }

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            a((com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback)obj);
        }

        am(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback, int i1, int j1, String s1)
        {
            tZ = fl.this;
            super(fl.this, reliablemessagesentcallback);
            mC = i1;
            ut = j1;
            us = s1;
        }
    }

    final class an extends fk
    {

        final fl tZ;
        final com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback uu;

        public void b(int i1, int j1, String s1)
        {
            tZ.a(tZ. new am(uu, i1, j1, s1));
        }

        public an(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            tZ = fl.this;
            super();
            uu = reliablemessagesentcallback;
        }
    }

    abstract class ao extends dw.d
        implements Releasable, Result
    {

        final Status jY;
        final DataHolder nE;
        final fl tZ;

        public Status getStatus()
        {
            return jY;
        }

        public void release()
        {
            if (nE != null)
            {
                nE.close();
            }
        }

        public ao(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(fl.this, c1, dataholder);
            jY = new Status(dataholder.getStatusCode());
            nE = dataholder;
        }
    }

    final class ap extends c
    {

        final fl tZ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onRoomAutoMatching(room);
        }

        ap(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class aq extends fk
    {

        final fl tZ;
        private final RoomUpdateListener uv;
        private final RoomStatusUpdateListener uw;
        private final RealTimeMessageReceivedListener ux;

        public void a(DataHolder dataholder, String as1[])
        {
            tZ.a(tZ. new af(uw, dataholder, as1));
        }

        public void b(DataHolder dataholder, String as1[])
        {
            tZ.a(tZ. new ag(uw, dataholder, as1));
        }

        public void c(DataHolder dataholder, String as1[])
        {
            tZ.a(tZ. new ah(uw, dataholder, as1));
        }

        public void d(DataHolder dataholder, String as1[])
        {
            tZ.a(tZ. new ad(uw, dataholder, as1));
        }

        public void e(DataHolder dataholder, String as1[])
        {
            tZ.a(tZ. new ac(uw, dataholder, as1));
        }

        public void f(DataHolder dataholder, String as1[])
        {
            tZ.a(tZ. new ae(uw, dataholder, as1));
        }

        public void onLeftRoom(int i1, String s1)
        {
            tZ.a(tZ. new v(uv, i1, s1));
        }

        public void onP2PConnected(String s1)
        {
            tZ.a(tZ. new aa(uw, s1));
        }

        public void onP2PDisconnected(String s1)
        {
            tZ.a(tZ. new ab(uw, s1));
        }

        public void onRealTimeMessageReceived(RealTimeMessage realtimemessage)
        {
            tZ.a(tZ. new z(ux, realtimemessage));
        }

        public void t(DataHolder dataholder)
        {
            tZ.a(tZ. new at(uv, dataholder));
        }

        public void u(DataHolder dataholder)
        {
            tZ.a(tZ. new q(uv, dataholder));
        }

        public void v(DataHolder dataholder)
        {
            tZ.a(tZ. new as(uw, dataholder));
        }

        public void w(DataHolder dataholder)
        {
            tZ.a(tZ. new ap(uw, dataholder));
        }

        public void x(DataHolder dataholder)
        {
            tZ.a(tZ. new ar(uv, dataholder));
        }

        public void y(DataHolder dataholder)
        {
            tZ.a(tZ. new h(uw, dataholder));
        }

        public void z(DataHolder dataholder)
        {
            tZ.a(tZ. new i(uw, dataholder));
        }

        public aq(RoomUpdateListener roomupdatelistener)
        {
            tZ = fl.this;
            super();
            uv = (RoomUpdateListener)eg.b(roomupdatelistener, "Callbacks must not be null");
            uw = null;
            ux = null;
        }

        public aq(RoomUpdateListener roomupdatelistener, RoomStatusUpdateListener roomstatusupdatelistener, RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            tZ = fl.this;
            super();
            uv = (RoomUpdateListener)eg.b(roomupdatelistener, "Callbacks must not be null");
            uw = roomstatusupdatelistener;
            ux = realtimemessagereceivedlistener;
        }
    }

    final class ar extends b
    {

        final fl tZ;

        public void a(RoomUpdateListener roomupdatelistener, Room room, int i1)
        {
            roomupdatelistener.onRoomConnected(i1, room);
        }

        ar(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomupdatelistener, dataholder);
        }
    }

    final class as extends c
    {

        final fl tZ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onRoomConnecting(room);
        }

        as(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class at extends b
    {

        final fl tZ;

        public void a(RoomUpdateListener roomupdatelistener, Room room, int i1)
        {
            roomupdatelistener.onRoomCreated(i1, room);
        }

        public at(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomupdatelistener, dataholder);
        }
    }

    final class au extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void onSignOutComplete()
        {
            Status status = new Status(0);
            tZ.a(tZ. new av(jW, status));
        }

        public au(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class av extends dw.b
    {

        private final Status jY;
        final fl tZ;

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(jY);
        }

        public av(com.google.android.gms.common.api.a.c c1, Status status)
        {
            tZ = fl.this;
            super(fl.this, c1);
            jY = status;
        }
    }

    final class aw extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void d(DataHolder dataholder)
        {
            tZ.a(tZ. new ax(jW, dataholder));
        }

        public aw(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class ax extends ao
        implements com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
    {

        final fl tZ;
        private final ScoreSubmissionData uy;

        public void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        public volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public ScoreSubmissionData getScoreData()
        {
            return uy;
        }

        public ax(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            uy = new ScoreSubmissionData(dataholder);
        }
    }

    abstract class ay extends ao
    {

        final fl tZ;
        final TurnBasedMatch un = null;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            i(c1);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public TurnBasedMatch getMatch()
        {
            return un;
        }

        abstract void i(com.google.android.gms.common.api.a.c c1);

        ay(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            fl1 = new TurnBasedMatchBuffer(dataholder);
            if (getCount() <= 0) goto _L2; else goto _L1
_L1:
            un = (TurnBasedMatch)((TurnBasedMatch)get(0)).freeze();
_L4:
            close();
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            c1;
            close();
            throw c1;
        }
    }

    final class az extends fk
    {

        final fl tZ;
        private final com.google.android.gms.common.api.a.c uz;

        public void onTurnBasedMatchCanceled(int i1, String s1)
        {
            Status status = new Status(i1);
            tZ.a(tZ. new ba(uz, status, s1));
        }

        public az(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            uz = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    abstract class b extends dw.d
    {

        final fl tZ;

        protected void a(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            a(roomupdatelistener, com.google.android.gms.internal.fl.a(tZ, dataholder), dataholder.getStatusCode());
        }

        protected abstract void a(RoomUpdateListener roomupdatelistener, Room room, int i1);

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((RoomUpdateListener)obj, dataholder);
        }

        b(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(fl.this, roomupdatelistener, dataholder);
        }
    }

    final class ba extends dw.b
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    {

        private final Status jY;
        final fl tZ;
        private final String uA;

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        public String getMatchId()
        {
            return uA;
        }

        public Status getStatus()
        {
            return jY;
        }

        ba(com.google.android.gms.common.api.a.c c1, Status status, String s1)
        {
            tZ = fl.this;
            super(fl.this, c1);
            jY = status;
            uA = s1;
        }
    }

    final class bb extends fk
    {

        final fl tZ;
        private final com.google.android.gms.common.api.a.c uB;

        public void n(DataHolder dataholder)
        {
            tZ.a(tZ. new bc(uB, dataholder));
        }

        public bb(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            uB = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class bc extends ay
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult
    {

        final fl tZ;

        protected void i(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        bc(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
        }
    }

    final class bd extends fk
    {

        final fl tZ;
        private final com.google.android.gms.common.api.a.c uC;

        public void p(DataHolder dataholder)
        {
            tZ.a(tZ. new be(uC, dataholder));
        }

        public bd(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            uC = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class be extends ay
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult
    {

        final fl tZ;

        protected void i(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        be(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
        }
    }

    final class bf extends fk
    {

        final fl tZ;
        private final com.google.android.gms.common.api.a.c uD;

        public void m(DataHolder dataholder)
        {
            tZ.a(tZ. new bg(uD, dataholder));
        }

        public bf(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            uD = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class bg extends ay
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult
    {

        final fl tZ;

        protected void i(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        bg(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
        }
    }

    final class bh extends fk
    {

        final fl tZ;
        private final com.google.android.gms.common.api.a.c uE;

        public void o(DataHolder dataholder)
        {
            tZ.a(tZ. new bi(uE, dataholder));
        }

        public bh(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            uE = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class bi extends ay
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
    {

        final fl tZ;

        protected void i(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        bi(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
        }
    }

    final class bj extends fk
    {

        final fl tZ;
        private final com.google.android.gms.common.api.a.c uF;

        public void a(int i1, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = new Status(i1);
            tZ.a(tZ. new bk(uF, status, bundle));
        }

        public bj(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            uF = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class bk extends dw.b
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
    {

        private final Status jY;
        final fl tZ;
        private final LoadMatchesResponse uG;

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        public LoadMatchesResponse getMatches()
        {
            return uG;
        }

        public Status getStatus()
        {
            return jY;
        }

        public void release()
        {
            uG.close();
        }

        bk(com.google.android.gms.common.api.a.c c1, Status status, Bundle bundle)
        {
            tZ = fl.this;
            super(fl.this, c1);
            jY = status;
            uG = new LoadMatchesResponse(bundle);
        }
    }

    abstract class c extends dw.d
    {

        final fl tZ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            a(roomstatusupdatelistener, com.google.android.gms.internal.fl.a(tZ, dataholder));
        }

        protected abstract void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room);

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((RoomStatusUpdateListener)obj, dataholder);
        }

        c(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(fl.this, roomstatusupdatelistener, dataholder);
        }
    }

    final class d extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void onAchievementUpdated(int i1, String s1)
        {
            tZ.a(tZ. new e(jW, i1, s1));
        }

        d(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class e extends dw.b
        implements com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    {

        private final Status jY;
        final fl tZ;
        private final String ua;

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        public String getAchievementId()
        {
            return ua;
        }

        public Status getStatus()
        {
            return jY;
        }

        e(com.google.android.gms.common.api.a.c c1, int i1, String s1)
        {
            tZ = fl.this;
            super(fl.this, c1);
            jY = new Status(i1);
            ua = s1;
        }
    }

    final class f extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void b(DataHolder dataholder)
        {
            tZ.a(tZ. new g(jW, dataholder));
        }

        f(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class g extends ao
        implements com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
    {

        final fl tZ;
        private final AchievementBuffer ub;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public AchievementBuffer getAchievements()
        {
            return ub;
        }

        g(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            ub = new AchievementBuffer(dataholder);
        }
    }

    final class h extends c
    {

        final fl tZ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onConnectedToRoom(room);
        }

        h(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class i extends c
    {

        final fl tZ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onDisconnectedFromRoom(room);
        }

        i(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class j extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void g(DataHolder dataholder)
        {
            tZ.a(tZ. new k(jW, dataholder));
        }

        j(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class k extends ao
        implements com.google.android.gms.games.GamesMetadata.LoadGamesResult
    {

        final fl tZ;
        private final GameBuffer uc;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public GameBuffer getGames()
        {
            return uc;
        }

        k(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            uc = new GameBuffer(dataholder);
        }
    }

    final class l extends fk
    {

        final fl tZ;
        private final OnInvitationReceivedListener ud;

        public void l(DataHolder dataholder)
        {
            InvitationBuffer invitationbuffer;
            invitationbuffer = new InvitationBuffer(dataholder);
            dataholder = null;
            if (invitationbuffer.getCount() > 0)
            {
                dataholder = (Invitation)((Invitation)invitationbuffer.get(0)).freeze();
            }
            invitationbuffer.close();
            if (dataholder != null)
            {
                tZ.a(tZ. new m(ud, dataholder));
            }
            return;
            dataholder;
            invitationbuffer.close();
            throw dataholder;
        }

        public void onInvitationRemoved(String s1)
        {
            tZ.a(tZ. new n(ud, s1));
        }

        l(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            tZ = fl.this;
            super();
            ud = oninvitationreceivedlistener;
        }
    }

    final class m extends dw.b
    {

        final fl tZ;
        private final Invitation ue;

        protected void a(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationReceived(ue);
        }

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            a((OnInvitationReceivedListener)obj);
        }

        m(OnInvitationReceivedListener oninvitationreceivedlistener, Invitation invitation)
        {
            tZ = fl.this;
            super(fl.this, oninvitationreceivedlistener);
            ue = invitation;
        }
    }

    final class n extends dw.b
    {

        final fl tZ;
        private final String uf;

        protected void a(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationRemoved(uf);
        }

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            a((OnInvitationReceivedListener)obj);
        }

        n(OnInvitationReceivedListener oninvitationreceivedlistener, String s1)
        {
            tZ = fl.this;
            super(fl.this, oninvitationreceivedlistener);
            uf = s1;
        }
    }

    final class o extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void k(DataHolder dataholder)
        {
            tZ.a(tZ. new p(jW, dataholder));
        }

        o(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class p extends ao
        implements com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
    {

        final fl tZ;
        private final InvitationBuffer ug;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public InvitationBuffer getInvitations()
        {
            return ug;
        }

        p(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            ug = new InvitationBuffer(dataholder);
        }
    }

    final class q extends b
    {

        final fl tZ;

        public void a(RoomUpdateListener roomupdatelistener, Room room, int i1)
        {
            roomupdatelistener.onJoinedRoom(i1, room);
        }

        public q(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            tZ = fl.this;
            super(roomupdatelistener, dataholder);
        }
    }

    final class r extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void a(DataHolder dataholder, DataHolder dataholder1)
        {
            tZ.a(tZ. new s(jW, dataholder, dataholder1));
        }

        r(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class s extends ao
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
    {

        final fl tZ;
        private final com.google.android.gms.games.leaderboard.a uh = null;
        private final LeaderboardScoreBuffer ui;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public Leaderboard getLeaderboard()
        {
            return uh;
        }

        public LeaderboardScoreBuffer getScores()
        {
            return ui;
        }

        s(com.google.android.gms.common.api.a.c c1, DataHolder dataholder, DataHolder dataholder1)
        {
            tZ = fl.this;
            super(c1, dataholder1);
            fl1 = new LeaderboardBuffer(dataholder);
            if (getCount() <= 0) goto _L2; else goto _L1
_L1:
            uh = (com.google.android.gms.games.leaderboard.a)((Leaderboard)get(0)).freeze();
_L4:
            close();
            ui = new LeaderboardScoreBuffer(dataholder1);
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            c1;
            close();
            throw c1;
        }
    }

    final class t extends fk
    {

        private final com.google.android.gms.common.api.a.c jW;
        final fl tZ;

        public void c(DataHolder dataholder)
        {
            tZ.a(tZ. new u(jW, dataholder));
        }

        t(com.google.android.gms.common.api.a.c c1)
        {
            tZ = fl.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class u extends ao
        implements com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
    {

        final fl tZ;
        private final LeaderboardBuffer uj;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public LeaderboardBuffer getLeaderboards()
        {
            return uj;
        }

        u(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            tZ = fl.this;
            super(c1, dataholder);
            uj = new LeaderboardBuffer(dataholder);
        }
    }

    final class v extends dw.b
    {

        private final int mC;
        final fl tZ;
        private final String uk;

        public void a(RoomUpdateListener roomupdatelistener)
        {
            roomupdatelistener.onLeftRoom(mC, uk);
        }

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            a((RoomUpdateListener)obj);
        }

        v(RoomUpdateListener roomupdatelistener, int i1, String s1)
        {
            tZ = fl.this;
            super(fl.this, roomupdatelistener);
            mC = i1;
            uk = s1;
        }
    }

    final class w extends dw.b
    {

        final fl tZ;
        private final String ul;

        protected void a(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchRemoved(ul);
        }

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            a((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        w(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener, String s1)
        {
            tZ = fl.this;
            super(fl.this, onturnbasedmatchupdatereceivedlistener);
            ul = s1;
        }
    }

    final class x extends fk
    {

        final fl tZ;
        private final OnTurnBasedMatchUpdateReceivedListener um;

        public void onTurnBasedMatchRemoved(String s1)
        {
            tZ.a(tZ. new w(um, s1));
        }

        public void q(DataHolder dataholder)
        {
            TurnBasedMatchBuffer turnbasedmatchbuffer;
            turnbasedmatchbuffer = new TurnBasedMatchBuffer(dataholder);
            dataholder = null;
            if (turnbasedmatchbuffer.getCount() > 0)
            {
                dataholder = (TurnBasedMatch)((TurnBasedMatch)turnbasedmatchbuffer.get(0)).freeze();
            }
            turnbasedmatchbuffer.close();
            if (dataholder != null)
            {
                tZ.a(tZ. new y(um, dataholder));
            }
            return;
            dataholder;
            turnbasedmatchbuffer.close();
            throw dataholder;
        }

        x(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            tZ = fl.this;
            super();
            um = onturnbasedmatchupdatereceivedlistener;
        }
    }

    final class y extends dw.b
    {

        final fl tZ;
        private final TurnBasedMatch un;

        protected void a(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchReceived(un);
        }

        protected void aL()
        {
        }

        protected void b(Object obj)
        {
            a((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        y(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener, TurnBasedMatch turnbasedmatch)
        {
            tZ = fl.this;
            super(fl.this, onturnbasedmatchupdatereceivedlistener);
            un = turnbasedmatch;
        }
    }

    final class z extends dw.b
    {

        final fl tZ;
        private final RealTimeMessage uo;

        public void a(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            if (realtimemessagereceivedlistener != null)
            {
                realtimemessagereceivedlistener.onRealTimeMessageReceived(uo);
            }
        }

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            a((RealTimeMessageReceivedListener)obj);
        }

        z(RealTimeMessageReceivedListener realtimemessagereceivedlistener, RealTimeMessage realtimemessage)
        {
            tZ = fl.this;
            super(fl.this, realtimemessagereceivedlistener);
            uo = realtimemessage;
        }
    }


    private final String jG;
    private boolean tA;
    private int tB;
    private final String tO;
    private final Map tP;
    private PlayerEntity tQ;
    private GameEntity tR;
    private final fq tS;
    private boolean tT;
    private final Binder tU;
    private final long tV;
    private final boolean tW;
    private final int tX;

    public fl(Context context, String s1, String s2, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String as1[], int i1, 
            View view, boolean flag, boolean flag1, int j1)
    {
        this(context, s1, s2, ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new dw.c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new dw.g(onconnectionfailedlistener))), as1, i1, view, flag, flag1, j1, 4368);
    }

    public fl(Context context, String s1, String s2, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as1[], int i1, 
            View view, boolean flag, boolean flag1, int j1, int k1)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, as1);
        tT = false;
        tA = false;
        tO = s1;
        jG = (String)eg.f(s2);
        tU = new Binder();
        tP = new HashMap();
        tS = com.google.android.gms.internal.fq.a(this, i1);
        setViewForPopups(view);
        tA = flag1;
        tB = j1;
        tV = hashCode();
        tW = flag;
        tX = k1;
        registerConnectionCallbacks(this);
        registerConnectionFailedListener(this);
    }

    private Room E(DataHolder dataholder)
    {
        com.google.android.gms.games.multiplayer.realtime.a a1;
        a1 = new com.google.android.gms.games.multiplayer.realtime.a(dataholder);
        dataholder = null;
        if (a1.getCount() > 0)
        {
            dataholder = (Room)((Room)a1.get(0)).freeze();
        }
        a1.close();
        return dataholder;
        dataholder;
        a1.close();
        throw dataholder;
    }

    static Room a(fl fl1, DataHolder dataholder)
    {
        return fl1.E(dataholder);
    }

    private RealTimeSocket ae(String s1)
    {
        Object obj;
        LocalSocket localsocket;
        try
        {
            obj = ((fp)bQ()).ag(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            fn.d("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        localsocket = new LocalSocket();
        localsocket.connect(new LocalSocketAddress(((String) (obj))));
        obj = new fr(localsocket, s1);
        tP.put(s1, obj);
        return ((RealTimeSocket) (obj));
        s1;
        fn.d("GamesClientImpl", (new StringBuilder()).append("connect() call failed on socket: ").append(s1.getMessage()).toString());
        return null;
    }

    private void dc()
    {
        tQ = null;
    }

    private void de()
    {
        for (Iterator iterator = tP.values().iterator(); iterator.hasNext();)
        {
            RealTimeSocket realtimesocket = (RealTimeSocket)iterator.next();
            try
            {
                realtimesocket.close();
            }
            catch (IOException ioexception)
            {
                com.google.android.gms.internal.fn.a("GamesClientImpl", "IOException:", ioexception);
            }
        }

        tP.clear();
    }

    protected fp F(IBinder ibinder)
    {
        return fp.a.H(ibinder);
    }

    public int a(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback, byte abyte0[], String s1, String s2)
    {
        int i1;
        try
        {
            i1 = ((fp)bQ()).a(new an(reliablemessagesentcallback), abyte0, s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public int a(byte abyte0[], String s1, String as1[])
    {
        eg.b(as1, "Participant IDs must not be null");
        int i1;
        try
        {
            i1 = ((fp)bQ()).b(abyte0, s1, as1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    protected void a(int i1, IBinder ibinder, Bundle bundle)
    {
        if (i1 == 0 && bundle != null)
        {
            tT = bundle.getBoolean("show_welcome_popup");
        }
        super.a(i1, ibinder, bundle);
    }

    public void a(IBinder ibinder, Bundle bundle)
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        ((fp)bQ()).a(ibinder, bundle);
        return;
        ibinder;
        com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        return;
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((fp)bQ()).a(new ak(c1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, LeaderboardScoreBuffer leaderboardscorebuffer, int i1, int j1)
    {
        try
        {
            ((fp)bQ()).a(new r(c1), leaderboardscorebuffer.dq().dr(), i1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        try
        {
            ((fp)bQ()).a(new bb(c1), turnbasedmatchconfig.getVariant(), turnbasedmatchconfig.getMinPlayers(), turnbasedmatchconfig.getInvitedPlayerIds(), turnbasedmatchconfig.getAutoMatchCriteria());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((fp)bQ()).c(new ak(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, int i1)
    {
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        c1 = null;
_L1:
        try
        {
            ((fp)bQ()).a(c1, s1, i1, tS.dn(), tS.dm());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_59;
        c1 = new d(c1);
          goto _L1
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((fp)bQ()).a(new r(c1), s1, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, int i1, boolean flag, boolean flag1)
    {
        if (!s1.equals("playedWith"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid player collection: ").append(s1).toString());
        }
        try
        {
            ((fp)bQ()).d(new ak(c1), s1, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, long l1, String s2)
    {
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        c1 = null;
_L1:
        try
        {
            ((fp)bQ()).a(c1, s1, l1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_47;
        c1 = new aw(c1);
          goto _L1
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, String s2)
    {
        try
        {
            ((fp)bQ()).d(new bd(c1), s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, String s2, int i1, int j1)
    {
        try
        {
            ((fp)bQ()).a(new ai(c1), s1, s2, i1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, boolean flag)
    {
        try
        {
            ((fp)bQ()).c(new t(c1), s1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, byte abyte0[], String s2, ParticipantResult aparticipantresult[])
    {
        try
        {
            ((fp)bQ()).a(new bh(c1), s1, abyte0, s2, aparticipantresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, byte abyte0[], ParticipantResult aparticipantresult[])
    {
        try
        {
            ((fp)bQ()).a(new bh(c1), s1, abyte0, aparticipantresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, boolean flag)
    {
        try
        {
            ((fp)bQ()).b(new t(c1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int ai1[])
    {
        try
        {
            ((fp)bQ()).a(new bj(c1), ai1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    protected void a(ec ec1, dw.e e1)
        throws RemoteException
    {
        String s1 = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", tW);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", tA);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", tB);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", tX);
        ec1.a(e1, 0x40ba50, getContext().getPackageName(), jG, bO(), tO, tS.dn(), s1, bundle);
    }

    protected transient void a(String as1[])
    {
        int i1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        while (i1 < as1.length) 
        {
            String s1 = as1[i1];
            boolean flag2;
            if (s1.equals("https://www.googleapis.com/auth/games"))
            {
                flag2 = true;
            } else
            {
                flag2 = flag1;
                if (s1.equals("https://www.googleapis.com/auth/games.firstparty"))
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
            com.google.android.gms.internal.eg.a(flag1, String.format("Cannot have both %s and %s!", new Object[] {
                "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"
            }));
            return;
        } else
        {
            com.google.android.gms.internal.eg.a(flag1, String.format("Games APIs requires %s to function.", new Object[] {
                "https://www.googleapis.com/auth/games"
            }));
            return;
        }
    }

    public Bundle aU()
    {
        Bundle bundle;
        try
        {
            bundle = ((fp)bQ()).aU();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        bundle.setClassLoader(com/google/android/gms/internal/fl.getClassLoader());
        return bundle;
    }

    protected String am()
    {
        return "com.google.android.gms.games.service.START";
    }

    protected String an()
    {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void b(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((fp)bQ()).a(new au(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.c c1, String s1)
    {
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        c1 = null;
_L1:
        try
        {
            ((fp)bQ()).a(c1, s1, tS.dn(), tS.dm());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_58;
        c1 = new d(c1);
          goto _L1
    }

    public void b(com.google.android.gms.common.api.a.c c1, String s1, int i1)
    {
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        c1 = null;
_L1:
        try
        {
            ((fp)bQ()).b(c1, s1, i1, tS.dn(), tS.dm());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_59;
        c1 = new d(c1);
          goto _L1
    }

    public void b(com.google.android.gms.common.api.a.c c1, String s1, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((fp)bQ()).b(new r(c1), s1, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.c c1, boolean flag)
    {
        try
        {
            ((fp)bQ()).a(new f(c1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void c(com.google.android.gms.common.api.a.c c1, String s1)
    {
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        c1 = null;
_L1:
        try
        {
            ((fp)bQ()).b(c1, s1, tS.dn(), tS.dm());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_58;
        c1 = new d(c1);
          goto _L1
    }

    public void clearNotifications(int i1)
    {
        try
        {
            ((fp)bQ()).clearNotifications(i1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void connect()
    {
        dc();
        super.connect();
    }

    public void createRoom(RoomConfig roomconfig)
    {
        try
        {
            aq aq1 = new aq(roomconfig.getRoomUpdateListener(), roomconfig.getRoomStatusUpdateListener(), roomconfig.getMessageReceivedListener());
            ((fp)bQ()).a(aq1, tU, roomconfig.getVariant(), roomconfig.getInvitedPlayerIds(), roomconfig.getAutoMatchCriteria(), roomconfig.isSocketEnabled(), tV);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomConfig roomconfig)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void d(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((fp)bQ()).n(new bb(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public int dd()
    {
        int i1;
        try
        {
            i1 = ((fp)bQ()).dd();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return 4368;
        }
        return i1;
    }

    public void df()
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ((fp)bQ()).df();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        return;
    }

    public void disconnect()
    {
        tT = false;
        if (isConnected())
        {
            try
            {
                fp fp1 = (fp)bQ();
                fp1.df();
                fp1.j(tV);
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.fn.c("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        de();
        super.disconnect();
    }

    public void dismissTurnBasedMatch(String s1)
    {
        try
        {
            ((fp)bQ()).ak(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void e(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((fp)bQ()).o(new bb(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void f(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((fp)bQ()).q(new bd(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void g(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((fp)bQ()).d(new j(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void g(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((fp)bQ()).p(new az(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public Intent getAchievementsIntent()
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getAchievementsIntent();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent getAllLeaderboardsIntent()
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getAllLeaderboardsIntent();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public String getAppId()
    {
        String s1;
        try
        {
            s1 = ((fp)bQ()).getAppId();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public String getCurrentAccountName()
    {
        String s1;
        try
        {
            s1 = ((fp)bQ()).getCurrentAccountName();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public Game getCurrentGame()
    {
        bP();
        this;
        JVM INSTR monitorenter ;
        Object obj = tR;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new GameBuffer(((fp)bQ()).di());
        if (((GameBuffer) (obj)).getCount() > 0)
        {
            tR = (GameEntity)((GameBuffer) (obj)).get(0).freeze();
        }
        ((GameBuffer) (obj)).close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return tR;
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
        com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
          goto _L1
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Player getCurrentPlayer()
    {
        bP();
        this;
        JVM INSTR monitorenter ;
        Object obj = tQ;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new PlayerBuffer(((fp)bQ()).dg());
        if (((PlayerBuffer) (obj)).getCount() > 0)
        {
            tQ = (PlayerEntity)((PlayerBuffer) (obj)).get(0).freeze();
        }
        ((PlayerBuffer) (obj)).close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return tQ;
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
        com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
          goto _L1
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getCurrentPlayerId()
    {
        String s1;
        try
        {
            s1 = ((fp)bQ()).getCurrentPlayerId();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public Intent getInvitationInboxIntent()
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getInvitationInboxIntent();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent getLeaderboardIntent(String s1)
    {
        try
        {
            s1 = ((fp)bQ()).getLeaderboardIntent(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public Intent getMatchInboxIntent()
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getMatchInboxIntent();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public int getMaxTurnBasedMatchDataSize()
    {
        int i1;
        try
        {
            i1 = ((fp)bQ()).getMaxTurnBasedMatchDataSize();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return 2;
        }
        return i1;
    }

    public Intent getPlayerSearchIntent()
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getPlayerSearchIntent();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent getRealTimeSelectOpponentsIntent(int i1, int j1, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getRealTimeSelectOpponentsIntent(i1, j1, flag);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String s1, String s2)
    {
label0:
        {
            if (s2 == null || !ParticipantUtils.am(s2))
            {
                throw new IllegalArgumentException("Bad participant ID");
            }
            RealTimeSocket realtimesocket = (RealTimeSocket)tP.get(s2);
            if (realtimesocket != null)
            {
                s1 = realtimesocket;
                if (!realtimesocket.isClosed())
                {
                    break label0;
                }
            }
            s1 = ae(s2);
        }
        return s1;
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int i1)
    {
        try
        {
            room = ((fp)bQ()).a((RoomEntity)room.freeze(), i1);
        }
        // Misplaced declaration of an exception variable
        catch (Room room)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return room;
    }

    public Intent getSettingsIntent()
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getSettingsIntent();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent getTurnBasedSelectOpponentsIntent(int i1, int j1, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((fp)bQ()).getTurnBasedSelectOpponentsIntent(i1, j1, flag);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public void h(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((fp)bQ()).e(new o(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void h(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((fp)bQ()).r(new bf(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void i(String s1, int i1)
    {
        try
        {
            ((fp)bQ()).i(s1, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void j(String s1, int i1)
    {
        try
        {
            ((fp)bQ()).j(s1, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void joinRoom(RoomConfig roomconfig)
    {
        try
        {
            aq aq1 = new aq(roomconfig.getRoomUpdateListener(), roomconfig.getRoomStatusUpdateListener(), roomconfig.getMessageReceivedListener());
            ((fp)bQ()).a(aq1, tU, roomconfig.getInvitationId(), roomconfig.isSocketEnabled(), tV);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomConfig roomconfig)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void leaveRoom(RoomUpdateListener roomupdatelistener, String s1)
    {
        try
        {
            ((fp)bQ()).e(new aq(roomupdatelistener), s1);
            de();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomUpdateListener roomupdatelistener)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle bundle)
    {
        if (tT)
        {
            tS.dl();
            tT = false;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        tT = false;
    }

    public void onConnectionSuspended(int i1)
    {
    }

    protected IInterface p(IBinder ibinder)
    {
        return F(ibinder);
    }

    public void registerInvitationListener(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        try
        {
            oninvitationreceivedlistener = new l(oninvitationreceivedlistener);
            ((fp)bQ()).a(oninvitationreceivedlistener, tV);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void registerMatchUpdateListener(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        try
        {
            onturnbasedmatchupdatereceivedlistener = new x(onturnbasedmatchupdatereceivedlistener);
            ((fp)bQ()).b(onturnbasedmatchupdatereceivedlistener, tV);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public int sendUnreliableRealTimeMessageToAll(byte abyte0[], String s1)
    {
        int i1;
        try
        {
            i1 = ((fp)bQ()).b(abyte0, s1, null);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public void setGravityForPopups(int i1)
    {
        tS.setGravity(i1);
    }

    public void setViewForPopups(View view)
    {
        tS.e(view);
    }

    public void unregisterInvitationListener()
    {
        try
        {
            ((fp)bQ()).k(tV);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }

    public void unregisterMatchUpdateListener()
    {
        try
        {
            ((fp)bQ()).l(tV);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fn.c("GamesClientImpl", "service died");
        }
    }
}
