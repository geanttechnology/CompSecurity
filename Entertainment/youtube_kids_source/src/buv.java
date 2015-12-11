// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class buv
{

    public amy a;
    public List b;
    public List c;

    buv(amy amy1)
    {
        try
        {
            a = (amy)eun.a(new amy(), eun.a(amy1));
        }
        catch (eum eum1)
        {
            a = new amy();
        }
        b = new ArrayList(Arrays.asList(amy1.c));
        c = new ArrayList(Arrays.asList(amy1.f));
    }

    public buv(buy buy1, String s)
    {
        a = new amy();
        a.d = ((buy)b.a(buy1)).d;
        a.b = b.a(s);
        a.h = 15;
        a.e = 2;
        b = new ArrayList();
        c = new ArrayList();
    }

    public final but a()
    {
        boolean flag = false;
        a.f = (String[])c.toArray(new String[0]);
        if (a.j.length <= 0)
        {
            buw buw1 = buw.a(a.e, b);
            a.c = new String[b.size()];
            List list = b;
            ArrayList arraylist;
            int i;
            int j;
            boolean flag1;
            if (list.size() == buw1.a.size())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            b.b(flag1);
            arraylist = new ArrayList();
            i = 0;
            do
            {
                j = ((flag) ? 1 : 0);
                if (i >= list.size())
                {
                    break;
                }
                arraylist.add(list.get(((Integer)buw1.a.get(i)).intValue()));
                i++;
            } while (true);
            for (; j < arraylist.size(); j++)
            {
                a.c[j] = (String)arraylist.get(j);
            }

            a.j = a.b(buw1.a);
        }
        but but1;
        try
        {
            but1 = new but((amy)eun.a(new amy(), eun.a(a)));
        }
        catch (eum eum1)
        {
            return null;
        }
        return but1;
    }
}
