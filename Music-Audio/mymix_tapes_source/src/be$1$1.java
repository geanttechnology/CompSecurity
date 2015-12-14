// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ng.Object
    implements Runnable
{

    private a a;

    public final void run()
    {
        a.a.b();
    }

    ct(ct ct)
    {
        a = ct;
        super();
    }

    // Unreferenced inner class be$1

/* anonymous class */
    final class be._cls1
        implements cx
    {

        final be a;
        private cx b;

        public final void a(byte abyte0[], int i, int j, boolean flag)
            throws dc
        {
            if (be.a(a) != null) goto _L2; else goto _L1
_L1:
            b.a(abyte0, i, j, flag);
_L4:
            abyte0 = a;
            be.c();
            return;
_L2:
            if (be.a(a).a())
            {
                abyte0 = (byte[])(byte[])be.a(a).b();
                if (!be.a(a).a())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                b.a(abyte0, 0, abyte0.length, flag);
                if (flag)
                {
                    ax.a(new be._cls1._cls1(this));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                a = be1;
                b = cx1;
                super();
            }
    }

}
