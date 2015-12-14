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

public class TDecorateInfo
{

    public float backgroundAlpha;
    public int backgroundColor;
    public RectF bubbleTextFrame;
    public boolean editable;
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

    public boolean isBubbleText()
    {
        return type == 19;
    }

    public boolean isLocation()
    {
        return type == 5 || type == 10 || type == 9 || type == 14;
    }

    public boolean isText()
    {
        return type != 1 && type != 7 && type != 15 && type != 16 && type != 17 && type != 14 && type != 19;
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
