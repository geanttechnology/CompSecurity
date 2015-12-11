// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchBuffer

public final class LoadMatchesResponse
{

    private final InvitationBuffer zzaAY;
    private final TurnBasedMatchBuffer zzaAZ;
    private final TurnBasedMatchBuffer zzaBa;
    private final TurnBasedMatchBuffer zzaBb;

    public LoadMatchesResponse(Bundle bundle)
    {
        DataHolder dataholder = zza(bundle, 0);
        if (dataholder != null)
        {
            zzaAY = new InvitationBuffer(dataholder);
        } else
        {
            zzaAY = null;
        }
        dataholder = zza(bundle, 1);
        if (dataholder != null)
        {
            zzaAZ = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            zzaAZ = null;
        }
        dataholder = zza(bundle, 2);
        if (dataholder != null)
        {
            zzaBa = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            zzaBa = null;
        }
        bundle = zza(bundle, 3);
        if (bundle != null)
        {
            zzaBb = new TurnBasedMatchBuffer(bundle);
            return;
        } else
        {
            zzaBb = null;
            return;
        }
    }

    private static DataHolder zza(Bundle bundle, int i)
    {
        String s = TurnBasedMatchTurnStatus.zzfZ(i);
        if (!bundle.containsKey(s))
        {
            return null;
        } else
        {
            return (DataHolder)bundle.getParcelable(s);
        }
    }

    public void close()
    {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches()
    {
        return zzaBb;
    }

    public InvitationBuffer getInvitations()
    {
        return zzaAY;
    }

    public TurnBasedMatchBuffer getMyTurnMatches()
    {
        return zzaAZ;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches()
    {
        return zzaBa;
    }

    public boolean hasData()
    {
        while (zzaAY != null && zzaAY.getCount() > 0 || zzaAZ != null && zzaAZ.getCount() > 0 || zzaBa != null && zzaBa.getCount() > 0 || zzaBb != null && zzaBb.getCount() > 0) 
        {
            return true;
        }
        return false;
    }

    public void release()
    {
        if (zzaAY != null)
        {
            zzaAY.release();
        }
        if (zzaAZ != null)
        {
            zzaAZ.release();
        }
        if (zzaBa != null)
        {
            zzaBa.release();
        }
        if (zzaBb != null)
        {
            zzaBb.release();
        }
    }
}
