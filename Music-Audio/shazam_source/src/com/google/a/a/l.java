// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import java.io.Serializable;
import java.util.Arrays;

// Referenced classes of package com.google.a.a:
//            k, f

public final class l
{
    private static final class a
        implements k, Serializable
    {

        final Object a;

        public final Object a()
        {
            return a;
        }

        public final boolean equals(Object obj)
        {
            if (obj instanceof a)
            {
                obj = (a)obj;
                return f.a(a, ((a) (obj)).a);
            } else
            {
                return false;
            }
        }

        public final int hashCode()
        {
            return Arrays.hashCode(new Object[] {
                a
            });
        }

        public final String toString()
        {
            String s = String.valueOf(String.valueOf(a));
            return (new StringBuilder(s.length() + 22)).append("Suppliers.ofInstance(").append(s).append(")").toString();
        }

        public a(Object obj)
        {
            a = obj;
        }
    }

}
