// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import com.Test118.NativeView;
import com.crashlytics.android.Crashlytics;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.File;
import java.util.concurrent.Semaphore;

public class uv
{

    static uv b = new uv();
    public int a;
    private int c;
    private int d;
    private uy e;
    private Bitmap f;
    private String g;
    private boolean h;
    private Semaphore i;
    private Semaphore j;
    private String k;

    private uv()
    {
        a = -1;
        c = -1;
        d = 0;
        g = "";
        h = false;
        i = new Semaphore(1);
        j = new Semaphore(2);
        k = "";
        g = a("proedit_origin_img");
    }

    static int a(uv uv1, int l)
    {
        uv1.c = l;
        return l;
    }

    static Bitmap a(uv uv1)
    {
        return uv1.f;
    }

    static Bitmap a(uv uv1, Bitmap bitmap)
    {
        uv1.f = bitmap;
        return bitmap;
    }

    private String a(int l)
    {
        return (new StringBuilder()).append("proedit_src_img").append(String.valueOf(l)).toString();
    }

    static uy a(uv uv1, uy uy)
    {
        uv1.e = uy;
        return uy;
    }

    private void a(String s, Bitmap bitmap)
    {
        if (s == null)
        {
            return;
        }
        try
        {
            NativeView.a(bitmap, s, 100);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
    }

    static void a(uv uv1, String s, Bitmap bitmap)
    {
        uv1.a(s, bitmap);
    }

    private Bitmap b(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            s = BitmapFactory.decodeFile(s, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            s.printStackTrace();
            return null;
        }
        return s;
    }

    private String b(String s, Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return "";
        }
        s = a(s);
        if (s == null)
        {
            return "";
        }
        try
        {
            NativeView.a(bitmap, s, 100);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return "";
        }
        Log.v("MNewImageKeeper", (new StringBuilder()).append(s).append(" has write successfully").toString());
        return s;
    }

    static String b(uv uv1)
    {
        return uv1.g;
    }

    static String b(uv uv1, int l)
    {
        return uv1.a(l);
    }

    static String b(uv uv1, String s, Bitmap bitmap)
    {
        return uv1.b(s, bitmap);
    }

    static int c(uv uv1, int l)
    {
        uv1.d = l;
        return l;
    }

    private Bitmap c(String s)
    {
        s = a(s);
        if (s == null)
        {
            return null;
        } else
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeFile(s, options);
        }
    }

    public static uv c()
    {
        return b;
    }

    static uy c(uv uv1)
    {
        return uv1.e;
    }

    static int d(uv uv1)
    {
        return uv1.c;
    }

    static int e(uv uv1)
    {
        return uv1.d;
    }

    private static File k()
    {
        File file1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.beautyedit/").toString());
        File file = file1;
        if (!file1.exists())
        {
            file = file1;
            if (!file1.mkdir())
            {
                file = InstaBeautyApplication.a().getDir(".beautyedit", 0);
            }
        }
        return file;
    }

    public String a(String s)
    {
        File file = k();
        if (file != null)
        {
            return (new StringBuilder()).append(file.getAbsolutePath()).append("/").append(s).toString();
        } else
        {
            return null;
        }
    }

    public void a()
    {
        try
        {
            i.acquire();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Crashlytics.logException(interruptedexception);
            interruptedexception.printStackTrace();
            return;
        }
    }

    public void a(Bitmap bitmap, String s, boolean flag, uy uy)
    {
        if (f != null)
        {
            return;
        }
        b();
        h = flag;
        if (s != null && s.length() > 0)
        {
            g = s;
        }
        f = bitmap;
        (new Thread(new uw(this, bitmap, flag, uy))).start();
    }

    public void a(Bitmap bitmap, uy uy)
    {
        e = uy;
        (new Thread(new ux(this, bitmap))).start();
    }

    public void b()
    {
        try
        {
            i.release();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }

    public void d()
    {
        int l = 0;
        Object obj;
        String as[];
        if (f != null)
        {
            f = null;
        }
        File file = k();
        obj = file.getAbsolutePath();
        as = file.list();
_L3:
        if (l >= as.length) goto _L2; else goto _L1
_L1:
        Object obj1 = as[l];
        try
        {
            obj1 = new File((new StringBuilder()).append(((String) (obj))).append(File.separator).append(((String) (obj1))).toString());
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        if (((File) (obj1)).exists() && ((File) (obj1)).isFile())
        {
            ((File) (obj1)).delete();
        }
        break MISSING_BLOCK_LABEL_167;
_L2:
        if (h)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = new File(g);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        if (((File) (obj)).exists() && ((File) (obj)).isFile())
        {
            ((File) (obj)).delete();
        }
        c = -1;
        a = -1;
        d = 0;
        return;
        l++;
          goto _L3
    }

    public boolean e()
    {
        return a < c;
    }

    public boolean f()
    {
        return a >= d;
    }

    public Bitmap g()
    {
        if (f())
        {
            a = a - 1;
            return i();
        } else
        {
            return null;
        }
    }

    public Bitmap h()
    {
        if (e())
        {
            a = a + 1;
            return i();
        } else
        {
            return null;
        }
    }

    public Bitmap i()
    {
        if (a == c && f != null && !f.isRecycled())
        {
            return f;
        }
        Log.e("MNewImageKeeper", (new StringBuilder()).append("getDisplayProcessedBitmap:").append(a).toString());
        if ((new File(a(a(a)))).exists() && a >= 0)
        {
            return c(a(a));
        } else
        {
            Log.e("MNewImageKeeper", "getDisplayProcessedBitmap origin");
            return b(g);
        }
    }

    public Bitmap j()
    {
        if (c >= 0)
        {
            return b(g);
        } else
        {
            return f;
        }
    }

}
