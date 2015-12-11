// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

public class b extends com.target.mothership.model.common.a.b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERR_NETWORK;
        public static final a ERR_STORE_NOT_FOUND;
        private c mCode[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/weeklyad/interfaces/a/b$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public c[] a()
        {
            return mCode;
        }

        static 
        {
            ERR_NETWORK = new a("ERR_NETWORK", 0, new c[0]);
            ERR_STORE_NOT_FOUND = new a("ERR_STORE_NOT_FOUND", 1, new c[0]);
            $VALUES = (new a[] {
                ERR_NETWORK, ERR_STORE_NOT_FOUND
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mCode = ac;
        }
    }


    public b()
    {
    }

    public a[] a()
    {
        return a.values();
    }

    public j[] c()
    {
        return a();
    }
}
