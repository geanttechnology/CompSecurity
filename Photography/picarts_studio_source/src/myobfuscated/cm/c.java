// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Xfermode;
import android.util.Log;
import com.photo.effect.Effect;
import com.picsart.effectnew.n;
import com.socialin.android.photo.effects.factory.b;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import myobfuscated.ay.e;
import myobfuscated.cj.a;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.cm:
//            d, i, l, k, 
//            e, m, n

public final class c
{

    public ThreadPoolExecutor a;
    public Context b;
    public i c;
    public myobfuscated.ck.c d;
    public boolean e;

    public c(Context context, ThreadPoolExecutor threadpoolexecutor, myobfuscated.ck.c c1)
    {
        e = false;
        b = context;
        a = threadpoolexecutor;
        d = c1;
    }

    static void a(int j, int k, ByteBuffer bytebuffer, ByteBuffer bytebuffer1, ByteBuffer bytebuffer2, Xfermode xfermode)
    {
        Log.e("ex1", "***************");
        Log.e("ex1", "blendEffect");
        Log.e("ex1", "***************");
        Bitmap bitmap = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap != null)
        {
            Log.e("ex1", "destBitmap != null");
            Bitmap bitmap1 = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
            if (bitmap1 != null)
            {
                Log.e("ex1", "blendBitmap != null");
                bytebuffer.rewind();
                bitmap1.copyPixelsFromBuffer(bytebuffer);
                bytebuffer1.rewind();
                bitmap.copyPixelsFromBuffer(bytebuffer1);
                bytebuffer = new Canvas(bitmap1);
                bytebuffer1 = new Paint(2);
                bytebuffer1.setXfermode(xfermode);
                bytebuffer.drawBitmap(bitmap, 0.0F, 0.0F, bytebuffer1);
                bytebuffer2.rewind();
                bitmap1.copyPixelsToBuffer(bytebuffer2);
                com.socialin.android.util.c.a(bitmap1);
                com.socialin.android.util.c.a(bitmap);
            }
        }
    }

    static void a(d d1, int j)
    {
        android.graphics.PorterDuffXfermode porterduffxfermode = com.socialin.android.photo.effects.factory.b.a(j);
        if (porterduffxfermode != null)
        {
            Log.e("ex1", "porderDuffMode != null");
            Log.e("ex1", (new StringBuilder("effectBlendModeIndex = ")).append(j).toString());
            Bitmap bitmap = com.socialin.android.util.c.a(d1.c, android.graphics.Bitmap.Config.ARGB_8888);
            if (bitmap != null)
            {
                d1.c.eraseColor(0xff000000);
                Canvas canvas = new Canvas(d1.c);
                Paint paint = new Paint(2);
                canvas.drawBitmap(d1.b, 0.0F, 0.0F, paint);
                paint.setXfermode(porterduffxfermode);
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
            }
        }
    }

    public final void a()
    {
        if (c != null)
        {
            i j = c;
            if (!j.b)
            {
                j.b = true;
                if (j.a >= 0)
                {
                    Log.e("ex1", (new StringBuilder("cancelTask() taskId = ")).append(j.a).toString());
                    ImageOp.interruptEffectInstance(j.a);
                }
            }
            c = null;
        }
    }

    public final void a(String s, Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressformat, ArrayList arraylist, l l)
    {
        (new ModernAsyncTask(l) {

            private l a;

            protected final Object doInBackground(Object aobj[])
            {
                String s1 = (String)aobj[0];
                Bitmap bitmap1 = (Bitmap)aobj[1];
                android.graphics.Bitmap.CompressFormat compressformat1 = (android.graphics.Bitmap.CompressFormat)aobj[2];
                aobj = (Context)aobj[3];
                long l1 = System.currentTimeMillis();
                boolean flag = w.a(new File(s1), bitmap1, compressformat1, ((Context) (aobj)));
                com.socialin.android.util.c.a(bitmap1);
                if (flag)
                {
                    myobfuscated.ay.e.a();
                }
                long l2 = System.currentTimeMillis();
                return ((Object) (new Object[] {
                    s1, new Boolean(flag), new Long(l2 - l1)
                }));
            }

            protected final void onPostExecute(Object obj)
            {
                Object aobj[] = (Object[])obj;
                obj = (String)aobj[0];
                boolean flag = ((Boolean)aobj[1]).booleanValue();
                Long long1 = (Long)aobj[2];
                myobfuscated.cm.n n1 = new myobfuscated.cm.n();
                n1.c = ((String) (obj));
                if (a != null)
                {
                    a.a(null, flag, n1, long1.longValue());
                }
            }

            
            {
                a = l1;
                super();
            }
        }).execute(new Object[] {
            s, bitmap, compressformat, b, arraylist
        });
    }

    // Unreferenced inner class myobfuscated/cm/c$1

