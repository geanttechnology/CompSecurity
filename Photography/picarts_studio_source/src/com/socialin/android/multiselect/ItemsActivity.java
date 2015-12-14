// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.shop.v;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myobfuscated.ad.m;
import myobfuscated.by.a;

// Referenced classes of package com.socialin.android.multiselect:
//            d

public class ItemsActivity extends BaseActivity
{

    private RecyclerView a;
    private View b;
    private a c;
    private List d;
    private String e;
    private LinearLayout f;
    private HorizontalScrollView g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private e l;
    private k m;
    private android.support.v7.widget.RecyclerView.OnScrollListener n;

    public ItemsActivity()
    {
        a = null;
        c = null;
        d = new ArrayList();
        e = "";
        f = null;
        g = null;
        h = -1;
        i = 0;
        j = -1;
        k = false;
        m = null;
        n = new android.support.v7.widget.RecyclerView.OnScrollListener() {

            private ItemsActivity a;

            public final void onScrollStateChanged(RecyclerView recyclerview, int i1)
            {
                super.onScrollStateChanged(recyclerview, i1);
                if (i1 == 0)
                {
                    recyclerview = com.socialin.android.multiselect.ItemsActivity.a(a);
                    myobfuscated.aj.j.a();
                    recyclerview.c();
                    for (recyclerview = ((k) (recyclerview)).c.a().iterator(); recyclerview.hasNext(); ((k)recyclerview.next()).c()) { }
                } else
                {
                    com.socialin.android.multiselect.ItemsActivity.a(a).b();
                }
            }

            
            {
                a = ItemsActivity.this;
                super();
            }
        };
    }

    static k a(ItemsActivity itemsactivity)
    {
        return itemsactivity.m;
    }

    private void a()
    {
        float f1 = TypedValue.applyDimension(1, 100F, getResources().getDisplayMetrics());
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int j1 = point.x;
        int i1 = (int)((float)j1 / f1);
        int k1 = j1 / i1;
        if (h == -1)
        {
            h = k1 - 2;
        }
        if (c != null)
        {
            j1 = (j1 - h * i1) / i1;
            c.b = j1;
        }
        if (a == null)
        {
            a = (RecyclerView)findViewById(0x7f100729);
            a.setOnScrollListener(n);
            a.setOnHierarchyChangeListener(null);
            a.setHasFixedSize(true);
        }
        a.setLayoutManager(new GridLayoutManager(this, i1));
    }

    static void a(ItemsActivity itemsactivity, String s)
    {
        itemsactivity.a(s);
    }

    private void a(String s)
    {
        View view = getLayoutInflater().inflate(0x7f03016f, null);
        ImageView imageview = (ImageView)view.findViewById(0x7f10072b);
        if (m == null)
        {
            m = com.bumptech.glide.b.b(getApplicationContext());
            m.i().a(0.6F).a(((e)com.bumptech.glide.request.e.b(l.a).b()).a(android.graphics.Bitmap.CompressFormat.PNG));
        }
        m.a((new StringBuilder("file://")).append(s).toString()).a(l.a(h, h)).a(imageview);
        view.setOnClickListener(new android.view.View.OnClickListener(s) {

            private String a;
            private ItemsActivity b;

            public final void onClick(View view1)
            {
                ItemsActivity.i(b).removeView(view1);
                ItemsActivity.c(b).remove(a);
                if (ItemsActivity.c(b).isEmpty())
                {
                    com.socialin.android.multiselect.ItemsActivity.e(b).setVisibility(8);
                }
                ((TextView)b.findViewById(0x7f10072e)).setText((new StringBuilder()).append(ItemsActivity.c(b).size()).toString());
            }

            
            {
                b = ItemsActivity.this;
                a = s;
                super();
            }
        });
        f.addView(view);
        d.add(s);
        ((TextView)findViewById(0x7f10072e)).setText((new StringBuilder()).append(d.size()).toString());
    }

    static boolean a(ItemsActivity itemsactivity, boolean flag)
    {
        itemsactivity.k = flag;
        return flag;
    }

