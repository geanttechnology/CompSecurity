// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.aqo;
import android.support.v7.gg;
import android.support.v7.gh;
import android.support.v7.ib;
import android.support.v7.is;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.abtnprojects.ambatana.models.Category;
import com.abtnprojects.ambatana.models.SearchParameters;
import com.abtnprojects.ambatana.ui.widgets.c;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

public class SearchActivity extends b
{

    private ImageButton A;
    private ScrollView B;
    private ViewGroup C;
    private List D;
    private List E;
    private ViewGroup F;
    private List G;
    private c H;
    private EditText I;
    private EditText J;
    private ViewGroup K;
    private List L;
    private c M;
    private LinearLayout N;
    private LinearLayout O;
    private List P;
    private double Q;
    private double R;
    private String S;
    private gg T;
    private EditText n;

    public SearchActivity()
    {
    }

    private void C()
    {
        C.removeAllViews();
        c c1;
        for (Iterator iterator = P.iterator(); iterator.hasNext(); C.addView(c1))
        {
            Category category = (Category)iterator.next();
            c1 = new c(this);
            D.add(c1);
            c1.setId(Integer.valueOf(category.getId()).intValue());
            c1.setTitle(category.getName());
            c1.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view)
                {
                    view = (c)view;
                    c c2;
                    if (SearchActivity.d(a).contains(view))
                    {
                        SearchActivity.d(a).remove(view);
                    } else
                    {
                        SearchActivity.d(a).add(view);
                    }
                    for (view = SearchActivity.e(a).iterator(); view.hasNext(); c2.setSelected(SearchActivity.d(a).contains(c2)))
                    {
                        c2 = (c)view.next();
                    }

                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
        }

    }

    private void D()
    {
        G.clear();
        F.removeAllViews();
        H = null;
        String s4 = is.a(this, Locale.getDefault());
        int j = 0;
        while (j < com.abtnprojects.ambatana.models.SearchParameters.Distance.values().length) 
        {
            c c1 = new c(this);
            G.add(c1);
            com.abtnprojects.ambatana.models.SearchParameters.Distance distance = com.abtnprojects.ambatana.models.SearchParameters.Distance.values()[j];
            c1.setId(j);
            int i1 = distance.getStringResourceId();
            if (i1 == 0x7f090162)
            {
                String s;
                if (s4 == null || s4.equalsIgnoreCase("mi"))
                {
                    s = getString(0x7f090164);
                } else
                {
                    s = getString(0x7f090163);
                }
                c1.setTitle((new StringBuilder()).append(getString(distance.getStringResourceId())).append(" ").append(s).toString());
            } else
            if (i1 == 0x7f09015f)
            {
                String s1;
                if (s4 == null || s4.equalsIgnoreCase("mi"))
                {
                    s1 = getString(0x7f090161);
                } else
                {
                    s1 = getString(0x7f090160);
                }
                c1.setTitle((new StringBuilder()).append(getString(distance.getStringResourceId())).append(" ").append(s1).toString());
            } else
            if (i1 == 0x7f090165)
            {
                String s2;
                if (s4 == null || s4.equalsIgnoreCase("mi"))
                {
                    s2 = getString(0x7f090167);
                } else
                {
                    s2 = getString(0x7f090166);
                }
                c1.setTitle((new StringBuilder()).append(getString(distance.getStringResourceId())).append(" ").append(s2).toString());
            } else
            if (i1 == 0x7f090168)
            {
                String s3;
                if (s4 == null || s4.equalsIgnoreCase("mi"))
                {
                    s3 = getString(0x7f09016a);
                } else
                {
                    s3 = getString(0x7f090169);
                }
                c1.setTitle((new StringBuilder()).append(getString(distance.getStringResourceId())).append(" ").append(s3).toString());
            }
            c1.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view)
                {
                    view = (c)view;
                    if (view != SearchActivity.f(a))
                    {
                        SearchActivity.a(a, view);
                        Iterator iterator = SearchActivity.g(a).iterator();
                        while (iterator.hasNext()) 
                        {
                            c c2 = (c)iterator.next();
                            boolean flag;
                            if (c2 == view)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            c2.setSelected(flag);
                        }
                    }
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            F.addView(c1);
            j++;
        }
    }

