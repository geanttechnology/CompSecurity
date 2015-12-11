// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatch, b

public final class TurnBasedMatchEntity
    implements SafeParcelable, TurnBasedMatch
{

    public static final b CREATOR = new b();
    final int b;
    final GameEntity c;
    final String d;
    final String e;
    final long f;
    final String g;
    final long h;
    final String i;
    final int j;
    final int k;
    final int l;
    final byte m[];
    final String n;
    final byte o[];
    final int p;
    final Bundle q;
    final int r;
    final boolean s;
    private final ArrayList t;

    TurnBasedMatchEntity(int i1, GameEntity gameentity, String s1, String s2, long l1, String s3, 
            long l2, String s4, int j1, int k1, int i2, byte abyte0[], 
            ArrayList arraylist, String s5, byte abyte1[], int j2, Bundle bundle, int k2, boolean flag)
    {
        b = i1;
        c = gameentity;
        d = s1;
        e = s2;
        f = l1;
        g = s3;
        h = l2;
        i = s4;
        j = j1;
        r = k2;
        k = k1;
        l = i2;
        m = abyte0;
        t = arraylist;
        n = s5;
        o = abyte1;
        p = j2;
        q = bundle;
        s = flag;
    }

    public TurnBasedMatchEntity(TurnBasedMatch turnbasedmatch)
    {
        b = 2;
        c = new GameEntity(turnbasedmatch.b());
        d = turnbasedmatch.c();
        e = turnbasedmatch.d();
        f = turnbasedmatch.e();
        g = turnbasedmatch.j();
        h = turnbasedmatch.k();
        i = turnbasedmatch.l();
        j = turnbasedmatch.f();
        r = turnbasedmatch.g();
        k = turnbasedmatch.h();
        l = turnbasedmatch.n();
        n = turnbasedmatch.o();
        p = turnbasedmatch.q();
        q = turnbasedmatch.r();
        s = turnbasedmatch.t();
        byte abyte0[] = turnbasedmatch.m();
        int j1;
        if (abyte0 == null)
        {
            m = null;
        } else
        {
            m = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, m, 0, abyte0.length);
        }
        abyte0 = turnbasedmatch.p();
        if (abyte0 == null)
        {
            o = null;
        } else
        {
            o = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, o, 0, abyte0.length);
        }
        turnbasedmatch = turnbasedmatch.i();
        j1 = turnbasedmatch.size();
        t = new ArrayList(j1);
        for (int i1 = 0; i1 < j1; i1++)
        {
            t.add((ParticipantEntity)(ParticipantEntity)((Participant)turnbasedmatch.get(i1)).a());
        }

    }

    static int a(TurnBasedMatch turnbasedmatch)
    {
        return Arrays.hashCode(new Object[] {
            turnbasedmatch.b(), turnbasedmatch.c(), turnbasedmatch.d(), Long.valueOf(turnbasedmatch.e()), turnbasedmatch.j(), Long.valueOf(turnbasedmatch.k()), turnbasedmatch.l(), Integer.valueOf(turnbasedmatch.f()), Integer.valueOf(turnbasedmatch.g()), Integer.valueOf(turnbasedmatch.h()), 
            Integer.valueOf(turnbasedmatch.n()), turnbasedmatch.i(), turnbasedmatch.o(), Integer.valueOf(turnbasedmatch.q()), turnbasedmatch.r(), Integer.valueOf(turnbasedmatch.s()), Boolean.valueOf(turnbasedmatch.t())
        });
    }

    static boolean a(TurnBasedMatch turnbasedmatch, Object obj)
    {
        if (obj instanceof TurnBasedMatch)
        {
            if (turnbasedmatch == obj)
            {
                return true;
            }
            obj = (TurnBasedMatch)obj;
            if (gw.a(((TurnBasedMatch) (obj)).b(), turnbasedmatch.b()) && gw.a(((TurnBasedMatch) (obj)).c(), turnbasedmatch.c()) && gw.a(((TurnBasedMatch) (obj)).d(), turnbasedmatch.d()) && gw.a(Long.valueOf(((TurnBasedMatch) (obj)).e()), Long.valueOf(turnbasedmatch.e())) && gw.a(((TurnBasedMatch) (obj)).j(), turnbasedmatch.j()) && gw.a(Long.valueOf(((TurnBasedMatch) (obj)).k()), Long.valueOf(turnbasedmatch.k())) && gw.a(((TurnBasedMatch) (obj)).l(), turnbasedmatch.l()) && gw.a(Integer.valueOf(((TurnBasedMatch) (obj)).f()), Integer.valueOf(turnbasedmatch.f())) && gw.a(Integer.valueOf(((TurnBasedMatch) (obj)).g()), Integer.valueOf(turnbasedmatch.g())) && gw.a(Integer.valueOf(((TurnBasedMatch) (obj)).h()), Integer.valueOf(turnbasedmatch.h())) && gw.a(Integer.valueOf(((TurnBasedMatch) (obj)).n()), Integer.valueOf(turnbasedmatch.n())) && gw.a(((TurnBasedMatch) (obj)).i(), turnbasedmatch.i()) && gw.a(((TurnBasedMatch) (obj)).o(), turnbasedmatch.o()) && gw.a(Integer.valueOf(((TurnBasedMatch) (obj)).q()), Integer.valueOf(turnbasedmatch.q())) && gw.a(((TurnBasedMatch) (obj)).r(), turnbasedmatch.r()) && gw.a(Integer.valueOf(((TurnBasedMatch) (obj)).s()), Integer.valueOf(turnbasedmatch.s())) && gw.a(Boolean.valueOf(((TurnBasedMatch) (obj)).t()), Boolean.valueOf(turnbasedmatch.t())))
            {
                return true;
            }
        }
        return false;
    }

    static String b(TurnBasedMatch turnbasedmatch)
    {
        return gw.a(turnbasedmatch).a("Game", turnbasedmatch.b()).a("MatchId", turnbasedmatch.c()).a("CreatorId", turnbasedmatch.d()).a("CreationTimestamp", Long.valueOf(turnbasedmatch.e())).a("LastUpdaterId", turnbasedmatch.j()).a("LastUpdatedTimestamp", Long.valueOf(turnbasedmatch.k())).a("PendingParticipantId", turnbasedmatch.l()).a("MatchStatus", Integer.valueOf(turnbasedmatch.f())).a("TurnStatus", Integer.valueOf(turnbasedmatch.g())).a("Variant", Integer.valueOf(turnbasedmatch.h())).a("Data", turnbasedmatch.m()).a("Version", Integer.valueOf(turnbasedmatch.n())).a("Participants", turnbasedmatch.i()).a("RematchId", turnbasedmatch.o()).a("PreviousData", turnbasedmatch.p()).a("MatchNumber", Integer.valueOf(turnbasedmatch.q())).a("AutoMatchCriteria", turnbasedmatch.r()).a("AvailableAutoMatchSlots", Integer.valueOf(turnbasedmatch.s())).a("LocallyModified", Boolean.valueOf(turnbasedmatch.t())).toString();
    }

    public final volatile Object a()
    {
        return this;
    }

    public final Game b()
    {
        return c;
    }

    public final String c()
    {
        return d;
    }

    public final String d()
    {
        return e;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final long e()
    {
        return f;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final int f()
    {
        return j;
    }

    public final int g()
    {
        return r;
    }

    public final int h()
    {
        return k;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final ArrayList i()
    {
        return new ArrayList(t);
    }

    public final String j()
    {
        return g;
    }

    public final long k()
    {
        return h;
    }

    public final String l()
    {
        return i;
    }

    public final byte[] m()
    {
        return m;
    }

    public final int n()
    {
        return l;
    }

    public final String o()
    {
        return n;
    }

    public final byte[] p()
    {
        return o;
    }

    public final int q()
    {
        return p;
    }

    public final Bundle r()
    {
        return q;
    }

    public final int s()
    {
        if (q == null)
        {
            return 0;
        } else
        {
            return q.getInt("max_automatch_players");
        }
    }

    public final boolean t()
    {
        return s;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.games.multiplayer.turnbased.b.a(this, parcel, i1);
    }

}
