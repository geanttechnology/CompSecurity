// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import bgd;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TPhotoMaskInfo
{

    public String backFilterName;
    public float backScaleFactor;
    public int backgroundColor;
    public RectF backgroundFrame;
    public String backgroundImagePath;
    public String backmaskImagePath;
    public float downsampling;
    public String filterName;
    public String folderName;
    public int foregroundColor;
    public RectF foregroundFrame;
    public String foregroundImagePath;
    public float gaussianBlur;
    public String gaussianFilterName;
    public String grainPath;
    public RectF innerFrame;
    public boolean isBackgroundShadow;
    public boolean isPIP;
    public String maskImagePath;
    public float rangeReductionFactor;
    public EResType resType;
    public float rotation;
    public float saturation;
    public List transforms;

    public TPhotoMaskInfo()
    {
        resType = EResType.ASSET;
        folderName = null;
    }

    public void deleteFromCache()
    {
        if (foregroundImagePath != null && foregroundImagePath.length() > 0)
        {
            FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, foregroundImagePath);
        }
        if (backgroundImagePath != null && backgroundImagePath.length() > 0)
        {
            FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, backgroundImagePath);
        }
        if (maskImagePath != null && maskImagePath.length() > 0)
        {
            FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, maskImagePath);
        }
        if (backmaskImagePath != null && backmaskImagePath.length() > 0)
        {
            FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, backmaskImagePath);
        }
    }

    public Bitmap getBitmapByPath(String s)
    {
        Object obj2 = null;
        if (resType != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = s.substring(s.lastIndexOf("/") + 1);
        obj1 = EOnlineResType.MAG_MASK_INFO;
        if (folderName == null || folderName.length() <= 0) goto _L4; else goto _L3
_L3:
        s = FileManager.getInstance().getInstaMagFileCache().a();
        s = (new StringBuilder()).append(s).append("/").append(folderName).append("/").append(((String) (obj))).toString();
        s = FileManager.getInstance().getBitmapByFilePath(s);
_L6:
        return s;
_L4:
        return FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj1)), s);
_L2:
        obj = InstaBeautyApplication.a().b().getAssets();
        s = ((AssetManager) (obj)).open(s);
        obj = obj2;
        obj1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        obj = BitmapFactory.decodeStream(s);
        obj1 = s;
_L7:
        s = ((String) (obj));
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        }
        if (true) goto _L6; else goto _L5
_L5:
        IOException ioexception;
        ioexception;
        s = null;
_L8:
        ioexception.printStackTrace();
        ioexception = obj2;
        obj1 = s;
          goto _L7
        ioexception;
          goto _L8
    }

    public boolean is3DTransform()
    {
        if (transforms != null && transforms.size() == 5)
        {
            float f = ((Float)transforms.get(2)).floatValue();
            float f1 = ((Float)transforms.get(3)).floatValue();
            float f2 = ((Float)transforms.get(4)).floatValue();
            if (f != 0.0F && f1 != 0.0F && f2 != 0.0F)
            {
                return true;
            }
        }
        return false;
    }
}
