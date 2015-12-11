// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            Room, b, d

public final class RoomEntity extends fm
    implements Room
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    final int a;
    final String b;
    final String c;
    final long d;
    final int e;
    final String f;
    final int g;
    final Bundle h;
    final int i;
    private final ArrayList j;

    RoomEntity(int l, String s, String s1, long l1, int i1, String s2, 
            int j1, Bundle bundle, ArrayList arraylist, int k1)
    {
        a = l;
        b = s;
        c = s1;
        d = l1;
        e = i1;
        f = s2;
        g = j1;
        h = bundle;
        j = arraylist;
        i = k1;
    }

    public RoomEntity(Room room)
    {
        a = 2;
        b = room.b();
        c = room.c();
        d = room.d();
        e = room.e();
        f = room.f();
        g = room.g();
        h = room.h();
        ArrayList arraylist = room.i();
        int i1 = arraylist.size();
        j = new ArrayList(i1);
        for (int l = 0; l < i1; l++)
        {
            j.add((ParticipantEntity)((Participant)arraylist.get(l)).a());
        }

        i = room.j();
    }

    static int a(Room room)
    {
        return Arrays.hashCode(new Object[] {
            room.b(), room.c(), Long.valueOf(room.d()), Integer.valueOf(room.e()), room.f(), Integer.valueOf(room.g()), room.h(), room.i(), Integer.valueOf(room.j())
        });
    }

    static boolean a(Room room, Object obj)
    {
        if (obj instanceof Room)
        {
            if (room == obj)
            {
                return true;
            }
            obj = (Room)obj;
            if (gw.a(((Room) (obj)).b(), room.b()) && gw.a(((Room) (obj)).c(), room.c()) && gw.a(Long.valueOf(((Room) (obj)).d()), Long.valueOf(room.d())) && gw.a(Integer.valueOf(((Room) (obj)).e()), Integer.valueOf(room.e())) && gw.a(((Room) (obj)).f(), room.f()) && gw.a(Integer.valueOf(((Room) (obj)).g()), Integer.valueOf(room.g())) && gw.a(((Room) (obj)).h(), room.h()) && gw.a(((Room) (obj)).i(), room.i()) && gw.a(Integer.valueOf(((Room) (obj)).j()), Integer.valueOf(room.j())))
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

    static String b(Room room)
    {
        return gw.a(room).a("RoomId", room.b()).a("CreatorId", room.c()).a("CreationTimestamp", Long.valueOf(room.d())).a("RoomStatus", Integer.valueOf(room.e())).a("Description", room.f()).a("Variant", Integer.valueOf(room.g())).a("AutoMatchCriteria", room.h()).a("Participants", room.i()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.j())).toString();
    }

    static Integer k()
    {
        return t();
    }

    public final volatile Object a()
    {
        return this;
    }

    public final String b()
    {
        return b;
    }

    public final String c()
    {
        return c;
    }

    public final long d()
    {
        return d;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int e()
    {
        return e;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final String f()
    {
        return f;
    }

    public final int g()
    {
        return g;
    }

    public final Bundle h()
    {
        return h;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final ArrayList i()
    {
        return new ArrayList(j);
    }

    public final int j()
    {
        return i;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int l)
    {
        if (!super.s)
        {
            com.google.android.gms.games.multiplayer.realtime.d.a(this, parcel);
        } else
        {
            parcel.writeString(b);
            parcel.writeString(c);
            parcel.writeLong(d);
            parcel.writeInt(e);
            parcel.writeString(f);
            parcel.writeInt(g);
            parcel.writeBundle(h);
            int j1 = j.size();
            parcel.writeInt(j1);
            int i1 = 0;
            while (i1 < j1) 
            {
                ((ParticipantEntity)j.get(i1)).writeToParcel(parcel, l);
                i1++;
            }
        }
    }

}
