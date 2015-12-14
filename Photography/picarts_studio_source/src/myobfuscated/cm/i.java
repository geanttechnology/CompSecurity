// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.photo.effect.Effect;
import com.socialin.android.photo.effects.factory.EffectsFactory;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeoutException;
import myobfuscated.ay.e;
import myobfuscated.cj.a;

// Referenced classes of package myobfuscated.cm:
//            d, j, c

public final class i extends ModernAsyncTask
{

    int a;
    boolean b;
    public boolean c;
    private Context d;
    private Effect e;
    private boolean f;
    private boolean g;
    private d h;
    private j i;
    private myobfuscated.cm.c j;

    public i(myobfuscated.cm.c c1, Effect effect, Context context, boolean flag, d d1, j j1)
    {
        j = c1;
        super();
        a = -1;
        b = false;
        f = false;
        g = true;
        c = false;
        e = effect;
        d = context;
        g = flag;
        h = d1;
        i = j1;
    }

    private transient Long a()
    {
        Object obj1;
        Object obj2;
        Bitmap bitmap;
        ByteBuffer bytebuffer;
        ByteBuffer bytebuffer1;
        Point point;
        Object obj3;
        Point point1;
        long l;
        if (b)
        {
            return null;
        }
        bitmap = h.a;
        obj3 = h.b;
        bytebuffer1 = h.g;
        obj2 = h.i;
        obj1 = h.k;
        point = h.f;
        point1 = h.e;
        l = System.currentTimeMillis();
        bytebuffer = null;
        if (c)
        {
            myobfuscated.ay.e.a(h.a, h.d, h.b);
        }
        if (!g) goto _L2; else goto _L1
_L1:
        obj2 = com.socialin.android.util.c.a(point.x, point.y, android.graphics.Bitmap.Config.ARGB_8888);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1073;
        }
        if (obj1 == null || !e.d()) goto _L4; else goto _L3
_L3:
        if (e.d.compareTo("Motion") != 0 || !e.b("Colorize")) goto _L6; else goto _L5
_L5:
        Object obj = com.socialin.android.util.c.a(point.x, point.y, android.graphics.Bitmap.Config.ARGB_8888);
        if (obj == null) goto _L8; else goto _L7
_L7:
        boolean flag = EffectsFactory.applyMotionOrigEffectRenderscript(e, d, obj1, ((Bitmap) (obj3)), ((Bitmap) (obj)), null, 1.0F);
_L10:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        f = e.a(d, obj1, ((Bitmap) (obj3)), ((Bitmap) (obj2)));
        Log.e("ex1", "renderScript apply");
        obj1 = obj;
_L11:
        obj = obj1;
        if (b)
        {
            Log.e("ex1", "BitmapManager.recycle(resultBitmap);");
            com.socialin.android.util.c.a(((Bitmap) (obj2)));
            if (obj1 != null)
            {
                com.socialin.android.util.c.a(((Bitmap) (obj1)));
            }
            return null;
        }
          goto _L9
_L8:
        flag = false;
          goto _L10
        obj1;
        obj = null;
_L12:
        ((TimeoutException) (obj1)).printStackTrace();
        obj1 = obj;
          goto _L11
_L4:
        obj = null;
_L9:
        if (!f && e.f())
        {
            obj1 = e.a(d, ((Bitmap) (obj3)), ((Bitmap) (obj2)));
            if (obj1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f = flag;
            Log.e("ex1", "bitmap apply");
        } else
        {
            obj1 = obj2;
        }
        if (!f && e.e())
        {
            obj2 = myobfuscated.cj.a.a();
            bytebuffer = ((a) (obj2)).a(point.x * point.y * 4);
            bytebuffer.rewind();
            ((Bitmap) (obj3)).copyPixelsToBuffer(bytebuffer);
            obj3 = ((a) (obj2)).a(point.x * point.y * 4);
            if (e.d.compareTo("Motion") == 0 && e.b("Colorize"))
            {
                obj = com.socialin.android.util.c.a(point.x, point.y, android.graphics.Bitmap.Config.ARGB_8888);
                if (obj != null)
                {
                    flag = EffectsFactory.applyMotionOrigEffect(e, d, bytebuffer, ((ByteBuffer) (obj3)), point.x, point.y, null, 1.0F, true, a);
                    if (flag)
                    {
                        ((ByteBuffer) (obj3)).rewind();
                        ((Bitmap) (obj)).copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
                    }
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = true;
            }
            if (flag)
            {
                f = e.a(d, bytebuffer, ((ByteBuffer) (obj3)), point.x, point.y, true, a);
            }
            ((ByteBuffer) (obj3)).rewind();
            ((Bitmap) (obj1)).copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
            ((a) (obj2)).a(bytebuffer);
            ((a) (obj2)).a(((ByteBuffer) (obj3)));
            Log.e("ex1", "native apply");
        }
_L13:
        if (f && !b)
        {
            if (obj1 != null)
            {
                myobfuscated.ay.e.a(((Bitmap) (obj1)), h.d, h.c);
                if (obj1 != h.a)
                {
                    com.socialin.android.util.c.a(((Bitmap) (obj1)));
                }
            }
            if (obj != null)
            {
                myobfuscated.ay.e.a(((Bitmap) (obj)), h.d, h.b);
                com.socialin.android.util.c.a(((Bitmap) (obj)));
            }
            if (!g)
            {
                bytebuffer1.rewind();
                bitmap.copyPixelsFromBuffer(bytebuffer1);
            }
        } else
        if (!g)
        {
            bytebuffer1.rewind();
            bitmap.copyPixelsFromBuffer(bytebuffer1);
        }
        l = System.currentTimeMillis() - l;
        Log.e("ex1", (new StringBuilder("time = ")).append(l).toString());
        return new Long(l);
_L2:
        if (obj1 != null && e.d())
        {
            try
            {
                f = e.a(d, obj1, bitmap, bitmap);
                Log.e("ex1", "renderScript apply");
                if (f && !b)
                {
                    ((ByteBuffer) (obj2)).position(0);
                    bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj2)));
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((TimeoutException) (obj)).printStackTrace();
            }
            if (b)
            {
                return null;
            }
        }
        if (!f && e.f())
        {
            obj = e.a(d, bitmap, null);
            if (obj != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f = flag;
            if (f && !b)
            {
                ((ByteBuffer) (obj2)).position(0);
                ((Bitmap) (obj)).copyPixelsToBuffer(((java.nio.Buffer) (obj2)));
            }
            Log.e("ex1", "bitmap apply");
        } else
        {
            obj = bitmap;
        }
        if (!f && e.e())
        {
            f = e.a(d, bytebuffer1, ((ByteBuffer) (obj2)), point1.x, point1.y, true, a);
            if (f && !b)
            {
                ((ByteBuffer) (obj2)).rewind();
                ((Bitmap) (obj)).copyPixelsFromBuffer(((java.nio.Buffer) (obj2)));
            }
            Log.e("ex1", "native apply");
        }
        obj1 = obj;
        obj = bytebuffer;
        break MISSING_BLOCK_LABEL_600;
        obj1;
          goto _L12
        obj1;
          goto _L12
_L6:
        flag = true;
        obj = null;
          goto _L10
        obj1 = obj2;
        obj = bytebuffer;
          goto _L13
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Long)obj;
        if (!b && i != null)
        {
            long l = 0L;
            if (obj != null)
            {
                l = ((Long) (obj)).longValue();
            }
            i.a(e, f, l);
        }
        if (a >= 0)
        {
            ImageOp.a(a);
            a = -1;
        }
    }

    protected final void onPreExecute()
    {
        a = ImageOp.a();
        if (e.d.compareTo("Motion") == 0 && e.b("Colorize"))
        {
            j.e = true;
        }
    }
}
