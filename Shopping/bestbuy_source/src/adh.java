// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

public final class adh
    implements android.os.Handler.Callback
{

    private static final Object a = new Object();
    private static adh b;
    private final Context c;
    private final HashMap d = new HashMap();
    private final Handler e;

    private adh(Context context)
    {
        e = new Handler(context.getMainLooper(), this);
        c = context.getApplicationContext();
    }

    public static adh a(Context context)
    {
        synchronized (a)
        {
            if (b == null)
            {
                b = new adh(context.getApplicationContext());
            }
        }
        return b;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static HashMap a(adh adh1)
    {
        return adh1.d;
    }

    static Context b(adh adh1)
    {
        return adh1.c;
    }

    public boolean a(String s, adc adc1)
    {
        HashMap hashmap = d;
        hashmap;
        JVM INSTR monitorenter ;
        adi adi1 = (adi)d.get(s);
        if (adi1 != null) goto _L2; else goto _L1
_L1:
        adi1 = new adi(this, s);
        adi1.a(adc1);
        adi1.a();
        d.put(s, adi1);
        s = adi1;
_L7:
        boolean flag = s.d();
        hashmap;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        e.removeMessages(0, adi1);
        if (adi1.c(adc1))
        {
            throw new IllegalStateException((new StringBuilder()).append("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=").append(s).toString());
        }
        break MISSING_BLOCK_LABEL_118;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        adi1.a(adc1);
        adi1.e();
        JVM INSTR tableswitch 1 2: default 174
    //                   1 148
    //                   2 165;
           goto _L3 _L4 _L5
_L4:
        adc1.onServiceConnected(adi1.h(), adi1.g());
        s = adi1;
        continue; /* Loop/switch isn't completed */
_L5:
        adi1.a();
        s = adi1;
        continue; /* Loop/switch isn't completed */
_L3:
        s = adi1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void b(String s, adc adc1)
    {
        HashMap hashmap = d;
        hashmap;
        JVM INSTR monitorenter ;
        adi adi1 = (adi)d.get(s);
        if (adi1 != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        throw new IllegalStateException((new StringBuilder()).append("Nonexistent connection status for service action: ").append(s).toString());
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
        if (!adi1.c(adc1))
        {
            throw new IllegalStateException((new StringBuilder()).append("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=").append(s).toString());
        }
        adi1.b(adc1);
        if (adi1.f())
        {
            s = e.obtainMessage(0, adi1);
            e.sendMessageDelayed(s, 5000L);
        }
        hashmap;
        JVM INSTR monitorexit ;
    }

    public boolean handleMessage(Message message)
    {
        adi adi1;
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            adi1 = (adi)message.obj;
            break;
        }
        synchronized (d)
        {
            if (adi1.f())
            {
                adi1.b();
                d.remove(adi1.c());
            }
        }
        return true;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
