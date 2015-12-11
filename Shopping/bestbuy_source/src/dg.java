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
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.Iterator;

public class dg extends ArrayAdapter
{

    private ArrayList a;
    private Activity b;
    private LayoutInflater c;
    private ArrayList d;
    private int e;
    private BBYBaseFragment f;
    private boolean g;
    private boolean h;
    private RegistryWishList i;
    private LinearLayout j;

    public dg(Activity activity, BBYBaseFragment bbybasefragment, int k, ArrayList arraylist, ArrayList arraylist1, int l, LinearLayout linearlayout, 
            RegistryWishList registrywishlist, boolean flag)
    {
        super(activity, k);
        j = null;
        a = arraylist;
        b = activity;
        d = arraylist1;
        e = l;
        f = bbybasefragment;
        j = linearlayout;
        i = registrywishlist;
        h = flag;
        c = activity.getLayoutInflater();
    }

    public dg(Activity activity, BBYBaseFragment bbybasefragment, int k, ArrayList arraylist, ArrayList arraylist1, int l, boolean flag)
    {
        super(activity, k);
        j = null;
        a = arraylist;
        b = activity;
        d = arraylist1;
        e = l;
        f = bbybasefragment;
        g = flag;
        c = activity.getLayoutInflater();
    }

    static Activity a(dg dg1)
    {
        return dg1.b;
    }

    public int a(BBYProduct bbyproduct)
    {
        return a.indexOf(bbyproduct);
    }

    public int a(String s)
    {
        Object obj = d;
        String s1 = "";
        Iterator iterator1 = ((ArrayList) (obj)).iterator();
        do
        {
            obj = s1;
            if (!iterator1.hasNext())
            {
                break;
            }
            obj = (Entities)iterator1.next();
            if (!((Entities) (obj)).getUuid().equals(s))
            {
                continue;
            }
            obj = ((Entities) (obj)).getSku();
            break;
        } while (true);
        s = a;
        for (Iterator iterator = s.iterator(); iterator.hasNext();)
        {
            BBYProduct bbyproduct = (BBYProduct)iterator.next();
            if (bbyproduct.getSkuId().equals(obj))
            {
                return s.indexOf(bbyproduct);
            }
        }

        return -1;
    }

    public void a(int k)
    {
        e = k;
    }

    public int getCount()
    {
        return a.size();
    }

    public int getItemViewType(int k)
    {
        return 0;
    }

    public int getPosition(Object obj)
    {
        return a((BBYProduct)obj);
    }

    public View getView(int k, View view, ViewGroup viewgroup)
    {
label0:
        {
label1:
            {
label2:
                {
                    float f1;
                    float f2;
                    dh dh1;
                    View view1;
                    BBYProduct bbyproduct;
                    Summary summary;
                    if (view == null)
                    {
                        dh1 = new dh();
                        view1 = c.inflate(0x7f03011c, viewgroup, false);
                        dh1.h = (LinearLayout)view1.findViewById(0x7f0c032e);
                        dh1.b = (BBYTextView)view1.findViewById(0x7f0c0427);
                        dh1.a = (ImageView)view1.findViewById(0x7f0c0426);
                        dh1.c = (RatingBar)view1.findViewById(0x7f0c0429);
                        dh1.d = (BBYTextView)view1.findViewById(0x7f0c042a);
                        dh1.f = (LinearLayout)view1.findViewById(0x7f0c00cd);
                        dh1.e = (LinearLayout)view1.findViewById(0x7f0c0301);
                        dh1.g = (LinearLayout)view1.findViewById(0x7f0c0300);
                        view1.setTag(dh1);
                    } else
                    {
                        dh1 = (dh)view.getTag();
                        view1 = view;
                    }
                    dh1.e.removeAllViews();
                    bbyproduct = (BBYProduct)a.get(k);
                    summary = bbyproduct.getSummary();
                    if (d.size() <= 0)
                    {
                        break label0;
                    }
                    view = (Entities)d.get(k);
                    if (bbyproduct == null)
                    {
                        break label0;
                    }
                    viewgroup = summary.getNames().getShortName();
                    try
                    {
                        lt.a(getContext(), dh1.b, viewgroup, 1000, 0x7f080024);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        dh1.b.setText(viewgroup);
                    }
                    dh1.c.setNumStars(5);
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
                    dh1.c.setRating(f1);
                    if (summary.getCustomerRatings() != null)
                    {
                        k = summary.getCustomerRatings().getTotalCount();
                        dh1.d.setText((new StringBuilder()).append("( ").append(k).append(" reviews )").toString());
                    }
                    if (bbyproduct.getPriceBlock() != null)
                    {
                        viewgroup = lp.a(b, bbyproduct, 3, false, null, false, "");
                        if (viewgroup != null)
                        {
                            dh1.f.removeAllViews();
                            dh1.f.addView(viewgroup);
                        }
                    }
                    if (g)
                    {
                        view = mo.a(b, f, bbyproduct, view, e, g, j, i);
                    } else
                    if (h)
                    {
                        view = mo.a(b, f, bbyproduct, view, e, h, j, i);
                    } else
                    {
                        view = mo.a(b, f, bbyproduct, view, e, false, j, i);
                    }
                    if (view != null)
                    {
                        dh1.e.addView(view);
                    }
                    view = "";
                    viewgroup = view;
                    if (summary.getMedia() == null)
                    {
                        break label1;
                    }
                    viewgroup = view;
                    if (summary.getMedia().getPrimaryImage() != null)
                    {
                        viewgroup = summary.getMedia().getPrimaryImage().getUrl();
                    }
                    if (!viewgroup.isEmpty())
                    {
                        view = viewgroup;
                        if (!viewgroup.equals(b.getString(0x7f080068)))
                        {
                            break label2;
                        }
                    }
                    view = viewgroup;
                    if (summary.getMedia().getListImage() != null)
                    {
                        view = summary.getMedia().getListImage().getUrl();
                    }
                }
                if (!view.isEmpty())
                {
                    viewgroup = view;
                    if (!view.equals(b.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                viewgroup = view;
                if (summary.getMedia().getThumbnailImage() != null)
                {
                    viewgroup = summary.getMedia().getThumbnailImage().getUrl();
                }
            }
            ng.a(viewgroup, dh1.a, false);
        }
        dh1.h.setOnClickListener(new android.view.View.OnClickListener(bbyproduct) {

            final BBYProduct a;
            final dg b;

            public void onClick(View view2)
            {
                ((HomeActivity)dg.a(b)).openPDP(a.getSkuId(), "", a.getSummary().getProductId(), false, true);
            }

            
            {
                b = dg.this;
                a = bbyproduct;
                super();
            }
        });
        return view1;
    }

    public int getViewTypeCount()
    {
        return 2;
    }
}