    private void E()
    {
        L.clear();
        K.removeAllViews();
        M = null;
        int j = 0;
        while (j < com.abtnprojects.ambatana.models.SearchParameters.SortBy.values().length) 
        {
            c c1 = new c(this);
            L.add(c1);
            com.abtnprojects.ambatana.models.SearchParameters.SortBy sortby = com.abtnprojects.ambatana.models.SearchParameters.SortBy.values()[j];
            c1.setId(j);
            c1.setTitle(sortby.getStringResourceId());
            if (j == v.getSortBy().ordinal())
            {
                M = c1;
                c1.setSelected(true);
            } else
            {
                c1.setSelected(false);
            }
            c1.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view)
                {
                    view = (c)view;
                    if (view != SearchActivity.h(a))
                    {
                        SearchActivity.b(a, view);
                        Iterator iterator = SearchActivity.i(a).iterator();
                        while (iterator.hasNext()) 
                        {
                            c c2 = (c)iterator.next();
                            boolean flag;
                            if (c2 == view)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            c2.setSelected(flag);
                        }
                    }
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            K.addView(c1);
            j++;
        }
    }

    private void F()
    {
        n.setText("");
    }

    private void G()
    {
        aqo.a("onResetFiltersPressed", new Object[0]);
        v = new SearchParameters();
        Q = v.getLatitude();
        R = v.getLongitude();
        S = v.getFormattedAddress();
        a(v);
        E = c(v);
        H = b(v);
        d(v);
        M = e(v);
        is.a(this, v);
    }

