// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, CachedAd, MMSDK, AdCacheThreadPool, 
//            HandShake, MMAdImpl

final class AdCache
{

    static boolean a = true;
    private static Set b;
    private static String c;
    private static boolean d;
    private static Map e;
    private static Set f;
    private static boolean g;
    private static Map h;
    private static boolean i;

    private AdCache()
    {
    }

    static File a()
    {
        File file;
label0:
        {
            file = Environment.getExternalStorageDirectory();
            if (file != null)
            {
                file = new File(file, ".mmsyscache");
                if (file.exists() || file.mkdirs())
                {
                    break label0;
                }
            }
            return null;
        }
        return file;
    }

    static File a(String s)
    {
        File file1 = a();
        File file = null;
        if (file1 != null)
        {
            file = new File(file1, s);
        }
        return file;
    }

    static File a(String s, String s1)
    {
        File file1 = a();
        File file = null;
        if (file1 != null)
        {
            file = new File(file1, (new StringBuilder()).append(s).append(File.separator).append(s1).toString());
        }
        return file;
    }

    static String a(Context context)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (!d)
        {
            HashSet hashset = new HashSet();
            a(context, 2, ((Iterator) (new Iterator(context, hashset) {
            private class Iterator
            {

                void a()
                {
                }

                boolean a(CachedAd cachedad)
                {
                    return false;
                }

                boolean a(String s, Date date, ObjectInputStream objectinputstream)
                {
                    return false;
                }

                Iterator()
                {
                }
            }


                private Context a;
                private Set b;

                final boolean a(CachedAd cachedad)
                {
                    if (cachedad.acid != null && cachedad.getType() == 1 && cachedad.isOnDisk(a))
                    {
                        b.add(cachedad.acid);
                    }
                    return true;
                }

            
            {
                a = context;
                b = set;
                super();
            }
            })));
            b = hashset;
            d = true;
        }
        if (b == null || b.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        context = new StringBuilder();
        iterator = b.iterator();
_L1:
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_150;
            }
            s = (String)iterator.next();
            if (context.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_138;
            }
            context.append((new StringBuilder(",")).append((String)s).toString());
        } while (true);
        context;
        throw context;
        context.append((String)s);
          goto _L1
        c = context.toString();
        context = c;
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return context;
    }

    static void a(Context context, int k, Iterator iterator)
    {
        context = g(context);
        if (context == null) goto _L2; else goto _L1
_L1:
        File afile[] = context.listFiles(new FileFilter() {

            public final boolean accept(File file1)
            {
                return !file1.isDirectory() && file1.getName().endsWith("ad.dat");
            }

        });
        if (afile == null) goto _L2; else goto _L3
_L3:
        Object obj;
        int l;
        int i1;
        i1 = afile.length;
        l = 0;
        obj = null;
_L8:
        if (l >= i1) goto _L2; else goto _L4
_L4:
        File file = afile[l];
        if (file == null) goto _L6; else goto _L5
_L5:
        Object obj1 = obj;
        boolean flag = file.exists();
        if (flag) goto _L7; else goto _L6
_L6:
        context = ((Context) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        ((ObjectInputStream) (obj)).close();
        context = null;
_L9:
        l++;
        obj = context;
          goto _L8
        context;
        MMLog.a("AdCache", "Failed to close", context);
        context = ((Context) (obj));
          goto _L9
_L7:
        if (k != 0) goto _L11; else goto _L10
_L10:
        obj1 = obj;
        file.getName();
        if (obj != null)
        {
            try
            {
                ((ObjectInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MMLog.a("AdCache", "Failed to close", context);
            }
        }
_L2:
        iterator.a();
        return;
_L11:
        obj1 = obj;
        context = new ObjectInputStream(new FileInputStream(file));
        context.readInt();
        obj = (Date)context.readObject();
        context.readObject();
        context.readLong();
        if (k != 1) goto _L13; else goto _L12
_L12:
        if (iterator.a(file.getName(), ((Date) (obj)), context)) goto _L15; else goto _L14
_L14:
        context.close();
          goto _L2
        Exception exception;
        exception;
        obj = context;
_L19:
        obj1 = obj;
        MMLog.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[] {
            file.getName()
        }), exception);
        context = ((Context) (obj));
        if (obj == null) goto _L9; else goto _L16
_L16:
        ((ObjectInputStream) (obj)).close();
        context = null;
          goto _L9
_L13:
        if (iterator.a((CachedAd)context.readObject())) goto _L15; else goto _L17
_L17:
        context.close();
          goto _L2
        iterator;
        obj1 = context;
        context = iterator;
_L18:
        if (obj1 != null)
        {
            try
            {
                ((ObjectInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Iterator iterator)
            {
                MMLog.a("AdCache", "Failed to close", iterator);
            }
        }
        throw context;
_L15:
        context.close();
        context = null;
          goto _L9
        obj;
        MMLog.a("AdCache", "Failed to close", ((Throwable) (obj)));
          goto _L9
        context;
        MMLog.a("AdCache", "Failed to close", context);
        context = ((Context) (obj));
          goto _L9
        context;
          goto _L18
        exception;
          goto _L19
    }

    static void a(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (!d)
        {
            a(context);
        }
        if (b == null)
        {
            b = new HashSet();
        }
        b.add(s);
        c = null;
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void a(Context context, String s, String s1)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!g)
        {
            i(context);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        Map map = e;
        String s2;
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        map.put(s, s2);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        a(((android.content.SharedPreferences.Editor) (context)), s);
        context.putString((new StringBuilder("nextCachedAd_")).append(s).toString(), (String)e.get(s));
        context.commit();
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private static void a(android.content.SharedPreferences.Editor editor, String s)
    {
        int k = s.indexOf('_');
        if (k >= 0 && k < s.length())
        {
            String s1 = s.substring(k + 1);
            if (s1 != null && !f.contains(s1))
            {
                s = null;
                if (!f.isEmpty())
                {
                    Iterator iterator = f.iterator();
                    s = new StringBuilder();
                    for (; iterator.hasNext(); s.append((new StringBuilder()).append((String)iterator.next()).append(MMSDK.c).toString())) { }
                }
                StringBuilder stringbuilder = new StringBuilder();
                if (s == null)
                {
                    s = "";
                } else
                {
                    s = s.toString();
                }
                editor.putString("nextCachedAd_apids", stringbuilder.append(s).append(s1).toString());
                f.add(s1);
            }
        }
    }

    private static void a(SharedPreferences sharedpreferences)
    {
        f = new HashSet();
        sharedpreferences = sharedpreferences.getString("nextCachedAd_apids", null);
        if (sharedpreferences != null)
        {
            sharedpreferences = sharedpreferences.split(MMSDK.c);
            if (sharedpreferences != null && sharedpreferences.length > 0)
            {
                int l = sharedpreferences.length;
                for (int k = 0; k < l; k++)
                {
                    Object obj = sharedpreferences[k];
                    f.add(obj);
                }

            }
        }
    }

    private static void a(File file, long l)
    {
        file = file.listFiles();
        int i1 = file.length;
        int k = 0;
        while (k < i1) 
        {
            File file1 = file[k];
            if (file1.isFile())
            {
                if (System.currentTimeMillis() - file1.lastModified() > l)
                {
                    file1.delete();
                }
            } else
            if (file1.isDirectory())
            {
                try
                {
                    a(file1, l);
                    if (file1.list() != null && file1.list().length == 0)
                    {
                        file1.delete();
                    }
                }
                catch (SecurityException securityexception)
                {
                    MMLog.a("AdCache", "Security Exception cleaning up directory", securityexception);
                }
            }
            k++;
        }
    }

    static boolean a(Context context, CachedAd cachedad)
    {
        Object obj2;
        Object obj3;
        obj3 = null;
        obj2 = null;
        if (cachedad != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        return false;
_L2:
        if ((obj1 = j(context, cachedad.getId())) == null) goto _L1; else goto _L3
_L3:
        MMLog.a("AdCache", String.format("Saving CachedAd %s to %s", new Object[] {
            cachedad.getId(), obj1
        }));
        Object obj = new File(((File) (obj1)).getParent(), (new StringBuilder()).append(cachedad.getId()).append("ad.lock").toString());
        if (((File) (obj)).createNewFile())
        {
            break MISSING_BLOCK_LABEL_133;
        }
        MMLog.a("AdCache", String.format("Could not save the cached ad %s. Ad was locked.", new Object[] {
            cachedad.getId()
        }));
        try
        {
            ((File) (obj)).delete();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("AdCache", "Failed to close", context);
            return false;
        }
        return false;
        obj1 = new ObjectOutputStream(new FileOutputStream(((File) (obj1))));
        ((ObjectOutputStream) (obj1)).writeInt(cachedad.getType());
        ((ObjectOutputStream) (obj1)).writeObject(cachedad.expiration);
        ((ObjectOutputStream) (obj1)).writeObject(cachedad.acid);
        ((ObjectOutputStream) (obj1)).writeLong(cachedad.deferredViewStart);
        ((ObjectOutputStream) (obj1)).writeObject(cachedad);
        try
        {
            ((File) (obj)).delete();
            ((ObjectOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.a("AdCache", "Failed to close", ((Throwable) (obj)));
        }
        if (!cachedad.saveAssets(context))
        {
            cachedad.delete(context);
            return false;
        } else
        {
            return true;
        }
        obj1;
        context = null;
        obj = obj2;
_L7:
        MMLog.a("AdCache", String.format("There was a problem saving the cached ad %s.", new Object[] {
            cachedad.getId()
        }), ((Throwable) (obj1)));
        try
        {
            context.delete();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("AdCache", "Failed to close", context);
            return false;
        }
        if (obj == null) goto _L1; else goto _L4
_L4:
        ((ObjectOutputStream) (obj)).close();
        return false;
        context;
        obj = null;
        cachedad = obj3;
_L6:
        ((File) (obj)).delete();
        if (cachedad != null)
        {
            try
            {
                cachedad.close();
            }
            // Misplaced declaration of an exception variable
            catch (CachedAd cachedad)
            {
                MMLog.a("AdCache", "Failed to close", cachedad);
            }
        }
        throw context;
        context;
        cachedad = obj3;
        continue; /* Loop/switch isn't completed */
        context;
        cachedad = ((CachedAd) (obj1));
        continue; /* Loop/switch isn't completed */
        cachedad;
        obj1 = context;
        context = cachedad;
        cachedad = ((CachedAd) (obj));
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        context = ((Context) (obj));
        obj = obj2;
          goto _L7
        Exception exception;
        exception;
        context = ((Context) (obj1));
        File file = ((File) (obj));
        obj1 = exception;
        obj = context;
        context = file;
          goto _L7
    }

    static boolean a(Context context, String s, CachedAd cachedad, AdCacheTaskListener adcachetasklistener)
    {
        return AdCacheThreadPool.a().a(context, s, cachedad, adcachetasklistener);
    }

    static boolean a(String s, String s1, Context context)
    {
        context = g(context);
        if (context == null || !context.isDirectory())
        {
            return false;
        } else
        {
            return a(s, s1, ((File) (context)));
        }
    }

    private static boolean a(String s, String s1, File file)
    {
        Object obj;
        Object obj1;
        if (TextUtils.isEmpty(s))
        {
            MMLog.b("AdCache", "No Url ...");
            return false;
        }
        File file1 = new File(file, s1);
        MMLog.a("AdCache", String.format("Downloading Component: %s from %s", new Object[] {
            s1, s
        }));
        file = file1.getParentFile();
        if (!file.exists() && !file.mkdirs())
        {
            MMLog.a("AdCache", (new StringBuilder()).append(file).append(" does not exist and cannot create directory.").toString());
            return false;
        }
        if (file1.exists() && file1.length() > 0L)
        {
            MMLog.a("AdCache", (new StringBuilder()).append(s1).append(" already exists, skipping...").toString());
            return true;
        }
        Object obj2 = null;
        obj = null;
        obj1 = null;
        long l = -1L;
        int k;
        long l1;
        try
        {
            s = new URL(s);
            HttpURLConnection.setFollowRedirects(true);
            file = (HttpURLConnection)s.openConnection();
            file.setConnectTimeout(30000);
            file.setRequestMethod("GET");
            file.connect();
            s = file.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            file = obj1;
            s = obj2;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            s = null;
            file = ((File) (obj));
        }
        file = file.getHeaderField("Content-Length");
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        l = Long.parseLong(file);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        MMLog.e("AdCache", String.format("Connection stream is null downloading %s.", new Object[] {
            s1
        }));
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.a("AdCache", "Content caching error downloading component: ", s);
                file1.delete();
                return false;
            }
        }
        return false;
        file = new FileOutputStream(file1);
        obj = new byte[4096];
_L3:
        k = s.read(((byte []) (obj)));
        if (k <= 0) goto _L2; else goto _L1
_L1:
        file.write(((byte []) (obj)), 0, k);
          goto _L3
        obj;
_L9:
        MMLog.e("AdCache", String.format("Exception downloading component %s: %s", new Object[] {
            s1, obj
        }));
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.a("AdCache", "Content caching error downloading component: ", s);
                file1.delete();
                return false;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        file.close();
_L4:
        file1.delete();
        return false;
_L2:
        l1 = file1.length();
        if (l1 != l && l != -1L)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        s.close();
        file.close();
        return true;
        s;
        MMLog.a("AdCache", "Content caching error downloading component: ", s);
        file1.delete();
        return false;
        MMLog.e("AdCache", "Content-Length does not match actual length.");
_L5:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        s.close();
        file.close();
          goto _L4
        s;
        MMLog.a("AdCache", "Content caching error downloading component: ", s);
        file1.delete();
        return false;
        obj;
        MMLog.a("AdCache", String.format("Exception downloading component %s: ", new Object[] {
            s1
        }), ((Throwable) (obj)));
          goto _L5
        s1;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.a("AdCache", "Content caching error downloading component: ", s);
                file1.delete();
                return false;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_494;
        }
        file.close();
        throw s1;
        s1;
        file = ((File) (obj));
        continue; /* Loop/switch isn't completed */
        s1;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        file = obj1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static boolean a(String s, String s1, String s2)
    {
        File file = a();
        if (file == null || !file.isDirectory())
        {
            return false;
        } else
        {
            return a(s, s2, new File(file, s1));
        }
    }

    static void b(Context context)
    {
        Utils.ThreadUtils.a(new Runnable(context) {

            private Context a;

            public final void run()
            {
                MMLog.b("AdCache", "AdCache");
                AdCache.c(a);
                AdCache.d(a);
            }

            
            {
                a = context;
                super();
            }
        });
    }

    static void b(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (!d)
        {
            a(context);
        }
        if (b != null)
        {
            b.remove(s);
            c = null;
        }
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void b(Context context, String s, String s1)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!i)
        {
            j(context);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Map map = h;
        String s2;
        s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        map.put(s, s2);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        a(context, s);
        context.putString((new StringBuilder("incompleteDownload_")).append(s).toString(), (String)h.get(s));
        context.commit();
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static boolean b()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    static boolean b(String s, String s1)
    {
        File file = a();
        if (file == null || !file.isDirectory())
        {
            return false;
        } else
        {
            return a(s, s1, file);
        }
    }

    static CachedAd c(Context context, String s)
    {
        s = i(context, s);
        if (s == null || s.equals(""))
        {
            return null;
        } else
        {
            return g(context, s);
        }
    }

    static void c(Context context)
    {
        a(context, 1, new Iterator() {

            final boolean a(String s, Date date, ObjectInputStream objectinputstream)
            {
                if (date != null && date.getTime() <= System.currentTimeMillis())
                {
                    try
                    {
                        MMLog.e("AdCache", String.format("Deleting expired ad %s.", new Object[] {
                            ((CachedAd)objectinputstream.readObject()).getId()
                        }));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Date date)
                    {
                        MMLog.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[] {
                            s
                        }), date);
                        return true;
                    }
                }
                return true;
            }

        });
    }

    static String d(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!i)
        {
            j(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = (String)h.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    static void d(Context context)
    {
        File file = g(context);
        if (file != null && file.exists() && file.isDirectory())
        {
            a(file, HandShake.a(context).c);
        }
        if (h(context))
        {
            File file1 = a();
            if (file1 != null && file1.exists() && file1.isDirectory())
            {
                a(file1, HandShake.a(context).c);
            }
        }
    }

    static CachedAd e(Context context, String s)
    {
        s = d(context, s);
        if (s == null)
        {
            return null;
        } else
        {
            return g(context, s);
        }
    }

    static void e(Context context)
    {
        a(context, 2, new Iterator(context) {

            private Context a;

            final boolean a(CachedAd cachedad)
            {
                MMLog.b("AdCache", String.format("Deleting ad %s.", new Object[] {
                    cachedad.getId()
                }));
                cachedad.delete(a);
                return true;
            }

            
            {
                a = context;
                super();
            }
        });
        b = null;
        c = null;
        d = false;
        if (e != null)
        {
            for (Iterator iterator = e.keySet().iterator(); iterator.hasNext(); a(context, (String)iterator.next(), ((String) (null)))) { }
        }
        if (h != null)
        {
            for (Iterator iterator1 = h.keySet().iterator(); iterator1.hasNext(); b(context, (String)iterator1.next(), null)) { }
        }
    }

    static File f(Context context)
    {
        if (h(context))
        {
            return a();
        } else
        {
            return g(context);
        }
    }

    static boolean f(Context context, String s)
    {
        context = a(s);
        return context != null && context.exists();
    }

    static CachedAd g(Context context, String s)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((context = j(context, s)) == null) goto _L1; else goto _L3
_L3:
        ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream(context));
        context = objectinputstream;
        objectinputstream.readInt();
        context = objectinputstream;
        objectinputstream.readObject();
        context = objectinputstream;
        objectinputstream.readObject();
        context = objectinputstream;
        objectinputstream.readLong();
        context = objectinputstream;
        CachedAd cachedad = (CachedAd)objectinputstream.readObject();
        objectinputstream.close();
        context = cachedad;
_L4:
        return context;
        context;
        MMLog.a("AdCache", "Failed to close", context);
        context = cachedad;
          goto _L4
        Object obj;
        obj;
        objectinputstream = null;
_L8:
        context = objectinputstream;
        MMLog.a("AdCache", (new StringBuilder("There was a problem loading up the cached ad ")).append(s).append(". Ad is not on disk.").toString(), ((Throwable) (obj)));
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        objectinputstream.close();
        context = null;
          goto _L4
        context;
        MMLog.a("AdCache", "Failed to close", context);
        context = null;
          goto _L4
        obj;
        objectinputstream = null;
_L7:
        context = objectinputstream;
        MMLog.a("AdCache", String.format("There was a problem loading up the cached ad %s.", new Object[] {
            s
        }), ((Throwable) (obj)));
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        objectinputstream.close();
        context = null;
          goto _L4
        context;
        MMLog.a("AdCache", "Failed to close", context);
        context = null;
          goto _L4
        s;
        context = null;
_L6:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MMLog.a("AdCache", "Failed to close", context);
            }
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
          goto _L7
        obj;
          goto _L8
    }

    static File g(Context context)
    {
        if (context != null)
        {
            if ((context = new File(context.getFilesDir(), ".mmsyscache")).exists() || context.mkdirs())
            {
                return context;
            }
        }
        return null;
    }

    static boolean h(Context context)
    {
        if (context != null)
        {
            String s = Environment.getExternalStorageState();
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && !TextUtils.isEmpty(s) && s.equals("mounted") && a)
            {
                return true;
            }
        }
        return false;
    }

    static boolean h(Context context, String s)
    {
        context = j(context, s);
        if (context != null)
        {
            return context.delete();
        } else
        {
            return false;
        }
    }

    private static String i(Context context, String s)
    {
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorenter ;
        if (!g)
        {
            i(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/millennialmedia/android/AdCache;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = (String)e.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    private static void i(Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0);
        e = new ConcurrentHashMap();
        if (f == null)
        {
            a(context);
        }
        for (Iterator iterator = f.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String as[] = MMAdImpl.k();
            int k = 0;
            while (k < 2) 
            {
                String s1 = as[k];
                String s2 = context.getString((new StringBuilder("nextCachedAd_")).append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    e.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                k++;
            }
        }

        g = true;
    }

    private static File j(Context context, String s)
    {
        String s1;
        boolean flag;
        s1 = (new StringBuilder()).append(s).append("ad.dat").toString();
        flag = h(context);
        s = g(context);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.isDirectory()) goto _L2; else goto _L3
_L3:
        s = new File(s, s1);
_L5:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (s.exists())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        try
        {
            context = context.getFilesDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("AdCache", "getCachedAdFile: ", context);
            return null;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        context = new File(context, (new StringBuilder(".mmsyscache")).append(File.separator).append(s1).toString());
        if (!context.exists())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        flag = context.isFile();
        if (flag)
        {
            return context;
        }
        return s;
_L2:
        s = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void j(Context context)
    {
        context = context.getSharedPreferences("MillennialMediaSettings", 0);
        h = new ConcurrentHashMap();
        if (f == null)
        {
            a(context);
        }
        for (Iterator iterator = f.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String as[] = MMAdImpl.k();
            int k = 0;
            while (k < 2) 
            {
                String s1 = as[k];
                String s2 = context.getString((new StringBuilder("incompleteDownload_")).append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    h.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                k++;
            }
        }

        i = true;
    }

}
