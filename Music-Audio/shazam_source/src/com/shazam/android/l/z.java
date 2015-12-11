// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.net.Uri;
import com.shazam.b.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class z
    implements a
{

    private final Map a;

    public z(Map map)
    {
        a = map;
    }

    public final Object a(Object obj)
    {
        obj = ((Uri)obj).toString();
        Iterator iterator = a.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (java.util.Map.Entry)iterator.next();
            String s = (String)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = (String)((java.util.Map.Entry) (obj1)).getValue();
            boolean flag;
            if (obj == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && !((String) (obj)).isEmpty())
            {
                if (s == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag && !s.isEmpty() && obj1 != null)
                {
                    int k = ((String) (obj)).indexOf(s, 0);
                    if (k != -1)
                    {
                        int i1 = s.length();
                        int j = ((String) (obj1)).length() - i1;
                        int i = j;
                        if (j < 0)
                        {
                            i = 0;
                        }
                        StringBuilder stringbuilder = new StringBuilder(i * 16 + ((String) (obj)).length());
                        i = 0;
                        j = -1;
                        int l;
                        do
                        {
                            l = i;
                            if (k == -1)
                            {
                                break;
                            }
                            stringbuilder.append(((String) (obj)).substring(i, k)).append(((String) (obj1)));
                            i = k + i1;
                            j--;
                            l = i;
                            if (j == 0)
                            {
                                break;
                            }
                            k = ((String) (obj)).indexOf(s, i);
                        } while (true);
                        stringbuilder.append(((String) (obj)).substring(l));
                        obj = stringbuilder.toString();
                    }
                }
            }
        } while (true);
        return Uri.parse(((String) (obj)));
    }
}
