// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a.b;


// Referenced classes of package org.a.a.a.a.b:
//            a

public class b
{

    public static CharSequence a(CharSequence charsequence, String s)
    {
        if (charsequence == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" may not be null").toString());
        }
        if (org.a.a.a.a.b.a.a(charsequence))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" may not be blank").toString());
        } else
        {
            return charsequence;
        }
    }

    public static Object a(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" may not be null").toString());
        } else
        {
            return obj;
        }
    }

    public static void a(boolean flag, String s)
    {
        if (!flag)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }
}
