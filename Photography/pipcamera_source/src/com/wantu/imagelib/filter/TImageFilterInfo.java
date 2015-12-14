// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.List;

public class TImageFilterInfo extends TResInfo
{

    public int BlendMode;
    public ArrayList dependentResources;
    public String filterIconName;
    public String filterName;
    public int filterVersion;
    public String frameIconUrl;
    public String frameUrl;
    public int iconUrl;
    public Boolean isAvalable;
    public Boolean isHide;
    public Boolean isRemovable;
    public float opacity;
    public List processes;

    public TImageFilterInfo()
    {
        opacity = 1.0F;
    }

    public Bitmap getAssetIconBitMap()
    {
        return BitmapFactory.decodeStream(PIPCameraApplication.a.getAssets().open(filterIconName));
    }

    public Bitmap getLiNetworkIconBitmap()
    {
        return null;
    }
}
