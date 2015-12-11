// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            az, ax, aw

public final class ay
{

    private final aw a;

    public ay(aw aw1)
    {
        a = aw1;
    }

    public final void a(int ai[], int i)
        throws az
    {
        Object aobj[];
        boolean flag;
        boolean flag1;
        ax ax1 = new ax(a, ai);
        aobj = new int[i];
        flag1 = a.equals(aw.f);
        flag = true;
        int j = 0;
        while (j < i) 
        {
            aw aw1 = a;
            int i2;
            if (flag1)
            {
                i2 = j + 1;
            } else
            {
                i2 = j;
            }
            i2 = ax1.b(aw1.a(i2));
            aobj[aobj.length - 1 - j] = i2;
            if (i2 != 0)
            {
                flag = false;
            }
            j++;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1 = new ax(a, ((int []) (aobj)));
        Object obj2 = a.a(i, 1);
        Object obj;
        Object obj3;
        ax ax2;
        ax ax3;
        ax ax4;
        ax ax5;
        int k2;
        int l2;
        if (((ax) (obj2)).a() < ((ax) (obj1)).a())
        {
            obj = obj1;
            obj1 = obj2;
        } else
        {
            obj = obj2;
        }
        ax3 = a.b();
        ax5 = a.a();
        ax2 = a.a();
        ax4 = a.b();
        obj2 = obj;
        obj3 = obj1;
        obj = ax5;
        obj1 = ax4;
        Object obj4;
        for (; ((ax) (obj3)).a() >= i / 2; obj3 = obj4)
        {
            if (((ax) (obj3)).b())
            {
                throw new az("r_{i-1} was zero");
            }
            obj4 = a.a();
            int k = ((ax) (obj3)).a(((ax) (obj3)).a());
            k = a.c(k);
            int j1;
            int j2;
            for (; ((ax) (obj2)).a() >= ((ax) (obj3)).a() && !((ax) (obj2)).b(); obj2 = ((ax) (obj2)).a(((ax) (obj3)).a(j1, j2)))
            {
                j1 = ((ax) (obj2)).a() - ((ax) (obj3)).a();
                j2 = a.c(((ax) (obj2)).a(((ax) (obj2)).a()), k);
                obj4 = ((ax) (obj4)).a(a.a(j1, j2));
            }

            ax ax6 = ((ax) (obj4)).b(((ax) (obj))).a(ax3);
            ax3 = ((ax) (obj4)).b(((ax) (obj1))).a(ax2);
            ax2 = ((ax) (obj1));
            obj1 = ax3;
            ax3 = ((ax) (obj));
            obj = ax6;
            obj4 = obj2;
            obj2 = obj3;
        }

        i = ((ax) (obj1)).a(0);
        if (i == 0)
        {
            throw new az("sigmaTilde(0) was zero");
        }
        i = a.c(i);
        obj = ((ax) (obj1)).c(i);
        obj2 = ((ax) (obj3)).c(i);
        obj1 = new ax[2];
        obj1[0] = ((ax) (obj));
        obj1[1] = ((ax) (obj2));
        obj2 = obj1[0];
        obj1 = obj1[1];
        k2 = ((ax) (obj2)).a();
        if (k2 == 1)
        {
            obj = new int[1];
            obj[0] = ((ax) (obj2)).a(1);
        } else
        {
            obj = new int[k2];
            l = 0;
            int l1;
            for (i = 1; i < a.c() && l < k2; l = l1)
            {
                l1 = l;
                if (((ax) (obj2)).b(i) == 0)
                {
                    obj[l] = a.c(i);
                    l1 = l + 1;
                }
                i++;
            }

            if (l != k2)
            {
                throw new az("Error locator degree does not match number of roots");
            }
        }
        l2 = obj.length;
        obj2 = new int[l2];
        for (int l = 0; l < l2; l++)
        {
            int i3 = a.c(obj[l]);
            i = 1;
            int k1 = 0;
            while (k1 < l2) 
            {
                if (l != k1)
                {
                    k2 = a.c(obj[k1], i3);
                    if ((k2 & 1) == 0)
                    {
                        k2 |= 1;
                    } else
                    {
                        k2 &= -2;
                    }
                    i = a.c(i, k2);
                }
                k1++;
            }
            obj2[l] = a.c(((ax) (obj1)).b(i3), a.c(i));
            if (flag1)
            {
                obj2[l] = a.c(obj2[l], i3);
            }
        }

        i = 0;
        while (i < obj.length) 
        {
            int i1 = ai.length - 1 - a.b(obj[i]);
            if (i1 < 0)
            {
                throw new az("Bad error location");
            }
            ai[i1] = aw.b(ai[i1], obj2[i]);
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
