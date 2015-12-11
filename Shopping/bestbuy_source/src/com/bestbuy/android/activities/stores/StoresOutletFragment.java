// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kb;
import kf;
import kt;
import ku;
import mw;
import mx;
import my;
import nb;
import nc;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreDetailsFragment

public class StoresOutletFragment extends BBYBaseFragment
{

    private static final String a = com/bestbuy/android/activities/stores/StoresOutletFragment.getSimpleName();
    private Fragment b;
    private boolean c;
    private String g;
    private String h;
    private View i;
    private LayoutInflater j;
    private LinearLayout k;

    public StoresOutletFragment()
    {
        c = false;
    }

    public StoresOutletFragment(boolean flag, String s, String s1)
    {
        c = false;
        c = flag;
        g = s;
        h = s1;
    }

    static void a(StoresOutletFragment storesoutletfragment, String s, String s1, String s2)
    {
        storesoutletfragment.a(s, s1, s2);
    }

    private void a(String s, String s1, String s2)
    {
        if (s1.equals(getString(0x7f08006c)) || s1.equals(getString(0x7f08012a)))
        {
            s2 = null;
            Fragment fragment = getParentFragment();
            if (fragment instanceof StoreDetailsFragment)
            {
                s2 = ((StoreDetailsFragment)fragment).c();
            }
            s = kb.a(s, s1, s2);
            ((BaseTabContainer)fragment.getParentFragment()).a(s, true);
        } else
        if (s1.equals(getString(0x7f08008d)))
        {
            s = nb.a().c();
            if (!s.getBoolean(d.getResources().getString(0x7f08008a), false) && !s.getBoolean(d.getString(0x7f08004d), false))
            {
                int l = s.getInt(d.getString(0x7f080087), 1);
                Bundle bundle;
                if (l >= 10)
                {
                    (new kt(d, ku.b)).a();
                } else
                {
                    s = s.edit();
                    s.putInt(d.getString(0x7f080087), l + 1);
                    s.commit();
                }
            }
            s1 = kb.a("MdotWebFragment");
            bundle = new Bundle();
            s = s2;
            if (h != null)
            {
                s = s2;
                if (!h.isEmpty())
                {
                    s = (new StringBuilder()).append(s2).append("/stores?storeID=").append(h).toString();
                }
            }
            bundle.putString("mDotURL", s);
            s1.setArguments(bundle);
            ((BaseTabContainer)b.getParentFragment()).a(s1, true);
            return;
        }
    }

    private void a(my my1)
    {
        if (my1 != null)
        {
            int l = 0;
            do
            {
                if (l >= my1.a().size())
                {
                    break;
                }
                for (Iterator iterator = ((mx)my1.a().get(l)).b().iterator(); iterator.hasNext();)
                {
                    Object obj = (mw)iterator.next();
                    if (!((mw) (obj)).i().equals(getString(0x7f080077)) && !((mw) (obj)).i().equals("Pre-Owned"))
                    {
                        Object obj1 = (LinearLayout)j.inflate(0x7f030109, k, false);
                        Object obj2 = (ImageView)((LinearLayout) (obj1)).findViewById(0x7f0c03e0);
                        BBYTextView bbytextview = (BBYTextView)((LinearLayout) (obj1)).findViewById(0x7f0c03e1);
                        ((ImageView) (obj2)).setBackgroundResource(getResources().getIdentifier(((mw) (obj)).c(), "drawable", i.getContext().getPackageName()));
                        bbytextview.setText(((mw) (obj)).d());
                        obj2 = (BBYTextView)((LinearLayout) (obj1)).findViewById(0x7f0c03e2);
                        if (((mw) (obj)).i().equals(getString(0x7f08012a)))
                        {
                            ((BBYTextView) (obj2)).setText(getResources().getString(0x7f08034c));
                        } else
                        if (((mw) (obj)).i().equals(getString(0x7f08006c)))
                        {
                            ((BBYTextView) (obj2)).setText(getResources().getString(0x7f08034f));
                        } else
                        if (((mw) (obj)).i().equals("Pre-Owned"))
                        {
                            ((BBYTextView) (obj2)).setText(getResources().getString(0x7f080350));
                        } else
                        if (((mw) (obj)).i().equals(getString(0x7f080077)))
                        {
                            ((BBYTextView) (obj2)).setText(getResources().getString(0x7f080351));
                        } else
                        if (((mw) (obj)).i().equals(getString(0x7f08008d)))
                        {
                            ((BBYTextView) (obj2)).setText(getResources().getString(0x7f080353));
                        }
                        k.addView(((View) (obj1)));
                        ((LinearLayout) (obj1)).setOnClickListener(new android.view.View.OnClickListener(((mw) (obj))) {

                            final mw a;
                            final StoresOutletFragment b;

                            public void onClick(View view)
                            {
                                view = a.e();
                                StoresOutletFragment.a(b, view, a.i(), a.f());
                            }

            
            {
                b = StoresOutletFragment.this;
                a = mw1;
                super();
            }
                        });
                        obj = new View(i.getContext());
                        obj1 = new android.widget.RelativeLayout.LayoutParams(-1, 1);
                        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(3, 0, 0, 0);
                        ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                        ((View) (obj)).setBackgroundColor(0x7f0b0008);
                        k.addView(((View) (obj)));
                    }
                }

                l++;
            } while (true);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        b = getParentFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        i = layoutinflater.inflate(0x7f030108, viewgroup, false);
        j = layoutinflater;
        k = (LinearLayout)i.findViewById(0x7f0c03df);
        if (g != null && !g.isEmpty())
        {
            ((BBYTextView)i.findViewById(0x7f0c011e)).setText(g);
        }
        layoutinflater = new nc();
        try
        {
            a(new my(layoutinflater.a(d, nb.e, nb.d[3]), "StoresOutletItems"));
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            kf.e(a, (new StringBuilder()).append("Error attempting to load & display deals cards: ").append(layoutinflater.getLocalizedMessage()).toString());
        }
        return i;
    }

}
