// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import bgm;
import bgq;
import bgv;
import com.google.gson.Gson;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.wantu.imagelib.filter:
//            TImageFilterManager, TImageFilterInfo

public class TLightingFilterManager extends TImageFilterManager
{

    public TLightingFilterManager()
    {
        unarchive();
        _network = new bgq();
        _network.a(this);
    }

    public List AllInfos()
    {
        return getAllItems();
    }

    public void addPreinstallFilter()
    {
        String s = String.format("%d", new Object[] {
            Integer.valueOf(0)
        });
        List list = super.getmKeyOderArray();
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo1 = new TImageFilterInfo();
            timagefilterinfo1.filterName = s;
            timagefilterinfo1.filterVersion = 1;
            timagefilterinfo1.filterIconName = "lightStreamFilter/icon/icon_nolighting.png";
            timagefilterinfo1.isAvalable = Boolean.valueOf(true);
            timagefilterinfo1.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo1);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(1)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo2 = new TImageFilterInfo();
            timagefilterinfo2.filterName = s;
            timagefilterinfo2.filterIconName = "lightStreamFilter/icon/icon_colorr.jpg";
            timagefilterinfo2.isAvalable = Boolean.valueOf(true);
            timagefilterinfo2.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo2);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(2)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo3 = new TImageFilterInfo();
            timagefilterinfo3.filterName = s;
            timagefilterinfo3.filterIconName = "lightStreamFilter/icon/icon_cyborg.jpg";
            timagefilterinfo3.isAvalable = Boolean.valueOf(true);
            timagefilterinfo3.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo3);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(3)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo4 = new TImageFilterInfo();
            timagefilterinfo4.filterName = s;
            timagefilterinfo4.filterIconName = "lightStreamFilter/icon/icon_drop.jpg";
            timagefilterinfo4.isAvalable = Boolean.valueOf(true);
            timagefilterinfo4.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo4);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(4)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo5 = new TImageFilterInfo();
            timagefilterinfo5.filterName = s;
            timagefilterinfo5.filterIconName = "lightStreamFilter/icon/icon_burn.jpg";
            timagefilterinfo5.isAvalable = Boolean.valueOf(true);
            timagefilterinfo5.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo5);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(5)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo6 = new TImageFilterInfo();
            timagefilterinfo6.filterName = s;
            timagefilterinfo6.filterIconName = "lightStreamFilter/icon/icon_sand.jpg";
            timagefilterinfo6.isAvalable = Boolean.valueOf(true);
            timagefilterinfo6.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo6);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(6)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo7 = new TImageFilterInfo();
            timagefilterinfo7.filterName = s;
            timagefilterinfo7.filterIconName = "lightStreamFilter/icon/icon_bocea.jpg";
            timagefilterinfo7.isAvalable = Boolean.valueOf(true);
            timagefilterinfo7.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo7);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(7)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo8 = new TImageFilterInfo();
            timagefilterinfo8.filterName = s;
            timagefilterinfo8.filterIconName = "lightStreamFilter/icon/icon_glitter.jpg";
            timagefilterinfo8.isAvalable = Boolean.valueOf(true);
            timagefilterinfo8.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo8);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(8)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo9 = new TImageFilterInfo();
            timagefilterinfo9.filterName = s;
            timagefilterinfo9.filterIconName = "lightStreamFilter/icon/icon_twinkle.jpg";
            timagefilterinfo9.isAvalable = Boolean.valueOf(true);
            timagefilterinfo9.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo9);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(9)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo10 = new TImageFilterInfo();
            timagefilterinfo10.filterName = s;
            timagefilterinfo10.filterIconName = "lightStreamFilter/icon/icon_vignette.jpg";
            timagefilterinfo10.isAvalable = Boolean.valueOf(true);
            timagefilterinfo10.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo10);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(10)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo11 = new TImageFilterInfo();
            timagefilterinfo11.filterName = s;
            timagefilterinfo11.filterIconName = "lightStreamFilter/icon/icon_rain.jpg";
            timagefilterinfo11.isAvalable = Boolean.valueOf(true);
            timagefilterinfo11.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo11);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(11)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo12 = new TImageFilterInfo();
            timagefilterinfo12.filterName = s;
            timagefilterinfo12.filterIconName = "lightStreamFilter/icon/icon_stop.jpg";
            timagefilterinfo12.isAvalable = Boolean.valueOf(true);
            timagefilterinfo12.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo12);
        }
        s = String.format("%d", new Object[] {
            Integer.valueOf(12)
        });
        if (!list.contains(s))
        {
            list.add(s);
        }
        if (!mFilterDict.containsKey(s))
        {
            TImageFilterInfo timagefilterinfo = new TImageFilterInfo();
            timagefilterinfo.filterName = s;
            timagefilterinfo.filterIconName = "lightStreamFilter/icon/icon_dirt.jpg";
            timagefilterinfo.isAvalable = Boolean.valueOf(true);
            timagefilterinfo.setResType(EResType.ASSET);
            mFilterDict.put(s, timagefilterinfo);
        }
    }

    public void addSmallLayoutPreinstallFilter()
    {
        addPreinstallFilter();
    }

    public void archive()
    {
        if (getmKeyOderArray() != null)
        {
            String s = (new Gson()).toJson(getmKeyOderArray());
            FileManager.getInstance().archiveKeyFilterManger(EOnlineResType.LIGHT_FILTER, s);
        }
        if (mFilterDict != null)
        {
            String s1 = (new Gson()).toJson(mFilterDict);
            FileManager.getInstance().archiveFilterManger(EOnlineResType.LIGHT_FILTER, s1);
        }
    }

    public void deleteInfo(TResInfo tresinfo)
    {
        TImageFilterInfo timagefilterinfo = (TImageFilterInfo)tresinfo;
        if (mFilterDict == null || !mFilterDict.containsKey(tresinfo.name)) goto _L2; else goto _L1
_L1:
        TImageFilterInfo timagefilterinfo1 = (TImageFilterInfo)mFilterDict.get(timagefilterinfo.name);
        if (timagefilterinfo1.getResType() != EResType.NETWORK || !tresinfo.name.equalsIgnoreCase(timagefilterinfo1.name)) goto _L2; else goto _L3
_L3:
        int i = 0;
_L9:
        if (i >= mKeyOderArray.size()) goto _L5; else goto _L4
_L4:
        if (!((String)mKeyOderArray.get(i)).equalsIgnoreCase(timagefilterinfo1.name)) goto _L7; else goto _L6
_L6:
        mKeyOderArray.remove(i);
_L5:
        mFilterDict.remove(timagefilterinfo1.name);
        i = timagefilterinfo.icon.lastIndexOf("/");
        tresinfo = timagefilterinfo.icon.substring(i + 1);
        FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.LIGHT_FILTER, tresinfo);
        i = timagefilterinfo.frameUrl.lastIndexOf("/");
        tresinfo = timagefilterinfo.frameUrl.substring(i + 1);
        Log.v("PIpStyle NetWork frameFileName:", tresinfo);
        FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.LIGHT_FILTER, tresinfo);
        archive();
        tresinfo = new Intent("ACTION_MATERIAL_REMOVE");
        tresinfo.putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.LIGHT_FILTER));
        InstaBeautyApplication.a().b().sendBroadcast(tresinfo);
