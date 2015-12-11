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
//            al, r, an, b, 
//            v, ab

final class com.millennialmedia.android.a
{
    static interface a
    {

        public abstract void a();

        public abstract void a(r r1, boolean flag);
    }

    static class b
    {

        void a()
        {
        }

        boolean a(r r1)
        {
            return false;
        }

        boolean a(String s, Date date, ObjectInputStream objectinputstream)
        {
            return false;
        }

        b()
        {
        }
    }


    static boolean a = true;
    private static Set b;
    private static String c;
    private static boolean d;
    private static Map e;
    private static Set f;
    private static boolean g;
    private static Map h;
    private static boolean i;

    static File a(Boolean boolean1)
    {
        File file = Environment.getExternalStorageDirectory();
        if (file != null)
        {
            String s = ".mmsyscache";
            if (boolean1.booleanValue())
            {
                s = "mmsyscache";
            }
            boolean1 = new File(file, s);
            if (!boolean1.exists() && !boolean1.mkdirs())
            {
                return null;
            } else
            {
                return boolean1;
            }
        } else
        {
            return null;
        }
    }

    static File a(String s)
    {
        File file1 = a(Boolean.valueOf(false));
        File file = null;
        if (file1 != null)
        {
            file = new File(file1, s);
        }
        return file;
    }

    static File a(String s, String s1, Boolean boolean1)
    {
        File file = a(boolean1);
        boolean1 = null;
        if (file != null)
        {
            boolean1 = new File(file, (new StringBuilder()).append(s).append(File.separator).append(s1).toString());
        }
        return boolean1;
    }

