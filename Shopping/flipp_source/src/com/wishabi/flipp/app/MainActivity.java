// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import com.wishabi.flipp.b.u;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.p;
import com.wishabi.flipp.widget.CollectionView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.b;
import uk.co.senab.actionbarpulltorefresh.library.h;
import uk.co.senab.actionbarpulltorefresh.library.i;

// Referenced classes of package com.wishabi.flipp.app:
//            dh, a, fg, DrawerFragment, 
//            FeaturedFragment, SearchFragment, CouponFragment, ShoppingListFragment, 
//            dj, en, di, SettingsActivity, 
//            EulaActivity, do, HelpActivity, dk

public class MainActivity extends Activity
{

    private static final String a[] = {
        "RequestDialogTag", "AllowPushDialogTag", "CouponDialogTag", "TutorialHeroDialogTag", "TutorialPrintCouponDialogTag"
    };
    private static final HashMap b;
    private a c;
    private FeaturedFragment d;
    private CouponFragment e;
    private SearchFragment f;
    private View g;
    private DrawerLayout h;
    private String i;
    private PullToRefreshLayout j;
    private int k;
    private String l;
    private SharedPreferences m;
    private final BroadcastReceiver n = new dh(this);

    public MainActivity()
    {
        k = -1;
    }

    static SearchFragment a(MainActivity mainactivity)
    {
        return mainactivity.f;
    }