_L2:
        return;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void filterDownloadFinished(Object obj)
    {
        TImageFilterInfo timagefilterinfo = (TImageFilterInfo)obj;
        timagefilterinfo.setResType(EResType.NETWORK);
        insertFirstFilter(timagefilterinfo);
        super.filterDownloadFinished(obj);
        obj = new Intent("ACTION_MATERIAL_ADDED");
        ((Intent) (obj)).putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.LIGHT_FILTER));
        InstaBeautyApplication.a().b().sendBroadcast(((Intent) (obj)));
    }

    public List getAllItems()
    {
        List list = super.getmKeyOderArray();
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            String s = (String)list.get(i);
            if (mFilterDict.get(s) != null)
            {
                arraylist.add(mFilterDict.get(s));
            }
        }

        return arraylist;
    }

    public TImageFilterInfo imageFilterInfoWithName(String s)
    {
        if (mFilterDict.get(s) != null)
        {
            return (TImageFilterInfo)mFilterDict.get(s);
        } else
        {
            return null;
        }
    }

    public List netMaterials()
    {
        Object obj = getAllItems();
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            TImageFilterInfo timagefilterinfo = (TImageFilterInfo)((Iterator) (obj)).next();
            if (timagefilterinfo.getResType() == EResType.NETWORK)
            {
                arraylist.add(timagefilterinfo);
            }
        } while (true);
        return arraylist;
    }

    public void unarchive()
    {
        Object obj = FileManager.getInstance().unarchiveKeyFilterManger(EOnlineResType.LIGHT_FILTER);
        if (obj != null)
        {
            obj = (String)obj;
            mKeyOderArray = (List)(new Gson()).fromJson(((String) (obj)), (new _cls1()).getType());
            obj = FileManager.getInstance().unarchiveFilterManger(EOnlineResType.LIGHT_FILTER);
            if (obj != null)
            {
                obj = (String)obj;
                Log.v("TLightingFilterManager unarhicve", ((String) (obj)));
                mFilterDict = (Map)(new Gson()).fromJson(((String) (obj)), (new _cls2()).getType());
            }
            return;
        } else
        {
            addPreinstallFilter();
            return;
        }
    }

    public void valifyRes()
    {
    }

    private class _cls1 extends TypeToken
    {

        final TLightingFilterManager this$0;

        _cls1()
        {
            this$0 = TLightingFilterManager.this;
            super();
        }
    }


    private class _cls2 extends TypeToken
    {

        final TLightingFilterManager this$0;

        _cls2()
        {
            this$0 = TLightingFilterManager.this;
            super();
        }
    }

}
