// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.location.Location;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class am
{

    static Location l;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    String j;
    public String k;
    Map m;

    public am()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        m = new HashMap();
    }

    public static void a(Location location)
    {
        if (location == null)
        {
            return;
        } else
        {
            l = location;
            return;
        }
    }

    public final void a(Map map)
    {
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            if (s.equals("age"))
            {
                a = ((String) (obj));
            } else
            if (s.equals("children"))
            {
                b = ((String) (obj));
            } else
            if (s.equals("education"))
            {
                c = ((String) (obj));
            } else
            if (s.equals("ethnicity"))
            {
                d = ((String) (obj));
            } else
            if (s.equals("gender"))
            {
                e = ((String) (obj));
            } else
            if (s.equals("income"))
            {
                f = ((String) (obj));
            } else
            if (s.equals("keywords"))
            {
                g = ((String) (obj));
            } else
            if (s.equals("marital"))
            {
                h = ((String) (obj));
            } else
            if (s.equals("politics"))
            {
                i = ((String) (obj));
            } else
            if (s.equals("vendor"))
            {
                j = ((String) (obj));
            } else
            if (s.equals("zip"))
            {
                k = ((String) (obj));
            } else
            if (obj != null)
            {
                m.put(s, obj);
            } else
            {
                m.remove(s);
            }
        }

    }
}
