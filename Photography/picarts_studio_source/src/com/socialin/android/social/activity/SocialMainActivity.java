// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.social.activity;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.d;
import com.socialin.android.multiselect.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import myobfuscated.cw.b;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.socialin.android.social.activity:
//            b, a, c

public class SocialMainActivity extends BaseActivity
{

    private static final String a = com/socialin/android/social/activity/SocialMainActivity.getSimpleName();
    private com.socialin.android.social.activity.b b[] = {
        new com.socialin.android.social.activity.b("interesting", 0x7f100081), new com.socialin.android.social.activity.b("art", 0x7f100071), new com.socialin.android.social.activity.b("beach", 0x7f100072), new com.socialin.android.social.activity.b("birthday", 0x7f100073), new com.socialin.android.social.activity.b("california", 0x7f100074), new com.socialin.android.social.activity.b("italy", 0x7f100084), new com.socialin.android.social.activity.b("japan", 0x7f100085), new com.socialin.android.social.activity.b("france", 0x7f100078), new com.socialin.android.social.activity.b("wedding", 0x7f10009d), new com.socialin.android.social.activity.b("nature", 0x7f10008a), 
        new com.socialin.android.social.activity.b("music", 0x7f100088), new com.socialin.android.social.activity.b("party", 0x7f10008d), new com.socialin.android.social.activity.b("night", 0x7f10008b), new com.socialin.android.social.activity.b("snow", 0x7f100096), new com.socialin.android.social.activity.b("travel", 0x7f10009a), new com.socialin.android.social.activity.b("london", 0x7f100086), new com.socialin.android.social.activity.b("people", 0x7f10008e), new com.socialin.android.social.activity.b("sea", 0x7f100093), new com.socialin.android.social.activity.b("sky", 0x7f100095), new com.socialin.android.social.activity.b("photography", 0x7f10008f), 
        new com.socialin.android.social.activity.b("summer", 0x7f100097)
    };
    private boolean c;
    private e d;
    private ViewPager e;
    private SlidingTabLayout f;
    private b g;
    private SearchView h;
    private a i;

    public SocialMainActivity()
    {
        c = false;
        d = null;
        e = null;
        f = null;
        g = null;
    }

    static String a(String as[])
    {
        return b(as);
    }

