// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ajp, aij, ajt, aim, 
//            ail, ajk, ajn, ajr, 
//            aju, aid, ain, aip, 
//            aiv, ajf, aio, ajl, 
//            ajo

public class aik
{

    public static final String a = android/support/v7/aik.getSimpleName();
    private static volatile aik e;
    private ail b;
    private aim c;
    private final ajn d = new ajp();

    protected aik()
    {
    }

    private static Handler a(aij aij1)
    {
        Handler handler = aij1.r();
        if (aij1.s())
        {
            aij1 = null;
        } else
        {
            aij1 = handler;
            if (handler == null)
            {
                aij1 = handler;
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                    return new Handler();
                }
            }
        }
        return aij1;
    }

    public static aik a()
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        android/support/v7/aik;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new aik();
        }
        android/support/v7/aik;
        JVM INSTR monitorexit ;
_L2:
        return e;
        Exception exception;
        exception;
        android/support/v7/aik;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void b()
    {
        if (b == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    public void a(ail ail1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ail1 != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        ail1;
        this;
        JVM INSTR monitorexit ;
        throw ail1;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        ajt.a("Initialize ImageLoader with configuration", new Object[0]);
        c = new aim(ail1);
        b = ail1;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        ajt.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public void a(String s, ajk ajk1, aij aij1)
    {
        a(s, ajk1, aij1, null, null);
    }

    public void a(String s, ajk ajk1, aij aij1, ajn ajn1)
    {
        a(s, ajk1, aij1, ajn1, null);
    }

    public void a(String s, ajk ajk1, aij aij1, ajn ajn1, ajo ajo)
    {
        b();
        if (ajk1 == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        if (ajn1 == null)
        {
            ajn1 = d;
        }
        if (aij1 == null)
        {
            aij1 = b.r;
        }
        if (TextUtils.isEmpty(s))
        {
            c.b(ajk1);
            ajn1.a(s, ajk1.d());
            if (aij1.b())
            {
                ajk1.a(aij1.b(b.a));
            } else
            {
                ajk1.a(null);
            }
            ajn1.a(s, ajk1.d(), null);
            return;
        }
        aiu aiu = ajr.a(ajk1, b.a());
        String s1 = aju.a(s, aiu);
        c.a(ajk1, s1);
        ajn1.a(s, ajk1.d());
        Bitmap bitmap = (Bitmap)b.n.a(s1);
        if (bitmap != null && !bitmap.isRecycled())
        {
            ajt.a("Load image from memory cache [%s]", new Object[] {
                s1
            });
            if (aij1.e())
            {
                s = new ain(s, ajk1, aiu, s1, aij1, ajn1, ajo, c.a(s));
                s = new aip(c, bitmap, s, a(aij1));
                if (aij1.s())
                {
                    s.run();
                    return;
                } else
                {
                    c.a(s);
                    return;
                }
            } else
            {
                aij1.q().a(bitmap, ajk1, aiv.c);
                ajn1.a(s, ajk1.d(), bitmap);
                return;
            }
        }
        if (aij1.a())
        {
            ajk1.a(aij1.a(b.a));
        } else
        if (aij1.g())
        {
            ajk1.a(null);
        }
        s = new ain(s, ajk1, aiu, s1, aij1, ajn1, ajo, c.a(s));
        s = new aio(c, s, a(aij1));
        if (aij1.s())
        {
            s.run();
            return;
        } else
        {
            c.a(s);
            return;
        }
    }

    public void a(String s, ImageView imageview, aij aij1, ajn ajn1)
    {
        a(s, imageview, aij1, ajn1, null);
    }

    public void a(String s, ImageView imageview, aij aij1, ajn ajn1, ajo ajo)
    {
        a(s, ((ajk) (new ajl(imageview))), aij1, ajn1, ajo);
    }

}
