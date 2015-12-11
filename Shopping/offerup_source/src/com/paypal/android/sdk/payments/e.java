// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.paypal.android.sdk.payments:
//            f, g, h

class e
{

    private static final Object f = new Object();
    private static e g;
    private final Context a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final ArrayList d = new ArrayList();
    private final Handler e;

    private e(Context context)
    {
        a = context;
        e = new f(this, context.getMainLooper());
    }

    public static e a(Context context)
    {
        synchronized (f)
        {
            if (g == null)
            {
                g = new e(context.getApplicationContext());
            }
            context = g;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void a(e e1)
    {
_L4:
        Object obj = e1.b;
        obj;
        JVM INSTR monitorenter ;
        int i = e1.d.size();
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        g ag[];
        ag = new g[i];
        e1.d.toArray(ag);
        e1.d.clear();
        obj;
        JVM INSTR monitorexit ;
        i = 0;
_L2:
        if (i < ag.length)
        {
            obj = ag[i];
            for (int j = 0; j < ((g) (obj)).b.size(); j++)
            {
                ((h)((g) (obj)).b.get(j)).b.onReceive(e1.a, ((g) (obj)).a);
            }

            break MISSING_BLOCK_LABEL_112;
        }
        continue; /* Loop/switch isn't completed */
        e1;
        obj;
        JVM INSTR monitorexit ;
        throw e1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(BroadcastReceiver broadcastreceiver)
    {
        HashMap hashmap = b;
        hashmap;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)b.remove(broadcastreceiver);
        if (arraylist != null) goto _L2; else goto _L1
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return;
_L15:
        int j;
        if (j >= arraylist.size()) goto _L4; else goto _L3
_L3:
        IntentFilter intentfilter = (IntentFilter)arraylist.get(j);
        int k = 0;
_L13:
        String s;
        ArrayList arraylist1;
        if (k >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        s = intentfilter.getAction(k);
        arraylist1 = (ArrayList)c.get(s);
        if (arraylist1 == null) goto _L6; else goto _L5
_L5:
        int i = 0;
_L11:
        if (i >= arraylist1.size()) goto _L8; else goto _L7
_L7:
        if (((h)arraylist1.get(i)).b != broadcastreceiver) goto _L10; else goto _L9
_L9:
        arraylist1.remove(i);
        i--;
          goto _L10
_L8:
        if (arraylist1.size() <= 0)
        {
            c.remove(s);
        }
        break; /* Loop/switch isn't completed */
_L4:
        hashmap;
        JVM INSTR monitorexit ;
        return;
        broadcastreceiver;
        hashmap;
        JVM INSTR monitorexit ;
        throw broadcastreceiver;
_L2:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L10:
        i++;
        if (true) goto _L11; else goto _L6
_L6:
        k++;
        if (true) goto _L13; else goto _L12
_L12:
        j++;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public final void a(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        HashMap hashmap = b;
        hashmap;
        JVM INSTR monitorenter ;
        Object obj;
        h h1;
        h1 = new h(intentfilter, broadcastreceiver);
        obj = (ArrayList)b.get(broadcastreceiver);
        ArrayList arraylist;
        arraylist = ((ArrayList) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        arraylist = new ArrayList(1);
        b.put(broadcastreceiver, arraylist);
        arraylist.add(intentfilter);
        int i = 0;
_L2:
        if (i >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = intentfilter.getAction(i);
        arraylist = (ArrayList)c.get(obj);
        broadcastreceiver = arraylist;
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        broadcastreceiver = new ArrayList(1);
        c.put(obj, broadcastreceiver);
        broadcastreceiver.add(h1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return;
        broadcastreceiver;
        hashmap;
        JVM INSTR monitorexit ;
        throw broadcastreceiver;
    }

    public final boolean a(Intent intent)
    {
        HashMap hashmap = b;
        hashmap;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        android.net.Uri uri;
        String s2;
        java.util.Set set;
        s = intent.getAction();
        s1 = intent.resolveTypeIfNeeded(a.getContentResolver());
        uri = intent.getData();
        s2 = intent.getScheme();
        set = intent.getCategories();
        ArrayList arraylist;
        int i;
        ArrayList arraylist1;
        h h1;
        int j;
        int k;
        if ((intent.getFlags() & 8) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        (new StringBuilder("Resolving type ")).append(s1).append(" scheme ").append(s2).append(" of intent ").append(intent);
        arraylist1 = (ArrayList)c.get(intent.getAction());
        if (arraylist1 == null) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        (new StringBuilder("Action list: ")).append(arraylist1);
          goto _L4
_L16:
        if (j >= arraylist1.size()) goto _L6; else goto _L5
_L5:
        h1 = (h)arraylist1.get(j);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        (new StringBuilder("Matching against filter ")).append(h1.a);
        if (!h1.c) goto _L8; else goto _L7
_L7:
        if (i == 0);
          goto _L9
_L8:
        k = h1.a.match(s, s1, s2, uri, set, "ClonedLocalBroadcastManager");
        if (k < 0) goto _L11; else goto _L10
_L10:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        (new StringBuilder("  Filter matched!  match=0x")).append(Integer.toHexString(k));
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        arraylist = new ArrayList();
        arraylist.add(h1);
        h1.c = true;
          goto _L9
        intent;
        hashmap;
        JVM INSTR monitorexit ;
        throw intent;
_L11:
        if (i == 0) goto _L9; else goto _L12
_L12:
        k;
        JVM INSTR tableswitch -4 -1: default 320
    //                   -4 431
    //                   -3 428
    //                   -2 434
    //                   -1 437;
           goto _L9 _L9 _L9 _L9 _L9
_L15:
        if (i >= arraylist.size()) goto _L14; else goto _L13
_L13:
        ((h)arraylist.get(i)).c = false;
        i++;
          goto _L15
_L14:
        d.add(new g(intent, arraylist));
        if (!e.hasMessages(1))
        {
            e.sendEmptyMessage(1);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return true;
_L2:
        hashmap;
        JVM INSTR monitorexit ;
        return false;
_L4:
        arraylist = null;
        j = 0;
          goto _L16
_L9:
        j++;
          goto _L16
_L6:
        if (arraylist == null) goto _L2; else goto _L17
_L17:
        i = 0;
          goto _L15
    }

    static 
    {
        com/paypal/android/sdk/payments/e.getSimpleName();
    }
}
