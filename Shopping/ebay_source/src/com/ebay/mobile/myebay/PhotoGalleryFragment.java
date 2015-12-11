// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.ebay.common.util.ImageCache;
import java.util.ArrayList;

public class PhotoGalleryFragment extends DialogFragment
{
    private final class PhotoGalleryFragmentAdapter extends PagerAdapter
    {

        private final ArrayList imageUrls;
        final PhotoGalleryFragment this$0;
        private final ArrayList views = new ArrayList();

        private View getItem(ViewGroup viewgroup, int i)
        {
            viewgroup = (String)imageUrls.get(i);
            View view1 = LayoutInflater.from(getActivity()).inflate(0x7f030199, null);
            ImageView imageview = (ImageView)view1.findViewById(0x7f10005b);
            i = (int)(0.80000000000000004D * (double)getResources().getDisplayMetrics().heightPixels);
            imageview.setMinimumHeight(i);
            imageview.setMinimumWidth(i);
            if (viewgroup == null)
            {
                imageview.setImageResource(0x7f02027a);
                return view1;
            } else
            {
                imageCache.setImage(imageview, viewgroup);
                return view1;
            }
        }

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView((View)obj);
            if (i < views.size())
            {
                views.set(i, null);
            }
        }

        public int getCount()
        {
            return imageUrls.size();
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            int k = getCount();
            int j = k;
            if (i + 1 > k)
            {
                j = i + 1;
            }
            if (views.size() < j)
            {
                views.ensureCapacity(j);
                for (; views.size() < j; views.add(null)) { }
            }
            View view2 = (View)views.get(i);
            View view1 = view2;
            if (view2 == null)
            {
                view1 = getItem(viewgroup, i);
                views.set(i, view1);
                viewgroup.addView(view1);
            }
            return view1;
        }

        public boolean isViewFromObject(View view1, Object obj)
        {
            return obj == view1;
        }

        public PhotoGalleryFragmentAdapter(ArrayList arraylist)
        {
            this$0 = PhotoGalleryFragment.this;
            super();
            imageUrls = arraylist;
        }
    }


    private static final String PARAM_IMAGE_URLS = "com.ebay.mobile.param.image_urls";
    private static final String PARAM_SELECTED_IMAGE = "com.ebay.mobile.param.image_url";
    ImageCache imageCache;
    private ArrayList imageUrls;
    private String selectedImage;
    private View view;

    public PhotoGalleryFragment()
    {
    }

    public static PhotoGalleryFragment newInstance(ArrayList arraylist, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("com.ebay.mobile.param.image_urls", arraylist);
        bundle.putString("com.ebay.mobile.param.image_url", s);
        arraylist = new PhotoGalleryFragment();
        arraylist.setArguments(bundle);
        return arraylist;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        imageCache = new ImageCache(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        imageUrls = bundle.getStringArrayList("com.ebay.mobile.param.image_urls");
        selectedImage = bundle.getString("com.ebay.mobile.param.image_url");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f030198, viewgroup, false);
        layoutinflater = getDialog().getWindow();
        layoutinflater.requestFeature(1);
        layoutinflater.setBackgroundDrawable(new ColorDrawable(0));
        layoutinflater = (ViewPager)view.findViewById(0x7f1004ae);
        layoutinflater.setAdapter(new PhotoGalleryFragmentAdapter(imageUrls));
        if (selectedImage != null)
        {
            layoutinflater.setCurrentItem(imageUrls.indexOf(selectedImage));
        }
        return view;
    }

    public void onDetach()
    {
        imageCache.clearImageFetching();
        imageCache = null;
        super.onDetach();
    }
}
