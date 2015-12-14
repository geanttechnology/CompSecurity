// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Pair;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.jniproxy.PixelFormat;
import com.cyberlink.youcammakeup.jniproxy.UIBeautifierCacheMode;
import com.cyberlink.youcammakeup.jniproxy.ae;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.al;
import com.cyberlink.youcammakeup.jniproxy.am;
import com.cyberlink.youcammakeup.jniproxy.at;
import com.cyberlink.youcammakeup.jniproxy.au;
import com.cyberlink.youcammakeup.jniproxy.av;
import com.cyberlink.youcammakeup.jniproxy.bc;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.jniproxy.bk;
import com.cyberlink.youcammakeup.jniproxy.bm;
import com.cyberlink.youcammakeup.jniproxy.d;
import com.cyberlink.youcammakeup.jniproxy.r;
import com.cyberlink.youcammakeup.jniproxy.s;
import com.cyberlink.youcammakeup.jniproxy.u;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.ad;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            d, c, a

public class BeautifierEditCenter
    implements ad
{

    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d a;
    private com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d b;
    private final String c = (new StringBuilder()).append(Globals.d().q()).append("/model").toString();
    private String d;
    private BeautifierErrorCode e;

    public BeautifierEditCenter()
    {
        d = "";
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        a = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d();
        b = a;
        StatusManager.j().a(this);
        bb.a(c);
    }

    public static BeautifierEditCenter a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.c.a();
    }

    private boolean a(Bitmap bitmap, String s, boolean flag, PixelFormat pixelformat)
    {
        if (pixelformat == null)
        {
            pixelformat = new d();
        } else
        {
            pixelformat = new d(pixelformat);
        }
        try
        {
            pixelformat.a(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            pixelformat.c();
            pixelformat.b();
            return false;
        }
        finally
        {
            pixelformat.c();
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        com.cyberlink.youcammakeup.jniproxy.d.b(pixelformat);
        flag = pixelformat.b(s);
        pixelformat.c();
        pixelformat.b();
        return flag;
        pixelformat.b();
        throw bitmap;
    }

    public Pair a(int i1, float f1, int j1, s s, Bitmap bitmap, List list, String s1, 
            boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        s1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        ae ae1 = new ae();
        if (bitmap != null)
        {
            if (!a(bitmap, s1, true, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
            ae1.a(s1);
        }
        ae ae2 = new ae();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Bitmap bitmap1 = (Bitmap)iterator.next();
            if (bitmap1 != null)
            {
                String s2 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
                if (!a(bitmap1, s2, false, ((PixelFormat) (null))))
                {
                    e = BeautifierErrorCode.b;
                }
                ae2.a(s2);
                arraylist.add(s2);
            }
        } while (true);
        b.b.a(i1, f1, j1, s, ae1, ae2);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        if (bitmap != null && list != null)
        {
            return Pair.create(s1, arraylist);
        } else
        {
            return null;
        }
    }

    public Pair a(int i1, int j1, r r, Bitmap bitmap, Bitmap bitmap1, com.cyberlink.youcammakeup.jniproxy.bb bb1, com.cyberlink.youcammakeup.jniproxy.bb bb2, 
            com.cyberlink.youcammakeup.jniproxy.bb bb3, String s, boolean flag, boolean flag1, boolean flag2, int k1, BeautifierTaskInfo beautifiertaskinfo)
    {
        String s1;
        String s2;
        ae ae1;
        ae ae2;
        Object obj;
        b = b.c();
        ae1 = new ae();
        ae2 = new ae();
        s1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        s2 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj = new d();
        ((d) (obj)).a(bitmap);
        ((d) (obj)).b(s1);
        ((d) (obj)).c();
        ((d) (obj)).b();
        ae1.a(s1);
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        obj = new d();
        ((d) (obj)).a(bitmap1);
        ((d) (obj)).b(s2);
        ((d) (obj)).c();
        ((d) (obj)).b();
        ae2.a(s2);
        obj = MotionControlHelper.e().c("Eyebrow_general");
        com.cyberlink.youcammakeup.jniproxy.z z = MotionControlHelper.e().d("Eyebrow_general");
        b.b.a(i1, j1, r, ae1, ae2, bb1, bb2, bb3, s, flag, flag1, k1, ((com.cyberlink.youcammakeup.jniproxy.z) (obj)), z);
        r = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        long l1 = StatusManager.j().l();
        bb1 = StatusManager.j().f(l1);
        if (((a) (bb1)).e >= 0 && ((a) (bb1)).e < r.size())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (bb1 != null && r != null && i1 != 0 && r.get(((a) (bb1)).e) != null)
        {
            r = ((ar)r.get(((a) (bb1)).e)).c;
            if (r != null)
            {
                bb1 = MotionControlHelper.e().c(s);
                bb2 = MotionControlHelper.e().d(s);
                if (bb1 != null && bb2 != null)
                {
                    r.a(com.cyberlink.youcammakeup.kernelctrl.j.a(bb1));
                    r.b(com.cyberlink.youcammakeup.kernelctrl.j.a(bb2));
                    b.a.a(r);
                    b.b.a(b.b.c(), r);
                }
            }
        }
        b.a();
        if (flag2)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        if (bitmap1 != null && bitmap != null)
        {
            return Pair.create(s1, s2);
        } else
        {
            return null;
        }
        r;
        ((d) (obj)).c();
        ((d) (obj)).b();
        throw r;
        r;
        ((d) (obj)).c();
        ((d) (obj)).b();
        throw r;
    }

    public Pair a(int i1, int j1, r r, Bitmap bitmap, Bitmap bitmap1, com.cyberlink.youcammakeup.jniproxy.bb bb1, com.cyberlink.youcammakeup.jniproxy.bb bb2, 
            com.cyberlink.youcammakeup.jniproxy.bb bb3, String s, boolean flag, boolean flag1, boolean flag2, String s1, int k1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        ae ae1 = new ae();
        ae ae2 = new ae();
        String s2 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        String s3 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (bitmap != null)
        {
            if (!a(bitmap, s2, false, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
            ae1.a(s2);
        }
        if (bitmap1 != null)
        {
            if (!a(bitmap1, s3, false, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
            ae2.a(s3);
        }
        com.cyberlink.youcammakeup.jniproxy.z z = MotionControlHelper.e().f("default_original_looks");
        com.cyberlink.youcammakeup.jniproxy.z z1 = MotionControlHelper.e().g("default_original_looks");
        b.b.a(i1, j1, r, ae1, ae2, bb1, bb2, bb3, s, flag, flag1, k1, z, z1);
        r = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        long l1 = StatusManager.j().l();
        bb1 = StatusManager.j().f(l1);
        if (((a) (bb1)).e >= 0 && ((a) (bb1)).e < r.size())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (bb1 != null && r != null && i1 != 0 && r.get(((a) (bb1)).e) != null)
        {
            r = ((ar)r.get(((a) (bb1)).e)).c;
            if (r != null && s1 != null)
            {
                bb1 = MotionControlHelper.e().f(s1);
                bb2 = MotionControlHelper.e().g(s1);
                if (bb1 != null && bb2 != null)
                {
                    r.a(com.cyberlink.youcammakeup.kernelctrl.j.a(bb1));
                    r.b(com.cyberlink.youcammakeup.kernelctrl.j.a(bb2));
                    b.a.a(r);
                    b.b.a(b.b.c(), r);
                }
            }
        }
        b.a();
        if (flag2)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        if (bitmap1 != null && bitmap != null)
        {
            return Pair.create(s2, s3);
        } else
        {
            return null;
        }
    }

    public Pair a(int i1, r r, Bitmap bitmap, Bitmap bitmap1, String s, boolean flag, boolean flag1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, s, false, ((PixelFormat) (null))))
        {
            e = BeautifierErrorCode.b;
        }
        bitmap = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap1, ((String) (bitmap)), false, ((PixelFormat) (null))))
        {
            e = BeautifierErrorCode.b;
        }
        b.b.a(i1, r, s, bitmap, flag);
        b.a();
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return Pair.create(s, bitmap);
    }

    public ae a(int i1, r r, Bitmap bitmap, bc bc, String s, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        ae ae1 = new ae();
        String s1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, s1, false, ((PixelFormat) (null))))
        {
            e = BeautifierErrorCode.b;
        }
        ae1.a(s1);
        b.b.a(i1, r, ae1, bc, s);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return ae1;
    }

    public ae a(int i1, r r, ArrayList arraylist, bc bc, String s, boolean flag, int j1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        ae ae1 = new ae();
        String s1;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); ae1.a(s1))
        {
            Bitmap bitmap = (Bitmap)arraylist.next();
            s1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
            if (!a(bitmap, s1, false, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
        }

        b.b.a(i1, r, ae1, bc, s, j1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return ae1;
    }

    public ae a(av av, av av1, s s, av av2, ArrayList arraylist, Bitmap bitmap, bc bc, 
            String s1, boolean flag, int i1, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        ae ae1 = new ae();
        d = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, d, false, ((PixelFormat) (null))))
        {
            e = BeautifierErrorCode.b;
        }
        ae1.a(d);
        bitmap = new ae();
        String s2;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); bitmap.a(s2))
        {
            Bitmap bitmap1 = (Bitmap)arraylist.next();
            s2 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
            if (!a(bitmap1, s2, false, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
        }

        b.b.a(av, s, av2, bitmap, bc, s1, ae1, av1, i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return bitmap;
    }

    public ae a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, bi bi, bm bm, 
            ArrayList arraylist, int i1, boolean flag5, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        ae ae1 = new ae();
        String s;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); ae1.a(s))
        {
            Bitmap bitmap = (Bitmap)arraylist.next();
            s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
            if (!a(bitmap, s, false, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
        }

        b.b.a(flag, flag1, flag2, flag3, flag4, bi, bm, ae1, i1);
        b.a();
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag5)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
        return ae1;
    }

    public String a(boolean flag, boolean flag1, boolean flag2, boolean flag3, Bitmap bitmap, ah ah, ah ah1, 
            int i1, bi bi, boolean flag4, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        String s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, s, false, PixelFormat.a))
        {
            e = BeautifierErrorCode.b;
        }
        b.c.a(flag, flag1, flag2, flag3, s, ah, ah1, i1, bi);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag4)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
        return s;
    }

    public String a(boolean flag, boolean flag1, boolean flag2, boolean flag3, Bitmap bitmap, ah ah, ah ah1, 
            bi bi, boolean flag4, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        String s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, s, false, PixelFormat.a))
        {
            e = BeautifierErrorCode.b;
        }
        b.c.a(flag, flag1, flag2, flag3, s, ah, ah1, bi);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag4)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
        return s;
    }

    public List a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, Bitmap bitmap, 
            Bitmap bitmap1, ah ah, ah ah1, ah ah2, ah ah3, bi bi, bi bi1, 
            boolean flag6, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        String s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, s, false, PixelFormat.a))
        {
            e = BeautifierErrorCode.b;
        }
        boolean flag7 = false;
        if (bitmap1 != null)
        {
            String s1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
            flag7 = true;
            bitmap = s1;
            if (!a(bitmap1, s1, false, PixelFormat.a))
            {
                e = BeautifierErrorCode.b;
                flag7 = false;
                bitmap = s;
            }
        } else
        {
            bitmap = s;
        }
        b.c.c(flag, flag2, flag3, flag5, s, ah, ah1, bi);
        b.c.a(flag1, flag2, flag4, flag5, bitmap, ah2, ah3, bi1, flag7);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag && !flag1)
        {
            b.c.a(false);
        }
        if (flag6)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
        bitmap1 = new ArrayList();
        bitmap1.add(s);
        if (bitmap != null)
        {
            bitmap1.add(bitmap);
        }
        return bitmap1;
    }

    public void a(int i1, float f1, int j1, s s, String s1, List list, String s2, 
            boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        s2 = new ae();
        s2.a(s1);
        s1 = new ae();
        for (list = list.iterator(); list.hasNext(); s1.a((String)list.next())) { }
        b = b.c();
        b.b.a(i1, f1, j1, s, s2, s1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, int j1, int k1, boolean flag, LipstickType lipsticktype, int l1, int i2, 
            int j2, int k2, int l2, int i3, boolean flag1, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(i1, flag, lipsticktype.ordinal(), l1, j2, l2, j1, i2, k2, i3, k1);
        b.a();
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.a(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void a(int i1, int j1, r r, String s, String s1, com.cyberlink.youcammakeup.jniproxy.bb bb1, com.cyberlink.youcammakeup.jniproxy.bb bb2, 
            com.cyberlink.youcammakeup.jniproxy.bb bb3, String s2, boolean flag, boolean flag1, boolean flag2, int k1, BeautifierTaskInfo beautifiertaskinfo)
    {
        ae ae1 = new ae();
        ae1.a(s);
        s = new ae();
        s.a(s1);
        b = b.c();
        s1 = MotionControlHelper.e().c("Eyebrow_general");
        com.cyberlink.youcammakeup.jniproxy.z z = MotionControlHelper.e().d("Eyebrow_general");
        b.b.a(i1, j1, r, ae1, s, bb1, bb2, bb3, s2, flag, flag1, k1, s1, z);
        r = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        long l1 = StatusManager.j().l();
        s = StatusManager.j().f(l1);
        if (((a) (s)).e >= 0 && ((a) (s)).e < r.size())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (s != null && r != null && i1 != 0 && r.get(((a) (s)).e) != null)
        {
            r = ((ar)r.get(((a) (s)).e)).c;
            if (r != null)
            {
                s = MotionControlHelper.e().c(s2);
                s1 = MotionControlHelper.e().d(s2);
                if (s != null && s1 != null)
                {
                    r.a(com.cyberlink.youcammakeup.kernelctrl.j.a(s));
                    r.b(com.cyberlink.youcammakeup.kernelctrl.j.a(s1));
                    b.a.a(r);
                    b.b.a(b.b.c(), r);
                }
            }
        }
        b.a();
        if (flag2)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, int j1, r r, String s, String s1, com.cyberlink.youcammakeup.jniproxy.bb bb1, com.cyberlink.youcammakeup.jniproxy.bb bb2, 
            com.cyberlink.youcammakeup.jniproxy.bb bb3, String s2, boolean flag, boolean flag1, boolean flag2, String s3, int k1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        ae ae1 = new ae();
        ae1.a(s);
        s = new ae();
        s.a(s1);
        b = b.c();
        s1 = MotionControlHelper.e().f("default_original_looks");
        com.cyberlink.youcammakeup.jniproxy.z z = MotionControlHelper.e().g("default_original_looks");
        b.b.a(i1, j1, r, ae1, s, bb1, bb2, bb3, s2, flag, flag1, k1, s1, z);
        r = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
        long l1 = StatusManager.j().l();
        s = StatusManager.j().f(l1);
        if (((a) (s)).e >= 0 && ((a) (s)).e < r.size())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (s != null && r != null && i1 != 0 && r.get(((a) (s)).e) != null)
        {
            r = ((ar)r.get(((a) (s)).e)).c;
            if (r != null && s3 != null)
            {
                s = MotionControlHelper.e().f(s3);
                s1 = MotionControlHelper.e().g(s3);
                if (s != null && s1 != null)
                {
                    r.a(com.cyberlink.youcammakeup.kernelctrl.j.a(s));
                    r.b(com.cyberlink.youcammakeup.kernelctrl.j.a(s1));
                    b.a.a(r);
                    b.b.a(b.b.c(), r);
                }
            }
        }
        b.a();
        if (flag2)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, int j1, r r, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(j1, i1, r);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, r r, ae ae1, bc bc, String s, boolean flag, int j1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(i1, r, ae1, bc, s, j1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, r r, ae ae1, bc bc, String s, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(i1, r, ae1, bc, s);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, r r, String s, String s1, String s2, boolean flag, boolean flag1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(i1, r, s, s1, flag);
        b.a();
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, r r, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(i1, r);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a.b(i1);
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, boolean flag, LipstickType lipsticktype, int j1, int k1, int l1, boolean flag1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(i1, flag, lipsticktype.ordinal(), j1, k1, l1);
        b.a();
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(int i1, boolean flag, boolean flag1, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a.a(i1, flag);
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(long l1, Object obj, UUID uuid)
    {
        b();
    }

    public void a(UIBeautifierCacheMode uibeautifiercachemode)
    {
        b = b.c();
        b.a.a(uibeautifiercachemode.a());
        b.b.a(uibeautifiercachemode.a());
    }

    public void a(ai ai, y y1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a.a(y1);
        b.b.a(ai, y1);
        a.a.a(y1);
        a.b.a(ai, y1);
        boolean flag1;
        if (MotionControlHelper.e().f() != null)
        {
            flag1 = MotionControlHelper.e().f().booleanValue();
        } else
        {
            flag1 = false;
        }
        b.b.f(flag1);
        a.b.f(flag1);
        if (flag)
        {
            BeautifierManager.a().c();
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(av av, av av1, s s, av av2, ae ae1, bc bc, String s1, 
            boolean flag, int i1, BeautifierTaskInfo beautifiertaskinfo)
    {
        ae ae2 = new ae();
        ae2.a(d);
        b = b.c();
        b.b.a(av, s, av2, ae1, bc, s1, ae2, av1, i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a();
        StatusManager.j().a(b.c(), beautifiertaskinfo);
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d d1)
    {
        a(d1, false);
        StatusManager.j().t();
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d d1, boolean flag)
    {
        boolean flag2 = false;
        boolean flag1;
        if (b != null && b.b != null && !b.b.h())
        {
            flag1 = b.b.f();
        } else
        {
            flag1 = false;
        }
        if (d1 != null)
        {
            a = d1.c();
            b = a;
        } else
        {
            a = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d();
            a.a.a(b.a.b());
            a.b.a(b.b.c(), b.b.d());
            b = a;
        }
        if (!flag)
        {
            long l1 = StatusManager.j().l();
            d1 = Globals.d().t();
            flag = flag2;
            if (d1 != null)
            {
                flag = d1.B();
            }
            if (flag)
            {
                d1 = StatusManager.j().l(l1);
            } else
            {
                d1 = StatusManager.j().i(l1);
            }
            if (d1 != null)
            {
                a(MotionControlHelper.e().a(((a) (d1)).e));
            }
        }
        b(flag1);
        c(true);
    }

    public void a(Map map, List list, List list1, List list2, List list3, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        ae ae1;
        au au1;
        am am1;
        int i1;
        ae1 = new ae();
        au1 = new au();
        am1 = new am();
        i1 = 0;
_L2:
        Object obj;
        d d1;
        Bitmap bitmap;
        String s1;
        if (i1 >= list1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap = (Bitmap)list1.get(i1);
        d1 = new d();
        s1 = (String)list.get(i1);
        String s = (String)map.get(s1);
        obj = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(((String) (obj)));
        d1.c();
        d1.b();
        map.put(s1, obj);
        ae1.a(((String) (obj)));
        obj = (Point)list2.get(i1);
        at at1 = new at();
        at1.a(((Point) (obj)).x);
        at1.b(((Point) (obj)).y);
        au1.a(at1);
        am1.a((al)list3.get(i1));
        i1++;
        if (true) goto _L2; else goto _L1
        map;
        d1.c();
        d1.b();
        throw map;
_L1:
        b.b.a(ae1, au1, am1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return;
    }

    public void a(boolean flag)
    {
        if (b != null && b.b != null)
        {
            b.b.b(flag);
        }
        if (a != null && a.b != null)
        {
            a.b.b(flag);
        }
    }

    public void a(boolean flag, boolean flag1, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a.a(flag);
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            int i1, bi bi, boolean flag4, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.c.a(flag, flag1, flag2, flag3, s, ah, ah1, i1, bi);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag4)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            bi bi, boolean flag4, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.c.a(flag, flag1, flag2, flag3, s, ah, ah1, bi);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag4)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, bi bi, bm bm, 
            ae ae1, int i1, boolean flag5, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(flag, flag1, flag2, flag3, flag4, bi, bm, ae1, i1);
        b.a();
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag5)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, String s, 
            String s1, ah ah, ah ah1, ah ah2, ah ah3, bi bi, bi bi1, 
            boolean flag6, boolean flag7, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.c.c(flag, flag2, flag3, flag5, s, ah, ah1, bi);
        b.c.a(flag1, flag2, flag4, flag5, s1, ah2, ah3, bi1, flag6);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag && !flag1)
        {
            b.c.a(false);
        }
        if (flag7)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
    }

    public ae b(int i1, r r, ArrayList arraylist, bc bc, String s, boolean flag, int j1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        ae ae1 = new ae();
        String s1;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); ae1.a(s1))
        {
            Bitmap bitmap = (Bitmap)arraylist.next();
            s1 = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
            if (!a(bitmap, s1, false, ((PixelFormat) (null))))
            {
                e = BeautifierErrorCode.b;
            }
        }

        b.b.b(i1, r, ae1, bc, s, j1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return ae1;
    }

    public String b(boolean flag, boolean flag1, boolean flag2, boolean flag3, Bitmap bitmap, ah ah, ah ah1, 
            bi bi, boolean flag4, BeautifierTaskInfo beautifiertaskinfo)
    {
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        b = b.c();
        String s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        if (!a(bitmap, s, false, PixelFormat.a))
        {
            e = BeautifierErrorCode.b;
        }
        b.c.b(flag, flag1, flag2, flag3, s, ah, ah1, bi);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag4)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
        return s;
    }

    public void b()
    {
        a = new com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d();
        b = a;
        if (c != null)
        {
            bb.b(new File(c));
            bb.a(c);
        }
    }

    public void b(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.b(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void b(int i1, r r, ae ae1, bc bc, String s, boolean flag, int j1, 
            BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.b(i1, r, ae1, bc, s, j1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void b(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a.c(i1);
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void b(Map map, List list, List list1, List list2, List list3, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        ae ae1;
        au au1;
        am am1;
        int i1;
        ae1 = new ae();
        au1 = new au();
        am1 = new am();
        i1 = 0;
_L2:
        Object obj;
        d d1;
        Bitmap bitmap;
        String s1;
        if (i1 >= list1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap = (Bitmap)list1.get(i1);
        d1 = new d();
        s1 = (String)list.get(i1);
        String s = (String)map.get(s1);
        obj = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(((String) (obj)));
        d1.c();
        d1.b();
        map.put(s1, obj);
        ae1.a(((String) (obj)));
        obj = (Point)list2.get(i1);
        at at1 = new at();
        at1.a(((Point) (obj)).x);
        at1.b(((Point) (obj)).y);
        au1.a(at1);
        am1.a((al)list3.get(i1));
        i1++;
        if (true) goto _L2; else goto _L1
        map;
        d1.c();
        d1.b();
        throw map;
_L1:
        b.b.b(ae1, au1, am1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        return;
    }

    public void b(boolean flag)
    {
        if (b != null && b.b != null)
        {
            b.b.c(flag);
        }
        if (a != null && a.b != null)
        {
            a.b.c(flag);
        }
    }

    public void b(boolean flag, boolean flag1, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.a(flag);
        b.a();
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void b(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, ah ah, ah ah1, 
            bi bi, boolean flag4, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.c.b(flag, flag1, flag2, flag3, s, ah, ah1, bi);
        if (beautifiertaskinfo.b() && !beautifiertaskinfo.c() && !flag)
        {
            b.c.a(false);
        }
        if (flag4)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
        b.c.a(true);
    }

    public void c()
    {
        b.b.i();
    }

    public void c(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.a(j1, i1, ae1, bc);
        b.b.b(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void c(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.a.d(i1);
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void c(boolean flag)
    {
        if (b != null && b.b != null)
        {
            b.b.e(flag);
        }
        if (a != null && a.b != null)
        {
            a.b.e(flag);
        }
    }

    public void c(boolean flag, boolean flag1, BeautifierTaskInfo beautifiertaskinfo)
    {
        b.b.f(flag);
        if (flag1)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d d()
    {
        return b.c();
    }

    public void d(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.c(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void d(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.b(i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void d(boolean flag)
    {
        b = b.c();
        b.b.d(flag);
        b.a();
    }

    public BeautifierErrorCode e()
    {
        BeautifierErrorCode beautifiererrorcode = e;
        e = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierErrorCode.a;
        return beautifiererrorcode;
    }

    public void e(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.d(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void e(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.c(i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void e(boolean flag)
    {
        if (flag)
        {
            a = b;
        } else
        {
            b = a;
        }
        StatusManager.j().a(flag);
    }

    public void f(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.c(j1, i1, ae1, bc);
        b.b.d(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void f(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.d(i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void g(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.e(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void g(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.e(i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void h(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.f(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void h(int i1, boolean flag, BeautifierTaskInfo beautifiertaskinfo)
    {
        b = b.c();
        b.b.f(i1);
        b.a();
        if (flag)
        {
            StatusManager.j().a(b.c(), beautifiertaskinfo);
        }
    }

    public void i(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.g(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void j(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.h(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void k(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.e(j1, i1, ae1, bc);
        b.b.g(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void l(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.f(j1, i1, ae1, bc);
        b.b.h(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void m(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.i(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void n(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.j(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    public void o(int i1, int j1, Bitmap bitmap, bc bc)
    {
        d d1;
        ae ae1;
        String s;
        ae1 = new ae();
        d1 = new d();
        s = (new StringBuilder()).append(c).append("/").append(UUID.randomUUID().toString()).toString();
        d1.a(bitmap);
        com.cyberlink.youcammakeup.jniproxy.d.b(d1);
        d1.b(s);
        d1.c();
        d1.b();
        ae1.a(s);
        b.b.i(j1, i1, ae1, bc);
        b.b.j(j1, i1, ae1, bc);
        return;
        bitmap;
        d1.c();
        d1.b();
        throw bitmap;
    }

    private class BeautifierErrorCode extends Enum
    {

        public static final BeautifierErrorCode a;
        public static final BeautifierErrorCode b;
        private static final BeautifierErrorCode c[];

        public static BeautifierErrorCode valueOf(String s)
        {
            return (BeautifierErrorCode)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/dataeditcenter/BeautifierEditCenter$BeautifierErrorCode, s);
        }

        public static BeautifierErrorCode[] values()
        {
            return (BeautifierErrorCode[])c.clone();
        }

        static 
        {
            a = new BeautifierErrorCode("NONE", 0);
            b = new BeautifierErrorCode("DUMP_CACHE_FAILED", 1);
            c = (new BeautifierErrorCode[] {
                a, b
            });
        }

        private BeautifierErrorCode(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class LipstickType extends Enum
    {

        public static final LipstickType a;
        public static final LipstickType b;
        public static final LipstickType c;
        public static final LipstickType d;
        private static final LipstickType e[];

        public static LipstickType valueOf(String s)
        {
            return (LipstickType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/dataeditcenter/BeautifierEditCenter$LipstickType, s);
        }

        public static LipstickType[] values()
        {
            return (LipstickType[])e.clone();
        }

        static 
        {
            a = new LipstickType("THICK", 0);
            b = new LipstickType("BRIGHT", 1);
            c = new LipstickType("GLOSS", 2);
            d = new LipstickType("CHERRY", 3);
            e = (new LipstickType[] {
                a, b, c, d
            });
        }

        private LipstickType(String s, int i1)
        {
            super(s, i1);
        }
    }

}
