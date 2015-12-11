// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.d;


// Referenced classes of package com.gimbal.internal.d:
//            i

public final class h extends i
{

    public h()
    {
        super(new Class[0]);
    }

    public final String a(String s)
    {
        Object obj = s;
        if (s != null)
        {
            obj = new StringBuilder();
            s = s.toCharArray();
            int k = s.length;
            int j = 0;
            while (j < k) 
            {
                char c = s[j];
                if (Character.isUpperCase(c))
                {
                    ((StringBuilder) (obj)).append('_');
                    ((StringBuilder) (obj)).append(Character.toLowerCase(c));
                } else
                {
                    ((StringBuilder) (obj)).append(c);
                }
                j++;
            }
            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

    public final String b(String s)
    {
        Object obj = s;
        if (s != null)
        {
            obj = new StringBuilder();
            s = s.toCharArray();
            int k = s.length;
            int j = 0;
            boolean flag = false;
            while (j < k) 
            {
                char c = s[j];
                if (c == '_')
                {
                    flag = true;
                } else
                if (flag)
                {
                    ((StringBuilder) (obj)).append(Character.toUpperCase(c));
                    flag = false;
                } else
                {
                    ((StringBuilder) (obj)).append(c);
                }
                j++;
            }
            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }
}
