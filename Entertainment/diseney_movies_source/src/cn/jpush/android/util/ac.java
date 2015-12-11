// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            a, x, ai, ad, 
//            c, n

public class ac
{

    public static WeakReference a;
    public static JSONObject b;
    private static final String c;
    private static String d;
    private static String e;
    private static String f;
    private static final String g;
    private static ExecutorService h;
    private static Object i;
    private static final String z[];

    public ac()
    {
    }

    public static String a()
    {
        return d;
    }

    public static String a(int j)
    {
        try
        {
            InetAddress.getByName(z[29]);
        }
        catch (Exception exception)
        {
            return d;
        }
        return (new StringBuilder(z[28])).append(f).toString();
    }

    public static String a(Context context)
    {
        long l = cn.jpush.android.util.a.s(context);
        if (l == 0L)
        {
            context = c;
            x.c();
        } else
        {
            context = cn.jpush.android.util.a.t(context);
            if (ai.a(context))
            {
                context = c;
                x.c();
                return null;
            }
            context = cn.jpush.android.util.a.b(context);
            context = cn.jpush.android.util.a.b((new StringBuilder()).append(l).append(context).toString());
            if (!ai.a(context))
            {
                return (new StringBuilder()).append(l).append(":").append(context).toString();
            }
        }
        return null;
    }

    public static String a(Context context, String s, int j)
    {
        if (ai.a(s))
        {
            context = c;
            x.c();
        } else
        {
            s = c(s);
            long l = cn.jpush.android.util.a.s(context);
            if (l == 0L)
            {
                context = c;
                x.c();
                return null;
            }
            context = cn.jpush.android.util.a.t(context);
            if (ai.a(context))
            {
                context = c;
                x.c();
                return null;
            }
            context = cn.jpush.android.util.a.b(context);
            context = cn.jpush.android.util.a.b((new StringBuilder()).append(l).append(context).append(s).toString());
            if (!ai.a(context))
            {
                return (new StringBuilder()).append(l).append(":").append(context).toString();
            }
        }
        return null;
    }

    public static String a(String s)
    {
        String s1 = s;
        if (!s.startsWith(z[10]))
        {
            s1 = (new StringBuilder(z[10])).append(s).toString();
        }
        s = s1;
        if (!s1.endsWith(e))
        {
            s = (new StringBuilder()).append(s1).append(e).toString();
        }
        d = s;
        return s;
    }

