// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.an;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements android.view.OnClickListener
{

    final a a;

    public final void onClick(View view)
    {
        com.socialin.android.share.a.a(a, new an() {

            private a._cls21 a;

            protected final Object doInBackground(Object aobj[])
            {
                if (!c.b(a.a.getActivity()))
                {
                    return Integer.valueOf(-1);
                } else
                {
                    return Integer.valueOf(0);
                }
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Integer)obj;
                if (!isCancelled() && a.a.getActivity() != null && !a.a.getActivity().isFinishing() && ((Integer) (obj)).intValue() != -1)
                {
                    com.socialin.android.share.a.p(a.a);
                    AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("picsart", "url")).setOwner(a.a.a).setFreeToEdit(a.a.b).setDestSection("page"));
                }
            }

            
            {
                a = a._cls21.this;
                super();
            }
        });
        com.socialin.android.share.a.a(a).a(new Void[0]);
    }

    it>(a a1)
    {
        a = a1;
        super();
    }
}
