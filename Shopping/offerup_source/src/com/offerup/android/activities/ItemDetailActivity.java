// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.e.a;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import com.b.a.a.j;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Photo;
import com.offerup.android.e.c;
import com.offerup.android.g.a.ae;
import com.offerup.android.g.a.af;
import com.offerup.android.g.a.ai;
import com.offerup.android.g.a.f;
import com.offerup.android.g.a.g;
import com.offerup.android.g.a.x;
import com.offerup.android.network.UserRelationService;
import com.offerup.android.network.o;
import com.offerup.android.network.t;
import com.offerup.android.tracker.ItemDetailUserInteractionRecord;
import com.offerup.android.utils.ay;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;
import com.squareup.otto.Bus;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            k, ct, a, cr, 
//            cn, co, cp, GalleryActivity, 
//            cq, cs, cu

public class ItemDetailActivity extends k
    implements ae, af, ai, f, g, x
{

    private Item a;
    private long b;
    private View c;
    private View d;
    private Button j;
    private Button k;
    private String l;
    private int m;
    private int n;
    private boolean o;
    private ay p;
    private boolean q;
    private ItemDetailUserInteractionRecord r;

    public ItemDetailActivity()
    {
        m = -1;
        n = -1;
    }

    static Item a(ItemDetailActivity itemdetailactivity, Item item)
    {
        itemdetailactivity.a = item;
        return item;
    }

    private void a(Intent intent)
    {
        a(intent.getExtras());
    }

    private void a(Bundle bundle)
    {
        if (bundle.containsKey("activity_started_externally"))
        {
            q = bundle.getBoolean("activity_started_externally");
        } else
        {
            q = false;
        }
        r = ItemDetailUserInteractionRecord.a(bundle);
        a = null;
        b = 0L;
        if (bundle.containsKey("item"))
        {
            a = (Item)bundle.getParcelable("item");
        } else
        if (bundle.containsKey("itemId"))
        {
            b = bundle.getLong("itemId", 0L);
            return;
        }
    }

    private void a(Button button)
    {
        try
        {
            button.startAnimation(AnimationUtils.loadAnimation(this, 0x7f050011));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Button button)
        {
            com.b.a.a.g.a(this, button);
        }
    }

    static void a(ItemDetailActivity itemdetailactivity)
    {
        itemdetailactivity.p();
    }

    static void a(ItemDetailActivity itemdetailactivity, String s)
    {
        itemdetailactivity.b(s);
    }

    private void b(long l1)
    {
        try
        {
            g = ProgressDialog.show(this, "", "Loading...");
            android.support.v4.e.a.a(l1, new ct(this));
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    static void b(ItemDetailActivity itemdetailactivity)
    {
        com.offerup.android.tracker.a.a(itemdetailactivity, itemdetailactivity.getApplicationContext());
        itemdetailactivity.f.b(itemdetailactivity.a);
    }

    private void b(String s)
    {
        android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(this);
        builder.setTitle(getString(0x7f090186));
        builder.setMessage(getString(0x7f090185));
        builder.setPositiveButton("OK", new cr(this));
        com.offerup.android.utils.n.a(builder);
        com.b.a.a.g.a(this, new Throwable(s));
    }

    static Item c(ItemDetailActivity itemdetailactivity)
    {
        return itemdetailactivity.a;
    }

    static ItemDetailUserInteractionRecord d(ItemDetailActivity itemdetailactivity)
    {
        return itemdetailactivity.r;
    }

    static void e(ItemDetailActivity itemdetailactivity)
    {
        itemdetailactivity.q();
    }

    private void o()
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        ItemDetailUserInteractionRecord itemdetailuserinteractionrecord = r;
        int i;
        if (a.getPhotos() != null)
        {
            i = a.getPhotos().length;
        } else
        {
            i = 0;
        }
        itemdetailuserinteractionrecord.b(i);
        q();
_L4:
        j = (Button)findViewById(0x7f1000dc);
        j.setOnClickListener(new cn(this));
        k = (Button)findViewById(0x7f1000dd);
        k.setOnClickListener(new co(this));
        return;
_L2:
        if (b != 0L)
        {
            b(b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void p()
    {
        com.offerup.android.tracker.a.b(this, getApplicationContext());
        f.c(a);
    }

    private void q()
    {
        if (a == null)
        {
            b("Unable to update UI with null item.");
        } else
        {
            com.offerup.android.b.a.getInstance().post(new c(a));
            supportInvalidateOptionsMenu();
        }
        i();
    }

    public final void a()
    {
        t.a(a.getId(), new cp(this));
        android.support.v4.e.a.k();
    }

    public final void a(long l1)
    {
        f.a(l1);
    }

    public final void a(Fragment fragment)
    {
        getSupportFragmentManager().a().a(fragment).c();
    }

    public final void a(Photo photo)
    {
        int i;
        com.offerup.android.activities.a a1 = f;
        Item item = a;
        Intent intent;
        Photo aphoto[];
        if (photo != null)
        {
            photo = photo.getUuid();
        } else
        {
            photo = null;
        }
        intent = new Intent(a1.a, com/offerup/android/activities/GalleryActivity);
        aphoto = item.getPhotos();
        intent.putExtra("photos", item.getPhotos());
        if (!StringUtils.isNotEmpty(photo) || aphoto == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L7:
        if (i >= aphoto.length) goto _L2; else goto _L3
_L3:
        if (!photo.equals(aphoto[i].getUuid())) goto _L5; else goto _L4
_L4:
        intent.putExtra("photo_index", i);
_L2:
        a1.a.startActivity(intent);
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void a(String s)
    {
        Item item = a;
        if (item != null)
        {
            com.offerup.android.tracker.a.a(getApplicationContext(), "ou_item_detail_share", s, item);
            p.a(item.getGetFullUrl());
            return;
        } else
        {
            Toast.makeText(this, "Unable to share item", 0).show();
            return;
        }
    }

    final String b()
    {
        return null;
    }

    public final void b(int i)
    {
        r.a(i);
    }

    public final int e()
    {
        return !ba.a(a) ? 0x7f110004 : 0x7f110005;
    }

    public final void f()
    {
        t.b(a.getId(), new cq(this));
        android.support.v4.e.a.k();
    }

    public final void g()
    {
        r.a();
    }

    public final void m()
    {
        if (a != null && a.getId() > 0L)
        {
            if (!android.support.v4.e.a.b(this))
            {
                android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.b(this);
                builder.setPositiveButton("Retry", new cs(this));
                com.offerup.android.utils.n.a(builder);
                return;
            } else
            {
                com.offerup.android.tracker.a.a(this, getApplicationContext(), a);
                g = ProgressDialog.show(this, "", getString(0x7f090114));
                long l1 = a.getId();
                cu cu1 = new cu(this, (byte)0);
                com.offerup.android.network.o.b(com.offerup.android.network.o.c(Executors.newCachedThreadPool())).createReport("item", l1, cu1);
                return;
            }
        } else
        {
            a("Error", getString(0x7f09017b));
            return;
        }
    }

    public final void n()
    {
        p();
    }

    protected void onActivityResult(int i, int i1, Intent intent)
    {
        if (i == 13)
        {
            if (i1 == -1)
            {
                if (intent != null && intent.hasExtra("item"))
                {
                    a = (Item)intent.getParcelableExtra("item");
                    intent = r;
                    if (a.getPhotos() == null)
                    {
                        i = 0;
                    } else
                    {
                        i = a.getPhotos().length;
                    }
                    intent.b(i);
                    q();
                    return;
                } else
                {
                    b(a.getId());
                    return;
                }
            } else
            {
                com.b.a.a.g.a(this, new Throwable("unable to show item after update"));
                return;
            }
        } else
        {
            super.onActivityResult(i, i1, intent);
            return;
        }
    }

    public void onBackPressed()
    {
        com.offerup.android.tracker.a.a(r);
        if (q)
        {
            l();
            f.m();
            finish();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040024);
        p = new ay(this);
        int i;
        if ("layout_1".equals(e.W()))
        {
            i = 0x7f080002;
        } else
        if ("layout_2".equals(e.W()))
        {
            i = 0x7f080003;
        } else
        if ("layout_3".equals(e.W()))
        {
            i = 0x7f080004;
        } else
        {
            i = 0x7f080001;
        }
        c = findViewById(0x7f1000da);
        d = findViewById(0x7f1000db);
        (new com.offerup.android.g.a.t()).a(getApplicationContext(), i).a(0x7f1000da).a(getSupportFragmentManager(), false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        if (bundle == null)
        {
            a(getIntent());
        } else
        {
            a(bundle);
        }
        o();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        com.offerup.android.tracker.a.a(r);
        a = null;
        b = 0L;
        findViewById(0x7f1000d9).scrollTo(0, 0);
        a(intent);
        o();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755732: 
            f.a(a);
            break;
        }
        return true;
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        a(bundle);
        o();
    }

    protected void onResume()
    {
        super.onResume();
        Bundle bundle;
        if (ba.a(a) || com.offerup.android.utils.a.a(a))
        {
            d.setVisibility(4);
            c.setPadding(c.getPaddingLeft(), c.getPaddingTop(), c.getPaddingRight(), 0);
        } else
        {
            d.setVisibility(0);
            c.setPadding(c.getPaddingLeft(), c.getPaddingTop(), c.getPaddingRight(), getResources().getDimensionPixelSize(0x7f0b00bb));
            a(j);
            a(k);
        }
        bundle = getIntent().getExtras();
        if (bundle == null)
        {
            com.offerup.android.tracker.a.a("item_details", "deeplink", b);
        } else
        {
            l = bundle.getString("originScreenViewKey", null);
            m = bundle.getInt("listId", -1);
            n = bundle.getInt("itemListPosition", -1);
            o = bundle.getBoolean("hasSearchQuery", false);
        }
        if (m != -1) goto _L2; else goto _L1
_L1:
        if (a == null) goto _L4; else goto _L3
_L3:
        com.offerup.android.tracker.a.a("item_details", l, a.getId());
_L6:
        return;
_L4:
        if (b != 0L)
        {
            com.offerup.android.tracker.a.a("item_details", l, b);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (a != null)
        {
            com.offerup.android.tracker.a.a("item_details", l, a.getId(), m, n, o);
            return;
        }
        if (b != 0L)
        {
            com.offerup.android.tracker.a.a("item_details", l, b, m, n, o);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (a != null)
        {
            bundle.putParcelable("item", a);
        } else
        {
            bundle.putLong("itemId", getIntent().getLongExtra("itemId", 0L));
        }
        if (StringUtils.isNotEmpty(l))
        {
            bundle.putString("originScreenViewKey", l);
        }
        if (m != -1)
        {
            bundle.putInt("listId", m);
        }
        if (n != -1)
        {
            bundle.putInt("itemListPosition", n);
        }
        if (o)
        {
            bundle.putBoolean("hasSearchQuery", o);
        }
        bundle.putBoolean("activity_started_externally", q);
        super.onSaveInstanceState(bundle);
    }
}
