// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.api.lib.models.pdp.AlternateProduct;
import com.bestbuy.android.api.lib.models.pdp.Option;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.ProductFamily;
import com.bestbuy.android.api.lib.models.pdp.ProductOption;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment, PDPFragmentContainer

public class PDPOptionFragment extends BBYBaseFragment
{

    private Activity a;
    private OverviewResponse b;
    private View c;
    private FrameLayout g;
    private ImageView h;
    private LayoutInflater i;
    private RelativeLayout j;
    private LinearLayout k;
    private boolean l;

    public PDPOptionFragment()
    {
        l = false;
    }

    public PDPOptionFragment(OverviewResponse overviewresponse)
    {
        l = false;
        b = overviewresponse;
    }

    static void a(PDPOptionFragment pdpoptionfragment, List list)
    {
        pdpoptionfragment.c(list);
    }

    private void a(String s)
    {
        View view = g.findViewById(0x7f0c0224);
        if (s.equalsIgnoreCase(getString(0x7f080085)))
        {
            view.setBackgroundResource(0x7f02019c);
            return;
        }
        if (s.equalsIgnoreCase(getString(0x7f080074)))
        {
            view.setBackgroundResource(0x7f020150);
            return;
        }
        if (s.equalsIgnoreCase(getString(0x7f0800f9)))
        {
            view.setBackgroundResource(0x7f020071);
            return;
        }
        if (s.equalsIgnoreCase(getString(0x7f08038f)))
        {
            view.setBackgroundResource(0x7f0201c0);
            return;
        }
        if (s.equalsIgnoreCase(getString(0x7f0800e5)))
        {
            view.setBackgroundResource(0x7f020065);
            return;
        } else
        {
            view.setBackgroundResource(0x7f0201b5);
            return;
        }
    }

    private void a(List list)
    {
        c.findViewById(0x7f0c023e).setVisibility(0);
        k.setVisibility(0);
        list = list.iterator();
_L3:
        Option option;
        BBYTextView bbytextview;
        LinearLayout linearlayout;
        View view;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_336;
        }
        option = (Option)list.next();
        bbytextview = (BBYTextView)c.findViewById(0x7f0c023d);
        linearlayout = (LinearLayout)c.findViewById(0x7f0c023f);
        g = (FrameLayout)i.inflate(0x7f03008d, null);
        h = (ImageView)g.findViewById(0x7f0c0225);
        view = g.findViewById(0x7f0c0224);
        if (option.getDisplayName() == null || option.getDisplayName().length() <= 0)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        int i1 = Color.parseColor(nb.a().g(option.getDisplayName().toLowerCase()));
_L1:
        Object obj = option.getDisplayName().toLowerCase();
        if (i1 != -12345)
        {
            if (((String) (obj)).equalsIgnoreCase("Gold"))
            {
                view.setBackgroundResource(0x7f0200de);
            } else
            if (((String) (obj)).equalsIgnoreCase("Silver"))
            {
                view.setBackgroundResource(0x7f02018e);
            } else
            {
                view.setBackgroundColor(i1);
            }
        } else
        {
            a(((String) (obj)));
        }
        linearlayout.addView(g);
        view = new View(a);
        view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(12, 1));
        linearlayout.addView(view);
        if (option.getState().equals("selected"))
        {
            h.setBackgroundResource(0x7f020083);
            bbytextview.setText(option.getDisplayName());
        } else
        {
            g.setOnClickListener(new android.view.View.OnClickListener(option) {

                final Option a;
                final PDPOptionFragment b;

                public void onClick(View view1)
                {
                    view1 = new HashMap();
                    view1.put("&&products", (new StringBuilder()).append(";").append(a.getSku()).toString());
                    lu.b(lu.an, view1);
                    view1 = b.getParentFragment();
                    PDPFragment pdpfragment = new PDPFragment(a.getSku(), null, false);
                    ((PDPFragmentContainer)view1.getParentFragment()).a(pdpfragment, true);
                }

            
            {
                b = PDPOptionFragment.this;
                a = option;
                super();
            }
            });
        }
        continue; /* Loop/switch isn't completed */
        obj;
        ((Exception) (obj)).printStackTrace();
        i1 = -12345;
          goto _L1
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void b(List list)
    {
        String s1;
        j.setVisibility(0);
        StringBuffer stringbuffer = new StringBuffer();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            AlternateProduct alternateproduct = (AlternateProduct)iterator.next();
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append(", ");
            }
            if (alternateproduct.getFormat().equalsIgnoreCase(getString(0x7f080088)))
            {
                stringbuffer.append(getString(0x7f080075));
            } else
            {
                stringbuffer.append(alternateproduct.getFormat());
            }
        }

        s1 = stringbuffer.toString();
        if (s1 != null && !s1.isEmpty()) goto _L2; else goto _L1
_L1:
        String s = b.getCondition();
_L4:
        s = (new StringBuilder()).append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).toString();
        ((BBYTextView)c.findViewById(0x7f0c0242)).setText(s);
        j.setOnClickListener(new android.view.View.OnClickListener(list) {

            final List a;
            final PDPOptionFragment b;

            public void onClick(View view)
            {
                PDPOptionFragment.a(b, a);
            }

            
            {
                b = PDPOptionFragment.this;
                a = list;
                super();
            }
        });
        return;
_L2:
        if (s1.equalsIgnoreCase(getString(0x7f080030)))
        {
            s = getString(0x7f08002f);
        } else
        {
            s = s1;
            if (s1.equalsIgnoreCase(getString(0x7f080040)))
            {
                s = getString(0x7f08003f);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void c(List list)
    {
        Object obj = new ArrayList();
        for (list = list.iterator(); list.hasNext(); ((ArrayList) (obj)).add(((AlternateProduct)list.next()).getSkuId())) { }
        ((BBYBaseFragmentActivity)a).changeActionBarShareVisibility(a, false);
        list = new PLPFragmentContainer();
        obj = new PLPFragment(true, "PLP", "", ((ArrayList) (obj)), "", 20);
        ((PDPFragmentContainer)((PDPFragment)getParentFragment()).getParentFragment()).a(list, true);
        list.a(((Fragment) (obj)), true);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        i = layoutinflater;
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f030092, viewgroup, false);
            k = (LinearLayout)c.findViewById(0x7f0c023c);
            j = (RelativeLayout)c.findViewById(0x7f0c0240);
            if (b != null)
            {
                if (b.getProductFamily() != null && b.getProductFamily().size() > 0)
                {
                    int i1 = 0;
                    layoutinflater = null;
                    for (; i1 < b.getProductFamily().size(); i1++)
                    {
                        if (((ProductFamily)b.getProductFamily().get(i1)).getAttributeType().equalsIgnoreCase("color"))
                        {
                            layoutinflater = ((ProductFamily)b.getProductFamily().get(i1)).getOptions();
                        }
                    }

                    if (layoutinflater != null && !layoutinflater.isEmpty())
                    {
                        a(layoutinflater);
                        l = true;
                    }
                }
                if (b.getPriceBlock() != null && b.getPriceBlock().getProductOptions() != null)
                {
                    layoutinflater = b.getPriceBlock().getProductOptions().getAlternateProducts();
                    if (layoutinflater != null && !layoutinflater.isEmpty() && layoutinflater.size() > 0)
                    {
                        b(layoutinflater);
                        l = true;
                    }
                }
            }
            if (!l)
            {
                c.setVisibility(8);
            }
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        return c;
    }
}
