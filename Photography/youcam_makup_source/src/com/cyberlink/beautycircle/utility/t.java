// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;


// Referenced classes of package com.cyberlink.beautycircle.utility:
//            v, u

public abstract class t
{

    public static final v a;
    public static final v b;
    public static final v c;
    public static final v d;
    public static final v e;
    public static final v f;
    public static final v g;
    public static final v h;
    public static final v i[];

    public static boolean a(u u)
    {
        boolean flag1 = false;
        v av[] = i;
        int k = av.length;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < k)
                {
                    if (!av[j].b(u))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    static 
    {
        a = new v();
        b = new v();
        c = new v();
        d = new v();
        e = new v();
        f = new v();
        g = new v();
        h = new v();
        i = (new v[] {
            a, b, c, d, e, f, g, h
        });
    }
}
