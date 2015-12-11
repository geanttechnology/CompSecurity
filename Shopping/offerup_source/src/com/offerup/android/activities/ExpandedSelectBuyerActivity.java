// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import com.b.a.a.g;
import com.offerup.android.a.al;
import com.offerup.android.dto.Item;
import com.offerup.android.h.a;
import com.offerup.android.utils.n;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.offerup.android.activities:
//            k, by, a

public class ExpandedSelectBuyerActivity extends k
    implements a
{

    private RecyclerView a;
    private al b;
    private android.support.v7.widget.RecyclerView.LayoutManager c;
    private Item d;

    public ExpandedSelectBuyerActivity()
    {
    }

    private void a(String s)
    {
        android.app.AlertDialog.Builder builder = n.c(this);
        builder.setTitle(getString(0x7f09017d));
        builder.setMessage(getString(0x7f09017b));
        builder.setPositiveButton("OK", new by(this));
        n.a(builder);
        g.a(this, new Throwable(s));
    }

    protected final void a(ActionBar actionbar)
    {
        if (actionbar != null)
        {
            actionbar.setTitle(getResources().getString(0x7f0901d2));
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    final String b()
    {
        return "select_buyer_expanded";
    }

    public final void b(int i)
    {
        com.offerup.android.dto.Person person = b.a(i);
        f.a(d, person);
        com.offerup.android.tracker.a.a("ou_select_buyer_expanded", d.getId(), person);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 11 && j == -1)
        {
            setResult(-1);
            finish();
        }
    }

    public void onBackPressed()
    {
        com.offerup.android.tracker.a.a("ou_select_buyer_expanded_back", null);
        setResult(1);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04001f);
        a = (RecyclerView)findViewById(0x7f1000ca);
        c = new LinearLayoutManager(this);
        a.setLayoutManager(c);
        b = new al(getApplicationContext(), this, new ArrayList());
        a.setAdapter(b);
        bundle = getIntent().getExtras();
        if (bundle.containsKey("buyerList") && bundle.containsKey("item"))
        {
            ArrayList arraylist = bundle.getParcelableArrayList("buyerList");
            if (arraylist == null || arraylist.size() == 0)
            {
                a("Unable to retrieve buyers list.");
            }
            d = (Item)bundle.getParcelable("item");
            b.a(arraylist);
            b.notifyDataSetChanged();
            return;
        } else
        {
            a("No item ID and buyers list found in the current intent");
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }
}
