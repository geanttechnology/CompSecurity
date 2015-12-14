// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.google.android.gms.common.api.GoogleApiClient;
import com.picsart.shop.m;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.f;
import com.socialin.android.d;
import com.socialin.android.photo.g;
import com.socialin.android.photo.textart.TextPreview;
import com.socialin.android.photo.textart.b;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.io.PrintStream;
import java.lang.ref.WeakReference;

// Referenced classes of package com.socialin.android.photo.clipart:
//            g, j, f, h, 
//            i

public class SelectClipArtFrameActivity extends AdBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a[] = {
        "clipart", "frame", "collage_frame", "textart"
    };
    private static String b;
    private static boolean c;
    private static Bundle d;
    private ViewPager e;
    private com.socialin.android.photo.clipart.g f;
    private h g;
    private i h;
    private GoogleApiClient i;

    public SelectClipArtFrameActivity()
    {
        g = null;
        h = null;
    }

    public static Bundle a()
    {
        return d;
    }

    static com.socialin.android.photo.clipart.g a(SelectClipArtFrameActivity selectclipartframeactivity)
    {
        return selectclipartframeactivity.f;
    }

    public static String b()
    {
        return b;
    }

    public static boolean c()
    {
        return c;
    }

    static String[] d()
    {
        return a;
    }

    private boolean e()
    {
        if (e != null && e.getCurrentItem() == 1)
        {
            e.setCurrentItem(0);
            return true;
        } else
        {
            return false;
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onActivityResult(int k, int l, Intent intent)
    {
        super.onActivityResult(k, l, intent);
        if (f != null && f.getItem(1) != null && (f.getItem(1) instanceof j))
        {
            Object obj = (j)f.getItem(1);
            if (((j) (obj)).getActivity() != null && !((j) (obj)).getActivity().isFinishing())
            {
                obj = (m)((j) (obj)).getActivity().getFragmentManager().findFragmentByTag("shopItemFragment");
                if (obj != null && ((m) (obj)).isAdded() && ((m) (obj)).isVisible())
                {
                    ((m) (obj)).onActivityResult(k, l, intent);
                }
            }
        }
        if (k == 93 && l == -1 && f != null && f.getCount() > 0 && (f.getItem(0) instanceof com.socialin.android.photo.clipart.f))
        {
            ((com.socialin.android.photo.clipart.f)f.getItem(0)).a();
        }
        System.out.println("result code = ok");
        if (l == -1 && (k == 1 || k == 3 || k == 2))
        {
            intent = intent.getExtras().getString("text");
            System.out.println((new StringBuilder("result text = ")).append(intent).toString());
            TextPreview textpreview = (TextPreview)findViewById(0x7f100643);
            textpreview.post(new Runnable(textpreview, intent) {

                private TextPreview a;
                private String b;

                public final void run()
                {
                    a.append(b);
                }

            
            {
                a = textpreview;
                b = s;
                super();
            }
            });
        }
    }

    public void onBackPressed()
    {
        if (!e())
        {
            super.onBackPressed();
        }
    }

    public void onClick(View view)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int k = displaymetrics.widthPixels;
        int l = displaymetrics.heightPixels;
        float f1 = (float)k / getResources().getDisplayMetrics().density;
        float f2 = (float)l / getResources().getDisplayMetrics().density;
        if (d.b)
        {
            (new StringBuilder("screenwidthDp:")).append(f1).append(" screenWidthPx: ").append(k);
        }
        if (f1 < 450F || k < 600 || f2 < 450F || l < 600)
        {
            ActionBar actionbar;
            int i1;
            if (!getIntent().getStringExtra("category").equals(a[3]))
            {
                setContentView(0x7f030066);
            } else
            {
                setContentView(0x7f030257);
            }
            e = (ViewPager)findViewById(0x7f100169);
            i1 = (int)(220F * getResources().getDisplayMetrics().density);
            e.setPageMargin(i1 - k);
            f = new com.socialin.android.photo.clipart.g(getFragmentManager(), getIntent());
            e.setAdapter(f);
        } else
        {
            android.app.Fragment fragment;
            android.app.Fragment fragment1;
            FragmentTransaction fragmenttransaction;
            if (!getIntent().getStringExtra("category").equals(a[3]))
            {
                setContentView(0x7f030067);
            } else
            {
                setContentView(0x7f030258);
            }
            f = new com.socialin.android.photo.clipart.g(getFragmentManager(), getIntent());
            fragment = f.getItem(0);
            fragment1 = f.getItem(1);
            fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f100169, fragment, "a");
            fragmenttransaction.add(0x7f100169, fragment1, "b");
            fragmenttransaction.commit();
        }
        initAd();
        if (getIntent() != null && e != null)
        {
            k = getIntent().getIntExtra("screen", -1);
            if (k != -1)
            {
                e.setCurrentItem(k);
            }
        }
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        g = new h(this, new Handler());
        h = new i(this, new Handler());
        getContentResolver().registerContentObserver(SocialinV3.UPDATE_SHOP_ITEMS_URI, false, g);
        getContentResolver().registerContentObserver(SocialinV3.UPDATE_USER_URI, false, h);
        if (a[3].equals(getIntent().getStringExtra("category")) && bundle != null)
        {
            if (bundle.containsKey("editTextValue"))
            {
                b = bundle.getString("editTextValue");
            }
            c = bundle.getBoolean("isRotation");
        }
        d = bundle;
        Utils.b(hashCode());
        i = myobfuscated.f.m.a(this);
    }

    protected void onDestroy()
    {
        b = null;
        c = false;
        if (g != null)
        {
            getContentResolver().unregisterContentObserver(g);
        }
        if (h != null)
        {
            getContentResolver().unregisterContentObserver(h);
        }
        w.c((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/frame").toString());
        super.onDestroy();
    }

    public boolean onKeyUp(int k, KeyEvent keyevent)
    {
        return super.onKeyUp(k, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   1: 70
    //                   2: 91
    //                   16908332: 42;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L4:
        if (!e())
        {
            setResult(0);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("clipartCat:exit");
        }
_L6:
        return true;
_L2:
        if (this != null)
        {
            com.socialin.android.photo.g.b(this);
            AnalyticUtils.getInstance(this).trackLocalAction("clipart:shop");
        }
        continue; /* Loop/switch isn't completed */
_L3:
        menuitem = (b)f.getItem(1);
        String s = ((b) (menuitem)).p.getText().toString();
        if (!s.equals("") && s.split(" ").length != 0)
        {
            Intent intent = new Intent();
            intent.putExtra("text", s);
            intent.putExtra("style", b.t);
            intent.putExtra("style-index", b.q);
            intent.putExtra("font-type", ((b) (menuitem)).r);
            menuitem.getActivity().setResult(-1, intent);
            (new com.socialin.android.photo.textart.b._cls7(menuitem, s)).execute(new Void[0]);
            menuitem.getActivity().finish();
        } else
        {
            Utils.c(menuitem.getActivity(), "Please enter text");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onPause()
    {
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        menu.add(0, 1, 0, getString(0x7f08034b)).setTitle(getString(0x7f080443)).setIcon(0x7f0203fa).setShowAsAction(2);
        if (f.a.equals(a[3]))
        {
            menu.add(0, 2, 1, getString(0x7f0802b8)).setTitle(getString(0x7f0802b8)).setIcon(0x7f020046).setShowAsAction(2);
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        Utils.b(hashCode());
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
label0:
        {
            if (getIntent().getStringExtra("category").equals(a[3]))
            {
                if (isFinishing())
                {
                    break label0;
                }
                bundle.putString("editTextValue", ((b)f.getItem(1)).s);
                bundle.putBoolean("isRotation", true);
                Object obj = ((b)f.getItem(1)).x;
                if (obj != null && ((WeakReference) (obj)).get() != null)
                {
                    f f1 = (f)((WeakReference) (obj)).get();
                    obj = f1.b;
                    if (((b)f.getItem(1)).u == obj)
                    {
                        obj = "fill-color";
                    } else
                    if (((b)f.getItem(1)).v == obj)
                    {
                        obj = "gradient-color";
                    } else
                    {
                        obj = "stroke-color";
                    }
                    bundle.putString("colorPickerListener", ((String) (obj)));
                    bundle.putBoolean("isColorPickerShowing", f1.isShowing());
                    bundle.putInt("color", f1.b());
                    bundle.putInt("previousColor", f1.a);
                }
            }
            return;
        }
        bundle.putString("editTextValue", null);
        bundle.putBoolean("isRotation", false);
    }

    protected void onStart()
    {
        super.onStart();
        i.connect();
        myobfuscated.f.m.a(i, "http://schema.org/ViewAction", getString(0x7f0800c7), "android-app://com.picsart.studio/picsart/collage");
    }

    protected void onStop()
    {
        super.onStop();
        myobfuscated.f.m.b(i, "http://schema.org/ViewAction", getString(0x7f0800c7), "android-app://com.picsart.studio/picsart/collage");
        i.disconnect();
    }

}
