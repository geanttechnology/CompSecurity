// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;

public final class m
{

    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    final int f;
    final int g;
    final int h;
    final int i;
    final int j;
    final int k;
    final int l;
    final int m;
    final int n;
    final int o;
    final int p;
    final int q;
    final int r;
    final int s;
    final int t;
    final int u;

    public m(Cursor cursor, String s1, String s2)
    {
        a = cursor.getColumnIndexOrThrow("_id");
        b = cursor.getColumnIndexOrThrow("flyer_id");
        c = cursor.getColumnIndexOrThrow("flyer_item_id");
        d = cursor.getColumnIndexOrThrow("coupon_id");
        e = cursor.getColumnIndexOrThrow("left");
        f = cursor.getColumnIndexOrThrow("top");
        g = cursor.getColumnIndexOrThrow("right");
        h = cursor.getColumnIndexOrThrow("bottom");
        i = cursor.getColumnIndexOrThrow("item_current_price");
        j = cursor.getColumnIndexOrThrow("item_original_price");
        k = cursor.getColumnIndexOrThrow("item_dollars_off");
        l = cursor.getColumnIndexOrThrow("item_cutout_url");
        m = cursor.getColumnIndexOrThrow("coupon_dollars_off");
        n = cursor.getColumnIndexOrThrow("total_savings");
        o = cursor.getColumnIndexOrThrow("final_price");
        p = cursor.getColumnIndexOrThrow("percent_off");
        q = cursor.getColumnIndexOrThrow("display_final_price");
        r = cursor.getColumnIndexOrThrow("display_type");
        s = cursor.getColumnIndexOrThrow("item_rank");
        t = cursor.getColumnIndex(s1);
        u = cursor.getColumnIndex(s2);
    }
}
