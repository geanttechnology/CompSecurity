// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.b.a.a.g;
import com.offerup.android.a.u;
import com.offerup.android.dto.Discussion;
import com.offerup.android.dto.Item;
import com.offerup.android.g.f;
import com.offerup.android.h.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.offerup.android.activities:
//            k, a, ew

public class PayItemGridActivity extends k
    implements a
{

    private RecyclerView a;
    private u b;
    private StaggeredGridLayoutManager c;
    private List d;
    private View j;

    public PayItemGridActivity()
    {
    }

    static void a(PayItemGridActivity payitemgridactivity, List list)
    {
        int i = 0;
        if (list == null) goto _L2; else goto _L1
_L1:
        if (list.size() <= 0) goto _L2; else goto _L3
_L3:
        if (i >= list.size()) goto _L2; else goto _L4
_L4:
        Item item = ((Discussion)list.get(i)).getItem();
        if (item.isPayable() && item.getState() == 3)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        list.remove(i);
        i--;
        break MISSING_BLOCK_LABEL_163;
_L2:
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        if (list.size() > 0)
        {
            payitemgridactivity.j.setVisibility(8);
            payitemgridactivity.a.setVisibility(0);
            payitemgridactivity.d = list;
            if (payitemgridactivity.b != null)
            {
                payitemgridactivity.b.a();
                payitemgridactivity.b.a(list);
                payitemgridactivity.b.notifyDataSetChanged();
                return;
            }
            break MISSING_BLOCK_LABEL_170;
        }
        try
        {
            payitemgridactivity.j.setVisibility(0);
            payitemgridactivity.a.setVisibility(8);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PayItemGridActivity payitemgridactivity)
        {
            g.a(com/offerup/android/g/f.getSimpleName(), payitemgridactivity);
        }
        return;
        i++;
          goto _L3
    }

    final String b()
    {
        return "";
    }

    public final void b(int i)
    {
        Object obj = (Discussion)d.get(i);
        Item item = ((Discussion) (obj)).getItem();
        obj = ((Discussion) (obj)).getCurrentBuyRequest();
        f.a(item, ((com.offerup.android.dto.BuyRequest) (obj)));
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04002e);
        bundle = getSupportActionBar();
        bundle.setHomeButtonEnabled(true);
        bundle.setDisplayShowHomeEnabled(true);
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setDisplayUseLogoEnabled(false);
        bundle.setDisplayShowTitleEnabled(true);
        bundle.setTitle("Select an item");
        j = findViewById(0x7f100109);
        a = (RecyclerView)findViewById(0x7f1000fd);
        findViewById(0x7f1000ff);
        c = new StaggeredGridLayoutManager(getResources().getInteger(0x7f0d0004), 1);
        a.setLayoutManager(c);
        a.setHasFixedSize(true);
        b = new u(this, getApplicationContext(), new ArrayList());
        a.setAdapter(b);
        a(new ew(this, this), new Object[0]);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110002, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            h = true;
            onBackPressed();
            return true;

        case 2131755393: 
            finish();
            break;
        }
        return true;
    }
}
