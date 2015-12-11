// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.request:
//            GameRequest, GameRequestEntityCreator

public final class GameRequestEntity
    implements SafeParcelable, GameRequest
{

    public static final android.os.Parcelable.Creator CREATOR = new GameRequestEntityCreator();
    private final int mVersionCode;
    private final String zzBY;
    private final int zzWJ;
    private final GameEntity zzaAy;
    private final long zzaAz;
    private final PlayerEntity zzaBA;
    private final ArrayList zzaBB;
    private final long zzaBC;
    private final Bundle zzaBD;
    private final byte zzaBg[];
    private final int zzys;

    GameRequestEntity(int i, GameEntity gameentity, PlayerEntity playerentity, byte abyte0[], String s, ArrayList arraylist, int j, 
            long l, long l1, Bundle bundle, int k)
    {
        mVersionCode = i;
        zzaAy = gameentity;
        zzaBA = playerentity;
        zzaBg = abyte0;
        zzBY = s;
        zzaBB = arraylist;
        zzWJ = j;
        zzaAz = l;
        zzaBC = l1;
        zzaBD = bundle;
        zzys = k;
    }

    public GameRequestEntity(GameRequest gamerequest)
    {
        mVersionCode = 2;
        zzaAy = new GameEntity(gamerequest.getGame());
        zzaBA = new PlayerEntity(gamerequest.getSender());
        zzBY = gamerequest.getRequestId();
        zzWJ = gamerequest.getType();
        zzaAz = gamerequest.getCreationTimestamp();
        zzaBC = gamerequest.getExpirationTimestamp();
        zzys = gamerequest.getStatus();
        Object obj = gamerequest.getData();
        int j;
        if (obj == null)
        {
            zzaBg = null;
        } else
        {
            zzaBg = new byte[obj.length];
            System.arraycopy(obj, 0, zzaBg, 0, obj.length);
        }
        obj = gamerequest.getRecipients();
        j = ((List) (obj)).size();
        zzaBB = new ArrayList(j);
        zzaBD = new Bundle();
        for (int i = 0; i < j; i++)
        {
            Player player = (Player)((Player)((List) (obj)).get(i)).freeze();
            String s = player.getPlayerId();
            zzaBB.add((PlayerEntity)player);
            zzaBD.putInt(s, gamerequest.getRecipientStatus(s));
        }

    }

    static int zza(GameRequest gamerequest)
    {
        return zzw.hashCode(new Object[] {
            gamerequest.getGame(), gamerequest.getRecipients(), gamerequest.getRequestId(), gamerequest.getSender(), zzb(gamerequest), Integer.valueOf(gamerequest.getType()), Long.valueOf(gamerequest.getCreationTimestamp()), Long.valueOf(gamerequest.getExpirationTimestamp())
        });
    }

    static boolean zza(GameRequest gamerequest, Object obj)
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
        if (!zzw.equal(((GameRequest) (obj)).getGame(), gamerequest.getGame()) || !zzw.equal(((GameRequest) (obj)).getRecipients(), gamerequest.getRecipients()) || !zzw.equal(((GameRequest) (obj)).getRequestId(), gamerequest.getRequestId()) || !zzw.equal(((GameRequest) (obj)).getSender(), gamerequest.getSender()) || !Arrays.equals(zzb(((GameRequest) (obj))), zzb(gamerequest)) || !zzw.equal(Integer.valueOf(((GameRequest) (obj)).getType()), Integer.valueOf(gamerequest.getType())) || !zzw.equal(Long.valueOf(((GameRequest) (obj)).getCreationTimestamp()), Long.valueOf(gamerequest.getCreationTimestamp())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Long.valueOf(((GameRequest) (obj)).getExpirationTimestamp()), Long.valueOf(gamerequest.getExpirationTimestamp()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    private static int[] zzb(GameRequest gamerequest)
    {
        List list = gamerequest.getRecipients();
        int j = list.size();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = gamerequest.getRecipientStatus(((Player)list.get(i)).getPlayerId());
        }

        return ai;
    }

    static String zzc(GameRequest gamerequest)
    {
        return zzw.zzv(gamerequest).zzg("Game", gamerequest.getGame()).zzg("Sender", gamerequest.getSender()).zzg("Recipients", gamerequest.getRecipients()).zzg("Data", gamerequest.getData()).zzg("RequestId", gamerequest.getRequestId()).zzg("Type", Integer.valueOf(gamerequest.getType())).zzg("CreationTimestamp", Long.valueOf(gamerequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gamerequest.getExpirationTimestamp())).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
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
        return zzaAz;
    }

    public byte[] getData()
    {
        return zzaBg;
    }

    public long getExpirationTimestamp()
    {
        return zzaBC;
    }

    public Game getGame()
    {
        return zzaAy;
    }

    public int getRecipientStatus(String s)
    {
        return zzaBD.getInt(s, 0);
    }

    public List getRecipients()
    {
        return new ArrayList(zzaBB);
    }

    public String getRequestId()
    {
        return zzBY;
    }

    public Player getSender()
    {
        return zzaBA;
    }

    public int getStatus()
    {
        return zzys;
    }

    public int getType()
    {
        return zzWJ;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isConsumed(String s)
    {
        return getRecipientStatus(s) == 1;
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        GameRequestEntityCreator.zza(this, parcel, i);
    }

    public Bundle zzvR()
    {
        return zzaBD;
    }

}
