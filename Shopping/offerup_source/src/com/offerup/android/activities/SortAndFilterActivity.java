// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.dto.Filter;
import com.offerup.android.dto.FilterOption;
import com.offerup.android.dto.Sort;
import com.offerup.android.g.a;
import com.offerup.android.g.at;
import com.offerup.android.g.au;
import com.offerup.android.g.ax;
import com.offerup.android.g.c;
import com.offerup.android.g.d;
import com.offerup.android.g.x;
import com.offerup.android.utils.OfferUpLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.activities:
//            k, hp, hq

public class SortAndFilterActivity extends k
{

    private TextView a;
    private LinearLayout b;
    private Button c;
    private a d;
    private c j;
    private Map k;
    private List l;
    private List m;
    private OfferUpLocation n;

    public SortAndFilterActivity()
    {
    }

    private void a(Intent intent)
    {
        if (intent != null)
        {
            ArrayList arraylist = intent.getParcelableArrayListExtra("sortList");
            intent = intent.getParcelableArrayListExtra("filterList");
            if (intent != null && intent.size() > 0)
            {
                m = intent;
                intent = m.iterator();
                do
                {
                    if (!intent.hasNext())
                    {
                        break;
                    }
                    Filter filter = (Filter)intent.next();
                    if (getResources().getString(0x7f0901fc).equals(filter.getType()) && !getResources().getString(0x7f0901fd).equals(filter.getName()))
                    {
                        ax ax1 = new ax();
                        k.put(filter.getName(), ax1);
                        getSupportFragmentManager().a().a(0x7f100140, ax1).b();
                    } else
                    if (filter.getType().equals(getResources().getString(0x7f090202)))
                    {
                        d d1 = new d();
                        k.put(filter.getName(), d1);
                        getSupportFragmentManager().a().a(0x7f100140, d1).b();
                    }
                } while (true);
            }
            if (arraylist != null && arraylist.size() > 0)
            {
                l = arraylist;
            }
        }
    }

    private void a(Filter filter)
    {
        if (filter != null)
        {
            ((a)k.get(filter.getName())).a(filter);
        }
    }

    private void a(JSONObject jsonobject, String s, String s1)
    {
        try
        {
            jsonobject.put(s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            g.a(getClass().getSimpleName(), jsonobject);
        }
    }

    private void b(Intent intent)
    {
        if (intent == null) goto _L2; else goto _L1
_L1:
        if (intent.hasExtra("location"))
        {
            n = (OfferUpLocation)intent.getParcelableExtra("location");
        }
        if (n == null) goto _L4; else goto _L3
_L3:
        if (!StringUtils.isNotEmpty(n.f())) goto _L6; else goto _L5
_L5:
        a.setText((new StringBuilder()).append(n.f()).append(", ").append(n.g()).toString());
_L2:
        return;
_L6:
        if (StringUtils.isNotEmpty(n.a()))
        {
            a.setText(n.a());
            return;
        } else
        {
            a.setText(getApplicationContext().getResources().getString(0x7f09013e));
            return;
        }
_L4:
        intent = intent.getStringExtra("address");
        String s = e.E();
        String s1 = e.I();
        String s2 = e.J();
        if (StringUtils.isNotEmpty(intent))
        {
            if (StringUtils.isNotEmpty(s1))
            {
                a.setText((new StringBuilder()).append(s1).append(", ").append(s2).toString());
                return;
            }
            if (StringUtils.isNotEmpty(s))
            {
                a.setText(s);
                return;
            }
        } else
        if (StringUtils.isNotEmpty(s))
        {
            a.setText(s);
            return;
        } else
        {
            a.setText(getApplicationContext().getResources().getString(0x7f09013e));
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public final void a()
    {
        JSONObject jsonobject = new JSONObject();
        Intent intent = new Intent();
        Object obj = l.iterator();
        boolean flag;
        boolean flag1;
        for (flag = false; ((Iterator) (obj)).hasNext(); flag = flag1)
        {
            Sort sort = (Sort)((Iterator) (obj)).next();
            flag1 = flag;
            if (!sort.isSelected())
            {
                continue;
            }
            intent.putExtra("sort", sort.getValue());
            if (!sort.isDefaultValue())
            {
                flag = true;
            }
            a(jsonobject, "sort", sort.getValue());
            flag1 = flag;
        }

        obj = new ArrayList();
        Iterator iterator = m.iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Filter filter = (Filter)iterator.next();
            if (filter.getType().equals(getResources().getString(0x7f0901fc)))
            {
                Iterator iterator1 = filter.getOptions().iterator();
                do
                {
                    FilterOption filteroption;
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            continue label0;
                        }
                        filteroption = (FilterOption)iterator1.next();
                    } while (!filteroption.isSelected());
                    intent.putExtra(filter.getName(), filteroption.getValue());
                    ((ArrayList) (obj)).add(filter.getName());
                    if (!filteroption.isDefaultValue())
                    {
                        flag = true;
                    }
                    a(jsonobject, filter.getName(), filteroption.getValue());
                } while (true);
            }
            if (filter.getType().equals(getResources().getString(0x7f090202)))
            {
                String s = String.valueOf(filter.isSelected());
                intent.putExtra(filter.getName(), s);
                ((ArrayList) (obj)).add(filter.getName());
                if (filter.isSelected() != filter.isDefaultValue())
                {
                    flag = true;
                }
                a(jsonobject, filter.getName(), s);
            }
        } while (true);
        intent.putExtra("location", n);
        if (((ArrayList) (obj)).size() > 0)
        {
            intent.putStringArrayListExtra("filter", ((ArrayList) (obj)));
        }
        if (flag)
        {
            setResult(9, intent);
        } else
        {
            setResult(8, intent);
        }
        com.offerup.android.tracker.a.a("ou_sort_filter_apply", jsonobject);
        finish();
    }

