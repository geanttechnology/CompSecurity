// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.a;
import com.google.android.gms.common.api.b;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            fy, fw, gi, ge, 
//            ha, gg

public final class gd extends fy
{

    public final int b;
    public final Bundle c;
    public final IBinder d;
    final fw e;

    public gd(fw fw1, int i, IBinder ibinder, Bundle bundle)
    {
        e = fw1;
        super(fw1, Boolean.valueOf(true));
        b = i;
        d = ibinder;
        c = bundle;
    }

    protected final void a(Object obj)
    {
        boolean flag1 = true;
        if ((Boolean)obj == null) goto _L2; else goto _L1
_L1:
        b;
        JVM INSTR lookupswitch 2: default 40
    //                   0: 137
    //                   10: 442;
           goto _L3 _L4 _L5
_L3:
        int i;
        boolean flag;
        Object obj1;
        ge ge1;
        Exception exception;
        ArrayList arraylist;
        int j;
        if (c != null)
        {
            obj = (PendingIntent)c.getParcelable("pendingIntent");
        } else
        {
            obj = null;
        }
        if (fw.e(e) != null)
        {
            com.google.android.gms.internal.gi.a(fw.f(e)).b(e.a(), fw.e(e));
            fw.g(e);
        }
        com.google.android.gms.internal.fw.a(e, null);
        com.google.android.gms.internal.fw.a(e).a(new a(b, ((PendingIntent) (obj))));
_L2:
        return;
_L4:
        obj = d.getInterfaceDescriptor();
        if (!e.b().equals(obj)) goto _L7; else goto _L6
_L6:
        com.google.android.gms.internal.fw.a(e, e.a(d));
        if (fw.d(e) == null) goto _L7; else goto _L8
_L8:
        ge1 = com.google.android.gms.internal.fw.a(e);
        obj = ge1.b;
        obj;
        JVM INSTR monitorenter ;
        obj1 = ge1.b;
        obj1;
        JVM INSTR monitorenter ;
        if (!ge1.d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.internal.ha.a(flag);
        ge1.f.removeMessages(1);
        ge1.d = true;
        if (ge1.c.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        com.google.android.gms.internal.ha.a(flag);
        arraylist = ge1.b;
        j = arraylist.size();
        i = 0;
_L14:
        if (i >= j) goto _L10; else goto _L9
_L9:
        if (!ge1.a.j() || !ge1.a.e()) goto _L10; else goto _L11
_L11:
        ge1.c.size();
        if (!ge1.c.contains(arraylist.get(i)))
        {
            ((b)arraylist.get(i)).a();
        }
          goto _L12
_L10:
        ge1.c.clear();
        ge1.d = false;
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
_L7:
        com.google.android.gms.internal.gi.a(fw.f(e)).b(e.a(), fw.e(e));
        fw.g(e);
        com.google.android.gms.internal.fw.a(e, null);
        com.google.android.gms.internal.fw.a(e).a(new a(8, null));
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
_L5:
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
_L12:
        i++;
        if (true) goto _L14; else goto _L13
_L13:
    }
}