    private void a()
    {
        String as[] = a;
        int j1 = as.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            Object obj = as[i1];
            obj = (DialogFragment)getFragmentManager().findFragmentByTag(((String) (obj)));
            if (obj != null)
            {
                ((DialogFragment) (obj)).dismiss();
            }
        }

    }

    static DrawerLayout b(MainActivity mainactivity)
    {
        return mainactivity.h;
    }

    private void b(String s)
    {
        a();
        FragmentManager fragmentmanager = getFragmentManager();
        if (s.equals("AllowPushDialogTag"))
        {
            (new com.wishabi.flipp.app.a()).show(fragmentmanager, s);
        } else
        if (s.equals("RequestDialogTag"))
        {
            (new fg()).show(fragmentmanager, s);
            return;
        }
    }

    static PullToRefreshLayout c(MainActivity mainactivity)
    {
        return mainactivity.j;
    }

    static String d(MainActivity mainactivity)
    {
        return mainactivity.l;
    }

    static String e(MainActivity mainactivity)
    {
        mainactivity.l = null;
        return null;
    }

    static int f(MainActivity mainactivity)
    {
        mainactivity.k = -1;
        return -1;
    }

    protected final void a(String s)
    {
        if (i != null && i.equals(s))
        {
            return;
        }
        i = s;
        int i1 = com.wishabi.flipp.app.DrawerFragment.a(s);
        Object obj;
        if (i1 == 0x7f0e0086)
        {
            setTitle("");
        } else
        if (i1 == 0)
        {
            setTitle(s);
        } else
        {
            setTitle(i1);
        }
        obj = getActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).setNavigationMode(0);
        }
        if (b.get(s) != null)
        {
            i1 = ((Integer)b.get(s)).intValue();
        } else
        {
            i1 = 0x7f0b0025;
        }
        obj = getFragmentManager().beginTransaction();
        for (Iterator iterator = b.values().iterator(); iterator.hasNext();)
        {
            int j1 = ((Integer)iterator.next()).intValue();
            if (j1 == i1)
            {
                ((FragmentTransaction) (obj)).show(getFragmentManager().findFragmentById(j1));
            } else
            {
                ((FragmentTransaction) (obj)).hide(getFragmentManager().findFragmentById(j1));
            }
        }

        if (i1 == 0x7f0b0025)
        {
            FeaturedFragment featuredfragment = d;
            if (featuredfragment.a == null || !s.equals(featuredfragment.a))
            {
                featuredfragment.a = s;
                featuredfragment.b.scrollTo(0, 0);
                if (featuredfragment.isAdded())
                {
                    s = featuredfragment.getLoaderManager();
                    if (s != null)
                    {
                        s.restartLoader(0, null, featuredfragment);
                    }
                }
            }
        }
        if (f != null)
        {
            if (i1 == 0x7f0b0026)
            {
                ((FragmentTransaction) (obj)).show(f);
                f.onHiddenChanged(false);
            } else
            {
                ((FragmentTransaction) (obj)).hide(f);
            }
        }
        ((FragmentTransaction) (obj)).commit();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = c;
        if (!((a) (configuration)).d)
        {
            configuration.e = configuration.d();
        }
        configuration.f = android.support.v4.a.a.a(((a) (configuration)).a, ((a) (configuration)).g);
        configuration.a();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        m = p.a();
        registerReceiver(n, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        registerReceiver(n, new IntentFilter("android.intent.action.TIME_SET"));
        registerReceiver(n, new IntentFilter("android.intent.action.DATE_CHANGED"));
        setContentView(0x7f030003);
        setTitle(0x7f0e001b);
        Object obj = getFragmentManager();
        d = (FeaturedFragment)((FragmentManager) (obj)).findFragmentById(0x7f0b0025);
        e = (CouponFragment)((FragmentManager) (obj)).findFragmentById(0x7f0b0027);
        f = (SearchFragment)getFragmentManager().findFragmentById(0x7f0b002b);
        obj = (ShoppingListFragment)getFragmentManager().findFragmentById(0x7f0b0026);
        i i1;
        if (f != null && obj != null)
        {
            f.a(com.wishabi.flipp.app.en.b);
            obj.b = new di(this);
        }
        a("All Flyers");
        h = (DrawerLayout)findViewById(0x7f0b0022);
        obj = (DrawerFragment)getFragmentManager().findFragmentById(0x7f0b002a);
        if (obj != null)
        {
            g = ((DrawerFragment) (obj)).getView();
            obj.a = new dj(this);
        }
        c = new a(this, h);
        h.setDrawerListener(c);
        j = (PullToRefreshLayout)findViewById(0x7f0b0029);
        obj = uk.co.senab.actionbarpulltorefresh.library.a.a(this);
        i1 = uk.co.senab.actionbarpulltorefresh.library.h.a();
        i1.a.g = false;
        obj.a = i1.a;
        ((b) (obj)).a(j);
        obj = getActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).setDisplayHomeAsUpEnabled(true);
            ((ActionBar) (obj)).setHomeButtonEnabled(true);
        }
        if (bundle != null)
        {
            obj = bundle.getString("mCategoryName");
            if (obj != null)
            {
                a(((String) (obj)));
            }
            l = bundle.getString("mDeepLinkFilterUri");
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Object obj = u.a;
        int i1 = k;
        obj = (AsyncTask)((u) (obj)).d.get(Integer.valueOf(i1));
        if (obj != null)
        {
            ((AsyncTask) (obj)).cancel(true);
        }
        unregisterReceiver(n);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        Object obj = c;
        boolean flag = flag1;
        if (menuitem != null)
        {
            flag = flag1;
            if (menuitem.getItemId() == 0x102002c)
            {
                flag = flag1;
                if (((a) (obj)).c)
                {
                    View view = ((a) (obj)).b.a(0x800003);
                    if (view != null)
                    {
                        flag2 = DrawerLayout.g(view);
                    }
                    if (flag2)
                    {
                        obj = ((a) (obj)).b;
                        View view1 = ((DrawerLayout) (obj)).a(0x800003);
                        if (view1 == null)
                        {
                            throw new IllegalArgumentException((new StringBuilder("No drawer view found with gravity ")).append(DrawerLayout.b(0x800003)).toString());
                        }
                        ((DrawerLayout) (obj)).f(view1);
                    } else
                    {
                        obj = ((a) (obj)).b;
                        View view2 = ((DrawerLayout) (obj)).a(0x800003);
                        if (view2 == null)
                        {
                            throw new IllegalArgumentException((new StringBuilder("No drawer view found with gravity ")).append(DrawerLayout.b(0x800003)).toString());
                        }
                        ((DrawerLayout) (obj)).e(view2);
                    }
                    flag = true;
                }
            }
        }
        if (flag)
        {
            return true;
        }
        if (menuitem.getItemId() != 0x7f0b015b) goto _L2; else goto _L1
_L1:
        b("RequestDialogTag");
_L4:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (menuitem.getItemId() == 0x7f0b015c)
        {
            startActivity(new Intent(this, com/wishabi/flipp/app/SettingsActivity));
        } else
        if (menuitem.getItemId() == 0x7f0b015d)
        {
            startActivity(new Intent(this, com/wishabi/flipp/app/EulaActivity));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        c.a();
        if (com.wishabi.flipp.app.do.a.a() != 3)
        {
            startActivity(new Intent(this, com/wishabi/flipp/app/HelpActivity));
            finish();
        }
    }

    public void onResume()
    {
        boolean flag = true;
        super.onResume();
        Object obj = m.getString("postal_code", null);
        if (obj != null)
        {
            if (!m.contains("allow_push"))
            {
                Intent intent;
                Uri uri;
                String s;
                com.wishabi.flipp.b.a a1;
                String s1;
                HashMap hashmap;
                int i1;
                int j1;
                int k1;
                long l1;
                long l2;
                boolean flag1;
                if (com.wishabi.flipp.util.k.c(((String) (obj))))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                m.edit().putBoolean("allow_push", flag1).commit();
            }
            if (!m.getBoolean("has_responded_to_push_prompt", false) && com.wishabi.flipp.util.k.b(((String) (obj))))
            {
                b("AllowPushDialogTag");
            }
        }
        intent = getIntent();
        if (intent == null || intent.getBooleanExtra("was_handled", false)) goto _L2; else goto _L1
_L1:
        s = getIntent().getStringExtra("EXTRA_OPENED_BY_PUSH_PLATFORM");
        uri = intent.getData();
        if (s != null)
        {
            a1 = com.wishabi.flipp.b.a.a;
            hashmap = new HashMap();
            s1 = a1.d(s);
            hashmap.put("platform", s);
            hashmap.put("device_token", s1);
            if (uri != null)
            {
                obj = uri.toString();
            } else
            {
                obj = "<null>";
            }
            hashmap.put("url", obj);
            a1.a("push_notification_click", hashmap, false);
            if (uri != null)
            {
                obj = uri.toString();
            } else
            {
                obj = "(null)";
            }
            a1.a("Push Notification", (new StringBuilder("Push Notification | URL ")).append(((String) (obj))).toString(), String.format("Push Notification | URL %s | TOKEN %s", new Object[] {
                obj, s1
            }));
        }
        if (s == null && uri == null) goto _L4; else goto _L3
_L3:
        com.wishabi.flipp.b.a.a.a(s, uri);
        a("All Flyers");
        a();
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_822;
        }
        obj = getSharedPreferences("com.wishabi.flipp.preferences", 0).getString("postal_code", null);
        s = uri.getAuthority();
        if (obj == null || s == null || s.equals(""))
        {
            obj = null;
        } else
        {
            if (!s.equals("flyers"))
            {
                break MISSING_BLOCK_LABEL_822;
            }
            obj = com.wishabi.flipp.content.i.a.buildUpon();
            if (uri.getQueryParameter("flyer_ids") != null)
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_field", "flyer_id");
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_values", uri.getQueryParameter("flyer_ids"));
            } else
            if (uri.getQueryParameter("flyer_run_ids") != null)
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_field", "flyer_run_id");
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_values", uri.getQueryParameter("flyer_run_ids"));
            } else
            if (uri.getQueryParameter("merchant_ids") != null)
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_field", "merchant_id");
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_values", uri.getQueryParameter("merchant_ids"));
            } else
            if (uri.getQueryParameter("flyer_type_ids") != null)
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_field", "flyer_type_id");
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_values", uri.getQueryParameter("flyer_type_ids"));
            } else
            {
label0:
                {
                    if (uri.getQueryParameter("categories") == null)
                    {
                        break label0;
                    }
                    ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_field", "categories");
                    ((android.net.Uri.Builder) (obj)).appendQueryParameter("filter_values", uri.getQueryParameter("categories"));
                }
            }
            obj = ((android.net.Uri.Builder) (obj)).build();
        }
