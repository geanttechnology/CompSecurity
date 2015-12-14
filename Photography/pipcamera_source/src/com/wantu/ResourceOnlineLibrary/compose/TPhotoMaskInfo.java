// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
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
    }

    public Bitmap getAssetBitmapByPath(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = PIPCameraApplication.a.getAssets();
        s = ((AssetManager) (obj)).open(s);
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L2:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return ((Bitmap) (obj));
            }
        }
        return ((Bitmap) (obj));
        obj;
        s = null;
_L3:
        ((IOException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        obj = obj1;
        s1 = s;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
          goto _L3
    }

    public Bitmap getBitmapByPath(String s)
    {
        Object obj1 = null;
        if (resType != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        s = s.substring(s.lastIndexOf("/") + 1);
        EOnlineResType eonlinerestype = EOnlineResType.MAG_MASK_INFO;
        s = FileManager.getInstance().getOnlineBitmapRes(eonlinerestype, s);
_L4:
        return s;
_L2:
        Object obj = PIPCameraApplication.a.getAssets();
        s = ((AssetManager) (obj)).open(s);
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L5:
        s = ((String) (obj));
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return ((Bitmap) (obj));
            }
            return ((Bitmap) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
        IOException ioexception;
        ioexception;
        s = null;
_L6:
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
        ioexception = obj1;
        s1 = s;
          goto _L5
        ioexception;
          goto _L6
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
