// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.m;
import java.net.URI;
import java.util.List;

public class e extends a
{

    m a;
    private View b;
    private View c;
    private TextView d;
    private String e;
    private HorizontalScrollView f;
    private MakeupItemMetadata g;
    private List h;
    private List i;

    public e(String s)
    {
        e = s;
    }

    static List a(e e1)
    {
        return e1.h;
    }

    static HorizontalScrollView b(e e1)
    {
        return e1.f;
    }

    static List c(e e1)
    {
        return e1.i;
    }

    public void b()
    {
        for (int j = 0; j < h.size(); j++)
        {
            Globals.d().w().a(new k(g.a(), "Makeup_Category_item", (URI)h.get(j), g.u()), new l() {

                final e a;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                {
                }

                public void a(bn bn1)
                {
                    if (bn1 == null);
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    Globals.c(new Runnable(this, s) {

                        final String a;
                        final _cls2 b;

                        public void run()
                        {
                            String s;
                            int j;
                            s = a.substring(a.lastIndexOf("/"));
                            j = 0;
_L3:
                            if (j >= com.cyberlink.youcammakeup.widgetpool.dialogs.e.a(b.a).size())
                            {
                                break MISSING_BLOCK_LABEL_131;
                            }
                            if (!((URI)com.cyberlink.youcammakeup.widgetpool.dialogs.e.a(b.a).get(j)).toString().contains(s)) goto _L2; else goto _L1
_L1:
                            if (e.b(b.a) != null)
                            {
                                b.a.a.a(330, 400, a, (String)e.c(b.a).get(j), true);
                            }
                            return;
_L2:
                            j++;
                              goto _L3
                            j = 0;
                              goto _L1
                        }

            
            {
                b = _pcls2;
                a = s;
                super();
            }
                    });
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

                public void d(Object obj)
                {
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
                }

            
            {
                a = e.this;
                super();
            }
            });
        }

    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a = new m(getActivity(), com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.a);
        f.addView(a, new android.view.ViewGroup.LayoutParams(-2, -1));
        b();
        d = (TextView)b.findViewById(0x7f0c0571);
        d.setText(e);
        c = b.findViewById(0x7f0c0573);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final e a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = e.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = layoutinflater.inflate(0x7f030111, viewgroup);
        f = (HorizontalScrollView)b.findViewById(0x7f0c0572);
        g = Globals.d().D();
        h = g.p();
        i = g.r();
        return b;
    }
}
