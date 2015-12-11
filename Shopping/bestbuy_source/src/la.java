// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mybby.MyBBYHomeActivity;
import com.bestbuy.android.activities.registry.RegistryFragmentContainer;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Properties;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class la extends Dialog
{

    private Context a;
    private ArrayList b;
    private RegistryWishList c;
    private String d[];
    private String e[];
    private ListView f;
    private View g;
    private BBYTextView h;
    private BBYTextView i;
    private BBYTextView j;
    private BBYTextView k;
    private HashMap l;
    private HashMap m;
    private String n;
    private Fragment o;
    private OverviewResponse p;
    private boolean q;
    private String r;

    public la(Context context, Fragment fragment, HashMap hashmap)
    {
        super(context, 0x7f0e002b);
        m = new HashMap();
        a = context;
        o = fragment;
        l = hashmap;
    }

    static OverviewResponse a(la la1, OverviewResponse overviewresponse)
    {
        la1.p = overviewresponse;
        return overviewresponse;
    }

    static String a(la la1, String s)
    {
        la1.n = s;
        return s;
    }

    static HashMap a(la la1)
    {
        return la1.l;
    }

    private void a()
    {
        if (o instanceof HomeTabFragment)
        {
            if (((HomeTabFragment)o).e() instanceof BaseTabContainer)
            {
                Object obj = ((BaseTabContainer)((HomeTabFragment)o).e()).b();
                if (obj instanceof PDPFragmentContainer)
                {
                    obj = (PDPFragment)((PDPFragmentContainer)obj).b();
                    if (obj instanceof PDPFragment)
                    {
                        ((PDPFragment) (obj)).a(false);
                    }
                }
            }
        } else
        if (o instanceof PDPFragmentContainer)
        {
            PDPFragment pdpfragment = (PDPFragment)((PDPFragmentContainer)o).b();
            if (pdpfragment instanceof PDPFragment)
            {
                pdpfragment.a(false);
                return;
            }
        }
    }

    static boolean a(la la1, boolean flag)
    {
        la1.q = flag;
        return flag;
    }

    static OverviewResponse b(la la1)
    {
        return la1.p;
    }

    private void b()
    {
        k.setText("+ Create a New Wedding Registry");
        k.setTextColor(a.getResources().getColor(0x7f0b0000));
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final la a;

            public void onClick(View view)
            {
                a.dismiss();
                view = new HashMap();
                view.put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.f()).append("pdp: Create a Registry").toString());
                lu.a(lu.bf, view);
                if (fr.c() == null)
                {
                    break MISSING_BLOCK_LABEL_187;
                }
                la.a(a, (String)la.a(a).get("sku"));
                view = new RegistryFragmentContainer(true, la.d(a));
                if (!(la.f(a) instanceof HomeTabFragment)) goto _L2; else goto _L1
_L1:
                Fragment fragment = ((HomeTabFragment)la.f(a)).e();
                if ((fragment instanceof HomeTabContainer) || (fragment instanceof ProductTabContainer))
                {
                    ((HomeActivity)la.e(a)).addFragment(0x7f0c0033, view, "RegistryFragmentContainer");
                }
_L4:
                return;
_L2:
                if (!(la.f(a) instanceof PDPFragmentContainer)) goto _L4; else goto _L3
_L3:
                ((HomeActivity)la.e(a)).addFragment(0x7f0c0033, view, "RegistryFragmentContainer");
                return;
                nb.a().k((String)la.a(a).get("sku"));
                view = new Intent(la.e(a), com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
                ((HomeActivity)la.e(a)).startActivityForResult(view, 7892);
                ((HomeActivity)la.e(a)).overridePendingTransition(0x7f04000e, 0x7f040005);
                return;
            }

            
            {
                a = la.this;
                super();
            }
        });
    }

    static void c(la la1)
    {
        la1.a();
    }

    static String d(la la1)
    {
        return la1.n;
    }

    static Context e(la la1)
    {
        return la1.a;
    }

    static Fragment f(la la1)
    {
        return la1.o;
    }

    static View g(la la1)
    {
        return la1.g;
    }

    static RegistryWishList h(la la1)
    {
        return la1.c;
    }

    static ArrayList i(la la1)
    {
        return la1.b;
    }

    static String[] j(la la1)
    {
        return la1.e;
    }

    static HashMap k(la la1)
    {
        return la1.m;
    }

    static boolean l(la la1)
    {
        return la1.q;
    }

    public void onCreate(Bundle bundle)
    {
        android.view.ViewGroup.LayoutParams layoutparams;
        super.onCreate(bundle);
        setContentView(0x7f03002a);
        h = (BBYTextView)findViewById(0x7f0c00b0);
        i = (BBYTextView)findViewById(0x7f0c00b3);
        j = (BBYTextView)findViewById(0x7f0c00b2);
        k = (BBYTextView)findViewById(0x7f0c00b4);
        f = (ListView)findViewById(0x7f0c00b1);
        b = (ArrayList)l.get("WishListData");
        c = (RegistryWishList)l.get("RegistryData");
        g = findViewById(0x7f0c0064);
        r = (String)l.get("RegistryName");
        if (b != null)
        {
            d = new String[b.size()];
            e = new String[b.size()];
            for (int i1 = 0; i1 < b.size(); i1++)
            {
                d[i1] = ((RegistryWishList)b.get(i1)).getShortDescription();
                e[i1] = ((RegistryWishList)b.get(i1)).getUuid();
            }

        }
        if (c != null)
        {
            if (r != null && !r.isEmpty())
            {
                k.setText(c.getShortDescription());
                k.setOnClickListener(new android.view.View.OnClickListener() {

                    final la a;

                    public void onClick(View view)
                    {
                        la.a(a, (String)la.a(a).get("sku"));
                        la.a(a, (OverviewResponse)la.a(a).get("Product"));
                        la.a(a, ((Boolean)la.a(a).get("isFromDNM")).booleanValue());
                        if (la.b(a) != null && la.b(a).getAttributes() != null && la.b(a).getAttributes().isMarketplace() || la.b(a) != null && la.b(a).getCondition() != null && la.b(a).getCondition().equalsIgnoreCase("openbox") || la.b(a).getPriceBlock() != null && la.b(a).getPriceBlock().getProperties() != null && la.b(a).getPriceBlock().getProperties().getContractCondition() != null)
                        {
                            a.dismiss();
                            la.c(a);
                            return;
                        } else
                        {
                            a.dismiss();
                            nb.a().l(true);
                            view = new HashMap();
                            view.put("bb.addToList", "1");
                            view.put("&&products", (new StringBuilder()).append(";").append(la.d(a)).append(";;;;evar48=PDH-WR").toString());
                            lu.b((new StringBuilder()).append(PDPFragment.f()).append("pdp").toString(), view);
                            (new iy((HomeActivity)la.e(a), (BBYBaseFragment)la.f(a), la.g(a), la.h(a).getUuid(), la.d(a), la.h(a).getType(), "1")).executeOnExecutor(nb.g, new Void[0]);
                            return;
                        }
                    }

            
            {
                a = la.this;
                super();
            }
                });
            } else
            {
                b();
            }
        } else
        {
            b();
        }
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final la a;

            public void onClick(View view)
            {
                a.dismiss();
                view = new HashMap();
                view.put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.f()).append("pdp: Create a Wishlist").toString());
                lu.b(lu.be, view);
                if (fr.c() == null)
                {
                    break MISSING_BLOCK_LABEL_178;
                }
                la.a(a, (String)la.a(a).get("sku"));
                view = new WishListFragmentContainer(true, la.d(a));
                if (!(la.f(a) instanceof HomeTabFragment)) goto _L2; else goto _L1
