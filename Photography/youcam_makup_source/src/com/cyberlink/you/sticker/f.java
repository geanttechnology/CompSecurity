// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cyberlink.you.n;
import com.cyberlink.you.utility.LoadImageUtils;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.util.List;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, StickerObj

public class f extends PagerAdapter
{

    final StickerFragment a;
    private List b;
    private long c;
    private boolean d;

    public f(StickerFragment stickerfragment, List list, boolean flag)
    {
        a = stickerfragment;
        super();
        c = -2L;
        b = list;
        d = flag;
    }

    public f(StickerFragment stickerfragment, List list, boolean flag, long l)
    {
        a = stickerfragment;
        super();
        c = -2L;
        b = list;
        d = flag;
        c = l;
    }

    public void a(int i)
    {
        ViewGroup viewgroup = (ViewGroup)b.get(i);
        ViewGroup viewgroup1 = (ViewGroup)((ViewGroup)viewgroup.getChildAt(0)).getChildAt(0);
        i = 0;
        while (i < viewgroup1.getChildCount()) 
        {
            View view1 = viewgroup1.getChildAt(i);
            if (view1.getTag() != StickerFragment.a(a))
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    view1.setBackground(null);
                } else
                {
                    view1.setBackgroundColor(0);
                }
            }
            i++;
        }
        viewgroup = (ViewGroup)((ViewGroup)viewgroup.getChildAt(1)).getChildAt(0);
        i = 0;
        while (i < viewgroup.getChildCount()) 
        {
            View view = viewgroup.getChildAt(i);
            if (view.getTag() != StickerFragment.a(a))
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    view.setBackground(null);
                } else
                {
                    view.setBackgroundColor(0);
                }
            }
            i++;
        }
    }

    public void a(int i, StickerObj stickerobj)
    {
        ViewGroup viewgroup = (ViewGroup)b.get(i);
        ViewGroup viewgroup1 = (ViewGroup)((ViewGroup)viewgroup.getChildAt(0)).getChildAt(0);
        i = 0;
        while (i < viewgroup1.getChildCount()) 
        {
            View view1 = viewgroup1.getChildAt(i);
            if (view1.getTag() == stickerobj)
            {
                view1.setBackgroundResource(n.u_bg_border_sticker_preview);
            } else
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                view1.setBackground(null);
            } else
            {
                view1.setBackgroundColor(0);
            }
            i++;
        }
        viewgroup = (ViewGroup)((ViewGroup)viewgroup.getChildAt(1)).getChildAt(0);
        i = 0;
        while (i < viewgroup.getChildCount()) 
        {
            View view = viewgroup.getChildAt(i);
            if (view.getTag() == stickerobj)
            {
                view.setBackgroundResource(n.u_bg_border_sticker_preview);
            } else
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                view.setBackground(null);
            } else
            {
                view.setBackgroundColor(0);
            }
            i++;
        }
    }

    public boolean a()
    {
        return d;
    }

    public void b()
    {
        b.clear();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)b.get(i));
    }

    public int getCount()
    {
        return b.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = (View)b.get(i);
        viewgroup.addView(view, 0);
        viewgroup = (StickerFragment.PageType)view.getTag();
        if (viewgroup.equals(StickerFragment.PageType.b))
        {
            viewgroup = (ViewGroup)((ViewGroup)((ViewGroup)view).getChildAt(0)).getChildAt(0);
            for (i = 0; i < viewgroup.getChildCount(); i++)
            {
                Object obj = viewgroup.getChildAt(i);
                if (!(((View) (obj)).getTag() instanceof StickerObj))
                {
                    continue;
                }
                StickerObj stickerobj = (StickerObj)((View) (obj)).getTag();
                obj = (ImageView)obj;
                if (a.getActivity() != null)
                {
                    LoadImageUtils.a(a.getActivity(), stickerobj, true, ((ImageView) (obj)), false);
                }
            }

            viewgroup = (ViewGroup)((ViewGroup)((ViewGroup)view).getChildAt(1)).getChildAt(0);
            for (i = 0; i < viewgroup.getChildCount(); i++)
            {
                Object obj1 = viewgroup.getChildAt(i);
                if (((View) (obj1)).getTag() instanceof StickerObj)
                {
                    StickerObj stickerobj1 = (StickerObj)((View) (obj1)).getTag();
                    obj1 = (ImageView)obj1;
                    if (a.getActivity() != null)
                    {
                        LoadImageUtils.a(a.getActivity(), stickerobj1, true, ((ImageView) (obj1)), false);
                    }
                }
            }

        } else
        if (viewgroup.equals(StickerFragment.PageType.c))
        {
            viewgroup = (ViewGroup)((ViewGroup)((ViewGroup)view).getChildAt(0)).getChildAt(0);
            for (i = 0; i < viewgroup.getChildCount(); i++)
            {
                ViewGroup viewgroup1 = (ViewGroup)viewgroup.getChildAt(i);
                for (int j = 0; j < viewgroup1.getChildCount(); j++)
                {
                    Object obj2 = viewgroup1.getChildAt(j);
                    if (!(((View) (obj2)).getTag() instanceof Emojicon))
                    {
                        continue;
                    }
                    Emojicon emojicon = (Emojicon)((View) (obj2)).getTag();
                    obj2 = (ImageView)obj2;
                    if (a.getActivity() != null)
                    {
                        LoadImageUtils.a(a.getActivity(), emojicon, ((ImageView) (obj2)));
                    }
                }

            }

        }
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
