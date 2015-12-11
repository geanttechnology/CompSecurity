// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.c;
import java.util.List;

public final class v
{
    public static final class a
    {

        private final com.google.api.a.f.a.a.a.a.b.a a;

        public final a a(String s, Object obj)
        {
            boolean flag = false;
            com.google.api.a.f.a.a.a.a.b.a a1 = a;
            c.a(s);
            com.google.api.a.f.a.a.a.a.b.a.a a2 = new com.google.api.a.f.a.a.a.a.b.a.a((byte)0);
            a1.a.add(a2);
            if (obj == null)
            {
                flag = true;
            }
            a2.b = flag;
            a2.a.append(s).append('=').append(obj);
            return this;
        }

        public final String toString()
        {
            return a.toString();
        }

        public a(com.google.api.a.f.a.a.a.a.b.a a1)
        {
            a = a1;
        }
    }


    public static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }
}
