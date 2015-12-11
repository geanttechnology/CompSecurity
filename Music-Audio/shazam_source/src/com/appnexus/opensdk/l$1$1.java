// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.k;
import java.util.HashMap;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            i, k, m, z, 
//            r, al, l, ar, 
//            ao, aq, d, o, 
//            aa, ad, af

final class a
    implements i
{

    final m a;
    final roy b;

    public final z a()
    {
        return b.b.getMediaType();
    }

    public final boolean b()
    {
        return false;
    }

    public final r c()
    {
        return a;
    }

    public final al d()
    {
        return null;
    }

    public final void e()
    {
        a.destroy();
    }

    LayoutParams(LayoutParams layoutparams, m m1)
    {
        b = layoutparams;
        a = m1;
        super();
    }

    // Unreferenced inner class com/appnexus/opensdk/l$1

/* anonymous class */
    final class l._cls1
        implements Runnable
    {

        final ar a;
        final com.appnexus.opensdk.k b;
        final l c;

        public final void run()
        {
            boolean flag2 = false;
            ad ad1 = null;
            Object obj = null;
            boolean flag;
            boolean flag1;
            if (a != null && a.f)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag2;
            if (((ao) (c)).b != null)
            {
                flag1 = flag2;
                if (!((ao) (c)).b.isEmpty())
                {
                    flag1 = true;
                }
            }
            if (!flag && !flag1)
            {
                com.appnexus.opensdk.b.b.d(b.f, com.appnexus.opensdk.b.b.a(an.d.response_no_ads));
                b.getAdDispatcher().a(aq.c);
            } else
            {
                if (b.getMediaType().equals(z.a))
                {
                    ((o)b).j();
                }
                if (flag)
                {
                    c.b = a.d;
                }
                if (((ao) (c)).b != null && !((ao) (c)).b.isEmpty())
                {
                    aa aa1 = c.f();
                    if (aa1 != null && a != null)
                    {
                        aa1.g = a.e;
                    }
                    if (b.getMediaType().equals(z.a))
                    {
                        l l1 = c;
                        ad1 = new ad((Activity)b.getContext(), c, aa1, b.getAdDispatcher());
                        if (!ad1.f)
                        {
                            obj = ad1;
                        }
                        l1.a = ((ac) (obj));
                        return;
                    }
                    if (b.getMediaType().equals(com.appnexus.opensdk.z.b))
                    {
                        l l2 = c;
                        Object obj1 = new af((Activity)b.getContext(), c, aa1, b.getAdDispatcher());
                        if (((af) (obj1)).f)
                        {
                            obj1 = ad1;
                        }
                        l2.a = ((ac) (obj1));
                        return;
                    } else
                    {
                        com.appnexus.opensdk.b.b.e(b.b, "Request type can not be identified.");
                        b.getAdDispatcher().a(com.appnexus.opensdk.aq.b);
                        return;
                    }
                }
                if (a != null)
                {
                    m m1 = new m(b);
                    ar ar1 = a;
                    if (ar1 != null)
                    {
                        Object obj2;
                        if (ar1.a != null)
                        {
                            obj2 = ar1.a;
                        } else
                        {
                            obj2 = "";
                        }
                        m1.i = ar1.b;
                        m1.h = ar1.c;
                        if (k.a(((String) (obj2))))
                        {
                            m1.a = true;
                        } else
                        {
                            com.appnexus.opensdk.b.b.a(b.b, com.appnexus.opensdk.b.b.a(an.d.webview_loading, ((String) (obj2))));
                            HashMap hashmap = ar1.e;
                            if (!hashmap.isEmpty())
                            {
                                if (hashmap.containsKey("MRAID"))
                                {
                                    m1.c = ((Boolean)hashmap.get("MRAID")).booleanValue();
                                }
                                float f;
                                int i1;
                                if (hashmap.containsKey("ORIENTATION") && hashmap.get("ORIENTATION").equals("h"))
                                {
                                    m1.j = 2;
                                } else
                                {
                                    m1.j = 1;
                                }
                            }
                            obj2 = m1.b(m.a(((String) (obj2))));
                            f = m1.b.getContext().getResources().getDisplayMetrics().density;
                            i1 = (int)((float)ar1.b * f + 0.5F);
                            m1.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)(f * (float)ar1.c + 0.5F), i1, 17));
                            m1.loadDataWithBaseURL(j.y, ((String) (obj2)), "text/html", "UTF-8", null);
                        }
                    }
                    if (b.getMediaType().equals(z.a))
                    {
                        obj2 = (o)b;
                        if (((o) (obj2)).getExpandsToFitScreenWidth())
                        {
                            ((o) (obj2)).a(a.c, a.b, m1);
                        }
                    }
                    c.a(new l._cls1._cls1(this, m1));
                    return;
                }
            }
        }

            
            {
                c = l1;
                a = ar1;
                b = k1;
                super();
            }
    }

}
