// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.m;
import java.io.File;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            am, p

public abstract class an extends a
{

    HorizontalScrollView a;
    m b;
    View c;
    final MakeupItemMetadata d;
    private View e;

    an(MakeupItemMetadata makeupitemmetadata)
    {
        d = makeupitemmetadata;
    }

    public static an a(MakeupItemMetadata makeupitemmetadata)
    {
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata.UnlockMethod.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata.UnlockMethod.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.dialogs._cls4.a[makeupitemmetadata.y().ordinal()])
        {
        default:
            return new am(makeupitemmetadata);

        case 1: // '\001'
            return new p(makeupitemmetadata);
        }
    }

    private void b()
    {
        if (d.q() == null)
        {
            return;
        } else
        {
            NetworkManager networkmanager = Globals.d().w();
            k k1 = new k(d.a(), "Makeup_Category_item", d.q(), d.u());
            c.setVisibility(0);
            networkmanager.a(k1, new l() {

                final an a;

                private void a()
                {
                    Globals.c(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            a.a.c.setVisibility(8);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }

                static void a(_cls2 _pcls2)
                {
                    _pcls2.a();
                }

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                {
                }

                public void a(bn bn1)
                {
                    if (bn1 == null);
                    a();
                }

                public volatile void a(Object obj)
                {
                    a((String)obj);
                }

                public void a(String s)
                {
                    Globals.d().a(Uri.fromFile(new File(s)));
                    Globals.c(new Runnable(this, s) {

                        final String a;
                        final _cls2 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.widgetpool.dialogs._cls2.a(b);
                            ImageView imageview = (ImageView)b.a.getView().findViewById(0x7f0c071b);
                            android.graphics.Bitmap bitmap;
                            if (imageview != null)
                            {
                                if ((bitmap = BitmapFactory.decodeFile(a)) != null)
                                {
                                    imageview.setImageBitmap(bitmap);
                                    return;
                                }
                            }
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
                    a();
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
                a = an.this;
                super();
            }
            });
            return;
        }
    }

    private void c()
    {
        URI uri;
        for (Iterator iterator = d.p().iterator(); iterator.hasNext(); Globals.d().w().a(new k(d.a(), "Makeup_Category_item", uri, d.u()), new l() {

        final an a;

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
                final _cls3 b;

                public void run()
                {
                    String s;
                    Iterator iterator;
                    int i;
                    s = a.substring(a.lastIndexOf("/"));
                    iterator = b.a.d.p().iterator();
                    i = 0;
_L3:
                    if (!iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_133;
                    }
                    if (!((URI)iterator.next()).toString().contains(s)) goto _L2; else goto _L1
_L1:
                    if (b.a.a != null)
                    {
                        b.a.b.a(330, 440, a, (String)b.a.d.r().get(i), false);
                    }
                    return;
_L2:
                    i++;
                      goto _L3
                    i = 0;
                      goto _L1
                }

            
            {
                b = _pcls3;
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
                a = an.this;
                super();
            }
    }))
        {
            uri = (URI)iterator.next();
        }

    }

    abstract View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle);

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b = new m(getActivity(), com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.a);
        a.addView(b, new android.view.ViewGroup.LayoutParams(-1, -1));
        e = getView().findViewById(0x7f0c0608);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final an a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = an.this;
                super();
            }
        });
        b();
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = a(layoutinflater, viewgroup, bundle);
        a = (HorizontalScrollView)layoutinflater.findViewById(0x7f0c0572);
        ((TextView)layoutinflater.findViewById(0x7f0c0604)).setText(d.t());
        ((TextView)layoutinflater.findViewById(0x7f0c0603)).setText(d.s());
        c = layoutinflater.findViewById(0x7f0c0607);
        return layoutinflater;
    }
}
