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
    private final String zzBm;
    private final int zzUS;
    private final GameEntity zzaxY;
    private final long zzaxZ;
    private final byte zzayG[];
    private final PlayerEntity zzaza;
    private final ArrayList zzazb;
    private final long zzazc;
    private final Bundle zzazd;
    private final int zzxJ;

    GameRequestEntity(int i, GameEntity gameentity, PlayerEntity playerentity, byte abyte0[], String s, ArrayList arraylist, int j, 
            long l, long l1, Bundle bundle, int k)
    {
        mVersionCode = i;
        zzaxY = gameentity;
        zzaza = playerentity;
        zzayG = abyte0;
        zzBm = s;
        zzazb = arraylist;
        zzUS = j;
        zzaxZ = l;
        zzazc = l1;
        zzazd = bundle;
        zzxJ = k;
    }

    public GameRequestEntity(GameRequest gamerequest)
    {
        mVersionCode = 2;
        zzaxY = new GameEntity(gamerequest.getGame());
        zzaza = new PlayerEntity(gamerequest.getSender());
        zzBm = gamerequest.getRequestId();
        zzUS = gamerequest.getType();
        zzaxZ = gamerequest.getCreationTimestamp();
        zzazc = gamerequest.getExpirationTimestamp();
        zzxJ = gamerequest.getStatus();
        Object obj = gamerequest.getData();
        int j;
        if (obj == null)
        {
            zzayG = null;
        } else
        {
            zzayG = new byte[obj.length];
            System.arraycopy(obj, 0, zzayG, 0, obj.length);
        }
        obj = gamerequest.getRecipients();
        j = ((List) (obj)).size();
        zzazb = new ArrayList(j);
        zzazd = new Bundle();
        for (int i = 0; i < j; i++)
        {
            Player player = (Player)((Player)((List) (obj)).get(i)).freeze();
            String s = player.getPlayerId();
            zzazb.add((PlayerEntity)player);
            zzazd.putInt(s, gamerequest.getRecipientStatus(s));
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
        return zzw.zzu(gamerequest).zzg("Game", gamerequest.getGame()).zzg("Sender", gamerequest.getSender()).zzg("Recipients", gamerequest.getRecipients()).zzg("Data", gamerequest.getData()).zzg("RequestId", gamerequest.getRequestId()).zzg("Type", Integer.valueOf(gamerequest.getType())).zzg("CreationTimestamp", Long.valueOf(gamerequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gamerequest.getExpirationTimestamp())).toString();
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
        return zzaxZ;
    }

    public byte[] getData()
    {
        return zzayG;
    }

    public long getExpirationTimestamp()
    {
        return zzazc;
    }

    public Game getGame()
    {
        return zzaxY;
    }

    public int getRecipientStatus(String s)
    {
        return zzazd.getInt(s, 0);
    }

    public List getRecipients()
    {
        return new ArrayList(zzazb);
    }

    public String getRequestId()
    {
        return zzBm;
    }

    public Player getSender()
    {
        return zzaza;
    }

    public int getStatus()
    {
        return zzxJ;
    }

    public int getType()
    {
        return zzUS;
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

    public Bundle zzvb()
    {
        return zzazd;
    }

}
