// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames
{

    public final String name;
    public final String title;
    public final String zzazA;
    public final String zzazB;
    public final String zzazC;
    public final String zzazD;
    public final String zzazE;
    public final String zzazF;
    public final String zzazG;
    public final String zzazH;
    public final String zzazI;
    public final String zzazJ;
    public final String zzazK;
    public final String zzazL;
    public final String zzazM;
    public final String zzazN;
    public final String zzazO;
    public final String zzazP;
    public final String zzazq;
    public final String zzazr;
    public final String zzazs;
    public final String zzazt;
    public final String zzazu;
    public final String zzazv;
    public final String zzazw;
    public final String zzazx;
    public final String zzazy;
    public final String zzazz;

    public PlayerColumnNames(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            zzazq = "external_player_id";
            zzazr = "profile_name";
            zzazs = "profile_icon_image_uri";
            zzazt = "profile_icon_image_url";
            zzazu = "profile_hi_res_image_uri";
            zzazv = "profile_hi_res_image_url";
            zzazw = "last_updated";
            zzazx = "is_in_circles";
            zzazy = "played_with_timestamp";
            zzazz = "current_xp_total";
            zzazA = "current_level";
            zzazB = "current_level_min_xp";
            zzazC = "current_level_max_xp";
            zzazD = "next_level";
            zzazE = "next_level_max_xp";
            zzazF = "last_level_up_timestamp";
            title = "player_title";
            zzazG = "has_all_public_acls";
            zzazH = "is_profile_visible";
            zzazI = "most_recent_external_game_id";
            zzazJ = "most_recent_game_name";
            zzazK = "most_recent_activity_timestamp";
            zzazL = "most_recent_game_icon_uri";
            zzazM = "most_recent_game_hi_res_uri";
            zzazN = "most_recent_game_featured_uri";
            zzazO = "has_debug_access";
            zzazP = "gamer_tag";
            name = "real_name";
            return;
        } else
        {
            zzazq = (new StringBuilder()).append(s).append("external_player_id").toString();
            zzazr = (new StringBuilder()).append(s).append("profile_name").toString();
            zzazs = (new StringBuilder()).append(s).append("profile_icon_image_uri").toString();
            zzazt = (new StringBuilder()).append(s).append("profile_icon_image_url").toString();
            zzazu = (new StringBuilder()).append(s).append("profile_hi_res_image_uri").toString();
            zzazv = (new StringBuilder()).append(s).append("profile_hi_res_image_url").toString();
            zzazw = (new StringBuilder()).append(s).append("last_updated").toString();
            zzazx = (new StringBuilder()).append(s).append("is_in_circles").toString();
            zzazy = (new StringBuilder()).append(s).append("played_with_timestamp").toString();
            zzazz = (new StringBuilder()).append(s).append("current_xp_total").toString();
            zzazA = (new StringBuilder()).append(s).append("current_level").toString();
            zzazB = (new StringBuilder()).append(s).append("current_level_min_xp").toString();
            zzazC = (new StringBuilder()).append(s).append("current_level_max_xp").toString();
            zzazD = (new StringBuilder()).append(s).append("next_level").toString();
            zzazE = (new StringBuilder()).append(s).append("next_level_max_xp").toString();
            zzazF = (new StringBuilder()).append(s).append("last_level_up_timestamp").toString();
            title = (new StringBuilder()).append(s).append("player_title").toString();
            zzazG = (new StringBuilder()).append(s).append("has_all_public_acls").toString();
            zzazH = (new StringBuilder()).append(s).append("is_profile_visible").toString();
            zzazI = (new StringBuilder()).append(s).append("most_recent_external_game_id").toString();
            zzazJ = (new StringBuilder()).append(s).append("most_recent_game_name").toString();
            zzazK = (new StringBuilder()).append(s).append("most_recent_activity_timestamp").toString();
            zzazL = (new StringBuilder()).append(s).append("most_recent_game_icon_uri").toString();
            zzazM = (new StringBuilder()).append(s).append("most_recent_game_hi_res_uri").toString();
            zzazN = (new StringBuilder()).append(s).append("most_recent_game_featured_uri").toString();
            zzazO = (new StringBuilder()).append(s).append("has_debug_access").toString();
            zzazP = (new StringBuilder()).append(s).append("gamer_tag").toString();
            name = (new StringBuilder()).append(s).append("real_name").toString();
            return;
        }
    }
}
