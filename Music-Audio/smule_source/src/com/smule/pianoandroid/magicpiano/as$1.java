// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smule.android.d.u;
import com.smule.android.network.managers.a;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.utils.e;
import com.smule.pianoandroid.utils.f;
import com.smule.pianoandroid.utils.j;
import com.smule.pianoandroid.utils.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            as

class e
    implements Runnable
{

    final Map a;
    final boolean b;
    final ListingV2 c;
    final View d;
    final Activity e;
    final as f;

    public void run()
    {
        Object obj = "modalTitleRenewSubsKey";
        a.put("modalTitleRenewSubsKey", f.getContext().getString(0x7f0c0226));
        Map map;
        if (b)
        {
            q.z();
            if (c.subscriberOnly)
            {
                ((TextView)d.findViewById(0x7f0a01f7)).setText(c.song.title);
                a.put("modalTitleRenewSubsVIPKey", f.getContext().getString(0x7f0c0227));
                q.z();
                obj = "modalTitleRenewSubsVIPKey";
            }
        } else
        {
            ((TextView)d.findViewById(0x7f0a01f7)).setText(c.song.title);
            if (c.b())
            {
                a.put("modalTitleSubsJamKey", f.getContext().getString(0x7f0c0283));
                obj = "modalTitleSubsJamKey";
            } else
            {
                obj = "modalTitleSubsNormalKey";
                a.put("modalTitleSubsNormalKey", f.getContext().getString(0x7f0c0281));
            }
        }
        map = com.smule.android.network.managers.a.a().a("piandroid.purchasePage", "layout", a);
        ((TextView)d.findViewById(0x7f0a01f8)).setText((CharSequence)map.get(obj));
        obj = (TextView)d.findViewById(0x7f0a01f9);
        ((TextView) (obj)).setText((CharSequence)map.get("cancelButtonTitleKey"));
        ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final as._cls1 a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.as.a(a.f);
            }

            
            {
                a = as._cls1.this;
                super();
            }
        });
        ((TextView) (obj)).setBackgroundDrawable(j.a((String)map.get("cancelButtonColorOn"), (String)map.get("cancelButtonColorOff")));
        com.smule.pianoandroid.utils.e.a(e, new f() {

            final as._cls1 a;

            public void a()
            {
                ((TextView)a.f.findViewById(0x7f0a01eb)).setText(0x7f0c0037);
            }

            public void a(Map map1, List list)
            {
                LinearLayout linearlayout = (LinearLayout)a.d.findViewById(0x7f0a008a);
                if (map1 == null)
                {
                    ((TextView)a.f.findViewById(0x7f0a01eb)).setText(0x7f0c0037);
                } else
                {
                    a.f.findViewById(0x7f0a01eb).setVisibility(8);
                    list = list.iterator();
                    while (list.hasNext()) 
                    {
                        com.smule.android.network.models.f f1 = (com.smule.android.network.models.f)list.next();
                        linearlayout.addView(com.smule.pianoandroid.magicpiano.as.a(a.f, f1, (u)map1.get(f1.sku), linearlayout));
                    }
                }
            }

            
            {
                a = as._cls1.this;
                super();
            }
        });
    }

    gV2(as as1, Map map, boolean flag, ListingV2 listingv2, View view, Activity activity)
    {
        f = as1;
        a = map;
        b = flag;
        c = listingv2;
        d = view;
        e = activity;
        super();
    }
}
