// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzatn extends zzatn
    implements com.google.android.gms.games.multiplayer.tn
{

    private final InvitationBuffer zzatn;

    public InvitationBuffer getInvitations()
    {
        return zzatn;
    }

    (DataHolder dataholder)
    {
        super(dataholder);
        zzatn = new InvitationBuffer(dataholder);
    }
}
