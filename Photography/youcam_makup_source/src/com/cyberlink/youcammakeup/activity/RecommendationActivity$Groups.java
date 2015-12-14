// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;

public class <init> extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static <init> b(Intent intent)
    {
        if (!intent.hasExtra("Groups"))
        {
            throw new IllegalStateException();
        } else
        {
            return values()[intent.getIntExtra("Groups", -1)];
        }
    }

    public static values valueOf(String s)
    {
        return (values)Enum.valueOf(com/cyberlink/youcammakeup/activity/RecommendationActivity$Groups, s);
    }

    public static values[] values()
    {
        return (values[])c.clone();
    }

    public void a(Intent intent)
    {
        intent.putExtra("Groups", ordinal());
    }

    static 
    {
        a = new RecommendationActivity.Groups("Recommendation", 0) {

            public String toString()
            {
                return "GROUP_ANDOIRD_YMK_RECOMMENDATION_001";
            }

        };
        b = new RecommendationActivity.Groups("CyberLink", 1) {

            public String toString()
            {
                return "GROUP_ANDROID_YMK_CYBERLINK_APP";
            }

        };
        c = (new c[] {
            a, b
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
