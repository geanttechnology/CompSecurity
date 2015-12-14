// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.preference.Preference;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.e;
import com.socialin.android.dialog.f;
import com.socialin.android.photo.g;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.m;
import com.socialin.asyncnet.cache.CacheManager;
import java.io.File;

// Referenced classes of package com.socialin.android.preference:
//            d

final class a extends Thread
{

    private com.socialin.android.dialog.g a;
    private a b;

    public final void run()
    {
        m.a();
        FileUtils.a(new File(g.a(b.b.b.getActivity())));
        CacheManager.a().c();
        myobfuscated.f.m.b(b.b.b.getActivity(), a);
    }

    Utils(Utils utils, com.socialin.android.dialog.g g1)
    {
        b = utils;
        a = g1;
        super();
    }

    // Unreferenced inner class com/socialin/android/preference/d$7

/* anonymous class */
    final class d._cls7
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final d a;

        public final boolean onPreferenceClick(Preference preference)
        {
            AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("pref:pref_web_cache");
            preference = new f(a.getActivity());
            preference.a = a.getString(0x7f080521);
            preference.b = a.getString(0x7f080051);
            preference.a(new d._cls7._cls1(this)).a().show();
            return false;
        }

            
            {
                a = d1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/preference/d$7$1

/* anonymous class */
    final class d._cls7._cls1
        implements android.view.View.OnClickListener
    {

        final d._cls7 a;

        public final void onClick(View view)
        {
            (new d._cls7._cls1._cls1(this, com.socialin.android.dialog.g.a(a.a.getActivity(), a.a.getString(0x7f080450), a.a.getString(0x7f08041a)))).start();
        }

            
            {
                a = _pcls7;
                super();
            }
    }

}
