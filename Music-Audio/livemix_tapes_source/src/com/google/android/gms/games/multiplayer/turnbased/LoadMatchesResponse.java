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

    private final TurnBasedMatchBuffer zzayA;
    private final TurnBasedMatchBuffer zzayB;
    private final InvitationBuffer zzayy;
    private final TurnBasedMatchBuffer zzayz;

    public LoadMatchesResponse(Bundle bundle)
    {
        DataHolder dataholder = zza(bundle, 0);
        if (dataholder != null)
        {
            zzayy = new InvitationBuffer(dataholder);
        } else
        {
            zzayy = null;
        }
        dataholder = zza(bundle, 1);
        if (dataholder != null)
        {
            zzayz = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            zzayz = null;
        }
        dataholder = zza(bundle, 2);
        if (dataholder != null)
        {
            zzayA = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            zzayA = null;
        }
        bundle = zza(bundle, 3);
        if (bundle != null)
        {
            zzayB = new TurnBasedMatchBuffer(bundle);
            return;
        } else
        {
            zzayB = null;
            return;
        }
    }

    private static DataHolder zza(Bundle bundle, int i)
    {
        String s = TurnBasedMatchTurnStatus.zzfQ(i);
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
        return zzayB;
    }

    public InvitationBuffer getInvitations()
    {
        return zzayy;
    }

    public TurnBasedMatchBuffer getMyTurnMatches()
    {
        return zzayz;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches()
    {
        return zzayA;
    }

    public boolean hasData()
    {
        while (zzayy != null && zzayy.getCount() > 0 || zzayz != null && zzayz.getCount() > 0 || zzayA != null && zzayA.getCount() > 0 || zzayB != null && zzayB.getCount() > 0) 
        {
            return true;
        }
        return false;
    }

    public void release()
    {
        if (zzayy != null)
        {
            zzayy.release();
        }
        if (zzayz != null)
        {
            zzayz.release();
        }
        if (zzayA != null)
        {
            zzayA.release();
        }
        if (zzayB != null)
        {
            zzayB.release();
        }
    }
}
