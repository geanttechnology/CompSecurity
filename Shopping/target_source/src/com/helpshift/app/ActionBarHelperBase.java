// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.helpshift.i.x;
import com.helpshift.widget.SimpleSearchView;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.helpshift.app:
//            b, e, d

public class ActionBarHelperBase extends b
{
    public static class HomeView extends LinearLayout
    {

        private ImageView a;
        private Context b;

        protected void onFinishInflate()
        {
            super.onFinishInflate();
            a = (ImageView)findViewById(com.helpshift.b.c.K);
        }

        public void setIcon(Drawable drawable)
        {
            a.setImageDrawable(drawable);
        }

        public HomeView(Context context)
        {
            super(context);
            b = context;
        }

        public HomeView(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            b = context;
        }
    }

    private class a extends MenuInflater
    {

        MenuInflater a;
        final ActionBarHelperBase b;

        private void a(int l)
        {
            Object obj;
            XmlResourceParser xmlresourceparser;
            Object obj2;
            int i1;
            i1 = 0;
            obj = null;
            obj2 = null;
            xmlresourceparser = null;
            XmlResourceParser xmlresourceparser1 = b.a.getResources().getXml(l);
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            int j1 = xmlresourceparser1.getEventType();
            l = i1;
            i1 = j1;
              goto _L1
_L3:
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            j1 = xmlresourceparser1.next();
            l = i1;
            i1 = j1;
              goto _L1
_L10:
            i1 = l;
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            if (!xmlresourceparser1.getName().equals("item")) goto _L3; else goto _L2
_L2:
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            j1 = xmlresourceparser1.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "id", 0);
            i1 = l;
            if (j1 == 0) goto _L3; else goto _L4
_L4:
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            i1 = xmlresourceparser1.getAttributeIntValue("http://schemas.android.com/apk/res/android", "showAsAction", -1);
            if ((i1 & 2) == 0 && (i1 & 1) == 0)
            {
                break MISSING_BLOCK_LABEL_272;
            }
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            i1 = xmlresourceparser1.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "actionLayout", 0);
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_244;
            }
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            ActionBarHelperBase.c(b).put(Integer.valueOf(j1), Integer.valueOf(i1));
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            ActionBarHelperBase.d(b).add(Integer.valueOf(j1));
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            String s = xmlresourceparser1.getAttributeValue("http://schemas.android.com/apk/res/android", "actionViewClass");
            i1 = l;
            if (s == null) goto _L3; else goto _L5
_L5:
            xmlresourceparser = xmlresourceparser1;
            obj = xmlresourceparser1;
            obj2 = xmlresourceparser1;
            ActionBarHelperBase.a(b).put(Integer.valueOf(j1), s);
            i1 = l;
              goto _L3
            obj2;
            obj = xmlresourceparser;
            throw new InflateException("Error inflating menu XML", ((Throwable) (obj2)));
            Object obj1;
            obj1;
            if (obj != null)
            {
                ((XmlResourceParser) (obj)).close();
            }
            throw obj1;
_L9:
            i1 = 1;
              goto _L3
_L7:
            if (xmlresourceparser1 != null)
            {
                xmlresourceparser1.close();
            }
            return;
            obj1;
            obj = obj2;
            throw new InflateException("Error inflating menu XML", ((Throwable) (obj1)));
_L1:
            if (l != 0) goto _L7; else goto _L6
_L6:
            i1;
            JVM INSTR tableswitch 1 2: default 432
        //                       1 368
        //                       2 84;
               goto _L8 _L9 _L10
_L8:
            i1 = l;
            if (true) goto _L3; else goto _L11
