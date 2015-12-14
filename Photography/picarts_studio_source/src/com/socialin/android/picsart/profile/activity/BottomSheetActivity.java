// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.fragment.g;
import java.util.UUID;

public class BottomSheetActivity extends BaseActivity
{

    private float a;
    private g b;
    private View c;
    private String d;

    public BottomSheetActivity()
    {
        a = 0.0F;
    }

    public void finish()
    {
        super.finish();
        overridePendingTransition(0, 0x7f040048);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (b != null)
        {
            b.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (b != null)
        {
            g g1 = b;
            android.app.Fragment fragment = g1.getFragmentManager().findFragmentByTag("FAB_Recent_Photos_Fragment");
            if (fragment != null)
            {
                g1.getFragmentManager().beginTransaction().remove(fragment);
            }
            getFragmentManager().beginTransaction().remove(b);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.width = getResources().getDisplayMetrics().widthPixels;
        layoutparams.gravity = 81;
        getWindow().setAttributes(layoutparams);
        setContentView(0x7f03003f);
        c = findViewById(0x7f1001c0);
        if (bundle == null)
        {
            d = UUID.randomUUID().toString();
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.MainMenuOpenEvent(d));
        } else
        {
            d = bundle.getString("session_id");
        }
        bundle = getFragmentManager().beginTransaction();
        b = new g();
        b.a = d;
        bundle.replace(0x7f1001c0, b, "fab_fragment_tag");
        bundle.commit();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("session_id", d);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getX() < c.getX() || motionevent.getX() > c.getX() + (float)c.getWidth())
        {
            finish();
            return true;
        }
        if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        a = motionevent.getY();
        if (a < c.getY())
        {
            finish();
        }
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (motionevent.getAction() == 2 && motionevent.getY() - a > 20F)
        {
            finish();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
