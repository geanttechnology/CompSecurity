// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;


// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AdapterView

class p
    implements Runnable
{

    final PLA_AdapterView a;

    private p(PLA_AdapterView pla_adapterview)
    {
        a = pla_adapterview;
        super();
    }

    p(PLA_AdapterView pla_adapterview, PLA_AdapterView._cls1 _pcls1)
    {
        this(pla_adapterview);
    }

    public void run()
    {
        if (a.Q)
        {
            if (a.getAdapter() != null)
            {
                a.post(this);
            }
            return;
        } else
        {
            PLA_AdapterView.b(a);
            PLA_AdapterView.c(a);
            return;
        }
    }
}
