// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSECameraActivity, CameraBgHelper

public class CameraPreview extends SurfaceView
    implements android.hardware.Camera.PreviewCallback, android.view.SurfaceHolder.Callback
{
    private class SizeAndRatio
    {

        double ratio;
        android.hardware.Camera.Size size;
        final CameraPreview this$0;

        public SizeAndRatio(android.hardware.Camera.Size size1, double d)
        {
            this$0 = CameraPreview.this;
            super();
            size = size1;
            ratio = d;
        }
    }


    private Handler handler;
    private FSECameraActivity mActivity;
    protected Camera mCamera;
    protected android.hardware.Camera.Size mCameraPreviewSize;
    private SurfaceHolder mHolder;
    protected boolean mIsCameraPaused;
    private boolean mIsJustCreated;
    private int mMaxHeight;
    private int mMinHeight;
    protected int mOrientation;
    protected int mPreviewImageFormat;
    protected int mRoiHeight;
    protected int mRoiWidth;
    protected int mRoiX;
    protected int mRoiY;
    private Point m_updatedCameraFrameLayoutSize;

    public CameraPreview(Context context)
    {
        super(context);
        mRoiX = -1;
        mRoiY = -1;
        mRoiWidth = -1;
        mRoiHeight = -1;
        mPreviewImageFormat = -1;
        mOrientation = -1;
        mMaxHeight = 720;
        mMinHeight = 320;
        mIsCameraPaused = false;
        mIsJustCreated = false;
        handler = new Handler() {

            final CameraPreview this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Log.w("CameraPreview", "Run scheduled restart");
                    break;
                }
                restart();
            }

            
            {
                this$0 = CameraPreview.this;
                super();
            }
        };
        mActivity = (FSECameraActivity)context;
        mHolder = getHolder();
        mHolder.setType(3);
        mHolder.addCallback(this);
    }

    private android.hardware.Camera.Size calculateBestPreviewSizeAndAdjustLayout(Camera camera, Rect rect, int i, int j, int k)
    {
        Iterator iterator = null;
        double d = (double)rect.right / (double)rect.bottom;
        ArrayList arraylist;
        boolean flag;
        if (i % 180 == 90)
        {
            d = 1.0D / d;
            m_updatedCameraFrameLayoutSize = new Point(rect.bottom, rect.right);
        } else
        {
            m_updatedCameraFrameLayoutSize = new Point(rect.right, rect.bottom);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14 && i != 270)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        camera = camera.getParameters().getSupportedPreviewSizes();
        arraylist = new ArrayList();
        camera = camera.iterator();
        do
        {
            if (!camera.hasNext())
            {
                break;
            }
            rect = (android.hardware.Camera.Size)camera.next();
            if (((android.hardware.Camera.Size) (rect)).height >= j && ((android.hardware.Camera.Size) (rect)).height <= k)
            {
                arraylist.add(new SizeAndRatio(rect, (double)((android.hardware.Camera.Size) (rect)).width / (double)((android.hardware.Camera.Size) (rect)).height));
            }
        } while (true);
        if (arraylist.isEmpty())
        {
            return null;
        }
        Collections.sort(arraylist, new Comparator() {

            final CameraPreview this$0;

            public int compare(SizeAndRatio sizeandratio, SizeAndRatio sizeandratio1)
            {
                return sizeandratio1.size.height - sizeandratio.size.height;
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((SizeAndRatio)obj, (SizeAndRatio)obj1);
            }

            
            {
                this$0 = CameraPreview.this;
                super();
            }
        });
        rect = arraylist.iterator();
        do
        {
            camera = iterator;
            if (!rect.hasNext())
            {
                break;
            }
            camera = (SizeAndRatio)rect.next();
        } while (Math.abs(((SizeAndRatio) (camera)).ratio - d) >= 0.025000000000000001D);
        if (camera != null)
        {
            return ((SizeAndRatio) (camera)).size;
        }
        rect = camera;
        if (flag)
        {
            iterator = arraylist.iterator();
            do
            {
                rect = camera;
                if (!iterator.hasNext())
                {
                    break;
                }
                rect = (SizeAndRatio)iterator.next();
            } while (Math.abs(((SizeAndRatio) (rect)).ratio - 1.7777777777777777D) >= 0.025000000000000001D);
            if (rect != null)
            {
                m_updatedCameraFrameLayoutSize = mActivity.getCameraBgHelper().adjustSurfaceSize(mActivity, ((SizeAndRatio) (rect)).ratio, i);
                return ((SizeAndRatio) (rect)).size;
            }
            iterator = arraylist.iterator();
            do
            {
                camera = rect;
                if (!iterator.hasNext())
                {
                    break;
                }
                camera = (SizeAndRatio)iterator.next();
            } while (Math.abs(((SizeAndRatio) (camera)).ratio - 1.3333333333333333D) >= 0.025000000000000001D);
            rect = camera;
            if (camera != null)
            {
                m_updatedCameraFrameLayoutSize = mActivity.getCameraBgHelper().adjustSurfaceSize(mActivity, ((SizeAndRatio) (camera)).ratio, i);
                return ((SizeAndRatio) (camera)).size;
            }
        }
        double d1 = 1.7976931348623157E+308D;
        iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            camera = (SizeAndRatio)iterator.next();
            double d2 = Math.abs(((SizeAndRatio) (camera)).ratio - d);
            if (d2 < d1)
            {
                d1 = d2;
                rect = camera;
            }
        } while (true);
        if (flag)
        {
            m_updatedCameraFrameLayoutSize = mActivity.getCameraBgHelper().adjustSurfaceSize(mActivity, ((SizeAndRatio) (rect)).ratio, i);
        }
        return ((SizeAndRatio) (rect)).size;
    }

    private void restart()
    {
        if (mIsCameraPaused || mHolder.getSurface() == null)
        {
            return;
        } else
        {
            handler.removeMessages(1);
            stopPreview();
            startPreview();
            return;
        }
    }

    private void schedRestart()
    {
        if (!handler.hasMessages(1))
        {
            handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        handler.removeMessages(1);
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        if (CameraBgHelper.getOrientation(getContext()) != mOrientation)
        {
            schedRestart();
        }
    }

    public void setCamera(Camera camera)
    {
        mCamera = camera;
    }

    public void setIsCameraPaused(boolean flag)
    {
        mIsCameraPaused = flag;
    }

    public void setMaxHeight(int i)
    {
        mMaxHeight = i;
    }

    public void setMinHeight(int i)
    {
        mMinHeight = i;
    }

    protected void startPreview()
    {
        Object obj;
        mCamera.setPreviewDisplay(mHolder);
        mOrientation = CameraBgHelper.getOrientation(getContext());
        mCamera.setDisplayOrientation(mOrientation);
        obj = calculateBestPreviewSizeAndAdjustLayout(mCamera, mHolder.getSurfaceFrame(), mOrientation, mMinHeight, mMaxHeight);
        if (obj == null)
        {
            try
            {
                throw new Exception("No no available preview sizes found by continouse-scan.");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("CameraPreview", (new StringBuilder()).append("Error starting camera preview: ").append(((Exception) (obj)).getMessage()).toString());
            }
            return;
        }
        double d;
        double d1;
        int i;
        int k;
        int i1;
        int j1;
        CameraBgHelper.setCameraParameters(mCamera, ((android.hardware.Camera.Size) (obj)), this);
        mCameraPreviewSize = mCamera.getParameters().getPreviewSize();
        mPreviewImageFormat = mCamera.getParameters().getPreviewFormat();
        obj = mHolder.getSurfaceFrame();
        i = ((Rect) (obj)).bottom - ((Rect) (obj)).top;
        k = ((Rect) (obj)).right - ((Rect) (obj)).left;
        d = (double)k / (double)i;
        i1 = m_updatedCameraFrameLayoutSize.y;
        j1 = m_updatedCameraFrameLayoutSize.x;
        d1 = (double)j1 / (double)i1;
        break MISSING_BLOCK_LABEL_223;
_L2:
        int j;
        int l;
        d = (double)j / (double)i1;
        d1 = (double)l / (double)j1;
        mRoiX = 0;
        mRoiY = 0;
        mRoiWidth = (int)((double)mCameraPreviewSize.width * d1);
        mRoiHeight = (int)((double)mCameraPreviewSize.height * d);
        mCamera.startPreview();
        return;
        if (d >= 1.0D || d1 <= 1.0D)
        {
            j = i;
            l = k;
            if (d <= 1.0D)
            {
                continue; /* Loop/switch isn't completed */
            }
            j = i;
            l = k;
            if (d1 >= 1.0D)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j = k;
        l = i;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void stopPreview()
    {
        if (mCamera == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        try
        {
            mCamera.setPreviewCallback(null);
        }
        catch (Exception exception)
        {
            Log.e("CameraPreview", (new StringBuilder()).append("Error camera setPreviewCallback: ").append(exception.getMessage()).toString());
        }
        mCamera.stopPreview();
        return;
        Exception exception1;
        exception1;
        Log.e("CameraPreview", (new StringBuilder()).append("Error camera stopPreview: ").append(exception1.getMessage()).toString());
        return;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (mHolder.getSurface() == null)
        {
            return;
        }
        if (mIsJustCreated)
        {
            mIsJustCreated = false;
            startPreview();
            return;
        } else
        {
            restart();
            return;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        mIsJustCreated = true;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }

    public PointF translatePoint(PointF pointf)
    {
        switch (mOrientation)
        {
        default:
            return new PointF((((float)mCameraPreviewSize.height - pointf.y) * (float)m_updatedCameraFrameLayoutSize.y) / (float)mCameraPreviewSize.height, (pointf.x * (float)m_updatedCameraFrameLayoutSize.x) / (float)mCameraPreviewSize.width);

        case 0: // '\0'
            return new PointF((pointf.x * (float)m_updatedCameraFrameLayoutSize.x) / (float)mCameraPreviewSize.width, (pointf.y * (float)m_updatedCameraFrameLayoutSize.y) / (float)mCameraPreviewSize.height);

        case 180: 
            return new PointF((((float)mCameraPreviewSize.width - pointf.x) * (float)m_updatedCameraFrameLayoutSize.x) / (float)mCameraPreviewSize.width, (((float)mCameraPreviewSize.height - pointf.y) * (float)m_updatedCameraFrameLayoutSize.y) / (float)mCameraPreviewSize.height);

        case 270: 
            return new PointF((pointf.y * (float)m_updatedCameraFrameLayoutSize.y) / (float)mCameraPreviewSize.height, (((float)mCameraPreviewSize.width - pointf.x) * (float)m_updatedCameraFrameLayoutSize.x) / (float)mCameraPreviewSize.width);
        }
    }

}
