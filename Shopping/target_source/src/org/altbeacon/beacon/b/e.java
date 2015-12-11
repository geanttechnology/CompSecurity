// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.b;

import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.c.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package org.altbeacon.beacon.b:
//            c, a, b, f

public class e
    implements org.altbeacon.beacon.b.c
{

    Map a;
    private a b;
    private org.altbeacon.beacon.b.c c;
    private a d;
    private a e;
    private String f;
    private Context g;

    public e(Context context, String s)
    {
        this(context, s, org.altbeacon.beacon.b.a.a());
    }

    public e(Context context, String s, a a1)
    {
        f = null;
        e = a1;
        f = s;
        g = context;
        a();
        c = a(a1);
    }

    static String a(e e1)
    {
        return e1.f;
    }

    private org.altbeacon.beacon.b.c a(a a1)
    {
        org.altbeacon.beacon.c.c.a("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", new Object[] {
            a1.b(), a1.c(), a1.d(), a1.e()
        });
        if (a == null)
        {
            org.altbeacon.beacon.c.c.a("ModelSpecificDistanceCalculator", "Cannot get distance calculator because modelMap was never initialized", new Object[0]);
            return null;
        }
        a a2 = null;
        Iterator iterator = a.keySet().iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a3 = (a)iterator.next();
            if (a3.a(a1) > i)
            {
                i = a3.a(a1);
                a2 = a3;
            }
        } while (true);
        if (a2 != null)
        {
            org.altbeacon.beacon.c.c.a("ModelSpecificDistanceCalculator", "found a match with score %s", new Object[] {
                Integer.valueOf(i)
            });
            org.altbeacon.beacon.c.c.a("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", new Object[] {
                a2.b(), a2.c(), a2.d(), a2.e()
            });
            d = a2;
        } else
        {
            d = b;
            org.altbeacon.beacon.c.c.c("ModelSpecificDistanceCalculator", "Cannot find match for this device.  Using default", new Object[0]);
        }
        return (org.altbeacon.beacon.b.c)a.get(d);
    }

    static org.altbeacon.beacon.b.c a(e e1, a a1)
    {
        return e1.a(a1);
    }

    static org.altbeacon.beacon.b.c a(e e1, org.altbeacon.beacon.b.c c1)
    {
        e1.c = c1;
        return c1;
    }

    private void a()
    {
        boolean flag = false;
        if (f != null)
        {
            boolean flag1 = b();
            flag = flag1;
            if (!flag1)
            {
                c();
                flag = flag1;
            }
        }
        if (!flag)
        {
            d();
        }
        c = a(e);
    }

    static void a(e e1, String s)
        throws JSONException
    {
        e1.b(s);
    }

    private boolean a(String s)
    {
        FileOutputStream fileoutputstream;
        FileOutputStream fileoutputstream1;
        boolean flag;
        flag = false;
        fileoutputstream1 = null;
        fileoutputstream = null;
        FileOutputStream fileoutputstream2 = g.openFileOutput("model-distance-calculations.json", 0);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        fileoutputstream2.write(s.getBytes());
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        fileoutputstream2.close();
        if (fileoutputstream2 != null)
        {
            try
            {
                fileoutputstream2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        org.altbeacon.beacon.c.c.b("ModelSpecificDistanceCalculator", "Successfully saved new distance model file", new Object[0]);
        flag = true;
        return flag;
        s;
        fileoutputstream1 = fileoutputstream;
        org.altbeacon.beacon.c.c.a(s, "ModelSpecificDistanceCalculator", "Cannot write updated distance model to local storage", new Object[0]);
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            return false;
        } else
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s;
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception) { }
        }
        throw s;
    }

    private void b(String s)
        throws JSONException
    {
        a = new HashMap();
        s = JSONObjectInstrumentation.init(s).getJSONArray("models");
        int i = 0;
        while (i < s.length()) 
        {
            Object obj1 = s.getJSONObject(i);
            double d1;
            double d2;
            double d3;
            Object obj;
            String s1;
            String s2;
            String s3;
            boolean flag;
            if (((JSONObject) (obj1)).has("default"))
            {
                flag = ((JSONObject) (obj1)).getBoolean("default");
            } else
            {
                flag = false;
            }
            d1 = ((JSONObject) (obj1)).getDouble("coefficient1");
            d2 = ((JSONObject) (obj1)).getDouble("coefficient2");
            d3 = ((JSONObject) (obj1)).getDouble("coefficient3");
            obj = ((JSONObject) (obj1)).getString("version");
            s1 = ((JSONObject) (obj1)).getString("build_number");
            s2 = ((JSONObject) (obj1)).getString("model");
            s3 = ((JSONObject) (obj1)).getString("manufacturer");
            obj1 = new b(Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue(), Double.valueOf(d3).doubleValue());
            obj = new a(((String) (obj)), s1, s2, s3);
            a.put(obj, obj1);
            if (flag)
            {
                b = ((a) (obj));
            }
            i++;
        }
    }

    private boolean b()
    {
        Object obj1;
        Object obj2;
        Object obj4;
        Object obj5;
        File file;
        StringBuilder stringbuilder;
        obj5 = null;
        obj2 = null;
        obj4 = null;
        obj1 = null;
        file = new File(g.getFilesDir(), "model-distance-calculations.json");
        stringbuilder = new StringBuilder();
        Object obj = new FileInputStream(file);
        obj2 = obj4;
        obj1 = obj;
        obj4 = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
_L3:
        obj1 = ((BufferedReader) (obj4)).readLine();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append(((String) (obj1))).append("\n");
          goto _L3
        obj1;
        obj1 = obj;
        obj = obj4;
_L9:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (obj1 != null)
        {
            try
            {
                ((FileInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        return false;
_L2:
        if (obj4 != null)
        {
            try
            {
                ((BufferedReader) (obj4)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        try
        {
            b(stringbuilder.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            org.altbeacon.beacon.c.c.d("ModelSpecificDistanceCalculator", "Cannot update distance models from online database at %s with JSON", new Object[] {
                obj, f, stringbuilder.toString()
            });
            return false;
        }
        return true;
        obj4;
        obj = null;
_L7:
        obj2 = obj5;
        obj1 = obj;
        org.altbeacon.beacon.c.c.b(((Throwable) (obj4)), "ModelSpecificDistanceCalculator", "Cannot open distance model file %s", new Object[] {
            file
        });
        if (obj5 != null)
        {
            try
            {
                ((BufferedReader) (obj5)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        return false;
        obj4;
        obj = null;
_L5:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj4;
        obj4;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj2 = obj4;
        obj4 = obj1;
        if (true) goto _L5; else goto _L4
_L4:
        obj4;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj5 = obj4;
        obj4 = obj1;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        obj = null;
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Object obj3 = null;
        filenotfoundexception = ((FileNotFoundException) (obj));
        obj = obj3;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static boolean b(e e1)
    {
        return e1.b();
    }

    static boolean b(e e1, String s)
    {
        return e1.a(s);
    }

    private String c(String s)
        throws IOException
    {
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = null;
        stringbuilder = new StringBuilder();
        InputStream inputstream = org/altbeacon/beacon/b/e.getResourceAsStream((new StringBuilder()).append("/").append(s).toString());
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Object obj = getClass().getClassLoader().getResourceAsStream((new StringBuilder()).append("/").append(s).toString());
        inputstream = ((InputStream) (obj));
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        throw new RuntimeException((new StringBuilder()).append("Cannot load resource at ").append(s).toString());
        s;
_L6:
        if (bufferedreader != null)
        {
            bufferedreader.close();
        }
        if (inputstream != null)
        {
            inputstream.close();
        }
        throw s;
_L2:
        obj = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        s = ((BufferedReader) (obj)).readLine();
_L4:
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(s);
        stringbuilder.append('\n');
        s = ((BufferedReader) (obj)).readLine();
        if (true) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            ((BufferedReader) (obj)).close();
        }
        if (inputstream != null)
        {
            inputstream.close();
        }
        return stringbuilder.toString();
        s;
        inputstream = null;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        bufferedreader = ((BufferedReader) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static a c(e e1)
    {
        return e1.e;
    }

    private void c()
    {
        if (g.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            org.altbeacon.beacon.c.c.c("ModelSpecificDistanceCalculator", "App has no android.permission.INTERNET permission.  Cannot check for distance model updates", new Object[0]);
            return;
        }
        f f1 = new f(g, f, new _cls1());
        java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void avoid[] = new Void[0];
        if (!(f1 instanceof AsyncTask))
        {
            f1.executeOnExecutor(executor, avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask)f1, executor, avoid);
            return;
        }
    }

    private void d()
    {
        a = new HashMap();
        try
        {
            b(c("model-distance-calculations.json"));
            return;
        }
        catch (Exception exception)
        {
            org.altbeacon.beacon.c.c.b(exception, "ModelSpecificDistanceCalculator", "Cannot build model distance calculations", new Object[0]);
        }
    }

    public double a(int i, double d1)
    {
        if (c == null)
        {
            org.altbeacon.beacon.c.c.c("ModelSpecificDistanceCalculator", "distance calculator has not been set", new Object[0]);
            return -1D;
        } else
        {
            return c.a(i, d1);
        }
    }

    /* member class not found */
    class _cls1 {}

}
