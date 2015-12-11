// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.Locale;

final class pj
    implements pq
{

    final ph a;

    pj(ph ph1)
    {
        a = ph1;
        super();
    }

    public final int a()
    {
        return ph.a(a).a() != -1F ? 20 : 0;
    }

    public final void a(bnf bnf)
    {
        bnf = b();
        if (bnf != null)
        {
            ph.b(a).b("bat", bnf);
        }
    }

    String b()
    {
        boolean flag = true;
        float f = ph.a(a).a();
        if (f != -1F)
        {
            Locale locale = Locale.US;
            String s = ph.c(a);
            int i;
            if (ph.a(a).b().getInt("plugged", 0) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            return String.format(locale, "%s:%.3f:%d", new Object[] {
                s, Float.valueOf(f), Integer.valueOf(i)
            });
        } else
        {
            return null;
        }
    }
}
