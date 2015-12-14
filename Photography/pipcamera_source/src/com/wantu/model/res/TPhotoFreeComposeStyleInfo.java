// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import com.pipcamera.application.PIPCameraApplication;
import java.util.ArrayList;

// Referenced classes of package com.wantu.model.res:
//            TResInfo, EResType

public class TPhotoFreeComposeStyleInfo extends TResInfo
{

    public int backgroundBorderColor;
    public float backgroundBorderWidth;
    public int backgroundColor;
    public String backgroundImageURL;
    public int borderColor;
    public float borderWidth;
    public ArrayList decoratorArray;
    public ArrayList dependencesRes;
    public Boolean isAvailable;
    public Boolean isHideShadow;
    public Boolean isNeedSign;
    public Boolean isTiledBgImage;
    public RectF margin;
    public int photoBackgroundColor;
    public String photoFrameImageURL;
    public float roundRadius;
    public int uid;
    public int version;

    public TPhotoFreeComposeStyleInfo()
    {
    }

    public Bitmap getImageBitmap()
    {
        Object obj = null;
        if (resType == EResType.ASSET)
        {
            obj = BitmapFactory.decodeStream(PIPCameraApplication.a.getAssets().open(backgroundImageURL));
        }
        if (resType == EResType.RES)
        {
            obj = PIPCameraApplication.a;
            int i = Integer.parseInt(backgroundImageURL);
            obj = BitmapFactory.decodeResource(((Context) (obj)).getResources(), i);
        }
        return ((Bitmap) (obj));
    }
}
