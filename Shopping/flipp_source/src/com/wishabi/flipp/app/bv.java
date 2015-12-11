// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.database.Cursor;

// Referenced classes of package com.wishabi.flipp.app:
//            bw

final class bv
{

    float a;
    float b;
    float c;
    float d;
    int e;
    private int f;
    private int g;
    private String h;

    public bv(bw bw1, Cursor cursor)
    {
        f = cursor.getInt(bw1.a);
        g = cursor.getInt(bw1.b);
        a = cursor.getFloat(bw1.c);
        b = cursor.getFloat(bw1.d);
        c = cursor.getFloat(bw1.e);
        d = cursor.getFloat(bw1.f);
        h = cursor.getString(bw1.g);
        e = cursor.getInt(bw1.h);
    }
}
