// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Participant, c, h, ParticipantResult

public final class ParticipantEntity extends fm
    implements Participant
{

    public static final android.os.Parcelable.Creator CREATOR = new c();
    final int a;
    final String b;
    final int c;
    final String d;
    final boolean e;
    final PlayerEntity f;
    final int g;
    final ParticipantResult h;
    private final String i;
    private final Uri j;
    private final Uri k;

    ParticipantEntity(int i1, String s, String s1, Uri uri, Uri uri1, int j1, String s2, 
            boolean flag, PlayerEntity playerentity, int k1, ParticipantResult participantresult)
    {
        a = i1;
        b = s;
        i = s1;
        j = uri;
        k = uri1;
        c = j1;
        d = s2;
        e = flag;
        f = playerentity;
        g = k1;
        h = participantresult;
    }

    public ParticipantEntity(Participant participant)
    {
        a = 2;
        b = participant.i();
        i = participant.f();
        j = participant.g();
        k = participant.h();
        c = participant.b();
        d = participant.c();
        e = participant.e();
        Object obj = participant.j();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new PlayerEntity(((Player) (obj)));
        }
        f = ((PlayerEntity) (obj));
        g = participant.d();
        h = participant.k();
    }

    static int a(Participant participant)
    {
        return Arrays.hashCode(new Object[] {
            participant.j(), Integer.valueOf(participant.b()), participant.c(), Boolean.valueOf(participant.e()), participant.f(), participant.g(), participant.h(), Integer.valueOf(participant.d()), participant.k()
        });
    }

    static boolean a(Participant participant, Object obj)
    {
        if (obj instanceof Participant)
        {
            if (participant == obj)
            {
                return true;
            }
            obj = (Participant)obj;
            if (gw.a(((Participant) (obj)).j(), participant.j()) && gw.a(Integer.valueOf(((Participant) (obj)).b()), Integer.valueOf(participant.b())) && gw.a(((Participant) (obj)).c(), participant.c()) && gw.a(Boolean.valueOf(((Participant) (obj)).e()), Boolean.valueOf(participant.e())) && gw.a(((Participant) (obj)).f(), participant.f()) && gw.a(((Participant) (obj)).g(), participant.g()) && gw.a(((Participant) (obj)).h(), participant.h()) && gw.a(Integer.valueOf(((Participant) (obj)).d()), Integer.valueOf(participant.d())) && gw.a(((Participant) (obj)).k(), participant.k()))
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

    static String b(Participant participant)
    {
        return gw.a(participant).a("Player", participant.j()).a("Status", Integer.valueOf(participant.b())).a("ClientAddress", participant.c()).a("ConnectedToRoom", Boolean.valueOf(participant.e())).a("DisplayName", participant.f()).a("IconImage", participant.g()).a("HiResImage", participant.h()).a("Capabilities", Integer.valueOf(participant.d())).a("Result", participant.k()).toString();
    }

    static Integer l()
    {
        return t();
    }

    public final volatile Object a()
    {
        return this;
    }

    public final int b()
    {
        return c;
    }

    public final String c()
    {
        return d;
    }

    public final int d()
    {
        return g;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean e()
    {
        return e;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final String f()
    {
        if (f == null)
        {
            return i;
        } else
        {
            return f.c;
        }
    }

    public final Uri g()
    {
        if (f == null)
        {
            return j;
        } else
        {
            return f.d;
        }
    }

    public final Uri h()
    {
        if (f == null)
        {
            return k;
        } else
        {
            return f.e;
        }
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final String i()
    {
        return b;
    }

    public final Player j()
    {
        return f;
    }

    public final ParticipantResult k()
    {
        return h;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        Object obj = null;
        boolean flag = false;
        if (!super.s)
        {
            com.google.android.gms.games.multiplayer.h.a(this, parcel, i1);
        } else
        {
            parcel.writeString(b);
            parcel.writeString(i);
            String s;
            int j1;
            if (j == null)
            {
                s = null;
            } else
            {
                s = j.toString();
            }
            parcel.writeString(s);
            if (k == null)
            {
                s = obj;
            } else
            {
                s = k.toString();
            }
            parcel.writeString(s);
            parcel.writeInt(c);
            parcel.writeString(d);
            if (e)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            parcel.writeInt(j1);
            if (f == null)
            {
                j1 = ((flag) ? 1 : 0);
            } else
            {
                j1 = 1;
            }
            parcel.writeInt(j1);
            if (f != null)
            {
                f.writeToParcel(parcel, i1);
                return;
            }
        }
    }

}
