// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.e.a;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import com.b.a.a.g;
import com.b.a.a.j;
import com.google.gson.Gson;
import com.offerup.android.a.q;
import com.offerup.android.dto.ItemList;
import com.offerup.android.gson.GsonManager;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            k, cd, ca, cb, 
//            cc, a, SearchActivity, bz

public class ExploreActivity extends k
{

    private String a;
    private q b;
    private StaggeredGridLayoutManager c;
    private RecyclerView d;
    private Toolbar j;

    public ExploreActivity()
    {
        a = "ExploreActivity";
    }

    private void a()
    {
        if (android.support.v4.e.a.b(this))
        {
            (new cd(this, (byte)0)).execute(new Void[1]);
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = n.c(this);
            builder.setTitle(getString(0x7f090178));
            builder.setMessage(getString(0x7f090176));
            builder.setPositiveButton(getString(0x7f090177), new ca(this, builder));
            builder.setNegativeButton(getString(0x7f090175), new cb(this));
            n.a(builder);
            return;
        }
    }

    static void a(ExploreActivity exploreactivity, List list)
    {
        exploreactivity.a(list);
    }

    private void a(List list)
    {
        if (ba.a()) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (i >= list.size()) goto _L2; else goto _L3
_L3:
        if (((ItemList)list.get(i)).getUser_required() == 1)
        {
            list.remove(i);
        }
          goto _L4
_L2:
        try
        {
            Collections.sort(list, new cc(this));
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            g.a(a, list);
            return;
        }
        if (b != null)
        {
            b.a();
            b.a(list);
            b.notifyDataSetChanged();
        }
        return;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected final void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null)
        {
            actionbar.setHomeAsUpIndicator(0x7f020015);
            actionbar.setTitle(getString(0x7f0900b3));
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
        }
    }

    final String b()
    {
        return "browse";
    }

    public final void b(int i)
    {
        Object obj = (ItemList)b.a(i);
        com.offerup.android.tracker.a.c(((ItemList) (obj)).getName());
        if (((ItemList) (obj)).getId() == 1)
        {
            f.m();
            return;
        } else
        {
            com.offerup.android.activities.a a1 = f;
            String s = ((ItemList) (obj)).getName();
            i = ((ItemList) (obj)).getId();
            obj = new Intent(a1.a, com/offerup/android/activities/SearchActivity);
            ((Intent) (obj)).addFlags(0x10000000);
            ((Intent) (obj)).putExtra("listName", s);
            ((Intent) (obj)).putExtra("listId", i);
            a1.a.startActivity(((Intent) (obj)));
            return;
        }
    }

    public final int c()
    {
        return 1;
    }

    public final boolean d()
    {
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040021);
        d = (RecyclerView)findViewById(0x7f1000cc);
        d.setHasFixedSize(true);
        c = new StaggeredGridLayoutManager(getResources().getInteger(0x7f0d0002), 1);
        d.setLayoutManager(c);
        b = new q(this, new ArrayList());
        d.setAdapter(b);
        j = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(j);
        a(getSupportActionBar());
    }

    protected void onResume()
    {
        super.onResume();
        String s = e.D();
        if (StringUtils.isNotEmpty(s))
        {
            try
            {
                java.lang.reflect.Type type = (new bz(this)).getType();
                a((ArrayList)GsonManager.getGson().fromJson(s, type));
                return;
            }
            catch (Exception exception)
            {
                g.a(a, exception);
            }
        }
        a();
    }
}
