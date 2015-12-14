// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.View;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.picsart.profile.adapter.bf;
import com.socialin.android.picsart.profile.fragment.o;
import com.socialin.android.picsart.profile.fragment.p;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ContestRulesActivity

public class ContestItemsActivity extends ContestRulesActivity
{

    public bf a;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private List i;
    private FragmentManager j;
    private ViewPager k;
    private View l;
    private View m;
    private SlidingTabLayout n;
    private boolean o;

    public ContestItemsActivity()
    {
        f = 1;
        g = 0;
        i = new ArrayList();
    }

    static int a(ContestItemsActivity contestitemsactivity)
    {
        return contestitemsactivity.h;
    }

    static int a(ContestItemsActivity contestitemsactivity, int i1)
    {
        contestitemsactivity.h = i1;
        return i1;
    }

    private static String a(String s)
    {
        return (new StringBuilder("contestItemsFragmentTag_")).append(s.trim()).toString();
    }

    private void a()
    {
        if (k != null)
        {
            k.removeAllViews();
            k.removeAllViewsInLayout();
        }
        if (a != null)
        {
            a.a.clear();
        }
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().removeAllTabs();
        }
        if (i != null)
        {
            i.clear();
        }
        if (g == 0)
        {
            if (f == 2)
            {
                AppProps appprops = SocialinV3.getInstance().getAppProps();
                Object obj;
                if (appprops != null)
                {
                    obj = appprops.getContestNewSystemTabs();
                } else
                {
                    obj = new ArrayList();
                }
                if (obj == null || ((List) (obj)).isEmpty())
                {
                    obj = new ArrayList();
                    ((List) (obj)).add(appprops.createTab(false, false, false, getString(0x7f08031d), "editor"));
                    ((List) (obj)).add(appprops.createTab(false, false, false, getString(0x7f080304), "submissions"));
                }
                i.clear();
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    com.socialin.android.apiv3.model.AppProps.ContestTab contesttab = (com.socialin.android.apiv3.model.AppProps.ContestTab)((Iterator) (obj)).next();
                    if (e || !contesttab.hideAfterSubmit)
                    {
                        i.add(contesttab);
                    }
                } while (true);
                if (!SocialinV3.getInstance().isRegistered() || !e)
                {
                    List list = b();
                    i.removeAll(list);
                }
                if (i.size() == 1)
                {
                    a(((com.socialin.android.apiv3.model.AppProps.ContestTab)i.get(0)).order, ((com.socialin.android.apiv3.model.AppProps.ContestTab)i.get(0)).isVoting);
                    return;
                } else
                {
                    d();
                    return;
                }
            } else
            {
                c();
                return;
            }
        } else
        {
            a("participants", false);
            return;
        }
    }

    private void a(String s, boolean flag)
    {
        k.setVisibility(8);
        n.setVisibility(8);
        l.setVisibility(0);
        m.setVisibility(0);
        String s1 = s;
        if (s == null)
        {
            s1 = "participants";
        }
        s = j.beginTransaction();
        Fragment fragment = j.findFragmentByTag(a(s1));
        if (fragment != null && fragment.isAdded())
        {
            s.show(fragment);
        } else
        {
            o o1 = new o();
            o1.setArguments(com.socialin.android.picsart.profile.fragment.o.a(s1, e, flag));
            s.add(0x7f10091f, o1, a(s1));
        }
        s.commit();
    }

    private List b()
    {
        ArrayList arraylist = new ArrayList();
        if (!SocialinV3.getInstance().isRegistered())
        {
            Iterator iterator = i.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.socialin.android.apiv3.model.AppProps.ContestTab contesttab = (com.socialin.android.apiv3.model.AppProps.ContestTab)iterator.next();
                if ("submissions".equals(contesttab.order))
                {
                    arraylist.add(contesttab);
                }
            } while (true);
        }
        return arraylist;
    }

    static List b(ContestItemsActivity contestitemsactivity)
    {
        return contestitemsactivity.i;
    }

    private void c()
    {
        Object obj;
        Object obj1;
        obj1 = SocialinV3.getInstance().getAppProps();
        obj = new ArrayList();
        if (g != 0) goto _L2; else goto _L1
_L1:
label0:
        {
            if (obj1 != null)
            {
                obj = ((AppProps) (obj1)).getContestTabs();
            }
            if (obj != null)
            {
                obj1 = obj;
                if (!((List) (obj)).isEmpty())
                {
                    break label0;
                }
            }
            obj1 = new ArrayList();
            obj = SocialinV3.getInstance().getAppProps();
            ((List) (obj1)).add(((AppProps) (obj)).createTab(true, false, false, getString(0x7f08035b), "trending"));
            ((List) (obj1)).add(((AppProps) (obj)).createTab(true, false, false, getString(0x7f08032f), "recent"));
            ((List) (obj1)).add(((AppProps) (obj)).createTab(false, false, false, getString(0x7f080359), "top"));
            if (SocialinV3.getInstance().isRegistered())
            {
                ((List) (obj1)).add(((AppProps) (obj)).createTab(false, false, false, getString(0x7f080304), "submissions"));
            }
        }
_L4:
        i.clear();
        obj = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj1 = (com.socialin.android.apiv3.model.AppProps.ContestTab)((Iterator) (obj)).next();
            if (e || !((com.socialin.android.apiv3.model.AppProps.ContestTab) (obj1)).hideAfterSubmit)
            {
                i.add(obj1);
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        ((List) (obj)).add(((AppProps) (obj1)).createTab(false, false, false, getString(0x7f0802ca), "top"));
        ((List) (obj)).add(((AppProps) (obj1)).createTab(false, false, false, getString(0x7f08031d), "participants"));
        obj1 = obj;
        if (true) goto _L4; else goto _L3
_L3:
        d();
        return;
    }

    private void d()
    {
        int j1;
        if (e)
        {
            Iterator iterator = i.iterator();
            int i1 = 0;
            do
            {
                j1 = i1;
                if (!iterator.hasNext())
                {
                    break;
                }
                com.socialin.android.apiv3.model.AppProps.ContestTab contesttab = (com.socialin.android.apiv3.model.AppProps.ContestTab)iterator.next();
                if ("submissions".equals(contesttab.order) && !SocialinV3.getInstance().isRegistered() || contesttab.hideBeforeVoting)
                {
                    i1++;
                }
            } while (true);
        } else
        {
            j1 = 0;
        }
        if (j1 == i.size())
        {
            Utils.c(this, getString(0x7f0800ec));
            finish();
            return;
        }
        k.setVisibility(0);
        l.setVisibility(8);
        m.setVisibility(8);
        n.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            private ContestItemsActivity a;

            public final void onPageSelected(int k1)
            {
                super.onPageSelected(k1);
                ContestItemsActivity.a(a, k1);
                a.getIntent().putExtra("contestItemsOrder", ((com.socialin.android.apiv3.model.AppProps.ContestTab)ContestItemsActivity.b(a).get(ContestItemsActivity.a(a))).order);
            }

            
            {
                a = ContestItemsActivity.this;
                super();
            }
        });
        a = new bf(this, j);
        Iterator iterator1 = i.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            com.socialin.android.apiv3.model.AppProps.ContestTab contesttab1 = (com.socialin.android.apiv3.model.AppProps.ContestTab)iterator1.next();
            boolean flag1 = "submissions".equals(contesttab1.order);
            if (!flag1 || SocialinV3.getInstance().isRegistered())
            {
                boolean flag;
                if (!e || !contesttab1.hideBeforeVoting)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag1)
                {
                    a.a(contesttab1.title.toUpperCase(), com/socialin/android/picsart/profile/fragment/p, p.a(e), 0x7f100087);
                } else
                if (flag)
                {
                    a.a(contesttab1.title.toUpperCase(), com/socialin/android/picsart/profile/fragment/o, com.socialin.android.picsart.profile.fragment.o.a(contesttab1.order, e, contesttab1.isVoting), 0x7f100091);
                }
            }
        } while (true);
        k.setAdapter(a);
        k.setCurrentItem(h);
        n.setViewPager(k);
        n.a(h).setSelected(true);
        getIntent().putExtra("contestItemsOrder", ((com.socialin.android.apiv3.model.AppProps.ContestTab)i.get(h)).order);
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag = false;
        super.onCreate(bundle);
        setContentView(0x7f0301fd);
        Object obj = getIntent();
        if (obj != null)
        {
            if (((Intent) (obj)).hasExtra("contestName"))
            {
                b = ((Intent) (obj)).getStringExtra("contestName");
            }
            Object obj1;
            if (((Intent) (obj)).hasExtra("contestType"))
            {
                g = ((Intent) (obj)).getIntExtra("contestType", g);
            } else
            if (((Intent) (obj)).getIntExtra("till_end", 0) > 0)
            {
                g = 0;
            }
            if (((Intent) (obj)).hasExtra("isSubmitAvailable"))
            {
                flag = ((Intent) (obj)).getBooleanExtra("isSubmitAvailable", true);
            } else
            {
                int i1 = ((Intent) (obj)).getIntExtra("tillSubmit", 0);
                if (g == 0 && i1 != 0)
                {
                    flag = true;
                }
            }
            e = flag;
            if (((Intent) (obj)).hasExtra("contestSystemType"))
            {
                f = ((Intent) (obj)).getIntExtra("contestSystemType", 1);
            }
            c = ((Intent) (obj)).getStringExtra("contest.name.prefix");
        }
        obj1 = b;
        obj = obj1;
        if (!TextUtils.isEmpty(b))
        {
            obj = obj1;
            if (b.startsWith(c))
            {
                obj = b.replace(c, c.toUpperCase());
                super.d = (new StringBuilder("http://picsart.com/")).append(c).append("rules").toString();
            }
        }
        obj1 = getSupportActionBar();
        if (obj1 != null)
        {
            ((ActionBar) (obj1)).setDisplayHomeAsUpEnabled(true);
            ((ActionBar) (obj1)).setDisplayShowHomeEnabled(true);
            ((ActionBar) (obj1)).setIcon(getResources().getDrawable(0x7f020404));
            ((ActionBar) (obj1)).setTitle(((CharSequence) (obj)));
        }
        k = (ViewPager)findViewById(0x7f100920);
        l = findViewById(0x7f10091f);
        m = findViewById(0x7f100505);
        n = (SlidingTabLayout)findViewById(0x7f10068c);
        j = getFragmentManager();
        if (bundle != null)
        {
            h = bundle.getInt("selected_tab");
        }
        a();
        o = SocialinV3.getInstance().isRegistered();
    }

    protected void onResume()
    {
        super.onResume();
        if (SocialinV3.getInstance().isRegistered() != o)
        {
            a();
        }
        o = SocialinV3.getInstance().isRegistered();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("selected_tab", h);
        super.onSaveInstanceState(bundle);
    }
}
