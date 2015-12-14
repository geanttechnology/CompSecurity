// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.pip.fragment.Pip2ProcessFragment;
import com.pipcamera.activity.pip.fragment.Pip2StyleFragment;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneCatalog;
import com.wantu.piprender.ESceneMode;
import java.util.List;
import yf;
import yg;
import yl;

public class Pip2FragmentActivity extends FullscreenActivity
{

    private ProgressDialog a;
    private yf b;
    private int c;
    private Bitmap d;
    private Pip2StyleFragment e;
    private String f;

    public Pip2FragmentActivity()
    {
        f = "";
    }

    public Bitmap a(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo != null)
        {
            return tdfsceneinfo.getPipCoverBitmap(this);
        } else
        {
            return null;
        }
    }

    public void a()
    {
        showDialog(1);
    }

    public void a(int l)
    {
        c = l;
    }

    public void a(Bitmap bitmap)
    {
        yg.a().a("pip2foresourceimage", bitmap);
    }

    public void a(yf yf1)
    {
        b = yf1;
    }

    public Bitmap b(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo != null)
        {
            return tdfsceneinfo.getPipMaskBitmap(this);
        } else
        {
            return null;
        }
    }

    public void b()
    {
        a = null;
        removeDialog(1);
    }

    public void b(Bitmap bitmap)
    {
        yg.a().a("pip2bgsourceimage", bitmap);
    }

    public ProgressDialog c()
    {
        return a;
    }

    public void c(Bitmap bitmap)
    {
        yg.a().a("pip2sourceimage", bitmap);
    }

    public void d()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 0)
        {
            fragmentmanager.popBackStack(fragmentmanager.getBackStackEntryAt(0).getId(), 1);
            return;
        } else
        {
            yg.a().b();
            yl.a().c();
            finish();
            overridePendingTransition(0x10a0002, 0x10a0003);
            super.onBackPressed();
            return;
        }
    }

    public void d(Bitmap bitmap)
    {
        if (d != null && !d.isRecycled())
        {
            d.recycle();
            d = null;
        }
        d = bitmap;
    }

    public void e()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() < 1)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            Pip2ProcessFragment pip2processfragment = new Pip2ProcessFragment();
            fragmenttransaction.setCustomAnimations(0x7f040014, 0x7f040015, 0x7f040016, 0x7f040017);
            fragmenttransaction.replace(0x7f0c01ea, pip2processfragment);
            fragmenttransaction.addToBackStack(null);
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public Bitmap f()
    {
        return yg.a().a("pip2foresourceimage");
    }

    public Bitmap g()
    {
        return yg.a().a("pip2bgsourceimage");
    }

    public Bitmap h()
    {
        return yg.a().a("pip2sourceimage");
    }

    public Bitmap i()
    {
        return d;
    }

    public yf j()
    {
        if (b == null)
        {
            b = new yf();
        }
        return b;
    }

    public TDFSceneInfo k()
    {
        TDFSceneInfo tdfsceneinfo = null;
        List list = j().a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        if (c < list.size())
        {
            tdfsceneinfo = (TDFSceneInfo)list.get(c);
        }
        return tdfsceneinfo;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03006b);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        f = bundle.getString("SelectedImageUri");
_L4:
        Uri uri = Uri.parse(f);
        b = new yf();
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (bundle == null)
        {
            bundle = fragmentmanager.beginTransaction();
            e = Pip2StyleFragment.a(uri.toString());
            bundle.add(0x7f0c01ea, e);
            bundle.commit();
        }
        return;
_L2:
        Intent intent = getIntent();
        if (intent != null)
        {
            f = intent.getStringExtra("SelectedImageUri");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Dialog onCreateDialog(int l)
    {
        ProgressDialog progressdialog;
        switch (l)
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
        bundle.putString("SelectedImageUri", f);
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
