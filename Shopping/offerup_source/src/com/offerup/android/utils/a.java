// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.UriMatcher;
import android.net.Uri;
import com.offerup.android.dto.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
{

    static List a;
    private UriMatcher b;
    private com.offerup.android.activities.a c;
    private final boolean d;

    public a(com.offerup.android.activities.a a1, boolean flag)
    {
        c = a1;
        d = flag;
        b = new UriMatcher(-1);
        b.addURI("*", "accounts/settings", 2);
        b.addURI("*", "p/#", 3);
        b.addURI("*", "item/detail/#", 4);
        b.addURI("*", "search", 5);
        b.addURI("*", "/item/#/discussions/#/messages", 6);
    }

    public static void a(long l)
    {
        com/offerup/android/utils/a;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new ArrayList(1);
        }
        a.add(Long.valueOf(l));
        com/offerup/android/utils/a;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean a(Item item)
    {
        return item != null && item.getState() == 4;
    }

    public final void a(Uri uri)
    {
        Object obj3 = null;
        if (uri == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj4;
        Iterator iterator;
        switch (b.match(uri))
        {
        default:
            c.a(uri.getPath(), d, null);
            return;

        case 2: // '\002'
            c.a(d);
            return;

        case 4: // '\004'
            long l = Long.parseLong((String)uri.getPathSegments().get(2));
            c.a(l, d, null);
            return;

        case 6: // '\006'
            long l1 = Long.parseLong((String)uri.getPathSegments().get(1));
            long l3 = Long.parseLong((String)uri.getPathSegments().get(3));
            c.a(l3, l1, d);
            return;

        case 3: // '\003'
            long l2 = Long.parseLong((String)uri.getPathSegments().get(1));
            c.a(l2);
            return;

        case 5: // '\005'
            iterator = uri.getQueryParameterNames().iterator();
            obj2 = null;
            obj = null;
            obj1 = null;
            obj4 = null;
            break;
        }
_L4:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_352;
        }
        String s = (String)iterator.next();
        Object obj5 = uri.getQueryParameter(s);
        if ("lat".equals(s))
        {
            try
            {
                obj5 = Double.valueOf(((String) (obj5)));
            }
            catch (NumberFormatException numberformatexception)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        if ("lon".equals(s))
        {
            try
            {
                obj5 = Double.valueOf(((String) (obj5)));
            }
            catch (NumberFormatException numberformatexception1)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = obj5;
            continue; /* Loop/switch isn't completed */
        }
        if ("cid".equals(s))
        {
            try
            {
                obj5 = Integer.valueOf(((String) (obj5)));
            }
            catch (NumberFormatException numberformatexception2)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj2 = obj5;
            continue; /* Loop/switch isn't completed */
        }
        if (!"lid".equals(s))
        {
            break MISSING_BLOCK_LABEL_335;
        }
        obj5 = Integer.valueOf(((String) (obj5)));
        obj3 = obj5;
        continue; /* Loop/switch isn't completed */
        if ("q".equals(s))
        {
            obj4 = obj5;
        }
        continue; /* Loop/switch isn't completed */
        if (obj4 != null || obj3 != null || obj2 != null || obj1 != null && obj != null)
        {
            c.a(((String) (obj4)), ((Integer) (obj3)), ((Integer) (obj2)), ((Double) (obj1)), ((Double) (obj)));
            return;
        } else
        {
            c.m();
            return;
        }
_L2:
        c.d();
        return;
        NumberFormatException numberformatexception3;
        numberformatexception3;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(String s)
    {
        try
        {
            a(Uri.parse(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            c.d();
        }
    }
}
