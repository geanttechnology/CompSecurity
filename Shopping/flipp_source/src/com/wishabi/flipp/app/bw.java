// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.database.Cursor;

final class bw
{

    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;

    private bw(Cursor cursor)
    {
        a = cursor.getColumnIndexOrThrow("id");
        b = cursor.getColumnIndexOrThrow("flyer_id");
        c = cursor.getColumnIndexOrThrow("left");
        d = cursor.getColumnIndexOrThrow("bottom");
        e = cursor.getColumnIndexOrThrow("right");
        f = cursor.getColumnIndexOrThrow("top");
        g = cursor.getColumnIndexOrThrow("name");
        h = cursor.getColumnIndexOrThrow("page");
    }

    bw(Cursor cursor, byte byte0)
    {
        this(cursor);
    }
}