    static String a(Context context)
    {
        com/millennialmedia/android/a;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (!d)
        {
            HashSet hashset = new HashSet();
            a(context, 2, ((b) (new b(context, hashset) {

                final Context a;
                final Set b;

                final boolean a(r r1)
                {
                    if (r1.b != null && r1.c() == 1 && r1.c(a))
                    {
                        b.add(r1.b);
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
        com/millennialmedia/android/a;
        JVM INSTR monitorexit ;
        return context;
    }

    static void a(Context context, int j, b b1)
    {
        context = f(context);
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
        int k;
        int l;
        l = afile.length;
        k = 0;
        obj = null;
_L8:
        if (k >= l) goto _L2; else goto _L4
_L4:
        File file = afile[k];
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
        k++;
        obj = context;
          goto _L8
        context;
        al.a("AdCache", "Failed to close", context);
        context = ((Context) (obj));
          goto _L9
_L7:
        if (j != 0) goto _L11; else goto _L10
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
                al.a("AdCache", "Failed to close", context);
            }
        }
_L2:
        b1.a();
        return;
_L11:
        obj1 = obj;
        context = new ObjectInputStream(new FileInputStream(file));
        context.readInt();
        obj = (Date)context.readObject();
        context.readObject();
        context.readLong();
        if (j != 1) goto _L13; else goto _L12
_L12:
        if (b1.a(file.getName(), ((Date) (obj)), context)) goto _L15; else goto _L14
_L14:
        context.close();
          goto _L2
        Exception exception;
        exception;
        obj = context;
_L19:
        obj1 = obj;
        al.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[] {
            file.getName()
        }), exception);
        context = ((Context) (obj));
        if (obj == null) goto _L9; else goto _L16
_L16:
        ((ObjectInputStream) (obj)).close();
        context = null;
          goto _L9
_L13:
        if (b1.a((r)context.readObject())) goto _L15; else goto _L17
_L17:
        context.close();
          goto _L2
        b1;
        obj1 = context;
        context = b1;
_L18:
        if (obj1 != null)
        {
            try
            {
                ((ObjectInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (b b1)
            {
                al.a("AdCache", "Failed to close", b1);
            }
        }
        throw context;
_L15:
        context.close();
        context = null;
          goto _L9
        obj;
        al.a("AdCache", "Failed to close", ((Throwable) (obj)));
          goto _L9
        context;
        al.a("AdCache", "Failed to close", context);
        context = ((Context) (obj));
          goto _L9
        context;
          goto _L18
        exception;
          goto _L19
    }

    static void a(Context context, String s)
    {
        com/millennialmedia/android/a;
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
        com/millennialmedia/android/a;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void a(Context context, String s, String s1)
    {
        com/millennialmedia/android/a;
        JVM INSTR monitorenter ;
        if (!g)
        {
            h(context);
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
        com/millennialmedia/android/a;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private static void a(android.content.SharedPreferences.Editor editor, String s)
    {
        int j = s.indexOf('_');
        if (j >= 0 && j < s.length())
        {
            String s1 = s.substring(j + 1);
            if (s1 != null && !f.contains(s1))
            {
                s = null;
                if (!f.isEmpty())
                {
                    Iterator iterator = f.iterator();
                    s = new StringBuilder();
                    for (; iterator.hasNext(); s.append((new StringBuilder()).append((String)iterator.next()).append(an.c).toString())) { }
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
            sharedpreferences = sharedpreferences.split(an.c);
            if (sharedpreferences != null && sharedpreferences.length > 0)
            {
                int k = sharedpreferences.length;
                for (int j = 0; j < k; j++)
                {
                    Object obj = sharedpreferences[j];
                    f.add(obj);
                }

            }
        }
    }

    private static void a(File file, long l)
    {
        file = file.listFiles();
        int k = file.length;
        int j = 0;
        while (j < k) 
        {
            File file1 = file[j];
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
                    al.a("AdCache", "Security Exception cleaning up directory", securityexception);
                }
            }
            j++;
        }
    }

    static boolean a()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    static boolean a(Context context, r r1)
    {
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        if (r1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((context = i(context, r1.a)) == null) goto _L1; else goto _L3
_L3:
        String.format("Saving CachedAd %s to %s", new Object[] {
            r1.a, context
        });
        al.a();
        Object obj = new File(context.getParent(), (new StringBuilder()).append(r1.a).append("ad.lock").toString());
        if (((File) (obj)).createNewFile())
        {
            break MISSING_BLOCK_LABEL_130;
        }
        String.format("Could not save the cached ad %s. Ad was locked.", new Object[] {
            r1.a
        });
        al.a();
        try
        {
            ((File) (obj)).delete();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("AdCache", "Failed to close", context);
            return false;
        }
        return false;
        context = new ObjectOutputStream(new FileOutputStream(context));
        context.writeInt(r1.c());
        context.writeObject(r1.c);
        context.writeObject(r1.b);
        context.writeLong(r1.d);
        context.writeObject(r1);
        try
        {
            ((File) (obj)).delete();
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("AdCache", "Failed to close", context);
        }
        return true;
        obj1;
        context = null;
        obj = obj2;
_L7:
        al.a("AdCache", String.format("There was a problem saving the cached ad %s.", new Object[] {
            r1.a
        }), ((Throwable) (obj1)));
        try
        {
            context.delete();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("AdCache", "Failed to close", context);
            return false;
        }
        if (obj == null) goto _L1; else goto _L4
_L4:
        ((ObjectOutputStream) (obj)).close();
        return false;
        context;
        obj = null;
        r1 = ((r) (obj1));
_L6:
        ((File) (obj)).delete();
        if (r1 != null)
        {
            try
            {
                r1.close();
            }
            // Misplaced declaration of an exception variable
            catch (r r1)
            {
                al.a("AdCache", "Failed to close", r1);
            }
        }
        throw context;
        context;
        r1 = ((r) (obj1));
        continue; /* Loop/switch isn't completed */
        obj1;
        r1 = context;
        context = ((Context) (obj1));
        continue; /* Loop/switch isn't completed */
        r1;
        obj1 = context;
        context = r1;
        r1 = ((r) (obj));
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        context = ((Context) (obj));
        obj = obj2;
          goto _L7
        obj1;
        File file = ((File) (obj));
        obj = context;
        context = file;
          goto _L7
    }

    static boolean a(Context context, String s, r r1, a a1)
    {
        return com.millennialmedia.android.b.a().a(context, s, r1, a1);
    }

    static boolean a(String s, String s1)
    {
        File file = a(Boolean.valueOf(false));
        if (file == null || !file.isDirectory())
        {
            return false;
        } else
        {
            return a(s, s1, file);
        }
    }

    static boolean a(String s, String s1, Context context)
    {
        context = f(context);
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
        obj = null;
        Exception exception = null;
        if (TextUtils.isEmpty(s))
        {
            al.b();
            return false;
        }
        File file1 = new File(file, s1);
        String.format("Downloading Component: %s from %s", new Object[] {
            s1, s
        });
        al.a();
        file = file1.getParentFile();
        if (!file.exists() && !file.mkdirs())
        {
            (new StringBuilder()).append(file).append(" does not exist and cannot create directory.");
            al.a();
            return false;
        }
        if (file1.exists() && file1.length() > 0L)
        {
            (new StringBuilder()).append(s1).append(" already exists, skipping...");
            al.a();
            return true;
        }
        int j;
        long l;
        try
        {
            s = new URL(s);
            HttpURLConnection.setFollowRedirects(true);
            s = (HttpURLConnection)s.openConnection();
            s.setConnectTimeout(30000);
            s.setRequestMethod("GET");
            s.connect();
            s = s.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s = null;
            file = exception;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            s = null;
            file = ((File) (obj));
            continue; /* Loop/switch isn't completed */
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        al.a("AdCache", String.format("Connection stream is null downloading %s.", new Object[] {
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
                al.a("AdCache", "Content caching error downloading component: ", s);
                file1.delete();
                return false;
            }
        }
        return false;
        file = new FileOutputStream(file1);
        obj = new byte[4096];
_L3:
        j = s.read(((byte []) (obj)));
        if (j <= 0) goto _L2; else goto _L1
_L1:
        file.write(((byte []) (obj)), 0, j);
          goto _L3
        exception;
        obj = file;
        file = s;
        s = ((String) (obj));
        obj = exception;
_L9:
        al.a("AdCache", String.format("Exception downloading component %s: %s", new Object[] {
            s1, obj
        }));
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                al.a("AdCache", "Content caching error downloading component: ", s);
                file1.delete();
                return false;
            }
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        s.close();
_L4:
        file1.delete();
        return false;
_L2:
        l = file1.length();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        s.close();
        file.close();
        return true;
        s;
        al.a("AdCache", "Content caching error downloading component: ", s);
        file1.delete();
        return false;
        al.a("AdCache", "Downloaded file has zero length.");
_L5:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        s.close();
        file.close();
          goto _L4
        s;
        al.a("AdCache", "Content caching error downloading component: ", s);
        file1.delete();
        return false;
        obj;
        al.a("AdCache", String.format("Exception downloading component %s: ", new Object[] {
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
                al.a("AdCache", "Content caching error downloading component: ", s);
                file1.delete();
                return false;
            }
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        file.close();
        throw s1;
        s1;
        file = ((File) (obj));
        continue; /* Loop/switch isn't completed */
        s1;
        obj = file;
        file = s;
        s = ((String) (obj));
        if (true) goto _L7; else goto _L6
        obj;
        Object obj1 = null;
        file = s;
        s = obj1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static boolean a(String s, String s1, String s2)
    {
        File file = a(Boolean.valueOf(true));
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
        au.c.a(new Runnable(context) {

            final Context a;

            public final void run()
            {
                al.b();
                com.millennialmedia.android.a.c(a);
                com.millennialmedia.android.a.d(a);
            }

            
            {
                a = context;
                super();
            }
        });
    }

    static void b(Context context, String s)
    {
        com/millennialmedia/android/a;
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
        com/millennialmedia/android/a;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void b(Context context, String s, String s1)
    {
        com/millennialmedia/android/a;
        JVM INSTR monitorenter ;
        if (!i)
        {
            i(context);
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
        com/millennialmedia/android/a;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static boolean b(String s)
    {
        s = a(s);
        return s != null && s.exists();
    }

    static r c(Context context, String s)
    {
        s = h(context, s);
        if (s == null || s.equals(""))
        {
            return null;
        } else
        {
            return f(context, s);
        }
    }

    static void c(Context context)
    {
        a(context, 1, new b() {

            final boolean a(String s, Date date, ObjectInputStream objectinputstream)
            {
                if (date != null && date.getTime() <= System.currentTimeMillis())
                {
                    try
                    {
                        al.a("AdCache", String.format("Deleting expired ad %s.", new Object[] {
                            ((r)objectinputstream.readObject()).a
                        }));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Date date)
                    {
                        al.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[] {
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
        com/millennialmedia/android/a;
        JVM INSTR monitorenter ;
        if (!i)
        {
            i(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/millennialmedia/android/a;
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
        File file = f(context);
        if (file != null && file.exists() && file.isDirectory())
        {
            a(file, v.a(context).d);
        }
        if (g(context))
        {
            File file1 = a(Boolean.valueOf(false));
            if (file1 != null && file1.exists() && file1.isDirectory())
            {
                a(file1, v.a(context).d);
            }
        }
    }

    static r e(Context context, String s)
    {
        s = d(context, s);
        if (s == null)
        {
            return null;
        } else
        {
            return f(context, s);
        }
    }

    static File e(Context context)
    {
        if (g(context))
        {
            return a(Boolean.valueOf(false));
        } else
        {
            return f(context);
        }
    }

    static r f(Context context, String s)
    {
        if (s != null && !s.equals("")) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((context = i(context, s)) == null) goto _L1; else goto _L3
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
        r r1 = (r)objectinputstream.readObject();
        objectinputstream.close();
        context = r1;
_L4:
        return context;
        context;
        al.a("AdCache", "Failed to close", context);
        context = r1;
          goto _L4
        Object obj;
        obj;
        objectinputstream = null;
_L8:
        context = objectinputstream;
        al.a("AdCache", (new StringBuilder("There was a problem loading up the cached ad ")).append(s).append(". Ad is not on disk.").toString(), ((Throwable) (obj)));
        if (objectinputstream == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        objectinputstream.close();
        context = null;
          goto _L4
        context;
        al.a("AdCache", "Failed to close", context);
        context = null;
          goto _L4
        obj;
        objectinputstream = null;
_L7:
        context = objectinputstream;
        al.a("AdCache", String.format("There was a problem loading up the cached ad %s.", new Object[] {
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
        al.a("AdCache", "Failed to close", context);
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
                al.a("AdCache", "Failed to close", context);
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

    static File f(Context context)
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

    static boolean g(Context context)
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

    static boolean g(Context context, String s)
    {
        context = i(context, s);
        if (context != null)
        {
            return context.delete();
        } else
        {
            return false;
        }
    }

    private static String h(Context context, String s)
    {
        com/millennialmedia/android/a;
        JVM INSTR monitorenter ;
        if (!g)
        {
            h(context);
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/millennialmedia/android/a;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = (String)e.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    private static void h(Context context)
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
            String as[] = ab.l();
            int j = 0;
            while (j < 2) 
            {
                String s1 = as[j];
                String s2 = context.getString((new StringBuilder("nextCachedAd_")).append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    e.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                j++;
            }
        }

        g = true;
    }

    private static File i(Context context, String s)
    {
        String s1;
        boolean flag;
        s1 = (new StringBuilder()).append(s).append("ad.dat").toString();
        flag = g(context);
        s = f(context);
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
            al.a("AdCache", "getCachedAdFile: ", context);
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

    private static void i(Context context)
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
            String as[] = ab.l();
            int j = 0;
            while (j < 2) 
            {
                String s1 = as[j];
                String s2 = context.getString((new StringBuilder("incompleteDownload_")).append(s1).append('_').append(s).toString(), null);
                if (s2 != null)
                {
                    h.put((new StringBuilder()).append(s1).append('_').append(s).toString(), s2);
                }
                j++;
            }
        }

        i = true;
    }

}