_L11:
        }

        public void inflate(int l, Menu menu)
        {
            a(l);
            a.inflate(l, menu);
            l = 0;
            while (l < menu.size()) 
            {
                try
                {
                    e e1 = (e)menu.getItem(l);
                    int i1 = e1.getItemId();
                    if (ActionBarHelperBase.a(b).containsKey(Integer.valueOf(i1)) && ((String)ActionBarHelperBase.a(b).get(Integer.valueOf(i1))).equals("android.widget.SearchView"))
                    {
                        SimpleSearchView simplesearchview = (SimpleSearchView)ActionBarHelperBase.b(b).inflate(com.helpshift.b.d.n, null);
                        simplesearchview.setId(i1);
                        e1.setActionView(simplesearchview);
                    }
                    if (ActionBarHelperBase.c(b).containsKey(Integer.valueOf(e1.getItemId())))
                    {
                        View view = ActionBarHelperBase.b(b).inflate(((Integer)ActionBarHelperBase.c(b).get(Integer.valueOf(e1.getItemId()))).intValue(), null);
                        view.setId(i1);
                        e1.setActionView(view);
                    }
                }
                catch (ClassCastException classcastexception)
                {
                    com.helpshift.x.a(ActionBarHelperBase.c(), "ClassCastException on hardware menu button click", classcastexception);
                }
                l++;
            }
        }

        public a(Context context, MenuInflater menuinflater)
        {
            b = ActionBarHelperBase.this;
            super(context);
            a = menuinflater;
        }
    }


    private static final String c = com/helpshift/app/b.getName();
    protected boolean b;
    private Set d;
    private Map e;
    private Map f;
    private Map g;
    private Map h;
    private LayoutInflater i;
    private boolean j;
    private boolean k;

    public ActionBarHelperBase(Activity activity)
    {
        super(activity);
        d = new HashSet();
        e = new HashMap();
        f = new HashMap();
        g = new HashMap();
        h = new HashMap();
        j = false;
        k = false;
        b = false;
    }

    static Map a(ActionBarHelperBase actionbarhelperbase)
    {
        return actionbarhelperbase.e;
    }

    private void a(ViewGroup viewgroup)
    {
        int l = com.helpshift.b.b.a;
        int i1 = com.helpshift.b.b.b;
        ProgressBar progressbar = new ProgressBar(a, null, com.helpshift.b.a.b);
        l = a.getResources().getDimensionPixelSize(l);
        i1 = a.getResources().getDimensionPixelSize(i1);
        int j1 = l / 2;
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(j1, j1);
        layoutparams.setMargins((l - j1) / 2, (i1 - j1) / 2, (l - j1) / 2, 0);
        progressbar.setLayoutParams(layoutparams);
        if (k)
        {
            progressbar.setVisibility(0);
        } else
        {
            progressbar.setVisibility(8);
        }
        progressbar.setId(com.helpshift.b.c.I);
        viewgroup.addView(progressbar);
    }

    private void a(ViewGroup viewgroup, MenuItem menuitem)
    {
        HomeView homeview = (HomeView)i.inflate(com.helpshift.b.d.l, viewgroup, false);
        if (homeview == null)
        {
            return;
        } else
        {
            homeview.setOnClickListener(new android.view.View.OnClickListener(menuitem) {

                final MenuItem a;
                final ActionBarHelperBase b;

                public void onClick(View view)
                {
                    if (b.b)
                    {
                        b.a(null);
                        return;
                    } else
                    {
                        b.a.onMenuItemSelected(0, a);
                        return;
                    }
                }

            
            {
                b = ActionBarHelperBase.this;
                a = menuitem;
                super();
            }
            });
            homeview.setClickable(true);
            homeview.setFocusable(true);
            homeview.setIcon(menuitem.getIcon());
            viewgroup.addView(homeview);
            return;
        }
    }

    static LayoutInflater b(ActionBarHelperBase actionbarhelperbase)
    {
        return actionbarhelperbase.i;
    }

    private void b(ViewGroup viewgroup, MenuItem menuitem)
    {
        int l = (int)a.getResources().getDimension(com.helpshift.b.b.a);
        ImageButton imagebutton = new ImageButton(a, null, com.helpshift.b.a.a);
        imagebutton.setLayoutParams(new android.view.ViewGroup.LayoutParams(l, -1));
        imagebutton.setImageDrawable(menuitem.getIcon());
        imagebutton.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        imagebutton.setContentDescription(menuitem.getTitle());
        imagebutton.setOnClickListener(new android.view.View.OnClickListener(menuitem) {

            final MenuItem a;
            final ActionBarHelperBase b;

            public void onClick(View view)
            {
                b.a.onMenuItemSelected(0, a);
            }

            
            {
                b = ActionBarHelperBase.this;
                a = menuitem;
                super();
            }
        });
        viewgroup.addView(imagebutton);
        ((e)menuitem).a(new com.helpshift.j.c.b(imagebutton) {

            final ImageButton a;
            final ActionBarHelperBase b;

            public void a(boolean flag)
            {
                if (flag)
                {
                    a.setVisibility(0);
                    return;
                } else
                {
                    a.setVisibility(8);
                    return;
                }
            }

            
            {
                b = ActionBarHelperBase.this;
                a = imagebutton;
                super();
            }
        });
    }

    static String c()
    {
        return c;
    }

    static Map c(ActionBarHelperBase actionbarhelperbase)
    {
        return actionbarhelperbase.f;
    }

    static Set d(ActionBarHelperBase actionbarhelperbase)
    {
        return actionbarhelperbase.d;
    }

    private void d()
    {
        ViewGroup viewgroup = a();
        if (viewgroup == null)
        {
            return;
        } else
        {
            ApplicationInfo applicationinfo = a.getApplicationInfo();
            d d1 = new d(a);
            Object obj = new e(d1, 0x102002c, 0, applicationinfo.name);
            ((e) (obj)).setIcon(x.a(a));
            d(((MenuItem) (obj)));
            obj = new android.widget.LinearLayout.LayoutParams(0, -1);
            obj.weight = 1.0F;
            TextView textview = new TextView(a, null, com.helpshift.b.a.c);
            textview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            textview.setText(a.getTitle());
            textview.setId(0x1020016);
            viewgroup.addView(textview);
            d(((MenuItem) (new e(d1, 0x102000d, 0, applicationinfo.name))));
            j = true;
            return;
        }
    }

    private void d(MenuItem menuitem)
    {
        ViewGroup viewgroup = a();
        if (viewgroup == null)
        {
            return;
        }
        View view = ((e)menuitem).getActionView();
        if (view != null)
        {
            viewgroup.addView(view);
            return;
        }
        switch (menuitem.getItemId())
        {
        default:
            b(viewgroup, menuitem);
            return;

        case 16908332: 
            a(viewgroup, menuitem);
            return;

        case 16908301: 
            a(viewgroup);
            return;
        }
    }

    private void e(MenuItem menuitem)
    {
        int l = menuitem.getItemId();
        menuitem = a().findViewById(0x1020016);
        View view = a().findViewById(com.helpshift.b.c.a);
        if (h.containsKey(Integer.valueOf(l)) && l == com.helpshift.b.c.m)
        {
            com.helpshift.j.c.a a1 = (com.helpshift.j.c.a)h.get(Integer.valueOf(l));
            ((SimpleSearchView)a().findViewById(com.helpshift.b.c.m)).setOnActionExpandListener(new android.support.v4.view.q.e(menuitem, view, a1) {

                final View a;
                final View b;
                final com.helpshift.j.c.a c;
                final ActionBarHelperBase d;

                public boolean a(MenuItem menuitem1)
                {
                    a.setVisibility(8);
                    if (b != null)
                    {
                        b.setVisibility(8);
                    }
                    d.b = true;
                    return c.e();
                }

                public boolean b(MenuItem menuitem1)
                {
                    a.setVisibility(0);
                    if (b != null)
                    {
                        b.setVisibility(0);
                    }
                    d.b = false;
                    return c.f();
                }

            
            {
                d = ActionBarHelperBase.this;
                a = view;
                b = view1;
                c = a1;
                super();
            }
            });
        }
    }

    private void f(MenuItem menuitem)
    {
        int l = menuitem.getItemId();
        if (g.containsKey(Integer.valueOf(l)) && l == com.helpshift.b.c.m)
        {
            menuitem = (com.helpshift.j.c.c)g.get(Integer.valueOf(l));
            ((SimpleSearchView)a().findViewById(com.helpshift.b.c.m)).setQueryTextListener(new android.support.v4.widget.s.a(menuitem) {

                final com.helpshift.j.c.c b;
                final ActionBarHelperBase c;

                public boolean a(String s)
                {
                    return b.b(s);
                }

                public boolean b(String s)
                {
                    return b.c(s);
                }

            
            {
                c = ActionBarHelperBase.this;
                b = c1;
                super();
            }
            });
        }
    }

    public MenuInflater a(MenuInflater menuinflater)
    {
        return new a(a, menuinflater);
    }

    public ViewGroup a()
    {
        return (ViewGroup)a.findViewById(com.helpshift.b.c.J);
    }

    public void a(int l)
    {
    }

    public void a(Bundle bundle)
    {
        a.requestWindowFeature(7);
        i = (LayoutInflater)a.getSystemService("layout_inflater");
    }

    public void a(MenuItem menuitem)
    {
        ((SimpleSearchView)a().findViewById(com.helpshift.b.c.m)).a();
    }

    public void a(MenuItem menuitem, com.helpshift.j.c.a a1)
    {
        h.put(Integer.valueOf(menuitem.getItemId()), a1);
    }

    public void a(MenuItem menuitem, com.helpshift.j.c.c c1)
    {
        g.put(Integer.valueOf(menuitem.getItemId()), c1);
    }

    public void a(String s)
    {
        a.setTitle(s);
        if (j)
        {
            TextView textview = (TextView)a().findViewById(0x1020016);
            if (textview != null)
            {
                textview.setText(s);
            }
        }
    }

    public void a(boolean flag)
    {
    }

    public String b(MenuItem menuitem)
    {
        int l = menuitem.getItemId();
        menuitem = "";
        if (l == com.helpshift.b.c.m)
        {
            menuitem = ((SimpleSearchView)a().findViewById(com.helpshift.b.c.m)).getQuery();
        }
        return menuitem;
    }

    public void b(int l)
    {
    }

    public void b(Bundle bundle)
    {
        boolean flag = false;
        super.b(bundle);
        a.getWindow().setFeatureInt(7, com.helpshift.b.d.m);
        d();
        bundle = new d(a);
        a.onCreatePanelMenu(0, bundle);
        a.onPrepareOptionsMenu(bundle);
        int l = 0;
        int i1;
        do
        {
            i1 = ((flag) ? 1 : 0);
            if (l >= bundle.size())
            {
                break;
            }
            MenuItem menuitem = bundle.getItem(l);
            if (d.contains(Integer.valueOf(menuitem.getItemId())))
            {
                d(menuitem);
            }
            l++;
        } while (true);
        for (; i1 < bundle.size(); i1++)
        {
            MenuItem menuitem1 = bundle.getItem(i1);
            if (d.contains(Integer.valueOf(menuitem1.getItemId())))
            {
                f(menuitem1);
                e(menuitem1);
            }
        }

    }

    public void b(boolean flag)
    {
        if (j)
        {
            View view = a().findViewById(com.helpshift.b.c.I);
            if (flag)
            {
                view.setVisibility(0);
            } else
            {
                view.setVisibility(8);
            }
        }
        k = flag;
    }

    protected boolean b()
    {
        return b;
    }

    public void c(MenuItem menuitem)
    {
        if (menuitem.getItemId() == com.helpshift.b.c.m)
        {
            ((SimpleSearchView)a().findViewById(com.helpshift.b.c.m)).clearFocus();
        }
    }

}
