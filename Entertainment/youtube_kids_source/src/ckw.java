// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

public final class ckw
    implements ckl
{

    private final ckl a;
    private boolean b;

    public ckw(ckl ckl1)
    {
        a = (ckl)b.a(ckl1);
    }

    public final void a()
    {
        a.a();
        b = false;
    }

    public final void a(int i)
    {
        if (b)
        {
            switch (i)
            {
            case 3: // '\003'
            case 4: // '\004'
            default:
                return;

            case 2: // '\002'
                b = false;
                return;

            case 5: // '\005'
            case 6: // '\006'
                break;
            }
        }
        a.a(i);
    }

    public final void a(Handler handler)
    {
        a.a(handler);
    }

    public final void a(Message message)
    {
        a.a(message);
    }

    public final void a(bwb bwb, bwb bwb1, bwb bwb2, bwv abwv[], String as[], int i)
    {
        a.a(bwb, bwb1, bwb2, abwv, as, i);
    }

    public final void a(cia cia)
    {
        if (b)
        {
            return;
        } else
        {
            a.a(cia);
            return;
        }
    }

    public final void a(cnd cnd)
    {
        a.a(cnd);
    }

    public final void a(boolean flag)
    {
        a.a(flag);
    }

    public final void b()
    {
        a.b();
        b = true;
    }

    public final void b(int i)
    {
        if (b)
        {
            return;
        } else
        {
            a.b(i);
            return;
        }
    }

    public final void c(int i)
    {
        if (b)
        {
            return;
        } else
        {
            a.c(i);
            return;
        }
    }

    public final void d(int i)
    {
        a.d(i);
    }

    public final void e(int i)
    {
        a.e(i);
    }
}
