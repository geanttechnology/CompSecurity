// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdStrategy;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class jg
{

    public static boolean b = false;
    private static jg c;
    private static String d = "FullScreenAdManager";
    private static String e = "TEMPIMAGEPATH";
    private static String f = "IMAGEPATH";
    private static String g;
    public Context a;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private final int m = 998;
    private jf n;
    private com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener o;

    public jg(Context context)
    {
        i = "FullScreenSharedPrefrence";
        j = "FullScreenData";
        k = "FullScreenExTime";
        l = "FullScreenShowTimes";
        n = null;
        o = new com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener() {

            final jg a;

            public void onAdInReterund(boolean flag)
            {
                Log.i("FullScreenAdManager", (new StringBuilder()).append("FullScreenAdManager onAdInReterund : ").append(flag).toString());
                if (flag)
                {
                    a.a(FotoAdStrategy.getMadFullInfo());
                }
            }

            
            {
                a = jg.this;
                super();
            }
        };
        a = context;
        i();
    }

    private String a(Context context, String s)
    {
        Context context1;
        Object obj;
        context1 = null;
        obj = context.getApplicationContext();
        context = ((Context) (obj)).getExternalFilesDir(null);
        if (!context.exists())
        {
            context.mkdir();
        }
        context = context.getAbsolutePath();
_L2:
        context1 = context;
        if (context != null)
        {
            context = (new StringBuilder()).append(context).append("/").append(s).toString();
            s = new File(context);
            context1 = context;
            if (!s.exists())
            {
                s.mkdirs();
                context1 = context;
            }
        }
        Log.v(d, (new StringBuilder()).append("enter here rootDir").append(context1).toString());
        return context1;
        context;
        obj = ((Context) (obj)).getCacheDir();
        context = context1;
        if (obj != null)
        {
            context = ((File) (obj)).getAbsolutePath();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String a(jg jg1)
    {
        return jg1.i;
    }

    public static jg a(Context context)
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        jg;
        JVM INSTR monitorenter ;
        c = new jg(context);
        jg;
        JVM INSTR monitorexit ;
_L2:
        return c;
        context;
        jg;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void a(jf jf1)
    {
label0:
        {
            if (jf1.b != null && !jf1.b.isEmpty())
            {
                String s = (new StringBuilder()).append(g).append(File.separator).append(jf1.b.substring(jf1.b.lastIndexOf("/") + 1)).toString();
                if (!(new File(s)).exists())
                {
                    break label0;
                }
                a(s, h);
            }
            return;
        }
        String s1 = (new StringBuilder()).append(h).append(File.separator).append(jf1.b.substring(jf1.b.lastIndexOf("/") + 1)).toString();
        (new AsyncHttpClient()).get(jf1.b, new AsyncHttpResponseHandler(s1) {

            final String a;
            final jg b;

            public void onFailure(int i1, Header aheader[], byte abyte0[], Throwable throwable)
            {
                Log.v(jg.h(), "save image failure.");
            }

            public void onSuccess(int i1, Header aheader[], byte abyte0[])
            {
                jg.a(b, abyte0, a);
                b.a.getSharedPreferences(jg.a(b), 0).edit().putString(jg.b(b), FotoAdStrategy.getMadFullInfo()).apply();
                Log.v(jg.h(), "save image success.");
            }

            
            {
                b = jg.this;
                a = s;
                super();
            }
        });
    }

    static void a(jg jg1, byte abyte0[], String s)
    {
        jg1.a(abyte0, s);
    }

    private void a(byte abyte0[], String s)
    {
        try
        {
            s = new FileOutputStream(new File(s));
            s.write(abyte0);
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
    }

    private boolean a(String s, String s1)
    {
        s = new File(s);
        if (!s.exists())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (!s.isFile())
        {
            return false;
        }
        boolean flag;
        File file = new File(s1);
        if (!file.exists())
        {
            file.mkdirs();
        }
        flag = s.renameTo(new File((new StringBuilder()).append(s1).append(File.separator).append(s.getName()).toString()));
        return flag;
        s;
        Crashlytics.logException(s);
        return false;
    }

    private int b(String s)
    {
        if (s.equalsIgnoreCase(es.m))
        {
            return com.fotoable.fotoadpackage.R.drawable.fullscreen_default_locker;
        }
        if (s.equalsIgnoreCase(es.e))
        {
            return com.fotoable.fotoadpackage.R.drawable.fullscreen_default_pip;
        }
        if (s.equalsIgnoreCase(es.b))
        {
            return com.fotoable.fotoadpackage.R.drawable.fullscreen_default_wantu;
        } else
        {
            return com.fotoable.fotoadpackage.R.drawable.fullscreen_default_locker;
        }
    }

    static String b(jg jg1)
    {
        return jg1.j;
    }

    private void b(String s, String s1)
    {
        File file = new File(s);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        if (!file.isDirectory())
        {
            return;
        }
        int j1;
        s = new File(s1);
        if (!s.exists())
        {
            s.mkdirs();
        }
        s1 = file.listFiles();
        j1 = s1.length;
        int i1 = 0;
_L8:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        file = s1[i1];
        if (!file.isFile()) goto _L5; else goto _L4
_L4:
        a(file.getAbsolutePath(), s.getAbsolutePath());
          goto _L6
_L5:
        if (file.isDirectory())
        {
            b(file.getAbsolutePath(), (new StringBuilder()).append(s.getAbsolutePath()).append(File.separator).append(file.getName()).toString());
        }
          goto _L6
        s;
        Crashlytics.logException(s);
_L2:
        return;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String c(Context context)
    {
        ArrayList arraylist = new ArrayList();
        if (context == null) goto _L2; else goto _L1
_L1:
        if (!ew.a(context, es.m))
        {
            arraylist.add(es.m);
        }
        if (!context.getPackageName().equalsIgnoreCase(es.e)) goto _L4; else goto _L3
_L3:
        if (!ew.a(context, es.b))
        {
            arraylist.add(es.b);
        }
_L2:
        if (arraylist.size() == 0)
        {
            return null;
        }
          goto _L5
_L4:
        if (ew.a(context, es.e)) goto _L2; else goto _L6
_L6:
        arraylist.add(es.e);
          goto _L2
        context;
        Crashlytics.logException(context);
_L8:
        context = null;
_L10:
        return context;
_L5:
        int i1 = (new Random()).nextInt(arraylist.size());
        if (i1 < 0) goto _L8; else goto _L7
_L7:
        if (i1 >= arraylist.size()) goto _L8; else goto _L9
_L9:
        context = (String)arraylist.get(i1);
          goto _L10
    }

    static String h()
    {
        return d;
    }

    private void i()
    {
        h = a(a, f);
        g = a(a, e);
    }

    public void a()
    {
        if (FotoAdStrategy.enableNewStrategy(a.getApplicationContext()))
        {
            FotoAdStrategy.addListener(o);
        }
    }

    public void a(int i1)
    {
        String s = (new StringBuilder()).append("fullAD_").append(i1).toString();
        try
        {
            Object obj = a.getSharedPreferences(l, 0);
            i1 = ((SharedPreferences) (obj)).getInt(s, 0);
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putInt(s.toString(), i1 + 1);
            ((android.content.SharedPreferences.Editor) (obj)).apply();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jf jf1;
        JSONObject jsonobject1;
        int i1;
        long l1;
        long l2;
        long l3;
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (s == null) goto _L2; else goto _L3
_L3:
        b(h, g);
        s = kv.b(s, "data");
        if (s == null) goto _L2; else goto _L4
_L4:
        if (s.length() <= 0) goto _L2; else goto _L5
_L5:
        l3 = (new Date()).getTime() / 1000L;
        i1 = 0;
_L9:
        if (i1 >= s.length()) goto _L2; else goto _L6
_L6:
        jsonobject = s.getJSONObject(i1);
        jf1 = new jf();
        if (jsonobject.has("id"))
        {
            jf1.a = jsonobject.getInt("id");
        }
        if (jsonobject.has("imageurl"))
        {
            jf1.b = jsonobject.getString("imageurl");
        }
        if (!jsonobject.has("ontime"))
        {
            break MISSING_BLOCK_LABEL_421;
        }
        l1 = jsonobject.getLong("ontime");
_L11:
        if (!jsonobject.has("offtime")) goto _L8; else goto _L7
_L7:
        l2 = jsonobject.getLong("offtime");
_L10:
        if (jsonobject.has("url"))
        {
            jf1.c = jsonobject.getString("url");
        }
        if (l1 >= l3 || l2 <= l3)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        jf1.d = l1;
        jf1.e = l2;
        if (jsonobject.has("maxTimes"))
        {
            jf1.f = jsonobject.getInt("maxTimes");
        }
        if (jsonobject.has("interval"))
        {
            jf1.h = jsonobject.getLong("interval");
        }
        if (jsonobject.has("adSchemUrl"))
        {
            jf1.i = jsonobject.getString("adSchemUrl");
        }
        jf1.j = null;
        if (!jsonobject.has("clickFrame"))
        {
            break MISSING_BLOCK_LABEL_368;
        }
        jsonobject1 = jsonobject.getJSONObject("clickFrame");
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        int j1 = jsonobject1.getInt("x");
        int k1 = jsonobject1.getInt("y");
        jf1.j = new Rect(j1, k1, jsonobject1.getInt("w") + j1, jsonobject1.getInt("h") + k1);
        if (jsonobject.has("analysizeUrl"))
        {
            jf1.k = jsonobject.getString("analysizeUrl");
        }
        a(jf1);
        i1++;
          goto _L9
        s;
        s.printStackTrace();
_L2:
        return;
_L8:
        l2 = 0L;
          goto _L10
        l1 = 0L;
          goto _L11
    }

    public boolean a(Context context, boolean flag)
    {
        return flag && c(context) != null;
    }

    public int b(int i1)
    {
        try
        {
            String s = (new StringBuilder()).append("fullAD_").append(i1).toString();
            i1 = a.getSharedPreferences(l, 0).getInt(s, 0);
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i1;
    }

    public jf b()
    {
        return n;
    }

    public jf b(Context context)
    {
        jf jf1;
        try
        {
            context = c(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return null;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (context.equalsIgnoreCase(""))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        jf1 = new jf();
        jf1.a = 998;
        jf1.i = context;
        jf1.c = (new StringBuilder()).append("market://details?id=").append(context).toString();
        jf1.g = b(((String) (context)));
        jf1.j = new Rect(0, 0, 320, 480);
        jf1.h = 3000L;
        return jf1;
        return null;
    }

    public String c()
    {
        return h;
    }

    public void d()
    {
        a.getSharedPreferences(i, 0).edit().putLong(k, (new Date()).getTime() / 1000L).apply();
    }

    public void e()
    {
        a.getSharedPreferences(i, 0).edit().putLong(k, 0L).apply();
    }

    public boolean f()
    {
        long l1;
        if (et.j(a) * 2 >= et.i(a) * 3)
        {
            if ((new Date()).getTime() / 1000L - (l1 = a.getSharedPreferences(i, 0).getLong(k, 0L)) > 1800L)
            {
                return true;
            }
        }
        return false;
    }

    public boolean g()
    {
        if (et.j(a) * 2 >= et.i(a) * 3) goto _L2; else goto _L1
_L1:
        boolean flag2 = false;
_L4:
        return flag2;
_L2:
        int i1;
        boolean flag;
        Object obj = a.getSharedPreferences(i, 0);
        Object obj1 = ((SharedPreferences) (obj)).getString(j, "{}");
        long l1 = ((SharedPreferences) (obj)).getLong(k, 0L);
        Exception exception;
        Exception exception1;
        jf jf1;
        JSONObject jsonobject;
        int j1;
        int k1;
        long l2;
        long l3;
        boolean flag1;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        if ((new Date()).getTime() / 1000L - l1 > 1800L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        flag4 = false;
        flag5 = false;
        flag = false;
        flag3 = false;
        flag2 = flag3;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        flag2 = flag3;
        if (i1 == 0) goto _L4; else goto _L5
_L5:
        try
        {
            obj = new JSONObject(((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
            return flag;
        }
        flag2 = flag3;
        if (obj == null) goto _L4; else goto _L6
_L6:
        flag1 = flag5;
        obj = kv.b(((JSONObject) (obj)), "data");
        flag2 = flag3;
        if (obj == null) goto _L4; else goto _L7
_L7:
        flag2 = flag3;
        flag1 = flag5;
        if (((JSONArray) (obj)).length() <= 0) goto _L4; else goto _L8
_L8:
        flag1 = flag5;
        l3 = (new Date()).getTime() / 1000L;
        i1 = 0;
        flag = flag4;
_L10:
        flag2 = flag;
        flag1 = flag;
        if (i1 >= ((JSONArray) (obj)).length()) goto _L4; else goto _L9
_L9:
        flag1 = flag;
        obj1 = ((JSONArray) (obj)).getJSONObject(i1);
        flag1 = flag;
        jf1 = new jf();
        l1 = 0L;
        l2 = 0L;
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("id"))
        {
            break MISSING_BLOCK_LABEL_277;
        }
        flag1 = flag;
        jf1.a = ((JSONObject) (obj1)).getInt("id");
        flag1 = flag;
        flag2 = flag;
        if (!((JSONObject) (obj1)).has("imageurl"))
        {
            break MISSING_BLOCK_LABEL_841;
        }
        flag1 = flag;
        jf1.b = ((JSONObject) (obj1)).getString("imageurl");
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("ontime"))
        {
            break MISSING_BLOCK_LABEL_337;
        }
        flag1 = flag;
        l1 = ((JSONObject) (obj1)).getLong("ontime");
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("offtime"))
        {
            break MISSING_BLOCK_LABEL_364;
        }
        flag1 = flag;
        l2 = ((JSONObject) (obj1)).getLong("offtime");
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("url"))
        {
            break MISSING_BLOCK_LABEL_393;
        }
        flag1 = flag;
        jf1.c = ((JSONObject) (obj1)).getString("url");
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("interval"))
        {
            break MISSING_BLOCK_LABEL_422;
        }
        flag1 = flag;
        jf1.h = ((JSONObject) (obj1)).getLong("interval");
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("maxTimes"))
        {
            break MISSING_BLOCK_LABEL_478;
        }
        flag1 = flag;
        j1 = ((JSONObject) (obj1)).getInt("maxTimes");
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_478;
        }
        flag1 = flag;
        if (b(jf1.a) > j1)
        {
            flag2 = flag;
            break MISSING_BLOCK_LABEL_841;
        }
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("adSchemUrl"))
        {
            break MISSING_BLOCK_LABEL_546;
        }
        flag1 = flag;
        jf1.i = ((JSONObject) (obj1)).getString("adSchemUrl");
        if (jf1.i == null || jf1.i.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_546;
        }
        flag1 = ew.a(a, jf1.i);
        flag2 = flag;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_841;
        }
        flag1 = flag;
        jf1.j = null;
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("clickFrame"))
        {
            break MISSING_BLOCK_LABEL_656;
        }
        flag1 = flag;
        jsonobject = ((JSONObject) (obj1)).getJSONObject("clickFrame");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_656;
        }
        flag1 = flag;
        j1 = jsonobject.getInt("x");
        flag1 = flag;
        k1 = jsonobject.getInt("y");
        flag1 = flag;
        jf1.j = new Rect(j1, k1, jsonobject.getInt("w") + j1, jsonobject.getInt("h") + k1);
        flag1 = flag;
        if (!((JSONObject) (obj1)).has("analysizeUrl"))
        {
            break MISSING_BLOCK_LABEL_685;
        }
        flag1 = flag;
        jf1.k = ((JSONObject) (obj1)).getString("analysizeUrl");
        flag2 = flag;
        if (l1 >= l3)
        {
            break MISSING_BLOCK_LABEL_841;
        }
        flag2 = flag;
        if (l2 <= l3)
        {
            break MISSING_BLOCK_LABEL_841;
        }
        flag1 = flag;
        jf1.d = l1;
        flag1 = flag;
        jf1.e = l2;
        flag1 = flag;
        if (n != null)
        {
            break MISSING_BLOCK_LABEL_755;
        }
        flag1 = flag;
        n = new jf();
        flag1 = flag;
        n = jf1;
        flag1 = flag;
        if (n.a(c()))
        {
            flag2 = true;
            break MISSING_BLOCK_LABEL_841;
        }
        flag1 = flag;
        a(n);
        flag2 = flag;
        break MISSING_BLOCK_LABEL_841;
        exception;
        flag = flag1;
        exception.printStackTrace();
        return flag1;
        exception1;
        flag2 = flag;
        i1++;
        flag = flag2;
          goto _L10
    }

}
