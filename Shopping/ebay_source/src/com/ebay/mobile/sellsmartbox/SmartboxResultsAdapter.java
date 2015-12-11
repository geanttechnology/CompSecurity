// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.util.ThemeUtil;
import java.io.Serializable;
import java.util.List;

public class SmartboxResultsAdapter extends ArrayAdapter
{
    public static final class SmartboxResult
        implements Serializable
    {

        public String epid;
        public String imageUrl;
        public String itemId;
        public String subtext;
        public String text;
        public int type;

        public SmartboxResult()
        {
        }
    }

    public static final class ViewCache
    {

        public final View categoryTitle;
        public final View change;
        public final ImageView image;
        public final TextView subtext;
        public final TextView text;

        public ViewCache(View view)
        {
            image = (ImageView)view.findViewById(0x7f10005e);
            text = (TextView)view.findViewById(0x7f100135);
            subtext = (TextView)view.findViewById(0x7f100137);
            change = view.findViewById(0x7f100711);
            categoryTitle = view.findViewById(0x7f100710);
        }
    }


    private final CharSequence categoryNamePath;
    private final ImageCache imageCache;
    private final LayoutInflater inflater;
    private final String keywords;
    private final String selectedCategory;
    private final String startWithThisText;
    private final ColorStateList textColorBlack;
    private final ColorStateList textColorGrey;

    public SmartboxResultsAdapter(Context context, int i, List list, String s, String s1)
    {
        super(context, i, list);
        keywords = s;
        categoryNamePath = s1;
        inflater = LayoutInflater.from(context);
        imageCache = new ImageCache((Activity)context);
        textColorGrey = ThemeUtil.resolveThemeColorStateList(context.getResources(), context.getTheme(), 0x1010038);
        textColorBlack = ThemeUtil.resolveThemeColorStateList(context.getResources(), context.getTheme(), 0x1010036);
        startWithThisText = context.getString(0x7f070ad1);
        selectedCategory = context.getString(0x7f070ad0);
    }

    private int removeSpecialCasesFromPosition(int i)
    {
        return i - 2;
    }

    public int getCount()
    {
        return super.getCount() + 2;
    }

    public SmartboxResult getItem(int i)
    {
        if (!isCategoryItem(i) && !isContinueItem(i))
        {
            i = removeSpecialCasesFromPosition(i);
            if (i < super.getCount())
            {
                return (SmartboxResult)super.getItem(i);
            }
        }
        return null;
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f030222, null);
            view = new ViewCache(viewgroup);
            viewgroup.setTag(view);
        } else
        {
            viewgroup = view;
            view = (ViewCache)viewgroup.getTag();
        }
        ((ViewCache) (view)).change.setVisibility(8);
        ((ViewCache) (view)).text.setVisibility(8);
        ((ViewCache) (view)).subtext.setVisibility(8);
        ((ViewCache) (view)).categoryTitle.setVisibility(8);
        ((ViewCache) (view)).image.setVisibility(8);
        if (isCategoryItem(i))
        {
            ((ViewCache) (view)).categoryTitle.setVisibility(0);
            ((ViewCache) (view)).subtext.setText(categoryNamePath);
            ((ViewCache) (view)).subtext.setVisibility(0);
            ((ViewCache) (view)).subtext.setTextColor(textColorBlack);
            ((ViewCache) (view)).change.setVisibility(0);
        } else
        {
            if (isContinueItem(i))
            {
                ((ViewCache) (view)).text.setTextAppearance(getContext(), 0x7f0a013e);
                ((ViewCache) (view)).text.setText(keywords);
                ((ViewCache) (view)).text.setVisibility(0);
                ((ViewCache) (view)).subtext.setText(startWithThisText);
                ((ViewCache) (view)).subtext.setTextColor(textColorGrey);
                ((ViewCache) (view)).subtext.setVisibility(0);
                ((ViewCache) (view)).image.setImageResource(0x7f0201f5);
                ((ViewCache) (view)).image.setVisibility(0);
                return viewgroup;
            }
            SmartboxResult smartboxresult = getItem(i);
            if (smartboxresult != null)
            {
                ((ViewCache) (view)).text.setText(smartboxresult.text);
                ((ViewCache) (view)).text.setVisibility(0);
                imageCache.setImage(((ViewCache) (view)).image, smartboxresult.imageUrl);
                ((ViewCache) (view)).image.setVisibility(0);
                return viewgroup;
            }
        }
        return viewgroup;
    }

    public boolean isCategoryItem(int i)
    {
        return i == 0;
    }

    public boolean isContinueItem(int i)
    {
        return i == 1;
    }
}
