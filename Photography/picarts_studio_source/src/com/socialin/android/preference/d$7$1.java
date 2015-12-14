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
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.m;
import com.socialin.asyncnet.cache.CacheManager;
import java.io.File;

// Referenced classes of package com.socialin.android.preference:
//            d

final class a
    implements android.view.nClickListener
{

    final _cls1.start a;

    public final void onClick(View view)
    {
        (new Thread(g.a(a.a.getActivity(), a.a.getString(0x7f080450), a.a.getString(0x7f08041a))) {

            private g a;
            private d._cls7._cls1 b;

            public final void run()
            {
                m.a();
                FileUtils.a(new File(com.socialin.android.photo.g.a(b.a.a.getActivity())));
                CacheManager.a().c();
                myobfuscated.f.m.b(b.a.a.getActivity(), a);
            }

            
            {
                b = d._cls7._cls1.this;
                a = g1;
                super();
            }
        }).start();
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
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

}
