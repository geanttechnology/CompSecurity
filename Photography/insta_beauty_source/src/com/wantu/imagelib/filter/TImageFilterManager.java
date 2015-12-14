// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.content.Context;
import android.content.res.Resources;
import bgm;
import bgv;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.wantu.imagelib.filter:
//            TImageFilter, TImageFilterInfo, TImageProcessingDelegate

public class TImageFilterManager extends bgv
{

    public static final String kFilterCatalogeArts = "arts";
    public static final String kFilterCatalogeBackground = "background";
    public static final String kFilterCatalogeBeauty = "beauty";
    public static final String kFilterCatalogeDefault = "default";
    public static final String kFilterCatalogeForground = "forground";
    public static final String kFilterCatalogeLomo = "lomo";
    protected Map _imageFilterCataloge;
    protected bgm _network;
    protected Context mContext;
    private TImageProcessingDelegate mDelegate;
    private TImageFilter mFilter;
    protected Map mFilterDict;
    protected List mKeyOderArray;

    public TImageFilterManager()
    {
        mFilterDict = new HashMap();
        _imageFilterCataloge = new HashMap();
        mFilter = new TImageFilter();
        mKeyOderArray = new ArrayList();
        mContext = InstaBeautyApplication.a().getApplicationContext();
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.d())
        {
            addSmallLayoutPreinstallFilter();
        } else
        {
            addPreinstallFilter();
        }
        _network = new bgm();
        _network.a(this);
    }

    public TImageFilterManager(Context context)
    {
        mFilterDict = new HashMap();
        _imageFilterCataloge = new HashMap();
        mFilter = new TImageFilter();
        mKeyOderArray = new ArrayList();
        mContext = context;
        InstaBeautyApplication.a();
        if (InstaBeautyApplication.d())
        {
            addSmallLayoutPreinstallFilter();
        } else
        {
            addPreinstallFilter();
        }
        _network = new bgm();
        _network.a(this);
    }

    public void addPreinstallFilter()
    {
        Object obj = mContext;
        String s = ((Context) (obj)).getResources().getString(0x7f0601a0);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo1 = new TImageFilterInfo();
            timagefilterinfo1.filterName = s;
            timagefilterinfo1.iconUrl = 0x7f020482;
            timagefilterinfo1.isAvalable = Boolean.valueOf(true);
            timagefilterinfo1.setResType(EResType.ASSET);
            installFilter(timagefilterinfo1);
            addToCataloge("default", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06008c);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo2 = new TImageFilterInfo();
            timagefilterinfo2.filterName = s;
            timagefilterinfo2.iconUrl = 0x7f020482;
            timagefilterinfo2.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo2);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060090);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo3 = new TImageFilterInfo();
            timagefilterinfo3.filterName = s;
            timagefilterinfo3.iconUrl = 0x7f020482;
            timagefilterinfo3.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo3);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06025e);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo4 = new TImageFilterInfo();
            timagefilterinfo4.filterName = s;
            timagefilterinfo4.iconUrl = 0x7f020482;
            timagefilterinfo4.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo4);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("arts", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0601c1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo5 = new TImageFilterInfo();
            timagefilterinfo5.filterName = s;
            timagefilterinfo5.iconUrl = 0x7f020482;
            timagefilterinfo5.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo5);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0602f3);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo6 = new TImageFilterInfo();
            timagefilterinfo6.filterName = s;
            timagefilterinfo6.iconUrl = 0x7f020482;
            timagefilterinfo6.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo6);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060281);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo7 = new TImageFilterInfo();
            timagefilterinfo7.filterName = s;
            timagefilterinfo7.iconUrl = 0x7f020482;
            timagefilterinfo7.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo7);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060135);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo8 = new TImageFilterInfo();
            timagefilterinfo8.filterName = s;
            timagefilterinfo8.iconUrl = 0x7f020482;
            timagefilterinfo8.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo8);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060184);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo9 = new TImageFilterInfo();
            timagefilterinfo9.filterName = s;
            timagefilterinfo9.iconUrl = 0x7f020482;
            timagefilterinfo9.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo9);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06015f);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo10 = new TImageFilterInfo();
            timagefilterinfo10.filterName = s;
            timagefilterinfo10.iconUrl = 0x7f020482;
            timagefilterinfo10.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo10);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060160);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo11 = new TImageFilterInfo();
            timagefilterinfo11.filterName = s;
            timagefilterinfo11.iconUrl = 0x7f020482;
            timagefilterinfo11.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo11);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060086);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo12 = new TImageFilterInfo();
            timagefilterinfo12.filterName = s;
            timagefilterinfo12.iconUrl = 0x7f020482;
            timagefilterinfo12.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo12);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060067);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo13 = new TImageFilterInfo();
            timagefilterinfo13.filterName = s;
            timagefilterinfo13.iconUrl = 0x7f020482;
            timagefilterinfo13.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo13);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0602fb);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo14 = new TImageFilterInfo();
            timagefilterinfo14.filterName = s;
            timagefilterinfo14.iconUrl = 0x7f020482;
            timagefilterinfo14.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo14);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600b5);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo15 = new TImageFilterInfo();
            timagefilterinfo15.filterName = s;
            timagefilterinfo15.iconUrl = 0x7f020482;
            timagefilterinfo15.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo15);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060108);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo16 = new TImageFilterInfo();
            timagefilterinfo16.filterName = s;
            timagefilterinfo16.iconUrl = 0x7f020482;
            timagefilterinfo16.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo16);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06013c);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo17 = new TImageFilterInfo();
            timagefilterinfo17.filterName = s;
            timagefilterinfo17.iconUrl = 0x7f020482;
            timagefilterinfo17.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo17);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600f1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo18 = new TImageFilterInfo();
            timagefilterinfo18.filterName = s;
            timagefilterinfo18.iconUrl = 0x7f020482;
            timagefilterinfo18.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo18);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060134);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo19 = new TImageFilterInfo();
            timagefilterinfo19.filterName = s;
            timagefilterinfo19.iconUrl = 0x7f020482;
            timagefilterinfo19.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo19);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060198);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo20 = new TImageFilterInfo();
            timagefilterinfo20.filterName = s;
            timagefilterinfo20.iconUrl = 0x7f020482;
            timagefilterinfo20.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo20);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06009d);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo21 = new TImageFilterInfo();
            timagefilterinfo21.filterName = s;
            timagefilterinfo21.iconUrl = 0x7f020482;
            timagefilterinfo21.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo21);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600b0);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo22 = new TImageFilterInfo();
            timagefilterinfo22.filterName = s;
            timagefilterinfo22.iconUrl = 0x7f020482;
            timagefilterinfo22.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo22);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060271);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo23 = new TImageFilterInfo();
            timagefilterinfo23.filterName = s;
            timagefilterinfo23.iconUrl = 0x7f020482;
            timagefilterinfo23.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo23);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06016f);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo24 = new TImageFilterInfo();
            timagefilterinfo24.filterName = s;
            timagefilterinfo24.iconUrl = 0x7f020482;
            timagefilterinfo24.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo24);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060282);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo25 = new TImageFilterInfo();
            timagefilterinfo25.filterName = s;
            timagefilterinfo25.iconUrl = 0x7f020482;
            timagefilterinfo25.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo25);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600c6);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo26 = new TImageFilterInfo();
            timagefilterinfo26.filterName = s;
            timagefilterinfo26.iconUrl = 0x7f020482;
            timagefilterinfo26.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo26);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06009e);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo27 = new TImageFilterInfo();
            timagefilterinfo27.filterName = s;
            timagefilterinfo27.iconUrl = 0x7f020482;
            timagefilterinfo27.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo27);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0601a1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo28 = new TImageFilterInfo();
            timagefilterinfo28.filterName = s;
            timagefilterinfo28.iconUrl = 0x7f020482;
            timagefilterinfo28.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo28);
            addToCataloge("default", s);
            addToCataloge("arts", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600fd);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo29 = new TImageFilterInfo();
            timagefilterinfo29.filterName = s;
            timagefilterinfo29.iconUrl = 0x7f020482;
            timagefilterinfo29.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo29);
            addToCataloge("default", s);
            addToCataloge("arts", s);
        }
        obj = ((Context) (obj)).getResources().getString(0x7f060197);
        if (!mFilterDict.containsKey(obj))
        {
            TImageFilterInfo timagefilterinfo = new TImageFilterInfo();
            timagefilterinfo.filterName = ((String) (obj));
            timagefilterinfo.iconUrl = 0x7f020482;
            timagefilterinfo.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo);
            addToCataloge("default", ((String) (obj)));
            addToCataloge("arts", ((String) (obj)));
        }
    }

    public void addSmallLayoutPreinstallFilter()
    {
        Object obj = mContext;
        String s = ((Context) (obj)).getResources().getString(0x7f0601a0);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo1 = new TImageFilterInfo();
            timagefilterinfo1.filterName = s;
            timagefilterinfo1.iconUrl = 0x7f0201f3;
            timagefilterinfo1.isAvalable = Boolean.valueOf(true);
            timagefilterinfo1.setResType(EResType.ASSET);
            installFilter(timagefilterinfo1);
            addToCataloge("default", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06008c);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo2 = new TImageFilterInfo();
            timagefilterinfo2.filterName = s;
            timagefilterinfo2.iconUrl = 0x7f0201f3;
            timagefilterinfo2.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo2);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0601c1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo3 = new TImageFilterInfo();
            timagefilterinfo3.filterName = s;
            timagefilterinfo3.iconUrl = 0x7f0201f3;
            timagefilterinfo3.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo3);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0602f3);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo4 = new TImageFilterInfo();
            timagefilterinfo4.filterName = s;
            timagefilterinfo4.iconUrl = 0x7f0201f3;
            timagefilterinfo4.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo4);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060135);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo5 = new TImageFilterInfo();
            timagefilterinfo5.filterName = s;
            timagefilterinfo5.iconUrl = 0x7f0201f3;
            timagefilterinfo5.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo5);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060184);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo6 = new TImageFilterInfo();
            timagefilterinfo6.filterName = s;
            timagefilterinfo6.iconUrl = 0x7f0201f3;
            timagefilterinfo6.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo6);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06015f);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo7 = new TImageFilterInfo();
            timagefilterinfo7.filterName = s;
            timagefilterinfo7.iconUrl = 0x7f0201f3;
            timagefilterinfo7.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo7);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0602fb);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo8 = new TImageFilterInfo();
            timagefilterinfo8.filterName = s;
            timagefilterinfo8.iconUrl = 0x7f0201f3;
            timagefilterinfo8.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo8);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600b5);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo9 = new TImageFilterInfo();
            timagefilterinfo9.filterName = s;
            timagefilterinfo9.iconUrl = 0x7f0201f3;
            timagefilterinfo9.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo9);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060108);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo10 = new TImageFilterInfo();
            timagefilterinfo10.filterName = s;
            timagefilterinfo10.iconUrl = 0x7f0201f3;
            timagefilterinfo10.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo10);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600f1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo11 = new TImageFilterInfo();
            timagefilterinfo11.filterName = s;
            timagefilterinfo11.iconUrl = 0x7f0201f3;
            timagefilterinfo11.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo11);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060134);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo12 = new TImageFilterInfo();
            timagefilterinfo12.filterName = s;
            timagefilterinfo12.iconUrl = 0x7f0201f3;
            timagefilterinfo12.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo12);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060198);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo13 = new TImageFilterInfo();
            timagefilterinfo13.filterName = s;
            timagefilterinfo13.iconUrl = 0x7f0201f3;
            timagefilterinfo13.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo13);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06009d);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo14 = new TImageFilterInfo();
            timagefilterinfo14.filterName = s;
            timagefilterinfo14.iconUrl = 0x7f0201f3;
            timagefilterinfo14.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo14);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060271);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo15 = new TImageFilterInfo();
            timagefilterinfo15.filterName = s;
            timagefilterinfo15.iconUrl = 0x7f0201f3;
            timagefilterinfo15.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo15);
            addToCataloge("forground", s);
            addToCataloge("background", s);
            addToCataloge("default", s);
            addToCataloge("lomo", s);
        }
        obj = ((Context) (obj)).getResources().getString(0x7f06016f);
        if (!mFilterDict.containsKey(obj))
        {
            TImageFilterInfo timagefilterinfo = new TImageFilterInfo();
            timagefilterinfo.filterName = ((String) (obj));
            timagefilterinfo.iconUrl = 0x7f0201f3;
            timagefilterinfo.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo);
            addToCataloge("forground", ((String) (obj)));
            addToCataloge("background", ((String) (obj)));
            addToCataloge("default", ((String) (obj)));
            addToCataloge("lomo", ((String) (obj)));
        }
    }

    public void addToCataloge(String s, String s1)
    {
        if (_imageFilterCataloge == null)
        {
            _imageFilterCataloge = new HashMap();
        }
        List list = (List)_imageFilterCataloge.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            _imageFilterCataloge.put(s, obj);
        }
        ((List) (obj)).add(s1);
    }

    public void downloadRes(TResInfo tresinfo)
    {
        if (_network != null)
        {
            _network.a(materialtype);
            _network.b(tresinfo);
        }
    }

    public List filterNamesByCatalogeName(String s)
    {
        return (List)_imageFilterCataloge.get(s);
    }

    public TImageFilter filterWithName(String s)
    {
        if (mFilterDict.get(s) != null)
        {
            mFilter.setmInfo((TImageFilterInfo)mFilterDict.get(s));
            return mFilter;
        } else
        {
            return null;
        }
    }

    public TImageProcessingDelegate getmDelegate()
    {
        return mDelegate;
    }

    public TImageFilter getmFilter()
    {
        return mFilter;
    }

    public Map getmFilterDict()
    {
        return mFilterDict;
    }

    public List getmKeyOderArray()
    {
        return mKeyOderArray;
    }

    public void hideFilter(String s, Boolean boolean1)
    {
        while (s == null || mFilterDict.get(s) == null) 
        {
            return;
        }
        ((TImageFilterInfo)mFilterDict.get(s)).isHide = boolean1;
    }

    public void insertFirstFilter(TImageFilterInfo timagefilterinfo)
    {
        mFilterDict.put(timagefilterinfo.filterName, timagefilterinfo);
        mKeyOderArray.add(1, timagefilterinfo.filterName);
    }

    public void installFilter(TImageFilterInfo timagefilterinfo)
    {
        mFilterDict.put(timagefilterinfo.filterName, timagefilterinfo);
        mKeyOderArray.add(timagefilterinfo.filterName);
    }

    public Boolean isFilterRemovable(String s)
    {
        return ((TImageFilterInfo)mFilterDict.get(s)).isRemovable;
    }

    public void removeFilter(String s)
    {
        while (s == null || mFilterDict.get(s) == null) 
        {
            return;
        }
        mFilterDict.remove(s);
        mKeyOderArray.remove(s);
    }

    public void removeFilterWithName(String s)
    {
        if (mFilterDict.get(s) != null)
        {
            mFilterDict.remove(s);
            if (mKeyOderArray.contains(s))
            {
                mKeyOderArray.remove(s);
            }
        }
    }

    public void setmDelegate(TImageProcessingDelegate timageprocessingdelegate)
    {
        mDelegate = timageprocessingdelegate;
    }

    public void setmFilterDict(Map map)
    {
        mFilterDict = map;
    }

    public void update()
    {
        if (_network == null)
        {
            return;
        }
        ArrayList arraylist = new ArrayList(mFilterDict.size());
        for (Iterator iterator = mFilterDict.values().iterator(); iterator.hasNext(); arraylist.add((TImageFilterInfo)iterator.next())) { }
        _network.a(materialtype);
        _network.b(arraylist);
    }
}
