// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

final class ahy extends bmr
{

    private ahs a;

    ahy(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    public final Object a()
    {
        boolean flag;
        if (ahs.h(a).s() || "true".equalsIgnoreCase(ahs.c(a).i().getString("youtube.mdx.enable_logs", "")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
