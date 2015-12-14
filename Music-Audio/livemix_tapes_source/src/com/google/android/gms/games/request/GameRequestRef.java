// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.request:
//            GameRequest, GameRequestEntity

public final class GameRequestRef extends zzc
    implements GameRequest
{

    private final int zzasz;

    public GameRequestRef(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        zzasz = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return GameRequestEntity.zza(this, obj);
    }

    public GameRequest freeze()
    {
        return new GameRequestEntity(this);
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public long getCreationTimestamp()
    {
        return getLong("creation_timestamp");
    }

    public byte[] getData()
    {
        return getByteArray("data");
    }

    public long getExpirationTimestamp()
    {
        return getLong("expiration_timestamp");
    }

    public Game getGame()
    {
        return new GameRef(zzYX, zzabg);
    }

    public int getRecipientStatus(String s)
    {
        for (int i = zzabg; i < zzabg + zzasz; i++)
        {
            int j = zzYX.zzbo(i);
            if (zzYX.zzd("recipient_external_player_id", i, j).equals(s))
            {
                return zzYX.zzc("recipient_status", i, j);
            }
        }

        return -1;
    }

    public List getRecipients()
    {
        ArrayList arraylist = new ArrayList(zzasz);
        for (int i = 0; i < zzasz; i++)
        {
            arraylist.add(new PlayerRef(zzYX, zzabg + i, "recipient_"));
        }

        return arraylist;
    }

    public String getRequestId()
    {
        return getString("external_request_id");
    }

    public Player getSender()
    {
        return new PlayerRef(zzYX, zznS(), "sender_");
    }

    public int getStatus()
    {
        return getInteger("status");
    }

    public int getType()
    {
        return getInteger("type");
    }

    public int hashCode()
    {
        return GameRequestEntity.zza(this);
    }

    public boolean isConsumed(String s)
    {
        return getRecipientStatus(s) == 1;
    }

    public String toString()
    {
        return com.google.android.gms.games.request.GameRequestEntity.zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((GameRequestEntity)freeze()).writeToParcel(parcel, i);
    }
}
