// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.browseproduct.pdp.PDPPriceBlockFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Price;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Properties;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

public class lp
{

    private static BBYTextView a;
    private static BBYTextView b;
    private static BBYTextView c;
    private static BBYTextView d;
    private static BBYTextView e;
    private static LinearLayout f;
    private static BBYTextView g;
    private static ImageView h;
    private static boolean i = false;
    private static BBYTextView j;
    private static BBYTextView k;
    private static BBYTextView l;
    private static BBYTextView m;
    private static BBYTextView n;
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static boolean r = false;
    private static boolean s = false;
    private static boolean t = false;
    private static boolean u = false;
    private static boolean v = false;
    private static boolean w = false;
    private static boolean x = false;

    public static View a(Activity activity, BBYProduct bbyproduct, int i1, boolean flag, DNMProduct dnmproduct, boolean flag1, String s1)
    {
        View view;
        LayoutInflater layoutinflater;
        Object obj1;
        Price price;
        Summary summary;
        boolean flag2;
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        t = false;
        u = false;
        v = false;
        w = false;
        x = false;
        price = bbyproduct.getPriceBlock().getPrice();
        summary = bbyproduct.getSummary();
        if (summary != null)
        {
            if (summary.getCondition() != null && bbyproduct.getSummary().getCondition().equals("refurbished"))
            {
                p = true;
            }
            if (summary.getAttributes() != null)
            {
                o = summary.getAttributes().isMarketplace();
            }
        }
        if (price != null && price.getPricingType() != null)
        {
            if (price.getPricingType().equals("onSale"))
            {
                q = true;
            }
            if (price.getPricingType().equals("clearance"))
            {
                s = true;
            }
            if (price.getPricingType().equals("bundle"))
            {
                t = true;
            }
            if (price.getPricingType().equals("ICR-noPrice"))
            {
                u = true;
            }
            if (price.getPricingType().equals("ICR-strikeThrough"))
            {
                v = true;
            }
            if (price.getPricingType().equals("MAP"))
            {
                x = true;
            }
            if (price.getPricingType().equals("ICR-hidePrice"))
            {
                w = true;
            }
            if (price.getPricingType().equals("regular"))
            {
                r = true;
            }
        }
        flag2 = false;
        obj1 = new DecimalFormat("0.00");
        layoutinflater = activity.getLayoutInflater();
        view = null;
        i1;
        JVM INSTR tableswitch 1 4: default 308
    //                   1 339
    //                   2 352
    //                   3 365
    //                   4 378;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (price != null && (!bbyproduct.getSummary().isActive() || w))
        {
            view.setVisibility(8);
            return view;
        }
        break; /* Loop/switch isn't completed */
_L2:
        view = layoutinflater.inflate(0x7f0300c8, null);
        continue; /* Loop/switch isn't completed */
_L3:
        view = layoutinflater.inflate(0x7f0300c7, null);
        continue; /* Loop/switch isn't completed */
_L4:
        view = layoutinflater.inflate(0x7f0300c6, null);
        continue; /* Loop/switch isn't completed */
_L5:
        view = layoutinflater.inflate(0x7f0300c5, null);
        if (true) goto _L1; else goto _L6
_L6:
        f = (LinearLayout)view.findViewById(0x7f0c00cf);
        h = (ImageView)view.findViewById(0x7f0c0283);
        g = (BBYTextView)view.findViewById(0x7f0c0284);
        a = (BBYTextView)view.findViewById(0x7f0c00d8);
        b = (BBYTextView)view.findViewById(0x7f0c031b);
        c = (BBYTextView)view.findViewById(0x7f0c031a);
        d = (BBYTextView)view.findViewById(0x7f0c00d9);
        e = (BBYTextView)view.findViewById(0x7f0c031c);
        m = (BBYTextView)view.findViewById(0x7f0c00d5);
        n = (BBYTextView)view.findViewById(0x7f0c0288);
        if (!flag || dnmproduct == null) goto _L8; else goto _L7
_L7:
        if (m != null)
        {
            m.setVisibility(8);
        }
        Object obj;
        if (flag && !dnmproduct.isICRPrice() && !dnmproduct.isICRStrike() && !dnmproduct.isMapFlag())
        {
            if (dnmproduct.getDnmType().equals(activity.getString(0x7f08012a)))
            {
                b.setVisibility(0);
                b.setText("CLEARANCE");
            }
            d.setVisibility(0);
            String s3 = String.valueOf(String.format("%.2f", new Object[] {
                Double.valueOf(dnmproduct.getSaveAmt())
            }));
            obj = s3;
            try
            {
                if (dnmproduct.getSaveAmt() > 1.0D)
                {
                    obj = s3.replace(s3.substring(s3.indexOf("."), s3.length()), "");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                obj = s3;
            }
            a.setVisibility(0);
            if (dnmproduct.getClearancePrice() % 1.0D == 0.0D)
            {
                a.setText((new StringBuilder()).append("$").append(dnmproduct.getClearancePrice()).toString());
            } else
            {
                a.setText((new StringBuilder()).append("$").append(a(String.valueOf(dnmproduct.getClearancePrice()))).toString());
            }
            if (i1 == 1)
            {
                b.setText((new StringBuilder()).append("SAVE $").append(a(((String) (obj)))).toString());
                if (dnmproduct.getSkuPermRegPrice() % 1.0D == 0.0D)
                {
                    d.setText((new StringBuilder()).append("Reg. $").append(dnmproduct.getSkuPermRegPrice()).toString());
                } else
                {
                    d.setText((new StringBuilder()).append("Reg. $").append(a(String.valueOf(dnmproduct.getSkuPermRegPrice()))).toString());
                }
            } else
            {
                n.setVisibility(0);
                d.setText((new StringBuilder()).append("SAVE $").append(a(((String) (obj)))).toString());
                if (dnmproduct.getSkuPermRegPrice() % 1.0D == 0.0D)
                {
                    n.setText((new StringBuilder()).append("(Reg. $").append(dnmproduct.getSkuPermRegPrice()).append(")").toString());
                } else
                {
                    n.setText((new StringBuilder()).append("(Reg. $").append(a(String.valueOf(dnmproduct.getSkuPermRegPrice()))).append(")").toString());
                }
            }
        }
        if (dnmproduct.isICRPrice() || dnmproduct.isICRStrike())
        {
            if (i1 == 1)
            {
                obj = "See Details \nin Checkout";
                a.setVisibility(4);
            } else
            if (i1 == 4)
            {
                obj = activity.getString(0x7f08035c);
                a.setVisibility(8);
            } else
            {
                obj = activity.getString(0x7f0802af);
                a.setVisibility(8);
            }
            c.setText(((String) (obj)));
            c.setVisibility(0);
            if (dnmproduct.isICRStrike())
            {
                a.setVisibility(0);
                if (dnmproduct.getClearancePrice() % 1.0D == 0.0D)
                {
                    a.setText((new StringBuilder()).append("$").append(dnmproduct.getClearancePrice()).toString());
                } else
                {
                    a.setText((new StringBuilder()).append("$").append(a(String.valueOf(dnmproduct.getClearancePrice()))).toString());
                }
                a.setPaintFlags(a.getPaintFlags() | 0x10);
            }
        }
        if (dnmproduct.isMapFlag())
        {
            c.setVisibility(0);
            if (i1 == 1)
            {
                obj = "See price \nin cart";
                a.setVisibility(4);
            } else
            if (i1 == 4)
            {
                obj = activity.getString(0x7f08035c);
                a.setVisibility(8);
            } else
            {
                obj = "See Price in Cart";
                a.setVisibility(8);
            }
            if (flag1 && i1 == 1)
            {
                c.setVisibility(8);
                a.setVisibility(0);
                d.setVisibility(0);
                if (dnmproduct.getClearancePrice() % 1.0D == 0.0D)
                {
                    a.setText((new StringBuilder()).append("$").append(dnmproduct.getClearancePrice()).toString());
                } else
                {
                    a.setText((new StringBuilder()).append("$").append(a(String.valueOf(dnmproduct.getClearancePrice()))).toString());
                }
                if (dnmproduct.getSkuPermRegPrice() % 1.0D == 0.0D)
                {
                    d.setText((new StringBuilder()).append("Reg. $").append(dnmproduct.getSkuPermRegPrice()).toString());
                } else
                {
                    d.setText((new StringBuilder()).append("Reg. $").append(a(String.valueOf(dnmproduct.getSkuPermRegPrice()))).toString());
                }
            } else
            {
                c.setText(((String) (obj)));
            }
            if (m != null)
            {
                m.setVisibility(0);
                if (dnmproduct.getSkuPermRegPrice() % 1.0D == 0.0D)
                {
                    m.setText((new StringBuilder()).append("Reg.Price: $").append(dnmproduct.getSkuPermRegPrice()).toString());
                } else
                {
                    m.setText((new StringBuilder()).append("Reg.Price: $").append(a(String.valueOf(dnmproduct.getSkuPermRegPrice()))).toString());
                }
            }
        }
_L10:
        c.setOnClickListener(new android.view.View.OnClickListener(price, flag, dnmproduct, i1, bbyproduct, s1, activity, flag1) {

            final Price a;
            final boolean b;
            final DNMProduct c;
            final int d;
            final BBYProduct e;
            final String f;
            final Activity g;
            final boolean h;

            public void onClick(View view1)
            {
                Object obj2 = null;
                if ((a == null || !a.getPricingType().equals("ICR-noPrice") && !a.getPricingType().equals("ICR-strikeThrough")) && (!b || c == null || !c.isICRPrice() && !c.isICRStrike())) goto _L2; else goto _L1
_L1:
                if (d == 4)
                {
                    if (a.getPricingType().equals("ICR-noPrice"))
                    {
                        view1 = new HashMap();
                        view1.put("bb.pdpTap", "1");
                        view1.put("&&products", (new StringBuilder()).append(";").append(e.getPriceBlock().getSkuId()).append(";;").toString());
                        lu.b((new StringBuilder()).append(f).append("pdp").toString(), view1);
                    }
                    view1 = e.getRestrictedPrice();
                    if (view1 != null)
                    {
                        e.getPriceBlock().setPrice(view1);
                        view1 = lp.a(g, e, d, b, c, h, f);
                        PDPPriceBlockFragment.a.removeAllViewsInLayout();
                        PDPPriceBlockFragment.a.addView(view1);
                        view1 = null;
                    } else
                    {
                        view1 = new lb(g, 0x7f0801e4, 0x7f0801e1, 0x7f0801e5, 0x7f0801e2, 0x7f0801e3);
                    }
                } else
                {
                    view1 = new lb(g, 0x7f0801e4, 0x7f0801e1, 0x7f0801e5, 0x7f0801e2, 0x7f0801e3);
                }
_L4:
                if (view1 != null)
                {
                    view1.show();
                }
                return;
_L2:
                if (a == null || !a.getPricingType().equals("MAP"))
                {
                    view1 = obj2;
                    if (!b)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    view1 = obj2;
                    if (c == null)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    view1 = obj2;
                    if (!c.isMapFlag())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }
                if (d == 4)
                {
                    if (a.getPricingType().equals("MAP"))
                    {
                        view1 = new HashMap();
                        view1.put("bb.pdpTap", "1");
                        view1.put("&&products", (new StringBuilder()).append(";").append(e.getPriceBlock().getSkuId()).append(";;").toString());
                        lu.b((new StringBuilder()).append(f).append("pdp").toString(), view1);
                    }
                    view1 = e.getRestrictedPrice();
                    if (view1 != null)
                    {
                        e.getPriceBlock().setPrice(view1);
                        view1 = lp.a(g, e, d, b, c, h, f);
                        PDPPriceBlockFragment.a.removeAllViewsInLayout();
                        PDPPriceBlockFragment.a.addView(view1);
                        view1 = obj2;
                    } else
                    {
                        view1 = new lb(g, 0x7f080224, 0x7f080222, 0x7f080225, 0x7f080223, h, c, e);
                    }
                } else
                {
                    view1 = new lb(g, 0x7f080224, 0x7f080222, 0x7f080225, 0x7f080223, h, c, e);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = price;
                b = flag;
                c = dnmproduct;
                d = i1;
                e = bbyproduct;
                f = s1;
                g = activity;
                h = flag1;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener(summary, activity) {

            final Summary a;
            final Activity b;

            public void onClick(View view1)
            {
                Object obj2 = null;
                if (a.getAttributes() == null || !a.getAttributes().isMarketplace() || a.getCondition() == null || !a.getCondition().equals("refurbished")) goto _L2; else goto _L1
_L1:
                view1 = new lb(b, 0x7f080229, 0x7f080228);
_L4:
                if (view1 != null)
                {
                    view1.show();
                }
                return;
_L2:
                if (a.getAttributes() != null && a.getAttributes().isMarketplace())
                {
                    view1 = new lb(b, 0x7f08022b, 0x7f080227);
                } else
                {
                    view1 = obj2;
                    if (a.getCondition() != null)
                    {
                        view1 = obj2;
                        if (a.getCondition().equals("refurbished"))
                        {
                            view1 = new lb(b, 0x7f0802d2, 0x7f0802d1);
                        }
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = summary;
                b = activity;
                super();
            }
        });
        return view;
_L8:
        if (price == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        double d1 = price.getSavingsAmount();
        String s2;
        String s4;
        String s5;
        String s6;
        int j1;
        if (price.getSavingsAmount() > 1.0D)
        {
            s4 = (new StringBuilder()).append("").append(Math.round(price.getSavingsAmount())).toString();
        } else
        {
            s4 = String.valueOf(d1);
        }
        if (i1 == 1)
        {
            h.setVisibility(8);
        }
        s2 = ((DecimalFormat) (obj1)).format(price.getRegularPrice());
        s5 = s2;
        if (s2.contains(","))
        {
            s5 = s2.replace(",", ".");
        }
        s2 = ((DecimalFormat) (obj1)).format(price.getCurrentPrice());
        s6 = s2;
        if (s2.contains(","))
        {
            s6 = s2.replace(",", ".");
        }
        obj1 = ((DecimalFormat) (obj1)).format(price.getMinimumPriceDisplay());
        if (u || v)
        {
            if (i1 == 1)
            {
                s2 = "See Details \nin checkout";
                a.setVisibility(4);
            } else
            if (i1 == 4)
            {
                s2 = activity.getString(0x7f08035c);
                a.setVisibility(8);
            } else
            {
                s2 = activity.getString(0x7f0802af);
                a.setVisibility(8);
            }
            c.setText(s2);
            c.setVisibility(0);
            if (v)
            {
                a.setVisibility(0);
                if (price.getRegularPrice() % 1.0D == 0.0D)
                {
                    a.setText((new StringBuilder()).append("$").append(s5).toString());
                } else
                {
                    a.setText((new StringBuilder()).append("$").append(a(String.valueOf(s5))).toString());
                }
                a.setPaintFlags(a.getPaintFlags() | 0x10);
            }
            flag2 = true;
        }
        if (x)
        {
            c.setVisibility(0);
            if (i1 == 1)
            {
                s2 = "See price \nin cart";
                a.setVisibility(4);
            } else
            if (i1 == 4)
            {
                s2 = activity.getString(0x7f08035c);
                a.setVisibility(8);
            } else
            {
                s2 = "See Price in Cart";
                a.setVisibility(8);
            }
            c.setText(s2);
            if (m == null)
            {
                break MISSING_BLOCK_LABEL_2875;
            }
            m.setVisibility(0);
            if (!((String) (obj1)).equals("NaN"))
            {
                m.setText((new StringBuilder()).append("Reg.Price: $").append(a(((String) (obj1)))).toString());
                flag2 = true;
            } else
            {
label0:
                {
                    if (s5.equals("NaN"))
                    {
                        break label0;
                    }
                    m.setText((new StringBuilder()).append("Reg.Price: $").append(a(s5)).toString());
                    flag2 = true;
                }
            }
        }
        if (o || i || p)
        {
            s2 = null;
            j1 = -1;
            if (o && p)
            {
                s2 = activity.getString(0x7f080064);
                j1 = 0x7f020110;
            } else
            if (o)
            {
                s2 = activity.getString(0x7f080063);
                j1 = 0x7f020110;
            } else
            if (p)
            {
                s2 = activity.getString(0x7f080077);
                j1 = 0x7f020169;
            }
            a.setText((new StringBuilder()).append("$").append(a(s6)).toString());
            if (i)
            {
                c.setVisibility(0);
                c.setText(activity.getString(0x7f080039));
            } else
            if (i1 != 4)
            {
                f.setVisibility(0);
                g.setText(s2);
                h.setImageResource(j1);
            }
            if (s4 != null && !s4.isEmpty() && !s4.equals("NaN") && !s5.equals("NaN") && !s5.equals("0.00") && !s4.equals("0.00"))
            {
                d.setVisibility(0);
                if (i1 == 1)
                {
                    b.setText((new StringBuilder()).append("SAVE $").append(a(s4)).toString());
                    if (price.getRegularPrice() % 1.0D == 0.0D)
                    {
                        d.setText((new StringBuilder()).append("Reg. $").append(s5).toString());
                    } else
                    {
                        d.setText((new StringBuilder()).append("Reg. $").append(a(String.valueOf(s5))).toString());
                    }
                } else
                {
                    n.setVisibility(0);
                    d.setText((new StringBuilder()).append("SAVE $").append(a(s4)).toString());
                    if (price.getRegularPrice() % 1.0D == 0.0D)
                    {
                        n.setText((new StringBuilder()).append("(Reg. $").append(s5).append(")").toString());
                    } else
                    {
                        n.setText((new StringBuilder()).append("(Reg. $").append(a(String.valueOf(s5))).append(")").toString());
                    }
                }
            }
            if (i1 == 2 && (q || t))
            {
                b.setVisibility(8);
            }
        }
        if ((q || s || t) && !p && !o && !flag2)
        {
            d.setVisibility(0);
            a.setText((new StringBuilder()).append("$").append(s6).toString());
            b.setVisibility(0);
            if (q)
            {
                if (o || p)
                {
                    b.setVisibility(8);
                } else
                {
                    b.setText("ON SALE");
                }
            } else
            if (s)
            {
                b.setText("CLEARANCE");
            } else
            {
                b.setVisibility(8);
            }
            if (s4 != null && !s4.isEmpty() && !s4.equals("NaN") && !s5.equals("NaN"))
            {
                if (i1 == 1)
                {
                    b.setText((new StringBuilder()).append("SAVE $").append(a(s4)).toString());
                    if (price.getRegularPrice() % 1.0D == 0.0D)
                    {
                        d.setText((new StringBuilder()).append("Reg. $").append(s5).toString());
                    } else
                    {
                        d.setText((new StringBuilder()).append("Reg. $").append(a(String.valueOf(s5))).toString());
                    }
                } else
                {
                    n.setVisibility(0);
                    d.setText((new StringBuilder()).append("SAVE $").append(a(s4)).toString());
                    if (price.getRegularPrice() % 1.0D == 0.0D)
                    {
                        n.setText((new StringBuilder()).append("(Reg. $").append(s5).append(")").toString());
                    } else
                    {
                        n.setText((new StringBuilder()).append("(Reg. $").append(a(String.valueOf(s5))).append(")").toString());
                    }
                }
            }
            if (i1 == 2 && (q || t))
            {
                b.setVisibility(8);
            }
        }
        obj1 = null;
        s2 = ((String) (obj1));
        if (bbyproduct.getPriceBlock() != null)
        {
            s2 = ((String) (obj1));
            if (bbyproduct.getPriceBlock().getProperties() != null)
            {
                s2 = bbyproduct.getPriceBlock().getProperties().getContractCondition();
            }
        }
        if (s2 != null)
        {
            b.setVisibility(8);
            if (price.isIbPricing())
            {
                a.setText((new StringBuilder()).append("$").append(a(s6)).append("/mo.").toString());
            } else
            {
                a.setText((new StringBuilder()).append("$").append(a(s6)).toString());
            }
            if (s2.equals("2_YEARS_NEW"))
            {
                if (i1 == 1)
                {
                    s2 = "With 2-yr contract";
                } else
                {
                    s2 = "With new 2-year contract";
                }
            } else
            if (s2.equals("2_YEARS_UPGRADE"))
            {
                if (i1 == 1)
                {
                    s2 = "With 2-yr upgrade";
                } else
                {
                    s2 = "With 2-year upgrade";
                }
            }
            e.setText(s2);
            e.setVisibility(0);
            if (q)
            {
                d.setVisibility(0);
                if (i1 == 1)
                {
                    d.setText((new StringBuilder()).append("SAVE $").append(a(s4)).toString());
                } else
                {
                    n.setVisibility(0);
                    d.setText((new StringBuilder()).append("SAVE $").append(a(s4)).toString());
                    if (price.getRegularPrice() % 1.0D == 0.0D)
                    {
                        n.setText((new StringBuilder()).append("(Reg. $").append(s5).append(")").toString());
                    } else
                    {
                        n.setText((new StringBuilder()).append("(Reg. $").append(a(String.valueOf(s5))).append(")").toString());
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_3527;
        m.setVisibility(8);
        flag2 = true;
        break MISSING_BLOCK_LABEL_2011;
        if (s6 != null && !s6.equals("NaN"))
        {
            if (Double.parseDouble(s6) % 1.0D == 0.0D)
            {
                a.setText((new StringBuilder()).append("$").append(s6).toString());
            } else
            {
                a.setText((new StringBuilder()).append("$").append(a(String.valueOf(s6))).toString());
            }
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static View a(Activity activity, HashMap hashmap)
    {
        View view = activity.getLayoutInflater().inflate(0x7f0300c9, null);
        j = (BBYTextView)view.findViewById(0x7f0c031e);
        k = (BBYTextView)view.findViewById(0x7f0c031f);
        l = (BBYTextView)view.findViewById(0x7f0c0320);
        if (hashmap != null)
        {
            if (hashmap.get("CurrentPrice") != null)
            {
                j.setText(hashmap.get("CurrentPrice").toString());
            }
            if (((Boolean)hashmap.get("onSale")).booleanValue())
            {
                k.setText("ON SALE");
            } else
            {
                k.setVisibility(8);
            }
            if (hashmap.get("SavingsAmount") != null)
            {
                if (hashmap.get("SavingsAmount").toString().contains("You Save:"))
                {
                    activity = hashmap.get("SavingsAmount").toString().replace("You Save:", "SAVE");
                    if (activity.length() > 20)
                    {
                        l.setTextSize(2, 10F);
                    } else
                    {
                        l.setTextSize(2, 12F);
                    }
                } else
                {
                    activity = hashmap.get("SavingsAmount").toString();
                    if (activity.length() > 20)
                    {
                        l.setTextSize(2, 10F);
                    } else
                    {
                        l.setTextSize(2, 12F);
                    }
                }
                l.setText(activity);
            }
        }
        return view;
    }

    private static String a(String s1)
    {
        double d1;
        String s2;
        try
        {
            d1 = Double.parseDouble(s1);
        }
        catch (Exception exception)
        {
            return s1;
        }
        if (d1 < 1000D)
        {
            return s1;
        }
        s2 = (new DecimalFormat("###,###,###.##")).format(d1);
        return s2;
    }

}
