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

    private final int zzauX;

    public GameRequestRef(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        zzauX = j;
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
        return new GameRef(zzabq, zzadl);
    }

    public int getRecipientStatus(String s)
    {
        for (int i = zzadl; i < zzadl + zzauX; i++)
        {
            int j = zzabq.zzbt(i);
            if (zzabq.zzd("recipient_external_player_id", i, j).equals(s))
            {
                return zzabq.zzc("recipient_status", i, j);
            }
        }

        return -1;
    }

    public List getRecipients()
    {
        ArrayList arraylist = new ArrayList(zzauX);
        for (int i = 0; i < zzauX; i++)
        {
            arraylist.add(new PlayerRef(zzabq, zzadl + i, "recipient_"));
        }

        return arraylist;
    }

    public String getRequestId()
    {
        return getString("external_request_id");
    }

    public Player getSender()
    {
        return new PlayerRef(zzabq, zzou(), "sender_");
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
