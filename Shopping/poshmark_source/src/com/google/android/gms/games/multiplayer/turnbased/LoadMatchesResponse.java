// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.internal.gv;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchBuffer

public final class LoadMatchesResponse
{

    private final InvitationBuffer JV;
    private final TurnBasedMatchBuffer JW;
    private final TurnBasedMatchBuffer JX;
    private final TurnBasedMatchBuffer JY;

    public LoadMatchesResponse(Bundle bundle)
    {
        DataHolder dataholder = a(bundle, 0);
        if (dataholder != null)
        {
            JV = new InvitationBuffer(dataholder);
        } else
        {
            JV = null;
        }
        dataholder = a(bundle, 1);
        if (dataholder != null)
        {
            JW = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            JW = null;
        }
        dataholder = a(bundle, 2);
        if (dataholder != null)
        {
            JX = new TurnBasedMatchBuffer(dataholder);
        } else
        {
            JX = null;
        }
        bundle = a(bundle, 3);
        if (bundle != null)
        {
            JY = new TurnBasedMatchBuffer(bundle);
            return;
        } else
        {
            JY = null;
            return;
        }
    }

    private static DataHolder a(Bundle bundle, int i)
    {
        String s = gv.aW(i);
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
        if (JV != null)
        {
            JV.close();
        }
        if (JW != null)
        {
            JW.close();
        }
        if (JX != null)
        {
            JX.close();
        }
        if (JY != null)
        {
            JY.close();
        }
    }

    public TurnBasedMatchBuffer getCompletedMatches()
    {
        return JY;
    }

    public InvitationBuffer getInvitations()
    {
        return JV;
    }

    public TurnBasedMatchBuffer getMyTurnMatches()
    {
        return JW;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches()
    {
        return JX;
    }

    public boolean hasData()
    {
        while (JV != null && JV.getCount() > 0 || JW != null && JW.getCount() > 0 || JX != null && JX.getCount() > 0 || JY != null && JY.getCount() > 0) 
        {
            return true;
        }
        return false;
    }
}
