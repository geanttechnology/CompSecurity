// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.internal.request:
//            GameRequestClusterCreator

public final class GameRequestCluster
    implements SafeParcelable, GameRequest
{

    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int mVersionCode;
    private final ArrayList zzaxq;

    GameRequestCluster(int i, ArrayList arraylist)
    {
        mVersionCode = i;
        zzaxq = arraylist;
        zzuz();
    }

    private void zzuz()
    {
        GameRequest gamerequest;
        int i;
        int j;
        boolean flag;
        if (!zzaxq.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzb.zzY(flag);
        gamerequest = (GameRequest)zzaxq.get(0);
        j = zzaxq.size();
        i = 1;
        while (i < j) 
        {
            GameRequest gamerequest1 = (GameRequest)zzaxq.get(i);
            if (gamerequest.getType() == gamerequest1.getType())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzb.zza(flag, "All the requests must be of the same type");
            zzb.zza(gamerequest.getSender().equals(gamerequest1.getSender()), "All the requests must be from the same sender");
            i++;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GameRequestCluster))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        obj = (GameRequestCluster)obj;
        if (((GameRequestCluster) (obj)).zzaxq.size() != zzaxq.size())
        {
            return false;
        }
        int j = zzaxq.size();
        for (int i = 0; i < j; i++)
        {
            if (!((GameRequest)zzaxq.get(i)).equals((GameRequest)((GameRequestCluster) (obj)).zzaxq.get(i)))
            {
                return false;
            }
        }

        return true;
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
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String s)
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public List getRecipients()
    {
        return zzuO();
    }

    public String getRequestId()
    {
        return ((GameRequestEntity)zzaxq.get(0)).getRequestId();
    }

    public Player getSender()
    {
        return ((GameRequestEntity)zzaxq.get(0)).getSender();
    }

    public int getStatus()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType()
    {
        return ((GameRequestEntity)zzaxq.get(0)).getType();
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(zzaxq.toArray());
    }

    public boolean isConsumed(String s)
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        GameRequestClusterCreator.zza(this, parcel, i);
    }

    public ArrayList zzuN()
    {
        return new ArrayList(zzaxq);
    }

    public ArrayList zzuO()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

}
