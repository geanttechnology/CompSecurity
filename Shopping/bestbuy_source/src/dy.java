// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.cart.MyCartFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class dy extends PagerAdapter
{

    private ArrayList a;
    private LayoutInflater b;
    private Activity c;
    private Fragment d;
    private String e;
    private boolean f;
    private int g;
    private String h;
    private String i;

    public dy(Activity activity, ArrayList arraylist, Fragment fragment, boolean flag)
    {
        e = "";
        g = 10;
        h = "";
        a = arraylist;
        c = activity;
        d = fragment;
        f = flag;
        b = activity.getLayoutInflater();
    }

    public dy(Activity activity, ArrayList arraylist, Fragment fragment, boolean flag, String s)
    {
        e = "";
        g = 10;
        h = "";
        a = arraylist;
        c = activity;
        d = fragment;
        f = flag;
        b = activity.getLayoutInflater();
        e = s;
    }

    public dy(Activity activity, ArrayList arraylist, Fragment fragment, boolean flag, String s, String s1)
    {
        e = "";
        g = 10;
        h = "";
        a = arraylist;
        c = activity;
        d = fragment;
        f = flag;
        b = activity.getLayoutInflater();
        e = s;
        h = s1;
    }

    static Fragment a(dy dy1)
    {
        return dy1.d;
    }

    static String a(dy dy1, String s)
    {
        dy1.i = s;
        return s;
    }

    static Activity b(dy dy1)
    {
        return dy1.c;
    }

    static String c(dy dy1)
    {
        return dy1.e;
    }

    static String d(dy dy1)
    {
        return dy1.h;
    }

    public void destroyItem(ViewGroup viewgroup, int j, Object obj)
    {
        ((ViewPager)viewgroup).removeView((FrameLayout)obj);
    }

    public int getCount()
    {
        if (a.size() < g)
        {
            return a.size();
        } else
        {
            return g;
        }
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public float getPageWidth(int j)
    {
        return 0.87F;
    }

    public Object instantiateItem(ViewGroup viewgroup, int j)
    {
label0:
        {
label1:
            {
                BBYProduct bbyproduct = (BBYProduct)a.get(j);
                Summary summary = bbyproduct.getSummary();
                View view = b.inflate(0x7f0300d7, null);
                Object obj1 = (BBYTextView)view.findViewById(0x7f0c00c9);
                ImageView imageview = (ImageView)view.findViewById(0x7f0c00c8);
                RatingBar ratingbar = (RatingBar)view.findViewById(0x7f0c00cb);
                BBYTextView bbytextview = (BBYTextView)view.findViewById(0x7f0c00cc);
                Object obj = (LinearLayout)view.findViewById(0x7f0c00cd);
                ((LinearLayout) (obj)).removeAllViews();
                ((BBYTextView) (obj1)).setText(summary.getNames().getShortName());
                ratingbar.setNumStars(5);
                float f2 = 0.0F;
                float f1 = f2;
                if (summary.getCustomerRatings() != null)
                {
                    f1 = f2;
                    if (summary.getCustomerRatings().getAverageRating() != null)
                    {
                        f1 = (float)summary.getCustomerRatings().getAverageRating().getScore();
                    }
                }
                ratingbar.setRating(f1);
                if (summary.getProductType() != null && summary.getProductType().equals("bundle"))
                {
                    ratingbar.setVisibility(8);
                    bbytextview.setVisibility(8);
                } else
                if (f1 > 0.0F)
                {
                    j = summary.getCustomerRatings().getTotalCount();
                    if (j == 1)
                    {
                        bbytextview.setText((new StringBuilder()).append("(").append(j).append(" ").append(c.getString(0x7f0802df)).toString());
                    } else
                    {
                        bbytextview.setText((new StringBuilder()).append("(").append(j).append(" ").append(c.getString(0x7f0802e0)).toString());
                    }
                    if (j > 999)
                    {
                        bbytextview.setTextSize(2, 10F);
                    } else
                    {
                        bbytextview.setTextSize(2, 11F);
                    }
                } else
                {
                    bbytextview.setTextSize(2, 10F);
                    bbytextview.setText(c.getString(0x7f080394));
                }
                if (bbyproduct.getPriceBlock() != null)
                {
                    obj1 = lp.a(c, bbyproduct, 2, false, null, false, "");
                    if (obj1 != null)
                    {
                        ((LinearLayout) (obj)).addView(((View) (obj1)));
                    }
                }
                obj = "";
                obj1 = obj;
                if (summary.getMedia() == null)
                {
                    break label0;
                }
                obj1 = obj;
                if (summary.getMedia().getPrimaryImage() != null)
                {
                    obj1 = summary.getMedia().getPrimaryImage().getUrl();
                }
                if (!((String) (obj1)).isEmpty())
                {
                    obj = obj1;
                    if (!((String) (obj1)).equals(c.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                obj = obj1;
                if (summary.getMedia().getListImage() != null)
                {
                    obj = summary.getMedia().getListImage().getUrl();
                }
            }
            if (!((String) (obj)).isEmpty())
            {
                obj1 = obj;
                if (!((String) (obj)).equals(c.getString(0x7f080068)))
                {
                    break label0;
                }
            }
            obj1 = obj;
            if (summary.getMedia().getThumbnailImage() != null)
            {
                obj1 = summary.getMedia().getThumbnailImage().getUrl();
            }
        }
        ng.a(((String) (obj1)), imageview, true);
        view.setOnClickListener(new android.view.View.OnClickListener(summary, bbyproduct) {

            final Summary a;
            final BBYProduct b;
            final dy c;

            public void onClick(View view1)
            {
                if (!(dy.a(c) instanceof MyCartFragment)) goto _L2; else goto _L1
_L1:
                Object obj2;
                Object obj3;
                obj2 = ((BBYBaseFragmentActivity)dy.b(c)).getCurrentActionBarTitle();
                view1 = new PDPFragment(a.getSkuId(), (new StringBuilder()).append("").append(a.getProductId()).toString(), false, true, b, "Checkout: Cart \u2013 Empty");
                obj2 = new PDPFragmentContainer(((String) (obj2)));
                obj3 = ((FragmentActivity)dy.b(c)).getSupportFragmentManager().findFragmentById(0x7f0c0033);
                if (!(obj3 instanceof HomeTabFragment)) goto _L4; else goto _L3
_L3:
                obj3 = (HomeTabFragment)obj3;
                ((HomeTabFragment) (obj3)).b().getCurrentTab();
                JVM INSTR tableswitch 0 3: default 152
            //                           0 204
            //                           1 152
            //                           2 152
            //                           3 204;
                   goto _L5 _L6 _L5 _L5 _L6
_L5:
                (new Handler()).postDelayed(new Runnable(this, ((HomeTabFragment) (obj3)), ((PDPFragmentContainer) (obj2)), view1) {

                    final HomeTabFragment a;
                    final PDPFragmentContainer b;
                    final PDPFragment c;
                    final _cls1 d;

                    public void run()
                    {
                        ((BaseTabContainer)a.e()).a(b, true);
                        b.a(c, true);
                    }

            
            {
                d = _pcls1;
                a = hometabfragment;
                b = pdpfragmentcontainer;
                c = pdpfragment;
                super();
            }
                }, 500L);
_L4:
                ((HomeActivity)dy.b(c)).sendRecommendations("cartclickmostpopular", dy.c(c), b);
                return;
_L6:
                ((HomeTabFragment) (obj3)).a(1);
                if (true) goto _L5; else goto _L2
_L2:
                if (dy.c(c).isEmpty())
                {
                    if (b.getSkuId() != null && !b.getSkuId().isEmpty())
                    {
                        ((HomeActivity)dy.b(c)).openPDP(b.getSkuId(), false, (new StringBuilder()).append("").append(a.getProductId()).toString(), false, b, dy.c(c), "");
                        return;
                    } else
                    {
                        ((HomeActivity)dy.b(c)).openPDP(a.getSkuId(), false, (new StringBuilder()).append("").append(a.getProductId()).toString(), false, b, dy.c(c), "");
                        return;
                    }
                }
                if (dy.c(c).equals("customeralsobought"))
                {
                    ((HomeActivity)dy.b(c)).sendRecommendations("clickcustomeralsobought", dy.c(c), b);
                } else
                if (dy.c(c).equals("customeralsoviewed"))
                {
                    ((HomeActivity)dy.b(c)).sendRecommendations("clickcustomeralsoviewed", dy.c(c), b);
                } else
                if (dy.c(c).equals("product"))
                {
                    ((HomeActivity)dy.b(c)).sendRecommendations("productsclickmostpopular", dy.c(c), b);
                } else
                if (dy.c(c).equals("stores"))
                {
                    ((HomeActivity)dy.b(c)).sendRecommendations("storesclickmostpopular", dy.c(c), b);
                } else
                if (dy.c(c).equals("recentlyviewed"))
                {
                    ((HomeActivity)dy.b(c)).sendRecommendations("homeclickrecentlyviewed", dy.c(c), b);
                } else
                if (dy.c(c).equals("GHP"))
                {
                    ((HomeActivity)dy.b(c)).sendRecommendations("homeclicktrendingnow", dy.c(c), b);
                }
                if (b.getSkuId() != null && !b.getSkuId().isEmpty())
                {
                    dy.a(c, b.getSkuId());
                } else
                {
                    dy.a(c, a.getSkuId());
                }
                if (dy.c(c).equalsIgnoreCase("customeralsoviewed") || dy.c(c).equals("customeralsobought"))
                {
                    ((HomeActivity)dy.b(c)).openPDP(b.getSkuId(), false, (new StringBuilder()).append("").append(a.getProductId()).toString(), true, b, dy.c(c), dy.d(c));
                    return;
                } else
                {
                    ((HomeActivity)dy.b(c)).openPDP(b.getSkuId(), false, (new StringBuilder()).append("").append(a.getProductId()).toString(), true, b, dy.c(c), "");
                    return;
                }
            }

            
            {
                c = dy.this;
                a = summary;
                b = bbyproduct;
                super();
            }
        });
        ((ViewPager)viewgroup).addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }
}
