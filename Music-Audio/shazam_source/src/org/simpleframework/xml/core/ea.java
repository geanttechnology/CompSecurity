// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            dd, dz

final class ea
{
    private static final class a
    {

        int a;
        private dz b;

        public final dz a()
        {
            if (a >= 0)
            {
                a = a + 1;
            }
            return b;
        }

        public a(boolean flag)
        {
            b = new dz(flag);
        }
    }


    private ThreadLocal a;

    public ea()
    {
        a = new ThreadLocal();
    }

    public final dz a(boolean flag)
    {
        a a1 = (a)a.get();
        if (a1 != null)
        {
            return a1.a();
        } else
        {
            a a2 = new a(flag);
            a.set(a2);
            return a2.a();
        }
    }

    public final void a()
    {
        a a1 = (a)a.get();
        if (a1 == null)
        {
            throw new dd("Session does not exist", new Object[0]);
        }
        int i = a1.a - 1;
        a1.a = i;
        if (i == 0)
        {
            a.remove();
        }
    }
}
