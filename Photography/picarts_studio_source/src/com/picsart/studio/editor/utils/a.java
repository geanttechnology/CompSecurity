// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.SparseIntArray;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.EditorAction;
import com.picsart.studio.gifencoder.GifEncoder;
import com.socialin.android.util.ModernAsyncTask;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.utils:
//            b

public final class a
{

    e a;
    public com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions b;
    GifEncoder c;
    public b d;
    Canvas e;
    Bitmap f;
    int g[];
    public volatile int h;
    public int i;
    public boolean j;
    public ModernAsyncTask k;
    private Matrix l;
    private RectF m;
    private RectF n;
    private Paint o;

    public a(e e1, com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions, GifEncoder gifencoder, b b1)
    {
        h = 0;
        j = false;
        a = e1;
        b = gifoptions;
        c = gifencoder;
        d = b1;
        l = new Matrix();
        m = new RectF();
        n = new RectF();
        o = new Paint(2);
    }

    static void a(a a1, Bitmap bitmap)
    {
        bitmap.getPixels(a1.g, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        a1.c.addFrame(a1.g);
    }

    static void a(a a1, Bitmap bitmap, Bitmap bitmap1)
    {
        a1.m.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
        a1.n.set(0.0F, 0.0F, bitmap1.getWidth(), bitmap1.getHeight());
        a1.l.setRectToRect(a1.m, a1.n, android.graphics.Matrix.ScaleToFit.CENTER);
        a1.e.drawBitmap(bitmap, a1.l, a1.o);
    }

    public final void a()
    {
        if (k != null)
        {
            k.cancel(true);
        }
    }

    // Unreferenced inner class com/picsart/studio/editor/utils/a$1

/* anonymous class */
    public final class _cls1 extends ModernAsyncTask
    {

        private a a;

        private transient Boolean a()
        {
            Object obj;
            Object obj1;
            Object obj2;
            obj1 = a;
            obj = new Point(((a) (obj1)).a.a.b());
            obj2 = ((a) (obj1)).a.c.e();
            obj1 = new SparseIntArray();
            obj2 = ((List) (obj2)).iterator();
_L20:
            if (!((Iterator) (obj2)).hasNext()) goto _L2; else goto _L1
_L1:
            ((EditorAction)((Iterator) (obj2)).next()).getOutSize(((Point) (obj)));
            if (((Point) (obj)).x <= 512 && ((Point) (obj)).y <= 512) goto _L4; else goto _L3
_L3:
            if (((Point) (obj)).x <= ((Point) (obj)).y) goto _L6; else goto _L5
_L5:
            int j1 = 512;
            int i1 = (int)((512F * (float)((Point) (obj)).y) / (float)((Point) (obj)).x);
_L7:
            ((Point) (obj)).set(j1, i1);
_L4:
            i1 = (int)(((float)((Point) (obj)).y * 1024F) / (float)((Point) (obj)).x);
            ((SparseIntArray) (obj1)).put(i1, ((SparseIntArray) (obj1)).get(i1) + 1);
            continue; /* Loop/switch isn't completed */
            obj;
            if (a.c != null)
            {
                a.c.close();
            }
            throw obj;
_L6:
            i1 = 512;
            j1 = (int)((512F * (float)((Point) (obj)).x) / (float)((Point) (obj)).y);
              goto _L7
_L2:
            j1 = ((SparseIntArray) (obj1)).size() - 1;
            i1 = 0;
_L18:
            if (i1 >= ((SparseIntArray) (obj1)).size())
            {
                break MISSING_BLOCK_LABEL_266;
            }
            int k1 = j1;
            if (((SparseIntArray) (obj1)).valueAt(i1) > ((SparseIntArray) (obj1)).valueAt(j1))
            {
                k1 = i1;
            }
            break MISSING_BLOCK_LABEL_890;
            float f1;
            int l1;
            ((Point) (obj)).set(1024, ((SparseIntArray) (obj1)).keyAt(j1));
            obj1 = a.a.c.e();
            l1 = ((List) (obj1)).size() + 1;
            f1 = (float)l1 / 10F;
            if (a.c.init(a.b.getOutputPath(), ((Point) (obj)).x, ((Point) (obj)).y, a.b.getCOLORMX(), a.b.getQuality(), (int)a.b.getDelay()) == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_862;
            }
            a.f = Bitmap.createBitmap(((Point) (obj)).x, ((Point) (obj)).y, android.graphics.Bitmap.Config.ARGB_8888);
            a.g = new int[((Point) (obj)).x * ((Point) (obj)).y];
            a.e = new Canvas(a.f);
            if (!isCancelled()) goto _L9; else goto _L8
_L8:
            a.c.cancelGifGeneration(a.b.getOutputPath());
            obj1 = Boolean.valueOf(false);
            obj = obj1;
            if (a.c != null)
            {
                a.c.close();
                obj = obj1;
            }
_L15:
            return ((Boolean) (obj));
_L9:
            obj = Bitmap.createScaledBitmap(a.a.a.a(), ((Point) (obj)).x, ((Point) (obj)).y, true);
            a.a(a, ((Bitmap) (obj)), a.f);
            if (isCancelled()) goto _L11; else goto _L10
_L10:
            a.a(a, a.f);
            publishProgress(new Integer[] {
                Integer.valueOf((int)(100F / (float)l1))
            });
            j1 = 0;
            k1 = 1;
            i1 = 1;
_L16:
            if (j1 >= ((List) (obj1)).size())
            {
                break MISSING_BLOCK_LABEL_834;
            }
            if (!isCancelled()) goto _L13; else goto _L12
_L12:
            a.c.cancelGifGeneration(a.b.getOutputPath());
            obj1 = Boolean.valueOf(false);
            obj = obj1;
            if (a.c == null) goto _L15; else goto _L14
_L14:
            a.c.close();
            return ((Boolean) (obj1));
_L11:
            a.c.cancelGifGeneration(a.b.getOutputPath());
            obj1 = Boolean.valueOf(false);
            obj = obj1;
            if (a.c != null)
            {
                a.c.close();
                return ((Boolean) (obj1));
            }
              goto _L15
_L13:
            if ((int)((float)i1 * f1) != k1 && l1 >= 10)
            {
                break MISSING_BLOCK_LABEL_792;
            }
            obj = ((EditorAction)((List) (obj1)).get(j1)).apply(((Bitmap) (obj)));
            a.f.eraseColor(0);
            a.a(a, ((Bitmap) (obj)), a.f);
            a.a(a, a.f);
            i1++;
            publishProgress(new Integer[] {
                Integer.valueOf((int)((100F * (float)(j1 + 2)) / (float)l1))
            });
            k1++;
            j1++;
              goto _L16
            a.a(a, a.f);
            ((Bitmap) (obj)).recycle();
            a.f.recycle();
            if (a.c != null)
            {
                a.c.close();
            }
            return Boolean.valueOf(true);
            i1++;
            j1 = k1;
            if (true) goto _L18; else goto _L17
_L17:
            if (true) goto _L20; else goto _L19
_L19:
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected final volatile void onCancelled(Object obj)
        {
            a.h = 1;
            a.j = false;
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (Boolean)obj;
            super.onPostExecute(obj);
            a.j = true;
            a.h = 1;
            if (((Boolean) (obj)).booleanValue())
            {
                a.d.a(a.b);
                return;
            } else
            {
                a.d.a();
                return;
            }
        }

        protected final void onPreExecute()
        {
            super.onPreExecute();
            a.j = false;
            a.h = 0;
        }

        protected final void onProgressUpdate(Object aobj[])
        {
            aobj = (Integer[])aobj;
            super.onProgressUpdate(aobj);
            a.i = ((Integer) (aobj[0])).intValue();
            a.d.a(((Integer) (aobj[0])).intValue());
        }

            public 
            {
                a = a.this;
                super();
            }
    }

}
