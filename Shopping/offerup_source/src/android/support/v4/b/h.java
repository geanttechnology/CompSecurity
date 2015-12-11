// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package android.support.v4.b:
//            i, j, k

public final class h
{

    private static final Object f = new Object();
    private static h g;
    private final Context a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final ArrayList d = new ArrayList();
    private final Handler e;

    private h(Context context)
    {
        a = context;
        e = new i(this, context.getMainLooper());
    }

    public static h a(Context context)
    {
        synchronized (f)
        {
            if (g == null)
            {
                g = new h(context.getApplicationContext());
            }
            context = g;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void a(h h1)
    {
_L4:
        Object obj = h1.b;
        obj;
        JVM INSTR monitorenter ;
        int l = h1.d.size();
        if (l > 0)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        j aj[];
        aj = new j[l];
        h1.d.toArray(aj);
        h1.d.clear();
        obj;
        JVM INSTR monitorexit ;
        l = 0;
_L2:
        if (l < aj.length)
        {
            obj = aj[l];
            for (int i1 = 0; i1 < ((j) (obj)).b.size(); i1++)
            {
                ((k)((j) (obj)).b.get(i1)).b.onReceive(h1.a, ((j) (obj)).a);
            }

            break MISSING_BLOCK_LABEL_112;
        }
        continue; /* Loop/switch isn't completed */
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
        l++;
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
        int i1;
        if (i1 >= arraylist.size()) goto _L4; else goto _L3
_L3:
        IntentFilter intentfilter = (IntentFilter)arraylist.get(i1);
        int j1 = 0;
_L13:
        String s;
        ArrayList arraylist1;
        if (j1 >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        s = intentfilter.getAction(j1);
        arraylist1 = (ArrayList)c.get(s);
        if (arraylist1 == null) goto _L6; else goto _L5
_L5:
        int l = 0;
_L11:
        if (l >= arraylist1.size()) goto _L8; else goto _L7
_L7:
        if (((k)arraylist1.get(l)).b != broadcastreceiver) goto _L10; else goto _L9
_L9:
        arraylist1.remove(l);
        l--;
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
        i1 = 0;
        continue; /* Loop/switch isn't completed */
_L10:
        l++;
        if (true) goto _L11; else goto _L6
_L6:
        j1++;
        if (true) goto _L13; else goto _L12
_L12:
        i1++;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public final void a(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        HashMap hashmap = b;
        hashmap;
        JVM INSTR monitorenter ;
        Object obj;
        k k1;
        k1 = new k(intentfilter, broadcastreceiver);
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
        int l = 0;
_L2:
        if (l >= intentfilter.countActions())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = intentfilter.getAction(l);
        arraylist = (ArrayList)c.get(obj);
        broadcastreceiver = arraylist;
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        broadcastreceiver = new ArrayList(1);
        c.put(obj, broadcastreceiver);
        broadcastreceiver.add(k1);
        l++;
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
        Object obj;
        int l;
        ArrayList arraylist1;
        int i1;
        int j1;
        if ((intent.getFlags() & 8) != 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (l == 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder("Resolving type ")).append(s1).append(" scheme ").append(s2).append(" of intent ").append(intent).toString());
        arraylist1 = (ArrayList)c.get(intent.getAction());
        if (arraylist1 == null) goto _L2; else goto _L1
_L1:
        if (l == 0) goto _L4; else goto _L3
_L3:
        Log.v("LocalBroadcastManager", (new StringBuilder("Action list: ")).append(arraylist1).toString());
          goto _L4
_L20:
        if (i1 >= arraylist1.size()) goto _L6; else goto _L5
_L5:
        obj = (k)arraylist1.get(i1);
        if (l == 0)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder("Matching against filter ")).append(((k) (obj)).a).toString());
        if (!((k) (obj)).c) goto _L8; else goto _L7
_L7:
        if (l == 0) goto _L10; else goto _L9
_L9:
        Log.v("LocalBroadcastManager", "  Filter's target already added");
          goto _L10
_L8:
        j1 = ((k) (obj)).a.match(s, s1, s2, uri, set, "LocalBroadcastManager");
        if (j1 < 0) goto _L12; else goto _L11
_L11:
        if (l == 0)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        Log.v("LocalBroadcastManager", (new StringBuilder("  Filter matched!  match=0x")).append(Integer.toHexString(j1)).toString());
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_301;
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
        if (l == 0) goto _L10; else goto _L13
_L13:
        j1;
        JVM INSTR tableswitch -4 -1: default 360
    //                   -4 501
    //                   -3 495
    //                   -2 507
    //                   -1 513;
           goto _L14 _L15 _L16 _L17 _L18
_L14:
        obj = "unknown reason";
_L21:
        Log.v("LocalBroadcastManager", (new StringBuilder("  Filter did not match: ")).append(((String) (obj))).toString());
          goto _L10
_L19:
        if (l >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_419;
        }
        ((k)arraylist.get(l)).c = false;
        l++;
          goto _L19
        d.add(new j(intent, arraylist));
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
        i1 = 0;
          goto _L20
_L10:
        i1++;
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
        if (arraylist == null) goto _L2; else goto _L22
_L22:
        l = 0;
          goto _L19
    }

}
