// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPager;
import android.view.animation.AnimationUtils;
import com.fotoable.sketch.view.TTieZhiCollectionPageScrolllView;
import java.util.List;
import java.util.Map;

public class awv
    implements Runnable
{

    final List a;
    final int b;
    final TTieZhiCollectionPageScrolllView c;

    public awv(TTieZhiCollectionPageScrolllView ttiezhicollectionpagescrolllview, List list, int i)
    {
        c = ttiezhicollectionpagescrolllview;
        a = list;
        b = i;
        super();
    }

    public void run()
    {
        TTieZhiCollectionPageScrolllView.access$002(c, a);
        android.view.animation.Animation animation = AnimationUtils.loadAnimation(TTieZhiCollectionPageScrolllView.access$100(c), 0x7f04003e);
        if (!c.mRefrenceViewMap.isEmpty())
        {
            c.mRefrenceViewMap.clear();
            TTieZhiCollectionPageScrolllView.access$202(c, -1);
            TTieZhiCollectionPageScrolllView.access$302(c, -1);
            c.mCollectionViewPager.removeAllViews();
            c.mCollectionViewPager.setAdapter(null);
            c.mCollectionViewPager.setAdapter(c.mCollectionPagerAdapter);
        }
        c.mCollectionPagerAdapter.notifyDataSetChanged();
        c.setSelectedIndex(b);
        c.mCollectionViewPager.startAnimation(animation);
    }
}
