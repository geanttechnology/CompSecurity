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
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class em extends ArrayAdapter
{

    private ArrayList a;
    private Activity b;

    public em(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i, arraylist);
        b = activity;
        a = arraylist;
    }

    public int getCount()
    {
        return a.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
label0:
        {
label1:
            {
                float f;
                View view1;
                Object obj;
                BBYProduct bbyproduct;
                if (view == null)
                {
                    view1 = b.getLayoutInflater().inflate(0x7f0300bb, viewgroup, false);
                    viewgroup = new en();
                    viewgroup.a = (BBYTextView)view1.findViewById(0x7f0c00c9);
                    viewgroup.b = (ImageView)view1.findViewById(0x7f0c00c8);
                    viewgroup.c = (RatingBar)view1.findViewById(0x7f0c00cb);
                    viewgroup.d = (BBYTextView)view1.findViewById(0x7f0c00cc);
                    viewgroup.e = (LinearLayout)view1.findViewById(0x7f0c00cd);
                    view1.setTag(viewgroup);
                } else
                {
                    viewgroup = (en)view.getTag();
                    view1 = view;
                }
                bbyproduct = (BBYProduct)a.get(i);
                if (bbyproduct == null)
                {
                    break label0;
                }
                view = bbyproduct.getSummary().getNames().getShortName();
                try
                {
                    lt.a(b, ((en) (viewgroup)).a, view, 1000, 0x7f080024);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    ((en) (viewgroup)).a.setText(view);
                }
                ((en) (viewgroup)).c.setNumStars(5);
                f = (float)bbyproduct.getSummary().getCustomerRatings().getAverageRating().getScore();
                ((en) (viewgroup)).c.setRating(f);
                i = bbyproduct.getSummary().getCustomerRatings().getTotalCount();
                if (i == 1)
                {
                    ((en) (viewgroup)).d.setText((new StringBuilder()).append("(").append(i).append(" ").append(b.getString(0x7f0802df)).toString());
                } else
                {
                    ((en) (viewgroup)).d.setText((new StringBuilder()).append("(").append(i).append(" ").append(b.getString(0x7f0802e0)).toString());
                }
                if (bbyproduct.getPriceBlock() != null)
                {
                    ((en) (viewgroup)).e.setVisibility(0);
                    view = lp.a(b, bbyproduct, 3, false, null, false, "");
                    if (view != null)
                    {
                        ((en) (viewgroup)).e.removeAllViews();
                        ((en) (viewgroup)).e.addView(view);
                    }
                } else
                {
                    ((en) (viewgroup)).e.setVisibility(8);
                }
                if (bbyproduct.getSummary().getMedia().getListImage().getUrl() == null)
                {
                    break label0;
                }
                obj = bbyproduct.getSummary().getMedia().getListImage().getUrl();
                if (!((String) (obj)).isEmpty())
                {
                    view = ((View) (obj));
                    if (!((String) (obj)).equals(b.getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                view = bbyproduct.getSummary().getMedia().getPrimaryImage().getUrl();
            }
label2:
            {
                if (!view.isEmpty())
                {
                    obj = view;
                    if (!view.equals(b.getString(0x7f080068)))
                    {
                        break label2;
                    }
                }
                obj = bbyproduct.getSummary().getMedia().getThumbnailImage().getUrl();
            }
            ng.a(((String) (obj)), ((en) (viewgroup)).b, true);
        }
        return view1;
    }
}
