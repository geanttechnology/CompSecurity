// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.Context;
import android.os.Debug;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.pf.common.utility.m;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            l, CollageLayout, j, p, 
//            m, g, CollageTextView, f, 
//            CollageTextPainter, k, i

public class e
{

    private String a;
    private ExecutorService b;

    private e()
    {
        a = "CollageExporter";
        b = Executors.newFixedThreadPool(1);
    }


    public static e a()
    {
        return l.a();
    }

    static String a(e e1)
    {
        return e1.a;
    }

    public void a(Context context, CollageLayout collagelayout, float f1, i i)
    {
        m.e(a, (new StringBuilder()).append("generateBlendedBitmap").append(collagelayout).toString());
        long l1 = Runtime.getRuntime().totalMemory();
        m.e(a, (new StringBuilder()).append("totalMemory:").append(l1).toString());
        l1 = Runtime.getRuntime().totalMemory();
        long l2 = Runtime.getRuntime().freeMemory();
        m.e(a, (new StringBuilder()).append("totalMemory (in-used):").append(l1 - l2).toString());
        m.e(a, (new StringBuilder()).append("nativeHeapAllocatedSize:").append(Debug.getNativeHeapAllocatedSize()).toString());
        m.e(a, (new StringBuilder()).append("nativeHeapSize:").append(Debug.getNativeHeapSize()).toString());
        o o = collagelayout.getTemplate();
        LinkedBlockingQueue linkedblockingqueue = new LinkedBlockingQueue();
        int k1 = collagelayout.getChildCount();
        int i1 = 0;
        while (i1 < k1) 
        {
            Object obj = collagelayout.getChildAt(collagelayout.getChildDrawingOrder(k1, i1));
            m.e(a, (new StringBuilder()).append("child is ").append(obj).toString());
            if (obj instanceof PanZoomViewer)
            {
                obj = (PanZoomViewer)obj;
                q q1 = ((PanZoomViewer) (obj)).getCurImageInfo();
                com.cyberlink.youcammakeup.kernelctrl.collageComposer.m m1 = collagelayout.a(Integer.valueOf(obj.hashCode()));
                j j1 = new j(this);
                j1.b = ((PanZoomViewer) (obj)).getCurEngineROIInfo();
                j1.f = q1.a;
                j1.c = q1.d;
                j1.a = (p)((PanZoomViewer) (obj)).getTag();
                if (m1 != null)
                {
                    obj = collagelayout.a(m1.a);
                } else
                {
                    obj = null;
                }
                j1.d = ((android.graphics.Bitmap) (obj));
                linkedblockingqueue.add(j1);
            } else
            if (obj instanceof ImageView)
            {
                obj = new g(this);
                obj.a = collagelayout.getCoverImage();
                linkedblockingqueue.add(obj);
            } else
            if (obj instanceof CollageTextView)
            {
                Object obj1 = (CollageTextView)obj;
                obj = new f(this);
                obj.a = (p)((CollageTextView) (obj1)).getTag();
                obj1 = ((CollageTextView) (obj1)).getTextPainter();
                obj.b = ((CollageTextPainter) (obj1)).g;
                obj.c = ((CollageTextPainter) (obj1)).i;
                linkedblockingqueue.add(obj);
            }
            i1++;
        }
        m.e(a, "Execute export task in worker thread");
        (new k(this, context, o, linkedblockingqueue, f1, i)).executeOnExecutor(b, new Void[0]);
    }
}