    private void H()
    {
        float f1;
        String s2;
        ArrayList arraylist;
        com.abtnprojects.ambatana.models.SearchParameters.Distance distance;
        f1 = -1F;
        s2 = n.getText().toString();
        arraylist = new ArrayList();
        for (int j = 0; j < E.size(); j++)
        {
            arraylist.add(Integer.valueOf(((c)E.get(j)).getId()));
        }

        distance = com.abtnprojects.ambatana.models.SearchParameters.Distance.values()[H.getId()];
        String s = I.getText().toString();
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        float f2 = Float.valueOf(s).floatValue();
_L5:
        Object obj;
        com.abtnprojects.ambatana.models.SearchParameters.SortBy sortby;
        SearchParameters searchparameters;
        boolean flag;
        try
        {
            String s1 = J.getText().toString();
            if (!TextUtils.isEmpty(s1))
            {
                f1 = Float.valueOf(s1).floatValue();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aqo.b(((Throwable) (obj)), "Invalid price to field value", new Object[0]);
            f1 = -1F;
        }
        if (f2 > 0.0F && f1 > 0.0F && f2 > f1)
        {
            obj = getString(0x7f09017c);
            flag = false;
        } else
        {
            obj = null;
            flag = true;
        }
        sortby = com.abtnprojects.ambatana.models.SearchParameters.SortBy.values()[M.getId()];
        if (!flag) goto _L4; else goto _L3
_L3:
        obj = new Intent();
        searchparameters = new SearchParameters();
        searchparameters.setQuery(s2);
        searchparameters.setCategoryIds(arraylist);
        searchparameters.setLatitude(Q);
        searchparameters.setLongitude(R);
        searchparameters.setFormattedAddress(S);
        searchparameters.setDistance(distance);
        searchparameters.setPriceFrom(f2);
        searchparameters.setPriceTo(f1);
        searchparameters.setSortBy(sortby);
        is.a(this, searchparameters);
        T.a(this, s2, ParseUser.getCurrentUser());
        setResult(-1, ((Intent) (obj)));
        finish();
_L7:
        return;
        obj;
        aqo.b(((Throwable) (obj)), "Invalid price from field value", new Object[0]);
_L2:
        f2 = -1F;
          goto _L5
_L4:
        if (obj == null) goto _L7; else goto _L6
_L6:
        Toast.makeText(this, ((CharSequence) (obj)), 0).show();
        return;
          goto _L5
    }

    static c a(SearchActivity searchactivity, c c1)
    {
        searchactivity.H = c1;
        return c1;
    }

    private void a(SearchParameters searchparameters)
    {
        n.setText(searchparameters.getQuery());
    }

    static void a(SearchActivity searchactivity)
    {
        searchactivity.H();
    }

    private c b(SearchParameters searchparameters)
    {
        c c1 = null;
        for (Iterator iterator = G.iterator(); iterator.hasNext();)
        {
            c c2 = (c)iterator.next();
            if (c2.getId() == searchparameters.getDistance().ordinal())
            {
                c2.setSelected(true);
                c1 = c2;
            } else
            {
                c2.setSelected(false);
            }
        }

        return c1;
    }

    static c b(SearchActivity searchactivity, c c1)
    {
        searchactivity.M = c1;
        return c1;
    }

    static void b(SearchActivity searchactivity)
    {
        searchactivity.F();
    }

    private List c(SearchParameters searchparameters)
    {
        ArrayList arraylist = new ArrayList();
        searchparameters = searchparameters.getCategoryIds();
        for (Iterator iterator = D.iterator(); iterator.hasNext();)
        {
            c c1 = (c)iterator.next();
            if (searchparameters.contains(Integer.valueOf(c1.getId())))
            {
                arraylist.add(c1);
                c1.setSelected(true);
            } else
            {
                c1.setSelected(false);
            }
        }

        return arraylist;
    }

    static void c(SearchActivity searchactivity)
    {
        searchactivity.G();
    }

    static List d(SearchActivity searchactivity)
    {
        return searchactivity.E;
    }

    private void d(SearchParameters searchparameters)
    {
        if (searchparameters.hasPriceFrom())
        {
            I.setText(Float.toString(searchparameters.getPriceFrom()));
        } else
        {
            I.setText("");
        }
        if (searchparameters.hasPriceTo())
        {
            J.setText(Float.toString(searchparameters.getPriceTo()));
            return;
        } else
        {
            J.setText("");
            return;
        }
    }

    private c e(SearchParameters searchparameters)
    {
        c c1 = null;
        for (Iterator iterator = L.iterator(); iterator.hasNext();)
        {
            c c2 = (c)iterator.next();
            if (c2.getId() == searchparameters.getSortBy().ordinal())
            {
                c2.setSelected(true);
                c1 = c2;
            } else
            {
                c2.setSelected(false);
            }
        }

        return c1;
    }

    static List e(SearchActivity searchactivity)
    {
        return searchactivity.D;
    }

    static c f(SearchActivity searchactivity)
    {
        return searchactivity.H;
    }

    static List g(SearchActivity searchactivity)
    {
        return searchactivity.G;
    }

    static c h(SearchActivity searchactivity)
    {
        return searchactivity.M;
    }

    static List i(SearchActivity searchactivity)
    {
        return searchactivity.L;
    }

    private List l()
    {
        int j = 0;
        String as[] = getResources().getStringArray(0x7f0e0001);
        ArrayList arraylist = new ArrayList(as.length);
        int i1 = 1;
        int k1 = as.length;
        int j1 = 0;
        for (; j < k1; j++)
        {
            arraylist.add(j1, new Category(i1, as[j]));
            j1++;
            i1++;
        }

        return arraylist;
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            a(0x7f0200d1);
            T = new gg(new gh());
            T.a(this, ParseUser.getCurrentUser());
            Q = v.getLatitude();
            R = v.getLongitude();
            S = v.getFormattedAddress();
            n = (EditText)findViewById(0x7f1000c7);
            n.setHint(0x7f090176);
            A = (ImageButton)findViewById(0x7f10015e);
            n.addTextChangedListener(new ib(A));
            n.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final SearchActivity a;

                public boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
                {
                    SearchActivity.a(a);
                    return true;
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            A.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view)
                {
                    SearchActivity.b(a);
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            B = (ScrollView)findViewById(0x7f1000be);
            B.setVisibility(4);
            C = (ViewGroup)findViewById(0x7f1000c0);
            D = new ArrayList();
            E = new ArrayList();
            F = (ViewGroup)findViewById(0x7f1000c1);
            G = new ArrayList();
            H = null;
            I = (EditText)findViewById(0x7f1000c2);
            J = (EditText)findViewById(0x7f1000c3);
            K = (ViewGroup)findViewById(0x7f1000c4);
            L = new ArrayList();
            M = null;
            N = (LinearLayout)findViewById(0x7f1000c5);
            N.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view)
                {
                    com.abtnprojects.ambatana.ui.activities.SearchActivity.c(a);
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            O = (LinearLayout)findViewById(0x7f1000c6);
            O.setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view)
                {
                    SearchActivity.a(a);
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            D();
            E();
            a(v);
            H = b(v);
            d(v);
            M = e(v);
            P = l();
            C();
            E = c(v);
            B.setVisibility(0);
        }
    }

    protected void k()
    {
        setContentView(0x7f040025);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }
}
