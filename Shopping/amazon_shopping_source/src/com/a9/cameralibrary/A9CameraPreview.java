// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.a9.cameralibrary:
//            CameraOpenMode, CameraErrorReason, OnSurfaceCreatedListener, CameraFrameListener

public class A9CameraPreview extends SurfaceView
    implements android.hardware.Camera.PreviewCallback, android.view.SurfaceHolder.Callback
{
    private class SizeAndRatio
    {

        double ratio;
        android.hardware.Camera.Size size;
        final A9CameraPreview this$0;

        public SizeAndRatio(android.hardware.Camera.Size size1, double d)
        {
            this$0 = A9CameraPreview.this;
            super();
            size = size1;
            ratio = d;
        }
    }


    private Camera m_camera;
    private CameraFrameListener m_cameraCallbackListener;
    private CameraOpenMode m_cameraOpenMode;
    private android.hardware.Camera.Parameters m_cameraParameters;
    private android.hardware.Camera.Size m_cameraSize;
    private String m_focusMode;
    private boolean m_focusing;
    private int m_framesTilNextFocus;
    private SurfaceHolder m_holder;
    private boolean m_isCameraReleased;
    private Date m_lastFocus;
    private int m_maxHeight;
    private int m_minHeight;
    private int m_orientation;
    private int m_previewImageFormat;
    private int m_roiHeight;
    private int m_roiWidth;
    private int m_roiX;
    private int m_roiY;
    private int m_screenHeight;
    private int m_screenWidth;
    private boolean m_supportsContinuousFocus;
    private OnSurfaceCreatedListener m_surfaceCreatedListener;
    private Point m_updatedCameraFrameLayoutSize;

    public A9CameraPreview(Context context, CameraFrameListener cameraframelistener)
    {
        super(context);
        m_cameraOpenMode = CameraOpenMode.UNKOWN;
        m_orientation = -1;
        m_maxHeight = 768;
        m_minHeight = 320;
        m_previewImageFormat = -1;
        m_focusMode = "auto";
        m_roiX = -1;
        m_roiY = -1;
        m_roiWidth = -1;
        m_roiHeight = -1;
        m_cameraCallbackListener = cameraframelistener;
        m_holder = getHolder();
        m_holder.addCallback(this);
        m_holder.setType(3);
    }

    private void calcRoiCoordinates()
    {
        double d;
        double d1;
        if (m_orientation % 180 == 90)
        {
            d = (double)m_screenWidth / (double)m_updatedCameraFrameLayoutSize.y;
            d1 = (double)m_screenHeight / (double)m_updatedCameraFrameLayoutSize.x;
        } else
        {
            d = (double)m_screenHeight / (double)m_updatedCameraFrameLayoutSize.y;
            d1 = (double)m_screenWidth / (double)m_updatedCameraFrameLayoutSize.x;
        }
        m_roiX = 0;
        m_roiY = 0;
        m_roiWidth = (int)((double)m_cameraSize.width * d1);
        m_roiHeight = (int)((double)m_cameraSize.height * d);
    }

    private android.hardware.Camera.Size calculateBestPreviewSizeAndAdjustLayout()
    {
        if (m_camera != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        triggerCameraError(CameraErrorReason.CAMERA_OBJECT_NULL, "Camera Object is null while calculating best preview size");
        return null;
        double d;
        Object obj;
        SizeAndRatio sizeandratio;
        Object obj1;
        boolean flag;
        int i;
        sizeandratio = null;
        android.hardware.Camera.Size size;
        try
        {
            obj = m_holder.getSurfaceFrame();
            d = (double)((Rect) (obj)).right / (double)((Rect) (obj)).bottom;
            i = getOrientation();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            triggerCameraError(CameraErrorReason.CAMERA_EXCEPTION_ERROR, (new StringBuilder()).append("Error while calculating best preview size. Exception = ").append(obj).toString());
            return null;
        }
        if (i % 180 != 90)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        d = 1.0D / d;
        m_updatedCameraFrameLayoutSize = new Point(((Rect) (obj)).bottom, ((Rect) (obj)).right);
_L1:
        double d1;
        double d2;
        Iterator iterator;
        if (android.os.Build.VERSION.SDK_INT >= 14 && m_cameraOpenMode == CameraOpenMode.FIRST_BACK_FACING && m_orientation != 270)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = m_camera.getParameters().getSupportedPreviewSizes();
        obj1 = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            size = (android.hardware.Camera.Size)((Iterator) (obj)).next();
            if (size.height >= m_minHeight && size.height <= m_maxHeight)
            {
                ((List) (obj1)).add(new SizeAndRatio(size, (double)size.width / (double)size.height));
            }
        } while (true);
        break MISSING_BLOCK_LABEL_284;
        m_updatedCameraFrameLayoutSize = new Point(((Rect) (obj)).right, ((Rect) (obj)).bottom);
          goto _L1
        if (!((List) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_339;
        }
        triggerCameraError(CameraErrorReason.NO_PREVIEW_SIZES_MEET_CONSTRAINTS, (new StringBuilder()).append("There are no available sizes given Min Height = ").append(m_minHeight).append(" and Max Height = ").append(m_maxHeight).toString());
        return null;
        Collections.sort(((List) (obj1)), new Comparator() {

            final A9CameraPreview this$0;

            public int compare(SizeAndRatio sizeandratio1, SizeAndRatio sizeandratio2)
            {
                return sizeandratio2.size.height - sizeandratio1.size.height;
            }

            public volatile int compare(Object obj2, Object obj3)
            {
                return compare((SizeAndRatio)obj2, (SizeAndRatio)obj3);
            }

            
            {
                this$0 = A9CameraPreview.this;
                super();
            }
        });
        iterator = ((List) (obj1)).iterator();
_L3:
        obj = sizeandratio;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (SizeAndRatio)iterator.next();
        if (Math.abs(((SizeAndRatio) (obj)).ratio - d) >= 0.025000000000000001D) goto _L3; else goto _L2
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        return ((SizeAndRatio) (obj)).size;
        sizeandratio = ((SizeAndRatio) (obj));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        sizeandratio = ((SizeAndRatio) (obj));
        if (m_surfaceCreatedListener == null)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        iterator = ((List) (obj1)).iterator();
_L5:
        sizeandratio = ((SizeAndRatio) (obj));
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sizeandratio = (SizeAndRatio)iterator.next();
        if (Math.abs(sizeandratio.ratio - 1.7777777777777777D) >= 0.025000000000000001D) goto _L5; else goto _L4
_L4:
        if (sizeandratio == null)
        {
            break MISSING_BLOCK_LABEL_520;
        }
        m_updatedCameraFrameLayoutSize = m_surfaceCreatedListener.adjustSurfaceSize(sizeandratio.ratio, i);
        return sizeandratio.size;
        iterator = ((List) (obj1)).iterator();
_L7:
        obj = sizeandratio;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (SizeAndRatio)iterator.next();
        if (Math.abs(((SizeAndRatio) (obj)).ratio - 1.3333333333333333D) >= 0.025000000000000001D) goto _L7; else goto _L6
_L6:
        sizeandratio = ((SizeAndRatio) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        m_updatedCameraFrameLayoutSize = m_surfaceCreatedListener.adjustSurfaceSize(((SizeAndRatio) (obj)).ratio, i);
        return ((SizeAndRatio) (obj)).size;
        d1 = 1.7976931348623157E+308D;
        obj1 = ((List) (obj1)).iterator();
_L8:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_673;
        }
        obj = (SizeAndRatio)((Iterator) (obj1)).next();
        d2 = Math.abs(((SizeAndRatio) (obj)).ratio - d);
        if (d2 < d1)
        {
            d1 = d2;
            sizeandratio = ((SizeAndRatio) (obj));
        }
          goto _L8
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_705;
        }
        if (m_surfaceCreatedListener != null)
        {
            m_updatedCameraFrameLayoutSize = m_surfaceCreatedListener.adjustSurfaceSize(sizeandratio.ratio, i);
        }
        obj = sizeandratio.size;
        return ((android.hardware.Camera.Size) (obj));
    }

    private void checkFocus()
    {
        if (!m_supportsContinuousFocus && !m_focusing)
        {
            int i = m_framesTilNextFocus - 1;
            m_framesTilNextFocus = i;
            if (i < 0 && (m_lastFocus == null || (new Date()).getTime() - m_lastFocus.getTime() > 3000L))
            {
                focus();
            }
        }
    }

    private void focus()
    {
        if (m_isCameraReleased)
        {
            return;
        }
        m_focusing = true;
        try
        {
            if (m_supportsContinuousFocus)
            {
                android.hardware.Camera.Parameters parameters = m_camera.getParameters();
                parameters.setFocusMode(m_focusMode);
                m_camera.setParameters(parameters);
            }
            m_camera.autoFocus(new android.hardware.Camera.AutoFocusCallback() {

                final A9CameraPreview this$0;

                public void onAutoFocus(boolean flag, Camera camera)
                {
                    if (!m_isCameraReleased) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    m_focusing = false;
                    m_framesTilNextFocus = 3;
                    m_lastFocus = new Date();
                    if (!m_supportsContinuousFocus) goto _L1; else goto _L3
_L3:
                    camera = m_camera.getParameters();
                    camera.setFocusMode("continuous-picture");
                    m_camera.setParameters(camera);
                    setFocusArea();
                    return;
                    camera;
                    m_focusing = false;
                    return;
                }

            
            {
                this$0 = A9CameraPreview.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private int getOrientation()
    {
        Display display = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        display.getRotation();
        JVM INSTR tableswitch 1 3: default 48
    //                   1 90
    //                   2 97
    //                   3 106;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_106;
_L1:
        char c;
        boolean flag;
        c = 'Z';
        flag = true;
_L5:
        boolean flag1;
        int i;
        if (display.getHeight() > display.getWidth())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i = c;
        if (flag1 != flag)
        {
            i = (c + 270) % 360;
        }
        return i;
_L2:
        c = '\0';
        flag = false;
          goto _L5
_L3:
        c = '\u010E';
        flag = true;
          goto _L5
        c = '\264';
        flag = false;
          goto _L5
    }

    private void setFocusArea()
    {
        if (android.os.Build.VERSION.SDK_INT < 14 || m_cameraParameters.getMaxNumFocusAreas() <= 0)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(new android.hardware.Camera.Area(new Rect(-150, -250, 150, 250), 1000));
        m_cameraParameters.setFocusAreas(arraylist);
        m_camera.setParameters(m_cameraParameters);
        return;
        Exception exception;
        exception;
        m_cameraParameters.setFocusAreas(null);
        return;
    }

    public void callFocus()
    {
        if (!m_focusing)
        {
            focus();
        }
    }

    public float getScreenHeight()
    {
        switch (m_orientation)
        {
        default:
            return translatePoint(new PointF(m_roiWidth, 0.0F)).y;

        case 270: 
            return translatePoint(new PointF(0.0F, m_roiHeight)).y;

        case 0: // '\0'
            return translatePoint(new PointF(m_roiWidth, m_roiHeight)).y;

        case 180: 
            return translatePoint(new PointF(0.0F, 0.0F)).y;
        }
    }

    public float getScreenWidth()
    {
        switch (m_orientation)
        {
        default:
            return translatePoint(new PointF(m_roiWidth, 0.0F)).x;

        case 270: 
            return translatePoint(new PointF(0.0F, m_roiHeight)).x;

        case 0: // '\0'
            return translatePoint(new PointF(m_roiWidth, m_roiHeight)).x;

        case 180: 
            return translatePoint(new PointF(0.0F, 0.0F)).x;
        }
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        long l = SystemClock.uptimeMillis();
        if (m_cameraCallbackListener != null)
        {
            m_cameraCallbackListener.didReceiveFrame(abyte0, m_cameraSize.height, m_cameraSize.width, 1, m_previewImageFormat, m_roiX, m_roiY, m_roiWidth, m_roiHeight, l);
        }
        m_camera.addCallbackBuffer(abyte0);
_L2:
        checkFocus();
        return;
        camera;
        m_camera.addCallbackBuffer(abyte0);
        if (true) goto _L2; else goto _L1
_L1:
        camera;
        m_camera.addCallbackBuffer(abyte0);
        throw camera;
    }

    public void setCamera(Camera camera)
    {
        m_camera = camera;
    }

    public void setCameraOpenMode(CameraOpenMode cameraopenmode)
    {
        m_cameraOpenMode = cameraopenmode;
    }

    public void setIsCameraReleased(boolean flag)
    {
        m_isCameraReleased = flag;
    }

    public void setMaxHeight(int i)
    {
        m_maxHeight = i;
    }

    public void setMinHeight(int i)
    {
        m_minHeight = i;
    }

    public void setOnSurfaceCreatedListener(OnSurfaceCreatedListener onsurfacecreatedlistener)
    {
        m_surfaceCreatedListener = onsurfacecreatedlistener;
    }

    public void setScreenSize(int i, int j)
    {
        m_screenWidth = i;
        m_screenHeight = j;
    }

    protected void startPreview()
    {
        Object obj;
        String s;
        try
        {
            m_camera.setPreviewDisplay(m_holder);
            m_orientation = getOrientation();
            m_camera.setDisplayOrientation(m_orientation);
            m_cameraParameters = m_camera.getParameters();
            obj = m_cameraParameters.getSupportedFocusModes();
        }
        catch (Exception exception)
        {
            triggerCameraError(CameraErrorReason.CAMERA_EXCEPTION_ERROR, (new StringBuilder()).append("Error while calling start preview. Exception = ").append(exception).toString());
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            s = (String)((Iterator) (obj)).next();
            if (s.equals("continuous-picture"))
            {
                m_supportsContinuousFocus = true;
            }
            if (s.equals("macro"))
            {
                m_focusMode = "macro";
            }
        } while (true);
        Iterator iterator;
        if (m_supportsContinuousFocus)
        {
            setFocusArea();
            m_cameraParameters.setFocusMode("continuous-picture");
            m_camera.setParameters(m_cameraParameters);
        }
        m_focusing = false;
        m_lastFocus = null;
        m_framesTilNextFocus = 0;
        iterator = m_cameraParameters.getSupportedPreviewFpsRange().iterator();
_L2:
        int ai[];
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        ai = (int[])iterator.next();
        if (ai.length != 2 || ai[0] != 30000 || ai[1] != 30000)
        {
            continue; /* Loop/switch isn't completed */
        }
        m_cameraParameters.setPreviewFpsRange(ai[0], ai[1]);
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 14 && Build.MODEL.equals("Nexus 4"))
        {
            m_cameraParameters.setRecordingHint(true);
        }
        m_cameraParameters.setPreviewSize(m_cameraSize.width, m_cameraSize.height);
        m_cameraParameters.setPreviewFormat(17);
        m_camera.setParameters(m_cameraParameters);
        m_cameraParameters = m_camera.getParameters();
        m_cameraSize = m_cameraParameters.getPreviewSize();
        m_previewImageFormat = m_cameraParameters.getPreviewFormat();
        m_camera.startPreview();
        m_camera.setPreviewCallbackWithBuffer(this);
        calcRoiCoordinates();
        PixelFormat pixelformat = new PixelFormat();
        PixelFormat.getPixelFormatInfo(m_cameraParameters.getPreviewFormat(), pixelformat);
        int i = (m_cameraSize.width * m_cameraSize.height * pixelformat.bitsPerPixel) / 8;
        m_camera.addCallbackBuffer(new byte[i]);
        m_camera.addCallbackBuffer(new byte[i]);
        return;
    }

    protected void stopPreview()
    {
        try
        {
            m_camera.setPreviewCallback(null);
            m_camera.stopPreview();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        m_cameraSize = calculateBestPreviewSizeAndAdjustLayout();
        if (m_cameraSize != null)
        {
            startPreview();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        stopPreview();
    }

    public void torchOff()
    {
        try
        {
            m_cameraParameters.setFlashMode("off");
            m_camera.setParameters(m_cameraParameters);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void torchOn()
    {
        try
        {
            m_cameraParameters.setFlashMode("torch");
            m_camera.setParameters(m_cameraParameters);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public PointF translatePoint(PointF pointf)
    {
        switch (m_orientation)
        {
        default:
            return new PointF((((float)m_cameraSize.height - pointf.y) * (float)m_updatedCameraFrameLayoutSize.y) / (float)m_cameraSize.height, (pointf.x * (float)m_updatedCameraFrameLayoutSize.x) / (float)m_cameraSize.width);

        case 270: 
            return new PointF((pointf.y * (float)m_updatedCameraFrameLayoutSize.y) / (float)m_cameraSize.height, (((float)m_cameraSize.width - pointf.x) * (float)m_updatedCameraFrameLayoutSize.x) / (float)m_cameraSize.width);

        case 0: // '\0'
            return new PointF((pointf.x * (float)m_updatedCameraFrameLayoutSize.x) / (float)m_cameraSize.width, (pointf.y * (float)m_updatedCameraFrameLayoutSize.y) / (float)m_cameraSize.height);

        case 180: 
            return new PointF((((float)m_cameraSize.width - pointf.x) * (float)m_updatedCameraFrameLayoutSize.x) / (float)m_cameraSize.width, (((float)m_cameraSize.height - pointf.y) * (float)m_updatedCameraFrameLayoutSize.y) / (float)m_cameraSize.height);
        }
    }

    public void translatePointInPlace(PointF pointf)
    {
        float f = pointf.x;
        switch (m_orientation)
        {
        default:
            pointf.x = (((float)m_roiHeight - pointf.y) * (float)m_screenWidth) / (float)m_roiHeight;
            pointf.y = ((float)m_screenHeight * f) / (float)m_roiWidth;
            return;

        case 270: 
            pointf.x = (pointf.y * (float)m_updatedCameraFrameLayoutSize.y) / (float)m_cameraSize.height;
            pointf.y = (((float)m_cameraSize.width - f) * (float)m_updatedCameraFrameLayoutSize.x) / (float)m_cameraSize.width;
            return;

        case 0: // '\0'
            pointf.x = (pointf.x * (float)m_screenWidth) / (float)m_roiWidth;
            pointf.y = (pointf.y * (float)m_screenHeight) / (float)m_roiHeight;
            return;

        case 180: 
            pointf.x = (((float)m_roiWidth - pointf.x) * (float)m_screenWidth) / (float)m_roiWidth;
            pointf.y = (((float)m_roiHeight - pointf.y) * (float)m_screenHeight) / (float)m_roiHeight;
            return;
        }
    }

    public void triggerCameraError(CameraErrorReason cameraerrorreason, String s)
    {
        if (m_cameraCallbackListener != null)
        {
            m_cameraCallbackListener.cameraError(cameraerrorreason, s);
        }
    }



/*
    static boolean access$102(A9CameraPreview a9camerapreview, boolean flag)
    {
        a9camerapreview.m_focusing = flag;
        return flag;
    }

*/


/*
    static int access$202(A9CameraPreview a9camerapreview, int i)
    {
        a9camerapreview.m_framesTilNextFocus = i;
        return i;
    }

*/


/*
    static Date access$302(A9CameraPreview a9camerapreview, Date date)
    {
        a9camerapreview.m_lastFocus = date;
        return date;
    }

*/



}
