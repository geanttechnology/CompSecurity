// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.a.f;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.ProductFeature;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.g;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public class p extends com.cyberlink.beautycircle.controller.adapter.m
{

    private Activity a;
    private long b;

    public p(Activity activity, ViewGroup viewgroup, int i, n n)
    {
        super(activity, viewgroup, i, 20, n);
        b = -1L;
        if (activity == null)
        {
            throw new NullPointerException("The first parameter cannot be null");
        } else
        {
            a = activity;
            return;
        }
    }

    static Activity a(p p1)
    {
        return p1.a;
    }

    private void b(ProductFeature productfeature, View view)
    {
        android.view.View.OnClickListener onclicklistener = null;
        byte byte0;
        if (productfeature.metadata != null && productfeature.metadata.infoLink != null && !productfeature.metadata.infoLink.isEmpty())
        {
            productfeature = Uri.parse(productfeature.metadata.infoLink);
        } else
        {
            productfeature = null;
        }
        byte0 = 4;
        if (productfeature != null)
        {
            byte0 = 0;
            onclicklistener = new android.view.View.OnClickListener(productfeature) {

                final Uri a;
                final p b;

                public void onClick(View view1)
                {
                    com.perfectcorp.a.b.a(new f("more_info", a.getQueryParameter("SkuType"), a.getQueryParameter("SkuGuid"), a.getQueryParameter("SkuItemGuid")));
                    g.a(p.a(b), a);
                }

            
            {
                b = p.this;
                a = uri;
                super();
            }
            };
        }
        productfeature = view.findViewById(j.product_info_btn);
        if (productfeature != null)
        {
            productfeature.setVisibility(byte0);
            productfeature.setOnClickListener(onclicklistener);
        }
    }

    public void a(long l)
    {
        b = l;
    }

    protected void a(ProductFeature productfeature)
    {
    }

    protected void a(ProductFeature productfeature, View view)
    {
        Object obj3;
        View view1;
        boolean flag;
        flag = false;
        obj3 = null;
        if (productfeature == null || view == null)
        {
            return;
        }
        view1 = view.findViewById(j.product_type_outter);
        if (view1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        Object obj1 = (Integer)view.getTag();
        if (productfeature.productType != null)
        {
            obj = productfeature.productType;
        } else
        {
            obj = null;
        }
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        i = ((Integer) (obj1)).intValue();
        if (i != 0) goto _L6; else goto _L5
_L5:
        i = 0;
_L8:
        view1.setVisibility(i);
        view1.setOnClickListener(null);
        obj1 = (TextView)view1.findViewById(j.product_type_name);
        if (obj1 != null)
        {
            ((TextView) (obj1)).setText(((CharSequence) (obj)));
        }
_L2:
        obj = view.findViewById(j.product_info_bar);
        if (obj != null)
        {
            ((View) (obj)).setVisibility(0);
        }
        obj1 = (UICImageView)view.findViewById(j.product_thumb);
        if (obj1 != null)
        {
            Object obj2;
            if (productfeature.imgUrl != null)
            {
                obj = Uri.parse(productfeature.imgUrl);
            } else
            {
                obj = null;
            }
            ((UICImageView) (obj1)).setImageURI(((Uri) (obj)));
        }
        obj = (TextView)view.findViewById(j.product_title);
        if (obj != null)
        {
            ((TextView) (obj)).setText(productfeature.productTitle);
        }
        obj = (TextView)view.findViewById(j.product_description);
        if (obj != null)
        {
            ((TextView) (obj)).setText(productfeature.productDescription);
        }
        obj1 = view.findViewById(j.product_try_it_outter);
        if (obj1 != null)
        {
            if (productfeature.metadata != null && productfeature.metadata.tryLink != null && !productfeature.metadata.tryLink.isEmpty())
            {
                obj = Uri.parse(productfeature.metadata.tryLink);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                obj = new android.view.View.OnClickListener(((Uri) (obj))) {

                    final Uri a;
                    final p b;

                    public void onClick(View view2)
                    {
                        com.perfectcorp.a.b.a(new f("try_it", (String)a.getPathSegments().get(0), a.getQueryParameter("SkuGuid"), a.getQueryParameter("SkuItemGuid")));
                        g.a(p.a(b), a);
                    }

            
            {
                b = p.this;
                a = uri;
                super();
            }
                };
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 4;
                obj = obj3;
            }
            ((View) (obj1)).setVisibility(i);
            ((View) (obj1)).setOnClickListener(((android.view.View.OnClickListener) (obj)));
        }
        b(productfeature, view);
        return;
_L6:
        if (i > 0)
        {
            obj2 = (ProductFeature)getItem(i - 1);
            if (obj2 != null)
            {
                if (((ProductFeature) (obj2)).productType != null)
                {
                    obj2 = ((ProductFeature) (obj2)).productType;
                } else
                {
                    obj2 = null;
                }
                if (obj2 != null && obj != null && !((String) (obj)).equals(obj2))
                {
                    i = 0;
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
_L4:
        i = 8;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void a(Model model)
    {
        b((ProductFeature)model);
    }

    protected volatile void a(Model model, View view)
    {
        a((ProductFeature)model, view);
    }

    protected d b(int i, int k)
    {
        Object obj = new com.perfectcorp.utility.j() {

            final p a;

            protected d a(d d1)
            {
                return d1;
            }

            protected volatile Object a(Object obj1)
            {
                return a((d)obj1);
            }

            protected void a(int l)
            {
                super.a(l);
                if (p.a(a) != null && (p.a(a) instanceof MainActivity) && l != 0)
                {
                    ((BaseActivity)p.a(a)).a(p.a(a).getString(m.bc_server_connect_fail), 3000);
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        try
        {
            obj = (d)r.a(b, i, k).a(((com.perfectcorp.utility.j) (obj))).d();
        }
        catch (Exception exception)
        {
            e.e(new Object[] {
                exception
            });
            return null;
        }
        return ((d) (obj));
    }

    protected void b(ProductFeature productfeature)
    {
        Object obj = null;
        if (productfeature != null)
        {
            Uri uri;
            Uri uri1;
            if (productfeature.metadata != null && productfeature.metadata.tryLink != null && !productfeature.metadata.tryLink.isEmpty())
            {
                uri = Uri.parse(productfeature.metadata.tryLink);
            } else
            {
                uri = null;
            }
            uri1 = obj;
            if (productfeature.metadata != null)
            {
                uri1 = obj;
                if (productfeature.metadata.infoLink != null)
                {
                    uri1 = obj;
                    if (!productfeature.metadata.infoLink.isEmpty())
                    {
                        uri1 = Uri.parse(productfeature.metadata.infoLink);
                    }
                }
            }
            if (uri1 != null)
            {
                g.a(a, uri1);
                return;
            }
            if (uri != null)
            {
                g.a(a, uri);
                return;
            }
        }
    }

    protected void b(Model model)
    {
        a((ProductFeature)model);
    }
}
