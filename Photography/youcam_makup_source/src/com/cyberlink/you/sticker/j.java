// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.l;
import com.cyberlink.you.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.LoadImageUtils;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.widgetpool.clhorizontalgridview.e;
import java.io.File;
import java.util.List;

// Referenced classes of package com.cyberlink.you.sticker:
//            k, StickerFragment

class j extends ArrayAdapter
{

    final StickerFragment a;
    private int b;

    public j(StickerFragment stickerfragment, Context context, int i, List list)
    {
        a = stickerfragment;
        super(context, i, list);
        b = -1;
    }

    public int a()
    {
        for (int i = 0; i < getCount(); i++)
        {
            if (com.cyberlink.you.database.StickerPackObj.FunctionType.a == ((StickerPackObj)getItem(i)).r())
            {
                return i;
            }
        }

        return -1;
    }

    public int a(long l1)
    {
        for (int i = 0; i < getCount(); i++)
        {
            StickerPackObj stickerpackobj = (StickerPackObj)getItem(i);
            if (com.cyberlink.you.database.StickerPackObj.FunctionType.a == stickerpackobj.r() && l1 == stickerpackobj.b())
            {
                return i;
            }
        }

        return -1;
    }

    public void a(int i)
    {
        b = i;
    }

    public int b()
    {
        int i = 0;
        int i1;
        int j1;
        for (i1 = 0; i < getCount(); i1 = j1)
        {
            j1 = i1;
            if (com.cyberlink.you.database.StickerPackObj.FunctionType.a == ((StickerPackObj)getItem(i)).r())
            {
                j1 = i1 + 1;
            }
            i++;
        }

        return i1;
    }

    public int b(long l1)
    {
        for (int i = 0; i < getCount(); i++)
        {
            if (l1 == ((StickerPackObj)getItem(i)).b())
            {
                return i;
            }
        }

        return -1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        Object obj1;
        if (view == null)
        {
            view = new k(this, null);
            if (a.getActivity() != null)
            {
                View view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.u_view_item_sticker_category, viewgroup, false);
                view.a = (ImageView)view1.findViewById(o.sticker_category_image);
                view.b = (RelativeLayout)view1.findViewById(o.sticker_category_background);
                viewgroup = new e(-1, -1);
                DisplayMetrics displaymetrics = new DisplayMetrics();
                a.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                viewgroup.width = (int)(((float)displaymetrics.widthPixels / 1080F) * 158F);
                view1.setLayoutParams(viewgroup);
                view1.setTag(view);
                viewgroup = view;
                view = view1;
            } else
            {
                view.b = new RelativeLayout(getContext());
                view.a = new ImageView(getContext());
                obj = ((k) (view)).b;
                viewgroup = ((k) (view)).a;
                obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13, -1);
                viewgroup.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                ((RelativeLayout) (obj)).addView(viewgroup);
                ((View) (obj)).setLayoutParams(new e(-1, -1));
                ((View) (obj)).setTag(view);
                viewgroup = view;
                view = ((View) (obj));
            }
        } else
        {
            viewgroup = (k)view.getTag();
        }
        if (a.getActivity() != null)
        {
            obj = ((k) (viewgroup)).b;
            if (b == i)
            {
                ((RelativeLayout) (obj)).setBackgroundResource(n.u_bg_sticker_category_selected);
            } else
            {
                ((RelativeLayout) (obj)).setBackgroundColor(a.getActivity().getResources().getColor(l.you_color_light_gray));
            }
        }
        obj = ((k) (viewgroup)).a;
        obj1 = (StickerPackObj)getItem(i);
        if (((StickerPackObj) (obj1)).r() == com.cyberlink.you.database.StickerPackObj.FunctionType.a)
        {
            viewgroup = ((StickerPackObj) (obj1)).i().e;
            if (viewgroup.equals("_"))
            {
                if (a.getActivity() != null)
                {
                    viewgroup = d.a(((StickerPackObj) (obj1)).b());
                }
                if (viewgroup != null)
                {
                    ((StickerPackObj) (obj1)).i().e = (new StringBuilder()).append(viewgroup).append(File.separator).append("thumbnail").toString();
                    com.cyberlink.you.e.i().a(((StickerPackObj) (obj1)).b(), ((StickerPackObj) (obj1)));
                }
            }
            LoadImageUtils.a(getContext(), ((StickerPackObj) (obj1)), ((ImageView) (obj)), true, false);
        } else
        {
            if (((StickerPackObj) (obj1)).r() == com.cyberlink.you.database.StickerPackObj.FunctionType.b)
            {
                ((ImageView) (obj)).setImageResource(n.u_sticker_thumbnail_emoji);
                return view;
            }
            if (((StickerPackObj) (obj1)).r() == com.cyberlink.you.database.StickerPackObj.FunctionType.c)
            {
                ((ImageView) (obj)).setImageResource(n.u_btn_sticker_setting);
                return view;
            }
        }
        return view;
    }
}
