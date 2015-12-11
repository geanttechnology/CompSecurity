// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import com.poshmark.http.api.PMApi;

public class FollowFollowingHelper
{

    public FollowFollowingHelper()
    {
    }

    public static void fireFollowCall(String s)
    {
        PMApi.followUser(s, null);
    }

    public static void fireUnfollowCall(String s)
    {
        PMApi.unFollowUser(s, null);
    }

    public static void setFollowButton(Context context, Button button)
    {
        button.setBackgroundDrawable(context.getResources().getDrawable(0x7f020005));
        button.setTextColor(context.getResources().getColor(0x7f090040));
        button.setText(context.getResources().getString(0x7f06012f));
    }

    public static void setFollowingButton(Context context, Button button)
    {
        button.setBackgroundDrawable(context.getResources().getDrawable(0x7f020009));
        button.setTextColor(context.getResources().getColor(0x7f090039));
        button.setText(context.getResources().getString(0x7f060134));
    }
}
