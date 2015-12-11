// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.model.SlideShowItem;
import com.gotv.crackle.util.StringUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.freewheel.ad.interfaces.ISlot;

public class HeroPagerAdapter extends PagerAdapter
{

    public static final int SLIDE_SHOW_ITEM_HEIGHT_HANDSET = 350;
    public static final int SLIDE_SHOW_ITEM_HEIGHT_TABLET = 350;
    public static final int SLIDE_SHOW_ITEM_WIDTH_HANDSET = 640;
    public static final int SLIDE_SHOW_ITEM_WIDTH_TABLET = 1024;
    private Map mAdViewMap;
    private Context mCtx;
    public ImageLoader mImageLoader;
    public DisplayImageOptions mImageOptions;
    private List mItems;
    private android.view.View.OnClickListener mOnClickListener;

    public HeroPagerAdapter(Context context, android.view.View.OnClickListener onclicklistener, List list, Map map)
    {
        mAdViewMap = new HashMap();
        mImageLoader = ImageLoader.getInstance();
        mImageOptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).build();
        mCtx = context;
        mAdViewMap = map;
        mItems = list;
        mOnClickListener = onclicklistener;
    }

    private void fillInSlideShowView(SlideShowItem slideshowitem, View view)
    {
        Object obj = new android.widget.LinearLayout.LayoutParams(getSlideShowItemWidth(), getSlideShowItemHeight());
        Object obj1 = (ImageView)view.findViewById(0x7f0a00fa);
        ((ImageView) (obj1)).setImageBitmap(null);
        ((ImageView) (obj1)).setVisibility(0);
        view.setOnClickListener(mOnClickListener);
        ((ImageView) (obj1)).setOnClickListener(mOnClickListener);
        view.setTag(slideshowitem);
        ((ImageView) (obj1)).setTag(slideshowitem);
        ((ImageView) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        if (Application.getInstance().isTablet())
        {
            mImageLoader.displayImage(slideshowitem.getSlideImage_1024x350(), ((ImageView) (obj1)), mImageOptions);
        } else
        {
            mImageLoader.displayImage(slideshowitem.getSlideImage_640x350(), ((ImageView) (obj1)), mImageOptions);
        }
        if (Application.getInstance().isTablet())
        {
            obj = (TextView)view.findViewById(0x7f0a00fe);
            ((TextView) (obj)).setText(StringUtil.ellipsizeAtCount(slideshowitem.getTitle(), 40));
            if (Application.isLeanBack())
            {
                ((TextView) (obj)).setPadding(Application.dpToPx(20), ((TextView) (obj)).getPaddingTop(), Application.dpToPx(20), ((TextView) (obj)).getPaddingBottom());
            }
        }
        obj = (TextView)view.findViewById(0x7f0a00fb);
        if (Application.isKindle7())
        {
            if (Application.getInstance().isLandscape())
            {
                ((TextView) (obj)).setText(StringUtil.ellipsizeAtCount(slideshowitem.getSlideDescription(), 60));
            } else
            {
                ((TextView) (obj)).setText(StringUtil.ellipsizeAtCount(slideshowitem.getSlideDescription(), 37));
            }
        } else
        {
            ((TextView) (obj)).setText(slideshowitem.getSlideDescription());
        }
        if (Application.isLeanBack())
        {
            ((TextView) (obj)).setPadding(Application.dpToPx(20), ((TextView) (obj)).getPaddingTop(), Application.dpToPx(20), ((TextView) (obj)).getPaddingBottom());
        }
        obj = (RelativeLayout)view.findViewById(0x7f0a00fd);
        view = view.findViewById(0x7f0a00fc);
        slideshowitem = (ISlot)mAdViewMap.get(slideshowitem.getSlideID());
        if (slideshowitem != null)
        {
            view = slideshowitem.getBase();
            if (view != null)
            {
                view.setTag("dont_delete");
                obj1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
                view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                try
                {
                    ((ViewGroup)view.getParent()).removeView(view);
                }
                catch (Exception exception) { }
                ((RelativeLayout) (obj)).addView(view);
                slideshowitem.play();
            }
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    private int getPositionInItems(int i)
    {
        int j = 0;
        if (mItems.size() > 0)
        {
            j = i % mItems.size();
        }
        return j;
    }

    private void unbindDrawables(View view)
    {
        if (view.getTag() == null || !(view.getTag() instanceof String) || !((String)view.getTag()).equalsIgnoreCase("dont_delete"))
        {
            if (view.getBackground() != null)
            {
                view.getBackground().setCallback(null);
            }
            if (view instanceof ViewGroup)
            {
                for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++)
                {
                    unbindDrawables(((ViewGroup)view).getChildAt(i));
                }

                ((ViewGroup)view).removeAllViews();
                return;
            }
        }
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        unbindDrawables((View)obj);
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return mItems.size() <= 0 ? 0 : 0xf42400;
    }

    public int getSlideShowItemHeight()
    {
        if (!Application.getInstance().isTablet());
        double d;
        int i;
        if (Application.getInstance().isTablet())
        {
            i = 1024;
        } else
        {
            i = 640;
        }
        d = (double)getSlideShowItemWidth() / (double)i;
        return (int)Math.round((double)350 * d);
    }

    public int getSlideShowItemWidth()
    {
        if (!Application.getInstance().isTablet() && Application.getInstance().isLandscape())
        {
            return (int)((double)Application.getScreenWidth() * 0.56999999999999995D);
        } else
        {
            return Application.getScreenWidth();
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = ((LayoutInflater)mCtx.getSystemService("layout_inflater")).inflate(0x7f030050, null);
        fillInSlideShowView((SlideShowItem)mItems.get(getPositionInItems(i)), view);
        viewgroup.addView(view, 0);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }
}
