// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import junit.framework.Assert;

// Referenced classes of package com.b.a:
//            e, b, a, d, 
//            c, f, o, k, 
//            i, m

public final class l
{

    static Resources a;
    static DisplayMetrics b;
    private static boolean c = true;
    private static boolean d = false;
    private static e e;
    private static b f;
    private static a g;
    private static d h;
    private static ArrayList i;
    private static c j = com.b.a.c.a();
    private static f k;
    private static HashSet l = new HashSet();
    private static Hashtable m = new Hashtable();
    private static Hashtable n = new Hashtable();

    public static int a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
        int i1 = 0;
        do
        {
            int j1 = inputstream.read(abyte0);
            if (j1 != -1)
            {
                outputstream.write(abyte0, 0, j1);
                i1 += j1;
            } else
            {
                return i1;
            }
        } while (true);
    }

    static Bitmap a(Context context, String s, String s1, int i1, int j1)
    {
        return b(context, s, s1, i1, j1);
    }

    static c a()
    {
        return j;
    }

    public static String a(String s)
    {
        return (new StringBuilder()).append(s.hashCode()).append(".urlimage").toString();
    }

    public static void a(Context context)
    {
        a(context, 0x240c8400L);
    }

    public static void a(Context context, long l1)
    {
        if (!d) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        d = true;
        String as[];
        Object obj;
        int j1;
        try
        {
            as = context.getFilesDir().list();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (as == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = as.length;
        i1 = 0;
_L4:
        if (i1 >= j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = as[i1];
        if (!((String) (obj)).endsWith(".urlimage"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append('/').append(((String) (obj))).toString());
        if (System.currentTimeMillis() > ((File) (obj)).lastModified() + 0x240c8400L)
        {
            ((File) (obj)).delete();
        }
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    private static void a(Context context, ImageView imageview, String s, int i1, long l1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = imageview.getResources().getDrawable(i1);
        } else
        {
            drawable = null;
        }
        a(context, imageview, s, drawable, l1, null);
    }

    private static void a(Context context, ImageView imageview, String s, Drawable drawable, long l1, k k1)
    {
        boolean flag;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("setUrlDrawable and loadUrlDrawable should only be called from the main thread.", flag);
        a(context);
        if (!a(((CharSequence) (s)))) goto _L2; else goto _L1
_L1:
        if (imageview != null)
        {
            m.remove(imageview);
            imageview.setImageDrawable(drawable);
        }
_L4:
        return;
_L2:
        String s1;
        File file;
        int i2;
        int j2;
        if (b == null)
        {
            b(context);
        }
        i2 = b.widthPixels;
        j2 = b.heightPixels;
        s1 = context.getFileStreamPath(a(s)).getAbsolutePath();
        file = new File(s1);
        if (k == null)
        {
            k = new f(c(context) / 8);
        }
        Bitmap bitmap = (Bitmap)k.a(s);
        Object obj;
        Object obj1;
        if (bitmap != null)
        {
            a((new StringBuilder()).append("zombie load: ").append(s).toString(), new Object[0]);
            obj1 = new o(s, a, bitmap);
        } else
        {
            obj1 = (Drawable)j.a(s);
        }
        obj = obj1;
        if (obj1 != null)
        {
            a((new StringBuilder()).append("Cache hit on: ").append(s).toString(), new Object[0]);
            if (file.exists() && !a(file, l1))
            {
                a((new StringBuilder()).append("Cache hit, but file is stale. Forcing reload: ").append(s).toString(), new Object[0]);
                if (obj1 instanceof o)
                {
                    ((o)obj1).a();
                }
                obj = null;
            } else
            {
                a((new StringBuilder()).append("Using cached: ").append(s).toString(), new Object[0]);
                obj = obj1;
            }
        }
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = ((Context) (obj));
        if (imageview != null)
        {
            m.remove(imageview);
            context = ((Context) (obj));
            if (obj instanceof o)
            {
                context = ((o)obj).a(a);
            }
            imageview.setImageDrawable(context);
        }
        if (k1 != null)
        {
            if (!(context instanceof o));
            k1.a(imageview, bitmap, s, true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        a((new StringBuilder()).append("Waiting for ").append(s).append(" ").append(imageview).toString(), new Object[0]);
        if (imageview != null)
        {
            imageview.setImageDrawable(drawable);
            m.put(imageview, s);
        }
        ArrayList arraylist = (ArrayList)n.get(s);
        if (arraylist == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (imageview != null)
        {
            arraylist.add(imageview);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        m m1;
        ArrayList arraylist1 = new ArrayList();
        if (imageview != null)
        {
            arraylist1.add(imageview);
        }
        n.put(s, arraylist1);
        int j1 = i2;
        if (i2 <= 0)
        {
            j1 = 0x7fffffff;
        }
        i2 = j2;
        if (j2 <= 0)
        {
            i2 = 0x7fffffff;
        }
        m1 = new m(s1, context, s, j1, i2) {

            final String a;
            final Context b;
            final String c;
            final int d;
            final int e;

            public void a(i k2, InputStream inputstream, String s2)
            {
                boolean flag1;
                if (inputstream == null || s2 == null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                Assert.assertTrue(flag1);
                if (inputstream != null || s2 != null) goto _L2; else goto _L1
_L1:
                if (k2 != null && !k2.a())
                {
                    (new File(a)).delete();
                }
_L3:
                return;
_L2:
                String s3 = a;
                if (inputstream == null)
                {
                    break MISSING_BLOCK_LABEL_94;
                }
                s2 = new FileOutputStream(a);
                l.a(inputstream, s2);
                s2.close();
                s2 = s3;
                f = l.a(b, c, s2, d, e);
                if (k2 != null && !k2.a())
                {
                    (new File(a)).delete();
                    return;
                }
                  goto _L3
                inputstream;
                (new File(a)).delete();
                if (k2 == null || k2.a()) goto _L3; else goto _L4
_L4:
                (new File(a)).delete();
                return;
                inputstream;
                if (k2 != null && !k2.a())
                {
                    (new File(a)).delete();
                }
                throw inputstream;
            }

            
            {
                a = s;
                b = context;
                c = s1;
                d = i1;
                e = j1;
                super();
            }
        };
        k1 = new Runnable(m1, s, drawable, k1, imageview, arraylist1) {

            final m a;
            final String b;
            final Drawable c;
            final k d;
            final ImageView e;
            final ArrayList f;

            public void run()
            {
                Assert.assertEquals(Looper.myLooper(), Looper.getMainLooper());
                Object obj2 = a.f;
                Iterator iterator1;
                int k2;
                if (obj2 != null)
                {
                    obj2 = new o(b, l.a, ((Bitmap) (obj2)));
                } else
                {
                    obj2 = null;
                }
                if (obj2 == null)
                {
                    l.a((new StringBuilder()).append("No usable result, defaulting ").append(b).toString(), new Object[0]);
                    obj2 = c;
                    l.a().a(b, obj2);
                }
                l.b().remove(b);
                if (d != null && e == null)
                {
                    d.a(null, a.f, b, false);
                }
                iterator1 = f.iterator();
                k2 = 0;
                while (iterator1.hasNext()) 
                {
                    ImageView imageview1 = (ImageView)iterator1.next();
                    String s2 = (String)l.c().get(imageview1);
                    if (!b.equals(s2))
                    {
                        l.a((new StringBuilder()).append("Ignoring out of date request to update view for ").append(b).append(" ").append(s2).append(" ").append(imageview1).toString(), new Object[0]);
                    } else
                    {
                        l.c().remove(imageview1);
                        if (obj2 != null)
                        {
                            imageview1.setImageDrawable(((Drawable) (obj2)));
                        }
                        if (d != null && imageview1 == e)
                        {
                            d.a(imageview1, a.f, b, false);
                        }
                        k2++;
                    }
                }
                l.a((new StringBuilder()).append("Populated: ").append(k2).toString(), new Object[0]);
            }

            
            {
                a = m1;
                b = s;
                c = drawable;
                d = k1;
                e = imageview;
                f = arraylist;
                super();
            }
        };
        if (!file.exists()) goto _L7; else goto _L6
_L6:
        Exception exception;
        if (a(file, l1))
        {
            a((new StringBuilder()).append("File Cache hit on: ").append(s).append(". ").append(System.currentTimeMillis() - file.lastModified()).append("ms old.").toString(), new Object[0]);
            a(((AsyncTask) (new AsyncTask(m1, s1, k1) {

                final m a;
                final String b;
                final Runnable c;

                protected transient Void a(Void avoid[])
                {
                    a.a(null, null, b);
                    return null;
                }

                protected void a(Void void1)
                {
                    c.run();
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj2)
                {
                    a((Void)obj2);
                }

            
            {
                a = m1;
                b = s;
                c = runnable;
                super();
            }
            })));
            return;
        }
          goto _L8
_L7:
        Iterator iterator = i.iterator();
        i i1;
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            i1 = (i)iterator.next();
        } while (!i1.a(s));
        i1.a(context, s, s1, m1, k1);
        return;
_L8:
        try
        {
            a("File cache has expired. Refreshing.", new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        if (true) goto _L7; else goto _L9
_L9:
        imageview.setImageDrawable(drawable);
        return;
    }

    static void a(AsyncTask asynctask)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            asynctask.execute(new Void[0]);
            return;
        } else
        {
            b(asynctask);
            return;
        }
    }

    public static void a(ImageView imageview, String s, int i1)
    {
        a(imageview.getContext(), imageview, s, i1, 0xf731400L);
    }

    static transient void a(String s, Object aobj[])
    {
        if (aobj.length == 0)
        {
            return;
        } else
        {
            String.format(s, aobj);
            return;
        }
    }

    private static boolean a(File file, long l1)
    {
        return l1 == 0x7fffffffL || System.currentTimeMillis() < file.lastModified() + l1;
    }

    private static boolean a(CharSequence charsequence)
    {
        return charsequence == null || charsequence.equals("") || charsequence.equals("null") || charsequence.equals("NULL");
    }

    private static Bitmap b(Context context, String s, String s1, int i1, int j1)
    {
        b(context);
        a((new StringBuilder()).append("Decoding: ").append(s).append(" ").append(s1).toString(), new Object[0]);
        if (!c) goto _L2; else goto _L1
_L1:
        FileInputStream fileinputstream;
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        fileinputstream = new FileInputStream(s1);
        int k1;
        s = fileinputstream;
        context = fileinputstream;
        try
        {
            BitmapFactory.decodeStream(fileinputstream, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
        s = fileinputstream;
        context = fileinputstream;
        fileinputstream.close();
        k1 = 0;
_L7:
        s = fileinputstream;
        context = fileinputstream;
        if (options.outWidth >> k1 > i1)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        s = fileinputstream;
        context = fileinputstream;
        if (options.outHeight >> k1 > j1)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        s = fileinputstream;
        context = fileinputstream;
        options = new android.graphics.BitmapFactory.Options();
        s = fileinputstream;
        context = fileinputstream;
        options.inSampleSize = 1 << k1;
        context = fileinputstream;
_L6:
        s = context;
        s1 = new FileInputStream(s1);
        context = BitmapFactory.decodeStream(s1, null, options);
        a(String.format("Loaded bitmap (%dx%d).", new Object[] {
            Integer.valueOf(context.getWidth()), Integer.valueOf(context.getHeight())
        }), new Object[0]);
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.w("UrlImageViewHelper", "Failed to close FileInputStream", s);
                return context;
            }
        }
        return context;
        context;
        context = null;
_L5:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("UrlImageViewHelper", "Failed to close FileInputStream", context);
            }
        }
        return null;
        context;
        s = null;
_L4:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.w("UrlImageViewHelper", "Failed to close FileInputStream", s);
            }
        }
        throw context;
        context;
        s = s1;
        if (true) goto _L4; else goto _L3
        context;
        context = s1;
        if (true) goto _L5; else goto _L2
_L2:
        options = null;
        context = null;
          goto _L6
        k1++;
          goto _L7
    }

    static Hashtable b()
    {
        return n;
    }

    private static void b(Context context)
    {
        if (b != null)
        {
            return;
        } else
        {
            b = new DisplayMetrics();
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(b);
            a = new Resources(context.getAssets(), b, context.getResources().getConfiguration());
            return;
        }
    }

    private static void b(AsyncTask asynctask)
    {
        asynctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private static int c(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getMemoryClass() * 1024 * 1024;
    }

    static Hashtable c()
    {
        return m;
    }

    static HashSet d()
    {
        return l;
    }

    static f e()
    {
        return k;
    }

    static 
    {
        e = new e();
        f = new b();
        g = new a();
        h = new d();
        i = new ArrayList();
        i.add(e);
        i.add(g);
        i.add(f);
        i.add(h);
    }
}
