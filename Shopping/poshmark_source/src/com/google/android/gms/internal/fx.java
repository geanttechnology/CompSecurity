// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

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
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            eh, er, gd, gb, 
//            fz, gc, ge, en, 
//            fw, gs, hb

public final class fx extends eh
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{
    abstract class a extends c
    {

        private final ArrayList GI = new ArrayList();
        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            a(roomstatusupdatelistener, room, GI);
        }

        protected abstract void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist);

        a(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder);
            int i1 = 0;
            for (int j1 = as1.length; i1 < j1; i1++)
            {
                GI.add(as1[i1]);
            }

        }
    }

    final class aa extends eh.b
    {

        final fx GJ;
        private final String GZ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            if (roomstatusupdatelistener != null)
            {
                roomstatusupdatelistener.onP2PConnected(GZ);
            }
        }

        public volatile void a(Object obj)
        {
            a((RoomStatusUpdateListener)obj);
        }

        protected void cP()
        {
        }

        aa(RoomStatusUpdateListener roomstatusupdatelistener, String s1)
        {
            GJ = fx.this;
            super(fx.this, roomstatusupdatelistener);
            GZ = s1;
        }
    }

    final class ab extends eh.b
    {

        final fx GJ;
        private final String GZ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            if (roomstatusupdatelistener != null)
            {
                roomstatusupdatelistener.onP2PDisconnected(GZ);
            }
        }

        public volatile void a(Object obj)
        {
            a((RoomStatusUpdateListener)obj);
        }

        protected void cP()
        {
        }

        ab(RoomStatusUpdateListener roomstatusupdatelistener, String s1)
        {
            GJ = fx.this;
            super(fx.this, roomstatusupdatelistener);
            GZ = s1;
        }
    }

    final class ac extends a
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeersConnected(room, arraylist);
        }

        ac(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ad extends a
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerDeclined(room, arraylist);
        }

        ad(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ae extends a
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeersDisconnected(room, arraylist);
        }

        ae(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class af extends a
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerInvitedToRoom(room, arraylist);
        }

        af(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ag extends a
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerJoined(room, arraylist);
        }

        ag(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ah extends a
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room, ArrayList arraylist)
        {
            roomstatusupdatelistener.onPeerLeft(room, arraylist);
        }

        ah(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder, String as1[])
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder, as1);
        }
    }

    final class ai extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void C(DataHolder dataholder)
        {
            GJ.a(GJ. new aj(vj, dataholder));
        }

        ai(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class aj extends eh.d
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
    {

        final fx GJ;
        private final com.google.android.gms.games.leaderboard.d Ha = null;
        private final Status vl;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public LeaderboardScore getScore()
        {
            return Ha;
        }

        public Status getStatus()
        {
            return vl;
        }

        aj(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(fx.this, c1, dataholder);
            vl = new Status(dataholder.getStatusCode());
            fx1 = new LeaderboardScoreBuffer(dataholder);
            if (getCount() <= 0) goto _L2; else goto _L1
_L1:
            Ha = (com.google.android.gms.games.leaderboard.d)get(0).freeze();
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

    final class ak extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void e(DataHolder dataholder)
        {
            GJ.a(GJ. new al(vj, dataholder));
        }

        ak(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class al extends av
        implements com.google.android.gms.games.Players.LoadPlayersResult
    {

        final fx GJ;
        private final PlayerBuffer Hb;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public PlayerBuffer getPlayers()
        {
            return Hb;
        }

        al(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            Hb = new PlayerBuffer(dataholder);
        }
    }

    final class am extends eh.b
    {

        final fx GJ;
        private final String Hc;
        private final int Hd;
        private final int yJ;

        public void a(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            if (reliablemessagesentcallback != null)
            {
                reliablemessagesentcallback.onRealTimeMessageSent(yJ, Hd, Hc);
            }
        }

        public volatile void a(Object obj)
        {
            a((com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback)obj);
        }

        protected void cP()
        {
        }

        am(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback, int i1, int j1, String s1)
        {
            GJ = fx.this;
            super(fx.this, reliablemessagesentcallback);
            yJ = i1;
            Hd = j1;
            Hc = s1;
        }
    }

    final class an extends fw
    {

        final fx GJ;
        final com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback He;

        public void b(int i1, int j1, String s1)
        {
            GJ.a(GJ. new am(He, i1, j1, s1));
        }

        public an(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            GJ = fx.this;
            super();
            He = reliablemessagesentcallback;
        }
    }

    final class ao extends fw
    {

        final fx GJ;
        private final OnRequestReceivedListener Hf;

        public void m(DataHolder dataholder)
        {
            GameRequestBuffer gamerequestbuffer;
            gamerequestbuffer = new GameRequestBuffer(dataholder);
            dataholder = null;
            if (gamerequestbuffer.getCount() > 0)
            {
                dataholder = (GameRequest)((GameRequest)gamerequestbuffer.get(0)).freeze();
            }
            gamerequestbuffer.close();
            if (dataholder != null)
            {
                GJ.a(GJ. new ap(Hf, dataholder));
            }
            return;
            dataholder;
            gamerequestbuffer.close();
            throw dataholder;
        }

        public void onRequestRemoved(String s1)
        {
            GJ.a(GJ. new aq(Hf, s1));
        }

        ao(OnRequestReceivedListener onrequestreceivedlistener)
        {
            GJ = fx.this;
            super();
            Hf = onrequestreceivedlistener;
        }
    }

    final class ap extends eh.b
    {

        final fx GJ;
        private final GameRequest Hg;

        protected void a(Object obj)
        {
            b((OnRequestReceivedListener)obj);
        }

        protected void b(OnRequestReceivedListener onrequestreceivedlistener)
        {
            onrequestreceivedlistener.onRequestReceived(Hg);
        }

        protected void cP()
        {
        }

        ap(OnRequestReceivedListener onrequestreceivedlistener, GameRequest gamerequest)
        {
            GJ = fx.this;
            super(fx.this, onrequestreceivedlistener);
            Hg = gamerequest;
        }
    }

    final class aq extends eh.b
    {

        final fx GJ;
        private final String Hh;

        protected void a(Object obj)
        {
            b((OnRequestReceivedListener)obj);
        }

        protected void b(OnRequestReceivedListener onrequestreceivedlistener)
        {
            onrequestreceivedlistener.onRequestRemoved(Hh);
        }

        protected void cP()
        {
        }

        aq(OnRequestReceivedListener onrequestreceivedlistener, String s1)
        {
            GJ = fx.this;
            super(fx.this, onrequestreceivedlistener);
            Hh = s1;
        }
    }

    final class ar extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hi;

        public void b(int i1, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = new Status(i1);
            GJ.a(GJ. new as(Hi, status, bundle));
        }

        public ar(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hi = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class as extends eh.b
        implements com.google.android.gms.games.request.Requests.LoadRequestsResult
    {

        final fx GJ;
        private final Bundle Hj;
        private final Status vl;

        protected void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        protected void cP()
        {
            release();
        }

        public GameRequestBuffer getRequests(int i1)
        {
            String s1 = gs.aW(i1);
            if (!Hj.containsKey(s1))
            {
                return null;
            } else
            {
                return new GameRequestBuffer((DataHolder)Hj.get(s1));
            }
        }

        public Status getStatus()
        {
            return vl;
        }

        public void release()
        {
            Iterator iterator = Hj.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (String)iterator.next();
                obj = (DataHolder)Hj.getParcelable(((String) (obj)));
                if (obj != null)
                {
                    ((DataHolder) (obj)).close();
                }
            } while (true);
        }

        as(com.google.android.gms.common.api.a.c c1, Status status, Bundle bundle)
        {
            GJ = fx.this;
            super(fx.this, c1);
            vl = status;
            Hj = bundle;
        }
    }

    final class at extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hk;

        public void D(DataHolder dataholder)
        {
            GJ.a(GJ. new au(Hk, dataholder));
        }

        public at(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hk = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class au extends av
        implements com.google.android.gms.games.request.Requests.UpdateRequestsResult
    {

        final fx GJ;
        private final hb Hl;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public Set getRequestIds()
        {
            return Hl.getRequestIds();
        }

        public int getRequestOutcome(String s1)
        {
            return Hl.getRequestOutcome(s1);
        }

        au(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            Hl = hb.H(dataholder);
        }
    }

    abstract class av extends eh.d
        implements Releasable, Result
    {

        final fx GJ;
        final Status vl;
        final DataHolder zU;

        public Status getStatus()
        {
            return vl;
        }

        public void release()
        {
            if (zU != null)
            {
                zU.close();
            }
        }

        public av(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(fx.this, c1, dataholder);
            vl = new Status(dataholder.getStatusCode());
            zU = dataholder;
        }
    }

    final class aw extends c
    {

        final fx GJ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onRoomAutoMatching(room);
        }

        aw(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class ax extends fw
    {

        final fx GJ;
        private final RoomUpdateListener Hm;
        private final RoomStatusUpdateListener Hn;
        private final RealTimeMessageReceivedListener Ho;

        public void a(DataHolder dataholder, String as1[])
        {
            GJ.a(GJ. new af(Hn, dataholder, as1));
        }

        public void b(DataHolder dataholder, String as1[])
        {
            GJ.a(GJ. new ag(Hn, dataholder, as1));
        }

        public void c(DataHolder dataholder, String as1[])
        {
            GJ.a(GJ. new ah(Hn, dataholder, as1));
        }

        public void d(DataHolder dataholder, String as1[])
        {
            GJ.a(GJ. new ad(Hn, dataholder, as1));
        }

        public void e(DataHolder dataholder, String as1[])
        {
            GJ.a(GJ. new ac(Hn, dataholder, as1));
        }

        public void f(DataHolder dataholder, String as1[])
        {
            GJ.a(GJ. new ae(Hn, dataholder, as1));
        }

        public void onLeftRoom(int i1, String s1)
        {
            GJ.a(GJ. new v(Hm, i1, s1));
        }

        public void onP2PConnected(String s1)
        {
            GJ.a(GJ. new aa(Hn, s1));
        }

        public void onP2PDisconnected(String s1)
        {
            GJ.a(GJ. new ab(Hn, s1));
        }

        public void onRealTimeMessageReceived(RealTimeMessage realtimemessage)
        {
            GJ.a(GJ. new z(Ho, realtimemessage));
        }

        public void s(DataHolder dataholder)
        {
            GJ.a(GJ. new ba(Hm, dataholder));
        }

        public void t(DataHolder dataholder)
        {
            GJ.a(GJ. new q(Hm, dataholder));
        }

        public void u(DataHolder dataholder)
        {
            GJ.a(GJ. new az(Hn, dataholder));
        }

        public void v(DataHolder dataholder)
        {
            GJ.a(GJ. new aw(Hn, dataholder));
        }

        public void w(DataHolder dataholder)
        {
            GJ.a(GJ. new ay(Hm, dataholder));
        }

        public void x(DataHolder dataholder)
        {
            GJ.a(GJ. new h(Hn, dataholder));
        }

        public void y(DataHolder dataholder)
        {
            GJ.a(GJ. new i(Hn, dataholder));
        }

        public ax(RoomUpdateListener roomupdatelistener)
        {
            GJ = fx.this;
            super();
            Hm = (RoomUpdateListener)er.b(roomupdatelistener, "Callbacks must not be null");
            Hn = null;
            Ho = null;
        }

        public ax(RoomUpdateListener roomupdatelistener, RoomStatusUpdateListener roomstatusupdatelistener, RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            GJ = fx.this;
            super();
            Hm = (RoomUpdateListener)er.b(roomupdatelistener, "Callbacks must not be null");
            Hn = roomstatusupdatelistener;
            Ho = realtimemessagereceivedlistener;
        }
    }

    final class ay extends b
    {

        final fx GJ;

        public void a(RoomUpdateListener roomupdatelistener, Room room, int i1)
        {
            roomupdatelistener.onRoomConnected(i1, room);
        }

        ay(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomupdatelistener, dataholder);
        }
    }

    final class az extends c
    {

        final fx GJ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onRoomConnecting(room);
        }

        az(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    abstract class b extends eh.d
    {

        final fx GJ;

        protected void a(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            a(roomupdatelistener, com.google.android.gms.internal.fx.a(GJ, dataholder), dataholder.getStatusCode());
        }

        protected abstract void a(RoomUpdateListener roomupdatelistener, Room room, int i1);

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((RoomUpdateListener)obj, dataholder);
        }

        b(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(fx.this, roomupdatelistener, dataholder);
        }
    }

    final class ba extends b
    {

        final fx GJ;

        public void a(RoomUpdateListener roomupdatelistener, Room room, int i1)
        {
            roomupdatelistener.onRoomCreated(i1, room);
        }

        public ba(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomupdatelistener, dataholder);
        }
    }

    final class bb extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void cM()
        {
            Status status = new Status(0);
            GJ.a(GJ. new bc(vj, status));
        }

        public bb(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class bc extends eh.b
    {

        final fx GJ;
        private final Status vl;

        public void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(vl);
        }

        protected void cP()
        {
        }

        public bc(com.google.android.gms.common.api.a.c c1, Status status)
        {
            GJ = fx.this;
            super(fx.this, c1);
            vl = status;
        }
    }

    final class bd extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void d(DataHolder dataholder)
        {
            GJ.a(GJ. new be(vj, dataholder));
        }

        public bd(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class be extends av
        implements com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
    {

        final fx GJ;
        private final ScoreSubmissionData Hp;

        public void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        public volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public ScoreSubmissionData getScoreData()
        {
            return Hp;
        }

        public be(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            Hp = new ScoreSubmissionData(dataholder);
            dataholder.close();
            return;
            fx1;
            dataholder.close();
            throw fx.this;
        }
    }

    abstract class bf extends av
    {

        final fx GJ;
        final TurnBasedMatch GX = null;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            h(c1);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public TurnBasedMatch getMatch()
        {
            return GX;
        }

        abstract void h(com.google.android.gms.common.api.a.c c1);

        bf(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            fx1 = new TurnBasedMatchBuffer(dataholder);
            if (getCount() <= 0) goto _L2; else goto _L1
_L1:
            GX = (TurnBasedMatch)((TurnBasedMatch)get(0)).freeze();
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

    final class bg extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hq;

        public void f(int i1, String s1)
        {
            Status status = new Status(i1);
            GJ.a(GJ. new bh(Hq, status, s1));
        }

        public bg(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hq = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class bh extends eh.b
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
    {

        final fx GJ;
        private final String Hr;
        private final Status vl;

        public void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        protected void cP()
        {
        }

        public String getMatchId()
        {
            return Hr;
        }

        public Status getStatus()
        {
            return vl;
        }

        bh(com.google.android.gms.common.api.a.c c1, Status status, String s1)
        {
            GJ = fx.this;
            super(fx.this, c1);
            vl = status;
            Hr = s1;
        }
    }

    final class bi extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hs;

        public void o(DataHolder dataholder)
        {
            GJ.a(GJ. new bj(Hs, dataholder));
        }

        public bi(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hs = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class bj extends bf
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult
    {

        final fx GJ;

        protected void h(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        bj(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
        }
    }

    final class bk extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Ht;

        public void q(DataHolder dataholder)
        {
            GJ.a(GJ. new bl(Ht, dataholder));
        }

        public bk(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Ht = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class bl extends bf
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult
    {

        final fx GJ;

        protected void h(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        bl(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
        }
    }

    final class bm extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hu;

        public void n(DataHolder dataholder)
        {
            GJ.a(GJ. new bn(Hu, dataholder));
        }

        public bm(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hu = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class bn extends bf
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult
    {

        final fx GJ;

        protected void h(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        bn(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
        }
    }

    final class bo extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hv;

        public void p(DataHolder dataholder)
        {
            GJ.a(GJ. new bp(Hv, dataholder));
        }

        public bo(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hv = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class bp extends bf
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
    {

        final fx GJ;

        protected void h(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        bp(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
        }
    }

    final class bq extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c Hw;

        public void a(int i1, Bundle bundle)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Status status = new Status(i1);
            GJ.a(GJ. new br(Hw, status, bundle));
        }

        public bq(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            Hw = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class br extends eh.b
        implements com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
    {

        final fx GJ;
        private final LoadMatchesResponse Hx;
        private final Status vl;

        protected void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        protected void cP()
        {
        }

        public LoadMatchesResponse getMatches()
        {
            return Hx;
        }

        public Status getStatus()
        {
            return vl;
        }

        public void release()
        {
            Hx.close();
        }

        br(com.google.android.gms.common.api.a.c c1, Status status, Bundle bundle)
        {
            GJ = fx.this;
            super(fx.this, c1);
            vl = status;
            Hx = new LoadMatchesResponse(bundle);
        }
    }

    abstract class c extends eh.d
    {

        final fx GJ;

        protected void a(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            a(roomstatusupdatelistener, com.google.android.gms.internal.fx.a(GJ, dataholder));
        }

        protected abstract void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room);

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((RoomStatusUpdateListener)obj, dataholder);
        }

        c(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(fx.this, roomstatusupdatelistener, dataholder);
        }
    }

    final class d extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void e(int i1, String s1)
        {
            GJ.a(GJ. new e(vj, i1, s1));
        }

        d(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class e extends eh.b
        implements com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
    {

        final fx GJ;
        private final String GK;
        private final Status vl;

        protected void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        protected void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        protected void cP()
        {
        }

        public String getAchievementId()
        {
            return GK;
        }

        public Status getStatus()
        {
            return vl;
        }

        e(com.google.android.gms.common.api.a.c c1, int i1, String s1)
        {
            GJ = fx.this;
            super(fx.this, c1);
            vl = new Status(i1);
            GK = s1;
        }
    }

    final class f extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void b(DataHolder dataholder)
        {
            GJ.a(GJ. new g(vj, dataholder));
        }

        f(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class g extends av
        implements com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
    {

        final fx GJ;
        private final AchievementBuffer GL;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public AchievementBuffer getAchievements()
        {
            return GL;
        }

        g(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            GL = new AchievementBuffer(dataholder);
        }
    }

    final class h extends c
    {

        final fx GJ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onConnectedToRoom(room);
        }

        h(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class i extends c
    {

        final fx GJ;

        public void a(RoomStatusUpdateListener roomstatusupdatelistener, Room room)
        {
            roomstatusupdatelistener.onDisconnectedFromRoom(room);
        }

        i(RoomStatusUpdateListener roomstatusupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomstatusupdatelistener, dataholder);
        }
    }

    final class j extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void g(DataHolder dataholder)
        {
            GJ.a(GJ. new k(vj, dataholder));
        }

        j(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class k extends av
        implements com.google.android.gms.games.GamesMetadata.LoadGamesResult
    {

        final fx GJ;
        private final GameBuffer GM;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public GameBuffer getGames()
        {
            return GM;
        }

        k(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            GM = new GameBuffer(dataholder);
        }
    }

    final class l extends fw
    {

        final fx GJ;
        private final OnInvitationReceivedListener GN;

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
                GJ.a(GJ. new m(GN, dataholder));
            }
            return;
            dataholder;
            invitationbuffer.close();
            throw dataholder;
        }

        public void onInvitationRemoved(String s1)
        {
            GJ.a(GJ. new n(GN, s1));
        }

        l(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            GJ = fx.this;
            super();
            GN = oninvitationreceivedlistener;
        }
    }

    final class m extends eh.b
    {

        final fx GJ;
        private final Invitation GO;

        protected void a(Object obj)
        {
            b((OnInvitationReceivedListener)obj);
        }

        protected void b(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationReceived(GO);
        }

        protected void cP()
        {
        }

        m(OnInvitationReceivedListener oninvitationreceivedlistener, Invitation invitation)
        {
            GJ = fx.this;
            super(fx.this, oninvitationreceivedlistener);
            GO = invitation;
        }
    }

    final class n extends eh.b
    {

        final fx GJ;
        private final String GP;

        protected void a(Object obj)
        {
            b((OnInvitationReceivedListener)obj);
        }

        protected void b(OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            oninvitationreceivedlistener.onInvitationRemoved(GP);
        }

        protected void cP()
        {
        }

        n(OnInvitationReceivedListener oninvitationreceivedlistener, String s1)
        {
            GJ = fx.this;
            super(fx.this, oninvitationreceivedlistener);
            GP = s1;
        }
    }

    final class o extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void k(DataHolder dataholder)
        {
            GJ.a(GJ. new p(vj, dataholder));
        }

        o(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class p extends av
        implements com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
    {

        final fx GJ;
        private final InvitationBuffer GQ;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public InvitationBuffer getInvitations()
        {
            return GQ;
        }

        p(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            GQ = new InvitationBuffer(dataholder);
        }
    }

    final class q extends b
    {

        final fx GJ;

        public void a(RoomUpdateListener roomupdatelistener, Room room, int i1)
        {
            roomupdatelistener.onJoinedRoom(i1, room);
        }

        public q(RoomUpdateListener roomupdatelistener, DataHolder dataholder)
        {
            GJ = fx.this;
            super(roomupdatelistener, dataholder);
        }
    }

    final class r extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void a(DataHolder dataholder, DataHolder dataholder1)
        {
            GJ.a(GJ. new s(vj, dataholder, dataholder1));
        }

        r(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class s extends av
        implements com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
    {

        final fx GJ;
        private final com.google.android.gms.games.leaderboard.a GR = null;
        private final LeaderboardScoreBuffer GS;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public Leaderboard getLeaderboard()
        {
            return GR;
        }

        public LeaderboardScoreBuffer getScores()
        {
            return GS;
        }

        s(com.google.android.gms.common.api.a.c c1, DataHolder dataholder, DataHolder dataholder1)
        {
            GJ = fx.this;
            super(c1, dataholder1);
            fx1 = new LeaderboardBuffer(dataholder);
            if (getCount() <= 0) goto _L2; else goto _L1
_L1:
            GR = (com.google.android.gms.games.leaderboard.a)((Leaderboard)get(0)).freeze();
_L4:
            close();
            GS = new LeaderboardScoreBuffer(dataholder1);
            return;
_L2:
            if (true) goto _L4; else goto _L3
_L3:
            c1;
            close();
            throw c1;
        }
    }

    final class t extends fw
    {

        final fx GJ;
        private final com.google.android.gms.common.api.a.c vj;

        public void c(DataHolder dataholder)
        {
            GJ.a(GJ. new u(vj, dataholder));
        }

        t(com.google.android.gms.common.api.a.c c1)
        {
            GJ = fx.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class u extends av
        implements com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
    {

        final fx GJ;
        private final LeaderboardBuffer GT;

        protected void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        protected volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public LeaderboardBuffer getLeaderboards()
        {
            return GT;
        }

        u(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            GJ = fx.this;
            super(c1, dataholder);
            GT = new LeaderboardBuffer(dataholder);
        }
    }

    final class v extends eh.b
    {

        final fx GJ;
        private final String GU;
        private final int yJ;

        public void a(RoomUpdateListener roomupdatelistener)
        {
            roomupdatelistener.onLeftRoom(yJ, GU);
        }

        public volatile void a(Object obj)
        {
            a((RoomUpdateListener)obj);
        }

        protected void cP()
        {
        }

        v(RoomUpdateListener roomupdatelistener, int i1, String s1)
        {
            GJ = fx.this;
            super(fx.this, roomupdatelistener);
            yJ = i1;
            GU = s1;
        }
    }

    final class w extends eh.b
    {

        final fx GJ;
        private final String GV;

        protected void a(Object obj)
        {
            b((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        protected void b(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchRemoved(GV);
        }

        protected void cP()
        {
        }

        w(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener, String s1)
        {
            GJ = fx.this;
            super(fx.this, onturnbasedmatchupdatereceivedlistener);
            GV = s1;
        }
    }

    final class x extends fw
    {

        final fx GJ;
        private final OnTurnBasedMatchUpdateReceivedListener GW;

        public void onTurnBasedMatchRemoved(String s1)
        {
            GJ.a(GJ. new w(GW, s1));
        }

        public void r(DataHolder dataholder)
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
                GJ.a(GJ. new y(GW, dataholder));
            }
            return;
            dataholder;
            turnbasedmatchbuffer.close();
            throw dataholder;
        }

        x(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            GJ = fx.this;
            super();
            GW = onturnbasedmatchupdatereceivedlistener;
        }
    }

    final class y extends eh.b
    {

        final fx GJ;
        private final TurnBasedMatch GX;

        protected void a(Object obj)
        {
            b((OnTurnBasedMatchUpdateReceivedListener)obj);
        }

        protected void b(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            onturnbasedmatchupdatereceivedlistener.onTurnBasedMatchReceived(GX);
        }

        protected void cP()
        {
        }

        y(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener, TurnBasedMatch turnbasedmatch)
        {
            GJ = fx.this;
            super(fx.this, onturnbasedmatchupdatereceivedlistener);
            GX = turnbasedmatch;
        }
    }

    final class z extends eh.b
    {

        final fx GJ;
        private final RealTimeMessage GY;

        public void a(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            if (realtimemessagereceivedlistener != null)
            {
                realtimemessagereceivedlistener.onRealTimeMessageReceived(GY);
            }
        }

        public volatile void a(Object obj)
        {
            a((RealTimeMessageReceivedListener)obj);
        }

        protected void cP()
        {
        }

        z(RealTimeMessageReceivedListener realtimemessagereceivedlistener, RealTimeMessage realtimemessage)
        {
            GJ = fx.this;
            super(fx.this, realtimemessagereceivedlistener);
            GY = realtimemessage;
        }
    }


    private boolean GA;
    private boolean GB;
    private int GC;
    private final Binder GD = new Binder();
    private final long GE = (long)hashCode();
    private final boolean GF;
    private final int GG;
    private final boolean GH;
    private final String Gv;
    private final Map Gw = new HashMap();
    private PlayerEntity Gx;
    private GameEntity Gy;
    private final gd Gz;
    private final String vi;

    public fx(Context context, Looper looper, String s1, String s2, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as1[], 
            int i1, View view, boolean flag, boolean flag1, int j1, boolean flag2, int k1)
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, as1);
        GA = false;
        GB = false;
        Gv = s1;
        vi = (String)er.f(s2);
        Gz = com.google.android.gms.internal.gd.a(this, i1);
        e(view);
        GB = flag1;
        GC = j1;
        GF = flag;
        GH = flag2;
        GG = k1;
        registerConnectionCallbacks(this);
        registerConnectionFailedListener(this);
    }

    private Room G(DataHolder dataholder)
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

    static Room a(fx fx1, DataHolder dataholder)
    {
        return fx1.G(dataholder);
    }

    private RealTimeSocket aw(String s1)
    {
        Object obj;
        LocalSocket localsocket;
        try
        {
            obj = ((gb)eb()).aD(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fz.h("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        com.google.android.gms.internal.fz.f("GamesClientImpl", "Created native libjingle socket.");
        obj = new gc(((android.os.ParcelFileDescriptor) (obj)));
        Gw.put(s1, obj);
        return ((RealTimeSocket) (obj));
        com.google.android.gms.internal.fz.f("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
        obj = ((gb)eb()).ay(s1);
        if (obj == null)
        {
            return null;
        }
        localsocket = new LocalSocket();
        localsocket.connect(new LocalSocketAddress(((String) (obj))));
        obj = new ge(localsocket, s1);
        Gw.put(s1, obj);
        return ((RealTimeSocket) (obj));
        s1;
        com.google.android.gms.internal.fz.h("GamesClientImpl", (new StringBuilder()).append("connect() call failed on socket: ").append(s1.getMessage()).toString());
        return null;
    }

    private void fG()
    {
        for (Iterator iterator = Gw.values().iterator(); iterator.hasNext();)
        {
            RealTimeSocket realtimesocket = (RealTimeSocket)iterator.next();
            try
            {
                realtimesocket.close();
            }
            catch (IOException ioexception)
            {
                com.google.android.gms.internal.fz.a("GamesClientImpl", "IOException:", ioexception);
            }
        }

        Gw.clear();
    }

    private void fm()
    {
        Gx = null;
    }

    protected gb H(IBinder ibinder)
    {
        return gb.a.J(ibinder);
    }

    public int a(com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback, byte abyte0[], String s1, String s2)
    {
        int i1;
        try
        {
            i1 = ((gb)eb()).a(new an(reliablemessagesentcallback), abyte0, s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public int a(byte abyte0[], String s1, String as1[])
    {
        er.b(as1, "Participant IDs must not be null");
        int i1;
        try
        {
            i1 = ((gb)eb()).b(abyte0, s1, as1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public Intent a(int i1, int j1, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).a(i1, j1, flag);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent a(int i1, byte abyte0[], int j1, Bitmap bitmap, String s1)
    {
        try
        {
            abyte0 = ((gb)eb()).a(i1, abyte0, j1, s1);
            er.b(bitmap, "Must provide a non null icon");
            abyte0.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return abyte0;
    }

    public Intent a(Room room, int i1)
    {
        try
        {
            room = ((gb)eb()).a((RoomEntity)room.freeze(), i1);
        }
        // Misplaced declaration of an exception variable
        catch (Room room)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return room;
    }

    protected void a(int i1, IBinder ibinder, Bundle bundle)
    {
        if (i1 == 0 && bundle != null)
        {
            GA = bundle.getBoolean("show_welcome_popup");
        }
        super.a(i1, ibinder, bundle);
    }

    public void a(IBinder ibinder, Bundle bundle)
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        ((gb)eb()).a(ibinder, bundle);
        return;
        ibinder;
        com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        return;
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i1, int j1, int k1)
    {
        try
        {
            ((gb)eb()).a(new ar(c1), i1, j1, k1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i1, boolean flag, boolean flag1)
    {
        try
        {
            ((gb)eb()).a(new ak(c1), i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i1, int ai1[])
    {
        try
        {
            ((gb)eb()).a(new bq(c1), i1, ai1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, LeaderboardScoreBuffer leaderboardscorebuffer, int i1, int j1)
    {
        try
        {
            ((gb)eb()).a(new r(c1), leaderboardscorebuffer.fX().fY(), i1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, TurnBasedMatchConfig turnbasedmatchconfig)
    {
        try
        {
            ((gb)eb()).a(new bi(c1), turnbasedmatchconfig.getVariant(), turnbasedmatchconfig.getMinPlayers(), turnbasedmatchconfig.getInvitedPlayerIds(), turnbasedmatchconfig.getAutoMatchCriteria());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((gb)eb()).a(new ak(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
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
            ((gb)eb()).a(c1, s1, i1, Gz.fP(), Gz.fO());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_59;
        c1 = new d(c1);
          goto _L1
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((gb)eb()).a(new r(c1), s1, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
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
            ((gb)eb()).d(new ak(c1), s1, i1, flag, flag1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
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
            ((gb)eb()).a(c1, s1, l1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_47;
        c1 = new bd(c1);
          goto _L1
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, String s2)
    {
        try
        {
            ((gb)eb()).c(new bk(c1), s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, String s2, int i1, int j1)
    {
        try
        {
            ((gb)eb()).a(new ai(c1), s1, s2, i1, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, boolean flag)
    {
        try
        {
            ((gb)eb()).c(new t(c1), s1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, byte abyte0[], String s2, ParticipantResult aparticipantresult[])
    {
        try
        {
            ((gb)eb()).a(new bo(c1), s1, abyte0, s2, aparticipantresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String s1, byte abyte0[], ParticipantResult aparticipantresult[])
    {
        try
        {
            ((gb)eb()).a(new bo(c1), s1, abyte0, aparticipantresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, boolean flag)
    {
        try
        {
            ((gb)eb()).c(new ak(c1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, String as1[])
    {
        try
        {
            ((gb)eb()).a(new at(c1), as1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        try
        {
            oninvitationreceivedlistener = new l(oninvitationreceivedlistener);
            ((gb)eb()).a(oninvitationreceivedlistener, GE);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnInvitationReceivedListener oninvitationreceivedlistener)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(RoomConfig roomconfig)
    {
        try
        {
            ax ax1 = new ax(roomconfig.getRoomUpdateListener(), roomconfig.getRoomStatusUpdateListener(), roomconfig.getMessageReceivedListener());
            ((gb)eb()).a(ax1, GD, roomconfig.getVariant(), roomconfig.getInvitedPlayerIds(), roomconfig.getAutoMatchCriteria(), roomconfig.isSocketEnabled(), GE);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomConfig roomconfig)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(RoomUpdateListener roomupdatelistener, String s1)
    {
        try
        {
            ((gb)eb()).c(new ax(roomupdatelistener), s1);
            fG();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomUpdateListener roomupdatelistener)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
    {
        try
        {
            onturnbasedmatchupdatereceivedlistener = new x(onturnbasedmatchupdatereceivedlistener);
            ((gb)eb()).b(onturnbasedmatchupdatereceivedlistener, GE);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnTurnBasedMatchUpdateReceivedListener onturnbasedmatchupdatereceivedlistener)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void a(OnRequestReceivedListener onrequestreceivedlistener)
    {
        try
        {
            onrequestreceivedlistener = new ao(onrequestreceivedlistener);
            ((gb)eb()).c(onrequestreceivedlistener, GE);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnRequestReceivedListener onrequestreceivedlistener)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    protected void a(en en1, eh.e e1)
        throws RemoteException
    {
        String s1 = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", GF);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", GB);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", GC);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", GH);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", GG);
        en1.a(e1, 0x41f6b8, getContext().getPackageName(), vi, ea(), Gv, Gz.fP(), s1, bundle);
    }

    protected String aF()
    {
        return "com.google.android.gms.games.service.START";
    }

    protected String aG()
    {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void aT(int i1)
    {
        Gz.setGravity(i1);
    }

    public void aU(int i1)
    {
        try
        {
            ((gb)eb()).aU(i1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public Intent au(String s1)
    {
        try
        {
            s1 = ((gb)eb()).au(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public void av(String s1)
    {
        try
        {
            ((gb)eb()).aC(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public Intent b(int i1, int j1, boolean flag)
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).b(i1, j1, flag);
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public void b(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((gb)eb()).a(new bb(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
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
            ((gb)eb()).a(c1, s1, Gz.fP(), Gz.fO());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
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
            ((gb)eb()).b(c1, s1, i1, Gz.fP(), Gz.fO());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_59;
        c1 = new d(c1);
          goto _L1
    }

    public void b(com.google.android.gms.common.api.a.c c1, String s1, int i1, int j1, int k1, boolean flag)
    {
        try
        {
            ((gb)eb()).b(new r(c1), s1, i1, j1, k1, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.c c1, boolean flag)
    {
        try
        {
            ((gb)eb()).b(new t(c1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.c c1, String as1[])
    {
        try
        {
            ((gb)eb()).b(new at(c1), as1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void b(RoomConfig roomconfig)
    {
        try
        {
            ax ax1 = new ax(roomconfig.getRoomUpdateListener(), roomconfig.getRoomStatusUpdateListener(), roomconfig.getMessageReceivedListener());
            ((gb)eb()).a(ax1, GD, roomconfig.getInvitationId(), roomconfig.isSocketEnabled(), GE);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomConfig roomconfig)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    protected transient void b(String as1[])
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
            com.google.android.gms.internal.er.a(flag1, String.format("Cannot have both %s and %s!", new Object[] {
                "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"
            }));
            return;
        } else
        {
            com.google.android.gms.internal.er.a(flag1, String.format("Games APIs requires %s to function.", new Object[] {
                "https://www.googleapis.com/auth/games"
            }));
            return;
        }
    }

    public void c(com.google.android.gms.common.api.a.c c1, int i1)
    {
        try
        {
            ((gb)eb()).a(new o(c1), i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
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
            ((gb)eb()).b(c1, s1, Gz.fP(), Gz.fO());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
        break MISSING_BLOCK_LABEL_58;
        c1 = new d(c1);
          goto _L1
    }

    public void c(com.google.android.gms.common.api.a.c c1, boolean flag)
    {
        try
        {
            ((gb)eb()).a(new f(c1), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public Bundle cY()
    {
        Bundle bundle;
        try
        {
            bundle = ((gb)eb()).cY();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        bundle.setClassLoader(com/google/android/gms/internal/fx.getClassLoader());
        return bundle;
    }

    public void connect()
    {
        fm();
        super.connect();
    }

    public int d(byte abyte0[], String s1)
    {
        int i1;
        try
        {
            i1 = ((gb)eb()).b(abyte0, s1, null);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return -1;
        }
        return i1;
    }

    public void d(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((gb)eb()).l(new bi(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void disconnect()
    {
        GA = false;
        if (isConnected())
        {
            try
            {
                gb gb1 = (gb)eb();
                gb1.fH();
                gb1.n(GE);
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.fz.g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        fG();
        super.disconnect();
    }

    public void e(View view)
    {
        Gz.f(view);
    }

    public void e(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((gb)eb()).m(new bi(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void f(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((gb)eb()).o(new bk(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public int fA()
    {
        int i1;
        try
        {
            i1 = ((gb)eb()).fA();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return 4368;
        }
        return i1;
    }

    public String fB()
    {
        String s1;
        try
        {
            s1 = ((gb)eb()).fB();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public int fC()
    {
        int i1;
        try
        {
            i1 = ((gb)eb()).fC();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return 2;
        }
        return i1;
    }

    public Intent fD()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).fD();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public int fE()
    {
        int i1;
        try
        {
            i1 = ((gb)eb()).fE();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return 2;
        }
        return i1;
    }

    public int fF()
    {
        int i1;
        try
        {
            i1 = ((gb)eb()).fF();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return 2;
        }
        return i1;
    }

    public void fH()
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_19;
        }
        ((gb)eb()).fH();
        return;
        RemoteException remoteexception;
        remoteexception;
        com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        return;
    }

    public String fn()
    {
        String s1;
        try
        {
            s1 = ((gb)eb()).fn();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public String fo()
    {
        String s1;
        try
        {
            s1 = ((gb)eb()).fo();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return s1;
    }

    public Player fp()
    {
        bm();
        this;
        JVM INSTR monitorenter ;
        Object obj = Gx;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new PlayerBuffer(((gb)eb()).fI());
        if (((PlayerBuffer) (obj)).getCount() > 0)
        {
            Gx = (PlayerEntity)((PlayerBuffer) (obj)).get(0).freeze();
        }
        ((PlayerBuffer) (obj)).close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return Gx;
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
        com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
          goto _L1
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Game fq()
    {
        bm();
        this;
        JVM INSTR monitorenter ;
        Object obj = Gy;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = new GameBuffer(((gb)eb()).fK());
        if (((GameBuffer) (obj)).getCount() > 0)
        {
            Gy = (GameEntity)((GameBuffer) (obj)).get(0).freeze();
        }
        ((GameBuffer) (obj)).close();
_L1:
        this;
        JVM INSTR monitorexit ;
        return Gy;
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
        com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
          goto _L1
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Intent fr()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).fr();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent fs()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).fs();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent ft()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).ft();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent fu()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).fu();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public void fv()
    {
        try
        {
            ((gb)eb()).o(GE);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void fw()
    {
        try
        {
            ((gb)eb()).p(GE);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void fx()
    {
        try
        {
            ((gb)eb()).q(GE);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public Intent fy()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).fy();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public Intent fz()
    {
        Intent intent;
        try
        {
            intent = ((gb)eb()).fz();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
            return null;
        }
        return intent;
    }

    public void g(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((gb)eb()).d(new j(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void g(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((gb)eb()).n(new bg(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void h(com.google.android.gms.common.api.a.c c1, String s1)
    {
        try
        {
            ((gb)eb()).p(new bm(c1), s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket i(String s1, String s2)
    {
label0:
        {
            if (s2 == null || !ParticipantUtils.aE(s2))
            {
                throw new IllegalArgumentException("Bad participant ID");
            }
            RealTimeSocket realtimesocket = (RealTimeSocket)Gw.get(s2);
            if (realtimesocket != null)
            {
                s1 = realtimesocket;
                if (!realtimesocket.isClosed())
                {
                    break label0;
                }
            }
            s1 = aw(s2);
        }
        return s1;
    }

    public void l(String s1, int i1)
    {
        try
        {
            ((gb)eb()).l(s1, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void m(String s1, int i1)
    {
        try
        {
            ((gb)eb()).m(s1, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.google.android.gms.internal.fz.g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle bundle)
    {
        if (GA)
        {
            Gz.fN();
            GA = false;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        GA = false;
    }

    public void onConnectionSuspended(int i1)
    {
    }

    protected IInterface p(IBinder ibinder)
    {
        return H(ibinder);
    }
}
