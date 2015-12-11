// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.consumable.hal.HalLiveFeaturedContent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class LiveFeaturedCarouselPagerAdapter extends PagerAdapter
    implements LiveStreamsFragment.HalLiveFeaturedContentContainer
{

    private final Activity activity;
    private final CoverArtImageLoader coverArtImageLoader;
    private final int imageHeight;
    private final int imageWidth;
    private final LayoutInflater inflater;
    private List liveFeaturedContentList;

    public LiveFeaturedCarouselPagerAdapter(Activity activity1, CoverArtImageLoader coverartimageloader, List list, int i, int j)
    {
        activity = activity1;
        coverArtImageLoader = coverartimageloader;
        liveFeaturedContentList = list;
        imageWidth = i;
        imageHeight = j;
        inflater = (LayoutInflater)activity1.getSystemService("layout_inflater");
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        if (liveFeaturedContentList != null)
        {
            return liveFeaturedContentList.size();
        } else
        {
            return 0;
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        HalLiveFeaturedContent hallivefeaturedcontent = (HalLiveFeaturedContent)liveFeaturedContentList.get(i);
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(com.xfinity.playerlib.R.layout.carousel_item, viewgroup, false);
        Object obj = (ImageView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.image);
        TextView textview3 = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.title);
        TextView textview = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.time);
        TextView textview1 = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.subtitle);
        TextView textview2 = (TextView)viewgroup1.findViewById(com.xfinity.playerlib.R.id.description);
        View view = viewgroup1.findViewById(com.xfinity.playerlib.R.id.gradient);
        android.view.ViewGroup.LayoutParams layoutparams = ((ImageView) (obj)).getLayoutParams();
        if (layoutparams.width < 0)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
            layoutparams.height = displaymetrics.widthPixels / 2;
            i = (int)((double)layoutparams.height / 0.75D);
            view.getLayoutParams().height = (int)((double)i * 0.55000000000000004D);
        }
        coverArtImageLoader.loadImage(hallivefeaturedcontent.getExpandedArtworkLink(imageWidth, imageHeight), ((ImageView) (obj)));
        textview3.setText(hallivefeaturedcontent.getTitle());
        if (hallivefeaturedcontent.getStartDate() != null && hallivefeaturedcontent.getEndDate() != null)
        {
            obj = new SimpleDateFormat("h:mma");
            obj = (new StringBuilder()).append(((DateFormat) (obj)).format(hallivefeaturedcontent.getStartDate())).append(" - ").append(((DateFormat) (obj)).format(hallivefeaturedcontent.getEndDate())).toString();
        } else
        {
            obj = hallivefeaturedcontent.getTimeField();
        }
        textview.setText(((String) (obj)).replaceAll("AM", "a").replaceAll("PM", "p"));
        if (hallivefeaturedcontent.getSubTitle() != null && hallivefeaturedcontent.getSubTitle().length() > 0)
        {
            textview1.setVisibility(0);
            textview1.setText(hallivefeaturedcontent.getSubTitle());
        } else
        {
            textview1.setVisibility(8);
        }
        if (hallivefeaturedcontent.getDescription() != null && hallivefeaturedcontent.getDescription().length() > 0)
        {
            textview2.setVisibility(0);
            textview2.setText(hallivefeaturedcontent.getDescription());
        } else
        {
            textview2.setVisibility(8);
        }
        viewgroup.addView(viewgroup1);
        return viewgroup1;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void setLiveFeaturedContentList(List list)
    {
        liveFeaturedContentList = list;
    }
}
