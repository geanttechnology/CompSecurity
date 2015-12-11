// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smule.android.d.u;
import com.smule.android.network.managers.a;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.f;
import com.smule.pianoandroid.utils.e;
import com.smule.pianoandroid.utils.j;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication, ba, at

public class as extends Dialog
{

    private static final String a = com/smule/pianoandroid/magicpiano/as.getName();
    private at b;
    private Activity c;
    private ListingV2 d;
    private Integer e;
    private Runnable f;

    public as(Activity activity, ListingV2 listingv2, Integer integer, Runnable runnable, boolean flag)
    {
        super(activity, 0x7f0d007f);
        c = activity;
        d = listingv2;
        e = integer;
        f = runnable;
        requestWindowFeature(1);
        integer = activity.getLayoutInflater().inflate(0x7f030062, null, false);
        setContentView(integer);
        j.a(integer, activity.getLayoutInflater().getContext());
        runnable = new HashMap();
        runnable.put("cancelButtonTitleKey", getContext().getString(0x7f0c0042));
        runnable.put("cancelButtonColorOn", "#666666");
        runnable.put("cancelButtonColorOff", "#cccccc");
        MagicApplication.getLoader().a("RenewSubscriptionDialog.LoadSubs", Arrays.asList(new String[] {
            "InitAppTask.OP_LOCALIZE_SETTINGS"
        }), n.a(activity, new Runnable(runnable, flag, listingv2, integer, activity) {

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
                ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener(this) {

                    final _cls1 a;

                    public void onClick(View view)
                    {
                        com.smule.pianoandroid.magicpiano.as.a(a.f);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                ((TextView) (obj)).setBackgroundDrawable(j.a((String)map.get("cancelButtonColorOn"), (String)map.get("cancelButtonColorOff")));
                com.smule.pianoandroid.utils.e.a(e, new com.smule.pianoandroid.utils.f(this) {

                    final _cls1 a;

                    public void a()
                    {
                        ((TextView)a.f.findViewById(0x7f0a01eb)).setText(0x7f0c0037);
                    }

                    public void a(Map map, List list)
                    {
                        LinearLayout linearlayout = (LinearLayout)a.d.findViewById(0x7f0a008a);
                        if (map == null)
                        {
                            ((TextView)a.f.findViewById(0x7f0a01eb)).setText(0x7f0c0037);
                        } else
                        {
                            a.f.findViewById(0x7f0a01eb).setVisibility(8);
                            list = list.iterator();
                            while (list.hasNext()) 
                            {
                                f f1 = (f)list.next();
                                linearlayout.addView(com.smule.pianoandroid.magicpiano.as.a(a.f, f1, (u)map.get(f1.sku), linearlayout));
                            }
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                f = as.this;
                a = map;
                b = flag;
                c = listingv2;
                d = view;
                e = activity;
                super();
            }
        })).a();
        integer.findViewById(0x7f0a0063).setOnClickListener(new android.view.View.OnClickListener() {

            final as a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = as.this;
                super();
            }
        });
    }

    private ba a(f f1, u u, ViewGroup viewgroup)
    {
        viewgroup = (ba)c.getLayoutInflater().inflate(0x7f030063, null, false);
        viewgroup.a(f1, u, new android.view.View.OnClickListener(f1, u) {

            final f a;
            final u b;
            final as c;

            public void onClick(View view)
            {
                if (as.b(c) != null)
                {
                    com.smule.android.c.a.a(a.sku, a.period, b.b());
                    as.b(c).a(a.sku);
                }
                c.dismiss();
            }

            
            {
                c = as.this;
                a = f1;
                b = u1;
                super();
            }
        });
        return viewgroup;
    }

    static ba a(as as1, f f1, u u, ViewGroup viewgroup)
    {
        return as1.a(f1, u, viewgroup);
    }

    private void a()
    {
        dismiss();
        if (f != null && !d.subscriberOnly)
        {
            o.a(c, d, e, f);
        }
    }

    static void a(as as1)
    {
        as1.a();
    }

    static at b(as as1)
    {
        return as1.b;
    }

    public void a(at at)
    {
        b = at;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        a();
    }

}
