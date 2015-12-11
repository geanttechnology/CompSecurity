// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package jumiomobile:
//            bb, bc, bd, ab

public final class ba
{

    private static final Object g = new Object();
    private static ba h;
    private final Context a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private final ArrayList e = new ArrayList();
    private final Handler f;

    private ba(Context context)
    {
        a = context;
        f = new bb(this, context.getMainLooper());
    }

    public static ba a(Context context)
    {
        synchronized (g)
        {
            if (h == null)
            {
                h = new ba(context.getApplicationContext());
            }
            context = h;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void a()
    {
        jumiomobile/ba;
        JVM INSTR monitorenter ;
        ba ba1 = h;
        if (ba1 != null) goto _L2; else goto _L1
_L1:
        jumiomobile/ba;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (h.c != null)
        {
            h.c.clear();
        }
        if (h.d != null)
        {
            h.d.clear();
        }
        h = null;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void a(ba ba1)
    {
        ba1.b();
    }

    private void b()
    {
_L4:
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        int i = e.size();
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        bc abc[];
        abc = new bc[i];
        e.toArray(abc);
        e.clear();
        obj;
        JVM INSTR monitorexit ;
        i = 0;
_L2:
        if (i < abc.length)
        {
            obj = abc[i];
            for (int j = 0; j < ((bc) (obj)).b.size(); j++)
            {
                ((bd)((bc) (obj)).b.get(j)).b.onReceive(a, ((bc) (obj)).a);
            }

            break MISSING_BLOCK_LABEL_112;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
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
        if (((bd)arraylist1.get(i)).b != broadcastreceiver) goto _L10; else goto _L9
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
        ArrayList arraylist1;
        bd bd1;
        bd1 = new bd(intentfilter, broadcastreceiver);
        arraylist1 = (ArrayList)b.get(broadcastreceiver);
        ArrayList arraylist;
        arraylist = arraylist1;
        if (arraylist1 != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        arraylist = new ArrayList(1);
        b.put(broadcastreceiver, arraylist);
        arraylist.add(intentfilter);
        arraylist1 = new ArrayList();
        int i = 0;
_L2:
        String s;
        if (i >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        s = intentfilter.getAction(i);
        if (d.containsKey(s))
        {
            arraylist1.add(s);
        }
        arraylist = (ArrayList)c.get(s);
        broadcastreceiver = arraylist;
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        broadcastreceiver = new ArrayList(1);
        c.put(s, broadcastreceiver);
        broadcastreceiver.add(bd1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        for (broadcastreceiver = arraylist1.iterator(); broadcastreceiver.hasNext(); d.remove(intentfilter))
        {
            intentfilter = (String)broadcastreceiver.next();
            a((Intent)d.get(intentfilter));
        }

        break MISSING_BLOCK_LABEL_229;
        broadcastreceiver;
        hashmap;
        JVM INSTR monitorexit ;
        throw broadcastreceiver;
        hashmap;
        JVM INSTR monitorexit ;
    }

    public final boolean a(Intent intent)
    {
        return a(intent, false);
    }

    public final boolean a(Intent intent, boolean flag)
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
        Object obj;
        int i;
        ArrayList arraylist1;
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
            break MISSING_BLOCK_LABEL_105;
        }
        ab.d("LocalBroadcastManager", (new StringBuilder("Resolving type ")).append(s1).append(" scheme ").append(s2).append(" of intent ").append(intent).toString());
        arraylist1 = (ArrayList)c.get(intent.getAction());
        if (arraylist1 == null) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        ab.d("LocalBroadcastManager", (new StringBuilder("Action list: ")).append(arraylist1).toString());
          goto _L4
_L20:
        if (j >= arraylist1.size()) goto _L6; else goto _L5
_L5:
        obj = (bd)arraylist1.get(j);
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        ab.d("LocalBroadcastManager", (new StringBuilder("Matching against filter ")).append(((bd) (obj)).a).toString());
        if (!((bd) (obj)).c) goto _L8; else goto _L7
_L7:
        if (i == 0) goto _L10; else goto _L9
_L9:
        ab.d("LocalBroadcastManager", "  Filter's target already added");
          goto _L10
_L8:
        k = ((bd) (obj)).a.match(s, s1, s2, uri, set, "LocalBroadcastManager");
        if (k < 0) goto _L12; else goto _L11
_L11:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        ab.d("LocalBroadcastManager", (new StringBuilder("  Filter matched!  match=0x")).append(Integer.toHexString(k)).toString());
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        arraylist = new ArrayList();
        arraylist.add(obj);
        obj.c = true;
          goto _L10
        intent;
        hashmap;
        JVM INSTR monitorexit ;
        throw intent;
_L12:
        if (i == 0) goto _L10; else goto _L13
_L13:
        k;
        JVM INSTR tableswitch -4 -1: default 360
    //                   -4 519
    //                   -3 511
    //                   -2 527
    //                   -1 535;
           goto _L14 _L15 _L16 _L17 _L18
_L14:
        obj = "unknown reason";
_L21:
        ab.d("LocalBroadcastManager", (new StringBuilder("  Filter did not match: ")).append(((String) (obj))).toString());
          goto _L10
_L19:
        if (i >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_420;
        }
        ((bd)arraylist.get(i)).c = false;
        i++;
          goto _L19
        e.add(new bc(intent, arraylist));
        if (!f.hasMessages(1))
        {
            f.sendEmptyMessage(1);
        }
        hashmap;
        JVM INSTR monitorexit ;
        return true;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_477;
        }
        d.put(s, intent);
_L23:
        hashmap;
        JVM INSTR monitorexit ;
        return false;
_L4:
        arraylist = null;
        j = 0;
          goto _L20
_L10:
        j++;
          goto _L20
_L16:
        obj = "action";
          goto _L21
_L15:
        obj = "category";
          goto _L21
_L17:
        obj = "data";
          goto _L21
_L18:
        obj = "type";
          goto _L21
_L6:
        if (arraylist == null) goto _L23; else goto _L22
_L22:
        i = 0;
          goto _L19
    }

}
