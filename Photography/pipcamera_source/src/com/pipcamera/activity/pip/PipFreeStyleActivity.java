// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.pip.fragment.PipFreeStyleFragment;
import yb;
import yg;
import yl;

public class PipFreeStyleActivity extends FullscreenActivity
{

    private ProgressDialog a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private String e;

    public PipFreeStyleActivity()
    {
        e = "";
    }

    public static Intent g()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        return intent;
    }

    public void a()
    {
        showDialog(1);
    }

    public void a(Bitmap bitmap)
    {
        b = bitmap;
    }

    public void b()
    {
        a = null;
        removeDialog(1);
    }

    public void b(Bitmap bitmap)
    {
        c = bitmap;
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
            super.onBackPressed();
            System.gc();
            return;
        }
    }

    public void c(Bitmap bitmap)
    {
        d = bitmap;
    }

    public Bitmap d()
    {
        if (b == null || b.isRecycled())
        {
            b = yl.a().b(yb.i);
        }
        return b;
    }

    public Bitmap e()
    {
        return c;
    }

    public Bitmap f()
    {
        return d;
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030076);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        e = bundle.getString("SelectedImageUri");
_L4:
        bundle = PipFreeStyleFragment.b(e);
        getSupportFragmentManager().beginTransaction().add(0x7f0c0221, bundle).commit();
        return;
_L2:
        bundle = getIntent();
        if (bundle != null)
        {
            e = bundle.getStringExtra("SelectedImageUri");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Dialog onCreateDialog(int i)
    {
        ProgressDialog progressdialog;
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this);
            break;
        }
        progressdialog.setMessage(getResources().getString(0x7f0601a4));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        a = progressdialog;
        return progressdialog;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            c();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
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
        bundle.putString("SelectedImageUri", e);
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
