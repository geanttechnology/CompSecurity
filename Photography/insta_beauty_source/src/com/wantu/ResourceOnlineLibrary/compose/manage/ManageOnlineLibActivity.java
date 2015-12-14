// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose.manage;

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
import bhu;
import bhv;
import bhw;
import bhx;
import bpg;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose.manage:
//            ManageMaterialFragement

public class ManageOnlineLibActivity extends FullscreenActivity
{

    private String a;
    private Button b;
    private Button c;
    private Button d;
    private Button e;
    private InstaMagType f;
    private ProgressBar g;

    public ManageOnlineLibActivity()
    {
        a = "ManageOnlineLibActivity";
        f = InstaMagType.RECT_LIB_SIZE_TYPE;
    }

    public void a()
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

    public void a(InstaMagType instamagtype)
    {
        f = instamagtype;
    }

    public void a(Boolean boolean1)
    {
        byte byte0 = 4;
        Button button = c;
        int i;
        if (boolean1.booleanValue())
        {
            i = 0;
        } else
        {
            i = 4;
        }
        button.setVisibility(i);
        button = b;
        if (boolean1.booleanValue())
        {
            i = 0;
        } else
        {
            i = 4;
        }
        button.setVisibility(i);
        button = d;
        i = byte0;
        if (boolean1.booleanValue())
        {
            i = 0;
        }
        button.setVisibility(i);
        c.setFocusable(false);
        b.setFocusable(false);
        d.setFocusable(false);
    }

    public InstaMagType b()
    {
        return f;
    }

    public void b(InstaMagType instamagtype)
    {
        if (instamagtype == InstaMagType.RECT_LIB_SIZE_TYPE)
        {
            b.setSelected(true);
            c.setSelected(false);
            d.setSelected(false);
        } else
        {
            if (instamagtype == InstaMagType.SQ_LIB_SIZE_TYPE)
            {
                b.setSelected(false);
                c.setSelected(true);
                d.setSelected(false);
                return;
            }
            if (instamagtype == InstaMagType.LANDSCAPE_LIB_SIZE_TYPE)
            {
                b.setSelected(false);
                c.setSelected(false);
                d.setSelected(true);
                return;
            }
        }
    }

    public void backBtnClicked(View view)
    {
        a();
    }

    public void c(InstaMagType instamagtype)
    {
        a(instamagtype);
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        if (fragment instanceof ManageMaterialFragement)
        {
            ((ManageMaterialFragement)fragment).a(instamagtype);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03007c);
        g = (ProgressBar)findViewById(0x7f0d0261);
        g.setVisibility(4);
        b = (Button)findViewById(0x7f0d0268);
        b.setSelected(true);
        c = (Button)findViewById(0x7f0d0269);
        d = (Button)findViewById(0x7f0d026a);
        b.setOnClickListener(new bhu(this));
        c.setOnClickListener(new bhv(this));
        d.setOnClickListener(new bhw(this));
        ((Button)findViewById(0x7f0d010a)).setOnClickListener(new bhx(this));
        if (getIntent() != null)
        {
            int i = getIntent().getIntExtra("initalInstaMagType", 1);
            if (i == 0)
            {
                f = InstaMagType.SQ_LIB_SIZE_TYPE;
            } else
            if (i == 1)
            {
                f = InstaMagType.RECT_LIB_SIZE_TYPE;
            } else
            if (i == 2)
            {
                f = InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
            }
            b(f);
        }
        e = (Button)findViewById(0x7f0d010b);
        e.setVisibility(4);
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.d())
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
        bundle = new ManageMaterialFragement();
        getSupportFragmentManager().beginTransaction().replace(0x7f0d00f6, bundle).commit();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            a();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onResume()
    {
        super.onResume();
        a(Boolean.valueOf(true));
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }
}