/* anonymous class */
    public final class _cls1 extends ModernAsyncTask
    {

        private d a;
        private int b;
        private k c;

        protected final volatile Object doInBackground(Object aobj[])
        {
            return null;
        }

        protected final void onPostExecute(Object obj)
        {
            if (a.j != null)
            {
                a.j.rewind();
                a.c.copyPixelsFromBuffer(a.j);
                myobfuscated.cm.c.a(a, b);
            }
            if (c != null)
            {
                c.a();
            }
        }

            public 
            {
                a = d1;
                b = j;
                c = k1;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/cm/c$2

/* anonymous class */
    public final class _cls2 extends ModernAsyncTask
    {

        private myobfuscated.cm.e a;
        private Effect b;

        protected final Object doInBackground(Object aobj[])
        {
            Bitmap bitmap = (Bitmap)aobj[0];
            String s = (String)aobj[1];
            ByteBuffer bytebuffer = (ByteBuffer)aobj[3];
            Bitmap bitmap1 = (Bitmap)aobj[4];
            Bitmap bitmap2 = (Bitmap)aobj[5];
            Bitmap bitmap3 = (Bitmap)aobj[6];
            aobj = (ByteBuffer)aobj[7];
            long l = System.currentTimeMillis();
            m.a(((ByteBuffer) (aobj)), bitmap);
            aobj = android.graphics.Bitmap.CompressFormat.PNG;
            n n1 = new n();
            n1.a = false;
            aobj = w.a(s, bitmap);
            n1.a = true;
            n1.b = ((java.util.HashMap) (aobj));
            long l1;
            if (n1.a)
            {
                aobj = new myobfuscated.cj.c(null, 0, n1.b);
                bytebuffer.rewind();
                bitmap.copyPixelsToBuffer(bytebuffer);
                ImageOpCommon.changeBufferAlphaChannelWithAlpha(bytebuffer, bitmap.getWidth() * bitmap.getHeight(), 255);
                bytebuffer.rewind();
                bitmap.copyPixelsFromBuffer(bytebuffer);
                myobfuscated.ay.e.a(bitmap, bitmap3, bitmap2);
                myobfuscated.ay.e.a(bitmap, bitmap3, bitmap1);
            } else
            {
                aobj = null;
            }
            com.socialin.android.util.c.a(bitmap);
            l1 = System.currentTimeMillis();
            return ((Object) (new Object[] {
                Boolean.valueOf(n1.a), aobj, new Long(l1 - l)
            }));
        }

        protected final void onPostExecute(Object obj)
        {
            obj = ((Object) ((Object[])obj));
            Log.e("ex1", "apply effect small size OnPostExecute");
            boolean flag = ((Boolean)obj[0]).booleanValue();
            myobfuscated.cj.c c1 = (myobfuscated.cj.c)obj[1];
            long l = ((Long)obj[2]).longValue();
            a.a(c1, flag, l, false);
        }

            public 
            {
                a = e1;
                b = effect;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/cm/c$3

/* anonymous class */
    public final class _cls3 extends ModernAsyncTask
    {

        private Bitmap a;
        private myobfuscated.cm.m b;
        private c c;

        protected final Object doInBackground(Object aobj[])
        {
            long l = System.currentTimeMillis();
            myobfuscated.cj.c c1 = (myobfuscated.cj.c)aobj[0];
            int j = ((Integer)aobj[1]).intValue();
            Bitmap bitmap = (Bitmap)aobj[2];
            Bitmap bitmap1 = (Bitmap)aobj[3];
            Bitmap bitmap2 = (Bitmap)aobj[4];
            ByteBuffer bytebuffer = (ByteBuffer)aobj[5];
            long l1;
            boolean flag;
            if (a != null)
            {
                aobj = a;
            } else
            {
                aobj = myobfuscated.ay.e.a(c1.c, c1.a, c1.b, j);
            }
            if (aobj != null && !((Bitmap) (aobj)).isRecycled())
            {
                (new Canvas(bitmap)).drawBitmap(((Bitmap) (aobj)), 0.0F, 0.0F, new Paint(2));
                com.socialin.android.util.c.a(((Bitmap) (aobj)));
                bytebuffer.rewind();
                bitmap.copyPixelsToBuffer(bytebuffer);
                myobfuscated.ay.e.a(bitmap, bitmap1, bitmap2);
                flag = true;
            } else
            {
                flag = false;
            }
            l1 = System.currentTimeMillis();
            return ((Object) (new Object[] {
                new Boolean(flag), new Long(l1 - l)
            }));
        }

        protected final void onPostExecute(Object obj)
        {
            Object aobj[] = (Object[])obj;
            obj = (Boolean)aobj[0];
            Long long1 = (Long)aobj[1];
            if (((Boolean) (obj)).booleanValue())
            {
                c.e = false;
            }
            if (b != null)
            {
                b.a(((Boolean) (obj)).booleanValue(), long1.longValue());
            }
        }

            public 
            {
                c = c.this;
                a = bitmap;
                b = m1;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/cm/c$4

/* anonymous class */
    public final class _cls4 extends ModernAsyncTask
    {

        private boolean a;
        private int b;
        private l c;

        protected final Object doInBackground(Object aobj[])
        {
            myobfuscated.cj.c c1;
            Object obj;
            Context context;
            Object obj1;
            java.util.HashMap hashmap;
            String s;
            int j;
            long l1;
            c1 = (myobfuscated.cj.c)aobj[0];
            obj1 = c1.a;
            j = c1.b;
            hashmap = c1.c;
            obj = (android.graphics.Bitmap.CompressFormat)aobj[1];
            context = (Context)aobj[2];
            s = (String)aobj[3];
            l1 = System.currentTimeMillis();
            aobj = new myobfuscated.cm.n();
            if (!a) goto _L2; else goto _L1
_L1:
            boolean flag;
            obj = myobfuscated.ay.e.a(((String) (obj1)), j, hashmap, b);
            long l2;
            if (obj != null && !((Bitmap) (obj)).isRecycled())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aobj.a = ((Bitmap) (obj));
_L4:
            l2 = System.currentTimeMillis();
            return ((Object) (new Object[] {
                c1, aobj, new Boolean(flag), new Long(l2 - l1)
            }));
_L2:
            if (obj1 == null || j != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = myobfuscated.ay.e.a(context, ((String) (obj1)), s, ((android.graphics.Bitmap.CompressFormat) (obj)));
_L5:
            if (flag)
            {
                myobfuscated.ay.e.a();
            }
            aobj.c = s;
            if (true) goto _L4; else goto _L3
_L3:
            obj1 = myobfuscated.ay.e.a(((String) (obj1)), j, hashmap, b);
            if (obj1 != null)
            {
                flag = w.a(new File(s), ((Bitmap) (obj1)), ((android.graphics.Bitmap.CompressFormat) (obj)), context);
                com.socialin.android.util.c.a(((Bitmap) (obj1)));
            } else
            {
                flag = false;
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        protected final void onPostExecute(Object obj)
        {
            obj = ((Object) ((Object[])obj));
            myobfuscated.cj.c c1 = (myobfuscated.cj.c)obj[0];
            myobfuscated.cm.n n1 = (myobfuscated.cm.n)obj[1];
            boolean flag = ((Boolean)obj[2]).booleanValue();
            long l1 = ((Long)obj[3]).longValue();
            if (c != null)
            {
                c.a(c1, flag, n1, l1);
            }
        }

            public 
            {
                a = flag;
                b = j;
                c = l1;
                super();
            }
    }


    // Unreferenced inner class myobfuscated/cm/c$6

/* anonymous class */
    public final class _cls6 extends ModernAsyncTask
    {

        final l a;
        private d b;
        private boolean c;
        private Effect d;
        private int e;
        private ArrayList f;
        private boolean g;
        private String h;
        private android.graphics.Bitmap.CompressFormat i;
        private ArrayList j;
        private c k;

        private transient Object[] a()
        {
            Object obj;
            Object obj1;
            Point point;
            ByteBuffer bytebuffer;
            Point point1;
            Bitmap bitmap1;
            Object obj2;
            long l1;
            boolean flag2;
            bitmap1 = b.a;
            point = b.e;
            bytebuffer = b.g;
            point1 = b.f;
            obj = b.i;
            obj2 = b.k;
            l1 = System.currentTimeMillis();
            flag2 = true;
            Log.e("ex1", (new StringBuilder("applyEffect = ")).append(c).toString());
            if (!c)
            {
                break MISSING_BLOCK_LABEL_725;
            }
            Log.e("ex1", (new StringBuilder("origSize = ")).append(point.x).append(" : ").append(point.y).toString());
            obj1 = myobfuscated.cj.a.a().a(point.x * point.y * 4);
            boolean flag3 = false;
            boolean flag = false;
            flag2 = flag3;
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_281;
            }
            flag2 = flag3;
            if (!d.d())
            {
                break MISSING_BLOCK_LABEL_281;
            }
            flag2 = flag;
            obj = com.socialin.android.util.c.a(point.x, point.y, android.graphics.Bitmap.Config.ARGB_8888);
            boolean flag1;
            int i1;
            int j1;
            long l2;
            if (obj != null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag1 = flag2;
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_232;
            }
            flag1 = d.a(k.b, obj2, bitmap1, ((Bitmap) (obj)));
            flag2 = flag1;
            Log.e("ex1", "renderScript apply");
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_277;
            }
            flag2 = flag1;
            ((ByteBuffer) (obj1)).position(0);
            flag2 = flag1;
            ((Bitmap) (obj)).copyPixelsToBuffer(((java.nio.Buffer) (obj1)));
            flag2 = flag1;
            com.socialin.android.util.c.a(((Bitmap) (obj)));
            flag2 = flag1;
_L1:
            flag1 = flag2;
            if (!flag2)
            {
                flag1 = flag2;
                if (d.f())
                {
                    obj = d.a(k.b, bitmap1, null);
                    if (obj != null)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        ((ByteBuffer) (obj1)).position(0);
                        ((Bitmap) (obj)).copyPixelsToBuffer(((java.nio.Buffer) (obj1)));
                        if (obj != bitmap1)
                        {
                            com.socialin.android.util.c.a(((Bitmap) (obj)));
                        }
                    }
                    Log.e("ex1", "bitmap apply");
                }
            }
            flag2 = flag1;
            obj = obj1;
            if (flag1)
            {
                break MISSING_BLOCK_LABEL_725;
            }
            flag2 = flag1;
            obj = obj1;
            if (!d.e())
            {
                break MISSING_BLOCK_LABEL_725;
            }
            flag1 = d.a(k.b, bytebuffer, ((ByteBuffer) (obj1)), point.x, point.y, false, -1);
            Log.e("ex1", "native apply");
            obj = obj1;
_L2:
            obj1 = null;
            if (flag1)
            {
                Log.e("ex1", (new StringBuilder("effectsBlendModeIndex = ")).append(e).toString());
                obj1 = com.socialin.android.photo.effects.factory.b.a(e);
                if (obj1 != null)
                {
                    Log.e("ex1", "porderDuffMode != null");
                    myobfuscated.cm.c.a(point.x, point.y, bytebuffer, ((ByteBuffer) (obj)), ((ByteBuffer) (obj)), ((Xfermode) (obj1)));
                }
                obj1 = b.h;
                obj1 = m.a(d, point1, point, f, bytebuffer, ((ByteBuffer) (obj)), ((ByteBuffer) (obj1)));
            }
            i1 = point.x;
            j1 = point.y;
            flag2 = false;
            flag1 = false;
            if (obj1 != null)
            {
                Bitmap bitmap = com.socialin.android.util.c.a(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
                if (bitmap != null)
                {
                    ((ByteBuffer) (obj1)).position(0);
                    bitmap.copyPixelsFromBuffer(((java.nio.Buffer) (obj1)));
                    flag1 = true;
                }
                if (obj != b.i)
                {
                    myobfuscated.cj.a.a().a(((ByteBuffer) (obj)));
                }
                if (obj1 != obj && obj1 != b.i)
                {
                    myobfuscated.ay.e.a(((ByteBuffer) (obj1)));
                    Log.e("ex1", "saveBuffer != destBuffer && saveBuffer != input.destBuffer");
                    obj = bitmap;
                } else
                {
                    Log.e("ex1", "NOT NOT saveBuffer != destBuffer && saveBuffer != input.destBuffer");
                    obj = bitmap;
                }
            } else
            {
                if (obj != b.i)
                {
                    myobfuscated.cj.a.a().a(((ByteBuffer) (obj)));
                }
                obj = null;
                flag1 = flag2;
            }
            l2 = System.currentTimeMillis();
            return (new Object[] {
                new Boolean(flag1), obj, new Long(l2 - l1)
            });
            obj;
            ((TimeoutException) (obj)).printStackTrace();
              goto _L1
            flag1 = flag2;
              goto _L2
        }

        protected final Object doInBackground(Object aobj[])
        {
            return ((Object) (a()));
        }

        protected final void onPostExecute(Object obj)
        {
            Object aobj[] = (Object[])obj;
            boolean flag = ((Boolean)aobj[0]).booleanValue();
            obj = (Bitmap)aobj[1];
            long l1 = ((Long)aobj[2]).longValue();
            if (g)
            {
                myobfuscated.cm.n n1 = new myobfuscated.cm.n();
                n1.a = ((Bitmap) (obj));
                if (a != null)
                {
                    a.a(null, flag, n1, l1);
                }
            } else
            {
                if (flag)
                {
                    k.a(h, ((Bitmap) (obj)), i, j, new l(this, l1) {

                        private long a;
                        private _cls6 b;

                        public final void a(Object obj, boolean flag, myobfuscated.cm.n n, long l1)
                        {
    public final class _cls6 extends ModernAsyncTask
    {
                            b.a.a(obj, flag, n, l1 + a);
                        }

            
            {
                b = _pcls6;
                a = l1;
                super();
            }
                    });
                    return;
                }
                if (a != null)
                {
                    a.a(null, flag, null, l1);
                    return;
                }
            }
        }

            public 
            {
                k = c.this;
                b = d1;
                c = flag;
                d = effect;
                e = i1;
                f = arraylist;
                g = flag1;
                a = l1;
                h = s;
                i = compressformat;
                j = arraylist1;
                super();
            }
    }

}
