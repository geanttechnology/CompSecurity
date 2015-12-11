// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.home.DODHomeCard;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.home.DealOfTheDay;
import com.bestbuy.android.api.lib.models.home.OfferImage;
import com.bestbuy.android.api.lib.models.home.Price;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.ButtonState;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.HashMap;
import java.util.List;

public class du extends PagerAdapter
{

    private List a;
    private LayoutInflater b;
    private Activity c;
    private DODHomeCard d;
    private boolean e;
    private BBYProduct f;
    private HashMap g;

    public du(Activity activity, List list, DODHomeCard dodhomecard, boolean flag)
    {
        a = list;
        c = activity;
        d = dodhomecard;
        e = flag;
        b = activity.getLayoutInflater();
    }

    static List a(du du1)
    {
        return du1.a;
    }

    static Activity b(du du1)
    {
        return du1.c;
    }

    static boolean c(du du1)
    {
        return du1.e;
    }

    static DODHomeCard d(du du1)
    {
        return du1.d;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        ((ViewPager)viewgroup).removeView((FrameLayout)obj);
    }

    public int getCount()
    {
        return a.size();
    }

    public float getPageWidth(int i)
    {
        return 0.87F;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view1 = b.inflate(0x7f0300d7, null);
        dv dv1 = new dv();
        dv1.a = (BBYTextView)view1.findViewById(0x7f0c00c9);
        dv1.b = (ImageView)view1.findViewById(0x7f0c00c8);
        dv1.c = (RatingBar)view1.findViewById(0x7f0c00cb);
        dv1.d = (BBYTextView)view1.findViewById(0x7f0c00cc);
        dv1.e = (LinearLayout)view1.findViewById(0x7f0c00cd);
        dv1.e.removeAllViews();
        f = new BBYProduct();
        if (a != null && a.size() > 0)
        {
            if (a.get(i) != null && ((DealOfTheDay)a.get(i)).getOfferType() != null && ((DealOfTheDay)a.get(i)).getOfferType().equals("customOffer"))
            {
                dv1.a.setText(Html.fromHtml(((DealOfTheDay)a.get(i)).getOfferTitle()));
                g = new HashMap();
                if (((DealOfTheDay)a.get(i)).getPrice() != null)
                {
                    g.put("CurrentPrice", ((DealOfTheDay)a.get(i)).getPrice().getCurrentPrice());
                    g.put("onSale", Boolean.valueOf(((DealOfTheDay)a.get(i)).getPrice().isOnSale()));
                    g.put("SavingsAmount", ((DealOfTheDay)a.get(i)).getPrice().getSavingsAmount());
                    View view = lp.a(c, g);
                    if (view != null)
                    {
                        dv1.e.addView(view);
                    }
                }
                Object obj;
                int j;
                if (((DealOfTheDay)a.get(i)).getOfferImage() != null)
                {
                    obj = ((DealOfTheDay)a.get(i)).getOfferImage().getUrl();
                } else
                {
                    obj = "";
                }
                ng.a(((String) (obj)), dv1.b, true);
                dv1.c.setVisibility(8);
                dv1.d.setVisibility(8);
            } else
            if (a.get(i) != null && ((DealOfTheDay)a.get(i)).getOfferType() != null && ((DealOfTheDay)a.get(i)).getOfferType().equals("product"))
            {
                obj = ((DealOfTheDay)a.get(i)).getPriceBlock();
                f.setPriceBlock(((PriceBlock) (obj)));
                f.setSummary(((DealOfTheDay)a.get(i)).getSummary());
                if (((DealOfTheDay)a.get(i)).getSummary() != null && ((DealOfTheDay)a.get(i)).getSummary().getNames() != null)
                {
                    dv1.a.setText(((DealOfTheDay)a.get(i)).getSummary().getNames().getShortName());
                }
                if (obj != null)
                {
                    obj = lp.a(c, f, 2, false, null, false, "");
                    if (obj != null)
                    {
                        dv1.e.addView(((View) (obj)));
                    }
                }
                if (((DealOfTheDay)a.get(i)).getSummary() != null && ((DealOfTheDay)a.get(i)).getSummary().getMedia() != null && ((DealOfTheDay)a.get(i)).getSummary().getMedia().getPrimaryImage() != null)
                {
                    ng.a(((DealOfTheDay)a.get(i)).getSummary().getMedia().getPrimaryImage().getUrl(), dv1.b, true);
                }
                if (((DealOfTheDay)a.get(i)).getSummary() != null && ((DealOfTheDay)a.get(i)).getSummary().getProductType() != null && ((DealOfTheDay)a.get(i)).getSummary().getProductType().equals("bundle"))
                {
                    dv1.c.setVisibility(8);
                    dv1.d.setVisibility(8);
                } else
                if (((DealOfTheDay)a.get(i)).getSummary() != null && ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings() != null && ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getAverageRating() != null && ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getAverageRating().getScore() == 0.0D)
                {
                    dv1.c.setRating(0.0F);
                    dv1.d.setTextSize(2, 11F);
                    dv1.d.setText(c.getString(0x7f080394));
                }
            }
            if (((DealOfTheDay)a.get(i)).getSummary() != null && ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings() != null && ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getAverageRating() != null && ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getAverageRating().getScore() != 0.0D)
            {
                dv1.c.setVisibility(0);
                dv1.d.setVisibility(0);
                dv1.c.setNumStars(5);
                dv1.c.setRating((float)((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getAverageRating().getScore());
                j = ((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getTotalCount();
                if (j == 1)
                {
                    dv1.d.setText((new StringBuilder()).append("(").append(j).append(" ").append(c.getString(0x7f0802df)).toString());
                    dv1.c.setNumStars(5);
                } else
                {
                    dv1.d.setText((new StringBuilder()).append("(").append(j).append(" ").append(c.getString(0x7f0802e0)).toString());
                    dv1.c.setNumStars(5);
                }
                if (((DealOfTheDay)a.get(i)).getSummary().getCustomerRatings().getTotalCount() > 999)
                {
                    dv1.d.setTextSize(2, 10F);
                } else
                {
                    dv1.d.setTextSize(2, 11F);
                }
            }
            obj = ((DealOfTheDay)a.get(i)).getPriceBlock();
            if (obj != null && ((PriceBlock) (obj)).getButtonState().getButtonStateID() != null && ((PriceBlock) (obj)).getButtonState().getButtonStateID().compareToIgnoreCase(d.getString(0x7f08002e)) == 0)
            {
                obj = (RelativeLayout)view1.findViewById(0x7f0c0350);
                ((RelativeLayout) (obj)).setVisibility(0);
                ((RelativeLayout) (obj)).setOnClickListener(new android.view.View.OnClickListener(i) {

                    final int a;
                    final du b;

                    public void onClick(View view2)
                    {
                        ((HomeActivity)du.b(b)).openPDP(((DealOfTheDay)du.a(b).get(a)).getSummary().getSkuId(), ((DealOfTheDay)du.a(b).get(a)).getSummary().getProductId(), false);
                    }

            
            {
                b = du.this;
                a = i;
                super();
            }
                });
                ((BBYTextView)view1.findViewById(0x7f0c0351)).setText(c.getString(0x7f080328));
            }
        }
        view1.setOnClickListener(new android.view.View.OnClickListener(i) {

            final int a;
            final du b;

            public void onClick(View view2)
            {
                if (du.c(b))
                {
                    view2 = nb.a().c();
                    if (!view2.getBoolean(du.b(b).getString(0x7f08003e), false) && !view2.getBoolean(du.b(b).getString(0x7f08004c), false))
                    {
                        int k = view2.getInt(du.b(b).getString(0x7f080086), 1);
                        if (k >= 10)
                        {
                            (new kt(du.b(b), ku.a)).a();
                        } else
                        {
                            view2 = view2.edit();
                            view2.putInt(du.b(b).getString(0x7f080086), k + 1);
                            view2.commit();
                        }
                    }
                    if (((DealOfTheDay)du.a(b).get(a)).getOfferType().equals("customOffer"))
                    {
                        view2 = ((DealOfTheDay)du.a(b).get(a)).getUrl();
                        du.d(b).a(view2);
                    } else
                    if (((DealOfTheDay)du.a(b).get(a)).getOfferType().equals("product"))
                    {
                        ((HomeActivity)du.b(b)).openPDP(((DealOfTheDay)du.a(b).get(a)).getSummary().getSkuId(), ((DealOfTheDay)du.a(b).get(a)).getSummary().getProductId(), false);
                        return;
                    }
                }
            }

            
            {
                b = du.this;
                a = i;
                super();
            }
        });
        ((ViewPager)viewgroup).addView(view1, 0);
        return view1;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }
}
