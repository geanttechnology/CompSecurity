// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.framebg;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import com.fotoable.photocollage.view.compose2.pager.TPageLine;
import com.fotoable.photocollage.view.compose2.pager.TPageMultiLine;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kf;
import la;
import mi;
import mn;
import mr;

public class FrameCollageBgPagerAdapter extends PagerAdapter
    implements mi
{

    final String a = "FreeCollageBgPagerAdapter";
    int b;
    List c;
    mn d;
    List e;
    TResInfo f;
    int g;
    int h;
    float i;
    int j;
    int k;
    mr l;

    public FrameCollageBgPagerAdapter()
    {
        b = 12;
        e = new ArrayList();
        g = 40;
        h = 8;
        i = 1.0F;
        j = 2;
        k = 8;
        l = TPageLine.calcLineItem(PIPCameraApplication.b().c(), g, h, i);
        PIPCameraApplication.b();
        if (PIPCameraApplication.d())
        {
            j = 1;
        }
        b = j * l.c();
    }

    public void a(List list)
    {
        c = list;
    }

    public void a(mn mn1)
    {
        d = mn1;
    }

    public void destroyItem(View view, int i1, Object obj)
    {
        obj = (TPageMultiLine)obj;
        ((ViewPager)view).removeView(((View) (obj)));
        e.remove(obj);
        ((TPageMultiLine) (obj)).clear();
    }

    public int getCount()
    {
        int k1 = c.size();
        int j1 = k1 / b;
        int i1 = j1;
        if (k1 % b != 0)
        {
            i1 = j1 + 1;
        }
        return i1;
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public Object instantiateItem(View view, int i1)
    {
        TPageMultiLine tpagemultiline = new TPageMultiLine(PIPCameraApplication.b().c(), null);
        tpagemultiline.setMultiLineInfo(j, k, g, h, i, false);
        ((ViewPager)view).addView(tpagemultiline, 0);
        tpagemultiline.setItemSelectListener(this);
        int k1 = i1 * b;
        int j1;
        if (c.size() > b + k1)
        {
            i1 = b + k1;
        } else
        {
            i1 = c.size();
        }
        j1 = k1;
        while (j1 < i1) 
        {
            int l1 = j1 - k1;
            if (f != null && f.name.compareTo(((TFrameItemInfo)c.get(j1)).name) == 0)
            {
                tpagemultiline.setItemData(l1, (TResInfo)c.get(j1), true);
            } else
            {
                tpagemultiline.setItemData(l1, (TResInfo)c.get(j1), false);
            }
            j1++;
        }
        e.add(tpagemultiline);
        return tpagemultiline;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void resItemSelected(TResInfo tresinfo)
    {
        Log.v("FreeCollageBgPagerAdapter", "resItemSelected");
        if (tresinfo != null && (tresinfo instanceof TFrameItemInfo))
        {
            TPageMultiLine tpagemultiline1;
            for (Iterator iterator = e.iterator(); iterator.hasNext(); tpagemultiline1.setItemSelect(tresinfo, true))
            {
                tpagemultiline1 = (TPageMultiLine)iterator.next();
                if (f != null)
                {
                    tpagemultiline1.setItemSelect(f, false);
                }
            }

            f = tresinfo;
            tresinfo = (TFrameItemInfo)tresinfo;
            if (d != null)
            {
                if (tresinfo != null && ((TFrameItemInfo) (tresinfo)).name != null)
                {
                    kf.d(((TFrameItemInfo) (tresinfo)).name);
                    la.a(PIPCameraApplication.a, "Collage_Save_Value", "CollageBg", "");
                }
                d.onItemSelected(tresinfo);
            }
        } else
        if (tresinfo == null)
        {
            tresinfo = e.iterator();
            while (tresinfo.hasNext()) 
            {
                TPageMultiLine tpagemultiline = (TPageMultiLine)tresinfo.next();
                if (f != null)
                {
                    tpagemultiline.setItemSelect(f, false);
                }
            }
        }
    }
}
