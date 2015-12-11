// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.text.TextUtils;

final class g
{

    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public g()
    {
        if (TextUtils.isEmpty(null))
        {
            a = "external_player_id";
            b = "profile_name";
            c = "profile_icon_image_uri";
            d = "profile_hi_res_image_uri";
            e = "last_updated";
            f = "is_in_circles";
            g = "played_with_timestamp";
            return;
        } else
        {
            a = (new StringBuilder()).append(null).append("external_player_id").toString();
            b = (new StringBuilder()).append(null).append("profile_name").toString();
            c = (new StringBuilder()).append(null).append("profile_icon_image_uri").toString();
            d = (new StringBuilder()).append(null).append("profile_hi_res_image_uri").toString();
            e = (new StringBuilder()).append(null).append("last_updated").toString();
            f = (new StringBuilder()).append(null).append("is_in_circles").toString();
            g = (new StringBuilder()).append(null).append("played_with_timestamp").toString();
            return;
        }
    }
}
