// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.Log;
import com.kahuna.sdk.m;
import com.kahuna.sdk.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ahf, ahe, ahd, ahi

public class ahj
{

    private static final ahj a = new ahj();
    private ahf b;
    private ahe c;
    private boolean d;
    private Map e;
    private Object f;
    private Context g;

    private ahj()
    {
        d = false;
        f = new Object();
    }

    public static void a(Context context)
    {
        a.g = context;
    }

    public static void a(m m1)
    {
        if (m1 != null && (m1 instanceof m)) goto _L2; else goto _L1
_L1:
        Log.e("Kahuna", "You cannot init the Region Manager externally from the Kahuna SDK. Aborting!");
_L4:
        return;
_L2:
        a.d = b(a.g);
        if (!a.d) goto _L4; else goto _L3
_L3:
        a.b = new ahf(a.g);
        a.c = new ahe(a.g);
        Object obj = a.f;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        a.e = r.a(m1, a.g);
        long l = System.currentTimeMillis();
        obj1 = new HashSet();
        Iterator iterator = a.e.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (l > ((Long)a.e.get(s1)).longValue())
            {
                ((Set) (obj1)).add(s1);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_243;
        m1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw m1;
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            a.d = false;
        }
        if (!m.s()) goto _L4; else goto _L5
_L5:
        Log.d("Kahuna", (new StringBuilder()).append("Caught error in Region Manager init: ").append(m1).toString());
        m1.printStackTrace();
        return;
        String s;
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); a.e.remove(s))
        {
            s = (String)((Iterator) (obj1)).next();
        }

        r.a(m1, a.e, a.g);
        obj;
        JVM INSTR monitorexit ;
        Object obj2 = r.b(m1, a.g);
        obj = new ArrayList();
        obj2 = ((List) (obj2)).iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            ahd ahd1 = (ahd)((Iterator) (obj2)).next();
            if (a.e.containsKey(ahd1.a()))
            {
                ((List) (obj)).add(ahd1);
            }
        } while (true);
        if (((List) (obj)).size() <= 0) goto _L4; else goto _L6