    private static ArrayList a(JSONArray jsonarray, int j)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj = new JSONArray();
        if (jsonarray == null || jsonarray.length() <= 0) goto _L2; else goto _L1
_L1:
        int k;
        int i1;
        i1 = jsonarray.length() - 1;
        k = 0;
        j = 0;
_L9:
        if (i1 < 0) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject = jsonarray.optJSONObject(i1);
        if (jsonobject == null) goto _L6; else goto _L5
_L5:
        int l = jsonobject.toString().getBytes(z[9]).length;
        j += l;
        if (j <= 0x32000 || i1 <= 1)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (i1 > 1)
        {
            return arraylist;
        }
        if (i1 != 1)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        ((JSONArray) (obj)).put(jsonobject);
        arraylist.add(obj);
        return arraylist;
        if (k + l <= 20480) goto _L8; else goto _L7
_L7:
        Object obj1;
        arraylist.add(obj);
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put(jsonobject);
        k = l;
        obj = obj1;
_L6:
        i1--;
          goto _L9
_L8:
        k += l;
        ((JSONArray) (obj)).put(jsonobject);
          goto _L6
        obj1;
_L10:
        String s = c;
        ((UnsupportedEncodingException) (obj1)).getMessage();
        x.f();
          goto _L6
_L4:
        if (((JSONArray) (obj)).length() > 0)
        {
            arraylist.add(obj);
        }
_L2:
        return arraylist;
        obj1;
          goto _L10
        obj1;
        k = l;
          goto _L10
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        k = l;
        obj = obj1;
        obj1 = unsupportedencodingexception;
          goto _L10
        obj1;
          goto _L10
    }

    public static JSONObject a(Context context, String s)
    {
        Object obj;
        if (s == null || s.length() <= 0)
        {
            context = c;
            x.c();
            return null;
        }
        if (s.equals(z[0]))
        {
            obj = z[19];
        } else
        {
            obj = z[11];
        }
        if (context == null)
        {
            context = c;
            (new StringBuilder(z[20])).append(((String) (obj))).toString();
            x.c();
            return null;
        }
        s = context.openFileInput(s);
        context = s;
        byte abyte0[] = new byte[s.available() + 1];
        context = s;
        s.read(abyte0);
        a(((Closeable) (s)));
        context = new String(abyte0, z[9]);
        if (!ai.a(context)) goto _L2; else goto _L1
_L1:
        context = c;
        (new StringBuilder()).append(((String) (obj))).append(z[16]).toString();
        x.c();
        return null;
        Object obj1;
        obj1;
        s = null;
_L8:
        context = s;
        String s1 = c;
        context = s;
        (new StringBuilder(z[14])).append(((String) (obj))).append(z[17]).append(((FileNotFoundException) (obj1)).getMessage()).toString();
        context = s;
        x.c();
        a(((Closeable) (s)));
        return null;
        obj1;
        s = null;
_L6:
        context = s;
        s1 = c;
        context = s;
        (new StringBuilder(z[12])).append(((String) (obj))).append(z[18]).append(((IOException) (obj1)).getMessage()).toString();
        context = s;
        x.c();
        a(((Closeable) (s)));
        return null;
        context;
        obj = null;
        s = context;
_L4:
        a(((Closeable) (obj)));
        throw s;
_L2:
        try
        {
            context = new JSONObject(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            s = c;
            (new StringBuilder(z[13])).append(((String) (obj))).append(z[18]).append(context.getMessage()).toString();
            x.c();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            s = c;
            (new StringBuilder(z[15])).append(((String) (obj))).append(z[21]).append(context.getMessage()).toString();
            x.c();
            return null;
        }
        return context;
        s;
        obj = context;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void a(Context context, int j)
    {
        int l = 0;
        if (b != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j >= 0x32000)
        {
            b(context);
            return;
        }
        JSONArray jsonarray;
        JSONArray jsonarray1;
        JSONObject jsonobject;
        int k;
        int i1;
        try
        {
            k = b.toString().getBytes(z[1]).length;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            k = 0;
        }
        i1 = (k + j) - 0x32000;
        if (i1 <= 0) goto _L1; else goto _L3
_L3:
        jsonarray = b.optJSONArray(z[2]);
        if (jsonarray == null || jsonarray.length() <= 0) goto _L1; else goto _L4
_L4:
        try
        {
            jsonarray1 = new JSONArray();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        j = 0;
        k = l;
        if (j >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        jsonobject = jsonarray.getJSONObject(j);
        l = k;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        if (k < i1)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        jsonarray1.put(jsonobject);
        l = k + jsonobject.toString().getBytes(z[1]).length;
        break MISSING_BLOCK_LABEL_192;
        if (jsonarray1.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        b.put(z[2], jsonarray1);
_L6:
        a(context, z[0], b);
        return;
        b = null;
        if (true) goto _L6; else goto _L5
_L5:
        j++;
        k = l;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_89;
        }
    }

    public static void a(Context context, JSONArray jsonarray)
    {
        if (context == null)
        {
            context = c;
            x.c();
            return;
        }
        if (jsonarray == null || jsonarray.length() <= 0)
        {
            context = c;
            x.c();
            return;
        } else
        {
            h.execute(new ad(context, jsonarray));
            return;
        }
    }

    public static void a(Context context, JSONObject jsonobject)
    {
        a(context, (new JSONArray()).put(jsonobject));
    }

    private static void a(Context context, JSONObject jsonobject, ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() <= 0)
        {
            b(context);
        }
        JSONArray jsonarray = new JSONArray();
        for (int j = 0; j < arraylist.size(); j++)
        {
            JSONArray jsonarray1 = (JSONArray)arraylist.get(j);
            for (int k = 0; k < jsonarray1.length(); k++)
            {
                if (jsonarray1.optJSONObject(k) != null)
                {
                    jsonarray.put(jsonarray1.optJSONObject(k));
                }
            }

        }

        try
        {
            jsonobject.put(z[2], jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist) { }
        b = jsonobject;
        a(context, z[0], jsonobject);
    }

    private static void a(Context context, JSONObject jsonobject, JSONArray jsonarray, ArrayList arraylist)
    {
        if (arraylist != null)
        {
            if (arraylist.size() == 1)
            {
                b = null;
                b(context);
                return;
            }
            if (jsonarray != null && arraylist.size() > 1)
            {
                arraylist.remove(jsonarray);
                jsonarray = new JSONArray();
                for (int j = 0; j < arraylist.size(); j++)
                {
                    JSONArray jsonarray1 = (JSONArray)arraylist.get(j);
                    for (int k = 0; k < jsonarray1.length(); k++)
                    {
                        if (jsonarray1.optJSONObject(k) != null)
                        {
                            jsonarray.put(jsonarray1.optJSONObject(k));
                        }
                    }

                }

                try
                {
                    jsonobject.put(z[2], jsonarray);
                }
                // Misplaced declaration of an exception variable
                catch (JSONArray jsonarray) { }
                b = jsonobject;
                a(context, z[0], jsonobject);
                return;
            }
        }
    }

    private static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static boolean a(Context context, String s, JSONObject jsonobject)
    {
        String s2;
        if (ai.a(s))
        {
            context = c;
            x.c();
            return false;
        }
        if (s.equals(z[0]))
        {
            s2 = z[19];
        } else
        {
            s2 = z[11];
        }
        if (context == null)
        {
            context = c;
            (new StringBuilder(z[33])).append(s2).toString();
            x.c();
            return false;
        }
        Object obj3 = i;
        obj3;
        JVM INSTR monitorenter ;
        Object obj2;
        obj2 = "";
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        Object obj;
        boolean flag;
        obj = jsonobject.toString();
        flag = s.equals(z[0]);
        obj2 = obj;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        String s1 = c;
        (new StringBuilder(z[30])).append(jsonobject.toString(1)).toString();
        x.e();
        obj2 = obj;
_L2:
        Object obj1;
        obj1 = null;
        jsonobject = null;
        obj = null;
        context = context.openFileOutput(s, 0);
        obj = context;
        obj1 = context;
        jsonobject = context;
        context.write(((String) (obj2)).getBytes(z[9]));
        a(((Closeable) (context)));
        obj3;
        JVM INSTR monitorexit ;
        return true;
        obj1;
        obj1 = c;
        (new StringBuilder(z[30])).append(jsonobject.toString()).toString();
        x.e();
        obj2 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
        s;
        context = null;
_L4:
        jsonobject = c;
        (new StringBuilder(z[14])).append(s2).append(z[31]).append(s.getMessage()).toString();
        x.c();
        a(((Closeable) (context)));
        obj3;
        JVM INSTR monitorexit ;
        return false;
        context;
        jsonobject = ((JSONObject) (obj));
        s = c;
        jsonobject = ((JSONObject) (obj));
        (new StringBuilder(z[13])).append(s2).append(z[34]).append(context.getMessage()).toString();
        jsonobject = ((JSONObject) (obj));
        x.c();
        a(((Closeable) (obj)));
        obj3;
        JVM INSTR monitorexit ;
        return false;
        context;
        jsonobject = ((JSONObject) (obj1));
        s = c;
        jsonobject = ((JSONObject) (obj1));
        (new StringBuilder(z[32])).append(s2).append(z[34]).append(context.getMessage()).toString();
        jsonobject = ((JSONObject) (obj1));
        x.c();
        a(((Closeable) (obj1)));
        obj3;
        JVM INSTR monitorexit ;
        return false;
_L3:
        a(((Closeable) (s)));
        throw context;
        jsonobject;
        s = context;
        context = jsonobject;
          goto _L3
        s;
          goto _L4
        context;
        s = jsonobject;
          goto _L3
    }

    private static boolean a(JSONObject jsonobject, Context context)
    {
        jsonobject.put(z[26], "a");
        long l = cn.jpush.android.util.a.s(context);
        if (l == 0L)
        {
            jsonobject = c;
            x.f();
            return false;
        }
        jsonobject.put(z[25], l);
        context = cn.jpush.android.util.a.v(context);
        if (ai.a(context))
        {
            jsonobject = c;
            x.f();
            return false;
        } else
        {
            jsonobject.put(z[23], context);
            jsonobject.put(z[24], z[22]);
            return true;
        }
    }

    public static String b(String s)
    {
        try
        {
            s = cn.jpush.android.util.c.a(s.getBytes(), 10);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            x.f();
            return null;
        }
        return s;
    }

    private static void b(Context context)
    {
        b = null;
        a(context, z[0], ((JSONObject) (null)));
    }

    static void b(Context context, JSONArray jsonarray)
    {
        c(context, jsonarray);
    }

    public static void b(Context context, JSONObject jsonobject)
    {
        try
        {
            JSONArray jsonarray = new JSONArray();
            jsonarray.put(jsonobject);
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put(z[2], jsonarray);
            if (a(jsonobject1, context))
            {
                String s = c;
                (new StringBuilder(z[27])).append(jsonobject.toString()).toString();
                x.c();
                if (n.a(context, jsonobject1, true) == 200)
                {
                    jsonobject = c;
                    x.c();
                    c(context, ((JSONArray) (null)));
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private static String c(String s)
    {
        try
        {
            byte abyte0[] = s.getBytes(z[9]);
            s = new ByteArrayOutputStream();
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(s);
            gzipoutputstream.write(abyte0);
            gzipoutputstream.close();
            abyte0 = s.toByteArray();
            s.close();
            s = cn.jpush.android.util.a.a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    private static void c(Context context, JSONArray jsonarray)
    {
        Object obj;
        Object obj1;
        boolean flag1;
        flag1 = false;
        obj = z[0];
        if (b == null)
        {
            b = a(context, ((String) (obj)));
        }
        obj = b;
        if (obj == null)
        {
            obj = new JSONObject();
        }
        obj1 = ((JSONObject) (obj)).optJSONArray(z[2]);
        if (obj1 == null)
        {
            obj1 = new JSONArray();
        }
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() <= 0) goto _L2; else goto _L3
_L3:
        int j = 0;
_L4:
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        ((JSONArray) (obj1)).put(jsonarray.get(j));
        j++;
        if (true) goto _L4; else goto _L2
_L2:
        if (cn.jpush.android.util.a.b(context)) goto _L6; else goto _L5
_L5:
        ((JSONObject) (obj)).put(z[2], obj1);
        a(context, z[0], ((JSONObject) (obj)));
_L8:
        return;
        jsonarray;
_L6:
        if (((JSONArray) (obj1)).length() <= 0) goto _L8; else goto _L7
_L7:
        jsonarray = a(((JSONArray) (obj1)), 20480);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(jsonarray);
        JSONException jsonexception;
        String s1;
        String s2;
        int k;
        boolean flag;
        try
        {
            String s = c;
            (new StringBuilder(z[6])).append(((JSONArray) (obj1)).toString().getBytes(z[1]).length).toString();
            x.c();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception) { }
        obj1 = c;
        (new StringBuilder(z[3])).append(jsonarray.size()).append(z[8]).toString();
        x.c();
        flag = false;
        k = ((flag1) ? 1 : 0);
_L13:
        if (k >= jsonarray.size()) goto _L8; else goto _L9
_L9:
        obj1 = (JSONArray)jsonarray.get(k);
        if (flag) goto _L8; else goto _L10
_L10:
        if (((JSONArray) (obj1)).length() > 0) goto _L12; else goto _L11
_L11:
        arraylist.remove(obj1);
_L14:
        k++;
          goto _L13
_L12:
        ((JSONObject) (obj)).put(z[2], obj1);
        try
        {
            if (!a(((JSONObject) (obj)), context))
            {
                c(context, ((JSONObject) (obj)));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            obj1 = c;
            (new StringBuilder(z[7])).append(jsonarray).toString();
            x.c();
            c(context, ((JSONObject) (obj)));
            return;
        }
        break MISSING_BLOCK_LABEL_402;
        jsonexception;
        s2 = c;
        (new StringBuilder(z[4])).append(jsonexception).toString();
        x.c();
        a(context, ((JSONObject) (obj)), ((JSONArray) (obj1)), arraylist);
          goto _L14
        if (obj != null)
        {
            try
            {
                s1 = c;
                (new StringBuilder(z[5])).append(((JSONObject) (obj)).toString(1)).toString();
                x.d();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1 = c;
                (new StringBuilder(z[5])).append(((JSONObject) (obj)).toString()).toString();
                x.d();
            }
        }
        switch (n.a(context, ((JSONObject) (obj)), true))
        {
        case -5: 
        case -4: 
        case -3: 
        case -2: 
            a(context, ((JSONObject) (obj)), ((JSONArray) (obj1)), arraylist);
            break;

        case 200: 
            a(context, ((JSONObject) (obj)), ((JSONArray) (obj1)), arraylist);
            break;

        case 401: 
            b(context);
            flag = true;
            break;

        case -1: 
        case 404: 
        case 429: 
        case 500: 
            a(context, ((JSONObject) (obj)), arraylist);
            break;
        }
        if (true) goto _L14; else goto _L15
_L15:
    }

    private static void c(Context context, JSONObject jsonobject)
    {
        b = jsonobject;
        a(context, z[0], jsonobject);
    }

    static 
    {
        Object obj;
        Object aobj[];
        Object obj1;
        int j;
        int k;
        aobj = new String[35];
        k = 0;
        obj1 = "\020Fbh\000%Ecz\034%Uvx\000\037i\177r\033\016YebF\020Exu";
        j = -1;
        obj = ((Object) (aobj));
_L46:
        String as[];
        char ac1[];
        int l;
        int i1;
        int j1;
        int k1;
        byte byte1;
        int l1;
        ac1 = ((String) (obj1)).toCharArray();
        l = ac1.length;
        k1 = 0;
        i1 = 0;
        byte1 = j;
        obj1 = ac1;
        l1 = k;
        as = ((String []) (obj));
        j1 = l;
        if (l > 1) goto _L2; else goto _L1
_L1:
        String as1[];
        byte byte0;
        as1 = ((String []) (obj));
        obj = ac1;
        byte0 = j;
_L10:
        j1 = i1;
_L8:
        obj1 = obj;
        k1 = obj1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 1200
    //                   1 1207
    //                   2 1214
    //                   3 1221;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        j = 104;
_L57:
label0:
        {
            obj1[i1] = (char)(j ^ k1);
            j1++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
          goto _L8
        k1 = j1;
        j1 = l;
        as = as1;
        l1 = k;
        obj1 = obj;
        byte1 = byte0;
_L2:
        byte0 = byte1;
        obj = obj1;
        k = l1;
        as1 = as;
        l = j1;
        i1 = k1;
        if (j1 > k1) goto _L10; else goto _L9
_L9:
        obj = (new String(((char []) (obj1)))).intern();
        byte1;
        JVM INSTR tableswitch 0 33: default 356
    //                   0 375
    //                   1 394
    //                   2 413
    //                   3 432
    //                   4 451
    //                   5 471
    //                   6 492
    //                   7 513
    //                   8 534
    //                   9 555
    //                   10 576
    //                   11 597
    //                   12 618
    //                   13 639
    //                   14 660
    //                   15 681
    //                   16 702
    //                   17 723
    //                   18 744
    //                   19 765
    //                   20 786
    //                   21 807
    //                   22 828
    //                   23 849
    //                   24 870
    //                   25 891
    //                   26 912
    //                   27 933
    //                   28 954
    //                   29 975
    //                   30 996
    //                   31 1017
    //                   32 1038
    //                   33 1059;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45
_L11:
        as[l1] = ((String) (obj));
        k = 1;
        obj1 = "\017Bq6P";
        j = 0;
        obj = ((Object) (aobj));
          goto _L46
_L12:
        as[l1] = ((String) (obj));
        k = 2;
        obj1 = "\031Yyo\r\024B";
        j = 1;
        obj = ((Object) (aobj));
          goto _L46
_L13:
        as[l1] = ((String) (obj));
        k = 3;
        obj1 = "\026Yp;\f\023@~\177\r\036\026~u\034\025\026";
        j = 2;
        obj = ((Object) (aobj));
          goto _L46
_L14:
        as[l1] = ((String) (obj));
        k = 4;
        obj1 = "\nCc;\013\025Xc~\006\016\026rc\013\037Fcr\007\024\0327|\001\fS7n\030ZEru\fZZx|R";
        j = 3;
        obj = ((Object) (aobj));
          goto _L46
_L15:
        as[l1] = ((String) (obj));
        k = 5;
        obj1 = "\tSy\177H\026Yp;\033\026_t~R";
        j = 4;
        obj = ((Object) (aobj));
          goto _L46
_L16:
        as[l1] = ((String) (obj));
        k = 6;
        obj1 = "\026Yp;\033\023Lr!";
        j = 5;
        obj = ((Object) (aobj));
          goto _L46
_L17:
        as[l1] = ((String) (obj));
        k = 7;
        obj1 = "\rDvkH\031Yyo\t\023XriH\037Nt~\030\016_xuDZQ~m\rZCg;\033\037Xs;\004\025Q-";
        j = 6;
        obj = ((Object) (aobj));
          goto _L46
_L18:
        as[l1] = ((String) (obj));
        k = 8;
        obj1 = "ZFvi\034\t";
        j = 7;
        obj = ((Object) (aobj));
          goto _L46
_L19:
        as[l1] = ((String) (obj));
        k = 9;
        obj1 = "/bQ6P";
        j = 8;
        obj = ((Object) (aobj));
          goto _L46
_L20:
        as[l1] = ((String) (obj));
        k = 10;
        obj1 = "\022BckRU\031";
        j = 9;
        obj = ((Object) (aobj));
          goto _L46
_L21:
        as[l1] = ((String) (obj));
        k = 11;
        obj1 = "\031Cei\r\024BHh\r\tE~t\006%P~w\r";
        j = 10;
        obj = ((Object) (aobj));
          goto _L46
_L22:
        as[l1] = ((String) (obj));
        k = 12;
        obj1 = "\031Wy<\034ZDrz\fZ";
        j = 11;
        obj = ((Object) (aobj));
          goto _L46
_L23:
        as[l1] = ((String) (obj));
        k = 13;
        obj1 = "\031Wy<\034ZSyx\007\036_y|H";
        j = 12;
        obj = ((Object) (aobj));
          goto _L46
_L24:
        as[l1] = ((String) (obj));
        k = 14;
        obj1 = "\031Wy<\034ZYg~\006Z";
        j = 13;
        obj = ((Object) (aobj));
          goto _L46
_L25:
        as[l1] = ((String) (obj));
        k = 15;
        obj1 = "\031Wy<\034ZTbr\004\036\026";
        j = 14;
        obj = ((Object) (aobj));
          goto _L46
_L26:
        as[l1] = ((String) (obj));
        k = 16;
        obj1 = "Z_d;\006\017Z{7H\bScn\032\024\026yn\004\026";
        j = 15;
        obj = ((Object) (aobj));
          goto _L46
_L27:
        as[l1] = ((String) (obj));
        k = 17;
        obj1 = "Z_yk\035\016eci\r\033[;;\017\023@r;\035\n\026e~\t\036\0267!";
        j = 16;
        obj = ((Object) (aobj));
          goto _L46
_L28:
        as[l1] = ((String) (obj));
        k = 18;
        obj1 = "V\026pr\036\037\026bkH\bSv\177H@";
        j = 17;
        obj = ((Object) (aobj));
          goto _L46
_L29:
        as[l1] = ((String) (obj));
        k = 19;
        obj1 = "\022_do\007\bOH}\001\026S";
        j = 18;
        obj = ((Object) (aobj));
          goto _L46
_L30:
        as[l1] = ((String) (obj));
        k = 20;
        obj1 = "\031Yyo\r\002B7r\033ZXbw\004Z\0327|\001\fS7n\030ZDrz\fZ";
        j = 19;
        obj = ((Object) (aobj));
          goto _L46
_L31:
        as[l1] = ((String) (obj));
        k = 21;
        obj1 = "Z_yo\007Z|dt\0065T}~\013\016\0327|\001\fS7n\030ZDrz\fZ\f";
        j = 20;
        obj = ((Object) (aobj));
          goto _L46
_L32:
        as[l1] = ((String) (obj));
        k = 22;
        obj1 = "K\030 5Y";
        j = 21;
        obj = ((Object) (aobj));
          goto _L46
_L33:
        as[l1] = ((String) (obj));
        k = 23;
        obj1 = "\033FgD\003\037O";
        j = 22;
        obj = ((Object) (aobj));
          goto _L46
_L34:
        as[l1] = ((String) (obj));
        k = 24;
        obj1 = "\tR|D\036\037D";
        j = 23;
        obj = ((Object) (aobj));
          goto _L46
_L35:
        as[l1] = ((String) (obj));
        k = 25;
        obj1 = "\017_s";
        j = 24;
        obj = ((Object) (aobj));
          goto _L46
_L36:
        as[l1] = ((String) (obj));
        k = 26;
        obj1 = "\nZvo\016\025Dz";
        j = 25;
        obj = ((Object) (aobj));
          goto _L46
_L37:
        as[l1] = ((String) (obj));
        k = 27;
        obj1 = "\bSgt\032\016\026ar\tZE~u\017\026S7x\000\033Xy~\004@";
        j = 26;
        obj = ((Object) (aobj));
          goto _L46
_L38:
        as[l1] = ((String) (obj));
        k = 28;
        obj1 = "\022BckRU\031do\t\016E9q\030\017E\1775\013\024";
        j = 27;
        obj = ((Object) (aobj));
          goto _L46
_L39:
        as[l1] = ((String) (obj));
        k = 29;
        obj1 = "\tBvo\033T\\gn\033\022\030tu";
        j = 28;
        obj = ((Object) (aobj));
          goto _L46
_L40:
        as[l1] = ((String) (obj));
        k = 30;
        obj1 = "\tWa~H\026Yp;\001\024\026`i\001\016S_r\033\016Yeb$\025Q-";
        j = 29;
        obj = ((Object) (aobj));
          goto _L46
_L41:
        as[l1] = ((String) (obj));
        k = 31;
        obj1 = "ZYbo\030\017BDo\032\037Wz7H\035_a~H\017F7h\t\fS7!";
        j = 30;
        obj = ((Object) (aobj));
          goto _L46
_L42:
        as[l1] = ((String) (obj));
        k = 32;
        obj1 = "\031Wy<\034ZAer\034\037\026";
        j = 31;
        obj = ((Object) (aobj));
          goto _L46
_L43:
        as[l1] = ((String) (obj));
        k = 33;
        obj1 = "\031Yyo\r\002B7r\033ZXbw\004Z\0327|\001\fS7n\030ZEvm\rZ";
        j = 32;
        obj = ((Object) (aobj));
          goto _L46
_L44:
        as[l1] = ((String) (obj));
        k = 34;
        obj1 = "Z\0327|\001\fS7n\030ZEvm\rZ\f";
        j = 33;
        obj = ((Object) (aobj));
          goto _L46
_L45:
        as[l1] = ((String) (obj));
        z = ((String []) (aobj));
        c = cn/jpush/android/util/ac.getSimpleName();
        d = "";
        obj = "U@&4\032\037Fxi\034";
        l = -1;
_L63:
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        j1 = 0;
        j = 0;
        k1 = l;
        aobj = ((Object []) (obj));
        i1 = k;
        if (k > 1) goto _L48; else goto _L47
_L47:
        j1 = j;
        i1 = j;
_L56:
        aobj = ((Object []) (obj));
        k1 = aobj[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 1168
    //                   0 1228
    //                   1 1235
    //                   2 1242
    //                   3 1249;
           goto _L49 _L50 _L51 _L52 _L53
_L49:
        j = 104;
_L58:
        aobj[i1] = (char)(j ^ k1);
        j1++;
        if (k != 0) goto _L55; else goto _L54
_L54:
        i1 = k;
          goto _L56
_L4:
        j = 122;
          goto _L57
_L5:
        j = 54;
          goto _L57
_L6:
        j = 23;
          goto _L57
_L7:
        j = 27;
          goto _L57
_L50:
        j = 122;
          goto _L58
_L51:
        j = 54;
          goto _L58
_L52:
        j = 23;
          goto _L58
_L53:
        j = 27;
          goto _L58
_L55:
        i1 = k;
        aobj = ((Object []) (obj));
        k1 = l;
_L48:
        l = k1;
        obj = ((Object) (aobj));
        k = i1;
        j = j1;
        if (i1 > j1) goto _L47; else goto _L59
_L59:
        obj = (new String(((char []) (aobj)))).intern();
        k1;
        JVM INSTR tableswitch 0 0: default 1320
    //                   0 1333;
           goto _L60 _L61
_L60:
        e = ((String) (obj));
        obj = "U@%4\032\037Fxi\034";
        l = 0;
        if (true) goto _L63; else goto _L62
_L62:
_L61:
        f = ((String) (obj));
        g = (new StringBuilder(z[28])).append(e).toString();
        h = Executors.newSingleThreadExecutor();
        a = null;
        b = null;
        i = new Object();
          goto _L8
    }
}
