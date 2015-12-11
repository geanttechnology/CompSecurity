// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class axd
    implements Comparator
{

    axd()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (byte[])obj;
        obj1 = (byte[])obj1;
        int j = Math.min(obj.length, obj1.length);
        for (int i = 0; i < j; i++)
        {
            int k = obj[i] & 0xff;
            int l = obj1[i] & 0xff;
            if (k != l)
            {
                return k - l;
            }
        }

        return obj.length - obj1.length;
    }
}
