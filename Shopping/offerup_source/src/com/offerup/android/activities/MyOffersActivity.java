// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.b.a;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.Discussion;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.dto.response.ItemActions;
import com.offerup.android.dto.response.UserWatchlistResponse;
import com.offerup.android.e.d;
import com.offerup.android.g.ad;
import com.offerup.android.g.ba;
import com.offerup.android.g.f;
import com.offerup.android.network.ArchiveService;
import com.offerup.android.network.ItemService;
import com.offerup.android.network.b;
import com.offerup.android.network.o;
import com.offerup.android.utils.n;
import com.offerup.android.views.SlidingTabLayout;
import com.squareup.otto.Bus;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            k, eb, ec, ee, 
//            a, dp, dq, ea, 
//            dx, ef, dj, dw, 
//            dv, dm, eg, dn, 
//            do, dy, dk, dl, 
//            DiscussionsListActivity, du, dt, ed, 
//            dr, ds, MyArchivedOffersActivity, eh

public class MyOffersActivity extends k
{

    int a;
    ad b;
    List c;
    ViewPager d;
    private String j;
    private RecyclerView k;
    private RecyclerView l;
    private SlidingTabLayout m;
    private View n;
    private TextView o;
    private Toolbar p;
    private int q;
    private boolean r;
    private Date s;
    private Date t;
    private Date u;
    private f v;
    private List w;
    private ba x;
    private List y;

    public MyOffersActivity()
    {
        j = "MyOffersActivity";
        a = 0;
        r = true;
    }

    private void a()
    {
        if (a == 1)
        {
            (new eb(this, this)).execute(new Void[0]);
        } else
        {
            if (a == 0)
            {
                f();
                return;
            }
            if (a == 2)
            {
                (new ec(this, this, (byte)0)).execute(new Void[0]);
                return;
            }
        }
    }

    static void a(MyOffersActivity myoffersactivity)
    {
        myoffersactivity.f();
    }

    static void a(MyOffersActivity myoffersactivity, Item item)
    {
        myoffersactivity.a(item);
    }

    static void a(MyOffersActivity myoffersactivity, List list)
    {
        myoffersactivity.i();
        com.offerup.android.b.a.getInstance().post(new ee(list, (byte)0));
    }

    static void a(MyOffersActivity myoffersactivity, RetrofitError retrofiterror)
    {
        myoffersactivity.i();
        if (retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() == 401)
        {
            myoffersactivity.f.a();
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(myoffersactivity);
            builder.setTitle(myoffersactivity.getString(0x7f09017d));
            builder.setMessage(myoffersactivity.getString(0x7f09017b));
            builder.setNegativeButton(myoffersactivity.getString(0x7f090175), new dp(myoffersactivity));
            builder.setPositiveButton(myoffersactivity.getString(0x7f090177), new dq(myoffersactivity, builder));
            com.offerup.android.utils.n.a(builder);
            com.b.a.a.g.a(myoffersactivity, retrofiterror);
            return;
        }
    }

    static void a(MyOffersActivity myoffersactivity, boolean flag, Item item)
    {
        myoffersactivity.a(true, ((android.os.AsyncTask) (new ea(myoffersactivity, item))), new Object[0]);
    }

    private void a(Item item)
    {
        i();
        g = ProgressDialog.show(this, "", (new StringBuilder("Archiving ")).append(item.getTitle()).toString());
        com.offerup.android.network.o.i(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).archiveItem(item.getId(), new dx(this, item, (byte)0));
    }

    static void b(MyOffersActivity myoffersactivity)
    {
        long l1 = myoffersactivity.p();
        try
        {
            myoffersactivity.g = ProgressDialog.show(myoffersactivity, "", "Marking as sold");
            ef ef1 = new ef(myoffersactivity, (byte)0);
            com.offerup.android.network.o.l(com.offerup.android.network.o.a(Executors.newSingleThreadExecutor())).markItemAsSold(l1, com.offerup.android.c.a.ratingsUseInAppRatings, ef1);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(myoffersactivity, exception);
        }
    }

    private void b(boolean flag)
    {
        a(true, new eb(this, this), new Object[0]);
    }

