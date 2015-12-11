// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.List;

final class an
{

    private final y a;

    an(y y1)
    {
        a = y1;
        y1.a(200);
    }

    final List a()
    {
        List list = Collections.emptyList();
        Object obj;
        try
        {
            obj = a.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            p.a("Error reading beacons from database", ((Throwable) (obj)));
            return list;
        }
        try
        {
            a.b();
        }
        catch (Throwable throwable)
        {
            p.a("Error clearing beacons from database", throwable);
            return ((List) (obj));
        }
        return ((List) (obj));
    }

    final boolean a(List list)
    {
        boolean flag;
        try
        {
            flag = a.a(list);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            p.a("Error writing beacons to database", list);
            return false;
        }
        return flag;
    }

    public final void b()
    {
        a.c();
    }
}
