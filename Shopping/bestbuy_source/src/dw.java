// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.browseproduct.plp.PLPCustomOffersFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.home.OfferImage;
import com.bestbuy.android.api.lib.models.home.Price;
import com.bestbuy.android.api.lib.models.home.pageconfiguration.SIOffer;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.ButtonState;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.HashMap;
import java.util.List;

public class dw extends ArrayAdapter
{

    private List a;
    private Activity b;
    private LayoutInflater c;
    private HashMap d;
    private BBYProduct e;
    private BBYBaseFragment f;

    public dw(Activity activity, BBYBaseFragment bbybasefragment, int i, List list)
    {
        super(activity, i, list);
        a = list;
        b = activity;
        f = bbybasefragment;
        c = activity.getLayoutInflater();
    }

    static List a(dw dw1)
    {
        return dw1.a;
    }

    static Activity b(dw dw1)
    {
        return dw1.b;
    }

    static BBYBaseFragment c(dw dw1)
    {
        return dw1.f;
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemViewType(int i)
    {
        return !((SIOffer)a.get(i)).getOfferType().equalsIgnoreCase("Product") ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = c.inflate(0x7f0300bb, null);
        dx dx1 = new dx();
        dx1.a = (BBYTextView)viewgroup.findViewById(0x7f0c00c9);
        dx1.b = (ImageView)viewgroup.findViewById(0x7f0c00c8);
        dx1.c = (RatingBar)viewgroup.findViewById(0x7f0c00cb);
        dx1.d = (BBYTextView)viewgroup.findViewById(0x7f0c00cc);
        dx1.e = (LinearLayout)viewgroup.findViewById(0x7f0c00cd);
        dx1.e.removeAllViews();
        e = new BBYProduct();
        if (a != null && a.size() > 0)
        {
            if (a.get(i) != null && ((SIOffer)a.get(i)).getOfferType() != null && ((SIOffer)a.get(i)).getOfferType().equals("customOffer"))
            {
                dx1.a.setText(((SIOffer)a.get(i)).getOfferTitle());
                d = new HashMap();
                d.put("CurrentPrice", ((SIOffer)a.get(i)).getPrice().getCurrentPrice());
                d.put("onSale", Boolean.valueOf(((SIOffer)a.get(i)).getPrice().isOnSale()));
                d.put("SavingsAmount", ((SIOffer)a.get(i)).getPrice().getSavingsAmount());
                view = lp.a(b, d);
                if (view != null)
                {
                    dx1.e.addView(view);
                }
                int j;
                if (((SIOffer)a.get(i)).getOfferImage() != null)
                {
                    view = ((SIOffer)a.get(i)).getOfferImage().getUrl();
                } else
                {
                    view = "";
                }
                ng.a(view, dx1.b, true);
                dx1.c.setVisibility(8);
                dx1.d.setVisibility(8);
            } else
            if (a.get(i) != null && ((SIOffer)a.get(i)).getOfferType() != null && ((SIOffer)a.get(i)).getOfferType().equals("product"))
            {
                view = ((SIOffer)a.get(i)).getPriceBlock();
                e.setPriceBlock(view);
                e.setSummary(((SIOffer)a.get(i)).getSummary());
                dx1.a.setText(((SIOffer)a.get(i)).getSummary().getNames().getShortName());
                if (view != null)
                {
                    view = lp.a(b, e, 3, false, null, false, "");
                    if (view != null)
                    {
                        dx1.e.addView(view);
                    }
                }
                if (((SIOffer)a.get(i)).getSummary().getMedia().getPrimaryImage() != null)
                {
                    ng.a(((SIOffer)a.get(i)).getSummary().getMedia().getPrimaryImage().getUrl(), dx1.b, true);
                }
                if (((SIOffer)a.get(i)).getSummary().getProductType().equals("bundle"))
                {
                    dx1.c.setVisibility(8);
                    dx1.d.setVisibility(8);
                } else
                if (((SIOffer)a.get(i)).getSummary() != null && ((SIOffer)a.get(i)).getSummary().getCustomerRatings() != null && ((SIOffer)a.get(i)).getSummary().getCustomerRatings().getAverageRating() != null && ((SIOffer)a.get(i)).getSummary().getCustomerRatings().getAverageRating().getScore() == 0.0D)
                {
                    dx1.c.setRating(0.0F);
                    dx1.d.setTextSize(2, 11F);
                    dx1.d.setText(b.getString(0x7f080394));
                }
            }
            if (((SIOffer)a.get(i)).getSummary() != null && ((SIOffer)a.get(i)).getSummary().getCustomerRatings() != null && ((SIOffer)a.get(i)).getSummary().getCustomerRatings().getAverageRating() != null && ((SIOffer)a.get(i)).getSummary().getCustomerRatings().getAverageRating().getScore() != 0.0D)
            {
                dx1.c.setVisibility(0);
                dx1.d.setVisibility(0);
                dx1.c.setNumStars(5);
                dx1.c.setRating((float)((SIOffer)a.get(i)).getSummary().getCustomerRatings().getAverageRating().getScore());
                j = ((SIOffer)a.get(i)).getSummary().getCustomerRatings().getTotalCount();
                if (j == 1)
                {
                    dx1.d.setText((new StringBuilder()).append("(").append(j).append(" ").append(b.getString(0x7f0802df)).toString());
                    dx1.c.setNumStars(5);
                } else
                {
                    dx1.d.setText((new StringBuilder()).append("(").append(j).append(" ").append(b.getString(0x7f0802e0)).toString());
                    dx1.c.setNumStars(5);
                }
                if (((SIOffer)a.get(i)).getSummary().getCustomerRatings().getTotalCount() > 999)
                {
                    dx1.d.setTextSize(2, 10F);
                } else
                {
                    dx1.d.setTextSize(2, 11F);
                }
            }
            view = ((SIOffer)a.get(i)).getPriceBlock();
            if (view != null && view.getButtonState().getButtonStateID() != null && view.getButtonState().getButtonStateID().compareToIgnoreCase(b.getString(0x7f08002e)) == 0)
            {
                view = (RelativeLayout)viewgroup.findViewById(0x7f0c0350);
                if (view != null)
                {
                    view.setVisibility(0);
                    view.setOnClickListener(new android.view.View.OnClickListener(i) {

                        final int a;
                        final dw b;

                        public void onClick(View view1)
                        {
                            ((HomeActivity)dw.b(b)).openPDP(((SIOffer)dw.a(b).get(a)).getSummary().getSkuId(), ((SIOffer)dw.a(b).get(a)).getSummary().getProductId(), false);
                        }

            
            {
                b = dw.this;
                a = i;
                super();
            }
                    });
                }
                view = (BBYTextView)viewgroup.findViewById(0x7f0c0351);
                if (view != null)
                {
                    view.setText(b.getString(0x7f080328));
                }
            }
        }
        viewgroup.setOnClickListener(new android.view.View.OnClickListener(i) {

            final int a;
            final dw b;

            public void onClick(View view1)
            {
                if (((SIOffer)dw.a(b).get(a)).getOfferType().equals("customOffer"))
                {
                    view1 = ((SIOffer)dw.a(b).get(a)).getUrl();
                    ((PLPCustomOffersFragment)dw.c(b)).a(view1);
                } else
                if (((SIOffer)dw.a(b).get(a)).getOfferType().equals("product"))
                {
                    ((HomeActivity)dw.b(b)).openPDP(((SIOffer)dw.a(b).get(a)).getSummary().getSkuId(), ((SIOffer)dw.a(b).get(a)).getSummary().getProductId(), false);
                    return;
                }
            }

            
            {
                b = dw.this;
                a = i;
                super();
            }
        });
        return viewgroup;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
