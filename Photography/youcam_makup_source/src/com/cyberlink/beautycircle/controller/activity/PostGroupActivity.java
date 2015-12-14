// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.e;
import com.cyberlink.beautycircle.controller.fragment.r;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;

public class PostGroupActivity extends BaseArcMenuActivity
{

    public PostGroupActivity()
    {
    }

    public boolean a(MotionEvent motionevent)
    {
        return ((r)e).a(motionevent);
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
        setContentView(k.bc_activity_post_group);
        Object obj = getIntent();
        if (obj != null)
        {
            obj = ((Intent) (obj)).getStringExtra("Title");
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            obj = "";
        }
        b(((String) (obj)));
        b().a();
        if (bundle == null)
        {
            e = new r();
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
        }
        b(bundle);
    }
}
