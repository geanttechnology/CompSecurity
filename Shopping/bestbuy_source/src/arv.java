// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class arv extends aru
{

    private static final Object a = new Object();
    private static arv k;
    private aqs b;
    private volatile aqr c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private aqt i;
    private boolean j;

    private arv()
    {
        d = 0x1b7740;
        e = true;
        f = false;
        g = true;
        h = true;
        i = new aqt() {

            final arv a;

            
            {
                a = arv.this;
                super();
            }
        };
        j = false;
    }

    static aqs a(arv arv1)
    {
        return arv1.b;
    }

    public static arv b()
    {
        if (k == null)
        {
            k = new arv();
        }
        return k;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (f) goto _L2; else goto _L1
_L1:
        aqv.d("Dispatch call queued. Dispatch will run once initialization is complete.");
        e = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        c.a(new Runnable() {

            final arv a;

            public void run()
            {
                arv.a(a).a();
            }

            
            {
                a = arv.this;
                super();
            }
        });
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
