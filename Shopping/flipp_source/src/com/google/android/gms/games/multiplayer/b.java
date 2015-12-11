// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Invitation, InvitationEntity, d, Participant

public final class b extends e
    implements Invitation
{

    private final Game c;
    private final d d;
    private final ArrayList e;

    private Invitation j()
    {
        return new InvitationEntity(this);
    }

    public final Object a()
    {
        return j();
    }

    public final Game b()
    {
        return c;
    }

    public final String c()
    {
        return d("external_invitation_id");
    }

    public final Participant d()
    {
        return d;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final long e()
    {
        return Math.max(a("creation_timestamp"), a("last_modified_timestamp"));
    }

    public final boolean equals(Object obj)
    {
        return InvitationEntity.a(this, obj);
    }

    public final int f()
    {
        return b("type");
    }

    public final int g()
    {
        return b("variant");
    }

    public final int h()
    {
        if (!c("has_automatch_criteria"))
        {
            return 0;
        } else
        {
            return b("automatch_max_players");
        }
    }

    public final int hashCode()
    {
        return InvitationEntity.a(this);
    }

    public final ArrayList i()
    {
        return e;
    }

    public final String toString()
    {
        return InvitationEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int k)
    {
        ((InvitationEntity)j()).writeToParcel(parcel, k);
    }
}
