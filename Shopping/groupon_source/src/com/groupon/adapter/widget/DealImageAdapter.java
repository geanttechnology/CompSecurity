// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ImageUrl;
import com.groupon.view.imagezoom.ImageViewTouch;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

public class DealImageAdapter extends PagerAdapter
    implements com.groupon.view.imagezoom.ImageViewTouch.OnImageViewTouchDoubleTapListener, com.groupon.view.imagezoom.ImageViewTouch.OnImageViewTouchScaleListener
{

    private String channel;
    private Context context;
    private String dealId;
    private boolean hasLoggedPinchToZoom;
    private List images;
    private LayoutInflater inflater;
    private Logger logger;
    private com.groupon.view.imagezoom.ImageViewTouch.OnImageViewTouchSingleTapListener singleTapListener;

    public DealImageAdapter(Context context1, List list, String s, String s1)
    {
        hasLoggedPinchToZoom = false;
        context = context1;
        images = list;
        dealId = s;
        channel = s1;
        hasLoggedPinchToZoom = false;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        obj = (View)obj;
        Ln.d("PAGER: destroy %s: %s", new Object[] {
            Integer.valueOf(i), obj
        });
        ((ImageViewTouch)((View) (obj)).findViewById(0x7f100268)).clearImage();
        viewgroup.removeView(((View) (obj)));
    }

    public int getCount()
    {
        return images.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = inflater.inflate(0x7f0300cc, null);
        ImageViewTouch imageviewtouch = (ImageViewTouch)view.findViewById(0x7f100268);
        imageviewtouch.setImageUrl((ImageUrl)images.get(i), context.getResources().getDrawable(0x7f02020b), com.groupon.view.UrlImageView.ScaleImageType.CENTER_INSIDE, true);
        imageviewtouch.setDoubleTapListener(this);
        imageviewtouch.setUserScaleListener(this);
        if (singleTapListener != null)
        {
            imageviewtouch.setSingleTapListener(singleTapListener);
        }
        viewgroup.addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void onDoubleTap()
    {
        logger.logUserInteraction("", "tap_to_zoom", channel, dealId, Logger.NULL_NST_FIELD);
    }

    public void onScale()
    {
        if (!hasLoggedPinchToZoom)
        {
            logger.logUserInteraction("", "pinch_to_zoom", channel, dealId, Logger.NULL_NST_FIELD);
            hasLoggedPinchToZoom = true;
        }
    }

    public void setSingleTapListener(com.groupon.view.imagezoom.ImageViewTouch.OnImageViewTouchSingleTapListener onimageviewtouchsingletaplistener)
    {
        singleTapListener = onimageviewtouchsingletaplistener;
    }
}
