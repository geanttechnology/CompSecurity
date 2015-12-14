// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import com.melnykov.fab.FloatingActionButton;
import com.picsart.studio.utils.a;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.picsart.profile.adapter.ap;
import com.socialin.android.picsart.profile.fragment.bx;
import com.socialin.android.picsart.profile.fragment.by;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            TagPhotosActivity, BottomSheetActivity

public class TopTagsActivity extends TagPhotosActivity
    implements a
{

    private int c;
    private FloatingActionButton d;
    private ViewPager e;
    private ap f;

    public TopTagsActivity()
    {
    }

    static int a(TopTagsActivity toptagsactivity, int i)
    {
        toptagsactivity.c = i;
        return i;
    }

    static FloatingActionButton a(TopTagsActivity toptagsactivity)
    {
        return toptagsactivity.d;
    }

    public final void a()
    {
        d.a(true, true, false);
    }

    public final void b()
    {
        d.a(false, true, false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030230);
        e = (ViewPager)findViewById(0x7f100a34);
        Object obj;
        Object obj1;
        if (getIntent().getExtras() == null)
        {
            obj = bundle;
        } else
        {
            obj = getIntent().getExtras();
        }
        a = ((Bundle) (obj)).getString("key.tag");
        obj1 = getSupportActionBar();
        if (obj1 != null)
        {
            ((ActionBar) (obj1)).setDisplayHomeAsUpEnabled(true);
            ((ActionBar) (obj1)).setIcon(getResources().getDrawable(0x7f020404));
            Object obj2;
            if (a != null)
            {
                obj = (new StringBuilder("#")).append(a).toString();
            } else
            {
                obj = "";
            }
            ((ActionBar) (obj1)).setTitle(((CharSequence) (obj)));
        }
        d = (FloatingActionButton)findViewById(0x7f1006cd);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            private TopTagsActivity a;

            public final void onClick(View view)
            {
                view = new Intent(a, com/socialin/android/picsart/profile/activity/BottomSheetActivity);
                a.startActivity(view);
            }

            
            {
                a = TopTagsActivity.this;
                super();
            }
        });
        e.setVisibility(0);
        obj = (SlidingTabLayout)findViewById(0x7f10068c);
        if (bundle != null)
        {
            c = bundle.getInt("selected_tab");
        }
        ((SlidingTabLayout) (obj)).setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private TopTagsActivity a;

            public final void onPageSelected(int i)
            {
                super.onPageSelected(i);
                com.socialin.android.picsart.profile.activity.TopTagsActivity.a(a, i);
            }

            
            {
                a = TopTagsActivity.this;
                super();
            }
        });
        f = new ap(getFragmentManager());
        obj2 = new Bundle();
        ((Bundle) (obj2)).putString("key.tag", a);
        bundle = new Bundle();
        bundle.putString("key.tag", a);
        bundle.putBoolean("key.is.popular", false);
        ((Bundle) (obj2)).putString("fName", "UserTagDetailsFragment.popular");
        bundle.putString("fName", "UserTagDetailsFragment.recent");
        obj1 = new by();
        ((by) (obj1)).setArguments(((Bundle) (obj2)));
        obj2 = new bx();
        ((bx) (obj2)).setArguments(bundle);
        f.a(((android.app.Fragment) (obj1)), getString(0x7f0802e5), 0x7f100081);
        f.a(((android.app.Fragment) (obj2)), getString(0x7f08032f), 0x7f100092);
        e.setAdapter(f);
        e.setCurrentItem(c);
        ((SlidingTabLayout) (obj)).setViewPager(e);
        ((SlidingTabLayout) (obj)).a(c).setSelected(true);
        ((SlidingTabLayout) (obj)).setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private TopTagsActivity a;

            public final void onPageSelected(int i)
            {
                com.socialin.android.picsart.profile.activity.TopTagsActivity.a(a).a(true, true, false);
            }

            
            {
                a = TopTagsActivity.this;
                super();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (a != null)
        {
            bundle.putString("key.tag", a);
        }
        bundle.putInt("selected_tab", c);
        super.onSaveInstanceState(bundle);
    }
}
