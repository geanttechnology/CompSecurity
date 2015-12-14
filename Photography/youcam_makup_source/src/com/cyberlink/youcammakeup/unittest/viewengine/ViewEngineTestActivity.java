// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.unittest.viewengine;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cyberlink.youcammakeup.kernelctrl.ROI;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.c;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.q;
import com.pf.common.utility.m;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.cyberlink.youcammakeup.unittest.viewengine:
//            a

public class ViewEngineTestActivity extends Activity
{

    private ViewEngine a;
    private InnerSurfaceView b;
    private TextView c;
    private final int d = 1;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private double j;
    private long k;
    private long l;
    private a m;

    public ViewEngineTestActivity()
    {
        e = -99;
        j = 1.0D;
    }

    private double a(long l1, long l2, long l3, long l4)
    {
        return Math.min(1.0D, Math.min((double)l3 / (double)l1, (double)l4 / (double)l2));
    }

    private String a(Uri uri)
    {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null)
        {
            return uri.getPath();
        } else
        {
            cursor.moveToFirst();
            uri = cursor.getString(cursor.getColumnIndex("_data"));
            cursor.close();
            return uri;
        }
    }

    private void a()
    {
        c.setText("");
    }

    static void a(ViewEngineTestActivity viewenginetestactivity)
    {
        viewenginetestactivity.a();
    }

    private void a(String s)
    {
        c.append(s);
    }

    private void b()
    {
        int i1 = (int)h / 4;
        int j1 = (int)h / 4;
        int k1 = (int)i;
        c c1 = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
        c1.a = new ROI(i1, 0, j1, k1);
        a.a(e, 0.57142857142799997D, g(), c1, m);
    }

    static void b(ViewEngineTestActivity viewenginetestactivity)
    {
        viewenginetestactivity.b();
    }

    private void c()
    {
        long l1 = (new Date()).getTime();
        Object obj = a.c(e);
        if (obj == null)
        {
            com.pf.common.utility.m.e("ViewEngineTestActivity", "UNEXPECTED ERROR!");
            return;
        } else
        {
            l1 = (new Date()).getTime() - l1;
            com.pf.common.utility.m.b("ViewEngineTestActivity", (new StringBuilder()).append("getTinyCache() spent time: ").append(l1).append(", w / h = ").append(((ImageBufferWrapper) (obj)).b()).append(" / ").append(((ImageBufferWrapper) (obj)).c()).toString());
            a((new StringBuilder()).append("getTinyCache() spent time: ").append(l1).append(", w / h = ").append(((ImageBufferWrapper) (obj)).b()).append(" / ").append(((ImageBufferWrapper) (obj)).c()).toString());
            Bitmap bitmap = Bitmap.createBitmap((int)((ImageBufferWrapper) (obj)).b(), (int)((ImageBufferWrapper) (obj)).c(), android.graphics.Bitmap.Config.ARGB_8888);
            ((ImageBufferWrapper) (obj)).c(bitmap);
            ((ImageBufferWrapper) (obj)).m();
            obj = new com.cyberlink.youcammakeup.unittest.viewengine.a(bitmap);
            com.cyberlink.youcammakeup.unittest.viewengine.InnerSurfaceView.a(b).offer(obj);
            return;
        }
    }

    static void c(ViewEngineTestActivity viewenginetestactivity)
    {
        viewenginetestactivity.d();
    }

    private void d()
    {
        j = a(h, i, k, l);
        c c1 = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
        a.a(e, j, f(), c1, m);
    }

    static void d(ViewEngineTestActivity viewenginetestactivity)
    {
        viewenginetestactivity.e();
    }

    private void e()
    {
        int i1 = (int)h / 4;
        int j1 = (int)i / 4;
        int k1 = (int)h / 2;
        int l1 = (int)i / 2;
        c c1 = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
        c1.a = new ROI(i1, j1, k1, l1);
        a.a(e, j, f(), c1, m);
    }

    static void e(ViewEngineTestActivity viewenginetestactivity)
    {
        viewenginetestactivity.c();
    }

    private DevelopSetting f()
    {
        return DevelopSetting.a();
    }

    static ViewEngine f(ViewEngineTestActivity viewenginetestactivity)
    {
        return viewenginetestactivity.a;
    }

    private DevelopSetting g()
    {
        return DevelopSetting.a();
    }

    static InnerSurfaceView g(ViewEngineTestActivity viewenginetestactivity)
    {
        return viewenginetestactivity.b;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j1 == -1)
        {
            try
            {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData()));
                f = bitmap.getWidth();
                g = bitmap.getHeight();
                double d1 = Math.min((double)2048L / (double)f, (double)2048L / (double)g);
                h = Math.round((double)f * d1);
                i = Math.round(d1 * (double)g);
                j = 1.0D;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
                throw new RuntimeException("DIE!");
            }
            k = b.getWidth();
            l = b.getHeight();
            intent = a(intent.getData());
            a.a(e, intent, f, g, h, i);
            intent = new c(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
            a.a(e, j, f(), intent, m);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030024);
        com.pf.common.utility.m.b("ViewEngineTestbed", "Activity onCreate");
        a = ViewEngine.a();
        b = (InnerSurfaceView)findViewById(0x7f0c01f3);
        c = (TextView)findViewById(0x7f0c01fa);
        ((Button)findViewById(0x7f0c01f4)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewEngineTestActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.a(a);
                view = new Intent("android.intent.action.GET_CONTENT");
                view.setType("image/*");
                a.startActivityForResult(view, 1);
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        });
        ((Button)findViewById(0x7f0c01f7)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewEngineTestActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.a(a);
                ViewEngineTestActivity.b(a);
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        });
        ((Button)findViewById(0x7f0c01f5)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewEngineTestActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.a(a);
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.c(a);
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        });
        ((Button)findViewById(0x7f0c01f6)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewEngineTestActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.a(a);
                ViewEngineTestActivity.d(a);
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        });
        findViewById(0x7f0c01f8).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewEngineTestActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.a(a);
                ViewEngineTestActivity.e(a);
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        });
        ((Button)findViewById(0x7f0c01f9)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewEngineTestActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.unittest.viewengine.ViewEngineTestActivity.a(a);
                ViewEngineTestActivity.f(a).a(99L, null, null);
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        });
        m = new a() {

            final ViewEngineTestActivity a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s, Object obj)
            {
                com.pf.common.utility.m.b("ViewEngineTestActivity", (new StringBuilder()).append("[veCallback.onCancel] ").append(taskcanceltype).append(" msg: ").append(s).toString());
            }

            public void a(q q1, Object obj)
            {
                if (q1 == null)
                {
                    com.pf.common.utility.m.b("ViewEngineTestActivity", "[veCallback.onComplete] veResult is null");
                    return;
                }
                q1 = q1.a();
                if (q1 == null || q1.j() == null)
                {
                    com.pf.common.utility.m.b("ViewEngineTestActivity", "[veCallback.onComplete] Cannot get imageBuffer from veResult");
                    return;
                } else
                {
                    obj = Bitmap.createBitmap((int)q1.b(), (int)q1.c(), android.graphics.Bitmap.Config.ARGB_8888);
                    q1.c(((Bitmap) (obj)));
                    q1.m();
                    q1 = new com.cyberlink.youcammakeup.unittest.viewengine.a(((Bitmap) (obj)));
                    boolean flag = com.cyberlink.youcammakeup.unittest.viewengine.InnerSurfaceView.a(ViewEngineTestActivity.g(a)).offer(q1);
                    com.pf.common.utility.m.b("ViewEngineTestActivity", (new StringBuilder()).append("push drawing task in onComplete. ret=").append(flag).toString());
                    return;
                }
            }

            public void a(String s, Object obj)
            {
                com.pf.common.utility.m.b("ViewEngineTestActivity", (new StringBuilder()).append("[veCallback.onError] msg: ").append(s).toString());
            }

            
            {
                a = ViewEngineTestActivity.this;
                super();
            }
        };
    }

    private class InnerSurfaceView extends SurfaceView
        implements android.view.SurfaceHolder.Callback
    {

        private SurfaceHolder a;
        private b b;
        private BlockingQueue c;

        static BlockingQueue a(InnerSurfaceView innersurfaceview)
        {
            return innersurfaceview.c;
        }

        private void a(Context context)
        {
            c = new LinkedBlockingQueue();
            a = getHolder();
            a.addCallback(this);
        }

        private void a(com.cyberlink.youcammakeup.unittest.viewengine.a a1)
        {
            Canvas canvas = a.lockCanvas();
            Paint paint = new Paint();
            canvas.save();
            canvas.drawPaint(paint);
            canvas.drawBitmap(a1.a, 0.0F, 0.0F, paint);
            canvas.restore();
            a.unlockCanvasAndPost(canvas);
        }

        public void a()
        {
            try
            {
                a((com.cyberlink.youcammakeup.unittest.viewengine.a)c.take());
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
        {
            com.pf.common.utility.m.b("InnerSurfaceView", "on surfaceChanged(..)");
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            com.pf.common.utility.m.b("InnerSurfaceView", "on surfaceCreated(..)");
            b = new b(this);
            b.start();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            com.pf.common.utility.m.b("InnerSurfaceView", "on surfaceDestroyed");
            b.b = false;
            b.interrupt();
        }

        public InnerSurfaceView(Context context)
        {
            super(context);
            a(context);
        }

        public InnerSurfaceView(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            a(context);
        }

        public InnerSurfaceView(Context context, AttributeSet attributeset, int i1)
        {
            super(context, attributeset, i1);
            a(context);
        }
    }

}