    static HorizontalScrollView b(ItemsActivity itemsactivity)
    {
        return itemsactivity.g;
    }

    private void b()
    {
        Intent intent = new Intent();
        int j1 = d.size();
        String as[] = new String[j1];
        for (int i1 = 0; i1 < j1; i1++)
        {
            as[i1] = (String)d.get(i1);
        }

        intent.putExtra("selectedItems", as);
        intent.putExtra("itemsCount", j1);
        intent.putExtra("done", false);
        setResult(-1, intent);
        finish();
    }

    static List c(ItemsActivity itemsactivity)
    {
        return itemsactivity.d;
    }

    static int d(ItemsActivity itemsactivity)
    {
        return itemsactivity.j;
    }

    static View e(ItemsActivity itemsactivity)
    {
        return itemsactivity.b;
    }

    static a f(ItemsActivity itemsactivity)
    {
        return itemsactivity.c;
    }

    static void g(ItemsActivity itemsactivity)
    {
        Intent intent = new Intent();
        int j1 = itemsactivity.d.size();
        String as[] = new String[j1];
        for (int i1 = 0; i1 < j1; i1++)
        {
            as[i1] = (String)itemsactivity.d.get(i1);
        }

        intent.putExtra("selectedItems", as);
        intent.putExtra("itemsCount", j1);
        intent.putExtra("done", true);
        itemsactivity.setResult(-1, intent);
        itemsactivity.finish();
    }

    static boolean h(ItemsActivity itemsactivity)
    {
        return itemsactivity.k;
    }

    static LinearLayout i(ItemsActivity itemsactivity)
    {
        return itemsactivity.f;
    }

