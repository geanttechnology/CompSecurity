// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.opengl;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class AviaryGLSurfaceView extends GLSurfaceView
{
    private class AviaryGLRenderer
        implements android.opengl.GLSurfaceView.Renderer
    {

        private int mHeight;
        private int mWidth;
        final AviaryGLSurfaceView this$0;

        public void onDrawFrame(GL10 gl10)
        {
            AviaryGLSurfaceView.logger.log("onDrawFrame");
        }

        public void onSurfaceChanged(GL10 gl10, int i, int j)
        {
            AviaryGLSurfaceView.logger.log((new StringBuilder()).append("onSurfaceChanged. ").append(i).append("x").append(j).toString());
            boolean flag;
            if (mWidth != i || mHeight != j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mWidth = i;
            mHeight = j;
            setRenderbufferSize(flag, i, j);
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
        {
            Log.d("GL", (new StringBuilder()).append("GL_RENDERER = ").append(gl10.glGetString(7937)).toString());
            Log.d("GL", (new StringBuilder()).append("GL_VENDOR = ").append(gl10.glGetString(7936)).toString());
            Log.d("GL", (new StringBuilder()).append("GL_VERSION = ").append(gl10.glGetString(7938)).toString());
            Log.i("GL", (new StringBuilder()).append("GL_EXTENSIONS = ").append(gl10.glGetString(7939)).toString());
            AviaryGLSurfaceView.logger.log("onSurfaceCreated");
            initializeOpenGL();
        }

        private AviaryGLRenderer()
        {
            this$0 = AviaryGLSurfaceView.this;
            super();
        }

    }

    public static interface GLRendererListener
    {

        public abstract void onSurfaceChanged(boolean flag, int i, int j);

        public abstract void onSurfaceCreated();
    }

    class InitializeOpenGLJob
        implements com.aviary.android.feather.common.threading.ThreadPool.Job
    {

        final AviaryGLSurfaceView this$0;

        public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
            throws Exception
        {
            return run(worker, (Void[])aobj);
        }

        public transient Void run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Void avoid[])
            throws Exception
        {
            AviaryGLSurfaceView.logger.log("InitializeOpenGlJob::run");
            nativeInitialize();
            AviaryGLSurfaceView.logger.log("end::nativeInitialize");
            return null;
        }

        InitializeOpenGLJob()
        {
            this$0 = AviaryGLSurfaceView.this;
            super();
        }
    }

    class RenderJob
        implements com.aviary.android.feather.common.threading.ThreadPool.Job
    {

        WeakReference mBitmap;
        final AviaryGLSurfaceView this$0;

        public transient Boolean run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, String as[])
            throws Exception
        {
            AviaryGLSurfaceView.logger.log("RenderJob::run");
            if (mBitmap != null && mBitmap.get() != null)
            {
                return Boolean.valueOf(nativeRender((Bitmap)mBitmap.get(), as[0]));
            } else
            {
                return Boolean.valueOf(false);
            }
        }

        public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
            throws Exception
        {
            return run(worker, (String[])aobj);
        }

        public RenderJob(Bitmap bitmap)
        {
            this$0 = AviaryGLSurfaceView.this;
            super();
            mBitmap = new WeakReference(bitmap);
        }
    }

    class SetRenderbufferSizeJob
        implements com.aviary.android.feather.common.threading.ThreadPool.Job
    {

        final AviaryGLSurfaceView this$0;

        public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
            throws Exception
        {
            return run(worker, (Integer[])aobj);
        }

        public transient Void run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Integer ainteger[])
            throws Exception
        {
            AviaryGLSurfaceView.logger.log("SetRenderbufferSizeJob::run");
            nativeSetRenderbufferSize(ainteger[0].intValue(), ainteger[1].intValue());
            return null;
        }

        public SetRenderbufferSizeJob()
        {
            this$0 = AviaryGLSurfaceView.this;
            super();
        }
    }

    class WriteBitmapJob
        implements com.aviary.android.feather.common.threading.ThreadPool.Job
    {

        WeakReference mBitmap;
        final AviaryGLSurfaceView this$0;

        public transient Boolean run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Void avoid[])
            throws Exception
        {
            if (mBitmap != null && mBitmap.get() != null)
            {
                return Boolean.valueOf(nativeWriteBitmap((Bitmap)mBitmap.get()));
            } else
            {
                return Boolean.valueOf(false);
            }
        }

        public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
            throws Exception
        {
            return run(worker, (Void[])aobj);
        }

        public WriteBitmapJob(Bitmap bitmap)
        {
            this$0 = AviaryGLSurfaceView.this;
            super();
            mBitmap = new WeakReference(bitmap);
        }
    }


    private static final Handler UI_HANDLER = new Handler();
    private static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private GLRendererListener mGlRendererListener;
    private final Object mNativeLock;
    private final long mPtr;

    public AviaryGLSurfaceView(Context context)
    {
        super(context);
        mNativeLock = new Object();
        mPtr = init(context, null);
    }

    public AviaryGLSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mNativeLock = new Object();
        mPtr = init(context, attributeset);
    }

    private void fireOnSurfaceChanged(final boolean changed, final int width, final int height)
    {
        if (mGlRendererListener != null)
        {
            getHandler().post(new Runnable() {

                final AviaryGLSurfaceView this$0;
                final boolean val$changed;
                final int val$height;
                final int val$width;

                public void run()
                {
                    mGlRendererListener.onSurfaceChanged(changed, width, height);
                }

            
            {
                this$0 = AviaryGLSurfaceView.this;
                changed = flag;
                width = i;
                height = j;
                super();
            }
            });
        }
    }

    private void fireOnSurfaceCreated()
    {
        if (mGlRendererListener != null)
        {
            mGlRendererListener.onSurfaceCreated();
        }
    }

    private long init(Context context, AttributeSet attributeset)
    {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        setRenderer(new AviaryGLRenderer());
        setRenderMode(0);
        return nativeCreate();
    }

    private void initializeOpenGL()
    {
        submit(new InitializeOpenGLJob(), new FutureListener() {

            final AviaryGLSurfaceView this$0;

            public void onFutureDone(Future future)
            {
                fireOnSurfaceCreated();
            }

            
            {
                this$0 = AviaryGLSurfaceView.this;
                super();
            }
        }, new Void[0]);
    }

    private static native long n_create();

    private static native boolean n_dispose(long l);

    private static native boolean n_initialize(long l);

    private static native boolean n_render(long l, Bitmap bitmap, String s);

    private static native boolean n_setRenderbufferSize(long l, int i, int j);

    private static native boolean n_writeCurrentBitmap(long l, Bitmap bitmap);

    private long nativeCreate()
    {
        logger.log("nativeCreate");
        long l;
        synchronized (mNativeLock)
        {
            l = n_create();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void nativeDispose()
    {
        logger.log("nativeDispose");
        synchronized (mNativeLock)
        {
            n_dispose(mPtr);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean nativeInitialize()
    {
        logger.log("nativeInitialize");
        boolean flag;
        synchronized (mNativeLock)
        {
            flag = n_initialize(mPtr);
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean nativeRender(Bitmap bitmap, String s)
    {
        logger.log("nativeRender");
        boolean flag;
        synchronized (mNativeLock)
        {
            flag = n_render(mPtr, bitmap, s);
        }
        return flag;
        bitmap;
        obj;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    private boolean nativeSetRenderbufferSize(int i, int j)
    {
        logger.log("nativeSetRenderBufferSize");
        boolean flag;
        synchronized (mNativeLock)
        {
            flag = n_setRenderbufferSize(mPtr, i, j);
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean nativeWriteBitmap(Bitmap bitmap)
    {
        logger.log("nativeWriteBitmap");
        boolean flag;
        synchronized (mNativeLock)
        {
            flag = n_writeCurrentBitmap(mPtr, bitmap);
        }
        return flag;
        bitmap;
        obj;
        JVM INSTR monitorexit ;
        throw bitmap;
    }

    private void setRenderbufferSize(final boolean changed, final int width, final int height)
    {
        submit(new SetRenderbufferSizeJob(), new FutureListener() {

            final AviaryGLSurfaceView this$0;
            final boolean val$changed;
            final int val$height;
            final int val$width;

            public void onFutureDone(Future future)
            {
                fireOnSurfaceChanged(changed, width, height);
            }

            
            {
                this$0 = AviaryGLSurfaceView.this;
                changed = flag;
                width = i;
                height = j;
                super();
            }
        }, new Integer[] {
            Integer.valueOf(width), Integer.valueOf(height)
        });
    }

    public Future executeEffect(String s, Bitmap bitmap, boolean flag, FutureListener futurelistener)
    {
        return submit(new RenderJob(bitmap), futurelistener, new String[] {
            s
        });
    }

    protected void onDetachedFromWindow()
    {
        logger.info("onDetachedfromWindow");
        nativeDispose();
        super.onDetachedFromWindow();
    }

    public void setOnGlRendererListener(GLRendererListener glrendererlistener)
    {
        mGlRendererListener = glrendererlistener;
    }

    public transient Future submit(com.aviary.android.feather.common.threading.ThreadPool.Job job, FutureListener futurelistener, Object aobj[])
    {
        throw new RuntimeException("Not Implemented");
    }

    public Future writeBitmap(Bitmap bitmap, FutureListener futurelistener)
    {
        return submit(new WriteBitmapJob(bitmap), futurelistener, new Void[0]);
    }

    static 
    {
        logger = LoggerFactory.getLogger("gl-surface", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }










}
