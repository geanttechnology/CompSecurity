// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import bzr;
import bzs;
import bzt;
import bzu;
import cdq;
import cdt;
import cdv;
import cdw;
import cdx;
import cee;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public abstract class CameraCaptureActivity extends Activity
    implements cdt
{

    private static final File b = Environment.getExternalStorageDirectory();
    private final String a = "PreviewRatio";
    private cdw c;
    private final cdv d = new bzs(this);
    public int i;
    public int j;
    public BeautyCameraGLSurfaceView k;
    public bzu l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    protected boolean s;
    public boolean t;

    public CameraCaptureActivity()
    {
        i = 0;
        j = 0;
        c = null;
        m = true;
        n = false;
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        t = false;
    }

    private void a()
    {
        b();
        if (c != null)
        {
            c.d();
            c = null;
        }
    }

    public static void a(CameraCaptureActivity cameracaptureactivity)
    {
        cameracaptureactivity.c();
    }

    public static void b(CameraCaptureActivity cameracaptureactivity)
    {
        cameracaptureactivity.a();
    }

    private void c()
    {
        k.setSurfaceContainerSize(i, j);
    }

    public EnumRecordResult a(String s1)
    {
        if (c != null || !m)
        {
            return EnumRecordResult.RESULT_FAIL_NOT_PREPARE;
        }
        try
        {
            c = new cdw(s1, l);
            m = false;
            getApplicationContext().checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid());
            getApplicationContext().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid());
            new cdx(c, d, k.mVideoHeight, k.mVideoWidth);
            new cdq(c, d, this);
            if (!c.b())
            {
                return EnumRecordResult.RESULT_FAIL_PERMISSION_DENY;
            }
            c.c();
            c.e();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return EnumRecordResult.RESULT_FAIL_UNKOWN;
        }
        return EnumRecordResult.RESULT_SUCCESS;
    }

    public void a(int i1, int j1, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState enumcameracapturestate)
    {
        if (k == null)
        {
            return;
        }
        k.setCaptureState(enumcameracapturestate);
        if (enumcameracapturestate == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO || enumcameracapturestate == jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO)
        {
            k.setPreviewRatio(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_none);
            k.initCameraPreviewSize(i1, j1);
            return;
        } else
        {
            enumcameracapturestate = f();
            k.setPreviewRatio(enumcameracapturestate);
            k.initCameraPreviewSize(i1, j1);
            return;
        }
    }

    public void a(cdx cdx1)
    {
        cee cee1 = (cee)k.getRender();
        k.queueEvent(new bzr(this, cee1, cdx1));
    }

    public void a(BeautyCameraGLSurfaceView beautycameraglsurfaceview, Context context, boolean flag)
    {
        l = new bzu(this);
        k = beautycameraglsurfaceview;
    }

    public void a(jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        String s1;
        android.content.SharedPreferences.Editor editor;
        editor = getSharedPreferences("PreviewRatio", 0).edit();
        s1 = "";
        bzt.a[enumpreviewratio.ordinal()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 72
    //                   2 78
    //                   3 84;
           goto _L1 _L2 _L3 _L4
_L1:
        enumpreviewratio = s1;
_L6:
        editor.putString("ratio", enumpreviewratio);
        editor.commit();
        return;
_L2:
        enumpreviewratio = "none";
        continue; /* Loop/switch isn't completed */
_L3:
        enumpreviewratio = "43";
        continue; /* Loop/switch isn't completed */
_L4:
        enumpreviewratio = "11";
        if (true) goto _L6; else goto _L5
_L5:
    }

    public abstract void a(boolean flag);

    public abstract void b();

    public jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio f()
    {
        String s1 = getSharedPreferences("PreviewRatio", 0).getString("ratio", "");
        if (s1.compareTo("none") == 0)
        {
            return jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_none;
        }
        if (s1.compareTo("11") == 0)
        {
            return jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one;
        }
        if (s1.compareTo("43") == 0)
        {
            return jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three;
        }
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            return jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_four2three;
        } else
        {
            return jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio.Ratio_one2one;
        }
    }

    public void g()
    {
    }

    public void h()
    {
        if (k != null)
        {
            k.switchCamera();
            if (c != null)
            {
                a(c.a());
                return;
            }
        }
    }

    public boolean i()
    {
label0:
        {
            boolean flag = false;
            try
            {
                if (c == null)
                {
                    break label0;
                }
                c.d();
                c = null;
            }
            catch (Exception exception)
            {
                return false;
            }
            flag = true;
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        Log.i("CameraCaptureActivity", "onDestroy");
        l.a();
        super.onDestroy();
    }

    public void onPause()
    {
        Log.i("CameraCaptureActivity", "onPause -- releasing camera");
        k.pauseAll();
        i();
        super.onPause();
        Log.e("CameraCaptureActivity", "onPause complete");
    }

    public void onResume()
    {
        super.onResume();
        k.resumeAll();
    }


    private class EnumRecordResult extends Enum
    {

        private static final EnumRecordResult $VALUES[];
        public static final EnumRecordResult RESULT_FAIL_NOT_PREPARE;
        public static final EnumRecordResult RESULT_FAIL_PERMISSION_DENY;
        public static final EnumRecordResult RESULT_FAIL_UNKOWN;
        public static final EnumRecordResult RESULT_SUCCESS;

        public static EnumRecordResult valueOf(String s1)
        {
            return (EnumRecordResult)Enum.valueOf(jp/co/cyberagent/android/gpuimage/grafika/CameraCaptureActivity$EnumRecordResult, s1);
        }

        public static EnumRecordResult[] values()
        {
            return (EnumRecordResult[])$VALUES.clone();
        }

        static 
        {
            RESULT_SUCCESS = new EnumRecordResult("RESULT_SUCCESS", 0);
            RESULT_FAIL_NOT_PREPARE = new EnumRecordResult("RESULT_FAIL_NOT_PREPARE", 1);
            RESULT_FAIL_PERMISSION_DENY = new EnumRecordResult("RESULT_FAIL_PERMISSION_DENY", 2);
            RESULT_FAIL_UNKOWN = new EnumRecordResult("RESULT_FAIL_UNKOWN", 3);
            $VALUES = (new EnumRecordResult[] {
                RESULT_SUCCESS, RESULT_FAIL_NOT_PREPARE, RESULT_FAIL_PERMISSION_DENY, RESULT_FAIL_UNKOWN
            });
        }

        private EnumRecordResult(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
