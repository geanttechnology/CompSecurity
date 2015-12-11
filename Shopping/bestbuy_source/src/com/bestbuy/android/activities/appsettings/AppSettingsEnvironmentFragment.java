// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fs;
import fu;
import fw;
import ga;
import gb;
import gd;
import ge;
import gg;
import gh;
import gk;
import gm;
import gn;
import gq;
import gr;
import java.util.ArrayList;
import java.util.Iterator;
import kf;
import ms;
import mt;
import na;
import nb;
import ni;

public class AppSettingsEnvironmentFragment extends BBYBaseFragment
{

    private Activity a;
    private LinearLayout b;
    private SharedPreferences c;
    private int g;

    public AppSettingsEnvironmentFragment()
    {
        g = -1;
    }

    static int a(AppSettingsEnvironmentFragment appsettingsenvironmentfragment)
    {
        return appsettingsenvironmentfragment.g;
    }

    static int a(AppSettingsEnvironmentFragment appsettingsenvironmentfragment, int i)
    {
        appsettingsenvironmentfragment.g = i;
        return i;
    }

    static Activity b(AppSettingsEnvironmentFragment appsettingsenvironmentfragment)
    {
        return appsettingsenvironmentfragment.a;
    }

    static SharedPreferences c(AppSettingsEnvironmentFragment appsettingsenvironmentfragment)
    {
        return appsettingsenvironmentfragment.c;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = nb.a().c();
        viewgroup = layoutinflater.inflate(0x7f030009, viewgroup, false);
        Object obj;
        obj = (new ms(ni.a(a.getAssets().open("envsettings.json")))).a();
        b = (LinearLayout)viewgroup.findViewById(0x7f0c004e);
        bundle = new android.widget.LinearLayout.LayoutParams(-1, -2);
        bundle.setMargins(0, 10, 0, 10);
        obj = ((ArrayList) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        mt mt1;
        View view;
        LinearLayout linearlayout;
        RadioButton aradiobutton[];
        RadioGroup radiogroup;
        mt1 = (mt)((Iterator) (obj)).next();
        view = layoutinflater.inflate(0x7f030029, null);
        view.setVisibility(8);
        view.findViewById(0x7f0c00af).setOnClickListener(new android.view.View.OnClickListener(view) {

            final View a;
            final AppSettingsEnvironmentFragment b;

            public void onClick(View view1)
            {
                EditText edittext;
                view1 = (EditText)a.findViewById(0x7f0c00ad);
                edittext = (EditText)a.findViewById(0x7f0c00ae);
                fs.a(view1.getText().toString(), edittext.getText().toString(), AppSettingsEnvironmentFragment.a(b));
                AppSettingsEnvironmentFragment.a(b);
                JVM INSTR tableswitch 0 11: default 120
            //                           0 145
            //                           1 156
            //                           2 167
            //                           3 120
            //                           4 120
            //                           5 200
            //                           6 120
            //                           7 120
            //                           8 178
            //                           9 189
            //                           10 222
            //                           11 211;
                   goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L1 _L1 _L6 _L7 _L8 _L9
_L1:
                ((InputMethodManager)AppSettingsEnvironmentFragment.b(b).getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
                return;
_L2:
                gm.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L3:
                gd.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L4:
                gg.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L6:
                fu.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L7:
                fw.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L5:
                gk.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L9:
                gq.a(fs.a("CUSTOM"));
                continue; /* Loop/switch isn't completed */
_L8:
                ga.a(fs.a("CUSTOM"));
                if (true) goto _L1; else goto _L10
_L10:
            }

            
            {
                b = AppSettingsEnvironmentFragment.this;
                a = view;
                super();
            }
        });
        linearlayout = new LinearLayout(a);
        linearlayout.setOrientation(1);
        linearlayout.setBackgroundColor(getResources().getColor(0x7f0b0063));
        linearlayout.setPadding(8, 8, 8, 8);
        linearlayout.setLayoutParams(bundle);
        BBYTextView bbytextview = new BBYTextView(a);
        bbytextview.setText(mt1.a());
        bbytextview.a(a, a.getResources().getString(0x7f080024), null);
        bbytextview.a(a, "AvenirNextforBestBuy-Regular", null);
        linearlayout.addView(bbytextview);
        aradiobutton = new RadioButton[mt1.b().size()];
        radiogroup = new RadioGroup(a);
        radiogroup.setOrientation(1);
        int i = 0;
_L4:
        if (i >= aradiobutton.length)
        {
            break; /* Loop/switch isn't completed */
        }
        aradiobutton[i] = new RadioButton(a);
        aradiobutton[i].setText((CharSequence)mt1.b().get(i));
        aradiobutton[i].setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener(mt1, i, view) {

            final mt a;
            final int b;
            final View c;
            final AppSettingsEnvironmentFragment d;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (!flag) goto _L2; else goto _L1
_L1:
                compoundbutton = AppSettingsEnvironmentFragment.c(d).edit();
                compoundbutton.putInt(a.a(), b);
                compoundbutton.commit();
                compoundbutton = (String)a.b().get(b);
                if (!a.a().equals("Offers")) goto _L4; else goto _L3
_L3:
                AppSettingsEnvironmentFragment.a(d, 0);
                if (!compoundbutton.equals("Custom")) goto _L6; else goto _L5
_L5:
                c.setVisibility(0);
                compoundbutton = gm.a();
                if (compoundbutton.compareTo(gn.c) == 0)
                {
                    ((EditText)c.findViewById(0x7f0c00ae)).setText(((gn) (compoundbutton)).e);
                    ((EditText)c.findViewById(0x7f0c00ad)).setText(((gn) (compoundbutton)).d);
                }
_L2:
                return;
_L6:
                c.setVisibility(8);
                gm.a(fs.a(compoundbutton));
                return;
_L4:
                if (!a.a().equals("CartManager"))
                {
                    break; /* Loop/switch isn't completed */
                }
                AppSettingsEnvironmentFragment.a(d, 10);
                if (compoundbutton.equals("Custom"))
                {
                    c.setVisibility(0);
                    compoundbutton = ga.a();
                    if (compoundbutton.compareTo(gb.f) == 0)
                    {
                        ((EditText)c.findViewById(0x7f0c00ad)).setText(((gb) (compoundbutton)).g);
                        return;
                    }
                } else
                {
                    c.setVisibility(8);
                    ga.a(fs.a(compoundbutton));
                    return;
                }
                if (true) goto _L2; else goto _L7
_L7:
                if (!a.a().equals("Deals"))
                {
                    break; /* Loop/switch isn't completed */
                }
                AppSettingsEnvironmentFragment.a(d, 1);
                if (compoundbutton.equals("Custom"))
                {
                    c.setVisibility(0);
                    compoundbutton = gd.a();
                    if (compoundbutton.compareTo(ge.c) == 0)
                    {
                        ((EditText)c.findViewById(0x7f0c00ae)).setText(((ge) (compoundbutton)).e);
                        ((EditText)c.findViewById(0x7f0c00ad)).setText(((ge) (compoundbutton)).d);
                        return;
                    }
                } else
                {
                    c.setVisibility(8);
                    gd.a(fs.a(compoundbutton));
                    return;
                }
                if (true) goto _L2; else goto _L8
_L8:
                if (!a.a().equals("Experience Platform"))
                {
                    break; /* Loop/switch isn't completed */
                }
                AppSettingsEnvironmentFragment.a(d, 2);
                if (compoundbutton.equals("Custom"))
                {
                    c.setVisibility(0);
                    compoundbutton = gg.a();
                    if (compoundbutton.compareTo(gh.e) == 0)
                    {
                        ((EditText)c.findViewById(0x7f0c00ae)).setText(((gh) (compoundbutton)).g);
                        ((EditText)c.findViewById(0x7f0c00ad)).setText(((gh) (compoundbutton)).f);
                        return;
                    }
                } else
                {
                    c.setVisibility(8);
                    gg.a(fs.a(compoundbutton));
                    return;
                }
                if (true) goto _L2; else goto _L9
_L9:
                if (!a.a().equals("SI"))
                {
                    break; /* Loop/switch isn't completed */
                }
                AppSettingsEnvironmentFragment.a(d, 11);
                if (compoundbutton.equals("Custom"))
                {
                    c.setVisibility(0);
                    compoundbutton = gq.a();
                    if (compoundbutton.compareTo(gr.e) == 0)
                    {
                        ((EditText)c.findViewById(0x7f0c00ad)).setText(((gr) (compoundbutton)).f);
                        return;
                    }
                } else
                {
                    c.setVisibility(8);
                    gq.a(fs.a(compoundbutton));
                    return;
                }
                if (true) goto _L2; else goto _L10
_L10:
                if (a.a().equals("CIA"))
                {
                    na.a(fs.a(compoundbutton));
                    c.setVisibility(8);
                    return;
                }
                if (a.a().equals("SmallViewCart"))
                {
                    na.b(fs.a(compoundbutton));
                    c.setVisibility(8);
                    return;
                }
                if (true) goto _L2; else goto _L11
_L11:
            }

            
            {
                d = AppSettingsEnvironmentFragment.this;
                a = mt1;
                b = i;
                c = view;
                super();
            }
        });
        radiogroup.addView(aradiobutton[i]);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        int j = c.getInt(mt1.a(), -1);
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_521;
        }
        i = 0;
_L8:
        if (i >= mt1.c().size())
        {
            break MISSING_BLOCK_LABEL_521;
        }
        if (((Integer)mt1.c().get(i)).intValue() != mt1.d()) goto _L6; else goto _L5
_L5:
        aradiobutton[i].setChecked(true);
        linearlayout.addView(radiogroup);
        linearlayout.addView(view);
        b.addView(linearlayout);
          goto _L7
        layoutinflater;
        kf.e("AppSettingsEnvironmentFragment", (new StringBuilder()).append("Could not create AppSettingsEnvironmentFragment: ").append(layoutinflater.getLocalizedMessage()).toString());
_L2:
        return viewgroup;
_L6:
        i++;
          goto _L8
        i = j;
          goto _L5
    }
}
