// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.util.Utils;
import com.socialin.android.util.an;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements android.view.OnClickListener
{

    final a a;

    public final void onClick(View view)
    {
        com.socialin.android.share.a.a(a, new an() {

            private a._cls16 a;

            protected final Object doInBackground(Object aobj[])
            {
                return Integer.valueOf(com.socialin.android.share.a.c(a.a));
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Integer)obj;
                if (!isCancelled() && a.a.getActivity() != null && !a.a.getActivity().isFinishing() && ((Integer) (obj)).intValue() != -1)
                {
                    obj = a.a;
                    if (((a) (obj)).d != null)
                    {
                        ((a) (obj)).f.setMessage(((a) (obj)).getString(0x7f080679));
                        m.a(((a) (obj)).getActivity(), ((a) (obj)).f);
                        (new Thread(new a._cls17(((a) (obj))))).start();
                    } else
                    {
                        m.b(((a) (obj)).getActivity(), ((a) (obj)).f);
                        Utils.a(((a) (obj)).getActivity(), 0x7f0805ca);
                    }
                    com.socialin.android.share.a.a(a.a, "wallpaper");
                    AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("wallpaper", "bin")).setOwner(a.a.a).setFreeToEdit(a.a.b));
                }
            }

            
            {
                a = a._cls16.this;
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
