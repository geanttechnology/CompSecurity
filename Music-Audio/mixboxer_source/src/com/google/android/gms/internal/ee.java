// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            eg

public final class ee
{
    public static final class a
    {

        private final List pN;
        private final Object pO;

        public a a(String s, Object obj)
        {
            pN.add((new StringBuilder()).append((String)eg.f(s)).append("=").append(String.valueOf(obj)).toString());
            return this;
        }

        public String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder(100)).append(pO.getClass().getSimpleName()).append('{');
            int j = pN.size();
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append((String)pN.get(i));
                if (i < j - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            return stringbuilder.append('}').toString();
        }

        private a(Object obj)
        {
            pO = eg.f(obj);
            pN = new ArrayList();
        }

    }


    public static a e(Object obj)
    {
        return new a(obj);
    }

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static transient int hashCode(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }
}
