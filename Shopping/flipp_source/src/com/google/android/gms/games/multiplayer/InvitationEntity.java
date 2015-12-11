// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.ha;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Invitation, a, Participant, ParticipantEntity, 
//            g

public final class InvitationEntity extends fm
    implements Invitation
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    final int a;
    final GameEntity b;
    final String c;
    final long d;
    final int e;
    final ParticipantEntity f;
    final int g;
    final int h;
    private final ArrayList i;

    InvitationEntity(int k, GameEntity gameentity, String s, long l, int i1, ParticipantEntity participantentity, 
            ArrayList arraylist, int j1, int k1)
    {
        a = k;
        b = gameentity;
        c = s;
        d = l;
        e = i1;
        f = participantentity;
        i = arraylist;
        g = j1;
        h = k1;
    }

    InvitationEntity(Invitation invitation)
    {
        a = 2;
        b = new GameEntity(invitation.b());
        c = invitation.c();
        d = invitation.e();
        e = invitation.f();
        g = invitation.g();
        h = invitation.h();
        String s = invitation.d().i();
        Object obj = null;
        ArrayList arraylist = invitation.i();
        int l = arraylist.size();
        i = new ArrayList(l);
        int k = 0;
        invitation = obj;
        for (; k < l; k++)
        {
            Participant participant = (Participant)arraylist.get(k);
            if (participant.i().equals(s))
            {
                invitation = participant;
            }
            i.add((ParticipantEntity)participant.a());
        }

        ha.a(invitation, "Must have a valid inviter!");
        f = (ParticipantEntity)invitation.a();
    }

    static int a(Invitation invitation)
    {
        return Arrays.hashCode(new Object[] {
            invitation.b(), invitation.c(), Long.valueOf(invitation.e()), Integer.valueOf(invitation.f()), invitation.d(), invitation.i(), Integer.valueOf(invitation.g()), Integer.valueOf(invitation.h())
        });
    }

    static boolean a(Invitation invitation, Object obj)
    {
        if (obj instanceof Invitation)
        {
            if (invitation == obj)
            {
                return true;
            }
            obj = (Invitation)obj;
            if (gw.a(((Invitation) (obj)).b(), invitation.b()) && gw.a(((Invitation) (obj)).c(), invitation.c()) && gw.a(Long.valueOf(((Invitation) (obj)).e()), Long.valueOf(invitation.e())) && gw.a(Integer.valueOf(((Invitation) (obj)).f()), Integer.valueOf(invitation.f())) && gw.a(((Invitation) (obj)).d(), invitation.d()) && gw.a(((Invitation) (obj)).i(), invitation.i()) && gw.a(Integer.valueOf(((Invitation) (obj)).g()), Integer.valueOf(invitation.g())) && gw.a(Integer.valueOf(((Invitation) (obj)).h()), Integer.valueOf(invitation.h())))
            {
                return true;
            }
        }
        return false;
    }

    static boolean a(Integer integer)
    {
        return b(integer);
    }

    static boolean a(String s)
    {
        return b(s);
    }

    static String b(Invitation invitation)
    {
        return gw.a(invitation).a("Game", invitation.b()).a("InvitationId", invitation.c()).a("CreationTimestamp", Long.valueOf(invitation.e())).a("InvitationType", Integer.valueOf(invitation.f())).a("Inviter", invitation.d()).a("Participants", invitation.i()).a("Variant", Integer.valueOf(invitation.g())).a("AvailableAutoMatchSlots", Integer.valueOf(invitation.h())).toString();
    }

    static Integer j()
    {
        return t();
    }

    public final volatile Object a()
    {
        return this;
    }

    public final Game b()
    {
        return b;
    }

    public final String c()
    {
        return c;
    }

    public final Participant d()
    {
        return f;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final long e()
    {
        return d;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final int f()
    {
        return e;
    }

    public final int g()
    {
        return g;
    }

    public final int h()
    {
        return h;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final ArrayList i()
    {
        return new ArrayList(i);
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int k)
    {
        if (!super.s)
        {
            com.google.android.gms.games.multiplayer.g.a(this, parcel, k);
        } else
        {
            b.writeToParcel(parcel, k);
            parcel.writeString(c);
            parcel.writeLong(d);
            parcel.writeInt(e);
            f.writeToParcel(parcel, k);
            int i1 = i.size();
            parcel.writeInt(i1);
            int l = 0;
            while (l < i1) 
            {
                ((ParticipantEntity)i.get(l)).writeToParcel(parcel, k);
                l++;
            }
        }
    }

}
