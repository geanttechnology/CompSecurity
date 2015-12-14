// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.constants.b;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.multiselect.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.facebook:
//            j, FBImageObject, FacebookPagingFragment, a, 
//            g

public class FacebookMainActivity extends BaseActivity
    implements b, j
{

    public static List c;
    private static List h;
    private static String i = "My.Albums";
    private static String j = "My.Friends";
    private myobfuscated.cw.b d;
    private ViewPager e;
    private boolean f;
    private e g;
    private SearchView k;
    private boolean l;

    public FacebookMainActivity()
    {
        f = false;
        l = false;
    }

    static SearchView a(FacebookMainActivity facebookmainactivity)
    {
        return facebookmainactivity.k;
    }

    private void a()
    {
        h.addAll(c);
        for (Iterator iterator = h.iterator(); iterator.hasNext(); a((String)iterator.next())) { }
    }

    private void a(boolean flag)
    {
        a();
        if (flag)
        {
            FacebookUtils.logoutFacebook(true);
        }
        setResult(129);
        finish();
        overridePendingTransition(0x7f040044, 0x7f040048);
    }

    static boolean a(FacebookMainActivity facebookmainactivity, boolean flag)
    {
        facebookmainactivity.l = flag;
        return flag;
    }

    private boolean a(String s)
    {
        boolean flag1 = false;
        FragmentTransaction fragmenttransaction;
        boolean flag;
        try
        {
            FragmentManager fragmentmanager = getFragmentManager();
            fragmenttransaction = fragmentmanager.beginTransaction();
            s = fragmentmanager.findFragmentByTag(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return false;
        }
        flag = flag1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag = flag1;
        if (!s.isAdded())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag = flag1;
        if (s.isRemoving())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag = flag1;
        if (isFinishing())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        fragmenttransaction.setCustomAnimations(0, 0x7f050003);
        fragmenttransaction.remove(s);
        fragmenttransaction.commitAllowingStateLoss();
        flag = true;
        return flag;
    }

    static void b(FacebookMainActivity facebookmainactivity)
    {
        facebookmainactivity.a(true);
    }

    public final void a(FBImageObject fbimageobject)
    {
        Intent intent;
        if (f)
        {
            String s = FacebookUtils.getSmallPathForCache(this, fbimageobject.getId());
            g.a(fbimageobject.getSource(), fbimageobject.getPicture(), s);
            return;
        }
        fbimageobject = fbimageobject.getSource();
        intent = new Intent();
        if (TextUtils.isEmpty(fbimageobject))
        {
            break MISSING_BLOCK_LABEL_160;
        }
        intent.setData(Uri.parse(fbimageobject));
        intent.putExtra("path", fbimageobject);
        e.getCurrentItem();
        JVM INSTR tableswitch 0 2: default 104
    //                   0 124
    //                   1 136
    //                   2 148;
           goto _L1 _L2 _L3 _L4
_L1:
        intent.putExtra("source_tab", "facebook");
_L5:
        setResult(-1, intent);
_L6:
        finish();
        return;
_L2:
        intent.putExtra("source_tab", "facebook_my_albums");
          goto _L5
_L3:
        intent.putExtra("source_tab", "facebook_friends");
          goto _L5
_L4:
        intent.putExtra("source_tab", "facebook_my_photos");
          goto _L5
        setResult(0, intent);
          goto _L6
    }

    public final void a(String s, String s1, View view)
    {
        String s2;
        if ("/albums".equals(s))
        {
            l = false;
            invalidateOptionsMenu();
        }
        s2 = null;
        if (e.getCurrentItem() != 0) goto _L2; else goto _L1
_L1:
        s2 = (new StringBuilder()).append(i).append(h.size()).append(1).toString();
        h.add(s2);
        view.setId(0x7f100049);
_L4:
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("graph.endpoint", s1);
        bundle.putString("graph.path", s);
        s = Fragment.instantiate(this, com/socialin/android/facebook/FacebookPagingFragment.getName(), bundle);
        fragmenttransaction.setCustomAnimations(0x7f050004, 0);
        fragmenttransaction.add(view.getId(), s, s2);
        fragmenttransaction.commitAllowingStateLoss();
        return;
_L2:
        if (e.getCurrentItem() == 1)
        {
            s2 = (new StringBuilder()).append(j).append(c.size()).append(1).toString();
            c.add(s2);
            view.setId(0x7f10004a);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f040044, 0x7f040048);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f9);
        h = new ArrayList(1);
        c = new ArrayList(2);
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setDisplayShowHomeEnabled(true);
        bundle.setIcon(getResources().getDrawable(0x7f020362));
        bundle.setTitle(getResources().getString(0x7f0802c7));
        bundle = getIntent();
        if (bundle.hasExtra("multipleCheckMode"))
        {
            f = bundle.getBooleanExtra("multipleCheckMode", false);
        }
        if (f)
        {
            bundle = getFragmentManager();
            FragmentTransaction fragmenttransaction = bundle.beginTransaction();
            g = (e)bundle.findFragmentByTag("multiselectFragment");
            if (g == null)
            {
                g = new e();
            }
            fragmenttransaction.replace(0x7f100505, g, "multiselectFragment");
            fragmenttransaction.commit();
        }
        e = (ViewPager)findViewById(0x7f100504);
        d = new myobfuscated.cw.b(this, getFragmentManager());
        bundle = new Bundle();
        bundle.putString("graph.path", "/albums");
        bundle.putString("graph.endpoint", "me");
        d.a(getString(0x7f080494), com/socialin/android/facebook/FacebookPagingFragment, bundle, 0x7f100070);
        bundle = new Bundle();
        bundle.putString("graph.path", "/friends");
        bundle.putString("graph.endpoint", "me");
        d.a(getString(0x7f0805ba), com/socialin/android/facebook/FacebookPagingFragment, bundle, 0x7f10007b);
        bundle = new Bundle();
        bundle.putString("graph.path", "/photos");
        bundle.putString("graph.endpoint", "me");
        d.a(getString(0x7f0805bc), com/socialin/android/facebook/FacebookPagingFragment, bundle, 0x7f100090);
        e.setAdapter(d);
        bundle = (SlidingTabLayout)findViewById(0x7f100503);
        bundle.setViewPager(e);
        bundle.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            private FacebookMainActivity a;

            public final void onPageScrollStateChanged(int i1)
            {
            }

            public final void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public final void onPageSelected(int i1)
            {
                if (i1 != 1 || FacebookMainActivity.c.size() != 0) goto _L2; else goto _L1
_L1:
                FacebookMainActivity.a(a, true);
_L4:
                a.invalidateOptionsMenu();
                return;
_L2:
                FacebookMainActivity.a(a, false);
                if (FacebookMainActivity.a(a) != null)
                {
                    FacebookMainActivity.a(a).setOnQueryTextListener(null);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = FacebookMainActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110005, menu);
        if (l)
        {
            getMenuInflater().inflate(0x7f110007, menu);
            Object obj = menu.findItem(0x7f100ae8);
            k = (SearchView)MenuItemCompat.getActionView(((MenuItem) (obj)));
            FacebookPagingFragment facebookpagingfragment = (FacebookPagingFragment)d.a();
            ((MenuItem) (obj)).expandActionView();
            k.setQueryHint(getString(0x7f080343));
            obj = (InputMethodManager)getSystemService("input_method");
            if (((InputMethodManager) (obj)).isAcceptingText() && getWindow().getCurrentFocus() != null)
            {
                ((InputMethodManager) (obj)).hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
                k.clearFocus();
            }
            ((ImageView)k.findViewById(0x7f100111)).setOnClickListener(new android.view.View.OnClickListener(facebookpagingfragment) {

                private FacebookPagingFragment a;
                private FacebookMainActivity b;

                public final void onClick(View view)
                {
                    if (a != null && a.d != null)
                    {
                        view = a.c;
                        view.setItems(((a) (view)).a);
                        view.notifyDataSetChanged();
                    }
                    FacebookMainActivity.a(b).setQuery("", false);
                }

            
            {
                b = FacebookMainActivity.this;
                a = facebookpagingfragment;
                super();
            }
            });
            k.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener(facebookpagingfragment) {

                private FacebookPagingFragment a;
                private FacebookMainActivity b;

                public final boolean onQueryTextChange(String s)
                {
                    if (a == null) goto _L2; else goto _L1
_L1:
                    Object obj1;
                    ArrayList arraylist;
                    obj1 = a;
                    obj1.d = s;
                    obj1 = ((FacebookPagingFragment) (obj1)).c;
                    arraylist = new ArrayList();
                    if (!TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
                    ((a) (obj1)).setItems(((a) (obj1)).a);
_L2:
                    return true;
_L4:
                    if (((a) (obj1)).getItemCount() != 0)
                    {
                        for (int i1 = 0; i1 < ((a) (obj1)).a.size(); i1++)
                        {
                            String s1 = ((g)((a) (obj1)).a.get(i1)).getTitle();
                            if (TextUtils.isEmpty(s1) || s1.length() < s.length())
                            {
                                continue;
                            }
                            s1 = s1.substring(0, s.length()).toLowerCase();
                            if (!TextUtils.isEmpty(s1) && s.equalsIgnoreCase(s1))
                            {
                                arraylist.add(((a) (obj1)).a.get(i1));
                            }
                        }

                        ((a) (obj1)).setItems(arraylist);
                    }
                    if (true) goto _L2; else goto _L5
_L5:
                }

                public final boolean onQueryTextSubmit(String s)
                {
                    FacebookMainActivity.a(b).clearFocus();
                    return false;
                }

            
            {
                b = FacebookMainActivity.this;
                a = facebookpagingfragment;
                super();
            }
            });
            if (facebookpagingfragment != null)
            {
                k.setQuery(facebookpagingfragment.d, false);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        a();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 != 4) goto _L2; else goto _L1
_L1:
        e.getCurrentItem();
        JVM INSTR tableswitch 0 1: default 36
    //                   0 43
    //                   1 84;
           goto _L2 _L3 _L4
_L2:
        return super.onKeyDown(i1, keyevent);
_L3:
        if (h.size() > 0 && a((String)h.remove(h.size() - 1)))
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (c.size() > 0 && a((String)c.remove(c.size() - 1)))
        {
            if (c.size() == 0)
            {
                l = true;
                invalidateOptionsMenu();
            }
            return true;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        if (i1 == 0x7f100ae7)
        {
            Intent intent = new Intent();
            intent.setClassName(getPackageName(), "com.socialin.android.preference.FBActionPreferencesActivity");
            startActivity(intent);
        }
        if (i1 == 0x7f100ae6)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(0x7f0802b7).setCancelable(false).setPositiveButton(0x7f080373, new android.content.DialogInterface.OnClickListener() {

                private FacebookMainActivity a;

                public final void onClick(DialogInterface dialoginterface, int j1)
                {
                    SocialinV3.getInstance().removeFbConnection();
                    com.socialin.android.facebook.FacebookMainActivity.b(a);
                }

            
            {
                a = FacebookMainActivity.this;
                super();
            }
            }).setNegativeButton(0x7f08030b, new android.content.DialogInterface.OnClickListener() {

                public final void onClick(DialogInterface dialoginterface, int j1)
                {
                    dialoginterface.cancel();
                }

            });
            builder.create().show();
        }
        if (i1 == 0x102002c)
        {
            a(false);
        }
        return super.onOptionsItemSelected(menuitem);
    }

}