_L6:
        a(m1, ((List) (obj)), a.g);
        return;
    }

    public static void a(m m1, String s)
    {
        if (m1 == null || !(m1 instanceof m))
        {
            Log.e("Kahuna", "You cannot set last entered region externally from the Kahuna SDK. Aborting!");
        } else
        {
            r.a(m1, a.g, s);
            if (m.s())
            {
                Log.d("Kahuna", (new StringBuilder()).append("Saving last entered regionId: ").append(s).toString());
                return;
            }
        }
    }

    public static void a(m m1, List list, Context context)
    {
        if (m1 != null && (m1 instanceof m)) goto _L2; else goto _L1
_L1:
        Log.e("Kahuna", "You cannot request to add geofences to the Region Manager externally from the Kahuna SDK. Aborting!");
_L4:
        return;
_L2:
        if (!a.d)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj1 = a.f;
        obj1;
        JVM INSTR monitorenter ;
        Object obj = new ArrayList();
        ArrayList arraylist = ((ArrayList) (obj));
        if (a.e == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        arraylist = ((ArrayList) (obj));
        if (a.e.size() > 0)
        {
            arraylist = new ArrayList(a.e.keySet());
            obj = list.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ahd ahd1 = (ahd)((Iterator) (obj)).next();
                if (arraylist.contains(ahd1.a()))
                {
                    arraylist.remove(ahd1.a());
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_195;
        m1;
        obj1;
        JVM INSTR monitorexit ;
        try
        {
            throw m1;
        }
        // Misplaced declaration of an exception variable
        catch (m m1) { }
        if (!m.s()) goto _L4; else goto _L3
_L3:
        Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Region Manager add geofences: ").append(m1).toString());
        return;
        if (arraylist.size() > 0)
        {
            a.c.a(arraylist);
        }
        arraylist = new ArrayList();
        obj = new HashMap();
        if (list == null) goto _L6; else goto _L5
_L5:
        int i = 0;
_L7:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ahd ahd2 = (ahd)list.get(i);
        arraylist.add(ahd2.f());
        ((Map) (obj)).put(ahd2.a(), Long.valueOf(System.currentTimeMillis() + ahd2.e()));
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        a.b.a(arraylist);
        a.e = ((Map) (obj));
        r.a(m1, a.e, context);
        r.a(m1, list, context);
        obj1;
        JVM INSTR monitorexit ;
        return;
        if (!m.s()) goto _L4; else goto _L8
_L8:
        Log.d("Kahuna", "Attempted to register geofences but device is not properly setup.");
        return;
    }

    public static void a(m m1, JSONObject jsonobject, Context context)
    {
        if (m1 != null && (m1 instanceof m)) goto _L2; else goto _L1
_L1:
        Log.e("Kahuna", "You cannot request to process regions externally from the Kahuna SDK. Aborting!");
_L8:
        return;
_L2:
        if (!a.d)
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = jsonobject.optJSONArray("circle");
        if (jsonobject == null)
        {
            continue;
        }
        ArrayList arraylist;
        int j;
        j = jsonobject.length();
        arraylist = new ArrayList();
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject(i);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        double d1;
        double d2;
        String s;
        int k;
        long l2;
        s = jsonobject1.getString("id");
        d1 = jsonobject1.getDouble("lat");
        d2 = jsonobject1.getDouble("long");
        k = jsonobject1.getInt("radius");
        l2 = jsonobject1.optLong("expiry");
        long l;
        long l1;
        l1 = 0L;
        l = l1;
        if (l2 <= 0L)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        l2 -= System.currentTimeMillis() / 1000L;
        l = l1;
        if (l2 > 0L)
        {
            l = l2 * 1000L;
        }
        arraylist.add(new ahd(s, d1, d2, k, l, 3));
_L6:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        break;
        exception;
        if (!m.s()) goto _L6; else goto _L5
_L5:
        Log.d("Kahuna", "Encountered error processing geofence regions from Kahuna servers.");
        exception.printStackTrace();
          goto _L6
        do
        {
            try
            {
                d(m1);
                a(m1, ((List) (arraylist)), context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (m m1) { }
            if (m.s())
            {
                Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Region Manager process server regions: ").append(m1).toString());
                return;
            }
        } while (false);
        if (true) goto _L8; else goto _L7
_L7:
        if (!m.s()) goto _L8; else goto _L9
_L9:
        Log.d("Kahuna", "Server responded with available geofence regions but device is not setup properly.");
        return;
    }

    public static boolean a()
    {
        return a.d;
    }

    public static Set b(m m1)
    {
        Object obj;
        if (m1 == null || !(m1 instanceof m))
        {
            Log.e("Kahuna", "You cannot request to obtain Kahuna monitoring specs externally from the Kahuna SDK. Aborting!");
            return new HashSet();
        }
        obj = new HashSet();
        m1 = ((m) (a.f));
        m1;
        JVM INSTR monitorenter ;
        if (a.e != null)
        {
            for (Iterator iterator = a.e.keySet().iterator(); iterator.hasNext(); ((Set) (obj)).add(((String)iterator.next()).replace("KahunaEngineRegion_", ""))) { }
        }
        break MISSING_BLOCK_LABEL_113;
        obj;
        m1;
        JVM INSTR monitorexit ;
        throw obj;
        m1;
        JVM INSTR monitorexit ;
        return ((Set) (obj));
    }

    private static boolean b(Context context)
    {
        boolean flag;
        boolean flag1;
        try
        {
            flag1 = ahi.a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (m.s())
            {
                Log.w("Kahuna", "Caught error when checking for play services. If you are NOT using Geofencing please ignore this error: ");
                Log.w("Kahuna", context);
            }
            return false;
        }
        flag = flag1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        flag = ahi.a(context, "android.permission.ACCESS_FINE_LOCATION");
        return flag;
    }

    public static String c(m m1)
    {
        if (m1 == null || !(m1 instanceof m))
        {
            Log.e("Kahuna", "You cannot get last entered region externally from the Kahuna SDK. Aborting!");
            return null;
        } else
        {
            return r.c(m1, a.g);
        }
    }

    public static void d(m m1)
    {
        if (m1 == null || !(m1 instanceof m))
        {
            Log.e("Kahuna", "You cannot clear entered region externally from the Kahuna SDK. Aborting!");
        } else
        {
            r.a(m1, a.g, null);
            if (m.s())
            {
                Log.d("Kahuna", "Cleared last entered regionId");
                return;
            }
        }
    }

}
