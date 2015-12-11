// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.service.PushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            v, w, u, x, 
//            t, s

public class JRecorder
{

    private static ExecutorService a;
    private static Context c;
    private static Handler d;
    private static ArrayList e;
    private static volatile boolean f;
    private static final String z[];
    private ArrayList b;

    private JRecorder()
    {
        if (d == null)
        {
            d = new Handler(Looper.getMainLooper());
        }
    }

    private JRecorder(int i, Context context)
    {
        this();
        c = context.getApplicationContext();
        b = new ArrayList();
        context = new v(this, (byte)0);
        context.a = i;
        context.b = b;
        e.add(context);
    }

    static Context a()
    {
        return c;
    }

    private static JSONObject a(ArrayList arraylist)
    {
        int k;
        if (arraylist != null)
        {
            if ((k = arraylist.size()) > 0)
            {
                JSONObject jsonobject = new JSONObject();
                long l = ((w)arraylist.get(k - 1)).a;
                long l1 = ((w)arraylist.get(0)).a;
                int i = 0;
                int j = 0;
                for (; i < k; i++)
                {
                    j = (int)((double)j + ((w)arraylist.get(i)).b);
                }

                jsonobject.put(z[4], z[6]);
                jsonobject.put(z[5], l - l1);
                jsonobject.put(z[3], (double)j - ((w)arraylist.get(0)).b);
                return jsonobject;
            }
        }
        return null;
    }

    static void a(Context context)
    {
        if (e == null || e.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_327;
        }
          goto _L1
_L9:
        JSONArray jsonarray;
        Iterator iterator;
        ArrayList arraylist;
        int i;
        long l;
        long l1;
        if (context != null)
        {
            try
            {
                if (context.length() > 0)
                {
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put(z[11], z[10]);
                    jsonobject.put(z[7], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
                    jsonobject.put(z[9], context);
                    a.execute(new u(jsonobject));
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_332;
_L1:
        jsonarray = new JSONArray();
        iterator = e.iterator();
_L4:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        context = (v)iterator.next();
        if (((v) (context)).a != 0) goto _L3; else goto _L2
_L2:
        jsonarray.put(a(((v) (context)).b));
          goto _L4
_L3:
        if (((v) (context)).a != 1) goto _L4; else goto _L5
_L5:
        arraylist = ((v) (context)).b;
        if (arraylist != null) goto _L7; else goto _L6
_L6:
        context = null;
_L8:
        jsonarray.put(context);
          goto _L4
_L7:
        i = arraylist.size();
label0:
        {
            if (i > 0)
            {
                break label0;
            }
            context = null;
        }
          goto _L8
        l = ((w)arraylist.get(i - 1)).a;
        l1 = ((w)arraylist.get(0)).a;
        context = new JSONObject();
        context.put(z[4], z[8]);
        context.put(z[5], l - l1);
        context.put(z[3], ((w)arraylist.get(i - 1)).b - ((w)arraylist.get(0)).b);
          goto _L8
        b();
        context = jsonarray;
          goto _L9
        context = null;
          goto _L9
    }

    static void a(JRecorder jrecorder, double d1)
    {
        synchronized (jrecorder.b)
        {
            w w1 = new w(jrecorder, (byte)0);
            w1.b = d1;
            w1.a = System.currentTimeMillis();
            jrecorder.b.add(w1);
        }
    }

    static boolean a(boolean flag)
    {
        f = false;
        return false;
    }

    private static void b()
    {
        for (Iterator iterator = e.iterator(); iterator.hasNext(); ((v)iterator.next()).b.clear()) { }
        e.clear();
    }

    public static JRecorder getIncreamentsRecorder(Context context)
    {
        return new JRecorder(0, context);
    }

    public static JRecorder getSuperpositionRecorder(Context context)
    {
        return new JRecorder(1, context);
    }

    public static void parseRecordCommand(String s1)
    {
        if (f)
        {
            x.c();
            return;
        }
        try
        {
            int i = (new JSONObject(s1)).getInt(z[0]);
            f = true;
            (new StringBuilder(z[1])).append(i).append("s").toString();
            x.c();
            if (d == null)
            {
                d = new Handler(Looper.getMainLooper());
            }
            d.postDelayed(new t(), i * 1000);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            f = false;
        }
        (new StringBuilder(z[2])).append(s1.getMessage()).toString();
        x.c();
    }

    public void record(int i)
    {
        if (!f)
        {
            x.c();
            return;
        } else
        {
            a.execute(new s(this, i));
            return;
        }
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[12];
        i = 0;
        obj1 = "k\020\b\nV}\005\016\027Mv\021";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 518
    //                   1 525
    //                   2 532
    //                   3 539;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_539;
_L3:
        byte0 = 36;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "k\020\033\nVmU\016\013E{\031\016\001\004#";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "k\020\033\nVmU\017\fWx\027\007\000@9\027\022E\036";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "k\024\005\002A";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "k\020\b\nV}*\037\034T|";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "}\000\031\004Pp\032\005";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "p\033\b\027Ax\030\016\013P";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "p\001\002\bA";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "v\003\016\027Hx\f";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "k\020\b\nV}\000\005\fPj";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "s\007\016\006Kk\021\016\027";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "m\f\033\0";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            z = as;
            a = Executors.newSingleThreadExecutor();
            d = null;
            e = new ArrayList();
            f = false;
            return;
        }
          goto _L12
_L8:
        byte0 = 25;
          goto _L13
_L5:
        byte0 = 117;
          goto _L13
_L6:
        byte0 = 107;
          goto _L13
        byte0 = 101;
          goto _L13
    }
}
