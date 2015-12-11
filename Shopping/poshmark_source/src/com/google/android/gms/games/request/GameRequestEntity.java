// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ep;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.request:
//            GameRequest, GameRequestEntityCreator

public final class GameRequestEntity
    implements SafeParcelable, GameRequest
{

    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
    private final int AI;
    private final String Hh;
    private final GameEntity Jq;
    private final long Jr;
    private final byte Kf[];
    private final PlayerEntity Km;
    private final ArrayList Kn;
    private final long Ko;
    private final Bundle Kp;
    private final int wj;

    GameRequestEntity(int i, GameEntity gameentity, PlayerEntity playerentity, byte abyte0[], String s, ArrayList arraylist, int j, 
            long l, long l1, Bundle bundle)
    {
        wj = i;
        Jq = gameentity;
        Km = playerentity;
        Kf = abyte0;
        Hh = s;
        Kn = arraylist;
        AI = j;
        Jr = l;
        Ko = l1;
        Kp = bundle;
    }

    public GameRequestEntity(GameRequest gamerequest)
    {
        wj = 1;
        Jq = new GameEntity(gamerequest.getGame());
        Km = new PlayerEntity(gamerequest.getSender());
        Hh = gamerequest.getRequestId();
        AI = gamerequest.getType();
        Jr = gamerequest.getCreationTimestamp();
        Ko = gamerequest.getExpirationTimestamp();
        Object obj = gamerequest.getData();
        int j;
        if (obj == null)
        {
            Kf = null;
        } else
        {
            Kf = new byte[obj.length];
            System.arraycopy(obj, 0, Kf, 0, obj.length);
        }
        obj = gamerequest.fU();
        j = ((ArrayList) (obj)).size();
        Kn = new ArrayList(j);
        Kp = new Bundle();
        for (int i = 0; i < j; i++)
        {
            Player player = (Player)((Player)((ArrayList) (obj)).get(i)).freeze();
            String s = player.getPlayerId();
            Kn.add((PlayerEntity)player);
            Kp.putInt(s, gamerequest.getRecipientStatus(s));
        }

    }

    static int a(GameRequest gamerequest)
    {
        return ep.hashCode(new Object[] {
            gamerequest.getGame(), gamerequest.fU(), gamerequest.getRequestId(), gamerequest.getSender(), b(gamerequest), Integer.valueOf(gamerequest.getType()), Long.valueOf(gamerequest.getCreationTimestamp()), Long.valueOf(gamerequest.getExpirationTimestamp())
        });
    }

    static boolean a(GameRequest gamerequest, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof GameRequest) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (gamerequest == obj) goto _L4; else goto _L3
_L3:
        obj = (GameRequest)obj;
        if (!ep.equal(((GameRequest) (obj)).getGame(), gamerequest.getGame()) || !ep.equal(((GameRequest) (obj)).fU(), gamerequest.fU()) || !ep.equal(((GameRequest) (obj)).getRequestId(), gamerequest.getRequestId()) || !ep.equal(((GameRequest) (obj)).getSender(), gamerequest.getSender()) || !Arrays.equals(b(((GameRequest) (obj))), b(gamerequest)) || !ep.equal(Integer.valueOf(((GameRequest) (obj)).getType()), Integer.valueOf(gamerequest.getType())) || !ep.equal(Long.valueOf(((GameRequest) (obj)).getCreationTimestamp()), Long.valueOf(gamerequest.getCreationTimestamp())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(Long.valueOf(((GameRequest) (obj)).getExpirationTimestamp()), Long.valueOf(gamerequest.getExpirationTimestamp()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    private static int[] b(GameRequest gamerequest)
    {
        ArrayList arraylist = gamerequest.fU();
        int j = arraylist.size();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = gamerequest.getRecipientStatus(((Player)arraylist.get(i)).getPlayerId());
        }

        return ai;
    }

    static String c(GameRequest gamerequest)
    {
        return ep.e(gamerequest).a("Game", gamerequest.getGame()).a("Sender", gamerequest.getSender()).a("Recipients", gamerequest.fU()).a("Data", gamerequest.getData()).a("RequestId", gamerequest.getRequestId()).a("Type", Integer.valueOf(gamerequest.getType())).a("CreationTimestamp", Long.valueOf(gamerequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(gamerequest.getExpirationTimestamp())).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public ArrayList fU()
    {
        return new ArrayList(Kn);
    }

    public GameRequest freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public long getCreationTimestamp()
    {
        return Jr;
    }

    public byte[] getData()
    {
        return Kf;
    }

    public long getExpirationTimestamp()
    {
        return Ko;
    }

    public Game getGame()
    {
        return Jq;
    }

    public Player getRecipient()
    {
        if (Kn.isEmpty())
        {
            return null;
        } else
        {
            return (Player)Kn.get(0);
        }
    }

    public int getRecipientStatus()
    {
        return Kp.getInt(((PlayerEntity)Kn.get(0)).getPlayerId(), 0);
    }

    public int getRecipientStatus(String s)
    {
        return Kp.getInt(s, 0);
    }

    public String getRequestId()
    {
        return Hh;
    }

    public Player getSender()
    {
        return Km;
    }

    public int getType()
    {
        return AI;
    }

    public int getVersionCode()
    {
        return wj;
    }

    public Bundle gf()
    {
        return Kp;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isConsumed()
    {
        return getRecipientStatus() == 1;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return c(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        GameRequestEntityCreator.a(this, parcel, i);
    }

}
