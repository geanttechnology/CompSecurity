// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.consumable.hal.HalLiveFeaturedContent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CarouselItemFragment extends Fragment
{

    private final CoverArtImageLoader coverArtImageLoader = PlayerContainer.getInstance().createCoverArtImageLoader();
    private int imageHeight;
    private int imageWidth;
    private HalLiveFeaturedContent liveFeaturedContent;

    public CarouselItemFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            liveFeaturedContent = (HalLiveFeaturedContent)bundle.getParcelable("content");
            imageHeight = bundle.getInt("imageHeight");
            imageWidth = bundle.getInt("imageWidth");
        } else
        {
            bundle = getArguments();
            if (bundle != null)
            {
                liveFeaturedContent = (HalLiveFeaturedContent)bundle.getParcelable("content");
                imageHeight = bundle.getInt("imageHeight");
                imageWidth = bundle.getInt("imageWidth");
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = (ViewGroup)layoutinflater.inflate(com.xfinity.playerlib.R.layout.carousel_item, viewgroup, false);
        layoutinflater = (ImageView)viewgroup.findViewById(com.xfinity.playerlib.R.id.image);
        TextView textview2 = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.title);
        bundle = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.time);
        TextView textview = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.subtitle);
        TextView textview1 = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.description);
        View view = viewgroup.findViewById(com.xfinity.playerlib.R.id.gradient);
        android.view.ViewGroup.LayoutParams layoutparams = layoutinflater.getLayoutParams();
        if (layoutparams.width < 0)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
            layoutparams.height = displaymetrics.widthPixels / 2;
            int i = (int)((double)layoutparams.height / 0.75D);
            view.getLayoutParams().height = (int)((double)i * 0.55000000000000004D);
        }
        coverArtImageLoader.loadImage(liveFeaturedContent.getExpandedArtworkLink(imageWidth, imageHeight), layoutinflater);
        textview2.setText(liveFeaturedContent.getTitle());
        if (liveFeaturedContent.getStartDate() != null && liveFeaturedContent.getEndDate() != null)
        {
            layoutinflater = new SimpleDateFormat("h:mma");
            layoutinflater = (new StringBuilder()).append(layoutinflater.format(liveFeaturedContent.getStartDate())).append(" - ").append(layoutinflater.format(liveFeaturedContent.getEndDate())).toString();
        } else
        {
            layoutinflater = liveFeaturedContent.getTimeField();
        }
        bundle.setText(layoutinflater.replaceAll("AM", "a").replaceAll("PM", "p"));
        if (liveFeaturedContent.getSubTitle() != null && liveFeaturedContent.getSubTitle().length() > 0)
        {
            textview.setVisibility(0);
            textview.setText(liveFeaturedContent.getSubTitle());
        } else
        {
            textview.setVisibility(8);
        }
        if (liveFeaturedContent.getDescription() != null && liveFeaturedContent.getDescription().length() > 0)
        {
            textview1.setVisibility(0);
            textview1.setText(liveFeaturedContent.getDescription());
            return viewgroup;
        } else
        {
            textview1.setVisibility(8);
            return viewgroup;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("imageWidth", imageWidth);
        bundle.putInt("imageHeight", imageHeight);
        bundle.putParcelable("content", liveFeaturedContent);
    }
}
