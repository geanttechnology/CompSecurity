// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import com.bestbuy.android.activities.browseproduct.pdp.PDPProductAvailabilityContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPBuyingOptionsFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.pdp.ProductOption;
import com.bestbuy.android.api.lib.models.search.BBYStoreAvailability;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MultipleSellers;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Price;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class es extends ArrayAdapter
{

    private ArrayList a;
    private Activity b;
    private LayoutInflater c;
    private BBYBaseFragment d;
    private String e;
    private boolean f;

    public es(Activity activity, BBYBaseFragment bbybasefragment, int i, ArrayList arraylist)
    {
        super(activity, i, arraylist);
        a = arraylist;
        b = activity;
        d = bbybasefragment;
        c = activity.getLayoutInflater();
    }

    static Activity a(es es1)
    {
        return es1.b;
    }

    private int b(String s)
    {
        if (s.equalsIgnoreCase("Pick up Today"))
        {
            return b.getResources().getColor(0x7f0b0007);
        }
        if (s.equalsIgnoreCase("Pick up in 3-5 days"))
        {
            return b.getResources().getColor(0x7f0b0006);
        }
        if (s.equalsIgnoreCase("Not available for pickup"))
        {
            return b.getResources().getColor(0x7f0b000d);
        }
        if (s.equalsIgnoreCase("See details for store pickup"))
        {
            return b.getResources().getColor(0x7f0b0002);
        } else
        {
            return b.getResources().getColor(0x7f0b0006);
        }
    }

    static BBYBaseFragment b(es es1)
    {
        return es1.d;
    }

    public int a(BBYProduct bbyproduct)
    {
        return a.indexOf(bbyproduct);
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public int getPosition(Object obj)
    {
        return a((BBYProduct)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        double d1;
        double d2;
        et et1;
        View view1;
        Summary summary;
        Object obj1;
        boolean flag;
        double d3;
        float f1;
        float f2;
        int j;
        boolean flag1;
        int k;
        if (view == null)
        {
            et1 = new et();
            view1 = c.inflate(0x7f0300bb, viewgroup, false);
            et1.a = (BBYTextView)view1.findViewById(0x7f0c00c9);
            et1.b = (ImageView)view1.findViewById(0x7f0c00c8);
            et1.c = (RatingBar)view1.findViewById(0x7f0c00cb);
            et1.d = (BBYTextView)view1.findViewById(0x7f0c00cc);
            et1.e = (LinearLayout)view1.findViewById(0x7f0c00cd);
            et1.f = (LinearLayout)view1.findViewById(0x7f0c0301);
            et1.g = (LinearLayout)view1.findViewById(0x7f0c0300);
            et1.k = (BBYTextView)view1.findViewById(0x7f0c02ff);
            et1.j = (FrameLayout)view1.findViewById(0x7f0c02fe);
            et1.h = (LinearLayout)view1.findViewById(0x7f0c02fa);
            et1.i = (BBYTextView)view1.findViewById(0x7f0c02fc);
            et1.l = view1.findViewById(0x7f0c02fd);
            view1.setTag(et1);
        } else
        {
            et1 = (et)view.getTag();
            view1 = view;
        }
        et1.e.removeAllViews();
        et1.f.removeAllViews();
        view = (BBYProduct)a.get(i);
        summary = view.getSummary();
        if (view == null) goto _L2; else goto _L1
_L1:
        j = 0;
        viewgroup = view.getPriceBlock();
        Object obj = summary.getNames().getShortName();
        try
        {
            lt.a(b, et1.a, ((String) (obj)), 1000, 0x7f080024);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            ((Exception) (obj1)).printStackTrace();
            et1.a.setText(((String) (obj)));
        }
        et1.c.setNumStars(5);
        f2 = 0.0F;
        f1 = f2;
        if (summary.getCustomerRatings() != null)
        {
            f1 = f2;
            if (summary.getCustomerRatings().getAverageRating() != null)
            {
                f1 = (float)summary.getCustomerRatings().getAverageRating().getScore();
            }
        }
        et1.c.setRating(f1);
        if (f1 != 0.0F)
        {
            i = summary.getCustomerRatings().getTotalCount();
            if (i == 1)
            {
                et1.d.setText((new StringBuilder()).append("(").append(i).append(" ").append(b.getString(0x7f0802df)).toString());
            } else
            if (i == 0)
            {
                et1.d.setText(b.getString(0x7f080394));
            } else
            {
                et1.d.setText((new StringBuilder()).append("(").append(i).append(" ").append(b.getString(0x7f0802e0)).toString());
            }
        } else
        {
            et1.d.setText(b.getString(0x7f080394));
        }
        if (viewgroup == null) goto _L4; else goto _L3
_L3:
        flag1 = false;
        d2 = 0.0D;
        et1.e.setVisibility(0);
        obj = lp.a(b, view, 3, false, null, false, "");
        if (obj != null)
        {
            et1.e.addView(((View) (obj)));
        }
        obj = viewgroup.getProductOptions();
        d1 = d2;
        flag = flag1;
        i = j;
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj = ((ProductOption) (obj)).getMultipleSellers();
        d1 = d2;
        flag = flag1;
        i = j;
        if (obj == null) goto _L6; else goto _L7
_L7:
        d1 = d2;
        flag = flag1;
        i = j;
        if (((ArrayList) (obj)).isEmpty()) goto _L6; else goto _L8
_L8:
        j = 0;
        d1 = 0.0D;
        flag = false;
        i = 0;
_L21:
        if (j >= ((ArrayList) (obj)).size()) goto _L6; else goto _L9
_L9:
        obj1 = (MultipleSellers)((ArrayList) (obj)).get(j);
        flag1 = flag;
        d3 = d1;
        k = i;
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        flag1 = flag;
        d3 = d1;
        k = i;
        if (!((MultipleSellers) (obj1)).getCondition().equals("openBox")) goto _L11; else goto _L12
_L12:
        if (flag) goto _L14; else goto _L13
_L13:
        d2 = ((MultipleSellers) (obj1)).getPrice().getCurrentPrice();
_L17:
        flag = true;
        obj1 = ((MultipleSellers) (obj1)).getPrice().getPricingType();
        if (d2 == 0.0D || ((String) (obj1)).equals("ICR-noPrice") || ((String) (obj1)).equals("ICR-strikeThrough") || ((String) (obj1)).equals("MAP")) goto _L16; else goto _L15
_L15:
        flag1 = flag;
        d3 = d2;
        k = i;
        if (!((String) (obj1)).equals("ICR-hidePrice")) goto _L11; else goto _L16
_L16:
        k = 1;
        d3 = d2;
        flag1 = flag;
_L11:
        j++;
        flag = flag1;
        d1 = d3;
        i = k;
        continue; /* Loop/switch isn't completed */
_L14:
        double d4 = ((MultipleSellers) (obj1)).getPrice().getCurrentPrice();
        d2 = d1;
        if (d1 > d4)
        {
            d2 = d4;
        }
        if (true) goto _L17; else goto _L6
_L6:
        if (flag)
        {
            viewgroup = viewgroup.getPrice();
            if (i != 0 || viewgroup.getPricingType().equals("ICR-noPrice") || viewgroup.getPricingType().equals("ICR-strikeThrough") || viewgroup.getPricingType().equals("MAP") || viewgroup.getPricingType().equals("ICR-hidePrice"))
            {
                et1.k.setText("Open-Box Available");
            } else
            {
                et1.k.setText((new StringBuilder()).append("Open-Box from: $").append(d1).toString());
            }
            et1.j.setVisibility(0);
            et1.l.setVisibility(0);
            et1.j.setOnClickListener(new android.view.View.OnClickListener(view) {

                final BBYProduct a;
                final es b;

                public void onClick(View view2)
                {
                    ((HomeActivity)es.a(b)).setStoreAvailabilityVisible(false);
                    view2 = (BaseFragmentContainer)es.b(b).getParentFragment();
                    PDPProductAvailabilityContainer pdpproductavailabilitycontainer = new PDPProductAvailabilityContainer(" Product Availability ");
                    PLPBuyingOptionsFragment plpbuyingoptionsfragment = new PLPBuyingOptionsFragment(a);
                    view2.a(pdpproductavailabilitycontainer, true);
                    pdpproductavailabilitycontainer.a(plpbuyingoptionsfragment, true);
                }

            
            {
                b = es.this;
                a = bbyproduct;
                super();
            }
            });
        } else
        {
            et1.j.setVisibility(8);
            et1.l.setVisibility(8);
        }
_L19:
label0:
        {
label1:
            {
                if (view.getStoreAvailability() != null && f)
                {
                    et1.h.setVisibility(0);
                    et1.i.setTextColor(b(view.getStoreAvailability().getAvailabilityDisplayMessage()));
                    et1.i.setText(Html.fromHtml((new StringBuilder()).append(view.getStoreAvailability().getAvailabilityDisplayMessage()).append("<br/>").append(e).toString()));
                }
                view = "";
                viewgroup = view;
                if (summary.getMedia() == null)
                {
                    break label0;
                }
                viewgroup = view;
                if (summary.getMedia().getPrimaryImage() != null)
                {
                    viewgroup = summary.getMedia().getPrimaryImage().getUrl();
                }
                view = viewgroup;
                if (viewgroup == null)
                {
                    break label1;
                }
                if (!viewgroup.isEmpty())
                {
                    view = viewgroup;
                    if (!viewgroup.equals(b.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                view = viewgroup;
                if (summary.getMedia().getListImage() != null)
                {
                    view = summary.getMedia().getListImage().getUrl();
                }
            }
            viewgroup = view;
            if (view == null)
            {
                break label0;
            }
            if (!view.isEmpty())
            {
                viewgroup = view;
                if (!view.equals(b.getString(0x7f080068)))
                {
                    break label0;
                }
            }
            viewgroup = view;
            if (summary.getMedia().getThumbnailImage() != null)
            {
                viewgroup = summary.getMedia().getThumbnailImage().getUrl();
            }
        }
        ng.a(viewgroup, et1.b, false);
_L2:
        return view1;
_L4:
        et1.e.setVisibility(8);
        if (true) goto _L19; else goto _L18
_L18:
        if (true) goto _L21; else goto _L20
_L20:
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