_L1:
                if (((HomeTabFragment)la.f(a)).e() instanceof BaseTabContainer)
                {
                    ((HomeActivity)la.e(a)).addFragment(0x7f0c0033, view, "WishListFragmentContainer");
                }
_L4:
                return;
_L2:
                if (!(la.f(a) instanceof PDPFragmentContainer)) goto _L4; else goto _L3
_L3:
                ((HomeActivity)la.e(a)).addFragment(0x7f0c0033, view, "WishListFragmentContainer");
                return;
                nb.a().k((String)la.a(a).get("sku"));
                view = new Intent(la.e(a), com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
                ((HomeActivity)la.e(a)).startActivityForResult(view, 7891);
                ((HomeActivity)la.e(a)).overridePendingTransition(0x7f04000e, 0x7f040005);
                return;
            }

            
            {
                a = la.this;
                super();
            }
        });
        if (d == null || d.length <= 0) goto _L2; else goto _L1
_L1:
        bundle = new ArrayAdapter(a, 0x7f03010c, d);
        layoutparams = f.getLayoutParams();
        if (d.length > 8) goto _L4; else goto _L3
_L3:
        layoutparams.height = nf.b(Float.valueOf(d.length * 30).floatValue(), a);
        f.setLayoutParams(layoutparams);
_L6:
        f.setAdapter(bundle);
        f.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final la a;

            public void onItemClick(AdapterView adapterview, View view, int j1, long l1)
            {
                int k1 = 0;
                while (k1 < la.i(a).size()) 
                {
                    if (la.j(a)[j1].equals(((RegistryWishList)la.i(a).get(k1)).getUuid()))
                    {
                        la.a(a, (String)la.a(a).get("sku"));
                        la.k(a).put(la.j(a)[j1], la.d(a));
                        la.a(a, (OverviewResponse)la.a(a).get("Product"));
                        la.a(a, ((Boolean)la.a(a).get("isFromDNM")).booleanValue());
                        if (la.b(a) != null && la.b(a).getAttributes() != null && la.b(a).getAttributes().isMarketplace() || la.l(a))
                        {
                            a.dismiss();
                            la.c(a);
                        } else
                        {
                            a.dismiss();
                            nb.a().j(true);
                            adapterview = new HashMap();
                            adapterview.put("bb.addToList", "1");
                            adapterview.put("&&products", (new StringBuilder()).append(";").append(la.d(a)).append(";;;;evar48=PDH-WL").toString());
                            lu.b((new StringBuilder()).append(PDPFragment.f()).append("pdp").toString(), adapterview);
                            (new iy((HomeActivity)la.e(a), (BBYBaseFragment)la.f(a), la.g(a), la.j(a)[j1], la.d(a), ((RegistryWishList)la.i(a).get(k1)).getType(), "1")).executeOnExecutor(nb.g, new Void[0]);
                        }
                    }
                    k1++;
                }
            }

            
            {
                a = la.this;
                super();
            }
        });
_L2:
        return;
_L4:
        if (d.length > 8)
        {
            layoutparams.height = nf.b(Float.valueOf("250").floatValue(), a);
            f.setLayoutParams(layoutparams);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