    static String j(ItemsActivity itemsactivity)
    {
        return itemsactivity.e;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a();
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03016e);
        AnalyticUtils.getInstance(this).trackLocalAction("multiseclect_ItemsActivity:onCreate");
        l = (e)((e)com.bumptech.glide.request.e.b(l.a).b()).a(android.graphics.Bitmap.CompressFormat.PNG);
        m = com.bumptech.glide.b.b(getApplicationContext());
        m.i().a(0.6F).a(l);
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle("");
        f = (LinearLayout)findViewById(0x7f100733);
        g = (HorizontalScrollView)findViewById(0x7f100732);
        b = findViewById(0x7f100722);
        Object obj = getIntent();
        if (((Intent) (obj)).hasExtra("folder"))
        {
            e = ((Intent) (obj)).getStringExtra("folder");
            getSupportActionBar().setTitle(e.substring(e.lastIndexOf("/") + 1));
        }
        int i1;
        if (((Intent) (obj)).hasExtra("selectedItemsCount"))
        {
            i = ((Intent) (obj)).getIntExtra("selectedItemsCount", 0);
            bundle = b;
            String as[];
            int j1;
            if (i > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            bundle.setVisibility(i1);
        }
        if (((Intent) (obj)).hasExtra("itemsCount"))
        {
            j = ((Intent) (obj)).getIntExtra("itemsCount", -1);
            if (j != -1)
            {
                ((TextView)findViewById(0x7f10072f)).setText((new StringBuilder("/ ")).append(j).toString());
            }
        }
        bundle = (new File(e)).list(new myobfuscated.bz.a());
        if (bundle != null)
        {
            Arrays.sort(bundle, new d(this, (byte)0));
        }
        if (bundle != null)
        {
            i1 = bundle.length;
        } else
        {
            i1 = 0;
        }
        if (((Intent) (obj)).hasExtra("selectedItemsArray"))
        {
            as = ((Intent) (obj)).getStringArrayExtra("selectedItemsArray");
            for (j1 = 0; j1 < i; j1++)
            {
                a(as[j1]);
            }

        }
        (new Handler()).postDelayed(new Runnable() {

            private ItemsActivity a;

            public final void run()
            {
                com.socialin.android.multiselect.ItemsActivity.b(a).fullScroll(66);
                com.socialin.android.multiselect.ItemsActivity.b(a).invalidate();
            }

            
            {
                a = ItemsActivity.this;
                super();
            }
        }, 100L);
        as = new ArrayList(i1);
        for (int k1 = ((flag) ? 1 : 0); k1 < i1; k1++)
        {
            as.add((new StringBuilder()).append(e).append("/").append(bundle[k1]).toString());
        }

        a();
        c = new a(this, h, h, as, new v() {

            final ItemsActivity a;

            public final transient void a(int l1)
            {
                if (ItemsActivity.c(a).size() >= ItemsActivity.d(a) && ItemsActivity.d(a) != -1)
                {
                    Utils.a(a, 0x7f080442);
                    return;
                } else
                {
                    com.socialin.android.multiselect.ItemsActivity.e(a).setVisibility(0);
                    com.socialin.android.multiselect.ItemsActivity.a(a, ItemsActivity.f(a).a(l1));
            /* block-local class not found */
            class _cls1 {}

                    (new Handler()).postDelayed(new _cls1(), 100L);
                    return;
                }
            }

            
            {
                a = ItemsActivity.this;
                super();
            }
        });
        a.setAdapter(c);
        findViewById(0x7f100731).setOnClickListener(new android.view.View.OnClickListener() {

            private ItemsActivity a;

            public final void onClick(View view)
            {
                com.socialin.android.multiselect.ItemsActivity.g(a);
            }

            
            {
                a = ItemsActivity.this;
                super();
            }
        });
        findViewById(0x7f100730).setOnClickListener(new android.view.View.OnClickListener() {

            private ItemsActivity a;

            public final void onClick(View view)
            {
                ItemsActivity.c(a).clear();
                ((LinearLayout)a.findViewById(0x7f100733)).removeAllViews();
                com.socialin.android.multiselect.ItemsActivity.e(a).setVisibility(8);
            }

            
            {
                a = ItemsActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuItemCompat.setShowAsAction(menu.add(0, 1, 0, getString(0x7f0802a0)), 0);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            b();
        }
        return super.onKeyDown(i1, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   1: 41
    //                   16908332: 34;
           goto _L1 _L2 _L3
_L1:
        return true;
_L3:
        b();
        continue; /* Loop/switch isn't completed */
_L2:
        menuitem = (new android.app.AlertDialog.Builder(this)).create();
        menuitem.setTitle(0x7f080416);
        menuitem.setMessage(getResources().getString(0x7f080415));
        menuitem.setButton(-1, getResources().getString(0x7f080311), new android.content.DialogInterface.OnClickListener() {

            private ItemsActivity a;

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface = a;
                g g1 = new g(dialoginterface);
                g1.setMessage(dialoginterface.getResources().getString(0x7f080450));
                g1.setCancelable(true);
                g1.setOnCancelListener(dialoginterface. new android.content.DialogInterface.OnCancelListener() {

                    private ItemsActivity a;

                    public final void onCancel(DialogInterface dialoginterface)
                    {
                        com.socialin.android.multiselect.ItemsActivity.a(a, true);
                    }

            
            {
                a = ItemsActivity.this;
                super();
            }
                });
                g1.show();
                (new Thread(dialoginterface. new Runnable(g1) {

                    final g a;
                    final ItemsActivity b;

                    public final void run()
                    {
                        if (ItemsActivity.h(b))
                        {
                            com.socialin.android.multiselect.ItemsActivity.a(b, false);
                            return;
                        } else
                        {
                    /* block-local class not found */
                    class _cls1 {}

                            b.runOnUiThread(new _cls1());
                            return;
                        }
                    }

            
            {
                b = ItemsActivity.this;
                a = g1;
                super();
            }
                })).start();
            }

            
            {
                a = ItemsActivity.this;
                super();
            }
        });
        menuitem.setButton(-2, getResources().getString(0x7f080295), new android.content.DialogInterface.OnClickListener() {

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
            }

        });
        menuitem.show();
        if (true) goto _L1; else goto _L4
_L4:
    }
}