_L5:
        if (obj != null)
        {
            obj = ((Uri) (obj)).toString();
        } else
        {
            obj = null;
        }
        l = ((String) (obj));
_L4:
        intent.putExtra("was_handled", true);
_L2:
        l1 = System.currentTimeMillis();
        i1 = com.wishabi.flipp.util.g.b();
        l2 = m.getLong("last_flyer_fetch_time", 0L);
        obj = m.getString("last_flyer_fetch_locale", "");
        j1 = m.getInt("last_flyer_fetch_version_code", -1);
        if ((float)(l1 - l2) > 3600000F || !Locale.getDefault().toString().equals(obj) || l != null || i1 != j1)
        {
            if (l != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            obj = u.a;
            k1 = k;
            if (((u) (obj)).d.get(Integer.valueOf(k1)) == null)
            {
                flag = false;
            }
            if (!flag)
            {
                obj = getSharedPreferences("com.wishabi.flipp.preferences", 0).getString("postal_code", null);
                k = u.a.a(null, new dk(this, flag1, ((String) (obj))));
            }
        }
        if (i1 != j1)
        {
            m.edit().putInt("last_flyer_fetch_version_code", i1).commit();
        }
        return;
        obj = null;
          goto _L5
        obj = null;
          goto _L5
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (!isChangingConfigurations())
        {
            g.setLayoutParams(new android.support.v4.widget.g((android.support.v4.widget.g)g.getLayoutParams()));
        }
        super.onSaveInstanceState(bundle);
        bundle.putString("mCategoryName", i);
        bundle.putString("mDeepLinkFilterUri", l);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        b = hashmap;
        hashmap.put("All Flyers", Integer.valueOf(0x7f0b0025));
        b.put("Favorites", Integer.valueOf(0x7f0b0024));
        b.put("Clippings", Integer.valueOf(0x7f0b0023));
        b.put("Shopping List", Integer.valueOf(0x7f0b0026));
        b.put("Coupons", Integer.valueOf(0x7f0b0027));
        b.put("Print Coupons", Integer.valueOf(0x7f0b0028));
    }
}
