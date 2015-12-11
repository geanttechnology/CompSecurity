// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.internal.gf;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchBuffer

public final class LoadMatchesResponse
{

    private final InvitationBuffer wO;
    private final TurnBasedMatchBuffer wP;
    private final TurnBasedMatchBuffer wQ;
    private final TurnBasedMatchBuffer wR;

    public LoadMatchesResponse(Bundle bundle)
    {
        DataHolder dataholder = a(bundle, 0);
        if (dataholder != null)
        {
            wO = new InvitationBuffer(dataholder);
        } else
        {
            wO = null;
        }
        dataholder = a(bundle, 1);
        if (dataholder != null)
        {
            wP = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            wP = null;
        }
        dataholder = a(bundle, 2);
        if (dataholder != null)
        {
            wQ = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            wQ = null;
        }
        bundle = a(bundle, 3);
        if (bundle != null)
        {
            wR = new TurnBasedMatchBuffer(bundle);
            return;
        } else
        {
            wR = null;
            return;
        }
    }

    private static DataHolder a(Bundle bundle, int i)
    {
        String s = gf.aG(i);
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
        if (wO != null)
        {
            wO.close();
        }
        if (wP != null)
        {
            wP.close();
        }
        if (wQ != null)
        {
            wQ.close();
        }
        if (wR != null)
        {
            wR.close();
        }
    }

    public TurnBasedMatchBuffer getCompletedMatches()
    {
        return wR;
    }

    public InvitationBuffer getInvitations()
    {
        return wO;
    }

    public TurnBasedMatchBuffer getMyTurnMatches()
    {
        return wP;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches()
    {
        return wQ;
    }
}
