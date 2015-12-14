// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.sketch.view.TTieZhiLibraryView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import java.util.List;
import java.util.Map;

public class axr extends PagerAdapter
{

    final TTieZhiMainLibraryView a;

    public axr(TTieZhiMainLibraryView ttiezhimainlibraryview)
    {
        a = ttiezhimainlibraryview;
        super();
    }

    public Object a(int i)
    {
        if (!a.mRefrenceViewMap.containsKey(Integer.valueOf(i)))
        {
            return null;
        } else
        {
            return a.mRefrenceViewMap.get(Integer.valueOf(i));
        }
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)a.mRefrenceViewMap.get(Integer.valueOf(i)));
        a.mRefrenceViewMap.remove(Integer.valueOf(i));
    }

    public int getCount()
    {
        if (a.mData != null && a.mData.size() > 0)
        {
            return a.mData.size();
        } else
        {
            return 0;
        }
    }

    public CharSequence getPageTitle(int i)
    {
        if (i < a.mData.size() && i >= 0)
        {
            awk awk1 = (awk)a.mData.get(i);
            if (awk1 != null)
            {
                if (yp.b())
                {
                    return awk1.b;
                }
                if (yp.c())
                {
                    return awk1.c;
                } else
                {
                    return awk1.d;
                }
            }
        }
        return "";
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        TTieZhiLibraryView ttiezhilibraryview;
        if (a.mRefrenceViewMap.containsKey(Integer.valueOf(i)))
        {
            ttiezhilibraryview = (TTieZhiLibraryView)a.mRefrenceViewMap.get(Integer.valueOf(i));
        } else
        {
            ttiezhilibraryview = new TTieZhiLibraryView(a.getContext());
            ttiezhilibraryview.setTieZhiCellLisener(TTieZhiMainLibraryView.access$000(a));
            ttiezhilibraryview.initWithImageWorker(a.imageWorker);
        }
        ttiezhilibraryview.setIsFinishLoad(a._isFinishLoad);
        ttiezhilibraryview.setData((awk)a.mData.get(i));
        a.mRefrenceViewMap.put(Integer.valueOf(i), ttiezhilibraryview);
        viewgroup.addView(ttiezhilibraryview);
        return ttiezhilibraryview;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