    static boolean c(MyOffersActivity myoffersactivity)
    {
        boolean flag = false;
        if (myoffersactivity.c.get(myoffersactivity.q) != null)
        {
            if (Integer.valueOf(((Item)myoffersactivity.c.get(myoffersactivity.q)).getDiscussionCount()).intValue() > 0)
            {
                flag = true;
            }
        } else
        {
            flag = false;
        }
        return flag;
    }

    static int d(MyOffersActivity myoffersactivity)
    {
        return myoffersactivity.q;
    }

    static long e(MyOffersActivity myoffersactivity)
    {
        return myoffersactivity.p();
    }

    private void f()
    {
        if (a == 0)
        {
            a(0x7f09013c);
        }
        com.offerup.android.network.b.d(new dj(this));
    }

    private void f(int i1)
    {
        if (a == 0)
        {
            f.a((Item)c.get(i1), "my_offers");
            return;
        }
        if (a == 2)
        {
            f.a((Item)y.get(i1), "my_offers");
            return;
        } else
        {
            f.a(((Discussion)w.get(i1)).getItem(), "my_offers");
            return;
        }
    }

    static void f(MyOffersActivity myoffersactivity)
    {
        myoffersactivity.n();
    }

    private void g()
    {
        a("Error", "We were unable to process your archive request. If this continues, please restart app or contact support.");
    }

    static void g(MyOffersActivity myoffersactivity)
    {
        myoffersactivity.a();
    }

    static String h(MyOffersActivity myoffersactivity)
    {
        return myoffersactivity.j;
    }

    static void i(MyOffersActivity myoffersactivity)
    {
        myoffersactivity.g();
    }

    static void j(MyOffersActivity myoffersactivity)
    {
        myoffersactivity.r();
    }

    static void k(MyOffersActivity myoffersactivity)
    {
        myoffersactivity.q();
    }

