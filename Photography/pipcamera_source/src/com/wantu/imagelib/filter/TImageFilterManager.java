// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.content.Context;
import android.content.res.Resources;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tr;
import tu;

// Referenced classes of package com.wantu.imagelib.filter:
//            TImageFilter, TImageFilterInfo, TImageProcessingDelegate

public class TImageFilterManager extends tu
{

    public static final String kFilterCatalogeArts = "arts";
    public static final String kFilterCatalogeBeauty = "beauty";
    public static final String kFilterCatalogeComicFilter = "comic-filter";
    public static final String kFilterCatalogeDefaultFilter = "default-filter";
    public static final String kFilterCatalogeLomo = "lomo";
    protected Map _imageFilterCataloge;
    protected tr _network;
    private TImageProcessingDelegate mDelegate;
    private TImageFilter mFilter;
    protected Map mFilterDict;
    protected List mKeyOderArray;

    public TImageFilterManager()
    {
        mFilterDict = new HashMap();
        _imageFilterCataloge = new HashMap();
        mKeyOderArray = new ArrayList();
        mFilter = new TImageFilter();
        installAllFilters();
        if (PIPCameraApplication.a(PIPCameraApplication.a))
        {
            addSmallLayoutPreinstallFilter();
        } else
        {
            addPreinstallFilter();
        }
        _network = new tr();
        _network.a(this);
    }

    private void addPreinstallFilter()
    {
        boolean flag = false;
        Context context = PIPCameraApplication.a;
        ArrayList arraylist = new ArrayList(35);
        arraylist.add(context.getResources().getString(0x7f060181));
        arraylist.add(context.getResources().getString(0x7f0600eb));
        arraylist.add(context.getResources().getString(0x7f060089));
        arraylist.add(context.getResources().getString(0x7f0601a1));
        arraylist.add(context.getResources().getString(0x7f0602af));
        arraylist.add(context.getResources().getString(0x7f06024d));
        arraylist.add(context.getResources().getString(0x7f060122));
        arraylist.add(context.getResources().getString(0x7f060167));
        arraylist.add(context.getResources().getString(0x7f06022b));
        arraylist.add(context.getResources().getString(0x7f06014a));
        arraylist.add(context.getResources().getString(0x7f06014b));
        arraylist.add(context.getResources().getString(0x7f06006d));
        arraylist.add(context.getResources().getString(0x7f0602b5));
        arraylist.add(context.getResources().getString(0x7f0600ab));
        arraylist.add(context.getResources().getString(0x7f0600f6));
        arraylist.add(context.getResources().getString(0x7f060129));
        arraylist.add(context.getResources().getString(0x7f0600e1));
        arraylist.add(context.getResources().getString(0x7f060121));
        arraylist.add(context.getResources().getString(0x7f060178));
        arraylist.add(context.getResources().getString(0x7f060098));
        arraylist.add(context.getResources().getString(0x7f0600a5));
        arraylist.add(context.getResources().getString(0x7f06023c));
        arraylist.add(context.getResources().getString(0x7f060159));
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s1 = (String)arraylist.get(i);
            if (isExistFilter(s1))
            {
                addToCataloge("default-filter", s1);
            }
        }

