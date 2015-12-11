// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.b;

import android.database.Cursor;
import com.shazam.j.b;
import com.shazam.j.c;
import java.util.ArrayList;
import java.util.List;

public final class a
    implements com.shazam.b.a.a
{

    public final ArrayList a = new ArrayList();
    private final b b;

    public a(b b1)
    {
        b = b1;
    }

    private List a(Cursor cursor)
    {
        ArrayList arraylist = new ArrayList();
        if (cursor == null || cursor.isClosed()) goto _L2; else goto _L1
_L1:
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        String s = cursor.getString(cursor.getColumnIndex("_id"));
        Object obj;
        Object obj1;
        obj = cursor.getString(cursor.getColumnIndex("_id"));
        obj1 = cursor.getString(cursor.getColumnIndex("request"));
        obj1 = (com.shazam.android.y.d.a)b.a(((String) (obj1)), com/shazam/android/y/d/a);
        com.shazam.android.y.d.b.a a1 = new com.shazam.android.y.d.b.a();
        a1.a = ((String) (obj));
        a1.b = ((com.shazam.android.y.d.a) (obj1));
        obj = new com.shazam.android.y.d.b(a1, (byte)0);
        obj1 = ((com.shazam.android.y.d.b) (obj)).b;
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        if (((com.shazam.android.y.d.a) (obj1)).b == null) goto _L6; else goto _L7
_L7:
        arraylist.add(obj);
_L8:
        boolean flag = cursor.moveToNext();
        if (flag) goto _L3; else goto _L4
_L4:
        cursor.close();
_L2:
        return arraylist;
_L6:
        a.add(s);
          goto _L8
        c c1;
        c1;
        a.add(s);
          goto _L8
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public final volatile Object a(Object obj)
    {
        return a((Cursor)obj);
    }
}
