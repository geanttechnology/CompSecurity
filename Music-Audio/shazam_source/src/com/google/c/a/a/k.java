// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.google.c.a.a:
//            j, i

public final class k extends j
{

    public k()
    {
    }

    private static void a(Collection collection, Collection collection1, String s)
    {
        Object obj = null;
        int l = s.indexOf(';');
        if (l < 0)
        {
            collection.add(s);
            collection1.add(null);
            return;
        }
        collection.add(s.substring(0, l));
        s = s.substring(l + 1);
        collection = obj;
        if (s.startsWith("via="))
        {
            collection = s.substring(4);
        }
        collection1.add(collection);
    }

    protected final i a()
    {
        return i.g;
    }

    public final boolean a(String s)
    {
        int i1 = 0;
        s = c(s);
        if (!s.startsWith("sms:") && !s.startsWith("SMS:") && !s.startsWith("mms:") && !s.startsWith("MMS:"))
        {
            return false;
        }
        Object obj = e(s);
        boolean flag = i1;
        if (obj != null)
        {
            flag = i1;
            if (!((Map) (obj)).isEmpty())
            {
                flag = true;
            }
        }
        i1 = s.indexOf('?', 4);
        ArrayList arraylist;
        int l;
        if (i1 < 0 || !flag)
        {
            s = s.substring(4);
        } else
        {
            s = s.substring(4, i1);
        }
        l = -1;
        obj = new ArrayList(1);
        arraylist = new ArrayList(1);
        do
        {
            i1 = s.indexOf(',', l + 1);
            if (i1 > l)
            {
                a(((Collection) (obj)), ((Collection) (arraylist)), s.substring(l + 1, i1));
                l = i1;
            } else
            {
                a(((Collection) (obj)), ((Collection) (arraylist)), s.substring(l + 1));
                return true;
            }
        } while (true);
    }
}
