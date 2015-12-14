// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.Geom;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import javax.microedition.khronos.egl.EGL10;
import myobfuscated.av.a;
import myobfuscated.av.b;
import myobfuscated.av.e;
import myobfuscated.aw.d;

// Referenced classes of package com.photo.gpu:
//            e, Rotation, i, d

public final class GPUImage
    implements e
{

    final Context a;
    public final com.photo.gpu.e b;
    GLSurfaceView c;
    d d;
    public Bitmap e;
    b f;

    public GPUImage(Context context)
    {
        f = null;
        int j = ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
        a = context;
        d = new d();
        b = new com.photo.gpu.e(d);
    }

    public final com.photo.gpu.d a(Bitmap bitmap, ReadPixelsResultType readpixelsresulttype)
    {
        Object obj;
        obj = null;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        b.a();
        b.b(new Runnable() {

            private GPUImage a;

            public final void run()
            {
                synchronized (a.d)
                {
                    a.d.d();
                    a.d.notify();
                }
                return;
                exception;
                d1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = GPUImage.this;
                super();
            }
        });
        Object obj1 = d;
        obj1;
        JVM INSTR monitorenter ;
        b();
        d.wait();
_L1:
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        obj1 = new com.photo.gpu.e(d);
        ((com.photo.gpu.e) (obj1)).a(Rotation.NORMAL, b.e, b.f);
        Object obj2 = new i(j, k);
        obj2.a = ((android.opengl.GLSurfaceView.Renderer) (obj1));
        if (!Thread.currentThread().getName().equals(((i) (obj2)).k))
        {
            Log.e("PixelBuffer", "setRenderer: This thread does not own the OpenGL context.");
        } else
        {
            ((i) (obj2)).a.onSurfaceCreated(((i) (obj2)).j, ((i) (obj2)).g);
            ((i) (obj2)).a.onSurfaceChanged(((i) (obj2)).j, ((i) (obj2)).b, ((i) (obj2)).c);
        }
        ((com.photo.gpu.e) (obj1)).a(bitmap);
        if (readpixelsresulttype == ReadPixelsResultType.ReadPixelsResultTypeBitmap)
        {
            if (((i) (obj2)).a == null)
            {
                Log.e("PixelBuffer", "getBitmap: Renderer was not set.");
                bitmap = obj;
            } else
            if (!Thread.currentThread().getName().equals(((i) (obj2)).k))
            {
                Log.e("PixelBuffer", "getBitmap: This thread does not own the OpenGL context.");
                bitmap = obj;
            } else
            {
                ((i) (obj2)).a.onDrawFrame(((i) (obj2)).j);
                ((i) (obj2)).a.onDrawFrame(((i) (obj2)).j);
                Log.e("ex1", "convertToBitmap() START");
                bitmap = ((i) (obj2)).a();
                obj2.d = com.socialin.android.util.c.a(((i) (obj2)).b, ((i) (obj2)).c, android.graphics.Bitmap.Config.ARGB_8888);
                bitmap.position(0);
                ((i) (obj2)).d.copyPixelsFromBuffer(bitmap);
                ImageOpCommon.freeNativeBuffer(bitmap);
                Log.e("ex1", "convertToBitmap() END");
                bitmap = ((i) (obj2)).d;
            }
            bitmap = new com.photo.gpu.d(bitmap);
        } else
        {
            if (((i) (obj2)).a == null)
            {
                Log.e("PixelBuffer", "getBitmap: Renderer was not set.");
            } else
            if (!Thread.currentThread().getName().equals(((i) (obj2)).k))
            {
                Log.e("PixelBuffer", "getBitmap: This thread does not own the OpenGL context.");
            } else
            {
                ((i) (obj2)).a.onDrawFrame(((i) (obj2)).j);
                ((i) (obj2)).a.onDrawFrame(((i) (obj2)).j);
                ((i) (obj2)).a();
            }
            bitmap = new com.photo.gpu.d(j, k);
        }
        d.d();
        ((com.photo.gpu.e) (obj1)).a();
        ((com.photo.gpu.e) (obj1)).b();
        ((i) (obj2)).a.onDrawFrame(((i) (obj2)).j);
        ((i) (obj2)).a.onDrawFrame(((i) (obj2)).j);
        ((i) (obj2)).e.eglMakeCurrent(((i) (obj2)).f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        ((i) (obj2)).e.eglDestroySurface(((i) (obj2)).f, ((i) (obj2)).i);
        ((i) (obj2)).e.eglDestroyContext(((i) (obj2)).f, ((i) (obj2)).h);
        ((i) (obj2)).e.eglTerminate(((i) (obj2)).f);
        b.a(d);
        if (e != null)
        {
            b.a(e);
        }
        b();
        return bitmap;
        obj2;
        ((InterruptedException) (obj2)).printStackTrace();
          goto _L1
        bitmap;
        obj1;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    public final void a()
    {
        com.photo.gpu.e e1 = b;
        if (e1.a(new e._cls4(e1)))
        {
            c.requestRender();
        }
    }

    public final void a(Bitmap bitmap)
    {
        e = bitmap;
        b.a(bitmap);
        b();
    }

    public final void a(Runnable runnable)
    {
        b.c(runnable);
    }

    public final void b()
    {
        if (c != null)
        {
            c.requestRender();
        }
    }

    public final void c()
    {
        b.a();
        e = null;
        b();
    }

    public final Bitmap d()
    {
        Bitmap bitmap;
        int j;
        int k;
label0:
        {
            j = b.c;
            k = b.d;
            if (c != null && j > 0 && k > 0)
            {
                bitmap = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
                if (bitmap != null)
                {
                    break label0;
                }
            }
            return null;
        }
        ByteBuffer bytebuffer = ImageOpCommon.allocNativeBuffer(j * k * 4);
        bytebuffer.rewind();
        Semaphore semaphore = new Semaphore(0);
        b.c(new Runnable(j, k, bytebuffer, semaphore) {

            private int a;
            private int b;
            private ByteBuffer c;
            private Semaphore d;

            public final void run()
            {
                GLES20.glReadPixels(0, 0, a, b, 6408, 5121, c);
                d.release();
            }

            
            {
                a = j;
                b = k;
                c = bytebuffer;
                d = semaphore;
                super();
            }
        });
        b();
        try
        {
            semaphore.acquire();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        ImageOpCommon.reverseBitmap(bytebuffer, j, k);
        bytebuffer.rewind();
        bitmap.copyPixelsFromBuffer(bytebuffer);
        ImageOpCommon.freeNativeBuffer(bytebuffer);
        return bitmap;
    }

    // Unreferenced inner class com/photo/gpu/GPUImage$1

/* anonymous class */
    final class _cls1
        implements android.view.View.OnTouchListener
    {

        private GPUImage a;

        public final boolean onTouch(View view, MotionEvent motionevent)
        {
            int j;
            int k;
            view = a.f.a.b;
            j = motionevent.getPointerCount();
            k = motionevent.getActionIndex();
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 6: default 72
        //                       0 74
        //                       1 427
        //                       2 304
        //                       3 72
        //                       4 72
        //                       5 156
        //                       6 258;
               goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
            return true;
_L2:
            float f1 = motionevent.getX(0);
            float f2 = motionevent.getY(0);
            ((myobfuscated.av.c) (view)).o.set(f1, f2);
            view.a = motionevent.getPointerId(0);
            view.h = true;
            view.j = true;
            view.k = false;
            view.i = true;
            ((myobfuscated.av.c) (view)).g.postDelayed(new myobfuscated.av.c._cls1(view, f1, f2), ((myobfuscated.av.c) (view)).e);
            view.n = false;
            return true;
_L5:
            view.h = false;
            if (j == 2)
            {
                view.b = motionevent.getPointerId(k);
                view.a(motionevent, j, -1);
                PointF pointf = myobfuscated.av.c.a(motionevent, ((myobfuscated.av.c) (view)).a);
                motionevent = myobfuscated.av.c.a(motionevent, ((myobfuscated.av.c) (view)).b);
                if (pointf != null && motionevent != null)
                {
                    if (((myobfuscated.av.c) (view)).k)
                    {
                        ((myobfuscated.av.c) (view)).d.a();
                    }
                    ((myobfuscated.av.c) (view)).d.a(pointf, motionevent);
                    view.j = false;
                    view.k = true;
                    view.i = false;
                    return true;
                }
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (j != 1)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((myobfuscated.av.c) (view)).k)
            {
                ((myobfuscated.av.c) (view)).d.a();
                view.k = false;
                return true;
            }
            continue; /* Loop/switch isn't completed */
            if (j <= 2) goto _L1; else goto _L7
_L7:
            view.a(motionevent, j, k);
            return true;
_L4:
            if (!((myobfuscated.av.c) (view)).k)
            {
                continue; /* Loop/switch isn't completed */
            }
            boolean flag = myobfuscated.av.c.a(motionevent, ((myobfuscated.av.c) (view)).a, ((myobfuscated.av.c) (view)).l);
            boolean flag1 = myobfuscated.av.c.a(motionevent, ((myobfuscated.av.c) (view)).b, ((myobfuscated.av.c) (view)).m);
            if (flag || flag1)
            {
                ((myobfuscated.av.c) (view)).d.a(((myobfuscated.av.c) (view)).l, ((myobfuscated.av.c) (view)).m, flag, flag1);
                return true;
            }
            continue; /* Loop/switch isn't completed */
            if (!((myobfuscated.av.c) (view)).j) goto _L1; else goto _L8
_L8:
            ((myobfuscated.av.c) (view)).l.set(motionevent.getX(), motionevent.getY());
            if (!((myobfuscated.av.c) (view)).n && Geom.a(((myobfuscated.av.c) (view)).l, ((myobfuscated.av.c) (view)).o) >= ((myobfuscated.av.c) (view)).c)
            {
                view.n = true;
                return true;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (((myobfuscated.av.c) (view)).k)
            {
                ((myobfuscated.av.c) (view)).d.a();
                view.k = false;
                return true;
            }
            if (((myobfuscated.av.c) (view)).h && motionevent.getEventTime() - motionevent.getDownTime() <= ((myobfuscated.av.c) (view)).f)
            {
                new PointF(motionevent.getX(), motionevent.getY());
            }
            if (((myobfuscated.av.c) (view)).j)
            {
                new PointF(motionevent.getX(), motionevent.getY());
                return true;
            }
            if (true) goto _L1; else goto _L9
_L9:
        }

            
            {
                a = GPUImage.this;
                super();
            }
    }


    private class ReadPixelsResultType extends Enum
    {

        private static final ReadPixelsResultType $VALUES[];
        public static final ReadPixelsResultType ReadPixelsResultTypeBitmap;
        public static final ReadPixelsResultType ReadPixelsResultTypeBuffer;

        public static ReadPixelsResultType valueOf(String s)
        {
            return (ReadPixelsResultType)Enum.valueOf(com/photo/gpu/GPUImage$ReadPixelsResultType, s);
        }

        public static ReadPixelsResultType[] values()
        {
            return (ReadPixelsResultType[])$VALUES.clone();
        }

        static 
        {
            ReadPixelsResultTypeBitmap = new ReadPixelsResultType("ReadPixelsResultTypeBitmap", 0);
            ReadPixelsResultTypeBuffer = new ReadPixelsResultType("ReadPixelsResultTypeBuffer", 1);
            $VALUES = (new ReadPixelsResultType[] {
                ReadPixelsResultTypeBitmap, ReadPixelsResultTypeBuffer
            });
        }

        private ReadPixelsResultType(String s, int j)
        {
            super(s, j);
        }
    }

}
