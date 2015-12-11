// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;

// Referenced classes of package android.support.v7:
//            kx, la, kz, abo

public class adl
{
    static class a
        implements kz
    {

        private static int b(int i)
        {
            switch (i)
            {
            case 6: // '\006'
            default:
                return 3;

            case 5: // '\005'
                return 2;

            case 3: // '\003'
            case 4: // '\004'
                return 1;

            case 2: // '\002'
                return 0;
            }
        }

        public int a()
        {
            return b(abo.a());
        }

        public void a(int i)
        {
            abo.b("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void a(String s)
        {
            abo.b(s);
        }

        public void b(String s)
        {
            abo.a(s);
        }

        a()
        {
        }
    }


    private kx a;
    private Context b;
    private la c;

    public adl(Context context)
    {
        b = context;
    }

    private void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = kx.a(b);
            a.a(new a());
            c = a.a(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public la a(String s)
    {
        b(s);
        return c;
    }
}
