// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.uma:
//            b, f, l, e, 
//            g

public final class UMA
{

    static boolean a = false;
    private static final Object b = new Object();
    private static volatile f c;

    static b a(BufferedReader bufferedreader)
    {
        Object obj = b(bufferedreader);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        String s;
        if (!b(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        s = b(bufferedreader);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = new b(((String) (obj)), s);
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                Log.e("UMA", "", bufferedreader);
                return ((b) (obj));
            }
        }
        return ((b) (obj));
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                Log.e("UMA", "", bufferedreader);
            }
        }
_L2:
        return null;
        Object obj1;
        obj1;
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                Log.e("UMA", "", bufferedreader);
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                Log.e("UMA", "", bufferedreader);
            }
        }
        throw obj1;
    }

    static b a(File file)
    {
        Log.v("UMA", (new StringBuilder()).append("parseOverrideInitData ").append(file).toString());
        if (file == null || !file.exists())
        {
            return null;
        }
        try
        {
            file = a(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return null;
        }
        return file;
    }

    public static void a()
    {
        Log.v("UMA", "ENTER onStart");
        d();
        c.a();
        Log.v("UMA", "LEAVE onStart");
    }

    private static void a(Context context)
    {
        (new Thread(context) {

            final Context a;

            public void run()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("google_play_advertising_id", g.d(a));
                hashmap.put("android_id", g.b(a));
                Log.v("UMA", (new StringBuilder()).append("ID: ").append(hashmap).toString());
                UMA.a("_UMA_ID", hashmap, 1, 0.0D);
                UMA.c().c();
            }

            
            {
                a = context;
                super();
            }
        }).start();
    }

    public static void a(Context context, String s, String s1)
    {
        a(context, s, s1, ((String) (null)));
    }

    public static void a(Context context, String s, String s1, String s2)
    {
        b b1;
        b b2;
        b2 = null;
        b1 = null;
        Log.v("UMA", (new StringBuilder()).append("init URL:").append(s).append(" appKey:").append(s1).toString());
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null.");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("serverURL must not be null.");
        }
        if (!b(s))
        {
            throw new IllegalArgumentException("serverURL should be a http:// or https:// URL.");
        }
        if (s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException("appKey must not be null or empty.");
        }
        if (s2 != null)
        {
            int i = l.d(s2);
            if (i > 512)
            {
                String s3 = (new StringBuilder()).append("vendorInfo is too large. The URL encoded size ").append(i).append(" exceeds 512.").toString();
                if (a)
                {
                    throw new IllegalArgumentException(s3);
                }
                Log.w("UMA", s3);
            }
        }
        Object obj2 = b;
        obj2;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        if (a)
        {
            throw new IllegalStateException("init() was called. It must not be called multiple times.");
        }
        break MISSING_BLOCK_LABEL_211;
        context;
        obj2;
        JVM INSTR monitorexit ;
        throw context;
        Log.w("UMA", "init() was called. It must not be called multiple times.");
        obj2;
        JVM INSTR monitorexit ;
        return;
        boolean flag = s.equals("https://clad.cyberlink.com");
        Object obj;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        obj = b2;
        Object obj1 = context.getExternalFilesDir(null);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj = b2;
        obj1 = new File(((File) (obj1)), "uma-override.txt");
        obj = b2;
        b1 = a(((File) (obj1)));
        obj = obj1;
_L6:
        obj1 = obj;
        b2 = b1;
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        obj = b1;
        obj1 = l.a("uma-override.txt");
        obj = b1;
        b2 = a(((File) (obj1)));
        if (b2 == null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        obj = b2;
        Log.d("UMA", (new StringBuilder()).append("Found ").append(((File) (obj1)).getAbsolutePath()).append(". Will send data to ").append(b2.a).append(", with app key ").append(b2.b).toString());
_L3:
        Throwable throwable;
        for (obj = b2; obj != null; obj = null)
        {
            break MISSING_BLOCK_LABEL_449;
        }

        s = new b(s, s1);
_L4:
        c = new e(context, ((b) (s)).a, ((b) (s)).b, g.a(context), s2);
        a(context);
        obj2;
        JVM INSTR monitorexit ;
        return;
        throwable;
        Log.e("UMA", "Oops! That's embarrassing.", throwable);
          goto _L3
        s = ((String) (obj));
          goto _L4
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void a(String s)
    {
        a(s, 1);
    }

    public static void a(String s, int i)
    {
        a(s, i, 0.0D);
    }

    public static void a(String s, int i, double d1)
    {
        a(s, ((Map) (null)), i, d1);
    }

    public static void a(String s, Map map, int i)
    {
        a(s, map, i, 0.0D);
    }

    public static void a(String s, Map map, int i, double d1)
    {
        Log.v("UMA", (new StringBuilder()).append("recordEvent key:").append(s).append(" count:").append(i).append(" sum: ").append(d1).append(" segmentation:").append(map).toString());
        d();
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("key must not be null or empty.");
        }
        if (i < 1)
        {
            throw new IllegalArgumentException("count must be >= 1.");
        }
        int j = l.a(s, map);
        if (j > 5000)
        {
            try
            {
                throw new EventTooLargeException(s, j);
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            if (a)
            {
                throw s;
            }
            Log.e("UMA", "", s);
            HashMap hashmap = new HashMap();
            map = Log.getStackTraceString(s);
            s = map;
            if (map.length() > 2048)
            {
                s = (new StringBuilder()).append(map.substring(0, 2048)).append(" (truncated)").toString();
            }
            hashmap.put("stack_trace", s);
            a("_UMA_EventTooLargeException", ((Map) (hashmap)), 1);
            return;
        } else
        {
            c.a(s, map, i, d1);
            return;
        }
    }

    private static String b(BufferedReader bufferedreader)
    {
        do
        {
            String s = bufferedreader.readLine();
            if (s != null)
            {
                s = s.trim();
                if (!s.isEmpty() && s.charAt(0) != '#')
                {
                    return s;
                }
            } else
            {
                return null;
            }
        } while (true);
    }

    public static void b()
    {
        Log.v("UMA", "ENTER onStop");
        d();
        c.b();
        Log.v("UMA", "LEAVE onStop");
    }

    private static boolean b(String s)
    {
        return s != null && (s.startsWith("http://") || s.startsWith("https://"));
    }

    static f c()
    {
        return c;
    }

    private static void d()
    {
        if (c == null)
        {
            throw new IllegalStateException("UMA.init() must be called first.");
        } else
        {
            return;
        }
    }


    private class EventTooLargeException extends IllegalArgumentException
    {

        static String a(String s, int i)
        {
            return (new StringBuilder()).append("The estimated size is ").append(i).append(" that is greater than ").append(5000).append(". key:").append(s.substring(0, Math.min(s.length(), 40))).toString();
        }

        EventTooLargeException(String s, int i)
        {
            super(a(s, i));
        }
    }

}
