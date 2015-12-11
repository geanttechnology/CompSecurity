// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;

// Referenced classes of package android.support.v7:
//            wz, aag, wx

class a
    implements h
{

    final wz a;

    public void a(aag aag1)
    {
        if (aag1.a().f())
        {
            aag1 = aag1.c();
        } else
        {
            aag1 = null;
        }
        aag1 = new wx(wz.a(a), aag1, a.a());
        wz.a(a, aag1.a());
        wz.b(a);
    }

    public void a(g g)
    {
        a((aag)g);
    }

    ommon.api.g(wz wz1)
    {
        a = wz1;
        super();
    }
}
