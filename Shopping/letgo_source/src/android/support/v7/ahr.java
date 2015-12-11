// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

// Referenced classes of package android.support.v7:
//            ahk, ahm, aho

class ahr
{
    private static class a
    {

        private final aho.a a;
        private final String b;

        static aho.a a(a a1)
        {
            return a1.a;
        }

        static String b(a a1)
        {
            return a1.b;
        }

        public String toString()
        {
            return (new StringBuilder()).append(android/support/v7/ahr$a.getSimpleName()).append(" - type: ").append(a).append(", name: ").append(b).toString();
        }

        protected a(aho.a a1, String s)
        {
            a = a1;
            b = s;
        }
    }


    private static final ahr a = new ahr();
    private volatile List b;
    private volatile ScheduledExecutorService c;

    private ahr()
    {
        b = new ArrayList();
        c = null;
    }

    public static ahr a()
    {
        return a;
    }

    static List a(ahr ahr1)
    {
        return ahr1.b;
    }

    static List a(ahr ahr1, List list)
    {
        ahr1.b = list;
        return list;
    }

    public void a(Context context)
    {
        if (c != null)
        {
            return;
        }
        SharedPreferences sharedpreferences = context.getSharedPreferences("nanTrackingPrefs", 0);
        if (sharedpreferences == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = new ArrayList();
        int i = 0;
_L5:
        String s1;
        context = sharedpreferences.getString((new StringBuilder()).append("suppress_type").append(i).toString(), null);
        s1 = sharedpreferences.getString((new StringBuilder()).append("suppress_name").append(i).toString(), null);
        if (context != null && s1 != null) goto _L4; else goto _L3
_L3:
        String s;
        try
        {
            b = arraylist;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ahk.a().a("Error initializing type/name for suppression", context);
        }
_L2:
        c = Executors.newSingleThreadScheduledExecutor();
        c.scheduleWithFixedDelay(new Runnable() {

            final ahr a;

            public void run()
            {
                Object obj2;
                InputStream inputstream;
                obj2 = null;
                inputstream = null;
                if (aho.a().b() != null || aho.a().c() != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                Object obj = "http://api.nanigans.com/disallowed.php?";
                if (aho.a().b() != null)
                {
                    obj = (new StringBuilder()).append("http://api.nanigans.com/disallowed.php?").append("fb_app_id=").append(URLEncoder.encode(aho.a().b(), "UTF-8")).toString();
                }
                Object obj1 = obj;
                if (aho.a().c() == null)
                {
                    break MISSING_BLOCK_LABEL_129;
                }
                obj1 = (new StringBuilder()).append(((String) (obj)));
                Object obj3;
                int j;
                if (((String) (obj)).endsWith("?"))
                {
                    obj = "&";
                } else
                {
                    obj = "";
                }
                obj1 = ((StringBuilder) (obj1)).append(((String) (obj))).append("app_id=").append(aho.a().c()).toString();
                obj = (HttpURLConnection)(new URL(((String) (obj1)))).openConnection();
                ((HttpURLConnection) (obj)).setUseCaches(false);
                ((HttpURLConnection) (obj)).setConnectTimeout(60000);
                ((HttpURLConnection) (obj)).setReadTimeout(60000);
                ((HttpURLConnection) (obj)).setRequestProperty("Connection", "Keep-Alive");
                ((HttpURLConnection) (obj)).setRequestProperty("Content-Length", "0");
                ((HttpURLConnection) (obj)).connect();
                j = ((HttpURLConnection) (obj)).getResponseCode();
                obj1 = ((HttpURLConnection) (obj)).getInputStream();
                inputstream = ((InputStream) (obj1));
                obj2 = new ByteArrayOutputStream();
                for (byte abyte0[] = new byte[1024]; inputstream.read(abyte0) != -1; ((ByteArrayOutputStream) (obj2)).write(abyte0)) { }
                  goto _L3
_L18:
                if (ahk.a().a)
                {
                    Log.e(android/support/v7/aho.getSimpleName(), "Error getting suppressed info", ((Throwable) (obj2)));
                }
                if (abyte0 != null)
                {
                    abyte0.disconnect();
                }
                Object obj4;
                Object obj6;
                Object obj7;
                ArrayList arraylist1;
                int k;
                if (inputstream != null)
                {
                    try
                    {
                        inputstream.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[]) { }
                }
                if (obj == null) goto _L1; else goto _L4
_L4:
                try
                {
                    ((ByteArrayOutputStream) (obj)).close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return;
                }
_L3:
                obj6 = new String(((ByteArrayOutputStream) (obj2)).toByteArray(), "UTF-8");
                j;
                JVM INSTR tableswitch 200 200: default 894
            //                           200 395;
                   goto _L5 _L6
_L5:
                if (ahk.a().a)
                {
                    Log.e(android/support/v7/aho.getSimpleName(), (new StringBuilder()).append("Error getting suppressed info, status: ").append(j).toString());
                }
_L20:
                if (obj != null)
                {
                    ((HttpURLConnection) (obj)).disconnect();
                }
                if (inputstream != null)
                {
                    try
                    {
                        inputstream.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj) { }
                }
                if (obj2 == null) goto _L1; else goto _L7
_L7:
                try
                {
                    ((ByteArrayOutputStream) (obj2)).close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return;
                }
_L6:
                obj7 = new JSONArray(((String) (obj6)));
                arraylist1 = new ArrayList(((JSONArray) (obj7)).length());
                j = 0;
_L31:
                k = ((JSONArray) (obj7)).length();
                if (j >= k) goto _L9; else goto _L8
_L8:
                obj4 = ((JSONArray) (obj7)).getJSONArray(j);
                if (((JSONArray) (obj4)).length() != 2) goto _L11; else goto _L10
_L10:
                if (!"*".equals(((JSONArray) (obj4)).getString(0))) goto _L13; else goto _L12
_L12:
                abyte0 = null;
_L16:
                if (!"*".equals(((JSONArray) (obj4)).getString(1))) goto _L15; else goto _L14
_L14:
                obj4 = null;
_L17:
                arraylist1.add(new a(abyte0, ((String) (obj4))));
                break MISSING_BLOCK_LABEL_897;
_L13:
                abyte0 = aho.a.valueOf(((JSONArray) (obj4)).getString(0).toUpperCase().trim());
                  goto _L16
_L15:
                obj4 = ((JSONArray) (obj4)).getString(1).trim();
                  goto _L17
_L11:
                if (ahk.a().a)
                {
                    Log.e(android/support/v7/aho.getSimpleName(), (new StringBuilder()).append("Invalid suppress item: ").append(obj4).toString());
                }
                break MISSING_BLOCK_LABEL_897;
                  goto _L16
                abyte0;
                try
                {
                    if (ahk.a().a)
                    {
                        Log.e(android/support/v7/aho.getSimpleName(), (new StringBuilder()).append("Error parsing suppress response: ").append(((String) (obj6))).toString(), abyte0);
                    }
                    break MISSING_BLOCK_LABEL_897;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj3)
                {
                    abyte0 = ((byte []) (obj));
                    obj = obj2;
                    obj2 = obj3;
                }
                finally
                {
                    abyte0 = ((byte []) (obj));
                    obj = obj4;
                }
                  goto _L18
_L30:
                if (abyte0 != null)
                {
                    abyte0.disconnect();
                }
                if (inputstream != null)
                {
                    try
                    {
                        inputstream.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[]) { }
                }
                if (obj2 != null)
                {
                    try
                    {
                        ((ByteArrayOutputStream) (obj2)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (byte abyte0[]) { }
                }
                throw obj;
_L9:
                ahr.a(a, arraylist1);
                abyte0 = aho.a().d();
                if (abyte0 == null) goto _L20; else goto _L19
_L19:
                obj6 = abyte0.getSharedPreferences("nanTrackingPrefs", 0).edit();
                obj7 = ahr.a(a).iterator();
_L27:
                if (!((Iterator) (obj7)).hasNext()) goto _L22; else goto _L21
_L21:
                obj4 = (a)((Iterator) (obj7)).next();
                if (a.a(((a) (obj4))) != null) goto _L24; else goto _L23
_L23:
                abyte0 = "*";
_L28:
                if (a.b(((a) (obj4))) != null) goto _L26; else goto _L25
_L25:
                obj4 = "*";
_L29:
                ((android.content.SharedPreferences.Editor) (obj6)).putString(abyte0, ((String) (obj4)));
                  goto _L27
_L24:
                abyte0 = a.a(((a) (obj4))).name();
                  goto _L28
_L26:
                obj4 = a.b(((a) (obj4)));
                  goto _L29
_L22:
                ((android.content.SharedPreferences.Editor) (obj6)).commit();
                  goto _L20
                obj;
                Object obj5 = null;
                inputstream = null;
                abyte0 = ((byte []) (obj2));
                obj2 = obj5;
                  goto _L30
                obj5;
                obj2 = null;
                inputstream = null;
                abyte0 = ((byte []) (obj));
                obj = obj5;
                  goto _L30
                obj5;
                obj2 = null;
                abyte0 = ((byte []) (obj));
                obj = obj5;
                  goto _L30
                obj5;
                obj2 = obj;
                obj = obj5;
                  goto _L30
                obj2;
                obj = null;
                abyte0 = null;
                  goto _L18
                obj2;
                abyte0 = ((byte []) (obj));
                obj = null;
                  goto _L18
                obj2;
                abyte0 = ((byte []) (obj));
                obj = null;
                  goto _L18
                j++;
                  goto _L31
            }

            
            {
                a = ahr.this;
                super();
            }
        }, 0L, 900L, TimeUnit.SECONDS);
        return;
_L4:
        if (!context.equals("*"))
        {
            break MISSING_BLOCK_LABEL_189;
        }
        context = null;
_L6:
        s = s1;
        if (s1.equals("*"))
        {
            s = null;
        }
        arraylist.add(new a(context, s));
        i++;
          goto _L5
        context = aho.a.valueOf(context);
          goto _L6
    }

    public boolean a(ahm ahm1)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            if ((a.a(a1) == null || ahm1.e == a.a(a1)) && (aho.b(ahm1.d) || a.b(a1) == null || a.b(a1).equalsIgnoreCase(ahm1.d)))
            {
                ahk.a().b((new StringBuilder()).append("Event has been suppressed, type: ").append(ahm1.e).append(", name: ").append(ahm1.d).toString(), null);
                return true;
            }
        }

        return false;
    }

    public void b()
    {
        if (c != null)
        {
            c.shutdownNow();
        }
_L1:
        return;
        Throwable throwable;
        throwable;
        if (ahk.a().a)
        {
            Log.w(android/support/v7/aho.getSimpleName(), "Error shutting down suppress manager", throwable);
            return;
        }
          goto _L1
    }

}
