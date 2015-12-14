// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.ay.e;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            b

public final class a
{

    Activity a;
    ByteBuffer b;
    Bitmap c;
    Bitmap d;
    Paint e;
    Canvas f;
    ArrayList g;
    int h;
    int i;
    boolean j;
    boolean k;
    boolean l;
    private int m;
    private int n;

    public a(Activity activity, Bitmap bitmap)
    {
        b = null;
        c = null;
        d = null;
        j = false;
        k = false;
        l = false;
        a = activity;
        b = ImageOpCommon.allocNativeBuffer(bitmap.getWidth() * bitmap.getHeight() * 4);
        m = bitmap.getWidth();
        n = bitmap.getHeight();
        d = bitmap;
        b.position(0);
        bitmap.copyPixelsToBuffer(b);
        g = new ArrayList();
        h = 240;
        i = 20;
        e = new Paint();
        e.setAntiAlias(true);
        e.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        e.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        f = new Canvas(d);
        a(b, h, i);
    }

    static void a(a a1)
    {
        if (a1.b != null)
        {
            a1.b.position(0);
            if (a1.d != null && !a1.d.isRecycled() && a1.b != null)
            {
                a1.d.copyPixelsFromBuffer(a1.b);
            }
            if (!a1.a.isFinishing())
            {
                PorterDuffXfermode porterduffxfermode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
                a1.e.setXfermode(porterduffxfermode);
                a1.a(a1.f, a1.e);
                if (!a1.a.isFinishing())
                {
                    PorterDuffXfermode porterduffxfermode1 = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER);
                    a1.e.setXfermode(porterduffxfermode1);
                    a1.f.drawBitmap(a1.c, 0.0F, 0.0F, a1.e);
                }
            }
        }
    }

    public final HashMap a(HashMap hashmap, String s, int i1, String s1, String s2, int j1)
    {
        HashMap hashmap1;
        Object obj1;
        int ai[];
        j = true;
        obj1 = null;
        ai = new int[2];
        hashmap1 = null;
        hashmap = myobfuscated.ay.e.a(s, i1, hashmap, j1);
        hashmap1 = hashmap;
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        hashmap1 = hashmap;
        Log.e("ex1", (new StringBuilder("EyeReplacer maxSizeBitmap size w = ")).append(hashmap.getWidth()).append(" h = ").append(hashmap.getHeight()).toString());
        hashmap1 = hashmap;
_L2:
        hashmap = obj1;
        if (hashmap1 == null)
        {
            break MISSING_BLOCK_LABEL_581;
        }
        hashmap = obj1;
        if (hashmap1.isRecycled())
        {
            break MISSING_BLOCK_LABEL_581;
        }
        ai[0] = hashmap1.getWidth();
        ai[1] = hashmap1.getHeight();
        s = ImageOpCommon.allocNativeBuffer(hashmap1.getWidth() * hashmap1.getHeight() * 4);
        s.position(0);
        hashmap1.copyPixelsToBuffer(s);
        s.position(0);
        com.socialin.android.util.c.a(hashmap1, "EyeReplacer");
        if (a.isFinishing())
        {
            ImageOpCommon.freeNativeBuffer(s);
            return null;
        }
        break; /* Loop/switch isn't completed */
        hashmap;
        hashmap.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        hashmap = com.socialin.android.util.c.a(m, n, android.graphics.Bitmap.Config.ARGB_8888);
        Object obj = new Canvas(hashmap);
        ((Canvas) (obj)).drawARGB(255, 0, 0, 0);
        Object obj2 = new Paint();
        ((Paint) (obj2)).setAntiAlias(true);
        ((Paint) (obj2)).setStrokeJoin(android.graphics.Paint.Join.ROUND);
        ((Paint) (obj2)).setStrokeCap(android.graphics.Paint.Cap.ROUND);
        ((Paint) (obj2)).setColor(Color.argb(255, 255, 255, 255));
        a(((Canvas) (obj)), ((Paint) (obj2)));
        if (a.isFinishing())
        {
            if (s != null)
            {
                ImageOpCommon.freeNativeBuffer(s);
            }
            if (hashmap != null && !hashmap.isRecycled())
            {
                com.socialin.android.util.c.a(hashmap, "EyeReplacer");
            }
            return null;
        }
        obj2 = ImageOpCommon.allocNativeBuffer(hashmap.getWidth() * hashmap.getHeight() * 4);
        ((ByteBuffer) (obj2)).position(0);
        hashmap.copyPixelsToBuffer(((java.nio.Buffer) (obj2)));
        com.socialin.android.util.c.a(hashmap, "EyeReplacer");
        obj = ImageOpCommon.allocNativeBuffer(s.capacity());
        ((ByteBuffer) (obj2)).position(0);
        ((ByteBuffer) (obj)).position(0);
        ImageResize.resize(((ByteBuffer) (obj2)), m, n, ((ByteBuffer) (obj)), ai[0], ai[1], 0);
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj2)));
        if (a.isFinishing())
        {
            if (s != null)
            {
                ImageOpCommon.freeNativeBuffer(s);
            }
            if (obj != null)
            {
                ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            }
            return null;
        }
        obj2 = ImageOpCommon.allocNativeBuffer(s.capacity());
        s.position(0);
        ((ByteBuffer) (obj2)).position(0);
        ImageOpCommon.changebufferHSL(s, ((java.nio.Buffer) (obj2)), ai[0], ai[1], h, i, 0);
        if (a.isFinishing())
        {
            if (s != null)
            {
                ImageOpCommon.freeNativeBuffer(s);
            }
            if (obj != null)
            {
                ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
            }
            if (obj2 != null)
            {
                ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj2)));
            }
            return null;
        }
        s.position(0);
        ((ByteBuffer) (obj2)).position(0);
        if (s1 != null)
        {
            ImageOp.blend4mix2(s, ((java.nio.Buffer) (obj2)), ((java.nio.Buffer) (obj)), 0, ai[0], ai[1], s1, ai[0], ai[1]);
            hashmap = null;
        } else
        {
            s1 = ImageOpCommon.allocNativeBuffer(s.capacity());
            s1.position(0);
            ImageOp.blend4buf(s, ((java.nio.Buffer) (obj2)), ((java.nio.Buffer) (obj)), 0, ai[0], ai[1], s1, ai[0], ai[1]);
            hashmap = w.a(s2, s1, ai[0], ai[1]);
            ImageOpCommon.freeNativeBuffer(s1);
        }
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj2)));
        ImageOpCommon.freeNativeBuffer(s);
        ImageOpCommon.freeNativeBuffer(((ByteBuffer) (obj)));
        j = false;
        return hashmap;
    }

    final void a(Canvas canvas, Paint paint)
    {
        int i1 = 0;
        do
        {
            if (i1 >= g.size())
            {
                break;
            }
            b b1 = (b)g.get(i1);
            canvas.drawCircle(b1.a, b1.b, b1.c, paint);
            if (a.isFinishing())
            {
                break;
            }
            i1++;
        } while (true);
    }

    final void a(ByteBuffer bytebuffer, int i1, int j1)
    {
        if (!a.isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ByteBuffer bytebuffer1;
        bytebuffer1 = ImageOpCommon.allocNativeBuffer(m * n * 4);
        bytebuffer.position(0);
        if (!a.isFinishing())
        {
            break; /* Loop/switch isn't completed */
        }
        if (bytebuffer1 != null)
        {
            ImageOpCommon.freeNativeBuffer(bytebuffer1);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        k = true;
        ImageOpCommon.changebufferHSL(bytebuffer, bytebuffer1, m, n, i1, j1, 0);
        k = false;
        if (l)
        {
            ImageOpCommon.freeNativeBuffer(bytebuffer);
            b = null;
            l = false;
        }
        if (!a.isFinishing())
        {
            break; /* Loop/switch isn't completed */
        }
        if (bytebuffer1 != null)
        {
            ImageOpCommon.freeNativeBuffer(bytebuffer1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (c == null || c != null && c.isRecycled() && !a.isFinishing())
        {
            c = com.socialin.android.util.c.a(m, n, android.graphics.Bitmap.Config.ARGB_8888, "EyeReplacer");
        }
        if (a.isFinishing())
        {
            if (bytebuffer1 != null)
            {
                ImageOpCommon.freeNativeBuffer(bytebuffer1);
            }
            if (c != null && !c.isRecycled())
            {
                com.socialin.android.util.c.a(c, "EyeReplacer");
                c = null;
                return;
            }
        } else
        {
            bytebuffer1.position(0);
            a.runOnUiThread(new Runnable(bytebuffer1) {

                private ByteBuffer a;
                private a b;

                public final void run()
                {
                    b.c.copyPixelsFromBuffer(a);
                    ImageOpCommon.freeNativeBuffer(a);
                }

            
            {
                b = a.this;
                a = bytebuffer;
                super();
            }
            });
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    // Unreferenced inner class com/picsart/effects/eyereplacer/a$2

/* anonymous class */
    final class _cls2
        implements Runnable
    {

        private a a;

        public final void run()
        {
            a.a(a);
        }

            
            {
                a = a.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/effects/eyereplacer/a$3

/* anonymous class */
    final class _cls3
        implements Runnable
    {

        private a a;

        public final void run()
        {
            a.a(a);
        }

            
            {
                a = a.this;
                super();
            }
    }

}
