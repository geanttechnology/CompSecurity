// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            fl

final class aHolder extends aHolder
    implements com.google.android.gms.games.s.LoadPlayersResult
{

    final fl tZ;
    private final PlayerBuffer ur;

    protected void a(com.google.android.gms.common.api.older older, DataHolder dataholder)
    {
        older.older(this);
    }

    protected volatile void a(Object obj, DataHolder dataholder)
    {
        a((com.google.android.gms.common.api.older)obj, dataholder);
    }

    public PlayerBuffer getPlayers()
    {
        return ur;
    }

    aHolder(fl fl1, com.google.android.gms.common.api.older older, DataHolder dataholder)
    {
        tZ = fl1;
        super(fl1, older, dataholder);
        ur = new PlayerBuffer(dataholder);
    }
}
