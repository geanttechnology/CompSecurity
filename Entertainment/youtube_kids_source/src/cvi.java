// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class cvi
    implements bxr
{

    public boolean a;
    public boolean b;
    private final Context c;

    public cvi(Context context)
    {
        c = context;
    }

    public static cse a(bss bss1)
    {
        csf csf1;
        int i;
        i = bss1.b;
        csf1 = csf.a;
        if (i != 1) goto _L2; else goto _L1
_L1:
        csf1 = csf.b;
_L4:
        return new cse(csf1, false, bss1.a.b);
_L2:
        if (i == 2)
        {
            csf1 = csf.c;
        } else
        if (bss1.b())
        {
            csf1 = csf.e;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(bss bss1, cvj cvj1, csg csg1)
    {
        if (bss1 == null)
        {
            cvj1.a(new cse(csf.a, false, null));
            return;
        }
        if (bss1.a())
        {
            csg1 = csg1.a;
            if (!bss1.c && (csg1 == ctr.e || csg1 == ctr.d))
            {
                cvj1.a(new cse(csf.k, false, c.getString(0x7f0b00b7)));
                return;
            } else
            {
                cvj1.a();
                return;
            }
        }
        if (bss1.b())
        {
            cvj1.a(a(bss1));
            return;
        } else
        {
            cvj1.a(a(bss1));
            return;
        }
    }

    public final void a(bxu bxu1)
    {
        bxu1.k = a;
        bxu1.j = b;
    }
}
