// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;

public final class d
{

    final int A;
    public final int a;
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
    final int v;
    final int w;
    final int x;
    final int y;
    final int z;

    public d(Cursor cursor)
    {
        this(cursor, null, null);
    }

    public d(Cursor cursor, String s1, String s2)
    {
        String s3 = s1;
        if (s1 == null)
        {
            s3 = "";
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        a = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("_id").toString());
        b = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("merchant_id").toString());
        c = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("merchant_name").toString());
        d = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("merchant_logo_url").toString());
        e = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("coupon_vendor_id").toString());
        f = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("coupon_type").toString());
        g = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("brand").toString());
        h = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("brand_logo_url").toString());
        i = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("sale_story").toString());
        j = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("dollars_off").toString());
        k = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("percent_off").toString());
        l = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("qualifying_quantity").toString());
        m = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("reward_quantity").toString());
        n = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("promotion_text").toString());
        o = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("redemption_method").toString());
        p = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("available_from").toString());
        q = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("available_to").toString());
        r = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("valid_from").toString());
        s = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("valid_to").toString());
        t = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("coupon_image_url").toString());
        u = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("barcode_image_url").toString());
        v = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("use_sales_story").toString());
        w = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("priority").toString());
        x = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("postal_code").toString());
        y = cursor.getColumnIndexOrThrow((new StringBuilder()).append(s3).append("deleted").toString());
        z = cursor.getColumnIndex((new StringBuilder()).append(s1).append("clipped").toString());
        A = cursor.getColumnIndex((new StringBuilder()).append(s1).append("sent").toString());
    }
}
