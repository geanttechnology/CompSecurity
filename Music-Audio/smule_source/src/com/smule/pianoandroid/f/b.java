// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.f;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.smule.android.c.d;
import com.smule.android.f.p;
import com.smule.android.facebook.a;
import com.smule.android.network.core.r;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.utils.q;
import java.util.Arrays;
import java.util.List;

public class b
{

    public static final String a = MagicApplication.getContext().getString(0x7f0c0100);
    public static List b = Arrays.asList(new String[] {
        "user_birthday", "email"
    });

    public static void a(int i)
    {
        if (i > 0)
        {
            GameReward gamereward = new GameReward();
            gamereward.type = com.smule.pianoandroid.data.model.GameReward.Type.COINS.toString();
            q.a(d.e, Arrays.asList(new GameReward[] {
                gamereward
            }));
        }
        p.a(com.smule.android.facebook.a.a().d().edit().putBoolean("HAS_CLAIMED_INCENTIVE", true));
    }

    public static boolean a()
    {
        return com.smule.android.facebook.a.a().d().getBoolean("HAS_CLAIMED_INCENTIVE", false);
    }

    public static boolean a(Activity activity)
    {
        String s = com.smule.android.network.managers.a.a().a("piandroid.offers", "fb-login.reward", "n/a");
        return r.a(activity) && !s.equals("n/a");
    }

}
