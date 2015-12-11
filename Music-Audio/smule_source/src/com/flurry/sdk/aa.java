// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.net.Uri;
import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            af, ah, ab, fz, 
//            an, gd, z, r, 
//            ct, hp, ho, ap, 
//            ae

public class aa
{

    private static final String b = com/flurry/sdk/aa.getSimpleName();
    z a;
    private long c;
    private long d;
    private a e;

    public aa()
    {
        e = a.a;
    }

    private af a(af af1, ah ah1)
    {
        if (af1 != null) goto _L2; else goto _L1
_L1:
        af af2 = af.a;
_L4:
        return af2;
_L2:
        af2 = af1;
        if (ah1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ah.g.equals(ah1))
        {
            return af.f;
        }
        if (!ah.f.equals(ah1))
        {
            break; /* Loop/switch isn't completed */
        }
        af2 = af1;
        if (!af1.equals(af.f))
        {
            return af.e;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!ah.a.equals(ah1) && !ah.e.equals(ah1))
        {
            break; /* Loop/switch isn't completed */
        }
        af2 = af1;
        if (!af1.equals(af.f))
        {
            af2 = af1;
            if (!af1.equals(af.e))
            {
                return af.c;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (!ah.b.equals(ah1) && !ah.c.equals(ah1))
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (af.a.equals(af1))
        {
            break; /* Loop/switch isn't completed */
        }
        af2 = af1;
        if (!af.d.equals(af1)) goto _L4; else goto _L6
_L6:
        return af.b;
        af2 = af1;
        if (ah.d.equals(ah1))
        {
            af2 = af1;
            if (af.a.equals(af1))
            {
                return af.d;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void a(ab.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        ab ab1 = new ab();
        ab1.a = a1;
        fz.a().a(ab1);
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    private boolean a(String s, long l)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        an an1 = an.a;
        Object obj = Uri.parse(s).getPath();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            String s1 = URLConnection.guessContentTypeFromName(((String) (obj)));
            gd.a(3, b, (new StringBuilder()).append("Precaching: assetLink: ").append(s).append(" urlPath: ").append(((String) (obj))).append(" mimeType: ").append(s1).toString());
            obj = an1;
            if (s1 != null)
            {
                if (s1.startsWith("video"))
                {
                    gd.a(3, b, (new StringBuilder()).append("Precaching: asset is a video: ").append(s).toString());
                    obj = an.b;
                } else
                if (s1.startsWith("image"))
                {
                    gd.a(3, b, (new StringBuilder()).append("Precaching: asset is an image: ").append(s).toString());
                    obj = an.c;
                } else
                if (s1.startsWith("text"))
                {
                    gd.a(3, b, (new StringBuilder()).append("Precaching: asset is text: ").append(s).toString());
                    obj = an.d;
                } else
                {
                    gd.a(5, b, (new StringBuilder()).append("Precaching: could not identify media type for asset: ").append(s).toString());
                    obj = an1;
                }
            }
        } else
        {
            gd.a(5, b, (new StringBuilder()).append("Precaching: could not identify urlPath for asset: ").append(s).toString());
            obj = an1;
        }
        return a.a(s, ((an) (obj)), l);
    }

    private void b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            a.b(s);
            return;
        }
    }

    private boolean b(r r1, String s)
    {
        if (b() && !TextUtils.isEmpty(s))
        {
            gd.a(3, b, (new StringBuilder()).append("Precaching: Saving local asset for adObject:").append(r1.d()).toString());
            if (ah.d.equals(a.b(s)))
            {
                return c(r1, s);
            }
        }
        return false;
    }

    private String c(String s)
    {
        return ct.c(s);
    }

    private boolean c(r r1, String s)
    {
        Object obj = null;
        if (r1 != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L6:
        return flag1;
_L2:
        File file = new File(ct.a("fileStreamCacheDownloaderTmp", r1.d()), c(s));
        boolean flag = file.exists();
        if (!flag) goto _L4; else goto _L3
_L3:
        r1 = null;
_L9:
        hp.a(((java.io.Closeable) (obj)));
        hp.a(r1);
        flag = true;
_L8:
        flag1 = flag;
        if (flag) goto _L6; else goto _L5
_L5:
        file.delete();
        return flag;
_L4:
        if (!ho.a(file))
        {
            throw new IOException((new StringBuilder()).append("Precaching: Error creating directory to save tmp file:").append(file.getAbsolutePath()).toString());
        }
          goto _L7
        Object obj1;
        obj1;
        obj = null;
        r1 = null;
_L12:
        gd.a(6, b, (new StringBuilder()).append("Precaching: Error saving temp file for url:").append(s).append(" ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
        hp.a(r1);
        hp.a(((java.io.Closeable) (obj)));
        flag = false;
          goto _L8
_L7:
        r1 = new FileOutputStream(file);
        obj = a.c(s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        hp.a(((al.b) (obj)).a(), r1);
        gd.a(3, b, (new StringBuilder()).append("Precaching: Temp asset ").append(s).append(" saved to :").append(file.getAbsolutePath()).toString());
          goto _L9
        gd.a(3, b, (new StringBuilder()).append("Precaching: Temp asset not saved.  Could not open cache reader: ").append(s).toString());
          goto _L9
        obj1;
        s = ((String) (obj));
        obj = r1;
        r1 = s;
        s = ((String) (obj1));
_L11:
        hp.a(r1);
        hp.a(((java.io.Closeable) (obj)));
        throw s;
        s;
        obj = null;
        r1 = null;
        continue; /* Loop/switch isn't completed */
        s;
        obj = r1;
        r1 = null;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L11; else goto _L10
_L10:
        obj1;
        obj = r1;
        r1 = null;
          goto _L12
        obj1;
        r r2 = r1;
        r1 = ((r) (obj));
        obj = r2;
          goto _L12
    }

    private void d(ap ap1)
    {
        if (b() && ap1 != null)
        {
            List list = ap1.a().adFrames;
            int k = 0;
            while (k < list.size()) 
            {
                for (Iterator iterator = ap1.f(k).iterator(); iterator.hasNext(); b((String)iterator.next())) { }
                k++;
            }
        }
    }

    private void j()
    {
        try
        {
            File file = ct.b("fileStreamCacheDownloaderTmp");
            gd.a(3, b, (new StringBuilder()).append("Precaching: Cleaning temp asset directory: ").append(file).toString());
            ho.b(file);
            return;
        }
        catch (Exception exception)
        {
            gd.a(6, b, (new StringBuilder()).append("Precaching: Error cleaning temp asset directory: ").append(exception.getMessage()).toString(), exception);
        }
    }

    public af a(ap ap1)
    {
        af af1;
        if (!b())
        {
            af1 = af.f;
        } else
        {
            if (ap1 == null)
            {
                return af.f;
            }
            if (ap1.a() == null)
            {
                return af.d;
            }
            af1 = af.a;
            List list = ap1.a().adFrames;
            boolean flag = false;
            for (int k = 0; k < list.size(); k++)
            {
                for (Iterator iterator = ap1.f(k).iterator(); iterator.hasNext();)
                {
                    String s = (String)iterator.next();
                    af1 = a(af1, a.b(s));
                    flag = true;
                }

            }

            if (!flag)
            {
                return af.d;
            }
        }
        return af1;
    }

    public File a(int k, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if ((s = new File(ct.a("fileStreamCacheDownloaderTmp", k), c(s))).exists())
            {
                return s;
            }
        }
        return null;
    }

    public File a(r r1, String s)
    {
        if (r1 == null || TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return a(r1.d(), s);
        }
    }

    public void a(long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, b, "Precaching: Initializing AssetCacheManager.");
        c = l;
        d = l1;
        j();
        e = a.b;
        a(ab.a.a);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void a(ae ae1)
    {
        while (!a() || ae1 == null || ah.b.equals(ae1.b()) || ah.c.equals(ae1.b())) 
        {
            return;
        }
        a.a(ae1);
    }

    public void a(r r1)
    {
        if (r1 == null)
        {
            return;
        }
        try
        {
            File file = ct.a("fileStreamCacheDownloaderTmp", r1.d());
            gd.a(3, b, (new StringBuilder()).append("Precaching: Removing local assets for adObject:").append(r1.d()).toString());
            ho.b(file);
            return;
        }
        catch (Exception exception)
        {
            gd.a(6, b, (new StringBuilder()).append("Precaching: Error removing local assets for adObject:").append(r1.d()).append(" ").append(exception.getMessage()).toString(), exception);
        }
    }

    public void a(String s)
    {
        if (!b())
        {
            return;
        } else
        {
            a.a(s);
            return;
        }
    }

    public void a(List list)
    {
        if (b() && list != null)
        {
            for (int k = list.size() - 1; k >= 0; k--)
            {
                d((ap)list.get(k));
            }

            list = list.iterator();
            int l = 0;
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                int i1;
                if (b((ap)list.next()) > 0)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                l = i1 + l;
            } while (l < 2);
        }
    }

    public boolean a()
    {
        return !a.a.equals(e);
    }

    public boolean a(ap ap1, String s)
    {
        if (ap1 != null && !TextUtils.isEmpty(s))
        {
            List list = ap1.a().adFrames;
            int k = 0;
            while (k < list.size()) 
            {
                for (Iterator iterator = ap1.f(k).iterator(); iterator.hasNext();)
                {
                    if (((String)iterator.next()).equals(s))
                    {
                        return true;
                    }
                }

                k++;
            }
        }
        return false;
    }

    public boolean a(r r1, ap ap1)
    {
        while (!b() || r1 == null || ap1 == null) 
        {
            return false;
        }
        gd.a(3, b, (new StringBuilder()).append("Precaching: Saving local assets for adObject:").append(r1.d()).toString());
        List list = ap1.a().adFrames;
        int k = 0;
        do
        {
            if (k >= list.size())
            {
                break;
            }
            for (Iterator iterator = ap1.f(k).iterator(); iterator.hasNext();)
            {
                if (!b(r1, (String)iterator.next()))
                {
                    return false;
                }
            }

            k++;
        } while (true);
        return true;
    }

    public int b(ap ap1)
    {
        while (!b() || ap1 == null) 
        {
            return 0;
        }
        List list = ap1.a().adFrames;
        int l = 0;
        int k = 0;
label0:
        for (; l < list.size(); l++)
        {
            AdFrame adframe = (AdFrame)list.get(l);
            Iterator iterator = ap1.f(l).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                if (a((String)iterator.next(), adframe.assetExpirationTimestampUTCMillis))
                {
                    k++;
                }
            } while (true);
        }

        return k;
    }

    public boolean b()
    {
        return a.c.equals(e) || a.d.equals(e);
    }

    public void c(ap ap1)
    {
        if (b() && ap1 != null)
        {
            List list = ap1.a().adFrames;
            int k = 0;
            while (k < list.size()) 
            {
                AdFrame adframe = (AdFrame)list.get(k);
                Iterator iterator = ap1.f(k).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    if (a(s, adframe.assetExpirationTimestampUTCMillis))
                    {
                        a(s);
                    }
                } while (true);
                k++;
            }
        }
    }

    public boolean c()
    {
        return a.d.equals(e);
    }

    public List d()
    {
        if (!a())
        {
            return null;
        } else
        {
            return a.d();
        }
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!b())
        {
            gd.a(3, b, "Precaching: Starting AssetCacheManager.");
            a = new z("fileStreamCacheDownloader", c, d, false);
            a.e();
            e = a.c;
            a(ab.a.b);
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        gd.a(3, b, "Precaching: Stopping AssetCacheManager.");
        a.f();
        e = a.b;
        a(ab.a.c);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c())
        {
            gd.a(3, b, "Precaching: Resuming AssetCacheManager.");
            a.g();
            e = a.c;
            a(ab.a.e);
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void h()
    {
        if (!b())
        {
            return;
        } else
        {
            a.h();
            return;
        }
    }

    public List i()
    {
        if (!b())
        {
            return Collections.emptyList();
        } else
        {
            return a.k();
        }
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/flurry/sdk/aa$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("NONE", 0);
            b = new a("INIT", 1);
            c = new a("ACTIVE", 2);
            d = new a("PAUSED", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int k)
        {
            super(s, k);
        }
    }

}
