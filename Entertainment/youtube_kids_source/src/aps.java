// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public class aps
    implements apr
{

    private final arp a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final float f;

    public aps(arp arp1, int i, int j, int k, int l, float f1)
    {
        a = arp1;
        b = i;
        c = (long)j * 1000L;
        d = (long)k * 1000L;
        e = (long)l * 1000L;
        f = f1;
    }

    public long a(long l)
    {
        if (l == -1L)
        {
            return (long)b;
        } else
        {
            return (long)((float)l * f);
        }
    }

    public app a(app aapp[], long l)
    {
        l = a(l);
        for (int i = 0; i < aapp.length; i++)
        {
            app app1 = aapp[i];
            if ((long)app1.e <= l)
            {
                return app1;
            }
        }

        return aapp[aapp.length - 1];
    }

    public void a(List list, long l, app aapp[], apt apt1)
    {
        app app1;
        boolean flag1;
        long l1;
        boolean flag2 = false;
        boolean flag;
        if (list.isEmpty())
        {
            l1 = 0L;
        } else
        {
            l1 = ((apv)list.get(list.size() - 1)).g - l;
        }
        app1 = apt1.c;
        aapp = a(aapp, a.a());
        if (aapp != null && app1 != null && ((app) (aapp)).e > app1.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (aapp != null)
        {
            flag1 = flag2;
            if (app1 != null)
            {
                flag1 = flag2;
                if (((app) (aapp)).e < app1.e)
                {
                    flag1 = true;
                }
            }
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (l1 >= c) goto _L4; else goto _L3
_L3:
        list = app1;
_L7:
        if (app1 != null && list != app1)
        {
            apt1.b = 2;
        }
        apt1.c = list;
        return;
_L4:
        if (l1 >= e)
        {
            int i = 1;
            do
            {
                if (i >= list.size())
                {
                    break;
                }
                apv apv1 = (apv)list.get(i);
                if (apv1.f - l >= e && apv1.a.e < ((app) (aapp)).e && apv1.a.d < ((app) (aapp)).d && apv1.a.d < 720 && apv1.a.c < 1280)
                {
                    apt1.a = i;
                    list = aapp;
                    continue; /* Loop/switch isn't completed */
                }
                i++;
            } while (true);
            list = aapp;
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L2:
        if (flag1 && app1 != null && l1 >= d)
        {
            list = app1;
            continue; /* Loop/switch isn't completed */
        }
_L5:
        list = aapp;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
