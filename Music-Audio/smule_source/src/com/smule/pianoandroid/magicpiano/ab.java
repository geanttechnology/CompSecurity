// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.smule.android.c.aa;
import com.smule.android.console.DebugConsoleActivity;
import com.smule.android.network.managers.UserManager;
import com.smule.magicpiano.h;
import com.smule.pianoandroid.utils.o;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            au, z, ac, aa, 
//            DailyChallengeActivity, ProductListActivity, GameStatsActivity, SoloActivity, 
//            GlobeActivity, SettingsActivity, PianoWebActivity, MagicApplication

public class ab extends LinearLayout
    implements au
{

    private static final String d = com/smule/pianoandroid/magicpiano/ab.getName();
    protected FrameLayout a;
    protected ListView b;
    protected DrawerLayout c;
    private Activity e;
    private Boolean f;
    private ActionBarDrawerToggle g;
    private Boolean h;
    private Boolean i;
    private z j;
    private Observer k = new Observer() {

        final ab a;

        public void update(Observable observable, Object obj)
        {
            ab.a(a).runOnUiThread(new Runnable(this) {

                final _cls1 a;

                public void run()
                {
                    a.a.f();
                    a.a.b();
                }

            
            {
                a = _pcls1;
                super();
            }
            });
        }

            
            {
                a = ab.this;
                super();
            }
    };
    private Observer l = new Observer() {

        final ab a;

        public void update(Observable observable, Object obj)
        {
            a.b();
        }

            
            {
                a = ab.this;
                super();
            }
    };

    public ab(Context context)
    {
        super(context);
        f = Boolean.valueOf(false);
        h = Boolean.valueOf(true);
        i = Boolean.valueOf(false);
        j = new z();
        LayoutInflater.from(context).inflate(0x7f030047, this);
        a = (FrameLayout)findViewById(0x7f0a016d);
        e = (Activity)context;
    }

    public ab(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = Boolean.valueOf(false);
        h = Boolean.valueOf(true);
        i = Boolean.valueOf(false);
        j = new z();
        LayoutInflater.from(context).inflate(0x7f030047, this);
        a = (FrameLayout)findViewById(0x7f0a016d);
        e = (Activity)context;
        a(context, attributeset);
    }

    public ab(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        f = Boolean.valueOf(false);
        h = Boolean.valueOf(true);
        i = Boolean.valueOf(false);
        j = new z();
        LayoutInflater.from(context).inflate(0x7f030047, this);
        a = (FrameLayout)findViewById(0x7f0a016d);
        e = (Activity)context;
        a(context, attributeset);
    }

    static Activity a(ab ab1)
    {
        return ab1.e;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, h.NavBarView);
        h = Boolean.valueOf(context.getBoolean(1, true));
        i = Boolean.valueOf(context.getBoolean(0, false));
        context.recycle();
    }

    static Boolean b(ab ab1)
    {
        return ab1.f;
    }

    static String h()
    {
        return d;
    }

    private Drawable i()
    {
        int i1 = ac.a().b();
        if (i1 > 0)
        {
            Drawable drawable = e.getResources().getDrawable(0x7f02004a);
            if (drawable == null)
            {
                aa.b(d, "Error finding base notificationsDrawable resource");
                return e.getResources().getDrawable(0x7f02012b);
            } else
            {
                float f1 = TypedValue.applyDimension(2, 8F, getResources().getDisplayMetrics());
                LayerDrawable layerdrawable = (LayerDrawable)drawable;
                String s = Integer.toString(i1);
                layerdrawable.setDrawableByLayerId(0x7f0a024b, new com.smule.pianoandroid.utils.h(f1, new Drawable[0], s));
                return drawable;
            }
        } else
        {
            return e.getResources().getDrawable(0x7f02012b);
        }
    }

    public void a()
    {
        if (h.booleanValue())
        {
            g();
        }
    }

    public boolean a(MenuItem menuitem)
    {
        return g.onOptionsItemSelected(menuitem);
    }

    public void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (a == null)
        {
            super.addView(view, i1, layoutparams);
            return;
        } else
        {
            a.addView(view, i1, layoutparams);
            return;
        }
    }

    protected void b()
    {
        Object obj;
        ArrayList arraylist;
        String s;
        int i1;
        boolean flag;
        if (!UserManager.n().h())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = Boolean.valueOf(flag);
        arraylist = new ArrayList();
        if (f.booleanValue())
        {
            obj = getResources().getString(0x7f0c016d);
        } else
        {
            obj = UserManager.n().e();
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(((String) (obj)), 0x7f020152, Boolean.valueOf(false)));
        s = getResources().getString(0x7f0c00bc);
        if (e instanceof DailyChallengeActivity)
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f0200ff;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f0200fc;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(s, i1, ((Boolean) (obj)), ac.a().a("NOTIFICATION_CHALLENGE")));
        s = getResources().getString(0x7f0c026b);
        if (e instanceof ProductListActivity)
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f020190;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f02018f;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(s, i1, ((Boolean) (obj))));
        s = getResources().getString(0x7f0c001d);
        if (e instanceof GameStatsActivity)
        {
            i1 = 0x7f020047;
            obj = Boolean.valueOf(true);
        } else
        {
            i1 = 0x7f020044;
            obj = Boolean.valueOf(false);
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(s, i1, ((Boolean) (obj)), ac.a().a("NOTIFICATION_ACHIEVEMENTS")));
        s = getResources().getString(0x7f0c026a);
        if (e instanceof SoloActivity)
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f02018e;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f02018d;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(s, i1, ((Boolean) (obj))));
        s = getResources().getString(0x7f0c02e1);
        if (e instanceof GlobeActivity)
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f0200d6;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f0200d5;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(s, i1, ((Boolean) (obj))));
        s = getResources().getString(0x7f0c024a);
        if (e instanceof SettingsActivity)
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f020185;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f020184;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(s, i1, ((Boolean) (obj))));
        if ((e instanceof PianoWebActivity) && ((PianoWebActivity)e).f().booleanValue())
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f020107;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f020106;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(getResources().getString(0x7f0c0260), i1, ((Boolean) (obj))));
        if ((e instanceof PianoWebActivity) && ((PianoWebActivity)e).e().booleanValue())
        {
            obj = Boolean.valueOf(true);
            i1 = 0x7f0200df;
        } else
        {
            obj = Boolean.valueOf(false);
            i1 = 0x7f0200de;
        }
        arraylist.add(new com.smule.pianoandroid.magicpiano.aa(getResources().getString(0x7f0c013c), i1, ((Boolean) (obj))));
        if (MagicApplication.isDebug().booleanValue())
        {
            arraylist.add(new com.smule.pianoandroid.magicpiano.aa(getResources().getString(0x7f0c00b2), 0x7f020092, Boolean.valueOf(false)));
        }
        j.a(arraylist);
        b.setAdapter(j);
    }

    public void c()
    {
        b();
    }

    protected void d()
    {
        aa.a(d, "Setting action bar");
        ActionBar actionbar = e.getActionBar();
        if (actionbar != null)
        {
            actionbar.setDisplayShowHomeEnabled(true);
            actionbar.setHomeButtonEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setDisplayShowCustomEnabled(true);
            actionbar.setDisplayShowTitleEnabled(false);
            if (!i.booleanValue())
            {
                String s = e.getTitle().toString();
                View view = ((LayoutInflater)e.getSystemService("layout_inflater")).inflate(0x7f030000, null);
                ((TextView)view.findViewById(0x7f0a0037)).setText(s);
                actionbar.setCustomView(view);
            }
            actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f020002));
            f();
            if (h.booleanValue())
            {
                b();
            }
            actionbar.show();
        }
        g = new ActionBarDrawerToggle(e, c, 0x7f0200e0, 0x7f0c00df, 0x7f0c00de) {

            final ab a;

            public void onDrawerClosed(View view1)
            {
                super.onDrawerClosed(view1);
                ab.a(a).invalidateOptionsMenu();
            }

            public void onDrawerOpened(View view1)
            {
                if (ab.b(a).booleanValue() && UserManager.n().h())
                {
                    a.b();
                }
                super.onDrawerOpened(view1);
                ab.a(a).invalidateOptionsMenu();
            }

            
            {
                a = ab.this;
                super(activity, drawerlayout, i1, j1, k1);
            }
        };
        c.setDrawerListener(g);
        if (e instanceof SettingsActivity)
        {
            ((SettingsActivity)e).a = this;
        }
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ab a;

            public void onItemClick(AdapterView adapterview, View view1, int i1, long l1)
            {
                if (i1 != 0) goto _L2; else goto _L1
_L1:
                if (!ab.b(a).booleanValue()) goto _L4; else goto _L3
_L3:
                o.a(ab.a(a), new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        o.e(ab.a(a.a));
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
_L6:
                a.b.setItemChecked(i1, true);
                a.c.closeDrawer(0x800003);
                return;
_L4:
                if (!(ab.a(a) instanceof SettingsActivity))
                {
                    adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/SettingsActivity);
                    adapterview.putExtra("settings.show_handle", Boolean.TRUE);
                    ab.a(a).startActivity(adapterview);
                    ab.a(a).finish();
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (i1 == 1)
                {
                    if (!(ab.a(a) instanceof DailyChallengeActivity))
                    {
                        adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
                        ab.a(a).startActivity(adapterview);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 2)
                {
                    if (!(ab.a(a) instanceof ProductListActivity))
                    {
                        adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/ProductListActivity);
                        ab.a(a).startActivity(adapterview);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 3)
                {
                    if (!(ab.a(a) instanceof GameStatsActivity))
                    {
                        adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/GameStatsActivity);
                        ab.a(a).startActivity(adapterview);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 4)
                {
                    if (!(ab.a(a) instanceof SoloActivity))
                    {
                        adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/SoloActivity);
                        ab.a(a).startActivity(adapterview);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 5)
                {
                    if (!(ab.a(a) instanceof GlobeActivity))
                    {
                        o.d(ab.a(a));
                    }
                } else
                if (i1 == 6)
                {
                    if (!(ab.a(a) instanceof SettingsActivity))
                    {
                        adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/SettingsActivity);
                        ab.a(a).startActivity(adapterview);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 7)
                {
                    if ((ab.a(a) instanceof PianoWebActivity) && ((PianoWebActivity)ab.a(a)).f().booleanValue())
                    {
                        adapterview = Boolean.valueOf(false);
                    } else
                    {
                        adapterview = Boolean.valueOf(true);
                    }
                    if (adapterview.booleanValue())
                    {
                        PianoWebActivity.a(ab.a(a), com.smule.pianoandroid.magicpiano.PianoWebActivity.h);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 8)
                {
                    if ((ab.a(a) instanceof PianoWebActivity) && ((PianoWebActivity)ab.a(a)).e().booleanValue())
                    {
                        adapterview = Boolean.valueOf(false);
                    } else
                    {
                        adapterview = Boolean.valueOf(true);
                    }
                    if (adapterview.booleanValue())
                    {
                        PianoWebActivity.a(ab.a(a), PianoWebActivity.e);
                        ab.a(a).finish();
                    }
                } else
                if (i1 == 9)
                {
                    adapterview = new Intent(ab.a(a), com/smule/android/console/DebugConsoleActivity);
                    ab.a(a).startActivity(adapterview);
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = ab.this;
                super();
            }
        });
        com.smule.android.f.h.a().a("BADGE_NOTIFICATION", k);
        com.smule.android.f.h.a().a("IMAGE_UPDATED", l);
    }

    public void e()
    {
        com.smule.android.f.h.a().b("BADGE_NOTIFICATION", k);
        com.smule.android.f.h.a().b("IMAGE_UPDATED", l);
    }

    public void f()
    {
        ActionBar actionbar = e.getActionBar();
        if (actionbar != null)
        {
            actionbar.setIcon(i());
        }
    }

    public void g()
    {
        g.syncState();
    }

    public void setTitle(String s)
    {
        Object obj = e.getActionBar();
        if (obj != null)
        {
            obj = ((ActionBar) (obj)).getCustomView();
            if (obj != null)
            {
                ((TextView)((View) (obj)).findViewById(0x7f0a0037)).setText(s);
            }
        }
    }

}
