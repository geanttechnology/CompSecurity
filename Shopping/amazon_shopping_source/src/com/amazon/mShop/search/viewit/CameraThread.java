// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CameraThread extends Thread
{

    private Camera mCamera;
    private final CountDownLatch mCameraOpenLatch = new CountDownLatch(1);
    private final CountDownLatch mCameraReleaseLatch = new CountDownLatch(1);
    private Handler mHandler;
    private final CountDownLatch mThreadInitLatch = new CountDownLatch(1);

    public CameraThread()
    {
        mHandler = null;
        mCamera = null;
    }

    public Camera getCamera()
    {
        return mCamera;
    }

    public void openAwait(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        mCameraOpenLatch.await(l, timeunit);
    }

    public void openCamera()
    {
        mHandler.post(new Runnable() {

            final CameraThread this$0;

            public void run()
            {
                mCamera = Camera.open();
                mCameraOpenLatch.countDown();
                return;
                Object obj;
                obj;
                Log.e("CameraThread", (new StringBuilder()).append("Error camera open: ").append(((Throwable) (obj)).getMessage()).toString());
                mCameraOpenLatch.countDown();
                return;
                obj;
                mCameraOpenLatch.countDown();
                throw obj;
            }

            
            {
                this$0 = CameraThread.this;
                super();
            }
        });
    }

    public void releaseAwait(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        mCameraReleaseLatch.await(l, timeunit);
    }

    public void releaseCamera()
    {
        mHandler.postAtFrontOfQueue(new Runnable() {

            final CameraThread this$0;

            public void run()
            {
                Exception exception;
                try
                {
                    mCamera.setPreviewCallback(null);
                    mCamera.stopPreview();
                    mCamera.release();
                    mCamera = null;
                    shutdownCameraThread();
                }
                catch (Throwable throwable)
                {
                    mCameraReleaseLatch.countDown();
                    return;
                }
                finally
                {
                    mCameraReleaseLatch.countDown();
                }
                mCameraReleaseLatch.countDown();
                return;
                throw exception;
            }

            
            {
                this$0 = CameraThread.this;
                super();
            }
        });
    }

    public void run()
    {
        Looper.prepare();
        mHandler = new Handler();
        mThreadInitLatch.countDown();
        Looper.loop();
    }

    public void shutdownCameraThread()
    {
        mHandler.getLooper().quit();
    }

    public void start()
    {
        super.start();
        try
        {
            mThreadInitLatch.await();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            throw new IllegalStateException("Could not start camera thread");
        }
    }



/*
    static Camera access$002(CameraThread camerathread, Camera camera)
    {
        camerathread.mCamera = camera;
        return camera;
    }

*/


}
