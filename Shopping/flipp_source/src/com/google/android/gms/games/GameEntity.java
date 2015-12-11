// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games:
//            Game, a, e

public final class GameEntity extends fm
    implements Game
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    final int a;
    final String b;
    final String c;
    final String d;
    final String e;
    final String f;
    final String g;
    final Uri h;
    final Uri i;
    final Uri j;
    final boolean k;
    final boolean l;
    final String m;
    final int n;
    final int o;
    final int p;
    final boolean q;
    final boolean r;

    GameEntity(int i1, String s1, String s2, String s3, String s4, String s5, String s6, 
            Uri uri, Uri uri1, Uri uri2, boolean flag, boolean flag1, String s7, int j1, 
            int k1, int l1, boolean flag2, boolean flag3)
    {
        a = i1;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = uri;
        i = uri1;
        j = uri2;
        k = flag;
        l = flag1;
        m = s7;
        n = j1;
        o = k1;
        p = l1;
        q = flag2;
        r = flag3;
    }

    public GameEntity(Game game)
    {
        a = 2;
        b = game.b();
        d = game.d();
        e = game.e();
        f = game.f();
        g = game.g();
        c = game.c();
        h = game.h();
        i = game.i();
        j = game.j();
        k = game.k();
        l = game.l();
        m = game.m();
        n = game.n();
        o = game.o();
        p = game.p();
        q = game.q();
        r = game.r();
    }

    static int a(Game game)
    {
        return Arrays.hashCode(new Object[] {
            game.b(), game.c(), game.d(), game.e(), game.f(), game.g(), game.h(), game.i(), game.j(), Boolean.valueOf(game.k()), 
            Boolean.valueOf(game.l()), game.m(), Integer.valueOf(game.n()), Integer.valueOf(game.o()), Integer.valueOf(game.p()), Boolean.valueOf(game.q()), Boolean.valueOf(game.r())
        });
    }

    static boolean a(Game game, Object obj)
    {
        if (obj instanceof Game)
        {
            if (game == obj)
            {
                return true;
            }
            obj = (Game)obj;
            if (gw.a(((Game) (obj)).b(), game.b()) && gw.a(((Game) (obj)).c(), game.c()) && gw.a(((Game) (obj)).d(), game.d()) && gw.a(((Game) (obj)).e(), game.e()) && gw.a(((Game) (obj)).f(), game.f()) && gw.a(((Game) (obj)).g(), game.g()) && gw.a(((Game) (obj)).h(), game.h()) && gw.a(((Game) (obj)).i(), game.i()) && gw.a(((Game) (obj)).j(), game.j()) && gw.a(Boolean.valueOf(((Game) (obj)).k()), Boolean.valueOf(game.k())) && gw.a(Boolean.valueOf(((Game) (obj)).l()), Boolean.valueOf(game.l())) && gw.a(((Game) (obj)).m(), game.m()) && gw.a(Integer.valueOf(((Game) (obj)).n()), Integer.valueOf(game.n())) && gw.a(Integer.valueOf(((Game) (obj)).o()), Integer.valueOf(game.o())) && gw.a(Integer.valueOf(((Game) (obj)).p()), Integer.valueOf(game.p())) && gw.a(Boolean.valueOf(((Game) (obj)).q()), Boolean.valueOf(game.q())) && gw.a(Boolean.valueOf(((Game) (obj)).r()), Boolean.valueOf(game.r())))
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

    static boolean a(String s1)
    {
        return b(s1);
    }

    static String b(Game game)
    {
        return gw.a(game).a("ApplicationId", game.b()).a("DisplayName", game.c()).a("PrimaryCategory", game.d()).a("SecondaryCategory", game.e()).a("Description", game.f()).a("DeveloperName", game.g()).a("IconImageUri", game.h()).a("HiResImageUri", game.i()).a("FeaturedImageUri", game.j()).a("PlayEnabledGame", Boolean.valueOf(game.k())).a("InstanceInstalled", Boolean.valueOf(game.l())).a("InstancePackageName", game.m()).a("GameplayAclStatus", Integer.valueOf(game.n())).a("AchievementTotalCount", Integer.valueOf(game.o())).a("LeaderboardCount", Integer.valueOf(game.p())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.q())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.r())).toString();
    }

    static Integer s()
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

    public final String d()
    {
        return d;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String e()
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

    public final String g()
    {
        return g;
    }

    public final Uri h()
    {
        return h;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final Uri i()
    {
        return i;
    }

    public final Uri j()
    {
        return j;
    }

    public final boolean k()
    {
        return k;
    }

    public final boolean l()
    {
        return l;
    }

    public final String m()
    {
        return m;
    }

    public final int n()
    {
        return n;
    }

    public final int o()
    {
        return o;
    }

    public final int p()
    {
        return p;
    }

    public final boolean q()
    {
        return q;
    }

    public final boolean r()
    {
        return r;
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        Object obj = null;
        if (!super.s)
        {
            com.google.android.gms.games.e.a(this, parcel, i1);
            return;
        }
        parcel.writeString(b);
        parcel.writeString(c);
        parcel.writeString(d);
        parcel.writeString(e);
        parcel.writeString(f);
        parcel.writeString(g);
        String s1;
        if (h == null)
        {
            s1 = null;
        } else
        {
            s1 = h.toString();
        }
        parcel.writeString(s1);
        if (i == null)
        {
            s1 = null;
        } else
        {
            s1 = i.toString();
        }
        parcel.writeString(s1);
        if (j == null)
        {
            s1 = obj;
        } else
        {
            s1 = j.toString();
        }
        parcel.writeString(s1);
        if (k)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        if (l)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeString(m);
        parcel.writeInt(n);
        parcel.writeInt(o);
        parcel.writeInt(p);
    }

}
