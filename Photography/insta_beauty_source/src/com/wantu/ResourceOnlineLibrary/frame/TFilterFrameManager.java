// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.frame;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import bgv;
import bhy;
import bia;
import com.google.gson.Gson;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TFilterFrameManager extends bgv
{

    bia _network;
    private List mFrames;

    public TFilterFrameManager()
    {
        mFrames = new ArrayList();
        unarchive();
        _network = new bia();
        _network.a(this);
    }

    public List AllInfos()
    {
        return allItem();
    }

    public void add(TFrameItemInfo tframeiteminfo)
    {
        mFrames.add(tframeiteminfo);
    }

    public void addFront(TFrameItemInfo tframeiteminfo)
    {
        mFrames.add(1, tframeiteminfo);
    }

    public List allItem()
    {
        if (mFrames.size() == 0)
        {
            preInstall();
        }
        return mFrames;
    }

    public void archive()
    {
        if (mFrames != null && mFrames.size() > 0)
        {
            String s = (new Gson()).toJson(mFrames);
            Log.v("TFrameFilterManager archive:", s);
            FileManager.getInstance().archiveFilterManger(EOnlineResType.FILTER_FRAME, s);
        }
    }

    public void deleteInfo(TResInfo tresinfo)
    {
        Object obj = allItem();
        int i = 0;
        do
        {
label0:
            {
                if (i < ((List) (obj)).size())
                {
                    TFrameItemInfo tframeiteminfo = (TFrameItemInfo)((List) (obj)).get(i);
                    if (tframeiteminfo.getResType() != EResType.NETWORK || !tresinfo.name.equalsIgnoreCase(tframeiteminfo.name))
                    {
                        break label0;
                    }
                    ((List) (obj)).remove(tframeiteminfo);
                    tresinfo = (TFrameItemInfo)tresinfo;
                    i = ((TFrameItemInfo) (tresinfo)).icon.lastIndexOf("/");
                    obj = ((TFrameItemInfo) (tresinfo)).icon.substring(i + 1);
                    FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.FILTER_FRAME, ((String) (obj)));
                    i = ((TFrameItemInfo) (tresinfo)).imageURL.lastIndexOf("/");
                    tresinfo = ((TFrameItemInfo) (tresinfo)).imageURL.substring(i + 1);
                    Log.v("PIpStyle NetWork frameFileName:", tresinfo);
                    FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.FILTER_FRAME, tresinfo);
                    archive();
                    tresinfo = new Intent("ACTION_MATERIAL_REMOVE");
                    tresinfo.putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.FILTER_FRAME));
                    InstaBeautyApplication.a().b().sendBroadcast(tresinfo);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void downloadRes(TResInfo tresinfo)
    {
        if (_network != null)
        {
            _network.a(materialtype);
            _network.b(tresinfo);
        }
    }

    public void filterDownloadFinished(Object obj)
    {
        TFrameItemInfo tframeiteminfo = (TFrameItemInfo)obj;
        tframeiteminfo.setResType(EResType.NETWORK);
        addFront(tframeiteminfo);
        super.filterDownloadFinished(obj);
        obj = new Intent("ACTION_MATERIAL_ADDED");
        ((Intent) (obj)).putExtra("TYPE_MATERIAL", bgv.getStringByResType(EOnlineResType.FILTER_FRAME));
        InstaBeautyApplication.a().b().sendBroadcast(((Intent) (obj)));
    }

    public List netMaterials()
    {
        Object obj = allItem();
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            TFrameItemInfo tframeiteminfo = (TFrameItemInfo)((Iterator) (obj)).next();
            if (tframeiteminfo.getResType() == EResType.NETWORK)
            {
                arraylist.add(tframeiteminfo);
            }
        } while (true);
        return arraylist;
    }

    public void preInstall()
    {
        TFrameItemInfo tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_noboder.png";
        tframeiteminfo.name = "original";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_film.png";
        tframeiteminfo.imageURL = "border/film.png";
        tframeiteminfo.name = "b1";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_lomo_mask.png";
        tframeiteminfo.imageURL = "border/lomo_mask.png";
        tframeiteminfo.name = "b3";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_nashville_mask.png";
        tframeiteminfo.imageURL = "border/nashville_mask.png";
        tframeiteminfo.name = "b4";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_border03.png";
        tframeiteminfo.imageURL = "border/border03.png";
        tframeiteminfo.name = "b5";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_border05.png";
        tframeiteminfo.imageURL = "border/border05.png";
        tframeiteminfo.name = "b6";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_border06.png";
        tframeiteminfo.imageURL = "border/border06.png";
        tframeiteminfo.name = "b7";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_commenmask.png";
        tframeiteminfo.imageURL = "border/commenMask.png";
        tframeiteminfo.name = "b9";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_earlybird_mask.png";
        tframeiteminfo.imageURL = "border/earlybird_mask.png";
        tframeiteminfo.name = "b10";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_jaggies_border";
        tframeiteminfo.imageURL = "border/jaggies-border.png";
        tframeiteminfo.name = "b12";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_border02.png";
        tframeiteminfo.imageURL = "border/border02.png";
        tframeiteminfo.name = "b13";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_pink_style_frame.png";
        tframeiteminfo.imageURL = "border/pink_style_frame.png";
        tframeiteminfo.name = "b14";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_roundframemask.png";
        tframeiteminfo.imageURL = "border/roundframemask.png";
        tframeiteminfo.name = "b15";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_xpro_mask.png";
        tframeiteminfo.imageURL = "border/xpro_mask.png";
        tframeiteminfo.name = "b17";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
        tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.icon = "frameicon/icon_lord_frame.png";
        tframeiteminfo.imageURL = "border/lord_frame.png";
        tframeiteminfo.name = "b18";
        tframeiteminfo.setResType(EResType.ASSET);
        add(tframeiteminfo);
    }

    public void unarchive()
    {
        Object obj = FileManager.getInstance().unarchiveFilterManger(EOnlineResType.FILTER_FRAME);
        if (obj != null)
        {
            obj = (String)obj;
            mFrames = (List)(new Gson()).fromJson(((String) (obj)), (new bhy(this)).getType());
            return;
        } else
        {
            preInstall();
            return;
        }
    }

    public void update()
    {
        if (mFrames.size() > 0)
        {
            ArrayList arraylist = new ArrayList(mFrames.size());
            for (Iterator iterator = mFrames.iterator(); iterator.hasNext(); arraylist.add((TFrameItemInfo)iterator.next())) { }
            _network.a(materialtype);
            _network.b(arraylist);
        }
    }
}
