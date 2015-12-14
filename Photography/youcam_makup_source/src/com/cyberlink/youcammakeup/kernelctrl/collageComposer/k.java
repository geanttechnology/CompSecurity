// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.ROI;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.c;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.o;
import com.cyberlink.youcammakeup.utility.g;
import com.pf.common.utility.m;
import java.util.Queue;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            e, f, r, CollageTextPainter, 
//            q, g, j, p, 
//            o, h, i

class k extends AsyncTask
{

    final com.cyberlink.youcammakeup.kernelctrl.collageComposer.e a;
    private Context b;
    private Queue c;
    private i d;
    private com.cyberlink.youcammakeup.kernelctrl.collageComposer.o e;
    private Paint f;
    private Paint g;
    private float h;

    public k(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e e1, Context context, com.cyberlink.youcammakeup.kernelctrl.collageComposer.o o1, Queue queue, float f1, i l)
    {
        a = e1;
        super();
        c = null;
        d = null;
        e = null;
        f = new Paint(2);
        g = new Paint(2);
        b = context;
        e = o1;
        c = queue;
        d = l;
        h = f1;
    }

    private void a(Canvas canvas, f f1)
    {
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "blendCollageTextViewOnBitmap start");
        if (f1.a instanceof r)
        {
            r r1 = (r)f1.a;
            CollageTextPainter collagetextpainter = new CollageTextPainter(b);
            collagetextpainter.a(r1.a.a, r1.a.b);
            collagetextpainter.a(r1.f);
            collagetextpainter.a(f1.b);
            collagetextpainter.b(r1.g);
            collagetextpainter.b(r1.a.c, r1.a.d);
            collagetextpainter.b(r1.h);
            collagetextpainter.a(f1.c);
            collagetextpainter.a(canvas);
        }
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "blendCollageTextViewOnBitmap end");
    }

    private void a(Canvas canvas, com.cyberlink.youcammakeup.kernelctrl.collageComposer.g g1)
    {
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "blendCoverImageOnBitmap start");
        canvas.drawBitmap(g1.a, 0.0F, 0.0F, null);
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "blendCoverImageOnBitmap end");
    }

    private void a(Canvas canvas, j j1)
    {
        Object obj;
        int l;
        int i1;
        int k1;
        int l1;
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "blendPanZoomViewerOnBitmap start");
        obj = com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(j1.f), Boolean.valueOf(false));
        Object obj1 = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.a);
        l = j1.a.a.a;
        i1 = j1.a.a.b;
        k1 = l + j1.a.a.c;
        l1 = i1 + j1.a.a.d;
        boolean flag;
        if (j1.b == null)
        {
            Object obj2 = ViewEngine.a().a(j1.f);
            obj2 = com.cyberlink.youcammakeup.utility.g.b((int)((d) (obj2)).a.a, (int)((d) (obj2)).a.b, k1 - l, l1 - i1);
            obj1.a = new ROI((int)((RectF) (obj2)).left, (int)((RectF) (obj2)).top, (int)((RectF) (obj2)).width(), (int)((RectF) (obj2)).height());
        } else
        {
            obj1.a = j1.b.b;
        }
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "ViewEngine.getInstance().getEditBuffer() start");
        obj = ViewEngine.a().a(j1.f, 1.0D, ((com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting) (obj)), ((c) (obj1)));
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "ViewEngine.getInstance().getEditBuffer() end");
        if (j1.c == UIImageOrientation.a || j1.c == UIImageOrientation.b) goto _L2; else goto _L1
_L1:
        obj1 = new ImageBufferWrapper();
        flag = ((ImageBufferWrapper) (obj1)).a(((ImageBufferWrapper) (obj)), j1.c);
        ((ImageBufferWrapper) (obj)).m();
        obj = obj1;
        if (flag) goto _L2; else goto _L3
_L3:
        return;
_L2:
        if (obj != null)
        {
            Bitmap bitmap = Bitmap.createBitmap((int)((ImageBufferWrapper) (obj)).b(), (int)((ImageBufferWrapper) (obj)).c(), android.graphics.Bitmap.Config.ARGB_8888);
            ((ImageBufferWrapper) (obj)).c(bitmap);
            ((ImageBufferWrapper) (obj)).m();
            if (j1.d != null)
            {
                (new Canvas(bitmap)).drawBitmap(j1.d, null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), g);
            }
            canvas.drawBitmap(bitmap, null, new Rect(l, i1, k1, l1), f);
            bitmap.recycle();
            m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "blendPanZoomViewerOnBitmap end");
            return;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    protected transient Bitmap a(Void avoid[])
    {
        Canvas canvas;
        h h1;
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "doInBackground");
        try
        {
            avoid = Bitmap.createBitmap((int)((float)e.i * h), (int)((float)e.j * h), android.graphics.Bitmap.Config.ARGB_8888);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return null;
        }
        canvas = new Canvas(avoid);
        canvas.scale(h, h);
        canvas.drawColor(e.h);
        g.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "start traverse pending queue");
_L2:
        if (c.isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        h1 = (h)c.poll();
        if (h1 instanceof j)
        {
            a(canvas, (j)h1);
            continue; /* Loop/switch isn't completed */
        }
        if (h1 instanceof com.cyberlink.youcammakeup.kernelctrl.collageComposer.g)
        {
            a(canvas, (com.cyberlink.youcammakeup.kernelctrl.collageComposer.g)h1);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (h1 instanceof f)
            {
                a(canvas, (f)h1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            m.b(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "ProcessExportTask", avoid);
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "end traverse pending queue");
        return avoid;
    }

    protected void a(Bitmap bitmap)
    {
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), (new StringBuilder()).append("onPostExecute = ").append(bitmap).toString());
        if (bitmap == null)
        {
            d.a("OutOfMemoryError when blending bitmap");
            return;
        } else
        {
            d.a(bitmap);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    public void onCancelled()
    {
        m.e(com.cyberlink.youcammakeup.kernelctrl.collageComposer.e.a(a), "onCancelled");
        d.a();
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }
}
