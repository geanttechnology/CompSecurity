// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class mm
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ActivityCameraNew a;

    public mm(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onGlobalLayout()
    {
        int i = a.getResources().getDisplayMetrics().heightPixels;
        int l = a.getResources().getDisplayMetrics().widthPixels;
        int k = yp.a(a, 60F);
        int k2 = yp.a(a, 44F);
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)ActivityCameraNew.Y(a).getLayoutParams();
        layoutparams = (android.widget.FrameLayout.LayoutParams)ActivityCameraNew.Z(a).getLayoutParams();
        int k1 = a.k.getPreviewWidth();
        int l1 = a.k.getPreviewHeight();
        int j = l;
        i = k;
        if (k1 != 0)
        {
            j = l;
            i = k;
            if (l1 != 0)
            {
                int i2 = yp.a(a, 45F);
                i = yp.a(a, 60F);
                j = a.getResources().getDisplayMetrics().widthPixels;
                int j2 = a.getResources().getDisplayMetrics().heightPixels;
                int j1 = j2 - i - i2;
                android.widget.FrameLayout.LayoutParams layoutparams1;
                int i1;
                if ((float)j / (float)j1 < (float)l1 / (float)k1)
                {
                    j1 = (int)(((float)j * (float)k1) / (float)l1);
                    i = j2 - j1 - k2;
                    k = j;
                    i1 = k;
                } else
                {
                    i1 = (int)(((float)j1 * (float)l1) / (float)k1);
                    i = k;
                }
                layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutparams1.leftMargin = (j - i1) / 2;
                layoutparams1.topMargin = i2;
                layoutparams1.height = j1;
                layoutparams1.width = i1;
                layoutparams1.gravity = 48;
                ActivityCameraNew.Y(a).setLayoutParams(layoutparams1);
                a.i = i1;
                a.j = j1;
                layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutparams1.leftMargin = 0;
                layoutparams1.topMargin = 0;
                layoutparams1.gravity = 48;
                layoutparams1.width = j;
                layoutparams1.height = i2;
                ActivityCameraNew.aa(a).setLayoutParams(layoutparams1);
                layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutparams1.leftMargin = 0;
                layoutparams1.bottomMargin = 0;
                layoutparams1.height = i;
                layoutparams1.width = j;
                layoutparams1.gravity = 80;
                ActivityCameraNew.Z(a).setLayoutParams(layoutparams1);
                ActivityCameraNew.ac(a).sendMessage(ActivityCameraNew.ab(a).obtainMessage(2));
                Log.e(ActivityCameraNew.i(a), (new StringBuilder()).append("srcH=").append(j2).append(", srcW=").append(j).toString());
                Log.e(ActivityCameraNew.i(a), (new StringBuilder()).append("mCameraPreviewWidth=").append(k1).append(", mCameraPreviewHeight=").append(l1).toString());
                Log.e(ActivityCameraNew.i(a), (new StringBuilder()).append("mSurfaceContainerWidth=").append(a.i).append(", mSurfaceContainerHeight=").append(a.j).toString());
                Log.e(ActivityCameraNew.i(a), (new StringBuilder()).append("surfaceH=").append(j1).append(", takingBarH=").append(i).toString());
            }
        }
        ActivityCameraNew.a(a, a.k.getCaptureState());
        if (!ActivityCameraNew.j(a))
        {
            i -= yp.a(a, 70F);
        }
        layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams1.leftMargin = 0;
        layoutparams1.height = yp.a(a, 115F);
        layoutparams1.width = j;
        layoutparams1.gravity = 80;
        layoutparams1.bottomMargin = i;
        ActivityCameraNew.ad(a).setLayoutParams(layoutparams1);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityCameraNew.Z(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            ActivityCameraNew.Z(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            return;
        }
    }
}
