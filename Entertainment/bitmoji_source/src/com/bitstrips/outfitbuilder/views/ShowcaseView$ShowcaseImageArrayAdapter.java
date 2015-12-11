// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bitstrips.outfitbuilder.models.OBShowcaseItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.bitstrips.outfitbuilder.views:
//            ShowcaseView

private class items extends PagerAdapter
{

    ArrayList items;
    final ShowcaseView this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return items.size() != 0 ? 500 : 0;
    }

    public int getStartPage()
    {
        if (items.size() == 0)
        {
            return 0;
        } else
        {
            return (250 / items.size()) * items.size();
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        android.content.Context context = getContext();
        String s = ((OBShowcaseItem)items.get(i % items.size())).getImageURL();
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new android.widget.mageURL(-1, -1));
        Picasso.with(context).load(s).fit().into(imageview);
        viewgroup.addView(imageview);
        return imageview;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public (List list)
    {
        this$0 = ShowcaseView.this;
        super();
        items = new ArrayList();
        for (showcaseview = list.iterator(); hasNext(); items.add(list))
        {
            list = (OBShowcaseItem)next();
        }

    }
}
