// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            aa, ab, ac, a, 
//            r, v, al, ag, 
//            an, am, at

public final class ah
    implements aa
{
    final class a extends ab
    {

        final ah a;

        final volatile aa d()
        {
            return a;
        }

        public a(Context context)
        {
            a = ah.this;
            super(context);
        }
    }


    public ab a;

    public ah(Context context)
    {
        a = new a(context.getApplicationContext());
        a.f = "i";
    }

    private int e()
    {
        ab ab1;
        r r1;
        ac.a(a);
        if (a.l == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        ab1 = a;
        r1 = com.millennialmedia.android.a.c(ab1.j(), ab1.k());
        if (r1 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (!r1.a(ab1.j(), ab1, true))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        an.a.c(ab1);
        com.millennialmedia.android.a.a(ab1.j(), ab1.k(), null);
        r1.a(ab1.j(), ab1.h);
        v.a(ab1.j()).a(ab1.j(), ab1.f);
        return 0;
        int i = ac.a(ab1, r1);
        return i;
        return 20;
        Exception exception;
        exception;
        al.a("MMInterstitial", "There was an exception displaying a cached ad. ", exception);
        exception.printStackTrace();
        return 100;
    }

    public final void a()
    {
        if (a != null && a.c != null)
        {
            a(a.b, a.c);
            return;
        } else
        {
            b();
            return;
        }
    }

    public final void a(am am, at at)
    {
        if (a != null)
        {
            a.b = am;
            a.c = at;
        }
        b();
    }

    public final void a(at at)
    {
        a.c = at;
    }

    public final void a(String s)
    {
        a.a(s);
    }

    public final void b()
    {
        if (c())
        {
            al.b();
            an.a.a(a, new ag(17));
            return;
        } else
        {
            al.b();
            a.g();
            return;
        }
    }

    public final boolean c()
    {
        if (an.a()) goto _L2; else goto _L1
_L1:
        al.a("MMInterstitial", ag.a(3));
_L4:
        return false;
_L2:
        ac.a(a);
        if (a.l == null) goto _L4; else goto _L3
_L3:
        ab ab1;
        r r1;
        ab1 = a;
        r1 = com.millennialmedia.android.a.c(ab1.j(), ab1.k());
        if (r1 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        int i;
        if (r1.a(ab1.j(), ab1, true))
        {
            i = 0;
        } else
        {
            try
            {
                i = ac.a(ab1, r1);
            }
            catch (Exception exception)
            {
                al.a("MMInterstitial", "There was an exception checking for a cached ad. ", exception);
                exception.printStackTrace();
                return false;
            }
        }
        continue; /* Loop/switch isn't completed */
        al.c();
        i = 20;
        if (i != 0) goto _L4; else goto _L5
_L5:
        return true;
    }

    public final boolean d()
    {
        if (!an.a())
        {
            al.a("MMInterstitial", ag.a(3));
        } else
        {
            int i;
            try
            {
                i = e();
            }
            catch (Exception exception)
            {
                return false;
            }
            if (i == 0)
            {
                return true;
            }
        }
        return false;
    }
}
