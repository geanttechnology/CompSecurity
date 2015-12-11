// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games:
//            Player, c, f

public final class PlayerEntity extends fm
    implements Player
{

    public static final android.os.Parcelable.Creator CREATOR = new c();
    final int a;
    final String b;
    public final String c;
    public final Uri d;
    public final Uri e;
    final long f;
    final int g;
    final long h;

    PlayerEntity(int j, String s, String s1, Uri uri, Uri uri1, long l, 
            int k, long l1)
    {
        a = j;
        b = s;
        c = s1;
        d = uri;
        e = uri1;
        f = l;
        g = k;
        h = l1;
    }

    public PlayerEntity(Player player)
    {
        a = 3;
        b = player.b();
        c = player.c();
        d = player.d();
        e = player.e();
        f = player.f();
        g = player.h();
        h = player.g();
        fu.a(b);
        fu.a(c);
        boolean flag;
        if (f > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException();
        } else
        {
            return;
        }
    }

    static int a(Player player)
    {
        return Arrays.hashCode(new Object[] {
            player.b(), player.c(), player.d(), player.e(), Long.valueOf(player.f())
        });
    }

    static boolean a(Player player, Object obj)
    {
        if (obj instanceof Player)
        {
            if (player == obj)
            {
                return true;
            }
            obj = (Player)obj;
            if (gw.a(((Player) (obj)).b(), player.b()) && gw.a(((Player) (obj)).c(), player.c()) && gw.a(((Player) (obj)).d(), player.d()) && gw.a(((Player) (obj)).e(), player.e()) && gw.a(Long.valueOf(((Player) (obj)).f()), Long.valueOf(player.f())))
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

    static String b(Player player)
    {
        return gw.a(player).a("PlayerId", player.b()).a("DisplayName", player.c()).a("IconImageUri", player.d()).a("HiResImageUri", player.e()).a("RetrievedTimestamp", Long.valueOf(player.f())).toString();
    }

    static Integer i()
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

    public final Uri d()
    {
        return d;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Uri e()
    {
        return e;
    }

    public final boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public final long f()
    {
        return f;
    }

    public final long g()
    {
        return h;
    }

    public final int h()
    {
        return g;
    }

    public final int hashCode()
    {
        return a(this);
    }

    public final String toString()
    {
        return b(this);
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        Object obj = null;
        if (!super.s)
        {
            com.google.android.gms.games.f.a(this, parcel, j);
            return;
        }
        parcel.writeString(b);
        parcel.writeString(c);
        String s;
        if (d == null)
        {
            s = null;
        } else
        {
            s = d.toString();
        }
        parcel.writeString(s);
        if (e == null)
        {
            s = obj;
        } else
        {
            s = e.toString();
        }
        parcel.writeString(s);
        parcel.writeLong(f);
    }

}
