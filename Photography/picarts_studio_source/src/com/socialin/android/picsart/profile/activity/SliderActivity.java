// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import com.picsart.studio.view.SlidingUpPanelLayout;
import com.picsart.studio.view.f;
import com.picsart.studio.view.k;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.picsart.profile.fragment.al;
import com.socialin.android.picsart.profile.fragment.b;
import com.socialin.android.picsart.profile.fragment.r;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import com.socialin.android.util.Utils;

public class SliderActivity extends BaseActivity
    implements f
{

    private k a;
    private al b;
    private b c;
    private r d;
    private SlidingUpPanelLayout e;
    private View f;
    private View g;
    private String h;

    public SliderActivity()
    {
        a = new k(this, (byte)0);
    }

    public static SlidingUpPanelLayout a(SliderActivity slideractivity)
    {
        return slideractivity.e;
    }

    private void b()
    {
        if (e != null)
        {
            e.e();
            f.animate().alpha(0.0F);
        } else
        {
            finish();
        }
        if (h.equals("commentFragment") && b != null)
        {
            getFragmentManager().beginTransaction().remove(b);
        } else
        {
            if (h.equals("addToMembox") && c != null)
            {
                getFragmentManager().beginTransaction().remove(c);
                return;
            }
            if (h.equals("createMembox") && d != null)
            {
                getFragmentManager().beginTransaction().remove(d);
                return;
            }
        }
    }

    public final boolean a()
    {
        return e.d();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (h.equals("commentFragment") && b != null)
        {
            b.onActivityResult(i, j, intent);
        } else
        if (h.equals("addToMembox") && c != null)
        {
            c.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        b();
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        String s;
        byte byte0;
        super.onCreate(bundle);
        obj = getIntent();
        h = ((Intent) (obj)).getStringExtra("sliderContent");
        bundle = getFragmentManager().beginTransaction();
        s = h;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 76
    //                   163210703: 223
    //                   1350003698: 253
    //                   1357982194: 238;
           goto _L1 _L2 _L3 _L4
_L1:
        byte0;
        JVM INSTR tableswitch 0 2: default 104
    //                   0 268
    //                   1 343
    //                   2 416;
           goto _L5 _L6 _L7 _L8
_L5:
        bundle.commit();
        e = (SlidingUpPanelLayout)findViewById(0x7f100766);
        if (e != null)
        {
            g = findViewById(0x7f100765);
            if (h.equals("createMembox"))
            {
                bundle = e;
                if (((SlidingUpPanelLayout) (bundle)).c)
                {
                    bundle.a = com.picsart.studio.view.SlidingUpPanelLayout.PanelState.EXPANDED;
                } else
                {
                    bundle.a(1.0F);
                }
            }
            e.setPanelSlideListener(a);
            bundle = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(bundle);
            e.setPanelHeight(((DisplayMetrics) (bundle)).heightPixels / 2);
            getSupportActionBar().hide();
        }
        return;
_L2:
        if (s.equals("commentFragment"))
        {
            byte0 = 0;
        }
          goto _L1
_L4:
        if (s.equals("addToMembox"))
        {
            byte0 = 1;
        }
          goto _L1
_L3:
        if (s.equals("createMembox"))
        {
            byte0 = 2;
        }
          goto _L1
_L6:
        obj = ((Intent) (obj)).getStringExtra("source");
        setContentView(0x7f030184);
        b = new al();
        b.e = ((String) (obj));
        bundle.setCustomAnimations(GalleryUtils.a, 0);
        bundle.replace(0x7f100336, b, "details_fragment_tag");
        f = findViewById(0x7f100783);
        f.setVisibility(0);
          goto _L5
_L7:
        if (Utils.h(this))
        {
            setContentView(0x7f030184);
            bundle.setCustomAnimations(GalleryUtils.a, 0);
            f = findViewById(0x7f100783);
            f.setVisibility(8);
        } else
        {
            setContentView(0x7f030090);
        }
        c = com.socialin.android.picsart.profile.fragment.b.a();
        bundle.replace(0x7f100336, c, "add_to_membox_fragment_tag");
          goto _L5
_L8:
        if (Utils.h(this))
        {
            setContentView(0x7f030184);
            bundle.setCustomAnimations(GalleryUtils.a, 0);
            f = findViewById(0x7f100783);
            f.setVisibility(8);
        } else
        {
            setContentView(0x7f030090);
        }
        d = (r)getFragmentManager().findFragmentByTag("create_membox_fragment_tag");
        if (d == null)
        {
            d = r.a();
            d.setRetainInstance(true);
            bundle.add(0x7f100336, d, "create_membox_fragment_tag");
        }
          goto _L5
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (h.equals("createMembox"))
        {
            getMenuInflater().inflate(0x7f110000, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() != 0x102002c) goto _L2; else goto _L1
_L1:
        b();
_L4:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (menuitem.getItemId() == 0x7f100ae3)
        {
            d.b();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (g != null && (motionevent.getX() < g.getX() || motionevent.getX() > g.getX() + (float)g.getWidth()) && e != null)
        {
            e.e();
            f.animate().alpha(0.0F);
        }
        return false;
    }
}
