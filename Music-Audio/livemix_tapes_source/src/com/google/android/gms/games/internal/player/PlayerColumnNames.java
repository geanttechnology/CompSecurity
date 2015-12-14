// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames
{

    public final String title;
    public final String zzawR;
    public final String zzawS;
    public final String zzawT;
    public final String zzawU;
    public final String zzawV;
    public final String zzawW;
    public final String zzawX;
    public final String zzawY;
    public final String zzawZ;
    public final String zzaxa;
    public final String zzaxb;
    public final String zzaxc;
    public final String zzaxd;
    public final String zzaxe;
    public final String zzaxf;
    public final String zzaxg;
    public final String zzaxh;
    public final String zzaxi;
    public final String zzaxj;
    public final String zzaxk;
    public final String zzaxl;
    public final String zzaxm;
    public final String zzaxn;
    public final String zzaxo;
    public final String zzaxp;

    public PlayerColumnNames(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            zzawR = "external_player_id";
            zzawS = "profile_name";
            zzawT = "profile_icon_image_uri";
            zzawU = "profile_icon_image_url";
            zzawV = "profile_hi_res_image_uri";
            zzawW = "profile_hi_res_image_url";
            zzawX = "last_updated";
            zzawY = "is_in_circles";
            zzawZ = "played_with_timestamp";
            zzaxa = "current_xp_total";
            zzaxb = "current_level";
            zzaxc = "current_level_min_xp";
            zzaxd = "current_level_max_xp";
            zzaxe = "next_level";
            zzaxf = "next_level_max_xp";
            zzaxg = "last_level_up_timestamp";
            title = "player_title";
            zzaxh = "has_all_public_acls";
            zzaxi = "is_profile_visible";
            zzaxj = "most_recent_external_game_id";
            zzaxk = "most_recent_game_name";
            zzaxl = "most_recent_activity_timestamp";
            zzaxm = "most_recent_game_icon_uri";
            zzaxn = "most_recent_game_hi_res_uri";
            zzaxo = "most_recent_game_featured_uri";
            zzaxp = "has_debug_access";
            return;
        } else
        {
            zzawR = (new StringBuilder()).append(s).append("external_player_id").toString();
            zzawS = (new StringBuilder()).append(s).append("profile_name").toString();
            zzawT = (new StringBuilder()).append(s).append("profile_icon_image_uri").toString();
            zzawU = (new StringBuilder()).append(s).append("profile_icon_image_url").toString();
            zzawV = (new StringBuilder()).append(s).append("profile_hi_res_image_uri").toString();
            zzawW = (new StringBuilder()).append(s).append("profile_hi_res_image_url").toString();
            zzawX = (new StringBuilder()).append(s).append("last_updated").toString();
            zzawY = (new StringBuilder()).append(s).append("is_in_circles").toString();
            zzawZ = (new StringBuilder()).append(s).append("played_with_timestamp").toString();
            zzaxa = (new StringBuilder()).append(s).append("current_xp_total").toString();
            zzaxb = (new StringBuilder()).append(s).append("current_level").toString();
            zzaxc = (new StringBuilder()).append(s).append("current_level_min_xp").toString();
            zzaxd = (new StringBuilder()).append(s).append("current_level_max_xp").toString();
            zzaxe = (new StringBuilder()).append(s).append("next_level").toString();
            zzaxf = (new StringBuilder()).append(s).append("next_level_max_xp").toString();
            zzaxg = (new StringBuilder()).append(s).append("last_level_up_timestamp").toString();
            title = (new StringBuilder()).append(s).append("player_title").toString();
            zzaxh = (new StringBuilder()).append(s).append("has_all_public_acls").toString();
            zzaxi = (new StringBuilder()).append(s).append("is_profile_visible").toString();
            zzaxj = (new StringBuilder()).append(s).append("most_recent_external_game_id").toString();
            zzaxk = (new StringBuilder()).append(s).append("most_recent_game_name").toString();
            zzaxl = (new StringBuilder()).append(s).append("most_recent_activity_timestamp").toString();
            zzaxm = (new StringBuilder()).append(s).append("most_recent_game_icon_uri").toString();
            zzaxn = (new StringBuilder()).append(s).append("most_recent_game_hi_res_uri").toString();
            zzaxo = (new StringBuilder()).append(s).append("most_recent_game_featured_uri").toString();
            zzaxp = (new StringBuilder()).append(s).append("has_debug_access").toString();
            return;
        }
    }
}
