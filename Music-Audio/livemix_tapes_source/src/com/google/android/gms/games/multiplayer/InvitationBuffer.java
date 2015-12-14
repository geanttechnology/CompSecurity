// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            InvitationRef, Invitation

public final class InvitationBuffer extends zzf
{

    public InvitationBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    protected Object zzk(int i, int j)
    {
        return zzp(i, j);
    }

    protected String zznW()
    {
        return "external_invitation_id";
    }

    protected Invitation zzp(int i, int j)
    {
        return new InvitationRef(zzYX, i, j);
    }
}
