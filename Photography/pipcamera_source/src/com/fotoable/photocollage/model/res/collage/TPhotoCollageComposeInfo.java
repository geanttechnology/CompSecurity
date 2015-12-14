// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.model.res.collage;

import android.graphics.Point;
import android.graphics.Rect;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TResInfo;
import ew;
import java.util.ArrayList;
import java.util.List;

public class TPhotoCollageComposeInfo extends TResInfo
{

    private float aspectRatio;
    private String backGroundImagePath;
    private int mCurEdge;
    private int mDefaultEdge;
    private List photoFrameArray;
    private float roundRadius;
    private List trackPointsArray;
    private List vectorPointsArray;

    public TPhotoCollageComposeInfo()
    {
        photoFrameArray = new ArrayList();
        trackPointsArray = new ArrayList();
        vectorPointsArray = new ArrayList();
        mDefaultEdge = 0;
        mCurEdge = 0;
        aspectRatio = 1.0F;
    }

    private List getPointsFromRect(Rect rect)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new Point(rect.left, rect.top));
        arraylist.add(new Point(rect.right, rect.top));
        arraylist.add(new Point(rect.right, rect.bottom));
        arraylist.add(new Point(rect.left, rect.bottom));
        return arraylist;
    }

    public float getAspectRatio()
    {
        return aspectRatio;
    }

    public String getBackGroundImagePath()
    {
        return backGroundImagePath;
    }

    public int getCurEdge()
    {
        return mCurEdge;
    }

    public int getDefaultEdge()
    {
        return mDefaultEdge;
    }

    public List getPhotoFrameArray()
    {
        return photoFrameArray;
    }

    public float getRoundRadius()
    {
        return roundRadius;
    }

    public List getTrackPointsArray()
    {
        return trackPointsArray;
    }

    public List getVectorPointsArray()
    {
        return vectorPointsArray;
    }

    public void setAspectRatio(float f)
    {
        aspectRatio = f;
    }

    public void setBackGroundImagePath(String s)
    {
        backGroundImagePath = s;
    }

    public void setCurEdge(int i)
    {
        mCurEdge = i;
    }

    public void setDefaultEdge(int i)
    {
        mDefaultEdge = ew.a(PIPCameraApplication.a, i);
    }

    public void setPhotoFrameArray(List list)
    {
        photoFrameArray = list;
        if (trackPointsArray.size() <= 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                trackPointsArray.add(getPointsFromRect((Rect)list.get(i)));
            }

        }
    }

    public void setRoundRadius(float f)
    {
        roundRadius = f;
    }

    public void setTrackPointsArray(List list)
    {
        trackPointsArray = list;
    }

    public void setVectorPointsArray(List list)
    {
        vectorPointsArray = list;
    }
}
