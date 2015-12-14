// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class gm
{

    static gm a = new gm();
    public static String b = "proedit_processed_index";
    public int c;
    private String d;
    private Semaphore e;
    private Bitmap f;
    private File g;
    private String h;
    private String i;
    private int j;
    private int k;
    private go l;
    private boolean m;

    private gm()
    {
        d = "ProEidtImageKeeper";
        e = new Semaphore(1);
        h = "proedit_src_img";
        i = "proedit_origin_img";
        c = -1;
        j = -1;
        k = 0;
        m = false;
        Log.e("imagekeep", "ProEidtImageKeeper create");
        g = l();
        if (!g.exists())
        {
            g.mkdir();
        }
    }

    static int a(gm gm1, int i1)
    {
        gm1.j = i1;
        return i1;
    }

    static Bitmap a(gm gm1, Bitmap bitmap)
    {
        gm1.f = bitmap;
        return bitmap;
    }

    static go a(gm gm1, go go)
    {
        gm1.l = go;
        return go;
    }

    static String a(gm gm1)
    {
        return gm1.d;
    }

    static String a(gm gm1, String s, Bitmap bitmap)
    {
        return gm1.a(s, bitmap);
    }

    public static String a(String s)
    {
        return (new StringBuilder()).append(e()).append("/").append(s).toString();
    }

    private String a(String s, Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return "";
        }
        s = (new StringBuilder()).append(e()).append("/").append(s).toString();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream);
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        Log.v("Imagekeeper", (new StringBuilder()).append(s).append(" has write successfully").toString());
        return s;
    }

    static int b(gm gm1, int i1)
    {
        gm1.k = i1;
        return i1;
    }

    static go b(gm gm1)
    {
        return gm1.l;
    }

    private Bitmap c(String s)
    {
        s = (new StringBuilder()).append(e()).append("/").append(s).toString();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        return BitmapFactory.decodeFile(s, options);
    }

    public static gm c()
    {
        return a;
    }

    static boolean c(gm gm1)
    {
        return gm1.m;
    }

    static String d(gm gm1)
    {
        return gm1.h;
    }

    static Bitmap e(gm gm1)
    {
        return gm1.f;
    }

    public static String e()
    {
        return l().getAbsolutePath();
    }

    static int f(gm gm1)
    {
        return gm1.j;
    }

    static int g(gm gm1)
    {
        return gm1.k;
    }

    static String h(gm gm1)
    {
        return gm1.i;
    }

    private static File l()
    {
        File file1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
        File file = file1;
        if (!file1.exists())
        {
            file = file1;
            if (!file1.mkdir())
            {
                file = PIPCameraApplication.b().getDir("tmp", 0);
            }
        }
        return file;
    }

    public List a(int i1, int j1)
    {
        ArrayList arraylist = new ArrayList();
        Log.e("imagekeep", (new StringBuilder()).append("filesToBitmaps:").append(c).toString());
        int k1 = 0;
        while (k1 < i1) 
        {
            if (k1 == j1)
            {
                arraylist.add(k());
            } else
            {
                arraylist.add(c((new StringBuilder()).append(b).append(k1).toString()));
            }
            k1++;
        }
        return arraylist;
    }

    public void a()
    {
        try
        {
            e.acquire();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Crashlytics.logException(interruptedexception);
            interruptedexception.printStackTrace();
            return;
        }
    }

    public void a(Bitmap bitmap, gp gp)
    {
        f = bitmap;
        gn gn1 = new gn(this);
        gn1.a(i);
        gn1.a(gp);
        gn1.d(new Bitmap[] {
            bitmap
        });
    }

    public void a(go go, Bitmap bitmap, Activity activity)
    {
        l = go;
        (new Thread(new Runnable(bitmap, activity) {

            final Bitmap a;
            final Activity b;
            final gm c;

            public void run()
            {
                c.a();
                Log.e(gm.a(c), "saveDisplayBitmap lock");
                gm.a(c, a);
                b.runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        gm.b(a.c).a();
                        gm.a(a.c, null);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                if (gm.c(c)) goto _L2; else goto _L1
_L1:
                gm gm1 = c;
                gm1.c = gm1.c + 1;
                gm.a(c, c.c);
                gm.a(c, (new StringBuilder()).append(gm.d(c)).append(String.valueOf(c.c)).toString(), gm.e(c));
                if (gm.f(c) - gm.g(c) < 6) goto _L2; else goto _L3
_L3:
                int i1;
                int j1;
                j1 = gm.f(c) - 6;
                i1 = gm.g(c);
_L9:
                if (i1 >= j1) goto _L5; else goto _L4
_L4:
                File file = new File(gm.a((new StringBuilder()).append(gm.d(c)).append(String.valueOf(i1)).toString()));
                if (file == null) goto _L7; else goto _L6
_L6:
                if (file.exists())
                {
                    file.delete();
                }
                  goto _L7
_L5:
                try
                {
                    gm.b(c, j1 + 1);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
_L2:
                c.b();
                Log.e(gm.a(c), "saveDisplayBitmap unlock");
                return;
_L7:
                i1++;
                if (true) goto _L9; else goto _L8
_L8:
            }

            
            {
                c = gm.this;
                a = bitmap;
                b = activity;
                super();
            }
        })).start();
    }

    public void a(gp gp)
    {
        (new Thread(new Runnable(gp) {

            final gp a;
            final gm b;

            public void run()
            {
                b.a();
                String s = gm.a((new StringBuilder()).append(gm.d(b)).append(String.valueOf(b.c)).toString());
                if ((new File(s)).exists() && b.c >= 0)
                {
                    a.a(s);
                    b.b();
                    return;
                }
                Log.e("imagekeep", "getDisplayProcessedBitmap origin");
                s = (new StringBuilder()).append(gm.e()).append("/").append(gm.h(b)).toString();
                if ((new File(s)).exists())
                {
                    a.a(s);
                    b.b();
                    return;
                } else
                {
                    a.a(null);
                    b.b();
                    return;
                }
            }

            
            {
                b = gm.this;
                a = gp1;
                super();
            }
        })).start();
    }

    public boolean a(Bitmap bitmap)
    {
        f = bitmap;
        Log.e("imagekeep", (new StringBuilder()).append("setDisplayProcessedBitmap:").append(c).toString());
        c = c + 1;
        j = c;
        a((new StringBuilder()).append(h).append(String.valueOf(c)).toString(), bitmap);
        if (j - k < 5) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        j1 = j - 5;
        i1 = k;
_L8:
        if (i1 >= j1) goto _L4; else goto _L3
_L3:
        try
        {
            bitmap = new File(a((new StringBuilder()).append(h).append(String.valueOf(i1)).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return false;
        }
        if (bitmap == null) goto _L6; else goto _L5
_L5:
        if (bitmap.exists())
        {
            bitmap.delete();
        }
          goto _L6
_L4:
        k = j1 + 1;
_L2:
        return true;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean a(List list)
    {
        int i1;
        try
        {
            Log.e("imagekeep", (new StringBuilder()).append("bitmapsToFiles:").append(c).toString());
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list.printStackTrace();
            return false;
        }
        i1 = 0;
        if (i1 >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        a((new StringBuilder()).append(b).append(i1).toString(), (Bitmap)list.get(i1));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_31;
_L1:
        return true;
    }

    public int b(String s)
    {
        return PIPCameraApplication.b().c().getSharedPreferences("lightPenconfig", 0).getInt(s, -1);
    }

    public void b()
    {
        try
        {
            e.release();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }

    public Bitmap d()
    {
        return f;
    }

    public boolean f()
    {
        return c < j;
    }

    public boolean g()
    {
        return c >= k;
    }

    public void h()
    {
        for (int i1 = 0; i1 < b("imageCounts"); i1++)
        {
            File file = new File(a((new StringBuilder()).append("processedIndex").append(i1).toString()));
            if (file.exists())
            {
                Log.v("Imagekeeper", (new StringBuilder()).append(file.getName()).append(" has successfully delete...").toString());
                file.delete();
            }
        }

    }

    public void i()
    {
        Log.e("imagekeep", "clear");
        for (int i1 = 0; i1 < j; i1++)
        {
            File file = new File(a((new StringBuilder()).append(h).append(String.valueOf(i1)).toString()));
            if (file != null && file.exists())
            {
                file.delete();
            }
        }

        m = false;
        j = -1;
        c = -1;
        k = 0;
        File file1 = new File(a(i));
        if (file1.exists())
        {
            file1.delete();
        }
        h();
    }

    public void j()
    {
        (new Thread(new Runnable() {

            final gm a;

            public void run()
            {
                a.a();
                if (gm.e(a) != null && !gm.e(a).isRecycled())
                {
                    gm.a(a, null);
                }
                a.b();
            }

            
            {
                a = gm.this;
                super();
            }
        })).start();
    }

    public Bitmap k()
    {
        if (c == j && f != null && !f.isRecycled())
        {
            return f;
        }
        Log.e("imagekeep", (new StringBuilder()).append("getDisplayProcessedBitmap:").append(c).toString());
        if ((new File(a((new StringBuilder()).append(h).append(String.valueOf(c)).toString()))).exists() && c >= 0)
        {
            return c((new StringBuilder()).append(h).append(String.valueOf(c)).toString());
        } else
        {
            Log.e("imagekeep", "getDisplayProcessedBitmap origin");
            return c(i);
        }
    }

}
