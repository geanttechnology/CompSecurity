// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.Window;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.b;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.gpuimage.camera.GPUImageCameraView;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.ca;
import com.cyberlink.youcammakeup.utility.u;
import com.pf.common.utility.m;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            a, LauncherActivity

public class CameraActivity extends BaseActivity
    implements android.view.SurfaceHolder.Callback, b
{

    public static final UUID a = UUID.randomUUID();
    private static AtomicBoolean b = new AtomicBoolean(false);
    private GPUImageCameraView c;
    private CameraCtrl d;
    private a e;

    public CameraActivity()
    {
    }

    static CameraCtrl a(CameraActivity cameraactivity)
    {
        return cameraactivity.d;
    }

    public static boolean a(boolean flag, boolean flag1)
    {
        return b.compareAndSet(flag, flag1);
    }

    public static void b(boolean flag)
    {
        b.set(flag);
    }

    public static boolean k()
    {
        return b.get();
    }

    public void a(String s)
    {
        if (u.c)
        {
            d.a(s);
        }
    }

    public void finish()
    {
        e.a();
        super.finish();
    }

    public void j()
    {
        e.a();
        Object obj = getIntent();
        if (obj != null)
        {
            obj = (Class)((Intent) (obj)).getSerializableExtra(getResources().getString(0x7f070729));
            if (obj != null)
            {
                startActivity(new Intent(getApplicationContext(), ((Class) (obj))));
                finish();
                return;
            }
        }
        if (DownloadUseUtils.a(this) == null)
        {
            startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        bn.a(null, -1L, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a, new e() {

            final CameraActivity a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
            }

            
            {
                a = CameraActivity.this;
                super();
            }
        });
        super.onCreate(null);
        m.e("CameraActivity", "Create");
        setContentView(0x7f030005);
        ViewEngine.a().b(-7L);
        StatusManager.j().F();
        StatusManager.j().a(-1L, a);
        StatusManager.j().a("cameraView");
        StatusManager.j().a(-7L, a);
        e = new a(new Runnable() {

            final CameraActivity a;

            public void run()
            {
                if (CameraActivity.a(a) != null)
                {
                    CameraActivity.a(a).h();
                }
            }

            
            {
                a = CameraActivity.this;
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
        m.e("CameraActivity", "Destroy");
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
        if (!flag);
        return true;
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        d.a();
    }

    protected void onPause()
    {
        m.e("CameraActivity", "Pause");
        if (isFinishing())
        {
            e.a();
        }
        if (u.c)
        {
            d.e();
        }
        Globals.d().c("cameraView");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        m.e("CameraActivity", "Resume");
        if (u.c)
        {
            d.d();
        }
        StatusManager.j().a("cameraView");
        Globals.d().c(null);
        StatusManager.j().F();
        ca.b().a();
    }

    protected void onStart()
    {
        super.onStart();
        m.e("CameraActivity", "Start");
        if (u.c)
        {
            d.c();
        }
    }

    protected void onStop()
    {
        m.e("CameraActivity", "Stop");
        if (u.c)
        {
            d.f();
        }
        super.onStop();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int l, int i1)
    {
        m.e("CameraActivity", "surfaceChanged");
        d.surfaceChanged(surfaceholder, i, l, i1);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        m.e("CameraActivity", "surfaceCreated");
        d.surfaceCreated(surfaceholder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        m.e("CameraActivity", "surfaceDestroyed");
        d.surfaceDestroyed(surfaceholder);
    }

}
