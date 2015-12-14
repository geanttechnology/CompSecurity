// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.d;
import com.socialin.android.multiselect.e;
import myobfuscated.cw.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.instagram:
//            a, g, e, h, 
//            f

public class InstagramMainActivity extends BaseActivity
    implements android.app.ActionBar.TabListener
{

    private static final String a = com/socialin/android/instagram/InstagramMainActivity.getSimpleName();
    private boolean b;
    private e c;
    private a d;
    private ViewPager e;
    private SlidingTabLayout f;

    public InstagramMainActivity()
    {
        b = true;
        c = null;
        e = null;
        f = null;
    }

    private void a()
    {
        Object obj = getSupportActionBar();
        ((ActionBar) (obj)).setDisplayHomeAsUpEnabled(true);
        ((ActionBar) (obj)).setIcon(getResources().getDrawable(0x7f020395));
        ((ActionBar) (obj)).setTitle(getString(0x7f0802e2));
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            ((ActionBar) (obj)).setHomeAsUpIndicator(0x7f020781);
        }
        Log.i("MY LOG", "this is instagram");
        f = (SlidingTabLayout)findViewById(0x7f10068c);
        e = (ViewPager)findViewById(0x7f10068d);
        obj = new b(this, getFragmentManager());
        Bundle bundle = new Bundle();
        boolean flag;
        if (d == null || TextUtils.isEmpty(d.a))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        bundle.putBoolean("user.authorized", flag);
        ((b) (obj)).a(getString(0x7f0805bc), com/socialin/android/instagram/g, bundle, 0x7f10007e);
        ((b) (obj)).a(getString(0x7f0805c0), com/socialin/android/instagram/e, null, 0x7f10007f);
        ((b) (obj)).notifyDataSetChanged();
        e.setAdapter(((android.support.v4.view.PagerAdapter) (obj)));
        f.setViewPager(e);
        f.a(1).setSelected(true);
        e.setCurrentItem(1);
    }

    private void b()
    {
        if (getCurrentFocus() != null)
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 800 && j == 326)
        {
            intent = intent.getExtras().getString("oauth2ResultJson");
            try
            {
                intent = new a(new JSONObject(intent));
                h.a(getApplicationContext(), intent);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                com.socialin.android.d.a(a, intent);
            }
            a();
        }
        if (j == 1)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03013b);
        d = h.a(getApplicationContext());
        if (!com.socialin.android.instagram.h.b(getApplicationContext()))
        {
            (new f(this)).a(800);
            return;
        } else
        {
            a();
            return;
        }
    }

    public void onFragmentFinishWithResultError(int i)
    {
        super.onFragmentFinishWithResultError(i);
        String s;
        if (i == 11)
        {
            s = "Error while loading Instagram data";
        } else
        {
            s = "An Error occured";
        }
        Toast.makeText(this, s, 0).show();
    }

    public void onFragmentImageSelected(String s, boolean flag, String as[], String as1[], int i, JSONArray jsonarray)
    {
        super.onFragmentImageSelected(s, flag, as, as1, i, jsonarray);
        if (!b) goto _L2; else goto _L1
_L1:
        as = null;
        jsonarray = jsonarray.getString(0);
        as = jsonarray;
_L3:
        c.a(s, as1[i], as);
        return;
        jsonarray;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(jsonarray.getMessage()).toString()
        });
        if (true) goto _L3; else goto _L2
_L2:
        as1 = new Intent();
        as1.setData(Uri.parse(s));
        as1.putExtra("path", as[i]);
        setResult(-1, as1);
        finish();
        return;
    }

    public void onFragmentResult(int i, Intent intent)
    {
        super.onFragmentResult(i, intent);
        if (i == 327)
        {
            Toast.makeText(this, "An Error occured", 0).show();
        } else
        if (intent != null)
        {
            intent = intent.getExtras().getString("oauth2ResultJson");
            try
            {
                d = new a(new JSONObject(intent));
                h.a(getApplicationContext(), d);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(intent.getMessage()).toString()
                });
            }
            return;
        }
    }

    public void onInstagramTokenResult()
    {
        super.onInstagramTokenResult();
        d = h.a(getApplicationContext());
        a();
        f.a(0).setSelected(true);
        e.setCurrentItem(0);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        bundle = getIntent();
        if (bundle != null && bundle.hasExtra("multipleCheckMode"))
        {
            b = bundle.getBooleanExtra("multipleCheckMode", false);
        }
        if (b)
        {
            bundle = getFragmentManager();
            FragmentTransaction fragmenttransaction = bundle.beginTransaction();
            c = (e)bundle.findFragmentByTag("multiselectFragment");
            if (c != null && c.isAdded())
            {
                fragmenttransaction.show(c);
            } else
            {
                c = new e();
                fragmenttransaction.add(0x7f100505, c, "multiselectFragment");
            }
            fragmenttransaction.commitAllowingStateLoss();
        }
    }

    public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
    {
        b();
    }

    public void onTabSelected(android.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
    {
        b();
    }

    public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
    {
    }

}
