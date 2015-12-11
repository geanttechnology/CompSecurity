// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.app.Activity;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.a9.cameralibrary:
//            DataSourceThread, CameraConnectionRunnable, CameraErrorReason, A9CameraPreview, 
//            NewCameraPreview, CameraOpenMode, OnSurfaceCreatedListener

public class CameraBgHelper
{

    private Activity m_activity;
    private Camera m_camera;
    private FrameLayout m_cameraPreviewLayout;
    private DataSourceThread m_cameraThread;
    private NewCameraPreview m_newCameraPreview;
    private A9CameraPreview m_preview;

    public CameraBgHelper(Activity activity, NewCameraPreview newcamerapreview, FrameLayout framelayout)
    {
        m_activity = activity;
        m_newCameraPreview = newcamerapreview;
        m_cameraPreviewLayout = framelayout;
    }

    private Camera getCameraInstance(CameraOpenMode cameraopenmode)
    {
        m_cameraThread = new DataSourceThread("CameraThread");
        m_cameraThread.start();
        cameraopenmode = new CameraConnectionRunnable(cameraopenmode);
        m_cameraThread.runRunnable(cameraopenmode);
        Camera camera;
        try
        {
            cameraopenmode.await(15L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedexception) { }
        camera = cameraopenmode.getCamera();
        cameraopenmode = cameraopenmode.getError();
        if (cameraopenmode != null && m_preview != null)
        {
            m_preview.triggerCameraError(CameraErrorReason.CAMERA_CONNECTION_ERROR, (new StringBuilder()).append("Error Connecting camera. Error = ").append(cameraopenmode).toString());
        }
        return camera;
    }

    private void releaseCamera()
    {
        if (m_camera != null)
        {
            m_camera.setPreviewCallback(null);
            m_camera.release();
            m_camera = null;
        }
        if (m_cameraThread != null)
        {
            m_cameraThread.shutdown();
            m_cameraThread = null;
        }
    }

    public void pause()
    {
        if (m_preview != null)
        {
            m_preview.setIsCameraReleased(true);
            releaseCamera();
            m_cameraPreviewLayout.removeView(m_preview);
            m_preview = null;
        }
    }

    public void resume(int i, int j, int k, int l, CameraOpenMode cameraopenmode)
    {
        m_preview = m_newCameraPreview.newCameraPreview();
        m_preview.setScreenSize(k, l);
        m_camera = getCameraInstance(cameraopenmode);
        m_cameraPreviewLayout.addView(m_preview);
        m_preview.setCameraOpenMode(cameraopenmode);
        m_preview.setMinHeight(i);
        m_preview.setMaxHeight(j);
        m_preview.setCamera(m_camera);
        m_preview.setIsCameraReleased(false);
        m_preview.setOnSurfaceCreatedListener(new OnSurfaceCreatedListener() {

            final CameraBgHelper this$0;

            public Point adjustSurfaceSize(double d, int i1)
            {
                double d1;
                double d2;
                int j1;
                boolean flag;
                int k1;
                int l1;
                int i2;
                boolean flag1;
label0:
                {
                    Object obj;
                    if (i1 % 180 == 90)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj = m_activity.getWindowManager().getDefaultDisplay();
                    if (android.os.Build.VERSION.SDK_INT >= 13)
                    {
                        Point point = new Point();
                        ((Display) (obj)).getSize(point);
                        j1 = point.x;
                        i1 = point.y;
                    } else
                    {
                        j1 = ((Display) (obj)).getWidth();
                        i1 = ((Display) (obj)).getHeight();
                    }
                    flag1 = false;
                    d2 = (double)j1 / (double)i1;
                    if (d2 >= 1.0D || d <= 1.0D)
                    {
                        d1 = d;
                        if (d2 <= 1.0D)
                        {
                            break label0;
                        }
                        d1 = d;
                        if (d >= 1.0D)
                        {
                            break label0;
                        }
                    }
                    d1 = 1.0D / d;
                }
                if (d2 > d1)
                {
                    i2 = (int)((double)j1 / d1);
                    k1 = j1;
                    l1 = ((flag1) ? 1 : 0);
                } else
                if (d2 < d1)
                {
                    int j2 = (int)((double)i1 * d1);
                    l1 = ((flag1) ? 1 : 0);
                    i2 = i1;
                    k1 = j2;
                    if (flag)
                    {
                        l1 = j1 - j2;
                        i2 = i1;
                        k1 = j2;
                    }
                } else
                {
                    l1 = ((flag1) ? 1 : 0);
                    i2 = i1;
                    k1 = j1;
                    if (d2 == d1)
                    {
                        l1 = ((flag1) ? 1 : 0);
                        i2 = i1;
                        k1 = j1;
                    }
                }
                obj = (android.widget.FrameLayout.LayoutParams)m_cameraPreviewLayout.getLayoutParams();
                obj.width = k1;
                obj.height = i2;
                obj.topMargin = 0;
                obj.leftMargin = l1;
                m_cameraPreviewLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                if (flag)
                {
                    return new Point(i2, k1);
                } else
                {
                    return new Point(k1, i2);
                }
            }

            
            {
                this$0 = CameraBgHelper.this;
                super();
            }
        });
    }


}
