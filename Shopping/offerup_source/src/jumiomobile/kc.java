// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package jumiomobile:
//            kd

public class kc
{

    ArrayList a;
    public kd b;
    private int c;
    private int d;

    public kc(int i, int j)
    {
        c = 2;
        d = 3;
        c = i;
        d = j;
        b = kd.a;
        a = new ArrayList();
    }

    public void a()
    {
        b = kd.d;
    }

    public void a(kd kd1)
    {
        if (a.size() == d)
        {
            a.remove(0);
        }
        a.add(kd1);
        Iterator iterator = a.iterator();
        int i = 0;
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            kd kd2 = (kd)iterator.next();
            if (kd2 == kd1)
            {
                j++;
            } else
            if (kd2 == b)
            {
                i++;
            }
        } while (true);
        if (j >= c)
        {
            b = kd1;
        } else
        if (i < c)
        {
            b = kd.a;
            return;
        }
    }
}
