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

public class TDecorateInfo
{

    public float backgroundAlpha;
    public int backgroundColor;
    public RectF bubbleTextFrame;
    public String dynamicGifPath;
    public boolean editable;
    public String folderName;
    public String fontFamily;
    public int fontMaxCount;
    public int fontSize;
    public RectF frame;
    public String imagePath;
    public boolean isBold;
    public boolean isFlipH;
    public boolean isFlipV;
    public boolean isItalic;
    public boolean isOutline;
    public boolean isShadow;
    public int letterSpace;
    public int lines;
    public boolean movable;
    public EResType resType;
    public float rotation;
    public float scale;
    public String text;
    public int textAlignment;
    public int textColor;
    public int type;

    public TDecorateInfo()
    {
        resType = EResType.ASSET;
    }

    public void deleteFromCache()
    {
        if (imagePath != null && imagePath.length() > 0)
        {
            FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, imagePath);
        }
    }

    public Bitmap getBitmapByPath(String s)
    {
        Object obj1 = null;
        if (resType != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        Object obj;
        s = s.substring(s.lastIndexOf("/") + 1);
        obj = EOnlineResType.MAG_MASK_INFO;
        if (folderName == null || folderName.length() <= 0) goto _L4; else goto _L3
_L3:
        obj = FileManager.getInstance().getInstaMagFileCache().a();
        s = (new StringBuilder()).append(((String) (obj))).append("/").append(folderName).append("/").append(s).toString();
        s = FileManager.getInstance().getBitmapByFilePath(s);
_L6:
        return s;
_L4:
        return FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj)), s);
_L2:
        obj = InstaBeautyApplication.a().getAssets();
        s = ((AssetManager) (obj)).open(s);
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L7:
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
        ioexception = obj1;
        s1 = s;
          goto _L7
        ioexception;
          goto _L8
    }

    public boolean isLocation()
    {
        return type == 5 || type == 10 || type == 9 || type == 14;
    }

    public boolean isText()
    {
        return type != 1 && type != 7 && type != 15 && type != 16 && type != 17 && type != 14;
    }

    public boolean isTime()
    {
        return type == 12 || type == 6 || type == 11 || type == 4 || type == 8 || type == 13;
    }

    public boolean isWeather()
    {
        return type == 7 || type == 15 || type == 16 || type == 17;
    }
}
