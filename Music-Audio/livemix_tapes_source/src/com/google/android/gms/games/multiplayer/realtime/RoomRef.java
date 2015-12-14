// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            Room, RoomEntity, RoomConfig

public final class RoomRef extends zzc
    implements Room
{

    private final int zzasz;

    RoomRef(DataHolder dataholder, int i, int j)
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
        return RoomEntity.zza(this, obj);
    }

    public Room freeze()
    {
        return new RoomEntity(this);
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public Bundle getAutoMatchCriteria()
    {
        if (!getBoolean("has_automatch_criteria"))
        {
            return null;
        } else
        {
            return RoomConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
        }
    }

    public int getAutoMatchWaitEstimateSeconds()
    {
        return getInteger("automatch_wait_estimate_sec");
    }

    public long getCreationTimestamp()
    {
        return getLong("creation_timestamp");
    }

    public String getCreatorId()
    {
        return getString("creator_external");
    }

    public String getDescription()
    {
        return getString("description");
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zza("description", chararraybuffer);
    }

    public Participant getParticipant(String s)
    {
        return com.google.android.gms.games.multiplayer.realtime.RoomEntity.zzc(this, s);
    }

    public String getParticipantId(String s)
    {
        return RoomEntity.zzb(this, s);
    }

    public ArrayList getParticipantIds()
    {
        return com.google.android.gms.games.multiplayer.realtime.RoomEntity.zzc(this);
    }

    public int getParticipantStatus(String s)
    {
        return RoomEntity.zza(this, s);
    }

    public ArrayList getParticipants()
    {
        ArrayList arraylist = new ArrayList(zzasz);
        for (int i = 0; i < zzasz; i++)
        {
            arraylist.add(new ParticipantRef(zzYX, zzabg + i));
        }

        return arraylist;
    }

    public String getRoomId()
    {
        return getString("external_match_id");
    }

    public int getStatus()
    {
        return getInteger("status");
    }

    public int getVariant()
    {
        return getInteger("variant");
    }

    public int hashCode()
    {
        return RoomEntity.zza(this);
    }

    public String toString()
    {
        return RoomEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((RoomEntity)freeze()).writeToParcel(parcel, i);
    }
}
