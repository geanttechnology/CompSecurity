// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavL extends zzavL
    implements com.google.android.gms.games.multiplayer.vL
{

    private final InvitationBuffer zzavL;

    public InvitationBuffer getInvitations()
    {
        return zzavL;
    }

    (DataHolder dataholder)
    {
        super(dataholder);
        zzavL = new InvitationBuffer(dataholder);
    }
}
