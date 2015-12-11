// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.database.Cursor;
import cn.jpush.android.data.k;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.service:
//            g

final class i
    implements Runnable
{

    final long a;
    final g b;

    i(g g1, long l)
    {
        b = g1;
        a = l;
        super();
    }

    public final void run()
    {
        Cursor cursor;
        if (g.a() == null && g.a(b) != null)
        {
            g.a(new cn.jpush.android.data.i(g.a(b)));
        }
        cursor = null;
        Cursor cursor1;
        g.a().a();
        cursor1 = g.a().a(a, 0);
        cursor = cursor1;
        g.a();
        cn.jpush.android.data.i.a(cursor, g.b());
        if (1 != g.b().c()) goto _L2; else goto _L1
_L1:
        x.c();
        g.a().b(g.b().a(), 0, 1, 0, g.b().d(), g.b().f(), g.b().e());
_L5:
        g.a().b();
        if (cursor != null)
        {
            cursor.close();
        }
_L7:
        return;
_L2:
        if (g.b().b() <= 1) goto _L4; else goto _L3
_L3:
        x.c();
        g.a().b(g.b().a(), g.b().b() - 1, 0, 0, g.b().d(), g.b().f(), g.b().e());
          goto _L5
        Exception exception1;
        exception1;
_L13:
        if (cursor == null) goto _L7; else goto _L6
_L6:
        cursor.close();
        return;
_L4:
        if (g.b().b() != 1) goto _L9; else goto _L8
_L8:
        long l;
        x.c();
        l = System.currentTimeMillis();
        if (g.b().f() <= l) goto _L11; else goto _L10
_L10:
        x.c();
          goto _L5
        Exception exception2;
        exception2;
        Exception exception;
        exception1 = cursor;
        exception = exception2;
_L12:
        if (exception1 != null)
        {
            exception1.close();
        }
        throw exception;
_L11:
        g.a(b, g.a(b), g.b().d(), g.b(b), "");
        g.a().b(g.b().a(), 0, 0, 0, g.b().d(), g.b().f(), g.b().e());
          goto _L5
_L9:
        x.c();
          goto _L5
        exception;
        exception1 = null;
          goto _L12
        exception1;
          goto _L13
    }
}