    private void a()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (inputmethodmanager.isAcceptingText() && getWindow().getCurrentFocus() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            h.clearFocus();
        }
    }

    static void a(SocialMainActivity socialmainactivity)
    {
        socialmainactivity.a();
    }

    static void a(SocialMainActivity socialmainactivity, String s, String s1)
    {
        socialmainactivity.dismissFragmentProgressDialog();
        Intent intent = new Intent();
        intent.setData(Uri.parse(s));
        intent.putExtra("path", s1);
        socialmainactivity.setResult(-1, intent);
        socialmainactivity.finish();
    }

    static void a(SocialMainActivity socialmainactivity, String s, String s1, JSONArray jsonarray)
    {
        String s2 = null;
        String s3 = jsonarray.getString(0);
        s2 = s3;
        boolean flag = jsonarray.getBoolean(1);
        s2 = s3;
_L2:
        jsonarray = s;
        if (!flag)
        {
            jsonarray = (new StringBuilder("user:")).append(s).toString();
        }
        socialmainactivity.d.a(jsonarray, s1, s2);
        return;
        jsonarray;
        com.socialin.android.d.b(a, "addMultiSelectImage", jsonarray);
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(jsonarray.getMessage()).toString()
        });
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean a(SocialMainActivity socialmainactivity, String s)
    {
        socialmainactivity.onSearchRequested();
        int k = socialmainactivity.g.getCount();
        for (int j = 0; j < k; j++)
        {
            if (socialmainactivity.g.c(j).toString().equalsIgnoreCase(s))
            {
                socialmainactivity.f.a(j).setSelected(true);
                socialmainactivity.e.setCurrentItem(j);
                return true;
            }
        }

        Bundle bundle = new Bundle();
        if (s != null)
        {
            bundle.putString("tag", s);
            socialmainactivity.g.a(s.toUpperCase(), socialmainactivity.i.a, bundle, 0x7f100094);
        }
        socialmainactivity.g.notifyDataSetChanged();
        socialmainactivity.f.setViewPager(socialmainactivity.e);
        socialmainactivity.f.a(k).setSelected(true);
        socialmainactivity.e.setCurrentItem(k);
        return false;
    }

    static SearchView b(SocialMainActivity socialmainactivity)
    {
        return socialmainactivity.h;
    }

    private static transient String b(String as[])
    {
        String s = "";
        Object obj;
        try
        {
            obj = new URL(as[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(a, "buildConnectionUrl", ((Throwable) (obj)));
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((MalformedURLException) (obj)).getMessage()).toString()
            });
            obj = null;
        }
        if (obj != null)
        {
            try
            {
                obj = ((URL) (obj)).openConnection();
                ((URLConnection) (obj)).getInputStream().close();
                obj = ((URLConnection) (obj)).getURL().toString();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(a, "onFragmentImageSelected", ioexception);
                ioexception = s;
            }
        } else
        {
            obj = "";
        }
        while (((String) (obj)).equals(as[0]) || !as[0].contains("_")) 
        {
            return ((String) (obj));
        }
        ioexception = as[0].substring(as[0].lastIndexOf("."));
        s = as[0].substring(as[0].lastIndexOf("_"));
        return as[0].replace(s, ioexception);
    }

    static boolean c(SocialMainActivity socialmainactivity)
    {
        return socialmainactivity.c;
    }

    public void dismissFragmentProgressDialog()
    {
        super.dismissFragmentProgressDialog();
        FragmentTransaction fragmenttransaction;
        Object obj;
        try
        {
            obj = getFragmentManager();
            fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
            obj = ((FragmentManager) (obj)).findFragmentByTag("progressDialogFragment");
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, "showFragmentProgressDialog", exception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (((Fragment) (obj)).isAdded() && !((Fragment) (obj)).isRemoving() && !isFinishing())
        {
            fragmenttransaction.remove(((Fragment) (obj)));
        }
        fragmenttransaction.commitAllowingStateLoss();
        return;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 2)
        {
            a();
        }
        return super.dispatchTouchEvent(motionevent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030244);
        bundle = getIntent();
        if (bundle.hasExtra("multipleCheckMode"))
        {
            c = bundle.getBooleanExtra("multipleCheckMode", false);
        }
        i = new a(this, bundle.getIntExtra("key_social_type", 0));
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        if (i != null)
        {
            bundle.setIcon(getResources().getDrawable(i.c));
            bundle.setTitle(i.d);
        }
        f = (SlidingTabLayout)findViewById(0x7f10068c);
        e = (ViewPager)findViewById(0x7f10068d);
        g = new b(this, getFragmentManager());
        bundle = b;
        int k = bundle.length;
        for (int j = 0; j < k; j++)
        {
            Object obj = bundle[j];
            Bundle bundle1 = new Bundle();
            bundle1.putString("tag", ((com.socialin.android.social.activity.b) (obj)).a);
            g.a(((com.socialin.android.social.activity.b) (obj)).a, i.a, bundle1, ((com.socialin.android.social.activity.b) (obj)).b);
        }

        g.notifyDataSetChanged();
        e.setAdapter(g);
        f.setViewPager(e);
        f.a(0).setSelected(true);
        e.setCurrentItem(0);
        if (c)
        {
            bundle = getFragmentManager();
            FragmentTransaction fragmenttransaction = bundle.beginTransaction();
            d = (e)bundle.findFragmentByTag("multiselectFragment");
            if (d == null)
            {
                d = new e();
                if (i.b > 0)
                {
                    d.a = i.b;
                }
            }
            if (d != null && d.isAdded())
            {
                fragmenttransaction.show(d);
            } else
            {
                fragmenttransaction.setTransition(8194);
                fragmenttransaction.add(0x7f100505, d, "multiselectFragment");
            }
            fragmenttransaction.commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.clear();
        getMenuInflater().inflate(0x7f11000d, menu);
        h = (SearchView)MenuItemCompat.getActionView(menu.findItem(0x7f100ae8));
        h.setQueryHint(getString(0x7f080343));
        h.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {

            private SocialMainActivity a;

            public final boolean onQueryTextChange(String s)
            {
                return false;
            }

            public final boolean onQueryTextSubmit(String s)
            {
                return SocialMainActivity.a(a, s);
            }

            
            {
                a = SocialMainActivity.this;
                super();
            }
        });
        ((ImageView)h.findViewById(0x7f100111)).setOnClickListener(new android.view.View.OnClickListener() {

            private SocialMainActivity a;

            public final void onClick(View view)
            {
                SocialMainActivity.a(a);
                com.socialin.android.social.activity.SocialMainActivity.b(a).setQuery("", false);
            }

            
            {
                a = SocialMainActivity.this;
                super();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void onFragmentImageSelected(String s, boolean flag, String as[], String as1[], int j, JSONArray jsonarray)
    {
        super.onFragmentImageSelected(s, flag, as, as1, j, jsonarray);
        (new c(this, s, as1, j, jsonarray)).execute(new String[] {
            as[j]
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    public void showFragmentProgressDialog(String s, String s1, boolean flag)
    {
        super.showFragmentProgressDialog(s, s1, flag);
        FragmentManager fragmentmanager;
        FragmentTransaction fragmenttransaction;
        Fragment fragment;
        try
        {
            fragmentmanager = getFragmentManager();
            fragmenttransaction = fragmentmanager.beginTransaction();
            fragment = fragmentmanager.findFragmentByTag("progressDialogFragment");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(a, "showFragmentProgressDialog", s);
            return;
        }
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (fragment.isAdded() && !fragment.isRemoving() && !isFinishing())
        {
            fragmenttransaction.remove(fragment);
        }
        s = myobfuscated.cy.b.a(s, s1);
        s.setCancelable(flag);
        s.show(fragmentmanager, "progressDialogFragment");
        fragmenttransaction.commit();
        return;
    }

}
