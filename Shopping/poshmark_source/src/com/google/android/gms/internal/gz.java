// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            ha, ed, ep

public final class gz
    implements SafeParcelable, GameRequest
{

    public static final ha CREATOR = new ha();
    private final ArrayList IG;
    private final int wj;

    gz(int i, ArrayList arraylist)
    {
        wj = i;
        IG = arraylist;
        fR();
    }

    private void fR()
    {
        GameRequest gamerequest;
        int i;
        int j;
        boolean flag;
        if (!IG.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ed.v(flag);
        gamerequest = (GameRequest)IG.get(0);
        j = IG.size();
        i = 1;
        while (i < j) 
        {
            GameRequest gamerequest1 = (GameRequest)IG.get(i);
            if (gamerequest.getType() == gamerequest1.getType())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ed.a(flag, "All the requests must be of the same type");
            ed.a(gamerequest.getSender().equals(gamerequest1.getSender()), "All the requests must be from the same sender");
            i++;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof gz))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        obj = (gz)obj;
        if (((gz) (obj)).IG.size() != IG.size())
        {
            return false;
        }
        int j = IG.size();
        for (int i = 0; i < j; i++)
        {
            if (!((GameRequest)IG.get(i)).equals((GameRequest)((gz) (obj)).IG.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    public ArrayList fT()
    {
        return new ArrayList(IG);
    }

    public ArrayList fU()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
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

    public Player getRecipient()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String s)
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getRequestId()
    {
        return ((GameRequestEntity)IG.get(0)).getRequestId();
    }

    public Player getSender()
    {
        return ((GameRequestEntity)IG.get(0)).getSender();
    }

    public int getType()
    {
        return ((GameRequestEntity)IG.get(0)).getType();
    }

    public int getVersionCode()
    {
        return wj;
    }

    public int hashCode()
    {
        return ep.hashCode(IG.toArray());
    }

    public boolean isConsumed()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ha.a(this, parcel, i);
    }

}