        arraylist = new ArrayList(35);
        arraylist.add(context.getResources().getString(0x7f060181));
        arraylist.add(context.getResources().getString(0x7f0600eb));
        arraylist.add(context.getResources().getString(0x7f060089));
        arraylist.add(context.getResources().getString(0x7f0601a1));
        arraylist.add(context.getResources().getString(0x7f0602af));
        arraylist.add(context.getResources().getString(0x7f06024d));
        arraylist.add(context.getResources().getString(0x7f060122));
        arraylist.add(context.getResources().getString(0x7f060167));
        arraylist.add(context.getResources().getString(0x7f06022b));
        arraylist.add(context.getResources().getString(0x7f06014a));
        arraylist.add(context.getResources().getString(0x7f06014b));
        arraylist.add(context.getResources().getString(0x7f06006d));
        arraylist.add(context.getResources().getString(0x7f0602b5));
        arraylist.add(context.getResources().getString(0x7f0600ab));
        arraylist.add(context.getResources().getString(0x7f0600f6));
        arraylist.add(context.getResources().getString(0x7f060129));
        arraylist.add(context.getResources().getString(0x7f0600e1));
        arraylist.add(context.getResources().getString(0x7f060121));
        arraylist.add(context.getResources().getString(0x7f060178));
        arraylist.add(context.getResources().getString(0x7f060098));
        arraylist.add(context.getResources().getString(0x7f0600a5));
        arraylist.add(context.getResources().getString(0x7f06023c));
        arraylist.add(context.getResources().getString(0x7f060159));
        for (int j = ((flag) ? 1 : 0); j < arraylist.size(); j++)
        {
            String s = (String)arraylist.get(j);
            if (isExistFilter(s))
            {
                addToCataloge("comic-filter", s);
            }
        }

    }

    private void installAllFilters()
    {
        Object obj = PIPCameraApplication.a;
        String s = ((Context) (obj)).getResources().getString(0x7f060181);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo1 = new TImageFilterInfo();
            timagefilterinfo1.filterName = s;
            timagefilterinfo1.iconUrl = 0x7f020210;
            timagefilterinfo1.isAvalable = Boolean.valueOf(true);
            timagefilterinfo1.setResType(EResType.ASSET);
            installFilter(timagefilterinfo1);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600eb);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo2 = new TImageFilterInfo();
            timagefilterinfo2.filterName = s;
            timagefilterinfo2.iconUrl = 0x7f020200;
            timagefilterinfo2.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo2);
            addToCataloge("arts", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060089);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo3 = new TImageFilterInfo();
            timagefilterinfo3.filterName = s;
            timagefilterinfo3.iconUrl = 0x7f020200;
            timagefilterinfo3.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo3);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0601a1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo4 = new TImageFilterInfo();
            timagefilterinfo4.filterName = s;
            timagefilterinfo4.iconUrl = 0x7f020211;
            timagefilterinfo4.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo4);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0602af);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo5 = new TImageFilterInfo();
            timagefilterinfo5.filterName = s;
            timagefilterinfo5.iconUrl = 0x7f020217;
            timagefilterinfo5.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo5);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06024d);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo6 = new TImageFilterInfo();
            timagefilterinfo6.filterName = s;
            timagefilterinfo6.iconUrl = 0x7f0201ff;
            timagefilterinfo6.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo6);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060122);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo7 = new TImageFilterInfo();
            timagefilterinfo7.filterName = s;
            timagefilterinfo7.iconUrl = 0x7f020206;
            timagefilterinfo7.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo7);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060167);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo8 = new TImageFilterInfo();
            timagefilterinfo8.filterName = s;
            timagefilterinfo8.iconUrl = 0x7f02020a;
            timagefilterinfo8.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo8);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06022b);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo9 = new TImageFilterInfo();
            timagefilterinfo9.filterName = s;
            timagefilterinfo9.iconUrl = 0x7f020214;
            timagefilterinfo9.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo9);
            addToCataloge("arts", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06014a);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo10 = new TImageFilterInfo();
            timagefilterinfo10.filterName = s;
            timagefilterinfo10.iconUrl = 0x7f02020d;
            timagefilterinfo10.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo10);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06014b);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo11 = new TImageFilterInfo();
            timagefilterinfo11.filterName = s;
            timagefilterinfo11.iconUrl = 0x7f020202;
            timagefilterinfo11.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo11);
            addToCataloge("lomo", s);
        }
        ((Context) (obj)).getResources().getString(0x7f060083);
        s = ((Context) (obj)).getResources().getString(0x7f06006d);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo12 = new TImageFilterInfo();
            timagefilterinfo12.filterName = s;
            timagefilterinfo12.iconUrl = 0x7f0201fc;
            timagefilterinfo12.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo12);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0602b5);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo13 = new TImageFilterInfo();
            timagefilterinfo13.filterName = s;
            timagefilterinfo13.iconUrl = 0x7f020218;
            timagefilterinfo13.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo13);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600ab);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo14 = new TImageFilterInfo();
            timagefilterinfo14.filterName = s;
            timagefilterinfo14.iconUrl = 0x7f020203;
            timagefilterinfo14.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo14);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600f6);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo15 = new TImageFilterInfo();
            timagefilterinfo15.filterName = s;
            timagefilterinfo15.iconUrl = 0x7f020205;
            timagefilterinfo15.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo15);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060129);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo16 = new TImageFilterInfo();
            timagefilterinfo16.filterName = s;
            timagefilterinfo16.iconUrl = 0x7f020209;
            timagefilterinfo16.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo16);
            addToCataloge("arts", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600e1);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo17 = new TImageFilterInfo();
            timagefilterinfo17.filterName = s;
            timagefilterinfo17.iconUrl = 0x7f020215;
            timagefilterinfo17.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo17);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060121);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo18 = new TImageFilterInfo();
            timagefilterinfo18.filterName = s;
            timagefilterinfo18.iconUrl = 0x7f020219;
            timagefilterinfo18.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo18);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060178);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo19 = new TImageFilterInfo();
            timagefilterinfo19.filterName = s;
            timagefilterinfo19.iconUrl = 0x7f020204;
            timagefilterinfo19.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo19);
            addToCataloge("arts", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f060098);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo20 = new TImageFilterInfo();
            timagefilterinfo20.filterName = s;
            timagefilterinfo20.iconUrl = 0x7f020201;
            timagefilterinfo20.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo20);
            addToCataloge("beauty", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f0600a5);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo21 = new TImageFilterInfo();
            timagefilterinfo21.filterName = s;
            timagefilterinfo21.iconUrl = 0x7f020216;
            timagefilterinfo21.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo21);
            addToCataloge("lomo", s);
        }
        s = ((Context) (obj)).getResources().getString(0x7f06023c);
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo22 = new TImageFilterInfo();
            timagefilterinfo22.filterName = s;
            timagefilterinfo22.iconUrl = 0x7f0201fd;
            timagefilterinfo22.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo22);
            addToCataloge("arts", s);
        }
        obj = ((Context) (obj)).getResources().getString(0x7f060159);
        if (!mFilterDict.containsKey(obj))
        {
            TImageFilterInfo timagefilterinfo = new TImageFilterInfo();
            timagefilterinfo.filterName = ((String) (obj));
            timagefilterinfo.iconUrl = 0x7f02020e;
            timagefilterinfo.isAvalable = Boolean.valueOf(true);
            installFilter(timagefilterinfo);
            addToCataloge("arts", ((String) (obj)));
        }
    }

    public void addSmallLayoutPreinstallFilter()
    {
        boolean flag = false;
        Context context = PIPCameraApplication.a;
        ArrayList arraylist = new ArrayList(35);
        arraylist.add(context.getResources().getString(0x7f060181));
        arraylist.add(context.getResources().getString(0x7f060089));
        arraylist.add(context.getResources().getString(0x7f0601a1));
        arraylist.add(context.getResources().getString(0x7f0602af));
        arraylist.add(context.getResources().getString(0x7f060122));
        arraylist.add(context.getResources().getString(0x7f060167));
        arraylist.add(context.getResources().getString(0x7f060122));
        arraylist.add(context.getResources().getString(0x7f06014a));
        arraylist.add(context.getResources().getString(0x7f0602b5));
        arraylist.add(context.getResources().getString(0x7f0600ab));
        arraylist.add(context.getResources().getString(0x7f0600f6));
        arraylist.add(context.getResources().getString(0x7f0600e1));
        arraylist.add(context.getResources().getString(0x7f060121));
        arraylist.add(context.getResources().getString(0x7f060178));
        arraylist.add(context.getResources().getString(0x7f060098));
        arraylist.add(context.getResources().getString(0x7f06023c));
        arraylist.add(context.getResources().getString(0x7f060159));
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s1 = (String)arraylist.get(i);
            if (isExistFilter(s1))
            {
                addToCataloge("default-filter", s1);
            }
        }

        arraylist = new ArrayList(35);
        arraylist.add(context.getResources().getString(0x7f060181));
        arraylist.add(context.getResources().getString(0x7f0601a1));
        arraylist.add(context.getResources().getString(0x7f0602af));
        arraylist.add(context.getResources().getString(0x7f060122));
        arraylist.add(context.getResources().getString(0x7f060167));
        arraylist.add(context.getResources().getString(0x7f060122));
        arraylist.add(context.getResources().getString(0x7f06014a));
        arraylist.add(context.getResources().getString(0x7f0602b5));
        arraylist.add(context.getResources().getString(0x7f0600ab));
        arraylist.add(context.getResources().getString(0x7f0600f6));
        arraylist.add(context.getResources().getString(0x7f0600e1));
        arraylist.add(context.getResources().getString(0x7f060121));
        arraylist.add(context.getResources().getString(0x7f060178));
        arraylist.add(context.getResources().getString(0x7f060098));
        arraylist.add(context.getResources().getString(0x7f06023c));
        arraylist.add(context.getResources().getString(0x7f060159));
        for (int j = ((flag) ? 1 : 0); j < arraylist.size(); j++)
        {
            String s = (String)arraylist.get(j);
            if (isExistFilter(s))
            {
                addToCataloge("comic-filter", s);
            }
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

    public TImageFilterInfo getFilterByName(String s)
    {
        while (s == null || mFilterDict.get(s) == null) 
        {
            return null;
        }
        return (TImageFilterInfo)mFilterDict.get(s);
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

    public boolean isExistFilter(String s)
    {
        return (TImageFilterInfo)mFilterDict.get(s) != null;
    }

    public boolean isFilterRemovable(String s)
    {
        s = (TImageFilterInfo)mFilterDict.get(s);
        if (s != null)
        {
            return ((TImageFilterInfo) (s)).isRemovable.booleanValue();
        } else
        {
            return false;
        }
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
        _network.b(arraylist);
    }
}
