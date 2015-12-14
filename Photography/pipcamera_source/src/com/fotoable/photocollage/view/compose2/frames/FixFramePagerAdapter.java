// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.frames;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.view.compose2.pager.TPageLine;
import com.fotoable.photocollage.view.compose2.pager.TPageMultiLine;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TResInfo;
import ew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kf;
import mi;
import mr;

public class FixFramePagerAdapter extends PagerAdapter
    implements mi
{

    String a;
    int b;
    List c;
    mi d;
    TResInfo e;
    List f;
    int g;
    int h;
    float i;
    int j;
    int k;
    mr l;
    int m;
    private int n;

    public FixFramePagerAdapter(float f1)
    {
        a = "FixFramePagerAdapter";
        b = 12;
        f = new ArrayList();
        g = 46;
        h = 8;
        i = 1.0F;
        j = 2;
        k = 8;
        m = 0;
        i = f1;
        n = ew.a(PIPCameraApplication.b().c()) - 50;
        l = TPageLine.calcLineItem(n, g, h, f1);
        b = j * l.c();
    }

    public int a(TPhotoCollageComposeInfo tphotocollagecomposeinfo)
    {
        int i1;
        try
        {
            e = tphotocollagecomposeinfo;
        }
        // Misplaced declaration of an exception variable
        catch (TPhotoCollageComposeInfo tphotocollagecomposeinfo)
        {
            return 0;
        }
        i1 = 0;
        if (i1 >= c.size())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (((TPhotoCollageComposeInfo)c.get(i1)).name.compareTo(e.name) != 0) goto _L2; else goto _L1
_L1:
        i1 /= b;
        return i1;
_L2:
        i1++;
        break MISSING_BLOCK_LABEL_7;
        i1 = 0;
          goto _L1
    }

    public void a()
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext(); ((TPageMultiLine)iterator.next()).clear()) { }
    }

    public void a(List list)
    {
        c = list;
    }

    public void a(mi mi1)
    {
        d = mi1;
    }

    public void destroyItem(View view, int i1, Object obj)
    {
        obj = (TPageMultiLine)obj;
        ((ViewPager)view).removeView(((View) (obj)));
        f.remove(obj);
        ((TPageMultiLine) (obj)).clear();
    }

    public int getCount()
    {
        int k1 = c.size();
        int j1 = k1 / b;
        int i1 = j1;
        if (k1 % b != 0)
        {
            i1 = j1;
            if (k1 != 0)
            {
                i1 = j1 + 1;
            }
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
        tpagemultiline.setMultiLineInfo(ew.a(PIPCameraApplication.b().c(), n), j, k, g, h, i, false);
        ((ViewPager)view).addView(tpagemultiline, 0);
        tpagemultiline.setItemSelectListener(this);
        int l1 = i1 * b;
        int j1;
        int k1;
        if (c.size() > b + l1)
        {
            j1 = b + l1;
        } else
        {
            j1 = c.size();
        }
        k1 = l1;
        while (k1 < j1) 
        {
            int i2 = k1 - l1;
            if (e != null && e.name.compareTo(((TPhotoCollageComposeInfo)c.get(k1)).name) == 0)
            {
                tpagemultiline.setItemData(i2, (TResInfo)c.get(k1), true);
                m = i1;
            } else
            {
                tpagemultiline.setItemData(i2, (TResInfo)c.get(k1), false);
            }
            k1++;
        }
        f.add(tpagemultiline);
        return tpagemultiline;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void resItemSelected(TResInfo tresinfo)
    {
        if (tresinfo != null && (tresinfo instanceof TPhotoCollageComposeInfo))
        {
            TPageMultiLine tpagemultiline;
            for (Iterator iterator = f.iterator(); iterator.hasNext(); tpagemultiline.setItemSelect(tresinfo, true))
            {
                tpagemultiline = (TPageMultiLine)iterator.next();
                if (e != null)
                {
                    tpagemultiline.setItemSelect(e, false);
                }
            }

            e = tresinfo;
        }
        if (d != null)
        {
            kf.e(tresinfo.name);
            d.resItemSelected(tresinfo);
        }
    }
}
