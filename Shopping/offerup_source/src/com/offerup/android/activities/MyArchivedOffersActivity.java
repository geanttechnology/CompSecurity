// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.a.e;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.ItemsResponse;
import com.offerup.android.network.ArchiveService;
import com.offerup.android.network.MyOffersService;
import com.offerup.android.network.o;
import com.offerup.android.utils.n;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.concurrent.Executors;

// Referenced classes of package com.offerup.android.activities:
//            k, dh, di, dg, 
//            df

public class MyArchivedOffersActivity extends k
{

    private final String a = getClass().getSimpleName();
    private int b;
    private TextView c;
    private RecyclerView d;
    private e j;
    private StaggeredGridLayoutManager k;
    private View l;
    private TextView m;
    private View n;

    public MyArchivedOffersActivity()
    {
        b = 0;
    }

    private void a()
    {
        g = ProgressDialog.show(this, "", "Loading your archived items");
        MyOffersService myoffersservice = o.j(o.c(Executors.newSingleThreadExecutor()));
        if (b == 1)
        {
            myoffersservice.getBuyingArchivedItems(new dh(this, (byte)0));
            return;
        } else
        {
            myoffersservice.getSellingArchivedItems(new dh(this, (byte)0));
            return;
        }
    }

    static void a(MyArchivedOffersActivity myarchivedoffersactivity)
    {
        myarchivedoffersactivity.a();
    }

    static void a(MyArchivedOffersActivity myarchivedoffersactivity, Item item)
    {
        myarchivedoffersactivity.i();
        myarchivedoffersactivity.g = ProgressDialog.show(myarchivedoffersactivity, "", (new StringBuilder("Unarchiving ")).append(item.getTitle()).toString());
        o.i(o.a(Executors.newSingleThreadExecutor())).unarchiveItem(item.getId(), new di(myarchivedoffersactivity, item, (byte)0));
    }

    static void a(MyArchivedOffersActivity myarchivedoffersactivity, ItemsResponse itemsresponse)
    {
        if (itemsresponse == null || !itemsresponse.isSuccess())
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (myarchivedoffersactivity.j == null)
        {
            myarchivedoffersactivity.j = new e(myarchivedoffersactivity, new ArrayList());
            myarchivedoffersactivity.j.a(myarchivedoffersactivity.n);
        }
        if (itemsresponse.getTotal() > 0)
        {
            myarchivedoffersactivity.d.setVisibility(0);
            myarchivedoffersactivity.l.setVisibility(8);
            myarchivedoffersactivity.j.a();
            itemsresponse = itemsresponse.getItems();
            myarchivedoffersactivity.j.a(itemsresponse);
            myarchivedoffersactivity.j.notifyDataSetChanged();
            return;
        }
        try
        {
            itemsresponse = Typeface.createFromAsset(myarchivedoffersactivity.getAssets(), "segoesc.ttf");
            myarchivedoffersactivity.d.setVisibility(8);
            myarchivedoffersactivity.l.setVisibility(0);
            myarchivedoffersactivity.m.setTypeface(itemsresponse);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ItemsResponse itemsresponse)
        {
            g.a(myarchivedoffersactivity.a, itemsresponse);
        }
    }

    static int b(MyArchivedOffersActivity myarchivedoffersactivity)
    {
        return myarchivedoffersactivity.b;
    }

    static void c(MyArchivedOffersActivity myarchivedoffersactivity)
    {
        myarchivedoffersactivity.a("Error", "We were unable to process your unarchive request. If this continues, please restart app or contact support.");
    }

    static String d(MyArchivedOffersActivity myarchivedoffersactivity)
    {
        return myarchivedoffersactivity.a;
    }

    static void e(MyArchivedOffersActivity myarchivedoffersactivity)
    {
        myarchivedoffersactivity.a("Error", "We were unable to process your request. If this continues, please contact support.");
    }

    final String b()
    {
        if (b == 1)
        {
            return "archived_items_buying";
        } else
        {
            return "archived_items_selling";
        }
    }

    public final void b(int i)
    {
        Item item = (Item)j.a(i);
        android.app.AlertDialog.Builder builder = com.offerup.android.utils.n.c(this);
        builder.setTitle("Unarchive");
        StringWriter stringwriter = new StringWriter();
        stringwriter.append((new StringBuilder("Would you like to unarchive ")).append(item.getTitle()).append("?").toString());
        builder.setMessage(stringwriter.toString()).setCancelable(true).setPositiveButton("Yes", new dg(this, item)).setNegativeButton("No", new df(this));
        com.offerup.android.utils.n.a(builder);
    }

    public final int e()
    {
        return 0x7f110006;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04002a);
        d = (RecyclerView)findViewById(0x7f1000fd);
        c = (TextView)findViewById(0x7f1000fe);
        l = findViewById(0x7f1000ff);
        m = (TextView)findViewById(0x7f100100);
        k = new StaggeredGridLayoutManager(getResources().getInteger(0x7f0d0001), 1);
        d.setLayoutManager(k);
        d.setHasFixedSize(true);
        n = getLayoutInflater().inflate(0x7f0400a3, null);
        n.setLayoutParams(k.generateDefaultLayoutParams());
        j = new e(this, new ArrayList());
        j.a(n);
        d.setAdapter(j);
        bundle = getSupportActionBar();
        bundle.setDisplayOptions(0, 8);
        bundle.setElevation(0.0F);
        bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("tab"))
        {
            b = bundle.getInt("tab");
            if (b == 1)
            {
                c.setText("Buying Archive");
            } else
            {
                c.setText("Selling Archive");
            }
            a();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755393: 
            finish();
            break;
        }
        return true;
    }
}
