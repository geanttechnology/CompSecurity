// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res.pip;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.model.res.EResProcessType;
import com.wantu.model.res.EResType;
import com.wantu.model.res.FilterType;
import com.wantu.model.res.TResInfo;
import com.wantu.piprender.ESceneMode;

public class TDFSceneInfo extends TResInfo
{

    public String alphaTexturePath;
    public FilterType filterType;
    public String framePath;
    public Rect frameRect;
    public ESceneMode mode;
    public Point sceneSize;

    public TDFSceneInfo()
    {
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, EResType erestype, EResProcessType eresprocesstype, String s2, Point point, Rect rect, String s3, 
            ESceneMode escenemode)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setResType(erestype);
        tdfsceneinfo.setFramePath(s2);
        tdfsceneinfo.setSceneSize(point);
        tdfsceneinfo.setFrameRect(rect);
        tdfsceneinfo.setResProcessType(eresprocesstype);
        tdfsceneinfo.setAlphaTexturePath(s3);
        tdfsceneinfo.mode = escenemode;
        return tdfsceneinfo;
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, ESceneMode escenemode, EResType erestype)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setMode(escenemode);
        tdfsceneinfo.setResType(erestype);
        return tdfsceneinfo;
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, String s2, Point point, Rect rect, String s3, FilterType filtertype)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setFramePath(s2);
        tdfsceneinfo.setSceneSize(point);
        tdfsceneinfo.setFrameRect(rect);
        tdfsceneinfo.setAlphaTexturePath(s3);
        tdfsceneinfo.setFilterType(filtertype);
        return tdfsceneinfo;
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, String s2, Point point, Rect rect, String s3, ESceneMode escenemode, FilterType filtertype)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setFramePath(s2);
        tdfsceneinfo.setSceneSize(point);
        tdfsceneinfo.setFrameRect(rect);
        tdfsceneinfo.setAlphaTexturePath(s3);
        tdfsceneinfo.setMode(escenemode);
        tdfsceneinfo.setFilterType(filtertype);
        return tdfsceneinfo;
    }

    public String getAlphaTexturePath()
    {
        return alphaTexturePath;
    }

    public FilterType getFilterType()
    {
        return filterType;
    }

    public Bitmap getFrameBitmap()
    {
        Object obj = null;
        Bitmap bitmap = obj;
        if (getResType() == EResType.ASSET)
        {
            bitmap = obj;
            if (framePath != null)
            {
                bitmap = BitmapFactory.decodeStream(InstaBeautyApplication.a().getApplicationContext().getAssets().open(getIcon()));
            }
        }
        return bitmap;
    }

    public String getFramePath()
    {
        return framePath;
    }

    public Rect getFrameRect()
    {
        return frameRect;
    }

    public ESceneMode getMode()
    {
        if (mode == null)
        {
            return ESceneMode.SCENE_MODE1;
        } else
        {
            return mode;
        }
    }

    public Point getSceneSize()
    {
        return sceneSize;
    }

    public void setAlphaTexturePath(String s)
    {
        alphaTexturePath = s;
    }

    public void setFilterType(FilterType filtertype)
    {
        filterType = filtertype;
    }

    public void setFramePath(String s)
    {
        framePath = s;
    }

    public void setFrameRect(Rect rect)
    {
        frameRect = rect;
    }

    public void setMode(ESceneMode escenemode)
    {
        mode = escenemode;
    }

    public void setSceneSize(Point point)
    {
        sceneSize = point;
    }
}
