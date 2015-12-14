// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.compose;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apq;
import bbh;
import bbi;
import bhm;
import bpg;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.ResourceOnlineLibrary.compose.manage.ManageOnlineLibActivity;
import com.wantu.activity.photoselector.InstaPhotoSelectorActivity;

// Referenced classes of package com.instamag.activity.compose:
//            NetMaterialFragement

public class MainOnlineLibActivity extends FullscreenActivity
{

    private String a;
    private ProgressDialog b;
    private Button c;
    private InstaMagType d;
    private bhm e;
    private ProgressBar f;
    private boolean g;
    private int h;

    public MainOnlineLibActivity()
    {
        a = "MainOnlineLibActivity";
        d = InstaMagType.RECT_LIB_SIZE_TYPE;
        h = -1;
    }

    public bhm a()
    {
        if (e == null)
        {
            e = new bhm(h);
        }
        return e;
    }

    public void a(int i, int j)
    {
        if (g)
        {
            finish();
        } else
        if (d() != null && d().isExistedByResId(i))
        {
            Intent intent = new Intent(this, com/wantu/activity/photoselector/InstaPhotoSelectorActivity);
            intent.putExtra("SelectedComposeInfoResId", i);
            intent.putExtra("SelectedComposeInfoImageCount", j);
            startActivity(intent);
            finish();
            return;
        }
    }

    public void a(String s)
    {
        if (b != null && b.isShowing())
        {
            return;
        } else
        {
            b = ProgressDialog.show(this, "", s);
            return;
        }
    }

    public void b()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 0)
        {
            FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmentmanager.popBackStack(fragmentmanager.getBackStackEntryAt(fragmentmanager.getBackStackEntryCount() - 1).getId(), 1);
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            finish();
            overridePendingTransition(0x10a0002, 0x10a0003);
            System.gc();
            return;
        }
    }

    public void backBtnClicked(View view)
    {
        b();
    }

    public void c()
    {
        startActivity(new Intent(this, com/wantu/ResourceOnlineLibrary/compose/manage/ManageOnlineLibActivity));
        overridePendingTransition(0x7f040009, 0);
    }

    public TPhotoMagComposeManager d()
    {
        return apq.c().d();
    }

    protected void e()
    {
        if (f != null)
        {
            f.setVisibility(0);
        }
    }

    protected void f()
    {
        if (f != null)
        {
            f.setVisibility(4);
        }
    }

    protected void g()
    {
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03007c);
        f = (ProgressBar)findViewById(0x7f0d0261);
        ((Button)findViewById(0x7f0d010a)).setOnClickListener(new bbh(this));
        ((TextView)findViewById(0x7f0d0273)).setText(0x7f06003a);
        c = (Button)findViewById(0x7f0d010b);
        c.setOnClickListener(new bbi(this));
        if (bundle != null)
        {
            h = bundle.getInt("initalInstaMagCount");
            g = bundle.getBoolean("initalInstaMagIsFinishActivity");
        }
        if (getIntent() != null)
        {
            int i = getIntent().getIntExtra("initalInstaMagType", 1);
            if (i == 0)
            {
                d = InstaMagType.SQ_LIB_SIZE_TYPE;
            } else
            if (i == 1)
            {
                d = InstaMagType.RECT_LIB_SIZE_TYPE;
            } else
            if (i == 2)
            {
                d = InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
            }
            h = getIntent().getIntExtra("initalInstaMagCount", -1);
            g = getIntent().getBooleanExtra("initalInstaMagIsFinishActivity", false);
            if (g)
            {
                c.setVisibility(4);
            }
        }
        if (InstaBeautyApplication.a(this))
        {
            bundle = (RelativeLayout)findViewById(0x7f0d00b0);
            if (bundle != null)
            {
                bundle.setVisibility(8);
            }
        } else
        if (!bpg.a(this))
        {
            FotoAdFactory.createAdBanner(this, findViewById(0x1020002));
        }
        if (getSupportFragmentManager().getBackStackEntryCount() < 1)
        {
            bundle = new NetMaterialFragement();
            getSupportFragmentManager().beginTransaction().replace(0x7f0d00f6, bundle).commit();
        }
    }

    protected void onDestroy()
    {
        f();
        g();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            b();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onResume()
    {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("initalInstaMagCount", h);
        bundle.putBoolean("initalInstaMagIsFinishActivity", g);
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
    }
}
