// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.content.res.Resources;
import android.preference.Preference;
import android.view.View;
import android.widget.RadioButton;
import com.picsart.studio.PicsartContext;
import com.socialin.android.dialog.e;
import com.socialin.android.dialog.f;

// Referenced classes of package com.socialin.android.preference:
//            d

final class a
    implements android.view.ClickListener
{

    private ring a;

    public final void onClick(View view)
    {
        if (((RadioButton)view.getRootView().findViewById(0x7f100377)).isChecked())
        {
            PicsartContext.a(a.a.getActivity(), 0x400000);
            a.a.setSummary(a.a.getString(0x7f08038c));
        } else
        {
            if (((RadioButton)view.getRootView().findViewById(0x7f100378)).isChecked())
            {
                PicsartContext.a(a.a.getActivity(), 0x400000);
                a.a.setSummary(a.a.getString(0x7f08038d));
                return;
            }
            if (((RadioButton)view.getRootView().findViewById(0x7f100379)).isChecked())
            {
                PicsartContext.a(a.a.getActivity(), 0x500000);
                a.a.setSummary(a.a.getString(0x7f08038e));
                return;
            }
            if (((RadioButton)view.getRootView().findViewById(0x7f10037a)).isChecked())
            {
                PicsartContext.a(a.a.getActivity(), 0x600000);
                a.a.setSummary(a.a.getString(0x7f08038f));
                return;
            }
            if (((RadioButton)view.getRootView().findViewById(0x7f10037b)).isChecked())
            {
                PicsartContext.a(a.a.getActivity(), 0x700000);
                a.a.setSummary(a.a.getString(0x7f080390));
                return;
            }
            if (((RadioButton)view.getRootView().findViewById(0x7f10037c)).isChecked())
            {
                PicsartContext.a(a.a.getActivity(), 0x800000);
                a.a.setSummary(a.a.getString(0x7f080391));
                return;
            }
        }
    }

    yType(yType ytype)
    {
        a = ytype;
        super();
    }

    // Unreferenced inner class com/socialin/android/preference/d$10

/* anonymous class */
    final class d._cls10
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final Preference a;
        final d b;

        public final boolean onPreferenceClick(Preference preference)
        {
            preference = new f(b.getActivity());
            preference.e = 0x7f0300a1;
            preference.a = b.getResources().getString(0x7f0800c3);
            preference.g = false;
            String s = b.getResources().getString(0x7f080311);
            if (s != null)
            {
                preference.c = s;
            }
            preference.f = true;
            preference = preference.a(new d._cls10._cls1(this)).a();
            PicsartContext.a(b.getActivity()) / 0x100000;
            JVM INSTR tableswitch 3 8: default 136
        //                       3 241
        //                       4 257
        //                       5 273
        //                       6 289
        //                       7 305
        //                       8 321;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            if (PicsartContext.a.getMaxImageSizeMegapixel() < 5)
            {
                ((RadioButton)preference.findViewById(0x7f100379)).setVisibility(8);
            }
            if (PicsartContext.a.getMaxImageSizeMegapixel() < 6)
            {
                ((RadioButton)preference.findViewById(0x7f10037a)).setVisibility(8);
            }
            if (PicsartContext.a.getMaxImageSizeMegapixel() < 7)
            {
                ((RadioButton)preference.findViewById(0x7f10037b)).setVisibility(8);
            }
            if (PicsartContext.a.getMaxImageSizeMegapixel() < 8)
            {
                ((RadioButton)preference.findViewById(0x7f10037c)).setVisibility(8);
            }
            preference.show();
            return true;
_L2:
            ((RadioButton)preference.findViewById(0x7f100377)).setChecked(true);
            continue; /* Loop/switch isn't completed */
_L3:
            ((RadioButton)preference.findViewById(0x7f100378)).setChecked(true);
            continue; /* Loop/switch isn't completed */
_L4:
            ((RadioButton)preference.findViewById(0x7f100379)).setChecked(true);
            continue; /* Loop/switch isn't completed */
_L5:
            ((RadioButton)preference.findViewById(0x7f10037a)).setChecked(true);
            continue; /* Loop/switch isn't completed */
_L6:
            ((RadioButton)preference.findViewById(0x7f10037b)).setChecked(true);
            continue; /* Loop/switch isn't completed */
_L7:
            ((RadioButton)preference.findViewById(0x7f10037c)).setChecked(true);
            if (true) goto _L1; else goto _L8
_L8:
        }

            
            {
                b = d1;
                a = preference;
                super();
            }
    }

}
