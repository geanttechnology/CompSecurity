// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.b.a.a.g;
import com.offerup.android.a.al;
import com.offerup.android.dto.Item;
import com.offerup.android.h.a;
import com.offerup.android.network.ItemService;
import com.offerup.android.network.o;
import com.offerup.android.views.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

// Referenced classes of package com.offerup.android.activities:
//            k, hj, hh, a, 
//            hd, he, hf, hg

public class SelectBuyerActivity extends k
    implements a
{

    private CardView a;
    private CardView b;
    private CardView c;
    private TextView d;
    private TextView j;
    private CardView k;
    private CardView l;
    private RecyclerView m;
    private al n;
    private View o;
    private Item p;

    public SelectBuyerActivity()
    {
    }

    static Item a(SelectBuyerActivity selectbuyeractivity)
    {
        return selectbuyeractivity.p;
    }

    private void a(long l1)
    {
        try
        {
            g = ProgressDialog.show(this, "", "Loading...");
            hj hj1 = new hj(this, (byte)0);
            com.offerup.android.network.o.l(com.offerup.android.network.o.c(Executors.newSingleThreadExecutor())).getItemWithUserEngagement(l1, hj1);
            return;
        }
        catch (Exception exception)
        {
            g.a(this, exception);
        }
    }

    static void a(SelectBuyerActivity selectbuyeractivity, ArrayList arraylist)
    {
        if (arraylist != null && arraylist.size() > 0)
        {
            if (arraylist.size() > 3)
            {
                ArrayList arraylist1 = new ArrayList(3);
                for (int i1 = 0; i1 < 3; i1++)
                {
                    arraylist1.add(arraylist.get(i1));
                }

                selectbuyeractivity.n.a(arraylist1);
                selectbuyeractivity.d.setText((new StringBuilder()).append(arraylist.size()).append(" Total").toString());
                selectbuyeractivity.a.setVisibility(0);
                selectbuyeractivity.a.setOnClickListener(new hh(selectbuyeractivity, arraylist));
            } else
            {
                selectbuyeractivity.n.a(arraylist);
            }
            selectbuyeractivity.o.setVisibility(0);
            selectbuyeractivity.n.notifyDataSetChanged();
        } else
        {
            selectbuyeractivity.o.setVisibility(8);
        }
        selectbuyeractivity.b.setVisibility(0);
        selectbuyeractivity.c.setVisibility(0);
        selectbuyeractivity.j.setVisibility(0);
    }

    static CardView b(SelectBuyerActivity selectbuyeractivity)
    {
        return selectbuyeractivity.k;
    }

    static CardView c(SelectBuyerActivity selectbuyeractivity)
    {
        return selectbuyeractivity.l;
    }

    protected final void a(ActionBar actionbar)
    {
        if (actionbar != null)
        {
            actionbar.setTitle(getResources().getString(0x7f0901d2));
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(false);
        }
    }

    final String b()
    {
        return "select_buyer";
    }

    public final void b(int i1)
    {
        com.offerup.android.dto.Person person = n.a(i1);
        f.a(p, person);
        com.offerup.android.tracker.a.a("ou_select_buyer", p.getId(), person);
    }

    public final int e()
    {
        return 0x7f11000f;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 11 && j1 == -1)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        com.offerup.android.tracker.a.a("ou_select_buyer_back", null);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003b);
        a = (CardView)findViewById(0x7f100131);
        j = (TextView)findViewById(0x7f10012f);
        b = (CardView)findViewById(0x7f100134);
        c = (CardView)findViewById(0x7f100137);
        d = (TextView)findViewById(0x7f100132);
        k = (CardView)findViewById(0x7f100136);
        l = (CardView)findViewById(0x7f100139);
        m = (RecyclerView)findViewById(0x7f100130);
        o = findViewById(0x7f100133);
        bundle = new i(this);
        n = new al(getApplicationContext(), this, new ArrayList());
        m.setLayoutManager(bundle);
        m.setAdapter(n);
        bundle = getIntent().getExtras();
        if (bundle.containsKey("item"))
        {
            p = (Item)bundle.getParcelable("item");
            if (p != null)
            {
                a(p.getId());
            } else
            {
                g.a(this, new Exception("Unable to retrieve item id from intent"));
            }
        }
        k.setOnClickListener(new hd(this));
        l.setOnClickListener(new he(this));
        b.setOnClickListener(new hf(this));
        c.setOnClickListener(new hg(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755393: 
            com.offerup.android.tracker.a.b("ou_select_buyer_x_close");
            break;
        }
        Toast.makeText(this, getResources().getString(0x7f0900d7), 1).show();
        finish();
        return true;
    }
}
