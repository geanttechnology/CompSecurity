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
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class ds extends ArrayAdapter
{

    private Activity a;
    private LayoutInflater b;
    private ArrayList c;

    public ds(Activity activity, ArrayList arraylist)
    {
        super(activity, 0x7f030053, arraylist);
        a = activity;
        c = arraylist;
        b = activity.getLayoutInflater();
    }

    public int a(BBYProduct bbyproduct)
    {
        return c.indexOf(bbyproduct);
    }

    public int getCount()
    {
        int i = 3;
        if (c.size() < 3)
        {
            i = c.size();
        }
        return i;
    }

    public int getPosition(Object obj)
    {
        return a((BBYProduct)obj);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
label0:
        {
label1:
            {
label2:
                {
                    dt dt1;
                    View view1;
                    BBYProduct bbyproduct;
                    Summary summary;
                    if (view == null)
                    {
                        view1 = b.inflate(0x7f030053, viewgroup, false);
                        dt1 = new dt();
                        dt1.a = (ImageView)view1.findViewById(0x7f0c012e);
                        dt1.b = (BBYTextView)view1.findViewById(0x7f0c012f);
                        dt1.c = (LinearLayout)view1.findViewById(0x7f0c00cd);
                        dt1.c.removeAllViews();
                        view1.setTag(dt1);
                        view1.setTag(dt1);
                    } else
                    {
                        dt1 = (dt)view.getTag();
                        view1 = view;
                    }
                    if (c == null || c.isEmpty())
                    {
                        break label0;
                    }
                    bbyproduct = (BBYProduct)c.get(i);
                    summary = bbyproduct.getSummary();
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
                        if (!viewgroup.equals(a.getString(0x7f080068)))
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
                    if (!view.equals(a.getString(0x7f080068)))
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
            ng.a(viewgroup, dt1.a, false);
            dt1.b.setText(summary.getNames().getShortName());
            if (bbyproduct.getPriceBlock() != null)
            {
                view = lp.a(a, bbyproduct, 1, false, null, false, "");
                if (view != null)
                {
                    dt1.c.removeAllViews();
                    dt1.c.addView(view);
                }
            }
        }
        return view1;
    }
}
