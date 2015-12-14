// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.activity.pip.fragment.PipCameraFragment;
import com.pipcamera.activity.pip.fragment.PipProcessFragment;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneCatalog;
import com.wantu.piprender.ESceneMode;
import java.util.List;
import jw;
import tz;
import yb;
import yf;
import yg;
import yl;

// Referenced classes of package com.pipcamera.activity.pip:
//            PipStyleBaseActivity

public class PipRealTimeCameraActivity extends PipStyleBaseActivity
{

    public PipRealTimeCameraActivity()
    {
    }

    public static Intent k()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        return Intent.createChooser(intent, "\u9009\u62E9\u56FE\u7247");
    }

    public Bitmap a(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo != null)
        {
            return tdfsceneinfo.getPipMaskBitmap(this);
        } else
        {
            return null;
        }
    }

    public void a()
    {
        while (b != null && b.isShowing() || isFinishing()) 
        {
            return;
        }
        try
        {
            b = ProgressDialog.show(this, "", PIPCameraApplication.a.getResources().getString(0x7f0601a4));
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public void a(int i1)
    {
        a = i1;
    }

    public void a(Bitmap bitmap)
    {
        e = bitmap;
    }

    public void a(Matrix matrix)
    {
        d = matrix;
    }

    public void a(yf yf1)
    {
        c = yf1;
    }

    public Bitmap b(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo != null)
        {
            return tdfsceneinfo.getPipCoverBitmap(this);
        } else
        {
            return null;
        }
    }

    public void b()
    {
        if (b == null || !b.isShowing())
        {
            break MISSING_BLOCK_LABEL_29;
        }
        b.dismiss();
        b = null;
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    public void b(Bitmap bitmap)
    {
        f = bitmap;
    }

    public void c()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 0)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmentmanager.popBackStack(fragmentmanager.getBackStackEntryAt(0).getId(), 1);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            yg.a().b();
            yl.a().c();
            finish();
            overridePendingTransition(0x10a0002, 0x10a0003);
            System.gc();
            return;
        }
    }

    public void c(Bitmap bitmap)
    {
        if (g != null && !g.isRecycled())
        {
            g.recycle();
            g = null;
        }
        g = bitmap;
    }

    public void c(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo != null)
        {
            l = tdfsceneinfo;
        }
    }

    public void d()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() < 1)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            PipProcessFragment pipprocessfragment = new PipProcessFragment();
            fragmenttransaction.setCustomAnimations(0x7f040014, 0x7f040015, 0x7f040016, 0x7f040017);
            fragmenttransaction.replace(0x7f0c01f6, pipprocessfragment);
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public Bitmap e()
    {
        if (e == null || e.isRecycled())
        {
            e = yl.a().b(yb.i);
        }
        return e;
    }

    public Bitmap f()
    {
        return f;
    }

    public void finalize()
    {
        Log.v("PIPStyleAcitivity finalize", "PIPStyleAcitivity finalize");
        try
        {
            super.finalize();
            return;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            Crashlytics.logException(throwable);
            return;
        }
    }

    public Matrix g()
    {
        return d;
    }

    public yf h()
    {
        if (c == null)
        {
            c = new yf();
        }
        return c;
    }

    public TDFSceneInfo i()
    {
        TDFSceneInfo tdfsceneinfo = null;
        List list = h().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        if (a < list.size())
        {
            tdfsceneinfo = (TDFSceneInfo)list.get(a);
        }
        return tdfsceneinfo;
    }

    public jw j()
    {
        if (j == null)
        {
            j = jw.a(this);
        }
        return j;
    }

    public Bitmap l()
    {
        return g;
    }

    public void m()
    {
        showDialog(3);
    }

    public void n()
    {
        if (k != null && k.isShowing())
        {
            removeDialog(3);
        }
        k = null;
    }

    public void o()
    {
        showDialog(2);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        i = this;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030070);
        if (l == null)
        {
            l = h().b(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        }
        bundle = PipCameraFragment.a();
        getSupportFragmentManager().beginTransaction().add(0x7f0c01f6, bundle).commit();
    }

    protected Dialog onCreateDialog(int i1)
    {
        ProgressDialog progressdialog2;
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            ProgressDialog progressdialog = new ProgressDialog(this);
            progressdialog.setMessage(getResources().getString(0x7f0601a4));
            progressdialog.setIndeterminate(true);
            progressdialog.setCancelable(false);
            k = progressdialog;
            return progressdialog;

        case 2: // '\002'
            ProgressDialog progressdialog1 = new ProgressDialog(this);
            progressdialog1.setMessage(getResources().getString(0x7f0600da));
            progressdialog1.setIndeterminate(true);
            progressdialog1.setCancelable(true);
            progressdialog1.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final PipRealTimeCameraActivity a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    tz.a().b();
                }

            
            {
                a = PipRealTimeCameraActivity.this;
                super();
            }
            });
            k = progressdialog1;
            return progressdialog1;

        case 3: // '\003'
            progressdialog2 = new ProgressDialog(this);
            break;
        }
        progressdialog2.setMessage(getResources().getString(0x7f0600da));
        progressdialog2.setIndeterminate(true);
        progressdialog2.setCancelable(true);
        k = progressdialog2;
        return progressdialog2;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (b != null && b.isShowing())
        {
            try
            {
                b.dismiss();
                b = null;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
        }
        if (e != null && !e.isRecycled())
        {
            e.recycle();
            e = null;
        }
        if (g != null && !g.isRecycled())
        {
            g.recycle();
            g = null;
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            c();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onOptionsBtnClicked(View view)
    {
        openContextMenu(view);
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void p()
    {
        if (k != null && k.isShowing())
        {
            removeDialog(2);
        }
        k = null;
    }

    static 
    {
        try
        {
            System.loadLibrary("fotobeautyengine");
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }
}
