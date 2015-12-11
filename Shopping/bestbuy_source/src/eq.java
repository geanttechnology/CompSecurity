// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.browseproduct.pdp.PDPSourceProductAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPBuyingOptionsFragment;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.Availability;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsList;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.PickUpAvailability;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.Price;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.Properties;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.SellerImages;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.SellerInfo;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.ShipAvailability;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class eq extends ArrayAdapter
{

    private Context a;
    private ArrayList b;
    private LayoutInflater c;
    private Fragment d;
    private LinearLayout e;
    private View f;
    private String g;

    public eq(Context context, Fragment fragment, LinearLayout linearlayout, View view, int i, ArrayList arraylist, String s)
    {
        super(context, i, arraylist);
        a = context;
        d = fragment;
        b = arraylist;
        e = linearlayout;
        f = view;
        g = s;
        if (context != null)
        {
            c = LayoutInflater.from(context);
        }
    }

    static Fragment a(eq eq1)
    {
        return eq1.d;
    }

    private LinearLayout a(BuyingOptionsList buyingoptionslist)
    {
        LinearLayout linearlayout = (LinearLayout)c.inflate(0x7f03008c, null);
        BBYTextView bbytextview = (BBYTextView)linearlayout.findViewById(0x7f0c00d4);
        BBYTextView bbytextview1 = (BBYTextView)linearlayout.findViewById(0x7f0c0223);
        bbytextview1.setPaintFlags(bbytextview1.getPaintFlags());
        if (buyingoptionslist.getPrice() != null)
        {
            String s = fr.j();
            if (s != null && !s.equals("10130"))
            {
                bbytextview1.setVisibility(0);
                bbytextview1.setText((new StringBuilder()).append("$").append(a(buyingoptionslist.getPrice().getCurrentPrice())).toString());
                bbytextview.setVisibility(8);
            } else
            if (buyingoptionslist.getPrice().getPricingType().equals("regular"))
            {
                bbytextview1.setVisibility(0);
                bbytextview1.setText((new StringBuilder()).append("$").append(a(buyingoptionslist.getPrice().getTotalPrice())).toString());
                bbytextview.setVisibility(8);
            } else
            if (buyingoptionslist.getPrice().getPricingType().equals("MAP"))
            {
                bbytextview.setText("See Price in Cart");
                bbytextview.setVisibility(0);
                bbytextview1.setVisibility(8);
            } else
            if (buyingoptionslist.getPrice().getPricingType().equals("ICR-noPrice"))
            {
                bbytextview.setText(a.getString(0x7f0802af));
                bbytextview.setVisibility(0);
                bbytextview1.setVisibility(8);
            } else
            if (buyingoptionslist.getPrice().getPricingType().equals("ICR-strikeThrough"))
            {
                bbytextview.setText(a.getString(0x7f0802af));
                bbytextview.setVisibility(0);
                bbytextview1.setText((new StringBuilder()).append("$").append(a(buyingoptionslist.getPrice().getRegularPrice())).toString());
                bbytextview1.setPaintFlags(bbytextview1.getPaintFlags() | 0x10);
            } else
            if (buyingoptionslist.getPrice().getPricingType().equals("ICR-hidePrice"))
            {
                bbytextview1.setVisibility(8);
                bbytextview.setVisibility(8);
            } else
            {
                bbytextview1.setVisibility(0);
                bbytextview1.setText((new StringBuilder()).append("$").append(a(buyingoptionslist.getPrice().getCurrentPrice())).toString());
                bbytextview.setVisibility(8);
            }
            bbytextview.setOnClickListener(new android.view.View.OnClickListener(buyingoptionslist) {

                final BuyingOptionsList a;
                final eq b;

                public void onClick(View view)
                {
                    view = null;
                    if (!a.getPrice().getPricingType().equals("ICR-noPrice") && !a.getPrice().getPricingType().equals("ICR-strikeThrough")) goto _L2; else goto _L1
_L1:
                    view = new lb(eq.c(b), 0x7f0801e4, 0x7f0801e1, 0x7f0801e5, 0x7f0801e2, 0x7f0801e3);
_L4:
                    if (view != null)
                    {
                        view.show();
                    }
                    return;
_L2:
                    if (a.getPrice().getPricingType().equals("MAP"))
                    {
                        view = new lb(eq.c(b), 0x7f080224, 0x7f080222, 0x7f080225, 0x7f080223);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                b = eq.this;
                a = buyingoptionslist;
                super();
            }
            });
        }
        return linearlayout;
    }

    private String a(double d1)
    {
        if (d1 % 1.0D == 0.0D)
        {
            return String.format("%.2f", new Object[] {
                Double.valueOf(d1)
            });
        }
        String s;
        try
        {
            s = (new DecimalFormat("###,###,###.##")).format(d1);
        }
        catch (Exception exception)
        {
            return String.valueOf(d1);
        }
        return s;
    }

    static String b(eq eq1)
    {
        return eq1.g;
    }

    static Context c(eq eq1)
    {
        return eq1.a;
    }

    public int getCount()
    {
        return b.size();
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        BuyingOptionsList buyingoptionslist;
        String s1;
        boolean flag;
        if (view == null)
        {
            view = c.inflate(0x7f03008b, viewgroup, false);
            viewgroup = new er();
            viewgroup.a = (LinearLayout)view.findViewById(0x7f0c0212);
            viewgroup.f = (BBYTextView)view.findViewById(0x7f0c0213);
            viewgroup.b = (LinearLayout)view.findViewById(0x7f0c0214);
            viewgroup.g = (BBYTextView)view.findViewById(0x7f0c0215);
            viewgroup.h = (BBYTextView)view.findViewById(0x7f0c0216);
            viewgroup.c = (LinearLayout)view.findViewById(0x7f0c01ff);
            viewgroup.i = (BBYTextView)view.findViewById(0x7f0c0219);
            viewgroup.e = (LinearLayout)view.findViewById(0x7f0c021a);
            viewgroup.j = (BBYTextView)view.findViewById(0x7f0c021b);
            viewgroup.d = (LinearLayout)view.findViewById(0x7f0c021d);
            viewgroup.k = (BBYTextView)view.findViewById(0x7f0c021e);
            viewgroup.l = (BBYTextView)view.findViewById(0x7f0c021f);
            viewgroup.m = (BBYTextView)view.findViewById(0x7f0c021c);
            viewgroup.n = (RelativeLayout)view.findViewById(0x7f0c0220);
            viewgroup.o = (ImageView)view.findViewById(0x7f0c0217);
            viewgroup.p = (RelativeLayout)view.findViewById(0x7f0c0221);
            viewgroup.q = (RelativeLayout)view.findViewById(0x7f0c00cd);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (er)view.getTag();
        }
        buyingoptionslist = (BuyingOptionsList)b.get(i);
        if (buyingoptionslist == null) goto _L2; else goto _L1
_L1:
        if (!buyingoptionslist.getCondition().isEmpty())
        {
            String s = buyingoptionslist.getCondition().toLowerCase();
            if (s.equalsIgnoreCase("openbox"))
            {
                flag = buyingoptionslist.isDisplayCertifiedLogo();
                s1 = buyingoptionslist.getDisplayCondition().replace("Open-Box", "").trim();
                s = s1;
                if (flag)
                {
                    s = (new StringBuilder()).append("Certified \n").append(s1).toString();
                }
                s = (new StringBuilder()).append(s).append("\n").append("Condition").toString();
            } else
            {
                s = (new StringBuilder()).append(Character.toString(s.charAt(0)).toUpperCase()).append(s.substring(1)).toString();
            }
            ((er) (viewgroup)).f.setText(s);
        }
        if (buyingoptionslist.getSellerInfo() != null && buyingoptionslist.getSellerInfo().getSellerName().equalsIgnoreCase("BestBuy"))
        {
            ((er) (viewgroup)).g.setVisibility(8);
            ((er) (viewgroup)).h.setVisibility(0);
        } else
        {
            ((er) (viewgroup)).g.setVisibility(0);
            ((er) (viewgroup)).h.setVisibility(8);
            ((er) (viewgroup)).g.setText(buyingoptionslist.getSellerInfo().getSellerName());
        }
        if (buyingoptionslist.getSellerInfo().getImages() != null && ((SellerImages)buyingoptionslist.getSellerInfo().getImages().get(0)).getUrl() != null && !((SellerImages)buyingoptionslist.getSellerInfo().getImages().get(0)).getUrl().isEmpty())
        {
            ((er) (viewgroup)).o.setVisibility(0);
            ng.a(((SellerImages)buyingoptionslist.getSellerInfo().getImages().get(0)).getUrl(), ((er) (viewgroup)).o, false);
        } else
        {
            ((er) (viewgroup)).o.setVisibility(8);
        }
        if (buyingoptionslist.getAvailability() != null && buyingoptionslist.getAvailability().getShip() != null && buyingoptionslist.getAvailability().getShip().getDisplayMessage() != null && !buyingoptionslist.getAvailability().getShip().getDisplayMessage().isEmpty())
        {
            s = buyingoptionslist.getAvailability().getShip().getDisplayMessage().replace("<b>Shipping:</b>", "").replace("<b>Shipping</b>:", "").trim();
            ((er) (viewgroup)).i.setText(s);
        }
        if (buyingoptionslist.getAvailability() != null && buyingoptionslist.getAvailability().getPickup() != null && buyingoptionslist.getAvailability().getPickup().getDisplayMessage() != null && !buyingoptionslist.getAvailability().getPickup().getDisplayMessage().isEmpty())
        {
            if (!buyingoptionslist.getAvailability().getPickup().getDisplayMessage().replace("<b>Store Pickup:</b>", "").trim().isEmpty())
            {
                ((er) (viewgroup)).j.setText(buyingoptionslist.getAvailability().getPickup().getDisplayMessage().replace("<b>Store Pickup:</b>", "").trim());
            } else
            if (buyingoptionslist.getAvailability() != null && buyingoptionslist.getAvailability().getPickup() != null && buyingoptionslist.getAvailability().getPickup().isAvailable())
            {
                ((er) (viewgroup)).j.setText("Available");
            } else
            {
                ((er) (viewgroup)).j.setText("Not Available");
            }
        } else
        if (buyingoptionslist.getAvailability() != null && buyingoptionslist.getAvailability().getPickup() != null && buyingoptionslist.getAvailability().getPickup().isAvailable())
        {
            ((er) (viewgroup)).j.setText("Available");
        } else
        {
            ((er) (viewgroup)).j.setText("Not Available");
        }
        ((er) (viewgroup)).q.removeAllViews();
        ((er) (viewgroup)).q.addView(a(buyingoptionslist));
        if (buyingoptionslist.getPrice() == null || buyingoptionslist.getPrice().getPricingType().equals("ICR-noPrice") || buyingoptionslist.getPrice().getPricingType().equals("MAP") || buyingoptionslist.getPrice().getPricingType().equals("ICR-hidePrice") || buyingoptionslist.getPrice().getPricingType().equals("ICR-strikeThrough")) goto _L4; else goto _L3
_L3:
        if (buyingoptionslist.getPrice().getShippingCost() > 0.0D)
        {
            ((er) (viewgroup)).m.setVisibility(0);
            s = String.valueOf(String.format("%.2f", new Object[] {
                Double.valueOf(buyingoptionslist.getPrice().getShippingCost())
            }));
            ((er) (viewgroup)).m.setText((new StringBuilder()).append("Includes shipping:$").append(s).toString());
        } else
        {
            ((er) (viewgroup)).m.setVisibility(8);
        }
        if (buyingoptionslist.getProperties() == null) goto _L6; else goto _L5
_L5:
        if (buyingoptionslist.getProperties().getFreeShippingCode() == null || buyingoptionslist.getProperties().getFreeShippingCode().isEmpty()) goto _L8; else goto _L7
_L7:
        ((er) (viewgroup)).d.setVisibility(0);
        if (!buyingoptionslist.getProperties().getFreeShippingCode().equals("freeShipping")) goto _L9; else goto _L6
_L6:
        ((er) (viewgroup)).p.setVisibility(8);
        ((er) (viewgroup)).n.setVisibility(0);
        ((er) (viewgroup)).g.setOnClickListener(new android.view.View.OnClickListener(buyingoptionslist) {

            final BuyingOptionsList a;
            final eq b;

            public void onClick(View view1)
            {
                if (a.getSellerInfo() != null && !a.getSellerInfo().getSellerName().equalsIgnoreCase("BestBuy"))
                {
                    view1 = (new StringBuilder()).append("http://www.bestbuy.com").append(a.getSellerInfo().getSellerUrl()).toString();
                    if (eq.a(b) instanceof PDPSourceProductAvailabilityFragment)
                    {
                        ((PDPSourceProductAvailabilityFragment)eq.a(b)).a(view1);
                    } else
                    if (eq.a(b) instanceof PLPBuyingOptionsFragment)
                    {
                        ((PLPBuyingOptionsFragment)eq.a(b)).a(view1);
                        return;
                    }
                }
            }

            
            {
                b = eq.this;
                a = buyingoptionslist;
                super();
            }
        });
        ((er) (viewgroup)).n.setOnClickListener(new android.view.View.OnClickListener(buyingoptionslist) {

            final BuyingOptionsList a;
            final eq b;

            public void onClick(View view1)
            {
                view1 = a.getSellerInfo().getSellerId();
                String s2 = a.getProductId();
                view1 = (new StringBuilder()).append("http://www.bestbuy.com/m/e/product/morebuyingoptions.jsp?checkForPlansAndAccessories=true&skuId=").append(eq.b(b)).append("&sellerId=").append(view1).append("&productId=").append(s2).toString();
                (new ky(eq.c(b), eq.a(b), view1)).a();
            }

            
            {
                b = eq.this;
                a = buyingoptionslist;
                super();
            }
        });
_L2:
        return view;
_L9:
        if (buyingoptionslist.getProperties().getFreeShippingCode().equals("freeShipping35"))
        {
            ((er) (viewgroup)).l.setVisibility(0);
            ((er) (viewgroup)).l.setText("on Orders $35 and Up");
        } else
        if (buyingoptionslist.getProperties().getFreeShippingCode().equals("freeShipping25"))
        {
            ((er) (viewgroup)).l.setVisibility(0);
            ((er) (viewgroup)).l.setText("on Orders $25 and Up");
        }
        continue; /* Loop/switch isn't completed */
_L8:
        ((er) (viewgroup)).k.setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L4:
        ((er) (viewgroup)).k.setVisibility(8);
        ((er) (viewgroup)).m.setVisibility(8);
        if (true) goto _L6; else goto _L10
_L10:
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
