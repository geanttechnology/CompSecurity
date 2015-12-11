// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import hd;
import he;
import iy;
import java.util.ArrayList;
import java.util.HashMap;
import lp;
import lu;
import nb;
import ng;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            ScannedItemFragment

public class ScannedItemCustomerAlsoViewedFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private Activity a;
    private View b;
    private View c;
    private String g;
    private he h;
    private hd i;
    private ArrayList j;
    private View k;
    private LinearLayout l;
    private LayoutInflater m;
    private boolean n;
    private String o;
    private String p;
    private BBYBaseFragment q;

    public ScannedItemCustomerAlsoViewedFragment()
    {
        j = new ArrayList();
    }

    public ScannedItemCustomerAlsoViewedFragment(BBYBaseFragment bbybasefragment, String s, String s1, boolean flag, String s2)
    {
        j = new ArrayList();
        g = s1;
        o = s;
        p = s2;
        q = bbybasefragment;
        n = flag;
    }

    static String a(ScannedItemCustomerAlsoViewedFragment scanneditemcustomeralsoviewedfragment)
    {
        return scanneditemcustomeralsoviewedfragment.p;
    }

    private void a(int i1)
    {
label0:
        {
label1:
            {
                k = m.inflate(0x7f0300d5, null);
                Object obj1 = (BBYTextView)k.findViewById(0x7f0c00c9);
                ImageView imageview = (ImageView)k.findViewById(0x7f0c00c8);
                RatingBar ratingbar = (RatingBar)k.findViewById(0x7f0c00cb);
                BBYTextView bbytextview = (BBYTextView)k.findViewById(0x7f0c00cc);
                Object obj = (LinearLayout)k.findViewById(0x7f0c00cd);
                BBYButton bbybutton = (BBYButton)k.findViewById(0x7f0c034f);
                LinearLayout linearlayout = (LinearLayout)k.findViewById(0x7f0c034e);
                linearlayout.setVisibility(0);
                bbybutton.setVisibility(0);
                BBYProduct bbyproduct = (BBYProduct)j.get(i1);
                Summary summary = bbyproduct.getSummary();
                bbybutton.setOnClickListener(new android.view.View.OnClickListener(bbyproduct) {

                    final BBYProduct a;
                    final ScannedItemCustomerAlsoViewedFragment b;

                    public void onClick(View view)
                    {
                        view = new HashMap();
                        view.put("bb.addToList", "1");
                        if (!ScannedItemCustomerAlsoViewedFragment.a(b).equalsIgnoreCase("weddingregistrylists"))
                        {
                            view.put("&&products", (new StringBuilder()).append(";").append(a.getSkuId()).append(";;;;evar48=LE-WL").toString());
                            lu.b((new StringBuilder()).append(lu.L).append(ScannedItemCustomerAlsoViewedFragment.a(b).substring(0, ScannedItemCustomerAlsoViewedFragment.a(b).length() - 1)).toString(), view);
                            (new iy(ScannedItemCustomerAlsoViewedFragment.b(b), b, null, ScannedItemCustomerAlsoViewedFragment.c(b), a.getSkuId(), ScannedItemCustomerAlsoViewedFragment.a(b), "1")).executeOnExecutor(nb.g, new Void[0]);
                        } else
                        if (ScannedItemCustomerAlsoViewedFragment.a(b).equalsIgnoreCase("weddingregistrylists"))
                        {
                            view.put("&&products", (new StringBuilder()).append(";").append(a.getSkuId()).append(";;;;evar48=WR-WR").toString());
                            lu.b(lu.az, view);
                            (new iy(ScannedItemCustomerAlsoViewedFragment.b(b), b, null, ScannedItemCustomerAlsoViewedFragment.c(b), a.getSkuId(), ScannedItemCustomerAlsoViewedFragment.a(b), "1")).executeOnExecutor(nb.g, new Void[0]);
                            return;
                        }
                    }

            
            {
                b = ScannedItemCustomerAlsoViewedFragment.this;
                a = bbyproduct;
                super();
            }
                });
                if (summary.getCondition() != null && summary.getCondition().equalsIgnoreCase("openBox") || summary.getAttributes() != null && summary.getAttributes().isMarketplace())
                {
                    bbybutton.setVisibility(8);
                    linearlayout.setVisibility(8);
                }
                k.setId(i1);
                ((BBYTextView) (obj1)).setText(summary.getNames().getShortName());
                ((LinearLayout) (obj)).removeAllViews();
                ratingbar.setNumStars(5);
                float f1 = 0.0F;
                float f = f1;
                if (summary.getCustomerRatings() != null)
                {
                    f = f1;
                    if (summary.getCustomerRatings().getAverageRating() != null)
                    {
                        f = (float)summary.getCustomerRatings().getAverageRating().getScore();
                        ratingbar.setRating(f);
                    }
                }
                if (f > 1.0F)
                {
                    bbytextview.setTextSize(2, 11F);
                    bbytextview.setText((new StringBuilder()).append("(").append(summary.getCustomerRatings().getTotalCount()).append(" reviews)").toString());
                } else
                {
                    bbytextview.setTextSize(2, 10F);
                    bbytextview.setText(a.getString(0x7f08027c));
                }
                obj1 = lp.a(a, (BBYProduct)j.get(i1), 1, false, null, false, "");
                if (obj1 != null)
                {
                    ((LinearLayout) (obj)).addView(((View) (obj1)));
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
                    if (!((String) (obj1)).equals(a.getString(0x7f080068)))
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
                if (!((String) (obj)).equals(a.getString(0x7f080068)))
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
        ng.a(((String) (obj1)), imageview, false);
        l.addView(k);
    }

    static Activity b(ScannedItemCustomerAlsoViewedFragment scanneditemcustomeralsoviewedfragment)
    {
        return scanneditemcustomeralsoviewedfragment.a;
    }

    static String c(ScannedItemCustomerAlsoViewedFragment scanneditemcustomeralsoviewedfragment)
    {
        return scanneditemcustomeralsoviewedfragment.o;
    }

    public void a(ArrayList arraylist)
    {
        j.clear();
        j.addAll(arraylist);
        int i1 = 0;
        do
        {
            int j1;
            if (j.size() < 5)
            {
                j1 = j.size();
            } else
            {
                j1 = 5;
            }
            if (i1 < j1)
            {
                a(i1);
                ((LinearLayout)k).setOnClickListener(this);
                i1++;
            } else
            {
                return;
            }
        } while (true);
    }

    public void b()
    {
        ((ScannedItemFragment)q).a("Item Added");
        nb nb1 = nb.a();
        if (p.equalsIgnoreCase("weddingregistrylists"))
        {
            nb1.l(true);
        } else
        {
            nb1.j(true);
        }
        nb1.k(true);
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

    public void onClick(View view)
    {
        view.getId();
        view = (BBYProduct)j.get(view.getId());
        ((HomeActivity)a).openPDP(view.getSkuId(), "", (new StringBuilder()).append("").append(view.getSummary().getProductId()).toString(), false, true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        m = layoutinflater;
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f0300df, viewgroup, false);
            b = c.findViewById(0x7f0c012c);
            l = (LinearLayout)c.findViewById(0x7f0c0363);
            if (!n)
            {
                ((BBYTextView)c.findViewById(0x7f0c0362)).setText("CUSTOMERS ALSO VIEWED");
                h = new he(a, this, b, g);
                h.executeOnExecutor(nb.h, new Void[0]);
            } else
            {
                ((BBYTextView)c.findViewById(0x7f0c0362)).setText("CUSTOMERS ALSO BOUGHT");
                i = new hd(a, this, b, g);
                i.executeOnExecutor(nb.h, new Void[0]);
            }
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (h != null)
        {
            h.cancel(true);
        }
        if (i != null)
        {
            i.cancel(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (l())
        {
            h = new he(a, this, b, g);
            h.executeOnExecutor(nb.h, new Void[0]);
        }
    }
}
