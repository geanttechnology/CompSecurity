// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.app.Activity;
import com.socialin.android.d;
import myobfuscated.bn.a;
import myobfuscated.f.m;

public class ab
{

    private static String a = (new StringBuilder()).append(com/socialin/android/util/ab.getSimpleName()).append(" - ").toString();

    public ab()
    {
    }

    public static void a(Activity activity, int i)
    {
        if (m.a(activity, "string", "feature_reward_fullscreen") && "true".equals(Integer.valueOf(m.b(activity, "string", "feature_reward_fullscreen"))) && myobfuscated.bn.a.a(activity, i))
        {
            d.b(a, new Object[] {
                "Myus anqam FS kvaeles!"
            });
        }
    }

}
