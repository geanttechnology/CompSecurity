// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Player;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Participant, ParticipantEntity, ParticipantResult

public final class d extends e
    implements Participant
{

    private final com.google.android.gms.games.d c;

    public d(DataHolder dataholder, int i1)
    {
        super(dataholder, i1);
        c = new com.google.android.gms.games.d(dataholder, i1);
    }

    private Participant l()
    {
        return new ParticipantEntity(this);
    }

    public final Object a()
    {
        return l();
    }

    public final int b()
    {
        return b("player_status");
    }

    public final String c()
    {
        return d("client_address");
    }

    public final int d()
    {
        return b("capabilities");
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean e()
    {
        return b("connected") > 0;
    }

    public final boolean equals(Object obj)
    {
        return ParticipantEntity.a(this, obj);
    }

    public final String f()
    {
        if (g("external_player_id"))
        {
            return d("default_display_name");
        } else
        {
            return c.c();
        }
    }

    public final Uri g()
    {
        if (g("external_player_id"))
        {
            return f("default_display_image_uri");
        } else
        {
            return c.d();
        }
    }

    public final Uri h()
    {
        if (g("external_player_id"))
        {
            return f("default_display_hi_res_image_uri");
        } else
        {
            return c.e();
        }
    }

    public final int hashCode()
    {
        return ParticipantEntity.a(this);
    }

    public final String i()
    {
        return d("external_participant_id");
    }

    public final Player j()
    {
        if (g("external_player_id"))
        {
            return null;
        } else
        {
            return c;
        }
    }

    public final ParticipantResult k()
    {
        if (g("result_type"))
        {
            return null;
        } else
        {
            int i1 = b("result_type");
            int j1 = b("placing");
            return new ParticipantResult(d("external_participant_id"), i1, j1);
        }
    }

    public final String toString()
    {
        return ParticipantEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        ((ParticipantEntity)l()).writeToParcel(parcel, i1);
    }
}
