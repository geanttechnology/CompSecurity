// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.Cursor;

public final class ae
{

    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    private final int l;
    private final int m;

    public ae(Cursor cursor)
    {
        a = cursor.getColumnIndexOrThrow("top");
        b = cursor.getColumnIndexOrThrow("bottom");
        c = cursor.getColumnIndexOrThrow("left");
        d = cursor.getColumnIndexOrThrow("right");
        e = cursor.getColumnIndexOrThrow("_id");
        f = cursor.getColumnIndexOrThrow("valid_to");
        g = cursor.getColumnIndexOrThrow("thumbnail");
        h = cursor.getColumnIndexOrThrow("name");
        i = cursor.getColumnIndex("merchant");
        j = cursor.getColumnIndexOrThrow("merchant_logo");
        k = cursor.getColumnIndexOrThrow("flyer_id");
        l = cursor.getColumnIndexOrThrow("premium");
        m = cursor.getColumnIndexOrThrow("price");
    }
}
