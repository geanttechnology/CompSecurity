// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Descriptions;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Media;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class eo extends ArrayAdapter
{

    private ArrayList a;
    private Activity b;

    public eo(Activity activity, int i, ArrayList arraylist)
    {
        super(activity, i, arraylist);
        a = arraylist;
        b = activity;
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
label2:
                {
                    ep ep1;
                    View view1;
                    Summary summary;
                    if (view == null)
                    {
                        view1 = b.getLayoutInflater().inflate(0x7f0300b7, viewgroup, false);
                        ep1 = new ep();
                        ep1.a = (BBYTextView)view1.findViewById(0x7f0c02f0);
                        ep1.b = (ImageView)view1.findViewById(0x7f0c00c8);
                        ep1.c = (BBYTextView)view1.findViewById(0x7f0c02f1);
                        view1.setTag(ep1);
                    } else
                    {
                        ep1 = (ep)view.getTag();
                        view1 = view;
                    }
                    view = (BBYProduct)a.get(i);
                    summary = view.getSummary();
                    if (view == null)
                    {
                        break label0;
                    }
                    view = summary.getNames().getShortName();
                    try
                    {
                        lt.a(b, ep1.a, view, 1000, 0x7f080024);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ViewGroup viewgroup)
                    {
                        viewgroup.printStackTrace();
                        ep1.a.setText(view);
                    }
                    view = Html.fromHtml(summary.getDescriptions().getShortDesc().replaceAll("<ul>", "").replaceAll("</ul>", "").trim()).toString();
                    ep1.c.setText(view);
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
            ng.a(viewgroup, ep1.b, false);
        }
        return view1;
    }
}
