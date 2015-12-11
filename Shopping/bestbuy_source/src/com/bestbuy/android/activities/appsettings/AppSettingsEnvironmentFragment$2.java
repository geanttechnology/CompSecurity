// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import fs;
import ga;
import gb;
import gd;
import ge;
import gg;
import gh;
import gm;
import gn;
import gq;
import gr;
import java.util.ArrayList;
import mt;
import na;

// Referenced classes of package com.bestbuy.android.activities.appsettings:
//            AppSettingsEnvironmentFragment

class c
    implements android.widget.tener
{

    final mt a;
    final int b;
    final View c;
    final AppSettingsEnvironmentFragment d;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        compoundbutton = AppSettingsEnvironmentFragment.c(d).edit();
        compoundbutton.d(a.a(), b);
        compoundbutton.b();
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

    Q(AppSettingsEnvironmentFragment appsettingsenvironmentfragment, mt mt1, int i, View view)
    {
        d = appsettingsenvironmentfragment;
        a = mt1;
        b = i;
        c = view;
        super();
    }
}
