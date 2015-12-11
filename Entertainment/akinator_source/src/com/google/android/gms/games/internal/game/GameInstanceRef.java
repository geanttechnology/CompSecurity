// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.PlatformType;

// Referenced classes of package com.google.android.gms.games.internal.game:
//            GameInstance

public final class GameInstanceRef extends zzc
    implements GameInstance
{

    GameInstanceRef(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    public String getApplicationId()
    {
        return getString("external_game_id");
    }

    public String getDisplayName()
    {
        return getString("instance_display_name");
    }

    public String getPackageName()
    {
        return getString("package_name");
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("ApplicationId", getApplicationId()).zzg("DisplayName", getDisplayName()).zzg("SupportsRealTime", Boolean.valueOf(zzvl())).zzg("SupportsTurnBased", Boolean.valueOf(zzvm())).zzg("PlatformType", PlatformType.zzfZ(zzsu())).zzg("PackageName", getPackageName()).zzg("PiracyCheckEnabled", Boolean.valueOf(zzvn())).zzg("Installed", Boolean.valueOf(zzvo())).toString();
    }

    public int zzsu()
    {
        return getInteger("platform_type");
    }

    public boolean zzvl()
    {
        return getInteger("real_time_support") > 0;
    }

    public boolean zzvm()
    {
        return getInteger("turn_based_support") > 0;
    }

    public boolean zzvn()
    {
        return getInteger("piracy_check") > 0;
    }

    public boolean zzvo()
    {
        return getInteger("installed") > 0;
    }
}
