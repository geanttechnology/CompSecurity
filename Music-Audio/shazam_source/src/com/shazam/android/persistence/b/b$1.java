// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.b;

import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.m.c;
import java.util.List;

// Referenced classes of package com.shazam.android.persistence.b:
//            b

final class b
    implements c
{

    final List a;
    final String b;
    final b c;

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        com.shazam.android.persistence.b.b.a(c, sqlitedatabase, a, b);
    }

    e(b b1, List list, String s)
    {
        c = b1;
        a = list;
        b = s;
        super();
    }
}
