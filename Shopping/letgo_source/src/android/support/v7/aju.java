// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Comparator;

// Referenced classes of package android.support.v7:
//            aiu

public final class aju
{

    public static String a(String s, aiu aiu1)
    {
        return (new StringBuilder(s)).append("_").append(aiu1.a()).append("x").append(aiu1.b()).toString();
    }

    public static Comparator a()
    {
        return new Comparator() {

            public int a(String s, String s1)
            {
                return s.substring(0, s.lastIndexOf("_")).compareTo(s1.substring(0, s1.lastIndexOf("_")));
            }

            public int compare(Object obj, Object obj1)
            {
                return a((String)obj, (String)obj1);
            }

        };
    }
}
