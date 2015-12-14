// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.controller.fragment.e;
import com.cyberlink.beautycircle.controller.fragment.p;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

public class MeActivity extends BaseArcMenuActivity
{

    protected android.view.View.OnClickListener o;
    protected android.view.View.OnClickListener p;

    public MeActivity()
    {
    }

    public void a(android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        o = onclicklistener;
        p = onclicklistener1;
    }

    public boolean a(MotionEvent motionevent)
    {
        return ((p)e).a(motionevent);
    }

    public String d(String s)
    {
        if (e != null)
        {
            return ((p)e).n();
        } else
        {
            return null;
        }
    }

    protected void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        if (e != null)
        {
            e.onActivityResult(i, l, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_me);
        b("");
        if (bundle == null)
        {
            e = new p();
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
            ((p)e).s = true;
        }
        b(bundle);
    }

    public void onRightBtnClick(View view)
    {
        if (view.getId() == j.top_bar_right_text_btn && o != null)
        {
            o.onClick(view);
            return;
        } else
        {
            p.onClick(view);
            return;
        }
    }
}
