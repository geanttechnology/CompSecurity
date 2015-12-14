// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.Window;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.b;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.gpuimage.camera.GPUImageCameraView;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.u;
import com.pf.common.utility.m;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            b, LauncherActivity

public class CameraLandscapeActivity extends BaseActivity
    implements android.view.SurfaceHolder.Callback, b
{

    public static final UUID a = UUID.randomUUID();
    private static AtomicBoolean b = new AtomicBoolean(false);
    private GPUImageCameraView c;
    private CameraCtrl d;
    private com.cyberlink.youcammakeup.activity.b e;
    private boolean f;

    public CameraLandscapeActivity()
    {
        f = false;
    }

    static CameraCtrl a(CameraLandscapeActivity cameralandscapeactivity)
    {
        return cameralandscapeactivity.d;
    }

    static boolean a(CameraLandscapeActivity cameralandscapeactivity, boolean flag)
    {
        cameralandscapeactivity.f = flag;
        return flag;
    }

    public void finish()
    {
        e.a();
        super.finish();
    }

    public void j()
    {
        e.a();
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(null);
        m.e("CameraLandscapeActivity", "Create");
        if (!LiveDemoConfigHelper.h().m())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        getWindow().addFlags(0x200000);
        getWindow().addFlags(0x80000);
        getWindow().addFlags(128);
        long l;
        bundle = LiveDemoConfigHelper.h().n();
        m.b("CameraLandscapeActivity", (new StringBuilder()).append("onCreate, info. timeString=").append(bundle).toString());
        Object obj = Pattern.compile("(\\d\\d):(\\d\\d)").matcher(bundle);
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        bundle = ((Matcher) (obj)).group(1);
        obj = ((Matcher) (obj)).group(2);
        Calendar calendar = Calendar.getInstance();
        l = calendar.getTimeInMillis();
        calendar.set(11, Integer.parseInt(bundle));
        calendar.set(12, Integer.parseInt(((String) (obj))));
        l = calendar.getTimeInMillis() - l;
        m.b("CameraLandscapeActivity", (new StringBuilder()).append("onCreate(), diff (millisecond)=").append(l).toString());
        if (l > 0L)
        {
            try
            {
                Globals.a(new Runnable() {

                    final CameraLandscapeActivity a;

                    public void run()
                    {
                        if (!a.b())
                        {
                            CameraLandscapeActivity.a(a, true);
                            a.finish();
                        }
                    }

            
            {
                a = CameraLandscapeActivity.this;
                super();
            }
                }, l);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                m.e("CameraLandscapeActivity", (new StringBuilder()).append("onCreate(), error. e=").append(bundle).toString());
            }
        }
        setContentView(0x7f030011);
        ViewEngine.a().b(-7L);
        StatusManager.j().F();
        StatusManager.j().a(-1L, a);
        StatusManager.j().a("cameraLandscapeView");
        StatusManager.j().a(-7L, a);
        e = new com.cyberlink.youcammakeup.activity.b(new Runnable() {

            final CameraLandscapeActivity a;

            public void run()
            {
                if (CameraLandscapeActivity.a(a) != null)
                {
                    CameraLandscapeActivity.a(a).h();
                }
            }

            
            {
                a = CameraLandscapeActivity.this;
                super();
            }
        });
        if (u.c)
        {
            c = (GPUImageCameraView)findViewById(0x7f0c008d);
            c.getHolder().addCallback(this);
            d = new CameraCtrl(this, getWindow().getDecorView(), c, this);
            d.b();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), 0x7f07036f, 1).show();
            j();
            return;
        }
    }

    protected void onDestroy()
    {
        m.e("CameraLandscapeActivity", "Destroy");
        e.a();
        if (u.c)
        {
            c.getHolder().removeCallback(this);
            d.g();
        }
        d = null;
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (u.c)
        {
            flag = d.a(i, keyevent);
        }
        if (flag)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (u.c)
        {
            flag = d.b(i, keyevent);
        }
        if (flag)
        {
            return true;
        } else
        {
            j();
            return true;
        }
    }

    protected void onPause()
    {
        m.e("CameraLandscapeActivity", "Pause");
        if (isFinishing())
        {
            e.a();
        }
        if (u.c)
        {
            d.e();
        }
        if (f)
        {
            Globals.d().c(null);
        } else
        {
            Globals.d().c("cameraLandscapeView");
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        m.e("CameraLandscapeActivity", "Resume");
        if (u.c)
        {
            d.d();
        }
        StatusManager.j().a("cameraLandscapeView");
        Globals.d().c(null);
        StatusManager.j().F();
    }

    protected void onStart()
    {
        super.onStart();
        m.e("CameraLandscapeActivity", "Start");
        if (u.c)
        {
            d.c();
        }
    }

    protected void onStop()
    {
        m.e("CameraLandscapeActivity", "Stop");
        if (u.c)
        {
            d.f();
        }
        super.onStop();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int k, int l)
    {
        m.e("CameraLandscapeActivity", "surfaceChanged");
        d.surfaceChanged(surfaceholder, i, k, l);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        m.e("CameraLandscapeActivity", "surfaceCreated");
        d.surfaceCreated(surfaceholder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        m.e("CameraLandscapeActivity", "surfaceDestroyed");
        d.surfaceDestroyed(surfaceholder);
    }

}
