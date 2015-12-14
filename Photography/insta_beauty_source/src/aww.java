// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.sketch.view.TTieZhiCollectionPageScrolllView;
import com.fotoable.sketch.view.TTieZhiCollectionPageView;
import java.util.List;
import java.util.Map;
import viewpagerindicator.CirclePageIndicator;

public class aww extends PagerAdapter
{

    final TTieZhiCollectionPageScrolllView a;

    public aww(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview)
    {
        a = ttiezhicollectionpagescrolllview;
        super();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)a.mRefrenceViewMap.get(Integer.valueOf(i)));
        a.mRefrenceViewMap.remove(Integer.valueOf(i));
    }

    public int getCount()
    {
        if (TTieZhiCollectionPageScrolllView.access$000(a) != null && TTieZhiCollectionPageScrolllView.access$000(a).size() > 0)
        {
            int j = TTieZhiCollectionPageScrolllView.access$000(a).size() / TTieZhiCollectionPageScrolllView.access$400(a);
            int i = j;
            if (TTieZhiCollectionPageScrolllView.access$400(a) * j < TTieZhiCollectionPageScrolllView.access$000(a).size())
            {
                i = j + 1;
            }
            if (i > 1)
            {
                a.mCirclePageIndicator.setVisibility(0);
                return i;
            } else
            {
                a.mCirclePageIndicator.setVisibility(4);
                return i;
            }
        } else
        {
            return 0;
        }
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        TTieZhiCollectionPageView ttiezhicollectionpageview;
        int j;
        int k;
        int l;
        if (a.mRefrenceViewMap.containsKey(Integer.valueOf(i)))
        {
            ttiezhicollectionpageview = (TTieZhiCollectionPageView)a.mRefrenceViewMap.get(Integer.valueOf(i));
        } else
        {
            ttiezhicollectionpageview = new TTieZhiCollectionPageView(a.getContext());
        }
        ttiezhicollectionpageview.setCollectionPageViewLisener(TTieZhiCollectionPageScrolllView.access$500(a));
        ttiezhicollectionpageview.setImageWorker(TTieZhiCollectionPageScrolllView.access$600(a));
        l = i * TTieZhiCollectionPageScrolllView.access$400(a);
        k = TTieZhiCollectionPageScrolllView.access$400(a) + l;
        j = k;
        if (k > TTieZhiCollectionPageScrolllView.access$000(a).size())
        {
            j = TTieZhiCollectionPageScrolllView.access$000(a).size();
        }
        ttiezhicollectionpageview.setDataList(TTieZhiCollectionPageScrolllView.access$000(a).subList(l, j));
        ttiezhicollectionpageview.setTag(Integer.valueOf(i));
        if (i == TTieZhiCollectionPageScrolllView.access$200(a))
        {
            ttiezhicollectionpageview.setItemSelected(TTieZhiCollectionPageScrolllView.access$300(a));
        } else
        {
            ttiezhicollectionpageview.setItemSelected(-1);
        }
        viewgroup.addView(ttiezhicollectionpageview);
        a.mRefrenceViewMap.put(Integer.valueOf(i), ttiezhicollectionpageview);
        return ttiezhicollectionpageview;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
