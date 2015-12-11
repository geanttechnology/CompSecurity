// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.e.a;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.bi;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.h;
import com.b.a.a.j;
import com.offerup.android.a.i;
import com.offerup.android.b.b;
import com.offerup.android.dto.Blocked;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Message;
import com.offerup.android.dto.MessageThread;
import com.offerup.android.dto.Person;
import com.offerup.android.dto.response.MessagesResponse;
import com.offerup.android.network.MessagingService;
import com.offerup.android.network.UserRelationService;
import com.offerup.android.network.o;
import com.offerup.android.tracker.d;
import com.offerup.android.utils.am;
import com.offerup.android.utils.av;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.c;
import com.offerup.android.utils.n;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.activities:
//            k, bg, bh, bs, 
//            br, bu, bk, bl, 
//            bi, bv, bm, bn, 
//            a, bo, bp, bq, 
//            bd, be, bf, bc, 
//            bj

public class ChatActivity extends k
    implements bi
{

    private View A;
    private View B;
    private View C;
    private View D;
    private bu E;
    long a;
    ArrayList b;
    ListView c;
    i d;
    SwipeRefreshLayout j;
    long k;
    h l;
    private String m;
    private long n;
    private Item o;
    private String p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private String t;
    private int u;
    private String v;
    private long w;
    private int x;
    private boolean y;
    private boolean z;

    public ChatActivity()
    {
        m = "ChatActivity";
        p = "";
    }

    static void a(ChatActivity chatactivity)
    {
        chatactivity.p = ((EditText)chatactivity.findViewById(0x7f1000c7)).getText().toString();
        if (StringUtils.isNotEmpty(chatactivity.v))
        {
            com.offerup.android.utils.n.a(chatactivity, chatactivity.k);
            return;
        }
        if (StringUtils.isEmpty(chatactivity.p))
        {
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(chatactivity);
            builder.setTitle("Error!");
            builder.setMessage("Please enter a message");
            builder.setPositiveButton("Ok", new bg(chatactivity));
            com.offerup.android.utils.n.a(builder);
            return;
        }
        if (!android.support.v4.e.a.b(chatactivity))
        {
            android.app.AlertDialog.Builder builder1 = com.offerup.android.utils.n.b(chatactivity);
            builder1.setPositiveButton("Retry", new bh(chatactivity));
            com.offerup.android.utils.n.a(builder1);
            return;
        } else
        {
            chatactivity.g = ProgressDialog.show(chatactivity, "", "Sending your message");
            com.offerup.android.network.o.d(com.offerup.android.network.o.a(Executors.newCachedThreadPool())).sendMessage(chatactivity.n, chatactivity.a, chatactivity.p, new bs(chatactivity, (byte)0));
            return;
        }
    }

    static void a(ChatActivity chatactivity, boolean flag)
    {
        chatactivity.a(true, ((android.os.AsyncTask) (new br(chatactivity, chatactivity))), new Object[0]);
    }

    static void b(ChatActivity chatactivity)
    {
        chatactivity.E.a.setVisibility(8);
        chatactivity.E.b.setVisibility(8);
        chatactivity.E.c.setVisibility(8);
        chatactivity.E.d.setVisibility(8);
        chatactivity.E.e.setVisibility(8);
        chatactivity.E = null;
    }

    static String c(ChatActivity chatactivity)
    {
        return chatactivity.m;
    }

    static void d(ChatActivity chatactivity)
    {
        chatactivity.g();
    }

    private void f()
    {
        i();
        if (j.a())
        {
            j.setRefreshing(false);
        }
        if (android.support.v4.e.a.b(this))
        {
            a(new br(this, this), new Object[0]);
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(this);
            builder.setTitle(getString(0x7f090178));
            builder.setMessage(getString(0x7f090176));
            builder.setPositiveButton(getString(0x7f090177), new bk(this, builder));
            builder.setNegativeButton(getString(0x7f090175), new bl(this));
            com.offerup.android.utils.n.a(builder);
            return;
        }
    }

    private void g()
    {
        if (!android.support.v4.e.a.b(this))
        {
            android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.b(this);
            builder.setPositiveButton("Retry", new com.offerup.android.activities.bi(this));
            com.offerup.android.utils.n.a(builder);
            return;
        } else
        {
            g = ProgressDialog.show(this, "", "Please wait");
            com.offerup.android.network.o.b(com.offerup.android.network.o.c(Executors.newCachedThreadPool())).createReport("discussion", a, new bv(this, (byte)0));
            return;
        }
    }

    public final void a()
    {
        f();
    }

    public final void a(MessagesResponse messagesresponse)
    {
        if (messagesresponse.getBlocked() != null)
        {
            messagesresponse = messagesresponse.getBlocked();
            v = messagesresponse.getReportToken();
            t = "Unblock";
            u = 0x7f020007;
            k = messagesresponse.getBlockedUser();
            s.setVisibility(0);
            r.setText("");
            if (d != null && d.getCount() > 0)
            {
                b = null;
                d.a();
                d.notifyDataSetChanged();
            }
            supportInvalidateOptionsMenu();
        } else
        {
            v = null;
            t = "Report";
            u = 0x7f020007;
            s.setVisibility(8);
            supportInvalidateOptionsMenu();
            k = 0L;
            b = new ArrayList(messagesresponse.getMessages());
            d = new i(this, b, f);
            c.setAdapter(d);
            if (b != null && b.size() > 0)
            {
                messagesresponse = (Message)b.get(0);
                if (messagesresponse != null)
                {
                    messagesresponse = messagesresponse.getThread();
                    if (messagesresponse != null)
                    {
                        Item item = messagesresponse.getItem();
                        if (item != null)
                        {
                            n = item.getId();
                            o = item;
                            Object obj = ((Message)b.get(0)).getThread();
                            item = ((MessageThread) (obj)).getItem();
                            r.setText((new StringBuilder("$")).append(item.getPrice()).append(" ").append(item.getTitle()).toString());
                            if (q != null && q.getWidth() > 0 && q.getHeight() > 0)
                            {
                                Picasso.with(this).load(item.getGetImgPermalinkSmall()).resize(q.getWidth(), q.getHeight()).centerCrop().into(q);
                                q.setOnClickListener(new bm(this, item));
                            }
                            A.setVisibility(8);
                            B.setVisibility(8);
                            C.setVisibility(8);
                            obj = ((MessageThread) (obj)).getCurrentBuyRequest();
                            if (obj != null && ((BuyRequest) (obj)).getPaymentStatus() > 0)
                            {
                                B.setVisibility(0);
                                B.setOnClickListener(new bn(this, item));
                                D.setVisibility(0);
                            } else
                            if (item.isPayable())
                            {
                                if (item.getOwner().getId() == e.n())
                                {
                                    A.setVisibility(0);
                                    A.setOnClickListener(new bo(this));
                                    D.setVisibility(0);
                                } else
                                {
                                    C.setVisibility(0);
                                    C.setOnClickListener(new bp(this, item, ((BuyRequest) (obj))));
                                    l = h.a(getApplicationContext());
                                    if (!y && l.b())
                                    {
                                        y = true;
                                        E = new bu(this, (byte)0);
                                        E.a = findViewById(0x7f1000c2);
                                        E.b = findViewById(0x7f1000c6);
                                        E.c = findViewById(0x7f1000c5);
                                        E.d = findViewById(0x7f1000c3);
                                        E.e = findViewById(0x7f1000c1);
                                        E.a.setVisibility(0);
                                        E.b.setVisibility(0);
                                        E.c.setVisibility(0);
                                        E.d.setVisibility(0);
                                        E.e.setVisibility(0);
                                        E.c.setOnClickListener(new bq(this));
                                        E.d.setVisibility(0);
                                        E.d.setOnClickListener(new bd(this));
                                        E.a.setOnClickListener(new be(this));
                                        E.e.setOnClickListener(new bf(this));
                                    }
                                    D.setVisibility(0);
                                }
                            } else
                            {
                                D.setVisibility(8);
                            }
                        }
                        if (messagesresponse.getBuyer() != null && messagesresponse.getSeller() != null)
                        {
                            k = ba.a(messagesresponse.getBuyer().getId(), messagesresponse.getSeller().getId());
                        }
                    }
                }
            }
            c.setSelection(d.getCount() - 1);
            if (z && w > 0L || x == 3 || x == 4)
            {
                w = 0L;
                x = 0;
                f.c(o.getId());
                return;
            }
        }
    }

    final String b()
    {
        return "chat";
    }

    public void chatEventAvailable(b b1)
    {
        if (b1.a() == a)
        {
            f();
        }
    }

    public final int e()
    {
        return 0x7f110002;
    }

    public void onBackPressed()
    {
        if (z)
        {
            l();
            z = false;
            f.d();
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
        com.offerup.android.b.a.getInstance().register(this);
        setContentView(0x7f04001d);
        c = (ListView)findViewById(0x7f1000af);
        q = (ImageView)findViewById(0x7f1000b2);
        r = (TextView)findViewById(0x7f1000b3);
        s = (TextView)findViewById(0x7f1000ae);
        A = findViewById(0x7f1000b4);
        B = findViewById(0x7f1000b8);
        C = findViewById(0x7f1000ba);
        findViewById(0x7f1000bf);
        D = findViewById(0x7f1000ad);
        j = (SwipeRefreshLayout)findViewById(0x7f100091);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            z = bundle.getBoolean("activity_started_externally", false);
            a = bundle.getLong("discussionId", 0L);
            x = bundle.getInt("noticeType", 0);
            n = bundle.getLong("itemId", 0L);
            w = bundle.getLong("orderId", 0L);
        }
        ((EditText)findViewById(0x7f1000c7)).setOnEditorActionListener(new bc(this));
        j.setOnRefreshListener(this);
        j.setColorSchemeResources(new int[] {
            0x7f0e0050
        });
        ((ImageView)findViewById(0x7f1000c8)).setOnClickListener(new bj(this));
        h();
        getSupportActionBar().setElevation(0.0F);
        r.setText("Loading...");
    }

    protected void onDestroy()
    {
        com.offerup.android.b.a.getInstance().unregister(this);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755393: 
            finish();
            return true;

        case 2131755731: 
            menuitem = getApplicationContext();
            break;
        }
        d d1 = d.a;
        long l1 = a;
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("content_type", d1.toString().toLowerCase());
            jsonobject.put("content_id", String.valueOf(l1));
            av.a("ou_content_moderation", jsonobject);
            com.offerup.android.utils.c.a(menuitem, "ou_content_moderation");
            am.a("ou_content_moderation", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (MenuItem menuitem)
        {
            com.b.a.a.g.a("ReportingTracker", menuitem);
        }
        if (StringUtils.isEmpty(v))
        {
            g();
            return true;
        } else
        {
            f.a(v, a);
            return true;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (StringUtils.isNotEmpty(t))
        {
            MenuItem menuitem = menu.findItem(0x7f1002d3);
            menuitem.setTitle(t);
            menuitem.setIcon(u);
            menuitem.setVisible(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        super.onResume();
        f();
    }
}
