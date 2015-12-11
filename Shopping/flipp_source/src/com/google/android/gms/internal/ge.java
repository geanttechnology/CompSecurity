// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.a;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.d;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            gf, gg

public final class ge
{

    final gg a;
    ArrayList b;
    final ArrayList c = new ArrayList();
    boolean d;
    ArrayList e;
    final Handler f;
    boolean g;

    ge(gg gg1)
    {
        d = false;
        g = false;
        gf gf1 = new gf(this, Looper.getMainLooper());
        b = new ArrayList();
        e = new ArrayList();
        a = gg1;
        f = gf1;
    }

    public final void a()
    {
        f.removeMessages(1);
        ArrayList arraylist = b;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int j;
        d = true;
        arraylist1 = b;
        j = arraylist1.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (a.j())
        {
            if (b.contains(arraylist1.get(i)))
            {
                ((b)arraylist1.get(i)).b();
            }
            break MISSING_BLOCK_LABEL_95;
        }
        d = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(a a1)
    {
        f.removeMessages(1);
        ArrayList arraylist = e;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1;
        int j;
        g = true;
        arraylist1 = e;
        j = arraylist1.size();
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (a.j())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        if (e.contains(arraylist1.get(i)))
        {
            ((d)arraylist1.get(i)).a(a1);
        }
        break MISSING_BLOCK_LABEL_103;
        g = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
        a1;
        arraylist;
        JVM INSTR monitorexit ;
        throw a1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
