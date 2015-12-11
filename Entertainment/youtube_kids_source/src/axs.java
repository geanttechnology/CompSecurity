// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;

public final class axs
    implements android.os.Handler.Callback
{

    private static final Object a = new Object();
    private static axs b;
    private final Context c;
    private final HashMap d = new HashMap();
    private final Handler e;

    private axs(Context context)
    {
        e = new Handler(context.getMainLooper(), this);
        c = context.getApplicationContext();
    }

    public static axs a(Context context)
    {
        synchronized (a)
        {
            if (b == null)
            {
                b = new axs(context.getApplicationContext());
            }
        }
        return b;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static HashMap a(axs axs1)
    {
        return axs1.d;
    }

    public final boolean a(String s, axn axn1)
    {
        HashMap hashmap = d;
        hashmap;
        JVM INSTR monitorenter ;
        axt axt1 = (axt)d.get(s);
        if (axt1 != null) goto _L2; else goto _L1
_L1:
        axt1 = new axt(this, s);
        axt1.a(axn1);
        axn1 = (new Intent(s)).setPackage("com.google.android.gms");
        axt1.e = c.bindService(axn1, axt1.b, 129);
        d.put(s, axt1);
        s = axt1;
_L7:
        boolean flag = ((axt) (s)).e;
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        e.removeMessages(0, axt1);
        if (axt1.b(axn1))
        {
            throw new IllegalStateException((new StringBuilder("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=")).append(s).toString());
        }
        break MISSING_BLOCK_LABEL_144;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        axt1.a(axn1);
        axt1.d;
        JVM INSTR tableswitch 1 2: default 231
    //                   1 176
    //                   2 193;
           goto _L3 _L4 _L5
_L4:
        axn1.onServiceConnected(axt1.g, axt1.f);
        s = axt1;
        continue; /* Loop/switch isn't completed */
_L5:
        s = (new Intent(s)).setPackage("com.google.android.gms");
        axt1.e = c.bindService(s, axt1.b, 129);
        s = axt1;
        continue; /* Loop/switch isn't completed */
_L3:
        s = axt1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void b(String s, axn axn1)
    {
        HashMap hashmap = d;
        hashmap;
        JVM INSTR monitorenter ;
        axt axt1 = (axt)d.get(s);
        if (axt1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        throw new IllegalStateException((new StringBuilder("Nonexistent connection status for service action: ")).append(s).toString());
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        if (!axt1.b(axn1))
        {
            throw new IllegalStateException((new StringBuilder("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=")).append(s).toString());
        }
        axt1.c.remove(axn1);
        if (axt1.c.isEmpty())
        {
            s = e.obtainMessage(0, axt1);
            e.sendMessageDelayed(s, 5000L);
        }
        hashmap;
        JVM INSTR monitorexit ;
    }

    public final boolean handleMessage(Message message)
    {
        axt axt1;
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            axt1 = (axt)message.obj;
            break;
        }
        synchronized (d)
        {
            if (axt1.c.isEmpty())
            {
                c.unbindService(axt1.b);
                d.remove(axt1.a);
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