    private void m()
    {
        StringWriter stringwriter;
        int i1;
        Object obj = (Item)c.get(q);
        try
        {
            i1 = Integer.valueOf(((Item) (obj)).getDiscussionCount()).intValue();
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(j, exception);
            i1 = 0;
        }
        obj = com.offerup.android.utils.n.c(this);
        ((android.app.AlertDialog.Builder) (obj)).setTitle("Mark Offer as Sold");
        stringwriter = new StringWriter();
        stringwriter.append("Your listing will be marked as sold and no further discussions/offers are accepted.");
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        stringwriter.append("\n");
        stringwriter.append("NOTE: one person has shown an interest in your offer and will be notified.");
_L4:
        stringwriter.append("\n\n");
        stringwriter.append("This cannot be undone, only select this when you've met the buyer and received payment, continue?");
        ((android.app.AlertDialog.Builder) (obj)).setMessage(stringwriter.toString()).setCancelable(true).setPositiveButton("Yes", new dw(this)).setNegativeButton("No", new dv(this));
        com.offerup.android.utils.n.a(((android.app.AlertDialog.Builder) (obj)));
        return;
_L2:
        if (i1 > 0)
        {
            stringwriter.append("\n");
            stringwriter.append(String.format("NOTE: %s people have shown an interest in your offer and will be notified.", new Object[] {
                Integer.valueOf(i1)
            }));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void n()
    {
        n.setVisibility(4);
    }

    private void o()
    {
        supportInvalidateOptionsMenu();
        j j1 = com.b.a.a.j.a();
        if (j1.y() || j1.z())
        {
            boolean flag;
            boolean flag1;
            if (j1.y() && !j1.A())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (j1.z() && !j1.B())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag || flag1)
            {
                AnimationSet animationset = new AnimationSet(true);
                AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation.setStartOffset(500L);
                alphaanimation.setDuration(1000L);
                animationset.addAnimation(alphaanimation);
                if (flag1)
                {
                    o.setText("Something missing?\n\nWe have cleaned up your list by archiving inactive offers. You can find them here.");
                    j1.l(true);
                } else
                {
                    o.setText("Offer Archived\n\nYou can view archived offers here.");
                    j1.k(true);
                }
                n.setOnClickListener(new dm(this));
                n.setVisibility(0);
                n.startAnimation(animationset);
                return;
            }
        }
    }

    private long p()
    {
        Item item;
        if (a == 0)
        {
            item = (Item)c.get(q);
        } else
        {
            item = ((Discussion)w.get(q)).getItem();
        }
        if (item == null)
        {
            com.b.a.a.g.a(this, new Throwable("Unable to select a null item."));
            return 0L;
        } else
        {
            return item.getId();
        }
    }

    private void q()
    {
        long l1 = p();
        try
        {
            g = ProgressDialog.show(this, "", "Unlisting Item");
            android.support.v4.e.a.b(l1, new eg(this, 2));
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    private void r()
    {
        long l1 = p();
        try
        {
            g = ProgressDialog.show(this, "", "Relisting Item");
            android.support.v4.e.a.c(l1, new eg(this, 3));
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    protected final void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null)
        {
            actionbar.setHomeAsUpIndicator(0x7f020015);
            actionbar.setTitle(getString(0x7f0900b5));
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
        }
    }

    public final void a(RecyclerView recyclerview)
    {
        k = recyclerview;
    }

    protected final void a(boolean flag, int i1)
    {
        try
        {
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(this);
            builder.setTitle(getString(0x7f09017d));
            builder.setMessage(getString(0x7f09017b));
            builder.setNegativeButton(getString(0x7f090175), new dn(this));
            builder.setPositiveButton(getString(0x7f090177), new do(this, i1, builder));
            com.offerup.android.utils.n.a(builder);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(this, exception);
        }
    }

    final String b()
    {
        return "my_offers";
    }

    public final void b(int i1)
    {
        f(i1);
    }

    public final void b(RecyclerView recyclerview)
    {
        l = recyclerview;
    }

    public void buyingEventAvailable(dy dy1)
    {
        dy1 = dy1.a;
        if (dy1 == null || !dy1.isSuccess())
        {
            if (dy1 == null || !dy1.isAuthenticationError())
            {
                b(true);
            } else
            {
                f.a();
            }
        } else
        {
            android.support.v4.e.a.g();
            try
            {
                t = Calendar.getInstance().getTime();
                w = dy1.getDiscussions();
                v.a(w);
            }
            // Misplaced declaration of an exception variable
            catch (dy dy1)
            {
                com.b.a.a.g.a(j, dy1);
            }
        }
        if (a == 1)
        {
            o();
        }
    }

    public final int c()
    {
        return 3;
    }

    public final void c(int i1)
    {
        registerForContextMenu(k);
        q = i1;
        k.showContextMenu();
    }

    public final void d(int i1)
    {
        registerForContextMenu(l);
        q = i1;
        l.showContextMenu();
    }

    public final boolean d()
    {
        return true;
    }

    public final int e()
    {
        return 0x7f110008;
    }

    final Fragment e(int i1)
    {
label0:
        {
label1:
            {
                boolean flag1 = true;
                boolean flag2 = true;
                boolean flag = true;
                if (i1 != 0)
                {
                    break label0;
                }
                if (b == null)
                {
                    b = new ad();
                }
                if (c != null)
                {
                    flag1 = android.support.v4.e.a.c();
                    if (flag1 || s == null || Calendar.getInstance().getTimeInMillis() - s.getTime() <= 0x493e0L)
                    {
                        flag = flag1;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                }
                f();
            }
            return b;
        }
label2:
        {
label3:
            {
                if (i1 != 1)
                {
                    break label2;
                }
                if (v == null)
                {
                    v = new f();
                }
                if (w != null)
                {
                    flag = android.support.v4.e.a.d();
                    if (!flag && t != null && Calendar.getInstance().getTimeInMillis() - t.getTime() > 0x493e0L)
                    {
                        flag = flag1;
                    }
                    if (!flag)
                    {
                        break label3;
                    }
                }
                (new eb(this, this)).execute(new Void[0]);
            }
            return v;
        }
label4:
        {
label5:
            {
                if (i1 != 2)
                {
                    break label4;
                }
                if (x == null)
                {
                    x = new ba();
                }
                if (y != null)
                {
                    flag = android.support.v4.e.a.e();
                    if (!flag && u != null && Calendar.getInstance().getTimeInMillis() - u.getTime() > 0x493e0L)
                    {
                        flag = flag2;
                    }
                    if (!flag)
                    {
                        break label5;
                    }
                }
                (new ec(this, this, (byte)0)).execute(new Void[0]);
            }
            return x;
        }
        com.b.a.a.g.c(com/offerup/android/activities/MyOffersActivity.getSimpleName(), "Unknown tab selected from My Offers, returning null Fragment");
        return null;
    }

    public void itemUpdatedAvailable(d d1)
    {
        android.support.v4.e.a.i();
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 2 && j1 == -1)
        {
            a();
        }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onContextItemSelected(menuitem);

        case 2131755733: 
            f(q);
            return true;

        case 2131755518: 
            int i1 = q;
            if (a == 0)
            {
                menuitem = (Item)c.get(i1);
                com.offerup.android.tracker.a.a(this, "ou_sell_item_share", menuitem);
            } else
            {
                menuitem = ((Discussion)w.get(i1)).getItem();
                com.offerup.android.tracker.a.a(this, "ou_buy_item_share", menuitem);
            }
            f.a(menuitem.getGetFullUrl());
            return true;

        case 2131755734: 
            menuitem = ((Item)c.get(q)).getTitle();
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(this);
            View view = getLayoutInflater().inflate(0x7f0400b9, null);
            ((TextView)view.findViewById(0x7f100169)).setText((new StringBuilder("Are you sure you want to delete the ")).append(menuitem).append(" offer?").toString());
            builder.setView(view);
            builder.setPositiveButton(0x7f090100, new dk(this, menuitem));
            builder.setNegativeButton(0x7f0900da, new dl(this));
            com.offerup.android.utils.n.a(builder);
            return true;

        case 2131755737: 
            if (a == 0)
            {
                menuitem = f;
                long l1 = ((Item)c.get(q)).getId();
                Intent intent = new Intent(((com.offerup.android.activities.a) (menuitem)).a, com/offerup/android/activities/DiscussionsListActivity);
                intent.putExtra("itemId", l1);
                ((com.offerup.android.activities.a) (menuitem)).a.startActivity(intent);
            } else
            {
                a(new ea(this, ((Discussion)w.get(q)).getItem()), new Object[0]);
            }
            return true;

        case 2131755735: 
            com.offerup.android.tracker.a.a("ou_item_unlist", null);
            q();
            return true;

        case 2131755736: 
            com.offerup.android.tracker.a.a("ou_item_relist", null);
            r();
            return true;

        case 2131755738: 
            com.offerup.android.tracker.a.a("ou_my_offers_item_sold_click", null);
            m();
            return true;

        case 2131755739: 
            f.a((Item)c.get(q));
            return true;

        case 2131755740: 
            if (a == 0)
            {
                menuitem = (Item)c.get(q);
            } else
            {
                menuitem = ((Discussion)w.get(q)).getItem();
            }
            if (menuitem == null)
            {
                g();
            } else
            if (a == 0 && menuitem.getState() != 4 && menuitem.getState() != 2)
            {
                android.app.AlertDialog.Builder builder1 = com.offerup.android.utils.n.c(this);
                builder1.setTitle((new StringBuilder("Archive ")).append(menuitem.getTitle()).toString());
                StringWriter stringwriter = new StringWriter();
                stringwriter.append("This offer is still listed, archiving will remove it from sale.");
                builder1.setMessage(stringwriter.toString()).setCancelable(true).setPositiveButton("Continue", new du(this, menuitem)).setNegativeButton("No", new dt(this));
                com.offerup.android.utils.n.a(builder1);
            } else
            {
                a(menuitem);
            }
            return true;

        case 2131755741: 
            f.a(((Discussion)w.get(q)).getItem(), ((Discussion)w.get(q)).getCurrentBuyRequest());
            return true;

        case 2131755742: 
            if (a == 1)
            {
                f.c(((Discussion)w.get(q)).getItem().getId());
            } else
            {
                f.c(((Item)c.get(q)).getId());
            }
            return true;

        case 2131755743: 
            f.d((Item)c.get(q));
            com.offerup.android.tracker.a.a("ou_my_offers_rate_buyer", ((Item)c.get(q)).getId());
            return true;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04002c);
        d = (ViewPager)findViewById(0x7f100103);
        d.setAdapter(new ed(this, getSupportFragmentManager()));
        m = (SlidingTabLayout)findViewById(0x7f100102);
        m.setDistributeEvenly(true);
        m.setCustomTabColorizer(new dr(this));
        m.setOnPageChangeListener(new ds(this));
        m.setViewPager(d);
        n = findViewById(0x7f100104);
        findViewById(0x7f100105);
        o = (TextView)findViewById(0x7f100106);
        p = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(p);
        a(getSupportActionBar());
        com.offerup.android.b.a.getInstance().register(this);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        boolean flag;
        flag = false;
        getMenuInflater().inflate(0x7f110007, contextmenu);
        if (a != 0) goto _L2; else goto _L1
_L1:
        if (c == null) goto _L4; else goto _L3
_L3:
        view = (Item)c.get(q);
        contextmenu.setHeaderTitle(view.getTitle());
        if (view.getDiscussionCount() != null && Integer.valueOf(view.getDiscussionCount()).intValue() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (view.getState() == 2)
        {
            contextmenu.findItem(0x7f1002d5).setVisible(true);
            if (!flag)
            {
                contextmenu.findItem(0x7f1002d6).setVisible(true);
            }
            contextmenu.findItem(0x7f1002d8).setVisible(true);
            if (flag)
            {
                contextmenu.findItem(0x7f1002d9).setVisible(true);
            }
            contextmenu.findItem(0x7f1002da).setVisible(true);
            contextmenu.findItem(0x7f1002db).setVisible(true);
        } else
        if (view.getState() == 4)
        {
            contextmenu.findItem(0x7f1002d5).setVisible(true);
            contextmenu.findItem(0x7f1001fe).setVisible(true);
            if (com.offerup.android.c.a.ratingsUseInAppRatings && view.getItemActions().isAllowRating())
            {
                contextmenu.findItem(0x7f1002df).setVisible(true);
            } else
            {
                contextmenu.findItem(0x7f1002df).setVisible(false);
            }
            if (flag)
            {
                contextmenu.findItem(0x7f1002d9).setVisible(true);
            }
            contextmenu.findItem(0x7f1002db).setVisible(false);
        } else
        {
            contextmenu.findItem(0x7f1002d5).setVisible(true);
            contextmenu.findItem(0x7f1001fe).setVisible(true);
            if (!flag)
            {
                contextmenu.findItem(0x7f1002d6).setVisible(true);
            }
            contextmenu.findItem(0x7f1002d7).setVisible(true);
            if (flag)
            {
                contextmenu.findItem(0x7f1002d9).setVisible(true);
            }
            contextmenu.findItem(0x7f1002da).setVisible(true);
            contextmenu.findItem(0x7f1002db).setVisible(true);
        }
_L9:
        if (view.getOrderId() <= 0L) goto _L6; else goto _L5
_L5:
        contextmenu.findItem(0x7f1002de).setVisible(true);
        contextmenu.findItem(0x7f1002dd).setVisible(false);
_L4:
        return;
_L6:
        contextmenu.findItem(0x7f1002de).setVisible(false);
        contextmenu.findItem(0x7f1002dd).setVisible(false);
        return;
_L2:
        if (w == null || w.size() <= q)
        {
            break; /* Loop/switch isn't completed */
        }
        view = (Discussion)w.get(q);
        if (view.getCurrentBuyRequest() != null && view.getCurrentBuyRequest().getPaymentStatus() >= 4)
        {
            contextmenu.findItem(0x7f1002de).setVisible(true);
            contextmenu.findItem(0x7f1002dd).setVisible(false);
        } else
        if (view.getItem().isPayable() && view.getItem().getState() != 4)
        {
            contextmenu.findItem(0x7f1002de).setVisible(false);
            contextmenu.findItem(0x7f1002dd).setVisible(true);
        } else
        {
            contextmenu.findItem(0x7f1002de).setVisible(false);
            contextmenu.findItem(0x7f1002dd).setVisible(false);
        }
        if (Integer.valueOf(view.getMessageCount()).intValue() > 0)
        {
            flag = true;
        }
        contextmenu.setHeaderTitle(view.getItem().getTitle());
        contextmenu.findItem(0x7f1002d5).setVisible(true);
        contextmenu.findItem(0x7f1001fe).setVisible(true);
        if (flag)
        {
            contextmenu.findItem(0x7f1002d9).setVisible(true);
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
        com.b.a.a.g.c(j, "In MyOffers, user selected item out of arraysize. If persists, need to fix. This error will prevent context menu from being shown");
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onDestroy()
    {
        com.offerup.android.b.a.getInstance().unregister(this);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (n.getVisibility() != 8)
        {
            n();
        }
        if (menuitem.getItemId() == 0x7f1002e0)
        {
            menuitem = f;
            int i1 = a;
            Intent intent = new Intent(((com.offerup.android.activities.a) (menuitem)).a, com/offerup/android/activities/MyArchivedOffersActivity);
            intent.putExtra("tab", i1);
            intent.addFlags(0x20000);
            ((com.offerup.android.activities.a) (menuitem)).a.startActivity(intent);
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        j j1 = com.b.a.a.j.a();
        MenuItem menuitem = menu.findItem(0x7f1002e0);
        if ((j1.y() || j1.z()) && (a == 1 || a == 0))
        {
            menuitem.setVisible(true);
        } else
        {
            menuitem.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        if (bundle.containsKey("selected_navigation_item"))
        {
            d.setCurrentItem(bundle.getInt("selected_navigation_item"));
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!com.offerup.android.utils.ba.a())
        {
            f.a();
        } else
        {
            boolean flag = android.support.v4.e.a.c();
            boolean flag1 = android.support.v4.e.a.d();
            boolean flag2 = android.support.v4.e.a.e();
            if (!r)
            {
                if (flag && flag1 && flag2)
                {
                    w = null;
                    c = null;
                    y = null;
                    if (v != null)
                    {
                        v.a();
                        (new eb(this, this)).execute(new Void[0]);
                    }
                    if (b != null)
                    {
                        b.a();
                        f();
                    }
                    if (x != null)
                    {
                        x.a();
                        (new ec(this, this, (byte)0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    if (flag1 && a == 1)
                    {
                        a();
                        com.offerup.android.tracker.a.a("my_offers_buying");
                        return;
                    }
                    if (flag && a == 0)
                    {
                        a();
                        com.offerup.android.tracker.a.a("my_offers_selling");
                        return;
                    }
                    if (flag2 && a == 2)
                    {
                        a();
                        com.offerup.android.tracker.a.a("my_offers_watching");
                        return;
                    }
                }
            } else
            {
                r = false;
                com.offerup.android.tracker.a.a("my_offers_selling");
                return;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("selected_navigation_item", a);
    }

    public void sellingEventAvailable(ee ee1)
    {
        android.support.v4.e.a.f();
        ee1 = ee1.a();
        try
        {
            s = Calendar.getInstance().getTime();
            c = ee1;
            b.a(c);
        }
        // Misplaced declaration of an exception variable
        catch (ee ee1)
        {
            com.b.a.a.g.a(j, ee1);
        }
        if (a == 0)
        {
            o();
        }
    }

    public void watchingEventAvailable(eh eh1)
    {
        eh1 = eh1.a;
        if (eh1 == null || !eh1.isSuccess())
        {
            if (eh1 == null || !eh1.isAuthenticationError())
            {
                b(true);
                return;
            } else
            {
                f.a();
                return;
            }
        }
        android.support.v4.e.a.h();
        try
        {
            u = Calendar.getInstance().getTime();
            y = eh1.getItems();
            x.a(y);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (eh eh1)
        {
            com.b.a.a.g.a(j, eh1);
        }
    }
}
