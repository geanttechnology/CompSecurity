// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Preview extends ViewGroup
    implements android.view.SurfaceHolder.Callback
{

    private final String TAG;
    Camera mCamera;
    Boolean mForceLayout;
    SurfaceHolder mHolder;
    Boolean mIsFrontCamera;
    android.hardware.Camera.Size mPreviewSize;
    List mSupportedPreviewSizes;
    SurfaceView mSurfaceView;

    Preview(Context context)
    {
        super(context);
        TAG = "Preview";
        mIsFrontCamera = Boolean.valueOf(false);
        mForceLayout = Boolean.valueOf(false);
        init(context);
    }

    public Preview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "Preview";
        mIsFrontCamera = Boolean.valueOf(false);
        mForceLayout = Boolean.valueOf(false);
        init(context);
    }

    private void enforceLayout()
    {
        mForceLayout = Boolean.valueOf(true);
        requestLayout();
    }

    private android.hardware.Camera.Size getOptimalPreviewSize(List list, int i, int j)
    {
        double d1 = (double)i / (double)j;
        if (list != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return ((android.hardware.Camera.Size) (obj1));
_L2:
        Object obj = null;
        double d = 1.7976931348623157E+308D;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            obj1 = (android.hardware.Camera.Size)iterator.next();
            if (Math.abs((double)((android.hardware.Camera.Size) (obj1)).width / (double)((android.hardware.Camera.Size) (obj1)).height - d1) <= 0.10000000000000001D && (double)Math.abs(((android.hardware.Camera.Size) (obj1)).height - j) < d)
            {
                d = Math.abs(((android.hardware.Camera.Size) (obj1)).height - j);
                obj = obj1;
            }
        } while (true);
        obj1 = obj;
        if (obj != null)
        {
            continue;
        }
        d = 1.7976931348623157E+308D;
        iterator = list.iterator();
        do
        {
            obj1 = obj;
            if (!iterator.hasNext())
            {
                continue;
            }
            list = (android.hardware.Camera.Size)iterator.next();
            if ((double)Math.abs(((android.hardware.Camera.Size) (list)).height - j) < d)
            {
                d = Math.abs(((android.hardware.Camera.Size) (list)).height - j);
            } else
            {
                list = ((List) (obj));
            }
            obj = list;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void init(Context context)
    {
        mSurfaceView = new SurfaceView(context);
        setClipChildren(true);
        addView(mSurfaceView);
        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        mHolder.setType(3);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
label0:
        {
            if (flag && getChildCount() > 0 || mForceLayout.booleanValue())
            {
                if (mForceLayout.booleanValue())
                {
                    mForceLayout = Boolean.valueOf(false);
                }
                View view = getChildAt(0);
                k -= i;
                l -= j;
                if (mPreviewSize != null)
                {
                    if (mCamera != null && !mIsFrontCamera.booleanValue())
                    {
                        j = mPreviewSize.height;
                        i = mPreviewSize.width;
                    } else
                    {
                        j = mPreviewSize.width;
                        i = mPreviewSize.height;
                    }
                } else
                {
                    i = l;
                    j = k;
                }
                if (k * i <= l * j)
                {
                    break label0;
                }
                i = (i * k) / j;
                view.layout(0, (l - i) / 2, k, (i + l) / 2);
            }
            return;
        }
        i = (j * l) / i;
        view.layout((k - i) / 2, 0, (i + k) / 2, l);
    }

    protected void onMeasure(int i, int j)
    {
        i = resolveSize(getSuggestedMinimumWidth(), i);
        j = resolveSize(getSuggestedMinimumHeight(), j);
        setMeasuredDimension(i, j);
        if (mSupportedPreviewSizes != null)
        {
            mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes, i, j);
        }
    }

    public void setCamera(Camera camera)
    {
        mCamera = camera;
        if (mCamera != null)
        {
            mSupportedPreviewSizes = mCamera.getParameters().getSupportedPreviewSizes();
            requestLayout();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        if (mCamera != null)
        {
            surfaceholder = mCamera.getParameters();
            surfaceholder.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
            requestLayout();
            mCamera.setParameters(surfaceholder);
            mCamera.startPreview();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        try
        {
            if (mCamera != null)
            {
                mCamera.setPreviewDisplay(surfaceholder);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            Log.e("Preview", "IOException caused by setPreviewDisplay()", surfaceholder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        if (mCamera != null)
        {
            mCamera.stopPreview();
        }
    }

    public void switchCamera(Camera camera)
    {
        android.hardware.Camera.Parameters parameters;
        boolean flag;
        if (!mIsFrontCamera.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsFrontCamera = Boolean.valueOf(flag);
        setCamera(camera);
        try
        {
            camera.setPreviewDisplay(mHolder);
        }
        catch (IOException ioexception)
        {
            Log.e("Preview", "IOException caused by setPreviewDisplay()", ioexception);
        }
        parameters = camera.getParameters();
        mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes, getMeasuredWidth(), getMeasuredHeight());
        parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
        if (mCamera.getParameters().get("camera-id") != null)
        {
            enforceLayout();
        } else
        {
            requestLayout();
        }
        camera.setParameters(parameters);
    }
}
