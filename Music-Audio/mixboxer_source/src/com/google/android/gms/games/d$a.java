// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.text.TextUtils;

// Referenced classes of package com.google.android.gms.games:
//            d

private static final class tN
{

    public final String tH;
    public final String tI;
    public final String tJ;
    public final String tK;
    public final String tL;
    public final String tM;
    public final String tN;

    public (String s)
    {
        if (TextUtils.isEmpty(s))
        {
            tH = "external_player_id";
            tI = "profile_name";
            tJ = "profile_icon_image_uri";
            tK = "profile_hi_res_image_uri";
            tL = "last_updated";
            tM = "is_in_circles";
            tN = "played_with_timestamp";
            return;
        } else
        {
            tH = (new StringBuilder()).append(s).append("external_player_id").toString();
            tI = (new StringBuilder()).append(s).append("profile_name").toString();
            tJ = (new StringBuilder()).append(s).append("profile_icon_image_uri").toString();
            tK = (new StringBuilder()).append(s).append("profile_hi_res_image_uri").toString();
            tL = (new StringBuilder()).append(s).append("last_updated").toString();
            tM = (new StringBuilder()).append(s).append("is_in_circles").toString();
            tN = (new StringBuilder()).append(s).append("played_with_timestamp").toString();
            return;
        }
    }
}
