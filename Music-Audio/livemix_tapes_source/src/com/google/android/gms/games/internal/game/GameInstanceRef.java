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
        return zzw.zzu(this).zzg("ApplicationId", getApplicationId()).zzg("DisplayName", getDisplayName()).zzg("SupportsRealTime", Boolean.valueOf(zzuv())).zzg("SupportsTurnBased", Boolean.valueOf(zzuw())).zzg("PlatformType", PlatformType.zzfQ(zzrI())).zzg("PackageName", getPackageName()).zzg("PiracyCheckEnabled", Boolean.valueOf(zzux())).zzg("Installed", Boolean.valueOf(zzuy())).toString();
    }

    public int zzrI()
    {
        return getInteger("platform_type");
    }

    public boolean zzuv()
    {
        return getInteger("real_time_support") > 0;
    }

    public boolean zzuw()
    {
        return getInteger("turn_based_support") > 0;
    }

    public boolean zzux()
    {
        return getInteger("piracy_check") > 0;
    }

    public boolean zzuy()
    {
        return getInteger("installed") > 0;
    }
}
