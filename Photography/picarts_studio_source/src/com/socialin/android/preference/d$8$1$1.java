// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.preference.Preference;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.e;
import com.socialin.android.dialog.f;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.util.aa;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.preference:
//            d

final class a extends Thread
{

    private g a;
    private a b;

    public final void run()
    {
        aa.c(b.b.b.getActivity());
        m.b(b.b.b.getActivity(), a);
    }

    Utils(Utils utils, g g)
    {
        b = utils;
        a = g;
        super();
    }

    // Unreferenced inner class com/socialin/android/preference/d$8

/* anonymous class */
    final class d._cls8
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final d a;

        public final boolean onPreferenceClick(Preference preference)
        {
            AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:pref_search_history");
            preference = new f(a.getActivity());
            preference.a = a.getString(0x7f08051c);
            preference.b = a.getString(0x7f080051);
            preference.a(new d._cls8._cls1(this)).a().show();
            return false;
        }

            
            {
                a = d1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/preference/d$8$1

/* anonymous class */
    final class d._cls8._cls1
        implements android.view.View.OnClickListener
    {

        final d._cls8 a;

        public final void onClick(View view)
        {
            (new d._cls8._cls1._cls1(this, g.a(a.a.getActivity(), a.a.getString(0x7f080450), a.a.getString(0x7f08041a)))).start();
        }

            
            {
                a = _pcls8;
                super();
            }
    }

}
