// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.e;

// Referenced classes of package com.google.android.gms.games:
//            Game, GameEntity

public final class b extends e
    implements Game
{

    private Game s()
    {
        return new GameEntity(this);
    }

    public final Object a()
    {
        return s();
    }

    public final String b()
    {
        return d("external_game_id");
    }

    public final String c()
    {
        return d("display_name");
    }

    public final String d()
    {
        return d("primary_category");
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String e()
    {
        return d("secondary_category");
    }

    public final boolean equals(Object obj)
    {
        return GameEntity.a(this, obj);
    }

    public final String f()
    {
        return d("game_description");
    }

    public final String g()
    {
        return d("developer_name");
    }

    public final Uri h()
    {
        return f("game_icon_image_uri");
    }

    public final int hashCode()
    {
        return GameEntity.a(this);
    }

    public final Uri i()
    {
        return f("game_hi_res_image_uri");
    }

    public final Uri j()
    {
        return f("featured_image_uri");
    }

    public final boolean k()
    {
        return c("play_enabled_game");
    }

    public final boolean l()
    {
        return b("installed") > 0;
    }

    public final String m()
    {
        return d("package_name");
    }

    public final int n()
    {
        return b("gameplay_acl_status");
    }

    public final int o()
    {
        return b("achievement_total_count");
    }

    public final int p()
    {
        return b("leaderboard_count");
    }

    public final boolean q()
    {
        return b("real_time_support") > 0;
    }

    public final boolean r()
    {
        return b("turn_based_support") > 0;
    }

    public final String toString()
    {
        return GameEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        ((GameEntity)s()).writeToParcel(parcel, i1);
    }
}