    final String b()
    {
        return "sort_and_filter";
    }

    public final int e()
    {
        return 0x7f110010;
    }

    protected void onActivityResult(int i, int i1, Intent intent)
    {
        super.onActivityResult(i, i1, intent);
        if (i == 615)
        {
            b(intent);
        }
    }

    public void onBackPressed()
    {
        com.offerup.android.tracker.a.a("ou_sort_filter_cancel", null);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003c);
        bundle = getSupportActionBar();
        bundle.setTitle(getResources().getString(0x7f0901f6));
        bundle.setDisplayUseLogoEnabled(false);
        bundle.setDisplayShowTitleEnabled(true);
        l = new ArrayList();
        m = new ArrayList();
        k = new HashMap();
        a = (TextView)findViewById(0x7f10013d);
        b = (LinearLayout)findViewById(0x7f10013c);
        c = (Button)findViewById(0x7f100142);
        d = new x();
        getSupportFragmentManager().a().a(0x7f10013f, d).b();
        if (getResources().getBoolean(0x7f0a0000))
        {
            j = new at();
        } else
        {
            j = new au();
        }
        getSupportFragmentManager().a().a(0x7f100140, j).b();
        b.setOnClickListener(new hp(this));
        c.setOnClickListener(new hq(this));
        bundle = getIntent();
        if (bundle != null)
        {
            b(bundle);
            a(bundle);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110010, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755757: 
            com.offerup.android.tracker.a.a("ou_sort_filter_reset", null);
            break;
        }
        d.a();
        j.a();
        if (k != null)
        {
            for (menuitem = k.entrySet().iterator(); menuitem.hasNext(); ((a)((java.util.Map.Entry)menuitem.next()).getValue()).a()) { }
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        if (m != null && m.size() > 0)
        {
            Iterator iterator = m.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (Filter)iterator.next();
                if (((Filter) (obj)).getType().equals(getResources().getString(0x7f0901fc)))
                {
                    if (getResources().getString(0x7f0901fd).equals(((Filter) (obj)).getName()))
                    {
                        if (((Filter) (obj)).getOptions().size() > 1)
                        {
                            d.a(((Filter) (obj)));
                            obj = (FrameLayout)findViewById(0x7f10013f);
                            if (((FrameLayout) (obj)).getChildCount() != 0)
                            {
                                ((FrameLayout) (obj)).setVisibility(0);
                            }
                        }
                    } else
                    {
                        a(((Filter) (obj)));
                    }
                } else
                if (getResources().getString(0x7f090202).equals(((Filter) (obj)).getType()))
                {
                    a(((Filter) (obj)));
                }
            } while (true);
        }
        if (l != null && l.size() > 0)
        {
            j.a(l);
            if (l.size() > 1)
            {
                ((LinearLayout)findViewById(0x7f100140)).setVisibility(0);
            }
        }
    }
}
