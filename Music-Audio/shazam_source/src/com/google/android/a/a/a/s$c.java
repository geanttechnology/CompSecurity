// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.a.a.b;
import java.util.ArrayList;

// Referenced classes of package com.google.android.a.a.a:
//            s, b

protected final class d extends d
{

    public final b c;
    public final IBinder d;
    final s e;

    protected final void a(Object obj)
    {
        boolean flag1;
label0:
        {
            flag1 = true;
            if ((Boolean)obj != null)
            {
                switch (a[c.ordinal()])
                {
                default:
                    e.i();
                    break;

                case 1: // '\001'
                    break label0;
                }
            }
            return;
        }
        obj = d.getInterfaceDescriptor();
        if (!e.b().equals(obj)) goto _L2; else goto _L1
_L1:
        e.b = e.a(d);
        if (e.b == null) goto _L2; else goto _L3
_L3:
        s s1 = e;
        obj = s1.c;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        ArrayList arraylist;
        int i;
        int j;
        boolean flag;
        if (!s1.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        s1.a.removeMessages(4);
        s1.e = true;
        if (s1.d.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.a(flag);
        arraylist = s1.c;
        j = arraylist.size();
        i = 0;
_L9:
        if (i >= j) goto _L5; else goto _L4
_L4:
        if (!s1.g || !s1.f()) goto _L5; else goto _L6
_L6:
        if (!s1.d.contains(arraylist.get(i)))
        {
            ((ages)arraylist.get(i)).a();
        }
          goto _L7
_L5:
        s1.d.clear();
        s1.e = false;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L2:
        e.g();
        obj = e;
        b b1 = b.b;
        ((s) (obj)).i();
        return;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public (s s1, String s2, IBinder ibinder)
    {
        e = s1;
        super(s1, Boolean.valueOf(true));
        c = s.a(s2);
        d = ibinder;
    }
}
